package org.pibreidosreis.repository;

import org.pibreidosreis.entity.AbstractEntity;
import org.springframework.data.repository.CrudRepository;


public interface AbstractRepository<E extends AbstractEntity> extends CrudRepository<E, Long> {

}
