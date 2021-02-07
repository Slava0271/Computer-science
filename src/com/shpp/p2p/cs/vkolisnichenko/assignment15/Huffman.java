package com.shpp.p2p.cs.vkolisnichenko.assignment15;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeMap;

/**
 * The class in which the basic methods for
 * implementing the Huffman algorithm are implemented
 */
public class Huffman {

    /**
     * The method in which the sheet is created,
     * which stores the TreesNode objects sorted by value
     *
     * @param map - map with byte - size
     * @return sorted list
     */
    public LinkedList<TreesNode> treesNodes(HashMap<Byte, Integer> map) {
        LinkedList<TreesNode> nodes = new LinkedList<>();
        for (Byte b : map.keySet()) {
            nodes.add(new TreesNode(b, map.get(b)));
        }
        return nodes;
    }

    /**
     * The method in which the map is created in
     * which the encoded values for each byte are stored
     *
     * @param linkedList - list with sorted objects
     * @param node       - Top of the tree
     * @return - map with codes
     */
    public HashMap<Byte, String> coding(LinkedList<TreesNode> linkedList, TreesNode node) {
        HashMap<Byte, String> codes = new HashMap<>();

        for (TreesNode treesNode : linkedList) {
            codes.put(treesNode.b, node.getCodes(treesNode.b, ""));
        }
        return codes;
    }

    /**
     * The method in which the Huffman algorithm is implemented.
     * 2 elements are pulled from the sheet, and they are removed.
     * After that, an element is added to the sheet,
     * which will be the top of the two previous
     *
     * @param nodes - list with sorted nodes
     * @return - Top of the tree
     */
    public TreesNode huffmanAlgorithm(LinkedList<TreesNode> nodes) {
        while (nodes.size() > 1) {
            //sorted list
            Collections.sort(nodes);
            //get & remove 2 elements
            TreesNode left = nodes.remove(nodes.size() - 1);
            TreesNode right = nodes.remove(nodes.size() - 1);

            //add new element
            TreesNode node = new TreesNode(null, left.size + right.size, left, right);

            nodes.add(node);
        }
        return nodes.get(0);
    }
}
