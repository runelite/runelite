import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("jd")
@Implements("ClassInfo")
public class ClassInfo extends Node {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1381696547
   )
   int field3750;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1693504541
   )
   @Export("count")
   int count;
   @ObfuscatedName("t")
   @Export("errorIdentifiers")
   int[] errorIdentifiers;
   @ObfuscatedName("a")
   @Export("type")
   int[] type;
   @ObfuscatedName("s")
   @Export("fields")
   Field[] fields;
   @ObfuscatedName("r")
   @Export("fieldValues")
   int[] fieldValues;
   @ObfuscatedName("v")
   @Export("methods")
   Method[] methods;
   @ObfuscatedName("y")
   @Export("args")
   byte[][][] args;
}
