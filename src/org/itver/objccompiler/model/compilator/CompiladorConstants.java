/* Generated By:JavaCC: Do not edit this line. CompiladorConstants.java */
package org.itver.objccompiler.model.compilator;


/**
 * Token literal values and constants.
 * Generated by org.javacc.parser.OtherFilesGen#start()
 */
public interface CompiladorConstants {

  /** End of File. */
  int EOF = 0;
  /** RegularExpression Id. */
  int OP_INCREMENTO = 1;
  /** RegularExpression Id. */
  int OP_DECREMENTO = 2;
  /** RegularExpression Id. */
  int OP_SUMA = 3;
  /** RegularExpression Id. */
  int OP_RESTA = 4;
  /** RegularExpression Id. */
  int OP_PRODUCTO = 5;
  /** RegularExpression Id. */
  int OP_DIVISION = 6;
  /** RegularExpression Id. */
  int COMPLEMENTO = 7;
  /** RegularExpression Id. */
  int OP_AND = 8;
  /** RegularExpression Id. */
  int OP_OR = 9;
  /** RegularExpression Id. */
  int OP_NOT = 10;
  /** RegularExpression Id. */
  int OP_OR_BIT = 11;
  /** RegularExpression Id. */
  int OP_AND_BIT = 12;
  /** RegularExpression Id. */
  int OP_XOR_BIT = 13;
  /** RegularExpression Id. */
  int OP_ASIG = 14;
  /** RegularExpression Id. */
  int OP_ASIG_SUMA = 15;
  /** RegularExpression Id. */
  int OP_ASIG_RESTA = 16;
  /** RegularExpression Id. */
  int OP_ASIG_PRODUCTO = 17;
  /** RegularExpression Id. */
  int OP_ASIG_COCIENTE = 18;
  /** RegularExpression Id. */
  int OP_ASIG_MODULO = 19;
  /** RegularExpression Id. */
  int OP_ASIG_SHIFT_LEFT = 20;
  /** RegularExpression Id. */
  int OP_ASIG_SHIFT_RIGTH = 21;
  /** RegularExpression Id. */
  int OP_ASIG_XOR = 22;
  /** RegularExpression Id. */
  int OP_ASIG_OR = 23;
  /** RegularExpression Id. */
  int OP_ASIG_AND = 24;
  /** RegularExpression Id. */
  int LITERAL_BOOLEANA = 25;
  /** RegularExpression Id. */
  int LITERAL_ENTERA = 26;
  /** RegularExpression Id. */
  int LITERAL_DECIMAL = 27;
  /** RegularExpression Id. */
  int LITERAL_HEX = 28;
  /** RegularExpression Id. */
  int LITERAL_OCTAL = 29;
  /** RegularExpression Id. */
  int LITERAL_FLOTANTE = 30;
  /** RegularExpression Id. */
  int EXPONENTE = 31;
  /** RegularExpression Id. */
  int LITERAL_CARACTER = 32;
  /** RegularExpression Id. */
  int LITERAL_STRING = 33;
  /** RegularExpression Id. */
  int LITERAL_STRING_OBJC = 34;
  /** RegularExpression Id. */
  int BYTE = 35;
  /** RegularExpression Id. */
  int SHORT = 36;
  /** RegularExpression Id. */
  int ENTERO = 37;
  /** RegularExpression Id. */
  int LONG = 38;
  /** RegularExpression Id. */
  int DOUBLE = 39;
  /** RegularExpression Id. */
  int FLOTANTE = 40;
  /** RegularExpression Id. */
  int BOOLEANO = 41;
  /** RegularExpression Id. */
  int CARACTER = 42;
  /** RegularExpression Id. */
  int NSSTRING = 43;
  /** RegularExpression Id. */
  int ARREGLO = 44;
  /** RegularExpression Id. */
  int VOID = 45;
  /** RegularExpression Id. */
  int CONST = 46;
  /** RegularExpression Id. */
  int FOR = 47;
  /** RegularExpression Id. */
  int WHILE = 48;
  /** RegularExpression Id. */
  int DO = 49;
  /** RegularExpression Id. */
  int BREAK = 50;
  /** RegularExpression Id. */
  int CONTINUE = 51;
  /** RegularExpression Id. */
  int RETURN = 52;
  /** RegularExpression Id. */
  int IF = 53;
  /** RegularExpression Id. */
  int ELSE = 54;
  /** RegularExpression Id. */
  int SWITCH = 55;
  /** RegularExpression Id. */
  int CASE = 56;
  /** RegularExpression Id. */
  int PR_DEFAULT = 57;
  /** RegularExpression Id. */
  int IMPORTACION = 58;
  /** RegularExpression Id. */
  int DELIMITADOR_INSTRUCCION = 59;
  /** RegularExpression Id. */
  int DOS_PUNTOS = 60;
  /** RegularExpression Id. */
  int COMA = 61;
  /** RegularExpression Id. */
  int PARENTESIS_APERTURA = 62;
  /** RegularExpression Id. */
  int PARENTESIS_CERRADURA = 63;
  /** RegularExpression Id. */
  int LLAVE_APERTURA = 64;
  /** RegularExpression Id. */
  int LLAVE_CERRADURA = 65;
  /** RegularExpression Id. */
  int CORCHETE_APERTURA = 66;
  /** RegularExpression Id. */
  int CORCHETE_CERRADURA = 67;
  /** RegularExpression Id. */
  int COMILLA_DOBLE = 68;
  /** RegularExpression Id. */
  int ID = 69;
  /** RegularExpression Id. */
  int LETRA = 70;
  /** RegularExpression Id. */
  int DIGITO = 71;

  /** Lexical state. */
  int DEFAULT = 0;
  /** Lexical state. */
  int DENTRO_COMENTARIO = 1;

  /** Literal token values. */
  String[] tokenImage = {
    "<EOF>",
    "\"++\"",
    "\"--\"",
    "\"+\"",
    "\"-\"",
    "\"*\"",
    "\"/\"",
    "\"~\"",
    "\"&&\"",
    "\"||\"",
    "\"!\"",
    "\"|\"",
    "\"&\"",
    "\"^\"",
    "\"=\"",
    "\"+=\"",
    "\"-=\"",
    "\"*=\"",
    "\"/=\"",
    "\"%=\"",
    "\"<<=\"",
    "\">>=\"",
    "\"^=\"",
    "\"|=\"",
    "\"&=\"",
    "<LITERAL_BOOLEANA>",
    "<LITERAL_ENTERA>",
    "<LITERAL_DECIMAL>",
    "<LITERAL_HEX>",
    "<LITERAL_OCTAL>",
    "<LITERAL_FLOTANTE>",
    "<EXPONENTE>",
    "<LITERAL_CARACTER>",
    "<LITERAL_STRING>",
    "<LITERAL_STRING_OBJC>",
    "\"byte\"",
    "\"short\"",
    "\"int\"",
    "\"long\"",
    "\"double\"",
    "\"float\"",
    "\"BOOL\"",
    "\"char\"",
    "\"NSString\"",
    "\"NSArray\"",
    "\"void\"",
    "\"const\"",
    "\"for\"",
    "\"while\"",
    "\"do\"",
    "\"break\"",
    "\"continue\"",
    "\"return\"",
    "\"if\"",
    "\"else\"",
    "\"switch\"",
    "\"case\"",
    "\"default\"",
    "\"#import\"",
    "\";\"",
    "\":\"",
    "\",\"",
    "\"(\"",
    "\")\"",
    "\"{\"",
    "\"}\"",
    "\"[\"",
    "\"]\"",
    "\"\\\"\"",
    "<ID>",
    "<LETRA>",
    "<DIGITO>",
    "\" \"",
    "\"\\r\"",
    "\"\\t\"",
    "\"\\n\"",
    "<token of kind 76>",
    "\"/*\"",
    "\"*/\"",
    "<token of kind 79>",
    "\"<\"",
    "\">\"",
    "\"==\"",
    "\"!=\"",
    "\"<=\"",
    "\">=\"",
    "\"<<\"",
    "\">>\"",
    "\"%\"",
  };

}