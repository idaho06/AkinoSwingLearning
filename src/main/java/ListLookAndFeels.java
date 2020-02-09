import javax.swing.*;

public class ListLookAndFeels {
    public static void main(String[] args) {
        for (UIManager.LookAndFeelInfo lafi : UIManager.getInstalledLookAndFeels()) {
            System.out.println(lafi);
        }
    }
}
