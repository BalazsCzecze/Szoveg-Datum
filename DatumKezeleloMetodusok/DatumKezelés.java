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


public class DatumKezelés {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Date datum=new Date();
		//Aktuális dátum és idõ
		System.out.println("Aktuális idõ és dátum: "+datum);
		
		
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
				
				//Calendar osztály - java11 betölti a GregorianCalendar osztályt, ami nem deprecated
				Calendar calendarObj = Calendar.getInstance(); //objektumpéldány létrehozása az aktuális dátummal
				System.out.println("Aktuális év: "+calendarObj.get(Calendar.YEAR)); //2022
				System.out.println("Aktuális hónap: "+calendarObj.get(Calendar.MONTH)); //0. január
				System.out.println("Aktuális nap: "+calendarObj.get(Calendar.DATE)); 
				System.out.println("Aktuális perc: "+calendarObj.get(Calendar.MINUTE)); 
				System.out.println("Aktuális mp: "+calendarObj.get(Calendar.SECOND));
				Calendar.getInstance(Locale.US);
		
		//Irassuk ki a 2 héttel ezelõtti dátumot! Aktuális dátum alapján dolgozzunk!
		Calendar aktualisDatum=Calendar.getInstance();
		aktualisDatum.add(Calendar.DATE, -14);
		System.out.println("A 2 héttel ezelõtti dátum: "+aktualisDatum.getTime());
		System.out.println("Év: "+aktualisDatum.get(Calendar.YEAR));
		System.out.println("Hónap: "+(aktualisDatum.get(Calendar.MONTH)+1)); //január
		System.out.println("Nap: "+aktualisDatum.get(Calendar.DAY_OF_MONTH));
		System.out.println();
		
		
		
		//Kérjünk be 2 dátumot és döntsük el melyik korábbi/késõbbi/azonos.
		System.out.println("Feladat:Dátumok összehasonlítása");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		try {
			System.out.println("Kérem adja meg az elsõ dátum adatait egész számokkal: ");
			System.out.print("Év (pld. 2022): ");
			int evElso = Integer.parseInt(br.readLine());
			System.out.print("Hónap (pld. 12): ");
			int honapElso = Integer.parseInt(br.readLine())-1;
			System.out.print("Nap (pld. 8): ");
			int napElso = Integer.parseInt(br.readLine());
			
			System.out.println("Kérem adja meg az második dátum adatait egész számokkal: ");
			System.out.print("Év (pld. 2022): ");
			int evMasodik = Integer.parseInt(br.readLine());
			System.out.print("Hónap (pld. 12): ");
			int honapMasodik = Integer.parseInt(br.readLine())-1;
			System.out.print("Nap (pld. 8): ");
			int napMasodik = Integer.parseInt(br.readLine());
			
			Calendar elsoDatum = Calendar.getInstance();
			elsoDatum.set(evElso, honapElso, napElso);
			
			Calendar masodikDatum = Calendar.getInstance();
			masodikDatum.set(evMasodik, honapMasodik, napMasodik);
			
			System.out.println("Elsõ dátum: "+elsoDatum.get(Calendar.MONTH));
			//System.out.println("Második dátum: "+masodikDatum);
			
			//rossz megoldás - nincs ilyen megoldás - szintaktikai hiba
//			if (elsoDatum > masodikDatum) {
//				System.out.println("Elsõ dátum késõbbi...");
//			}
			
			if (elsoDatum.after(masodikDatum)) {
				System.out.println("Az elsõ dátum késõbbi, mint a második!!!");
			} else if (elsoDatum.before(masodikDatum)) {
				System.out.println("Az elsõ dátum korábbi, mint a második!!!");
			} else {
				System.out.println("Azonos dátumok...");
			}

			if (elsoDatum.compareTo(masodikDatum)<0){
				System.out.println("compareTo: Az elsõ dátum korábbi,  mint a második!!!");
			} else if (elsoDatum.compareTo(masodikDatum)>0) {
				System.out.println("compareTo: Az elsõ dátum késõbbi, mint a második!!!");
			} else if (elsoDatum.compareTo(masodikDatum)==0) {
				System.out.println("Azonos dátumok...");
			} 
			//Relációs operátorok önmagukban nem mukodnek == <=, kell a compareTo
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//java11 - Time package-et használjuk!!!
		LocalDate localDate = LocalDate.now(); //aktuális dátum 
		//ISO szabvány szerinti Dátum formátum 2022-09-01
		System.out.println("Aktuális dátum LocalDate: "+localDate);
		System.out.println(LocalDate.of(2015, 02, 20));
		
		LocalDate registrationDate = LocalDate.parse("2015-02-22");
		System.out.println("Regisztráció ideje (eredeti dátum: "+registrationDate);
		registrationDate = registrationDate.plusDays(-5);
		System.out.println("Regisztráció ideje (5 napot kivontunk): "+registrationDate);//2015-02-17

		registrationDate = registrationDate.plus(Period.ofDays(30));
		System.out.println("Regisztráció ideje (30 napot hozzáadtunk):" +registrationDate);
		
		System.out.println(registrationDate.isAfter(localDate)); //false
		System.out.println(registrationDate.isBefore(localDate)); //true
		
		//Feladat03: Két dátum közötti különbség napokban!
		// Vegyünk fel két dátumot, majd írjuk ki a kettõ közötti különbséget napokban
		LocalDate kezdoDatum = LocalDate.of(2015, 02, 20);
		LocalDate vegDatum = LocalDate.of(2017, 03, 28);
		
		int elteltNapokSzam = Period.between(kezdoDatum, vegDatum).getDays();
		System.out.println("Eltelt napok száma: "+elteltNapokSzam); //8
		
		Period period = Period.between(kezdoDatum, vegDatum);
		int years = Math.abs(period.getYears());
		int months = Math.abs(period.getMonths());
		int days = Math.abs(period.getDays());
		
		System.out.println("Év: "+years);
		System.out.println("Hónap: "+months);
		System.out.println("Nap: "+days);
		
		LocalDate firstLocaldate = LocalDate.parse("2022-02-10");
		LocalDate secondLocaldate = LocalDate.parse("2022-02-20");

		long kulonbsegNapokban = ChronoUnit.DAYS.between(firstLocaldate, secondLocaldate);
		System.out.println(firstLocaldate + " " + secondLocaldate);
		System.out.println("Ennyi különbség van a két nap között napokban (ChronoUnit): " + kulonbsegNapokban);
		
		LocalDateTime datum1 = LocalDateTime.now();
		LocalDateTime datum2 = LocalDateTime.of(2022, 7, 20, 12, 14);

		Duration duration = Duration.between(datum1, datum2);
		long diff = Math.abs(duration.toDays());
		System.out.println("Ennyi különbség van a két nap között napokban (duration)" + diff);
	
		System.out.println("Feladat04: idõ közötti különbség");
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
		System.out.println("gregorianCalendarObj tartalma év :"+gregorianCalendarObj.get(Calendar.YEAR));
		System.out.println("gregorianCalendarObj tartalma óra :"+gregorianCalendarObj.get(Calendar.HOUR));
		
		//Összefoglalva, java11-ben a következõ osztályok használjuk:
		//LocalDate és LocalDateTime
		//GregorianCalendar
		//TimeZone
		//Time
		//Time package
		
		//Külsõ könyvtárak: Date4J, JodaTime,ChronoUnit
		
		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
		
		
		
		
		
		
		
		
		
		
		
	}

}
