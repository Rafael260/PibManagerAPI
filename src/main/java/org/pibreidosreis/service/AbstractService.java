package org.pibreidosreis.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.pibreidosreis.entity.AbstractEntity;
import org.pibreidosreis.exception.ResourceNotFoundException;
import org.pibreidosreis.repository.AbstractRepository;
import org.pibreidosreis.util.mapper.MapperUtils;

public abstract class AbstractService<E extends AbstractEntity> {

	protected AbstractRepository<E> repository;

	public AbstractService(AbstractRepository<E> repository) {
		this.repository = repository;
	}

	public List<E> findAll() {
		List<E> list = new ArrayList<>();
		this.repository.findAll().iterator().forEachRemaining(list::add);
		return list;
	}
	
	public <D> List<D> findAll(Class<D> type){
		List<E> list = findAll();
		return MapperUtils.mapAll(list, type);
	}

	public E findById(Long id) {
		return this.repository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
	}
	
	public <D> D findById(Long id, Class<D> type) {
		E entity = findById(id);
		return MapperUtils.map(entity, type);
	}

	public E insert(E entityObject) {
		onBeforeInsert(entityObject);
		entityObject = this.repository.save(entityObject);
		onAfterInsert(entityObject);
		return entityObject;
	}

	public E update(E entityObject) {
		onBeforeUpdate(entityObject);
		entityObject = this.repository.save(entityObject);
		onAfterUpdate(entityObject);
		return entityObject;
	}

	//TODO retornar algum feedback sobre a operação
	public void delete(E entityObject) {
		onBeforeDelete(entityObject);
		this.repository.delete(entityObject);
		onAfterDelete(entityObject);
	}

	// Metodos de ciclo de vida, para serem sobrescritos caso necessite
	public void onBeforeInsert(E entityToPersist) {
		entityToPersist.setCreatedAt(LocalDateTime.now());
		entityToPersist.setUpdatedAt(LocalDateTime.now());
	}

	public void onAfterInsert(E entityPersisted) {

	}

	public void onBeforeUpdate(E entityToUpdate) {
		entityToUpdate.setUpdatedAt(LocalDateTime.now());
	}

	public void onAfterUpdate(E entityUpdated) {

	}

	public void onBeforeDelete(E entityToDelete) {

	}

	public void onAfterDelete(E entityDeleted) {

	}
}
