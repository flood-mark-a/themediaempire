/**
 * Copyright 2019 Mark Flood

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */
package com.flood.mark.themediaempire.service;

import java.util.function.Supplier;

import javax.validation.Valid;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.transaction.annotation.Transactional;

import com.flood.mark.themediaempire.repository.MediaEmpireRepository;
import com.flood.mark.themediaempire.repository.model.AbstractEntity;
import com.flood.mark.themediaempire.service.exception.NotFoundExceptionSupplier;
import com.flood.mark.themediaempire.service.model.AbstractModel;
import com.flood.mark.themediaempire.service.model.conversion.EntityConverter;

/**
 * @author Mark Flood
 * @since 2019
 */
public abstract class AbstractCrudService<T extends AbstractModel, V extends AbstractEntity>
		implements MediaEmpireCrudService<T> {

	private final MediaEmpireRepository<V> repository;
	private final EntityConverter<V, T> converter;
	private final String entityName;
	private final Supplier<V> entitySupplier;

	public AbstractCrudService(MediaEmpireRepository<V> repository, EntityConverter<V, T> converter, String entityName,
			Supplier<V> entitySupplier) {
		this.repository = repository;
		this.converter = converter;
		this.entityName = entityName;
		this.entitySupplier = entitySupplier;
	}

	@Override
	@Transactional(readOnly = true)
	public PageResult<T> listEntries(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Order.desc(AbstractEntity.CREATED_ON_FIELD)));
		return PageResult.of(repository.findAll(pageable).map(entry -> converter.convert(entry)));
	}

	/**
	 * @param model
	 */
	@Override
	@Transactional
	public T save(@Valid T model) {
		V entity = null;
		if (model.isNew()) {
			entity = entitySupplier.get();
		} else {
			entity = repository.findById(model.getId()).orElseThrow(
					new NotFoundExceptionSupplier("Could not find {1} with id: [{2}]", entityName, model.getId()));
		}
		converter.update(model, entity);
		return converter.convert(repository.save(entity));
	}

	/**
	 * Read a single entity
	 * 
	 * @param id
	 * @return
	 */
	@Override
	@Transactional(readOnly = true)
	public T read(int id) {
		return converter.convert(repository.findById(id)
				.orElseThrow(new NotFoundExceptionSupplier("Could not find {1} with id: [{2]", entityName, id)));
	}
}
