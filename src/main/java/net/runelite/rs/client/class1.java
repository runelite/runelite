package net.runelite.rs.client;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("l")
public class class1 {
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 525471789
   )
   static int field21;
   @ObfuscatedName("cc")
   static class223 field28;
   @ObfuscatedName("bv")
   static class80[] field29;

   @ObfuscatedName("k")
   static class102 method5(int var0) {
      class102 var1 = (class102)class42.field985.method3711((long)var0);
      if(null != var1) {
         return var1;
      } else {
         var1 = class37.method750(class42.field1001, class126.field2046, var0, false);
         if(null != var1) {
            class42.field985.method3713(var1, (long)var0);
         }

         return var1;
      }
   }

   @ObfuscatedName("o")
   static int method7(int var0, int var1) {
      long var2 = (long)((var0 << 16) + var1);
      return class170.field2732 != null && var2 == class170.field2732.field3112?class11.field179.field1998 * 99 / (class11.field179.field1995.length - class170.field2732.field2745) + 1:0;
   }

   @ObfuscatedName("q")
   static void method8(class25 var0) {
      if(var0.method612() != client.field291) {
         client.field291 = var0.method612();
         class169.method3326(var0.method612());
      }

      class141.field2179 = var0.field640;
      client.field286 = var0.field637;
      client.field287 = var0.field638;
      class215.field3152 = client.field288 == 0?'ꩊ':'鱀' + var0.field637;
      class6.field111 = client.field288 == 0?443:'썐' + var0.field637;
      client.field572 = class215.field3152;
   }
}
