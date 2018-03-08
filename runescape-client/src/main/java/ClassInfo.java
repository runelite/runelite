import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ln")
@Implements("ClassInfo")
public class ClassInfo extends Node {
   @ObfuscatedName("p")
   @Export("spritePixels")
   static byte[][] spritePixels;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1253341617
   )
   int field3946;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 369667131
   )
   @Export("count")
   int count;
   @ObfuscatedName("i")
   @Export("type")
   int[] type;
   @ObfuscatedName("a")
   @Export("errorIdentifiers")
   int[] errorIdentifiers;
   @ObfuscatedName("l")
   @Export("fields")
   Field[] fields;
   @ObfuscatedName("b")
   int[] field3951;
   @ObfuscatedName("e")
   @Export("methods")
   Method[] methods;
   @ObfuscatedName("x")
   @Export("args")
   byte[][][] args;
}
