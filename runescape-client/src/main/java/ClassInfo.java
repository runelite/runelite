import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hz")
@Implements("ClassInfo")
public class ClassInfo extends Node {
   @ObfuscatedName("g")
   int[] field3238;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -2011381443
   )
   int field3239;
   @ObfuscatedName("j")
   @Export("methods")
   Method[] methods;
   @ObfuscatedName("v")
   int[] field3241;
   @ObfuscatedName("y")
   @Export("fields")
   Field[] fields;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -791437783
   )
   int field3243;
   @ObfuscatedName("p")
   int[] field3244;
   @ObfuscatedName("m")
   @Export("args")
   byte[][][] args;
}
