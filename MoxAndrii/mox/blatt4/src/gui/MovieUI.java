/**
 * Mit massiver Hilfe von http://docs.oracle.com/javase/tutorial/uiswing/components/table.html
 */

package gui;

//{{{
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;

//import java.awt.Component;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import movieManagement.MovieManager;
import movieManagement.Movie;
import movieManagement.Language;
import movieManagement.Country;
//}}}

//{{{
public class MovieUI extends JPanel
{
	//{{{ Fields

	private static final long serialVersionUID = 8337140465783469323L;
	/**
	 * The Table that is displayed
	 */
	private JTable table;

	/**
	 * Some damn text field
	 */
	private JTextField filterText;
	//private JTextField statusText;
	/**
	 * The Sorter.
	 */
	private TableRowSorter<MovieTableModel> sorter;

	/**
	 *
	 */
	private int theKlickedRow;
	public void setTheklickedRow(int x) {this.theKlickedRow=x;}
	public int getTheKlickedRow()		{return this.theKlickedRow;}
	//}}}



	//{{{public MovieUI(MovieManager movMan)
	/**
	 * The UI.
	 * @param movMan
	 */
	public MovieUI(MovieManager movMan)
	{
		super();
		//this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setLayout(new GridBagLayout());


		//Create a separate form for filterText and add button
		JPanel form = new JPanel(new BorderLayout());
		//form.setPreferredSize(new Dimension(50,50));
		//System.out.println(form.getPreferredSize());

		JLabel l1 = new JLabel("Filter:", SwingConstants.TRAILING);
		form.add(l1, BorderLayout.LINE_START);

		filterText = new JTextField();
		//Whenever filterText changes, invoke newFilter.
		filterText.getDocument().addDocumentListener(
		    new DocumentListener()
		    {
		        public void changedUpdate(DocumentEvent e)
		        {
		            newFilter();
				}
		        public void insertUpdate(DocumentEvent e)
		        {
		            newFilter();
				}
		        public void removeUpdate(DocumentEvent e)
		        {
		            newFilter();
				}
			});
		l1.setLabelFor(filterText);
		form.add(filterText, BorderLayout.CENTER);

		// Create a button to add a movie
		final JButton addMovieButton=new JButton("Add Movie");
		ActionListener addMovieButtonListener = new ActionListener()
		{
            public void actionPerformed(java.awt.event.ActionEvent e) {
					((MovieTableModel) table.getModel()).addRow(new Movie("", 0, null, "", null, ""));
            }
        };
		addMovieButton.addActionListener(addMovieButtonListener);



		form.add(addMovieButton, BorderLayout.LINE_END);

		// Add the filter and add button to the Window
		//GridBagConstraints forConstraints = new GridBagConstraints(int gridx, int gridy, int gridwidth, int gridheight, double weightx, double weighty, int anchor, int fill, Insets insets, int ipadx, int ipady)
		GridBagConstraints formConstraints = new GridBagConstraints(0, 0, 1, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0,0,0,0), 0, 0);
		this.add(form, formConstraints);





		//Create a table with a sorter.
		MovieTableModel model = new MovieTableModel(movMan);
		sorter = new TableRowSorter<MovieTableModel>(model);
		table = new JTable(model);
		table.setRowSorter(sorter);
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));	// What the f*** is magic about these Dimensions
		table.setFillsViewportHeight(true);

		//For the purposes of this example, better to have a single selection.
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


		// Make sure there is a dropdown menu for the Language
		setUpLanguageColumn(table, table.getColumnModel().getColumn(3));	// Too bad getColumn() uses an Int...



		// add a context menu
		final JPopupMenu popup=new JPopupMenu();

		//popup.add(new AbstractAction( "Neu", new ImageIcon(getClass().getResource("t1.gif"))) {
		popup.add(new AbstractAction("Add Movie") {
			private static final long serialVersionUID = 5361006102656830997L;
			public void actionPerformed (ActionEvent e) {
				addMovieButton.doClick(); // just klick the button to remove redundant code
			}
		});
		popup.add(new AbstractAction("Delete Movie") {
			private static final long serialVersionUID = -6036550663338377816L;
			public void actionPerformed (ActionEvent e) {
				((MovieTableModel) table.getModel()).removeRow(getTheKlickedRow());
			}
		});




		MouseAdapter foo = new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent e) {
				if(e.getButton()==3)
				{
					setTheklickedRow(table.rowAtPoint(e.getPoint()));
					popup.show(e.getComponent(), e.getX(), e.getY());
				}
			}
		};

		table.addMouseListener(foo);

		//Create the scroll pane and add the table to it.
		JScrollPane scrollPane = new JScrollPane(table);

		//Add the scroll pane to this panel.
		//new GridBagConstraints(int gridx, int gridy, int gridwidth, int gridheight, double weightx, double weighty, int anchor, int fill, Insets insets, int ipadx, int ipady)
		GridBagConstraints tableConstraints = new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0,0,0,0), 0, 0);
		this.add(scrollPane, tableConstraints);
	}
	//}}}

	//{{{private void newFilter()
	/**
	 * Update the row filter regular expression from the expression in
	 * the text box.
	 */
	private void newFilter()
	{
		RowFilter<MovieTableModel, Object> rf = null;
		//If current expression doesn't parse, don't update.
		try {
			// We want the filter to search all columns
			rf = RowFilter.regexFilter(filterText.getText(), 1);	// Just search the title column
			//rf = RowFilter.regexFilter(filterText.getText());		// search all columns
		} catch(java.util.regex.PatternSyntaxException e)
		{
			return;
		}
		sorter.setRowFilter(rf);
	}
	//}}}

	//{{{public void setUpLanguageColumn(JTable table, TableColumn languageColumn)
	//
	public void setUpLanguageColumn(JTable table, TableColumn languageColumn)
	{
		//Set up the editor for the language cells.
		JComboBox<Language> comboBox = new JComboBox<Language>();
		for(Language lang : Language.values())
		{
			comboBox.addItem(lang);
		}
		languageColumn.setCellEditor(new DefaultCellEditor(comboBox));

		//Set up tool tips for the sport cells.
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		renderer.setToolTipText("Click for combo box");
		languageColumn.setCellRenderer(renderer);
	}
	//}}}



	//{{{class MovieTableModel extends AbstractTableModel
	//
	class MovieTableModel extends AbstractTableModel
	{
		private static final long serialVersionUID = 8432482343250491449L;
		private MovieManager movieManager;	// Das ist der aus dem SVN. Ich hab _wirklich_ keine Lust, nochmal einen zu implementieren

		//{{{
		public MovieTableModel(MovieManager manager)
		{
			super();
			this.movieManager=manager;
		}
		//}}}

		//{{{
		public int getColumnCount()
		{
			return Movie.getColumnnames().length;
		}
		//}}}

		//{{{
		public int getRowCount()
		{
			return movieManager.size();
		}
		//}}}

		//{{{
		public String getColumnName(int col)
		{
			return Movie.getColumnnames()[col];
		}
		//}}}

		//{{{
		public Object getValueAt(int row, int col)
		{
			return movieManager.getMovie(row).getX(col);
		}
		//}}}

		//{{{ public Class getColumnClass(int c)
		/*
		 * JTable uses this method to determine the default renderer/
		 * editor for each cell.  If we didn't implement this method,
		 * then the last column would contain text ("true"/"false"),
		 * rather than a check box.
		 */
		public Class getColumnClass(int c)
		{
			return getValueAt(0, c).getClass();
		}
		//}}}

		//{{{
		public boolean isCellEditable(int row, int col)
		{
			//Note that the data/cell address is constant,
			//no matter where the cell appears onscreen.
			if (col < 1)
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		//}}}

		//{{{
		public void setValueAt(Object value, int row, int col)
		{
			//System.out.println("public void setValueAt(Object value: " + value + ", int row: " +row+ ", int col: " + col + ")");
			movieManager.getMovie(row).setX(value, col);
			fireTableCellUpdated(row, col);
		}
		//}}}


		//{{{
		public void addRow(Movie movie)
		{
			movieManager.addMovie(movie);
			//System.out.println(movieManager.size());
			//this.fireTableDataChanged();
			this.fireTableRowsInserted(movieManager.size()-1, movieManager.size()-1);
		}
		//}}}

		//{{{
		public void removeRow(int row)
		{
			movieManager.removeMovie(row);
			this.fireTableRowsDeleted(row, row);
		}
		//}}}


	}
	//}}}

	//{{{private static void createAndShowGUI(MovieManager movieMan)
	/*
	 * Create the GUI and show it.  For thread safety,
	 * this method should be invoked from the
	 * event-dispatching thread.
	 */
	private static void createAndShowGUI(MovieManager movieMan)
	{
		//Create and set up the window.
		JFrame frame = new JFrame("MovieUI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Create and set up the content pane.
		MovieUI newContentPane = new MovieUI(movieMan);
		newContentPane.setOpaque(true);	//content panes must be opaque
		frame.setContentPane(newContentPane);

		//Display the window.
		frame.pack();
		frame.setVisible(true);
	}
	//}}}

	//{{{public static void main(String[] args)
	//
	public static void main(String[] args)
	{
		// Create some example Movies
		//Movie mov0=new Movie("Film0", 97, Language.GER, "great film of foo", Country.GER, "Behind grandmas back");
		//Movie mov1=new Movie("Another Movie", 120, Language.EN, "really good", Country.GER, "behind...");
		//Movie mov2=new Movie("Star Wars: A New Hope", 123, Language.GER, "the one and only", Country.GER, "tunesia and dant...");
		//Movie mov3=new Movie("Terminator", 107, Language.EN, "", Country.GER, "");
		final MovieManager movieMan = new MovieManager();
		movieMan.loadMovies();
		//movieMan.addMovie(mov0);
		//movieMan.addMovie(mov1);
		//movieMan.addMovie(mov2);
		//movieMan.addMovie(mov3);
		//movieMan.saveMovies();


		//Schedule a job for the event-dispatching thread:
		//creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() { public void run() { createAndShowGUI(movieMan); } });
	}
	//}}}
}
//}}}
