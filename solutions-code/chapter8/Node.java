package chapter8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public interface Node
{
	String name();
}

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
}