package org.example.navigator;

import java.util.ArrayList;

/**
* Created by Dmitry.Ivanov on 10/26/2014.
*/
public class Way {

    public final long id;

    public final ArrayList<Node> nodes = new ArrayList<>();
    public RoadType roadType;
    public double dist;
    public Node start;
    public Node end;

    public Way(long id) {
        this.id = id;
        this.roadType = RoadType.ROAD;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Way way = (Way) o;

        if (id != way.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int)id;
    }

    public void finish() {
        if (start != null) throw new IllegalStateException("finish called twice");

        start = nodes.get(0);
        end = nodes.get(nodes.size()-1);

        double d = 0;
        for (int i = 1; i < nodes.size(); i++) {
            Edge e = new Edge(this, nodes.get(i-1), nodes.get(i));
            nodes.get(i-1).edges.add(e);
            nodes.get(i).edges.add(e);
            d += e.realDist;
        }
        dist = d;
    }
}
