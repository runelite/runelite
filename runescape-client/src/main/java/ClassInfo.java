import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hu")
@Implements("ClassInfo")
public class ClassInfo extends Node {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -2118978699
   )
   int field3220;
   @ObfuscatedName("g")
   int[] field3221;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1960788357
   )
   int field3222;
   @ObfuscatedName("h")
   int[] field3223;
   @ObfuscatedName("v")
   @Export("fields")
   Field[] fields;
   @ObfuscatedName("l")
   int[] field3225;
   @ObfuscatedName("c")
   @Export("methods")
   Method[] methods;
   @ObfuscatedName("m")
   @Export("args")
   byte[][][] args;
}
