public class Card {
	private String suit;
	private int rank;

	public Card(String suit, int rank) {
		super();
		this.suit = suit;
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "[" + rank  + "," + suit + "]";
	}

	@Override
	public boolean equals(Object c2) {
		if (!(c2 instanceof Card)) {
			throw new RuntimeException("Illegal argument to Card.equals()");
		}
		Card card2 = (Card) c2;
		return ((this.getSuit().equals(card2.getSuit())) && 
				(this.getRank() == card2.getRank()));
	}

	public String getSuit() {
		return suit;
	}

	public int getRank() {
		return rank;
	}

	public boolean sameSuitAs(Card card2) {
		return (this.getSuit().equals(card2.getSuit()));
	}

	public boolean sameRankAs(Card card2) {
		return (this.getRank() == card2.getRank());
	}
	
	public boolean isASpade() {
		
		return (this.getSuit().equals("Spade"));
	}
	
	  public boolean hasHigherRank(Card c) {
	        return (this.getRank()>c.getRank());
	    }
	  
	  public static double averageRank(Card[] deck) {
		  double temp=0;
		  
		  for(int i=0;i<deck.length;i++){
			 temp += deck[i].getRank();
		  }
			
			return (temp/deck.length);
		}
	  
	  public static boolean hasNoAs(Card[] deck) {
		  
			for(int i=0;i<deck.length;i++){
				if(deck[i].getRank()==14){
					return false;
				}
			}
			return true; // Dummy return to avoid compiler error. Please replace as needed.
		}
	  
	  public static boolean consecutivePairExists(Card[] deck) {
		  
		  for(int i=1;i<deck.length;i++){
			  
				  if(deck[i].getRank()==deck[i-1].getRank()){
					  return true;
				  }  
		  }
	    	return false;
	    }
	  
	  public static boolean isSubDeck(Card[] deck1, Card[] deck2) {
		  int counter=0;
		  
		  if(deck1.length==0){
			  return true;
		  }
		  
		  if(deck1.length>deck2.length){
			  return false;
		  }
		  
		  for(int i=0;i<deck1.length;i++){
			  for(int j=0;j<deck2.length;j++){
				  if(deck1[i].sameSuitAs(deck2[j])){
					  if(deck1[i].sameRankAs(deck2[j])){
						  counter++;
					  }
				  }
			  }
			  
		  }
			
			return (counter >= Math.min(deck1.length, deck2.length));
		}
	  
	  public static boolean isRoyalFlush(Card[] deck) {
		  //Making sure deck is not empty
		  if(deck.length==0){
			  return false;
		  }
		  
		  //Making sure deck has at most 13 cards
		  if(deck.length>13){
			  return false;
		  }
		  
			// First Verify if all are the same suit
		  String tempsuit = deck[0].getSuit();
		  for(int i=1;i<deck.length;i++){
			  if(!(deck[i].getSuit().equals(tempsuit))){
				  return (false);
			  }
			  System.out.println("Verifing all are same suit");
		  }
		  
		//Make Sure No ranks are repeated
		  for(int i=0;i<deck.length;i++){
			  System.out.println("Making sure no ranks are repeated for1");
			  for(int j=0;j<deck.length;j++){
				  System.out.println("Making sure no ranks are repeated for2");
				  if(j==i){
				  System.out.println("If i==j");
				  }
				  else{System.out.println("Making sure no ranks are repeated ELSE");
					  if(deck[i].getRank()==deck[j].getRank()){
						  return false;
					  }
				  }
			  }
		  }
		  
		  //Find Max rank
		  int tempmax=deck[0].getRank();
		  for(int i=1;i<deck.length;i++){
			  System.out.println("Find Max FOR1");
			  if(deck[i].getRank()>tempmax){
				  System.out.println("Find max IF1");
				  tempmax = deck[i].getRank();
			  }
		  }
		  
		  int counter2=0;
		 
		  
//			  for(int j=0;j<deck.length;j++){
//				 System.out.println("DO FOR 1");
//				
//					  if(tempmax-1 == deck[j].getRank()){
//						  System.out.println("DO FOR IF1");
//						  tempmax--;
//						  counter2++;
//						  
//					  }
//				 
//			  }
		  
			  
			 // if(counter2==deck.length){
				  return true;
			 // }
			//  else{
			//	  return false;
			//  }
		}
}