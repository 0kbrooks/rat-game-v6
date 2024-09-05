import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MapTile a = new MapTile();
        System.out.println(a);
        MapTile[] b = {a,a};
        Map g = new Map(b);
        System.out.println(g.Tiles);
    }
    
}