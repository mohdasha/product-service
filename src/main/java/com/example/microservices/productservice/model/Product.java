package com.example.microservices.productservice.model;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.Value;
import lombok.val;


@Document
@Getter
@Setter
@NoArgsConstructor
public class Product {
	
	@Id private String id;
	private String brand;
	private String category;
	private String currency;
	private List<String> feature;
	private String genre;
	private String label;	
	private List<Metadata> metadata;
	private Image images;
	
	@Getter
	@Setter
	@ToString
	@NoArgsConstructor
	public class Metadata {
		private String key;
		private Object value;
	}
	@Getter
	@Setter
	@ToString
	public class Image {
		private Object large;
		private Object medium;
		private Object small;
	}
}
