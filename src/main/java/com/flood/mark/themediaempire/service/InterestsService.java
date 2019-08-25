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

import javax.validation.groups.Default;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.flood.mark.themediaempire.repository.MediaEmpireRepository;
import com.flood.mark.themediaempire.repository.model.InterestEntity;
import com.flood.mark.themediaempire.service.model.Interest;
import com.flood.mark.themediaempire.service.model.conversion.EntityConverter;

/**
 * @author Mark Flood
 * @since 2019
 */
@Service
@Validated(value = Default.class)
public class InterestsService extends AbstractCrudService<Interest, InterestEntity>
		implements MediaEmpireCrudService<Interest> {

	private static final String ENTITY_NAME = "Interest";

	/**
	 * @param repository
	 * @param converter
	 * @param entityName
	 * @param entitySupplier
	 */
	public InterestsService(MediaEmpireRepository<InterestEntity> repository,
			EntityConverter<InterestEntity, Interest> converter) {
		super(repository, converter, ENTITY_NAME, new Supplier<InterestEntity>() {

			@Override
			public InterestEntity get() {
				return new InterestEntity();
			}

		});
	}

}
