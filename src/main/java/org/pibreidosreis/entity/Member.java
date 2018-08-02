package org.pibreidosreis.entity;

import java.time.LocalDate;

import javax.persistence.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Member extends AbstractEntity{

	private String name;
	private LocalDate dateOfBirth;
	private String phone;
}
