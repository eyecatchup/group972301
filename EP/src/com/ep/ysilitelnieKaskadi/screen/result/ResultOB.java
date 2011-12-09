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

public class ResultOB implements BaseScreen {

	
	private JTable table_given;
	private JTable table_transistor;
	
	private JPanel CalculatePoint;
	private JTable table_OB;

	private static final Object[] GIVEN_COLOMNS = { "Òèï ÁÒ", 
		"Uêý0, Â", 
		"Iê, ìÀ", 
		"Eã, ìÂ", 
		"Rã, Îì", 
		"Rí, Îì", 
		"Cí, íÔ"};
	private static final Object[] TRANSISTOR_COLUMN = { "h21min", 
		"h21max", 
		"h21a", 
		"Cê, ïÔ", 
		"Cí, ïô" };
	private static final Object[] OB_COLUMN = { "Ua", "Uip", "Rk", "Ra", "Ib",  
		"Ub", "Id", "R1", "R2", "C1", 
		"C2", "Ca", "Cb", "Rvh", "Rb", 
		"Rvih", "Ki", "Ku", "Fn1", "Fn2", 
		"Fn3", "Fv1", "Fv2", "Fv3", "MvN", 
		"MnN"};

	private Object[][] mDataGiven = new Object[1][7];
	private Object[][] mDataTransistor = new Object[1][5];
	private Object[][] mDataOB = new Object[1][26];
	
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
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		scrollPane.setBounds(51, 89, 677, 41);
		CalculatePoint.add(scrollPane);

		table_given = new JTable(mDataGiven, GIVEN_COLOMNS);
		scrollPane.setViewportView(table_given);
		table_given.setBackground(Color.WHITE);
		table_given.setForeground(Color.GRAY);
		table_given.setColumnSelectionAllowed(true);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setEnabled(false);
		scrollPane_1.setBorder(BorderFactory.createEmptyBorder());
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(49, 202, 677, 58);
		CalculatePoint.add(scrollPane_1);

		table_transistor = new JTable(mDataTransistor, TRANSISTOR_COLUMN);
		scrollPane_1.setViewportView(table_transistor);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setEnabled(false);
		scrollPane_2.setBorder(BorderFactory.createEmptyBorder());
		scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane_2.setBounds(49, 333, 677, 41);
		CalculatePoint.add(scrollPane_2);

		table_OB = new JTable(mDataOB, OB_COLUMN);
		scrollPane_2.setViewportView(table_OB);
		
		JButton back_btn = new JButton("\u0412\u0435\u0440\u043D\u0443\u0442\u044C\u0441\u044F \u043D\u0430\u0437\u0430\u0434");
		back_btn.setBounds(577, 440, 168, 23);
		
		back_btn.addActionListener(backBtnListener);
		
		CalculatePoint.add(back_btn);
		
		return CalculatePoint;

	}
	
	public void setGiven(Object[][] data){
		for (int i = 0; i < 7; i++){
			mDataGiven[0][i] = data[0][i];
		}
	}
	
	public void setTransistor(Object[][] vipyamData) {
		for(int i = 0; i < 5; i++){
			mDataTransistor[0][i] = vipyamData[0][i];
		}
		
	}

	public void setOB(Object[][] s) {
		for(int i = 0; i < 26; i++){
			mDataOB[0][i] = s[0][i];
		}
	}

}
