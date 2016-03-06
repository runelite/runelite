package net.runelite.rs.client;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ce")
@Implements("Renderable")
public abstract class class84 extends class203 {
   @ObfuscatedName("cp")
   @ObfuscatedGetter(
      intValue = 1911097579
   )
   @Export("modelHeight")
   public int field1461 = 1000;

   @ObfuscatedName("cm")
   static void method1869(class172 var0) {
      class172 var1 = var0.field2778 == -1?null:class31.method698(var0.field2778);
      int var2;
      int var3;
      if(var1 == null) {
         var2 = class142.field2190;
         var3 = class89.field1566;
      } else {
         var2 = var1.field2774;
         var3 = var1.field2890;
      }

      class24.method595(var0, var2, var3, false);
      class10.method126(var0, var2, var3);
   }

   @ObfuscatedName("a")
   protected class104 vmethod1870() {
      return null;
   }

   @ObfuscatedName("v")
   void vmethod2302(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      class104 var10 = this.vmethod1870();
      if(null != var10) {
         this.field1461 = var10.field1461;
         var10.vmethod2302(var1, var2, var3, var4, var5, var6, var7, var8, var9);
      }

   }
}
