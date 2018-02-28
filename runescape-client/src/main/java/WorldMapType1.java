import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ah")
@Implements("WorldMapType1")
public class WorldMapType1 implements WorldMapSectionBase {
   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "Llv;"
   )
   static IndexedSprite field406;
   @ObfuscatedName("er")
   @ObfuscatedGetter(
      intValue = 700599479
   )
   @Export("baseY")
   static int baseY;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -2137713337
   )
   int field405;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1941108903
   )
   int field393;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1199044423
   )
   int field394;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1453568325
   )
   int field395;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 139379771
   )
   int field402;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 325457749
   )
   int field397;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 446255185
   )
   int field398;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -749551729
   )
   int field399;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -252507349
   )
   int field401;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1756597461
   )
   int field396;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lai;B)V",
      garbageValue = "59"
   )
   public void vmethod736(WorldMapData var1) {
      if(var1.field419 > this.field398) {
         var1.field419 = this.field398;
      }

      if(var1.field420 < this.field401) {
         var1.field420 = this.field401;
      }

      if(var1.field413 > this.field399) {
         var1.field413 = this.field399;
      }

      if(var1.field422 < this.field396) {
         var1.field422 = this.field396;
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "2052357031"
   )
   public boolean vmethod737(int var1, int var2, int var3) {
      return var1 >= this.field405 && var1 < this.field405 + this.field393?var2 >> 6 >= this.field394 && var2 >> 6 <= this.field402 && var3 >> 6 >= this.field395 && var3 >> 6 <= this.field397:false;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "1"
   )
   public boolean vmethod745(int var1, int var2) {
      return var1 >> 6 >= this.field398 && var1 >> 6 <= this.field401 && var2 >> 6 >= this.field399 && var2 >> 6 <= this.field396;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "-1022148607"
   )
   public int[] vmethod738(int var1, int var2, int var3) {
      if(!this.vmethod737(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field398 * 64 - this.field394 * 64 + var2, var3 + (this.field399 * 64 - this.field395 * 64)};
         return var4;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(III)Lhp;",
      garbageValue = "-1642348517"
   )
   public Coordinates vmethod739(int var1, int var2) {
      if(!this.vmethod745(var1, var2)) {
         return null;
      } else {
         int var3 = this.field394 * 64 - this.field398 * 64 + var1;
         int var4 = this.field395 * 64 - this.field399 * 64 + var2;
         return new Coordinates(this.field405, var3, var4);
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lgn;I)V",
      garbageValue = "1338328003"
   )
   public void vmethod741(Buffer var1) {
      this.field405 = var1.readUnsignedByte();
      this.field393 = var1.readUnsignedByte();
      this.field394 = var1.readUnsignedShort();
      this.field395 = var1.readUnsignedShort();
      this.field402 = var1.readUnsignedShort();
      this.field397 = var1.readUnsignedShort();
      this.field398 = var1.readUnsignedShort();
      this.field399 = var1.readUnsignedShort();
      this.field401 = var1.readUnsignedShort();
      this.field396 = var1.readUnsignedShort();
      this.method278();
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "20025"
   )
   void method278() {
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1906408841"
   )
   @Export("getSmoothNoise2D")
   static final int getSmoothNoise2D(int var0, int var1) {
      int var2 = ContextMenuRow.method1860(var0 - 1, var1 - 1) + ContextMenuRow.method1860(1 + var0, var1 - 1) + ContextMenuRow.method1860(var0 - 1, 1 + var1) + ContextMenuRow.method1860(1 + var0, var1 + 1);
      int var3 = ContextMenuRow.method1860(var0 - 1, var1) + ContextMenuRow.method1860(1 + var0, var1) + ContextMenuRow.method1860(var0, var1 - 1) + ContextMenuRow.method1860(var0, 1 + var1);
      int var4 = ContextMenuRow.method1860(var0, var1);
      return var2 / 16 + var3 / 8 + var4 / 4;
   }

   @ObfuscatedName("fo")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-172722526"
   )
   @Export("setGameState")
   static void setGameState(int var0) {
      if(var0 != Client.gameState) {
         if(Client.gameState == 0) {
            RenderOverview.clientInstance.method891();
         }

         if(var0 == 20 || var0 == 40 || var0 == 45) {
            Client.loginState = 0;
            Client.field853 = 0;
            Client.field861 = 0;
            Client.field912.method5600(var0);
            if(var0 != 20) {
               GrandExchangeEvent.method82(false);
            }
         }

         if(var0 != 20 && var0 != 40 && class1.field11 != null) {
            class1.field11.vmethod3317();
            class1.field11 = null;
         }

         if(Client.gameState == 25) {
            Client.field873 = 0;
            Client.field862 = 0;
            Client.field870 = 1;
            Client.field844 = 0;
            Client.field872 = 1;
         }

         if(var0 != 5 && var0 != 10) {
            if(var0 == 20) {
               GameCanvas.method804(class85.indexCache10, MessageNode.indexSprites, true, Client.gameState == 11?4:0);
            } else if(var0 == 11) {
               GameCanvas.method804(class85.indexCache10, MessageNode.indexSprites, false, 4);
            } else if(class5.field30) {
               class89.field1299 = null;
               class84.field1264 = null;
               class89.runeSprites = null;
               class234.field2759 = null;
               class305.field3806 = null;
               class89.logoSprite = null;
               SoundTask.titlemuteSprite = null;
               WorldComparator.field259 = null;
               class89.field1302 = null;
               class54.field605 = null;
               IndexStoreActionHandler.slFlagSprites = null;
               MapLabel.slArrowSprites = null;
               BoundingBox3D.slStarSprites = null;
               field406 = null;
               class28.field385 = null;
               class153.field2093 = null;
               class27.field370 = null;
               ChatLineBuffer.field1429 = null;
               class36.field471 = null;
               class36.field467 = null;
               class89.field1307 = null;
               DynamicObject.field1422 = null;
               class249.method4517(2);
               class230.sendConInfo(true);
               class5.field30 = false;
            }
         } else {
            GameCanvas.method804(class85.indexCache10, MessageNode.indexSprites, true, 0);
         }

         Client.gameState = var0;
      }
   }

   @ObfuscatedName("gv")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-1716689955"
   )
   @Export("getTileHeight")
   static final int getTileHeight(int var0, int var1, int var2) {
      int var3 = var0 >> 7;
      int var4 = var1 >> 7;
      if(var3 >= 0 && var4 >= 0 && var3 <= 103 && var4 <= 103) {
         int var5 = var2;
         if(var2 < 3 && (class61.tileSettings[1][var3][var4] & 2) == 2) {
            var5 = var2 + 1;
         }

         int var6 = var0 & 127;
         int var7 = var1 & 127;
         int var8 = (128 - var6) * class61.tileHeights[var5][var3][var4] + class61.tileHeights[var5][var3 + 1][var4] * var6 >> 7;
         int var9 = var6 * class61.tileHeights[var5][var3 + 1][var4 + 1] + class61.tileHeights[var5][var3][var4 + 1] * (128 - var6) >> 7;
         return var8 * (128 - var7) + var7 * var9 >> 7;
      } else {
         return 0;
      }
   }
}
