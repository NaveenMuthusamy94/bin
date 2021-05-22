package edu.umb.cs680.hw10;

public class ApfsCountingVisitor implements ApfsFSVisitor{

	private int dirNumber = 0;
	private int fileNumber = 0;
	private int linkNumber = 0;
	
	public int getDirNumber() {
		return dirNumber;
	}
	public int getFileNumber() {
		return fileNumber;
	}
	public int getLinkNumber() {
		return linkNumber;
	}
	public void visit(ApfsDirectory dir) {
		dirNumber++;
	}
	public void visit(ApfsFile file) {
		fileNumber++;
	}
	public void visit(ApfsLink link) {
		linkNumber++;
	}

}