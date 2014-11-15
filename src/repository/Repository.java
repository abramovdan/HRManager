package repository;

import java.util.Collection;

public interface Repository<T> {
	Collection<T> entities();
	void create(T entity);
	void update(T entity);
	void delete(T entity);
}
