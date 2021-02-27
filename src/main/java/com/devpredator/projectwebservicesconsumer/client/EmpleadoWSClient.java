/**
 * 
 */
package com.devpredator.projectwebservicesconsumer.client;

import java.time.LocalDateTime;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

import com.devpredator.projectwebservicesconsumer.dto.EmpleadoDTO;

/**
 * @author c-ado Clase cliente que permite consumir los webservices de empleado
 */
public class EmpleadoWSClient {
	public static void main(String[] args) {
//::::::::::::::::GET::::::::::::::::::::::::::

		 
//		Client client = ClientBuilder.newClient();
//		WebTarget webTarget = client.target("http://localhost:8080/project-webservices/devpredator/empleadosWS").path("consultarEmpleadoId").path("789");
//		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
//		Response response = invocationBuilder.get();
//		
//		if (response.getStatus()==204) {
//			System.out.println("No se encontraron coincidencias");
//		}
//		
//		if (response.getStatus()==200) {
//			EmpleadoDTO employee = response.readEntity(EmpleadoDTO.class);
//			System.out.println("Nombre del empleado :"+employee.getNombre());
//			System.out.println("Fecha de creacion :"+employee.getFechaCreacion());
//		}
//		

		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target("http://localhost:8080/project-webservices/devpredator/empleadosWS").path("guardarEmpleado");
		
		EmpleadoDTO empleado = new EmpleadoDTO ();
		empleado.setNombre("Carlos");
		empleado.setEdad(21);
        empleado.setNumeroEmpleado("789");
		empleado.setFechaCreacion(LocalDateTime.now());
		empleado.setPrimerApellido("Orbe");
		empleado.setSegundoApellido("Intriago");
		
		
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.post(Entity.entity(empleado,MediaType.APPLICATION_JSON));
		
		if (response.getStatus()==400) {
		String error = response.readEntity(String.class);
		System.out.println(error);
		}
		
		if (response.getStatus()==200) {
			EmpleadoDTO employee = response.readEntity(EmpleadoDTO.class);
			System.out.println("Nombre del empleado :"+employee.getNombre());
			System.out.println("Fecha de creacion :"+employee.getFechaCreacion());
		}
		
	}
}
