package GestorDeTareas;

import java.util.Objects;

public class Tareas {

	private String nomTarea = "";
	private Prioridad prioridad;
	private boolean estado = false;

	public Tareas(String nomTarea, Prioridad prioridad, boolean estado) {
		super();
		this.nomTarea = nomTarea;
		this.prioridad = prioridad;
		this.estado = estado;
	}
	
	public Tareas(String nomTarea, Prioridad prioridad) {
		super();
		this.nomTarea = nomTarea;
		this.prioridad = prioridad;
	}
	
	public void marcarCompletada () {
		this.estado = true;
	}

	public String getNomTarea() {
		return nomTarea;
	}
	
	public Prioridad getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(Prioridad prioridad) {
		this.prioridad = prioridad;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public void setNomTarea(String nomTarea) {
		this.nomTarea = nomTarea;
	}

	
	@Override
	public String toString() {
		return "[nomTarea=" + nomTarea + ", prioridad=" + prioridad + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(estado, nomTarea, prioridad);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tareas other = (Tareas) obj;
		return estado == other.estado && Objects.equals(nomTarea, other.nomTarea)
				&& Objects.equals(prioridad, other.prioridad);
	}
	
	
	
}
