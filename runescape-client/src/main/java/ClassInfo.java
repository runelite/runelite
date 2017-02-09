import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hk")
@Implements("ClassInfo")
public class ClassInfo extends Node {
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1226705741
   )
   public int field3220;
   @ObfuscatedName("w")
   @Export("fields")
   public Field[] fields;
   @ObfuscatedName("q")
   @Export("methods")
   public Method[] methods;
   @ObfuscatedName("r")
   public int[] field3223;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1810313731
   )
   public int field3224;
   @ObfuscatedName("j")
   public int[] field3225;
   @ObfuscatedName("o")
   public int[] field3226;
   @ObfuscatedName("d")
   @Export("args")
   public byte[][][] args;
}
