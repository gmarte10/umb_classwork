import stdio
import sys


# Reverse the one-dimensional list a in place, ie, without
# creating a new list.
def reverse(a):
    # Iterate over half of the list a.
    for i in range(len(a) // 2):
        # Exchange element at i in a with the element at
        # len(a) - i - 1.
        temp = a[i]
        a[i] = a[-i - 1]
        a[-i - 1] = temp


# Test client [DO NOT EDIT].
def _main():
    a = stdio.readAllStrings()
    reverse(a)
    for v in a[:-1]:
        stdio.writef('%s ', v)
    stdio.writeln(a[-1])


if __name__ == '__main__':
    _main()
