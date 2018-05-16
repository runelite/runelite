import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lt")
@Implements("ClassInfo")
public class ClassInfo extends Node {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 2094893415
   )
   public int field3758;
   @ObfuscatedName("m")
   @Export("args")
   public byte[][][] args;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1610310061
   )
   @Export("count")
   public int count;
   @ObfuscatedName("b")
   @Export("type")
   public int[] type;
   @ObfuscatedName("f")
   public int[] field3757;
   @ObfuscatedName("n")
   @Export("errorIdentifiers")
   public int[] errorIdentifiers;
   @ObfuscatedName("h")
   @Export("fields")
   public Field[] fields;
   @ObfuscatedName("x")
   @Export("methods")
   public Method[] methods;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Liv;I)V",
      garbageValue = "-288900723"
   )
   public static void method5752(IndexDataBase var0) {
      class265.field3351 = var0;
   }
}
