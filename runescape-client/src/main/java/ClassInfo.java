import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hd")
@Implements("ClassInfo")
public class ClassInfo extends Node {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1416975283
   )
   int field3219;
   @ObfuscatedName("g")
   int[] field3220;
   @ObfuscatedName("k")
   int[] field3221;
   @ObfuscatedName("q")
   @Export("args")
   byte[][][] args;
   @ObfuscatedName("n")
   @Export("fields")
   Field[] fields;
   @ObfuscatedName("f")
   int[] field3224;
   @ObfuscatedName("a")
   @Export("methods")
   Method[] methods;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 342143237
   )
   int field3226;
}
