package com.eb.na.data_modulo_generator;

import com.eb.na.data_modulo_generator.generator.DataModelGenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DataModuloGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataModuloGeneratorApplication.class, args);

		DataModelGenerator dataModelGenerator = new DataModelGenerator();

		System.out.println(dataModelGenerator.fetchDataStream());
	}

}
