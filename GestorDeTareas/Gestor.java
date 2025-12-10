package GestorDeTareas;

import java.util.*;

public class Gestor {
	
	Scanner sc = new Scanner (System.in);
	
	ArrayList<Tareas> lista = new ArrayList<>();

	public void añadirTarea (Tareas tarea) {
		lista.add(tarea);
		System.out.println("Se añadio la tarea " + tarea + ".");
	}
	
	public void eliminarTarea (String nomTarea) {
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getNomTarea().equals(nomTarea)) {
				System.out.println("¿Deseas eliminar la tarea " + nomTarea + "? (S/N)");
				char respuesta = sc.next().charAt(0);
				
				if (respuesta == 'S' || respuesta == 's') {
					lista.remove(i);
					System.out.println("Se ha eliminado la tarea " + nomTarea + ".");
				} else if (respuesta == 'N' || respuesta == 'n') {
					System.out.println("No se ha eliminado ninguna tarea.");
				}
			} else {
				System.out.println("Esa tarea no existe.");
			}
		} 
	}
	
	public void buscarTarea(String nomTarea) {
	    for (Tareas t : lista) {
	        if (t.getNomTarea().equalsIgnoreCase(nomTarea)) {
	            System.out.println("Tarea encontrada: " + t);
	            return;
	        }
	    }
	    System.out.println("Tarea no encontrada.");
	}
	
	public void listarEstado() {
	    System.out.println("TAREAS COMPLETADAS:");
	    for (Tareas t : lista) {
	        if (t.isEstado())
	            System.out.println(t);
	    }

	    System.out.println("\nTAREAS PENDIENTES:");
	    for (Tareas tarea : lista) {
	        if (!tarea.isEstado())
	            System.out.println(tarea);
	    }
	}
	
	public void listarTodas () {
		if (lista.isEmpty()) {
			System.out.println("La lista esta vacia.");
			return;
		}
		
		System.out.println("TAREAS:");
		for (Tareas tarea : lista) {
			System.out.println(tarea.toString());
		}
	}
	
	public void listarPorPrioridad() {
	    System.out.println("TAREAS POR PRIORIDAD:");
	    
	    // Agrupar por prioridad
	    Map<Prioridad, List<Tareas>> tareasPorPrioridad = new HashMap<>();
	    for (Tareas tarea : lista) {
	        tareasPorPrioridad.computeIfAbsent(tarea.getPrioridad(), k -> new ArrayList<>()).add(tarea);
	    }
	    
	    // Imprimir las tareas agrupadas por prioridad
	    for (Prioridad prioridad : Prioridad.values()) {
	        System.out.println("\n" + prioridad.toString().toUpperCase() + ":");
	        if (tareasPorPrioridad.containsKey(prioridad)) {
	            for (Tareas tarea : tareasPorPrioridad.get(prioridad)) {
	                System.out.println(tarea);
	            }
	        } else {
	            System.out.println("No hay tareas de esta prioridad.");
	        }
	    }
	}
	
	public void marcarCompletada(String nomTarea) {
	    for (Tareas t : lista) {
	        if (t.getNomTarea().equalsIgnoreCase(nomTarea)) {
	            t.marcarCompletada();
	            System.out.println("Tarea marcada como completada.");
	            return;
	        }
	    }
	    System.out.println("Tarea no encontrada.");
	}
	
}
