package rickmortyapi;

import java.util.Map;

public class Main {
	
	/*
	 * ACTIVIDAD DE REPASO N° 1
		Desarrollar un programa que se conecte a la siguiente API: 
		https://rickandmortyapi.com/api/character
		E informar lo siguiente:
		- Name
		- Gender
		- Origin
		Crear una columna que se llame Pais
		Si el origen es "Earth (C-137)" Entonces "Tierra (C-137)"
		"unknown" Entonces "Desconocido"
		"Abadango" Entonces "Malaga"
		Ademas el programa debe implementar pruebas unitarias probando la conexion a la API.
		
		Entregables:
		- Codigo del proyecto.
	 * 
	 * */

	public static void main(String[] args) {

		
		for(Map<String, String> resultado : ApiRepo.useApi()) {
			
			System.out.println(resultado);
		}

	}

}
