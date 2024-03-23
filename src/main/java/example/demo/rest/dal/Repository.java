package example.demo.rest.dal;

public interface Repository<T,I> {  //T for entity and I for the primary key
    
    T create(T entity);
    T auth(T entity);
    T find (I index);
    void delete(T entity);
    void update(T entity);
    //<T> findAll();

}