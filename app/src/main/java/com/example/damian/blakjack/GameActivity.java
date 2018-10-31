package com.example.damian.blakjack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {
    private static final String value   =   "'s value: ";
    private Player player;
    private Player dealer;
    private Deck   deck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView name   =   (TextView) findViewById(R.id.user);

        Intent intent   =   getIntent();
        String message = intent.getStringExtra(Chekin.EXTRA_MESSAGE);

        name.setText(message);
        player   =   new Player(message);
        dealer   =   new Player("dealer");
        deck     =   new Deck();

        playGame();

    }



    public void hit(View view){
        TextView status   =   (TextView) findViewById(R.id.gameStatus);
        Button   hit      =   (Button) findViewById(R.id.hit);
        Button   stay     =   (Button) findViewById(R.id.stay);
        if(deck.getCount()<0){
            deck   =   new Deck();
        }
        player.addCard(deck.deal());
        displayGame(player.getName());
        if(player.evaluate() >21){
            evaluateGame();
        }else if(player.evaluate() ==21){
            status.setText("You got Black Jack!!!");
            player.increasePoint();
            hit.setClickable(false);
            stay.setClickable(false);
        }
    }

    public void stay(View view){
        Button hit   =   (Button) findViewById(R.id.hit);
        Button stay   =   (Button) findViewById(R.id.stay);
        finishDealerTurn();
        evaluateGame();
        hit.setClickable(false);
        stay.setClickable(false);
    }

    public void deal(View view){
        setContentView(R.layout.activity_game);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView name   =   (TextView) findViewById(R.id.user);

        Intent intent   =   getIntent();
        String message = intent.getStringExtra(Chekin.EXTRA_MESSAGE);

        name.setText(message);
      //  removeHand();
        player   =   new Player(message);
        dealer   =   new Player("dealer");
        if(deck.getCount()<5)
            deck   =   new Deck();
        playGame();

    }

    public void removeHand(){
        Hand current   =   player.getHand();
        while(current.isEmpty()) {
            current.remove();
        }
    }

    public void playGame(){
        TextView status   =   (TextView) findViewById(R.id.gameStatus);
        Button   hit      =   (Button) findViewById(R.id.hit);
        Button   stay     =   (Button) findViewById(R.id.stay);
        player.addCard(deck.deal());
        dealer.addCard(deck.deal());
        player.addCard(deck.deal());
        dealer.addCard(deck.deal());
        if(player.evaluate() ==21){
            status.setText("You got Black Jack!!!");
            player.increasePoint();
            hit.setClickable(false);
            stay.setClickable(false);
        }
        displayGame(player.getName());

    }
    public void displayPlayer(){
        int count   =   0;/*player.getHand().getCount();*/
        ArrayList<ImageView> cards   =   new ArrayList<>();
        cards.add((ImageView) findViewById(R.id.userCard1));
        cards.add((ImageView) findViewById(R.id.userCard2));
        cards.add((ImageView) findViewById(R.id.userCard3));
        cards.add((ImageView) findViewById(R.id.userCard4));
        cards.add((ImageView) findViewById(R.id.userCard5));
        cards.add((ImageView) findViewById(R.id.userCard6));
        cards.add((ImageView) findViewById(R.id.userCard7));
        cards.add((ImageView) findViewById(R.id.userCard8));
        cards.add((ImageView) findViewById(R.id.userCard9));
        cards.add((ImageView) findViewById(R.id.userCard10));
        cards.add((ImageView) findViewById(R.id.userCard11));
        cards.add((ImageView) findViewById(R.id.userCard12));

        Node current   =   player.getHand().getHand().getHeadNode().getNext();
        while(current != null) {
            String card   =   current.getData().getCardImage();
            int imageResource = getResources().getIdentifier(card, "drawable", getPackageName());
            cards.get(count).setImageResource(imageResource);
            current = current.getNext();
            count++;
        }

    }
    public void displayDealer(){
        int count   =   0;
        ArrayList<ImageView> cards   =   new ArrayList<>();
        cards.add((ImageView) findViewById(R.id.dealerCard1));
        cards.add((ImageView) findViewById(R.id.dealerCard2));
        cards.add((ImageView) findViewById(R.id.dealerCard3));
        cards.add((ImageView) findViewById(R.id.dealerCard4));
        cards.add((ImageView) findViewById(R.id.dealerCard5));
        cards.add((ImageView) findViewById(R.id.dealerCard6));
        cards.add((ImageView) findViewById(R.id.dealerCard7));
        cards.add((ImageView) findViewById(R.id.dealerCard8));
        cards.add((ImageView) findViewById(R.id.dealerCard9));
        cards.add((ImageView) findViewById(R.id.dealerCard10));
        cards.add((ImageView) findViewById(R.id.dealerCard11));

        Node current   =   dealer.getHand().getHand().getHeadNode().getNext().getNext();
        while(current != null) {
            String card   =   current.getData().getCardImage();
            int imageResource = getResources().getIdentifier(card, "drawable", getPackageName());
            cards.get(count).setImageResource(imageResource);
            current = current.getNext();
            count++;
        }
    }
    public void displayGame(String name){
        TextView userValue     =   (TextView) findViewById(R.id.userScore);
        userValue.setText(name);
        userValue.append(value);
        userValue.append(String.valueOf(player.evaluate()));
        displayDealer();
        displayPlayer();
    }

    public void evaluateGame(){
        int playerValue   =   player.evaluate();
        int dealerValue   =   dealer.evaluate();
        TextView dealerScore   =   (TextView)findViewById(R.id.dealerScore);
        TextView status        =   (TextView)findViewById(R.id.gameStatus);
        Button   hit           =   (Button)findViewById(R.id.hit);
        Button   stay          =   (Button)findViewById(R.id.stay);
        ImageView hiddenCard   =   (ImageView) findViewById(R.id.dealerHiddenCard);

        dealerScore.append(String.valueOf(dealerValue));

        Node current   =   dealer.getHand().getHand().getHeadNode().getNext();
        String card   =   current.getData().getCardImage();
        int imageResource = getResources().getIdentifier(card, "drawable", getPackageName());
        hiddenCard.setImageResource(imageResource);

        if((playerValue > dealerValue && playerValue <22)||dealerValue >21){
            player.increasePoint();
            status.setText("You Win!!!");
        }else if((dealerValue > playerValue && dealerValue < 22) || playerValue >21){
            dealer.increasePoint();
            status.setText("Dealer win!!");
        }else
            status.setText("Draw");
        hit.setClickable(false);
        stay.setClickable(false);
    }
    public void finishDealerTurn(){
        TextView status   =   (TextView) findViewById(R.id.gameStatus);
        Button   hit      =   (Button) findViewById(R.id.hit);
        Button   stay     =   (Button) findViewById(R.id.stay);
        ImageView hiddenCard   =   (ImageView) findViewById(R.id.dealerHiddenCard);
        int value   =   dealer.evaluate();
        Node current   =   dealer.getHand().getHand().getHeadNode().getNext();
        String card   =   current.getData().getCardImage();
        int imageResource = getResources().getIdentifier(card, "drawable", getPackageName());
        hiddenCard.setImageResource(imageResource);
        while(value<17){
            if(deck.getCount()<0)
                deck   =   new Deck();
            dealer.addCard(deck.deal());
            value   =   dealer.evaluate();
            displayDealer();
            if(value ==21){
                status.setText("Dealer got Black Jack!!!");
                dealer.increasePoint();
                hit.setClickable(false);
                stay.setClickable(false);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
