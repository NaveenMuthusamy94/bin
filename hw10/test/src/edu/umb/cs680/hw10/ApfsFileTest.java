package edu.umb.cs680.hw10;

import static org.junit.Assert.assertSame;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;



class ApfsFileTest {
	
	LocalDateTime localTime = LocalDateTime.now();
	APFS ApfsFileSystem = APFS.getAPFSFileSystem();
	ApfsDirectory root = (ApfsDirectory) ApfsFileSystem.initFileSystem("Apfs", 500);
	ApfsDirectory applications = new ApfsDirectory(root, "applications", 0, localTime,"ApfsFile",localTime);
	ApfsDirectory home = new ApfsDirectory(root, "home", 0, localTime,"ApfsFile",localTime);
	ApfsDirectory code = new ApfsDirectory(home, "code", 0, localTime,"ApfsFile",localTime);
	ApfsFile a = new ApfsFile(applications, "a", 5, localTime,"ApfsFile",localTime);
	ApfsFile b = new ApfsFile(applications, "b", 20, localTime,"ApfsFile",localTime);
	ApfsFile c = new ApfsFile(home, "c", 30, localTime,"ApfsFile",localTime);
	ApfsFile d = new ApfsFile(home, "d", 40, localTime,"ApfsFile",localTime);
	ApfsFile e = new ApfsFile(code, "e", 15, localTime,"ApfsFile",localTime);
	ApfsFile f = new ApfsFile(code, "f", 15, localTime,"ApfsFile",localTime);
	ApfsLink x = new ApfsLink(home, "x", 0, localTime, "ApfsFile", localTime, applications);
	ApfsLink y = new ApfsLink(code, "y", 0, localTime,"ApfsFile",localTime,b);
	
	private String[] apfsFiletoStringArray(ApfsFile f) {
		String[] fileInfo = { Boolean.toString(f.isDirectory()), f.getName(),f.getParent().getName(),
				Integer.toString(f.getSize()),f.getCreationTime().toString(),f.getOwnerName(), f.getLastModified().toString() };
		return fileInfo;
	}
	
	@Test
	public void verifyFiles() {
		assertTrue(a.isFile());
		assertTrue(c.isFile());
		assertTrue(b.isFile());
		assertTrue(d.isFile());
		assertTrue(e.isFile());
		assertTrue(f.isFile());
	}
	@Test
	public void verifyFilesByDirectory() {
		assertSame("a", applications.getFiles().get(0).getName());
		assertSame("b", applications.getFiles().get(1).getName());
		assertSame("c", home.getFiles().get(0).getName());
		assertSame("d", home.getFiles().get(1).getName());
		assertSame("e", code.getFiles().get(0).getName());
		assertSame("f", code.getFiles().get(1).getName());
	}
	@Test
	public void verifyFileA() {
		String[] expected = { "false", "a", "applications", "5", localTime.toString(), "ApfsFile",localTime.toString() };
		ApfsFile actual = a;
		assertArrayEquals(expected, apfsFiletoStringArray(actual));
	}
		
	@Test
	public void verifyFileB() {
		String[] expected = { "false", "b", "applications", "20", localTime.toString(), "ApfsFile",localTime.toString() };
		ApfsFile actual = b;
		assertArrayEquals(expected, apfsFiletoStringArray(actual));
		}
		
	@Test
	public void verifyFileC() {
		String[] expected = { "false", "c", "home", "30", localTime.toString(), "ApfsFile",localTime.toString() };
		ApfsFile actual = c;
		assertArrayEquals(expected, apfsFiletoStringArray(actual));
	}
	@Test
	public void verifyFileD() {
		String[] expected = { "false", "d", "home","40", localTime.toString(), "ApfsFile",localTime.toString() };
		ApfsFile actual = d;
		assertArrayEquals(expected, apfsFiletoStringArray(actual));
	}
	
	@Test
	public void verifyFileE() {
		String[] expected = { "false", "e", "code", "15", localTime.toString(), "ApfsFile", localTime.toString() };
		ApfsFile actual = e;
	    assertArrayEquals(expected, apfsFiletoStringArray(actual));
	}
	
	@Test
	public void verifyFileF() {
		String[] expected = { "false", "f", "code","15", localTime.toString(), "ApfsFile",localTime.toString() };
		ApfsFile actual = f;
		assertArrayEquals(expected, apfsFiletoStringArray(actual));
	}
}
