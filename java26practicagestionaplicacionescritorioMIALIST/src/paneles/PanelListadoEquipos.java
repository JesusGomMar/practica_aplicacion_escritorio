package paneles;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import modelo.Equipo;
import daos.EquipoDAOImpl;
import tablemodels.TableModelEquipo;

public class PanelListadoEquipos extends JPanel{

	private EquipoDAOImpl daoClientes = new EquipoDAOImpl();
	private Equipo[] equipos;
	
	public PanelListadoEquipos() {
		// TODO Auto-generated constructor stub
		this.add(new JLabel("Soy el panel de listado de cliente"));
	}
	
	public void refrescarEquipo (){
		this.equipos = daoClientes.obtenerEquipo();
		for (Equipo e : equipos) {
			System.out.println(e.toString());
		}
		JTable tabla = new JTable (new TableModelEquipo(equipos));
		tabla.setPreferredScrollableViewportSize(new Dimension(500, 70));
		tabla.setFillsViewportHeight(true);
	    JScrollPane scrollPane = new JScrollPane(tabla);
		this.removeAll();//quito todo lo te tuviera antes dentro del panel
		this.add(scrollPane);

		
	}

}
