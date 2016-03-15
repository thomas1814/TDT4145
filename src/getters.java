/**
 * Created by DannyBoy on 08.03.2016.
 */

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class getters {


    String dbURL = "jdbc:mysql://localhost:3306/TDT4145";
    String username = "root";
    String password = "root";



    public void getOvelse() {
        try (Connection conn = DriverManager.getConnection(dbURL, username, password)){
            if (conn != null) {
                String sql = "SELECT * FROM ovelse";
                Statement statement = conn.createStatement();
                ResultSet result = statement.executeQuery(sql);

                while (result.next()) {
                    String navn = result.getString("navn");
                    String beskrivelse = result.getString("beskrivelse");

                    System.out.println("Navn på øvelse: " + navn + " Beskrivelse: " + beskrivelse);

                }
            }

        }catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void getGruppe(){
        try (Connection conn = DriverManager.getConnection(dbURL, username, password)){
        String sql = "SELECT * FROM gruppe";
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql);

        while (result.next()) {
            int id = result.getInt("id");
            String navn = result.getString("navn");

            System.out.println("Gruppe ID: " +id + " GruppeNavn: " + navn);
        }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void getStyrkeMaal(){
        try (Connection conn = DriverManager.getConnection(dbURL, username, password)){
            String sql = "SELECT * FROM styrkemaal";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                int id = result.getInt("id");
                String ovelseNavn = result.getString("ovelse_navn");
                int belastning = result.getInt("belastning");
                int reps = result.getInt("reps");
                int sets = result.getInt("sets");
                Date datoLaget = result.getDate("datoLaget");
                Date datoOppnaadd = result.getDate("datoOppnaadd");

                DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                String newDatoLaget = df.format(datoLaget);
                String newDatoOppnaadd = df.format(datoOppnaadd);

                System.out.println("Mål ID: " +id + " Navn på øvelse: " + ovelseNavn + " Dato Laget: "+ newDatoLaget+
                        " Dato Oppnådd: "+ newDatoOppnaadd+ " Belastning: " + belastning + " Reps: "+ reps + " Sets: " + sets);
        }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void getUtholdenhetsMaal(){
        try (Connection conn = DriverManager.getConnection(dbURL, username, password)){
            String sql = "SELECT * FROM utholdenhetsmaal";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                int id = result.getInt("id");
                String ovelseNavn = result.getString("ovelse_navn");
                Date datoLaget = result.getDate("datoLaget");
                Date datoOppnaadd = result.getDate("datoOppnaadd");

                DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                String newDatoLaget = df.format(datoLaget);
                String newDatoOppnaadd = df.format(datoOppnaadd);

                Time tid = result.getTime("tid");
                String newtid = tid.toString();
                int lengde = result.getInt("lengde");


                System.out.println("Mål ID: " +id + " Navn på øvelse: " + ovelseNavn + " Dato Laget: "+ newDatoLaget+
                        " Dato Oppnådd: "+ newDatoOppnaadd+ " Tid: " + newtid + " Lengde: "+ lengde);
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void getTrening(){
        try (Connection conn = DriverManager.getConnection(dbURL, username, password)){
            String sql = "SELECT * FROM treningsokt";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                int id = result.getInt("id");

                Date dato = result.getDate("dato");
                DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                String newDatoLaget = df.format(dato);

                Time tidspunkt = result.getTime("tidspunkt");
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                String newTidspunkt = sdf.format(tidspunkt);


                Time varighet = result.getTime("varighet");
                String newvarighet = varighet.toString();


                System.out.println("Treningsøkt ID: " +id + " Dato: " + dato + " Tidspunkt: "+ tidspunkt+ " Varighet: " + newvarighet);
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void getInnendors(){
        try (Connection conn = DriverManager.getConnection(dbURL, username, password)){
            String sql = "SELECT * FROM innendors";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                int id = result.getInt("id");
                int treningsoktid = result.getInt("Treningsokt_id");
                int luft = result.getInt("luft");
                int antallTilskuere = result.getInt("antallTilskuere");


                System.out.println("Innendørs ID: " +id + " Treningsøkt ID: " + treningsoktid + " Luft: "+ luft+ " Antall Tilskuere: " + antallTilskuere);
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void getUtendors(){
        try (Connection conn = DriverManager.getConnection(dbURL, username, password)){
            String sql = "SELECT * FROM utendors";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                int id = result.getInt("id");
                int treningsoktid = result.getInt("Treningsokt_id");
                int temperatur = result.getInt("temperatur");
                String vaertype = result.getString("vaertype");

                System.out.println("Innendørs ID: " +id + " Treningsøkt ID: " + treningsoktid + " Temperatur: "+ temperatur+ " Værtype: " + vaertype);
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void getStyrkeResultat(){
        try (Connection conn = DriverManager.getConnection(dbURL, username, password)){
            String sql = "SELECT * FROM styrkeresultat";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                String ovelseNavn = result.getString("Ovelse_navn");
                int treningsoktid = result.getInt("Treningsokt_id");
                int form = result.getInt("form");
                int prestasjon = result.getInt("prestajon");
                String notat = result.getString("notat");
                int belastning = result.getInt("belastning");
                int reps = result.getInt("reps");
                int sets = result.getInt("sets");


                System.out.println("Navn på øvelse: " + ovelseNavn + "Treningsøkt ID: " + treningsoktid +
                        " Form: " + form + " Prestasjon: " + prestasjon + " Notat: "+ notat + " Belastning: " + belastning + " Reps: "+ reps + " Sets: " + sets);
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void getUtholdenhetsResultat(){
        try (Connection conn = DriverManager.getConnection(dbURL, username, password)){
            String sql = "SELECT * FROM utholdenhetsresultat";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                String ovelseNavn = result.getString("Ovelse_navn");
                int treningsoktid = result.getInt("Treningsokt_id");
                int form = result.getInt("form");
                int prestasjon = result.getInt("prestajon");
                String notat = result.getString("notat");
                int tid = result.getInt("tid");
                int lengde = result.getInt("lengde");


                System.out.println("Navn på øvelse: " + ovelseNavn + "Treningsøkt ID: " + treningsoktid +
                        " Form: " + form + " Prestasjon: " + prestasjon + " Notat: "+ notat + " Tid: "+ tid + " Lengde: " + lengde);
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public int getTreningsokID(){
        try (Connection conn = DriverManager.getConnection(dbURL, username, password)){
            Statement statement = conn.createStatement();
            ResultSet idMax = statement.executeQuery("select id(max(id),0) from treningsokt");
            int id2 = 0;
            if ( idMax.next() ){
                id2 = idMax.getInt(1);
            }
            return(id2);

        }catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        }

    }



    public static void main(String[] args) {
        getters get = new getters();
        get.getOvelse();
    }
}