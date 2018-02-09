import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ku")
@Implements("ClassInfo")
public class ClassInfo extends Node {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1027677803
   )
   int field3865;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 716026281
   )
   @Export("count")
   int count;
   @ObfuscatedName("m")
   @Export("args")
   byte[][][] args;
   @ObfuscatedName("h")
   @Export("type")
   int[] type;
   @ObfuscatedName("i")
   @Export("errorIdentifiers")
   int[] errorIdentifiers;
   @ObfuscatedName("w")
   @Export("fields")
   Field[] fields;
   @ObfuscatedName("t")
   int[] field3866;
   @ObfuscatedName("d")
   @Export("methods")
   Method[] methods;
}
