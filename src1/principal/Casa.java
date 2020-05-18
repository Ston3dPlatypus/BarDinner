package principal;

import java.util.ArrayList;
import java.util.Iterator;

public class Casa {
	private ArrayList<Habitacion> lista;
	private static Casa listahab;
	
	private Casa() {
		this.lista=new ArrayList<Habitacion>();
	}
	
	public static Casa getCasa() {
		if(Casa.listahab==null) {
			Casa.listahab= new Casa();
		}
		return Casa.listahab;
	}
	private Iterator<Habitacion> getIterator(){
		return this.lista.iterator();
	}
	public int getNumHabitaciones() {
		return this.lista.size();
	}
	public Habitacion buscarHabitacionPorID(int id)
	{
		Iterator<Habitacion> itr = this.getIterator();
		boolean es = false;
		Habitacion habitacion = null;
		while (itr.hasNext() && !es) {
			habitacion = itr.next();
			if (habitacion.getIDHabitacion() == id)
			{
				es = true;
			}
		}
		if (es)
		{
			return habitacion;
		}
		else
		{
			System.out.println("Error. La habitacion que busca no existe.");
			return null;
		}
	}
	private int elegirAlAzarNumHabitaciones() {
		return (int)(Math.random()*5)+5;
	}
	private void crearResidentes()
	{
		ListaResidentes listaResidentes = ListaResidentes.getListaResidentes();
		int numResidentes = (int)(Math.random()*3)+3;
		Residente residente;
		while (numResidentes != 0)
		{
			residente = new Residente((int)(Math.random()*this.getNumHabitaciones()-1)+1);
			listaResidentes.nuevoResidente(residente);
		}
	}
	public void crearCasa()
	{
		int numHabitaciones = this.elegirAlAzarNumHabitaciones();
		int habitacionElegida;
		while (numHabitaciones != 0) {
			habitacionElegida = (int)(Math.random()*3)+1;
			switch (habitacionElegida) {
			case (1):
				Cocina cocina = new Cocina();
				this.lista.add(cocina);
			break;
			case (2):
				Cuarto cuarto = new Cuarto();
				this.lista.add(cuarto);
			break;
			case (3):
				Banio banio = new Banio();
				this.lista.add(banio);
			break;
			}
			numHabitaciones = numHabitaciones -1;
		}
		this.crearResidentes();
	}
	public void comprobarSiHaPerdido()
	{
		ListaResidentes.getListaResidentes().haPerdido();
	}
	public void moverResidentes()
	{
		ListaResidentes listaResidentes = ListaResidentes.getListaResidentes();
		listaResidentes.moverResidentes(this.getNumHabitaciones());
	}
}
