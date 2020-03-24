package Examen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Conector {

	// atributos

	private static Connection con;
	private static Conector INSTANCE = null;

	private Conector() {

	}

	private synchronized static void crearInstancia() {
		if (INSTANCE == null) {
			INSTANCE = new Conector();
			crearConexion();
		}
	}

	public static Conector getInstancia() {
		if (INSTANCE == null) {
			crearInstancia();
		}
		return INSTANCE;
	}

	// Conexion al usuario
	private static void crearConexion() {
		String host = "127.0.0.1";
		String user = "Santiago";
		String password = "00911037SAVC";
		String dataBase = "spotify";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String urlConexion = "jdbc:mysql://" + host + "/" + dataBase + "?" + "user=" + user + "&password="
					+ password;
			con = DriverManager.getConnection(urlConexion);
			System.out.println("Lo lograste :v");
			System.out.println();
		} catch (Exception e) {

		}

	}

	// Ejercicio 1
	// Mostrar las canciones de los albumes que terminen con "s"
	public ArrayList<String> getCanciones() throws SQLException {
		ArrayList<String> listCanciones = new ArrayList<String>();
		PreparedStatement ps = con
				.prepareStatement("select songs.title as Cancion, albums.title as Album\r\n" + "from songs\r\n"
						+ "inner join albums on songs.album = albums.id\r\n" + "where albums.title like '%s'");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			listCanciones.add(rs.getString("Cancion") + "       " + rs.getString("Album"));
		}
		rs.close();
		return listCanciones;
	}

	// Ejecercio 2
	// Mostrar los nombres de los artistas por orden de popularidad
	public ArrayList<String> getPopularidad() throws SQLException {
		ArrayList<String> listPopularidad = new ArrayList<String>();
		PreparedStatement ps = con
				.prepareStatement("select artists.name as Artista , max(plays) as Nro_Reproducciones\r\n"
						+ "from artists\r\n" + "inner join songs on artists.id=songs.artist\r\n"
						+ "group by artists.name\r\n" + "order by max(plays) desc;");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			listPopularidad.add(rs.getString("Artista") + "   " + rs.getString("Nro_Reproducciones"));
		}
		rs.close();
		return listPopularidad;
	}

	// Ejecercio 3
	// Obtener el promedio de duracion de las canciones de Mickey Mouse
	public ArrayList<String> getDuracion() throws SQLException {
		ArrayList<String> listDuracion = new ArrayList<String>();
		PreparedStatement ps = con.prepareStatement("select avg(songs.duration) as Promedio_Canciones_Mickey_Mouse\r\n"
				+ "from songs\r\n" + "where songs.artist =(\r\n" + "       select artists.id\r\n"
				+ "       from artists\r\n" + "       where artists.name = 'Mickey Mouse'\r\n" + ")");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			listDuracion.add(rs.getString("Promedio_Canciones_Mickey_Mouse"));
		}
		rs.close();
		return listDuracion;
	}

}