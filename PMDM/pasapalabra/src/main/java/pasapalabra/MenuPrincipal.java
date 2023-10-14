package pasapalabra;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MenuPrincipal extends JPanel implements MouseListener{


    private BufferedImage logo;

    private BufferedImage foto;
    private BufferedImage fotos[];
    private JLabel fotoclick;
    private JButton salir;
    public MenuPrincipal(){

        this.setSize(1280,720);
        this.setLayout(null);
      // this.add(new Rosco()); //test
        try {
            logo = ImageIO.read(new File("src/main/resources/pasapalabralogo.png"));
            foto = ImageIO.read(new File("src/main/resources/avatares/jotchua.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        File avatares[] = new File("src/main/resources/avatares").listFiles();

        fotos = new BufferedImage[avatares.length];
        for (int i = 0; i < avatares.length; i++) {

            try {
                fotos[i] = ImageIO.read(avatares[i]);
            } catch (IOException e) {

                e.printStackTrace();
            }
        }
        fotoclick = new JLabel();
        fotoclick.setIcon(new ImageIcon(foto));
        fotoclick.setBounds(600,400,100,100);
        fotoclick.addMouseListener(this);
        this.add(fotoclick);





    }




    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        //Explicación de esto de abajo: no encontraba un fondo bueno para el pasapalabra, así que decidí pintar varios gradientes azules a diferentes opacidades
        //para crearme mi propio fondo
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setPaint(Color.black);
        g2d.fillRect(0,0,getWidth(),getHeight());

        GradientPaint gradiente = new GradientPaint(
                new Point2D.Double(300, 150), new Color(30, 0, 250, 50),
                new Point2D.Double(400, 500), new Color(64, 161, 222, 50));
        GradientPaint gradiente2 = new GradientPaint(
                new Point2D.Double(100, 700), new Color(27, 98, 191, 50),
                new Point2D.Double(900,100), new Color(15, 49, 163, 50));
        GradientPaint gradiente3 = new GradientPaint(
                new Point2D.Double(400, 0), new Color(14, 30, 207, 50),
                new Point2D.Double(0,400), new Color(0, 54, 247, 50));



        g2d.setPaint(gradiente);
        g2d.fillRect(0,0,getWidth(),getHeight());
        g2d.setPaint(gradiente2);
        g2d.fillRect(0,0,getWidth(),getHeight());
        g2d.setPaint(gradiente3);
        g2d.fillRect(0,0,getWidth(),getHeight());


        g2d.drawImage(logo, getWidth()-logo.getWidth()-100, 50, null);
        //g2d.drawImage(foto, getWidth()-logo.getWidth()-200, 200, null);



    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==fotoclick){
            new FrameAvatar(fotos);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    private void cambiarAvatar(JLabel seleccion){
        fotoclick.setIcon(seleccion.getIcon());
        repaint();
    }

    private JButton crearBoton(int x, int y, String s){
        JButton jb = new JButton(s);
        jb.setBounds(x,y,100,50);

        return jb;
    };


    private class FrameAvatar extends JDialog implements MouseListener{

        private JLabel etiquetas[];
        private JButton confirmacion;
        private JLabel seleccion;

        private FrameAvatar(BufferedImage arr[]){
            this.setSize(500,300);
            //this.setUndecorated(true);
            this.getContentPane().setBackground(Color.black);
            this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            this.setModal(true);
            this.setLayout(null);
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            this.setLocation((screenSize.width - this.getWidth()) / 2, (screenSize.height - this.getHeight()) / 2);
            JPanel imagenes = new JPanel();
            imagenes.setLayout(new FlowLayout(FlowLayout.CENTER));
            imagenes.setBackground(Color.black);
            //
            etiquetas = new JLabel[arr.length];
            for(int i = 0; i < etiquetas.length;i++){
                etiquetas[i] = new JLabel();
                etiquetas[i].setIcon(new ImageIcon(arr[i]));
                etiquetas[i].setSize(100,100);
                etiquetas[i].addMouseListener(this);
                imagenes.add(etiquetas[i]);
            }

            imagenes.setBounds(0,0,500,200);
            this.add(imagenes);
            //Esto es para que en caso de que se seleccione una imagen y luego se cierre la ventana usando la X, no guarde la última imagen seleccionada (bueno,
            //más bien que la borre cuando la vuelvas a abrir, porque técnicamente sí la guarda)
            seleccion = null;

            confirmacion = new JButton("CONFIRMAR");
            confirmacion.setFocusable(false);
            confirmacion.setBorder(null);
            confirmacion.setBounds(200,200,100,50);
            confirmacion.addMouseListener(this);
            confirmacion.setBorder(new LineBorder(Color.white, 3));
            confirmacion.setBackground(Color.decode("#084CF6"));
            confirmacion.setForeground(Color.white);
            this.add(confirmacion);


            this.setVisible(true);



        }


        @Override
        public void mouseClicked(MouseEvent e) {

           for(int i = 0; i < etiquetas.length;i++){
                if(e.getSource()==etiquetas[i]){
                    Border border = new LineBorder(Color.white, 3);
                    etiquetas[i].setBorder(border);
                    seleccion = etiquetas[i];
                }
                else
                    etiquetas[i].setBorder(null);
            }

           if(e.getSource()==confirmacion&&seleccion!=null){
                cambiarAvatar(seleccion);
               this.setVisible(false);
               this.dispose();

           }

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }



}
