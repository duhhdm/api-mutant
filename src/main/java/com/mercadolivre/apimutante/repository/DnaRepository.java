package com.mercadolivre.apimutante.repository;

import com.mercadolivre.apimutante.entity.DnaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DnaRepository extends JpaRepository<DnaEntity, Integer> {
}
