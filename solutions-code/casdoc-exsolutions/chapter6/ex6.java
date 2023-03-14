package chapter6;


import java.awt.Component;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;

/*?
 * A composite icon is a collection of icons that are painted in sequence. The width and height of the composite icon is the maximum width and height of the icons in the collection. 
 */
public class CompositeIcon implements Icon
{
    /*?
     * Keyword: aIcons
     * aIcons is a list of icons.
     */
	private final List<Icon> aIcons = new ArrayList<>();
	
    /*?
     * Keyword: addIcon
     * addIcon adds an icon to the list of icons.
     */
	public void addIcon(Icon pIcon)
	{
		aIcons.add(pIcon);
	}
	
	@Override
    /*?
     * Keyword: getIconHeight
     * getIconHeight returns the maximum height of the icons in the list. It is calculated by iterating over the list of icons and comparing the height of each icon with the current maximum height.
     */
	public int getIconHeight()
	{
		int height = 0;
		for( Icon icon : aIcons )
		{
            /*?
             * Keyword: max
             * `Math.max` returns the maximum of two values.
             */
			height = Math.max(height, icon.getIconHeight());
		}
		return height;
	}

	@Override
    /*?
     * Keyword: getIconWidth
     * getIconWidth returns the maximum width of the icons in the list. It is calculated by iterating over the list of icons and comparing the width of each icon with the current maximum width.
     */
	public int getIconWidth()
	{
		int width = 0;
		for( Icon icon : aIcons )
		{
            /*?
             * Keyword: max
             * `Math.max` returns the maximum of two values.
             */
			width = Math.max(width, icon.getIconWidth());
		}
		return width;
	}

	@Override
    /*?
     * Keyword: paintIcon
     * paintIcon paints the icons in the list. It is calculated by iterating over the list of icons and calling the paintIcon method of each icon.
     */
	public void paintIcon(Component pComponent, Graphics pGraphics, int pX, int pY)
	{
		for( Icon icon : aIcons)
		{
			icon.paintIcon(pComponent, pGraphics, pX, pY);
		}
	}
}

public class ShiftedIcon implements Icon
{
	private final Icon aElement; // The icon to be shifted
	private final int aX; // The horizontal shift
	private final int aY; // The vertical shift
	
    // The constructor of the ShiftedIcon class takes an icon and a horizontal and vertical shift.
	public ShiftedIcon(Icon pElement, int pX, int pY)
	{
		aElement = pElement;
		aX = pX;
		aY = pY;
	}

	@Override
    /*?
     * Keyword: getIconHeight
     * getIconHeight returns the height of the icon plus the vertical shift.
     */
	public int getIconHeight()
	{
		return aElement.getIconHeight() + aY;
	}

	@Override
    /*?
     * Keyword: getIconWidth
     * getIconWidth returns the width of the icon plus the horizontal shift.
     */
	public int getIconWidth()
	{
		return aElement.getIconWidth() + aX;
	}

	@Override
    /*?
     * Keyword: paintIcon
     * paintIcon paints the icon at the specified location plus the horizontal and vertical shift.
     */
	public void paintIcon(Component pComponent, Graphics pGraphics, int pX, int pY)
	{
		aElement.paintIcon(pComponent, pGraphics, pX + aX, pY + aY);
	}

    /*?
     * Keyword: createHandIcon
     * createHandIcon creates an icon for a hand of cards. It takes an array of cards and a boolean indicating whether the cards should be hidden. It returns an icon that contains the cards. If the cards should be hidden, the back of the cards is shown. Otherwise, the front of the cards is shown. The cards are shifted horizontally by SHIFT_X and vertically by SHIFT_Y (both are integers)
     * 
     */
    private Icon createHandIcon(Card[] pHand, boolean pHidden) 
    {
        /*?
         * Keyword: result
         * result is a composite icon that contains the cards in the hand.
         */
	    CompositeIcon result = new CompositeIcon();
	    for( int i = 0; i < pHand.length; i++ )
	    {
            /*?
             * Keyword: SHIFT_X
             * SHIFT_X is the horizontal shift of the cards.
             * 
             * Keyword: SHIFT_Y
             * SHIFT_Y is the vertical shift of the cards.
             * 
             * Keyword: addIcon
             * addIcon adds an icon to the composite icon. It takes an icon as a parameter and adds it to the list of icons in the composite icon.
             * 
             * Keyword: pHidden
             * pHidden is a boolean indicating whether the cards should be hidden. The colon (:) is the ternary operator. It is used to select one of two values based on the value of a boolean. If pHidden is true, the back of the card, CardImages.getBack() is shown. Otherwise, the front of the card is shown, which is CardImages.getCard(pHand[i]).
             */
		    result.addIcon(new ShiftedIcon(pHidden?CardImages.getBack():CardImages.getCard(pHand[i]), SHIFT_X, SHIFT_Y));
	    }
	    return result;
    }
}
