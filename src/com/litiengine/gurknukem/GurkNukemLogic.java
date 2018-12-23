package com.litiengine.gurknukem;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.entities.Spawnpoint;
import de.gurkenlabs.litiengine.graphics.Camera;
import de.gurkenlabs.litiengine.graphics.PositionLockCamera;

public final class GurkNukemLogic {

  private GurkNukemLogic() {
  }

  /**
   * Initializes the game logic for the GURK NUKEM game.
   */
  public static void init() {

    // we'll use a camera in our game that is locked to the location of the player
    Camera camera = new PositionLockCamera(Player.instance());
    camera.setClampToMap(true);
    Game.world().setCamera(camera);
    
    Game.world().setGravity(70);

    // add default game logic for when a level was loaded
    Game.world().addLoadedListener(e -> {

      // spawn the player instance on the spawn point with the name "enter"
      Spawnpoint enter = e.getSpawnpoint("enter");
      if (enter != null) {
        enter.spawn(Player.instance());
      }
    });
  }
}