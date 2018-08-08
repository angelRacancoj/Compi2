package analisis;

import java_cup.runtime.*;
import errores.InputsVaciosException;

%%

%public
%class Lexer
%cup
%cupdebug
%line
%column

LineTerminator = \r|\n|\r\n|null
WhiteSpace     = {LineTerminator} | [ \t\f]

%{
	
  StringBuilder string = new StringBuilder();

	private Symbol symbol(int type) {
  	return new Symbol(type, yyline+1, yycolumn+1);
	}

	private Symbol symbol(int type, Object value) {
  	return new Symbol(type, yyline+1, yycolumn+1, value);
	}

	private void error(String message) throws InputsVaciosException {
  	System.out.println("Error en linea line "+(yyline+1)+", columna "+(yycolumn+1)+" : "+message);
	}

	private void imprimirToken(String textSalida){
		System.out.println("Leido: >> " + textSalida + " <<");
	}

%}

%%

<YYINITIAL>{

  "norte"           {return symbol(sym.Norte, yytext());}
  "sur"             {return symbol(sym.Sur, yytext());}
  "este"            {return symbol(sym.Este, yytext());}
  "oeste"           {return symbol(sym.Oeste, yytext());}
  "comienza"        {return symbol(sym.Comienza, yytext());}
  {WhiteSpace}      {/*Nothing to do*/}
}

[^] {error("Simbolo invalido << "+ yytext()+" >>");}
<<EOF>>                 { return symbol(sym.EOF); }