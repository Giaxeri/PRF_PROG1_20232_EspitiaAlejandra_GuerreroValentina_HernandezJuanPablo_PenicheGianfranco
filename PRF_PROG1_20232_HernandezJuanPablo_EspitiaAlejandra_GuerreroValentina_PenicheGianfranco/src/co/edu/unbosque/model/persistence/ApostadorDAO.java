package co.edu.unbosque.model.persistence;

import java.io.File;
import java.util.ArrayList;

/**
 * Clase que representa un DAO (Data Access Object) para gestionar operaciones
 * CRUD en la entidad ApostadorDTO.
 */
public class ApostadorDAO implements CRUDOperation {

	/** Lista que almacena objetos de tipo ApostadorDTO. */
	private ArrayList<ApostadorDTO> listaApostador;

	/**
	 * Objeto que maneja la escritura y lectura de archivos para los apostadores.
	 */
	private ArchivoApostadores f;

	/** Archivo que almacena los datos de los apostadores. */
	private File archivoApostador;

	/**
	 * Constructor de la clase ApostadorDAO. Inicializa la lista de apostadores, el
	 * objeto de archivo y el archivo en sí.
	 */
	public ApostadorDAO() {
		listaApostador = new ArrayList<>();
		f = new ArchivoApostadores();
		archivoApostador = new File("data/apostadores.dat");
	}

	/**
	 * Método para crear un nuevo apostador.
	 *
	 * @param strs Arreglo de strings con los datos del nuevo apostador.
	 */
	@Override
	public void create(String... strs) {
		ApostadorDTO apostadorTemp = new ApostadorDTO();
		apostadorTemp.setNombre(strs[0]);
		apostadorTemp.setCedula(Long.parseLong(strs[1]));
		apostadorTemp.setSede(strs[2]);
		apostadorTemp.setDireccion(strs[3]);
		apostadorTemp.setNumCelular(Long.parseLong(strs[4]));
		listaApostador.add(apostadorTemp);

	}

	/**
	 * Método para crear un nuevo apostador a partir de un objeto existente.
	 *
	 * @param obj Objeto ApostadorDTO que se añadirá a la lista.
	 */
	@Override
	public void create(Object obj) {
		listaApostador.add((ApostadorDTO) obj);
		f.crearArchivo();
		f.escribirArchivoApostador(listaApostador);
	}

	/**
	 * Método para obtener una representación en cadena de todos los apostadores.
	 *
	 * @return Cadena que representa a todos los apostadores.
	 */
	@Override
	public String readAll() {
		String printable = "";
		for (ApostadorDTO apostadorDTO : listaApostador) {
			printable += apostadorDTO.toString();
		}
		return printable;
	}

	/**
	 * Método para actualizar un apostador dado su índice y nuevos datos.
	 *
	 * @param index Índice del apostador a actualizar.
	 * @param strs  Arreglo de strings con los nuevos datos del apostador.
	 * @return True si la actualización fue exitosa, false de lo contrario.
	 */
	@Override
	public boolean updateByIndex(int index, String... strs) {
		if (index < 0 || index >= listaApostador.size()) {
			return false;
		} else {
			if (strs[0].isBlank() || strs[0] != null) {
				listaApostador.get(index).setNombre(strs[0]);
			}
			if (strs[1].isBlank() || strs[1] != null) {
				listaApostador.get(index).setCedula(Long.parseLong(strs[1]));
			}
			if (strs[2].isBlank() || strs[2] != null) {
				listaApostador.get(index).setSede(strs[2]);
			}
			if (strs[3].isBlank() || strs[3] != null) {
				listaApostador.get(index).setDireccion(strs[3]);
			}
			if (strs[4].isBlank() || strs[4] != null) {
				listaApostador.get(index).setNumCelular(Long.parseLong(strs[4]));
			}

			archivoApostador.delete();
			f.crearArchivo();
			f.escribirArchivoApostador(listaApostador);

			return true;
		}
	}

	/**
	 * Método para modificar los datos de un apostador específico.
	 *
	 * @param nombreAModificar Nombre del apostador a modificar.
	 * @param nuevoNombre      Nuevo nombre para el apostador.
	 * @param nuevaCedula      Nueva cédula para el apostador.
	 * @param nuevaSede        Nueva sede para el apostador.
	 * @param nuevaDireccion   Nueva dirección para el apostador.
	 * @param nuevoNumCelular  Nuevo número de celular para el apostador.
	 */
	public void modify(String nombreAModificar, String nuevoNombre, long nuevaCedula, String nuevaSede,
			String nuevaDireccion, long nuevoNumCelular) {
		for (int i = 0; i < listaApostador.size(); i++) {
			if (nombreAModificar.equalsIgnoreCase(listaApostador.get(i).getNombre())) {
				listaApostador.set(i,
						new ApostadorDTO(nuevoNombre, nuevaCedula, nuevaSede, nuevaDireccion, nuevoNumCelular));
			}
		}
		File f1 = new File("data/apostadores.dat");
		f1.delete();
		f.crearArchivo();
		f.escribirArchivoApostador(listaApostador);
	}

	/**
	 * Método para eliminar un apostador por su número de cédula.
	 *
	 * @param idNumber Número de cédula del apostador a eliminar.
	 * @return True si la eliminación fue exitosa, false de lo contrario.
	 */
	@Override
	public boolean delete(long idNumber) {
		boolean resp = false;
		for (int i = 0; i < listaApostador.size(); i++) {
			if (idNumber == listaApostador.get(i).getCedula()) {
				listaApostador.remove(i);
				resp = true;
			}
		}

		if (resp) {
			File f1 = new File("data/apostadores.dat");
			f1.delete();
			f.crearArchivo();
			f.escribirArchivoApostador(listaApostador);
		}
		return resp;
	}

	/**
	 * Método para eliminar un apostador a partir de un objeto dado.
	 *
	 * @param obj Objeto ApostadorDTO a eliminar.
	 * @return True si la eliminación fue exitosa, false si el objeto es nulo o no
	 *         se encuentra en la lista.
	 */
	@Override
	public boolean delete(Object obj) {
		if (obj == null) {
			return false;
		} else if (listaApostador.remove((ApostadorDTO) obj)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Inicializa la lista de apostadores a partir de un archivo y devuelve una
	 * representación en cadena de todos los apostadores.
	 *
	 * @return Cadena que representa a todos los apostadores después de inicializar
	 *         la lista desde el archivo.
	 */
	public String initializeFile() {
		listaApostador = f.initializeFile();
		return readAll();
	}

	/**
	 * Obtiene la lista de apostadores.
	 *
	 * @return Lista de apostadores.
	 */
	public ArrayList<ApostadorDTO> getListaApostador() {
		return listaApostador;
	}

	/**
	 * Establece la lista de apostadores.
	 *
	 * @param listaApostador Nueva lista de apostadores.
	 */
	public void setListaApostador(ArrayList<ApostadorDTO> listaApostador) {
		this.listaApostador = listaApostador;
	}

	/**
	 * Obtiene el objeto ArchivoApostadores utilizado para la escritura y lectura de
	 * archivos.
	 *
	 * @return Objeto ArchivoApostadores.
	 */
	public ArchivoApostadores getF() {
		return f;
	}

	/**
	 * Establece el objeto ArchivoApostadores utilizado para la escritura y lectura
	 * de archivos.
	 *
	 * @param f Nuevo objeto ArchivoApostadores.
	 */
	public void setF(ArchivoApostadores f) {
		this.f = f;
	}

	/**
	 * Obtiene el archivo que almacena los datos de los apostadores.
	 *
	 * @return Archivo que almacena los datos de los apostadores.
	 */
	public File getArchivoApostador() {
		return archivoApostador;
	}

	/**
	 * Establece el archivo que almacena los datos de los apostadores.
	 *
	 * @param archivoApostador Nuevo archivo que almacena los datos de los
	 *                         apostadores.
	 */
	public void setArchivoApostador(File archivoApostador) {
		this.archivoApostador = archivoApostador;
	}
	
	
}