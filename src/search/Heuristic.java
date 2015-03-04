package search;

@Deprecated
public interface Heuristic<A> {
	/**
	 * Calculate Heuristic function from current to the end Heuristic object
	 * 
	 * @param goal First Heuristic object to calculate the Cost function from
	 */
	void setHeuristic(float heuristic);
	/**
	 * Gets the Heuristic function value
	 * 
	 * @return Heuristic value
	 */
	float getHeuristic();
	/**
	 * Sets the Cost value
	 * 
	 * @param cost The Cost value
	 */
	void setCost(float cost);
	/**
	 * Gets the Cost function value
	 * 
	 * @return Cost value
	 */
	float getCost();

	/**
	 * Gets Cost function + Heuristic function
	 * 
	 * @return Cost + Heuristic
	 */
	float getF();
}