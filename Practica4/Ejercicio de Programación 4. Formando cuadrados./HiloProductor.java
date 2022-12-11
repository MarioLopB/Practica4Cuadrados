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

    private int generarIndice(int num) throws  InterruptedException{
        String hex = Integer.toHexString(num);

        switch(hex){
            case "2500":
                return 0;
                
            case "2502":
                return 1;
                
            case "250c":
                return 2;
                
            case "2510":
                return 3;
                
            case "2514":
                return 4;
                
            case "2518":
                return 5;
                
            case "2550":
                return 6;
                
            case "2551":
                return 7;
                
            case "2554":
                return 8;
                
            case "2557":
                return 9;
                
            case "255D":
                return 10;
                
            case "255A":
                return 11;
                
        }

        return -1;
    }

    public void generarCaracter() throws InterruptedException{
        int inicio = generarIndice(valor1);
        int fin = generarIndice(valor2);

        int indexchar = (int)(Math.random()*inicio+fin);

        this.idPizarra.ingresarCaracter(caracteres[indexchar]);
    }
}
