package chapter6;


import java.awt.Component;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;

public class CompositeIcon implements Icon
{
	private final List<Icon> aIcons = new ArrayList<>();
	
	public void addIcon(Icon pIcon)
	{
		aIcons.add(pIcon);
	}
	
	@Override
	public int getIconHeight()
	{
		int height = 0;
		for( Icon icon : aIcons )
		{
			height = Math.max(height, icon.getIconHeight());
		}
		return height;
	}

	@Override
	public int getIconWidth()
	{
		int width = 0;
		for( Icon icon : aIcons )
		{
			width = Math.max(width, icon.getIconWidth());
		}
		return width;
	}

	@Override
	public void paintIcon(Component pComponent, Graphics pGraphics, int pX, int pY)
	{
		for( Icon icon : aIcons)
		{
			icon.paintIcon(pComponent, pGraphics, pX, pY);
		}
	}
}
