/**
 * 
 */
package com.twitter;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

/**
 * @author Matija Kojoviæ
 */
public class TwitterTest {

	private Twitter t;
	LinkedList<TwitterPoruka> lista;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		t = new Twitter();
		lista = new LinkedList<>();
		/*for(int i = 0; i < 300; i++){
			String korisnik = "User";
			String poruka = "Poruka";
			
			korisnik += i;
			poruka += i;
			
			t.unesi(korisnik, poruka);
		}*/
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		t = null;
		lista = null;
	}
	/**
	 * Test method for {@link com.twitter.Twitter#unesi(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testUnesi() {
		String korisnik = "Nikola";
		String poruka = "Poruka";
		t.unesi(korisnik, poruka);
		
		LinkedList<TwitterPoruka> poruke = t.vratiSvePoruke();
		assertEquals("Nikola",poruke.getLast().getKorisnik());
		assertEquals("Poruka", poruke.getLast().getPoruka());
	}

	@Test
	public void testUnesiBug() {
		String korisnik = "Nikola";
		String poruka = "Poruka";
		t.unesi(korisnik, poruka);
		
		LinkedList<TwitterPoruka> poruke = t.vratiSvePoruke();
		
		assertFalse(poruke.getLast().getKorisnik().equals("korisnik"));			
	}
	
	/**
	 * Test method for {@link com.twitter.Twitter#vratiSvePoruke()}.
	 */
	@Test
	public void testVratiSvePoruke() {
		t.unesi("Pera", "Cao svima");
		
		assertEquals("Pera", t.vratiSvePoruke().getLast().getKorisnik());
		assertEquals("Cao svima", t.vratiSvePoruke().getLast().getPoruka());
	}
	@Test
	public void testVratiSvePoruke2() {
		t.unesi("Pera", "Cao svima");
		
		assertEquals("Pera", t.vratiSvePoruke().getLast().getKorisnik());
		assertEquals("Cao svima", t.vratiSvePoruke().getLast().getPoruka());
	}
	/**
	 * Test method for {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	@Test
	public void testVratiPoruke() {
		t.unesi("Andrea", "zdravo");
		t.unesi("Marija", "Cao");
		
		TwitterPoruka p1 = new TwitterPoruka();
		p1.setKorisnik("Andrea");
		p1.setPoruka("zdravo");		

		TwitterPoruka[] niz = t.vratiPoruke(1, "zdr");
		String s = niz[0].toString();
		
		assertEquals(p1.toString(), s);
	}		
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukeNull() {
		t.vratiPoruke(1, null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukeEmptyString() {
		t.vratiPoruke(1, "");
	}
}











