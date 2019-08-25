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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flood.mark.themediaempire.service.BlogEntryService;
import com.flood.mark.themediaempire.service.model.BlogEntry;

/**
 * @author Mark Flood
 * @since 2019
 */
@Controller
@RequestMapping("/blog")
public class BlogController extends BaseController {

	private static final String BLOG_LIST_ATTRIBUTE = "blogs";

	private final BlogEntryService blogEntryService;

	public BlogController(BlogEntryService blogEntryService) {
		this.blogEntryService = blogEntryService;
	}

	@GetMapping
	public String list(Model model) {
		model.addAttribute(BLOG_LIST_ATTRIBUTE,
				blogEntryService.listEntries(DEFAULT_PAGE, DEFAULT_PAGE_SIZE).getContent());
		return "blog-list";
	}

	@GetMapping("/create")
	public String create() {
		return "blog-create";
	}

	@PostMapping("/create")
	public String createSubmission(@ModelAttribute BlogEntry blogEntry) {
		blogEntryService.save(blogEntry);
		return redirect("/blog");
	}

	@GetMapping("/{id}/read")
	public String read(@PathVariable int id) {
		return "blog-read";
	}

}
