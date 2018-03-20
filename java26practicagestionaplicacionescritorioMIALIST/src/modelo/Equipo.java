package modelo;

public class Equipo {
	
	private String nombre;
	private String nombrequipo;
	private String fecha;
	private boolean legendario;
	private String pok1;
	private String pok2;
	private String pok3;
	private int id;

	

	public Equipo() {
		// TODO Auto-generated constructor stub
		
	}//end cliente
	
	public Equipo(String nombre, String nombrequipo, String fecha, boolean legendario, String pok1, String pok2 , String pok3 ) {
		super();
		this.nombre = nombre;
		this.nombrequipo = nombrequipo;
		this.fecha = fecha;
		this.legendario = legendario;
		this.pok1 = pok1;
		this.pok2 = pok2;
		this.pok3 = pok3;

	}

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombrequipo() {
		return nombrequipo;
	}

	public void setNombrequipo(String nombrequipo) {
		this.nombrequipo = nombrequipo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public boolean isLegendario() {
		if (legendario == true) {
			String Legendariostr = String.valueOf(legendario);
			Legendariostr = "Yes";
		}else {
			String Legendariostr = String.valueOf(legendario);
			Legendariostr = "No";
		}

		return legendario;
	}

	public void setLegendario(boolean legendario) {
		this.legendario = legendario;
	}

	public String getPok1() {
		return pok1;
	}

	public void setPok1(String pok1) {
		this.pok1 = pok1;
	}

	public String getPok2() {
		return pok2;
	}

	public void setPok2(String pok2) {
		this.pok2 = pok2;
	}

	public String getPok3() {
		return pok3;
	}

	public void setPok3(String pok3) {
		this.pok3 = pok3;
	}

	@Override
	public String toString() {
		return "Equipo [nombre=" + nombre + ", nombrequipo=" + nombrequipo + ", fecha=" + fecha + ", legendario="
				+ legendario + ", pok1=" + pok1 + ", pok2=" + pok2 + ", pok3=" + pok3 + "]";
	}
	


	
	


	
	
}
