package jsonrepository.repository;

import hrmanager.models.SimpleEntity;

import java.io.*;
import java.util.*;

import jsonrepository.annotations.JsonDAO;

import org.apache.commons.io.*;

import net.sf.json.*;
import net.sf.json.util.PropertyFilter;

public class JsonRepository<T extends JsonRepositoryObject> implements Repository<T> {

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
		JSON jsonObject = entity.toJSON();
		try{
			FileUtils.writeStringToFile(file, jsonObject.toString());
		   }catch(Exception ex){
			   ex.printStackTrace();
		   }
	}

	@Override
	public void delete(T entity) {
		getEntityFile(entity).delete();
	}
	
	

	@Override
	public Collection<T> findByParent(UUID parentUUID) {
		// TODO Auto-generated method stub
		return null;
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
}
