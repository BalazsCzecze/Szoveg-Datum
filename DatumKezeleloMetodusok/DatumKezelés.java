package DatumKezeleloMetodusok;

import java.io.BufferedReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;


public class DatumKezel�s {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Date datum=new Date();
		//Aktu�lis d�tum �s id�
		System.out.println("Aktu�lis id� �s d�tum: "+datum);
		
		
		//Date elsoDatum=new Date(2001,1,2);
		//elavult
		//System.out.println(elsoDatum);
		
		//SimpleDateFormat
				try {
					Date publishDate = new SimpleDateFormat("yyyy-MM-dd").parse("2012-01-08");
					System.out.println(publishDate);
					Date publishDate2 = new SimpleDateFormat("yyyy/MM/dd").parse("2012/01/10");
					System.out.println(publishDate2);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//Calendar oszt�ly - java11 bet�lti a GregorianCalendar oszt�lyt, ami nem deprecated
				Calendar calendarObj = Calendar.getInstance(); //objektump�ld�ny l�trehoz�sa az aktu�lis d�tummal
				System.out.println("Aktu�lis �v: "+calendarObj.get(Calendar.YEAR)); //2022
				System.out.println("Aktu�lis h�nap: "+calendarObj.get(Calendar.MONTH)); //0. janu�r
				System.out.println("Aktu�lis nap: "+calendarObj.get(Calendar.DATE)); 
				System.out.println("Aktu�lis perc: "+calendarObj.get(Calendar.MINUTE)); 
				System.out.println("Aktu�lis mp: "+calendarObj.get(Calendar.SECOND));
				Calendar.getInstance(Locale.US);
		
		//Irassuk ki a 2 h�ttel ezel�tti d�tumot! Aktu�lis d�tum alapj�n dolgozzunk!
		Calendar aktualisDatum=Calendar.getInstance();
		aktualisDatum.add(Calendar.DATE, -14);
		System.out.println("A 2 h�ttel ezel�tti d�tum: "+aktualisDatum.getTime());
		System.out.println("�v: "+aktualisDatum.get(Calendar.YEAR));
		System.out.println("H�nap: "+(aktualisDatum.get(Calendar.MONTH)+1)); //janu�r
		System.out.println("Nap: "+aktualisDatum.get(Calendar.DAY_OF_MONTH));
		System.out.println();
		
		
		
		//K�rj�nk be 2 d�tumot �s d�nts�k el melyik kor�bbi/k�s�bbi/azonos.
		System.out.println("Feladat:D�tumok �sszehasonl�t�sa");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		try {
			System.out.println("K�rem adja meg az els� d�tum adatait eg�sz sz�mokkal: ");
			System.out.print("�v (pld. 2022): ");
			int evElso = Integer.parseInt(br.readLine());
			System.out.print("H�nap (pld. 12): ");
			int honapElso = Integer.parseInt(br.readLine())-1;
			System.out.print("Nap (pld. 8): ");
			int napElso = Integer.parseInt(br.readLine());
			
			System.out.println("K�rem adja meg az m�sodik d�tum adatait eg�sz sz�mokkal: ");
			System.out.print("�v (pld. 2022): ");
			int evMasodik = Integer.parseInt(br.readLine());
			System.out.print("H�nap (pld. 12): ");
			int honapMasodik = Integer.parseInt(br.readLine())-1;
			System.out.print("Nap (pld. 8): ");
			int napMasodik = Integer.parseInt(br.readLine());
			
			Calendar elsoDatum = Calendar.getInstance();
			elsoDatum.set(evElso, honapElso, napElso);
			
			Calendar masodikDatum = Calendar.getInstance();
			masodikDatum.set(evMasodik, honapMasodik, napMasodik);
			
			System.out.println("Els� d�tum: "+elsoDatum.get(Calendar.MONTH));
			//System.out.println("M�sodik d�tum: "+masodikDatum);
			
			//rossz megold�s - nincs ilyen megold�s - szintaktikai hiba
//			if (elsoDatum > masodikDatum) {
//				System.out.println("Els� d�tum k�s�bbi...");
//			}
			
			if (elsoDatum.after(masodikDatum)) {
				System.out.println("Az els� d�tum k�s�bbi, mint a m�sodik!!!");
			} else if (elsoDatum.before(masodikDatum)) {
				System.out.println("Az els� d�tum kor�bbi, mint a m�sodik!!!");
			} else {
				System.out.println("Azonos d�tumok...");
			}

			if (elsoDatum.compareTo(masodikDatum)<0){
				System.out.println("compareTo: Az els� d�tum kor�bbi,  mint a m�sodik!!!");
			} else if (elsoDatum.compareTo(masodikDatum)>0) {
				System.out.println("compareTo: Az els� d�tum k�s�bbi, mint a m�sodik!!!");
			} else if (elsoDatum.compareTo(masodikDatum)==0) {
				System.out.println("Azonos d�tumok...");
			} 
			//Rel�ci�s oper�torok �nmagukban nem mukodnek == <=, kell a compareTo
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//java11 - Time package-et haszn�ljuk!!!
		LocalDate localDate = LocalDate.now(); //aktu�lis d�tum 
		//ISO szabv�ny szerinti D�tum form�tum 2022-09-01
		System.out.println("Aktu�lis d�tum LocalDate: "+localDate);
		System.out.println(LocalDate.of(2015, 02, 20));
		
		LocalDate registrationDate = LocalDate.parse("2015-02-22");
		System.out.println("Regisztr�ci� ideje (eredeti d�tum: "+registrationDate);
		registrationDate = registrationDate.plusDays(-5);
		System.out.println("Regisztr�ci� ideje (5 napot kivontunk): "+registrationDate);//2015-02-17

		registrationDate = registrationDate.plus(Period.ofDays(30));
		System.out.println("Regisztr�ci� ideje (30 napot hozz�adtunk):" +registrationDate);
		
		System.out.println(registrationDate.isAfter(localDate)); //false
		System.out.println(registrationDate.isBefore(localDate)); //true
		
		//Feladat03: K�t d�tum k�z�tti k�l�nbs�g napokban!
		// Vegy�nk fel k�t d�tumot, majd �rjuk ki a kett� k�z�tti k�l�nbs�get napokban
		LocalDate kezdoDatum = LocalDate.of(2015, 02, 20);
		LocalDate vegDatum = LocalDate.of(2017, 03, 28);
		
		int elteltNapokSzam = Period.between(kezdoDatum, vegDatum).getDays();
		System.out.println("Eltelt napok sz�ma: "+elteltNapokSzam); //8
		
		Period period = Period.between(kezdoDatum, vegDatum);
		int years = Math.abs(period.getYears());
		int months = Math.abs(period.getMonths());
		int days = Math.abs(period.getDays());
		
		System.out.println("�v: "+years);
		System.out.println("H�nap: "+months);
		System.out.println("Nap: "+days);
		
		LocalDate firstLocaldate = LocalDate.parse("2022-02-10");
		LocalDate secondLocaldate = LocalDate.parse("2022-02-20");

		long kulonbsegNapokban = ChronoUnit.DAYS.between(firstLocaldate, secondLocaldate);
		System.out.println(firstLocaldate + " " + secondLocaldate);
		System.out.println("Ennyi k�l�nbs�g van a k�t nap k�z�tt napokban (ChronoUnit): " + kulonbsegNapokban);
		
		LocalDateTime datum1 = LocalDateTime.now();
		LocalDateTime datum2 = LocalDateTime.of(2022, 7, 20, 12, 14);

		Duration duration = Duration.between(datum1, datum2);
		long diff = Math.abs(duration.toDays());
		System.out.println("Ennyi k�l�nbs�g van a k�t nap k�z�tt napokban (duration)" + diff);
	
		System.out.println("Feladat04: id� k�z�tti k�l�nbs�g");
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now);
		LocalDateTime sixMinutesBehind = now.minusMinutes(6);
		
		Duration duration2 = Duration.between(now, sixMinutesBehind);
		long diff2 = Math.abs(duration2.toMinutes());
		System.out.println("Eltelt percek: "+diff2);
		
		TimeZone tz = TimeZone.getTimeZone("GMT+:9:00");
		Locale loc = new Locale("en", "US", "US");
		Calendar calendar2 = Calendar.getInstance(loc);
		GregorianCalendar gregorianCalendarObj = (GregorianCalendar)calendar2;
		System.out.println("gregorianCalendarObj tartalma:"+gregorianCalendarObj);
		System.out.println("gregorianCalendarObj tartalma �v :"+gregorianCalendarObj.get(Calendar.YEAR));
		System.out.println("gregorianCalendarObj tartalma �ra :"+gregorianCalendarObj.get(Calendar.HOUR));
		
		//�sszefoglalva, java11-ben a k�vetkez� oszt�lyok haszn�ljuk:
		//LocalDate �s LocalDateTime
		//GregorianCalendar
		//TimeZone
		//Time
		//Time package
		
		//K�ls� k�nyvt�rak: Date4J, JodaTime,ChronoUnit
		
		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
		
		
		
		
		
		
		
		
		
		
		
	}

}
