import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("as")
public class class49 implements WorldMapSectionBase {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Ljz;"
   )
   @Export("currentRequest")
   static FileRequest currentRequest;
   @ObfuscatedName("fr")
   @ObfuscatedSignature(
      signature = "[Lld;"
   )
   @Export("mapDots")
   static SpritePixels[] mapDots;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1656938897
   )
   int field599;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1444697901
   )
   int field597;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1064982653
   )
   int field598;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1077526435
   )
   int field608;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1156672573
   )
   int field600;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1198841443
   )
   int field596;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 661192765
   )
   int field602;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1368684987
   )
   int field603;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1946867459
   )
   int field604;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -459760663
   )
   int field605;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lah;I)V",
      garbageValue = "634115433"
   )
   public void vmethod767(WorldMapData var1) {
      if(var1.minX > this.field600) {
         var1.minX = this.field600;
      }

      if(var1.field455 < this.field600) {
         var1.field455 = this.field600;
      }

      if(var1.minY > this.field596) {
         var1.minY = this.field596;
      }

      if(var1.field457 < this.field596) {
         var1.field457 = this.field596;
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIIB)Z",
      garbageValue = "29"
   )
   public boolean containsCoord(int var1, int var2, int var3) {
      return var1 >= this.field599 && var1 < this.field599 + this.field597?var2 >= (this.field598 << 6) + (this.field602 << 3) && var2 <= (this.field598 << 6) + (this.field602 << 3) + 7 && var3 >= (this.field608 << 6) + (this.field603 << 3) && var3 <= (this.field608 << 6) + (this.field603 << 3) + 7:false;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "230864345"
   )
   public boolean vmethod768(int var1, int var2) {
      return var1 >= (this.field600 << 6) + (this.field604 << 3) && var1 <= (this.field600 << 6) + (this.field604 << 3) + 7 && var2 >= (this.field596 << 6) + (this.field605 << 3) && var2 <= (this.field596 << 6) + (this.field605 << 3) + 7;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIIB)[I",
      garbageValue = "40"
   )
   public int[] vmethod753(int var1, int var2, int var3) {
      if(!this.containsCoord(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field600 * 64 - this.field598 * 64 + var2 + (this.field604 * 8 - this.field602 * 8), var3 + (this.field596 * 64 - this.field608 * 64) + (this.field605 * 8 - this.field603 * 8)};
         return var4;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIB)Lix;",
      garbageValue = "-31"
   )
   public Coordinates vmethod758(int var1, int var2) {
      if(!this.vmethod768(var1, var2)) {
         return null;
      } else {
         int var3 = this.field598 * 64 - this.field600 * 64 + (this.field602 * 8 - this.field604 * 8) + var1;
         int var4 = this.field608 * 64 - this.field596 * 64 + var2 + (this.field603 * 8 - this.field605 * 8);
         return new Coordinates(this.field599, var3, var4);
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lgc;I)V",
      garbageValue = "-2042290425"
   )
   public void vmethod754(Buffer var1) {
      this.field599 = var1.readUnsignedByte();
      this.field597 = var1.readUnsignedByte();
      this.field598 = var1.readUnsignedShort();
      this.field602 = var1.readUnsignedByte();
      this.field608 = var1.readUnsignedShort();
      this.field603 = var1.readUnsignedByte();
      this.field600 = var1.readUnsignedShort();
      this.field604 = var1.readUnsignedByte();
      this.field596 = var1.readUnsignedShort();
      this.field605 = var1.readUnsignedByte();
      this.method756();
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "602545447"
   )
   void method756() {
   }

   @ObfuscatedName("ga")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1703846011"
   )
   static void method755() {
      int var0 = class93.playerIndexesCount;
      int[] var1 = class93.playerIndices;

      for(int var2 = 0; var2 < var0; ++var2) {
         if(var1[var2] != Client.field1112 && var1[var2] != Client.localInteractingIndex) {
            WorldMapManager.method627(Client.cachedPlayers[var1[var2]], true);
         }
      }

   }
}
