package best.youarethe.game.services;

import best.youarethe.game.dao.GameRepository;
import best.youarethe.game.pojo.Game;
import best.youarethe.game.pojo.Location;
import best.youarethe.game.pojo.Task;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedScanList;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.function.Predicate;

@Service
public class GameService {
    private GameRepository repository;
    private final String STATUS_PROP = "status";

    public GameService(GameRepository repository) {
        this.repository = repository;
    }

    public boolean getGameStatus() {
        Game item = repository.loadProp(STATUS_PROP);
        return item.getIsStarted();
    }

    public boolean createTask(Task task) {
        task.setDone(false);
        repository.saveTask(task);
        return true;
    }

    public Task getTask(int number) {
        return repository.loadTask(number);
    }

    public boolean startGame() {
        try {
            repository.changeProp(new Game(STATUS_PROP, true));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean stopGame() {
        try {
            repository.changeProp(new Game(STATUS_PROP, false));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public Location[] getLastLocations() {
        PaginatedScanList<Location> list = repository.loadLocations();

        return list.stream()
                .sorted(Comparator.comparingInt(Location::getId).reversed())
                .limit(5)
                .toArray(Location[]::new);
    }

    public boolean addLocation(Location location) {
        try {
            PaginatedScanList<Location> res = repository.loadLocations();
            int id = res.stream().max(Comparator.comparingInt(Location::getId)).map(Location::getId).orElse(-1);
            location.setId(++id);
            repository.saveLocation(location);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean deleteTask(int taskId) {
        try {
            Task task = new Task();
            task.setId(taskId);
            repository.deleteTask(task);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public Task getCurrentTask() {
        PaginatedScanList<Task> list = repository.loadAllTasks();
        return list.stream()
                .filter(Predicate.not(Task::isDone))
                .min(Comparator.comparingInt(Task::getId))
                .orElse(null);
    }

    public Task[] getAllTask() {
        PaginatedScanList<Task> list = repository.loadAllTasks();
        return list.stream()
                .sorted(Comparator.comparingInt(Task::getId))
                .toArray(Task[]::new);
    }
}
