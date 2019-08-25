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

/**
 * @author Mark Flood
 * @since 2019
 */
public abstract class BaseController {

	protected static final int DEFAULT_PAGE = 0;
	protected static final int DEFAULT_PAGE_SIZE = 20;

	/**
	 * Method to redirect a user to another URL. Used primarily to prevent extra
	 * submissions on navigation.
	 * 
	 * @param url the URL to redirect to
	 * @return a {@link String} which will redirect the user to the specified URL
	 */
	protected String redirect(String url) {
		return "redirect:" + url;
	}

}
