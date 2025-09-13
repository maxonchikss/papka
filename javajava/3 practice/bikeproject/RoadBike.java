package bikeproject.src.bikeproject;

public class RoadBike extends Bike implements BikeParts{
	
	private int  tyreWidth, postHeight;
	
	public RoadBike()
	{
		this("drop", "racing", "tread less", "razor", 19, 20, 22);
	}//end constructor
	
	public RoadBike(int postHeight)
	{
		this("drop", "racing", "tread less", "razor", 19, 20, postHeight);
	}//end constructor
		
	public RoadBike(String handleBars, String frame, String tyres, String seatType, int numGears,
			int tyreWidth, int postHeight) {
		super(handleBars, frame, tyres, seatType, numGears);
		this.tyreWidth = tyreWidth;
		this.postHeight = postHeight;
	}//end constructor

	// added now
	public void setTyreWidth (int tyreWidth) {this.tyreWidth = tyreWidth;}
	public void setPostHeight (int postHeight) {this.postHeight = postHeight;}
	public int getPostHeight () {return postHeight;}
	public int getTyreWidth () {return tyreWidth;}
	public void printDescription()
	{
		super.printDescription();
		System.out.println("This Roadbike bike has " + this.tyreWidth + "mm tyres and a post height of " + this.postHeight + ".");
	}//end method printDescription
}//end class RoadBike
