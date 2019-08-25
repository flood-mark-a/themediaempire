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
package com.flood.mark.themediaempire.service.model.conversion;

import org.springframework.stereotype.Component;

import com.flood.mark.themediaempire.repository.model.BlogEntryEntity;
import com.flood.mark.themediaempire.service.model.BlogEntry;

/**
 * @author Mark Flood
 * @since 2019
 */
@Component
public class BlogEntryConverter implements EntityConverter<BlogEntryEntity, BlogEntry> {

	@Override
	public BlogEntry convert(BlogEntryEntity entity) {
		BlogEntry model = new BlogEntry();
		model.setContent(entity.getContent());
		model.setSubject(entity.getSubject());
		model.setCreatedOn(entity.getCreatedOn());
		model.setModifiedOn(entity.getModifiedOn());
		model.setId(entity.getId());
		return model;
	}

	@Override
	public void update(BlogEntry model, BlogEntryEntity entity) {
		entity.setContent(model.getContent());
		entity.setSubject(model.getSubject());
	}

}
