package Reto_3_ciclo_3.Reto_3_ciclo_3.repositorio;

import Reto_3_ciclo_3.Reto_3_ciclo_3.interfas.interfaceReservation;
import Reto_3_ciclo_3.Reto_3_ciclo_3.modelo.Reservation;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioReservation {
    
    @Autowired
    private interfaceReservation crud;
    
     public List<Reservation> getAll(){
        return (List<Reservation>)crud.findAll();
    }
    public Optional<Reservation> getReservation (int id){
       return crud.findById(id);
    }
    public Reservation save(Reservation reservation){
        return crud.save(reservation);
    }
    public void delete(Reservation reservation){
	        crud.delete(reservation);
	    }
}
