import Part1.*;

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

        System.out.println("Normal Iterator:");
        EpisodeIterator normal = new SeasonIterator(season1);
        while (normal.hasNext()) {
            System.out.println(normal.next());
        }

        System.out.println("\nReverse Iterator:");
        EpisodeIterator reverse = new ReverseSeasonIterator(season1);
        while (reverse.hasNext()) {
            System.out.println(reverse.next());
        }

        System.out.println("\nShuffle Iterator (seed = 42):");
        EpisodeIterator shuffle = new ShuffleSeasonIterator(season1, 42);
        while (shuffle.hasNext()) {
            System.out.println(shuffle.next());
        }

        System.out.println("\nSeason with for-each:");
        for (Episode ep : season1) {
            System.out.println(ep);
        }

        System.out.println("\nBinge Iterator:");
        EpisodeIterator binge = new BingeIterator(series);
        while (binge.hasNext()) {
            System.out.println(binge.next());
        }
    }
}
