package test;

import view.QLTV_View;

public class Test {
	public static void main(String[] args) {
		try {
			 for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
	                if ("Nimbus".equals(info.getName())) {
	                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
	                    break;
	                }
	            }
			new QLTV_View();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
