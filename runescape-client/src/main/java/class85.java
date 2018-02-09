import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ci")
public class class85 {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lkh;"
   )
   static IndexedSprite field1292;
   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "[Lki;"
   )
   static SpritePixels[] field1291;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lgt;II)V",
      garbageValue = "973821129"
   )
   @Export("decodeMovement")
   static void decodeMovement(PacketBuffer var0, int var1) {
      boolean var2 = var0.getBits(1) == 1;
      if(var2) {
         class92.field1400[++class92.field1399 - 1] = var1;
      }

      int var3 = var0.getBits(2);
      Player var4 = Client.cachedPlayers[var1];
      if(var3 == 0) {
         if(var2) {
            var4.field831 = false;
         } else if(Client.localInteractingIndex == var1) {
            throw new RuntimeException();
         } else {
            class92.Players_regions[var1] = (var4.field827 << 28) + (WorldMapData.baseY + var4.pathY[0] >> 13) + (ClanMemberManager.baseX + var4.pathX[0] >> 13 << 14);
            if(var4.field1142 != -1) {
               class92.Players_orientations[var1] = var4.field1142;
            } else {
               class92.Players_orientations[var1] = var4.orientation;
            }

            class92.Players_targetIndices[var1] = var4.interacting;
            Client.cachedPlayers[var1] = null;
            if(var0.getBits(1) != 0) {
               FriendManager.decodeRegionHash(var0, var1);
            }

         }
      } else {
         int var5;
         int var6;
         int var7;
         if(var3 == 1) {
            var5 = var0.getBits(3);
            var6 = var4.pathX[0];
            var7 = var4.pathY[0];
            if(var5 == 0) {
               --var6;
               --var7;
            } else if(var5 == 1) {
               --var7;
            } else if(var5 == 2) {
               ++var6;
               --var7;
            } else if(var5 == 3) {
               --var6;
            } else if(var5 == 4) {
               ++var6;
            } else if(var5 == 5) {
               --var6;
               ++var7;
            } else if(var5 == 6) {
               ++var7;
            } else if(var5 == 7) {
               ++var6;
               ++var7;
            }

            if(Client.localInteractingIndex == var1 && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
               var4.method1125(var6, var7);
               var4.field831 = false;
            } else if(var2) {
               var4.field831 = true;
               var4.field832 = var6;
               var4.field833 = var7;
            } else {
               var4.field831 = false;
               var4.method1131(var6, var7, class92.field1390[var1]);
            }

         } else if(var3 == 2) {
            var5 = var0.getBits(4);
            var6 = var4.pathX[0];
            var7 = var4.pathY[0];
            if(var5 == 0) {
               var6 -= 2;
               var7 -= 2;
            } else if(var5 == 1) {
               --var6;
               var7 -= 2;
            } else if(var5 == 2) {
               var7 -= 2;
            } else if(var5 == 3) {
               ++var6;
               var7 -= 2;
            } else if(var5 == 4) {
               var6 += 2;
               var7 -= 2;
            } else if(var5 == 5) {
               var6 -= 2;
               --var7;
            } else if(var5 == 6) {
               var6 += 2;
               --var7;
            } else if(var5 == 7) {
               var6 -= 2;
            } else if(var5 == 8) {
               var6 += 2;
            } else if(var5 == 9) {
               var6 -= 2;
               ++var7;
            } else if(var5 == 10) {
               var6 += 2;
               ++var7;
            } else if(var5 == 11) {
               var6 -= 2;
               var7 += 2;
            } else if(var5 == 12) {
               --var6;
               var7 += 2;
            } else if(var5 == 13) {
               var7 += 2;
            } else if(var5 == 14) {
               ++var6;
               var7 += 2;
            } else if(var5 == 15) {
               var6 += 2;
               var7 += 2;
            }

            if(Client.localInteractingIndex == var1 && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
               var4.method1125(var6, var7);
               var4.field831 = false;
            } else if(var2) {
               var4.field831 = true;
               var4.field832 = var6;
               var4.field833 = var7;
            } else {
               var4.field831 = false;
               var4.method1131(var6, var7, class92.field1390[var1]);
            }

         } else {
            var5 = var0.getBits(1);
            int var8;
            int var9;
            int var10;
            int var11;
            if(var5 == 0) {
               var6 = var0.getBits(12);
               var7 = var6 >> 10;
               var8 = var6 >> 5 & 31;
               if(var8 > 15) {
                  var8 -= 32;
               }

               var9 = var6 & 31;
               if(var9 > 15) {
                  var9 -= 32;
               }

               var10 = var8 + var4.pathX[0];
               var11 = var9 + var4.pathY[0];
               if(Client.localInteractingIndex == var1 && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
                  var4.method1125(var10, var11);
                  var4.field831 = false;
               } else if(var2) {
                  var4.field831 = true;
                  var4.field832 = var10;
                  var4.field833 = var11;
               } else {
                  var4.field831 = false;
                  var4.method1131(var10, var11, class92.field1390[var1]);
               }

               var4.field827 = (byte)(var7 + var4.field827 & 3);
               if(Client.localInteractingIndex == var1) {
                  class60.plane = var4.field827;
               }

            } else {
               var6 = var0.getBits(30);
               var7 = var6 >> 28;
               var8 = var6 >> 14 & 16383;
               var9 = var6 & 16383;
               var10 = (var8 + ClanMemberManager.baseX + var4.pathX[0] & 16383) - ClanMemberManager.baseX;
               var11 = (var9 + WorldMapData.baseY + var4.pathY[0] & 16383) - WorldMapData.baseY;
               if(Client.localInteractingIndex == var1 && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
                  var4.method1125(var10, var11);
                  var4.field831 = false;
               } else if(var2) {
                  var4.field831 = true;
                  var4.field832 = var10;
                  var4.field833 = var11;
               } else {
                  var4.field831 = false;
                  var4.method1131(var10, var11, class92.field1390[var1]);
               }

               var4.field827 = (byte)(var7 + var4.field827 & 3);
               if(Client.localInteractingIndex == var1) {
                  class60.plane = var4.field827;
               }

            }
         }
      }
   }
}
