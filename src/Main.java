import Part1.*;
import Part2.*;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class Main {
    public static void main(String[] args) {
        // Iterator Pattern Test
        System.out.println("    Iterator Pattern Test   ");
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


        System.out.println();
        System.out.println();
        System.out.println();
        // Iterator Pattern Test
        System.out.println("    Mediator Pattern Test   ");
        ControlTower tower = new ControlTower();
        Random rand = new Random();

        List<Aircraft> aircrafts = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Aircraft a;
            int type = rand.nextInt(3);
            String id = "A" + i;

            switch (type) {
                case 0 -> a = new PassengerPlane(id);
                case 1 -> a = new CargoPlane(id);
                default -> a = new Helicopter(id);
            }

            tower.registerAircraft(a);
            aircrafts.add(a);
        }

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(() -> {
            Aircraft a = aircrafts.get(rand.nextInt(aircrafts.size()));
            int chance = rand.nextInt(10);
            if (chance < 2) {
                a.send("MAYDAY", tower); // Emergency
            } else {
                if (tower.requestRunway(a)) {
                    a.receive("Landing successful.");
                    tower.releaseRunway();
                }
            }

            tower.processQueues();
        }, 0, 1, TimeUnit.SECONDS);

        // Auto shutdown after 20 seconds
        scheduler.schedule(() -> {
            scheduler.shutdown();
            System.out.println("\nSimulation ended.");
        }, 20, TimeUnit.SECONDS);
    }

    }

