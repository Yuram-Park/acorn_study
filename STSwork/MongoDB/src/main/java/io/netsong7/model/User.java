package io.netsong7.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="users")
public class User {
	@Id
	private String id;
	private String name;
	private int age;
}
