package manterlibreria;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author acabezaslopez
 */
public class ManterLibreria {

    static ArrayList<Libro> listaLibro = new ArrayList();
    static Libro libro = new Libro();
    static Prestamo p = new Prestamo();
   

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int op;
        String titulo,titcomp;
        float precio;
        do {
            System.out.println("###* MENU *###\n1)Engadir libro\n2)Consultar libro"
                    + "\n3)Visualizar libro\n4)Borrar libro\n5)Modificar precio\n6)Salir");
            op = Integer.parseInt(JOptionPane.showInputDialog("\nSeleccione una opción del  menú :"));
            switch (op) {
                case 1:
                    libro = new Libro(JOptionPane.showInputDialog("Titulo?"), JOptionPane.showInputDialog("Autor ?"), (Float.parseFloat(JOptionPane.showInputDialog("Precio ?"))), (Integer.parseInt(JOptionPane.showInputDialog("Unidades ?"))));
                    p.engadir(libro);
                    break;
                case 2:
                    titulo = JOptionPane.showInputDialog("\nIntroduzca el titulo a consultar :");
                    p.consultar(titulo);
                    break;
                case 3:
                    p.visualizar();
                    break;
                case 4:
                   p.borrar();
                    break;
                case 5:
                    titcomp = JOptionPane.showInputDialog("\nIntroduzca el titulo del libro a modificar :");
                    precio = Integer.parseInt(JOptionPane.showInputDialog("\nIntroduzca nuevo precio :"));
                    p.modificarPrecio(titcomp,precio);
                    break;
                case 6:
                    System.exit(0);
                    break;
            }
        } while (op < 6);
    }
    /*ngadir  engade un novo libro ao noso ficheiro
b) consultar dado o título dun libro visualizar o seu precio . se o libro non o temos na librería visualizamos unha mensaxe
c) visualizar visualiza todos os datos do ficheiro
d) borrar  borra os libros que teñan 0 unidades
e) modificar  modifica o precio dun libro determinado*/
}
