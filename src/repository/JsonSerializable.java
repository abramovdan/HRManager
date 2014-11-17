package repository;

import java.util.Collection;
import java.util.UUID;

import net.sf.json.JSON;

public interface JsonSerializable<T> {
	JSON toJSON();
	Collection<T> findByParent (UUID parentUUID);
}
