package com.example.consensus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

/**
 * Created by brand on 2/20/2017.
 */
public class Schulze {
    private ArrayList<String> mCandidates = null;
    private int[][] mPairwisePreferences = null;
    private int[][] mStrongestPaths = null;

    public Schulze(ArrayList<String> candidates)
    {
        mPairwisePreferences = new int[candidates.size()][candidates.size()];
        Collections.sort(candidates);
        mCandidates = candidates;
    }

    public void AddBallot(Map<String, Integer> ballot)
    {
        for (String candidateX : mCandidates)
        {
            for (String candidateY : mCandidates)
            {
                // Less Than means more preferred (1 is most preferred)
                if (ballot.get(candidateX) < ballot.get(candidateY))
                {
                    mPairwisePreferences[mCandidates.indexOf(candidateX)][mCandidates.indexOf(candidateY)]++;
                }
            }
        }
    }

    public ArrayList<String> getRanking()
    {
        mStrongestPaths = new int[mCandidates.size()][mCandidates.size()];

        for (int i = 0; i < mCandidates.size(); i++)
        {
            for (int j = 0; j < mCandidates.size(); j++)
            {
                if (i != j)
                {
                    if (mPairwisePreferences[i][j] > mPairwisePreferences[j][i])
                    {
                        mStrongestPaths[i][j] = mPairwisePreferences[i][j];
                    }
                    else
                    {
                        mStrongestPaths[i][j] = 0;
                    }
                }
            }
        }

        for (int i = 0; i < mCandidates.size(); i++)
        {
            for (int j = 0; j < mCandidates.size(); j++)
            {
                if (i != j)
                {
                    for (int k = 0; k < mCandidates.size(); k++)
                    {
                        if ((i != k) && (j != k))
                        {
                            mStrongestPaths[j][k] = Math.max(mStrongestPaths[j][k], Math.min(mStrongestPaths[j][i], mStrongestPaths[i][k]));
                        }
                    }
                }
            }
        }

        ArrayList<String> ranking = new ArrayList<String>(mCandidates);

        Collections.sort(ranking, new Comparator<String>() {
            @Override
            public int compare(String candidateX, String candidateY) {
                return mStrongestPaths[mCandidates.indexOf(candidateY)][mCandidates.indexOf(candidateX)] - mStrongestPaths[mCandidates.indexOf(candidateX)][mCandidates.indexOf(candidateY)];
            }
        });
        return ranking;
    }
}
