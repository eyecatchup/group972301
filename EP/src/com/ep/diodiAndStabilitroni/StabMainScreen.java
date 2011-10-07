package com.ep.diodiAndStabilitroni;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.CardLayout;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JSlider;

public class StabMainScreen extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

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
		setBounds(100, 100, 628, 337);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel label = new JLabel("\u0418\u0441\u0445\u043E\u0434\u043D\u044B\u0435 \u0434\u0430\u043D\u043D\u044B\u0435");
			label.setBounds(55, 44, 113, 14);
			contentPanel.add(label);
		}
		
		textField = new JTextField();
		textField.setBounds(112, 69, 56, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u0422\u043E\u043A");
		lblNewLabel.setBounds(21, 72, 25, 14);
		contentPanel.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(112, 100, 56, 20);
		contentPanel.add(textField_1);
		
		JLabel label = new JLabel("\u041D\u0430\u043F\u0440 \u0432\u044B\u0445");
		label.setBounds(21, 103, 73, 14);
		contentPanel.add(label);
		
		JLabel label_1 = new JLabel("\u0414\u0435\u043B \u043D\u0430\u043F\u0440 \u0432\u044B\u0445");
		label_1.setBounds(21, 134, 73, 14);
		contentPanel.add(label_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(112, 131, 56, 20);
		contentPanel.add(textField_2);
		
		JLabel label_2 = new JLabel("\u041D\u0430\u043F\u0440 \u0432\u044B\u0445");
		label_2.setBounds(21, 165, 73, 14);
		contentPanel.add(label_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(112, 162, 56, 20);
		contentPanel.add(textField_3);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(190, 27, 1, 189);
		contentPanel.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(10, 27, 1, 189);
		contentPanel.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(10, 216, 181, 2);
		contentPanel.add(separator_3);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 26, 181, 2);
		contentPanel.add(separator);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setOrientation(SwingConstants.VERTICAL);
		separator_4.setBounds(212, 28, 1, 189);
		contentPanel.add(separator_4);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(212, 217, 375, 2);
		contentPanel.add(separator_5);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setOrientation(SwingConstants.VERTICAL);
		separator_6.setBounds(586, 28, 1, 189);
		contentPanel.add(separator_6);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setBounds(212, 27, 375, 2);
		contentPanel.add(separator_7);
		
		JLabel label_3 = new JLabel("\u041F\u043E\u043B\u0443\u0447\u0435\u043D\u043D\u044B\u0435 \u0434\u0430\u043D\u043D\u044B\u0435");
		label_3.setBounds(344, 44, 118, 14);
		contentPanel.add(label_3);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
