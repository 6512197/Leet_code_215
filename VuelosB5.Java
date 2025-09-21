package fp.vuelos;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class VuelosB5 extends Vuelos {
public VuelosB5(String nombre, List<Vuelo> vuelos, String origen, String destino, double precio, int numPasajeros,
			int numPlazas, String codigo, LocalDate fecha, Duration duracion, List<String> tripulacion) {
		super(nombre, vuelos, origen, destino, precio, numPasajeros, numPlazas, codigo, fecha, duracion, tripulacion);
		// TODO Auto-generated constructor stub
	}

/**
 * # EJERCICIOS

En el tipo contenedor **VuelosB5** añada las siguientes operaciones e impleméntelas exclusivamente con *stream*


1. Dada una fecha f devuelve el número de destinos diferentes de todos los vuelos de esa fecha.

2. Devuelve un conjunto ordenado con los vuelos ordenados por el orden natural del tipo.

3. Dada una letra devuelve un conjunto ordenado alfabéticamente de manera ascendente con los destinos que empiezan por esa letra.

4. Devuelve un conjunto ordenado por longitud de caracteres con los destinos de todos los vuelos.

5. Usa el método collect junto con la clase Collectors para los siguientes ejercicios que ya hemos resuelto de otra manera:

	a. Dada una fecha, cuántos vuelos hay ese día.
 
	b. Dado un mes como un entero devuelve el precio medio de los vuelos de ese mes.

	c. Dado un año como un entero devuelve la recaudación de los vuelos de ese año.

	d. Devuelve el Vuelo con mayor número de pasajeros.

7. Devuelve un Map que a cada fecha le haga corresponder una lista con sus vuelos.

8. Devuelve un Map que a cada fecha le haga corresponder un conjunto con sus vuelos.

9. Devuelve un Map que a cada fecha le haga corresponder el número de vuelos.

10. Devuelve un Map que a cada destino le haga corresponder el número total de plazas.

11. Devuelve un Map que a cada destino le haga corresponder el precio medio de sus vuelos.

12. Devuelve un Map que a cada destino le haga corresponder un conjunto con las fechas de los vuelos a ese destino.

 */
	
	
	
	//1. Dada una fecha f devuelve el número de destinos diferentes de todos los vuelos de esa fecha.

	
	public long getNumeroDestinosPorFecha (LocalDate f) {
		return getVuelos().stream()
				.filter(v->v.getFecha().equals(f)).map(Vuelo::getDestino).distinct().count();
		
	}
	//2. Devuelve un conjunto ordenado con los vuelos ordenados por el orden natural del tipo. ( USAR TEESet)

	public SortedSet<Vuelo> getVuelosOrdenados (){
		return getVuelos().stream().collect(Collectors.toCollection(TreeSet::new));
	}
	//3. Dada una letra devuelve un conjunto ordenado alfabéticamente de manera ascendente con los destinos que empiezan por esa letra.
	
	
	public SortedSet<String> getDestinosPorLetra(char letra) {
	    return getVuelos().stream()
	            .map(Vuelo::getDestino)
	            .filter(d -> d.startsWith(String.valueOf(letra)))
	            .collect(Collectors.toCollection(TreeSet::new));
	}
 //4. Devuelve un conjunto ordenado por longitud de caracteres con los destinos de todos los vuelos.

	public SortedSet<String>getLongetudDeDestinos (String Destino) {
		return getVuelos()
				.stream()
				.map(Vuelo::getDestino)
				//Se ordenan primero por longitud y en empate por orden alfabético.
				.collect(Collectors.toCollection(()->new TreeSet<>(Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()))));
	}
}
