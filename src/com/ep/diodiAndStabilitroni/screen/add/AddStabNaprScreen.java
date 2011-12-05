package com.ep.diodiAndStabilitroni.screen.add;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.ep.diodiAndStabilitroni.screen.base.BaseScreen;

public class AddStabNaprScreen implements BaseScreen {

	private JPanel EnterPoint;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	private ActionListener action;
	
	public AddStabNaprScreen(ActionListener listener) {
		action = listener;
	}

	@Override
	public JPanel getView() {
		EnterPoint = new JPanel();
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

		calc.addActionListener(action);

		JLabel label = new JLabel("\u0412");
		label.setBounds(487, 183, 23, 19);
		EnterPoint.add(label);

		JLabel label_1 = new JLabel("\u043C\u0410");
		label_1.setBounds(487, 215, 19, 14);
		EnterPoint.add(label_1);

		JLabel label_4 = new JLabel("\u043C\u0412");
		label_4.setBounds(487, 245, 23, 19);
		EnterPoint.add(label_4);
		return EnterPoint;
	}

}
