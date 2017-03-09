import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ht")
@Implements("ClassInfo")
public class ClassInfo extends Node {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -239758749
   )
   public int field3238;
   @ObfuscatedName("c")
   public int[] field3239;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1011158707
   )
   public int field3240;
   @ObfuscatedName("d")
   public int[] field3241;
   @ObfuscatedName("w")
   @Export("fields")
   public Field[] fields;
   @ObfuscatedName("h")
   public int[] field3243;
   @ObfuscatedName("u")
   @Export("methods")
   public Method[] methods;
   @ObfuscatedName("k")
   @Export("args")
   public byte[][][] args;
}
