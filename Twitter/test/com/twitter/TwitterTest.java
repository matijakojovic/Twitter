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
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		t = new Twitter();
		
		for(int i = 0; i < 300; i++){
			String korisnik = "User";
			String poruka = "Poruka";
			
			korisnik += i;
			poruka += i;
			
			t.unesi(korisnik, poruka);
		}
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		t = null;
	}

	/**
	 * Test method for {@link com.twitter.Twitter#vratiSvePoruke()}.
	 */
	@Test
	public void testVratiSvePoruke() {
		assertEquals(300, t.vratiSvePoruke().size());	
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
		
		if (poruke.getLast().getKorisnik().equals("korisnik")) {
			fail("Metoda treba da doda ime koje je dato kao parametar");
			
		}
	}
	/**
	 * Test method for {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	@Test
	public void testVratiPoruke() {
		assertEquals(15, t.vratiPoruke(15, "test").length);
	}
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukeNull() {
		t.vratiPoruke(1, null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukeEmptyString() {
		t.vratiPoruke(1, "");
	}

	@Test 
	public void testVratiPorukeMaxBroj() {
		assertEquals(100, t.vratiPoruke(-23, "test").length);
	}
}











