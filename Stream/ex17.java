import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ex17 {
    public static void main(String[] args) {
        // filter() method ex
        Customer john = new Customer("John P.", 15);
        Customer sarah = new Customer("Sarah M.", 200);
        Customer charles = new Customer("Charles B.", 150);
        Customer mary = new Customer("Mary T.", 1);

        List<Customer> customer = Arrays.asList(john, sarah, charles, mary);

        List<Customer> customersWithMoreThan100Points = customer.stream().filter(c -> c.getPoints() > 100)
                .collect(Collectors.toList());

        customersWithMoreThan100Points.stream().forEach(System.out::println);
        System.out.println();

        List<Customer> charlesWithMoreThan100Points = customer.stream()
                .filter(c -> c.getPoints() > 100 && c.getName().startsWith("Charles"))
                .collect(Collectors.toList());

        charlesWithMoreThan100Points.stream().forEach(System.out::println);
        System.out.println();

        List<Customer> customersWithValidProfilePhoto = customer.stream()
                .filter(c -> {
                    try {
                        return c.hasValidProfilePhoto();
                    } catch (IOException e) {
                        //
                    }
                    return false;
                })
                .collect(Collectors.toList());
        
        customersWithValidProfilePhoto.stream().forEach(System.out::println);
    }
}