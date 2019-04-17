package uk.ac.york.sepr4.ahod2.obstacle;

import lombok.Getter;
/***
 * NEW
 * Card used to represent instance of obstacles.
 * Contains data used to populate ObstacleScreen.
 */
@Getter
public class Obstacle {

    private Integer id;
    private String name, text;
    private Double chance;
    private String background = "default.png";
    private Integer health;
    private Double escapeChance;
    private Boolean removeCrew;


    public Obstacle(){
        //json
    }
}
