/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufabc.spgig.repository;

/**
 *
 * @author isaac
 */

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import br.edu.ufabc.spgig.model.Gig;

public interface GigRepository extends CrudRepository<Gig, Long> {
    
    Iterable<Gig> findByTipo(String tipo);
    
    @Query("select g from Gig g where g.tipo = :tipo and g.cidade = :cidade")
    Iterable<Gig> findByCidade(@Param("tipo") String tipo, @Param("cidade") String cidade);
    
}
