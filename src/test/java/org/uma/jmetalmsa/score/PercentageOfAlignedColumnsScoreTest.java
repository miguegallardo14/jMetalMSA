package org.uma.jmetalmsa.score;

import mockit.Expectations;
import org.uma.jmetalmsa.score.impl.PercentageOfAlignedColumnsScore;
import org.junit.Before;
import org.junit.Test;
import org.uma.jmetalmsa.solution.MSASolution;
import mockit.Mocked;
import static org.junit.Assert.*;
/**
 * @author Miguel Angel Gallardo Ruiz <miguegallardo16@hotmail.com>
 *
 */
public class PercentageOfAlignedColumnsScoreTest {

    private static final double EPSILON = 0.00000000001;
    private PercentageOfAlignedColumnsScore objective;

    @Mocked
    MSASolution solution;

    @Before
    public void startup() {
        objective = new PercentageOfAlignedColumnsScore();
    }

    @Test
    public void returnOneColumnAligned() {
        new Expectations() {
            {
                char[][] decodedSequence = new char[][]{
                        {'-', 'R', 'C', 'A', 'D', '-'},
                        {'-', 'B', 'E', 'K', '-', '-'},
                        {'-', '-', 'L', 'A', '-', '-'},
                        {'-', 'T', 'C', 'I', 'G', '-'},
                        {'-', 'B', 'C', 'A', 'G', 'U'},
                };
                solution.decodeToMatrix();
                result = decodedSequence;
                times = 1;
            }
        };

        assertEquals(100.0 * 1.0 / 6.0, objective.compute(solution, solution.decodeToMatrix()), EPSILON); //Aqui comparamos si da 16.66667% de acierto, equivalente a 1 columna de 6
    }

    @Test
    public void returnTwoColumnAligned() {
        new Expectations() {
            {
                char[][] decodedSequence = new char[][]{
                        {'-', 'B', 'C', 'A', 'D', '-'},
                        {'-', 'B', 'E', 'A', '-', '-'},
                        {'-', '-', 'L', 'A', '-', '-'},
                        {'-', 'T', 'C', 'X', 'G', '-'},
                        {'-', 'B', 'C', 'A', 'G', '-'},
                };
                solution.decodeToMatrix();
                result = decodedSequence;
                times = 1;
            }
        };

        assertEquals(100.0 * 2.0 / 6.0, objective.compute(solution, solution.decodeToMatrix()), EPSILON);  //Aqui comparamos si da 33.33333% de acierto, equivalente a 2 columna de 6
    }


    @Test
    public void returnThreeColumnAligned() {
        new Expectations() {
            {
                char[][] decodedSequence = new char[][]{
                        {'-', 'B', 'C', 'A', 'D', '-'},
                        {'-', 'B', 'E', 'A', '-', '-'},
                        {'-', '-', 'L', 'A', '-', '-'},
                        {'-', 'T', 'C', 'A', 'G', '-'},
                        {'-', 'B', 'C', 'A', 'G', '-'},
                };
                solution.decodeToMatrix();
                result = decodedSequence;
                times = 1;
            }
        };

        assertEquals(100.0 * 3.0 / 6.0, objective.compute(solution, solution.decodeToMatrix()), EPSILON);  //Aqui comparamos si da 50% de acierto, equivalente a 3 columna de 6
    }

    @Test
    public void returnFourColumnAligned() {
        new Expectations() {
            {
                char[][] decodedSequence = new char[][]{
                        {'-', 'B', 'C', 'A', 'G', '-'},
                        {'-', 'B', 'E', 'A', 'G', '-'},
                        {'-', '-', 'L', 'A', 'G', '-'},
                        {'-', 'T', 'C', 'A', 'G', '-'},
                        {'-', 'B', 'C', 'A', 'G', '-'},
                };
                solution.decodeToMatrix();
                result = decodedSequence;
                times = 1;
            }
        };

        assertEquals(100.0 * 4.0 / 6.0, objective.compute(solution, solution.decodeToMatrix()), EPSILON);  //Aqui comparamos si da 66.666667% de acierto, equivalente a 4 columna de 6
    }

    @Test
    public void returnFiveColumnAligned() {
        new Expectations() {
            {
                char[][] decodedSequence = new char[][]{
                        {'-', 'B', 'C', 'A', 'G', '-'},
                        {'-', 'B', 'C', 'A', 'G', '-'},
                        {'-', '-', 'C', 'A', 'G', '-'},
                        {'-', 'T', 'C', 'A', 'G', '-'},
                        {'-', 'B', 'C', 'A', 'G', '-'},
                };
                solution.decodeToMatrix();
                result = decodedSequence;
                times = 1;
            }
        };

        assertEquals(100.0 * 5.0 / 6.0, objective.compute(solution, solution.decodeToMatrix()), EPSILON);  //Aqui comparamos si da 83.33333% de acierto, equivalente a 5 columna de 6
    }

    @Test
    public void returnAllColumnAligned() {
        new Expectations() {
            {
                char[][] decodedSequence = new char[][]{
                        {'-', 'B', 'C', 'A', 'G', '-'},
                        {'-', 'B', 'C', 'A', 'G', '-'},
                        {'-', 'B', 'C', 'A', 'G', '-'},
                        {'-', 'B', 'C', 'A', 'G', '-'},
                        {'-', 'B', 'C', 'A', 'G', '-'},
                };
                solution.decodeToMatrix();
                result = decodedSequence;
                times = 1;
            }
        };

        assertEquals(100.0 * 6.0 / 6.0, objective.compute(solution, solution.decodeToMatrix()), EPSILON);  //Aqui comparamos si da 100% de acierto, equivalente a 6 columna de 6
    }
}
