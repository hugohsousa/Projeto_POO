import javax.swing.SwingUtilities;

/**
 * Inicia o programa.
 * 
 * @author (Grupo 12)
 */
public class RunApp {
    private RunApp() {
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
           public void run() {
                Model model = new Model();
                Controller controller = new Controller(model);
                View view = new View(controller);
                view.run();
           } 
        });
    }
}
