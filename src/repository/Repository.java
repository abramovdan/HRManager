package repository;

import hrmanager.helpers.UUIDWrapper;

import java.util.Collection;

public interface Repository<T> {
	Collection<T> entities();
	void create(T entity);
	void update(T entity);
	void delete(T entity);
	Collection<T> findByParent(UUIDWrapper parentUUID);
}
