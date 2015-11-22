package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ax")
public class class32 {
   @ObfuscatedName("f")
   static byte[] field728 = new byte[2048];
   @ObfuscatedName("h")
   static int[] field730 = new int[2048];
   @ObfuscatedName("l")
   static byte[] field731 = new byte[2048];
   @ObfuscatedName("u")
   static class118[] field732 = new class118[2048];
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1441536975
   )
   static int field733 = 0;
   @ObfuscatedName("w")
   static int[] field735 = new int[2048];
   @ObfuscatedName("t")
   static int[] field736 = new int[2048];
   @ObfuscatedName("k")
   static int[] field737 = new int[2048];
   @ObfuscatedName("s")
   static int[] field738 = new int[2048];
   @ObfuscatedName("p")
   static class118 field739 = new class118(new byte[5000]);
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -249923199
   )
   static int field740 = 0;
   @ObfuscatedName("z")
   static int[] field741 = new int[2048];
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 981644955
   )
   static int field742 = 0;

   @ObfuscatedName("l")
   static Class method742(String var0) throws ClassNotFoundException {
      return var0.equals("B")?Byte.TYPE:(var0.equals("I")?Integer.TYPE:(var0.equals("S")?Short.TYPE:(var0.equals("J")?Long.TYPE:(var0.equals("Z")?Boolean.TYPE:(var0.equals("F")?Float.TYPE:(var0.equals("D")?Double.TYPE:(var0.equals("C")?Character.TYPE:(var0.equals("void")?Void.TYPE:Class.forName(var0)))))))));
   }

   @ObfuscatedName("e")
   static final int method749(int var0, int var1, int var2) {
      int var3 = var0 / var2;
      int var4 = var0 & var2 - 1;
      int var5 = var1 / var2;
      int var6 = var1 & var2 - 1;
      int var7 = class103.method2323(var3, var5);
      int var8 = class103.method2323(var3 + 1, var5);
      int var9 = class103.method2323(var3, 1 + var5);
      int var10 = class103.method2323(var3 + 1, 1 + var5);
      int var11 = class184.method3769(var7, var8, var4, var2);
      int var12 = class184.method3769(var9, var10, var4, var2);
      return class184.method3769(var11, var12, var6, var2);
   }

   @ObfuscatedName("al")
   static final void method753() {
      for(class29 var0 = (class29)client.field491.method3871(); var0 != null; var0 = (class29)client.field491.method3873()) {
         if(class8.field134 == var0.field664 && !var0.field662) {
            if(client.field286 >= var0.field663) {
               var0.method700(client.field420);
               if(var0.field662) {
                  var0.method3965();
               } else {
                  class24.field610.method1943(var0.field664, var0.field665, var0.field666, var0.field676, 60, var0, 0, -1, false);
               }
            }
         } else {
            var0.method3965();
         }
      }

   }
}
