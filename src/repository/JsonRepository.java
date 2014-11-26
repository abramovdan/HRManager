package repository;

import hrmanager.models.SimpleEntity;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

import org.apache.commons.io.*;

import repository.annotations.JsonDAO;
import repository.annotations.JsonDependent;
import net.sf.json.*;
import net.sf.json.util.PropertyFilter;

public class JsonRepository<T extends SimpleEntity> implements Repository<T> {

	public static final String JSON_CONTAINER_DIR = "json_dir";
	private Class<T> entityClass;
	private JsonConfig jsonConfig; 
		
	public JsonRepository(Class<T> entityClass) {
		this.entityClass = entityClass;
		initJsonConfig();
	}

	@Override
	public Collection<T> entities() {
		List<T> entities = new ArrayList<T>();
		File dir = new File(JSON_CONTAINER_DIR + File.separator + getEntityDirPath());
		if (!dir.exists()) return entities;
		
		for (File f : FileUtils.listFiles(dir, new String[] {"json"}, false)) {
			String json;
			try {
				json = FileUtils.readFileToString(f);
				JSONObject jsonObject = JSONObject.fromObject(json);
				T entity = (T) JSONObject.toBean( jsonObject, jsonConfig); 
				entity.setId(UUID.fromString(FilenameUtils.removeExtension(f.getName())));
				entities.add(entity);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
		return entities;
	}

	@Override
	public void create(T entity) {
		update(entity);
	}

	@Override
	public void update(T entity) {
		File file = getEntityFile(entity);
		JSON jsonObject = toJSON(entity);
		try{
			FileUtils.writeStringToFile(file, jsonObject.toString());
		   }catch(Exception ex){
			   ex.printStackTrace();
		   }
	}

	@Override
	public void delete(T entity) {
		if (entityClass.isAnnotationPresent(JsonDependent.class)){
			Class[] classes = entityClass.getAnnotation(JsonDependent.class).value();
			for (Class cl : classes) {
				Repository<SimpleEntity> repository = new JsonRepository<SimpleEntity>(cl);
				Collection<SimpleEntity> itemsToDelete = repository.findByParent(entity.getId());
				for (SimpleEntity itemToDelete : itemsToDelete) {
					repository.delete(itemToDelete);
				}
			}
		}
		File file = getEntityFile(entity);
		if (file.exists()) {
			file.delete();
		}
	}
	
	@Override
	public Collection<T> findByParent(UUID parentUUID) {
		Collection<T> result = new ArrayList<T>();
		for (T entity : entities()) {
			if (parentUUID.equals(entity.getParentId())){
				result.add(entity);
			}
		}
		return result;
	}
	
	private File getEntityFile(T entity) {
		String path = getEntityDirPath();
		File file = new File(JSON_CONTAINER_DIR + File.separator + path + File.separator + entity.getId() + ".json");
		File dir = file.getParentFile();
		if (!dir.exists()){
			dir.mkdirs();
		}
		return file;
	}
	
	private String getEntityDirPath(){
		if (!entityClass.isAnnotationPresent(JsonDAO.class)){
			return entityClass.getSimpleName();
		}
		return entityClass.getAnnotation(JsonDAO.class).path();
	}
	
	private void initJsonConfig() {
		jsonConfig= new JsonConfig();
		jsonConfig.setRootClass( entityClass );  
		jsonConfig.setJavaPropertyFilter( new PropertyFilter(){  
		   public boolean apply( Object source, String name, Object value ) {  
		      if( "id".equals( name )){  
		         return true;  
		      }  
		      return false;  
		   }  
		}); 
	}
	
	private JSON toJSON(T entity) {
		return JSONObject.fromObject(entity);
	}
}
