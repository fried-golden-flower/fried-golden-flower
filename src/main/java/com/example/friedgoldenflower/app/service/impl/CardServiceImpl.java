package com.example.friedgoldenflower.app.service.impl;

import com.example.friedgoldenflower.app.service.CardService;
import com.example.friedgoldenflower.fgf.calculator.PlayerType;
import com.example.friedgoldenflower.fgf.calculator.impl.FlowerValueCalculator;
import com.example.friedgoldenflower.fgf.compare.PlayerComparator;
import com.example.friedgoldenflower.fgf.entity.Card;
import com.example.friedgoldenflower.fgf.entity.Player;
import com.example.friedgoldenflower.fgf.provider.PlayerProvider;
import com.example.friedgoldenflower.fgf.provider.impl.LimitedPlayerProvider;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    public List<Player> testLimitedPlayer(Integer count) {
        // 使用有人数限制的发牌器
        PlayerProvider playerProvider = new LimitedPlayerProvider();
        // 使用花色参与大小比较的计算器
        PlayerComparator juger = new PlayerComparator(new FlowerValueCalculator());
        List<Player> players = playerProvider.getPlayers(count);
        // 使用发牌器发出的牌，每副牌已经自动按大到小排好序，调用sortRegularPlayers()方法
        juger.sortRegularPlayers(players);
//        Collections.sort(players, juger);
        printPlayers(players);
        return players;
    }

    // ========================以下代码全是打印输出====================================

    private static void printPlayers(List<Player> players) {
        for (int i = 0; i < players.size(); i++) {
            System.out.print("玩家_" + i + "_的牌：");
            printPlayerCards(players.get(i));
            printTypeValue(players.get(i));
            System.out.println();
        }
    }

    private static void printPlayerCards(Player player) {
        for (int j = 0; j < 3; j++) {
            printCard(player.cards[j]);
        }
    }

    private static void printCard(Card card) {
        int flower = card.getFlower();
        int number = card.getNumber();
        switch (flower) {
            case Card.FLOWER_SPADE:
                System.out.print("黑桃" + getCardStringNumber(number));
                break;
            case Card.FLOWER_HEART:
                System.out.print("红桃" + getCardStringNumber(number));
                break;
            case Card.FLOWER_CLUB:
                System.out.print("梅花" + getCardStringNumber(number));
                break;
            default:
                System.out.print("方片" + getCardStringNumber(number));
                break;
        }
        System.out.print(", ");
    }

    private static String getCardStringNumber(int number) {
        if (number <= 10) {
            return "" + number;
        } else if (number == 11) {
            return "J";
        } else if (number == 12) {
            return "Q";
        } else if (number == 13) {
            return "K";
        } else {
            return "A";
        }

    }

    private static void printTypeValue(Player player) {
        int type = player.getType();
        int value = player.getValue();
        switch (type) {
            case PlayerType.BOMB:
                System.out.print("炸弹,  牌值:" + value);
                break;
            case PlayerType.STRAIGHT_FLUSH:
                System.out.print("同花顺,  牌值:" + value);
                break;
            case PlayerType.FLUSH:
                System.out.print("同花，  牌值:" + value);
                break;
            case PlayerType.STRAIGHT:
                System.out.print("顺子,  牌值:" + value);
                break;
            case PlayerType.DOUBLE:
                System.out.print("对子,  牌值:" + value);
                break;
            default:
                if (player.isSpecial()) {
                    System.out.print("特殊牌,  牌值:" + value);
                } else {
                    System.out.print("普通牌,  牌值:" + value);
                }
                break;
        }
    }
}
