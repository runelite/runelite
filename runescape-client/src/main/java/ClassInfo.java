import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("he")
@Implements("ClassInfo")
public class ClassInfo extends Node {
   @ObfuscatedName("v")
   int[] field3177;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1317469579
   )
   int field3178;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 174042017
   )
   int field3179;
   @ObfuscatedName("n")
   @Export("methods")
   Method[] methods;
   @ObfuscatedName("z")
   @Export("fields")
   Field[] fields;
   @ObfuscatedName("t")
   int[] field3182;
   @ObfuscatedName("r")
   int[] field3183;
   @ObfuscatedName("i")
   @Export("args")
   byte[][][] args;
}
