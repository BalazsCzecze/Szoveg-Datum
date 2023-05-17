package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

	public static void main(String[] args) {
		
		/************ Meta karakterek *****************************/
//		. egy darab b�rmilyen karakter
//		\d b�rmilyen digit�lis sz�m: [0-9]
//		\D b�rmilyen nem digit�lis �rt�k [^0-9] 
//		\s whitespace karakter, [ \t\n\x0b\r\f]	
//		\S minden ami nem whitespace: nem sz�k�z, nem tabul�tor, nem �j sor, sort�r�s, kocsivissza jel
//		\w egy karakter, hosszabban: [a-zA-Z_0-9]
//		\W minden ami nem sima karakter [^\w]: speci�lis karakterek
//		\S+ Nagyon sok nem whitespace karakter
//		\b sz�, [a-zA-Z_0-9]
		
		/********** Mennyis�gi el�fordul�sok *******************/
//		X? X el�fordul 1X vagy egyszer sem
//		X+ X egyszer vagy t�bbsz�r el�fordul
//		X* X 0 vagy t�bb alkalommal fordul el�
//		X{n} X pontosan n alkalommal fordul el�
//		X{n,} X n-szer vagy t�bbsz�r fordul el�
//		X{n,m} X legal�bb n-szer, de kevesebb, mint m-szer fordul el�
		
		//1. m�dszer: Pattern �s Matcher oszt�lyok haszn�lata
		Pattern patter01 = Pattern.compile(".s");
		Matcher match01 = patter01.matcher("as");
		boolean isMatch01 = match01.matches();
		System.out.println("pattern: .s - sz�veg: as: "+isMatch01);
		Matcher match02 = patter01.matcher("mk");
		boolean isMatch02 = match02.matches();
		System.out.println("pattern: .s - sz�veg: mk: "+isMatch02);
		
		//2. m�dszer
		System.out.println("pattern: .a - sz�veg: la: "+Pattern.matches(".a", "la")); //true
		System.out.println("pattern: .a - sz�veg: al: "+Pattern.matches(".a", "al")); //false
		System.out.println("pattern: s.s - sz�veg: sas: "+Pattern.matches("s.s", "sas")); //true
		System.out.println("pattern: s.s - sz�veg: s�s: "+Pattern.matches("s.s", "s�s")); //true
		System.out.println("pattern: [abc] - sz�veg: a: "+Pattern.matches("[abc]", "a")); //true
		System.out.println("pattern: [abc] - sz�veg: z: "+Pattern.matches("[abc]", "z")); //false
		System.out.println("pattern: [anna]? - sz�veg: a: "+Pattern.matches("[anna]?", "a")); //true
		System.out.println("pattern: [anna]? - sz�veg: abc: "+Pattern.matches("[anna]?", "abc")); //false
		System.out.println("pattern: [anna]+ - sz�veg: a: "+Pattern.matches("[anna]+", "a")); //true
		System.out.println("pattern: [anna]* - sz�veg: a: "+Pattern.matches("[anna]*", "a")); //true
		System.out.println("pattern: [abc]* - sz�veg: z: "+Pattern.matches("[abc]*", "z")); //false
		
		System.out.println("pattern: \\d - sz�veg: z: "+Pattern.matches("\\d", "z")); //false
		System.out.println("pattern: \\d - sz�veg: 9: "+Pattern.matches("\\d", "9")); //true
		System.out.println("pattern: \"[0-9]\" - sz�veg: 5: "+Pattern.matches("[0-9]", "5")); //true
		System.out.println("pattern: \"[0-9]\" - sz�veg: r: "+Pattern.matches("[0-9]", "r")); //false
		System.out.println("pattern: \\D - sz�veg: z: "+Pattern.matches("\\D", "z")); //true
		System.out.println("pattern: \\D - sz�veg: 9: "+Pattern.matches("\\D", "9")); //false
		System.out.println("pattern: \"^[0-9]\" - sz�veg: 5: "+Pattern.matches("[^0-9]", "5")); //false
		System.out.println("pattern: \"^[0-9]\" - sz�veg: r: "+Pattern.matches("[^0-9]", "r")); //true
		
		System.out.println("pattern: [a-zA-Z0-9]{6} - sz�veg: 123abc: "+Pattern.matches("[a-zA-Z0-9]{6}", "123abc"));//true
		System.out.println("pattern: [a-zA-Z0-9]{6} - sz�veg: 1234abc: "+Pattern.matches("[a-zA-Z0-9]{6}", "1234abc"));//false
		System.out.println("pattern: [a-zA-Z0-9]{6} - sz�veg: 123ab!: "+Pattern.matches("[a-zA-Z0-9]{6}", "123ab!"));//false
		System.out.println("pattern: [a-zA-Z0-9]{6} - sz�veg: 123ab_: "+Pattern.matches("[a-zA-Z0-9]{6}", "123ab_"));//false

		System.out.println("pattern: [a-zA-Z]{5} - sz�veg: TeEle: "+Pattern.matches("[a-zA-Z]{5}", "TeEle"));//true
		System.out.println("pattern: [a-zA-Z]{5}_[0-9]{2} - sz�veg: TeEle_99: "+Pattern.matches("[a-zA-Z]{5}_[0-9]{2}", "TeEle_99"));//true
		System.out.println("pattern: [a-zA-Z]{5}_[0-9]{2} - sz�veg: TeEle_101: "+Pattern.matches("[a-zA-Z]{5}_[0-9]{2}", "TeEle_101")); //false
		System.out.println("pattern: [a-zA-Z]{5}_[0-9]{2} - sz�veg: TeEl_99: "+Pattern.matches("[a-zA-Z]{5}_[0-9]{2}", "TeEl_99"));//false
		
		//Feladat01: Banki sz�mlasz�mra k�sz�ts�nk regexet!
		// 12345678-12345678 - true
		// 12345678-12345678-12345678 -true
		System.out.println("Banksz�mlasz�m ellen�rz�s "
				+ "12345678-12345678: "+Pattern.matches("[0-9]{8}([-]?[0-9]{8}){1,2}", "12345678-12345678")); //true
		System.out.println("Banksz�mlasz�m ellen�rz�s "
				+ "12345678-12345678-12345678: "+Pattern.matches("[0-9]{8}([-]?[0-9]{8}){1,2}", "12345678-12345678-12345678")); //true
		System.out.println("Banksz�mlasz�m ellen�rz�s "
				+ "123456781234567812345678: "+Pattern.matches("[0-9]{8}([-]?[0-9]{8}){1,2}", "123456781234567812345678")); //true
		System.out.println("Banksz�mlasz�m ellen�rz�s "
				+ "123456781234567812345678: "+Pattern.matches("[0-9]{8}([-]?[0-9]{8}){1,2}", "123456781234567812345678dawd")); //false
		
		//Feladat02: Mobiltelefonsz�mra k�sz�ts�nk regexet!
		System.out.println("Mobiltelefonsz�m +3620-555-55-55: "+Pattern.matches("[+]36[237]{1}0-[0-9]{3}-[0-9]{2}-[0-9]{2}", "+3620-555-55-55")); //true
		System.out.println("Mobiltelefonsz�m +3620-555-55-55: "+Pattern.matches("[+]36[237]{1}0-[0-9]{3}-[0-9]{2}-[0-9]{2}", "+3620-555-55-552")); //false
		
		//Feladat03: Rendsz�mra k�sz�ts�nk regexet - hagyom�nyos pld. PCA-180!
		System.out.println("Rendsz�m PCA-180: "+Pattern.matches("[A-Z]{3}-[0-9]{3}", "PCA-180")); //true
		
		
	}

}
