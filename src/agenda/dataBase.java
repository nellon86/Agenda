/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.sql.*;
import java.util.*;

/**
 * Esta clase contiene los metodos que trabajan con la base de datos
 * 
 * @author A.Napoli
 */
public class dataBase {
    
    /**
     * Metodo utilizado para solo visualizar los datos
     * @param nom el nombre que ha sido introducido
     * @param ape el apellido que ha sido introducido
     * @return devuelve una HashMap con los datos encontrados
     * @throws ClassNotFoundException 
     */

    public Map seleccionApeNom(String nom, String ape) throws ClassNotFoundException {
        Map<String, String> datos = new HashMap<>();
        try {

            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:agenda.sqlite");
            //Un objeto Statement se usa para enviar sentencias SQL a la base de datos
            Statement stat = conn.createStatement();
            //ResultSet no es más que una clase java similar a una lista en la que está el resultado de la consulta
            ResultSet rs = stat.executeQuery("select * from contactos WHERE apellidos = '" + ape + "' And nombre = '" + nom + "'");//executeQuery para su uso con SELECT
            ResultSetMetaData rsmt =rs.getMetaData();
            int c = rsmt.getColumnCount();
            while (rs.next()) //executeUpdate para INSERT, UPDATE, DELETE
            {//recorremos todas las filas
                String dni = rs.getString("DNI");
                String nome = rs.getString("Nombre");
                String apel = rs.getString("Apellidos");
                String dir = rs.getString("Direccion");
                String tel = rs.getString("Telefono");
                datos.put("DNI", dni);
                datos.put("Nombre", nome);
                datos.put("Apellidos", apel);
                datos.put("Direccion", dir);
                datos.put("Telefono", tel);
            }
            stat.close();
            conn.close();//Cerramos la conexion
            return datos;

        } catch (SQLException ex) {
            System.out.println("Error de seleccion");
        }
        return null;
    }
    
    /**
     * Metodo utilizado para solo visualizar los datos
     * @param ape el apellido que ha sido introducido
     * @return devuelve una HashMap con los datos encontrados
     * @throws ClassNotFoundException 
     */

    public Map seleccionApe(String ape) throws ClassNotFoundException {
        Map<String, String> datos = new HashMap<>();
        try {

            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:agenda.sqlite");
            //Un objeto Statement se usa para enviar sentencias SQL a la base de datos
            Statement stat = conn.createStatement();
            //ResultSet no es más que una clase java similar a una lista en la que está el resultado de la consulta
            ResultSet rs = stat.executeQuery("select * from contactos WHERE apellidos='" + ape + "'");//executeQuery para su uso con SELECT
            while (rs.next()) //executeUpdate para INSERT, UPDATE, DELETE
            {//recorremos todas las filas
                String dni = rs.getString("DNI");
                String nome = rs.getString("Nombre");
                String apel = rs.getString("Apellidos");
                String dir = rs.getString("Direccion");
                String tel = rs.getString("Telefono");
                datos.put("DNI", dni);
                datos.put("Nombre", nome);
                datos.put("Apellidos", apel);
                datos.put("Direccion", dir);
                datos.put("Telefono", tel);
            }
            stat.close();
            conn.close();//Cerramos la conexion
            return datos;

        } catch (SQLException ex) {
            System.out.println("Error de seleccion");
        }
        return null;
    }
    
    /**
     * Metodo utilizado para solo visualizar los datos
     * @param dir la direccion que ha sido introducido
     * @return devuelve una HashMap con los datos encontrados
     * @throws ClassNotFoundException 
     */
    
    public Map seleccionDir(String dir) throws ClassNotFoundException {
        Map<String, String> datos = new HashMap<>();
        try {

            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:agenda.sqlite");
            //Un objeto Statement se usa para enviar sentencias SQL a la base de datos
            Statement stat = conn.createStatement();
            //ResultSet no es más que una clase java similar a una lista en la que está el resultado de la consulta
            ResultSet rs = stat.executeQuery("select * from contactos WHERE Direccion is like '" + dir + "'");//executeQuery para su uso con SELECT
            while (rs.next()) //executeUpdate para INSERT, UPDATE, DELETE
            {//recorremos todas las filas
                String dni = rs.getString("DNI");
                String nome = rs.getString("Nombre");
                String apel = rs.getString("Apellidos");
                String dire = rs.getString("Direccion");
                String tel = rs.getString("Telefono");
                datos.put("DNI", dni);
                datos.put("Nombre", nome);
                datos.put("Apellidos", apel);
                datos.put("Direccion", dire);
                datos.put("Telefono", tel);
            }
            stat.close();
            conn.close();//Cerramos la conexion
            return datos;

        } catch (SQLException ex) {
            System.out.println("Error de seleccion");
        }
        return null;
    }
    
    /**
     * Metodo utilizado para solo visualizar los datos
     * @param tel el telefono que ha sido introducido
     * @return devuelve una HashMap con los datos encontrados
     * @throws ClassNotFoundException 
     */
    
    public Map seleccionTel(String tel) throws ClassNotFoundException {
        Map<String, String> datos = new HashMap<>();
        try {

            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:agenda.sqlite");
            //Un objeto Statement se usa para enviar sentencias SQL a la base de datos
            Statement stat = conn.createStatement();
            //ResultSet no es más que una clase java similar a una lista en la que está el resultado de la consulta
            ResultSet rs = stat.executeQuery("select * from contactos WHERE Telefono ='" + tel + "'");//executeQuery para su uso con SELECT
            while (rs.next()) //executeUpdate para INSERT, UPDATE, DELETE
            {//recorremos todas las filas
                String dni = rs.getString("DNI");
                String nome = rs.getString("Nombre");
                String apel = rs.getString("Apellidos");
                String dire = rs.getString("Direccion");
                String tele = rs.getString("Telefono");
                datos.put("DNI", dni);
                datos.put("Nombre", nome);
                datos.put("Apellidos", apel);
                datos.put("Direccion", dire);
                datos.put("Telefono", tele);
            }
            stat.close();
            conn.close();//Cerramos la conexion
            return datos;

        } catch (SQLException ex) {
            System.out.println("Error de seleccion");
        }
        return null;
    }
    
    /**
     * Metodo utilizado para solo visualizar los datos
     * @param dni el DNI que ha sido introducido
     * @return devuelve una HashMap con los datos encontrados
     * @throws ClassNotFoundException 
     */

    public Map seleccionDNI(String dni) throws ClassNotFoundException {
        Map<String, String> datos = new HashMap<>();
        try {

            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:agenda.sqlite");
            //Un objeto Statement se usa para enviar sentencias SQL a la base de datos
            Statement stat = conn.createStatement();
            //ResultSet no es más que una clase java similar a una lista en la que está el resultado de la consulta
            ResultSet rs = stat.executeQuery("select * from contactos WHERE DNI='" + dni + "'");//executeQuery para su uso con SELECT
            while (rs.next()) //executeUpdate para INSERT, UPDATE, DELETE
            {//recorremos todas las filas
                String Dni = rs.getString("DNI");
                String nome = rs.getString("Nombre");
                String apel = rs.getString("Apellidos");
                String dir = rs.getString("Direccion");
                String tel = rs.getString("Telefono");
                datos.put("DNI", Dni);
                datos.put("Nombre", nome);
                datos.put("Apellidos", apel);
                datos.put("Direccion", dir);
                datos.put("Telefono", tel);

            }
            stat.close();
            conn.close();//Cerramos la conexion
            return datos;

        } catch (SQLException ex) {
            System.out.println("Error de seleccion");
        }
        return null;
    }
    
    /**
     * Metodo utilizado para solo visualizar los datos
     * @param nom el nombre que ha sido introducido
     * @return devuelve una HashMap con los datos encontrados
     * @throws ClassNotFoundException 
     */

    public Map seleccionNom(String nom) throws ClassNotFoundException {
        Map<String, String> datos = new HashMap<>();
        try {

            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:agenda.sqlite");
            //Un objeto Statement se usa para enviar sentencias SQL a la base de datos
            Statement stat = conn.createStatement();
            //ResultSet no es más que una clase java similar a una lista en la que está el resultado de la consulta
            ResultSet rs = stat.executeQuery("select * from contactos WHERE Nombre='" + nom + "'");//executeQuery para su uso con SELECT
            while (rs.next()) //executeUpdate para INSERT, UPDATE, DELETE
            {//recorremos todas las filas
//                System.out.print("Nombre: " + rs.getString("nombre"));
//                System.out.println(", Apellidos: " + rs.getString("apellidos"));
                String dni = rs.getString("DNI");
                String nome = rs.getString("Nombre");
                String ape = rs.getString("Apellidos");
                String dir = rs.getString("Direccion");
                String tel = rs.getString("Telefono");
                datos.put("DNI", dni);
                datos.put("Nombre", nome);
                datos.put("Apellidos", ape);
                datos.put("Direccion", dir);
                datos.put("Telefono", tel);
            }
            stat.close();
            conn.close();//Cerramos la conexion
            return datos;

        } catch (SQLException ex) {
            System.out.println("Error de seleccion");
        }
        return null;
    }
    
    /**
     * Metodo utilizado para crear una nueva entrada
     * @param dni DNI introducido
     * @param nom Nombre introducido
     * @param ape Apellido introducido
     * @param dir Direccion introducida
     * @param tel Telefono introducido
     * @throws ClassNotFoundException 
     */

    public void insercion(String dni, String nom, String ape, String dir, String tel) throws ClassNotFoundException {
        try {
            Class.forName("org.sqlite.JDBC"); //sirve para cargar el driver (diferente)
            Connection conn = DriverManager.getConnection("jdbc:sqlite:agenda.sqlite"); //direccion relativa (vedi fichero)
            Statement stat = conn.createStatement();// enviar comandos SQL a la base de datos, se usa la clase Statement de java
            stat.executeUpdate("INSERT INTO contactos(DNI,Nombre,Apellidos,Direccion,Telefono) VALUES('" + dni + "','" + nom + "','" + ape + "','" + dir + "','" + tel + "')");//Si el id es auto_increment no hay que poner el id
            stat.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Error de insercion");
        }
    }
    
    /**
     * Metodo utilizado para actualizar una entrada ya existente
     * @param dni DNI introducido
     * @param nom Nombre introducido
     * @param ape Apellido introducido
     * @param dir Direccion introducida
     * @param tel Telefono introducido
     * @throws ClassNotFoundException 
     */
    
    public void actualizarTodo(String nom, String ape, String dir, String tel, String dni) throws ClassNotFoundException {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:agenda.sqlite");
            Statement stat = conn.createStatement();
            stat.executeUpdate("UPDATE contactos SET nombre='" + nom + "', apellidos='"+ape+"', direccion='"+dir+"', telefono='"+tel+"' WHERE DNI='" + dni + "'");
            stat.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Error de actualizacion");
        }
    }
    
    /**
     * Metodo utilizado para actualizar una entrada ya existente por DNI y Nombre
     * @param dni DNI introducido
     * @param nom Nombre introducido
     */

    public void actualizarNom(String nom, String dni) throws ClassNotFoundException {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:agenda.sqlite");
            Statement stat = conn.createStatement();
            stat.executeUpdate("UPDATE contactos SET nombre='" + nom + "' WHERE DNI='" + dni + "'");
            stat.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Error de actualizacion");
        }
    }
    
    /**
     * Metodo utilizado para actualizar una entrada ya existente por DNI y Apellido
     * @param dni DNI introducido
     * @param ape Apellido introducido
     */
    
    public void actualizarApe(String ape, String dni) throws ClassNotFoundException {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:agenda.sqlite");
            Statement stat = conn.createStatement();
            stat.executeUpdate("UPDATE contactos SET Apellidos='" + ape + "' WHERE DNI='" + dni + "'");
            stat.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Error de actualizacion");
        }
    }
    /**
    * Mejor no utilizar este metodo aunque exista
    * @param ape for apellidos
    * @param dni for new dni value
    * @author A.Napoli
    **/
    public void actualizarDNI(String ape, String dni) throws ClassNotFoundException {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:agenda.sqlite");
            Statement stat = conn.createStatement();
            stat.executeUpdate("UPDATE contactos SET DNI='" + dni + "' WHERE Apellidos='" + ape + "'");
            stat.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Error de actualizacion");
        }
    }
    
    /**
     * Metodo utilizado para actualizar una entrada ya existente por DNI y Direccion
     * @param dni DNI introducido
     * @param dir Nombre introducido
     */
    
    public void actualizarDir(String dir, String dni) throws ClassNotFoundException {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:agenda.sqlite");
            Statement stat = conn.createStatement();
            stat.executeUpdate("UPDATE contactos SET Direccion='" + dir + "' WHERE DNI='" + dni + "'");
            stat.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Error de actualizacion");
        }
    }
    
    /**
     * Metodo utilizado para actualizar una entrada ya existente por DNI y Telefono
     * @param dni DNI introducido
     * @param tel Telefono introducido
     */
    
    public void actualizarTel(String tel, String dni) throws ClassNotFoundException {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:agenda.sqlite");
            Statement stat = conn.createStatement();
            stat.executeUpdate("UPDATE contactos SET Telefono='" + tel + "' WHERE DNI='" + dni + "'");
            stat.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Error de actualizacion");
        }
    }
    
    /**
     * Metodo utilizado para eliminar una entrada ya existente por Apellido y Nombre
     * @param ape Apellido introducido
     * @param nom Nombre introducido
     */

    public void eliminar(String ape, String nom) throws ClassNotFoundException {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:agenda.sqlite");
            Statement stat = conn.createStatement();
            stat.executeUpdate("DELETE FROM contactos WHERE apellidos='" + ape + "' And nombre='" + nom + "'");
            stat.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Error de eliminacion");
        }

    }
    
    /**
     * Metodo utilizado para visualizar todas las entrada ya existentes
     * 
     */

    public String todo() throws ClassNotFoundException {
        try {
            StringBuffer cadena = new StringBuffer();
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:agenda.sqlite");
            //Un objeto Statement se usa para enviar sentencias SQL a la base de datos
            Statement stat = conn.createStatement();
            //ResultSet no es más que una clase java similar a una lista en la que está el resultado de la consulta
            ResultSet rs = stat.executeQuery("select * from contactos");//executeQuery para su uso con SELECT
            while (rs.next()) //executeUpdate para INSERT, UPDATE, DELETE
            {//recorremos todas las filas
                cadena.append("Nombre: ").append(rs.getString("nombre"));
                cadena.append("\tApellidos: ").append(rs.getString("apellidos"));
                cadena.append("\n");
            }
            stat.close();
            conn.close();//Cerramos la conexion
            return cadena.toString();
        } catch (SQLException ex) {
            System.out.println("Error de seleccion");
        }
        return null;
    }
    
    /**
     * Metodo utilizado para detectar todos los DNIs
     * @throws ClassNotFoundException 
     * @return Devuelve una Lista con todos los DNI
     */

    public List todosDNI() throws ClassNotFoundException {
        try {
            List<String> cadena = null;
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:agenda.sqlite");
            //Un objeto Statement se usa para enviar sentencias SQL a la base de datos
            Statement stat = conn.createStatement();
            //ResultSet no es más que una clase java similar a una lista en la que está el resultado de la consulta
            ResultSet rs = stat.executeQuery("select * from contactos");//executeQuery para su uso con SELECT
            while (rs.next()) //executeUpdate para INSERT, UPDATE, DELETE
            {//recorremos todas las filas
                cadena.add(rs.getString("DNI"));
            }
            stat.close();
            conn.close();//Cerramos la conexion
            return cadena;
        } catch (SQLException ex) {
            System.out.println("Error de seleccion");
        }
        return null;
    }
}
