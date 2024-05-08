package com.retexspa.xr.ms.main.query.repositories;

import com.retexspa.xr.ms.main.query.entities.GerarchiaQueryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface GerarchiaRepository
    extends JpaRepository<GerarchiaQueryEntity, String>,
        JpaSpecificationExecutor<GerarchiaQueryEntity> {}
