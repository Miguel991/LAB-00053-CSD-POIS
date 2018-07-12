# language: es

Característica: Obtener el punto más cercano a mi ubicación
    Para tener que caminar poco
    Como usuario
    Quiero obtener el punto de interes de un servicio más cercano a mi ubicación acutal
    
Escenario: Caso de exito
    Dado que estoy en -34.609499 y -58.396711
    Cuando pido el POI mas cercano del servicio hospitales
    Entonces el servicio devuelve solo Sagrado Corazón
    
Escenario: Estoy en un POI
		Dado que estoy en -34.607915 y -58.394529
		Cuando pido el POI mas cercano del servicio hospitales
		Entonces el servicio devuelve solo Arrauz Otorrino Centro
		
Escenario: Dos POI a la misma distancia
		Dado que estoy en -34.608189 y -58.395066
		Cuando pido el POI mas cercano del servicio hospitales
		Entonces el servicio devuelve una lista de puntos de interes 
		|  latitud   |  longitud  	|  nombre     								|  descripcion  |
		| -34.608379 | -58.395596 	| Clínica AMEBPA 							| Hospital 			|
		| -34.608379 | -58.395596  	| Clínica AMEBPA planta baja 	| Hospital 			|
		