package application;

import javafx.beans.property.IntegerProperty;

public interface ICharSelectModel {
     int getRounds() ;

    void setRounds(int rounds);
    
    IntegerProperty getRoundsPty();
    
    Battle getBattle();
}
