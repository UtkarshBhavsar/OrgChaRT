package com.mob.orgchart.api.jpa;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public class OnRampJpaRepositoryImpl<T, ID extends Serializable> 
extends SimpleJpaRepository<T, ID> implements OnRampJpaRepository<T, ID> {

    private final EntityManager entityManager;
    private final Class<T> domainClass;

    public OnRampJpaRepositoryImpl(final Class<T> domainClass, final EntityManager entityManager) {
        super(domainClass, entityManager);
        this.entityManager = entityManager;
        this.domainClass = domainClass;
    }

    @Override
    public T getReference(final ID id) {
        return entityManager.getReference(domainClass, id);
    }

}
