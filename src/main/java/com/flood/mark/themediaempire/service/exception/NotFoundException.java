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
package com.flood.mark.themediaempire.service.exception;

import java.text.MessageFormat;

/**
 * @author Mark Flood
 * @since 2019
 */
public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * @param exceptionMessage
	 * @param args
	 */
	public NotFoundException(String exceptionMessage, Object[] args) {
		super(MessageFormat.format(exceptionMessage, args));
	}

}
