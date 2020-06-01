package best.youarethe.game.controllers;

import best.youarethe.game.pojo.Location;
import best.youarethe.game.pojo.Task;
import best.youarethe.game.services.GameService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/status")
    public ResponseEntity<Boolean> getStatus() {
        return ResponseEntity.ok( gameService.getGameStatus() );
    }

    @PutMapping("/gameStarter")
    public ResponseEntity<Boolean> startGame() {
        return ResponseEntity.ok( gameService.startGame() );
    }

    @PutMapping("/gameStopper")
    public ResponseEntity<Boolean> stopGame() {
        return ResponseEntity.ok( gameService.stopGame() );
    }

    @GetMapping("/task")
    public ResponseEntity<Task> getTask(@RequestParam int number) {
        return ResponseEntity.ok( gameService.getTask(number) );
    }

    @GetMapping("/tasks")
    public ResponseEntity<Task[]> getAllTasks() {
        return ResponseEntity.ok( gameService.getAllTask() );
    }

    @GetMapping("/currentTask")
    public ResponseEntity<Task> getTask() {
        return ResponseEntity.ok( gameService.getCurrentTask() );
    }

    @PostMapping("/task")
    public ResponseEntity<Boolean> createTask(@RequestBody Task task) {
        return ResponseEntity.ok( gameService.createTask(task) );
    }

    @DeleteMapping("/task")
    public ResponseEntity<Boolean> deleteTask(@RequestBody int taskId) {
        return ResponseEntity.ok( gameService.deleteTask(taskId) );
    }

    @CrossOrigin(origins = "http://localhost:3000")
    // TODO: 6/1/20 change CrossOrigin
    @GetMapping("/locations")
    public ResponseEntity<Location[]> getLastLocations() {
        return ResponseEntity.ok( gameService.getLastLocations());
    }

    @PostMapping("/location")
    public ResponseEntity<Boolean> addLocation(@RequestBody Location location) {
        return ResponseEntity.ok( gameService.addLocation(location));
    }
}
