package jsonrepository.repository;

import java.util.Collection;
import java.util.UUID;

public interface Repository<T> {
	Collection<T> entities();
	void create(T entity);
	void update(T entity);
	void delete(T entity);
	Collection<T> findByParent(UUID parentUUID);
}
