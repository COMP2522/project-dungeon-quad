package org.bcit.comp2522.project;

import java.util.ArrayList;
import java.util.List;

/**
 * Each Wave has a number of enemies.
 */
public class Waves {

  int waveNumber;
  List<Waves> waves;

  // Number of enemies in each wave
  int skeletons = 10; // EASY
  int goblins = 5; // MEDIUM
  int trolls = 3; // HARD


  // List of skeletons, goblins, and trolls
  List<Skeleton> skeletonsList = new ArrayList<>();
  List<Goblin> goblinsList = new ArrayList<>();
  List<Troll> trollsList = new ArrayList<>();


  public List<Waves> getWaves(){
    return waves;
  }

  public void setWaves(List<Waves> waves){
    this.waves = waves;
  }

  public int getWaveNumber(){
    return waveNumber;
  }

  public void setWaveNumber(int waveNumber){
    this.waveNumber = waveNumber;
  }

  public void spawnWaves(int waveNumber, int skeletons, int goblins, int trolls) {

      skeletons += waveNumber; // Increase skeletons at a normal rate (every wave)
      goblins += waveNumber/2; // Increase goblins at a slower rate (every 2 waves)
      trolls += waveNumber/3; // Increase trolls at an even slower rate (every 3 waves)

      int enemiesRemaining = skeletons + goblins + trolls;

      // Spawn waves
      spawnSkeleton(skeletons);
      spawnGoblin(goblins);
      spawnTroll(trolls);

      while (enemiesRemaining > 0) {
        // Check if any enemies are defeated
        if (allEnemiesDefeated()){
          waveNumber++;
          spawnWaves(waveNumber, skeletons, goblins, trolls); // RECURSIVE CALL YOOOOOOOOO -ean
          return;
        }

        // Pause between waves
        try {
          Thread.sleep(1000); // wait 1 second
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
  }

  public boolean allEnemiesDefeated() {
    for (Skeleton skeleton : skeletonsList) {
      if (skeleton.isAlive()) {
        return false;
      }
    }

    for (Goblin goblin : goblinsList) {
      if (goblin.isAlive()) {
        return false;
      }
    }

    for (Troll troll : trollsList) {
      if (troll.isAlive()) {
        return false;
      }
    }

    return true; // All enemies are defeated
  }



  private void spawnSkeleton(int skeletons) {
    for (int i = 0; i < skeletons; i++) {
      Skeleton skeleton = new Skeleton();
      skeletonsList.add(skeleton);
      // spawn skeleton
    }
  }

  private void spawnGoblin(int goblins) {
    for (int i = 0; i < goblins; i++) {
      Goblin goblin = new Goblin();
      goblinsList.add(goblin);
      // spawn goblin
    }
  }

  private void spawnTroll(int trolls) {
    for (int i = 0; i < trolls; i++) {
      Troll troll = new Troll();
      trollsList.add(troll);
      // spawn troll
    }
  }


  public void removeDefeatedWaves(int skeletons, int goblins, int trolls){
    // remove defeated waves
  }
}
