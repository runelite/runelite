import java.util.Comparator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("q")
final class class6 implements Comparator {
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = -639836997
   )
   static int field54;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;I)I",
      garbageValue = "2075998918"
   )
   int method86(class2 var1, class2 var2) {
      return var1.method22().compareTo(var2.method22());
   }

   public int compare(Object var1, Object var2) {
      return this.method86((class2)var1, (class2)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)LWorld;",
      garbageValue = "103"
   )
   static World method91() {
      World.field670 = 0;
      World var0;
      if(World.field670 < World.field677) {
         var0 = WidgetNode.worldList[++World.field670 - 1];
      } else {
         var0 = null;
      }

      return var0;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1900399179"
   )
   static void method94(int var0, int var1, int var2, int var3) {
      XItemContainer var4 = (XItemContainer)XItemContainer.itemContainers.method2331((long)var0);
      if(null == var4) {
         var4 = new XItemContainer();
         XItemContainer.itemContainers.method2333(var4, (long)var0);
      }

      if(var4.itemIds.length <= var1) {
         int[] var5 = new int[var1 + 1];
         int[] var6 = new int[1 + var1];

         int var7;
         for(var7 = 0; var7 < var4.itemIds.length; ++var7) {
            var5[var7] = var4.itemIds[var7];
            var6[var7] = var4.stackSizes[var7];
         }

         for(var7 = var4.itemIds.length; var7 < var1; ++var7) {
            var5[var7] = -1;
            var6[var7] = 0;
         }

         var4.itemIds = var5;
         var4.stackSizes = var6;
      }

      var4.itemIds[var1] = var2;
      var4.stackSizes[var1] = var3;
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "81"
   )
   static final void method95() {
      int var0 = VertexNormal.localPlayer.x + Client.field342;
      int var1 = VertexNormal.localPlayer.y + Client.field442;
      if(class49.field952 - var0 < -500 || class49.field952 - var0 > 500 || class65.field1111 - var1 < -500 || class65.field1111 - var1 > 500) {
         class49.field952 = var0;
         class65.field1111 = var1;
      }

      if(var0 != class49.field952) {
         class49.field952 += (var0 - class49.field952) / 16;
      }

      if(var1 != class65.field1111) {
         class65.field1111 += (var1 - class65.field1111) / 16;
      }

      int var2;
      int var3;
      if(class115.field1805 == 4 && class115.field1809) {
         var2 = class115.field1794 - Client.field366;
         Client.field364 = var2 * 2;
         Client.field366 = var2 != -1 && var2 != 1?(class115.field1794 + Client.field366) / 2:class115.field1794;
         var3 = Client.field306 - class115.field1799;
         Client.field363 = var3 * 2;
         Client.field306 = var3 != -1 && var3 != 1?(class115.field1799 + Client.field306) / 2:class115.field1799;
      } else {
         if(class105.field1712[96]) {
            Client.field363 += (-24 - Client.field363) / 2;
         } else if(class105.field1712[97]) {
            Client.field363 += (24 - Client.field363) / 2;
         } else {
            Client.field363 /= 2;
         }

         if(class105.field1712[98]) {
            Client.field364 += (12 - Client.field364) / 2;
         } else if(class105.field1712[99]) {
            Client.field364 += (-12 - Client.field364) / 2;
         } else {
            Client.field364 /= 2;
         }

         Client.field366 = class115.field1794;
         Client.field306 = class115.field1799;
      }

      Client.mapAngle = Client.mapAngle + Client.field363 / 2 & 2047;
      Client.field361 += Client.field364 / 2;
      if(Client.field361 < 128) {
         Client.field361 = 128;
      }

      if(Client.field361 > 383) {
         Client.field361 = 383;
      }

      var2 = class49.field952 >> 7;
      var3 = class65.field1111 >> 7;
      int var4 = Renderable.method1883(class49.field952, class65.field1111, class48.plane);
      int var5 = 0;
      int var6;
      if(var2 > 3 && var3 > 3 && var2 < 100 && var3 < 100) {
         for(var6 = var2 - 4; var6 <= var2 + 4; ++var6) {
            for(int var7 = var3 - 4; var7 <= 4 + var3; ++var7) {
               int var8 = class48.plane;
               if(var8 < 3 && (class11.tileSettings[1][var6][var7] & 2) == 2) {
                  ++var8;
               }

               int var9 = var4 - class11.tileHeights[var8][var6][var7];
               if(var9 > var5) {
                  var5 = var9;
               }
            }
         }
      }

      var6 = 192 * var5;
      if(var6 > 98048) {
         var6 = 98048;
      }

      if(var6 < '耀') {
         var6 = '耀';
      }

      if(var6 > Client.field370) {
         Client.field370 += (var6 - Client.field370) / 24;
      } else if(var6 < Client.field370) {
         Client.field370 += (var6 - Client.field370) / 80;
      }

   }

   @ObfuscatedName("eq")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)Ljava/lang/String;",
      garbageValue = "138316489"
   )
   static String method96(String var0, boolean var1) {
      String var2 = var1?"https://":"http://";
      if(Client.field281 == 1) {
         var0 = var0 + "-wtrc";
      } else if(Client.field281 == 2) {
         var0 = var0 + "-wtqa";
      } else if(Client.field281 == 3) {
         var0 = var0 + "-wtwip";
      } else if(Client.field281 == 5) {
         var0 = var0 + "-wti";
      } else if(Client.field281 == 4) {
         var0 = "local";
      }

      String var3 = "";
      if(null != class1.field12) {
         var3 = "/p=" + class1.field12;
      }

      String var4 = "runescape.com";
      return var2 + var0 + "." + var4 + "/l=" + Client.field285 + "/a=" + class103.field1685 + var3 + "/";
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "26"
   )
   static int method97(int var0, int var1, int var2) {
      return (class11.tileSettings[var0][var1][var2] & 8) != 0?0:(var0 > 0 && (class11.tileSettings[1][var1][var2] & 2) != 0?var0 - 1:var0);
   }

   @ObfuscatedName("dk")
   @ObfuscatedSignature(
      signature = "(IIIILSpritePixels;Lclass145;I)V",
      garbageValue = "1902756639"
   )
   static final void method99(int var0, int var1, int var2, int var3, SpritePixels var4, class145 var5) {
      int var6 = var2 * var2 + var3 * var3;
      if(var6 > 4225 && var6 < 90000) {
         int var7 = Client.mapAngle + Client.mapScale & 2047;
         int var8 = class84.field1428[var7];
         int var9 = class84.field1452[var7];
         var8 = 256 * var8 / (256 + Client.mapScaleDelta);
         var9 = var9 * 256 / (Client.mapScaleDelta + 256);
         int var10 = var3 * var8 + var9 * var2 >> 16;
         int var11 = var3 * var9 - var8 * var2 >> 16;
         double var12 = Math.atan2((double)var10, (double)var11);
         int var14 = (int)(Math.sin(var12) * 63.0D);
         int var15 = (int)(Math.cos(var12) * 57.0D);
         class186.field2752.method4126(4 + 94 + var0 + var14 - 10, 83 + var1 - var15 - 20, 20, 20, 15, 15, var12, 256);
      } else {
         class97.method1911(var0, var1, var2, var3, var4, var5);
      }

   }
}
