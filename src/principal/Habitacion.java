package principal;

public abstract class Habitacion {
	
	//atributos
	
	private int idHabitacion;
	private ListaResidentes listaR;
	//private int metrosCuadrados;
	private int botinTotal;
	
	//constructora
	
	public Habitacion()
	{
		this.idHabitacion = this.asignarIDHabitacion();
		//this.metrosCuadrados = this.asignarMetrosCuadrados();
		this.botinTotal = this.asignarBotinTotal();
		
	}
	
	//metodos
	
	//protected abstract int asignarMetrosCuadrados();
	
	protected abstract int asignarBotinTotal();
	
	/*public int getMetrosCuadrados()
	{
		return this.metrosCuadrados;
	}
	*/
	public int getBotinTotal()
	{
		return this.botinTotal;
	}
	
	private int asignarIDHabitacion() {
		Casa c = Casa.getCasa();
		return c.getNumHabitaciones();
	}
	
	public int getIDHabitacion()
	{
		return this.idHabitacion;
	}
	public void anadirResidente(Residente pResidente)
	{
		this.listaR.nuevoResidente(pResidente);
	}
	public void moverResidentes()
	{
		
	}
	public boolean haPerdido()
	{
		return this.listaR.haPerdido();
	}
	
}
