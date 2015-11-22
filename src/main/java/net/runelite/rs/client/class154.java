package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ef")
public class class154 {
   @ObfuscatedName("m")
   public static final boolean[] field2281 = new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false};
   @ObfuscatedName("f")
   public static int[] field2285 = new int[99];

   @ObfuscatedName("bg")
   static final void method3202(int var0, int var1) {
      int var2 = class143.field2174.method4161("Choose Option");

      int var3;
      for(var3 = 0; var3 < client.field416; ++var3) {
         class223 var4 = class143.field2174;
         String var5;
         if(client.field422[var3].length() > 0) {
            var5 = client.field297[var3] + " " + client.field422[var3];
         } else {
            var5 = client.field297[var3];
         }

         int var6 = var4.method4161(var5);
         if(var6 > var2) {
            var2 = var6;
         }
      }

      var2 += 8;
      var3 = client.field416 * 15 + 22;
      int var7 = var0 - var2 / 2;
      if(var7 + var2 > class129.field2048) {
         var7 = class129.field2048 - var2;
      }

      if(var7 < 0) {
         var7 = 0;
      }

      int var8 = var1;
      if(var1 + var3 > class136.field2101) {
         var8 = class136.field2101 - var3;
      }

      if(var8 < 0) {
         var8 = 0;
      }

      client.field500 = true;
      class18.field253 = var7;
      class36.field793 = var8;
      class0.field9 = var2;
      class19.field267 = 22 + client.field416 * 15;
   }

   static {
      int var0 = 0;

      for(int var1 = 0; var1 < 99; ++var1) {
         int var2 = 1 + var1;
         int var3 = (int)((double)var2 + 300.0D * Math.pow(2.0D, (double)var2 / 7.0D));
         var0 += var3;
         field2285[var1] = var0 / 4;
      }

   }

   @ObfuscatedName("ds")
   static class172 method3203(class172 var0) {
      int var1 = class16.method209(class7.method126(var0));
      if(var1 == 0) {
         return null;
      } else {
         for(int var2 = 0; var2 < var1; ++var2) {
            var0 = class48.method1036(var0.field2742);
            if(var0 == null) {
               return null;
            }
         }

         return var0;
      }
   }

   @ObfuscatedName("j")
   public static byte method3204(char var0) {
      byte var1;
      if((var0 <= 0 || var0 >= 128) && (var0 < 160 || var0 > 255)) {
         if(8364 == var0) {
            var1 = -128;
         } else if(8218 == var0) {
            var1 = -126;
         } else if(var0 == 402) {
            var1 = -125;
         } else if(var0 == 8222) {
            var1 = -124;
         } else if(8230 == var0) {
            var1 = -123;
         } else if(var0 == 8224) {
            var1 = -122;
         } else if(8225 == var0) {
            var1 = -121;
         } else if(var0 == 710) {
            var1 = -120;
         } else if(8240 == var0) {
            var1 = -119;
         } else if(352 == var0) {
            var1 = -118;
         } else if(var0 == 8249) {
            var1 = -117;
         } else if(338 == var0) {
            var1 = -116;
         } else if(381 == var0) {
            var1 = -114;
         } else if(var0 == 8216) {
            var1 = -111;
         } else if(var0 == 8217) {
            var1 = -110;
         } else if(var0 == 8220) {
            var1 = -109;
         } else if(var0 == 8221) {
            var1 = -108;
         } else if(var0 == 8226) {
            var1 = -107;
         } else if(8211 == var0) {
            var1 = -106;
         } else if(8212 == var0) {
            var1 = -105;
         } else if(var0 == 732) {
            var1 = -104;
         } else if(8482 == var0) {
            var1 = -103;
         } else if(var0 == 353) {
            var1 = -102;
         } else if(var0 == 8250) {
            var1 = -101;
         } else if(339 == var0) {
            var1 = -100;
         } else if(382 == var0) {
            var1 = -98;
         } else if(376 == var0) {
            var1 = -97;
         } else {
            var1 = 63;
         }
      } else {
         var1 = (byte)var0;
      }

      return var1;
   }
}
