import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("j")
@Implements("BaseVarType")
public enum BaseVarType implements MouseWheel {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lj;"
   )
   @Export("INTEGER")
   INTEGER(1, 0, Integer.class, new class2()),
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lj;"
   )
   @Export("LONG")
   LONG(0, 1, Long.class, new class3()),
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lj;"
   )
   @Export("STRING")
   STRING(2, 2, String.class, new class5());

   @ObfuscatedName("o")
   static int[] field24;
   @ObfuscatedName("fj")
   @Export("landRegionFileIds")
   static int[] landRegionFileIds;
   @ObfuscatedName("jr")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   static Widget field25;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1113624117
   )
   @Export("id2")
   final int id2;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 2112316573
   )
   @Export("id")
   final int id;

   @ObfuscatedSignature(
      signature = "(IILjava/lang/Class;Lp;)V"
   )
   BaseVarType(int var3, int var4, Class var5, class0 var6) {
      this.id2 = var3;
      this.id = var4;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "8"
   )
   public int rsOrdinal() {
      return this.id;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lik;III)Lko;",
      garbageValue = "-1790744197"
   )
   public static SpritePixels method17(IndexDataBase var0, int var1, int var2) {
      if(!class160.method3147(var0, var1, var2)) {
         return null;
      } else {
         SpritePixels var4 = new SpritePixels();
         var4.maxWidth = class310.field3891;
         var4.maxHeight = class310.field3898;
         var4.offsetX = class310.field3892[0];
         var4.offsetY = class310.offsetsY[0];
         var4.width = class310.field3895[0];
         var4.height = class310.field3896[0];
         int var5 = var4.height * var4.width;
         byte[] var6 = class160.spritePixels[0];
         var4.pixels = new int[var5];

         for(int var7 = 0; var7 < var5; ++var7) {
            var4.pixels[var7] = class310.field3897[var6[var7] & 255];
         }

         class47.method698();
         return var4;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lgd;IB)V",
      garbageValue = "-125"
   )
   @Export("decodeMovement")
   static void decodeMovement(PacketBuffer var0, int var1) {
      boolean var2 = var0.getBits(1) == 1;
      if(var2) {
         class92.field1376[++class92.field1385 - 1] = var1;
      }

      int var3 = var0.getBits(2);
      Player var4 = Client.cachedPlayers[var1];
      if(var3 == 0) {
         if(var2) {
            var4.field812 = false;
         } else if(Client.localInteractingIndex == var1) {
            throw new RuntimeException();
         } else {
            class92.Players_regions[var1] = (var4.field808 << 28) + (class85.baseY + var4.pathY[0] >> 13) + (WorldMapType1.baseX + var4.pathX[0] >> 13 << 14);
            if(var4.field1125 != -1) {
               class92.Players_orientations[var1] = var4.field1125;
            } else {
               class92.Players_orientations[var1] = var4.orientation;
            }

            class92.Players_targetIndices[var1] = var4.interacting;
            Client.cachedPlayers[var1] = null;
            if(var0.getBits(1) != 0) {
               class237.decodeRegionHash(var0, var1);
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

            if(Client.localInteractingIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
               if(var2) {
                  var4.field812 = true;
                  var4.field813 = var6;
                  var4.field814 = var7;
               } else {
                  var4.field812 = false;
                  var4.method1128(var6, var7, class92.field1383[var1]);
               }
            } else {
               var4.method1138(var6, var7);
               var4.field812 = false;
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
               var4.method1138(var6, var7);
               var4.field812 = false;
            } else if(var2) {
               var4.field812 = true;
               var4.field813 = var6;
               var4.field814 = var7;
            } else {
               var4.field812 = false;
               var4.method1128(var6, var7, class92.field1383[var1]);
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
               if(Client.localInteractingIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
                  if(var2) {
                     var4.field812 = true;
                     var4.field813 = var10;
                     var4.field814 = var11;
                  } else {
                     var4.field812 = false;
                     var4.method1128(var10, var11, class92.field1383[var1]);
                  }
               } else {
                  var4.method1138(var10, var11);
                  var4.field812 = false;
               }

               var4.field808 = (byte)(var7 + var4.field808 & 3);
               if(Client.localInteractingIndex == var1) {
                  MessageNode.plane = var4.field808;
               }

            } else {
               var6 = var0.getBits(30);
               var7 = var6 >> 28;
               var8 = var6 >> 14 & 16383;
               var9 = var6 & 16383;
               var10 = (var8 + WorldMapType1.baseX + var4.pathX[0] & 16383) - WorldMapType1.baseX;
               var11 = (var9 + class85.baseY + var4.pathY[0] & 16383) - class85.baseY;
               if(Client.localInteractingIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
                  if(var2) {
                     var4.field812 = true;
                     var4.field813 = var10;
                     var4.field814 = var11;
                  } else {
                     var4.field812 = false;
                     var4.method1128(var10, var11, class92.field1383[var1]);
                  }
               } else {
                  var4.method1138(var10, var11);
                  var4.field812 = false;
               }

               var4.field808 = (byte)(var7 + var4.field808 & 3);
               if(Client.localInteractingIndex == var1) {
                  MessageNode.plane = var4.field808;
               }

            }
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   public static void method16() {
      NPCComposition.npcs.reset();
      NPCComposition.npcModelCache.reset();
   }
}
