import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aq")
@Implements("WorldMapType1")
public class WorldMapType1 implements WorldMapSectionBase {
   @ObfuscatedName("qe")
   @ObfuscatedGetter(
      intValue = -1139325753
   )
   static int field407;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -509761655
   )
   int field396;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 2086756381
   )
   int field397;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -446488027
   )
   int field398;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -2044076491
   )
   int field399;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -809475605
   )
   int field400;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -788287631
   )
   int field401;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 547565351
   )
   int field402;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1835668463
   )
   int field403;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 326100629
   )
   int field404;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -66073615
   )
   int field405;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lam;I)V",
      garbageValue = "1999614542"
   )
   public void vmethod670(WorldMapData var1) {
      if(var1.field423 > this.field402) {
         var1.field423 = this.field402;
      }

      if(var1.field424 < this.field404) {
         var1.field424 = this.field404;
      }

      if(var1.field417 > this.field403) {
         var1.field417 = this.field403;
      }

      if(var1.field426 < this.field405) {
         var1.field426 = this.field405;
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIIB)Z",
      garbageValue = "16"
   )
   public boolean vmethod667(int var1, int var2, int var3) {
      return var1 >= this.field396 && var1 < this.field396 + this.field397?var2 >> 6 >= this.field398 && var2 >> 6 <= this.field400 && var3 >> 6 >= this.field399 && var3 >> 6 <= this.field401:false;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "748684240"
   )
   public boolean vmethod668(int var1, int var2) {
      return var1 >> 6 >= this.field402 && var1 >> 6 <= this.field404 && var2 >> 6 >= this.field403 && var2 >> 6 <= this.field405;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "1806249195"
   )
   public int[] vmethod682(int var1, int var2, int var3) {
      if(!this.vmethod667(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field402 * 64 - this.field398 * 64 + var2, var3 + (this.field403 * 64 - this.field399 * 64)};
         return var4;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)Lhk;",
      garbageValue = "-98479540"
   )
   public Coordinates vmethod669(int var1, int var2) {
      if(!this.vmethod668(var1, var2)) {
         return null;
      } else {
         int var3 = this.field398 * 64 - this.field402 * 64 + var1;
         int var4 = this.field399 * 64 - this.field403 * 64 + var2;
         return new Coordinates(this.field396, var3, var4);
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lfs;I)V",
      garbageValue = "-1450864888"
   )
   public void vmethod665(Buffer var1) {
      this.field396 = var1.readUnsignedByte();
      this.field397 = var1.readUnsignedByte();
      this.field398 = var1.readUnsignedShort();
      this.field399 = var1.readUnsignedShort();
      this.field400 = var1.readUnsignedShort();
      this.field401 = var1.readUnsignedShort();
      this.field402 = var1.readUnsignedShort();
      this.field403 = var1.readUnsignedShort();
      this.field404 = var1.readUnsignedShort();
      this.field405 = var1.readUnsignedShort();
      this.method228();
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1856859831"
   )
   void method228() {
   }
}
