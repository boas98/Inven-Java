/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pika.inventory.service;

import com.pika.inventory.domain.Barang;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author revze
 */
public interface BarangDao extends PagingAndSortingRepository<Barang, String>{
    
}
