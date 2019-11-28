package chapter8.copy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public interface Node
{
	public static void main(String[] args)
	{
		new Directory("Foo").accept(new MyVisitor());
	}
	
	String name();
	void accept(Visitor v);
}

interface Visitor
{
	void visit(File file);
	void visit(SymbolicLink link);
}

class File implements Node
{
	private String aName;
	
	protected File(String pName)
	{
		aName = pName;
	}
	
	public String name()
	{
		return aName;
	}
	
	public void accept(Visitor v)
	{
		v.visit(this);
	}
}

class Directory extends File implements Iterable<Node>
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
	
	public void accept(Visitor v)
	{
		v.visit(this);
		for( Node file : this)
		{
			file.accept(v);
		}
	}
}

class SymbolicLink extends File
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
	
	public void accept(Visitor v)
	{
		v.visit(this);
		aNode.accept(v);
	}
}

class AbstractVisitor implements Visitor
{
	@Override
	public void visit(File file)
	{
		System.out.println("File");
	}

	@Override
	public void visit(SymbolicLink link)
	{
		System.out.println("symbolicLink");
	}	
}

class MyVisitor extends AbstractVisitor
{
	@Override
	public void visit(File directory)
	{
		super.visit(directory);
	}
}