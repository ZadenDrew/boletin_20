package manterlibreria;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author acabezaslopez
 */
public class Prestamo {

    String linea;
    String[] lista = new String[4];
    Libro l, libro, lib;
    Scanner sc;
    BufferedReader br;
    PrintWriter pw;
    File pf;

    //engadir  engade un novo libro ao noso ficheiro
    public void engadir(Libro e) {
        try {
            pw = new PrintWriter(new FileOutputStream(("libros.txt"), true));
            ManterLibreria.listaLibro.add(e);
            pw.println(e);
        } catch (FileNotFoundException ex) {
            // Logger.getLogger(Prestamo.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Fichero no encontrado.....\n");
        } finally {
            // pw.flush();
            pw.close();
        }
    }

// consultar dado o título dun libro visualizar o seu precio . se o libro non o temos na librería visualizamos unha mensaxe
    public void consultar(String titulo) {

        try {

            sc = new Scanner(new FileInputStream("libros.txt"));
            while (sc.hasNextLine()) {
                linea = sc.nextLine();
                lista = linea.split("\\s*,\\s*");
                libro = new Libro(lista[0], lista[1], Float.parseFloat(lista[2]), Integer.parseInt(lista[3]));
                if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                    System.out.println(libro.getTitulo() + "\t" + libro.getPrecio());
                }
            }

        } catch (FileNotFoundException ex) {
            //Logger.getLogger(Prestamo.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("\nNo existe el ejemplar en la libreria .\n");
        } finally {
            sc.close();
        }
    }

    // visualizar visualiza todos os datos do ficheiro
    public void visualizar() {
        try {
            sc = new Scanner(new FileInputStream("libros.txt"));
            while (sc.hasNextLine()) {
                linea = sc.nextLine();
                lista = linea.split("\\s*,\\s*");
                l = new Libro(lista[0], lista[1], Float.parseFloat(lista[2]), Integer.parseInt(lista[3]));
                System.out.println(l);
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Error lectura obxectos.El Array es nulo\nNo hay libros!!!!");
        } finally {
            sc.close();
        }
    }
// borrar  borra os libros que teñan 0 unidades

    public void borrar() {
        try {
            File tempf = new File(pf.getAbsolutePath() + ".tmp");
            sc = new Scanner(new FileInputStream("libros.txt"));
            pw = new PrintWriter(new FileWriter(tempf));
            while (sc.hasNextLine()) {
                linea = sc.nextLine();
                lista = linea.split("\\s*,\\s*");
                lib = new Libro(lista[0], lista[1], Float.parseFloat(lista[2]), Integer.parseInt(lista[3]));
                if ((lib.getUnidades() != 0)) {
                    pw.println(linea);
                    pw.flush();
                }
            }
            pw.close();
            sc.close();
            //Elimina el fichero original
            if (!pf.delete()) {
                System.out.println("No es posible eliminar el fichero");
                return;
            }

            //Renombrar el nuevo fichero con el nombre del original
            if (!tempf.renameTo(pf)) {
                System.out.println("No se puede renombrar el fichero");

            }

        } catch (FileNotFoundException ex) {
            //Logger.getLogger(Prestamo.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("\nNo existe el ejemplar en la libreria .\n");

        } catch (IOException e) {
            System.out.println("\nNo existe el ejemplar en la libreria .\n");
        }
    }
    // modificar  modifica o precio dun libro determinado*/

    public void modificarPrecio(String titulo, float nuevoPrecio) {

        try {
            File pf2 = new File("libros.txt");
            File tempf2 = new File(pf2.getAbsolutePath() + ".tmp");
            sc = new Scanner(new FileInputStream("libros.txt"));
            pw = new PrintWriter(new FileWriter(tempf2));
            while (sc.hasNextLine()) {
                linea = sc.nextLine();
                lista = linea.split("\\s*,\\s*");
                libro = new Libro(lista[0], lista[1], Float.parseFloat(lista[2]), Integer.parseInt(lista[3]));
                if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                    System.out.println(libro.getTitulo() + "\t" + "precio antiguo" + libro.getPrecio());
                    libro = new Libro(lista[0], lista[1], Float.parseFloat(lista[2] = Float.toString(nuevoPrecio)), Integer.parseInt(lista[3]));
                    System.out.println(libro.getTitulo() + "\t" + "nuevo precio -> " + libro.getPrecio());
                    pw.println(libro.toString());
                } else {
                    pw.println(linea);
                }
            }
            sc.close();
            pw.close();
            //Elimina el fichero original
            if (!pf2.delete()) {
                System.out.println("No es posible eliminar el fichero");
                return;
            }

            //Renombrar el nuevo fichero con el nombre del original
            if (!tempf2.renameTo(pf2)) {
                System.out.println("No se puede renombrar el fichero");

            }

        } catch (FileNotFoundException ex) {
            System.out.println("\nNo existe el ejemplar en la libreria .\n");
        } catch (IOException e) {
            System.out.println("\nNo existe el ejemplar en la libreria .\n");
        }
    }

}
