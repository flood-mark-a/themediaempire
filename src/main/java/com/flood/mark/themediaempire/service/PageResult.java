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

import java.util.List;

import org.springframework.data.domain.Page;

/**
 * Simple abstraction over spring data class for use in our internal APIs.
 * 
 * @author Mark Flood
 * @since 2019
 */
public class PageResult<T> {

	private List<T> content;

	/**
	 * Create a new page result
	 * 
	 * @param page
	 */
	private PageResult(Page<T> page) {
		content = page.getContent();
	}

	/**
	 * Get the items in the page
	 * 
	 * @return The items in the page
	 */
	public List<T> getContent() {
		return content;
	}

	/**
	 * @param page the page to convert to our internal representation
	 * 
	 * @return a representation of the page
	 */
	public static <V> PageResult<V> of(Page<V> page) {
		return new PageResult<V>(page);
	}

}
