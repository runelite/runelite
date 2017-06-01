import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("jm")
@Implements("ClassInfo")
public class ClassInfo extends Node {
   @ObfuscatedName("y")
   int[] field3741;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 528403861
   )
   int field3742;
   @ObfuscatedName("e")
   int[] field3743;
   @ObfuscatedName("v")
   int[] field3744;
   @ObfuscatedName("b")
   @Export("fields")
   Field[] fields;
   @ObfuscatedName("h")
   @Export("methods")
   Method[] methods;
   @ObfuscatedName("x")
   @Export("args")
   byte[][][] args;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1369611539
   )
   int field3749;
}
