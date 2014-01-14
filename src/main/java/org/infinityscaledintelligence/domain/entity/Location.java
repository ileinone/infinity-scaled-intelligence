package org.infinityscaledintelligence.domain.entity;

import java.util.LinkedList;
import java.util.List;

public class Location {
	
	private Location location;
    private Location parent;
    private List<Location> children;

    public Location(Location location) {
        this.location = location;
        this.children = new LinkedList<Location>();
    }

    public Location addChild(Location child) {
        Location childNode = new Location(child);
        childNode.parent = this;
        this.children.add(childNode);
        return childNode;
    }

    public Location getParent() {
    	return this.parent;
    }

}
