import java.awt.Canvas;
import java.awt.Component;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ba")
@Implements("GameCanvas")
public final class GameCanvas extends Canvas {
   @ObfuscatedName("pz")
   @ObfuscatedGetter(
      intValue = 589048107
   )
   static int field624;
   @ObfuscatedName("t")
   @Export("component")
   Component component;

   GameCanvas(Component var1) {
      this.component = var1;
   }

   public final void paint(Graphics var1) {
      this.component.paint(var1);
   }

   public final void update(Graphics var1) {
      this.component.update(var1);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;Ljava/io/File;B)V",
      garbageValue = "-80"
   )
   static void method853(File var0, File var1) {
      try {
         FileOnDisk var2 = new FileOnDisk(class37.jagexClDat, "rw", 10000L);
         Buffer var3 = new Buffer(500);
         var3.putByte(3);
         var3.putByte(var1 != null?1:0);
         var3.putCESU8(var0.getPath());
         if(var1 != null) {
            var3.putCESU8("");
         }

         var2.write(var3.payload, 0, var3.offset);
         var2.close();
      } catch (IOException var4) {
         var4.printStackTrace();
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "1511894939"
   )
   static final void method854(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int[] var7 = Region.method2919(var0, var1, var2);
      int[] var8 = Region.method2919(var3, var4, var5);
      Rasterizer2D.drawLine(var7[0], var7[1], var8[0], var8[1], var6);
   }

   @ObfuscatedName("hj")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-2045346283"
   )
   @Export("groundItemSpawned")
   static final void groundItemSpawned(int var0, int var1) {
      Deque var2 = Client.groundItemDeque[Ignore.plane][var0][var1];
      if(var2 == null) {
         class38.region.removeGroundItemPile(Ignore.plane, var0, var1);
      } else {
         long var3 = -99999999L;
         Item var5 = null;

         Item var6;
         for(var6 = (Item)var2.getFront(); var6 != null; var6 = (Item)var2.getNext()) {
            ItemComposition var7 = class81.getItemDefinition(var6.id);
            long var8 = (long)var7.price;
            if(var7.isStackable == 1) {
               var8 *= (long)(var6.quantity + 1);
            }

            if(var8 > var3) {
               var3 = var8;
               var5 = var6;
            }
         }

         if(var5 == null) {
            class38.region.removeGroundItemPile(Ignore.plane, var0, var1);
         } else {
            var2.addTail(var5);
            Item var11 = null;
            Item var10 = null;

            for(var6 = (Item)var2.getFront(); var6 != null; var6 = (Item)var2.getNext()) {
               if(var5.id != var6.id) {
                  if(var11 == null) {
                     var11 = var6;
                  }

                  if(var11.id != var6.id && var10 == null) {
                     var10 = var6;
                  }
               }
            }

            int var9 = var0 + (var1 << 7) + 1610612736;
            class38.region.addItemPile(Ignore.plane, var0, var1, class149.getTileHeight(var0 * 128 + 64, var1 * 128 + 64, Ignore.plane), var5, var9, var11, var10);
         }
      }
   }

   @ObfuscatedName("hw")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "874344618"
   )
   static final void method846(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Client.widgetCount; ++var4) {
         if(Client.widgetPositionX[var4] + Client.widgetBoundsWidth[var4] > var0 && Client.widgetPositionX[var4] < var0 + var2 && Client.widgetBoundsHeight[var4] + Client.widgetPositionY[var4] > var1 && Client.widgetPositionY[var4] < var3 + var1) {
            Client.field1051[var4] = true;
         }
      }

   }
}
