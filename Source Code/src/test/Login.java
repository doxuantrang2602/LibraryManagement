package test;



import javax.swing.UIManager;

import view.QLTV_View;
import view.SignIn;

public class Login {
	public static void main(String[] args) {

		try {
			 for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
	                if ("Nimbus".equals(info.getName())) {
	                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
	                    break;
	                }
	            }
			 new SignIn();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
