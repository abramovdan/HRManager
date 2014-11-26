package hrmanager.models;

import java.util.UUID;


public abstract class SimpleEntity
{
	protected UUID id;
	protected UUID parentId;

	public SimpleEntity(){
		id = UUID.randomUUID();
	}

	public UUID getId(){
		return id;
	}
	
	public void setId(UUID uuid){
		this.id = uuid; 
	}

	public UUID getParentId(){
		return parentId;
	};
	
	public void setParentId(UUID parentIt){
		this.parentId = parentId;
	}
}
