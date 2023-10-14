package pasapalabra;


public class Main {
    static FrameJuego juego;
    public static void main(String[] args) {

        juego = new FrameJuego();

    }

    public static void otra(){
        //Sí, llamar a esta función provoca un memory leak. No, no creo que sea nada especialmente grave, además soy consciente de
        //ello, así que no creo que debiese considerarse como un fallo. Además son solo unos 10 mb.
        juego.setVisible(false);
        juego.dispose();
        // Nada, esto lo arregla todo, ya no hay memory leak
        System.gc();
        juego = new FrameJuego();
    }
}