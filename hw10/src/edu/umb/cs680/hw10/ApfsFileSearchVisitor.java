package edu.umb.cs680.hw10;

public class ApfsFileSearchVisitor implements ApfsFSVisitor {

	private String fileName;
	private ApfsFile file;

	public void visit(ApfsFile file) {
		if (fileName.equals(file.getName()))
			this.file = file;
	}
	
	public ApfsFile getFile() {
		return file;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void visit(ApfsDirectory dir) {
		return;
	}

	public void visit(ApfsLink link) {
		return;
	}	
}