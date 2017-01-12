import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hi")
@Implements("ClassInfo")
public class ClassInfo extends Node {
   @ObfuscatedName("i")
   public int[] field3219;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -270073897
   )
   public int field3220;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1385081285
   )
   public int field3221;
   @ObfuscatedName("a")
   public int[] field3222;
   @ObfuscatedName("cy")
   static class102 field3223;
   @ObfuscatedName("f")
   public int[] field3224;
   @ObfuscatedName("d")
   @Export("methods")
   public Method[] methods;
   @ObfuscatedName("l")
   @Export("args")
   public byte[][][] args;
   @ObfuscatedName("c")
   @Export("fields")
   public Field[] fields;
}
