package hrmanager.models;


import hrmanager.helpers.UUIDWrapper;

import java.util.UUID;

public abstract class SimpleEntity
{
	protected UUIDWrapper id;
	protected UUIDWrapper parentId;

	public SimpleEntity(){
		id = new UUIDWrapper(UUID.randomUUID());
	}

	public UUIDWrapper getId(){
		return id;
	}
	
	public void setId(UUIDWrapper UUIDWrapper){
		this.id = UUIDWrapper;
	}

	public UUIDWrapper getParentId(){
		return parentId;
	};
	
	public void setParentId(UUIDWrapper parentId){
		this.parentId = parentId;
	}
}
