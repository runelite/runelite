import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("by")
public class class71 extends class178 {
   @ObfuscatedName("px")
   @ObfuscatedSignature(
      signature = "Ldf;"
   )
   @Export("soundSystem1")
   static AbstractSoundSystem soundSystem1;
   @ObfuscatedName("qr")
   @ObfuscatedGetter(
      longValue = 2605552898751073199L
   )
   static long field834;
   @ObfuscatedName("cy")
   @ObfuscatedSignature(
      signature = "Ljn;"
   )
   @Export("indexInterfaces")
   static IndexData indexInterfaces;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIILfb;I)Z",
      garbageValue = "-1864637630"
   )
   protected boolean vmethod3428(int var1, int var2, int var3, CollisionData var4) {
      return var2 == super.field2296 && var3 == super.field2293;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "97"
   )
   static final void method1184(int var0) {
      short var1 = 256;
      class90.field1369 += var0 * 128;
      int var2;
      if(class90.field1369 > MouseRecorder.field819.length) {
         class90.field1369 -= MouseRecorder.field819.length;
         var2 = (int)(Math.random() * 12.0D);
         class44.method663(class90.runeSprites[var2]);
      }

      var2 = 0;
      int var3 = var0 * 128;
      int var4 = (var1 - var0) * 128;

      int var5;
      int var6;
      for(var5 = 0; var5 < var4; ++var5) {
         var6 = Huffman.field2513[var2 + var3] - var0 * MouseRecorder.field819[var2 + class90.field1369 & MouseRecorder.field819.length - 1] / 6;
         if(var6 < 0) {
            var6 = 0;
         }

         Huffman.field2513[var2++] = var6;
      }

      int var7;
      int var8;
      for(var5 = var1 - var0; var5 < var1; ++var5) {
         var6 = var5 * 128;

         for(var7 = 0; var7 < 128; ++var7) {
            var8 = (int)(Math.random() * 100.0D);
            if(var8 < 50 && var7 > 10 && var7 < 118) {
               Huffman.field2513[var7 + var6] = 255;
            } else {
               Huffman.field2513[var7 + var6] = 0;
            }
         }
      }

      if(class90.field1367 > 0) {
         class90.field1367 -= var0 * 4;
      }

      if(class90.field1358 > 0) {
         class90.field1358 -= var0 * 4;
      }

      if(class90.field1367 == 0 && class90.field1358 == 0) {
         var5 = (int)(Math.random() * (double)(2000 / var0));
         if(var5 == 0) {
            class90.field1367 = 1024;
         }

         if(var5 == 1) {
            class90.field1358 = 1024;
         }
      }

      for(var5 = 0; var5 < var1 - var0; ++var5) {
         class90.field1366[var5] = class90.field1366[var0 + var5];
      }

      for(var5 = var1 - var0; var5 < var1; ++var5) {
         class90.field1366[var5] = (int)(Math.sin((double)class90.field1368 / 14.0D) * 16.0D + Math.sin((double)class90.field1368 / 15.0D) * 14.0D + Math.sin((double)class90.field1368 / 16.0D) * 12.0D);
         ++class90.field1368;
      }

      class90.field1370 += var0;
      var5 = (var0 + (Client.gameCycle & 1)) / 2;
      if(var5 > 0) {
         for(var6 = 0; var6 < class90.field1370 * 100; ++var6) {
            var7 = (int)(Math.random() * 124.0D) + 2;
            var8 = (int)(Math.random() * 128.0D) + 128;
            Huffman.field2513[var7 + (var8 << 7)] = 192;
         }

         class90.field1370 = 0;

         int var9;
         for(var6 = 0; var6 < var1; ++var6) {
            var7 = 0;
            var8 = var6 * 128;

            for(var9 = -var5; var9 < 128; ++var9) {
               if(var9 + var5 < 128) {
                  var7 += Huffman.field2513[var5 + var9 + var8];
               }

               if(var9 - (var5 + 1) >= 0) {
                  var7 -= Huffman.field2513[var9 + var8 - (var5 + 1)];
               }

               if(var9 >= 0) {
                  AbstractSoundSystem.field1585[var9 + var8] = var7 / (var5 * 2 + 1);
               }
            }
         }

         for(var6 = 0; var6 < 128; ++var6) {
            var7 = 0;

            for(var8 = -var5; var8 < var1; ++var8) {
               var9 = var8 * 128;
               if(var8 + var5 < var1) {
                  var7 += AbstractSoundSystem.field1585[var6 + var9 + var5 * 128];
               }

               if(var8 - (var5 + 1) >= 0) {
                  var7 -= AbstractSoundSystem.field1585[var9 + var6 - (var5 + 1) * 128];
               }

               if(var8 >= 0) {
                  Huffman.field2513[var9 + var6] = var7 / (var5 * 2 + 1);
               }
            }
         }
      }

   }

   @ObfuscatedName("fn")
   @ObfuscatedSignature(
      signature = "(Lin;III)V",
      garbageValue = "-1331343339"
   )
   static final void method1181(Widget var0, int var1, int var2) {
      if(Client.field1099 == 0 || Client.field1099 == 3) {
         if(MouseInput.mouseLastButton == 1 || !MapIconReference.middleMouseMovesCamera && MouseInput.mouseLastButton == 4) {
            class236 var3 = var0.method4425(true);
            if(var3 == null) {
               return;
            }

            int var4 = MouseInput.mouseLastPressedX - var1;
            int var5 = MouseInput.mouseLastPressedY - var2;
            if(var3.method4346(var4, var5)) {
               var4 -= var3.field2773 / 2;
               var5 -= var3.field2772 / 2;
               int var6 = Client.mapAngle & 2047;
               int var7 = Graphics3D.SINE[var6];
               int var8 = Graphics3D.COSINE[var6];
               int var9 = var5 * var7 + var8 * var4 >> 11;
               int var10 = var8 * var5 - var4 * var7 >> 11;
               int var11 = var9 + SoundTaskDataProvider.localPlayer.x >> 7;
               int var12 = SoundTaskDataProvider.localPlayer.y - var10 >> 7;
               PacketNode var13 = WorldMapRectangle.method280(ClientPacket.field2396, Client.field957.field1484);
               var13.packetBuffer.putByte(18);
               var13.packetBuffer.method3542(KeyFocusListener.keyPressed[82]?(KeyFocusListener.keyPressed[81]?2:1):0);
               var13.packetBuffer.method3550(var12 + class23.baseY);
               var13.packetBuffer.method3551(var11 + class138.baseX);
               var13.packetBuffer.putByte(var4);
               var13.packetBuffer.putByte(var5);
               var13.packetBuffer.putShort(Client.mapAngle);
               var13.packetBuffer.putByte(57);
               var13.packetBuffer.putByte(0);
               var13.packetBuffer.putByte(0);
               var13.packetBuffer.putByte(89);
               var13.packetBuffer.putShort(SoundTaskDataProvider.localPlayer.x);
               var13.packetBuffer.putShort(SoundTaskDataProvider.localPlayer.y);
               var13.packetBuffer.putByte(63);
               Client.field957.method2052(var13);
               Client.destinationX = var11;
               Client.destinationY = var12;
            }
         }

      }
   }
}
