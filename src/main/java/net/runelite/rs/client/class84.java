package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cm")
public abstract class class84 extends class203 {
   @ObfuscatedName("qm")
   public static class77 field1440;
   @ObfuscatedName("co")
   @ObfuscatedGetter(
      intValue = 1450079013
   )
   public int field1441 = 1000;

   @ObfuscatedName("m")
   static final boolean method1920(char var0) {
      return var0 == 160 || var0 == 32 || 95 == var0 || 45 == var0;
   }

   @ObfuscatedName("f")
   protected class104 vmethod1921() {
      return null;
   }

   @ObfuscatedName("az")
   void vmethod2348(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      class104 var10 = this.vmethod1921();
      if(var10 != null) {
         this.field1441 = var10.field1441;
         var10.vmethod2348(var1, var2, var3, var4, var5, var6, var7, var8, var9);
      }

   }

   @ObfuscatedName("m")
   static class223 method1929(class166 var0, class166 var1, int var2, int var3) {
      return !class46.method1007(var0, var2, var3)?null:class51.method1105(var1.method3352(var2, var3));
   }
}
