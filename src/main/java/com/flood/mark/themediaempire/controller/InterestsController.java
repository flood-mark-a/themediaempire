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
package com.flood.mark.themediaempire.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flood.mark.themediaempire.service.InterestsService;
import com.flood.mark.themediaempire.service.model.Interest;

/**
 * @author Mark Flood
 * @since 2019
 */
@Controller
@RequestMapping("/interests")
public class InterestsController extends MediaEmpireCrudController<Interest> {

	private static final String MODEL_NAME = "interests";
	private static final String LIST_ATTRIBUTE = "interests";

	public InterestsController(InterestsService service) {
		super(MODEL_NAME, LIST_ATTRIBUTE, service);
	}

}
