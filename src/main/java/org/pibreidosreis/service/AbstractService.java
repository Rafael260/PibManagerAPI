package org.pibreidosreis.service;

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
	
	public <D> List<D> findAll(Class<D> type) {
		List<E> list = findAll();
		return MapperUtils.mapAll(list, type);
	}

	public E findById(Long id) {
		return this.repository.findById(id).orElseThrow(ResourceNotFoundException::new);
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
		if(!this.repository.existsById(entityObject.getId())) {
			throw new ResourceNotFoundException();
		}
		onBeforeUpdate(entityObject);
		entityObject = this.repository.save(entityObject);
		onAfterUpdate(entityObject);
		return entityObject;
	}

	public void delete(E entityObject) {
		onBeforeDelete(entityObject);
		this.repository.delete(entityObject);
		onAfterDelete(entityObject);
	}

	public void deleteById(Long id) {
		E entityToDelete = findById(id);
		delete(entityToDelete);
	}

	// Metodos de ciclo de vida, para serem sobrescritos caso necessite
	public void onBeforeInsert(E entityToPersist) {

	}

	public void onAfterInsert(E entityPersisted) {

	}

	public void onBeforeUpdate(E entityToUpdate) {

	}

	public void onAfterUpdate(E entityUpdated) {

	}

	public void onBeforeDelete(E entityToDelete) {

	}

	public void onAfterDelete(E entityDeleted) {

	}
}
