package com.twitter;

import java.util.LinkedList;

import com.twitter.poruke.TwitterPoruka;

/**
 * Klasa Twitter sadrzi listu svih poruka
 * @author Matija Kojoviæ
 * @version 1.0
 *
 */

public class Twitter {

	/**
	 * Atribut poruke predstavlja ulancanu listu objekata klase TwitterPoruka.
	 */
	private LinkedList<TwitterPoruka> poruke = new LinkedList<TwitterPoruka>();
	
	/**
	 * Vraca listu svih poruka.	
	 * 
	 * @return LinkedList poruke - vraca sve poruke kao ulancanu listu 
	 * @see com.twitter.poruke.TwitterPoruka
	 */
	public LinkedList<TwitterPoruka> vratiSvePoruke(){
		return poruke;
	}
	/**
	 * Metoda unosi novog korisnika i njegovu poruku.
	 * 
	 * @param korisnik unosi se kao String.
	 * @param poruka unosi se kao String.
	 */
	public void unesi(String korisnik, String poruka) {
		//Pravi se nova poruka i puni podacima.
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik(korisnik);
		tp.setPoruka(poruka);
		//Poruka se unosi u listu na kraj
		poruke.addLast(tp);
	}
	/**
	 * Metoda vraca zeljeni broj objekata klase TwitterPoruka koji sadrze prosledjeni tag , kao niz.
	 * 
	 * @param maxBroj unosi se kao int i predstavlja maksimalni broj poruka koji moze biti vracen
	 * @param tag unosi se kao String i predstvalja tag koji poruka treba da sadrzi
	 * @throws java.lang.RuntimeException ako je tag:
	 * 		<ul>
	 * 		<li>null</li>
	 * 		<li>prazan String</li>
	 * 		</ul>
	 * @return rezultat - niz poruka
	 * 
	 * 
	 */
	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {
		if (tag==null || tag.isEmpty()){
			throw new RuntimeException("Morate uneti tag");
		}
		//Ako je maxBroj <=0, vraca maxBroj se postavlja na 100 poruka
		if (maxBroj<=0){
			maxBroj = 100;
		}
		//Pomocna promenljiva koja predstavlja brojac upisanih poruka
		int brojac = 0;
		//Pomocni niz koja predstavlja rezultat pretrage tj. sadrzace
		//sve poruke koje u sebi imaju zadati tag
		TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];
		//Pretrazuju se poruke i traze se one koje sadrze tag.
		//Ako se nadje neka takva, i ako nije prekoracen maxBroj
		//ona se upisuje u niz. Ako je prekoracen maxBroj,pretraga
		//se prekida.
		for (int i = 0; i < poruke.size(); i++){
			if (poruke.get(i).getPoruka().indexOf(tag)!=-1){
				if (brojac < maxBroj){
					rezultat[brojac++]=poruke.get(i);
				}else{
					break;
				}
			}
		}
		return rezultat;
	}
}