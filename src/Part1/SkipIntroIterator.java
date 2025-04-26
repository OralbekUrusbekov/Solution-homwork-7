package Part1;
import java.util.Iterator;


public class SkipIntroIterator implements Iterator<EpisodeView> {
    private EpisodeIterator baseIterator;
    private int skipSeconds;

    public SkipIntroIterator(EpisodeIterator baseIterator, int skipSeconds) {
        this.baseIterator = baseIterator;
        this.skipSeconds = skipSeconds;
    }

    @Override
    public boolean hasNext() {
        return baseIterator.hasNext();
    }

    @Override
    public EpisodeView next() {
        Episode ep = baseIterator.next();
        return new EpisodeView(ep, Math.min(skipSeconds, ep.getRuntimeSec()));
    }
}

