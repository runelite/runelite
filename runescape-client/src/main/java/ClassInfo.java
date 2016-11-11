import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hb")
@Implements("ClassInfo")
public class ClassInfo extends Node {
   @ObfuscatedName("e")
   public int[] field3178;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 812445727
   )
   public int field3179;
   @ObfuscatedName("l")
   @Export("args")
   public byte[][][] args;
   @ObfuscatedName("g")
   public int[] field3181;
   @ObfuscatedName("n")
   @Export("fields")
   public Field[] fields;
   @ObfuscatedName("u")
   public int[] field3183;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -174244983
   )
   public int field3184;
   @ObfuscatedName("d")
   @Export("methods")
   public Method[] methods;
}
