package com.sabel.lastrest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Importer {
	private Service service;
	private Ressource ressource;
	
	public Importer() throws IOException {

		service = new Service();
		ressource = new Ressource();
	}
	
	public void importCSV() throws IOException{
		File file = new File("E:\\Programme\\jee-neon\\workspace\\LastRest\\personen.csv");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String zeile="";
		while ((zeile=br.readLine())!=null) {
			Person person = new Person();
			String[] split = zeile.split(";");
			person.setName(split[0]);
			person.setVorname(split[1]);
			person.setAge(Integer.parseInt(split[2]));
			service.addPerson(person);
//			ressource.newPerson(split[0], split[1], Integer.parseInt(split[2]));

		}
	}
	
	public static void main(String[] args) throws IOException {
		Importer importer = new Importer();
		importer.importCSV();
		
	}
}
