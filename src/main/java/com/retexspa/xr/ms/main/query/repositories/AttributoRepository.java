package com.retexspa.xr.ms.main.query.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.retexspa.xr.ms.main.query.entities.AttributoQueryEntity;

public interface AttributoRepository
    extends JpaRepository<AttributoQueryEntity, String>,
        JpaSpecificationExecutor<AttributoQueryEntity> {}
