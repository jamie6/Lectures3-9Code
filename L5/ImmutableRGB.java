/*//ASSUME THREAD 1 RUNS
SynchronizedRGB color =
new SynchronizedRGB(0, 0, 0, "Pitch Black");
THEN
int myColorInt = color.getRGB(); //Statement 1
String myColorName = color.getName(); //Statement 2
//PROBLEM IF RAN AS
int myColorInt = color.getRGB(); //T1 -- Statement 1
color.set() //T2 -- Runs the method before T1 statement 2
String myColorName = color.getName(); // T1 -- Statement 2
//colors won't match
//ImmutableRGB --> have them work on it*/
final public class ImmutableRGB {
// Values must be between 0 and 255.
final private int red;
final private int green;
final private int blue;
final private String name;
private void check(int red,
int green,
int blue) {
if (red < 0 || red > 255
|| green < 0 || green > 255
|| blue < 0 || blue > 255) {
throw new IllegalArgumentException();
}
}
public ImmutableRGB(int red,
int green,
int blue,
String name) {
check(red, green, blue);
this.red = red;
this.green = green;
this.blue = blue;
this.name = name;
}
public int getRGB() {
return ((red << 16) | (green << 8) | blue);
}
public String getName() {
return name;
}
public ImmutableRGB invert() {
return new ImmutableRGB(255 - red,
255 - green,
255 - blue,
"Inverse of " + name);
}
}