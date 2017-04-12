package com.twitter.poruke;

/**
  * Klasa TwitterPoruka koja sadrzi atribute:
 *          <ul>
 *          <li>korisnik
 *          <li>poruka
 *          </ul>
 *          
 * @author Matija Kojoviæ
 * @version 1.0
 *
 */

public class TwitterPoruka {
	/**
	 * Atribut korisnik koji je identifikator korisnika. 
	 */
	private String korisnik;
	/**
	 * Atribut poruka koji je poruka koju korisnika salje.
	 */
	private String poruka;

	/**
	 * Vraca vrednost atributa korisnik.
	 * @return korisnik kao String
	 */
	public String getKorisnik() {
		return korisnik;
	}
	/**
	 * Postavlja novu vrednost za atribut korisnik.
	 * @param korisnik novo ime korisnika, unosi se kao String
	 * @throws java.lang.RuntimeException ako je unesen korisnik:
	 * 
	 * <ul>
	 * <li>null</li>
	 * <li>nije prazan String</li>
	 * </ul>
	 */
	public void setKorisnik(String korisnik) {
		if (korisnik==null || !korisnik.isEmpty()){
			throw new RuntimeException("Ime korisnika mora biti uneto");
		}
	this.korisnik = korisnik;
	}
	/**
	 * Vraca vrednost atributa poruka.
	 * @return poruku korisnika kao String
	 */
	public String getPoruka() {
		return "poruka";
	}	
	/**
	 * Postavlja novu vrednost za atribut poruka.
	 * @param poruka nova poruka korisnika
	 * @throws java.lang.RuntimeException ako je uneta poruka:
	 * 
	 * <ul>
	 * <li>null</li>
	 * <li>prazan String</li>
	 * <li>duza od 140 karaktera</li>
	 * </ul>
	 */
	public void setPoruka(String poruka) {
		if (this.poruka==null || this.poruka == new String("") || this.poruka.length()>140){
			throw new RuntimeException("Poruka mora biti uneta i mora imati najvise 140 znakova");
		}
		this.poruka = poruka;
	}
	
	/**
	 * Vraca strin sa svim podacima objekta klase TwitterPoruka.
	 *   
	 * @return identifikator korisnika i njegovu poruku kao String.          
	 * Format : KORISNIK:<i>korisnik</i> PORUKA:<i>poruka</i>
	 */	
	public String toString(){
		return "KORISNIK:"+korisnik+" PORUKA:"+poruka;
	}
}