package dev.amerida.algoritms.leed_code.merge_two_sorted_lists;

import org.junit.jupiter.api.Test;

import static dev.amerida.algoritms.leed_code.merge_two_sorted_lists.MergeTwoSortedLists.ListNode;
import static org.junit.jupiter.api.Assertions.*;

class MergeTwoSortedListsTest {
    private final MergeTwoSortedLists merger = new MergeTwoSortedLists();

    private ListNode of(int... vals) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        for (int v : vals) {
            cur.next = new ListNode(v);
            cur = cur.next;
        }
        return dummy.next;
    }

    private int[] toArray(ListNode node) {
        int size = 0;
        ListNode cur = node;
        while (cur != null) { size++; cur = cur.next; }
        int[] result = new int[size];
        cur = node;
        for (int i = 0; i < size; i++) { result[i] = cur.val; cur = cur.next; }
        return result;
    }

    @Test
    void mergeTwoLists_typicalCase() {
        ListNode list1 = of(1, 2, 4);
        ListNode list2 = of(1, 3, 4);
        assertArrayEquals(new int[]{1, 1, 2, 3, 4, 4}, toArray(merger.mergeTwoLists(list1, list2)));
    }

    @Test
    void mergeTwoLists_bothEmpty() {
        assertNull(merger.mergeTwoLists(null, null));
    }

    @Test
    void mergeTwoLists_firstListEmpty() {
        ListNode list2 = of(1, 3, 5);
        assertArrayEquals(new int[]{1, 3, 5}, toArray(merger.mergeTwoLists(null, list2)));
    }

    @Test
    void mergeTwoLists_secondListEmpty() {
        ListNode list1 = of(2, 4, 6);
        assertArrayEquals(new int[]{2, 4, 6}, toArray(merger.mergeTwoLists(list1, null)));
    }

    @Test
    void mergeTwoLists_singleElementEach() {
        ListNode list1 = of(1);
        ListNode list2 = of(2);
        assertArrayEquals(new int[]{1, 2}, toArray(merger.mergeTwoLists(list1, list2)));
    }

    @Test
    void mergeTwoLists_singleElementEachReversed() {
        ListNode list1 = of(5);
        ListNode list2 = of(3);
        assertArrayEquals(new int[]{3, 5}, toArray(merger.mergeTwoLists(list1, list2)));
    }

    @Test
    void mergeTwoLists_duplicateValues() {
        ListNode list1 = of(2, 2, 2);
        ListNode list2 = of(2, 2);
        assertArrayEquals(new int[]{2, 2, 2, 2, 2}, toArray(merger.mergeTwoLists(list1, list2)));
    }

    @Test
    void mergeTwoLists_noOverlap_list1First() {
        ListNode list1 = of(1, 2, 3);
        ListNode list2 = of(4, 5, 6);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, toArray(merger.mergeTwoLists(list1, list2)));
    }

    @Test
    void mergeTwoLists_noOverlap_list2First() {
        ListNode list1 = of(4, 5, 6);
        ListNode list2 = of(1, 2, 3);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, toArray(merger.mergeTwoLists(list1, list2)));
    }
}