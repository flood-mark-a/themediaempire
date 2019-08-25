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

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.flood.mark.themediaempire.service.MediaEmpireCrudService;
import com.flood.mark.themediaempire.service.model.AbstractModel;

/**
 * @author Mark Flood
 * @since 2019
 */
public class MediaEmpireCrudController<V extends AbstractModel> extends BaseController {

	private final String modelName;
	private final String listAttribute;

	private final MediaEmpireCrudService<V> service;

	public MediaEmpireCrudController(String modelName, String listAttribute, MediaEmpireCrudService<V> service) {
		this.modelName = modelName;
		this.listAttribute = listAttribute;
		this.service = service;
	}

	@GetMapping
	public String list(Model model) {
		model.addAttribute(listAttribute, service.listEntries(DEFAULT_PAGE, DEFAULT_PAGE_SIZE).getContent());
		return modelName + "-list";
	}

	@GetMapping("/create")
	public String create() {
		return modelName + "-create";
	}

	@PostMapping("/create")
	public String createSubmission(@ModelAttribute V model) {
		service.save(model);
		return redirect("/" + modelName);
	}

	@GetMapping("/{id}/read")
	public String read(@PathVariable int id) {
		return modelName + "-read";
	}

}
