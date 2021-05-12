package Helper;

import javax.swing.*;

//hata mesajlar�n� bu helpere g�nderip ordan yap�ca��z

public class Metod_Helper {

	// butonlara t�rk�e kelime eklemek i�in

	public static void buttonTextChange() {

		UIManager.put("OptionPane.cancelButtonText", "�ptal");
		UIManager.put("OptionPane.okButtonText", "Tamam");
		UIManager.put("OptionPane.yesButtonText", "Evet");
		UIManager.put("OptionPane.noButtonText", "Hay�r");

	}

	public static void showMsg(String str) {
		String msg;
		buttonTextChange();
		switch (str) {

		case "fill":
			msg = "L�tfen bo� alanlar� doldurunuz";
			break;
		case "succes":
			msg = "��lem ba�ar�yla tamamland�";
			break;
		case "error":
			 msg = "Tuhaf �eyler oluyor";

		default:
			msg = str;
		}

		JOptionPane.showConfirmDialog(null, msg, "Mesaj", JOptionPane.CLOSED_OPTION);

	}

	public static boolean confirm(String str) {

		String msg;
		buttonTextChange();
		switch (str) {

		case "sure":
			msg = "	Bu i�lemi ger�ekle�tirmek istiyormusun";
			break;

		default:
			msg = str;
		}

		// JOptionpaneden evet yada hay�r a bas�nca 0 veya 1 d�nderen pane olu�turup
		// onun de�erlerini int bir de�i�kene at�yac��z burdan da ko�ula ba�l�yaca��z

		int result = JOptionPane.showConfirmDialog(null, msg, "Dikkat!", JOptionPane.YES_NO_OPTION);

		if (result == 0) {

			return true;

		} else {

			return false;

		}

	}

}
