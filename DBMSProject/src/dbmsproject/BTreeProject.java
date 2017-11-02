/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbmsproject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author VRUSHABH
 */
public class BTreeProject {

    private static int midKey = -1;
    private static int order = 5;
    private static BTNode root = null, x = null;

    private static ArrayList<String> data = new ArrayList<String>();

    public static int add_data(String name) {
        data.add(name);
        return data.indexOf(name);
    }

    public static void print_data(int index) {
        System.out.println("id: " + index + " name: " + data.get(index));
    }

    private static class BTNode {

        private int count;
        private int[] data;
        private int[] dataKey;
        private ArrayList<BTNode> childNodes;
        private Boolean leaf;

        public BTNode(int order, Boolean leaf) {
            this.leaf = leaf;
            data = new int[order - 1];
            dataKey = new int[order - 1];
            childNodes = new ArrayList<BTNode>();
            for (int i = 0; i < order; i++) {
                childNodes.add(null);
            }
            count = 0;
        }

        public void printNode() {
            int i = 0;
            for (i = 0; i < count; i++) {
                if (!this.leaf) {
                    childNodes.get(i).printNode();
                }
                System.out.println(data[i]);
            }

            if (!this.leaf && childNodes.get(i) != null) {
                childNodes.get(i).printNode();
            }
        }

        public BTNode searchNode(int key) {
            int i = 0;
            while (i < this.count && this.data[i] < key) {
                i++;
            }

            if (i <= this.count && this.data[i] == key) {
                return this;
            }

            if (this.leaf) {
                return null;
            }

            return this.childNodes.get(i).searchNode(key);
        }

    }

    private static class BTree {

        public int split_child(BTNode node, int index) {
            int j, mid;
            int splitPoint = (int) Math.floor(((float) order) / 2);
            BTNode node1, node3, ynode;
            node3 = new BTNode(order, true);
            if (index == -1) {
                mid = node.data[splitPoint];
                midKey = node.dataKey[splitPoint];

                node.data[splitPoint] = 0;
                node.dataKey[splitPoint] = -1;
                node.count--;

                node1 = new BTNode(order, false);
                node.leaf = true;

                for (j = splitPoint + 1; j < order - 1; ++j) {
                    node3.data[j - (splitPoint + 1)] = node.data[j];
                    node3.dataKey[j - (splitPoint + 1)] = node.dataKey[j];
                    node3.childNodes.set(j - (splitPoint + 1), node.childNodes.get(j));
                    node3.count++;

                    node.data[j] = 0;
                    node.dataKey[splitPoint] = -1;
                    node.count--;

                }
                for (j = 0; j < order; ++j) {
                    node.childNodes.set(j, null);
                }

                node1.data[0] = mid;
                node1.dataKey[0] = midKey;

                node1.childNodes.set(node1.count, node);
                node1.childNodes.set(node1.count + 1, node3);
                node1.count++;
                root = node1;
            } else {
                ynode = node.childNodes.get(index);
                mid = ynode.data[splitPoint];
                midKey = ynode.dataKey[splitPoint];

                ynode.data[splitPoint] = 0;
                ynode.dataKey[splitPoint] = -1;
                ynode.count--;

                for (j = splitPoint + 1; j < order - 1; ++j) {
                    node3.data[j - (splitPoint + 1)] = ynode.data[j];
                    node3.dataKey[j - (splitPoint + 1)] = ynode.dataKey[j];
                    node3.count++;

                    ynode.data[j] = 0;
                    ynode.dataKey[j] = -1;
                    ynode.count--;
                }

                node.childNodes.set(index + 1, ynode);
                node.childNodes.set(index + 1, node3);
            }

            return mid;
        }

        public void insert(int a, String name) {
            int i, temp;
            x = root;

            if (x == null) {
                root = new BTNode(order, true);
                x = root;
            } else if (x.leaf && x.count == order - 1) {
                temp = split_child(x, -1);
                x = root;
                for (i = 0; i < x.count; i++) {
                    if ((a > x.data[i]) && (a < x.data[i + 1])) {
                        i++;
                        break;
                    } else if (a < x.data[0]) {
                        break;
                    } else {
                        continue;
                    }
                }
                x = x.childNodes.get(i);
            } else {
                while (!x.leaf) {
                    for (i = 0; i < x.count; i++) {
                        if ((a > x.data[i]) && (a < x.data[i + 1])) {
                            i++;
                            break;
                        } else if (a < x.data[0]) {
                            break;
                        } else {
                            continue;
                        }
                    }
                    if (x.childNodes.get(i).count == order - 1) {
                        temp = split_child(x, i);
                        x.data[x.count] = temp;
                        x.dataKey[x.count] = midKey;
                        x.count++;
                        continue;
                    } else {
                        x = x.childNodes.get(i);
                    }
                }
            }
            x.data[x.count] = a;
            int d = add_data(name);
            x.data[x.count] = d;
            sort(x, x.count);
            x.count++;
        }

        public void sort(BTNode node, int n) {
            int i, j, temp, i_temp;
            for (i = 0; i < n; ++i) {
                for (j = i; j < n; ++j) {
                    if (node.data[i] > node.data[j]) {
                        temp = node.data[i];
                        i_temp = node.dataKey[i];
                        node.data[i] = node.data[j];
                        node.dataKey[i] = node.dataKey[j];
                        node.data[j] = temp;
                        node.dataKey[j] = i_temp;
                    }
                }
            }

        }

        private BTNode find(int id) {
            if (root != null) {
                return root.searchNode(id);
            }
            return root;
        }

        private void print() {
          if(root != null){
              root.printNode();
          }else{
              System.err.println("Tree is null");
          }
        }

    }

    public static void main(String[] args) {
        BufferedReader reader = null;
        String str, choice = "d";
        BTree tree = new BTree();
        Scanner s = new Scanner(System.in);
        try {
            reader = new BufferedReader(new FileReader("F:\\Projects\\DBMSProject\\src\\dbmsproject\\data.txt"));
            order = Integer.parseInt(reader.readLine());
            System.out.println(order);
            while ((str = reader.readLine()) != null) {
                String[] temp = str.split(" ");
                
                System.out.println(temp[0] + " " + temp[1]);
                
                tree.insert(Integer.parseInt(temp[0]), temp[1]);
                
                tree.print();
            }
        } catch (Exception e) {
            e.printStackTrace();
            //System.exit(-1);
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
                System.exit(-1);
            }
        }

        try {
            do {
                System.out.println("Operations: ");
                System.out.println("a. Insert");
                System.out.println("b. Find");
                System.out.println("c. Print Tree");
                System.out.println("d. exit");
                choice = s.nextLine();
                switch (choice) {
                    case "a":
                        String[] temp = s.nextLine().split(" ");
                        tree.insert(Integer.parseInt(temp[0]), temp[1]);
                        break;
                    case "b":
                        int id = Integer.parseInt(s.nextLine());
                        if (tree.find(id) != null) {
                            System.out.println("Found");
                        } else {
                            System.out.println("Not Found");
                        }
                        break;
                    case "c":
                        tree.print();
                        break;
                    case "d":
                        System.exit(1);
                        break;
                    default:
                        System.err.println("Invalid Operation, Try Again!");
                }
            } while (!choice.equals("d"));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
