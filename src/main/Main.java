package main;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {

        JFrame window = new JFrame(); 
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("The Bomberman");

        Panel panel = new Panel();
        window.getContentPane().add(panel);
        window.pack();
        
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        
        panel.setupGame();
        
        panel.iniciar_hilo();
    }
}
