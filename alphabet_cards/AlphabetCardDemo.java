package a;

public class AlphabetCardDemo {
    public static int currentFlag = -1 , previousFlag = 0;
    public static String cardName[] ={"one","two","three","four","five","six","seven","eight"};

    private static int number_of_card= cardName.length;
    public static String sortedCard []= new String[number_of_card];
    public static void main(String args[]){

        boolean modApplied = false;

        for (int i = 0; i < cardName.length; i++) {

            int cardNameLength = cardName[i].length();
            if (currentFlag < 0) { //just for beginning
                currentFlag = cardNameLength    ;
            }

            for (int j = currentFlag; j < number_of_card; ){
                if (modApplied){
                    //call for update currentFlag
                    updateFlag(cardNameLength);
                }
                if(sortedCard [currentFlag] == null){
                    sortedCard [currentFlag] = cardName[i];
                    //swap flag value
                    previousFlag = currentFlag;
                    System.out.println("Done cardName: "+cardName[i] +" at position "+ currentFlag);
                    if ( i == cardName.length-1) break; //
                    currentFlag = (currentFlag + (cardName[i+1].length() + 1));
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

        System.out.println("Result----------------------------------------");
        for (int i = 0; i < sortedCard.length; i++) {
            System.out.print("[ "+sortedCard[i]+" ]");
        }
        System.out.println("");

    }

    private static void updateFlag(int cardNameLength) {
        int indexPointer = (previousFlag + 1) % number_of_card;
        int countEmpty = 0;
        while((cardNameLength + 1) != countEmpty){
            if(sortedCard[indexPointer] == null) {
                countEmpty++;
            }
            indexPointer = (indexPointer +1 )%number_of_card;
        }
        if (indexPointer == 0) currentFlag = sortedCard.length - 1;  //base case where pointer at zero so set at end of array instead return -1
        else {
            currentFlag = indexPointer - 1;
        }
    }
}
