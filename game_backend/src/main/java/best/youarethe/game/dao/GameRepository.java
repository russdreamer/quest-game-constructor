package best.youarethe.game.dao;


import best.youarethe.game.pojo.Game;
import best.youarethe.game.pojo.Location;
import best.youarethe.game.pojo.Task;
import com.amazonaws.services.dynamodbv2.datamodeling.*;
import org.springframework.stereotype.Repository;

@Repository
public class GameRepository {
    private DynamoDBMapper mapper;

    public GameRepository(DynamoDBMapper mapper) {
        this.mapper = mapper;
    }

    public Game loadProp(String prop_name) {
        return mapper.load(Game.class, prop_name);
    }

    public void saveTask( Task task) {
        mapper.save(task);
    }

    public Task loadTask( int number) {
        return mapper.load(Task.class, number);
    }

    public void changeProp(Game gameProp) {
        mapper.save(gameProp);
    }

    public PaginatedScanList<Location> loadLocations() {
        return mapper.scan(Location.class, new DynamoDBScanExpression());
    }

    public void saveLocation(Location location) {
        mapper.save(location);
    }

    public void deleteTask(Task task) {
        mapper.delete(task);
    }

    public PaginatedScanList<Task> loadAllTasks() {
        return mapper.scan(Task.class, new DynamoDBScanExpression());
    }
}
