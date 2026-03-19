package dev.amerida.algoritms.leed_code.best_time_to_buy_and_sell;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxProfitTest {
    private final MaxProfit maxProfit = new MaxProfit();

    @Test
    void getMaxProfit_typicalCase() {
        assertEquals(5, maxProfit.getMaxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    @Test
    void getMaxProfit_descendingPrices_returnsZero() {
        assertEquals(0, maxProfit.getMaxProfit(new int[]{7, 6, 4, 3, 1}));
    }

    @Test
    void getMaxProfit_singleElement_returnsZero() {
        assertEquals(0, maxProfit.getMaxProfit(new int[]{5}));
    }

    @Test
    void getMaxProfit_twoElements_profit() {
        assertEquals(3, maxProfit.getMaxProfit(new int[]{2, 5}));
    }

    @Test
    void getMaxProfit_twoElements_noProfit() {
        assertEquals(0, maxProfit.getMaxProfit(new int[]{5, 2}));
    }

    @Test
    void getMaxProfit_allSamePrices_returnsZero() {
        assertEquals(0, maxProfit.getMaxProfit(new int[]{3, 3, 3, 3}));
    }

    @Test
    void getMaxProfit_minAtEnd_returnsZero() {
        assertEquals(0, maxProfit.getMaxProfit(new int[]{5, 4, 3, 2, 1}));
    }

    @Test
    void getMaxProfit_maxAtEnd() {
        assertEquals(8, maxProfit.getMaxProfit(new int[]{1, 2, 3, 4, 5, 6, 7, 9}));
    }

    @Test
    void getMaxProfit_buyLowSellHigh_notFirstAndLast() {
        // Best: buy at 1 (index 2), sell at 6 (index 4)
        assertEquals(5, maxProfit.getMaxProfit(new int[]{7, 2, 1, 6, 3, 4}));
    }

    @Test
    void getMaxProfit_nullArray_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> maxProfit.getMaxProfit(null));
    }

    @Test
    void getMaxProfit_emptyArray_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> maxProfit.getMaxProfit(new int[]{}));
    }
}