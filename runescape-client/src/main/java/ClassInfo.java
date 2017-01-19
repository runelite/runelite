import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ha")
@Implements("ClassInfo")
public class ClassInfo extends Node {
   @ObfuscatedName("g")
   @Export("fields")
   Field[] fields;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1133008715
   )
   int field3223;
   @ObfuscatedName("a")
   int[] field3224;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1264111645
   )
   int field3225;
   @ObfuscatedName("h")
   int[] field3226;
   @ObfuscatedName("f")
   int[] field3227;
   @ObfuscatedName("k")
   @Export("methods")
   Method[] methods;
   @ObfuscatedName("u")
   @Export("args")
   byte[][][] args;
}
