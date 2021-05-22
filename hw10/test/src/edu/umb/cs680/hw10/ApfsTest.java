package edu.umb.cs680.hw10;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class ApfsTest {

	private String[] apfsElementToArray(ApfsElement e) {
		String[] elementInfo = {Boolean.toString(e.isDirectory()), e.getName(), Integer.toString(e.getSize()),
				e.getOwnerName() };
		return elementInfo;
	}
	
	@Test
	public void sameAPFSTest() {
		APFS APFSOne = APFS.getAPFSFileSystem();
		APFS APFSTwo = APFS.getAPFSFileSystem();
		assertSame(APFSOne, APFSTwo);
	}

	@Test
	public void getRootDirTest() {
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsFileSystem.initFileSystem("ApfsFile", 500);
		ApfsDirectory actual = ApfsFileSystem.getRootDir();
		String[] expected = { "true","root", "0","ApfsFile" };
		assertArrayEquals(expected,apfsElementToArray(actual));
	}

	@Test
	public void createDefaultRootTest() {
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsDirectory actual = ApfsFileSystem.getRootDir();
		String[] expected = { "true","root", "0", "ApfsFile" };
		assertArrayEquals(expected, apfsElementToArray(actual));
	}
}
