import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("p")
final class class5 implements Comparator {
   @ObfuscatedName("pv")
   static class234 field49;
   @ObfuscatedName("ey")
   static SpritePixels[] field50;

   @ObfuscatedName("cw")
   @ObfuscatedSignature(
      signature = "(LWidget;IIZI)V",
      garbageValue = "462719116"
   )
   static void method63(Widget var0, int var1, int var2, boolean var3) {
      int var4 = var0.width;
      int var5 = var0.height;
      if(var0.field2280 == 0) {
         var0.width = var0.originalWidth;
      } else if(var0.field2280 == 1) {
         var0.width = var1 - var0.originalWidth;
      } else if(var0.field2280 == 2) {
         var0.width = var1 * var0.originalWidth >> 14;
      }

      if(var0.field2215 == 0) {
         var0.height = var0.field2219;
      } else if(var0.field2215 == 1) {
         var0.height = var2 - var0.field2219;
      } else if(var0.field2215 == 2) {
         var0.height = var0.field2219 * var2 >> 14;
      }

      if(var0.field2280 == 4) {
         var0.width = var0.height * var0.field2338 / var0.field2341;
      }

      if(var0.field2215 == 4) {
         var0.height = var0.width * var0.field2341 / var0.field2338;
      }

      if(Client.field455 && var0.type == 0) {
         if(var0.height < 5 && var0.width < 5) {
            var0.height = 5;
            var0.width = 5;
         } else {
            if(var0.height <= 0) {
               var0.height = 5;
            }

            if(var0.width <= 0) {
               var0.width = 5;
            }
         }
      }

      if(var0.contentType == 1337) {
         Client.field457 = var0;
      }

      if(var3 && var0.field2316 != null && (var0.width != var4 || var5 != var0.height)) {
         class18 var6 = new class18();
         var6.field189 = var0;
         var6.field196 = var0.field2316;
         Client.field484.method2824(var6);
      }

   }

   public int compare(Object var1, Object var2) {
      return this.method66((class2)var1, (class2)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;I)I",
      garbageValue = "250289532"
   )
   int method66(class2 var1, class2 var2) {
      return var1.field21.price < var2.field21.price?-1:(var2.field21.price == var1.field21.price?0:1);
   }

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1610172854"
   )
   static final void method75(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Client.field490; ++var4) {
         if(Client.widgetPositionX[var4] + Client.widgetBoundsWidth[var4] > var0 && Client.widgetPositionX[var4] < var0 + var2 && Client.widgetBoundsHeight[var4] + Client.widgetPositionY[var4] > var1 && Client.widgetPositionY[var4] < var3 + var1) {
            Client.field368[var4] = true;
         }
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(LPacketBuffer;B)V",
      garbageValue = "0"
   )
   static final void method76(PacketBuffer var0) {
      var0.method2644();
      int var1 = Client.localInteractingIndex;
      Player var2 = class22.localPlayer = Client.cachedPlayers[var1] = new Player();
      var2.field257 = var1;
      int var3 = var0.method2645(30);
      byte var4 = (byte)(var3 >> 28);
      int var5 = var3 >> 14 & 16383;
      int var6 = var3 & 16383;
      var2.pathX[0] = var5 - class108.baseX;
      var2.x = (var2.pathX[0] << 7) + (var2.method226() << 6);
      var2.pathY[0] = var6 - GameEngine.baseY;
      var2.y = (var2.pathY[0] << 7) + (var2.method226() << 6);
      Client.plane = var2.field256 = var4;
      if(class45.field890[var1] != null) {
         var2.method227(class45.field890[var1]);
      }

      class45.field891 = 0;
      class45.field894[++class45.field891 - 1] = var1;
      class45.field888[var1] = 0;
      class45.field893 = 0;

      for(int var7 = 1; var7 < 2048; ++var7) {
         if(var1 != var7) {
            int var8 = var0.method2645(18);
            int var9 = var8 >> 16;
            int var10 = var8 >> 8 & 597;
            int var11 = var8 & 597;
            class45.field895[var7] = (var9 << 28) + (var10 << 14) + var11;
            class45.field900[var7] = 0;
            class45.field897[var7] = -1;
            class45.field886[++class45.field893 - 1] = var7;
            class45.field888[var7] = 0;
         }
      }

      var0.method2647();
   }
}
