package jsonrepository.repository;

import java.util.UUID;

import net.sf.json.JSON;

public interface JsonRepositoryObject {
	UUID getId();
	void setId(UUID uuid);
	UUID getParentId();
	JSON toJSON();
}
