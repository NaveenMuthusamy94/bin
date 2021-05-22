package edu.umb.cs680.hw15.fs;

public abstract class FileSystem {
	protected String name;
	protected int capacity;
	protected FSElement rootDir;
	protected int id;
	
	public String getFileSystemName() {
		return this.name;
	}
	
	public int getCapacity() {
		return this.capacity;
	}
	
	public int getId() {
		return this.id;
	}
	
	public FSElement initFileSystem(String name, int capacity) {
		this.name = name;
		this.capacity = capacity;
		FSElement root = createDefaultRoot();
		if(root.isDirectory() && capacity >= root.getSize()){
			setRootDir(root);
			this.id = root.hashCode();
			return root;
		}
		else
			return null;
	}

	protected void setRootDir(FSElement root) {
		this.rootDir = root;
	}
	
	public FSElement getRootDir() {
		return this.rootDir;
	}
	
	protected abstract FSElement createDefaultRoot();
}


