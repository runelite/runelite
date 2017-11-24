import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ah")
@Implements("WorldMapType3")
public class WorldMapType3 implements WorldMapSectionBase {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -515412299
   )
   int field364;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1522383719
   )
   int field362;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 2066849077
   )
   int field355;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -163273639
   )
   int field356;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1934561623
   )
   int field354;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -514507801
   )
   int field358;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1374490977
   )
   int field353;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -586048053
   )
   int field357;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1356769195
   )
   int field359;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1482128499
   )
   int field361;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -723222401
   )
   int field363;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1673986525
   )
   int field360;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 534282559
   )
   int field365;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1732474743
   )
   int field366;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lal;I)V",
      garbageValue = "1038625343"
   )
   public void vmethod724(WorldMapData var1) {
      if(var1.field427 > this.field354) {
         var1.field427 = this.field354;
      }

      if(var1.field431 < this.field354) {
         var1.field431 = this.field354;
      }

      if(var1.field428 > this.field358) {
         var1.field428 = this.field358;
      }

      if(var1.field436 < this.field358) {
         var1.field436 = this.field358;
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "952023960"
   )
   public boolean vmethod728(int var1, int var2, int var3) {
      return var1 >= this.field364 && var1 < this.field364 + this.field362?var2 >= (this.field355 << 6) + (this.field353 << 3) && var2 <= (this.field355 << 6) + (this.field359 << 3) + 7 && var3 >= (this.field356 << 6) + (this.field357 << 3) && var3 <= (this.field356 << 6) + (this.field361 << 3) + 7:false;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "-27"
   )
   public boolean vmethod716(int var1, int var2) {
      return var1 >= (this.field354 << 6) + (this.field363 << 3) && var1 <= (this.field354 << 6) + (this.field365 << 3) + 7 && var2 >= (this.field358 << 6) + (this.field360 << 3) && var2 <= (this.field358 << 6) + (this.field366 << 3) + 7;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "-495685061"
   )
   public int[] vmethod717(int var1, int var2, int var3) {
      if(!this.vmethod728(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field354 * 64 - this.field355 * 64 + var2 + (this.field363 * 8 - this.field353 * 8), var3 + (this.field358 * 64 - this.field356 * 64) + (this.field360 * 8 - this.field357 * 8)};
         return var4;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIB)Lhp;",
      garbageValue = "1"
   )
   public Coordinates vmethod741(int var1, int var2) {
      if(!this.vmethod716(var1, var2)) {
         return null;
      } else {
         int var3 = this.field355 * 64 - this.field354 * 64 + (this.field353 * 8 - this.field363 * 8) + var1;
         int var4 = this.field356 * 64 - this.field358 * 64 + var2 + (this.field357 * 8 - this.field360 * 8);
         return new Coordinates(this.field364, var3, var4);
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lfr;I)V",
      garbageValue = "-1975557779"
   )
   public void vmethod719(Buffer var1) {
      this.field364 = var1.readUnsignedByte();
      this.field362 = var1.readUnsignedByte();
      this.field355 = var1.readUnsignedShort();
      this.field353 = var1.readUnsignedByte();
      this.field359 = var1.readUnsignedByte();
      this.field356 = var1.readUnsignedShort();
      this.field357 = var1.readUnsignedByte();
      this.field361 = var1.readUnsignedByte();
      this.field354 = var1.readUnsignedShort();
      this.field363 = var1.readUnsignedByte();
      this.field365 = var1.readUnsignedByte();
      this.field358 = var1.readUnsignedShort();
      this.field360 = var1.readUnsignedByte();
      this.field366 = var1.readUnsignedByte();
      this.method198();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1036368557"
   )
   void method198() {
   }
}
