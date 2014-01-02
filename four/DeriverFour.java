/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package deriver.four;

/**
 *
 * @author jamesthomas
 * 
 * FIX SIMP BY MAKING IT ACTUALLY NEST EVEN IF NOT CHANGING ON THAT LEVEL
 */
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;

public class DeriverFour extends JApplet{
	
	public static DeriverFour window;
	
	private JTextField equation;
	private Function function;
	private JButton graph;
	
	private JButton derive;
	private Function derivative;
	private JTextField derivativeResult;
	
	private GraphPlot plot;
	
	private JTextField x0;
	private JTextField xScale;
	private JTextField y0;
	private JTextField yScale;
	
	
	public Displayable.Scale scale;
	
	public DeriverFour(){
		this.setSize(802,560);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setLocationRelativeTo(null);
		//this.setTitle("Deriver and Grapher");
		
		this.setLayout( new BorderLayout(0,10) );
		
		JPanel northContainer = new JPanel ();
		northContainer.setLayout( new BoxLayout(northContainer, BoxLayout.Y_AXIS));
		
			JPanel equationContainer = new JPanel();
				equationContainer.add( new JLabel("Equation") );

				equation = new JTextField("x^x",30);
				equationContainer.add( equation );

				GraphListener hasGraphed = new GraphListener();
				graph = new JButton( "Graphaph" );
				graph.addActionListener( hasGraphed );
				equationContainer.add(graph);
			northContainer.add(equationContainer);
			
			JPanel deriveContainer = new JPanel();
				DeriveListener hasDerived = new DeriveListener();
				derive = new JButton("Deriveive");
				derive.addActionListener( hasDerived );
				deriveContainer.add(derive);

				deriveContainer.add( new JLabel("Derivative: ") );

				derivativeResult = new JTextField(30);
				deriveContainer.add(derivativeResult);
			northContainer.add( deriveContainer );
			
		this.add(northContainer, BorderLayout.NORTH);
			
		JPanel scaleContainer = new JPanel();
			scaleContainer.add( new JLabel("X center:") );
				x0 = new JTextField("1", 5);
				scaleContainer.add( x0 );
			scaleContainer.add( new JLabel("X scale:") );
				xScale = new JTextField("100", 5);
				scaleContainer.add( xScale );
			scaleContainer.add( new JLabel("Y center:") );
				y0 = new JTextField("1", 5);
				scaleContainer.add( y0 );
			scaleContainer.add( new JLabel("Y scale:") );
				yScale = new JTextField("100", 5);
				scaleContainer.add( yScale );
		this.add(scaleContainer, BorderLayout.SOUTH );
		
		this.setVisible(true);
	}
	
	private class GraphPlot extends JComponent {
		@Override
		public void paint(Graphics g){
			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint( RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			
			scale = new Displayable.Scale(
					Double.parseDouble(window.x0.getText()), 
					Double.parseDouble(window.xScale.getText()), 
					Double.parseDouble(window.y0.getText()), 
					Double.parseDouble(window.yScale.getText()) );
			
			g2.draw(scale.xAxis());
			g2.draw(scale.yAxis());
			g2.draw( new Rectangle2D.Double(0,0,800,400) );
			
			Shape seg;
			for( double x = scale.minX(); x<=scale.maxX(); x+= scale.deltaX()){
				seg = function.getSegment(x, x+0.01);
				g2.draw(seg);
			}
			
			g2.setPaint(Color.BLACK);
		}
	}
	
	private class DerivePlot extends JComponent {
		@Override
		public void paint( Graphics g){
			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint( RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			
			scale = new Displayable.Scale(
					Double.parseDouble(window.x0.getText()), 
					Double.parseDouble(window.xScale.getText()), 
					Double.parseDouble(window.y0.getText()), 
					Double.parseDouble(window.yScale.getText()) );
			
			g2.draw(scale.xAxis());
			g2.draw(scale.yAxis());
			g2.draw( new Rectangle2D.Double(0,0,800,400) );
			
			Shape seg;
			for( double x = scale.minX(); x<=scale.maxX(); x+= scale.deltaX()){
				seg = derivative.getSegment(x, x+0.01);
				g2.draw(seg);
			}
			
			g2.setPaint(Color.BLACK);
		}
	}
	
	private class GraphListener implements ActionListener {
		@Override
		public void actionPerformed( ActionEvent event){
			
			function = new Function( window.equation.getText() );
			
			plot = new GraphPlot();
			
			window.add( plot, BorderLayout.CENTER);
			window.setVisible(true);
			
			
			Expression equation = new Expression( window.equation.getText()  );
			Expression simp = Simplify.mod(equation);
			Expression doubleSimp = Simplify.mod(simp);
			
		}
	}
	
	private class DeriveListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			
			function = new Function( window.equation.getText() );
			
			derivative = new Function( Simplify.mod( Derive.mod( function.function ) ) );
			
			DerivePlot der = new DerivePlot();
			
			window.add( der, BorderLayout.CENTER);
			window.derivativeResult.setText(derivative.function.getString());
			window.setVisible(true);
		}
	}
	
	public static void main(String[] args) {
		
		window = new DeriverFour();
		
	}
	
	@Override
	public void init(){
		window = new DeriverFour();
	}
}