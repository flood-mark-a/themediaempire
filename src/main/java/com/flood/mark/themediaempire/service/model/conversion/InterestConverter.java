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

import com.flood.mark.themediaempire.repository.model.InterestEntity;
import com.flood.mark.themediaempire.service.model.Interest;

/**
 * @author Mark Flood
 * @since 2019
 */
@Component
public class InterestConverter implements EntityConverter<InterestEntity, Interest> {

	@Override
	public Interest convert(InterestEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Interest model, InterestEntity entity) {
		// TODO Auto-generated method stub

	}

}
