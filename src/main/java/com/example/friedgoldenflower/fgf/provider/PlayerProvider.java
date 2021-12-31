package com.example.friedgoldenflower.fgf.provider;

import com.example.friedgoldenflower.fgf.entity.Card;
import com.example.friedgoldenflower.fgf.entity.Player;

import java.util.List;

/**
 * 发牌器
 *
 * @author Leon
 */
public interface PlayerProvider {

    // 产生单副牌
    Player getSinglePlayer();

    // 产生多副牌
    List<Player> getPlayers(int number);

    // 发一张牌
    Card getCard();

    // 洗牌
    void shuffle();
}
