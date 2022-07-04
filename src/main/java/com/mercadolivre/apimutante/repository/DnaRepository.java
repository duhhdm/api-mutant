package com.mercadolivre.apimutante.repository;

import com.mercadolivre.apimutante.entity.DnaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedNativeQueries;
import java.lang.annotation.Native;
import java.util.List;

@Repository
public interface DnaRepository extends JpaRepository<DnaEntity, Integer> {

}
