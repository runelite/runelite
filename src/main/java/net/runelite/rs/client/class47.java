package net.runelite.rs.client;

import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ad")
public class class47 extends class203 {
   @ObfuscatedName("j")
   public static class166 field1046;
   @ObfuscatedName("m")
   public static class192 field1047 = new class192(64);
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1311527023
   )
   public int field1048;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1741540865
   )
   public int field1050;
   @ObfuscatedName("dv")
   static int[] field1051;
   @ObfuscatedName("da")
   @ObfuscatedGetter(
      intValue = -1084232987
   )
   @Export("baseX")
   static int field1053;
   @ObfuscatedName("z")
   public static class171 field1054;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 760131573
   )
   public int field1057;

   @ObfuscatedName("m")
   void method1018(class118 var1) {
      while(true) {
         int var2 = var1.method2536();
         if(0 == var2) {
            return;
         }

         this.method1026(var1, var2);
      }
   }

   @ObfuscatedName("r")
   static final int method1022(int var0, int var1) {
      int var2 = var1 * 57 + var0;
      var2 ^= var2 << 13;
      int var3 = 1376312589 + (789221 + var2 * var2 * 15731) * var2 & Integer.MAX_VALUE;
      return var3 >> 19 & 255;
   }

   @ObfuscatedName("j")
   public static final boolean method1024(String var0, String var1, String var2, String var3) {
      return var0 != null && var2 != null?(!var0.startsWith("#") && !var2.startsWith("#")?var1.equals(var3):var0.equals(var2)):false;
   }

   @ObfuscatedName("j")
   static int method1025(int var0, int var1) {
      class15 var2 = (class15)class15.field216.method3836((long)var0);
      return var2 == null?-1:(var1 >= 0 && var1 < var2.field217.length?var2.field217[var1]:-1);
   }

   @ObfuscatedName("f")
   void method1026(class118 var1, int var2) {
      if(1 == var2) {
         this.field1050 = var1.method2538();
         this.field1048 = var1.method2536();
         this.field1057 = var1.method2536();
      }

   }
}
