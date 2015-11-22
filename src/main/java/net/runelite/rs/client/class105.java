package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dt")
public class class105 {
   @ObfuscatedName("v")
   static int[] field1841;
   @ObfuscatedName("f")
   public static int[][] field1842 = new int[128][128];
   @ObfuscatedName("l")
   public static int[][] field1843 = new int[128][128];
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -373303145
   )
   public static int field1844;
   @ObfuscatedName("i")
   public static int[] field1845 = new int[4096];
   @ObfuscatedName("t")
   public static int[] field1848 = new int[4096];
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1623370363
   )
   public static int field1851;

   @ObfuscatedName("j")
   public static void method2411(class166 var0, class166 var1) {
      class39.field903 = var0;
      class177.field2895 = var1;
   }

   @ObfuscatedName("h")
   public static class223 method2415(class166 var0, class166 var1, String var2, String var3) {
      int var4 = var0.method3327(var2);
      int var5 = var0.method3323(var4, var3);
      return class84.method1929(var0, var1, var4, var5);
   }
}
