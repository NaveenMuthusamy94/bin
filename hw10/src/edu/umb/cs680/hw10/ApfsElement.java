package edu.umb.cs680.hw10;

import java.time.LocalDateTime;


public abstract class ApfsElement extends FSElement {

	private String ownerName;
	private LocalDateTime lastModified;
	
	public ApfsElement(ApfsDirectory parent, String name, int size, LocalDateTime creationTime, String ownerName,
			LocalDateTime lastModified) {
		super(parent, name, size, creationTime);
		this.ownerName = ownerName;
		this.lastModified = lastModified;
	}
	
	public abstract void accept(ApfsFSVisitor visitor);

	public String getOwnerName() {
		return ownerName;
	}

	public LocalDateTime getLastModified() {
		return lastModified;
	}
	
}
	
	
