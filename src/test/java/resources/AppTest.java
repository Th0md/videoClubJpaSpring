package resources;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import videoClub.JpaSpring.dao.DaoAdherent;
import videoClub.JpaSpring.dao.DaoFilm;
import videoClub.JpaSpring.model.Adherent;
import videoClub.JpaSpring.model.Article;
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
		
		
		
		
		Film film = new Film();
		film.setTitre("Fight");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			film.setDateSortie(sdf.parse("02/03/1996"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		ctx.getBean(DaoFilm.class).insert(film);
		
		Adherent adh = new Adherent("dd","rr");
		ctx.getBean(DaoAdherent.class).insert(adh);
		
		
		ctx.close();
		
		
				
	}

}
