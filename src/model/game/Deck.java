package model.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

import org.w3c.dom.events.EventException;

import model.card.Card;
import model.player.Player;



public abstract class Deck {
    
    private ArrayList<Card> discard;
    private Stack<Card>     deck;
    
    
    public Deck() {
        discard = new ArrayList<>();
        deck = new Stack<>();
        
        initDeck();
        Collections.shuffle(deck);
    }
    
    
    public abstract void initDeck();
    
    
    /**
     * Function for the maintenance of deck
     * 
     * @author nihil
     *
     */
    private void deckGestion() throws EventException {
        if (deck.isEmpty()) {
            // TODO: send message to controller
            deck.addAll(discard);
        } // end if
        if (deck.isEmpty() && discard.isEmpty()) {
            throw new EventException((short) 0, "Not enough card in both discard and deck");
        } // end if
    }// end deckGestion
    
    
    public Card draw(Player p) {
        Card c = deck.pop();
        deckGestion();
        return c;
    }// end draw
    
    
    /**
     * put the card to the discard
     * 
     * @param card
     */
    public void discard(Card card) {
        discard.add(card);
    }
    
    
    protected void addCardToDeck(Card card) {
        deck.push(card);
    }// end addCardsToDeck
    
}