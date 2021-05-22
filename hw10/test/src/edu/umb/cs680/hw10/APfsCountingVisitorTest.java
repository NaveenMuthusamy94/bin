package edu.umb.cs680.hw10;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;


class APfsCountingVisitorTest {
	
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
	

	@Test
	public void verifyVisitorRoot() {
		ApfsCountingVisitor visitor = new ApfsCountingVisitor();
		root.accept(visitor);
		assertEquals(4,visitor.getDirNumber());
		assertEquals(6,visitor.getFileNumber());
		assertEquals(2,visitor.getLinkNumber());
	}
	
	@Test
	public void verifyVisitorHome() {
		ApfsCountingVisitor visitor = new ApfsCountingVisitor();
		home.accept(visitor);
		assertEquals(2,visitor.getDirNumber());
		assertEquals(4,visitor.getFileNumber());
		assertEquals(2,visitor.getLinkNumber());
	}
	@Test
	public void verifyVisitorCode() {
		ApfsCountingVisitor visitor = new ApfsCountingVisitor();
		code.accept(visitor);
		assertEquals(1,visitor.getDirNumber());
		assertEquals(2,visitor.getFileNumber());
		assertEquals(1,visitor.getLinkNumber());
	}
	
}
