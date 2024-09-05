//import java.lang.ArrayIndexOutOfBoundsException;
import java.lang.NullPointerException;
import java.util.Hashtable;
//import java.util.HashMap;

public class Map {
    Hashtable<Integer, Hashtable<Integer,MapTile>> Tiles = new Hashtable<Integer, Hashtable<Integer,MapTile>>();
    
    Map(MapTile[] tiles) {
        Tiles.put(0, new Hashtable<Integer, MapTile>());
        Hashtable<Integer, Hashtable<Integer,MapTile>> output = new Hashtable<Integer, Hashtable<Integer,MapTile>>();
            //build table of tables for 2d map
        output.put(0,new Hashtable<Integer,MapTile>());
        
        
        System.out.println("Building map");
        
        for(int i = 0;i<tiles.length;i+=1) {
            System.out.println(i+1+"/"+tiles.length);
            while(true) {
                try{
                    output.get(tiles[i].x).put(tiles[i].y,tiles[i]);
                    System.out.println("Put "+tiles[i]+" at "+tiles[i].x+","+tiles[i].y);
                    break;
                } catch(NullPointerException e) {
                    System.out.println("Failed, expanding map");
                    System.out.println(tiles);
                    e.printStackTrace();
                    int timesExpanded;
                    for(timesExpanded = 1;timesExpanded<=tiles[i].x;timesExpanded++) {
                        output.put(timesExpanded-1,new Hashtable<Integer,MapTile>());
                    }
                    System.out.println("Expanded map "+timesExpanded+" times");
                    break;
                }
            }
        }
        System.out.println("Filling in holes");
        for(int i = 0; i<output.size();i++) {
            for(int j = 0; j<output.get(i).size();j++) {
                System.out.println(output.get(i).get(j));
                //in progress, should fill nulls with empty map tiles
            }
        }
        Tiles = output;
    }
}