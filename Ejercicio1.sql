/*Ejercicio 1*/
/*Mostrar las canciones de los albumes que terminen con "s"*/
select songs.title as Cancion, albums.title as Album
from songs
inner join albums on songs.album = albums.id
where albums.title like '%s'

