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
                if(!this.isPizarraEmpty()){
                    this.añadirPieza(consultarPizarra());
                }
                if(this.hasCuadrado()){
                    this.imprimeCuadrado();
                    Main.finalizar = true;
                }
            } while (!Main.finalizar);
        } catch(InterruptedException e){
            System.out.println("Cuadrado a terminado");
        }
    }

    public boolean isPizarraEmpty() throws InterruptedException{
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
        idPizarra.imprimeCuadrado(cuadrado, idCuadrado);
    }
}
