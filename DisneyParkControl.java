// --== CS400 Project Three File Header ==--
// Name: Henry Burke
// CSL Username: hburke
// Email: hpburke@wisc.edu
// Lecture #: 001 @11:00am
// Notes to Grader: did you drink enough water today?

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class DisneyParkControl {
    public static void main(String[] args) {
        Graph<IAttraction, Integer> graph = new Graph<>();
        DOTLoader dotloader = new DOTLoader();

        ArrayList<IAttraction> attractions = null;
        try {
            attractions = dotloader.loadData("AttractionData.gv");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (attractions != null) {
            for (IAttraction attraction : attractions) {
                graph.insertVertex(attraction);
            }
        }

            for(int i = 0; i < attractions.size(); i++) {
                for(int j = 0; j < attractions.get(i).getLinks().size(); j++) {
                    Attraction.Link link = (Attraction.Link) attractions.get(i).getLinks().get(j);
                    graph.insertEdge(link.source, link.target, link.weight);
                }
            }

        DisneyParkBackend backend = new DisneyParkBackend(graph, attractions);
        DisneyParkFrontend frontend = new DisneyParkFrontend(backend);

        frontend.runCommandLoop();
    }
}
