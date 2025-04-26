import Part1.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Create episodes
        Episode e1 = new Episode("Pilot", 1800);
        Episode e2 = new Episode("Second Wind", 1900);
        Episode e3 = new Episode("Finale", 2000);

        // Season 1
        Season season1 = new Season();
        season1.addEpisode(e1);
        season1.addEpisode(e2);

        // Season 2
        Season season2 = new Season();
        season2.addEpisode(e3);

        // Series
        Series series = new Series();
        series.addSeason(season1);
        series.addSeason(season2);

        // Skip Intro
        System.out.println("\nSkip Intro Iterator (skip 90s):");
        EpisodeIterator binge = new BingeIterator(series);
        SkipIntroIterator skipIntro = new SkipIntroIterator(binge, 90);
        while (skipIntro.hasNext()) {
            EpisodeView view = skipIntro.next();
            view.play(); // starts from 90s
        }

        // Watch History Filter
        System.out.println("\nWatch History Filter (watched: 'Pilot'):");
        Set<String> watched = new HashSet<>();
        watched.add("Pilot");

        EpisodeIterator season1Iterator = new SeasonIterator(season1);
        WatchHistoryFilterIterator unseenIterator = new WatchHistoryFilterIterator(season1Iterator, watched);

        while (unseenIterator.hasNext()) {
            System.out.println("Unseen: " + unseenIterator.next().getTitle());
        }
    }
}
