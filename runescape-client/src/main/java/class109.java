import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("de")
public class class109 {
   @ObfuscatedName("x")
   static int[] field1927 = new int[4096];
   @ObfuscatedName("o")
   static int[][] field1930 = new int[128][128];
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 279150237
   )
   static int field1932;
   @ObfuscatedName("r")
   static int[] field1933 = new int[4096];
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1121617413
   )
   static int field1934;
   @ObfuscatedName("e")
   static int[][] field1936 = new int[128][128];

   @ObfuscatedName("dk")
   @ObfuscatedSignature(
      signature = "(IIIILclass81;Lclass178;S)V",
      garbageValue = "14543"
   )
   static final void method2444(int var0, int var1, int var2, int var3, class81 var4, class178 var5) {
      int var6 = var3 * var3 + var2 * var2;
      if(var6 > 4225 && var6 < 90000) {
         int var7 = client.field342 + client.field357 & 2047;
         int var8 = class94.field1660[var7];
         int var9 = class94.field1661[var7];
         var8 = var8 * 256 / (256 + client.field484);
         var9 = 256 * var9 / (client.field484 + 256);
         int var10 = var2 * var9 + var3 * var8 >> 16;
         int var11 = var3 * var9 - var8 * var2 >> 16;
         double var12 = Math.atan2((double)var10, (double)var11);
         int var14 = (int)(Math.sin(var12) * 63.0D);
         int var15 = (int)(Math.cos(var12) * 57.0D);
         class75.field1428.method1812(4 + var0 + 94 + var14 - 10, var1 + 83 - var15 - 20, 20, 20, 15, 15, var12, 256);
      } else {
         class55.method1177(var0, var1, var2, var3, var4, var5);
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1909886111"
   )
   static void method2445() {
      client.field539 = -1L;
      client.field286 = -1;
      class62.field1289.field185 = 0;
      class125.field2070 = true;
      client.field287 = true;
      client.field496 = -1L;
      class41.method827();
      client.field313.field2045 = 0;
      client.field315.field2045 = 0;
      client.field317 = -1;
      client.field320 = 1;
      client.field321 = -1;
      client.field290 = -1;
      client.field318 = 0;
      client.field289 = 0;
      client.field323 = 0;
      client.field418 = 0;
      client.field412 = 0;
      client.field517 = false;
      class143.field2221 = 0;
      class6.method91();
      client.field531 = 0;
      client.field444 = false;
      client.field274 = 0;
      client.field341 = (int)(Math.random() * 100.0D) - 50;
      client.field337 = (int)(Math.random() * 110.0D) - 55;
      client.field339 = (int)(Math.random() * 80.0D) - 40;
      client.field342 = (int)(Math.random() * 120.0D) - 60;
      client.field484 = (int)(Math.random() * 30.0D) - 20;
      client.field357 = (int)(Math.random() * 20.0D) - 10 & 2047;
      client.field506 = 0;
      client.field410 = -1;
      client.field504 = 0;
      client.field464 = 0;
      client.field298 = class21.field581;
      client.field355 = class21.field581;
      client.field394 = 0;
      class34.field777 = 0;

      int var3;
      for(var3 = 0; var3 < 2048; ++var3) {
         class34.field775[var3] = null;
         class34.field773[var3] = 1;
      }

      for(var3 = 0; var3 < 2048; ++var3) {
         client.field393[var3] = null;
      }

      for(var3 = 0; var3 < '耀'; ++var3) {
         client.field308[var3] = null;
      }

      client.field344 = -1;
      client.field405.method3893();
      client.field406.method3893();

      int var2;
      for(var3 = 0; var3 < 4; ++var3) {
         for(int var1 = 0; var1 < 104; ++var1) {
            for(var2 = 0; var2 < 104; ++var2) {
               client.field403[var3][var1][var2] = null;
            }
         }
      }

      client.field369 = new class202();
      client.field538 = 0;
      client.field537 = 0;
      client.field543 = 0;

      for(var3 = 0; var3 < class56.field1239; ++var3) {
         class56 var4 = class4.method41(var3);
         if(null != var4) {
            class179.field2950[var3] = 0;
            class179.field2949[var3] = 0;
         }
      }

      class33.field764.method200();
      client.field463 = -1;
      if(client.field430 != -1) {
         var3 = client.field430;
         if(var3 != -1 && class219.field3209[var3]) {
            class176.field2889.method3301(var3);
            if(class176.field2814[var3] != null) {
               boolean var5 = true;

               for(var2 = 0; var2 < class176.field2814[var3].length; ++var2) {
                  if(class176.field2814[var3][var2] != null) {
                     if(class176.field2814[var3][var2].field2929 != 2) {
                        class176.field2814[var3][var2] = null;
                     } else {
                        var5 = false;
                     }
                  }
               }

               if(var5) {
                  class176.field2814[var3] = null;
               }

               class219.field3209[var3] = false;
            }
         }
      }

      for(class3 var0 = (class3)client.field535.method3847(); null != var0; var0 = (class3)client.field535.method3852()) {
         class142.method3002(var0, true);
      }

      client.field430 = -1;
      client.field535 = new class199(8);
      client.field402 = null;
      client.field517 = false;
      client.field412 = 0;
      client.field516.method3536((int[])null, new int[]{0, 0, 0, 0, 0}, false, -1);

      for(var3 = 0; var3 < 8; ++var3) {
         client.field399[var3] = null;
         client.field400[var3] = false;
      }

      class3.method40();
      client.field281 = true;

      for(var3 = 0; var3 < 100; ++var3) {
         client.field460[var3] = true;
      }

      class177.method3493();
      client.field497 = null;
      class152.field2300 = 0;
      class17.field236 = null;

      for(var3 = 0; var3 < 8; ++var3) {
         client.field546[var3] = new class223();
      }

      class137.field2125 = null;
   }
}
