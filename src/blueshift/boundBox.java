/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blueshift;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author umitaksoylu
 */
public class boundBox extends javax.swing.JFrame {

    /**
     * Creates new form boundBox
     */
    main parent;
    public boundBox(main m, int x_, int y_, int w_, int h_) {
        
       parent = m;
       setUndecorated(true);
       initComponents();
       
       
      
       setOpacity(0.35f);
       
       JLabel l1,l2;
       JButton whSet,Apply;
       JTextField w,h;  

       l1 = new JLabel("Width:");  
       l1.setBounds(50,10, 100,30);
       
       w=new JTextField(String.valueOf(w_));  
       w.setBounds(100,10, 50,30);  
       
       
       l2 = new JLabel("Height:");
       l2.setBounds(150,10, 100,30);
       h=new JTextField(String.valueOf(h_));  
       h.setBounds(200,10, 50,30);  
       
       whSet=new JButton("Set Size");  
       whSet.setBounds(250,10,100,30);  
       
       
       Apply=new JButton("Apply Capture Zone");  
       Apply.setBounds(100,30,150,30);  
       
            
       
       this.add(w);
       this.add(h);
       this.add(l1);
       this.add(l2);
       this.add(whSet);
       this.add(Apply);
       
        
        // Set window width&height Button Listener
        whSet.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Insert code here
                setSize(Integer.parseInt(w.getText()),Integer.parseInt(h.getText()));
                
            }
        });
        
        // Apply Capture Zone Button Listener
        Apply.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int X,Y,W,H;
                X = getX();
                Y = getY();
                W = getWidth();
                H = getHeight();
                parent.setXYWH(X, Y, W, H);
                setVisible(false);
                dispose();
            }
        });

       

       FrameDragListener frameDragListener = new FrameDragListener(this);
       this.addMouseListener(frameDragListener);
       this.addMouseMotionListener(frameDragListener);

       this.pack();
       this.setLocationRelativeTo(null);
       this.setVisible(true);
    }

    private boundBox() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(boundBox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(boundBox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(boundBox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(boundBox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new boundBox().setVisible(true);

            }
        });
        
    }
    
    
  public static class FrameDragListener extends MouseAdapter {

        private final JFrame frame;
        private Point mouseDownCompCoords = null;

        public FrameDragListener(JFrame frame) {
            this.frame = frame;
        }

        public void mouseReleased(MouseEvent e) {
            mouseDownCompCoords = null;
        }

        public void mousePressed(MouseEvent e) {
            mouseDownCompCoords = e.getPoint();
        }

        public void mouseDragged(MouseEvent e) {
            Point currCoords = e.getLocationOnScreen();
            frame.setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
        }
    }
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}