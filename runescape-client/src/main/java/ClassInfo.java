import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("jf")
@Implements("ClassInfo")
public class ClassInfo extends Node {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1472756127
   )
   int field3737;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1184574139
   )
   @Export("count")
   int count;
   @ObfuscatedName("u")
   @Export("errorIdentifiers")
   int[] errorIdentifiers;
   @ObfuscatedName("i")
   @Export("type")
   int[] type;
   @ObfuscatedName("g")
   @Export("fields")
   Field[] fields;
   @ObfuscatedName("s")
   @Export("fieldValues")
   int[] fieldValues;
   @ObfuscatedName("x")
   @Export("methods")
   Method[] methods;
   @ObfuscatedName("m")
   @Export("args")
   byte[][][] args;
}
