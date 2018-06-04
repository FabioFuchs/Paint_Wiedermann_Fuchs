package paint;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
/**
 * Das Panel zeigt alle Erstellten Elemente aus PaintFrame an
 * @author Barbara Wiedermann und Fabio Fuchs
 * @version 04.06.2018
 */

public class Panel extends JPanel {
	// Serializable
	private static final long serialVersionUID = 1L;

	JRadioButton[] layers;
	int selectedLayer;
	JPanel rechts;

	/**
	 * Erzeugt das Panel mit dem Frame.
	 * 
	 * @param controller
	 *            der Controller
	 * @param frame
	 *            das Frame
	 */
	public Panel(Controller controller, Frame frame) {
		// TODO Buttons
		JPanel links = new JPanel();
		links.setLayout(new GridLayout());

		// TODO Layer
		this.refreshLayers(frame);

		// MouseListeners hinzufügen
		frame.addMouseListener(controller);
		frame.addMouseMotionListener(controller);

		this.setLayout(new BorderLayout());
		this.add(frame);
		this.add(links, BorderLayout.WEST);
		this.add(rechts, BorderLayout.EAST);
	}

	public void refreshLayers(Frame frame) {
		rechts = new JPanel(new GridLayout(frame.getIndex(), 1));
		layers = new JRadioButton[frame.getIndex()];

		for (int i = 0; i < frame.getIndex(); i++) {
			// layers[i].add(comp)

		}

		if (frame.getElements().size() > 0) {
			// layer1 = new Layer(frame.createImage(0));

			this.revalidate();
		}
	}
}
