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

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flood.mark.themediaempire.repository.BlogEntryRepository;
import com.flood.mark.themediaempire.repository.model.BlogEntryEntity;
import com.flood.mark.themediaempire.service.exception.NotFoundExceptionSupplier;
import com.flood.mark.themediaempire.service.model.BlogEntry;
import com.flood.mark.themediaempire.service.model.conversion.BlogEntryConverter;

/**
 * @author Mark Flood
 * @since 2019
 */
@Service
public class BlogEntryService {

	private final BlogEntryRepository blogEntryRepository;
	private final BlogEntryConverter blogEntryConverter;

	public BlogEntryService(BlogEntryRepository blogEntryRepository, BlogEntryConverter blogEntryConverter) {
		this.blogEntryRepository = blogEntryRepository;
		this.blogEntryConverter = blogEntryConverter;
	}

	@Transactional(readOnly = true)
	public PageResult<BlogEntry> listEntries(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Order.desc(BlogEntryEntity.CREATED_ON_FIELD)));
		return PageResult.of(blogEntryRepository.findAll(pageable).map(entry -> blogEntryConverter.convert(entry)));
	}

	/**
	 * @param blogEntry
	 */
	@Transactional
	public void save(BlogEntry blogEntry) {
		BlogEntryEntity entity = null;
		if (blogEntry.isNew()) {
			entity = new BlogEntryEntity();
		} else {
			entity = blogEntryRepository.findById(blogEntry.getId()).orElseThrow(
					new NotFoundExceptionSupplier("Could not find blog entry with id: [{1}]", blogEntry.getId()));
		}
		blogEntryConverter.update(blogEntry, entity);
		blogEntryRepository.save(entity);
	}

}
