import java.util.*;

public class HiloCuadradoSimple implements Runnable{
    private int idCuadrado;
    private Pizarra idPizarra;
    private char[] cuadrado = {' ', ' ', ' ', ' ', ' ', ' '};

    public HiloCuadradoSimple(int i, Pizarra hiloPizarra){
        this.idCuadrado = i;
        this.idPizarra = hiloPizarra;
    }

    public void run(){
        try{
            do{
                if(!isPizzaraEmpty()){
                    añadirPieza(consultarPizarra());
                }
                if(hasCuadrado()){
                    imprimeCuadrado();
                    Main.finalizar = true;
                }
            } while (true);
        } catch(InterruptedException e){
            System.out.println("Cuadrado a terminado");
        }
    }

    public boolean isPizzaraEmpty() throws InterruptedException{
        return this.idPizarra.caracteres.isEmpty();
    }

    public char consultarPizarra() throws InterruptedException{
        return this.idPizarra.consultarCaracterSimple();
    }

    public void añadirPieza(char pieza) throws InterruptedException{
        boolean exist = false;

        for(char c: cuadrado){
            if(pieza == c || pieza == ' '){
                exist = true;
                break;
            }
        }

        if(!exist){
            switch(pieza){
                case '\u250c':
                    cuadrado[0] = pieza;
                    break;
                case '\u2500':
                    cuadrado[1] = pieza;
                    break;
                case '\u2510':
                    cuadrado[2] = pieza;
                    break;
                case '\u2502':
                    cuadrado[3] = pieza;
                    break;
                case '\u2514':
                    cuadrado[4] = pieza;
                    break;
                case '\u2518':
                    cuadrado[5] = pieza;
                    break;
            }
        }
    }

    public boolean hasCuadrado() throws InterruptedException{
        boolean hassquare = true;

        for(char c: cuadrado){
            if(c == ' '){
                hassquare = false;
                break;
            }
        }

        return hassquare;
    }

    public void imprimeCuadrado() throws InterruptedException{
        System.out.println(cuadrado[0] + cuadrado[1] + cuadrado[2]);
        System.out.println(cuadrado[3] + idCuadrado + cuadrado[3]);
        System.out.println(cuadrado[4] + cuadrado[1] + cuadrado[5]);
    }
}
