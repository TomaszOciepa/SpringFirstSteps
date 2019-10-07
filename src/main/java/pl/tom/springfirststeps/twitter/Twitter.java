package pl.tom.springfirststeps.twitter;

import java.time.LocalDateTime;


public class Twitter {
    private int id;
    private String message;
    private LocalDateTime time;
    private Double latitude;
    private Double longitude;

    public Twitter(int id, String message, LocalDateTime time, Double latitude, Double longitude) {
        this.id = id;
        this.message = message;
        this.time = time;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Twitter twitter = (Twitter) o;

        return new org.apache.commons.lang.builder.EqualsBuilder()
                .append(id, twitter.id)
                .append(message, twitter.message)
                .append(time, twitter.time)
                .append(latitude, twitter.latitude)
                .append(longitude, twitter.longitude)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new org.apache.commons.lang.builder.HashCodeBuilder(17, 37)
                .append(id)
                .append(message)
                .append(time)
                .append(latitude)
                .append(longitude)
                .toHashCode();
    }
}
