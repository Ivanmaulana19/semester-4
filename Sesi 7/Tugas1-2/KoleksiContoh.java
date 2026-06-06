import java.util.ArrayDeque;
import java.util.ArrayList;

public class KoleksiContoh {
    public static void main(String[] args) {
        // ArrayList: Urutan data dinamis
        ArrayList<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Python");
        System.out.println("ArrayList: " + list);

        // ArrayDeque: Antrean (Queue)
        ArrayDeque<String> antrean = new ArrayDeque<>();
        antrean.addLast("User A");
        antrean.addLast("User B");
        System.out.println("Antrean awal: " + antrean);
        System.out.println("Melayani: " + antrean.pollFirst());
        System.out.println("Sisa antrean: " + antrean);
    }
}