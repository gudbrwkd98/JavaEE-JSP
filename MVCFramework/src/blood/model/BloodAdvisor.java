package blood.model;

public class BloodAdvisor {
	public String getAdvice(String blood) {
		String msg = null;

		if (blood.equals("AÇü")) {
			msg = "²Ä²Ä";
		} else if (blood.equals("BÇü")) {
			msg = "È°¹ß";
		} else if (blood.equals("OÇü")) {
			msg = "»ç±³¼º";
		} else if (blood.equals("ABÇü")) {
			msg = "°áÁ¤¹Ù²ñ";
		}

		return msg;
	}
}
