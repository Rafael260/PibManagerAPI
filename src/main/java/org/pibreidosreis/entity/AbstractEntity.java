package org.pibreidosreis.entity;

import java.time.LocalDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Getter
@Setter
@MappedSuperclass
public class AbstractEntity {

	@Id
	@GeneratedValue
	protected Long id;

	@CreationTimestamp
	protected LocalDateTime createdAt;

	@UpdateTimestamp
	protected LocalDateTime updatedAt;
}
