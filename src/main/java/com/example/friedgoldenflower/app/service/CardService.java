package com.example.friedgoldenflower.app.service;

import com.example.friedgoldenflower.fgf.entity.Player;

import java.util.List;

public interface CardService {
    /**
     * 测试从一副牌里面发出count个玩家的牌-未带排序
     * @param count 玩家数量
     * @return
     */
    public List<Player> testLimitedPlayer(Integer count);
}
