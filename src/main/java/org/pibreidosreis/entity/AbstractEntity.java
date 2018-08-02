package org.pibreidosreis.entity;

import java.time.LocalDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@Data
@MappedSuperclass
public class AbstractEntity {

	@Id
	@GeneratedValue
	protected Long id;
	
	protected LocalDateTime createdAt;
	
	protected LocalDateTime updatedAt;
}
