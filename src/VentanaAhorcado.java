
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
public class VentanaAhorcado extends javax.swing.JFrame {

    String palabraOculta = "";
    //contador para saber el número de fallos
    int numeroFallos = 0;
    /**
     * Creates new form VentanaAhorcado
     */
    public VentanaAhorcado() {
        initComponents();
        //Aquí va el código que poniamos en el run en ACM
        cambiaImagenAhorcado();
        eligePalabraOculta();
        textoInicial();
        
    }

    
    private void eligePalabraOculta(){
        
        //Método básico de lectura de ficheros en Java.
        File fichero = null;
        FileReader fr = null;
        BufferedReader br= null;
        Random r = new Random();
        fichero = new File ("src/lemario-20101017.txt");
        String linea = "";
        try {
            fr = new FileReader(fichero);
            br = new BufferedReader(fr);
            
            int numeroLineasFichero = 0;
            while ( (linea = br.readLine()) != null ){
                numeroLineasFichero++;

            }
            
            int lineaSeleccionada = r.nextInt(numeroLineasFichero);
           
            fr.close();
            fr = new FileReader(fichero);
            br = new BufferedReader(fr);
           
            for (int i=0; i<lineaSeleccionada; i++){
                linea = br.readLine();
                
            }
           
        } catch (FileNotFoundException ex) {
           
        }
          catch (IOException ex) {
           
          }
        palabraOculta = linea;
        
        //Falta revisar las palabras con tilde o con guión
        //Falta revisar palabras con espacios en blanco
        //Falta escribir la palabra si has perdido
        
//        String [] listaDePalabras = new String [10];
//        //Random r = new Random();
//         
//        listaDePalabras [0] = "RATON";
//        listaDePalabras [1] = "PERRO";
//        listaDePalabras [2] = "ORDENADOR";
//        listaDePalabras [3] = "MONITOR";
//        listaDePalabras [4] = "TECLADO";
//        listaDePalabras [5] = "UNO";
//        listaDePalabras [6] = "CHAQUETA";
//        listaDePalabras [7] = "AHORCADO";
//        listaDePalabras [8] = "COMMIT";
//        listaDePalabras [9] = "CETYS";
//        
//       
//        palabraOculta = listaDePalabras[r.nextInt(9)];
//        
    }
    
    private void textoInicial(){
        jLabel1.setText("");
        for (int i=0; i<palabraOculta.length(); i++){
                jLabel1.setText(jLabel1.getText()+"_ ");
                }
    }
    private void cambiaImagenAhorcado (){
        
        String nombreImagen = "";
        //String [] listapalabras = new String [10];
        
        switch (numeroFallos){
                case 0: nombreImagen = "/ahorcado_0.png"; break;
                case 1: nombreImagen = "/ahorcado_1.png"; break;
                case 2: nombreImagen = "/ahorcado_2.png"; break;
                case 3: nombreImagen = "/ahorcado_3.png"; break;
                case 4: nombreImagen = "/ahorcado_4.png"; break;
                case 5: nombreImagen = "/ahorcado_5.png"; break;
                case 6: nombreImagen = "/ahorcado_fin.png"; break;
                case -100: nombreImagen = "/acertasteTodo.png"; break;
                default: nombreImagen = "/ahorcado_fin.png"; break;
            }
        
        //después del switch tendremos en nombreImagen el nombre correcto 
        //de la imagen que tenemos que mostrar dependiendo del numero de fallos.
        ImageIcon a = new ImageIcon(getClass().getResource(nombreImagen));
        Image auxiliar = a.getImage().getScaledInstance(280, 280, Image.SCALE_DEFAULT);
        ImageIcon imageIcon = new ImageIcon(auxiliar);
        jLabel2.setIcon(imageIcon);
    }
    
 
    private void chequeaLetra (JButton boton){
        if (boton.isEnabled()){
            
        String letra = boton.getText().toLowerCase();
        
        boton.setEnabled(false);
//System.out.println(boton.getText());
        String palabraConGuiones = jLabel1.getText();
        
        if (palabraOculta.contains(letra)){
           for (int i=0; i< palabraOculta.length(); i++){
               if (palabraOculta.charAt(i) == letra.charAt(0)){
                   palabraConGuiones = palabraConGuiones.substring(0, 2*i)
                           + letra
                           + palabraConGuiones.substring(2*i +1);
               }
           }
           jLabel1.setText(palabraConGuiones);
           //compruebo si en la palabraConGuiones hay guiones o no
           //si hay algún guiçon no hago nada porque no he adivinado todavía la partida
           //si no hay guiones, tengo que indicar de alguna forma que he ganado la partida.
           if (!palabraConGuiones.contains("_")){
               numeroFallos = -100;
           }
           
        }
        else {
            numeroFallos++;
            
        }
        }
        cambiaImagenAhorcado();
    
        
    }
    // 1º Elegir un valor de un arrays de string de forma aleatoria.
    // 2º Que termine la partida.
    // 3º Se pinte de forma automática los guiones que tenga la palabra oculta.
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        boton_A = new javax.swing.JButton();
        boton_B = new javax.swing.JButton();
        boton_C = new javax.swing.JButton();
        boton_D = new javax.swing.JButton();
        boton_E = new javax.swing.JButton();
        boton_F = new javax.swing.JButton();
        boton_G = new javax.swing.JButton();
        boton_L = new javax.swing.JButton();
        boton_M = new javax.swing.JButton();
        boton_N = new javax.swing.JButton();
        boton_H = new javax.swing.JButton();
        boton_I = new javax.swing.JButton();
        boton_J = new javax.swing.JButton();
        boton_K = new javax.swing.JButton();
        boton_R = new javax.swing.JButton();
        boton_S = new javax.swing.JButton();
        boton_T = new javax.swing.JButton();
        boton_Ñ = new javax.swing.JButton();
        boton_O = new javax.swing.JButton();
        boton_P = new javax.swing.JButton();
        boton_Q = new javax.swing.JButton();
        boton_X = new javax.swing.JButton();
        boton_Y = new javax.swing.JButton();
        boton_Z = new javax.swing.JButton();
        boton_U = new javax.swing.JButton();
        boton_V = new javax.swing.JButton();
        boton_W = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("_ _ _ _ _");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 330, 87));

        boton_A.setText("A");
        boton_A.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                boton_AMousePressed(evt);
            }
        });
        getContentPane().add(boton_A, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 379, 42, 42));

        boton_B.setText("B");
        boton_B.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                boton_BMousePressed(evt);
            }
        });
        getContentPane().add(boton_B, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 379, 42, 42));

        boton_C.setText("C");
        boton_C.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                boton_CMousePressed(evt);
            }
        });
        getContentPane().add(boton_C, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 379, 42, 42));

        boton_D.setText("D");
        boton_D.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                boton_DMousePressed(evt);
            }
        });
        getContentPane().add(boton_D, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 379, 42, 42));

        boton_E.setText("E");
        boton_E.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                boton_EMousePressed(evt);
            }
        });
        getContentPane().add(boton_E, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 379, 42, 42));

        boton_F.setText("F");
        boton_F.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                boton_FMousePressed(evt);
            }
        });
        getContentPane().add(boton_F, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 379, 42, 42));

        boton_G.setText("G");
        boton_G.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                boton_GMousePressed(evt);
            }
        });
        getContentPane().add(boton_G, new org.netbeans.lib.awtextra.AbsoluteConstraints(298, 379, 42, 42));

        boton_L.setText("L");
        boton_L.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                boton_LMousePressed(evt);
            }
        });
        getContentPane().add(boton_L, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 432, 42, 42));

        boton_M.setText("M");
        boton_M.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                boton_MMousePressed(evt);
            }
        });
        getContentPane().add(boton_M, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 432, 42, 42));

        boton_N.setText("N");
        boton_N.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                boton_NMousePressed(evt);
            }
        });
        getContentPane().add(boton_N, new org.netbeans.lib.awtextra.AbsoluteConstraints(298, 432, 42, 42));

        boton_H.setText("H");
        boton_H.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                boton_HMousePressed(evt);
            }
        });
        getContentPane().add(boton_H, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 432, 42, 42));

        boton_I.setText("I");
        boton_I.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                boton_IMousePressed(evt);
            }
        });
        getContentPane().add(boton_I, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 432, 42, 42));

        boton_J.setText("J");
        boton_J.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                boton_JMousePressed(evt);
            }
        });
        getContentPane().add(boton_J, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 432, 42, 42));

        boton_K.setText("K");
        boton_K.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                boton_KMousePressed(evt);
            }
        });
        getContentPane().add(boton_K, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 432, 42, 42));

        boton_R.setText("R");
        boton_R.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                boton_RMousePressed(evt);
            }
        });
        getContentPane().add(boton_R, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 487, 42, 42));

        boton_S.setText("S");
        boton_S.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                boton_SMousePressed(evt);
            }
        });
        getContentPane().add(boton_S, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 487, 42, 42));

        boton_T.setText("T");
        boton_T.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                boton_TMousePressed(evt);
            }
        });
        getContentPane().add(boton_T, new org.netbeans.lib.awtextra.AbsoluteConstraints(298, 487, 42, 42));

        boton_Ñ.setText("Ñ");
        boton_Ñ.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                boton_ÑMousePressed(evt);
            }
        });
        getContentPane().add(boton_Ñ, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 487, 42, 42));

        boton_O.setText("O");
        boton_O.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                boton_OMousePressed(evt);
            }
        });
        getContentPane().add(boton_O, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 487, 42, 42));

        boton_P.setText("P");
        boton_P.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                boton_PMousePressed(evt);
            }
        });
        getContentPane().add(boton_P, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 487, 42, 42));

        boton_Q.setText("Q");
        boton_Q.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                boton_QMousePressed(evt);
            }
        });
        getContentPane().add(boton_Q, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 487, 42, 42));

        boton_X.setText("X");
        boton_X.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                boton_XMousePressed(evt);
            }
        });
        getContentPane().add(boton_X, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 540, 42, 42));

        boton_Y.setText("Y");
        boton_Y.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                boton_YMousePressed(evt);
            }
        });
        getContentPane().add(boton_Y, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 540, 42, 42));

        boton_Z.setText("Z");
        boton_Z.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                boton_ZMousePressed(evt);
            }
        });
        getContentPane().add(boton_Z, new org.netbeans.lib.awtextra.AbsoluteConstraints(298, 540, 42, 42));

        boton_U.setText("U");
        boton_U.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                boton_UMousePressed(evt);
            }
        });
        getContentPane().add(boton_U, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, 42, 42));

        boton_V.setText("V");
        boton_V.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                boton_VMousePressed(evt);
            }
        });
        getContentPane().add(boton_V, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 540, 42, 42));

        boton_W.setText("W");
        boton_W.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                boton_WMousePressed(evt);
            }
        });
        getContentPane().add(boton_W, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 540, 42, 42));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 280, 280));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_AMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_AMousePressed
        chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_boton_AMousePressed

    private void boton_BMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_BMousePressed
        chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_boton_BMousePressed

    private void boton_CMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_CMousePressed
        chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_boton_CMousePressed

    private void boton_DMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_DMousePressed
        chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_boton_DMousePressed

    private void boton_EMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_EMousePressed
        chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_boton_EMousePressed

    private void boton_FMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_FMousePressed
        chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_boton_FMousePressed

    private void boton_GMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_GMousePressed
        chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_boton_GMousePressed

    private void boton_LMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_LMousePressed
        chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_boton_LMousePressed

    private void boton_MMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_MMousePressed
        chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_boton_MMousePressed

    private void boton_NMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_NMousePressed
        chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_boton_NMousePressed

    private void boton_HMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_HMousePressed
        chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_boton_HMousePressed

    private void boton_IMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_IMousePressed
        chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_boton_IMousePressed

    private void boton_JMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_JMousePressed
        chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_boton_JMousePressed

    private void boton_KMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_KMousePressed
        chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_boton_KMousePressed

    private void boton_RMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_RMousePressed
        chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_boton_RMousePressed

    private void boton_SMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_SMousePressed
        chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_boton_SMousePressed

    private void boton_TMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_TMousePressed
        chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_boton_TMousePressed

    private void boton_ÑMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_ÑMousePressed
        chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_boton_ÑMousePressed

    private void boton_OMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_OMousePressed
        chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_boton_OMousePressed

    private void boton_PMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_PMousePressed
        chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_boton_PMousePressed

    private void boton_QMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_QMousePressed
        chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_boton_QMousePressed

    private void boton_XMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_XMousePressed
        chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_boton_XMousePressed

    private void boton_YMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_YMousePressed
        chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_boton_YMousePressed

    private void boton_ZMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_ZMousePressed
        chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_boton_ZMousePressed

    private void boton_UMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_UMousePressed
        chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_boton_UMousePressed

    private void boton_VMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_VMousePressed
        chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_boton_VMousePressed

    private void boton_WMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_WMousePressed
        chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_boton_WMousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaAhorcado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaAhorcado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaAhorcado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaAhorcado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaAhorcado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_A;
    private javax.swing.JButton boton_B;
    private javax.swing.JButton boton_C;
    private javax.swing.JButton boton_D;
    private javax.swing.JButton boton_E;
    private javax.swing.JButton boton_F;
    private javax.swing.JButton boton_G;
    private javax.swing.JButton boton_H;
    private javax.swing.JButton boton_I;
    private javax.swing.JButton boton_J;
    private javax.swing.JButton boton_K;
    private javax.swing.JButton boton_L;
    private javax.swing.JButton boton_M;
    private javax.swing.JButton boton_N;
    private javax.swing.JButton boton_O;
    private javax.swing.JButton boton_P;
    private javax.swing.JButton boton_Q;
    private javax.swing.JButton boton_R;
    private javax.swing.JButton boton_S;
    private javax.swing.JButton boton_T;
    private javax.swing.JButton boton_U;
    private javax.swing.JButton boton_V;
    private javax.swing.JButton boton_W;
    private javax.swing.JButton boton_X;
    private javax.swing.JButton boton_Y;
    private javax.swing.JButton boton_Z;
    private javax.swing.JButton boton_Ñ;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
