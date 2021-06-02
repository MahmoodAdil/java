package com.cards;

public class AlphabetCards {

	public static String cardName[] ={"one","two","three","four","five","six","seven","eight","nine","ten","eleven","twelve","thirteen"};

	public static void main(String args[]){
		SortCards sortCards = new SortCards();

		String sortedCard [] = sortCards.cardSorter(cardName);

		System.out.println("Result----------------------------------------");
		for (int i = 0; i < sortedCard.length; i++) {
			System.out.print("[ "+sortedCard[i]+" ]");
		}
		System.out.println("");

	}


}