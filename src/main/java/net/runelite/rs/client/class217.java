package net.runelite.rs.client;
import java.applet.Applet;
import java.util.Comparator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hs")
final class class217 implements Comparator {
   @ObfuscatedName("j")
   static Applet field3158;
   @ObfuscatedName("ej")
   static class80[] field3159;
   @ObfuscatedName("i")
   static String[] field3160;
   @ObfuscatedName("qg")
   @ObfuscatedGetter(
      intValue = -1113367487
   )
   static int field3161;

   public int compare(Object var1, Object var2) {
      return this.method3908((class213)var1, (class213)var2);
   }

   @ObfuscatedName("j")
   int method3908(class213 var1, class213 var2) {
      return var1.field3143 < var2.field3143?-1:(var2.field3143 == var1.field3143?0:1);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("c")
   static final void method3916() {
      for(int var0 = 0; var0 < client.field530; ++var0) {
         --client.field443[var0];
         if(client.field443[var0] >= -10) {
            class58 var10 = client.field401[var0];
            if(var10 == null) {
               class58 var10000 = (class58)null;
               var10 = class58.method1247(class31.field740, client.field531[var0], 0);
               if(null == var10) {
                  continue;
               }

               client.field443[var0] += var10.method1242();
               client.field401[var0] = var10;
            }

            if(client.field443[var0] < 0) {
               int var2;
               if(client.field534[var0] != 0) {
                  int var3 = 128 * (client.field534[var0] & 255);
                  int var4 = client.field534[var0] >> 16 & 255;
                  int var5 = 128 * var4 + 64 - class148.field2249.field839;
                  if(var5 < 0) {
                     var5 = -var5;
                  }

                  int var6 = client.field534[var0] >> 8 & 255;
                  int var7 = 128 * var6 + 64 - class148.field2249.field848;
                  if(var7 < 0) {
                     var7 = -var7;
                  }

                  int var8 = var5 + var7 - 128;
                  if(var8 > var3) {
                     client.field443[var0] = -100;
                     continue;
                  }

                  if(var8 < 0) {
                     var8 = 0;
                  }

                  var2 = (var3 - var8) * client.field502 / var3;
               } else {
                  var2 = client.field300;
               }

               if(var2 > 0) {
                  class62 var11 = var10.method1252().method1280(class24.field628);
                  class64 var12 = class64.method1415(var11, 100, var2);
                  var12.method1304(client.field532[var0] - 1);
                  class17.field252.method1152(var12);
               }

               client.field443[var0] = -100;
            }
         } else {
            --client.field530;

            for(int var1 = var0; var1 < client.field530; ++var1) {
               client.field531[var1] = client.field531[var1 + 1];
               client.field401[var1] = client.field401[1 + var1];
               client.field532[var1] = client.field532[1 + var1];
               client.field443[var1] = client.field443[var1 + 1];
               client.field534[var1] = client.field534[var1 + 1];
            }

            --var0;
         }
      }

      if(client.field527) {
         boolean var9;
         if(0 != class182.field2957) {
            var9 = true;
         } else {
            var9 = class182.field2954.method3556();
         }

         if(!var9) {
            if(0 != client.field525 && client.field453 != -1) {
               class108.method2379(class137.field2139, client.field453, 0, client.field525, false);
            }

            client.field527 = false;
         }
      }

   }
}
