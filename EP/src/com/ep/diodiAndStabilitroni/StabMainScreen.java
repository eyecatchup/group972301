package com.ep.diodiAndStabilitroni;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class StabMainScreen extends JFrame {

	private final JPanel contentPanel = new JPanel();
	private JPanel EnterPoint;
	private JPanel CalculatePoint;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private CardLayout cardLayout;
	private JTable table_param_stab_napr;
	private JTable table_param_stab_vipr_dioda;
	private JTable table_vipr_napr;
	private JLabel label_param_stab_napr;
	private JLabel label_param_vipr_dioda;

	private static final Object[] STAB_COLOMNS = { "Тип стабилитрона",
			"Uвх ст, В", "\u0394Uвх ст, В", "Uвых, В", "\u0394Uвых т, В",
			"\u0394Uвых, В", "Iст, А", "Ir, А", "Kст", "Rн, Ом", "Rг, Ом" };
	private static final Object[] VIPR_DIOD_COLUMN = {"Тип диода" ,"Iпр мак, А",
			"Iпр и макс, А", "Uобр макс, В", "t обр вос" };
	private static final Object[] VIPR_NAPR = {"Тип диода", "С, Ф", "Uм обр, В", "Uвх м, В"};

	private Object [][] mData = new Object[1][11];
	private Object [][] mDataDiod = new Object [1][5];
	private Object [][] mDataViprNapr = new Object [1][5];

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

		enterPointView();
		calculatedView();

	}

	private void enterPointView() {
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

		calc.addActionListener(calcListener());

		JLabel label = new JLabel("\u0412");
		label.setBounds(487, 183, 23, 19);
		EnterPoint.add(label);

		JLabel label_1 = new JLabel("\u043C\u0410");
		label_1.setBounds(487, 215, 19, 14);
		EnterPoint.add(label_1);

		JLabel label_4 = new JLabel("\u043C\u0412");
		label_4.setBounds(487, 245, 23, 19);
		EnterPoint.add(label_4);
	}

	private void calculatedView() {
		CalculatePoint = new JPanel();
		contentPanel.add(CalculatePoint, "CalculatePoint");
		CalculatePoint.setLayout(null);

		label_param_stab_napr = new JLabel(
				"\u041F\u0430\u0440\u0430\u043C\u0435\u0442\u0440\u044B \u0441\u0442\u0430\u0431\u0438\u043B\u0438\u0437\u0430\u0442\u043E\u0440\u0430 \u043D\u0430\u043F\u0440\u044F\u0436\u0435\u043D\u0438\u044F");
		label_param_stab_napr.setBounds(51, 64, 311, 14);
		CalculatePoint.add(label_param_stab_napr);

		label_param_vipr_dioda = new JLabel(
				"\u041F\u0430\u0440\u0430\u043C\u0435\u0442\u0440\u044B \u0432\u044B\u043F\u0440\u044F\u043C\u0438\u0442\u0435\u043B\u044C\u043D\u043E\u0433\u043E \u0434\u0438\u043E\u0434\u0430");
		label_param_vipr_dioda.setBounds(51, 177, 311, 14);
		CalculatePoint.add(label_param_vipr_dioda);

		JLabel label_param_vipr_napr = new JLabel(
				"\u041F\u0430\u0440\u0430\u043C\u0435\u0442\u0440\u044B \u0432\u044B\u043F\u0440\u044F\u043C\u0438\u0442\u0435\u043B\u044C\u043D\u043E\u0433\u043E \u043D\u0430\u043F\u0440\u044F\u0436\u0435\u043D\u0438\u044F");
		label_param_vipr_napr.setBounds(49, 308, 325, 14);
		CalculatePoint.add(label_param_vipr_napr);

		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(29, 428, 716, 14);
		CalculatePoint.add(separator_5);

		JSeparator separator_6 = new JSeparator();
		separator_6.setOrientation(SwingConstants.VERTICAL);
		separator_6.setBounds(744, 28, 1, 400);
		CalculatePoint.add(separator_6);

		JSeparator separator_4 = new JSeparator();
		separator_4.setOrientation(SwingConstants.VERTICAL);
		separator_4.setBounds(29, 28, 1, 400);
		CalculatePoint.add(separator_4);

		JSeparator separator_7 = new JSeparator();
		separator_7.setBounds(29, 28, 716, 2);
		CalculatePoint.add(separator_7);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		scrollPane.setBounds(51, 89, 677, 41);
		CalculatePoint.add(scrollPane);

		table_param_stab_napr = new JTable(mData, STAB_COLOMNS);
		scrollPane.setViewportView(table_param_stab_napr);
		table_param_stab_napr.setBackground(Color.WHITE);
		table_param_stab_napr.setForeground(Color.GRAY);
		table_param_stab_napr.setColumnSelectionAllowed(true);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setEnabled(false);
		scrollPane_1.setBorder(BorderFactory.createEmptyBorder());
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(49, 202, 677, 58);
		CalculatePoint.add(scrollPane_1);

		table_param_stab_vipr_dioda = new JTable(mDataDiod, VIPR_DIOD_COLUMN);
		scrollPane_1.setViewportView(table_param_stab_vipr_dioda);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setEnabled(false);
		scrollPane_2.setBorder(BorderFactory.createEmptyBorder());
		scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane_2.setBounds(49, 333, 677, 41);
		CalculatePoint.add(scrollPane_2);

		table_vipr_napr = new JTable(mDataViprNapr, VIPR_NAPR);
		scrollPane_2.setViewportView(table_vipr_napr);
	}

	private ActionListener calcListener() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.show(contentPanel, "CalculatePoint");

				Given given = new Given(0.02, 6.8, 0.01, 1, true);
				StabilizatorNapr stabilizatorNapr;
				Stabilitron stabilitron = new Stabilitron(6.8, 0.045, 0.003,
						20, 0.06);
				CalculatorStabilitron calculatorStabilitron = new CalculatorStabilitron(
						given, stabilitron);

				stabilizatorNapr = calculatorStabilitron.getStabilitron();

				mData[0][0] = "Hello";
				mData[0][1] = stabilizatorNapr
						.getPostNagrNaWhodeStabilizatora();
				mData[0][2] = stabilizatorNapr.getAmplitudePuls();
				mData[0][3] = given.getNaprWihodnoe();
				mData[0][4] = stabilizatorNapr.getTemperUhod();
				mData[0][5] = given.getDeltaNaprWihodnoe();
				mData[0][6] = stabilizatorNapr.getRabTokStabilitrona();
				mData[0][7] = stabilizatorNapr.getTokGosResistora();
				mData[0][8] = stabilizatorNapr.getCoefStabiliz();
				mData[0][9] = stabilizatorNapr.getSoprNagruzki();
				mData[0][10] = stabilizatorNapr.getSoprotGosResis();
				
				
				Vipremitel vipr = new Vipremitel(stabilizatorNapr, true);
				Diod diod = vipr.getDiod();
				
				mDataDiod [0][0] = diod.getName();
				mDataDiod [0][1] = diod.getTok_maks();
				mDataDiod [0][2] = diod.getTok_i_maks();
				mDataDiod [0][3] = diod.getNapr_maks();
				mDataDiod [0][4] = diod.getT_obr();
				
				mDataViprNapr [0][0] = diod.getName();
				mDataViprNapr [0][1] = vipr.getEmkost();
				mDataViprNapr [0][2] = vipr.getNaprObr();
				mDataViprNapr [0][3] = vipr.getNaprVxod();
				
			}
		};
	}
}
