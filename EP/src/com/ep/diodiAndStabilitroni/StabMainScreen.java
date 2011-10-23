package com.ep.diodiAndStabilitroni;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class StabMainScreen extends JFrame {

	private final JPanel contentPanel = new JPanel();
	private JPanel EnterPoint;
	private JPanel CalculatePoint;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private CardLayout cardLayout;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			StabMainScreen dialog = new StabMainScreen();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public StabMainScreen() {
		setResizable(false);
		setBounds(100, 100, 782, 512);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		cardLayout = new CardLayout();
		contentPanel.setLayout(cardLayout);

		EnterPoint = new JPanel();
		contentPanel.add(EnterPoint, "EnterPoint");
		EnterPoint.setLayout(null);
		{
			JLabel label_2 = new JLabel(
					"\u0418\u0441\u0445\u043E\u0434\u043D\u044B\u0435 \u0434\u0430\u043D\u043D\u044B\u0435");
			label_2.setBounds(383, 133, 158, 14);
			EnterPoint.add(label_2);
		}

		textField = new JTextField();
		textField.setBounds(391, 182, 86, 20);
		EnterPoint.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("U \u0432\u044B\u0445");
		lblNewLabel.setBounds(344, 185, 30, 14);
		EnterPoint.add(lblNewLabel);

		textField_1 = new JTextField();
		textField_1.setBounds(391, 244, 86, 20);
		EnterPoint.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblI = new JLabel("I\u043D");
		lblI.setBounds(344, 210, 30, 19);
		EnterPoint.add(lblI);

		JLabel lblU = new JLabel("\u0394U \u0432\u044B\u0445");
		lblU.setBounds(344, 247, 37, 14);
		EnterPoint.add(lblU);

		textField_2 = new JTextField();
		textField_2.setBounds(391, 213, 86, 20);
		EnterPoint.add(textField_2);
		textField_2.setColumns(10);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(539, 16, 2, 0);
		EnterPoint.add(separator_1);
		separator_1.setOrientation(SwingConstants.VERTICAL);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(546, 16, 2, 0);
		EnterPoint.add(separator_2);
		separator_2.setOrientation(SwingConstants.VERTICAL);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(553, 15, 0, 2);
		EnterPoint.add(separator_3);

		JSeparator separator = new JSeparator();
		separator.setBounds(558, 15, 0, 2);
		EnterPoint.add(separator);

		JButton calc = new JButton(
				"\u0420\u0430\u0441\u0441\u0447\u0438\u0442\u0430\u0442\u044C");
		calc.setBounds(386, 289, 91, 23);
		EnterPoint.add(calc);
		
		calc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.show(contentPanel, "CalculatePoint");
				
			}
		});

		JLabel label = new JLabel("\u0412");
		label.setBounds(487, 183, 23, 19);
		EnterPoint.add(label);

		JLabel label_1 = new JLabel("\u043C\u0410");
		label_1.setBounds(487, 215, 19, 14);
		EnterPoint.add(label_1);

		JLabel label_4 = new JLabel("\u043C\u0412");
		label_4.setBounds(487, 245, 23, 19);
		EnterPoint.add(label_4);

		CalculatePoint = new JPanel();
		contentPanel.add(CalculatePoint, "CalculatePoint");
		CalculatePoint.setLayout(null);

		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(212, 428, 533, 1);
		CalculatePoint.add(separator_5);

		JSeparator separator_6 = new JSeparator();
		separator_6.setOrientation(SwingConstants.VERTICAL);
		separator_6.setBounds(744, 28, 1, 400);
		CalculatePoint.add(separator_6);

		JSeparator separator_4 = new JSeparator();
		separator_4.setOrientation(SwingConstants.VERTICAL);
		separator_4.setBounds(212, 28, 533, 400);
		CalculatePoint.add(separator_4);

		JSeparator separator_7 = new JSeparator();
		separator_7.setBounds(212, 27, 533, 2);
		CalculatePoint.add(separator_7);

		JLabel label_3 = new JLabel(
				"\u041F\u043E\u043B\u0443\u0447\u0435\u043D\u043D\u044B\u0435 \u0434\u0430\u043D\u043D\u044B\u0435");
		label_3.setBounds(410, 44, 145, 14);
		CalculatePoint.add(label_3);
	

	}
}
