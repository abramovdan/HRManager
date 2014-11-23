package hrmanager.models;

import java.util.UUID;

import net.sf.json.JSON;
import net.sf.json.JSONObject;

import jsonrepository.repository.JsonRepositoryObject;


public abstract class SimpleEntity implements JsonRepositoryObject
{
	protected UUID id;

	public SimpleEntity(){
		id = UUID.randomUUID();
	}

	public UUID getId(){
		return id;
	}
	
	public void setId(UUID uuid){
		this.id = uuid; 
	}

	@Override
	public JSON toJSON() {
		return JSONObject.fromObject(this);
	}
}
