package md.mazharul.islam.jihan.reportings.JsonModel;

import java.util.List;

public class ReportDetails
{
    public String reporterName;
    public String dateTime;
    public String details;
    public String video;
    public String headline;
    public String address;
    public List<String> photos;

    public ReportDetails() {
    }

    @Override
    public String toString() {
        return "ReportDetails{" +
                "reporterName='" + reporterName + '\'' +
                ", dateTime='" + dateTime + '\'' +
                ", details='" + details + '\'' +
                ", video='" + video + '\'' +
                ", headline='" + headline + '\'' +
                ", address='" + address + '\'' +
                ", photos=" + photos.size() +
                '}';
    }
}