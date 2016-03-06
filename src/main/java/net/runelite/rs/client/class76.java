package net.runelite.rs.client;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bo")
public class class76 {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -293301147
   )
   static int field1390;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 210797703
   )
   static int field1391;
   @ObfuscatedName("i")
   static int[] field1392;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 469338459
   )
   static int field1395;
   @ObfuscatedName("bs")
   static class167 field1396;

   @ObfuscatedName("j")
   public static void method1648(class166 var0) {
      class45.field1043 = var0;
   }

   @ObfuscatedName("j")
   public static class49 method1653(int var0) {
      class49 var1 = (class49)class49.field1092.method3711((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class49.field1088.method3214(15, var0);
         var1 = new class49();
         if(null != var2) {
            var1.method998(new class118(var2));
         }

         class49.field1092.method3713(var1, (long)var0);
         return var1;
      }
   }
}
