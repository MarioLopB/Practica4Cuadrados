import javax.print.attribute.standard.PrinterInfo;
import java.math.*;

public class HiloProductor extends Thread{
    private int valor1, valor2;
    private Pizarra idPizarra;
    private char[] caracteres = {'\u2500', '\u2502', '\u250c', '\u2510', '\u2514',
     '\u2518', '\u2550', '\u2551', '\u2554', '\u2557', '\u255D', '\u255A'};

    public HiloProductor(int valor1, int valor2, Pizarra hiloPizarra){
        this.valor1 = valor1;
        this.valor2 = valor2;
        this.idPizarra = hiloPizarra;
    }

    public void run(){
        try{
            do {
                generarCaracter();
                Thread.sleep(1);
            } while (!Main.finalizar);
        } catch(InterruptedException e){
        }
    }

    private void generarCaracter() throws  InterruptedException{
        String hex = Integer.toHexString((int)(Math.random()*this.valor1+this.valor2));
        char caracter = ' ';
        
        switch(hex){
            case "2500":
                caracter = caracteres[0];
                break;
            case "2502":
                caracter = caracteres[1];
                break;
            case "250c":
                caracter = caracteres[2];
                break;
            case "2510":
                caracter = caracteres[3];
                break;
            case "2514":
                caracter = caracteres[4];
                break;
            case "2518":
                caracter = caracteres[5];
                break;
            case "2550":
                caracter = caracteres[6];
                break;
            case "2551":
                caracter = caracteres[7];
                break;
            case "2554":
                caracter = caracteres[8];
                break;
            case "2557":
                caracter = caracteres[9];
                break;
            case "255D":
                caracter = caracteres[10];
                break;
            case "255A":
                caracter = caracteres[11];
                break;
            default:
                caracter = ' ';
                break;
        }
        
        this.idPizarra.ingresarCaracter(caracter);
    }
}
