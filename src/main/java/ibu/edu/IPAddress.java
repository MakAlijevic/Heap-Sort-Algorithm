package ibu.edu;

public class IPAddress implements Comparable<IPAddress>{
    long ipFrom;
    long ipTo;
    String countryCode;
    String countryName;
    String regionName;
    String cityName;

    public IPAddress(long ipFrom, long ipTo, String countryCode, String countryName, String regionName, String cityName) {
        this.ipFrom = ipFrom;
        this.ipTo = ipTo;
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.regionName = regionName;
        this.cityName = cityName;
    }

    public long getIpFrom(){
        return this.ipFrom;
    }

    @Override
    public int compareTo(IPAddress that) {
        if(this.ipFrom > that.ipFrom){
            return 1;
        }
        else if(this.ipFrom < that.ipFrom){
            return -1;
        }
        else{
            return 0;
        }
    }

    public String toString(){
        return ("ipFrom - " + ipFrom + " / ipTo - " + ipTo + " / countryCode - " + countryCode + " / countryName - " + countryName + " / regionName - " + regionName + " / cityName - " + cityName);
    }
}
