import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("jz")
@Implements("ClassInfo")
public class ClassInfo extends Node {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1604389559
   )
   int field3745;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1606776473
   )
   @Export("count")
   int count;
   @ObfuscatedName("r")
   @Export("errorIdentifiers")
   int[] errorIdentifiers;
   @ObfuscatedName("n")
   @Export("type")
   int[] type;
   @ObfuscatedName("v")
   @Export("fields")
   Field[] fields;
   @ObfuscatedName("e")
   @Export("fieldValues")
   int[] fieldValues;
   @ObfuscatedName("l")
   @Export("methods")
   Method[] methods;
   @ObfuscatedName("s")
   @Export("args")
   byte[][][] args;
}
