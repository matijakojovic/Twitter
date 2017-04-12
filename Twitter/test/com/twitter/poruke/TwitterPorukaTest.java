/**
 * 
 */
package com.twitter.poruke;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Matija Kojoviæ
 *
 */
public class TwitterPorukaTest {

	private TwitterPoruka t;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		t = new TwitterPoruka();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		t = null;
	}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setKorisnik(java.lang.String)}.
	 */
	@Test
	public void testSetKorisnik() {
		t.setKorisnik("Nikola");
		assertEquals("Nikola", t.getKorisnik());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikNull() {
		t.setKorisnik(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikEmptyString() {
		t.setKorisnik("");
		
	}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setPoruka(java.lang.String)}.
	 */

	@Test
	public void testSetPoruka() {
		t.setPoruka("Cao ja sam novi na twitteru");
		assertEquals("Cao ja sam novi na twitteru", t.getPoruka());
	}
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaNull() {
		t.setPoruka(null);	
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaEmptyString() {
		t.setPoruka("");
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaMoreThen140Characters() {
		String poruka = "";
		for(int i = 0; i < 141; i++){
			poruka += "a";
		}
		t.setPoruka(poruka);
	}
	
	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#toString()}.
	 */
	@Test
	public void testToString() {
		t.setKorisnik("Nikola");
		t.setPoruka("Cao ja sam novi na twitteru");
		
		assertEquals("KORISNIK:"+t.getKorisnik()+" PORUKA:"+t.getPoruka(), t.toString());
	}

}
