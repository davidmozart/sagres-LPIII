package view.util;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class LimitaCaracteres extends PlainDocument{

	private static final long serialVersionUID = 1L;

	
	public enum TipoEntrada{
		NUMEROINTEIRO, NUMERODECIMAL, NOME, EMAIL, DATA;
	};
	private int qtdCaracteres;
	private TipoEntrada tpEntrada;

	public LimitaCaracteres(int qtdCaracteres, TipoEntrada tpEntrada) {
		super();
		this.qtdCaracteres = qtdCaracteres;
		this.tpEntrada = tpEntrada;
	}

	@Override
	public void insertString(int arg0, String arg1, AttributeSet arg2) throws BadLocationException {
		if(arg1 == null || getLength() == qtdCaracteres) {
			return;
		}
		int totalCarac = getLength() + arg1.length();
		
		String regex = "";
		switch (tpEntrada) {
		case NUMEROINTEIRO: regex = "[^0-9]"; break;
		case NUMERODECIMAL: regex = "[^0-9.,]"; break;
		case NOME: regex = "[^\\p{IsLatin} ]"; break;
		case EMAIL: regex = "[^\\p{IsLatin}@.\\-_][^0-9]"; break;
		case DATA: regex = "[^0-9]"; break;
		}
		
		arg1 = arg1.replaceAll(regex, "");
		
		if(totalCarac <= qtdCaracteres) {
			super.insertString(arg0, arg1, arg2);
		} else {
			String nova = arg1.substring(0, qtdCaracteres);
			super.insertString(arg0, nova, arg2);
		}
		
		//super.insertString(arg0, arg1, arg2);
	}
	
	
}
