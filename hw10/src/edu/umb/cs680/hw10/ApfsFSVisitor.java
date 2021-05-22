package edu.umb.cs680.hw10;

public interface ApfsFSVisitor {
	
	public void visit(ApfsLink link);
	public void visit(ApfsDirectory dir);
	public void visit(ApfsFile file);
}
