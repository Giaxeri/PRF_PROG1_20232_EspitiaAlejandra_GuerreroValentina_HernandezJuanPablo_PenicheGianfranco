package co.edu.unbosque.model;

/**
 * La clase Reporte proporciona métodos para generar informes relacionados con
 * las apuestas y los apostadores.
 */
public class Reporte {
	public ApuestaBaloto apuestaBaloto;
	public ApuestaBetplay apuestaBetplay;
	public ApuestaLoteria apuestaLoteria;
	public ApuestaSuperastro apuestaSuperastro;
	public ApuestaChance apuestaChance;
	public GestionApostador gestionApostador;
	public GestionSedes gestionSedes;

	/**
	 * Constructor predeterminado de la clase Reporte. Inicializa instancias de
	 * clases relacionadas.
	 */
	public Reporte() {
		// Atributos de la clase
		apuestaBaloto = new ApuestaBaloto();
		apuestaBetplay = new ApuestaBetplay();
		apuestaLoteria = new ApuestaLoteria();
		apuestaSuperastro = new ApuestaSuperastro();
		apuestaChance = new ApuestaChance();
		gestionApostador = new GestionApostador();
		gestionSedes = new GestionSedes();
	}

	/**
	 * Genera un informe que lista los clientes agrupados por localidad.
	 *
	 * @return El informe generado.
	 */
	public String generarReporteListaClientes() {
		// Inicializar las apuestas y la gestión de apostadores y sedes
		apuestaBaloto.inicializarApuestasBaloto();
		apuestaBetplay.inicializarApuestasBetplay();
		apuestaChance.inicializarApuestasChance();
		apuestaLoteria.inicializarApuestasLoteria();
		apuestaSuperastro.inicializarApuestasSuperastro();
		gestionApostador.inicializarApostadores();
		gestionSedes.inicializarSedes();
		String salida = "";
		String apostadores = "";
		// Iterar sobre las sedes
		for (int i = 0; i < gestionSedes.getSedes().getSedes().size(); i++) {
			apostadores = "";
			// Iterar sobre los apostadores
			for (int j = 0; j < gestionApostador.getApostador().getListaApostador().size(); j++) {
				if (gestionSedes.getSedes().getSedes().get(i).getUbicacionLocalidad()
						.equalsIgnoreCase(gestionApostador.getApostador().getListaApostador().get(j).getSede())) {
					apostadores = apostadores
							.concat(gestionApostador.getApostador().getListaApostador().get(j).toString() + "\n");
				}
			}
			salida += gestionSedes.getSedes().getSedes().get(i).getUbicacionLocalidad() + "\n" + apostadores + "\n";
		}
		return salida;
	}

	/**
	 * Genera un reporte con los detalles de las apuestas realizadas por cada
	 * apuesta.
	 *
	 * @return Una cadena de texto que contiene los detalles de las apuestas por
	 *         apuesta.
	 */
	public String generarReporteValorTotalApuestas() {
		apuestaBaloto.inicializarApuestasBaloto();
		apuestaBetplay.inicializarApuestasBetplay();
		apuestaChance.inicializarApuestasChance();
		apuestaLoteria.inicializarApuestasLoteria();
		apuestaSuperastro.inicializarApuestasSuperastro();
		gestionApostador.inicializarApostadores();
		gestionSedes.inicializarSedes();
		double apuestas1 = 0;
		double apuestas2 = 0;
		double apuestas3 = 0;
		double apuestas4 = 0;
		double apuestas5 = 0;
		double sumaApuestas = 0;

		/**
		 * Genera un informe que muestra el valor total de las apuestas realizadas por
		 * cada apostador.
		 *
		 * @return El informe generado.
		 */
		String salida = "";
		// Inicializar las apuestas y la gestión de apostadores y sedes
		for (int i = 0; i < gestionApostador.getApostador().getListaApostador().size(); i++) {
			// Variables para el cálculo de apuestas
			apuestas1 = 0;
			apuestas2 = 0;
			apuestas3 = 0;
			apuestas4 = 0;
			apuestas5 = 0;
			sumaApuestas = 0;
			// Iterar sobre las apuestas de lotería
			for (int j = 0; j < apuestaLoteria.getApuestaLoteria().getApuestasLoteria().size(); j++) {
				if (gestionApostador.getApostador().getListaApostador().get(i).getCedula() == apuestaLoteria
						.getApuestaLoteria().getApuestasLoteria().get(j).getNumCedula()) {

					apuestas1 += apuestaLoteria.getApuestaLoteria().getApuestasLoteria().get(j).getValorApuesta();

				}
			}
			// Iterar sobre las apuestas de Baloto
			for (int j = 0; j < apuestaBaloto.getApuestaBaloto().getApuestasBaloto().size(); j++) {
				if (gestionApostador.getApostador().getListaApostador().get(i).getCedula() == apuestaBaloto
						.getApuestaBaloto().getApuestasBaloto().get(j).getNumCedula()) {

					apuestas2 += apuestaBaloto.getApuestaBaloto().getApuestasBaloto().get(j).getValorApuesta();

				}
			}
			// Iterar sobre las apuestas de Superastro
			for (int j = 0; j < apuestaSuperastro.getApuestaSuperastro().getApuestasSuperastro().size(); j++) {
				if (gestionApostador.getApostador().getListaApostador().get(i).getCedula() == apuestaSuperastro
						.getApuestaSuperastro().getApuestasSuperastro().get(j).getNumCedula()) {

					apuestas3 += apuestaSuperastro.getApuestaSuperastro().getApuestasSuperastro().get(j)
							.getValorApuesta();

				}
			}
			// Iterar sobre las apuestas de BetPlay
			for (int j = 0; j < apuestaBetplay.getApuestaBetplay().getApuestaBetplay().size(); j++) {
				if (gestionApostador.getApostador().getListaApostador().get(i).getCedula() == apuestaBetplay
						.getApuestaBetplay().getApuestaBetplay().get(j).getNumCedula()) {

					apuestas4 += apuestaBetplay.getApuestaBetplay().getApuestaBetplay().get(j).getValorApuesta();

				}
			}
			// Iterar sobre las apuestas de Chance
			for (int j = 0; j < apuestaChance.getApuestaChance().getApuestasChance().size(); j++) {
				if (gestionApostador.getApostador().getListaApostador().get(i).getCedula() == apuestaChance
						.getApuestaChance().getApuestasChance().get(j).getNumCedula()) {

					apuestas5 += apuestaChance.getApuestaChance().getApuestasChance().get(j).getValorApuesta();

				}
			}
			// Calcular la suma total de apuestas para el apostador actual
			sumaApuestas = apuestas1 + apuestas2 + apuestas3 + apuestas4 + apuestas5;
			// Agregar la información al resultado final
			salida += "Apostador " + gestionApostador.getApostador().getListaApostador().get(i).getCedula() + ": "
					+ sumaApuestas + "\n";

		}

		return salida;
	}

	/**
	 * Genera un reporte con los detalles de las apuestas realizadas por cada sede.
	 *
	 * @return Una cadena de texto que contiene los detalles de las apuestas por
	 *         sede.
	 */
	public String generarReporteDetallesApuestasPorSede() {
		String salida = "";
		String apuestas = "";
		String apuesta1 = "";
		String apuesta2 = "";
		String apuesta3 = "";
		String apuesta4 = "";
		String apuesta5 = "";

		// Inicializar las apuestas y la gestión de apostadores y sedes
		apuestaBaloto.inicializarApuestasBaloto();
		apuestaBetplay.inicializarApuestasBetplay();
		apuestaChance.inicializarApuestasChance();
		apuestaLoteria.inicializarApuestasLoteria();
		apuestaSuperastro.inicializarApuestasSuperastro();
		gestionApostador.inicializarApostadores();
		gestionSedes.inicializarSedes();

		// Iterar sobre las sedes
		for (int i = 0; i < gestionSedes.getSedes().getSedes().size(); i++) {
			apuesta1 = "";
			apuesta2 = "";
			apuesta3 = "";
			apuesta4 = "";
			apuesta5 = "";
			apuestas = "";

			// Iterar sobre las apuestas de lotería
			for (int j = 0; j < apuestaLoteria.getApuestaLoteria().getApuestasLoteria().size(); j++) {
				if (gestionSedes.getSedes().getSedes().get(i).getUbicacionLocalidad()
						.equals(apuestaLoteria.getApuestaLoteria().getApuestasLoteria().get(j).getNombreSede())) {
					apuesta1 = apuesta1
							.concat(apuestaLoteria.getApuestaLoteria().getApuestasLoteria().get(j).toString());
				}
			}

			// Iterar sobre las apuestas de Baloto
			for (int j = 0; j < apuestaBaloto.getApuestaBaloto().getApuestasBaloto().size(); j++) {
				if (gestionSedes.getSedes().getSedes().get(i).getUbicacionLocalidad().equalsIgnoreCase(
						apuestaBaloto.getApuestaBaloto().getApuestasBaloto().get(j).getNombreSede())) {
					apuesta2 = apuesta2.concat(apuestaBaloto.getApuestaBaloto().getApuestasBaloto().get(j).toString());
				}
			}

			// Iterar sobre las apuestas de Superastro
			for (int j = 0; j < apuestaSuperastro.getApuestaSuperastro().getApuestasSuperastro().size(); j++) {
				if (gestionSedes.getSedes().getSedes().get(i).getUbicacionLocalidad().equalsIgnoreCase(
						apuestaSuperastro.getApuestaSuperastro().getApuestasSuperastro().get(j).getNombreSede())) {
					apuesta3 = apuesta3
							.concat(apuestaSuperastro.getApuestaSuperastro().getApuestasSuperastro().get(j).toString());
				}
			}

			// Iterar sobre las apuestas de Betplay
			for (int j = 0; j < apuestaBetplay.getApuestaBetplay().getApuestaBetplay().size(); j++) {
				if (gestionSedes.getSedes().getSedes().get(i).getUbicacionLocalidad().equalsIgnoreCase(
						apuestaBetplay.getApuestaBetplay().getApuestaBetplay().get(j).getNombreSede())) {
					apuesta4 = apuesta4
							.concat(apuestaBetplay.getApuestaBetplay().getApuestaBetplay().get(j).toString() + "\n");
				}
			}

			// Iterar sobre las apuestas de Chance
			for (int j = 0; j < apuestaChance.getApuestaChance().getApuestasChance().size(); j++) {
				if (gestionSedes.getSedes().getSedes().get(i).getUbicacionLocalidad().equalsIgnoreCase(
						apuestaChance.getApuestaChance().getApuestasChance().get(j).getNombreSede())) {
					apuesta5 = apuesta5.concat(apuestaChance.getApuestaChance().getApuestasChance().get(j).toString());
				}
			}

			// Concatenar todas las apuestas por sede
			apuestas = "Loteria: " + "\n" + apuesta1 + "\n" + "Baloto: " + "\n" + apuesta2 + "\n" + "Superastro: "
					+ "\n" + apuesta3 + "\n" + "Betplay: " + "\n" + apuesta4 + "\n" + "Chance: " + "\n" + apuesta5;

			// Concatenar la información por sede al resultado final
			salida = salida.concat(
					gestionSedes.getSedes().getSedes().get(i).getUbicacionLocalidad() + ": " + "\n" + apuestas + "\n");
		}
		return salida;
	}

	/**
	 * Genera un reporte con los detalles de las apuestas realizadas por cada
	 * apostador.
	 *
	 * @return Una cadena de texto que contiene los detalles de las apuestas por
	 *         apostador.
	 */
	public String generarReporteDetallesApuestasPorApostador() {
		String salida = "";
		String apuestas = "";
		String apuesta1 = "";
		String apuesta2 = "";
		String apuesta3 = "";
		String apuesta4 = "";
		String apuesta5 = "";

		// Inicializar las apuestas y la gestión de apostadores y sedes
		apuestaBaloto.inicializarApuestasBaloto();
		apuestaBetplay.inicializarApuestasBetplay();
		apuestaChance.inicializarApuestasChance();
		apuestaLoteria.inicializarApuestasLoteria();
		apuestaSuperastro.inicializarApuestasSuperastro();
		gestionApostador.inicializarApostadores();
		gestionSedes.inicializarSedes();

		// Iterar sobre los apostadores
		for (int i = 0; i < gestionApostador.getApostador().getListaApostador().size(); i++) {
			apuesta1 = "";
			apuesta2 = "";
			apuesta3 = "";
			apuesta4 = "";
			apuesta5 = "";
			apuestas = "";

			// Iterar sobre las apuestas de lotería
			for (int j = 0; j < apuestaLoteria.getApuestaLoteria().getApuestasLoteria().size(); j++) {
				if (gestionApostador.getApostador().getListaApostador().get(i).getCedula() == apuestaLoteria
						.getApuestaLoteria().getApuestasLoteria().get(j).getNumCedula()) {
					apuesta1 = apuesta1
							.concat(apuestaLoteria.getApuestaLoteria().getApuestasLoteria().get(j).toString());
				}
			}

			// Iterar sobre las apuestas de Baloto
			for (int j = 0; j < apuestaBaloto.getApuestaBaloto().getApuestasBaloto().size(); j++) {
				if (gestionApostador.getApostador().getListaApostador().get(i).getCedula() == apuestaBaloto
						.getApuestaBaloto().getApuestasBaloto().get(j).getNumCedula()) {
					apuesta2 = apuesta2.concat(apuestaBaloto.getApuestaBaloto().getApuestasBaloto().get(j).toString());
				}
			}

			// Iterar sobre las apuestas de Superastro
			for (int j = 0; j < apuestaSuperastro.getApuestaSuperastro().getApuestasSuperastro().size(); j++) {
				if (gestionApostador.getApostador().getListaApostador().get(i).getCedula() == apuestaSuperastro
						.getApuestaSuperastro().getApuestasSuperastro().get(j).getNumCedula()) {
					apuesta3 = apuesta3
							.concat(apuestaSuperastro.getApuestaSuperastro().getApuestasSuperastro().get(j).toString());
				}
			}

			// Iterar sobre las apuestas de Betplay
			for (int j = 0; j < apuestaBetplay.getApuestaBetplay().getApuestaBetplay().size(); j++) {
				if (gestionApostador.getApostador().getListaApostador().get(i).getCedula() == apuestaBetplay
						.getApuestaBetplay().getApuestaBetplay().get(j).getNumCedula()) {
					apuesta4 = apuesta4
							.concat(apuestaBetplay.getApuestaBetplay().getApuestaBetplay().get(j).toString() + "\n");
				}
			}

			// Iterar sobre las apuestas de Chance
			for (int j = 0; j < apuestaChance.getApuestaChance().getApuestasChance().size(); j++) {
				if (gestionApostador.getApostador().getListaApostador().get(i).getCedula() == apuestaChance
						.getApuestaChance().getApuestasChance().get(j).getNumCedula()) {
					apuesta5 = apuesta5.concat(apuestaChance.getApuestaChance().getApuestasChance().get(j).toString());
				}
			}

			// Concatenar todas las apuestas por apostador
			apuestas = "Loteria: " + "\n" + apuesta1 + "\n" + "Baloto: " + "\n" + apuesta2 + "\n" + "Superastro: "
					+ "\n" + apuesta3 + "\n" + "Betplay: " + "\n" + apuesta4 + "\n" + "Chance: " + "\n" + apuesta5;

			// Concatenar la información por apostador al resultado final
			salida = salida.concat(gestionApostador.getApostador().getListaApostador().get(i).getCedula() + ": " + "\n"
					+ apuestas + "\n");
		}
		return salida;
	}

	/**
	 * Genera un reporte con el valor total de las apuestas realizadas por cada
	 * sede.
	 *
	 * @return Una cadena de texto que contiene el valor total de las apuestas por
	 *         sede.
	 */
	public String generarReporteValorTotalApuestasPorSede() {
		double apuestas1 = 0;
		double apuestas2 = 0;
		double apuestas3 = 0;
		double apuestas4 = 0;
		double apuestas5 = 0;
		double sumaApuestas = 0;
		String salida = "";
		// Inicializar las apuestas y la gestión de apostadores y sedes
		apuestaBaloto.inicializarApuestasBaloto();
		apuestaBetplay.inicializarApuestasBetplay();
		apuestaChance.inicializarApuestasChance();
		apuestaLoteria.inicializarApuestasLoteria();
		apuestaSuperastro.inicializarApuestasSuperastro();
		gestionApostador.inicializarApostadores();
		gestionSedes.inicializarSedes();

		// Iterar sobre las sedes
		for (int i = 0; i < gestionSedes.getSedes().getSedes().size(); i++) {
			apuestas1 = 0;
			apuestas2 = 0;
			apuestas3 = 0;
			apuestas4 = 0;
			apuestas5 = 0;
			sumaApuestas = 0;

			// Iterar sobre las apuestas de lotería
			for (int j = 0; j < apuestaLoteria.getApuestaLoteria().getApuestasLoteria().size(); j++) {
				if (gestionSedes.getSedes().getSedes().get(i).getUbicacionLocalidad()
						.equals(apuestaLoteria.getApuestaLoteria().getApuestasLoteria().get(j).getNombreSede())) {
					apuestas1 += apuestaLoteria.getApuestaLoteria().getApuestasLoteria().get(j).getValorApuesta();
				}
			}

			// Iterar sobre las apuestas de Baloto
			for (int j = 0; j < apuestaBaloto.getApuestaBaloto().getApuestasBaloto().size(); j++) {
				if (gestionSedes.getSedes().getSedes().get(i).getUbicacionLocalidad().equalsIgnoreCase(
						apuestaBaloto.getApuestaBaloto().getApuestasBaloto().get(j).getNombreSede())) {

					apuestas2 += apuestaBaloto.getApuestaBaloto().getApuestasBaloto().get(j).getValorApuesta();

				}
			}
			// Iterar sobre las apuestas de Superastro
			for (int j = 0; j < apuestaSuperastro.getApuestaSuperastro().getApuestasSuperastro().size(); j++) {
				if (gestionSedes.getSedes().getSedes().get(i).getUbicacionLocalidad().equalsIgnoreCase(
						apuestaSuperastro.getApuestaSuperastro().getApuestasSuperastro().get(j).getNombreSede())) {

					apuestas3 += apuestaSuperastro.getApuestaSuperastro().getApuestasSuperastro().get(j)
							.getValorApuesta();

				}
			}
			// Iterar sobre las apuestas de BetPlay
			for (int j = 0; j < apuestaBetplay.getApuestaBetplay().getApuestaBetplay().size(); j++) {
				if (gestionSedes.getSedes().getSedes().get(i).getUbicacionLocalidad().equalsIgnoreCase(
						apuestaBetplay.getApuestaBetplay().getApuestaBetplay().get(j).getNombreSede())) {

					apuestas4 += apuestaBetplay.getApuestaBetplay().getApuestaBetplay().get(j).getValorApuesta();

				}
			}
			// Iterar sobre las apuestas de Chance
			for (int j = 0; j < apuestaChance.getApuestaChance().getApuestasChance().size(); j++) {
				if (gestionSedes.getSedes().getSedes().get(i).getUbicacionLocalidad().equalsIgnoreCase(
						apuestaChance.getApuestaChance().getApuestasChance().get(j).getNombreSede())) {

					apuestas5 += apuestaChance.getApuestaChance().getApuestasChance().get(j).getValorApuesta();

				}
			}
			// Concatenar todas las apuestas para generar reporte
			sumaApuestas = apuestas1 + apuestas2 + apuestas3 + apuestas4 + apuestas5;
			// Concatenar la información por reporte para el resultado final
			salida = salida.concat(
					"Sede " + gestionSedes.getSedes().getSedes().get(i).getUbicacionLocalidad() + ": " + sumaApuestas
							+ "\n" + " Loteria: " + apuestas1 + "\n" + " Baloto: " + apuestas2 + "\n" + " Superastro: "
							+ apuestas3 + "\n" + " Betplay: " + apuestas4 + "\n" + " Chance: " + apuestas5 + "\n");

		}
		return salida;
	}

	public ApuestaBaloto getApuestaBaloto() {
		return apuestaBaloto;
	}

	public void setApuestaBaloto(ApuestaBaloto apuestaBaloto) {
		this.apuestaBaloto = apuestaBaloto;
	}

	public ApuestaBetplay getApuestaBetplay() {
		return apuestaBetplay;
	}

	public void setApuestaBetplay(ApuestaBetplay apuestaBetplay) {
		this.apuestaBetplay = apuestaBetplay;
	}

	public ApuestaLoteria getApuestaLoteria() {
		return apuestaLoteria;
	}

	public void setApuestaLoteria(ApuestaLoteria apuestaLoteria) {
		this.apuestaLoteria = apuestaLoteria;
	}

	public ApuestaSuperastro getApuestaSuperastro() {
		return apuestaSuperastro;
	}

	public void setApuestaSuperastro(ApuestaSuperastro apuestaSuperastro) {
		this.apuestaSuperastro = apuestaSuperastro;
	}

	public ApuestaChance getApuestaChance() {
		return apuestaChance;
	}

	public void setApuestaChance(ApuestaChance apuestaChance) {
		this.apuestaChance = apuestaChance;
	}

	public GestionApostador getGestionApostador() {
		return gestionApostador;
	}

	public void setGestionApostador(GestionApostador gestionApostador) {
		this.gestionApostador = gestionApostador;
	}

	public GestionSedes getGestionSedes() {
		return gestionSedes;
	}

	public void setGestionSedes(GestionSedes gestionSedes) {
		this.gestionSedes = gestionSedes;
	}

}
