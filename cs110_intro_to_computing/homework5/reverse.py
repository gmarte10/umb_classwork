import stdio
import sys


# Returns the reverse of the string s, computed recursively.
def reverse(s):
    if s == "":
        return ""
    return s[-1] + reverse(s[:-1])


# Test client [DO NOT EDIT]. Read a string s from command line and writes its
# reverse, computed recursively.
def _main():
    s = sys.argv[1]
    stdio.writeln(reverse(s))


if __name__ == '__main__':
    _main()
