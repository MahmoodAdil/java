package com.cards;

public class SortCards {
	private static int currentFlag = -1 , previousFlag = 0;
	private static int number_of_card;
	private static String sortedCard [];


	public String[] cardSorter(String[] inputCardsList){
		number_of_card = inputCardsList.length;
		sortedCard = new String[number_of_card];

		boolean modApplied = false;

		for (int i = 0; i < inputCardsList.length; i++) {

			int inputCardsListLength = inputCardsList[i].length();
			if (currentFlag < 0) { //just for beginning
				currentFlag = inputCardsListLength    ;
			}

			for (int j = currentFlag; j < number_of_card; ){
				if (modApplied){
					//call for update currentFlag
					updateFlag(inputCardsListLength);
				}
				if(sortedCard [currentFlag] == null){
					sortedCard [currentFlag] = inputCardsList[i];
					//swap flag value
					previousFlag = currentFlag;
					System.out.println("Done inputCardsList: "+inputCardsList[i] +" at position "+ currentFlag);
					if ( i == inputCardsList.length-1) break; //
					currentFlag = (currentFlag + (inputCardsList[i+1].length() + 1));
					if(currentFlag >= number_of_card){
						modApplied = true;
						currentFlag = currentFlag % number_of_card;
						System.out.println("mod hit");
					}
					break;
				}
				j++;
			}
		}
		return sortedCard;
	}
	
	private static void updateFlag(int cardNameLength) {
		int indexPointer = (previousFlag + 1) % number_of_card;
		int countEmpty = 0;
		while((cardNameLength + 1) != countEmpty){
			if(sortedCard[indexPointer] == null) {
				countEmpty++;
			}
			indexPointer = (indexPointer +1 ) % number_of_card;
		}
		if (indexPointer == 0) currentFlag = sortedCard.length - 1;  //base case where pointer at zero so set at end of array instead return -1
		else {
			currentFlag = indexPointer - 1;
		}
	}
}
