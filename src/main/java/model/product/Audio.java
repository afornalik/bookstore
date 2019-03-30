package model.product;

import model.Product;
import model.product.track.Track;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Audio extends Product {

    private final LocalDate publishmentDate;
    private List<Track> trackList;


    public Audio(long id, String name, BigDecimal price, LocalDate publishmentDate, List trackList) {
        super(id, name, price);
        this.publishmentDate = publishmentDate;
        this.trackList = trackList;
    }

    public LocalDate getPublishmentDate() {
        return publishmentDate;
    }

    public List<Track> getTrackList() {
        return trackList;
    }
}
