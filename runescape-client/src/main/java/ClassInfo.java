import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("jy")
@Implements("ClassInfo")
public class ClassInfo extends Node {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1006805373
   )
   public int field3740;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1715994357
   )
   public int field3741;
   @ObfuscatedName("i")
   public int[] field3742;
   @ObfuscatedName("j")
   public int[] field3743;
   @ObfuscatedName("f")
   public int[] field3745;
   @ObfuscatedName("z")
   @Export("methods")
   public Method[] methods;
   @ObfuscatedName("m")
   @Export("args")
   public byte[][][] args;
   @ObfuscatedName("c")
   @Export("fields")
   public Field[] fields;
}
