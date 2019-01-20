package resources;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import videoClub.JpaSpring.dao.DaoAdherent;
import videoClub.JpaSpring.dao.DaoArticle;
import videoClub.JpaSpring.dao.DaoFilm;
import videoClub.JpaSpring.model.Adherent;
import videoClub.JpaSpring.model.Article;
import videoClub.JpaSpring.model.Dvd;
import videoClub.JpaSpring.model.Film;

public class AppTest {

	public static void main(String[] args) {
		
//		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//		System.out.println(ctx.getBean(DaoPersonne.class).findByKey(1));
//		Eleve eleve = new Eleve("clara", "paf");
//		ctx.getBean(DaoPersonne.class).insert(eleve);
//		ctx.close();
		
//		Film film = new Film();
//		film.setTitre("Le Film");
//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//		try {
//			film.setDateSortie(sdf.parse("02/03/1996"));
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		DaoFilm f = DaoFilmFactory.getInstance();
//		f.insert(film);
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		//System.out.println(ctx.getBean(DaoFilm.class).findByKey(100));
		
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Film film1 = new Film();
		film1.setTitre("The Fight");
		try {
			film1.setDateSortie(sdf.parse("02/03/1996"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		ctx.getBean(DaoFilm.class).insert(film1);
		
		
		Film film2 = new Film();
		film2.setTitre("Flight Fight");
		try {
			film2.setDateSortie(sdf.parse("22/04/2002"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		ctx.getBean(DaoFilm.class).insert(film2);
		
		
		Film film3 = new Film();
		film3.setTitre("Finding me");
		try {
			film3.setDateSortie(sdf.parse("24/12/2013"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		ctx.getBean(DaoFilm.class).insert(film3);
		
		
		Adherent adh1 = new Adherent("Paul","Lefebvre");
		ctx.getBean(DaoAdherent.class).insert(adh1);
		
		Adherent adh2 = new Adherent("Alice","Duval");
		ctx.getBean(DaoAdherent.class).insert(adh2);
		
		Adherent adh3 = new Adherent("Sylvain","Quotte");
		ctx.getBean(DaoAdherent.class).insert(adh3);
		
		Article art1 = new Dvd();
		art1.setNbDisques(5);
		art1.setNoArticle(1);
		art1.setNoFilm(1);
		ctx.getBean(DaoArticle.class).insert(art1);
		
		Article art2 = new Dvd();
		art1.setNbDisques(5);
		art1.setNoArticle(2);
		art2.setNoFilm(2);
		ctx.getBean(DaoArticle.class).insert(art2);
		
		
		
		
		
		ctx.close();
		
		
				
	}

}
