package co.edu.unbosque.model.persistence;

import java.io.Serializable;

/**
 * Clase que representa una apuesta de lotería.
 * Hereda de la clase Apuesta e implementa Serializable.
 */
public class ApuestaLoteriaDTO extends Apuesta implements Serializable {
    /**
     * Identificador único para la serialización.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Nombre de la lotería.
     */
    private String nombreLoteria;

    /**
     * Número apostado en la lotería.
     */
    private int numeroApostado;

    /**
     * Número de serie de la lotería.
     */
    private int serieLoteria;

    /**
     * Constructor de la clase ApuestaLoteriaDTO.
     * @param nombreSede Nombre de la sede donde se realiza la apuesta.
     * @param numCedula Número de cédula del apostador.
     * @param diaApuesta Día en que se realiza la apuesta.
     * @param valorApuesta Valor apostado.
     */
    public ApuestaLoteriaDTO(String nombreSede, long numCedula, String diaApuesta, double valorApuesta) {
        super(nombreSede, numCedula, diaApuesta, valorApuesta);
    }

    /**
     * Constructor de la clase ApuestaLoteriaDTO con detalles de lotería.
     * @param nombreSede Nombre de la sede donde se realiza la apuesta.
     * @param numCedula Número de cédula del apostador.
     * @param diaApuesta Día en que se realiza la apuesta.
     * @param valorApuesta Valor apostado.
     * @param nombreLoteria Nombre de la lotería.
     * @param numeroApostado Número apostado en la lotería.
     * @param serieLoteria Número de serie de la lotería.
     */
    public ApuestaLoteriaDTO(String nombreSede, long numCedula, String diaApuesta, double valorApuesta,
            String nombreLoteria, int numeroApostado, int serieLoteria) {
        super(nombreSede, numCedula, diaApuesta, valorApuesta);
        this.nombreLoteria = nombreLoteria;
        this.numeroApostado = numeroApostado;
        this.serieLoteria = serieLoteria;
    }

    /**
     * Representación en cadena de la apuesta de lotería.
     * @return Cadena que describe la apuesta de lotería.
     */
    public String toString() {
        return "Apuesta Loteria: " + "Nombre sede: " + nombreSede + " Cedula: " + numCedula + " Dia apuesta: "
                + diaApuesta + " Valor apuesta: " + valorApuesta + " Nombre loteria: " + nombreLoteria
                + " Numero loteria: " + numeroApostado + " Numero serie: " + serieLoteria + "\n";
    }

	//Metodos que permiten acceder al valor de un atributo - getters y setters
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

	public String getNombreLoteria() {
		return nombreLoteria;
	}

	public void setNombreLoteria(String nombreLoteria) {
		this.nombreLoteria = nombreLoteria;
	}

	public int getNumeroApostado() {
		return numeroApostado;
	}

	public void setNumeroApostado(int numeroApostado) {
		this.numeroApostado = numeroApostado;
	}

	public int getSerieLoteria() {
		return serieLoteria;
	}

	public void setSerieLoteria(int serieLoteria) {
		this.serieLoteria = serieLoteria;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
