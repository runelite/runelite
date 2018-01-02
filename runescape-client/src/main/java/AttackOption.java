import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cz")
@Implements("AttackOption")
public enum AttackOption implements Enumerated {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lcz;"
   )
   @Export("AttackOption_dependsOnCombatLevels")
   AttackOption_dependsOnCombatLevels(0),
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lcz;"
   )
   @Export("AttackOption_alwaysRightClick")
   AttackOption_alwaysRightClick(1),
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lcz;"
   )
   @Export("AttackOption_leftClickWhereAvailable")
   AttackOption_leftClickWhereAvailable(2),
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lcz;"
   )
   @Export("AttackOption_hidden")
   AttackOption_hidden(3);

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lhz;"
   )
   static Widget field1306;
   @ObfuscatedName("fo")
   @ObfuscatedSignature(
      signature = "[Lkg;"
   )
   @Export("mapscene")
   static IndexedSprite[] mapscene;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1676481437
   )
   @Export("id")
   final int id;

   AttackOption(int var3) {
      this.id = var3;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1035813094"
   )
   public int rsOrdinal() {
      return this.id;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lgh;IIIIIIB)V",
      garbageValue = "15"
   )
   @Export("loadTerrain")
   static final void loadTerrain(Buffer var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7;
      if(var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
         class61.tileSettings[var1][var2][var3] = 0;

         while(true) {
            var7 = var0.readUnsignedByte();
            if(var7 == 0) {
               if(var1 == 0) {
                  int[] var8 = class61.tileHeights[0][var2];
                  int var11 = var2 + var4 + 932731;
                  int var12 = var3 + var5 + 556238;
                  int var13 = MouseRecorder.getSmoothNoise(var11 + 45365, var12 + 91923, 4) - 128 + (MouseRecorder.getSmoothNoise(10294 + var11, 37821 + var12, 2) - 128 >> 1) + (MouseRecorder.getSmoothNoise(var11, var12, 1) - 128 >> 2);
                  var13 = (int)(0.3D * (double)var13) + 35;
                  if(var13 < 10) {
                     var13 = 10;
                  } else if(var13 > 60) {
                     var13 = 60;
                  }

                  var8[var3] = -var13 * 8;
               } else {
                  class61.tileHeights[var1][var2][var3] = class61.tileHeights[var1 - 1][var2][var3] - 240;
               }
               break;
            }

            if(var7 == 1) {
               int var14 = var0.readUnsignedByte();
               if(var14 == 1) {
                  var14 = 0;
               }

               if(var1 == 0) {
                  class61.tileHeights[0][var2][var3] = -var14 * 8;
               } else {
                  class61.tileHeights[var1][var2][var3] = class61.tileHeights[var1 - 1][var2][var3] - var14 * 8;
               }
               break;
            }

            if(var7 <= 49) {
               UrlRequest.field2083[var1][var2][var3] = var0.readByte();
               class168.field2226[var1][var2][var3] = (byte)((var7 - 2) / 4);
               SceneMapObj.field413[var1][var2][var3] = (byte)(var7 - 2 + var6 & 3);
            } else if(var7 <= 81) {
               class61.tileSettings[var1][var2][var3] = (byte)(var7 - 49);
            } else {
               class61.field693[var1][var2][var3] = (byte)(var7 - 81);
            }
         }
      } else {
         while(true) {
            var7 = var0.readUnsignedByte();
            if(var7 == 0) {
               break;
            }

            if(var7 == 1) {
               var0.readUnsignedByte();
               break;
            }

            if(var7 <= 49) {
               var0.readUnsignedByte();
            }
         }
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1987387534"
   )
   public static void method1669() {
      FloorUnderlayDefinition.underlays.reset();
   }

   @ObfuscatedName("fm")
   @ObfuscatedSignature(
      signature = "(Lhz;IIB)V",
      garbageValue = "-44"
   )
   static final void method1678(Widget var0, int var1, int var2) {
      if(Client.field1062 == 0 || Client.field1062 == 3) {
         if(MouseInput.mouseLastButton == 1 || !class34.field455 && MouseInput.mouseLastButton == 4) {
            SpritePixels2 var3 = var0.method4148(true);
            if(var3 == null) {
               return;
            }

            int var4 = MouseInput.mouseLastPressedX - var1;
            int var5 = MouseInput.mouseLastPressedY - var2;
            if(var3.method4073(var4, var5)) {
               var4 -= var3.field2715 / 2;
               var5 -= var3.field2716 / 2;
               int var6 = Client.mapAngle & 2047;
               int var7 = Graphics3D.SINE[var6];
               int var8 = Graphics3D.COSINE[var6];
               int var9 = var5 * var7 + var8 * var4 >> 11;
               int var10 = var8 * var5 - var7 * var4 >> 11;
               int var11 = var9 + UrlRequest.localPlayer.x >> 7;
               int var12 = UrlRequest.localPlayer.y - var10 >> 7;
               PacketNode var13 = FileSystem.bufferForSize(ClientPacket.field2365, Client.signlink.field1449);
               var13.packetBuffer.putByte(18);
               var13.packetBuffer.method3287(KeyFocusListener.field593[82]?(KeyFocusListener.field593[81]?2:1):0);
               var13.packetBuffer.writeIntLE16(var11 + SceneChunkMetadata.baseX);
               var13.packetBuffer.putShortLE(var12 + Client.baseY);
               var13.packetBuffer.putByte(var4);
               var13.packetBuffer.putByte(var5);
               var13.packetBuffer.putShort(Client.mapAngle);
               var13.packetBuffer.putByte(57);
               var13.packetBuffer.putByte(0);
               var13.packetBuffer.putByte(0);
               var13.packetBuffer.putByte(89);
               var13.packetBuffer.putShort(UrlRequest.localPlayer.x);
               var13.packetBuffer.putShort(UrlRequest.localPlayer.y);
               var13.packetBuffer.putByte(63);
               Client.signlink.method1862(var13);
               Client.destinationX = var11;
               Client.destinationY = var12;
            }
         }

      }
   }
}
