package Part1;

import java.util.ArrayList;
import java.util.List;

/**
  The Series class holds a collection of seasons and provides functionality
  to add seasons to the series and retrieve all the seasons.
 */

public class Series {
    private List<Season> seasons = new ArrayList<>();


    public void addSeason(Season s) {
        seasons.add(s);
    }


    public List<Season> getSeasons() {
        return seasons;
    }
}
