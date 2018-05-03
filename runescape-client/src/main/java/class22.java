import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("m")
public class class22 extends class28 {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1774582851
   )
   static int field342;
   @ObfuscatedName("ea")
   @ObfuscatedSignature(
      signature = "Lkh;"
   )
   @Export("fontBold12")
   static Font fontBold12;
   @ObfuscatedName("fj")
   @ObfuscatedSignature(
      signature = "[Llh;"
   )
   @Export("modIconSprites")
   static IndexedSprite[] modIconSprites;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lgg;Lgg;I)V",
      garbageValue = "1076438152"
   )
   void method170(Buffer var1, Buffer var2) {
      int var3 = var2.readUnsignedByte();
      if(var3 != class37.field498.field499) {
         throw new IllegalStateException("");
      } else {
         super.field402 = var2.readUnsignedByte();
         super.field403 = var2.readUnsignedByte();
         super.field405 = var2.readUnsignedShort();
         super.field399 = var2.readUnsignedShort();
         super.field410 = var2.readUnsignedShort();
         super.field398 = var2.readUnsignedShort();
         super.field403 = Math.min(super.field403, 4);
         super.field404 = new short[1][64][64];
         super.field400 = new short[super.field403][64][64];
         super.field406 = new byte[super.field403][64][64];
         super.field407 = new byte[super.field403][64][64];
         super.decorations = new WorldMapDecoration[super.field403][64][64][];
         var3 = var1.readUnsignedByte();
         if(var3 != class36.field490.field491) {
            throw new IllegalStateException("");
         } else {
            int var4 = var1.readUnsignedByte();
            int var5 = var1.readUnsignedByte();
            if(var4 == super.field410 && var5 == super.field398) {
               for(int var6 = 0; var6 < 64; ++var6) {
                  for(int var7 = 0; var7 < 64; ++var7) {
                     this.method223(var6, var7, var1);
                  }
               }

            } else {
               throw new IllegalStateException("");
            }
         }
      }
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof class22)) {
         return false;
      } else {
         class22 var2 = (class22)var1;
         return super.field410 == var2.field410 && super.field398 == var2.field398;
      }
   }

   public int hashCode() {
      return super.field410 | super.field398 << 8;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ILcr;ZI)I",
      garbageValue = "545339252"
   )
   static int method174(int var0, Script var1, boolean var2) {
      Widget var3 = var2?class49.field604:class81.field1270;
      if(var0 == 1700) {
         class81.intStack[++class171.intStackSize - 1] = var3.itemId;
         return 1;
      } else if(var0 == 1701) {
         if(var3.itemId != -1) {
            class81.intStack[++class171.intStackSize - 1] = var3.itemQuantity;
         } else {
            class81.intStack[++class171.intStackSize - 1] = 0;
         }

         return 1;
      } else if(var0 == 1702) {
         class81.intStack[++class171.intStackSize - 1] = var3.index;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("hm")
   @ObfuscatedSignature(
      signature = "(Lbe;I)V",
      garbageValue = "-574894931"
   )
   static final void method169(PendingSpawn var0) {
      int var1 = 0;
      int var2 = -1;
      int var3 = 0;
      int var4 = 0;
      if(var0.type == 0) {
         var1 = GameSocket.region.getWallObjectHash(var0.level, var0.x, var0.y);
      }

      if(var0.type == 1) {
         var1 = GameSocket.region.method3067(var0.level, var0.x, var0.y);
      }

      if(var0.type == 2) {
         var1 = GameSocket.region.method2974(var0.level, var0.x, var0.y);
      }

      if(var0.type == 3) {
         var1 = GameSocket.region.getGroundObjectHash(var0.level, var0.x, var0.y);
      }

      if(var1 != 0) {
         int var5 = GameSocket.region.getObjectFlags(var0.level, var0.x, var0.y, var1);
         var2 = var1 >> 14 & 32767;
         var3 = var5 & 31;
         var4 = var5 >> 6 & 3;
      }

      var0.field1130 = var2;
      var0.field1132 = var3;
      var0.field1128 = var4;
   }

   @ObfuscatedName("hd")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "67"
   )
   static final void method177(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Client.widgetCount; ++var4) {
         if(Client.widgetPositionX[var4] + Client.widgetBoundsWidth[var4] > var0 && Client.widgetPositionX[var4] < var0 + var2 && Client.widgetBoundsHeight[var4] + Client.widgetPositionY[var4] > var1 && Client.widgetPositionY[var4] < var3 + var1) {
            Client.field1055[var4] = true;
         }
      }

   }

   @ObfuscatedName("kp")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-128"
   )
   static void method178() {
      if(class19.field326 != null) {
         Client.field1053 = Client.gameCycle;
         class19.field326.method4819();

         for(int var0 = 0; var0 < Client.cachedPlayers.length; ++var0) {
            if(Client.cachedPlayers[var0] != null) {
               class19.field326.method4811((Client.cachedPlayers[var0].x >> 7) + ClientPacket.baseX, (Client.cachedPlayers[var0].y >> 7) + MapIconReference.baseY);
            }
         }
      }

   }
}
