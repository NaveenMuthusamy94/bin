package edu.umb.cs680.hw15.apfs;

import edu.umb.cs680.hw15.fs.FSElement;
import java.time.LocalDateTime;

public abstract class ApfsElement extends FSElement{
	protected String OwnerName;
	protected LocalDateTime lastModified;
	
	ApfsElement(ApfsDirectory parent, String name, int size, LocalDateTime creationTime, String OwnerName, LocalDateTime LD){
		super(parent, name, size, creationTime);
		this.OwnerName = OwnerName;
		this.lastModified = LD;
	}
	
	public String getOwnerName() {
		return this.OwnerName;
	}
	
	public LocalDateTime getLastModified() {
		return this.lastModified;
	}
	
	public abstract boolean isDirectory();
}


