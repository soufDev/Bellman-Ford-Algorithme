import java.util.ArrayList;
import java.util.List;

public class Vertex {
    private String name;
    private boolean visited;
    private List <Edge>adjacentList;
    private double distanceMin=Double.MAX_VALUE;
    private Vertex previousVertex;


    public Vertex(String name){
        this.name=name;
        this.adjacentList=new ArrayList<Edge>();
    }

    public void addedge(Edge edge){
        this.adjacentList.add(edge);
    }

    @Override
    public String toString(){
        return(this.name);
    }



    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Edge> getAdjacentList() {
        return adjacentList;
    }


    public double getDistanceMin() {
        return distanceMin;
    }

    public void setDistanceMin(double distanceMin) {
        this.distanceMin = distanceMin;
    }

    public Vertex getPreviousVertex() {
        return previousVertex;
    }

    public void setPreviousVertex(Vertex previousVertex) {
        this.previousVertex = previousVertex;
    }

}

