package edu.umb.cs680.hw10;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

class AfpsFileSearchVisitorTest {
	
	LocalDateTime localTime = LocalDateTime.now();
	APFS ApfsFileSystem = APFS.getAPFSFileSystem();
	ApfsDirectory root = (ApfsDirectory) ApfsFileSystem.initFileSystem("Apfs", 500);
	ApfsDirectory applications = new ApfsDirectory(root, "applications", 0, localTime,"ApfsFile",localTime);
	ApfsDirectory home = new ApfsDirectory(root, "home", 0, localTime,"ApfsFile",localTime);
	ApfsDirectory code = new ApfsDirectory(home, "code", 0, localTime,"ApfsFile",localTime);
	ApfsFile a = new ApfsFile(applications, "a", 10, localTime,"ApfsFile",localTime);
	ApfsFile b = new ApfsFile(applications, "b", 15, localTime,"ApfsFile",localTime);
	ApfsFile c = new ApfsFile(home, "c", 20, localTime,"ApfsFile",localTime);
	ApfsFile d = new ApfsFile(home, "d", 50, localTime,"ApfsFile",localTime);
	ApfsFile e = new ApfsFile(code, "e", 10, localTime,"ApfsFile",localTime);
	ApfsFile f = new ApfsFile(code, "f", 20, localTime,"ApfsFile",localTime);
	ApfsLink x = new ApfsLink(home, "x", 0, localTime, "ApfsFile", localTime, applications);
	ApfsLink y = new ApfsLink(code, "y", 0, localTime,"ApfsFile",localTime,b);
	
	private String[] fileToStringArray(ApfsFile f) {
		String[] fileInfo = { Boolean.toString(f.isDirectory()), f.getName(), Integer.toString(f.getSize()),f.getCreationTime().toString(),
					f.getOwnerName(), f.getLastModified().toString() };
			return fileInfo;
	}

	@Test
	public void verifyFileA() {
		ApfsFileSearchVisitor visitor = new ApfsFileSearchVisitor();
		String[] expected = { "false", "a", "10", localTime.toString(), "ApfsFile", localTime.toString() };
		visitor.setFileName("a");
		root.accept(visitor);
		ApfsFile actual = visitor.getFile();
		assertArrayEquals(expected, fileToStringArray(actual));
	}
		
	@Test
	public void verifyFileB() {
		ApfsFileSearchVisitor visitor = new ApfsFileSearchVisitor();
		String[] expected = { "false", "b", "15", localTime.toString(), "ApfsFile", localTime.toString() };
		visitor.setFileName("b");
		root.accept(visitor);
		ApfsFile actual = visitor.getFile();
		assertArrayEquals(expected, fileToStringArray(actual));
	}
	
	@Test
	public void verifyFileC() {
		ApfsFileSearchVisitor visitor = new ApfsFileSearchVisitor();
		String[] expected = { "false", "c", "20", localTime.toString(), "ApfsFile", localTime.toString() };
		visitor.setFileName("c");
		root.accept(visitor);
		ApfsFile actual = visitor.getFile();
		assertArrayEquals(expected, fileToStringArray(actual));
	}
	
	@Test
	public void verifyFileD() {
		ApfsFileSearchVisitor visitor = new ApfsFileSearchVisitor();
		String[] expected = { "false", "d", "50", localTime.toString(), "ApfsFile", localTime.toString() };
		visitor.setFileName("d");
		root.accept(visitor);
		ApfsFile actual = visitor.getFile();
		assertArrayEquals(expected, fileToStringArray(actual));
	}

	@Test
	public void verifyFileE() {
		ApfsFileSearchVisitor visitor = new ApfsFileSearchVisitor();
		String[] expected = { "false", "e", "10", localTime.toString(), "ApfsFile", localTime.toString() };
		visitor.setFileName("e");
		root.accept(visitor);
		ApfsFile actual = visitor.getFile();
		assertArrayEquals(expected, fileToStringArray(actual));
	}
	
	@Test
	public void verifyFileF() {
		ApfsFileSearchVisitor visitor = new ApfsFileSearchVisitor();
		String[] expected = { "false", "f", "20", localTime.toString(), "ApfsFile", localTime.toString() };
		visitor.setFileName("f");
		root.accept(visitor);
		ApfsFile actual = visitor.getFile();
		assertArrayEquals(expected, fileToStringArray(actual));
	}

}
