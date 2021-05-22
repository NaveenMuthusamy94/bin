package edu.umb.cs680.hw15.apfs;

import java.time.LocalDateTime;

public class ApfsLink extends ApfsElement{
	
	private ApfsElement target;
	public ApfsLink(ApfsDirectory parent, String name, int size, LocalDateTime creationTime, String OwnerName, LocalDateTime LD, ApfsElement target) {
		super(parent, name, size, creationTime, OwnerName, LD);
		this.target = target;
		parent.appendChild(this);
	}
	
	public ApfsElement getTarget() {
		return this.target;
	}
	
	@Override
	public boolean isDirectory() {
		return false;
	}
}
