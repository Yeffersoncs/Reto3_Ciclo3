package Reto_3_ciclo_3.Reto_3_ciclo_3.repositorio;

import Reto_3_ciclo_3.Reto_3_ciclo_3.interfas.interfaceCategory;
import Reto_3_ciclo_3.Reto_3_ciclo_3.modelo.Category;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioCategoria {
    
    @Autowired
    private interfaceCategory crud;
    
    public List<Category> getAll(){
        return (List<Category>) crud.findAll();
    }
    public Optional <Category> getCategoria(int id){
        return crud.findById(id);
    }
    
    public Category save(Category category){
        return crud.save(category);
    }
    
        public void delete(Category Category){
	    crud.delete(Category);
	}
 
        
        
}