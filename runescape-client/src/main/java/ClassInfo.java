import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hp")
@Implements("ClassInfo")
public class ClassInfo extends Node {
   @ObfuscatedName("h")
   int[] field3220;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1354551801
   )
   int field3221;
   @ObfuscatedName("r")
   @Export("fields")
   Field[] fields;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -849198321
   )
   int field3223;
   @ObfuscatedName("w")
   int[] field3224;
   @ObfuscatedName("c")
   int[] field3225;
   @ObfuscatedName("p")
   @Export("methods")
   Method[] methods;
   @ObfuscatedName("m")
   @Export("args")
   byte[][][] args;
}
