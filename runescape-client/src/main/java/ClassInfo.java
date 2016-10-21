import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hg")
@Implements("ClassInfo")
public class ClassInfo extends Node {
   @ObfuscatedName("v")
   int[] field3168;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1275176959
   )
   int field3169;
   @ObfuscatedName("t")
   int[] field3170;
   @ObfuscatedName("b")
   @Export("fields")
   Field[] fields;
   @ObfuscatedName("m")
   @Export("args")
   byte[][][] args;
   @ObfuscatedName("f")
   int[] field3173;
   @ObfuscatedName("k")
   @Export("methods")
   Method[] methods;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1963142355
   )
   int field3175;
}
