package Main;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Arrays;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SpringLayout.Constraints;

import Sorters.Sorter;
import Utilities.RandomNumberGenerator;
import Utilities.SorterFactory;
import Utilities.SorterFactory.SorterType;

public class MainDesktop implements ActionListener {
	JFrame frame;
	JPanel mainPanel;
	Integer[] valuesToSort;

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});

	}

	protected static void createAndShowGUI() {
		MainDesktop window = new MainDesktop();

		window.frame = new JFrame("FrameDemo");
		window.frame.setLocation(200, 100);
		window.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		window.mainPanel = new JPanel();
		window.mainPanel.setPreferredSize(computeWindowSize());
		window.mainPanel.add(new JLabel("Unsorted Values(randomly generated):"));

		window.valuesToSort = RandomNumberGenerator.generateInts(10);

		window.mainPanel.add(new JLabel(Arrays.deepToString(window.valuesToSort)));

		Button sortButton = new Button("Sort");
		sortButton.addActionListener(window);
		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(new GridLayout(0, 1));
		leftPanel.add(sortButton);

		JRadioButton bubble = new JRadioButton("bubble sort");
		bubble.setMnemonic(KeyEvent.VK_B);
		JRadioButton selection = new JRadioButton("selection sort");
		bubble.setMnemonic(KeyEvent.VK_S);
		JRadioButton insertion = new JRadioButton("insertion sort");
		bubble.setMnemonic(KeyEvent.VK_I);
		JRadioButton merge = new JRadioButton("merge sort");
		bubble.setMnemonic(KeyEvent.VK_M);
		merge.setSelected(true);

		ButtonGroup group = new ButtonGroup();
		group.add(bubble);
		group.add(selection);
		group.add(insertion);
		group.add(merge);

		leftPanel.add(bubble, BorderLayout.CENTER);
		leftPanel.add(selection);
		leftPanel.add(insertion);
		leftPanel.add(merge);
		Box box = Box.createVerticalBox();
		leftPanel.add(box);

		window.frame.add(leftPanel, BorderLayout.WEST);

		window.frame.getContentPane().add(new JLabel("Sort"), BorderLayout.PAGE_START);
		window.frame.getContentPane().add(window.mainPanel, BorderLayout.CENTER);

		window.frame.pack();
		window.frame.setVisible(true);

	}

	private static Dimension computeWindowSize() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		return new Dimension((int) width / 2, (int) height / 2);
	}

	public void actionPerformed(ActionEvent e) {
		Sorter sorter = SorterFactory.getSorter(SorterType.MERGE);
		Integer[] sortedValues = Arrays.copyOf(valuesToSort, valuesToSort.length);
		sorter.sort(sortedValues);
		JPanel sortedValuesPanel = new JPanel();
		sortedValuesPanel.add(new JLabel("\nSorted Values:"));
		sortedValuesPanel.add(new JLabel(Arrays.deepToString(sortedValues)));
		mainPanel.add(sortedValuesPanel);
		frame.pack();
	}
}
