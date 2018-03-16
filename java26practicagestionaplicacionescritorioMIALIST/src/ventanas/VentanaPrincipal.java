package ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

import paneles.PanelListadoEquipos;
import paneles.PanelRegistroEquipos;

public class VentanaPrincipal extends JFrame implements ActionListener{
	
	// estos son los paneeles de la ventana
	private PanelRegistroEquipos panelRegistroEquipo = new PanelRegistroEquipos();
	private PanelListadoEquipos panelListadoEquipo = new PanelListadoEquipos();
	
	//barra de menu
	private JMenuBar barraDeMenu = new JMenuBar();
	private JMenu menuEquipos = new JMenu("Equipo");
	private JMenu menuAyuda = new JMenu("Ayuda");
	
	
	
	
	public VentanaPrincipal() {
		// TODO Auto-generated constructor stub
		
		//preparar la barra de menu
		JMenuItem equiposInsertar = new JMenuItem("Insertar Equipo");
		JMenuItem equiposListar = new JMenuItem("Listar Equipo");
		menuEquipos.add(equiposInsertar);
		menuEquipos.add(equiposListar);
		barraDeMenu.add(menuEquipos);
		barraDeMenu.add(menuAyuda);
		this.setJMenuBar(barraDeMenu);
		
		//voy a decir a las opciones de menu quien las va a atender
		// cuando se las haga un click
		
		equiposInsertar.addActionListener(this);
		equiposListar.addActionListener(this);
		
		// preparamos la ventana principal
		this.setSize(800, 600);
		this.setLocationRelativeTo(null); // centra la ventana
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // cierra la ventana si se pulsa la X
		
		// cuando arranque esta ventana se muestre el panel de registro cliente
		this.setContentPane(panelRegistroEquipo);
		this.setVisible(true);
		
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("atiendo a: " + e.getActionCommand());
		if(e.getActionCommand().equals("Insertar Equipo")){
			setContentPane(panelRegistroEquipo);
		}else if (e.getActionCommand().equals("Listar Equipo")){
			setContentPane(panelListadoEquipo);
			panelListadoEquipo.refrescarEquipo();
		}
		SwingUtilities.updateComponentTreeUI(this);
		
	}
	

}
