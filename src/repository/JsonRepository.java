package repository;

import hrmanager.helpers.UUIDWrapper;
import hrmanager.models.SimpleEntity;

import java.io.*;
import java.util.*;

import org.apache.commons.io.*;

import repository.annotations.*;
import net.sf.json.*;

public class JsonRepository<T extends SimpleEntity> implements Repository<T> {

	public static final String JSON_CONTAINER_DIR = "json_dir";
	private Class<T> entityClass;
		
	public JsonRepository(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	@Override
	public Collection<T> entities() {
		List<T> entities = new ArrayList<T>();
		File dir = new File(JSON_CONTAINER_DIR + File.separator + getEntityDirPath());
		if (!dir.exists()) return entities;

		Map classMap = new HashMap();
		classMap.put("[\\w]*[iI]d", UUIDWrapper.class);
		for (File f : FileUtils.listFiles(dir, new String[] {"json"}, false)) {
			String json;
			try {
				json = FileUtils.readFileToString(f);
				JSONObject jsonObject = JSONObject.fromObject(json);
				T entity = (T) JSONObject.toBean(jsonObject, entityClass, classMap);
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
		File file = getEntityFile(entity);
		if (file.exists()) {
			file.delete();
		}
		Class[] classes = getEntityDependentClasses();
		for (Class cl : classes) {
			Repository<SimpleEntity> repository = new JsonRepository<SimpleEntity>(cl);
			Collection<SimpleEntity> itemsToDelete = repository.findByParent(entity.getId());
			for (SimpleEntity itemToDelete : itemsToDelete) {
				repository.delete(itemToDelete);
			}
		}
	}

	@Override
	public Collection<T> findByParent(UUIDWrapper parentUUID) {
		Collection<T> result = new ArrayList<T>();
		for (T entity : entities()) {
			if (parentUUID.equals(entity.getParentId())){
				result.add(entity);
			}
		}
		return result;
	}
	
	private Class[] getEntityDependentClasses() {
		if (entityClass.isAnnotationPresent(JsonDependent.class)){
			return entityClass.getAnnotation(JsonDependent.class).value();
		}
		return new Class[] {};
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
	
	private JSON toJSON(T entity) {
		return JSONObject.fromObject(entity);
	}
}
