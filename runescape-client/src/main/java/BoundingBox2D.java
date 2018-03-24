import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("p")
@Implements("BoundingBox2D")
public final class BoundingBox2D extends BoundingBox {
   @ObfuscatedName("da")
   @ObfuscatedSignature(
      signature = "Lju;"
   )
   @Export("indexScripts")
   static IndexData indexScripts;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 478939067
   )
   @Export("xMin")
   final int xMin;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1436555565
   )
   @Export("yMin")
   final int yMin;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 891008535
   )
   @Export("xMax")
   final int xMax;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1864565545
   )
   @Export("yMax")
   final int yMax;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1728047869
   )
   @Export("color")
   final int color;

   BoundingBox2D(int var1, int var2, int var3, int var4, int var5) {
      this.xMin = var1;
      this.yMin = var2;
      this.xMax = var3;
      this.yMax = var4;
      this.color = var5;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-706888510"
   )
   public final void vmethod56() {
      Rasterizer2D.drawRectangle(this.xMin + Rasterizer2D.draw_region_x, this.yMin + Rasterizer2D.drawingAreaTop, this.xMax - this.xMin, this.yMax - this.yMin, this.color);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([BIIIIIII[Lfa;I)V",
      garbageValue = "-300131487"
   )
   static final void method31(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, CollisionData[] var8) {
      int var10;
      for(int var9 = 0; var9 < 8; ++var9) {
         for(var10 = 0; var10 < 8; ++var10) {
            if(var9 + var2 > 0 && var9 + var2 < 103 && var3 + var10 > 0 && var3 + var10 < 103) {
               var8[var1].flags[var9 + var2][var3 + var10] &= -16777217;
            }
         }
      }

      Buffer var20 = new Buffer(var0);

      for(var10 = 0; var10 < 4; ++var10) {
         for(int var11 = 0; var11 < 64; ++var11) {
            for(int var12 = 0; var12 < 64; ++var12) {
               if(var10 == var4 && var11 >= var5 && var11 < var5 + 8 && var12 >= var6 && var12 < var6 + 8) {
                  int var17 = var11 & 7;
                  int var18 = var12 & 7;
                  int var19 = var7 & 3;
                  int var16;
                  if(var19 == 0) {
                     var16 = var17;
                  } else if(var19 == 1) {
                     var16 = var18;
                  } else if(var19 == 2) {
                     var16 = 7 - var17;
                  } else {
                     var16 = 7 - var18;
                  }

                  class80.loadTerrain(var20, var1, var2 + var16, var3 + AbstractByteBuffer.method3787(var11 & 7, var12 & 7, var7), 0, 0, var7);
               } else {
                  class80.loadTerrain(var20, 0, -1, -1, 0, 0, 0);
               }
            }
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "54"
   )
   static final void method40() {
      MapIconReference.method757("Your ignore list is full. Max of 100 for free users, and 400 for members");
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-51733631"
   )
   protected static final void method36() {
      GameEngine.timer.vmethod3325();

      int var0;
      for(var0 = 0; var0 < 32; ++var0) {
         GameEngine.field652[var0] = 0L;
      }

      for(var0 = 0; var0 < 32; ++var0) {
         GameEngine.field653[var0] = 0L;
      }

      Huffman.field2483 = 0;
   }

   @ObfuscatedName("fm")
   @ObfuscatedSignature(
      signature = "(Lig;III)V",
      garbageValue = "-1276289560"
   )
   static final void method37(Widget var0, int var1, int var2) {
      if(Client.field1003 == 0 || Client.field1003 == 3) {
         if(MouseInput.mouseLastButton == 1 || !class153.middleMouseMovesCamera && MouseInput.mouseLastButton == 4) {
            class236 var3 = var0.method4470(true);
            if(var3 == null) {
               return;
            }

            int var4 = MouseInput.mouseLastPressedX - var1;
            int var5 = MouseInput.mouseLastPressedY - var2;
            if(var3.method4386(var4, var5)) {
               var4 -= var3.field2766 / 2;
               var5 -= var3.field2767 / 2;
               int var6 = Client.mapAngle & 2047;
               int var7 = Graphics3D.SINE[var6];
               int var8 = Graphics3D.COSINE[var6];
               int var9 = var4 * var8 + var7 * var5 >> 11;
               int var10 = var8 * var5 - var7 * var4 >> 11;
               int var11 = var9 + WorldMapData.localPlayer.x >> 7;
               int var12 = WorldMapData.localPlayer.y - var10 >> 7;
               PacketNode var13 = class33.method382(ClientPacket.field2432, Client.field1072.field1456);
               var13.packetBuffer.putByte(18);
               var13.packetBuffer.method3519(var12 + PlayerComposition.baseY);
               var13.packetBuffer.putShortLE(KeyFocusListener.keyPressed[82]?(KeyFocusListener.keyPressed[81]?2:1):0);
               var13.packetBuffer.method3573(var11 + class38.baseX);
               var13.packetBuffer.putByte(var4);
               var13.packetBuffer.putByte(var5);
               var13.packetBuffer.putShort(Client.mapAngle);
               var13.packetBuffer.putByte(57);
               var13.packetBuffer.putByte(0);
               var13.packetBuffer.putByte(0);
               var13.packetBuffer.putByte(89);
               var13.packetBuffer.putShort(WorldMapData.localPlayer.x);
               var13.packetBuffer.putShort(WorldMapData.localPlayer.y);
               var13.packetBuffer.putByte(63);
               Client.field1072.method2073(var13);
               Client.destinationX = var11;
               Client.destinationY = var12;
            }
         }

      }
   }

   @ObfuscatedName("jj")
   @ObfuscatedSignature(
      signature = "(IIIILla;Liq;I)V",
      garbageValue = "-237595582"
   )
   @Export("drawDot")
   static final void drawDot(int var0, int var1, int var2, int var3, SpritePixels var4, class236 var5) {
      if(var4 != null) {
         int var6 = Client.mapAngle & 2047;
         int var7 = var3 * var3 + var2 * var2;
         if(var7 <= 6400) {
            int var8 = Graphics3D.SINE[var6];
            int var9 = Graphics3D.COSINE[var6];
            int var10 = var9 * var2 + var3 * var8 >> 16;
            int var11 = var3 * var9 - var8 * var2 >> 16;
            if(var7 > 2500) {
               var4.method5858(var10 + var5.field2766 / 2 - var4.maxWidth / 2, var5.field2767 / 2 - var11 - var4.maxHeight / 2, var0, var1, var5.field2766, var5.field2767, var5.field2765, var5.field2764);
            } else {
               var4.drawAt(var0 + var10 + var5.field2766 / 2 - var4.maxWidth / 2, var5.field2767 / 2 + var1 - var11 - var4.maxHeight / 2);
            }

         }
      }
   }
}
