package edu.umb.cs680.hw15.apfs;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import edu.umb.cs680.hw15.fs.FSElement;
public class ApfsDirectory extends ApfsElement{

	private LinkedList<ApfsDirectory> directory = new LinkedList<>();
	private LinkedList<ApfsElement> children = new LinkedList<>();
	private LinkedList<ApfsFile> file = new LinkedList<>();
	
	public ApfsDirectory(ApfsDirectory parent, String name, int size, LocalDateTime creationTime, String OwnerName, LocalDateTime LD) {
		super(parent, name, size, creationTime, OwnerName, LD);
		if(parent!= null) {
			parent.appendChild(this);
		}
	}
	
	public int CountChildren() {
		int totalCount = 0;
		for(@SuppressWarnings("unused") ApfsElement f: getChildren()) {
			totalCount += 1;
		}
		return totalCount;
	}
	
	public void appendChild(ApfsElement child) {
		this.children.add(child);
	}
	
	public LinkedList<ApfsElement> getChildren() {
        Collections.sort(this.children, (ApfsElement arg1, ApfsElement arg2) -> arg1.getName().compareTo(arg2.getName()));
		return this.children;
	}
	
	public LinkedList<ApfsDirectory> getSubDirectory(){
		for(FSElement s: getChildren()) {
			if(s instanceof ApfsDirectory) {
				directory.add((ApfsDirectory) s);
			}
		}
		Collections.sort(directory, (ApfsElement arg1, ApfsElement arg2) -> arg1.getName().compareTo(arg2.getName()));
		return directory;
	}
	
	public LinkedList<ApfsFile> getFiles(){
		for(FSElement s: getChildren()) {
			if(s instanceof ApfsFile) {
				file.add((ApfsFile) s);
			}
		}
		Collections.sort(file, (ApfsElement arg1, ApfsElement arg2) -> arg1.getName().compareTo(arg2.getName()));
		return file;
	}
	
	public LinkedList<ApfsLink> getLinks() {
		LinkedList<ApfsLink> listoflink = new LinkedList<ApfsLink>();
		for(FSElement s : getChildren()) {
			if(s instanceof ApfsLink)
				listoflink.add((ApfsLink) s);
		}
		return listoflink;
	}
	
	public int getTotalSize() {
		int totalSize = 0;
		for(ApfsElement f: getChildren()) {
			if(f instanceof ApfsFile) {
				totalSize += f.getSize();
			}
			if(f instanceof ApfsDirectory) {
				totalSize += ((ApfsDirectory)f).getTotalSize();
			}
		}
		return totalSize;
	}
	
	public ApfsDirectory findDirectoryByName(String name) {
		ApfsDirectory directory = null;
		if(name.equals(getName())) {
			directory = this;
		}
		else {
			for(ApfsDirectory d: getSubDirectory()) {
				if(directory == null) {
					directory = d.findDirectoryByName(name);
					if(name.equals(d.getName())) {
						directory = d;
						break;
					}
				}			
			}
		}
		return directory;
	}
	
	public ApfsFile findFileByName(String name) {
		ApfsFile file = null;
		for(ApfsFile f: getFiles()) {
			if(name.equals(f.getName())) {
				file = f;
			}
		}
		if(file == null) {
			for(ApfsDirectory d: getSubDirectory()) {
				file = d.findFileByName(name);
				if(file != null) {
					break;
				}
			}
		}
		
		return file;
	}
	
	public ApfsLink findLinkByName(String name) {
		ApfsLink link = null;
		for(ApfsLink l : getLinks()) {
			if(name.equals(l.getName()))
				link = l;
		}
		if(link == null) {
			for(ApfsDirectory dir : getSubDirectory()) {
				link = dir.findLinkByName(name);
				if(link != null)
					break;
			}
		}
		return link;
	}
	
	public LinkedList<ApfsElement> getChildren(Comparator<ApfsElement> compare) {
		LinkedList<ApfsElement> f = getChildren();
		Collections.sort(f, compare);
		return f;
	}
	
	public LinkedList<ApfsDirectory> getSubDirectories(Comparator<ApfsElement> compare){
		LinkedList<ApfsDirectory> dir = getSubDirectory();
		Collections.sort(dir, compare);
		return dir;
	}
	
	public LinkedList<ApfsFile> getFiles(Comparator<ApfsElement> compare){
		LinkedList<ApfsFile> f = getFiles();
		Collections.sort(f, compare);
		return f;
	}
	
	@Override
	public boolean isDirectory() {
		return true;
	}

}
