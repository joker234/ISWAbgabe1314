/**
 * Mit massiver Hilfe von http://docs.oracle.com/javase/tutorial/uiswing/components/table.html
 */

package gui;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;
import java.awt.Dimension;
//import java.awt.Component;
import movieManagement.*;


public class MovieUI extends JPanel {
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
	 * The UI.
	 * @param movMan
	 */
	public MovieUI(MovieManager movMan) {
		super();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		//Create a table with a sorter.
		MovieTableModel model = new MovieTableModel(movMan);
		sorter = new TableRowSorter<MovieTableModel>(model);
		table = new JTable(model);
		table.setRowSorter(sorter);
		table.setPreferredScrollableViewportSize(new Dimension(500, 70)); // What the f*** is magic about these Dimensions
		table.setFillsViewportHeight(true);

		//For the purposes of this example, better to have a single
		//selection.
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		//When selection changes, provide user with row numbers for
		//both view and model.
		
		// These f***ing lines are quite long. Still more readable, than breaking them. And any good editor will break the line where I need it anyway, so gtfo!
		table.getSelectionModel().addListSelectionListener(
				new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent event) {
						int viewRow = table.getSelectedRow();
						if (viewRow < 0) {
							//Selection got filtered away.
							//statusText.setText("");
						} else {
							int modelRow = table.convertRowIndexToModel(viewRow);
							//statusText.setText( String.format("Selected Row in view: %d. " + "Selected Row in model: %d.", viewRow, modelRow));
						}
					}
				}
				);



		//Create a separate form for filterText and statusText
		JPanel form = new JPanel(new SpringLayout());
		//JPanel form = new JPanel();
		JLabel l1 = new JLabel("Filter Text:", SwingConstants.TRAILING);
		form.add(l1);
		filterText = new JTextField();
		//Whenever filterText changes, invoke newFilter.
		filterText.getDocument().addDocumentListener(
				new DocumentListener() {
					public void changedUpdate(DocumentEvent e) {
						newFilter();
					}
					public void insertUpdate(DocumentEvent e) {
						newFilter();
					}
					public void removeUpdate(DocumentEvent e) {
						newFilter();
					}
				});
		l1.setLabelFor(filterText);
		form.add(filterText);
		//JLabel l2 = new JLabel("Status:", SwingConstants.TRAILING);
		//form.add(l2);
		//statusText = new JTextField();
		//l2.setLabelFor(statusText);
		//form.add(statusText);
		//SpringUtilities.makeCompactGrid(form, 2, 2, 6, 6, 6, 6);
		SpringUtilities.makeCompactGrid(form, 1, 2, 6, 6, 6, 6);	// If 6 is considered a magic number, how do Java-developers copulate?
		add(form);


        setUpLanguageColumn(table, table.getColumnModel().getColumn(3));	// Too bad getColumn() uses an Int...


		//Create the scroll pane and add the table to it.
		JScrollPane scrollPane = new JScrollPane(table);

		//Add the scroll pane to this panel.
		add(scrollPane);
	}

	/**
	 * Update the row filter regular expression from the expression in
	 * the text box.
	 */
	private void newFilter() {
		RowFilter<MovieTableModel, Object> rf = null;
		//If current expression doesn't parse, don't update.
		try {
			// We want the filter to search all columns
			//rf = RowFilter.regexFilter(filterText.getText(), 0);
			//rf = RowFilter.regexFilter(filterText.getText(), 1);
			rf = RowFilter.regexFilter(filterText.getText());
		} catch (java.util.regex.PatternSyntaxException e) {
			return;
		}
		sorter.setRowFilter(rf);
	}


	public void setUpLanguageColumn(JTable table, TableColumn languageColumn) {
		//Set up the editor for the language cells.
		JComboBox comboBox = new JComboBox();
		for(Language lang : Language.values())
		{
			comboBox.addItem(lang);
		}
		languageColumn.setCellEditor(new DefaultCellEditor(comboBox));

		//Set up tool tips for the sport cells.
		DefaultTableCellRenderer renderer =
				new DefaultTableCellRenderer();
		renderer.setToolTipText("Click for combo box");
		languageColumn.setCellRenderer(renderer);
	}



	class MovieTableModel extends AbstractTableModel {


		private MovieManager movieManager; // Das ist der aus dem SVN. Ich hab _wirklich_ keine Lust, nochmal einen zu implementieren

		public MovieTableModel(MovieManager manager){
			super();
			this.movieManager=manager;
		}

		//        private Object[][] data = {
		//	    {new Integer(2), "Another Movie", new Integer(120), "Eng", "Really Good", "behind ...", new Boolean(true)},
		//	    {new Integer(3), "Star Wars: A New Hope", new Integer(123), "DE", "The One and Only", "Tunesia and Dant ...", new Boolean(false)},
		//	    {new Integer(4), "Terminator", new Integer(107), "Eng", "", "", new Boolean(true)}
		//       };

		public int getColumnCount() {
			return Movie.getColumnnames().length;
		}

		public int getRowCount() {
			return movieManager.size();
		}

		public String getColumnName(int col) {
			return Movie.getColumnnames()[col];
		}

		public Object getValueAt(int row, int col) {
			return movieManager.getMovie(row).getX(col);
		}

		/*
		 * JTable uses this method to determine the default renderer/
		 * editor for each cell.  If we didn't implement this method,
		 * then the last column would contain text ("true"/"false"),
		 * rather than a check box.
		 */
		public Class getColumnClass(int c) {
			return getValueAt(0, c).getClass();
		}

		/*
		 * Don't need to implement this method unless your table's
		 * editable.
		 */
		public boolean isCellEditable(int row, int col) {
			//Note that the data/cell address is constant,
			//no matter where the cell appears onscreen.
			if (col < 1) {
				return false;
			} else {
				return true;
			}
		}

		/*
		 * Don't need to implement this method unless your table's
		 * data can change.
		 */
		public void setValueAt(Object value, int row, int col) {
			movieManager.getMovie(row).setX(value, col);
			fireTableCellUpdated(row, col);
		}

		private void printDebugData() {
			int numRows = getRowCount();
			int numCols = getColumnCount();

			for (int i=0; i < numRows; i++) {
				System.out.print("    row " + i + ":");
				for (int j=0; j < numCols; j++) {
					//System.out.print("  " + data[i][j]);
				}
				System.out.println();
			}
			System.out.println("--------------------------");
		}
	}

	/**
	 * Create the GUI and show it.  For thread safety,
	 * this method should be invoked from the
	 * event-dispatching thread.
	 */
	private static void createAndShowGUI(MovieManager movieMan) {
		//Create and set up the window.
		JFrame frame = new JFrame("MovieUI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Create and set up the content pane.
		MovieUI newContentPane = new MovieUI(movieMan);
		newContentPane.setOpaque(true); //content panes must be opaque
		frame.setContentPane(newContentPane);

		//Display the window.
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {

		Movie mov0=new Movie("Film0", 97, Language.GER, "great film of foo", Country.GER, "Behind grandmas back");
		Movie mov1=new Movie("Another Movie", 120, Language.EN, "really good", Country.GER, "behind...");
		Movie mov2=new Movie("Star Wars: A New Hope", 123, Language.GER, "the one and only", Country.GER, "tunesia and dant...");
		Movie mov3=new Movie("Terminator", 107, Language.EN, "", Country.GER, "");
		final MovieManager movieMan = new MovieManager();
		movieMan.addMovie(mov0);
		movieMan.addMovie(mov1);
		movieMan.addMovie(mov2);
		movieMan.addMovie(mov3);


		//Schedule a job for the event-dispatching thread:
		//creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI(movieMan);
			}
		});
	}
}
