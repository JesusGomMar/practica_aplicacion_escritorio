package paneles;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import daos.EquipoDAO;
import daos.EquipoDAOImpl;
import modelo.Equipo;

public class PanelRegistroEquipos extends JPanel implements ActionListener{

	JTextField campoNombre = new JTextField(15);
	JTextField campoNombreEquipo = new JTextField(15);
	JTextField campoFecha = new JTextField(15);
	JRadioButton yesButton = new JRadioButton("Yes");
	//yesButton.setSelected(true);
	JRadioButton noButton = new JRadioButton("No");
	JTextField campoPok1 = new JTextField(15);
	JTextField campoPok2 = new JTextField(15);
	JTextField campoPok3 = new JTextField(15);
	
	
	
	public PanelRegistroEquipos() {
		// TODO Auto-generated constructor stub
		//asi asigno un gestor de diseño q me permite
		//colocar las cosas en forma de filas y celdas
		
		yesButton.setSelected(true);
		ButtonGroup group = new ButtonGroup();
        group.add(yesButton);
        group.add(noButton);
		
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		// primera fila
		gbc.gridy = 0;
		gbc.gridx = 0;
		gbc.gridwidth = 2;
		this.add(new JLabel("INTRODUCE LOS DATOS DEL JUGADOR"), gbc);
		// vuelvo a decir q cada componente solo ocupe 1 elemento
		gbc.gridwidth = 1;
		
		// segunda fila
		
		gbc.gridy = 1;
		gbc.gridx = 0;
		this.add(new JLabel("Nombre: "), gbc);
		gbc.gridy = 1;
		gbc.gridx = 1;
		this.add(campoNombre, gbc);
		
		//tercera fila
		
		gbc.gridy = 2;
		gbc.gridx = 0;
		this.add(new JLabel("Nombre Equipo: "), gbc);
		gbc.gridy = 2;
		gbc.gridx = 1;
		this.add(campoNombreEquipo, gbc);
		
		//cuarta fila
		gbc.gridy = 3;
		gbc.gridx = 0;
		this.add(new JLabel("Fecha: "), gbc);
		gbc.gridy = 3;
		gbc.gridx = 1;
		this.add(campoFecha, gbc);
		
		//quinta fila
		gbc.gridy = 4;
		gbc.gridx = 0;
		this.add(new JLabel("Legendarios "), gbc);
		gbc.gridy = 4;
		gbc.gridx = 1;
		this.add(yesButton, gbc);
		gbc.gridy = 4;
		gbc.gridx = 2;
		this.add(noButton, gbc);
		
		
		//sexta fila
		gbc.gridy = 5;
		gbc.gridx = 0;
		this.add(new JLabel("Pok1: "), gbc);
		gbc.gridy = 5;
		gbc.gridx = 1;
		this.add(campoPok1, gbc);
		
		//sexta fila
		gbc.gridy = 6;
		gbc.gridx = 0;
		this.add(new JLabel("Pok2: "), gbc);
		gbc.gridy = 6;
		gbc.gridx = 1;
		this.add(campoPok2, gbc);
		
		//sexta fila
		gbc.gridy = 7;
		gbc.gridx = 0;
		this.add(new JLabel("Pok3: "), gbc);
		gbc.gridy = 7;
		gbc.gridx = 1;
		this.add(campoPok3, gbc);
		
		//septima fila
		JButton botonRegistroEquipo = new JButton("Registrar");
		botonRegistroEquipo.addActionListener(this);
		gbc.gridy = 8;
		gbc.gridx = 0;
		gbc.gridwidth = 2;
		this.add(botonRegistroEquipo, gbc);		
		
		
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("actionPerformed del PanelRegistroCliente");
		String nombre = campoNombre.getText();
		String nombrequipo = campoNombreEquipo.getText();
		String fecha = campoFecha.getText();
		boolean legendario = true;
		if (noButton.isSelected()) {
			legendario = false;
			
		}
		String pok1 = campoPok1.getText();
		String pok2 = campoPok2.getText();
		String pok3 = campoPok3.getText();

		// ahora habria q validar estos datos 
		//...TODO
		// una vez validados todos los datos, registramos en base de datos
		Equipo clienteAregistrar = new Equipo (nombre, nombrequipo, fecha, legendario, pok1, pok2, pok3);
		System.out.println("Voy a registrar: "+clienteAregistrar.toString());
		//invoco a lo necesario de la capa de datos para registrar el cliente en db
		EquipoDAOImpl clientesDAO = new EquipoDAOImpl ();
		clientesDAO.registrarEquipo(clienteAregistrar);
		
	}//end actionperformed
	
}
