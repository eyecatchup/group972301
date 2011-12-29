package com.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.faces.event.ValueChangeEvent;

import org.hibernate.classic.Session;

import com.logic.AppLogic;

import dao.GivenDAOImpl;
import dao.OB_GivenDAOImpl;
import entity.GivenOB;
import ep.HibernateUtil;

public class MainService {
	private static String theme0 = "Тема - Диоды и стабилитрны";
	private static String theme1 = "Тема - Влада";
	private static String theme2 = "Тема - Вити";

	private static Map<Integer, Integer> variants0;
	private static Map<Integer, Integer> variants1;
	private static int choosedTheme_0_Var;
	private static int choosedTheme_1_Var;

	private DiodiAndStabilitrManager stabilizatorNaprManager = new DiodiAndStabilitrManager();
	private OBManager obManager = new OBManager();

	// private static Map<Integer, Integer> variants2 = new
	// LinkedHashMap<Integer, Integer>();

	private String choosenTheme;

	static {
		variants0 = new LinkedHashMap<Integer, Integer>();
		variants1 = new LinkedHashMap<Integer, Integer>();
		getStabilitronVariants();
		getObVariants();
	}

	private static void getObVariants() {
		OB_GivenDAOImpl daoImpl = new OB_GivenDAOImpl();
		daoImpl.setSession(HibernateUtil.getSessionFactory().openSession());
		List<Integer> list = daoImpl.getVariants();
		daoImpl.getSession().close();

		//System.out.println(list.size());
		for (int i : list) {
			variants1.put(i, i);
		}

	}

	public String checkResult_0() {
		stabilizatorNaprManager.caltulate(theme0);

		return AppLogic.DIODO_STABILITRONI_CHECK;
	}
	
	public String checkResult_1() {
		//stabilizatorNaprManager.caltulate(theme0);
		obManager.calculate(theme1);
		return AppLogic.OB_CHECK;
	}

	private static void getStabilitronVariants() {
		GivenDAOImpl daoImpl = new GivenDAOImpl();
		daoImpl.setSession(HibernateUtil.getSessionFactory().openSession());
		List<Integer> list = daoImpl.getVariants();
		daoImpl.getSession().close();

		// System.out.println(list.size());
		for (int i : list) {
			variants0.put(i, i);
		}
	}

	public void choosedTheme_0_Variant(ValueChangeEvent event) {
		if (event.getNewValue() != null) {
			setChoosedTheme_0_Var(Integer
					.parseInt((String) event.getNewValue()));

			GivenDAOImpl daoImpl = new GivenDAOImpl();
			daoImpl.setSession(HibernateUtil.getSessionFactory().openSession());
			stabilizatorNaprManager.setGiven(daoImpl
					.getGivenByVariant(choosedTheme_0_Var));
			daoImpl.getSession().close();
		}

	}

	public void choosedTheme_1_Variant(ValueChangeEvent event) {
		if (event.getNewValue() != null) {
			setChoosedTheme_1_Var(Integer
					.parseInt((String) event.getNewValue()));
			System.out.println(choosedTheme_1_Var);

			OB_GivenDAOImpl daoImpl = new OB_GivenDAOImpl();
			Session session = HibernateUtil.getSessionFactory().openSession();
			daoImpl.setSession(session);
			GivenOB givenOB = daoImpl.getGivenByVariant(choosedTheme_1_Var);
			obManager.setGiven(givenOB);
			session.close();

		}

	}

	public String showStabData() {
		return AppLogic.DIODI_STABILITRONI;
	}

	public String showOBdata() {
		return AppLogic.OB;
	}

	public String getChoosenTheme() {
		return choosenTheme;
	}

	public void setChoosenTheme(String choosenTheme) {
		this.choosenTheme = choosenTheme;
	}

	public Map<Integer, Integer> getVariants0() {
		return variants0;
	}

	public void setVariants0(Map<Integer, Integer> variants0) {
		MainService.variants0 = variants0;
	}

	public Map<Integer, Integer> getVariants1() {
		return variants1;
	}

	public void setVariants1(Map<Integer, Integer> variants1) {
		MainService.variants1 = variants1;
	}

	public String getTheme0() {
		return theme0;
	}

	public void setTheme0(String theme0) {
		MainService.theme0 = theme0;
	}

	public String getTheme1() {
		return theme1;
	}

	public void setTheme1(String theme1) {
		MainService.theme1 = theme1;
	}

	public String getTheme2() {
		return theme2;
	}

	public void setTheme2(String theme2) {
		MainService.theme2 = theme2;
	}

	public static int getChoosedTheme_0_Var() {
		return choosedTheme_0_Var;
	}

	public static void setChoosedTheme_0_Var(int choosedTheme_0_Var) {
		MainService.choosedTheme_0_Var = choosedTheme_0_Var;
	}

	public static int getChoosedTheme_1_Var() {
		return choosedTheme_1_Var;
	}

	public static void setChoosedTheme_1_Var(int choosedTheme_1_Var) {
		MainService.choosedTheme_1_Var = choosedTheme_1_Var;
	}

	public DiodiAndStabilitrManager getStabilizatorNaprManager() {
		return stabilizatorNaprManager;
	}

	public void setStabilizatorNaprManager(
			DiodiAndStabilitrManager stabilizatorNaprManager) {
		this.stabilizatorNaprManager = stabilizatorNaprManager;
	}

	public OBManager getObManager() {
		return obManager;
	}

	public void setObManager(OBManager obManager) {
		this.obManager = obManager;
	}

}
