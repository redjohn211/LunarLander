import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame frame= new JFrame("Lunar Landing");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

frame.getContentPane().add(new LaunchPanel());
frame.pack();
        frame.setVisible(true);
    }
}
