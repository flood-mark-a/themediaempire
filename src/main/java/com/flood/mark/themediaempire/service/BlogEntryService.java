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

import com.flood.mark.themediaempire.model.BlogEntry;
import com.flood.mark.themediaempire.repository.BlogEntryRepository;

/**
 * @author Mark Flood
 * @since 2019
 */
@Service
public class BlogEntryService {

	private final BlogEntryRepository blogEntryRepository;

	public BlogEntryService(BlogEntryRepository blogEntryRepository) {
		this.blogEntryRepository = blogEntryRepository;
	}

	public PageResult<BlogEntry> listEntries(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Order.desc(BlogEntry.CREATED_ON_FIELD)));
		return PageResult.of(blogEntryRepository.findAll(pageable));
	}

}
