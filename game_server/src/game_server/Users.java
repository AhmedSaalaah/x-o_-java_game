/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game_server;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author M Gamal
 */
public class Users{
    private SimpleIntegerProperty score;
    private SimpleStringProperty userName;
    
    public Users(Integer _score, String _userName)
    {
        this.score = new SimpleIntegerProperty(_score);
        this.userName = new SimpleStringProperty(_userName);
    }
    public int getScore() {
        return score.get();
    }

    public void setScore(int _score) {
        this.score = new SimpleIntegerProperty(_score);
    }
    public String getUserName() {
        return userName.get();
    }

    public void setFirstName(String _userName) {
        this.userName = new SimpleStringProperty(_userName);
    }
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
