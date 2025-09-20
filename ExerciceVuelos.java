package fp.vuelos;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

public class VuelosB4 extends Vuelos {

	
		
	
	
	public VuelosB4(String nombre, List<Vuelo> vuelos, String origen, String destino, double precio, int numPasajeros,
			int numPlazas, String codigo, LocalDate fecha, Duration duracion, List<String> tripulacion) {
		super(nombre, vuelos, origen, destino, precio, numPasajeros, numPlazas, codigo, fecha, duracion, tripulacion);
		// TODO Auto-generated constructor stub
	}

	/*1.	
	 * Dado un destino, ¿existe algún vuelo con ese destino?

			2.	Dado un número n devuelve cierto si todos los vuelos tienen al menos n pasajeros.

			3.	Dada una fecha, ¿cuántos vuelos hay ese día?. 

			4.	Dada una fecha devuelve una lista con los vuelos posteriores a esa fecha.

			5.	Dada una fecha devuelve un conjunto con los destinos de los vuelos anteriores a esa fecha.

			6.	Dado un conjunto de destinos devuelve el número de pasajeros a los destinos del conjunto.

			7.	Dado un mes como un entero devuelve el precio medio de los vuelos de ese mes.

			8.	Dado un año como un entero devuelve la recaudación de los vuelos de ese año. Suponga que todos los pasajeros pagan el mismo precio.

			9.	Devuelve el vuelo con mayor número de pasajeros. Si no se puede calcular devuelve null.

			10.	Dado un destino devuelve el código del vuelo de menor precio que vuela a ese destino. Eleva *NoSuchElementException* si no se puede calcular.

			11.	Dado un número *n* devuelve una lista con los n vuelos más baratos.
i
			12.	Dado un número *n* devuelve una lista con los n vuelos de mayor duración.
*/

	//	 * Dado un destino, ¿existe algún vuelo con ese destino?

	public Boolean getVueloDestino (String destino) {
		for (Vuelo v :getVuelos ()) {
			if (v.getDestino().equals(destino)) {
				return true  ;
			}
		} return false ;
		
	} 
	
	//2.	Dado un número n devuelve cierto si todos los vuelos tienen al menos n pasajeros.

	public Boolean getVuelosMenorPasejeros (Integer n) {
		for ( Vuelo v :getVuelos()) {
			if (v.getNumPasajeros()< n) {
				return false ;// en cuanto uno no cumple, ya no sirve
			}
		} return true ;}
	// using streams
	public Boolean todosVuelosConMinimoPasajeros(Integer n) {
	    return getVuelos().stream()
	            .allMatch(v -> v.getNumPasajeros() >= n);//si tus vuelos tienen [120, 80, 150] → devuelve false (porque 80 < 100).
	}
	
	
	//3.	Dada una fecha, ¿cuántos vuelos hay ese día?. 
public Integer getCuentaVuelosPorFecha (LocalDate fecha) {
	Integer contador = 0 ; 
	for (Vuelo v : getVuelos()) {
		if (v.getFecha().equals(fecha)) {  // ese dia
			contador ++ ; // andir 1 ( sumar vuelos)
		}
	}
	return contador; 
}


public long contarVuelosEnFecha (LocalDate fecha) {
	return getVuelos().stream()
			.filter(v ->v.getFecha().equals(fecha)) //deja solo los vuelos con esa fecha. mismo dia
			.count();
}


//	4.	Dada una fecha devuelve una lista con los vuelos posteriores a esa fecha.

public List<Vuelo> getFechPostirior ( LocalDate fecha ) {
	List <Vuelo> resultado = new ArrayList <>();
	for (Vuelo v : getVuelos()) {
		if (v.getFecha().isAfter(fecha)) {
			resultado.add(v);
		}
	}
	return resultado ;
}
	// list can store an object 
	
	
// 5.	Dada una fecha devuelve un conjunto con los destinos de los vuelos anteriores a esa fecha.


public Set<String>getFechaAnterior (LocalDate fecha){
	Set<String>resultado = new HashSet<>();
	for (Vuelo v : getVuelos()) {
		if (v.getFecha().isBefore(fecha)) {
			resultado.add(v.getDestino());
	
		}
	}
	return resultado;
}

// 6. Dado un conjunto de destinos devuelve el número de pasajeros a los destinos del conjunto

public Integer getNumeroDePasajerosAlosDestinos (Set<String>destinos) {
	Integer Total= 0 ; 
	for( Vuelo v : getVuelos() ) {
		if (destinos.contains(v.getDestino())) {
			Total += v.getNumPasajeros();
		}
	}
	return Total;
}
	// 8.	Dado un año como un entero devuelve la recaudación de los vuelos de ese año. Suponga que todos los pasajeros pagan el mismo precio.

	public double getRecaudacionDeLosVuelos (int anio) {
		double Total = 0.0 ; 
		for ( Vuelo v : getVuelos()) {
			if (v.getFecha().getYear()==anio) {
				Total+= v.getPrecio()* v.getNumPasajeros();
			}
		}
		return Total;
		
	}
	
	//9. Devuelve el vuelo con mayor número de pasajeros (o null)
	
	public Vuelo getVuelosConMayorNumPasajero () {
		Vuelo resultdao = null ; 
		int max = -1; 
		for (Vuelo v : getVuelos()) {
			if (v.getNumPasajeros()>max) {
				max = v.getNumPasajeros();
				resultdao = v;
			} 
		}
		return resultdao;
	}
	
	//10.	Dado un destino devuelve el código del vuelo de menor precio que vuela a ese destino. Eleva *NoSuchElementException* si no se puede calcular.

	 
	public String getCodigoConMenorPrecio( String destino ) {
		Vuelo resultado = null ; 
		double min = Double.MAX_VALUE; //empezamos suponiendo que el mínimo es un valor muy muy grande (Double.MAX_VALUE).
		for (Vuelo v : getVuelos()) {
			if (v.getDestino().equals(destino)) {
				// Si encontramos un precio más pequeño que ese número gigante, lo reemplazamos.
				if (v.getPrecio() < min) {
				  min = v.getPrecio();
				  resultado= v ;
				}	
			}
		}
		if (resultado == null) {
	        throw new NoSuchElementException("No hay vuelos para el destino: " + destino);
	    }
	    return resultado.getCodigo();
	}
	//	11.	Dado un número *n* devuelve una lista con los n vuelos más baratos.
	
	
public List<Vuelo> getNVuelosMasBaratos (int n){
	//ordena la lista de menor a mayor precio. dice que comparemos los vuelos por el precio (getPrecio).
	List <Vuelo> copia = new ArrayList<>(getVuelos());
	copia.sort(Comparator.comparing(Vuelo::getPrecio));
	//devuelve una vista parcial de la lista, desde el índice 0 hasta n-1.
	return copia.subList(0, Math.min(n, copia.size()));
	
	
	//Por eso usamos Math.min(n, copia.size()):

//Si n es más pequeño que el total de vuelos → devuelve los n primeros.

//Si n es más grande → devuelve todos los vuelos disponibles, evitando un error.**//
	
	
}
//			12.	Dado un número *n* devuelve una lista con los n vuelos de mayor duración.



public List <Vuelo> getNVuelosConMasDuracion (int n){
	List <Vuelo> copia = new ArrayList<>(getVuelos());
	copia.sort(Comparator.comparing(Vuelo::getDuracion).reversed());
	return copia.subList(0, Math.min(n, copia.size()));
	
	
	
	/**
	 * Math.min(n, copia.size())
Calcula el número final de elementos que vamos a devolver:

Si n es menor o igual al tamaño de la lista (copia.size()), se devuelve n.

Si n es mayor que el tamaño de la lista, se devuelve copia.size().
👉 Esto evita un IndexOutOfBoundsException.

copia.subList(0, X)
Crea una vista parcial de la lista original copia que contiene los elementos desde el índice 0 (incluido) hasta el índice X (excluido).

Si X = n, devuelve los n primeros elementos.

Si X = copia.size(), devuelve toda la lista.
	 */
	
}
// STREAMS
public List<Vuelo> getNVuelosConMasDuracion2 (int n) {
    return getVuelos().stream()
            .sorted(Comparator.comparing(Vuelo::getDuracion).reversed())
            .limit(n)
            .toList();
}


}
