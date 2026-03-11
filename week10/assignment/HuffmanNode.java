package week10.assignment;

import java.io.Serializable;

public class HuffmanNode implements Comparable<HuffmanNode>, Serializable
{
    private char ch;
    private int freq;
    private HuffmanNode left, right;

    public HuffmanNode(char ch, int freq)
    {
        this.ch = ch;
        this.freq = freq;
    }

    public HuffmanNode(int freq, HuffmanNode left, HuffmanNode right)
    {
        this.ch = '\0';
        this.freq = freq;
        this.left = left;
        this.right = right;
    }

    public char getChar() { return ch; }
    public int getFreq() { return freq; }
    public HuffmanNode getLeft() { return left; }
    public HuffmanNode getRight() { return right; }

    public boolean isLeaf() { return left == null && right == null; }

    @Override
    public int compareTo(HuffmanNode o)
    {
        return this.freq - o.freq;
    }
}