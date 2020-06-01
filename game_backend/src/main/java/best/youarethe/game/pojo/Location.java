package best.youarethe.game.pojo;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.io.Serializable;
import java.util.Date;

@DynamoDBTable(tableName = "locations")
@DynamoDBDocument
public class Location implements Serializable {
    private int id;
    private String latitude;
    private String longitude;
    private Date time;

    {
        time = new Date();
    }

    public Location() {
    }

    public Location(String latitude, String longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Location(String latitude, String longitude, Date time) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.time = time;
    }

    public Location(int id, String latitude, String longitude, Date time) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.time = time;
    }

    @DynamoDBHashKey
    public int getId() {
        return id;
    }

    @DynamoDBHashKey
    public void setId(int id) {
        this.id = id;
    }

    @DynamoDBAttribute
    public String getLatitude() {
        return latitude;
    }

    @DynamoDBAttribute
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    @DynamoDBAttribute
    public String getLongitude() {
        return longitude;
    }

    @DynamoDBAttribute
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @DynamoDBAttribute
    public Date getTime() {
        return time;
    }

    @DynamoDBAttribute
    public void setTime(Date time) {
        this.time = time;
    }
}
