package com.example.consensus;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class SchulzeUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void WhenWikiDataIsGiven_ThenRankingIsCorrect() throws Exception {
        ArrayList<String> candidateList = new ArrayList<String>();
        candidateList.add("A");
        candidateList.add("B");
        candidateList.add("C");
        candidateList.add("D");
        candidateList.add("E");

        Schulze schulze = new Schulze(candidateList);

        for (int i = 0; i < 5; i++)
        {
            Map<String, Integer> tempBallot = new HashMap<String, Integer>();
            tempBallot.put("A", 1);
            tempBallot.put("C", 2);
            tempBallot.put("B", 3);
            tempBallot.put("E", 4);
            tempBallot.put("D", 5);
            schulze.AddBallot(tempBallot);
        }

        for (int i = 0; i < 5; i++)
        {
            Map<String, Integer> tempBallot = new HashMap<String, Integer>();
            tempBallot.put("A", 1);
            tempBallot.put("D", 2);
            tempBallot.put("E", 3);
            tempBallot.put("C", 4);
            tempBallot.put("B", 5);
            schulze.AddBallot(tempBallot);
        }

        for (int i = 0; i < 8; i++)
        {
            Map<String, Integer> tempBallot = new HashMap<String, Integer>();
            tempBallot.put("B", 1);
            tempBallot.put("E", 2);
            tempBallot.put("D", 3);
            tempBallot.put("A", 4);
            tempBallot.put("C", 5);
            schulze.AddBallot(tempBallot);
        }

        for (int i = 0; i < 3; i++)
        {
            Map<String, Integer> tempBallot = new HashMap<String, Integer>();
            tempBallot.put("C", 1);
            tempBallot.put("A", 2);
            tempBallot.put("B", 3);
            tempBallot.put("E", 4);
            tempBallot.put("D", 5);
            schulze.AddBallot(tempBallot);
        }

        for (int i = 0; i < 7; i++)
        {
            Map<String, Integer> tempBallot = new HashMap<String, Integer>();
            tempBallot.put("C", 1);
            tempBallot.put("A", 2);
            tempBallot.put("E", 3);
            tempBallot.put("B", 4);
            tempBallot.put("D", 5);
            schulze.AddBallot(tempBallot);
        }

        for (int i = 0; i < 2; i++)
        {
            Map<String, Integer> tempBallot = new HashMap<String, Integer>();
            tempBallot.put("C", 1);
            tempBallot.put("B", 2);
            tempBallot.put("A", 3);
            tempBallot.put("D", 4);
            tempBallot.put("E", 5);
            schulze.AddBallot(tempBallot);
        }

        for (int i = 0; i < 7; i++)
        {
            Map<String, Integer> tempBallot = new HashMap<String, Integer>();
            tempBallot.put("D", 1);
            tempBallot.put("C", 2);
            tempBallot.put("E", 3);
            tempBallot.put("B", 4);
            tempBallot.put("A", 5);
            schulze.AddBallot(tempBallot);
        }

        for (int i = 0; i < 8; i++) {
            Map<String, Integer> tempBallot = new HashMap<String, Integer>();
            tempBallot.put("E", 1);
            tempBallot.put("B", 2);
            tempBallot.put("A", 3);
            tempBallot.put("D", 4);
            tempBallot.put("C", 5);
            schulze.AddBallot(tempBallot);
        }

        ArrayList<String> ranking = schulze.getRanking();
        ArrayList<String> expectedRanking = new ArrayList<String> (Arrays.asList("E", "A", "C", "B", "D"));

        for (int i = 0; i < ranking.size(); i++)
        {
            assertArrayEquals(expectedRanking.toArray(), ranking.toArray());
        }
    }

}