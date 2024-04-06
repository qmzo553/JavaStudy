import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ex03 {
    
    public static void main(String[] args) {
        // Mapping ex
        List<String> uris = new ArrayList<>();
        uris.add("./My.txt");
        uris.add("C:\\My.txt");
        Stream<Path> stream = uris.stream().map(uri -> Paths.get(uri));
        // Stream<Path> stream = uris.stream().map(Paths::get);
        stream.forEach(System.out::println);

        List<Detail> details = new ArrayList<>();
        details.add(new Detail());
        Stream<String> stream2 = details.stream().flatMap(detail -> detail.getParts().stream());
        stream2.forEach(System.out::println);
    }
}

class Detail {
    List<String> PARTS;

    public Detail() {
        PARTS = new ArrayList<>();
    }

    public List<String> getParts() {
        return PARTS;
    }
}
