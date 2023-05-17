package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

	public static void main(String[] args) {
		
		/************ Meta karakterek *****************************/
//		. egy darab bármilyen karakter
//		\d bármilyen digitális szám: [0-9]
//		\D bármilyen nem digitális érték [^0-9] 
//		\s whitespace karakter, [ \t\n\x0b\r\f]	
//		\S minden ami nem whitespace: nem szóköz, nem tabulátor, nem új sor, sortörés, kocsivissza jel
//		\w egy karakter, hosszabban: [a-zA-Z_0-9]
//		\W minden ami nem sima karakter [^\w]: speciális karakterek
//		\S+ Nagyon sok nem whitespace karakter
//		\b szó, [a-zA-Z_0-9]
		
		/********** Mennyiségi elõfordulások *******************/
//		X? X elõfordul 1X vagy egyszer sem
//		X+ X egyszer vagy többször elõfordul
//		X* X 0 vagy több alkalommal fordul elõ
//		X{n} X pontosan n alkalommal fordul elõ
//		X{n,} X n-szer vagy többször fordul elõ
//		X{n,m} X legalább n-szer, de kevesebb, mint m-szer fordul elõ
		
		//1. módszer: Pattern és Matcher osztályok használata
		Pattern patter01 = Pattern.compile(".s");
		Matcher match01 = patter01.matcher("as");
		boolean isMatch01 = match01.matches();
		System.out.println("pattern: .s - szöveg: as: "+isMatch01);
		Matcher match02 = patter01.matcher("mk");
		boolean isMatch02 = match02.matches();
		System.out.println("pattern: .s - szöveg: mk: "+isMatch02);
		
		//2. módszer
		System.out.println("pattern: .a - szöveg: la: "+Pattern.matches(".a", "la")); //true
		System.out.println("pattern: .a - szöveg: al: "+Pattern.matches(".a", "al")); //false
		System.out.println("pattern: s.s - szöveg: sas: "+Pattern.matches("s.s", "sas")); //true
		System.out.println("pattern: s.s - szöveg: sós: "+Pattern.matches("s.s", "sós")); //true
		System.out.println("pattern: [abc] - szöveg: a: "+Pattern.matches("[abc]", "a")); //true
		System.out.println("pattern: [abc] - szöveg: z: "+Pattern.matches("[abc]", "z")); //false
		System.out.println("pattern: [anna]? - szöveg: a: "+Pattern.matches("[anna]?", "a")); //true
		System.out.println("pattern: [anna]? - szöveg: abc: "+Pattern.matches("[anna]?", "abc")); //false
		System.out.println("pattern: [anna]+ - szöveg: a: "+Pattern.matches("[anna]+", "a")); //true
		System.out.println("pattern: [anna]* - szöveg: a: "+Pattern.matches("[anna]*", "a")); //true
		System.out.println("pattern: [abc]* - szöveg: z: "+Pattern.matches("[abc]*", "z")); //false
		
		System.out.println("pattern: \\d - szöveg: z: "+Pattern.matches("\\d", "z")); //false
		System.out.println("pattern: \\d - szöveg: 9: "+Pattern.matches("\\d", "9")); //true
		System.out.println("pattern: \"[0-9]\" - szöveg: 5: "+Pattern.matches("[0-9]", "5")); //true
		System.out.println("pattern: \"[0-9]\" - szöveg: r: "+Pattern.matches("[0-9]", "r")); //false
		System.out.println("pattern: \\D - szöveg: z: "+Pattern.matches("\\D", "z")); //true
		System.out.println("pattern: \\D - szöveg: 9: "+Pattern.matches("\\D", "9")); //false
		System.out.println("pattern: \"^[0-9]\" - szöveg: 5: "+Pattern.matches("[^0-9]", "5")); //false
		System.out.println("pattern: \"^[0-9]\" - szöveg: r: "+Pattern.matches("[^0-9]", "r")); //true
		
		System.out.println("pattern: [a-zA-Z0-9]{6} - szöveg: 123abc: "+Pattern.matches("[a-zA-Z0-9]{6}", "123abc"));//true
		System.out.println("pattern: [a-zA-Z0-9]{6} - szöveg: 1234abc: "+Pattern.matches("[a-zA-Z0-9]{6}", "1234abc"));//false
		System.out.println("pattern: [a-zA-Z0-9]{6} - szöveg: 123ab!: "+Pattern.matches("[a-zA-Z0-9]{6}", "123ab!"));//false
		System.out.println("pattern: [a-zA-Z0-9]{6} - szöveg: 123ab_: "+Pattern.matches("[a-zA-Z0-9]{6}", "123ab_"));//false

		System.out.println("pattern: [a-zA-Z]{5} - szöveg: TeEle: "+Pattern.matches("[a-zA-Z]{5}", "TeEle"));//true
		System.out.println("pattern: [a-zA-Z]{5}_[0-9]{2} - szöveg: TeEle_99: "+Pattern.matches("[a-zA-Z]{5}_[0-9]{2}", "TeEle_99"));//true
		System.out.println("pattern: [a-zA-Z]{5}_[0-9]{2} - szöveg: TeEle_101: "+Pattern.matches("[a-zA-Z]{5}_[0-9]{2}", "TeEle_101")); //false
		System.out.println("pattern: [a-zA-Z]{5}_[0-9]{2} - szöveg: TeEl_99: "+Pattern.matches("[a-zA-Z]{5}_[0-9]{2}", "TeEl_99"));//false
		
		//Feladat01: Banki számlaszámra készítsünk regexet!
		// 12345678-12345678 - true
		// 12345678-12345678-12345678 -true
		System.out.println("Bankszámlaszám ellenõrzés "
				+ "12345678-12345678: "+Pattern.matches("[0-9]{8}([-]?[0-9]{8}){1,2}", "12345678-12345678")); //true
		System.out.println("Bankszámlaszám ellenõrzés "
				+ "12345678-12345678-12345678: "+Pattern.matches("[0-9]{8}([-]?[0-9]{8}){1,2}", "12345678-12345678-12345678")); //true
		System.out.println("Bankszámlaszám ellenõrzés "
				+ "123456781234567812345678: "+Pattern.matches("[0-9]{8}([-]?[0-9]{8}){1,2}", "123456781234567812345678")); //true
		System.out.println("Bankszámlaszám ellenõrzés "
				+ "123456781234567812345678: "+Pattern.matches("[0-9]{8}([-]?[0-9]{8}){1,2}", "123456781234567812345678dawd")); //false
		
		//Feladat02: Mobiltelefonszámra készítsünk regexet!
		System.out.println("Mobiltelefonszám +3620-555-55-55: "+Pattern.matches("[+]36[237]{1}0-[0-9]{3}-[0-9]{2}-[0-9]{2}", "+3620-555-55-55")); //true
		System.out.println("Mobiltelefonszám +3620-555-55-55: "+Pattern.matches("[+]36[237]{1}0-[0-9]{3}-[0-9]{2}-[0-9]{2}", "+3620-555-55-552")); //false
		
		//Feladat03: Rendszámra készítsünk regexet - hagyományos pld. PCA-180!
		System.out.println("Rendszám PCA-180: "+Pattern.matches("[A-Z]{3}-[0-9]{3}", "PCA-180")); //true
		
		
	}

}
