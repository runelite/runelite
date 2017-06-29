import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("jd")
@Implements("ClassInfo")
public class ClassInfo extends Node {
   @ObfuscatedName("y")
   @Export("args")
   byte[][][] args;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1693504541
   )
   int field3748;
   @ObfuscatedName("a")
   int[] field3749;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1381696547
   )
   int field3750;
   @ObfuscatedName("s")
   @Export("fields")
   Field[] fields;
   @ObfuscatedName("t")
   int[] field3752;
   @ObfuscatedName("v")
   @Export("methods")
   Method[] methods;
   @ObfuscatedName("r")
   int[] field3754;
}
