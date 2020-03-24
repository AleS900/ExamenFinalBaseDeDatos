/*Ejercicio 3*/
/*Obtener el promedio de duracion de las canciones de Micky Mouse*/
select avg(songs.duration) as Promedio_Canciones_Mickey_Mouse
from songs
where songs.artist =(
       select artists.id
       from artists
       where artists.name = 'Mickey Mouse'
)