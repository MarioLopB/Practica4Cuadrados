public class HiloCuadradoDoble implements Runnable{
    private int idCuadrado;
    private Pizarra idPizarra;
    public static boolean canprint = true;
    private char[] cuadrado = {' ', ' ', ' ', ' ', ' ', ' '};

    public HiloCuadradoDoble(int i, Pizarra hiloPizarra){
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
                    while(!canprint){
                        wait();
                    }
                    HiloCuadradoSimple.canprint = false;
                    this.imprimeCuadrado();
                    HiloCuadradoSimple.canprint = true;
                    notifyAll();
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
        return this.idPizarra.consultarCaracterDoble();
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
                case '\u2554':
                    cuadrado[0] = pieza;
                    break;
                case '\u2550':
                    cuadrado[1] = pieza;
                    break;
                case '\u2557':
                    cuadrado[2] = pieza;
                    break;
                case '\u2551':
                    cuadrado[3] = pieza;
                    break;
                case '\u255a':
                    cuadrado[4] = pieza;
                    break;
                case '\u255d':
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
        System.out.println(""+ cuadrado[0] + cuadrado[1] + cuadrado[2]);
        System.out.println(""+ cuadrado[3] + idCuadrado + cuadrado[3]);
        System.out.println(""+ cuadrado[4] + cuadrado[1] + cuadrado[5]);
    }
}
