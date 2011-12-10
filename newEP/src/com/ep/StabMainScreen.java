package com.ep;

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

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.entity.Group;
import com.entity.Kravchenko_data;
import com.entity.Lab;
import com.entity.OB_Transistor;
import com.entity.Student;
import com.entity.StudentLabs;
import com.entity.OB_Given;
import com.ep.diodiAndStabilitroni.CalculatorStabilitron;
import com.ep.diodiAndStabilitroni.Diod;
import com.ep.diodiAndStabilitroni.Given;
import com.ep.diodiAndStabilitroni.Stabilitron;
import com.ep.diodiAndStabilitroni.Vipremitel;
import com.ep.diodiAndStabilitroni.screen.add.AddStabNaprScreen;
import com.ep.diodiAndStabilitroni.screen.result.ResultStabilizatorNapr;
import com.ep.ysilitelnieKaskadi.screen.result.ResultOB;
import com.ep.ysilitelnieKaskadi.*;

@SuppressWarnings("serial")
public class StabMainScreen extends JFrame {

	private final JPanel contentPanel = new JPanel();
	private CardLayout cardLayout;
	private JComboBox theme_combobox;

	private static final String[] THEME = { "Стабилизатор напряжения",
			"Усилительные каскады" };
	private static final Integer[] VARIANT = { 1, 2, 3, 4, 5 };

	private static final String CALCULATE_POINT = "CalculatePoint";
	private static final String ENTER_POINT = "EnterPoint";
	private static final String MAIN_SCREEN = "Main_Screen";
	private static final String OB_CALCULATE_POINT = "OBCalculatePoint";

	private ResultStabilizatorNapr resultStabilizatorNapr = new ResultStabilizatorNapr(
			new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					cardLayout.show(contentPanel, MAIN_SCREEN);

				}
			});

	private ResultOB resultOB = new ResultOB(
			new ActionListener() {

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

			/*AnnotationConfiguration aconf;
			Configuration config;

			aconf = new AnnotationConfiguration()
					.addAnnotatedClass(Student.class)
					.addAnnotatedClass(Lab.class)
					.addAnnotatedClass(Group.class)
					.addAnnotatedClass(StudentLabs.class)
					.addAnnotatedClass(com.entity.Given.class)
					.addAnnotatedClass(com.entity.Stabilitron.class).addAnnotatedClass(OB_Given.class)
					.addAnnotatedClass(OB_Transistor.class)
					.addAnnotatedClass(Kravchenko_data.class);

			config = aconf.configure();

			SessionFactory sessionFactory = config.configure()
					.buildSessionFactory();*/

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
		// ////////////////////////////////////create class MainScreen
		// implements
		// BaseScreen///////////////////////////////////////////////////

		JPanel main_panel = new JPanel();
		contentPanel.add(main_panel, MAIN_SCREEN);
		main_panel.setLayout(null);

		theme_combobox = new JComboBox(THEME);
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
			}
		});

		view_data_btn.setBounds(247, 381, 200, 23);
		main_panel.add(view_data_btn);

		// //////////////////////////////////////////////////////////////////////////////////////
		contentPanel.add(resultStabilizatorNapr.getView(), CALCULATE_POINT);
		contentPanel.add(addStabNaprScreen.getView(), ENTER_POINT);
		contentPanel.add(resultOB.getView(), OB_CALCULATE_POINT);

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
		switch (theme_combobox.getSelectedIndex()){
		case 0:
			Given given = new Given(0.02, 6.8, 0.01, 1, true);
			Stabilitron stabilitron = new Stabilitron(6.8, 0.045, 0.003, 20, 0.06);
			CalculatorStabilitron calculatorStabilitron = new CalculatorStabilitron(given, stabilitron);

			resultStabilizatorNapr.setStabNaprData(calculatorStabilitron.getData());
			Vipremitel vipr = new Vipremitel(calculatorStabilitron.getStabilitron(), true);
			Diod diod = vipr.getDiod();
			resultStabilizatorNapr.setVipryamData(vipr.getVipyamData());
			resultStabilizatorNapr.setDiodData(diod.getDiodData());
			
			cardLayout.show(contentPanel, CALCULATE_POINT);
			break;
		case 1:
			GivenOB giv = new GivenOB("Tran1", 6, 0.006, 0.005, 2000, 2000, 0.0000000002);
			TransistorOB transistor = new TransistorOB(40, 100, 5); 
			CalculatorOB calculator = new CalculatorOB(giv, transistor);
			
			resultOB.setGiven(giv.getData());
			resultOB.setTransistor(transistor.getData());
			resultOB.setOB(calculator.getData());
			
			cardLayout.show(contentPanel, OB_CALCULATE_POINT);
			break;
		}
	}
}
