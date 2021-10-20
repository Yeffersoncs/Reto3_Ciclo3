/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto_3_ciclo_3.Reto_3_ciclo_3.servicio;

import Reto_3_ciclo_3.Reto_3_ciclo_3.modelo.Reservation;
import Reto_3_ciclo_3.Reto_3_ciclo_3.repositorio.RepositorioReservation;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class serviciosReservation {
    
     @Autowired
    private RepositorioReservation metodosCrud;
    public List<Reservation> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<Reservation> getReservation(int idReservation){
        return metodosCrud.getReservation(idReservation);
    }
    public Reservation save(Reservation reservation){
        if(reservation.getIdReservation()==null){
            return metodosCrud.save(reservation);
        }else{
            Optional<Reservation> paux=metodosCrud.getReservation(reservation.getIdReservation());
            if(paux.isEmpty()){
            return metodosCrud.save(reservation);
            }else{
                return reservation;
            }
        }
    }
    
    public Reservation update(Reservation reservation){
	        if(reservation.getIdReservation()!=null){
                        Optional<Reservation> e= metodosCrud.getReservation(reservation.getIdReservation());
	            if(!e.isEmpty()){
	                if(reservation.getStartDate()!=null){
	                    e.get().setStartDate(reservation.getStartDate());
	                }
                        if(reservation.getDevolutionDate()!=null){
	                    e.get().setDevolutionDate(reservation.getDevolutionDate());
	                }
                        if(reservation.getStatus()!=null){
	                    e.get().setStatus(reservation.getStatus());
	                }
                        
	                metodosCrud.save(e.get());
                        return e.get();
                    }else{
                    return reservation;
                    }
                }else{
                    return reservation;
                }
    }
                    
                
    public boolean deleteReservation(int reservationId){
        
         Boolean aBoolean = getReservation(reservationId).map(reservation-> { 
             metodosCrud.delete(reservation);
             return (true);
                 }).orElse(false);
            return aBoolean;
         
        }  
    
}
