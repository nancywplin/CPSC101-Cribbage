import java.util.Arrays;

public class Scorer
{
//    public static void main(String[] args)
//    {
//        int cardNum = 0, currentPeggingScore = 0, minVal = 14, maxVal = 0, runCount = 0, pegCardNum = 0;
//        Cards tempCard = null, tempCard2 = null;
//        Cards[] peggingArray = new Cards[];
//    }
//
    private int currentPeggingScore = 0;
    private int cardNum = 0;
    private int minVal = 14, maxVal = 0;
    private int runCount = 0, pegCardNum = 0;
    private Cards tempCard = null, tempCard2 = null;
    private Cards[] peggingArray = new Cards[];
    private Cards[] runArray = new Cards[];



    public int peggingScore(Cards c)//all possible combos for score (runs, pairs, 15), run each turn
    {
        peggingArray[pegCardNum] = c;
        currentPeggingScore += c.valueFinder();
        pegCardNum++;
        if(currentPeggingScore == 15)
        {
            return 2;
        }
        if (currentPeggingScore == 31)
        {
            return 2;
            currentPeggingScore = 0;
            //end subround
        }
        if(pegCardNum > 1){
            if(isPair(peggingArray[pegCardNum] , peggingArray[pegCardNum - 1]))
            {
               return 2;
            }
        }
        if(pegCardNum > 4){
            if(peggingArray[pegCardNum].getSuit() == peggingArray[pegCardNum - 1].getSuit() && peggingArray[pegCardNum].getSuit() == peggingArray[pegCardNum - 2].getSuit() && peggingArray[pegCardNum].getSuit() == peggingArray[pegCardNum - 3].getSuit() && peggingArray[pegCardNum].getSuit() == peggingArray[pegCardNum - 4].getSuit())
            {
                return 5;
            }
        }
        if(pegCardNum > 2)
        {

        }
    }

    public void resetPeggingScore()
    {
        currentPeggingScore = 0;
    }

    private int is15(Cards[] playedHand, Cards cutCard)//could take all in at once, could have 4 methods for pair, triple etc.
    {

        int num15 = 0;//number of instances of 15's
        /** card[] cardArray = new card[]{card1, card2, card3, card4, cutCard}; old code, might revert back to if issues
         cardArray[0] = card1;
         cardArray[1] = card2;
         cardArray[2] = card3;
         cardArray[3] = card4;
         cardArray[4] = cutCard; */
        int k, j, i, totalVal;
        for(j=0;j<5;j++)
        {
            for(i=0;(i+j)<6;i++)
            {
                totalVal = playedHand[j].cardValue() + playedHand[i+j].cardValue();
                if (totalVal == 15)
                {
                    num15++;
                }
            }
        }
        for(k=0;k<4;k++)
        {
            for(j=0;(k+j)<5;j++)
            {
                for(i=0;(i+j+k)<6;i++)
                {
                    totalVal= playedHand[k].cardValue() + playedHand[k+j].cardValue() + playedHand[k + j + i].cardValue();
                    if (totalVal == 15)
                    {
                        num15++;
                    }

                }
            }
        }
        for(int l=0;l<3;l++)
        {
            for(k=0;k<4;k++)
            {
                for(j=0;(k+j)<5;j++)
                {
                    for(i=0;(i+j+k)<6;i++)
                    {
                        totalVal= playedHand[l].cardValue() + playedHand[l+k].cardValue() + playedHand[l + k + j].cardValue() + playedHand[l+k+j+i].cardValue();
                        if (totalVal == 15)
                        {
                            num15++;
                        }
                    }
                }
            }
        }
        totalVal= playedHand[0].cardValue() + playedHand[1].cardValue() + playedHand[2].cardValue() + playedHand[3].cardValue() + playedHand[4].cardValue();
        if (totalVal == 15)
        {
            num15++;
        }
        return num15;
    }
    private boolean isPair(Cards card1, Cards card2)
    {
        if (card1.valueFinder() == card2.valueFinder())
        {
            return true;
        }
        else return false;
    }
    private boolean isThreeKind(Cards card1, Cards card2, Cards card3)
    {
        if (card1.valueFinder() == card2.valueFinder() && card1.valueFinder() == card3.valueFinder())
        {
            return true;
        }
        else return false;
    }
    private boolean isFourkind(Cards card1,Cards card2,Cards card3,Cards card4)//can get rid of
    {
        if (card1.valueFinder() == card2.valueFinder() && card1.valueFinder() == card3.valueFinder() && card1.valueFinder() == card4.valueFinder())
        {
            return true;
        }
        else return false;
    }
    public boolean isFourKind(Cards[] playedHand, Cards cutCard)// change cards 1-4 into Hand arraylist
    {
        if(playedHand[0].getSuit() == playedHand[1].getSuit() && playedHand[0].getSuit() == playedHand[2].getSuit() && playedHand[0].getSuit() == playedHand[3].getSuit() && playedHand[0].getSuit() == cutCard.getSuit())
        {
            return true;
        }
        else return false;
    }
    public boolean isFlush(Cards[] playedHand)// change cards 1-4 into Hand arraylist
    {
        if(playedHand[0].getSuit() == playedHand[1].getSuit() && playedHand[2].getSuit() == playedHand[3].getSuit() && card1.s == card4.s )
        {
            return true;
        }
        else return false;
    }
    public int countHand(Cards[] playedHand, Cards cutCard, boolean isCrib)//reverse order, countCrib is exact same method but different card 1-4
    {
        int handScore = 0;
        //is15
        //isrun
        if(isFourKind(playedHand[0], playedHand[1], playedHand[2], playedHand[3])){return 16;}
        else{
            if(isFourKind(playedHand[0], playedHand[1], playedHand[2], cutCard)){return 16;}
            else{
                if(isFourKind(playedHand[0], playedHand[1], playedHand[3], cutCard)){return 16;}
                else{
                    if(isFourKind(playedHand[0], playedHand[2], playedHand[3], cutCard)){return 16;}
                    else{
                        if(isFourKind(playedHand[1], playedHand[2], playedHand[3], cutCard)){return 16;}
                        else{

                            if(isThreeKind(playedHand[0], playedHand[1], playedHand[2])){return 6;}
                            else{
                                if(isThreeKind(playedHand[0], playedHand[1], playedHand[3])){return 6;}
                                else{
                                    if(isThreeKind(playedHand[0], playedHand[1], cutCard)){return 6;}
                                    else{
                                        if(isThreeKind(playedHand[0], playedHand[2], playedHand[3])){return 6;}
                                        else{
                                            if(isThreeKind(playedHand[0], playedHand[2], cutCard)){return 6;}
                                            else{
                                                if(isThreeKind(playedHand[0], playedHand[3], cutCard)){return 6;}
                                                else{
                                                    if(isThreeKind(playedHand[1], playedHand[2], playedHand[3])){return 6;}
                                                    else{
                                                        if(isThreeKind(playedHand[1], playedHand[2], cutCard)){return 6;}
                                                        else{
                                                            if(isThreeKind(playedHand[1], playedHand[3], cutCard)){return 6;}
                                                            else{
                                                                if(isThreeKind(playedHand[2], playedHand[3], cutCard)){return 6;}
                                                                else{

                                                                    if(isPair(playedHand[0], playedHand[1])){return 2;}
                                                                    else{
                                                                        if(isPair(playedHand[0], playedHand[2])){return 2;}
                                                                        else{
                                                                            if(isPair(playedHand[0], playedHand[3])){return 2;}
                                                                            else{
                                                                                if(isPair(playedHand[0], cutCard)){return 2;}
                                                                                else{
                                                                                    if(isPair(playedHand[1], playedHand[2])){return 2;}
                                                                                    else{
                                                                                        if(isPair(playedHand[1], playedHand[3])){return 2;}
                                                                                        else{
                                                                                            if(isPair(playedHand[1], cutCard)){return 2;}
                                                                                            else{
                                                                                                if(isPair(playedHand[2], playedHand[3])){return 2;}
                                                                                                else{
                                                                                                    if(isPair(playedHand[2], cutCard)){return 2;}
                                                                                                    else{
                                                                                                        if(isPair(playedHand[3], cutCard)){return 2;}

                                                                                                    }}}}}}}}}}}}}}}}}}}}}}}}

        if(isCrib)
        {
            if(isCribFlush(playedHand[], cutCard)){return 5;}
        }
        else
        {
            if(isFlush(playedHand[], cutCard)){return  4;}
        }

        is15(playedHand[], cutCard);
    }

    public int cutCardScore(Cards cutCard, Cards[] cardArray)//Checks for nibs, jack points
    {
        if (cutCard.valueFinder() == 11)
        {
            return 2;
        }

        for(int i = 0; i < 4; i++)
        {
            if (cardArray[i].valueFinder() == 11 && cardArray[i].getSuit() == cutCard.getSuit())
            {
                return 1;
            }
        }
    }


    private int isRunPeg(Cards[] runArray)
    {
        runCount = runArray.length;
        Cards[]sortedRunArray = new Cards[runArray.length];

        if(runCount > 2)
        {
            for(int i=0;i<runCount;i++)
            {
                sortedRunArray[i] = runArray[runCount - i];//sorts right to left to the needed length
            }

            sortedRunArray = sortArray(sortedRunArray);
            if(runCount > 6)
            {
                if(runArray[runCount].valueFinder() == 7 && runArray[runCount - 1].valueFinder() == 6 && runArray[runCount - 2].valueFinder() == 5 && runArray[runCount - 3].valueFinder() == 4 & runArray[runCount - 4].valueFinder() == 3 && runArray[runCount - 5].valueFinder() == 2 && runArray[runCount - 6].valueFinder() == 1)
                {
                    return 7;
                }
            }

            if(runCount > 5){
                if((runArray[runCount].valueFinder() - runArray[runCount - 3].valueFinder())== (runArray[runCount - 1].valueFinder() - runArray[runCount - 4].valueFinder()) && (runArray[runCount].valueFinder() - runArray[runCount - 3].valueFinder()) == (runArray[runCount - 2].valueFinder() - runArray[runCount - 5].valueFinder()))
                {
                    return 6;
                }}

            if(runCount > 4){
                if((runArray[4].valueFinder() - runArray[3].valueFinder())== 1 && (runArray[3].valueFinder() - runArray[2].valueFinder())== 1 && (runArray[2].valueFinder() - runArray[1].valueFinder())== 1 && (runArray[1].valueFinder() - runArray[0].valueFinder())== 1)
                {
                    return 5;
                }}
            if(runCount > 3){
                if((runArray[runCount].valueFinder() - runArray[runCount - 2].valueFinder())== (runArray[runCount - 1].valueFinder() - runArray[runCount - 3].valueFinder()))
                {
                    return 4;
                }}
            if((runArray[runCount].valueFinder() - runArray[runCount-1].valueFinder())== 1 && (runArray[runCount-1].valueFinder() - runArray[runCount-2].valueFinder())== 1)
            {
                return 3;
            }
        }
        return 0;
    }


    //ONLY WORKS FOR RUNS OF 5 AND 4 SO FAR
    public int isRun(Cards[] a)
    {

        int i, j, k, runScore = 0;
        int[][] runArray = new int[13][2];

        for(i=0;i<13;i++)
        {
            runArray[i][0] = i;
            for(j=0;j<4;j++)
            {
                if(playedHand[j].value == (i+1))
                {
                    runArray[i][1]++;
                    k++;
                }
            }

            if(cutCard.v == i)
            {
                runArray[i][1]++;
                k++;
            }
            if(k == 5)
            {
                break;
            }
            if(runArray[i][1] != 0 && runArray[i-1][1] != 0 && runArray[i-2][1] != 0)
            {
                runScore = 3 * runArray[i][1] * runArray[i-1][1] * runArray[i-2][1];
            }
            if(runArray[i][1] != 0 && runArray[i-1][1] != 0 && runArray[i-2][1] != 0 && runArray[i-3][1] != 0)
            {
                runScore = 4 * runArray[i][1] * runArray[i-1][1] * runArray[i-2][1] * runArray[i-3][1];
            }
            if(runArray[i][1] != 0 && runArray[i-1][1] != 0 && runArray[i-2][1] != 0 && runArray[i-3][1] != 0 && runArray[i-4][1] != 0)
            {
                return 5;
            }
        }
        return runScore;
    }


    private Cards[] sortArray(Cards[] a) {
        int i, j;
        for ( i = 0; i < a.length; i++)
        {
            for (j = i; j > 0; j--)
            {
                if (a[j].valueFinder() < a[(j - 1)].valueFinder())
                {
                    tempCard = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = tempCard;
                }
            }
        }
        tempCard = null;
        return a;

    }
}