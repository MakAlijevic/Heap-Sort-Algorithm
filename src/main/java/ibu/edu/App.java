package ibu.edu;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\Korisnik\\Desktop\\IP-COUNTRY-REGION-CITY-SHUFFLED\\IP-COUNTRY-REGION-CITY-SHUFFLED.csv";
        String HeapSortPath = "C:\\Users\\Korisnik\\Desktop\\IP-COUNTRY-REGION-CITY-SHUFFLED\\HeapSort IPs.csv";

        File file = new File(path);
        File newFileHeapSort = new File(HeapSortPath);

        Scanner input = new Scanner(file);

        FileWriter HeapSortFileWriter = new FileWriter(newFileHeapSort);


        String[] ips;
        IPAddress[] ipAddressesHeapSort = new IPAddress[50];

        int i = 0;
        while (input.hasNextLine() && i < 50) {

            String data = input.nextLine();
            data = data.replace("\"", "");
            ips = data.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

            long ipFrom = Long.parseLong(ips[0]);
            long ipTo = Long.parseLong(ips[1]);
            ipAddressesHeapSort[i] = new IPAddress(ipFrom, ipTo, ips[2], ips[3], ips[4], ips[5]);
            i++;

        }
        input.close();

        //Heap sort
        long start = System.currentTimeMillis();

        HeapSort.sort(ipAddressesHeapSort);

        for (int a = 0; a < ipAddressesHeapSort.length; a++) {
            HeapSortFileWriter.write("\"" + ipAddressesHeapSort[a].ipFrom + "\"," + "\"" + ipAddressesHeapSort[a].ipTo + "\"," + "\"" + ipAddressesHeapSort[a].countryCode + "\"," + "\"" + ipAddressesHeapSort[a].countryName + "\"," + "\"" + ipAddressesHeapSort[a].regionName + "\"," + "\"" + ipAddressesHeapSort[a].cityName + "\n");
        }
        HeapSortFileWriter.close();
        System.out.println("Heap sort completed! Done in " + (System.currentTimeMillis() - start) + " ms");
    }
}
