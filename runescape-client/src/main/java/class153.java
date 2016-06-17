import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("et")
public class class153 {
   @ObfuscatedName("g")
   static final class153 field2257 = new class153("BUILDLIVE", 3);
   @ObfuscatedName("j")
   static final class153 field2258 = new class153("RC", 1);
   @ObfuscatedName("d")
   static final class153 field2259 = new class153("WIP", 2);
   @ObfuscatedName("x")
   public final String field2260;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1436929777
   )
   public final int field2261;
   @ObfuscatedName("he")
   @Export("localPlayer")
   static class2 field2262;
   @ObfuscatedName("ee")
   static class78 field2263;
   @ObfuscatedName("ms")
   static byte field2264;
   @ObfuscatedName("dc")
   @ObfuscatedGetter(
      intValue = -147054299
   )
   static int field2265;
   @ObfuscatedName("b")
   static final class153 field2267 = new class153("LIVE", 0);

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(Lclass2;III)V",
      garbageValue = "-1462578817"
   )
   static void method3164(class2 var0, int var1, int var2) {
      if(var0.field801 == var1 && var1 != -1) {
         int var3 = class17.method178(var1).field979;
         if(var3 == 1) {
            var0.field822 = 0;
            var0.field823 = 0;
            var0.field827 = var2;
            var0.field825 = 0;
         }

         if(var3 == 2) {
            var0.field825 = 0;
         }
      } else if(var1 == -1 || var0.field801 == -1 || class17.method178(var1).field973 >= class17.method178(var0.field801).field973) {
         var0.field801 = var1;
         var0.field822 = 0;
         var0.field823 = 0;
         var0.field827 = var2;
         var0.field825 = 0;
         var0.field836 = var0.field808;
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass167;Ljava/lang/String;Ljava/lang/String;B)Lclass80;",
      garbageValue = "-88"
   )
   public static class80 method3168(class167 var0, String var1, String var2) {
      int var3 = var0.method3281(var1);
      int var4 = var0.method3282(var3, var2);
      class80 var5;
      if(!class38.method766(var0, var3, var4)) {
         var5 = null;
      } else {
         class80 var7 = new class80();
         var7.field1393 = class109.field1890;
         var7.field1388 = class76.field1351;
         var7.field1392 = class76.field1353[0];
         var7.field1395 = class131.field2048[0];
         var7.field1390 = class76.field1354[0];
         var7.field1391 = class28.field674[0];
         var7.field1389 = class8.field135;
         var7.field1394 = class76.field1355[0];
         class7.method95();
         var5 = var7;
      }

      return var5;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(CB)Z",
      garbageValue = "1"
   )
   public static boolean method3169(char var0) {
      return var0 >= 48 && var0 <= 57 || var0 >= 65 && var0 <= 90 || var0 >= 97 && var0 <= 122;
   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2032193863"
   )
   static final void method3170() {
      for(int var0 = 0; var0 < client.field462; ++var0) {
         int var1 = client.field330[var0];
         class34 var2 = client.field326[var1];
         int var3 = client.field332.method2514();
         int var4;
         int var5;
         int var6;
         if((var3 & 16) != 0) {
            var4 = client.field332.method2548();
            if(var4 == '\uffff') {
               var4 = -1;
            }

            var5 = client.field332.method2574();
            if(var2.field801 == var4 && var4 != -1) {
               var6 = class17.method178(var4).field979;
               if(var6 == 1) {
                  var2.field822 = 0;
                  var2.field823 = 0;
                  var2.field827 = var5;
                  var2.field825 = 0;
               }

               if(var6 == 2) {
                  var2.field825 = 0;
               }
            } else if(var4 == -1 || var2.field801 == -1 || class17.method178(var4).field973 >= class17.method178(var2.field801).field973) {
               var2.field801 = var4;
               var2.field822 = 0;
               var2.field823 = 0;
               var2.field827 = var5;
               var2.field825 = 0;
               var2.field836 = var2.field808;
            }
         }

         if((var3 & 4) != 0) {
            var4 = client.field332.method2514();
            var5 = client.field332.method2514();
            var2.method754(var4, var5, client.field296);
            var2.field812 = client.field296 + 300;
            var2.field794 = client.field332.method2550();
            var2.field814 = client.field332.method2516();
         }

         if((var3 & 32) != 0) {
            var2.field803 = client.field332.method2522();
            var2.field806 = 100;
         }

         if((var3 & 128) != 0) {
            var2.field835 = client.field332.method2516();
            var4 = client.field332.method2519();
            var2.field834 = var4 >> 16;
            var2.field829 = (var4 & '\uffff') + client.field296;
            var2.field811 = 0;
            var2.field828 = 0;
            if(var2.field829 > client.field296) {
               var2.field811 = -1;
            }

            if(var2.field835 == '\uffff') {
               var2.field835 = -1;
            }
         }

         if((var3 & 2) != 0) {
            var4 = client.field332.method2661();
            var5 = client.field332.method2661();
            var6 = var2.field813 - 64 * (var4 - class4.field62 - class4.field62);
            int var7 = var2.field791 - (var5 - class85.field1434 - class85.field1434) * 64;
            if(var6 != 0 || var7 != 0) {
               var2.field817 = (int)(Math.atan2((double)var6, (double)var7) * 325.949D) & 2047;
            }
         }

         if((var3 & 8) != 0) {
            var2.field815 = client.field332.method2516();
            if(var2.field815 == '\uffff') {
               var2.field815 = -1;
            }
         }

         if((var3 & 64) != 0) {
            var4 = client.field332.method2540();
            var5 = client.field332.method2542();
            var2.method754(var4, var5, client.field296);
            var2.field812 = client.field296 + 300;
            var2.field794 = client.field332.method2516();
            var2.field814 = client.field332.method2550();
         }

         if((var3 & 1) != 0) {
            var2.field762 = class176.method3460(client.field332.method2548());
            var2.field832 = var2.field762.field865;
            var2.field842 = var2.field762.field891;
            var2.field798 = var2.field762.field871;
            var2.field821 = var2.field762.field894;
            var2.field800 = var2.field762.field873;
            var2.field848 = var2.field762.field866;
            var2.field795 = var2.field762.field868;
            var2.field796 = var2.field762.field869;
            var2.field797 = var2.field762.field860;
         }
      }

   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "0"
   )
   class153(String var1, int var2) {
      this.field2260 = var1;
      this.field2261 = var2;
   }
}
