package search.graphics;

import ilist.IList;
import search.graph.Coordinate;
import search.graph.Node;

import java.util.Observable;

/**
 * Traverses a path of {@link Node}s to be displayed on a {@link View}
 * 
 * @author Kelsey McKenna
 */

public class Traverser extends Observable {
	private Node<Coordinate> currentNode;
	private boolean isRunning = false;
	private boolean destinationReached = false;

	/**
	 * Starts a traversal
	 * 
	 * @param path Path to traverse
	 * @param t Time to sleep
	 */
	public void runTraversal(IList<Node<Coordinate>> path, int t) {
		if (path.isEmpty())
			return;
		else {
			isRunning = true;

			int size = path.size();

			for (int i = 0; i < size; ++i) {
				currentNode = path.get(i);
				setChanged();
				notifyObservers();

				if (i == size - 1)
					setDestinationReached(true);

				try {
					if (i == 0)
						Thread.sleep(1000);
					else
						Thread.sleep(t);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			try {
				setDestinationReached(true);
				Thread.sleep(2000);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}

			setDestinationReached(false);
		}

		isRunning = false;
	}

	private void setDestinationReached(boolean reached) {
		destinationReached = reached;
		setChanged();
		notifyObservers();
	}

	/**
	 * Gets the current {@link Node} in the traversal
	 * 
	 * @return Current {@link Node}
	 */
	public Node<Coordinate> getCurrentNode() {
		return currentNode;
	}

	/**
	 * Gets whether the traversal is running
	 * 
	 * @return true if running
	 */
	public boolean isRunning() {
		return isRunning;
	}

	/**
	 * Gets whether the end has been reached
	 * 
	 * @return true if end reached
	 */
	public boolean endReached() {
		return destinationReached;
	}
}
