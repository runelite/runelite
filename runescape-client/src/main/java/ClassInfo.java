import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("kl")
@Implements("ClassInfo")
public class ClassInfo extends Node {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 581520761
   )
   int field3793;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1662462171
   )
   @Export("count")
   int count;
   @ObfuscatedName("r")
   @Export("type")
   int[] type;
   @ObfuscatedName("g")
   @Export("errorIdentifiers")
   int[] errorIdentifiers;
   @ObfuscatedName("x")
   @Export("fields")
   Field[] fields;
   @ObfuscatedName("f")
   int[] field3797;
   @ObfuscatedName("u")
   @Export("methods")
   Method[] methods;
   @ObfuscatedName("t")
   @Export("args")
   byte[][][] args;
}
