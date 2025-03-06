package kh.edu.react.provider.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Clothes {
    @JsonProperty
    private int cId;
    @JsonProperty
    private String Name;
    @JsonProperty
    private String Category;
    @JsonProperty
    private String Brand;
    @JsonProperty
    private String Color;
    @JsonProperty
    private String Size;
    @JsonProperty
    private String Material;
    @JsonProperty
    private int Price;
    @JsonProperty
    private int Stock;
    @JsonProperty
    private String Gender;
    @JsonProperty
    private String Season;
    @JsonProperty
    private String RegisterDate;

}
