package com.curso.mc;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;

import com.curso.mc.service.validation.utils.Barcode;

public class BarcodeTest {

	@Test
	public void testToTypefulLine47() throws Throwable {
		final String barcode = "23791620800000586754150094900407757300003200";
		final String expected = "23794.15009 94900.407753 73000.032000 1 62080000058675";

		final String typefulLine = Barcode.toTypefulLine(barcode);
		assertEquals(expected, typefulLine);
	}

	@Test
	public void testToTypefulLine48() throws Throwable {
		final String barcode = "81770000000010936599704113107970300143370831";
		final String expected = "81770000000-0 01093659970-2 41131079703-9 00143370831-8";

		final String typefulLine = Barcode.toTypefulLine(barcode);
		assertEquals(expected, typefulLine);
	}

	@Test
	public void testToBarcode47() throws Throwable {
		final String typefulLine = "23794.15009 94900.407753 73000.032000 1 62080000058675";
		final String expected = "23791620800000586754150094900407757300003200";

		final String barcode = Barcode.toBarcode(typefulLine);
		assertEquals(expected, barcode);
	}

	@Test
	public void testToBarcode48() throws Throwable {
		final String typefulLine = "81770000000-0 01093659970-2 41131079703-9 00143370831-8";
		final String expected = "81770000000010936599704113107970300143370831";

		final String barcode = Barcode.toBarcode(typefulLine);
		assertEquals(expected, barcode);
	}

	@Test
	public void testExpiresAtTypefulLine() throws Throwable {
		final Calendar calendar = new GregorianCalendar(2014, Calendar.OCTOBER, 6);
		final Date expected = calendar.getTime();

		final String typefulLine = "23794.15009 94900.407753 73000.032000 1 62080000058675";

		final Date expiresAt = Barcode.expiresAt(typefulLine);
		assertEquals(expected, expiresAt);
	}

	@Test
	public void testExpiresAtBarcode() throws Throwable {
		final Calendar calendar = new GregorianCalendar(2014, Calendar.OCTOBER, 6);
		final Date expected = calendar.getTime();

		final String barcode = "23791620800000586754150094900407757300003200";

		final Date expiresAt = Barcode.expiresAt(barcode);
		assertEquals(expected, expiresAt);
	}

	@Test
	public void testDocumentValueTypefulLine47() throws Throwable {
		final double expected = 586.75;

		final String typefulLine = "23794.15009 94900.407753 73000.032000 1 62080000058675";

		final double documentValue = Barcode.documentValue(typefulLine);
		assertEquals(expected, documentValue);
	}

	@Test
	public void testDocumentValueBarcode47() throws Throwable {
		final double expected = 586.75;

		final String barcode = "23791620800000586754150094900407757300003200";

		final double documentValue = Barcode.documentValue(barcode);
		assertEquals(expected, documentValue);
	}

	@Test
	public void testDocumentValueTypefulLine48() throws Throwable {
		final double expected = 1.09;

		final String typefulLine = "81770000000-0 01093659970-2 41131079703-9 00143370831-8";

		final double documentValue = Barcode.documentValue(typefulLine);
		assertEquals(expected, documentValue);
	}

	@Test
	public void testDocumentValueBarcode48() throws Throwable {
		final double expected = 0.0;

		final String barcode = "81770000000010936599704113107970300143370831";

		final double documentValue = Barcode.documentValue(barcode);
		assertEquals(expected, documentValue);
	}

	@Test
	public void testIsValidDocketDocumentTrue() throws Throwable {
		final String typefulLine = "23794.15009 94900.407753 73000.032000 1 62080000058675";

		final boolean isValidContractDocument = Barcode.isValidDocketDocument(typefulLine);
		assertTrue(isValidContractDocument);
	}

	@Test
	public void testIsValidDocketDocumentFalse() throws Throwable {
		final String typefulLine = "23791.15009 94900.407753 73000.032000 1 62080000058675";

		final boolean isValidContractDocument = Barcode.isValidDocketDocument(typefulLine);
		assertFalse(isValidContractDocument);
	}

	@Test
	public void testIsValidContratDocumentTrue() throws Throwable {
		final String typefulLine = "81770000000-0 01093659970-2 41131079703-9 00143370831-8";

		final boolean isValidContractDocument = Barcode.isValidContractDocument(typefulLine);
		assertTrue(isValidContractDocument);
	}

	@Test
	public void testIsValidContratDocumentFalse() throws Throwable {
		final String typefulLine = "81770000000-0 01093659970-2 41131079703-9 00143370831-1";

		final boolean isValidContractDocument = Barcode.isValidContractDocument(typefulLine);
		assertFalse(isValidContractDocument);
	}

}
