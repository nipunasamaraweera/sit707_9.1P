package web.service;

import org.junit.Assert;
import org.junit.Test;

public class TestMathQuestionService {

    @Test
    public void testTrueAdd() {
        Assert.assertEquals(3, MathQuestionService.q1Addition("1", "2"), 0);
    }

    @Test
    public void testAddNumber1Empty() {
        Assert.assertNull(MathQuestionService.q1Addition("", "2"));
    }

    @Test
    public void testAddNumber2Empty() {
        Assert.assertNull(MathQuestionService.q1Addition("2", ""));
    }

    @Test
    public void testAddBothNumbersEmpty() {
        Assert.assertNull(MathQuestionService.q1Addition("", ""));
    }

    @Test
    public void testAddNonNumericInput() {
        Assert.assertNull(MathQuestionService.q1Addition("abc", "def"));
    }

    @Test
    public void testAddNegativeNumbers() {
        Assert.assertEquals(-1, MathQuestionService.q1Addition("-1", "0"), 0);
    }

    @Test
    public void testSubtraction() {
        Assert.assertEquals(3, MathQuestionService.q2Subtraction("5", "2"), 0);
    }

    @Test
    public void testSubtractionWithNegativeResult() {
        Assert.assertEquals(-3, MathQuestionService.q2Subtraction("2", "5"), 0);
    }

    @Test
    public void testMultiplication() {
        Assert.assertEquals(6, MathQuestionService.q3Multiplication("2", "3"), 0);
    }

    @Test
    public void testMultiplicationWithZero() {
        Assert.assertEquals(0, MathQuestionService.q3Multiplication("2", "0"), 0);
    }

    @Test
    public void testMultiplicationWithNegativeNumbers() {
        Assert.assertEquals(-6, MathQuestionService.q3Multiplication("-2", "3"), 0);
    }
}


