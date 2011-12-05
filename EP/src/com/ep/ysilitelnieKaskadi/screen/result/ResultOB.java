package com.ep.ysilitelnieKaskadi.screen.result;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import com.ep.diodiAndStabilitroni.screen.base.BaseScreen;

public class ResultOB implements BaseScreen{
		
	private JTable table_param_stab_vipr_dioda;
	private JTable table_vipr_napr;
	
	private JPanel CalculatePoint;
	private JTable table_param_stab_napr;

	private static final Object[] OB_COLOMNS = { "Òèï ÁÒ", "Uêý0, Â", "Iê, À", "Åã, ìÂ", "Rã, ÎÌ", "Rí, Îì", "Ñí, ìÔ"};
	private static final Object[] OB_COLUMNS_RES = { "fí1, Ãö", "fí2, Ãö", "fí3, Ãö", "fâ1, Ãö", "fâ2, Ãö", "fâ3, Ãö", "MâN", "MíN"};

	private Object[][] mOBData = new Object[1][7];
	private Object[][] mOBData_Result = new Object[1][8];
	
	private ActionListener backBtnListener;

	public ResultOB(ActionListener listener) {
		backBtnListener = listener;
	}
	
	@Override
	public JPanel getView() {
		CalculatePoint = new JPanel();
		
		CalculatePoint.setLayout(null);

		JLabel label_param_stab_napr = new JLabel(
				"\u041F\u0430\u0440\u0430\u043C\u0435\u0442\u0440\u044B \u0441\u0442\u0430\u0431\u0438\u043B\u0438\u0437\u0430\u0442\u043E\u0440\u0430 \u043D\u0430\u043F\u0440\u044F\u0436\u0435\u043D\u0438\u044F");
		label_param_stab_napr.setBounds(51, 64, 311, 14);
		CalculatePoint.add(label_param_stab_napr);

		JLabel label_param_vipr_dioda = new JLabel(
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

		table_param_stab_napr = new JTable(mOBData, OB_COLOMNS);
		scrollPane.setViewportView(table_param_stab_napr);
		table_param_stab_napr.setBackground(Color.WHITE);
		table_param_stab_napr.setForeground(Color.GRAY);
		table_param_stab_napr.setColumnSelectionAllowed(true);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setEnabled(false);
		scrollPane_1.setBorder(BorderFactory.createEmptyBorder());
		scrollPane_1
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(49, 202, 677, 58);
		CalculatePoint.add(scrollPane_1);

		table_param_stab_vipr_dioda = new JTable(mOBData_Result, OB_COLUMNS_RES);
		scrollPane_1.setViewportView(table_param_stab_vipr_dioda);
		
		
		JButton back_btn = new JButton("\u0412\u0435\u0440\u043D\u0443\u0442\u044C\u0441\u044F \u043D\u0430\u0437\u0430\u0434");
		back_btn.setBounds(577, 440, 168, 23);
		
		back_btn.addActionListener(backBtnListener);
		
		CalculatePoint.add(back_btn);
		
		return CalculatePoint;

	}
	
	public void setOBData(Object[][] data){
		for (int i = 0; i < 7; i++){
			mOBData[0][i] = data[0][i];
		}
	}
	
	public void setOBData_Result(Object[][] data) {
		for(int i = 0; i < 8; i++){
			mOBData_Result[0][i] = data[0][i];
		}
		
	}

}
