//Data Access Object
package dao;

import java.util.List;

//interface CRUD generica
//<T> generics
public interface Dao<T> {
	
	boolean inserir(T tipo);
	
	boolean atualizar();
	
	boolean buscar(long id);
	
	List<T> listar();
	
	boolean apagar(long id);
}
