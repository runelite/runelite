import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("jc")
@Implements("ClassInfo")
public class ClassInfo extends Node {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 2068248585
   )
   int field3758;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1958834467
   )
   @Export("count")
   int count;
   @ObfuscatedName("q")
   @Export("type")
   int[] type;
   @ObfuscatedName("o")
   @Export("errorIdentifiers")
   int[] errorIdentifiers;
   @ObfuscatedName("g")
   @Export("fields")
   Field[] fields;
   @ObfuscatedName("v")
   int[] field3762;
   @ObfuscatedName("p")
   @Export("methods")
   Method[] methods;
   @ObfuscatedName("e")
   @Export("args")
   byte[][][] args;
}
