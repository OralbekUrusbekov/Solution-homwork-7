package Part1;

/**
  Represents a single episode in a season.
 */
public class Episode {
    private String title;
    private int runtimeSec;

    /**
      Constructs an Episode with a title and runtime.
     */
    public Episode(String title, int runtimeSec) {
        this.title = title;
        this.runtimeSec = runtimeSec;
    }

    /**
      Returns the title of the episode.
     */
    public String getTitle() {
        return title;
    }

    /**
      Returns the runtime of the episode in seconds.
     */
    public int getRuntimeSec() {
        return runtimeSec;
    }

    /**
      String representation for printing (e.g., "Episode 1 (1800s)").
     */
    @Override
    public String toString() {
        return title + " (" + runtimeSec + "s)";
    }
}
