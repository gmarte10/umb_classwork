package edu.umb.cs210.p3;

import stdlib.In;
import stdlib.StdOut;

import java.util.Arrays;
import java.util.Comparator;

// Implements binary search for clients that may want to know the index of 
// either the first or last key in a (sorted) collection of keys.
public class BinarySearchDeluxe {
    // The index of the first key in a[] that equals the search key, 
    // or -1 if no such key.
    public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> c) {
        if (a == null || key == null)
        {
            throw new NullPointerException();
        }

        Arrays.sort(a);

        int index = -1;
        int hi = a.length - 1;
        int mid = 0;
        int lo = 0;

        while (lo <= hi)
        {
            mid = lo + (hi - lo) / 2;

            if (c.compare(key, a[mid]) < 0)
            {
                hi = mid - 1;
            }
            else if (c.compare(key, a[mid]) > 0)
            {
                lo = mid + 1;
            }
            else
            {
                index = mid;
                hi = mid - 1;
            }
        }
        return index;
    }


    // The index of the last key in a[] that equals the search key, 
    // or -1 if no such key.
    public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> c) {
        if (a == null || key == null)
        {
            throw new NullPointerException();
        }

        Arrays.sort(a);
        int index = -1;
        int hi = a.length - 1;
        int mid = 0;
        int lo = 0;


        while (lo <= hi)
        {
            mid = lo + (hi - lo) / 2;

            if (c.compare(key, a[mid]) < 0)
            {
                hi = mid - 1;
            }
            else if (c.compare(key, a[mid]) > 0)
            {
                lo = mid + 1;
            }
            else
            {
                index = mid;
                lo = mid + 1;
            }
        }
        return index;
    }


    // Test client. [DO NOT EDIT]
    public static void main(String[] args) {
        String filename = args[0];
        String prefix = args[1];
        In in = new In(filename);
        int N = in.readInt();
        Term[] terms = new Term[N];
        for (int i = 0; i < N; i++) {
            long weight = in.readLong(); 
            in.readChar(); 
            String query = in.readLine(); 
            terms[i] = new Term(query.trim(), weight); 
        }
        Arrays.sort(terms);
        Term term = new Term(prefix);
        Comparator<Term> prefixOrder = Term.byPrefixOrder(prefix.length());
        int i = BinarySearchDeluxe.firstIndexOf(terms, term, prefixOrder);
        int j = BinarySearchDeluxe.lastIndexOf(terms, term, prefixOrder);
        int count = i == -1 && j == -1 ? 0 : j - i + 1;
        StdOut.println(count);
    }
}
