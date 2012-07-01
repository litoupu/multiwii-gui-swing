package eu.kprod.gui.instrument;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.geom.Point2D;
import java.io.InputStream;

import eu.kprod.ds.MwDataSourceListener;
import eu.kprod.gui.MwGuiRuntimeException;
import eu.kprod.gui.Ress;
import eu.kprod.gui.comp.MwJPanel;

public abstract class MwInstrumentJPanel extends MwJPanel implements
        MwDataSourceListener {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Float FONTSIZE = 12.0f;

    private static Font writing = null;

    private Point2D centerPoint;
    private int radiusx;
    private int radiusy;
    private int maxRadiusX = 200;
    private int maxRadiusY = 200;

    private Dimension dimPanel;

    private int dimMarker5Deg=7;
    private int dimMarker10Deg=15;

    public MwInstrumentJPanel(Dimension dimension) {
        if (dimension == null) {
            // Instance variables initialization
            dimPanel = new Dimension(this.maxRadiusX, this.maxRadiusY);
        } else {
            dimPanel = dimension;
            maxRadiusX=dimPanel.width;
            maxRadiusY=dimPanel.height;
        }
        radiusx=((Double) (0.45 * this.maxRadiusX)).intValue();
        radiusy=((Double) (0.45 * this.maxRadiusY)).intValue();
        
        // this.setMinimumSize(dimPanel);
        // Define a center point as a reference
        centerPoint=new Point2D.Float(this.maxRadiusX / 2,
                this.maxRadiusY / 2);

        if (writing == null) {

            InputStream is = this.getClass().getResourceAsStream(
                    Ress.font);

            try {
                writing=Font.createFont(Font.TRUETYPE_FONT, is);

                writing=writing.deriveFont(FONTSIZE);

            } catch (Exception e) {
                throw new MwGuiRuntimeException("Fonts creation failed",e);
            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return dimPanel;
    }

    @Override
    public void resetAllValues() {
        resetAllValuesImpl();
        repaint();

    }

    abstract void resetAllValuesImpl();

    public static Font getWriting() {
        return writing;
    }

    public static void setWriting(Font writing) {
        MwInstrumentJPanel.writing = writing;
    }

    public Point2D getCenterPoint() {
        return centerPoint;
    }

    public void setCenterPoint(Point2D centerPoint) {
        this.centerPoint = centerPoint;
    }

    public int getRadiusx() {
        return radiusx;
    }

    public void setRadiusx(int radiusx) {
        this.radiusx = radiusx;
    }

    public int getDimMarker10Deg() {
        return dimMarker10Deg;
    }

    public void setDimMarker10Deg(int dimMarker10Deg) {
        this.dimMarker10Deg = dimMarker10Deg;
    }

    public int getDimMarker5Deg() {
        return dimMarker5Deg;
    }

    public void setDimMarker5Deg(int dimMarker5Deg) {
        this.dimMarker5Deg = dimMarker5Deg;
    }

    public int getRadiusy() {
        return radiusy;
    }

    public void setRadiusy(int radiusy) {
        this.radiusy = radiusy;
    }

    public int getMaxRadiusX() {
        return maxRadiusX;
    }

    public void setMaxRadiusX(int maxRadiusX) {
        this.maxRadiusX = maxRadiusX;
    }

    public int getMaxRadiusY() {
        return maxRadiusY;
    }

    public void setMaxRadiusY(int maxRadiusY) {
        this.maxRadiusY = maxRadiusY;
    }


}
