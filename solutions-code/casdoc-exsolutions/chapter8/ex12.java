package chapter8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public interface Node
{
    /*?
     * Keyword: name
     * This is a method that is used to get the name of the node.
     */
	String name();
    /*?
     * Keyword: accept
     * This is a method that is used to accept a visitor and visit the node. The visitor is passed to the accept method and the visit method of the visitor is called to visit the node and perform the action that is associated with the node being visited.
     */
    void accept(Visitor pVisitor);
}

/*?
 * Keyword: abstract class
 * An abstract class is a class that is used to define the common behaviour of a group of classes. It cannot be instantiated. It can only be used as a base class for other classes. 
 */
abstract class AbstractNode implements Node
{
	private String aName;
	
	protected AbstractNode(String pName)
	{
		aName = pName;
	}
	
	public String name()
	{
		return aName;
	}
}

class File extends AbstractNode
{
	public File(String pName)
	{
		super(pName);
	}

    /*?
     * Keyword: accept
     * This is a method that is used to accept a visitor and visit the node. The visitor is passed to the accept method and the visit method of the visitor is called to visit the node and perform the action that is associated with the node being visited.
     */
    public void accept(Visitor pVisitor)
    {
        /*?
         * Keyword: this
         * This is a keyword that is used to represent the current object. In this case, it is used to represent the File object that is being visited.
         */
        pVisitor.visitFile(this);
    }
}

class Directory extends AbstractNode implements Iterable<Node>
{
	private final List<Node> aNodes;
	
	public Directory(String pName, Node... pNodes)
	{
		super(pName);
		aNodes = Arrays.asList(pNodes);
	}
	
	public Iterator<Node> iterator()
	{
		return Collections.unmodifiableList(aNodes).iterator();
	}

    /*?
     * Keyword: accept
     * This is a method that is used to accept a visitor and visit the node. The visitor is passed to the accept method and the visit method of the visitor is called to visit the node and perform the action that is associated with the node being visited. In this case, the visitor is passed to the accept method of the Directory object and the preVisitDirectory method of the visitor is called to visit the Directory object. The Directory object is then iterated over and the accept method of each node is called to visit the node. The postVisitDirectory method of the visitor is then called to visit the Directory object.
     */
    public void accept(Visitor pVisitor) {
        /*?
         * Keyword: preVisitDirectory
         * The pre-visit method is called before the children of the node are visited.
         */
        pVisitor.preVisitDirectory(this);

        // for each node in the directory, accept the visitor
        for (Node node : this) {
            node.accept(pVisitor);
        }

        /*?
         * Keyword: postVisitDirectory
         * The post-visit method is called after the children of the node are visited.
         */
        pVisitor.postVisitDirectory(this);
    }
}

class SymbolicLink extends AbstractNode
{
	private final Node aNode;
	
	public SymbolicLink(String pName, Node pNode)
	{
		super(pName);
		aNode = pNode;
	}
	
	public String name()
	{
		return "Link to " + aNode.name();
	}

    /*?
     * Keyword: accept
     * This is a method that is used to accept a visitor and visit the node. The visitor is passed to the accept method and the visit method of the visitor is called to visit the node and perform the action that is associated with the node being visited.
     */
    public void accept(Visitor pVisitor)
    {
        /*?
         * Keyword: this
         * This is a keyword that is used to represent the current object. In this case, it is used to represent the SymbolicLink object that is being visited.
         */
        pVisitor.visitSymbolicLink(this);
    }
}

/*?
 * Keyword: Visitor
 * This is an interface that is used to represent a visitor. We are using the Visitor Design Pattern to visit each node in the tree and perform an action on it. The visit method is used to visit the node and perform the action that is associated with the node being visited. The visit method is overloaded to visit each type of node in the tree (File, Directory, SymbolicLink).
 * 
 * Internal: Visitor Design Pattern
 * Visitor
 * The visitor design pattern is used to separate the algorithm from the object structure on which it operates. The algorithm is defined in the visitor class and the object structure is defined in the node classes. The visitor class is passed to the accept method of the node classes and the visit method of the visitor class is called to visit the node and perform the action that is associated with the node being visited.
 */
interface Visitor {

    /*?
     * Keyword: visitFile
     * This is the visit method that is called to visit a File and perform the action that is associated with the File being visited.
     */
    void visitFile(File pFile);

    /*?
     * Keyword: visitDirectory
     * This is the visit method that is called to visit a Directory and perform the action that is associated with the Directory being visited.
     */
    void visitDirectory(Directory pDirectory);

    /*?
     * Keyword: preVisitDirectory
     * This is the visit method that is called to visit a Directory before the Directory is visited. It is used to perform an action before the Directory is visited. The traversal of the node tree is triggered from the target class hierarchy (as opposed to the visitor), so implementations of Visitor do not have the flexibility to add instructions before and after the children of a node are traversed without additional support. This support can be added using pre- and post- visit methods for aggregate nodes instead of a single visit method. The pre-visit method is called before the children of the node are visited.
     *
     */
    void preVisitDirectory(Directory pDirectory);

    /*?
     * Keyword: postVisitDirectory
     * This is the visit method that is called to visit a Directory after the Directory is visited. It is used to perform an action after the Directory is visited. The traversal of the node tree is triggered from the target class hierarchy (as opposed to the visitor), so implementations of Visitor do not have the flexibility to add instructions before and after the children of a node are traversed without additional support. This support can be added using pre- and post- visit methods for aggregate nodes instead of a single visit method. The post-visit method is called after the children of the node are visited.
     *
     */
    void postVisitDirectory(Directory pDirectory);

    /*?
     * Keyword: visitSymbolicLink
     * This is the visit method that is called to visit a SymbolicLink and perform the action that is associated with the SymbolicLink being visited.
     */
    void visitSymbolicLink(SymbolicLink pLink);
}

/*?
 * Keyword: PrintVisitor
 * This is a class that is used to implement the Visitor interface. It is used to print the name of each node in the tree when it is visited by the visitor.
 */
public class PrintVisitor implements Visitor {

    /*?
     * Keyword: TAB
     * This is a constant that is used to represent a tab character.
     */
    private static final String TAB = "   ";

    /*?
     * Keyword: aIndent
     * This is a StringBuilder that is used to represent the indentation of the output. The indentation is increased when a Directory is visited and decreased when the Directory is exited. The indentation is used to represent the hierarchy of the tree. The indentation is increased by appending a tab character to the StringBuilder and decreased by deleting the last tab character from the StringBuilder.
     * 
     * Internal: StringBuilder
     * aIndent
     * StringBuilder is a mutable sequence of characters. It is used to represent a sequence of characters that can be modified. It is more efficient than using String to represent a sequence of characters that can be modified. The append method is used to append a character to the end of the sequence of characters. The delete method is used to delete a character from the sequence of characters.
     */
    private StringBuilder aIndent = new StringBuilder();

    /*?
     * Keyword: indent
     * This is a method that is used to increase the indentation of the output by appending a tab character to the StringBuilder. The indentation is increased when a Directory is visited.
     */
    private void indent() {
        /*?
         * Keyword: append
         * This is a method that is used to append a character to the end of the sequence of characters. In this case, it is used to append a tab character to the end of the sequence of characters. The append method takes a String as a parameter and returns a StringBuilder object of the sequence of characters with the character appended to the end of the sequence of characters.
         */
        aIndent.append(TAB);
    }

    /*?
     * Keyword: unindent
     * This is a method that is used to decrease the indentation of the output by deleting the last tab character from the StringBuilder. The indentation is decreased when a Directory is exited.
     */
    private void unindent() {
        /*?
         * Keyword: delete
         * This is a method that is used to delete a character from the sequence of characters. In this case, it is used to delete the last tab character from the sequence of characters. The delete method takes two integers as parameters and returns a StringBuilder object of the sequence of characters with the character deleted from the sequence of characters.
         */
        aIndent.delete(aIndent.length() - TAB.length(), aIndent.length());
    }


    @Override
    /*?
     * Keyword: visitFile
     * This is the visit method that is called to visit a File and perform the action that is associated with the File being visited (in this case, print the name of the File).
     */
    public void visitFile(File pFile) {
        // Print the name of the File with the indentation.
        System.out.println(aIndent.toString() + pFile.name());
    }

    @Override
    /*?
     * Keyword: visitDirectory
     * This is the visit method that is called to visit a Directory and perform the action that is associated with the Directory being visited (in this case, print the name of the Directory).
     */
    public void visitDirectory(Directory pDirectory) {
        System.out.println(pDirectory.name());
    }

    @Override
    /*?
     * Keyword: preVisitDirectory
     * This is the visit method that is called to visit a Directory before the Directory is visited. It is used to perform an action before the Directory is visited. The traversal of the node tree is triggered from the target class hierarchy (as opposed to the visitor), so implementations of Visitor do not have the flexibility to add instructions before and after the children of a node are traversed without additional support. This support can be added using pre- and post- visit methods for aggregate nodes instead of a single visit method. The pre-visit method is called before the children of the node are visited.
     *
     */
    public void preVisitDirectory(Directory pDirectory)
    {
        // Print the name of the Directory with the indentation and increase the indentation for the children of the Directory.
       System.out.println(aIndent.toString() + pDirectory.name());
       indent();
    }
     
    @Override
    /*?
     * Keyword: postVisitDirectory
     * This is the visit method that is called to visit a Directory after the Directory is visited. It is used to perform an action after the Directory is visited. The traversal of the node tree is triggered from the target class hierarchy (as opposed to the visitor), so implementations of Visitor do not have the flexibility to add instructions before and after the children of a node are traversed without additional support. This support can be added using pre- and post- visit methods for aggregate nodes instead of a single visit method. The post-visit method is called after the children of the node are visited.
     *
     */
    public void postVisitDirectory(Directory pDirectory)
    {
       unindent(); // Decrease the indentation for the children of the Directory.
    }

    @Override
    /*?
     * Keyword: visitSymbolicLink
     * This is the visit method that is called to visit a SymbolicLink and perform the action that is associated with the SymbolicLink being visited (in this case, print the name of the SymbolicLink).
     */
    public void visitSymbolicLink(SymbolicLink pLink) {
        // Print the name of the SymbolicLink with the indentation.
        System.out.println(aIndent.toString() + pLink.name());
    }

    public static void main(String[] args) {
        /*?
         * Keyword: root
         * Create a tree of nodes. The root node is a Directory node that contains a File node, a Directory node, and another File node as children. The Directory node contains a File node and a SymbolicLink node as children. The SymbolicLink node contains a File node as a child.
         */
        Directory root = new Directory("root",
                new File("file1"),
                new Directory("dir1",
                        new File("file2"),
                        new SymbolicLink("link1", new File("file3"))),
                new File("file4"));

        PrintVisitor visitor = new PrintVisitor(); // Create a visitor
        root.accept(visitor); // Visit the root node and print the name of each node in the tree
    }
}