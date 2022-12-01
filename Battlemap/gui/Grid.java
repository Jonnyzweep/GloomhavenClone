package com.mycompany.gloomhaven.Battlemap.gui;

import com.mycompany.gloomhaven.Battlemap.elements.World;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class Grid extends JPanel {
	World world;


	private int rectWidth;
	private int rectHeight;
	private int HEXSIZE = 30;
	private boolean isPointyTop = true;

	private static BufferedImage bi;

	public Grid(World startWorld) {
		this.world = startWorld;
	}

	@Override
	public Dimension getPreferredSize() {
		Dimension d = new Dimension(world.getSizeX() * 70, world.getSizeY() * 65);
		return d;
	}

	/**
	 * Method for calculating the six corners (edges) of a Hexagon.<br>
	 * Takes the x/y coordinate of the centre, and the size of the Hex<br>
	 * For every corner, do the math and return the x,y coordinates<br>
	 * Returns the size corners (edges)
	 */
	public int[][] calculateHexEdges(int centrex, int centrey, int size) {
		int[] centre = { centrex, centrey };
		int[][] edges = new int[2][6];

		for (int corner = 0; corner < 6; corner++) {
			double angle_degree;
			if (isPointyTop) {
				angle_degree = 60 * corner + 30;
			} else {
				angle_degree = 60 * corner;
			}
			double angle_radius = Math.PI / 180 * angle_degree;
			edges[0][corner] = (int) (centre[0] + size * Math.cos(angle_radius));
			edges[1][corner] = (int) (centre[1] + size * Math.sin(angle_radius));

		}
		return edges;
	}

	/**
	 * Method for calculating the pixel centre of a Hex.<br>
	 * Take x and y coordinate, and the size<br>
	 * Calculate height, width. From there, calculate the centre position.<br>
	 * (!) even-odd-even-odd row structure<br>
	 * Returns the new coordinates in double[2]
	 */
	public double[] calculatePixelHexCentre(int ax, int ay, int size) {
		double h;
		double w;
		double[] newcoords = new double[2];

		if (isPointyTop) {
			h = size * 2; // height
			w = Math.sqrt(3) / 2 * h; // width
			newcoords[0] = w + ax * w; // horizontal distance
			newcoords[1] = h + ay * ((3.0 / 4.0) * h); // vertical distance
			if (ay % 2 == 1) { // this checks for odd/even: if odd, offset 2nd, 4th,...
				newcoords[0] = newcoords[0] + (w / 2);
			}

		} else {
			h = Math.sqrt(3) * size;
			w = 2 * size;
			newcoords[0] = w + ax * ((3.0 / 4.0) * w); // horizontal distance
			newcoords[1] = h + ay * (h); // vertical distance
			if (ax % 2 == 0) { //here we want the x instead of the y
				newcoords[1] = newcoords[1] + (h / 2);
			}

		}

		return newcoords;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		drawHexGrid(g2d, world, HEXSIZE);
	}

	private void drawHexGrid(Graphics2D g, World world, int size) {

		for (int i = 0; i < world.getSizeX(); i++) {
			for (int j = 0; j < world.getSizeY(); j++) {
				double[] centres = calculatePixelHexCentre(i, j, size);
				int[][] edges = calculateHexEdges((int) centres[0], (int) centres[1], size);
				Polygon poly = new Polygon(edges[0], edges[1], 6);





				if (world.getHex(i, j).getType() == 5)
				{
					if(world.getHex(i, j).getName() == 0) {
						try {
							bi = ImageIO.read(new File("Battlemap/images/logs.png"));
						} catch (IOException e) {
							throw new RuntimeException(e);
						}
					}
					g.drawImage(bi, ((((int) centres[0])) - 10), (((int) centres[1]) - 10), 20, 20, null);
					g.setColor(Color.pink);
					g.drawPolygon(poly);
				}

				else if (world.getHex(i, j).getType() == 6)
				{
					if(world.getHex(i, j).getName() == 0) {
						try {
							bi = ImageIO.read(new File("Battlemap/images/Bush.png"));
						} catch (IOException e) {
							throw new RuntimeException(e);
						}
						g.drawImage(bi, ((((int) centres[0])) - 15), (((int) centres[1]) - 15), 30, 30, null);
						g.setColor(Color.green);
						g.drawPolygon(poly);
					}
					else if(world.getHex(i, j).getName() == 1) {
						try {
							bi = ImageIO.read(new File("Battlemap/images/tree.png"));
						} catch (IOException e) {
							throw new RuntimeException(e);
						}
						g.drawImage(bi, ((((int) centres[0])) - 24), (((int) centres[1]) - 24), 48, 48, null);
						g.setColor(Color.green);
						g.drawPolygon(poly);
					}



				}


				else if (world.getHex(i, j).getType() == 7)
				{
					if(world.getHex(i, j).getName() == 0) {
						try {
							bi = ImageIO.read(new File("Battlemap/images/chest.png"));
						} catch (IOException e) {
							throw new RuntimeException(e);
						}
					}
					g.drawImage(bi, ((((int) centres[0])) - 19), (((int) centres[1]) - 19), 40, 40, null);
					g.setColor(Color.yellow);
					g.drawPolygon(poly);
				}


				else if (world.getHex(i, j).getType() == 8)
				{
					if(world.getHex(i, j).getName() == 0) {
						try {
							bi = ImageIO.read(new File("Battlemap/images/harrower-infester.png"));
						} catch (IOException e) {
							throw new RuntimeException(e);
						}
					}
					else if(world.getHex(i, j).getName() == 1) {
						try {
							bi = ImageIO.read(new File("Battlemap/images/forest-imp.png"));
						} catch (IOException e) {
							throw new RuntimeException(e);
						}
					}
					else if(world.getHex(i, j).getName() == 2) {
						try {
							bi = ImageIO.read(new File("Battlemap/images/earth-demon.png"));
						} catch (IOException e) {
							throw new RuntimeException(e);
						}
					}

					g.drawImage(bi, ((((int) centres[0])) - 32), (((int) centres[1]) - 32), 65, 65, null);
					g.setColor(Color.red);
					g.drawPolygon(poly);
				}

				else if (world.getHex(i, j).getType() == 20)
				{
					// does nothing so no hex is made at certian coords

				}



				else {
					g.setColor(Color.black);
					g.drawPolygon(poly);
					g.setColor(Color.lightGray);
					g.fillPolygon(poly);
				}

			}
		}
	}

	public int getGridWidth() {
		return rectWidth;
	}

	public int getGridHeight() {
		return rectHeight;
	}
	public class TexturePaintDemo extends JPanel {
		public void init() {
			setBackground(Color.white);
		}

}
}

