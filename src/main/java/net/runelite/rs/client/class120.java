package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("df")
public class class120 {
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = 136370951
   )
   static int field1989;
   @ObfuscatedName("u")
   static byte[][] field1990 = new byte[250][];
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1547826081
   )
   static int field1991 = 0;
   @ObfuscatedName("l")
   static byte[][] field1992 = new byte[1000][];
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -617030987
   )
   static int field1993 = 0;
   @ObfuscatedName("a")
   static byte[][] field1994 = new byte[50][];
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 593893221
   )
   static int field1997 = 0;

   @ObfuscatedName("br")
   static boolean method2775(int var0) {
      return var0 == 57 || 58 == var0 || 1007 == var0 || 25 == var0 || 30 == var0;
   }

   @ObfuscatedName("j")
   static synchronized byte[] method2778(int var0) {
      byte[] var1;
      if(100 == var0 && field1991 > 0) {
         var1 = field1992[--field1991];
         field1992[field1991] = null;
         return var1;
      } else if(5000 == var0 && field1997 > 0) {
         var1 = field1990[--field1997];
         field1990[field1997] = null;
         return var1;
      } else if(30000 == var0 && field1993 > 0) {
         var1 = field1994[--field1993];
         field1994[field1993] = null;
         return var1;
      } else {
         return new byte[var0];
      }
   }

   @ObfuscatedName("j")
   public static int method2779(int var0, int var1) {
      int var2;
      for(var2 = 1; var1 > 1; var1 >>= 1) {
         if(0 != (var1 & 1)) {
            var2 *= var0;
         }

         var0 *= var0;
      }

      if(var1 == 1) {
         return var2 * var0;
      } else {
         return var2;
      }
   }

   @ObfuscatedName("u")
   public static void method2780(int var0) {
      if(-1 != var0) {
         if(class172.field2725[var0]) {
            class172.field2726.method3324(var0);
            if(class172.field2857[var0] != null) {
               boolean var1 = true;

               for(int var2 = 0; var2 < class172.field2857[var0].length; ++var2) {
                  if(null != class172.field2857[var0][var2]) {
                     if(2 != class172.field2857[var0][var2].field2736) {
                        class172.field2857[var0][var2] = null;
                     } else {
                        var1 = false;
                     }
                  }
               }

               if(var1) {
                  class172.field2857[var0] = null;
               }

               class172.field2725[var0] = false;
            }
         }
      }
   }
}
