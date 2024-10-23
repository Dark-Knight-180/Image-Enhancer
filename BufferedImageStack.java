import java.awt.image.BufferedImage;

public class BufferedImageStack {

	private BufferedImage[] array;
	
	public BufferedImageStack()
	{
		array = new BufferedImage[2];
	}
	
	public void push(BufferedImage image)// if the array is full, clones original array, then puts all values of clone array into a new array double the size of original. If the array is not full, adds an image to the end
	{
		if(getSize() == array.length) { 
			int length = array.length; 
			BufferedImage[] tempArray = array; // temporary array thats a copy of original array
			array = new BufferedImage[length * 2];// creates new array double the size of original
			for(int i = 0; i < tempArray.length; i++) { // runs through the temporary array and adds all values to new array
				array[i] = tempArray[i];
			}
		}
		array[getSize()] = image;// sets the value at the end of array to an image
	}
	public BufferedImage pop()// gets the image at the end of the array, then sets the position to null
	{
		if(isEmpty()) {
			throw new java.util.EmptyStackException();
		}
		BufferedImage TempImage = array[getSize() - 1];// gets the last image in the array
		array[getSize() - 1] = null;// sets last position to null
		return TempImage;
		
	}
	public boolean isEmpty()// uses getSize method to check if the array has any values not null
	{
		if(getSize() == 0) {
			return true;
		}
		return false;
	}
	public BufferedImage get(int index)// returns the image in the array at position index
	{
		if(index >= getSize()) {
			throw new IndexOutOfBoundsException();
		}
		return array[index];
	}
	public int getSize()// runs through the array and returns how many positions aren't set to null
	{
		int count = 0;
		for(int i = 0; i < array.length; i++) {
			if(array[i] != null) {
				count++;
			}
		}
		return count;
	}
	public int getArraySize()// returns array length
	{
		return array.length;
	}
}
