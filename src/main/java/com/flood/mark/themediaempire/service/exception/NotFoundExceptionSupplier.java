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

import java.util.function.Supplier;

/**
 * @author Mark Flood
 * @since 2019
 */
public class NotFoundExceptionSupplier implements Supplier<NotFoundException> {

	private final String exceptionMessage;
	private final Object[] args;

	public NotFoundExceptionSupplier(String exceptionMessage, Object... args) {
		this.exceptionMessage = exceptionMessage;
		this.args = args;
	}

	@Override
	public NotFoundException get() {
		return new NotFoundException(exceptionMessage, args);
	}

}
