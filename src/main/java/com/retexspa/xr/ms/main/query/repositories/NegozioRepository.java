package com.retexspa.xr.ms.main.query.repositories;

import java.util.Optional;

import com.retexspa.xr.ms.main.query.entities.NegozioQueryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface NegozioRepository
    extends JpaRepository<NegozioQueryEntity, String>,
        JpaSpecificationExecutor<NegozioQueryEntity> {
            public Optional<NegozioQueryEntity> findByGerarchiaId(String gerarchiaId);

        }
