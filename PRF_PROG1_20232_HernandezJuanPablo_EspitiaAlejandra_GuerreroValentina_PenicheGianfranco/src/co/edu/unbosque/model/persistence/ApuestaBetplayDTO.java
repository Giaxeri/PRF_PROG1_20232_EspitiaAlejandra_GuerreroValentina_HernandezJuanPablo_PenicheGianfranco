package co.edu.unbosque.model.persistence;

import java.io.Serializable;

/**
 * Clase que representa una apuesta Betplay.
 */
public class ApuestaBetplayDTO extends Apuesta implements Serializable {

	/**
	 * Serial version UID para la serialización.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Resultado de los partidos.
	 */
	private String partido1, partido2, partido3, partido4, partido5, partido6, partido7, partido8, partido9, partido10,
			partido11, partido12, partido13, partido14;

	/**
	 * Constructor vacío necesario para la serialización.
	 */
	public ApuestaBetplayDTO(String nombreSede, long numCedula, String diaApuesta, double valorApuesta) {
		super(nombreSede, numCedula, diaApuesta, valorApuesta);

	}

	/**
	 * Constructor de la clase con todos los atributos.
	 *
	 * @param nombreSede   Nombre de la sede donde se realiza la apuesta.
	 * @param numCedula    Número de cédula del apostador.
	 * @param diaApuesta   Día en que se realiza la apuesta.
	 * @param valorApuesta Valor de la apuesta.
	 * @param partido1     Resultado del partido 1.
	 * @param partido2     Resultado del partido 2.
	 * @param partido3     Resultado del partido 3.
	 * @param partido4     Resultado del partido 4.
	 * @param partido5     Resultado del partido 5.
	 * @param partido6     Resultado del partido 6.
	 * @param partido7     Resultado del partido 7.
	 * @param partido8     Resultado del partido 8.
	 * @param partido9     Resultado del partido 9.
	 * @param partido10    Resultado del partido 10.
	 * @param partido11    Resultado del partido 11.
	 * @param partido12    Resultado del partido 12.
	 * @param partido13    Resultado del partido 13.
	 * @param partido14    Resultado del partido 14.
	 */

	public ApuestaBetplayDTO(String nombreSede, long numCedula, String diaApuesta, double valorApuesta, String partido1,
			String partido2, String partido3, String partido4, String partido5, String partido6, String partido7,
			String partido8, String partido9, String partido10, String partido11, String partido12, String partido13,
			String partido14) {
		super(nombreSede, numCedula, diaApuesta, valorApuesta);
		this.partido1 = partido1;
		this.partido2 = partido2;
		this.partido3 = partido3;
		this.partido4 = partido4;
		this.partido5 = partido5;
		this.partido6 = partido6;
		this.partido7 = partido7;
		this.partido8 = partido8;
		this.partido9 = partido9;
		this.partido10 = partido10;
		this.partido11 = partido11;
		this.partido12 = partido12;
		this.partido13 = partido13;
		this.partido14 = partido14;
	}

	/**
	 * Obtiene una representación en cadena de la apuesta Betplay.
	 *
	 * @return Cadena con la información de la apuesta Betplay.
	 */
	public String toString() {
		return "Apuesta BetPlay: " + "\n" + "Nombre sede: " + nombreSede + " Cedula: " + numCedula + " Dia apuesta: "
				+ diaApuesta + " Valor apuesta: " + valorApuesta + " Partido 1: " + partido1 + "\n" + " Partido 1: "
				+ partido1 + "\n" + " Partido 2: " + partido2 + "\n" + " Partido 3: " + partido3 + "\n" + " Partido 4: "
				+ partido4 + "\n" + " Partido 5: " + partido5 + "\n" + " Partido 6: " + partido6 + "\n" + " Partido 7: "
				+ partido7 + "\n" + " Partido 8: " + partido8 + "\n" + " Partido 9: " + partido9 + "\n"
				+ " Partido 10: " + partido10 + "\n" + " Partido 11: " + partido11 + "\n" + " Partido 12: " + partido12
				+ "\n" + " Partido 13: " + partido13 + "\n" + " Partido 14: " + partido14 + "\n";
	}

	// Metodos que permiten acceder al valor de un atributo - getters y setters
	public String getPartido1() {
		return partido1;
	}

	public void setPartido1(String partido1) {
		this.partido1 = partido1;
	}

	public String getPartido2() {
		return partido2;
	}

	public void setPartido2(String partido2) {
		this.partido2 = partido2;
	}

	public String getPartido3() {
		return partido3;
	}

	public void setPartido3(String partido3) {
		this.partido3 = partido3;
	}

	public String getPartido4() {
		return partido4;
	}

	public void setPartido4(String partido4) {
		this.partido4 = partido4;
	}

	public String getPartido5() {
		return partido5;
	}

	public void setPartido5(String partido5) {
		this.partido5 = partido5;
	}

	public String getPartido6() {
		return partido6;
	}

	public void setPartido6(String partido6) {
		this.partido6 = partido6;
	}

	public String getPartido7() {
		return partido7;
	}

	public void setPartido7(String partido7) {
		this.partido7 = partido7;
	}

	public String getPartido8() {
		return partido8;
	}

	public void setPartido8(String partido8) {
		this.partido8 = partido8;
	}

	public String getPartido9() {
		return partido9;
	}

	public void setPartido9(String partido9) {
		this.partido9 = partido9;
	}

	public String getPartido10() {
		return partido10;
	}

	public void setPartido10(String partido10) {
		this.partido10 = partido10;
	}

	public String getPartido11() {
		return partido11;
	}

	public void setPartido11(String partido11) {
		this.partido11 = partido11;
	}

	public String getPartido12() {
		return partido12;
	}

	public void setPartido12(String partido12) {
		this.partido12 = partido12;
	}

	public String getPartido13() {
		return partido13;
	}

	public void setPartido13(String partido13) {
		this.partido13 = partido13;
	}

	public String getPartido14() {
		return partido14;
	}

	public void setPartido14(String partido14) {
		this.partido14 = partido14;
	}

	public String getNombreSede() {
		return nombreSede;
	}

	public void setNombreSede(String nombreSede) {
		this.nombreSede = nombreSede;
	}

	public long getNumCedula() {
		return numCedula;
	}

	public void setNumCedula(long numCedula) {
		this.numCedula = numCedula;
	}

	public String getDiaApuesta() {
		return diaApuesta;
	}

	public void setDiaApuesta(String diaApuesta) {
		this.diaApuesta = diaApuesta;
	}

	public double getValorApuesta() {
		return valorApuesta;
	}

	public void setValorApuesta(double valorApuesta) {
		this.valorApuesta = valorApuesta;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
