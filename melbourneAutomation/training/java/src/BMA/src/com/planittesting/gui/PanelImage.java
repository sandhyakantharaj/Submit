package com.planittesting.gui;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class PanelImage extends JPanel
{

    // -----------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------

    private static final String URL_IMAGE = "data/images/bench.jpg";

    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------

    private JLabel label;
    private JLabel img;

    // -----------------------------------------------------------------
    // Constructors
    // -----------------------------------------------------------------

    public PanelImage( )
    {
        label = new JLabel( "BMA" );
        label.setIcon( new ImageIcon( URL_IMAGE ) );
        add( label );
    }

    // Methods
    // -----------------------------------------------------------------
}
