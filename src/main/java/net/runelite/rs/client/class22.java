package net.runelite.rs.client;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("c")
public class class22 extends class203 {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -2131801367
   )
   int field587;
   @ObfuscatedName("l")
   int[] field588;
   @ObfuscatedName("a")
   int[] field589;
   @ObfuscatedName("j")
   static class192 field590 = new class192(128);
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 291370527
   )
   int field591;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1817350077
   )
   int field592;
   @ObfuscatedName("i")
   String[] field594;
   @ObfuscatedName("nf")
   @ObfuscatedGetter(
      intValue = 678091251
   )
   static int field597;
   @ObfuscatedName("bs")
   static class80[] field598;
   @ObfuscatedName("dm")
   static byte[][] field599;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 331569519
   )
   int field601;

   @ObfuscatedName("j")
   static class22 method580(int var0) {
      class22 var1 = (class22)field590.method3711((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class160.field2649.method3214(var0, 0);
         if(null == var2) {
            return null;
         } else {
            var1 = new class22();
            class118 var3 = new class118(var2);
            var3.field1998 = var3.field1995.length - 12;
            int var4 = var3.method2458();
            var1.field591 = var3.method2455();
            var1.field587 = var3.method2455();
            var1.field592 = var3.method2455();
            var1.field601 = var3.method2455();
            var3.field1998 = 0;
            var3.method2460();
            var1.field588 = new int[var4];
            var1.field589 = new int[var4];
            var1.field594 = new String[var4];

            int var6;
            for(int var5 = 0; var3.field1998 < var3.field1995.length - 12; var1.field588[var5++] = var6) {
               var6 = var3.method2455();
               if(3 == var6) {
                  var1.field594[var5] = var3.method2461();
               } else if(var6 < 100 && 21 != var6 && var6 != 38 && 39 != var6) {
                  var1.field589[var5] = var3.method2458();
               } else {
                  var1.field589[var5] = var3.method2453();
               }
            }

            field590.method3713(var1, (long)var0);
            return var1;
         }
      }
   }

   @ObfuscatedName("j")
   public static class51 method581(int var0) {
      class51 var1 = (class51)class51.field1140.method3711((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class51.field1129.method3214(10, var0);
         var1 = new class51();
         var1.field1151 = var0;
         if(null != var2) {
            var1.method1026(new class118(var2));
         }

         var1.method1034();
         if(var1.field1152 != -1) {
            var1.method1020(method581(var1.field1152), method581(var1.field1148));
         }

         if(var1.field1161 != -1) {
            var1.method1022(method581(var1.field1161), method581(var1.field1160));
         }

         if(!class168.field2714 && var1.field1114) {
            var1.field1121 = "Members object";
            var1.field1159 = false;
            var1.field1135 = null;
            var1.field1136 = null;
            var1.field1119 = 0;
         }

         class51.field1140.method3713(var1, (long)var0);
         return var1;
      }
   }
}
