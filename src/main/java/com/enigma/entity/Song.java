package com.enigma.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "mst_Song")
public class Song {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    private String nameLagu;
    @ManyToOne
    @JoinColumn(name = "artist_id")
    @JsonIgnore
    private Artist artistId;
    @Transient
    private String artistIdTrasient;

    public Artist getArtistId() {
        return artistId;
    }

    public void setArtistId(Artist artistId) {
        this.artistId = artistId;
    }

    public String getArtistIdTrasient() {
        if (artistIdTrasient == null){
            return    artistId.getName();
        }
        return artistIdTrasient;
    }

    public void setArtistIdTrasient(String artistIdTrasient) {
        this.artistIdTrasient = artistIdTrasient;
    }

    public Song(String nameLagu) {
        this.nameLagu = nameLagu;
    }
    public Song() {
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNameLagu() {
        return nameLagu;
    }
    public void setNameLagu(String nameLagu) {
        this.nameLagu = nameLagu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return Objects.equals(id, song.id) &&
                Objects.equals(nameLagu, song.nameLagu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameLagu);
    }
}
