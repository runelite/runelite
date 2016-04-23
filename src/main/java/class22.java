import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("k")
public class class22 extends class204 {
   @ObfuscatedName("m")
   int[] field571;
   @ObfuscatedName("j")
   static class193 field572 = new class193(128);
   @ObfuscatedName("z")
   String[] field574;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1666617023
   )
   int field575;
   @ObfuscatedName("h")
   int[] field576;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 2119688283
   )
   int field577;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1500488043
   )
   int field578;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -707468815
   )
   int field581;
   @ObfuscatedName("bn")
   static class168 field582;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass168;IIIBZI)V",
      garbageValue = "0"
   )
   static void method586(class168 var0, int var1, int var2, int var3, byte var4, boolean var5) {
      long var6 = (long)(var2 + (var1 << 16));
      class172 var8 = (class172)class171.field2728.method3742(var6);
      if(var8 == null) {
         var8 = (class172)class171.field2712.method3742(var6);
         if(null == var8) {
            var8 = (class172)class171.field2715.method3742(var6);
            if(var8 != null) {
               if(var5) {
                  var8.method3863();
                  class171.field2728.method3743(var8, var6);
                  --class171.field2720;
                  ++class171.field2719;
               }

            } else {
               if(!var5) {
                  var8 = (class172)class171.field2717.method3742(var6);
                  if(null != var8) {
                     return;
                  }
               }

               var8 = new class172();
               var8.field2731 = var0;
               var8.field2730 = var3;
               var8.field2732 = var4;
               if(var5) {
                  class171.field2728.method3743(var8, var6);
                  ++class171.field2719;
               } else {
                  class171.field2716.method3844(var8);
                  class171.field2715.method3743(var8, var6);
                  ++class171.field2720;
               }

            }
         }
      }
   }

   @ObfuscatedName("ce")
   @ObfuscatedSignature(
      signature = "(Lclass173;I)V",
      garbageValue = "-2056681429"
   )
   static void method587(class173 var0) {
      class173 var1 = -1 == var0.field2763?null:class141.method2959(var0.field2763);
      int var2;
      int var3;
      if(var1 == null) {
         var2 = class5.field102;
         var3 = class39.field901;
      } else {
         var2 = var1.field2840;
         var3 = var1.field2746;
      }

      class98.method2194(var0, var2, var3, false);
      class102.method2272(var0, var2, var3);
   }
}
