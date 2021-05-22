package edu.umb.cs680.hw15.apfs;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.LinkedList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class AlphabeticalComparatorTest {
	
	static LocalDateTime localTime = LocalDateTime.now();
	
	private String[] ApfsEleToString(LinkedList<ApfsElement> l) {
		String[] info = new String[l.size()];
		int i=0;
		for(ApfsElement e: l) {
			info[i] = e.getName();
			//System.out.println(info[i]);
			i++;
		}
        return info;
		
	}
	
	private String[] APFSFileToString(LinkedList<ApfsFile> l) {
		String[] info = new String[l.size()];
		int i=0;
		for(ApfsFile e: l) {
			info[i] = e.getName();
			//System.out.println(info[i]);
			i++;
		}
        return info;
    }
	
	
	@SuppressWarnings("unused")
	@BeforeAll
	public static void setUpFileStructure() {
		APFS apfsFileSystem = APFS.getAPFSFileSystem();
		ApfsDirectory root  = (ApfsDirectory) apfsFileSystem.initFileSystem("root", 3500);
		ApfsDirectory applications = new ApfsDirectory(root, "applications", 0, localTime, "Naveen", localTime);
		ApfsDirectory home = new ApfsDirectory(root, "home", 0, localTime, "Naveen", localTime);
		ApfsDirectory code = new ApfsDirectory(home, "code", 0, localTime, "Naveen", localTime);
		ApfsDirectory pics = new ApfsDirectory(home, "pics", 0, localTime, "Naveen", localTime);
		ApfsFile a = new ApfsFile(applications, "a", 350, localTime, "Naveen", localTime);
		ApfsFile b = new ApfsFile(home, "b", 700, localTime, "Naveen", localTime);
		ApfsFile c = new ApfsFile(code, "c", 800, localTime, "Naveen", localTime);
		ApfsFile d = new ApfsFile(code, "d", 80, localTime, "Naveen", localTime);
		ApfsFile e = new ApfsFile(pics, "e", 700, localTime, "Naveen", localTime);
		ApfsFile f = new ApfsFile(pics, "f", 870, localTime, "Naveen", localTime);
		ApfsFile g = new ApfsFile(home, "g", 1, localTime, "Naveen", localTime);
		ApfsLink x = new ApfsLink(home, "x", 0, localTime, "Naveen", localTime, applications);
		ApfsLink y = new ApfsLink(code, "y", 0, localTime, "Naveen", localTime, a);
	}
	
    @Test
	public void ChildrenHomeDiretoryComparatorTest() {
		String[] expected = {"b", "code","g", "pics", "x"};
		APFS FilesystemApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemApfs.getRootDir();
		LinkedList<ApfsElement> l= root.findDirectoryByName("home").getChildren((ApfsElement arg1, ApfsElement arg2)-> arg1.getName().compareTo(arg2.getName()));
		assertArrayEquals(expected, ApfsEleToString(l));
	}
	
	@Test
	public void FilesInCodeDirectoryComparatorTest() {
		String[] expected = {"c","d"};
		APFS FilesystemApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemApfs.getRootDir();
		LinkedList<ApfsFile> l= root.findDirectoryByName("code").getFiles((ApfsElement arg1, ApfsElement arg2)-> arg1.getName().compareTo(arg2.getName()));
		assertArrayEquals(expected, APFSFileToString(l));
	}
	
	@Test
	public void FileInPicsDirectoryComparatorTest() {
		String[] expected = {"e","f"};
		APFS FilesystemApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemApfs.getRootDir();
		LinkedList<ApfsFile> l= root.findDirectoryByName("pics").getFiles((ApfsElement arg1, ApfsElement arg2)-> arg1.getName().compareTo(arg2.getName()));
		assertArrayEquals(expected, APFSFileToString(l));
	}
	
	@Test
	public void ChildrenInRootDirectoryComparatorTest() {
		String[] expected = {"applications","home"};
		APFS FilesystemApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemApfs.getRootDir();
		LinkedList<ApfsElement> l= root.findDirectoryByName("root").getChildren((ApfsElement arg1, ApfsElement arg2)-> arg1.getName().compareTo(arg2.getName()));
		assertArrayEquals(expected, ApfsEleToString(l));
	}
	
	@Test
	public void FileInHomeDirectoryComparatorTest() {
		String[] expected = {"b","g"};
		APFS FilesystemApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemApfs.getRootDir();
		LinkedList<ApfsFile> l= root.findDirectoryByName("home").getFiles((ApfsElement arg1, ApfsElement arg2)-> arg1.getName().compareTo(arg2.getName()));
		assertArrayEquals(expected, APFSFileToString(l));
	}

}
