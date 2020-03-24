/*Ejercicio 2*/
/*Mostrar los nombres de los artistas por orden de popularidad*/
select artists.name as Artista , max(plays) as Nro_Reproducciones
from artists
inner join songs on artists.id=songs.artist
group by artists.name
order by max(plays) desc
;
 
