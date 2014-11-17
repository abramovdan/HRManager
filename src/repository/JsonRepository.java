package repository;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.util.Collection;

import org.apache.commons.io.FileUtils;

import models.SimpleEntity;
import net.sf.json.JSON;
import annotations.JsonDAO;

public class JsonRepository<T extends SimpleEntity&JsonSerializable<T>> implements Repository<T> {

	public static final String defaultDir = "json_default_dir";
	
	@Override
	public Collection<T> entities() {
		T t = null;
		String path = getPath(t.getClass());
		
		
		return null;
		
	}

	@Override
	public void create(T entity) {
		Class cl = entity.getClass();
		String path = getPath(cl);
		File dir = new File(path);
		if (!dir.exists()){
			dir.mkdir();
		}
		JSON jsonObject = entity.toJSON();
		File file = new File(path + "/" + cl.getSimpleName() + "_" + entity.getId() + ".json");
		try{
			FileUtils.writeStringToFile(file, jsonObject.toString());
		   }catch(Exception ex){
			   ex.printStackTrace();
		   }
	}

	@Override
	public void update(T entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub
		
	}
	
	private String getPath(Class<?> cl){
		if (!cl.isAnnotationPresent(JsonDAO.class)){
			return defaultDir;
		}
		return cl.getAnnotation(JsonDAO.class).path();
	}
}
