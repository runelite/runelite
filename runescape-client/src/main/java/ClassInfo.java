import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("je")
@Implements("ClassInfo")
public class ClassInfo extends Node {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1393259973
   )
   int field3730;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 553058725
   )
   @Export("count")
   int count;
   @ObfuscatedName("y")
   @Export("errorIdentifiers")
   int[] errorIdentifiers;
   @ObfuscatedName("x")
   @Export("type")
   int[] type;
   @ObfuscatedName("e")
   @Export("fields")
   Field[] fields;
   @ObfuscatedName("f")
   @Export("fieldValues")
   int[] fieldValues;
   @ObfuscatedName("v")
   @Export("methods")
   Method[] methods;
   @ObfuscatedName("t")
   @Export("args")
   byte[][][] args;
}
