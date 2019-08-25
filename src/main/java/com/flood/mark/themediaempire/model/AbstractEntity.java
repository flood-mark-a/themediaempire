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
package com.flood.mark.themediaempire.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 * @author Mark Flood
 * @since 2019
 */
@MappedSuperclass
public class AbstractEntity {

	public static final String CREATED_ON_FIELD = "createdOn";
	public static final String MODIFIED_ON_FIELD = "modifiedOn";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id = -1;

	@Column(nullable = false, updatable = false)
	private LocalDateTime createdOn;

	@Column(nullable = false)
	private LocalDateTime modifiedOn;

	@PrePersist
	public void initializeAuditFields() {
		createdOn = LocalDateTime.now();
		modifiedOn = LocalDateTime.now();
	}

	@PreUpdate
	public void updateAuditFields() {
		modifiedOn = LocalDateTime.now();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public LocalDateTime getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(LocalDateTime modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public boolean isNew() {
		return id < 0;
	}

}
