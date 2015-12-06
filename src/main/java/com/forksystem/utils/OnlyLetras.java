package com.forksystem.utils;

import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class OnlyLetras extends PlainDocument{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OnlyLetras() {
		super();
	}

	
	
	 // Sempre usar verbo no infinitivo para criar metodos
    public void insertString(int offs, String str,
            javax.swing.text.AttributeSet a) throws BadLocationException {
 
        // normalmente apenas uma letra é inserida por vez,
        // mas fazendo assim também previne caso o usuário
        // cole algum texto
        for (int i = 0; i < str.length(); i++)
            // Se não for uma letra retorna zero
            if (!Character.isLetter(str.charAt(i)))
                return;
 
        // Aceita apena 1 letra digitada por vez
        int tamMax = 1;
        if ((getLength() + str.length()) <= tamMax)
 
            super.insertString(offs, str, a);
 
    }
    
    //Sempre usar verbo no infinitivo para criar metodos
    public void insertNumber(int offs, String str,
            javax.swing.text.AttributeSet a) throws BadLocationException {
        // normalmente apenas uma letra é inserida por vez,
        // mas fazendo assim também previne caso o usuário
        // cole algum texto
        //Aceita virgula e ponto nos números
        for (int i = 0; i < str.length(); i++)
            // Se não for número, ponto ou vírgula retorna zero
            if (!Character.isDigit(str.charAt(i)) && str.charAt(i) != ','
                    && str.charAt(i) != '.')
                return;
 
        super.insertString(offs, str, a);
 
    }
}
