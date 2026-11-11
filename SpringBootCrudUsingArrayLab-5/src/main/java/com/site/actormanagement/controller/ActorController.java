
package com.site.actormanagement.controller;

import com.site.actormanagement.model.Actor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ActorController {


    private Actor[] actors = {
            new Actor(1, "John Doe", "The Great Adventure"),
            new Actor(2, "Jane Smith", "Mystery Island")
    };

    // READ ALL
    @GetMapping("/actor")
    public Actor[] getAllActors() {
        return actors;
    }

    // READ BY ID
    @GetMapping("/actor/{id}")
    public Actor getActorById(@PathVariable int id) {

        for (Actor actor : actors) {
            if (actor.getId() == id) {
                return actor;
            }
        }

        return null;
    }

    // CREATE
    @PostMapping("/actor")
    public Actor createActor(@RequestBody Actor newActor) {

        Actor[] newActors = new Actor[actors.length + 1];

        for (int i = 0; i < actors.length; i++) {
            newActors[i] = actors[i];
        }

        newActors[actors.length] = newActor;

        actors = newActors;

        return newActor;
    }

    // UPDATE
    @PutMapping("/actor/{id}")
    public Actor updateActor(
            @PathVariable int id,
            @RequestBody Actor updatedActor) {

        for (Actor actor : actors) {

            if (actor.getId() == id) {

                actor.setName(updatedActor.getName());
                actor.setMovieName(updatedActor.getMovieName());

                return actor;
            }
        }

        return null;
    }

    // DELETE
    @DeleteMapping("/actor/{id}")
    public String deleteActorById(@PathVariable int id) {

        int count = 0;

        for (Actor actor : actors) {
            if (actor.getId() != id) {
                count++;
            }
        }

        Actor[] newActors = new Actor[count];

        int index = 0;

        for (Actor actor : actors) {
            if (actor.getId() != id) {
                newActors[index] = actor;
                index++;
            }
        }

        actors = newActors;

        return "Actor with ID " + id + " has been deleted successfully!";
    }
}
