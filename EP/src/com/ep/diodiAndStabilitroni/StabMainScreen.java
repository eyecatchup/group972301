package com.ep.diodiAndStabilitroni;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.ep.diodiAndStabilitroni.screen.add.AddStabNaprScreen;
import com.ep.diodiAndStabilitroni.screen.result.ResultStabilizatorNapr;

@SuppressWarnings("serial")
public class StabMainScreen extends JFrame {

	private final JPanel contentPanel = new JPanel();
	private CardLayout cardLayout;

	private static final String[] THEME = { "Стабилизатор напряжения" };
	private static final Integer[] VARIANT = { 1, 2, 3, 4, 5 };

	private static final String CALCULATE_POINT = "CalculatePoint";
	private static final String ENTER_POINT = "EnterPoint";
	private static final String MAIN_SCREEN = "Main_Screen";

	private ResultStabilizatorNapr resultStabilizatorNapr = new ResultStabilizatorNapr(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			cardLayout.show(contentPanel, MAIN_SCREEN);
			
		}
	});
	private AddStabNaprScreen addStabNaprScreen = new AddStabNaprScreen(
			calcListener());

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
		setForeground(Color.ORANGE);
		setBounds(100, 100, 782, 512);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		cardLayout = new CardLayout();
		contentPanel.setLayout(cardLayout);
		// ////////////////////////////////////create class MainScreen implements BaseScreen///////////////////////////////////////////////////

		JPanel main_panel = new JPanel();
		contentPanel.add(main_panel, MAIN_SCREEN);
		main_panel.setLayout(null);

		JComboBox theme_combobox = new JComboBox(THEME);
		theme_combobox.setBounds(346, 158, 275, 20);
		main_panel.add(theme_combobox);

		JLabel theme_label = new JLabel("\u0422\u0435\u043C\u0430");
		theme_label.setBounds(244, 158, 85, 20);
		main_panel.add(theme_label);

		JComboBox var_combobox = new JComboBox(VARIANT);
		var_combobox.setBounds(346, 206, 139, 20);
		main_panel.add(var_combobox);

		JLabel var_label = new JLabel(
				"\u0412\u0430\u0440\u0438\u0430\u043D\u0442");
		var_label.setBounds(244, 209, 85, 20);
		main_panel.add(var_label);

		JButton eter_new_data = new JButton(
				"\u0412\u0432\u0435\u0441\u0442\u0438 \u0441\u0432\u043E\u0438 \u0434\u0430\u043D\u044B\u0435");
		
		eter_new_data.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.show(contentPanel, ENTER_POINT);
			}
		});
		
		eter_new_data.setBounds(497, 381, 200, 23);
		main_panel.add(eter_new_data);

		JButton view_data_btn = new JButton(
				"\u041F\u043E\u0441\u043C\u043E\u0442\u0440\u0435\u0442\u044C \u0434\u0430\u043D\u043D\u044B\u0435");
		
		view_data_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calculateStabNap();
				cardLayout.show(contentPanel, CALCULATE_POINT);
			}
		});
		
		view_data_btn.setBounds(247, 381, 200, 23);
		main_panel.add(view_data_btn);

		// //////////////////////////////////////////////////////////////////////////////////////
		contentPanel.add(addStabNaprScreen.getView(), ENTER_POINT);
		contentPanel.add(resultStabilizatorNapr.getView(), CALCULATE_POINT);

	}

	private ActionListener calcListener() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				calculateStabNap();

			}

		};
	}

	private void calculateStabNap() {
		cardLayout.show(contentPanel, "CalculatePoint");

		Given given = new Given(0.02, 6.8, 0.01, 1, true);
		Stabilitron stabilitron = new Stabilitron(6.8, 0.045, 0.003, 20, 0.06);
		CalculatorStabilitron calculatorStabilitron = new CalculatorStabilitron(
				given, stabilitron);

		resultStabilizatorNapr.setStabNaprData(calculatorStabilitron.getData());

		Vipremitel vipr = new Vipremitel(
				calculatorStabilitron.getStabilitron(), true);
		Diod diod = vipr.getDiod();
		resultStabilizatorNapr.setVipryamData(vipr.getVipyamData());
		resultStabilizatorNapr.setDiodData(diod.getDiodData());
	}
}
