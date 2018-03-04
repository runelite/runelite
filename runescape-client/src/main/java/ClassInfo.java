import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("lu")
@Implements("ClassInfo")
public class ClassInfo extends Node {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1049068169
   )
   int field3947;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1010387719
   )
   @Export("count")
   int count;
   @ObfuscatedName("n")
   @Export("type")
   int[] type;
   @ObfuscatedName("r")
   @Export("errorIdentifiers")
   int[] errorIdentifiers;
   @ObfuscatedName("e")
   @Export("fields")
   Field[] fields;
   @ObfuscatedName("y")
   int[] field3946;
   @ObfuscatedName("k")
   @Export("methods")
   Method[] methods;
   @ObfuscatedName("s")
   @Export("args")
   byte[][][] args;
}
