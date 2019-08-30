/*******************************************************************************
 * Companion code for the book "Introduction to Software Design with Java" 
 * by Martin P. Robillard.
 *
 * Copyright (C) 2019 by Martin P. Robillard
 *
 * This code is licensed under a Creative Commons 
 * Attribution-NonCommercial-NoDerivatives 4.0 International License.
 * 
 * See http://creativecommons.org/licenses/by-nc-nd/4.0/
 *******************************************************************************/
package chapter8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Code for the Inventory case study of section .4.
 */
public class Inventory implements Iterable<Item>
{
	/**
	 * Sample client code.
	 */
	public static void main(String[] args)
	{
		Inventory inventory = new Inventory();
		PieChart chart = new PieChart(inventory);
		ListView list = new ListView();
		inventory.addObserver(chart);
		inventory.addObserver(list);
		inventory.add(new Item(1,2019));
		inventory.add(new Item(2,2019));
	}
	
	private final List<Item> aItems = new ArrayList<>();
	private final List<InventoryObserver> aObservers = new ArrayList<>();
	
	public void addObserver(InventoryObserver pObserver)
	{
		aObservers.add(pObserver);
	}
	
	public void removeObserver(InventoryObserver pObserver)
	{
		aObservers.remove(pObserver);
	}
	
	public void add(Item pItem)
	{
		aItems.add(pItem);
		for(InventoryObserver observer : aObservers )
		{
			observer.itemAdded(pItem);
		}
	}
	
	public void remove(Item pItem)
	{
		aItems.remove(pItem);
		for(InventoryObserver observer : aObservers )
		{
			observer.itemRemoved(pItem);
		}
	}
	

	@Override
	public Iterator<Item> iterator()
	{
		return aItems.iterator();
	}
}

class Item
{
	private final int aSerialNumber;
	private final int aYear;
	
	public Item( int pSerialNumber, int pYear) 
	{
		aSerialNumber = pSerialNumber;
		aYear = pYear;
	}
	
	public int getSerialNumber()
	{
		return aSerialNumber;
	}
	
	public int getYear()
	{
		return aYear;
	}
}

/**
 * The abstract observer in the design pattern.
 */
interface InventoryObserver
{
	void itemAdded(Item pItem);
	void itemRemoved(Item pItem);
}

/**
 * Sample concrete observer. Does a complete refresh for
 * every event and holds a reference to the model.
 */
class PieChart implements InventoryObserver
{
	private Inventory aModel;
	
	public PieChart( Inventory pInventory ) 
	{
		aModel = pInventory;
	}
	
	private void refresh()
	{
		// Clear pie chart
		for( @SuppressWarnings("unused") Item item : aModel )
		{
			// Add to piechart calculation.
		}
		// Draw pie chart
	}

	@Override
	public void itemAdded(Item pItem)
	{
		refresh();
	}

	@Override
	public void itemRemoved(Item pItem)
	{
		refresh();	
	}
}

/**
 * Sample concrete observer. Incrementally
 * adds to a list based on events. Does not
 * need a reference to the model.
 */
class ListView implements InventoryObserver
{

	@Override
	public void itemAdded(Item pItem)
	{
		// add pItem to the list.		
	}

	@Override
	public void itemRemoved(Item pItem)
	{
		// Find pItem and remove it from the list.		
	}
}