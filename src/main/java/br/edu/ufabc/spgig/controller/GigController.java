/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufabc.spgig.controller;

/**
 *
 * @author isaac
 */

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.ufabc.spgig.model.Gig;
import br.edu.ufabc.spgig.repository.GigRepository;
import br.edu.ufabc.spgig.model.Busca;

@RestController
public class GigController {
    
    @Autowired
    private GigRepository repository;
    
    @RequestMapping(value="/api/gig/{id}", method=RequestMethod.GET, produces="application/json")
    public @ResponseBody Gig listOne(@PathVariable("id") String id) {
        Gig obj = repository.findOne(Long.parseLong(id));
        return obj;
    }
    
    @RequestMapping(value="/api/gig", method=RequestMethod.GET, produces="application/json")
    public @ResponseBody Iterable<Gig> findAll() {
        return repository.findAll();
    }
    
    @RequestMapping(value="/api/gig", method=RequestMethod.POST, consumes="application/json")
    public @ResponseBody String insert(@RequestBody Gig obj) {
        repository.save(obj);
        return "{\"msg\": \"success\"}";
    }
    
    @RequestMapping(value="/api/gig/{id}", method=RequestMethod.DELETE)
    public @ResponseBody String delete(@PathVariable("id") String id) {
        Gig obj = repository.findOne(Long.parseLong(id));
        repository.delete(obj);
        return "{\"msg\": \"success\"}";
    }
    
    @RequestMapping(value="/api/gig/busca", method=RequestMethod.GET, consumes="application/json")
    public @ResponseBody Iterable<Gig> busca(@RequestBody Busca busca) {
        
        if (busca.getCidade() == null) {
            Iterable<Gig> obj = repository.findByTipo(busca.getTipo());
            return obj;
        } else {
            Iterable<Gig> obj = repository.findByCidade(busca.getTipo(), busca.getCidade());
            return obj;
        }
        
    }
    
}
