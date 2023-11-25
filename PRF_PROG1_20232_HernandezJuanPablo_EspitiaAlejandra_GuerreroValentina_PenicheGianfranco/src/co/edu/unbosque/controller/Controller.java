// Controlador que gestiona las interacciones entre la interfaz gráfica y el modelo del programa.
package co.edu.unbosque.controller;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

import co.edu.unbosque.model.ApuestaBaloto;
import co.edu.unbosque.model.ApuestaBetplay;
import co.edu.unbosque.model.ApuestaChance;
import co.edu.unbosque.model.ApuestaLoteria;
import co.edu.unbosque.model.ApuestaSuperastro;
import co.edu.unbosque.model.BettingHouse;
import co.edu.unbosque.model.DataException;
import co.edu.unbosque.model.GamesData;
import co.edu.unbosque.model.GestionApostador;
import co.edu.unbosque.model.GestionSedes;
import co.edu.unbosque.model.Reporte;
import co.edu.unbosque.view.Aviso;
import co.edu.unbosque.view.VentanaApostador;
import co.edu.unbosque.view.VentanaBaloto;
import co.edu.unbosque.view.VentanaBetPlay;
import co.edu.unbosque.view.VentanaChance;
import co.edu.unbosque.view.VentanaEleccion;
import co.edu.unbosque.view.VentanaLoteria;
import co.edu.unbosque.view.VentanaPresupuestos;
import co.edu.unbosque.view.VentanaPrincipal;
import co.edu.unbosque.view.VentanaRegistrar;
import co.edu.unbosque.view.VentanaSedes;
import co.edu.unbosque.view.VentanaSedesYClientes;
import co.edu.unbosque.view.VentanaSuperastro;

/**
 * Controlador que gestiona las interacciones entre la interfaz gráfica y el
 * modelo del programa.
 */
public class Controller implements ActionListener {
	// Declaración de componentes y objetos necesarios
	private VentanaPrincipal vp;
	private VentanaRegistrar vr;
	private VentanaPresupuestos vPre;
	private VentanaSedes vs;
	private VentanaEleccion ve;
	private VentanaApostador va;
	private VentanaSedesYClientes vsyc;
	private BettingHouse casaApuestas;
	private GamesData dataJuegos;
	private GestionSedes dataSedes;
	private GestionApostador dataApostador;
	private File temp, temp2, temp3, temp4, temp5, temp6, temp7, temp8, temp9;
	private Aviso aviso;
	private int eleccion;
	private VentanaLoteria vl;
	private VentanaBaloto vb;
	private VentanaSuperastro vsa;
	private VentanaBetPlay vbp;
	private VentanaChance vc;
	private ApuestaBaloto ab;
	private ApuestaLoteria al;
	private ApuestaSuperastro as;
	private ApuestaBetplay abp;
	private ApuestaChance ac;
	private String cedula, numApostado;
	private Reporte reporte;

	/**
	 * Constructor por defecto que inicializa los objetos y componentes necesarios.
	 */
	public Controller() {
		// TODO Auto-generated constructor stub
		casaApuestas = new BettingHouse();
		dataJuegos = new GamesData();
		dataSedes = new GestionSedes();
		dataApostador = new GestionApostador();
		al = new ApuestaLoteria();
		ab = new ApuestaBaloto();
		as = new ApuestaSuperastro();
		abp = new ApuestaBetplay();
		ac = new ApuestaChance();
		reporte = new Reporte();
		temp = new File("data/config.properties");
		temp2 = new File("data/juegos.dat");
		temp3 = new File("data/sedes.dat");
		temp4 = new File("data/apostadores.dat");
		temp5 = new File("data/apuestas-loteria.dat");
		temp6 = new File("data/apuestas-baloto.dat");
		temp7 = new File("data/apuestas-superastro.dat");
		temp8 = new File("data/apuestas-betplay.dat");
		temp9 = new File("data/apuestas-chance.dat");
		aviso = new Aviso();
		va = new VentanaApostador();
		vp = new VentanaPrincipal();
		vr = new VentanaRegistrar();
		vPre = new VentanaPresupuestos();
		vs = new VentanaSedes();
		ve = new VentanaEleccion();
		vl = new VentanaLoteria();
		vb = new VentanaBaloto();
		vsa = new VentanaSuperastro();
		vbp = new VentanaBetPlay();
		vc = new VentanaChance();
		vsyc = new VentanaSedesYClientes();
		agregarLectores();
		eleccion = 0;
		cedula = "";
		numApostado = "";

	}

	/**
	 * Método principal que inicia la ejecución del programa.
	 */
	public void ejecutar() {
		// Verifica la existencia de archivos de configuración y datos
		if (temp.exists() && temp2.exists() && temp3.exists()) {
			ve.setVisible(true);
			casaApuestas.initializeBettingHouseData();
			dataJuegos.initializeGames();
			dataSedes.inicializarSedes();
			ve.getBotonApostadores().setBounds(605, 225, 290, 180);

		} else {
			vp.setVisible(true);
		}
		// Verifica la existencia de archivos de datos de apostadores
		if (temp4.exists()) {
			dataApostador.inicializarApostadores();

			ve.getBotonApostador().setVisible(true);
			ve.getBotonCasaApuestas().setVisible(true);
			ve.getBotonModificar().setVisible(false);
			ve.getBotonApostadores().setVisible(false);

		}
		// Inicializa datos de apuestas según el tipo de juego
		if (temp5.exists()) {
			al.inicializarApuestasLoteria();
		}
		if (temp6.exists()) {
			ab.inicializarApuestasBaloto();
		}
		if (temp7.exists()) {
			as.inicializarApuestasSuperastro();
		}
		if (temp8.exists()) {
			abp.inicializarApuestasBetplay();
		}
		if (temp9.exists()) {
			ac.inicializarApuestasChance();
		}

	}

	/**
	 * Método que agrega los listeners a los botones de la interfaz gráfica.
	 */
	public void agregarLectores() {
		vp.getBotonIniciar().addActionListener(this);
		vp.getBotonIniciar().setActionCommand("BotonIniciarClick");
		vp.getBotonRegresar().addActionListener(this);
		vp.getBotonRegresar().setActionCommand("BotonSalirClick");
		vr.getFlecha().addActionListener(this);
		vr.getFlecha().setActionCommand("BotonRRClick");
		vr.getFlecha2().addActionListener(this);
		vr.getFlecha2().setActionCommand("BotonRRClick2");
		vr.getBotonCrear().addActionListener(this);
		vr.getBotonCrear().setActionCommand("btnCrearDataCasa");
		vPre.getBotonPresupuestos().addActionListener(this);
		vPre.getBotonPresupuestos().setActionCommand("BotonRPresupuestos");
		vs.getBotonSedes().addActionListener(this);
		vs.getBotonSedes().setActionCommand("BotonCrearSede");
		ve.getBotonModificar().addActionListener(this);
		ve.getBotonModificar().setActionCommand("BotonModificar");
		ve.getBotonApostadores().addActionListener(this);
		ve.getBotonApostadores().setActionCommand("BotonVentanaApostadores");
		vr.getBotonModificar().addActionListener(this);
		vr.getBotonModificar().setActionCommand("BotonModificarCasa");
		vPre.getBotonModificar().addActionListener(this);
		vPre.getBotonModificar().setActionCommand("BotonModificarJuegos");
		vs.getBotonModificarSedes().addActionListener(this);
		vs.getBotonModificarSedes().setActionCommand("BotonModificarSedes");
		vs.getBotonFinalizar().addActionListener(this);
		vs.getBotonFinalizar().setActionCommand("BotonFinalizar");
		vs.getBotonEliminarSede().addActionListener(this);
		vs.getBotonEliminarSede().setActionCommand("BotonEliminarSede");
		vs.getBotonLlenarSedes().addActionListener(this);
		vs.getBotonLlenarSedes().setActionCommand("BotonLlenarSedes");
		va.getBotonCrear().addActionListener(this);
		va.getBotonCrear().setActionCommand("BotonCrearApostador");
		ve.getBotonApostador().addActionListener(this);
		ve.getBotonApostador().setActionCommand("BotonSoyApostador");
		ve.getBotonCasaApuestas().addActionListener(this);
		ve.getBotonCasaApuestas().setActionCommand("BotonSoyCasaApuestas");
		ve.getBotonLeerApostador().addActionListener(this);
		ve.getBotonLeerApostador().setActionCommand("BotonLeerApostador");
		ve.getBotonModificarApostador().addActionListener(this);
		ve.getBotonModificarApostador().setActionCommand("BotonModificarApostador");
		ve.getBotonEliminarApostador().addActionListener(this);
		ve.getBotonEliminarApostador().setActionCommand("BotonEliminarApostador");
		va.getBotonModificar().addActionListener(this);
		va.getBotonModificar().setActionCommand("BtnModificarApostador");
		va.getBotonEliminar().addActionListener(this);
		va.getBotonEliminar().setActionCommand("BtnEliminarApostador");
		ve.getBotonApuesta().addActionListener(this);
		ve.getBotonApuesta().setActionCommand("BotonApuestas");
		ve.getBotonReportes().addActionListener(this);
		ve.getBotonReportes().setActionCommand("BotonReportes");
		ve.getFlecha().addActionListener(this);
		ve.getFlecha().setActionCommand("BotonRegresar");
		va.getFlecha().addActionListener(this);
		va.getFlecha().setActionCommand("BotonRegresarApostadores");
		ve.getBotonCrearApuesta().addActionListener(this);
		ve.getBotonCrearApuesta().setActionCommand("BotonRealizarApuesta");
		ve.getBotonModificarApuesta().addActionListener(this);
		ve.getBotonModificarApuesta().setActionCommand("BotonModificarApuesta");
		ve.getBotonEliminarApuestas().addActionListener(this);
		ve.getBotonEliminarApuestas().setActionCommand("BotonEliminarApuesta");
		ve.getBotonLeerApuestas().addActionListener(this);
		ve.getBotonLeerApuestas().setActionCommand("BotonLeerApuesta");
		ve.getFlecha2().addActionListener(this);
		ve.getFlecha2().setActionCommand("BotonRegresarApuestas");
		ve.getFlecha3().addActionListener(this);
		ve.getFlecha3().setActionCommand("BotonRegresarJuegos");
		ve.getBotonBaloto().addActionListener(this);
		ve.getBotonBaloto().setActionCommand("BotonApostarBaloto");
		ve.getBotonLoteria().addActionListener(this);
		ve.getBotonLoteria().setActionCommand("BotonApostarLoteria");
		ve.getBotonSuperastro().addActionListener(this);
		ve.getBotonSuperastro().setActionCommand("BotonApostarSuperastro");
		ve.getBotonBetplay().addActionListener(this);
		ve.getBotonBetplay().setActionCommand("BotonApostarBetplay");
		ve.getBotonChance().addActionListener(this);
		ve.getBotonChance().setActionCommand("BotonApostarChance");
		vl.getBotonApostar().addActionListener(this);
		vl.getBotonApostar().setActionCommand("btnApostarLoteria");
		vl.getBotonModificar().addActionListener(this);
		vl.getBotonModificar().setActionCommand("btnModificarLoteria");
		vl.getBotonEliminar().addActionListener(this);
		vl.getBotonEliminar().setActionCommand("btnEliminarLoteria");

		vb.getBotonApostar().addActionListener(this);
		vb.getBotonApostar().setActionCommand("btnApostarBaloto");
		vb.getBotonModificar().addActionListener(this);
		vb.getBotonModificar().setActionCommand("btnModificarBaloto");
		vb.getBotonEliminar().addActionListener(this);
		vb.getBotonEliminar().setActionCommand("btnEliminarBaloto");

		vsa.getBotonApostar().addActionListener(this);
		vsa.getBotonApostar().setActionCommand("btnApostarSuperastro");
		vsa.getBotonModificar().addActionListener(this);
		vsa.getBotonModificar().setActionCommand("btnModificarSuperastro");
		vsa.getBotonEliminar().addActionListener(this);
		vsa.getBotonEliminar().setActionCommand("btnEliminarSuperastro");

		vbp.getBotonApostar().addActionListener(this);
		vbp.getBotonApostar().setActionCommand("btnApostarBetplay");
		vbp.getBotonModificar().addActionListener(this);
		vbp.getBotonModificar().setActionCommand("btnModificarBetplay");
		vbp.getBotonEliminar().addActionListener(this);
		vbp.getBotonEliminar().setActionCommand("btnEliminarBetplay");

		vc.getBotonApostar().addActionListener(this);
		vc.getBotonApostar().setActionCommand("btnApostarChance");
		vc.getBotonModificar().addActionListener(this);
		vc.getBotonModificar().setActionCommand("btnModificarChance");
		vc.getBotonEliminar().addActionListener(this);
		vc.getBotonEliminar().setActionCommand("btnEliminarChance");

		vl.getFlecha().addActionListener(this);
		vl.getFlecha().setActionCommand("botonFlechaLoteria");
		vb.getFlecha().addActionListener(this);
		vb.getFlecha().setActionCommand("botonFlechaBaloto");
		vsa.getFlecha().addActionListener(this);
		vsa.getFlecha().setActionCommand("botonFlechaSuperastro");
		vbp.getFlecha().addActionListener(this);
		vbp.getFlecha().setActionCommand("botonFlechaBetplay");
		vc.getFlecha().addActionListener(this);
		vc.getFlecha().setActionCommand("botonFlechaChance");

		vsyc.getBotonClienteSedes().addActionListener(this);
		vsyc.getBotonClienteSedes().setActionCommand("botonReporteClientesPorSede");
		vsyc.getBotonTotal().addActionListener(this);
		vsyc.getBotonTotal().setActionCommand("botonReporteValorTotal");
		vsyc.getBotonDetalles().addActionListener(this);
		vsyc.getBotonDetalles().setActionCommand("botonReporteDetallesApuestas");
		vsyc.getBotonSedeTipo().addActionListener(this);
		vsyc.getBotonSedeTipo().setActionCommand("botonReporteTotalSedeTipo");
		vsyc.getFlecha().addActionListener(this);
		vsyc.getFlecha().setActionCommand("botonFlechaReportes");

	}

	/**
	 * Implementación de la interfaz ActionListener que gestiona las interacciones
	 * entre la interfaz gráfica y el modelo del programa.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// Controla las acciones según el comando del evento

		switch (e.getActionCommand()) {
		// Acción al hacer clic en el botón "BotonIniciarClick"
		case "BotonIniciarClick": {
			// Oculta la ventana principal y muestra la ventana de registro
			vp.setVisible(false);
			vr.setVisible(true);

			break;

		}
		// Acción al hacer clic en el botón "BotonSalirClick"
		case "BotonSalirClick": {
			// Cierra la aplicación
			vp.setVisible(false);
			System.exit(0);
			break;
		}

		// Acción al hacer clic en el botón "BotonRRClick"
		case "BotonRRClick": {
			// Oculta la ventana de registro y muestra la ventana principal
			vr.setVisible(false);
			vp.setVisible(true);
			break;
		}

		// Acción al hacer clic en el botón "BotonRRClick2"
		case "BotonRRClick2": {
			// Oculta la ventana de registro y muestra la ventana de elección
			vr.setVisible(false);
			ve.setVisible(true);
			break;
		}

		// Acción al hacer clic en el botón "btnCrearDataCasa"
		case "btnCrearDataCasa": {
			// Verifica que se hayan ingresado datos en los campos de la casa de apuestas
			if (!vr.getNombreCasaField().getText().equals("") && !vr.getCantidadSedesField().getText().equals("")
					&& !vr.getPresupuestoTotalField().getText().equals("")) {
				boolean temp1 = true;

				// Validación de entrada: Cantidad de sedes (entero)
				try {
					Integer.parseInt(vr.getCantidadSedesField().getText());
				} catch (NumberFormatException ex) {
					ex.printStackTrace();
					temp1 = false;
					aviso.mostrarInfo("Debe ingresar valores válidos.");
				}

				// Validación de entrada: Presupuesto total (decimal)
				try {
					Double.parseDouble(vr.getPresupuestoTotalField().getText());
				} catch (NumberFormatException ex) {
					ex.printStackTrace();
					temp1 = false;
					aviso.mostrarInfo("Debe ingresar valores válidos.");
				}

				// Validación de entrada: Campos no vacíos
				try {
					if (vr.getNombreCasaField().getText().equals("") && vr.getCantidadSedesField().getText().equals("")
							&& vr.getPresupuestoTotalField().getText().equals("")) {
						throw new DataException("Debe ingresar valores en los campos");
					}
				} catch (DataException ex) {
					aviso.mostrarInfo("Debe ingresar valores en los campos");
					temp1 = false;
				}

				// Procede si las validaciones son exitosas
				if (temp1 == true) {
					// Llena los datos de la casa de apuestas, inicializa y muestra la ventana de
					// presupuestos
					casaApuestas.fillBettingHouseData(vr.getNombreCasaField().getText(),
							vr.getCantidadSedesField().getText(), vr.getPresupuestoTotalField().getText());
					casaApuestas.initializeBettingHouseData();
					aviso.mostrarInfo("Datos ingresados correctamente");
					vPre.setVisible(true);
					vr.setVisible(false);
				}
			} else {
				aviso.mostrarInfo("Debe llenar todos los datos para crear la casa de apuestas");
			}
			break;
		}

		/**
		 * Maneja los eventos cuando se hace clic en el botón "BotonRPresupuestos".
		 * 
		 * Valida y registra los presupuestos de los juegos en la casa de apuestas.
		 */
		case "BotonRPresupuestos": {
			// Verifica que todos los campos de presupuestos estén llenos
			if (!vPre.getpLoteria().getText().equals("") && !vPre.getpBaloto().getText().equals("")
					&& !vPre.getpSuperastro().getText().equals("") && !vPre.getpBetplay().getText().equals("")
					&& !vPre.getpChance().getText().equals("")) {

				boolean temp1 = true;

				try {
					// Intenta convertir el valor de Lotería a Double
					Double.parseDouble(vPre.getpLoteria().getText());

				} catch (NumberFormatException ex) {
					ex.printStackTrace();
					temp1 = false;
					aviso.mostrarInfo("Debe ingresar valores válidos.");
				}
				try {
					// Intenta convertir el valor de Baloto a Double
					Double.parseDouble(vPre.getpBaloto().getText());

				} catch (NumberFormatException ex) {
					ex.printStackTrace();
					temp1 = false;
					aviso.mostrarInfo("Debe ingresar valores válidos.");
				}
				try {
					// Intenta convertir el valor de SuperAstro a Double
					Double.parseDouble(vPre.getpSuperastro().getText());

				} catch (NumberFormatException ex) {
					ex.printStackTrace();
					temp1 = false;
					aviso.mostrarInfo("Debe ingresar valores válidos.");
				}
				try {
					// Intenta convertir el valor de BetPlay a Double
					Double.parseDouble(vPre.getpBetplay().getText());

				} catch (NumberFormatException ex) {
					ex.printStackTrace();
					temp1 = false;
					aviso.mostrarInfo("Debe ingresar valores válidos.");
				}
				try {
					// Intenta convertir el valor de Chance a Double
					Double.parseDouble(vPre.getpChance().getText());

				} catch (NumberFormatException ex) {
					ex.printStackTrace();
					temp1 = false;
					aviso.mostrarInfo("Debe ingresar valores válidos.");
				}

				// Si todos los valores son válidos
				if (temp1 == true) {
					// Inicializa la información de la casa de apuestas
					casaApuestas.initializeBettingHouseData();
					double tmp1 = Double.parseDouble(vPre.getpLoteria().getText());
					double tmp2 = Double.parseDouble(vPre.getpBaloto().getText());
					double tmp3 = Double.parseDouble(vPre.getpSuperastro().getText());
					double tmp4 = Double.parseDouble(vPre.getpBetplay().getText());
					double tmp5 = Double.parseDouble(vPre.getpChance().getText());

					double sumPresupuesto = tmp1 + tmp2 + tmp3 + tmp4 + tmp5;

					// Verifica que la suma de los presupuestos no exceda el presupuesto total
					if (sumPresupuesto <= Double.parseDouble(vr.getPresupuestoTotalField().getText())) {
						// Registra la información de los juegos en la casa de apuestas
						dataJuegos.createGames("Loteria", "Loteria", vPre.getpLoteria().getText());
						dataJuegos.createGames("Baloto", "Loteria", vPre.getpBaloto().getText());
						dataJuegos.createGames("SuperAstro", "Loteria", vPre.getpSuperastro().getText());
						dataJuegos.createGames("BetPlay", "Deportivo", vPre.getpBetplay().getText());
						dataJuegos.createGames("Chance", "Chance", vPre.getpChance().getText());

						// Muestra un mensaje de éxito y actualiza la interfaz
						aviso.mostrarInfo("Información de juegos guardada correctamente");
						vPre.setVisible(false);
						vs.setVisible(true);
						vs.getSedesActuales()
								.setText("Debe crear " + vr.getCantidadSedesField().getText() + " sedes en total.");
					} else {
						// Muestra un mensaje de error si la suma de los presupuestos excede el
						// presupuesto total
						aviso.mostrarInfo(
								"La suma de los presupuestos excede su presupuesto total, realice de nuevo la distribución del presupuesto");
					}
				}
			} else {
				// Muestra un mensaje si no se completan todos los campos
				aviso.mostrarInfo("Debe completar todos los campos.");
			}
			break;
		}

		/**
		 * Gestiona las acciones correspondientes a los eventos generados por la
		 * interfaz gráfica al hacer clic en diferentes botones.
		 */
		case "BotonCrearSede": {
			// Verifica que los campos de localidad y empleados no estén vacíos
			if (!vs.getLocalidadField().getText().equals("") && !vs.getEmpleadosField().getText().equals("")) {
				boolean tmp = true;

				// Validación de entrada: Número de empleados (entero)
				try {
					Integer.parseInt(vs.getEmpleadosField().getText());
				} catch (NumberFormatException ex) {
					tmp = false;
					aviso.mostrarInfo("Ingrese un número válido");
					ex.printStackTrace();
				}

				// Procede si la validación es exitosa
				if (tmp == true) {
					casaApuestas.initializeBettingHouseData();
					aviso.mostrarInfo(dataSedes.crearNuevaSede(
							casaApuestas.getHouse().getBettingHouse().getNumberOfSites(),
							vs.getLocalidadField().getText(), Integer.parseInt(vs.getEmpleadosField().getText())));

					// Verifica si se crearon todas las sedes
					if (casaApuestas.getHouse().getBettingHouse().getNumberOfSites() == dataSedes.getSedes().getSedes()
							.size()) {
						ve.setVisible(true);
						vs.setVisible(false);
						ve.getBotonApostadores().setBounds(605, 225, 290, 180);
					} else {
						// Limpia los campos de localidad y empleados si no se crearon todas las sedes
						vs.getLocalidadField().setText(null);
						vs.getEmpleadosField().setText(null);
					}
				}
			} else {
				aviso.mostrarInfo("Debe llenar todos los campos");
			}
			break;
		}

		case "BotonModificar": {
			// Muestra la ventana de registro con campos prellenados para modificar la casa
			// de apuestas
			vr.setVisible(true);
			ve.setVisible(false);
			vr.getBotonCrear().setVisible(false);
			vr.getBotonModificar().setVisible(true);
			vr.getFlecha().setVisible(false);
			vr.getFlecha2().setVisible(true);

			// Informa al usuario sobre la modificación
			aviso.mostrarInfo(
					"A continuación, modifica los datos que desees, en caso de que no se necesite cambiar nada, deja los campos llenos y continúa.");

			// Preenche los campos de la ventana de registro con los datos actuales de la
			// casa de apuestas
			vr.getNombreCasaField().setText(casaApuestas.getHouse().getBettingHouse().getBettingHouseName());
			vr.getCantidadSedesField()
					.setText(String.valueOf(casaApuestas.getHouse().getBettingHouse().getNumberOfSites()));
			vr.getPresupuestoTotalField()
					.setText(String.valueOf(casaApuestas.getHouse().getBettingHouse().getTotalBudget()));
			break;
		}

		case "BotonModificarCasa": {
			// Verifica que los campos de nombre, cantidad de sedes y presupuesto no estén
			// vacíos
			if (!vr.getNombreCasaField().getText().equals("") && !vr.getCantidadSedesField().getText().equals("")
					&& !vr.getPresupuestoTotalField().getText().equals("")) {
				boolean temp1 = true;

				// Validación de entrada: Cantidad de sedes (entero)
				try {
					Integer.parseInt(vr.getCantidadSedesField().getText());
				} catch (NumberFormatException ex) {
					ex.printStackTrace();
					temp1 = false;
					aviso.mostrarInfo("Debe ingresar valores válidos.");
				}

				// Validación de entrada: Presupuesto total (decimal)
				try {
					Double.parseDouble(vr.getPresupuestoTotalField().getText());
				} catch (NumberFormatException ex) {
					ex.printStackTrace();
					temp1 = false;
					aviso.mostrarInfo("Debe ingresar valores válidos.");
				}

				// Validación de entrada: Campos no vacíos
				try {
					if (vr.getNombreCasaField().getText().equals("") && vr.getCantidadSedesField().getText().equals("")
							&& vr.getPresupuestoTotalField().getText().equals("")) {
						throw new DataException("Debe ingresar valores en los campos");
					}
				} catch (DataException ex) {
					aviso.mostrarInfo("Debe ingresar valores en los campos");
					temp1 = false;
				}

				// Procede si las validaciones son exitosas
				if (temp1 == true) {
					// Modifica los datos de la casa de apuestas y muestra la ventana de
					// presupuestos
					casaApuestas.modifyBettingHouseData(vr.getNombreCasaField().getText(),
							vr.getCantidadSedesField().getText(), vr.getPresupuestoTotalField().getText());
					casaApuestas.initializeBettingHouseData();
					aviso.mostrarInfo("Datos modificados correctamente");
					vPre.setVisible(true);
					vPre.getBotonModificar().setVisible(true);
					vPre.getBotonPresupuestos().setVisible(false);
					vr.setVisible(false);
					casaApuestas.initializeBettingHouseData();

					// Actualiza los presupuestos en la ventana de presupuestos
					String salida1 = "" + dataJuegos.getGame().getGames().get(0).getGameBudget();
					System.out.println(salida1);
					String salida2 = "" + dataJuegos.getGame().getGames().get(1).getGameBudget();
					System.out.println(salida2);
					String salida3 = "" + dataJuegos.getGame().getGames().get(2).getGameBudget();
					System.out.println(salida3);
					String salida4 = "" + dataJuegos.getGame().getGames().get(3).getGameBudget();
					System.out.println(salida4);
					String salida5 = "" + dataJuegos.getGame().getGames().get(4).getGameBudget();
					System.out.println(salida5);
					vPre.getpLoteria().setText(salida1);
					vPre.getpBaloto().setText(salida2);
					vPre.getpSuperastro().setText(salida3);
					vPre.getpBetplay().setText(salida4);
					vPre.getpChance().setText(salida5);

					// Verifica si la suma de los presupuestos excede el presupuesto total de la
					// casa de apuestas
					double tmp1 = Double.parseDouble(vPre.getpLoteria().getText());
					double tmp2 = Double.parseDouble(vPre.getpBaloto().getText());
					double tmp3 = Double.parseDouble(vPre.getpSuperastro().getText());
					double tmp4 = Double.parseDouble(vPre.getpBetplay().getText());
					double tmp5 = Double.parseDouble(vPre.getpChance().getText());
					double sumPresupuesto = tmp1 + tmp2 + tmp3 + tmp4 + tmp5;

					if (sumPresupuesto > Double.parseDouble(vr.getPresupuestoTotalField().getText())) {
						aviso.mostrarInfo(
								"Los presupuestos actuales de sus juegos exceden el presupuesto total existente, debe modificarlos a continuación");
						// Limpia los campos de presupuestos en la ventana de presupuestos
						vPre.getpLoteria().setText(null);
						vPre.getpBaloto().setText(null);
						vPre.getpSuperastro().setText(null);
						vPre.getpBetplay().setText(null);
						vPre.getpChance().setText(null);
					} else {
						aviso.mostrarInfo(
								"No hay problema alguno con los presupuestos actuales de sus juegos, puede continuar presionando el boton (Si desea hacer modificaciones, asegurese de que no excedan su presupuesto total)");
						dataJuegos.initializeGames();
						casaApuestas.initializeBettingHouseData();
					}

				} else {

				}

			} else {
				aviso.mostrarInfo("Debe llenar todos los datos para crear la casa de apuestas");
			}
			break;
		}
		/**
		 * Maneja los eventos cuando se hace clic en el botón "BotonModificarJuegos".
		 * 
		 * Se encarga de modificar la información de los juegos y gestionar las sedes,
		 * validando los datos ingresados y mostrando mensajes de información al
		 * usuario.
		 */
		case "BotonModificarJuegos": {
			if (!vPre.getpLoteria().getText().equals("") && !vPre.getpBaloto().getText().equals("")
					&& !vPre.getpSuperastro().getText().equals("") && !vPre.getpBetplay().getText().equals("")
					&& !vPre.getpChance().getText().equals("")) {

				// Validación de los valores ingresados
				boolean temp1 = true;

				try {
					Double.parseDouble(vPre.getpLoteria().getText());

				} catch (NumberFormatException ex) {
					ex.printStackTrace();
					temp1 = false;
					aviso.mostrarInfo("Debe ingresar valores válidos.");
				}
				try {
					Double.parseDouble(vPre.getpBaloto().getText());

				} catch (NumberFormatException ex) {
					ex.printStackTrace();
					temp1 = false;
					aviso.mostrarInfo("Debe ingresar valores válidos.");
				}
				try {
					Double.parseDouble(vPre.getpSuperastro().getText());

				} catch (NumberFormatException ex) {
					ex.printStackTrace();
					temp1 = false;
					aviso.mostrarInfo("Debe ingresar valores válidos.");
				}
				try {
					Double.parseDouble(vPre.getpBetplay().getText());

				} catch (NumberFormatException ex) {
					ex.printStackTrace();
					temp1 = false;
					aviso.mostrarInfo("Debe ingresar valores válidos.");
				}
				try {
					Double.parseDouble(vPre.getpChance().getText());

				} catch (NumberFormatException ex) {
					ex.printStackTrace();
					temp1 = false;
					aviso.mostrarInfo("Debe ingresar valores válidos.");
				}

				if (temp1 == true) {
					casaApuestas.initializeBettingHouseData();
					double tmp1 = Double.parseDouble(vPre.getpLoteria().getText());
					double tmp2 = Double.parseDouble(vPre.getpBaloto().getText());
					double tmp3 = Double.parseDouble(vPre.getpSuperastro().getText());
					double tmp4 = Double.parseDouble(vPre.getpBetplay().getText());
					double tmp5 = Double.parseDouble(vPre.getpChance().getText());

					double sumPresupuesto = tmp1 + tmp2 + tmp3 + tmp4 + tmp5;

					// Verifica si la suma de los presupuestos no excede el presupuesto total de la
					// casa de apuestas
					if (sumPresupuesto <= Double.parseDouble(vr.getPresupuestoTotalField().getText())) {
						// Modifica la información de los juegos
						dataJuegos.modifyGames("Loteria", "Loteria", vPre.getpLoteria().getText(), 0);
						dataJuegos.modifyGames("Baloto", "Loteria", vPre.getpBaloto().getText(), 1);
						dataJuegos.modifyGames("SuperAstro", "Loteria", vPre.getpSuperastro().getText(), 2);
						dataJuegos.modifyGames("BetPlay", "Deportivo", vPre.getpBetplay().getText(), 3);
						dataJuegos.modifyGames("Chance", "Chance", vPre.getpChance().getText(), 4);

						aviso.mostrarInfo("Información de juegos modificada correctamente");
						vPre.setVisible(false);
						vs.setVisible(true);
						casaApuestas.initializeBettingHouseData();

						// Gestiona las sedes en función de la cantidad creada y la ingresada
						if (dataSedes.getSedes().getSedes().size() == casaApuestas.getHouse().getBettingHouse()
								.getNumberOfSites()) {
							aviso.mostrarInfo(
									"No hay problema alguno con la cantidad de sedes creadas, a continuación puede modificar una sede o finalizar la modificación de los datos de la casa de apuestas.");
							vs.getSedesActuales().setText(dataSedes.mostrarSedes());
							vs.getSedesActuales().setVisible(true);
							vs.getLocalidadTxt().setBounds(40, 225, 400, 25);
							vs.getLocalidadField().setBounds(40, 250, 350, 30);
							vs.getLocalidadAModificarTxt().setVisible(true);
							vs.getLocalidadAModificarField().setVisible(true);
							vs.getBotonModificarSedes().setVisible(true);
							vs.getBotonFinalizar().setVisible(true);
							vs.getBotonSedes().setVisible(false);
							vs.getBotonLlenarSedes().setVisible(true);
						} else if (dataSedes.getSedes().getSedes().size() < casaApuestas.getHouse().getBettingHouse()
								.getNumberOfSites()) {
							aviso.mostrarInfo(
									"Actualmente hay menos sedes creadas que la cantidad ingresada, por favor, cree las sedes que faltan.");
							vs.getSedesActuales().setText(dataSedes.mostrarSedes());
							vs.getSedesActuales().setVisible(true);
							vs.getLocalidadField().setText(null);
							vs.getEmpleadosField().setText(null);
						} else if (dataSedes.getSedes().getSedes().size() > casaApuestas.getHouse().getBettingHouse()
								.getNumberOfSites()) {
							aviso.mostrarInfo(
									"Actualmente hay más sedes creadas que la cantidad ingresada, por favor, elimine las sedes sobrantes ingresando el nombre de su localidad.");
							vs.getSedesActuales().setText(dataSedes.mostrarSedes());
							vs.getSedesActuales().setVisible(true);
							vs.getEmpleadosField().setVisible(false);
							vs.getBotonEliminarSede().setVisible(true);
							vs.getBotonSedes().setVisible(false);
							vs.getEmpleadosTxt().setVisible(false);
						}

					} else {
						aviso.mostrarInfo(
								"La suma de los presupuestos excede su presupuesto total, realice de nuevo la distribución del presupuesto");
					}
				}
			} else {
				aviso.mostrarInfo("Debe completar todos los campos.");
			}
			break;
		}
		/**
		 * Maneja los eventos cuando se hace clic en el botón "BotonModificarSedes".
		 * 
		 * Se encarga de modificar la información de una sede, validando los datos
		 * ingresados y mostrando mensajes de información al usuario.
		 */
		case "BotonModificarSedes": {
			if (!vs.getLocalidadField().getText().equals("") && !vs.getEmpleadosField().getText().equals("")
					&& !vs.getLocalidadAModificarField().getText().equals("")) {
				boolean tmp = true;
				try {
					Integer.parseInt(vs.getEmpleadosField().getText());
				} catch (NumberFormatException ex) {
					tmp = false;
					aviso.mostrarInfo("Ingrese un número valido");
					ex.printStackTrace();
				}

				if (tmp == true) {
					dataSedes.modificarSede(vs.getLocalidadAModificarField().getText(),
							vs.getLocalidadField().getText(), Integer.parseInt(vs.getEmpleadosField().getText()));

					aviso.mostrarInfo("Sede modificada correctamente.");
				}
			} else {

				aviso.mostrarInfo("Debe llenar todos los campos");

			}
			break;
		}
		/**
		 * Maneja los eventos cuando se hace clic en el botón "BotonFinalizar".
		 * 
		 * Muestra un mensaje indicando que la modificación ha sido completada y cambia
		 * la visibilidad de las ventanas.
		 */
		case "BotonFinalizar": {
			aviso.mostrarInfo("Modificación completada.");
			vs.setVisible(false);
			ve.setVisible(true);
			break;
		}
		/**
		 * Maneja los eventos cuando se hace clic en el botón "BotonEliminarSede".
		 * 
		 * Elimina una sede de la casa de apuestas según la localidad proporcionada.
		 * Muestra mensajes informativos y actualiza la interfaz según el resultado.
		 */
		case "BotonEliminarSede": {
			if (!vs.getLocalidadField().getText().equals("")) {
				// Muestra un mensaje informativo sobre la eliminación exitosa de la sede
				aviso.mostrarInfo("Sede eliminada exitosamente");
				// Muestra un mensaje informativo sobre la eliminación y actualiza la interfaz
				aviso.mostrarInfo(dataSedes.eliminarSede(casaApuestas.getHouse().getBettingHouse().getNumberOfSites(),
						vs.getLocalidadField().getText()));
				vs.setVisible(false);
				ve.setVisible(true);
				ve.getBotonModificar().setVisible(false);
				ve.getBotonReportes().setVisible(false);
				ve.getBotonEliminarApostador().setVisible(false);
				ve.getBotonLeerApostador().setVisible(false);
				ve.getBotonModificarApostador().setVisible(false);
				ve.getBotonApostadores().setBounds(200, 180, 290, 180);
				ve.getBotonApostadores().setVisible(false);
				ve.getBotonApostador().setVisible(true);
				ve.getBotonCasaApuestas().setVisible(true);
				ve.getBotonApuesta().setVisible(false);
				ve.getFlecha().setVisible(true);
			} else {
				// Muestra un mensaje si no se proporciona la localidad de la sede a eliminar
				aviso.mostrarInfo("Debe indicar la sede que desea eliminar.");
			}
			break;
		}

		/**
		 * Maneja los eventos cuando se hace clic en el botón "BotonLlenarSedes".
		 * 
		 * Crea una nueva sede en la casa de apuestas con la localidad y empleados
		 * proporcionados. Muestra mensajes informativos y actualiza la interfaz según
		 * el resultado.
		 */
		case "BotonLlenarSedes": {
			if (!vs.getLocalidadField().getText().equals("") && !vs.getEmpleadosField().getText().equals("")) {
				boolean tmp = true;
				try {
					// Verifica si la cantidad de empleados es un número válido
					Integer.parseInt(vs.getEmpleadosField().getText());
				} catch (NumberFormatException ex) {
					tmp = false;
					// Muestra un mensaje de error si la cantidad de empleados no es válida
					aviso.mostrarInfo("Ingrese un número válido");
					ex.printStackTrace();
				}

				if (tmp == true) {
					// Inicializa la información de la casa de apuestas
					casaApuestas.initializeBettingHouseData();
					// Muestra un mensaje informativo sobre la creación exitosa de la sede
					aviso.mostrarInfo(dataSedes.crearNuevaSede(
							casaApuestas.getHouse().getBettingHouse().getNumberOfSites(),
							vs.getLocalidadField().getText(), Integer.parseInt(vs.getEmpleadosField().getText())));

					// Verifica si se ha alcanzado la cantidad total de sedes planificadas
					if (casaApuestas.getHouse().getBettingHouse().getNumberOfSites() == dataSedes.getSedes().getSedes()
							.size()) {
						// Muestra mensajes informativos y actualiza la interfaz
						aviso.mostrarInfo("Archivo de sedes creado exitosamente");
						ve.setVisible(true);
						vs.setVisible(false);
						ve.getBotonModificar().setVisible(false);
						ve.getBotonReportes().setVisible(false);
						ve.getBotonEliminarApostador().setVisible(false);
						ve.getBotonLeerApostador().setVisible(false);
						ve.getBotonModificarApostador().setVisible(false);
						ve.getBotonApostadores().setBounds(200, 180, 290, 180);
						ve.getBotonApostadores().setVisible(false);
						ve.getBotonApostador().setVisible(true);
						ve.getBotonCasaApuestas().setVisible(true);
						ve.getBotonApuesta().setVisible(false);
						ve.getFlecha().setVisible(true);
					} else {
						// Limpia los campos si no se ha alcanzado la cantidad total de sedes
						vs.getLocalidadField().setText(null);
						vs.getEmpleadosField().setText(null);
					}
				}
			} else {
				// Muestra un mensaje si no se llenan todos los campos
				aviso.mostrarInfo("Debe llenar todos los campos");
			}
			break;
		}

		/**
		 * Maneja los eventos cuando se hace clic en el botón "BotonVentanaApostadores".
		 * 
		 * Oculta la ventana actual y muestra la ventana de apostadores, configurando
		 * los campos y botones.
		 */
		case "BotonVentanaApostadores": {
			ve.setVisible(false);
			va.setVisible(true);
			va.getNombreField().setVisible(true);
			va.getNombreTxt().setVisible(true);
			va.getSedeField().setVisible(true);
			va.getSedeTxt().setVisible(true);
			va.getCelularField().setVisible(true);
			va.getDireccionTxt().setVisible(true);
			va.getDireccionField().setVisible(true);
			va.getBotonEliminar().setVisible(false);
			va.getNombreField().setText(null);
			va.getCedulaField().setText(null);
			va.getSedeField().setText(null);
			va.getDireccionField().setText(null);
			va.getCelularField().setText(null);
			va.getNombreTxt().setBounds(40, 110, 400, 25);
			va.getNombreField().setBounds(40, 130, 350, 30);
			va.getCedulaTxt().setBounds(40, 290, 400, 25);
			va.getCedulaField().setBounds(40, 310, 350, 30);
			va.getSedeTxt().setBounds(40, 470, 400, 25);
			va.getSedeField().setBounds(40, 490, 350, 30);
			va.getNombreAModificarField().setVisible(false);
			va.getNombreAModificarTxt().setVisible(false);
			va.getBotonModificar().setVisible(false);
			va.getBotonCrear().setVisible(true);
			aviso.mostrarInfo("Las sedes disponibles son: " + dataSedes.mostrarSedes());
			break;
		}

		/**
		 * Maneja los eventos cuando se hace clic en el botón "BotonCrearApostador".
		 * 
		 * Crea un nuevo apostador, validando los datos ingresados y mostrando mensajes
		 * de información al usuario.
		 */
		case "BotonCrearApostador": {
			if (!va.getNombreField().getText().equalsIgnoreCase("") && !va.getCedulaField().getText().equals("")
					&& !va.getSedeField().getText().equals("") && !va.getDireccionField().getText().equals("")
					&& !va.getCelularField().getText().equals("")) {

				boolean tmp = true;
				boolean tmp2 = false;
				try {
					Long.parseLong(va.getCedulaField().getText());
				} catch (NumberFormatException ex) {
					tmp = false;
					aviso.mostrarInfo("Ingrese un número de cédula válido");
					ex.printStackTrace();
				}
				try {
					Long.parseLong(va.getCelularField().getText());
				} catch (NumberFormatException ex) {
					tmp = false;
					aviso.mostrarInfo("Ingrese un número de teléfono válido");
					ex.printStackTrace();
				}

				for (int i = 0; i < dataSedes.getSedes().getSedes().size(); i++) {
					if (va.getSedeField().getText()
							.equals(dataSedes.getSedes().getSedes().get(i).getUbicacionLocalidad())) {
						tmp2 = true;
					}
				}

				if (tmp == true && tmp2 == true) {
					dataApostador.crearApostador(va.getNombreField().getText(),
							Long.parseLong(va.getCedulaField().getText()), va.getSedeField().getText(),
							va.getDireccionField().getText(), Long.parseLong(va.getCelularField().getText()));
					aviso.mostrarInfo("Apostador creado exitosamente");
					dataApostador.leerApostadores();
					va.setVisible(false);
					ve.setVisible(true);
					ve.getBotonApostador().setVisible(true);
					ve.getBotonCasaApuestas().setVisible(true);
					ve.getBotonModificar().setVisible(false);
					ve.getBotonApostadores().setVisible(false);
					ve.getBotonEliminarApostador().setVisible(false);
					ve.getBotonLeerApostador().setVisible(false);
					ve.getBotonModificarApostador().setVisible(false);
					ve.getBotonApostadores().setBounds(200, 180, 290, 180);
					ve.getBotonApostadores().setVisible(false);
					ve.getBotonApuesta().setVisible(false);
					ve.getFlecha().setVisible(true);
				} else if (tmp == true && tmp2 == false) {
					aviso.mostrarInfo("Debe ingresar una sede existente");
				} else {
					aviso.mostrarInfo("Debe ingresar valores y sede validos");
				}

			} else {
				aviso.mostrarInfo("Debe completar todos los campos.");
			}
			break;
		}

		/**
		 * Maneja los eventos cuando se hace clic en el botón "BotonSoyApostador".
		 * 
		 * Muestra o configura la visibilidad de botones y campos en la ventana de
		 * apostadores.
		 */
		case "BotonSoyApostador": {
			ve.getBotonEliminarApostador().setVisible(true);
			;
			ve.getBotonLeerApostador().setVisible(true);
			;
			ve.getBotonModificarApostador().setVisible(true);
			ve.getBotonApostadores().setBounds(200, 180, 290, 180);
			ve.getBotonApostadores().setVisible(true);
			ve.getBotonApostador().setVisible(false);
			ve.getBotonCasaApuestas().setVisible(false);
			ve.getBotonApuesta().setVisible(true);
			ve.getFlecha().setVisible(true);
			break;
		}
		/**
		 * Maneja los eventos cuando se hace clic en el botón "BotonSoyCasaApuestas".
		 * 
		 * Configura la visibilidad de botones en la ventana principal para la casa de
		 * apuestas.
		 */
		case "BotonSoyCasaApuestas": {
			ve.getBotonModificar().setVisible(true);
			ve.getBotonReportes().setVisible(true);
			ve.getFlecha().setVisible(true);
			ve.getBotonApostador().setVisible(false);
			ve.getBotonCasaApuestas().setVisible(false);
			break;
		}

		/**
		 * Maneja los eventos cuando se hace clic en el botón "BotonRegresar".
		 * 
		 * Restablece la visibilidad de botones y campos en la ventana principal después
		 * de modificar o interactuar con apostadores.
		 */
		case "BotonRegresar": {
			ve.getBotonModificar().setVisible(false);
			ve.getBotonReportes().setVisible(false);
			ve.getBotonEliminarApostador().setVisible(false);
			ve.getBotonLeerApostador().setVisible(false);
			ve.getBotonModificarApostador().setVisible(false);
			ve.getBotonApostadores().setBounds(200, 180, 290, 180);
			ve.getBotonApostadores().setVisible(false);
			ve.getBotonApostador().setVisible(true);
			ve.getBotonCasaApuestas().setVisible(true);
			ve.getBotonApuesta().setVisible(false);
			ve.getFlecha().setVisible(true);
			break;
		}

		/**
		 * Maneja los eventos cuando se hace clic en el botón "BotonModificarApostador".
		 * 
		 * Muestra la ventana de modificación de apostador y configura los campos y
		 * botones para la acción de modificación.
		 */
		case "BotonModificarApostador": {
			ve.setVisible(false);
			va.setVisible(true);
			va.getNombreTxt().setBounds(40, 250, 400, 25);
			va.getNombreField().setBounds(40, 270, 350, 30);
			va.getCedulaTxt().setBounds(40, 350, 400, 25);
			va.getCedulaField().setBounds(40, 370, 350, 30);
			va.getSedeTxt().setBounds(40, 450, 400, 25);
			va.getSedeField().setBounds(40, 470, 350, 30);
			va.getNombreAModificarField().setVisible(true);
			va.getNombreAModificarTxt().setVisible(true);
			va.getNombreField().setVisible(true);
			va.getNombreTxt().setVisible(true);
			va.getCelularField().setVisible(true);
			va.getCelularTxt().setVisible(true);
			va.getDireccionField().setVisible(true);
			va.getDireccionTxt().setVisible(true);
			va.getCelularField().setVisible(true);
			va.getCelularTxt().setVisible(true);
			va.getSedeField().setVisible(true);
			va.getSedeTxt().setVisible(true);
			va.getBotonModificar().setVisible(true);
			va.getBotonCrear().setVisible(false);
			va.getBotonEliminar().setVisible(false);
			va.getCedulaField().setText(null);
			aviso.mostrarInfo(
					"A continuación, ingrese el nombre del apostador que desea modificar, y luego, ingrese los nuevos datos del apostador.");
			break;
		}

		/**
		 * Maneja los eventos cuando se hace clic en el botón "BtnModificarApostador".
		 * 
		 * Modifica un apostador existente con los datos proporcionados, validando la
		 * información ingresada.
		 */
		case "BtnModificarApostador": {
			if (!va.getNombreAModificarField().getText().equals("")
					&& !va.getNombreField().getText().equalsIgnoreCase("") && !va.getCedulaField().getText().equals("")
					&& !va.getSedeField().getText().equals("") && !va.getDireccionField().getText().equals("")
					&& !va.getCelularField().getText().equals("")) {
				boolean tmp = true;
				try {
					Long.parseLong(va.getCedulaField().getText());
				} catch (NumberFormatException ex) {
					tmp = false;
					aviso.mostrarInfo("Ingrese un número de cédula válido");
					ex.printStackTrace();
				}
				try {
					Long.parseLong(va.getCelularField().getText());
				} catch (NumberFormatException ex) {
					tmp = false;
					aviso.mostrarInfo("Ingrese un número de teléfono válido");
					ex.printStackTrace();
				}

				if (tmp == true) {
					boolean tmp2 = false;
					for (int i = 0; i < dataSedes.getSedes().getSedes().size(); i++) {
						if (va.getSedeField().getText()
								.equals(dataSedes.getSedes().getSedes().get(i).getUbicacionLocalidad())) {
							tmp2 = true;
						}
					}
					if (tmp2 == true) {
						dataApostador.modificarApostador(va.getNombreAModificarField().getText(),
								va.getNombreField().getText(), Long.parseLong(va.getCedulaField().getText()),
								va.getSedeField().getText(), va.getDireccionField().getText(),
								Long.parseLong(va.getCelularField().getText()));
						aviso.mostrarInfo("Apostador modificado exitosamente.");
					} else {
						aviso.mostrarInfo("Debe ingresar una sede existente, las sedes disponibles son: "
								+ dataSedes.mostrarSedes());
					}
				} else {
					aviso.mostrarInfo("Debe ingresar números válidos en los campos de cédula y número.");
				}

			} else {
				aviso.mostrarInfo("Debe completar todos los campos.");
			}
			break;
		}

		/**
		 * Maneja los eventos cuando se hace clic en el botón "BotonEliminarApostador".
		 * 
		 * Prepara la interfaz para eliminar a un apostador, ocultando algunos campos y
		 * mostrando el campo de cédula. Muestra mensajes informativos y actualiza la
		 * interfaz según el resultado.
		 */
		case "BotonEliminarApostador": {
			ve.setVisible(false);
			va.setVisible(true);
			va.getNombreField().setVisible(false);
			va.getNombreTxt().setVisible(false);
			va.getSedeField().setVisible(false);
			va.getSedeTxt().setVisible(false);
			va.getCelularField().setVisible(false);
			va.getCelularTxt().setVisible(false);
			va.getDireccionTxt().setVisible(false);
			va.getDireccionField().setVisible(false);
			va.getBotonEliminar().setVisible(true);
			va.getNombreField().setText(null);
			va.getCedulaField().setText(null);
			va.getSedeField().setText(null);
			va.getDireccionField().setText(null);
			va.getCelularField().setText(null);
			va.getNombreTxt().setBounds(40, 110, 400, 25);
			va.getNombreField().setBounds(40, 130, 350, 30);
			va.getCedulaTxt().setBounds(40, 290, 400, 25);
			va.getCedulaField().setBounds(40, 310, 350, 30);
			va.getSedeTxt().setBounds(40, 470, 400, 25);
			va.getSedeField().setBounds(40, 490, 350, 30);
			va.getNombreAModificarField().setVisible(false);
			va.getNombreAModificarTxt().setVisible(false);
			va.getBotonModificar().setVisible(false);
			va.getBotonCrear().setVisible(false);

			// Muestra un mensaje informativo antes de eliminar al apostador
			aviso.mostrarInfo("A continuación, ingrese el número de cédula del apostador que desea eliminar.");
			break;
		}

		/**
		 * Maneja los eventos cuando se hace clic en el botón "BtnEliminarApostador".
		 * 
		 * Elimina a un apostador según el número de cédula proporcionado. Muestra
		 * mensajes informativos y actualiza la interfaz según el resultado.
		 */
		case "BtnEliminarApostador": {
			if (!va.getCedulaField().getText().equals("")) {
				boolean tmp = true;
				try {
					// Verifica si el número de cédula es válido
					Long.parseLong(va.getCedulaField().getText());
				} catch (NumberFormatException ex) {
					tmp = false;
					// Muestra un mensaje de error si el número de cédula no es válido
					aviso.mostrarInfo("Ingrese un número de cédula válido");
					ex.printStackTrace();
				}
				if (tmp == true) {
					// Elimina al apostador y muestra un mensaje informativo sobre la eliminación
					// exitosa
					dataApostador.eliminarApostador(Long.parseLong(va.getCedulaField().getText()));
					aviso.mostrarInfo("Apostador eliminado correctamente");
				} else {
					// Muestra un mensaje si el número de cédula no es válido
					aviso.mostrarInfo("Debe ingresar un número de cédula válido.");
				}
			} else {
				// Muestra un mensaje si no se ingresa el número de cédula
				aviso.mostrarInfo("Debe ingresar un número de cédula");
			}
			break;
		}

		/**
		 * Maneja los eventos cuando se hace clic en el botón "BotonLeerApostador".
		 * 
		 * Inicializa y lee la información de los apostadores, mostrando un mensaje
		 * informativo con la información.
		 */
		case "BotonLeerApostador": {
			dataApostador.inicializarApostadores();
			String apostadores = dataApostador.leerApostadores();
			// Muestra la información de los apostadores
			aviso.mostrarInfo(apostadores);
			break;
		}

		/**
		 * Maneja los eventos cuando se hace clic en el botón
		 * "BotonRegresarApostadores".
		 * 
		 * Regresa a la vista principal desde la vista de apostadores.
		 */
		case "BotonRegresarApostadores": {
			va.setVisible(false);
			ve.setVisible(true);
			break;
		}
		/**
		 * Maneja los eventos cuando se hace clic en el botón "BotonApuestas".
		 * 
		 * Oculta y muestra diferentes botones y elementos de la interfaz para gestionar
		 * apuestas.
		 */
		case "BotonApuestas": {
			ve.getBotonApostador().setVisible(false);
			ve.getBotonCasaApuestas().setVisible(false);
			ve.getBotonModificar().setVisible(false);
			ve.getBotonApostadores().setVisible(false);
			ve.getBotonEliminarApostador().setVisible(false);
			ve.getBotonLeerApostador().setVisible(false);
			ve.getBotonModificarApostador().setVisible(false);
			ve.getBotonApostadores().setBounds(200, 180, 290, 180);
			ve.getBotonApostadores().setVisible(false);
			ve.getBotonApuesta().setVisible(false);
			ve.getFlecha().setVisible(false);
			ve.getBotonCrearApuesta().setVisible(true);
			ve.getBotonLeerApuestas().setVisible(true);
			ve.getBotonModificarApuesta().setVisible(true);
			ve.getBotonEliminarApuestas().setVisible(true);
			ve.getFlecha2().setVisible(true);
			break;
		}

		/**
		 * Maneja los eventos cuando se hace clic en el botón "BotonRealizarApuesta".
		 * 
		 * Configura la interfaz para realizar una apuesta, mostrando opciones
		 * específicas para los tipos de apuestas.
		 */
		case "BotonRealizarApuesta": {
			eleccion = 1;
			ve.getBotonCrearApuesta().setVisible(false);
			ve.getBotonLeerApuestas().setVisible(false);
			ve.getBotonModificarApuesta().setVisible(false);
			ve.getBotonEliminarApuestas().setVisible(false);
			ve.getBotonLoteria().setVisible(true);
			ve.getBotonBaloto().setVisible(true);
			ve.getBotonSuperastro().setVisible(true);
			ve.getBotonBetplay().setVisible(true);
			ve.getBotonChance().setVisible(true);
			ve.getFlecha3().setVisible(true);
			ve.getFlecha2().setVisible(false);
			break;
		}

		/**
		 * Maneja los eventos cuando se hace clic en el botón "BotonApostarLoteria".
		 * 
		 * Realiza acciones específicas según la elección del usuario en la interfaz de
		 * apuestas de Lotería.
		 */
		case "BotonApostarLoteria": {
			if (eleccion == 1) {
				// Realiza la apuesta de Lotería
				vl.setVisible(true);
				ve.setVisible(false);
				cedula = aviso.recibirInfo("Por favor, ingrese el número de cédula");
				vl.getBotonApostar().setVisible(true);
				vl.getBotonModificar().setVisible(false);
				vl.getBotonEliminar().setVisible(false);
			} else if (eleccion == 2) {
				// Modifica la apuesta de Lotería
				vl.setVisible(true);
				ve.setVisible(false);
				cedula = aviso.recibirInfo("Por favor, ingrese el número de cédula");
				numApostado = aviso
						.recibirInfo("Por favor, ingrese el número apostado de la apuesta que desea modificar.");
				vl.getBotonModificar().setVisible(true);
				vl.getBotonApostar().setVisible(false);
				vl.getBotonEliminar().setVisible(false);
			} else if (eleccion == 3) {
				// Elimina la apuesta de Lotería
				cedula = aviso.recibirInfo("Por favor, ingrese el número de cédula");
				numApostado = aviso
						.recibirInfo("Por favor, ingrese el número apostado de la apuesta que desea eliminar.");
				if (!cedula.equals("") && !numApostado.equals("")) {
					boolean tmp = true;
					try {
						Long.parseLong(cedula);
					} catch (NumberFormatException ex) {
						tmp = false;
					}
					try {
						Integer.parseInt(numApostado);
					} catch (NumberFormatException ex) {
						tmp = false;
					}
					if (tmp == true) {
						// Elimina la apuesta de Lotería y muestra un mensaje informativo
						al.eliminarApuestaLoteria(Long.parseLong(cedula), Integer.parseInt(numApostado));
						aviso.mostrarInfo("Apuesta eliminada correctamente");
					}
				}
				vl.getBotonModificar().setVisible(false);
				vl.getBotonApostar().setVisible(false);
				vl.getBotonEliminar().setVisible(true);
			} else if (eleccion == 4) {
				// Lee las apuestas de Lotería
				al.inicializarApuestasLoteria();
				aviso.mostrarInfo(al.leerApuestaLoteria());
			}
			break;
		}

		/**
		 * Maneja los eventos cuando se hace clic en el botón "btnApostarLoteria" para
		 * realizar una apuesta de Lotería.
		 * 
		 * Valida los campos de la interfaz y crea la apuesta de Lotería si los datos
		 * son válidos.
		 */
		case "btnApostarLoteria": {
			if (!vl.getpDiaApuesta().getText().equals("") && !vl.getpNombreLoteria().getText().equals("")
					&& !vl.getpValorApuesta().getText().equals("") && !vl.getpNumeroApostado().getText().equals("")
					&& !vl.getpSerie().getText().equals("") && !cedula.equals("")
					&& vl.getpNumeroApostado().getText().length() == 4) {
				boolean tmp = true;

				String sede = null;
				try {
					Long.parseLong(cedula);
				} catch (NumberFormatException ex) {
					tmp = false;
				}
				try {
					Double.parseDouble(vl.getpValorApuesta().getText());
				} catch (NumberFormatException ex) {
					tmp = false;
				}
				try {
					Integer.parseInt(vl.getpNumeroApostado().getText());
				} catch (NumberFormatException ex) {
					tmp = false;
				}
				try {
					Integer.parseInt(vl.getpSerie().getText());
				} catch (NumberFormatException ex) {
					tmp = false;
				}

				if (tmp == true) {
					// Obtiene la sede del apostador
					boolean tmp2 = false;
					for (int i = 0; i < dataApostador.getApostador().getListaApostador().size(); i++) {
						if (Long.parseLong(cedula) == dataApostador.getApostador().getListaApostador().get(i)
								.getCedula()) {
							sede = dataApostador.getApostador().getListaApostador().get(i).getSede();
							tmp2 = true;
						}
					}

					if (tmp2 == true) {
						// Crea la apuesta de Lotería
						al.crearApuestaLoteria(sede, Long.parseLong(cedula), vl.getpDiaApuesta().getText(),
								Double.parseDouble(vl.getpValorApuesta().getText()), vl.getpNombreLoteria().getText(),
								Integer.parseInt(vl.getpNumeroApostado().getText()),
								Integer.parseInt(vl.getpSerie().getText()));

						// Muestra un mensaje informativo con el recibo de la apuesta
						aviso.mostrarInfo("Recibo: " + "\n" + "Nombre sede: " + sede + "\n" + " Cedula: " + cedula
								+ "\n" + " Dia apuesta: " + vl.getpDiaApuesta().getText() + "\n" + " Valor apuesta: "
								+ vl.getpValorApuesta().getText() + "\n" + " Nombre loteria: "
								+ vl.getpNombreLoteria().getText() + "\n" + " Numero loteria: "
								+ vl.getpNumeroApostado().getText() + "\n" + " Numero serie: "
								+ vl.getpSerie().getText());

					} else {
						aviso.mostrarInfo("Debe ingresar el número de cedula de un apostador existente");
						cedula = aviso.recibirInfo("Por favor, ingrese el número de cedula");
					}
				} else {
					// Muestra un mensaje de error y solicita nuevamente el número de cédula
					aviso.mostrarInfo(
							"Debe ingresar valores validos para cedula, valor de la apuesta, numero apostado y numero de serie");
					cedula = aviso.recibirInfo("Por favor, ingrese el número de cedula");
					vl.getpValorApuesta().setText(null);
					vl.getpNumeroApostado().setText(null);
					vl.getpSerie().setText(null);
				}

			} else {
				// Muestra un mensaje de error y solicita nuevamente el número de cédula
				aviso.mostrarInfo(
						"Debe ingresar valores en los campos, y asegurarse que el número apostado tenga solo 4 números.");
				cedula = aviso.recibirInfo("Por favor, ingrese el número de cedula");
			}
			break;
		}
		/**
		 * Maneja los eventos cuando se hace clic en el botón "btnModificarLoteria" para
		 * modificar una apuesta de Lotería.
		 * 
		 * Valida los campos de la interfaz y modifica la apuesta de Lotería si los
		 * datos son válidos.
		 */
		case "btnModificarLoteria": {
			if (!vl.getpDiaApuesta().getText().equals("") && !vl.getpNombreLoteria().getText().equals("")
					&& !vl.getpValorApuesta().getText().equals("") && !vl.getpNumeroApostado().getText().equals("")
					&& !vl.getpSerie().getText().equals("") && !cedula.equals("") && !numApostado.equals("")
					&& vl.getpNumeroApostado().getText().length() == 4) {
				boolean tmp = true;

				String sede = null;
				try {
					Long.parseLong(cedula);
				} catch (NumberFormatException ex) {
					tmp = false;
				}
				try {
					Double.parseDouble(vl.getpValorApuesta().getText());
				} catch (NumberFormatException ex) {
					tmp = false;
				}
				try {
					Integer.parseInt(vl.getpNumeroApostado().getText());
				} catch (NumberFormatException ex) {
					tmp = false;
				}
				try {
					Integer.parseInt(numApostado);
				} catch (NumberFormatException ex) {
					tmp = false;
				}
				try {
					Integer.parseInt(vl.getpSerie().getText());
				} catch (NumberFormatException ex) {
					tmp = false;
				}

				if (tmp == true) {
					// Obtiene la sede del apostador
					boolean tmp2 = false;
					boolean tmp3 = false;
					for (int i = 0; i < dataApostador.getApostador().getListaApostador().size(); i++) {
						if (Long.parseLong(cedula) == dataApostador.getApostador().getListaApostador().get(i)
								.getCedula()) {
							sede = dataApostador.getApostador().getListaApostador().get(i).getSede();
							tmp2 = true;
						}
					}
					for (int i = 0; i < al.getApuestaLoteria().getApuestasLoteria().size(); i++) {
						if (Integer.parseInt(numApostado) == al.getApuestaLoteria().getApuestasLoteria().get(i)
								.getNumeroApostado()) {
							tmp3 = true;
						}
					}
					if (tmp2 == true && tmp3 == true) {
						// Modifica la apuesta de Lotería y muestra un mensaje informativo
						al.modificarApuestaLoteria(sede, Long.parseLong(cedula), vl.getpDiaApuesta().getText(),
								Integer.parseInt(numApostado), Double.parseDouble(vl.getpValorApuesta().getText()),
								vl.getpNombreLoteria().getText(), Integer.parseInt(vl.getpNumeroApostado().getText()),
								Integer.parseInt(vl.getpSerie().getText()));
						aviso.mostrarInfo("Apuesta modificada correctamente");
					} else {
						aviso.mostrarInfo(
								"Error, ingresó mal el número de cedula o el número de la apuesta a modificar");
						cedula = aviso.recibirInfo("Por favor, ingrese el número de cedula");
						numApostado = aviso
								.recibirInfo("Por favor ingrese el numero apostado de la apuesta a modificar");
					}
				} else {
					// Muestra un mensaje de error y solicita nuevamente el número de cédula y
					// número apostado
					aviso.mostrarInfo(
							"Debe ingresar valores válidos para cedula, antiguo número apostado, valor de la apuesta, número apostado y número de serie");
					cedula = aviso.recibirInfo("Por favor, ingrese el número de cedula");
					numApostado = aviso.recibirInfo("Por favor ingrese el numero apostado de la apuesta a modificar");
					vl.getpValorApuesta().setText(null);
					vl.getpNumeroApostado().setText(null);
					vl.getpSerie().setText(null);
				}
			} else {
				// Muestra un mensaje de error y solicita nuevamente el número de cédula y
				// número apostado
				aviso.mostrarInfo(
						"Debe ingresar valores en los campos, y asegurarse que el número apostado tenga solo 4 números.");
				cedula = aviso.recibirInfo("Por favor, ingrese el número de cedula");
				numApostado = aviso.recibirInfo("Por favor ingrese el numero apostado de la apuesta a modificar");
			}
			break;
		}
		/**
		 * Maneja los eventos cuando se hace clic en el botón "botonFlechaLoteria" para
		 * regresar a la ventana principal desde la sección de apuestas de Lotería.
		 * Limpia los campos de la interfaz y muestra la ventana principal.
		 */
		case "botonFlechaLoteria": {
			vl.setVisible(false);
			vl.getpDiaApuesta().setText(null);
			vl.getpNombreLoteria().setText(null);
			vl.getpNumeroApostado().setText(null);
			vl.getpSerie().setText(null);
			vl.getpValorApuesta().setText(null);
			ve.setVisible(true);
			break;
		}

		/**
		 * Maneja los eventos cuando se hace clic en el botón "BotonApostarBaloto" para
		 * realizar acciones relacionadas con las apuestas de Baloto.
		 * 
		 * Realiza diferentes acciones según la elección, como apostar, modificar,
		 * eliminar o leer apuestas de Baloto.
		 */
		case "BotonApostarBaloto": {
			if (eleccion == 1) {
				// Caso de apostar una nueva apuesta de Baloto
				vb.setVisible(true);
				cedula = aviso.recibirInfo("Por favor, ingrese el número de cedula");
				vb.getBotonApostar().setVisible(true);
				vb.getBotonModificar().setVisible(false);
				vb.getBotonEliminar().setVisible(false);
				vb.getpValorApuesta().setText(null);
				vb.getpNumeroApostado().setText(null);
				vb.getpDiaApuesta().setText(null);
			} else if (eleccion == 2) {
				// Caso de modificar una apuesta de Baloto existente
				vb.getpValorApuesta().setText(null);
				vb.getpNumeroApostado().setText(null);
				vb.getpDiaApuesta().setText(null);
				vb.setVisible(true);
				cedula = aviso.recibirInfo("Por favor, ingrese el número de cedula");
				numApostado = aviso.recibirInfo(
						"Por favor, ingrese el número apostado de la apuesta que desea modificar (Ingrese los 6 números separados por un espacio cada uno, de la manera 1 2 3 4 5 6");
				vb.getBotonModificar().setVisible(true);
				vb.getBotonApostar().setVisible(false);
				vb.getBotonEliminar().setVisible(false);
			} else if (eleccion == 3) {
				// Caso de eliminar una apuesta de Baloto
				cedula = aviso.recibirInfo("Por favor, ingrese el número de cedula");
				numApostado = aviso.recibirInfo(
						"Por favor, ingrese el número apostado de la apuesta que desea modificar (Ingrese los 6 números separados por un espacio cada uno, de la manera 1 2 3 4 5 6");
				if (!cedula.equals("") && !numApostado.equals("")) {
					boolean tmp = true;
					try {
						Long.parseLong(cedula);
					} catch (NumberFormatException ex) {
						tmp = false;
					}
					try {
						numApostado = numApostado.replaceAll("\\s+", "");
						Integer.parseInt(numApostado);
					} catch (NumberFormatException ex) {
						tmp = false;
					}
					if (tmp) {
						ab.eliminarApuestaBaloto(Long.parseLong(cedula), numApostado);
						aviso.mostrarInfo("Apuesta eliminada correctamente");
					}
				}
			} else if (eleccion == 4) {
				// Caso de leer todas las apuestas de Baloto
				aviso.mostrarInfo(ab.leerApuestaBaloto());
			}
			break;
		}
		/**
		 * Maneja los eventos cuando se hace clic en el botón "btnApostarBaloto" para
		 * realizar una apuesta de Baloto. Valida los campos y realiza la apuesta,
		 * mostrando un recibo con la información de la apuesta.
		 */
		case "btnApostarBaloto": {
			String sede = "";
			if (!vb.getpDiaApuesta().getText().equals("") && !vb.getpValorApuesta().getText().equals("")
					&& !vb.getpNumeroApostado().getText().equals("") && !cedula.equals("")) {
				boolean tmp = true;

				try {
					Long.parseLong(cedula);
				} catch (NumberFormatException ex) {
					tmp = false;
				}
				try {
					Double.parseDouble(vb.getpValorApuesta().getText());
				} catch (NumberFormatException ex) {
					tmp = false;
				}

				if (tmp == true) {
					boolean tmp2 = false;
					for (int i = 0; i < dataApostador.getApostador().getListaApostador().size(); i++) {
						if (Long.parseLong(cedula) == dataApostador.getApostador().getListaApostador().get(i)
								.getCedula()) {
							sede = dataApostador.getApostador().getListaApostador().get(i).getSede();
							tmp2 = true;
						}
					}
					if (tmp2 == true) {
						aviso.mostrarInfo(ab.crearApuestaBaloto(sede, Long.parseLong(cedula),
								vb.getpDiaApuesta().getText(), Double.parseDouble(vb.getpValorApuesta().getText()),
								vb.getpNumeroApostado().getText()));

						aviso.mostrarInfo("Recibo: " + "\n" + "Nombre sede: " + sede + "\n" + " Cedula: " + cedula
								+ "\n" + " Dia apuesta: " + vb.getpDiaApuesta().getText() + "\n" + " Valor apuesta: "
								+ vb.getpValorApuesta().getText() + "\n" + " Numero apostado: "
								+ vb.getpNumeroApostado().getText());
					} else {
						aviso.mostrarInfo("Debe ingresar el número de cedula de un apostador existente");
						cedula = aviso.recibirInfo("Por favor, ingrese el número de cedula");
					}
				} else {
					aviso.mostrarInfo("Debe ingresar valores numéricos válidos.");
					cedula = aviso.recibirInfo("Por favor, ingrese el número de cedula");
				}

			} else {
				aviso.mostrarInfo("Debe completar los datos pedidos para realizar la apuesta");
				cedula = aviso.recibirInfo("Por favor, ingrese el número de cedula");
			}

			break;
		}
		/**
		 * Maneja la acción del botón "Modificar Baloto". Verifica la validez de los
		 * campos de entrada y realiza la modificación de una apuesta en el juego de
		 * Baloto. Muestra mensajes de aviso al usuario en caso de campos no válidos o
		 * éxito en la modificación.
		 */
		case "btnModificarBaloto": {
			if (!vb.getpDiaApuesta().getText().equals("") && !vb.getpValorApuesta().getText().equals("")
					&& !vb.getpNumeroApostado().getText().equals("") && !cedula.equals("") && !numApostado.equals("")) {
				// Validación de formatos de entrada
				boolean tmp = true;

				try {
					Long.parseLong(cedula);
				} catch (NumberFormatException ex) {
					tmp = false;
				}
				try {
					Double.parseDouble(vb.getpValorApuesta().getText());
				} catch (NumberFormatException ex) {
					tmp = false;
				}
				try {
					String temp = vb.getpNumeroApostado().getText();
					temp = temp.replaceAll("\\s+", "");
					Integer.parseInt(temp);
				} catch (NumberFormatException ex) {
					tmp = false;
				}
				try {
					numApostado = numApostado.replaceAll("\\s+", "");
					Integer.parseInt(numApostado);
				} catch (NumberFormatException ex) {
					tmp = false;
				}

				// Realiza la modificación si los formatos son válidos
				if (tmp == true) {
					// Obtiene la sede del apostador
					String sede = null;
					boolean tmp2 = false;
					for (int i = 0; i < dataApostador.getApostador().getListaApostador().size(); i++) {
						if (Long.parseLong(cedula) == dataApostador.getApostador().getListaApostador().get(i)
								.getCedula()) {
							sede = dataApostador.getApostador().getListaApostador().get(i).getSede();
							tmp2 = true;
						}
					}
					if (tmp2 == true) {
						// Modifica la apuesta y muestra mensajes de aviso
						aviso.mostrarInfo(ab.modificarApuestaBaloto(sede, Long.parseLong(cedula),
								vb.getpDiaApuesta().getText(), Double.parseDouble(vb.getpValorApuesta().getText()),
								numApostado, vb.getpNumeroApostado().getText()));
						aviso.mostrarInfo("Apuesta modificada correctamente");
					} else {
						aviso.mostrarInfo("Debe ingresar el número de cedula de un apostador existente.");
						cedula = aviso.recibirInfo("Por favor, ingrese el número de cédula");
					}
				} else {
					// Muestra mensaje de aviso por campos no válidos y solicita nueva entrada
					aviso.mostrarInfo(
							"Debe ingresar valores válidos para cédula, antiguo número apostado, valor de la apuesta, número apostado y número de serie");
					cedula = aviso.recibirInfo("Por favor, ingrese el número de cédula");
					numApostado = aviso.recibirInfo(
							"Por favor, ingrese el número apostado de la apuesta que desea modificar (Ingrese los 6 números separados por un espacio cada uno, de la manera 1 2 3 4 5 6");
					vb.getpValorApuesta().setText(null);
					vb.getpNumeroApostado().setText(null);
				}

			} else {
				// Muestra mensaje de aviso por campos no válidos y solicita nueva entrada
				aviso.mostrarInfo("Debe ingresar valores válidos en los campos");
				cedula = aviso.recibirInfo("Por favor, ingrese el número de cédula");
				numApostado = aviso.recibirInfo(
						"Por favor, ingrese el número apostado de la apuesta que desea modificar (Ingrese los 6 números separados por un espacio cada uno, de la manera 1 2 3 4 5 6");
			}
			break;
		}

		/**
		 * Maneja la acción del botón "Flecha Baloto" para cambiar de vista. Oculta la
		 * vista actual (vb) y muestra la vista siguiente (ve). Limpia los campos de la
		 * vista actual.
		 */
		case "botonFlechaBaloto": {
			vb.setVisible(false);
			ve.setVisible(true);
			vb.getpDiaApuesta().setText(null);
			vb.getpNumeroApostado().setText(null);
			vb.getpValorApuesta().setText(null);
			break;

		}
		/**
		 * Maneja la acción de los botones relacionados con las apuestas en el juego de
		 * Superastro. Dependiendo de la elección realizada, muestra la vista
		 * correspondiente y realiza las operaciones adecuadas. Elecciones posibles: 1 -
		 * Apostar: Muestra la vista de apuestas con la opción de apostar. 2 -
		 * Modificar: Muestra la vista de apuestas con la opción de modificar una
		 * apuesta existente. 3 - Eliminar: Solicita el número de cédula y número
		 * apostado, y elimina la apuesta correspondiente. 4 - Leer: Muestra la
		 * información de todas las apuestas de Superastro.
		 */
		case "BotonApostarSuperastro": {
			if (eleccion == 1) {
				vsa.setVisible(true);
				cedula = aviso.recibirInfo("Por favor, ingrese el número de cedula");
				vsa.getBotonApostar().setVisible(true);
				vsa.getBotonModificar().setVisible(false);
				vsa.getBotonEliminar().setVisible(false);
			} else if (eleccion == 2) {
				vsa.setVisible(true);
				cedula = aviso.recibirInfo("Por favor, ingrese el número de cedula");
				numApostado = aviso
						.recibirInfo("Por favor, ingrese el número apostado de la apuesta que desea modificar");
				vsa.getBotonModificar().setVisible(true);
				vsa.getBotonApostar().setVisible(false);
				vsa.getBotonEliminar().setVisible(false);
			} else if (eleccion == 3) {
				cedula = aviso.recibirInfo("Por favor, ingrese el número de cedula");
				numApostado = aviso
						.recibirInfo("Por favor, ingrese el número apostado de la apuesta que desea eliminar");
				if (!cedula.equals("") && !numApostado.equals("")) {
					boolean tmp = true;
					try {
						Long.parseLong(cedula);
					} catch (NumberFormatException ex) {
						tmp = false;
					}
					try {
						Integer.parseInt(numApostado);
					} catch (NumberFormatException ex) {
						tmp = false;
					}
					if (tmp == true) {
						as.eliminarApuestaSuperastro(Long.parseLong(cedula), Integer.parseInt(numApostado));
						aviso.mostrarInfo("Apuesta eliminada correctamente");
					}
				}
				vsa.getBotonModificar().setVisible(false);
				vsa.getBotonApostar().setVisible(false);
				vsa.getBotonEliminar().setVisible(true);
			} else if (eleccion == 4) {
				aviso.mostrarInfo(as.leerApuestaSuperastro());
			}
			break;

		}
		/**
		 * Maneja la acción del botón "Apostar Superastro". Verifica la validez de los
		 * campos de entrada y realiza la apuesta en el juego de Superastro. Muestra un
		 * mensaje de recibo con los detalles de la apuesta realizada.
		 */
		case "btnApostarSuperastro": {
			String sede = "";

			// Verifica que los campos de entrada no estén vacíos
			if (!vsa.getpDiaApuesta().getText().equals("") && !vsa.getpValorApuesta().getText().equals("")
					&& !vsa.getpNumeroApostado().getText().equals("") && !cedula.equals("")) {

				boolean tmp = true;

				// Realiza validaciones de formato para los campos numéricos
				try {
					Double.parseDouble(vsa.getpValorApuesta().getText());
				} catch (NumberFormatException ex) {
					tmp = false;
				}
				try {
					Long.parseLong(cedula);
				} catch (NumberFormatException ex) {
					tmp = false;
				}
				try {
					Integer.parseInt(vsa.getpNumeroApostado().getText());
				} catch (NumberFormatException ex) {
					tmp = false;
				}

				// Si los formatos son válidos, procede a realizar la apuesta
				if (tmp == true) {
					// Obtiene la sede del apostador
					boolean tmp2 = false;
					for (int i = 0; i < dataApostador.getApostador().getListaApostador().size(); i++) {
						if (Long.parseLong(cedula) == dataApostador.getApostador().getListaApostador().get(i)
								.getCedula()) {
							sede = dataApostador.getApostador().getListaApostador().get(i).getSede();
							tmp2 = true;
						}
					}
					if (tmp2 == true) {
						// Crea la apuesta en el juego de Superastro
						as.crearApuestaSuperastro(sede, Long.parseLong(cedula), vsa.getpDiaApuesta().getText(),
								Double.parseDouble(vsa.getpValorApuesta().getText()),
								vsa.getSignoZodical().getSelectedItem().toString(),
								Integer.parseInt(vsa.getpNumeroApostado().getText()));

						// Muestra un mensaje de recibo con los detalles de la apuesta
						aviso.mostrarInfo("Recibo: " + "\n" + "Nombre sede: " + sede + "\n" + " Cedula: " + cedula
								+ "\n" + " Dia apuesta: " + vsa.getpDiaApuesta().getText() + "\n" + " Valor apuesta: "
								+ vsa.getpValorApuesta().getText() + "\n" + " Signo del zodiaco: "
								+ vsa.getSignoZodical().getSelectedItem().toString() + "\n" + " Numero apostado: "
								+ vsa.getpNumeroApostado().getText());
					} else {
						aviso.mostrarInfo("Debe ingresar el número de cédula de un apostador existente");
						cedula = aviso.recibirInfo("Por favor, ingrese el número de cedula");
					}
				} else {
					// Muestra un mensaje de aviso por valores numéricos no válidos
					aviso.mostrarInfo("Debe ingresar valores numéricos válidos.");
					cedula = aviso.recibirInfo("Por favor, ingrese el número de cedula");
				}

			} else {
				// Muestra un mensaje de aviso por campos incompletos y solicita nueva entrada
				aviso.mostrarInfo("Debe completar los datos pedidos para realizar la apuesta");
				cedula = aviso.recibirInfo("Por favor, ingrese el número de cedula");
			}

			break;
		}

		/**
		 * Maneja la acción del botón "Modificar Superastro". Verifica la validez de los
		 * campos de entrada y realiza la modificación de una apuesta en el juego de
		 * Superastro. Muestra un mensaje de recibo con los detalles de la apuesta
		 * modificada.
		 */
		case "btnModificarSuperastro": {
			String sede = "";

			// Verifica que los campos de entrada no estén vacíos
			if (!vsa.getpDiaApuesta().getText().equals("") && !vsa.getpValorApuesta().getText().equals("")
					&& !vsa.getpNumeroApostado().getText().equals("") && !cedula.equals("")
					&& !numApostado.equals("")) {

				boolean tmp = true;

				// Realiza validaciones de formato para los campos numéricos
				try {
					Double.parseDouble(vsa.getpValorApuesta().getText());
				} catch (NumberFormatException ex) {
					tmp = false;
				}
				try {
					Long.parseLong(cedula);
				} catch (NumberFormatException ex) {
					tmp = false;
				}
				try {
					Integer.parseInt(vsa.getpNumeroApostado().getText());
				} catch (NumberFormatException ex) {
					tmp = false;
				}

				// Si los formatos son válidos, procede a realizar la modificación
				if (tmp == true) {
					// Obtiene la sede del apostador
					boolean tmp2 = false;
					boolean tmp3 = false;
					for (int i = 0; i < dataApostador.getApostador().getListaApostador().size(); i++) {
						if (Long.parseLong(cedula) == dataApostador.getApostador().getListaApostador().get(i)
								.getCedula()) {
							sede = dataApostador.getApostador().getListaApostador().get(i).getSede();
							tmp2 = true;
						}
					}
					for (int i = 0; i < as.getApuestaSuperastro().getApuestasSuperastro().size(); i++) {
						if (Integer.parseInt(numApostado) == as.getApuestaSuperastro().getApuestasSuperastro().get(i)
								.getNumeroApostado()) {
							tmp3 = true;
						}
					}
					if (tmp2 == true && tmp3 == true) {
						// Modifica la apuesta en el juego de Superastro
						as.modificarApuestaSuperastro(sede, Long.parseLong(cedula), vsa.getpDiaApuesta().getText(),
								Integer.parseInt(numApostado), Double.parseDouble(vsa.getpValorApuesta().getText()),
								vsa.getSignoZodical().getSelectedItem().toString(),
								Integer.parseInt(vsa.getpNumeroApostado().getText()));

						// Muestra un mensaje de recibo con los detalles de la apuesta modificada
						aviso.mostrarInfo("Recibo: " + "\n" + "Nombre sede: " + sede + "\n" + " Cedula: " + cedula
								+ "\n" + " Dia apuesta: " + vsa.getpDiaApuesta().getText() + "\n" + " Valor apuesta: "
								+ vsa.getpValorApuesta().getText() + "\n" + " Signo del zodiaco: "
								+ vsa.getSignoZodical().getSelectedItem().toString() + "\n" + " Numero apostado: "
								+ vsa.getpNumeroApostado().getText());
					} else {
						aviso.mostrarInfo(
								"Error, la cedula ingresada o el número antiguo apostado no coinciden con alguna apuesta, por favor, ingrese de nuevo los datos");
						cedula = aviso.recibirInfo("Por favor, ingrese el número de cedula");
						numApostado = aviso
								.recibirInfo("Por favor, ingrese el número apostado, de la apuesta a modificar");
					}
				} else {
					// Muestra un mensaje de aviso por valores numéricos no válidos
					aviso.mostrarInfo("Debe ingresar valores numéricos válidos.");
					cedula = aviso.recibirInfo("Por favor, ingrese el número de cedula");
				}

			} else {
				// Muestra un mensaje de aviso por campos incompletos y solicita nueva entrada
				aviso.mostrarInfo("Debe completar los datos pedidos para realizar la modificación");
				cedula = aviso.recibirInfo("Por favor, ingrese el número de cedula");
			}

			break;
		}

		/**
		 * Maneja la acción del botón "Flecha Superastro" para cambiar de vista. Oculta
		 * la vista actual (vsa) y muestra la vista siguiente (ve). Limpia los campos de
		 * la vista actual.
		 */
		case "botonFlechaSuperastro": {
			// Oculta la vista actual
			vsa.setVisible(false);

			// Muestra la vista siguiente
			ve.setVisible(true);

			// Limpia los campos de la vista actual
			vsa.getpDiaApuesta().setText(null);
			vsa.getpNumeroApostado().setText(null);
			vsa.getpValorApuesta().setText(null);
			break;
		}

		/**
		 * Maneja la acción de los botones relacionados con las apuestas en el juego de
		 * Betplay. Dependiendo de la elección realizada, muestra la vista
		 * correspondiente y realiza las operaciones adecuadas. Elecciones posibles: 1 -
		 * Apostar: Muestra la vista de apuestas con la opción de apostar. 2 -
		 * Modificar: Muestra la vista de apuestas con la opción de modificar una
		 * apuesta existente. 3 - Eliminar: Solicita el número de cédula y día de la
		 * semana, y elimina la apuesta correspondiente. 4 - Leer: Muestra la
		 * información de todas las apuestas de Betplay.
		 */
		case "BotonApostarBetplay": {
			if (eleccion == 1) {
				// Muestra la vista de Betplay para apostar
				vbp.setVisible(true);

				// Limpia los campos de la vista
				vbp.getpDiaApuesta().setText(null);
				vbp.getpValorApuesta().setText(null);

				// Solicita el número de cédula al usuario
				cedula = aviso.recibirInfo("Por favor, ingrese el número de cedula");

				// Configura la visibilidad de los botones en la vista
				vbp.getBotonApostar().setVisible(true);
				vbp.getBotonModificar().setVisible(false);
				vbp.getBotonEliminar().setVisible(false);
			} else if (eleccion == 2) {
				// Limpia los campos de la vista
				vbp.getpDiaApuesta().setText(null);
				vbp.getpValorApuesta().setText(null);

				// Muestra la vista de Betplay para modificar una apuesta existente
				vbp.setVisible(true);

				// Solicita el número de cédula al usuario
				cedula = aviso.recibirInfo("Por favor, ingrese el número de cedula");

				// Solicita el día de la semana al usuario
				numApostado = aviso
						.recibirInfo("Por favor ingrese el día de la semana en el que hizo la apuesta a modificar");

				// Configura la visibilidad de los botones en la vista
				vbp.getBotonModificar().setVisible(true);
				vbp.getBotonApostar().setVisible(false);
				vbp.getBotonEliminar().setVisible(false);
			} else if (eleccion == 3) {
				// Verificación de número de cédula
				boolean verificacion = true;
				cedula = aviso.recibirInfo("Por favor, ingrese el número de cedula");
				numApostado = aviso
						.recibirInfo("Por favor ingrese el día de la semana en el que hizo la apuesta a eliminar");

				try {
					Long.parseLong(cedula);
				} catch (NumberFormatException ex) {
					verificacion = false;
				}

				// Elimina la apuesta de Betplay si la verificación es válida
				if (verificacion == true) {
					abp.eliminarApuestaBetplay(Long.parseLong(cedula), numApostado);
				}

				// Configura la visibilidad de los botones en la vista
				vbp.getBotonModificar().setVisible(false);
				vbp.getBotonApostar().setVisible(false);
				vbp.getBotonEliminar().setVisible(true);
			} else if (eleccion == 4) {
				// Muestra la información de todas las apuestas de Betplay
				aviso.mostrarInfoLarga(abp.leerApuestaBetplay());
			}
			break;
		}
		/**
		 * Maneja la acción del botón "Apostar Betplay". Verifica que se haya ingresado
		 * la cédula, el día de la apuesta y el valor de la apuesta. Realiza
		 * validaciones de formato para los valores numéricos. Si todas las validaciones
		 * son exitosas, realiza la apuesta en Betplay y muestra un mensaje de recibo.
		 * Muestra mensajes de aviso si hay errores en la entrada.
		 */
		case "btnApostarBetplay": {
			// Verifica que se haya ingresado la cédula, el día de la apuesta y el valor de
			// la apuesta
			if (!cedula.equals("") && !vbp.getpDiaApuesta().getText().equals("")
					&& !vbp.getpValorApuesta().getText().equals("")) {
				boolean tmp = true;
				String sede = null;

				// Realiza validaciones de formato para los valores numéricos
				try {
					Double.parseDouble(vbp.getpValorApuesta().getText());
				} catch (NumberFormatException ex) {
					tmp = false;
				}

				try {
					Long.parseLong(cedula);
				} catch (NumberFormatException ex) {
					tmp = false;
				}

				// Si todas las validaciones son exitosas, realiza la apuesta en Betplay
				if (tmp == true) {
					// Obtiene la sede del apostador
					boolean tmp2 = false;
					for (int i = 0; i < dataApostador.getApostador().getListaApostador().size(); i++) {
						if (Long.parseLong(cedula) == dataApostador.getApostador().getListaApostador().get(i)
								.getCedula()) {
							sede = dataApostador.getApostador().getListaApostador().get(i).getSede();
							tmp2 = true;
						}
					}
					if (tmp2 == true) {
						// Realiza la apuesta en Betplay
						aviso.mostrarInfo(abp.crearApuestaBetplay(sede, Long.parseLong(cedula),
								vbp.getpDiaApuesta().getText(), Double.parseDouble(vbp.getpValorApuesta().getText()),
								vbp.getSantafeMillonarios().getSelectedItem().toString(),
								vbp.getNacionalMedellin().getSelectedItem().toString(),
								vbp.getAmericaCali().getSelectedItem().toString(),
								vbp.getJuniorUnion().getSelectedItem().toString(),
								vbp.getCucutaBucaramanga().getSelectedItem().toString(),
								vbp.getPereiraOnce().getSelectedItem().toString(),
								vbp.getAguilasEnvigado().getSelectedItem().toString(),
								vbp.getPatriotasChico().getSelectedItem().toString(),
								vbp.getTolimaHuila().getSelectedItem().toString(),
								vbp.getBarcelonaMadrid().getSelectedItem().toString(),
								vbp.getArsenalChelsea().getSelectedItem().toString(),
								vbp.getUnitedCity().getSelectedItem().toString(),
								vbp.getLiverpoolEverton().getSelectedItem().toString(),
								vbp.getBayernBorussia().getSelectedItem().toString()));

						aviso.mostrarInfo("Apuesta realizada correctamente");
						// Muestra un mensaje de recibo con los detalles de la apuesta realizada
						aviso.mostrarInfo("Recibo: " + "\n" + "Nombre sede: " + sede + "\n" + " Cedula: " + cedula
								+ "\n" + " Dia apuesta: " + vbp.getpDiaApuesta().getText() + "\n" + " Valor apuesta: "
								+ vbp.getpValorApuesta().getText() + "\n" + " Partido 1: "
								+ vbp.getSantafeMillonarios().getSelectedItem().toString() + "\n" + " Partido 2: "
								+ vbp.getNacionalMedellin().getSelectedItem().toString() + "\n" + " Partido 3: "
								+ vbp.getAmericaCali().getSelectedItem().toString() + "\n" + " Partido 4: "
								+ vbp.getJuniorUnion().getSelectedItem().toString() + "\n" + " Partido 5: "
								+ vbp.getCucutaBucaramanga().getSelectedItem().toString() + "\n" + " Partido 6: "
								+ vbp.getPereiraOnce().getSelectedItem().toString() + "\n" + " Partido 7: "
								+ vbp.getAguilasEnvigado().getSelectedItem().toString() + "\n" + " Partido 8: "
								+ vbp.getPatriotasChico().getSelectedItem().toString() + "\n" + " Partido 9: "
								+ vbp.getTolimaHuila().getSelectedItem().toString() + "\n" + " Partido 10: "
								+ vbp.getBarcelonaMadrid().getSelectedItem().toString() + "\n" + " Partido 11: "
								+ vbp.getArsenalChelsea().getSelectedItem().toString() + "\n" + " Partido 12: "
								+ vbp.getUnitedCity().getSelectedItem().toString() + "\n" + " Partido 13: "
								+ vbp.getLiverpoolEverton().getSelectedItem().toString() + "\n" + " Partido 14: "
								+ vbp.getBayernBorussia().getSelectedItem().toString());

					} else {
						aviso.mostrarInfo("Debe ingresar la cedula de un apostador existente");
					}
				} else {
					// Muestra un mensaje de aviso por valores numéricos no válidos
					aviso.mostrarInfo("Debe ingresar valores numéricos válidos.");
					cedula = aviso.recibirInfo("Por favor, ingrese el número de cedula");
				}

			} else {
				// Muestra un mensaje de aviso por campos incompletos y solicita nueva entrada
				aviso.mostrarInfo("Debe llenar todos los datos.");
				cedula = aviso.recibirInfo("Por favor, ingrese el número de cedula");
			}
			break;
		}

		/**
		 * Maneja la acción del botón "Modificar Betplay". Verifica que se haya
		 * ingresado la cédula, el día de la apuesta, el valor de la apuesta y el número
		 * de apuesta a modificar. Realiza validaciones de formato para los valores
		 * numéricos. Si todas las validaciones son exitosas, modifica la apuesta en
		 * Betplay y muestra un mensaje de recibo modificado. Muestra mensajes de aviso
		 * si hay errores en la entrada.
		 */
		case "btnModificarBetplay": {
			// Verifica que se haya ingresado la cédula, el día de la apuesta, el valor de
			// la apuesta y el número de apuesta a modificar
			if (!cedula.equals("") && !vbp.getpDiaApuesta().getText().equals("")
					&& !vbp.getpValorApuesta().getText().equals("") && !numApostado.equals("")) {
				boolean tmp = true;
				String sede = null;

				// Realiza validaciones de formato para los valores numéricos
				try {
					Double.parseDouble(vbp.getpValorApuesta().getText());
				} catch (NumberFormatException ex) {
					tmp = false;
				}

				try {
					Long.parseLong(cedula);
				} catch (NumberFormatException ex) {
					tmp = false;
				}

				// Si todas las validaciones son exitosas, modifica la apuesta en Betplay
				if (tmp == true) {
					// Obtiene la sede del apostador
					boolean tmp2 = false;
					boolean tmp3 = false;
					for (int i = 0; i < dataApostador.getApostador().getListaApostador().size(); i++) {
						if (Long.parseLong(cedula) == dataApostador.getApostador().getListaApostador().get(i)
								.getCedula()) {
							sede = dataApostador.getApostador().getListaApostador().get(i).getSede();
							tmp2 = true;
						}
					}
					for (int i = 0; i < abp.getApuestaBetplay().getApuestaBetplay().size(); i++) {
						if (numApostado
								.equalsIgnoreCase(abp.getApuestaBetplay().getApuestaBetplay().get(i).getDiaApuesta())) {

							tmp3 = true;
						}
					}
					if (tmp2 == true && tmp3 == true) {
						// Modifica la apuesta en Betplay
						aviso.mostrarInfo(abp.modificarApuestaBetplay(sede, Long.parseLong(cedula), numApostado,
								vbp.getpDiaApuesta().getText(), Double.parseDouble(vbp.getpValorApuesta().getText()),
								vbp.getSantafeMillonarios().getSelectedItem().toString(),
								vbp.getNacionalMedellin().getSelectedItem().toString(),
								vbp.getAmericaCali().getSelectedItem().toString(),
								vbp.getJuniorUnion().getSelectedItem().toString(),
								vbp.getCucutaBucaramanga().getSelectedItem().toString(),
								vbp.getPereiraOnce().getSelectedItem().toString(),
								vbp.getAguilasEnvigado().getSelectedItem().toString(),
								vbp.getPatriotasChico().getSelectedItem().toString(),
								vbp.getTolimaHuila().getSelectedItem().toString(),
								vbp.getBarcelonaMadrid().getSelectedItem().toString(),
								vbp.getArsenalChelsea().getSelectedItem().toString(),
								vbp.getUnitedCity().getSelectedItem().toString(),
								vbp.getLiverpoolEverton().getSelectedItem().toString(),
								vbp.getBayernBorussia().getSelectedItem().toString()));

						aviso.mostrarInfo("Apuesta modificada correctamente");
						// Muestra un mensaje de recibo modificado con los detalles de la apuesta
						aviso.mostrarInfo("Recibo Modificado: " + "\n" + "Nombre sede: " + sede + "\n" + " Cedula: "
								+ cedula + "\n" + " Dia apuesta: " + vbp.getpDiaApuesta().getText() + "\n"
								+ " Valor apuesta: " + vbp.getpValorApuesta().getText() + "\n" + " Partido 1: "
								+ vbp.getSantafeMillonarios().getSelectedItem().toString() + "\n" + " Partido 2: "
								+ vbp.getNacionalMedellin().getSelectedItem().toString() + "\n" + " Partido 3: "
								+ vbp.getAmericaCali().getSelectedItem().toString() + "\n" + " Partido 4: "
								+ vbp.getJuniorUnion().getSelectedItem().toString() + "\n" + " Partido 5: "
								+ vbp.getCucutaBucaramanga().getSelectedItem().toString() + "\n" + " Partido 6: "
								+ vbp.getPereiraOnce().getSelectedItem().toString() + "\n" + " Partido 7: "
								+ vbp.getAguilasEnvigado().getSelectedItem().toString() + "\n" + " Partido 8: "
								+ vbp.getPatriotasChico().getSelectedItem().toString() + "\n" + " Partido 9: "
								+ vbp.getTolimaHuila().getSelectedItem().toString() + "\n" + " Partido 10: "
								+ vbp.getBarcelonaMadrid().getSelectedItem().toString() + "\n" + " Partido 11: "
								+ vbp.getArsenalChelsea().getSelectedItem().toString() + "\n" + " Partido 12: "
								+ vbp.getUnitedCity().getSelectedItem().toString() + "\n" + " Partido 13: "
								+ vbp.getLiverpoolEverton().getSelectedItem().toString() + "\n" + " Partido 14: "
								+ vbp.getBayernBorussia().getSelectedItem().toString());

					} else {
						aviso.mostrarInfo(
								"Error, el número de cedula o el dia de la apuesta ingresado no coinciden con alguna apuesta creada, por favor, ingrese de nuevo los datos.");
						cedula = aviso.recibirInfo("Por favor, ingrese el número de cedula");
						numApostado = aviso
								.recibirInfo("Por favor ingrese el dia en el que se realizó la apuesta a modificar");
					}
				} else {
					// Muestra un mensaje de aviso por valores numéricos no válidos
					aviso.mostrarInfo("Debe ingresar valores numéricos válidos.");
					cedula = aviso.recibirInfo("Por favor, ingrese el número de cedula");
					numApostado = aviso
							.recibirInfo("Por favor ingrese el dia en el que se realizó la apuesta a modificar");
				}

			} else {
				// Muestra un mensaje de aviso por campos incompletos y solicita nueva entrada
				aviso.mostrarInfo("Debe llenar todos los datos.");
				cedula = aviso.recibirInfo("Por favor, ingrese el número de cedula");
				numApostado = aviso.recibirInfo("Por favor ingrese el dia en el que se realizó la apuesta a modificar");
			}
			break;
		}

		/**
		 * Maneja la acción del botón "Flecha Betplay". Oculta la ventana de apuestas
		 * Betplay y muestra la ventana principal. Limpia los campos de día de apuesta y
		 * valor de apuesta en Betplay.
		 */
		case "botonFlechaBetplay": {
			// Oculta la ventana de apuestas Betplay y muestra la ventana principal
			vbp.setVisible(false);
			ve.setVisible(true);

			// Limpia los campos de día de apuesta y valor de apuesta en Betplay
			vbp.getpDiaApuesta().setText(null);
			vbp.getpValorApuesta().setText(null);
			break;
		}

		/**
		 * Maneja la acción del botón "Apostar Chance". Realiza diferentes acciones
		 * según la opción de elección: - Elección 1: Muestra la ventana de apuestas
		 * Chance y configura botones visibles. - Elección 2: Muestra la ventana de
		 * apuestas Chance y configura botones visibles y oculta la ventana principal. -
		 * Elección 3: Elimina la apuesta Chance según la cédula y número apostado
		 * previamente ingresados. - Elección 4: Lee y muestra las apuestas Chance.
		 */
		case "BotonApostarChance": {
			if (eleccion == 1) {
				// Elección 1: Muestra la ventana de apuestas Chance y configura botones
				// visibles
				vc.setVisible(true);
				cedula = aviso.recibirInfo("Por favor, ingrese el número de cedula");
				vc.getBotonApostar().setVisible(true);
				vc.getBotonModificar().setVisible(false);
				vc.getBotonEliminar().setVisible(false);
			} else if (eleccion == 2) {
				// Elección 2: Muestra la ventana de apuestas Chance y configura botones
				// visibles y oculta la ventana principal
				vc.setVisible(true);
				ve.setVisible(false);
				cedula = aviso.recibirInfo("Por favor, ingrese el número de cedula");
				numApostado = aviso.recibirInfo("Por favor, ingrese el número apostado anteriormente");
				vc.getBotonModificar().setVisible(true);
				vc.getBotonApostar().setVisible(false);
				vc.getBotonEliminar().setVisible(false);
			} else if (eleccion == 3) {
				// Elección 3: Elimina la apuesta Chance según la cédula y número apostado
				// previamente ingresados
				cedula = aviso.recibirInfo("Por favor, ingrese el número de cedula");
				numApostado = aviso.recibirInfo("Por favor, ingrese el número apostado anteriormente");

				if (!cedula.equals("") && !numApostado.equals("")) {
					boolean tmp = true;
					try {
						Long.parseLong(cedula);
					} catch (NumberFormatException ex) {
						tmp = false;
					}
					try {
						Integer.parseInt(numApostado);
					} catch (NumberFormatException ex) {
						tmp = false;
					}
					if (tmp == true) {
						ac.eliminarApuestaChance(Long.parseLong(cedula), Integer.parseInt(numApostado));
						aviso.mostrarInfo("Apuesta eliminada correctamente");
					}
				}

				// Configura visibilidad de botones en la ventana de apuestas Chance
				vc.getBotonModificar().setVisible(false);
				vc.getBotonApostar().setVisible(false);
				vc.getBotonEliminar().setVisible(true);
			} else if (eleccion == 4) {
				// Elección 4: Lee y muestra las apuestas Chance
				aviso.mostrarInfo(ac.leerApuestaChance());
			}
			break;
		}

		/**
		 * Maneja la acción del botón "Apostar Chance". Realiza las siguientes acciones:
		 * - Verifica que los campos obligatorios no estén vacíos y que contengan
		 * valores válidos. - Recupera la sede del apostador. - Crea una nueva apuesta
		 * de Chance con los datos proporcionados. - Muestra un recibo con la
		 * información de la apuesta realizada. - En caso de valores no válidos,
		 * solicita nuevamente el número de cédula. - Si algún campo está vacío,
		 * solicita completar los datos para realizar la apuesta.
		 */
		case "btnApostarChance": {
			// Variable para almacenar la sede
			String sede = "";

			// Verifica que los campos obligatorios no estén vacíos y que contengan valores
			// válidos
			if (!vc.getpDiaApuesta().getText().equals("") && !vc.getpValorApuesta().getText().equals("")
					&& !vc.getpNumeroApostado().getText().equals("") && !vc.getpNombreLoteria().getText().equals("")
					&& !cedula.equals("")) {
				boolean tmp = true;

				// Verifica la validez de los valores numéricos ingresados
				try {
					Double.parseDouble(vc.getpValorApuesta().getText());
				} catch (NumberFormatException ex) {
					tmp = false;
				}
				try {
					Long.parseLong(cedula);
				} catch (NumberFormatException ex) {
					tmp = false;
				}
				try {
					Integer.parseInt(vc.getpNumeroApostado().getText());
				} catch (NumberFormatException ex) {
					tmp = false;
				}

				if (tmp == true) {
					// Recupera la sede del apostador
					boolean tmp2 = false;
					for (int i = 0; i < dataApostador.getApostador().getListaApostador().size(); i++) {
						if (Long.parseLong(cedula) == dataApostador.getApostador().getListaApostador().get(i)
								.getCedula()) {
							sede = dataApostador.getApostador().getListaApostador().get(i).getSede();
							tmp2 = true;
						}
					}
					if (tmp2 == true) {
						// Crea una nueva apuesta de Chance con los datos proporcionados
						ac.crearApuestaChance(sede, Long.parseLong(cedula), vc.getpDiaApuesta().getText(),
								Double.parseDouble(vc.getpValorApuesta().getText()), vc.getpNombreLoteria().getText(),
								Integer.parseInt(vc.getpNumeroApostado().getText()));

						// Muestra un recibo con la información de la apuesta realizada
						aviso.mostrarInfo("Recibo: " + "\n" + "Nombre sede: " + sede + "\n" + " Cedula: " + cedula
								+ "\n" + " Dia apuesta: " + vc.getpDiaApuesta().getText() + "\n" + " Valor apuesta: "
								+ vc.getpValorApuesta().getText() + "\n" + " Nombre de la loteria: "
								+ vc.getpNombreLoteria().getText() + "\n" + " Numero apostado: "
								+ vc.getpNumeroApostado().getText());
					} else {
						aviso.mostrarInfo("Debe ingresar el número de cedula de un apostador existente.");
						cedula = aviso.recibirInfo("Por favor, ingrese el número de cedula");
					}
				} else {
					// En caso de valores no válidos, solicita nuevamente el número de cédula
					aviso.mostrarInfo("Debe ingresar valores numericos validos.");
					cedula = aviso.recibirInfo("Por favor, ingrese el número de cedula");
				}
			} else {
				// Si algún campo está vacío, solicita completar los datos para realizar la
				// apuesta
				aviso.mostrarInfo("Debe completar los datos pedidos para realizar la apuesta");
				cedula = aviso.recibirInfo("Por favor, ingrese el número de cedula");
			}

			break;
		}
		/**
		 * Maneja la acción del botón "Modificar Chance". Realiza las siguientes
		 * acciones: - Verifica que los campos obligatorios no estén vacíos y que
		 * contengan valores válidos. - Recupera la sede del apostador. - Modifica una
		 * apuesta de Chance existente con los datos proporcionados. - Muestra un recibo
		 * con la información de la apuesta modificada. - En caso de valores no válidos,
		 * solicita nuevamente el número de cédula. - Si algún campo está vacío,
		 * solicita completar los datos para realizar la modificación.
		 */
		case "btnModificarChance": {
			// Variable para almacenar la sede
			String sede = "";

			// Verifica que los campos obligatorios no estén vacíos y que contengan valores
			// válidos
			if (!vc.getpDiaApuesta().getText().equals("") && !vc.getpValorApuesta().getText().equals("")
					&& !vc.getpNumeroApostado().getText().equals("") && !vc.getpNombreLoteria().getText().equals("")
					&& !cedula.equals("") && !numApostado.equals("")) {
				boolean tmp = true;

				// Verifica la validez de los valores numéricos ingresados
				try {
					Double.parseDouble(vc.getpValorApuesta().getText());
				} catch (NumberFormatException ex) {
					tmp = false;
				}
				try {
					Long.parseLong(cedula);
				} catch (NumberFormatException ex) {
					tmp = false;
				}
				try {
					Integer.parseInt(vc.getpNumeroApostado().getText());
				} catch (NumberFormatException ex) {
					tmp = false;
				}
				try {
					Integer.parseInt(numApostado);
				} catch (NumberFormatException ex) {
					tmp = false;
				}

				if (tmp == true) {
					// Recupera la sede del apostador
					boolean tmp2 = false;
					boolean tmp3 = false;
					for (int i = 0; i < dataApostador.getApostador().getListaApostador().size(); i++) {
						if (Long.parseLong(cedula) == dataApostador.getApostador().getListaApostador().get(i)
								.getCedula()) {
							sede = dataApostador.getApostador().getListaApostador().get(i).getSede();
							tmp2 = true;
						}
					}
					for (int i = 0; i < ac.getApuestaChance().getApuestasChance().size(); i++) {
						if (Integer.parseInt(numApostado) == ac.getApuestaChance().getApuestasChance().get(i)
								.getNumeroApostado()) {
							tmp3 = true;
						}
					}
					if (tmp2 == true && tmp3 == true) {
						// Modifica una apuesta de Chance existente con los datos proporcionados
						ac.modificarApuestaChance(sede, Long.parseLong(cedula), vc.getpDiaApuesta().getText(),
								Integer.parseInt(numApostado), Double.parseDouble(vc.getpValorApuesta().getText()),
								vc.getpNombreLoteria().getText(), Integer.parseInt(vc.getpNumeroApostado().getText()));

						// Muestra un recibo con la información de la apuesta modificada
						aviso.mostrarInfo("Recibo: " + "\n" + "Nombre sede: " + sede + "\n" + " Cedula: " + cedula
								+ "\n" + " Dia apuesta: " + vc.getpDiaApuesta().getText() + "\n" + " Valor apuesta: "
								+ vc.getpValorApuesta().getText() + "\n" + " Nombre de la loteria: "
								+ vc.getpNombreLoteria().getText() + "\n" + " Numero apostado: "
								+ vc.getpNumeroApostado().getText());
					} else {
						aviso.mostrarInfo(
								"Error, el número de cedula o el numero apostado antiguo ingresado, no coincide con alguna apuesta realizada, por favor, ingrese los datos de nuevo");
						cedula = aviso.recibirInfo("Por favor, ingrese el número de cedula");
						numApostado = aviso.recibirInfo("Por favor, ingrese el número apostado de la apuesta a modificar");
					}
				} else {
					// En caso de valores no válidos, solicita nuevamente el número de cédula
					aviso.mostrarInfo("Debe ingresar valores numericos validos.");
					cedula = aviso.recibirInfo("Por favor, ingrese el número de cedula");
					numApostado = aviso.recibirInfo("Por favor, ingrese el número apostado de la apuesta a modificar");
				}

			} else {
				// Si algún campo está vacío, solicita completar los datos para realizar la
				// modificación
				aviso.mostrarInfo("Debe completar los datos pedidos para realizar la apuesta");
				cedula = aviso.recibirInfo("Por favor, ingrese el número de cedula");
				numApostado = aviso.recibirInfo("Por favor, ingrese el número apostado de la apuesta a modificar");
			}

			break;
		}
		/**
		 * Maneja la acción del botón "Flecha Chance" en la interfaz principal. Realiza
		 * las siguientes acciones: - Oculta la vista de apuestas de Chance. - Muestra
		 * la vista principal de apuestas. - Limpia los campos de la vista de apuestas
		 * de Chance.
		 */
		case "botonFlechaChance": {
			// Oculta la vista de apuestas de Chance
			vc.setVisible(false);

			// Muestra la vista principal de apuestas
			ve.setVisible(true);

			// Limpia los campos de la vista de apuestas de Chance
			vc.getpDiaApuesta().setText(null);
			vc.getpNombreLoteria().setText(null);
			vc.getpNumeroApostado().setText(null);
			vc.getpValorApuesta().setText(null);

			break;
		}

		/**
		 * Maneja la acción del botón "Modificar Apuesta" en la interfaz principal.
		 * Realiza las siguientes acciones: - Configura la elección como 2 (modificar
		 * apuesta). - Ajusta la visibilidad de los botones en la interfaz principal. -
		 * Habilita los botones específicos para cada tipo de apuesta.
		 */
		case "BotonModificarApuesta": {
			// Configura la elección como 2 (modificar apuesta)
			eleccion = 2;

			// Ajusta la visibilidad de los botones en la interfaz principal
			ve.getBotonCrearApuesta().setVisible(false);
			ve.getBotonLeerApuestas().setVisible(false);
			ve.getBotonModificarApuesta().setVisible(false);
			ve.getBotonEliminarApuestas().setVisible(false);
			ve.getBotonLoteria().setVisible(true);
			ve.getBotonBaloto().setVisible(true);
			ve.getBotonSuperastro().setVisible(true);
			ve.getBotonBetplay().setVisible(true);
			ve.getBotonChance().setVisible(true);
			ve.getFlecha3().setVisible(true);
			ve.getFlecha2().setVisible(false);

			break;
		}
		/**
		 * Maneja la acción del botón "Eliminar Apuesta" en la interfaz principal.
		 * Realiza las siguientes acciones: - Configura la elección como 3 (eliminar
		 * apuesta). - Ajusta la visibilidad de los botones en la interfaz principal. -
		 * Habilita los botones específicos para cada tipo de apuesta.
		 */
		case "BotonEliminarApuesta": {
			// Configura la elección como 3 (eliminar apuesta)
			eleccion = 3;

			// Ajusta la visibilidad de los botones en la interfaz principal
			ve.getBotonCrearApuesta().setVisible(false);
			ve.getBotonLeerApuestas().setVisible(false);
			ve.getBotonModificarApuesta().setVisible(false);
			ve.getBotonEliminarApuestas().setVisible(false);
			ve.getBotonLoteria().setVisible(true);
			ve.getBotonBaloto().setVisible(true);
			ve.getBotonSuperastro().setVisible(true);
			ve.getBotonBetplay().setVisible(true);
			ve.getBotonChance().setVisible(true);
			ve.getFlecha3().setVisible(true);
			ve.getFlecha2().setVisible(false);

			break;
		}

		/**
		 * Maneja la acción del botón "Leer Apuesta" en la interfaz principal. Realiza
		 * las siguientes acciones: - Configura la elección como 4 (leer apuesta). -
		 * Ajusta la visibilidad de los botones en la interfaz principal. - Habilita los
		 * botones específicos para cada tipo de apuesta.
		 */
		case "BotonLeerApuesta": {
			// Configura la elección como 4 (leer apuesta)
			eleccion = 4;

			// Ajusta la visibilidad de los botones en la interfaz principal
			ve.getBotonCrearApuesta().setVisible(false);
			ve.getBotonLeerApuestas().setVisible(false);
			ve.getBotonModificarApuesta().setVisible(false);
			ve.getBotonEliminarApuestas().setVisible(false);
			ve.getBotonLoteria().setVisible(true);
			ve.getBotonBaloto().setVisible(true);
			ve.getBotonSuperastro().setVisible(true);
			ve.getBotonBetplay().setVisible(true);
			ve.getBotonChance().setVisible(true);
			ve.getFlecha3().setVisible(true);
			ve.getFlecha2().setVisible(false);

			break;
		}

		/**
		 * Maneja la acción del botón "Regresar Apuestas" en la interfaz principal.
		 * Realiza las siguientes acciones: - Ajusta la visibilidad de los botones para
		 * mostrar la vista de apostadores.
		 */
		case "BotonRegresarApuestas": {
			// Ajusta la visibilidad de los botones para mostrar la vista de apostadores
			ve.getBotonEliminarApostador().setVisible(true);
			ve.getBotonLeerApostador().setVisible(true);
			ve.getBotonModificarApostador().setVisible(true);
			ve.getBotonApostadores().setBounds(200, 180, 290, 180);
			ve.getBotonApostadores().setVisible(true);
			ve.getBotonApostador().setVisible(false);
			ve.getBotonCasaApuestas().setVisible(false);
			ve.getBotonApuesta().setVisible(true);
			ve.getFlecha().setVisible(true);
			ve.getBotonCrearApuesta().setVisible(false);
			ve.getBotonLeerApuestas().setVisible(false);
			ve.getBotonModificarApuesta().setVisible(false);
			ve.getBotonEliminarApuestas().setVisible(false);
			ve.getFlecha2().setVisible(false);

			break;
		}

		/**
		 * Maneja la acción del botón "Regresar Juegos" en la interfaz principal.
		 * Realiza las siguientes acciones: - Ajusta la visibilidad de los botones para
		 * mostrar la vista principal de apuestas.
		 */
		case "BotonRegresarJuegos": {
			// Ajusta la visibilidad de los botones para mostrar la vista principal de
			// apuestas
			ve.getBotonCrearApuesta().setVisible(true);
			ve.getBotonLeerApuestas().setVisible(true);
			ve.getBotonModificarApuesta().setVisible(true);
			ve.getBotonEliminarApuestas().setVisible(true);
			ve.getBotonLoteria().setVisible(false);
			ve.getBotonBaloto().setVisible(false);
			ve.getBotonSuperastro().setVisible(false);
			ve.getBotonBetplay().setVisible(false);
			ve.getBotonChance().setVisible(false);
			ve.getFlecha2().setVisible(true);
			ve.getFlecha3().setVisible(false);

			break;
		}
		/**
		 * Maneja la acción del botón "Reportes" en la interfaz principal. Realiza las
		 * siguientes acciones: - Muestra la vista de reportes. - Oculta la vista
		 * principal de apuestas.
		 */
		case "BotonReportes": {
			// Muestra la vista de reportes
			vsyc.setVisible(true);

			// Oculta la vista principal de apuestas
			ve.setVisible(false);

			break;
		}

		/**
		 * Maneja la acción del botón "Reporte Clientes por Sede" en la vista de
		 * reportes. Muestra un informe con la lista de clientes por sede.
		 */
		case "botonReporteClientesPorSede": {
			aviso.mostrarInfo(reporte.generarReporteListaClientes());
			break;
		}

		/**
		 * Maneja la acción del botón "Reporte Valor Total" en la vista de reportes.
		 * Muestra un informe con el valor total de todas las apuestas realizadas.
		 */
		case "botonReporteValorTotal": {
			aviso.mostrarInfo(reporte.generarReporteValorTotalApuestas());
			break;
		}

		/**
		 * Maneja la acción del botón "Reporte Detalles Apuestas" en la vista de
		 * reportes. Permite al usuario elegir entre ver los detalles de las apuestas
		 * por sedes o por clientes. Muestra un informe detallado según la opción
		 * seleccionada.
		 */
		case "botonReporteDetallesApuestas": {
			int n = aviso.elegirOpcionInfo("Elija de qué forma quiere ver los detalles de las apuestas", "Por sedes",
					"Por clientes");
			if (n == 0) {
				aviso.mostrarInfoLarga(reporte.generarReporteDetallesApuestasPorSede());
			} else if (n == 1) {
				aviso.mostrarInfoLarga(reporte.generarReporteDetallesApuestasPorApostador());
			}
			break;
		}

		/**
		 * Maneja la acción del botón "Reporte Total Sede Tipo" en la vista de reportes.
		 * Muestra un informe con el valor total de apuestas por sede.
		 */
		case "botonReporteTotalSedeTipo": {
			aviso.mostrarInfo(reporte.generarReporteValorTotalApuestasPorSede());
			break;
		}

		/**
		 * Maneja la acción del botón "Flecha Reportes" en la vista de reportes. Oculta
		 * la vista de reportes y muestra la vista principal de apuestas.
		 */
		case "botonFlechaReportes": {
			vsyc.setVisible(false);
			ve.setVisible(true);
			break;

		}

		}
	}
}
