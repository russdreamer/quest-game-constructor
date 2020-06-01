package best.youarethe.game.pojo;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.io.Serializable;

@DynamoDBTable(tableName = "game")
@DynamoDBDocument
public class Game implements Serializable {
    private String prop;
    private boolean isStarted;

    public Game() {
    }

    public Game(String prop, boolean isStarted) {
        this.prop = prop;
        this.isStarted = isStarted;
    }

    @DynamoDBHashKey
    public String getProp() {
        return prop;
    }

    @DynamoDBAttribute
    public boolean getIsStarted() {
        return isStarted;
    }

    @DynamoDBHashKey
    public void setProp(String prop) {
        this.prop = prop;
    }


    @DynamoDBAttribute
    public void setIsStarted(boolean isStarted) {
        this.isStarted = isStarted;
    }
}
