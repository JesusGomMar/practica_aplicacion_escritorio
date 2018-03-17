package paneles;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

import modelo.Equipo;
import daos.EquipoDAOImpl;
import tablemodels.TableModelEquipo;

public class PanelListadoEquipos extends JPanel implements ActionListener{

	private EquipoDAOImpl daoEquipo = new EquipoDAOImpl();
	private Equipo[] equipos;
	private JTable tabla;
	JButton botonBorrar = new JButton("BORRAR");
	
	public PanelListadoEquipos() {
		// TODO Auto-generated constructor stub
		this.add(new JLabel("Soy el panel de listado de cliente"));
	}
	
	public void refrescarEquipo (){
		this.equipos = daoEquipo.obtenerEquipo();
		
//		for (Equipo e : equipos) {
//			System.out.println(e.toString());
//		}
		tabla = new JTable (new TableModelEquipo(equipos));
		tabla.setPreferredScrollableViewportSize(new Dimension(500, 300));
		tabla.setFillsViewportHeight(true);
		// para solo poder seleccionar una fila
		tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    JScrollPane scrollPane = new JScrollPane(tabla);
		this.removeAll();//quito todo lo te tuviera antes dentro del panel
		this.add(botonBorrar);
		this.add(scrollPane);
		
		// voy a atender al boton borrar desde la instancia de esta clase
		botonBorrar.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// por si no se selecciona una fila como si pulso el boton repetidas veces
		if (tabla.getSelectedRow()==-1) {
			// aunq la funcion no devuelva nada, puedes llamar a return para decir que 
			// finaliza la funcion
			return;			
		}
		if(e.getSource()==botonBorrar) {

			JOptionPane.showMessageDialog(null, "borrar: "+equipos[tabla.getSelectedRow()].toString());
			daoEquipo.borrarEquipo(equipos[tabla.getSelectedRow()].getId());
			refrescarEquipo();
			SwingUtilities.updateComponentTreeUI(this);
		}
		
	}
}
