/* OutOfRangeException
 * Wayne Cook
 * 27 March 2023
 * Purpose:
 *          Provides a way to throw an exception if input is out of the acceptable range of values.
 */
public class OutOfRangeException extends Exception{
    public OutOfRangeException(String message) {
            super(message);
    }
}
