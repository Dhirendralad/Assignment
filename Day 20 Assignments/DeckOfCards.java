import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

class Card {
    private String rank;
    private String suit;

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public String getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}

class Player {
    private String name;
    private Queue<Card> deck;

    public Player(String name) {
        this.name = name;
        this.deck = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public Queue<Card> getDeck() {
        return deck;
    }
}

class DeckOfCards {
    private static final String[] SUITS = {"Clubs", "Diamonds", "Hearts", "Spades"};
    private static final String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    private static final int NUM_PLAYERS = 4;
    private static final int CARDS_PER_PLAYER = 9;

    public static void main(String[] args) {
        String[][] deck = generateDeck();
        shuffleDeck(deck);
        Queue<Player> playerQueue = createPlayers();
        distributeCards(deck, playerQueue);
        printPlayerCards(playerQueue);
    }

    private static String[][] generateDeck() {
        String[][] deck = new String[SUITS.length * RANKS.length][2];
        int index = 0;

        for (String suit : SUITS) {
            for (String rank : RANKS) {
                deck[index][0] = rank;
                deck[index][1] = suit;
                index++;
            }
        }

        return deck;
    }

    private static void shuffleDeck(String[][] deck) {
        Random random = new Random();

        for (int i = deck.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);

            String[] temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }
    }

    private static Queue<Player> createPlayers() {
        Queue<Player> playerQueue = new LinkedList<>();

        for (int i = 1; i <= NUM_PLAYERS; i++) {
            Player player = new Player("Player " + i);
            playerQueue.add(player);
        }

        return playerQueue;
    }

    private static void distributeCards(String[][] deck, Queue<Player> playerQueue) {
        int cardIndex = 0;
        for (int i = 0; i < CARDS_PER_PLAYER; i++) {
            for (Player player : playerQueue) {
                String rank = deck[cardIndex][0];
                String suit = deck[cardIndex][1];
                Card card = new Card(rank, suit);
                player.getDeck().add(card);
                cardIndex++;
            }
        }
    }

    private static void printPlayerCards(Queue<Player> playerQueue) {
        for (Player player : playerQueue) {
            System.out.println(player.getName() + " Cards:");
            Card[] cards = player.getDeck().toArray(new Card[0]);
            Arrays.sort(cards, Comparator.comparing(Card::getRank));
            for (Card card : cards) {
                System.out.println(card);
            }
            System.out.println();
        }
    }
}
