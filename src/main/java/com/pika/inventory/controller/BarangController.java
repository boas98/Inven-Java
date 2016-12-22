/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pika.inventory.controller;

import com.pika.inventory.domain.Barang;
import com.pika.inventory.service.BarangDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author beethoven
 */
@RestController
@RequestMapping("/api/barang")
public class BarangController {
    @Autowired
    private BarangDao barangDao;
    
    @RequestMapping(value="/{id}",method=RequestMethod.GET)
    public Barang findBarangById(@PathVariable String id)
    {
        return barangDao.findOne(id);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public void save(@RequestBody Barang barang)
    {
        barangDao.save(barang);
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public Page<Barang> findAll(Pageable pageable)
    {
        return barangDao.findAll(pageable);
    }
    
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable String id)
    {
        Barang barang = barangDao.findOne(id);
        if (barang!=null) {
            barangDao.delete(barang);
        }
    }
    
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public void edit(@PathVariable String id, @RequestBody Barang c)
    {
        Barang barang = barangDao.findOne(id);
        if (barang!=null) {
            c.setId(id);
            barangDao.save(c);
        }
    }
}
