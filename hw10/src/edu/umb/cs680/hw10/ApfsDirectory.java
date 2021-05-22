package edu.umb.cs680.hw10;

import java.time.LocalDateTime;
import java.util.LinkedList;


public class ApfsDirectory  extends ApfsElement {

	private LinkedList<ApfsElement> child = new LinkedList<ApfsElement>();
	private LinkedList<ApfsFile> fileList = new LinkedList<ApfsFile>();
	private LinkedList<ApfsDirectory> directoryList = new LinkedList<ApfsDirectory>();
	LinkedList<ApfsLink> linkList = new LinkedList<ApfsLink>();

	public ApfsDirectory(ApfsDirectory parent, String name, int size, LocalDateTime creationTime, String ownerName,
			LocalDateTime modifiedTime) {
		super(parent, name, 0, creationTime, ownerName, modifiedTime);
		if (parent != null)
			parent.appendChild(this);
	}

	public LinkedList<ApfsElement> getChildren() {
		return this.child;
	}

	public void appendChild(ApfsElement child) {
		this.child.add(child);
		child.setParent(this);
	}


	public int countChildren() {
		return getChildren().size();
	}

	public boolean isDirectory() {
		return true;
	}

	public boolean isFile() {
		return false;
	}

	public boolean isLink() {
		return false;
	}

	public LinkedList<ApfsFile> getFiles() {
		for (FSElement element : child) {
			if (element.isFile()) {
				fileList.add((ApfsFile) element);
			}
		}
		return fileList;
	}
	
	public LinkedList<ApfsLink> getLinks() {
		for (FSElement element : getChildren()) {
			if (element.isLink())
				linkList.add((ApfsLink) element);
		}
		return linkList;
	}

	public LinkedList<ApfsDirectory> getSubDirectories() {
		for (FSElement element : child) {
			if (element.isDirectory()) {
				directoryList.add((ApfsDirectory) element);
			}
		}
		return directoryList;
	}

	public int getTotalSize() {
		int totalSize = 0;
		for (FSElement element : child) {
			if (element.isDirectory()) {
				totalSize += ((ApfsDirectory) element).getTotalSize();
			} else {
				totalSize += element.getSize();
			}
		}
		return totalSize;
	}
	
	public void accept(ApfsFSVisitor visitor) {
		visitor.visit(this);
		for (ApfsElement e : getChildren()) {
			e.accept(visitor);
		}
	}
}
	
	
