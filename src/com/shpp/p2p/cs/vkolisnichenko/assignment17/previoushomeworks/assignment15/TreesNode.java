package com.shpp.p2p.cs.vkolisnichenko.assignment17.previoushomeworks.assignment15;

/**
 * A class that represents a tree object -
 * a node or a leaf, depending on the constructor.
 * Objects are sorted by the number of
 * repetitions of one byte
 */
public class TreesNode implements Comparable<TreesNode> {
    //byte
    Byte b;
    //number of repetitions
    int size;

    //Tree branches
    TreesNode left;
    TreesNode right;


    //used when creating a leaf
    public TreesNode(Byte b, int size) {
        this.b = b;
        this.size = size;
    }

    //used when creating a tree node
    public TreesNode(Byte b, int size, TreesNode left, TreesNode right) {
        this.b = b;
        this.size = size;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        if (b != null)
            return (char) (int) b + " " + size;
        return "" + size;
    }

    /**
     * A method in which an encoding is created from
     * bits for a byte, by traversing a tree, depending
     * on which nodes the byte is in, 0 or 1 is added
     *
     * @param by     - The byte to be encoded
     * @param coding - encoding for byte
     * @return
     */
    public String getCodes(Byte by, String coding) {
        //if we are on the desired byte
        if (b == by)
            return coding;
        else {
            //if left node not null
            if (left != null) {
                //add 0 to path
                String path = left.getCodes(by, coding + 0);
                if (path != null)
                    return path;
            }
            if (right != null) {
                ////add 1 to path
                String path = right.getCodes(by, coding + 1);
                if (path != null)
                    return path;
            }
        }
        return null;
    }

    /**
     * sorting objects by the number of identical elements
     *
     * @param o - object
     * @return - return value
     */
    @Override
    public int compareTo(TreesNode o) {
        return o.size - size;
    }

}
