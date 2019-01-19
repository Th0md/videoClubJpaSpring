package videoClub.JpaSpring.dao;

public enum Civilite {
	M("monsieur"),MME("madame"),MLLE("mademoiselle");
	private String abreviation;
	
	private Civilite(String abreviation) {
		this.abreviation=abreviation;
	}
	public String getCivilite() {
		return abreviation;
	}
	public void setCivilite(String abreviation) {
		this.abreviation=abreviation;
	}
	
}
