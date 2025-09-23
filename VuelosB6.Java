package fp.vuelos;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class VuelosB6 extends Vuelos{

	public VuelosB6(String nombre, List<Vuelo> vuelos, String origen, String destino, double precio, int numPasajeros,
			int numPlazas, String codigo, LocalDate fecha, Duration duracion, List<String> tripulacion) {
		super(nombre, vuelos, origen, destino, precio, numPasajeros, numPlazas, codigo, fecha, duracion, tripulacion);
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * # EJERCICIOS

En el tipo contenedor **VuelosB6** añada las siguientes operaciones e impleméntelas exclusivamente con *stream*.


1.	Método que devuelve un Map tal que a cada destino le hace corresponder un Optional<Vuelo> con el vuelo más barato a ese destino.

2.	Método que devuelve un Map tal que a cada destino le hace corresponder el vuelo más barato a ese destino.

3.	Método que devuelve un Map tal que a cada destino le hace corresponder el código del Vuelo con el vuelo más barato a ese destino.

4.	Método que devuelve el destino con más vuelos. Si no se puede calcular eleva NoSuchElementException.

5.	Método que devuelve cuál es el segundo destino con más vuelos. Si no se puede calcular eleva NoSuchElementException.

6.	Método que haga corresponder a cada destino el número total de plazas de los vuelos a ese destino. Usa ```Collectors.toMap``` para resolverlo.

7.	Método que devuelve un Map que a cada destino le haga corresponder el porcentaje de plazas de los vuelos a ese destino con respecto al total de plazas.

8.	Método que haga corresponder a cada destino el vuelo más barato a ese destino.  Usa ```Collectors.toMap``` para resolverlo.

9.	Método que dado un entero que representa un año devuelve un SortedMap que relacione cada destino con el total de pasajeros a ese destino en el año dado como parámetro.

10.	Método que devuelve un Map tal que dado un entero n haga corresponder a cada fecha la lista de los n destinos distintos de los vuelos de mayor duración.
		
11.	Método que devuelve un Map que a cada fecha le haga corresponder una lista de vuelos ordenada por precio.

12.	Método que dado un número entero n devuelve un conjunto con los destinos que están entre los n destinos con más vuelos.

Los resultados esperados para el dataset proporcionado son:

	 */

	
	
	
	//1.	Método que devuelve un Map tal que a cada destino le hace corresponder un Optional<Vuelo> con el vuelo más barato a ese destino.

	public Map <String,Optional<Vuelo>> getVuelosMasBaratoAUnDestino(){
		return getVuelos().stream().collect(Collectors.groupingBy(
	            Vuelo::getDestino,
	            Collectors.minBy(Comparator.comparingDouble(Vuelo::getPrecio))
	        ));	
	}
	
	
	
	//2.	Método que devuelve un Map tal que a cada destino le hace corresponder el vuelo más barato a ese destino.
	
	public Map <String, Vuelo> getVuelosMasBaratos (){
		return getVuelos().stream().collect(Collectors.groupingBy(Vuelo::getDestino ,Collectors.collectingAndThen(
                Collectors.minBy(Comparator.comparingDouble(Vuelo::getPrecio)),
                //collectingAndThen unwraps the Optional<Vuelo> because we assume every destination has at least one flight.
                Optional::get
            )
        ));
	}

}
