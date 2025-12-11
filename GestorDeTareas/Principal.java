package GestorDeTareas;

import java.util.*;

public class Principal {
	
	static Scanner sc = new Scanner (System.in);
	
	System.out.println("Prueba commit.");

	public static void main(String[] args) {
		Gestor gestor = new Gestor();	
		int opcion = -1;
		
		System.out.println("Voy a hacer un commit");
		
		while (opcion != 8) {
			System.out.println("----------------");
			System.out.println("GESTOR DE TAREAS");
			System.out.println("----------------");
			System.out.println("1. Añadir tarea.");
			System.out.println("2. Eliminar tarea");
			System.out.println("3. Buscar tarea.");
			System.out.println("4. Listar tareas.");
			System.out.println("5. Listar tareas por estado");
			System.out.println("6. Listar estado por prioridad.");
			System.out.println("7. Marcar tarea completada.");
			System.out.println("8. Cerrar gestor de tareas.");
			System.out.println("Introduce la opción:");
			opcion = sc.nextInt();
			sc.nextLine();
			
			switch (opcion) {
				case 1: {
					System.out.println("Elejiste la opción de crear una nueva tarea:");
					System.out.println("Nombre de la tarea:");
					String tarea = sc.nextLine();
					System.out.println("Prioridad de la tarea (alta/media/baja):");
					String prioridad = sc.nextLine();
					
					Tareas tarea1 = new Tareas(tarea, Prioridad.valueOf(prioridad));
					gestor.añadirTarea(tarea1);
					break;
				}
				case 2: {
					System.out.println("Elejiste la opción de eliminar una tarea:");
					System.out.println("Introduce la tarea a eliminar:");
					String tarea = sc.nextLine();
					
					gestor.eliminarTarea(tarea);
					break;
				}
				case 3: {
					System.out.println("Introduce el nombre de la tarea a buscar:");
                    String tarea = sc.nextLine();
                    gestor.buscarTarea(tarea);
					break;
				}
				case 4: {
					System.out.println("Elejiste la opción de listar las tareas:");
					gestor.listarTodas();
					break;
				}
				case 5: {
					System.out.println("Elejiste la opción de listar las tareas según su estado:");
					gestor.listarEstado();
					break;
				}
				
				case 6: {
					System.out.println("Elejiste la opción de listar las tareas por prioridad:");
				    gestor.listarPorPrioridad();
					break;
				}
				
				case 7: {
					System.out.println("Elejiste la opción de marcar una tarea completada:");
					System.out.println("Introduce la tarea completada:");
					String tarea = sc.nextLine();
					gestor.marcarCompletada(tarea);
					break;
				}
			
				default: {
					System.out.println("Opción no válida.");
					break;
				}
			}
		}
	}

}
