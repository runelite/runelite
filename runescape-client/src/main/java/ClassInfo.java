import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hx")
@Implements("ClassInfo")
public class ClassInfo extends Node {
   @ObfuscatedName("d")
   @Export("fields")
   public Field[] fields;
   @ObfuscatedName("k")
   public int[] field3220;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1803372799
   )
   public int field3221;
   @ObfuscatedName("q")
   public int[] field3222;
   @ObfuscatedName("x")
   public int[] field3224;
   @ObfuscatedName("j")
   @Export("methods")
   public Method[] methods;
   @ObfuscatedName("s")
   @Export("args")
   public byte[][][] args;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1640565193
   )
   public int field3227;
}
