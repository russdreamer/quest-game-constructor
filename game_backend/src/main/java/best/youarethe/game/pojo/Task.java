package best.youarethe.game.pojo;

import com.amazonaws.services.dynamodbv2.datamodeling.*;

import java.io.Serializable;
import java.util.Set;

@DynamoDBTable(tableName = "tasks")
@DynamoDBDocument
public class Task implements Serializable {
    private int id;
    private String html;
    private Set<String> images;
    private Set<String> answers;
    private boolean done;

    public Task() {
    }

    public Task(int id, String html, Set<String> images, Set<String> answers, boolean done) {
        this.id = id;
        this.html = html;
        this.images = images;
        this.answers = answers;
        this.done = done;
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
    public String getHtml() {
        return html;
    }

    @DynamoDBAttribute
    public void setHtml(String html) {
        this.html = html;
    }

    @DynamoDBAttribute
    public Set<String> getImages() {
        return images;
    }

    @DynamoDBAttribute
    public void setImages(Set<String> images) {
        this.images = images;
    }

    @DynamoDBAttribute
    public boolean isDone() {
        return done;
    }

    @DynamoDBAttribute
    public void setDone(boolean done) {
        this.done = done;
    }

    @DynamoDBAttribute
    public Set<String> getAnswers() {
        return answers;
    }

    @DynamoDBAttribute
    public void setAnswers(Set<String> answers) {
        this.answers = answers;
    }
}
