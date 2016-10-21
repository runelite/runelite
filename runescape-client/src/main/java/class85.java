import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cb")
public class class85 implements class115 {
   @ObfuscatedName("e")
   static final class85 field1479 = new class85(1, 1);
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1805014165
   )
   final int field1480;
   @ObfuscatedName("n")
   static final class85 field1482 = new class85(2, 2);
   @ObfuscatedName("v")
   static final class85 field1483 = new class85(4, 4);
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1206393699
   )
   public final int field1484;
   @ObfuscatedName("f")
   public static final class85 field1485 = new class85(0, 0);
   @ObfuscatedName("t")
   static final class85 field1486 = new class85(3, 3);
   @ObfuscatedName("dy")
   @ObfuscatedGetter(
      intValue = 1133799801
   )
   static int field1487;
   @ObfuscatedName("hz")
   @ObfuscatedGetter(
      intValue = 373629077
   )
   @Export("menuHeight")
   static int menuHeight;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "38"
   )
   static final void method1935() {
      for(int var0 = 0; var0 < Client.field363; ++var0) {
         --Client.field524[var0];
         if(Client.field524[var0] >= -10) {
            class61 var9 = Client.field313[var0];
            if(var9 == null) {
               Object var10000 = null;
               var9 = class61.method1299(class5.field77, Client.field522[var0], 0);
               if(null == var9) {
                  continue;
               }

               Client.field524[var0] += var9.method1287();
               Client.field313[var0] = var9;
            }

            if(Client.field524[var0] < 0) {
               int var2;
               if(Client.field525[var0] != 0) {
                  int var3 = (Client.field525[var0] & 255) * 128;
                  int var10 = Client.field525[var0] >> 16 & 255;
                  int var5 = 64 + var10 * 128 - class34.localPlayer.x;
                  if(var5 < 0) {
                     var5 = -var5;
                  }

                  int var6 = Client.field525[var0] >> 8 & 255;
                  int var7 = 64 + 128 * var6 - class34.localPlayer.y;
                  if(var7 < 0) {
                     var7 = -var7;
                  }

                  int var8 = var5 + var7 - 128;
                  if(var8 > var3) {
                     Client.field524[var0] = -100;
                     continue;
                  }

                  if(var8 < 0) {
                     var8 = 0;
                  }

                  var2 = Client.field520 * (var3 - var8) / var3;
               } else {
                  var2 = Client.field519;
               }

               if(var2 > 0) {
                  class65 var11 = var9.method1288().method1331(class59.field1234);
                  class67 var4 = class67.method1355(var11, 100, var2);
                  var4.method1384(Client.field523[var0] - 1);
                  WidgetNode.field59.method1184(var4);
               }

               Client.field524[var0] = -100;
            }
         } else {
            --Client.field363;

            for(int var1 = var0; var1 < Client.field363; ++var1) {
               Client.field522[var1] = Client.field522[1 + var1];
               Client.field313[var1] = Client.field313[var1 + 1];
               Client.field523[var1] = Client.field523[var1 + 1];
               Client.field524[var1] = Client.field524[1 + var1];
               Client.field525[var1] = Client.field525[1 + var1];
            }

            --var0;
         }
      }

      if(Client.field470) {
         boolean var12;
         if(class186.field3005 != 0) {
            var12 = true;
         } else {
            var12 = class28.field670.method3664();
         }

         if(!var12) {
            if(Client.field516 != 0 && Client.field517 != -1) {
               class1.method16(class47.field1050, Client.field517, 0, Client.field516, false);
            }

            Client.field470 = false;
         }
      }

   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class85(int var1, int var2) {
      this.field1484 = var1;
      this.field1480 = var2;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "50702266"
   )
   public int vmethod3196() {
      return this.field1480;
   }
}
