package com.example.prabha.itemserver.dao;

import com.example.prabha.itemserver.entity.ItemEntitys;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepo extends JpaRepository<ItemEntitys,String> {
}
