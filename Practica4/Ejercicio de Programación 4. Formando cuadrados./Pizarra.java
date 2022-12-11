import java.util.ArrayList;

public class Pizarra{
    public ArrayList<Character> caracteres = new ArrayList<Character>();

    public void ingresarCaracter(char caracter) {
        if(caracter != ' '){
            this.caracteres.add(caracter);
        }
    }

    public synchronized char consultarCaracterSimple() {
        boolean find = false;
        char caracter = ' ';

        for (int i = 0; i < caracteres.size() && !find; i++) {
            caracter = caracteres.get(i);

            switch (caracter) {
                case '\u2500':
                case '\u2502':
                case '\u250c':
                case '\u2514':
                case '\u2518':
                    caracteres.remove(i);
                    find = true;
                    break;
            }
        }

        return caracter;
    }

    public synchronized char consultarCaracterDoble(){
        boolean find = false;
        char caracter = ' ';

        for(int i = 0; i < caracteres.size() && !find; i++){
            caracter = caracteres.get(i);

            switch(caracter){
                case '\u2550':
                case '\u2551':
                case '\u2554':
                case '\u2557':
                case '\u255d':
                case '\u255a':
                    caracteres.remove(i);
                    find = true;
                    break;
            }
        }

        return caracter;
    }
}
