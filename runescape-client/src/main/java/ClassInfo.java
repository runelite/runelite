import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("lh")
@Implements("ClassInfo")
public class ClassInfo extends Node {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1772899199
   )
   public int field3865;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -362373453
   )
   @Export("count")
   public int count;
   @ObfuscatedName("o")
   @Export("type")
   public int[] type;
   @ObfuscatedName("p")
   @Export("errorIdentifiers")
   public int[] errorIdentifiers;
   @ObfuscatedName("a")
   @Export("fields")
   public Field[] fields;
   @ObfuscatedName("h")
   public int[] field3870;
   @ObfuscatedName("l")
   @Export("methods")
   public Method[] methods;
   @ObfuscatedName("y")
   @Export("args")
   public byte[][][] args;
}
