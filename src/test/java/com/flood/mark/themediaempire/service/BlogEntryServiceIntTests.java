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

import static org.assertj.core.api.Assertions.assertThat;

import javax.validation.ConstraintViolationException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.flood.mark.themediaempire.service.exception.NotFoundException;
import com.flood.mark.themediaempire.service.model.BlogEntry;

/**
 * Integration Tests for the {@link BlogEntryService}
 * 
 * @author Mark Flood
 * @since 2019
 */
public class BlogEntryServiceIntTests extends BaseServiceIntTests {

	// Class Under Test
	@Autowired
	private BlogEntryService service;

	// Useful common data
	private BlogEntry blogEntry;

	@Before
	public void setUp() {
		blogEntry = new BlogEntry();
		blogEntry.setSubject("Subject");
		blogEntry.setContent("Content");
	}

	@Test
	public void saveBlogEntryShouldInsertNewEntryWhenEntryIsNull() {
		blogEntry = service.save(blogEntry);

		assertThat(blogEntry.getId()).isGreaterThan(0);
	}

	@Test
	public void saveBlogEntryShouldUpdateExistingEntry() {
		blogEntry = service.save(blogEntry);
		blogEntry.setContent("Updated Content");
		blogEntry.setSubject("Updated Subject");

		service.save(blogEntry);
		BlogEntry savedBlogEntry = service.read(blogEntry.getId());

		assertThat(savedBlogEntry.getContent()).isEqualTo("Updated Content");
		assertThat(savedBlogEntry.getSubject()).isEqualTo("Updated Subject");
	}

	@Test(expected = NotFoundException.class)
	public void saveBlogEntryShouldThrowExceptionWhenAttemptingToUpdateEntryWhichDoesNotExist() {
		blogEntry.setId(1);

		service.save(blogEntry);
	}

	@Test(expected = ConstraintViolationException.class)
	public void saveBlogEntryWithEmptyContentShouldFail() {
		blogEntry.setContent("");

		service.save(blogEntry);
	}

	@Test(expected = ConstraintViolationException.class)
	public void saveBlogEntryWithEmptySubjectShouldFail() {
		blogEntry.setSubject(null);

		service.save(blogEntry);
	}
}
