import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("av")
@Implements("WorldMapType3")
public class WorldMapType3 implements WorldMapSectionBase {
   @ObfuscatedName("gs")
   @ObfuscatedGetter(
      intValue = -43008527
   )
   static int field360;
   @ObfuscatedName("jr")
   @ObfuscatedGetter(
      intValue = -1609990833
   )
   @Export("selectedItemIndex")
   static int selectedItemIndex;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 658722057
   )
   int field358;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -678616357
   )
   int field345;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -976794137
   )
   int field347;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1361421749
   )
   int field346;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 756627647
   )
   int field349;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -10247031
   )
   int field350;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -304747991
   )
   int field351;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1545497331
   )
   int field356;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1018103663
   )
   int field353;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1503945547
   )
   int field354;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 691808905
   )
   int field355;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1182233667
   )
   int field359;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 37686255
   )
   int field348;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -447974483
   )
   int field357;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lam;I)V",
      garbageValue = "1999614542"
   )
   public void vmethod670(WorldMapData var1) {
      if(var1.field423 > this.field349) {
         var1.field423 = this.field349;
      }

      if(var1.field424 < this.field349) {
         var1.field424 = this.field349;
      }

      if(var1.field417 > this.field350) {
         var1.field417 = this.field350;
      }

      if(var1.field426 < this.field350) {
         var1.field426 = this.field350;
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIIB)Z",
      garbageValue = "16"
   )
   public boolean vmethod667(int var1, int var2, int var3) {
      return var1 >= this.field358 && var1 < this.field345 + this.field358?var2 >= (this.field347 << 6) + (this.field351 << 3) && var2 <= (this.field347 << 6) + (this.field353 << 3) + 7 && var3 >= (this.field346 << 6) + (this.field356 << 3) && var3 <= (this.field346 << 6) + (this.field354 << 3) + 7:false;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "748684240"
   )
   public boolean vmethod668(int var1, int var2) {
      return var1 >= (this.field349 << 6) + (this.field355 << 3) && var1 <= (this.field349 << 6) + (this.field348 << 3) + 7 && var2 >= (this.field350 << 6) + (this.field359 << 3) && var2 <= (this.field350 << 6) + (this.field357 << 3) + 7;
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
         int[] var4 = new int[]{this.field349 * 64 - this.field347 * 64 + var2 + (this.field355 * 8 - this.field351 * 8), var3 + (this.field350 * 64 - this.field346 * 64) + (this.field359 * 8 - this.field356 * 8)};
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
         int var3 = this.field347 * 64 - this.field349 * 64 + (this.field351 * 8 - this.field355 * 8) + var1;
         int var4 = this.field346 * 64 - this.field350 * 64 + var2 + (this.field356 * 8 - this.field359 * 8);
         return new Coordinates(this.field358, var3, var4);
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lfs;I)V",
      garbageValue = "-1450864888"
   )
   public void vmethod665(Buffer var1) {
      this.field358 = var1.readUnsignedByte();
      this.field345 = var1.readUnsignedByte();
      this.field347 = var1.readUnsignedShort();
      this.field351 = var1.readUnsignedByte();
      this.field353 = var1.readUnsignedByte();
      this.field346 = var1.readUnsignedShort();
      this.field356 = var1.readUnsignedByte();
      this.field354 = var1.readUnsignedByte();
      this.field349 = var1.readUnsignedShort();
      this.field355 = var1.readUnsignedByte();
      this.field348 = var1.readUnsignedByte();
      this.field350 = var1.readUnsignedShort();
      this.field359 = var1.readUnsignedByte();
      this.field357 = var1.readUnsignedByte();
      this.method188();
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "64"
   )
   void method188() {
   }
}
