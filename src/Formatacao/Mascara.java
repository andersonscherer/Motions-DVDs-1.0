package Formatacao;

import java.text.ParseException;
import java.time.format.DateTimeFormatter;

import javax.swing.text.MaskFormatter;

public class Mascara {
	
	public static MaskFormatter getTelefoneMask()  {
		try {
			return new MaskFormatter("(##) ####-####");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static MaskFormatter getCpfMask()  {
		try {
			return new MaskFormatter("###.###.###-##");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static MaskFormatter getDatas()  {
		try {
			return new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static DateTimeFormatter formatadorDatas() {
		return DateTimeFormatter.ofPattern("dd/MM/yyyy");
	}
		
}
