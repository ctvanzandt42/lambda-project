import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static com.sun.tools.doclint.Entity.lambda;
import static jdk.nashorn.internal.objects.Global.print;

public class ComparatorDemo {

    public static void main(String[] args) {
        List<Address> addresses = new ArrayList<>();
        addresses.add(new Address("123 Main St.", "Austin", "TX", "78787"));
        addresses.add(new Address("43 High St.", "Columbus", "OH", "43034"));
        addresses.add(new Address("678 Leon Rd.", "Tallahassee", "FL", "32307"));
        addresses.add(new Address("8 Deep Sea Way", "Boca Raton", "FL", "33433"));

        System.out.println("Before sorting");
        print(addresses);

        Collections.sort(addresses, new Comparator<Address>() {
                    @Override
                    public int compare(Address o1, Address o2) {
                        return o1.getState().compareTo(o2.getState());
                    }
                }
        );

        System.out.println("\nAfter sorting by state");
        print(addresses);

        Collections.sort(addresses, Comparator.comparing(Address::getCity));


        System.out.println("\nAfter sorting by city");
        print(addresses);
    }

    private static void print(List<Address> addresses) {
        for(Address address : addresses) {
            System.out.println(address);
        }
    }
}
