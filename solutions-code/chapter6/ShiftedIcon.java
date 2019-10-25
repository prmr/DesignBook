package chapter6;


import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;

public class ShiftedIcon implements Icon
{
	private final Icon aElement;
	private final int aX;
	private final int aY;
	
	public ShiftedIcon(Icon pElement, int pX, int pY)
	{
		aElement = pElement;
		aX = pX;
		aY = pY;
	}

	@Override
	public int getIconHeight()
	{
		return aElement.getIconHeight() + aY;
	}

	@Override
	public int getIconWidth()
	{
		return aElement.getIconWidth() + aX;
	}

	@Override
	public void paintIcon(Component pComponent, Graphics pGraphics, int pX, int pY)
	{
		aElement.paintIcon(pComponent, pGraphics, pX + aX, pY + aY);
	}
}
