import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hr")
@Implements("ClassInfo")
public class ClassInfo extends Node {
   @ObfuscatedName("u")
   @Export("methods")
   Method[] methods;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1319573619
   )
   int field3257;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1184461893
   )
   int field3258;
   @ObfuscatedName("q")
   int[] field3259;
   @ObfuscatedName("t")
   @Export("fields")
   Field[] fields;
   @ObfuscatedName("p")
   int[] field3261;
   @ObfuscatedName("z")
   @Export("args")
   byte[][][] args;
   @ObfuscatedName("n")
   int[] field3263;
}
