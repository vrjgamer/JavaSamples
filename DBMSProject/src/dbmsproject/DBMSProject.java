package dbmsproject;

import java.io.BufferedReader;

import java.io.FileReader;
import java.util.ArrayList;

public class DBMSProject {

    public static int minDegree;
    public static int keyMaxCount;
    public static int childMaxCount;

    private static void initializeBTreeVariables(int minDegree) {
        DBMSProject.minDegree = minDegree;
        DBMSProject.keyMaxCount = minDegree - 1;
        DBMSProject.childMaxCount = 2 * minDegree - 1;
    }

    private static class BTreeNode {

        private ArrayList<Integer> keys;
        private ArrayList<BTreeNode> childs;
        private int currKeyCount;
        private boolean isLeaf;

        public BTreeNode(boolean isLeaf) {
            this.isLeaf = isLeaf;
            keys = new ArrayList<Integer>();
            for (int i = 0; i < DBMSProject.keyMaxCount; ++i) {
                keys.add(i, 0);
            }
            childs = new ArrayList<BTreeNode>();
            for (int i = 0; i < DBMSProject.childMaxCount; ++i) {
                childs.add(i, null);
            }
            this.currKeyCount = 0;
        }

        public void printNode() throws Exception {
            System.out.print("\nkeys: ");
            for (int i = 0; i < keys.size(); ++i) {
                System.out.print(keys.get(i) + " -- ");
            }
            System.out.print("\nchilds: ");
            for (int i = 0; i < childs.size(); ++i) {
                System.out.print(childs.get(i) + " -- ");
            }
        }

        public void printTree() throws Exception {
            int i;
            for (i = 0; i < this.currKeyCount; ++i) {
                if (!this.isLeaf) {
                    this.childs.get(i).printTree();
                }
                System.out.print(keys.get(i) + " ");
            }

            if (!this.isLeaf) {
                this.childs.get(i).printTree();
            }

        }

        public BTreeNode searchNode(int key) throws Exception {
            int i = 0;
            while (i < this.currKeyCount && this.keys.get(i) < key) {
                i++;
            }

            if (i <= this.currKeyCount && this.keys.get(i) == key) {
                return this;
            }

            if (this.isLeaf) {
                return null;
            }

            return this.childs.get(i).searchNode(key);
        }

        public void spiltChild(int index, BTreeNode node) throws Exception {

            BTreeNode splitNode = new BTreeNode(node.isLeaf);
            splitNode.currKeyCount = minDegree - 1;

            for (int i = 0; i < minDegree - 1; i++) {
                splitNode.keys.set(i, node.keys.get(i + minDegree));
            }

            if (node.isLeaf == false) {
                for (int j = 1; j <= node.currKeyCount; ++j) {
                    splitNode.childs.set(j, node.childs.get(j + minDegree));
                }
            }

            node.currKeyCount = minDegree - 1;

            for (int j = currKeyCount; j >= index + 1; j--) {
                this.childs.set(j + 1, childs.get(j));
            }

            this.childs.set(index + 1, splitNode);

            for (int j = currKeyCount - 1; j >= index; j--) {
                this.keys.set(j + 1, keys.get(j));
            }

            this.keys.set(index, node.keys.get(minDegree - 1));

            this.currKeyCount = this.currKeyCount + 1;
        }

        public void insertToChilds(int key) throws Exception {
            int i = this.currKeyCount - 1;

            if (this.isLeaf) {
                while (i >= 0 && this.keys.get(i) > key) {
                    this.keys.set(i + 1, this.keys.get(i));
                    i--;
                }

                this.keys.set(i + 1, key);
                this.currKeyCount++;
            } else {
                while (i >= 0 && this.keys.get(i) > key) {
                    i--;
                }

                if (this.childs.get(i + 1).currKeyCount == keyMaxCount) {
                    spiltChild(i + 1, this.childs.get(i + 1));

                    if (this.keys.get(i + 1) < key) {
                        i++;
                    }

                }
                this.childs.get(i + 1).insertToChilds(key);

            }
//            System.out.print("node: ");
//            printNode();
//            System.out.println();
        }

        public int findKeyIndex(int key) {
            int index = 0;

            while (index < this.currKeyCount && this.keys.get(index) < key) {
                ++index;
            }

            return index;
        }

        public void remove(int key) throws Exception {
            int index = findKeyIndex(key);

            if (index < this.currKeyCount && this.keys.get(index) == key) {
                if (this.isLeaf) {
                    this.removeFromLeaf(index);
                } else {
                    this.removeFromNonLeaf(index);
                }
            } else {
                if (this.isLeaf) {
                    System.err.println("Key is not present.");
                    return;
                }

                boolean flag = (index == this.currKeyCount);

                if (this.childs.get(index).currKeyCount < minDegree - 1) {
                    this.fill(index);
                }

                if (flag && index > this.currKeyCount) {
                    this.childs.get(index - 1).remove(key);
                } else {
                    this.childs.get(index).remove(key);
                }
            }
//            System.out.print("node: ");
//            printNode();
//            System.out.println();
            return;
        }

        public void removeFromLeaf(int index) throws Exception {
            for (int i = index + 1; i < this.currKeyCount; ++i) {
                this.keys.set(i - 1, this.keys.get(i));
            }
            this.currKeyCount -= 1;

            return;
        }

        public void removeFromNonLeaf(int index) throws Exception {
            int key = keys.get(index);

            if (childs.get(index).currKeyCount >= minDegree) {
                int predecessor = getPredecessor(index);
                keys.set(index, predecessor);
                childs.get(index).remove(predecessor);
            } else if (childs.get(index + 1).currKeyCount >= minDegree) {
                int successor = getSuccessor(index);
                keys.set(index, successor);
                childs.get(index).remove(successor);
            } else {
                merge(index);
                childs.get(index).remove(key);
            }
            return;

        }

        public int getPredecessor(int index) throws Exception {
            BTreeNode node = childs.get(index);
            while (!node.isLeaf) {
                node = node.childs.get(node.currKeyCount);
            }

            return node.keys.get(node.currKeyCount - 1);
        }

        public int getSuccessor(int index) throws Exception {
            BTreeNode node = childs.get(index + 1);
            while (!node.isLeaf) {
                node = node.childs.get(0);
            }

            return node.keys.get(0);
        }

        public void fill(int index) throws Exception {
            if ((index != 0) && (childs.get(index - 1).currKeyCount >= minDegree)) {
                borrowFromLeftNode(index);
            } else if (index != currKeyCount && childs.get(index + 1).currKeyCount >= minDegree) {
                borrowFromRightNode(index);
            } else if (index != currKeyCount) {
                merge(index);
            } else {
                merge(index - 1);
            }

            return;
        }

        public void borrowFromLeftNode(int index) throws Exception {
            BTreeNode childNode = childs.get(index);
            BTreeNode siblingNode = childs.get(index - 1);

            for (int i = childNode.currKeyCount - 1; i >= 0; --i) {
                childNode.keys.set(i + 1, childNode.keys.get(i));
            }

            if (!childNode.isLeaf) {
                for (int i = childNode.currKeyCount; i >= 0; --i) {
                    childNode.childs.set(i + 1, childNode.childs.get(i));
                }
            }

            childNode.keys.set(0, keys.get(index - 1));

            if (!isLeaf) {
                childNode.childs.set(0, siblingNode.childs.get(siblingNode.currKeyCount));
            }

            keys.set(index - 1, siblingNode.keys.get(siblingNode.currKeyCount - 1));

            childNode.currKeyCount += 1;
            siblingNode.currKeyCount -= 1;
            return;
        }

        public void borrowFromRightNode(int index) throws Exception {
            BTreeNode childNode = childs.get(index);
            BTreeNode siblingNode = childs.get(index + 1);

            childNode.keys.set(childNode.currKeyCount, keys.get(index));

            if (!childNode.isLeaf) {
                childNode.childs.set((childNode.currKeyCount + 1), siblingNode.childs.get(0));
            }

            for (int i = 1; i < siblingNode.currKeyCount; ++i) {
                siblingNode.keys.set(i - 1, siblingNode.keys.get(i));
            }

            if (!siblingNode.isLeaf) {
                for (int i = 1; i <= siblingNode.currKeyCount; ++i) {
                    siblingNode.childs.set(i - 1, siblingNode.childs.get(i));
                }
            }
            childNode.currKeyCount += 1;
            siblingNode.currKeyCount -= 1;
            return;
        }

        public void merge(int index) throws Exception {
            BTreeNode childNode = childs.get(index);
            BTreeNode siblingNode = childs.get(index + 1);

            childNode.keys.set(minDegree - 1, keys.get(index));

            for (int i = 0; i < siblingNode.currKeyCount; ++i) {
                childNode.keys.set(i + minDegree, siblingNode.keys.get(i));
            }

            if (!childNode.isLeaf) {
                for (int i = 0; i <= siblingNode.currKeyCount; ++i) {
                    childNode.childs.set(i + minDegree, siblingNode.childs.get(i));
                }
            }

            for (int i = index + 1; i < currKeyCount; ++i) {
                keys.set(i - 1, keys.get(i));
            }

            for (int i = index + 2; i <= currKeyCount; ++i) {
                childs.set(i - 1, childs.get(i));
            }

            childNode.currKeyCount += siblingNode.currKeyCount + 1;
            currKeyCount--;

            siblingNode = null;
            System.gc();
            return;

        }
    }

    private static class BTree {

        private BTreeNode root;

        public BTree() {
            root = null;
        }

        public void printTree() throws Exception {
            if (root != null) {
                root.printTree();
                System.out.println();
            }
        }

        public BTreeNode searchBTree(int key) throws Exception {
            if (root != null) {
                return root.searchNode(key);
            }

            return null;
        }

        public void insert(int key) throws Exception {

            if (root == null) {
                root = new BTreeNode(true);
                root.keys.set(0, key);
                root.currKeyCount = 1;
            } else if (root.currKeyCount == keyMaxCount) {
                BTreeNode sideNode = new BTreeNode(false);
                sideNode.childs.set(0, root);
                sideNode.spiltChild(0, root);

                int i = 0;
                if (sideNode.keys.get(0) < key) {
                    i++;
                }

                sideNode.childs.get(i).insertToChilds(key);

                root = sideNode;

            } else {
                root.insertToChilds(key);
            }
            printTree();
        }

        public void remove(int key) throws Exception {
            if (root == null) {
                System.err.println("Tree is empty");
                return;
            }

            root.remove(key);

            if (root.currKeyCount == 0) {
                BTreeNode temp = root;
                if (temp.isLeaf) {
                    root = null;
                } else {
                    root = root.childs.get(0);
                }
                temp = null;
                System.gc();
            }
            return;
        }

    }

    public static void main(String[] args) {
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader("F:\\Projects\\DBMSProject\\src\\dbmsproject\\data.txt"));
            int order = Integer.parseInt(reader.readLine());
            initializeBTreeVariables(3);

        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        BTree t = new BTree();
        try {

            t.insert(1);
            t.insert(3);
            t.insert(7);
            t.insert(10);
            t.insert(11);
            t.insert(13);
            t.insert(14);
            t.insert(15);
            t.insert(18);
            t.insert(16);
            t.insert(19);
            t.insert(24);
            t.insert(25);
            t.insert(26);
            t.insert(21);
            t.insert(4);
            t.insert(5);
            t.insert(20);
            t.insert(22);
            t.insert(2);
            t.insert(17);
            t.insert(12);
            t.insert(6);

            System.out.println("tree:");
            t.printTree();

            if (t.searchBTree(6) != null) {
                System.out.println("present");
            } else {
                System.out.println("not present");
            }

            t.remove(6);
            System.out.println("Traversal of tree constructed is\n");
            t.printTree();
            System.out.println();

            t.remove(13);
            System.out.println("Traversal of tree constructed is\n");
            t.printTree();
            System.out.println();

            t.remove(7);
            System.out.println("Traversal of tree constructed is\n");
            t.printTree();
            System.out.println();

            t.remove(4);
            System.out.println("Traversal of tree constructed is\n");
            t.printTree();
            System.out.println();
            t.remove(2);
            System.out.println("Traversal of tree constructed is\n");
            t.printTree();
            System.out.println();

            t.remove(16);
            System.out.println("Traversal of tree constructed is\n");
            t.printTree();
            System.out.println();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
