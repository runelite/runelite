import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ad")
@Implements("WorldMapType3")
public class WorldMapType3 implements WorldMapSectionBase {
   @ObfuscatedName("fb")
   @ObfuscatedGetter(
      intValue = -363070555
   )
   static int field371;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 213189871
   )
   int field365;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1943436909
   )
   int field363;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1607733235
   )
   int field359;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -566232043
   )
   int field357;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1568374479
   )
   int field361;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1130368305
   )
   int field362;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -685247359
   )
   int field366;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -937545057
   )
   int field364;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1155184479
   )
   int field358;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 2139076395
   )
   int field360;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1735375101
   )
   int field367;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1123761221
   )
   int field368;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1802609747
   )
   int field369;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1218229169
   )
   int field370;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Las;I)V",
      garbageValue = "-1901809840"
   )
   public void vmethod681(WorldMapData var1) {
      if(var1.field432 > this.field361) {
         var1.field432 = this.field361;
      }

      if(var1.field433 < this.field361) {
         var1.field433 = this.field361;
      }

      if(var1.field426 > this.field362) {
         var1.field426 = this.field362;
      }

      if(var1.field435 < this.field362) {
         var1.field435 = this.field362;
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIIB)Z",
      garbageValue = "-76"
   )
   public boolean vmethod682(int var1, int var2, int var3) {
      return var1 >= this.field365 && var1 < this.field363 + this.field365?var2 >= (this.field359 << 6) + (this.field366 << 3) && var2 <= (this.field359 << 6) + (this.field358 << 3) + 7 && var3 >= (this.field357 << 6) + (this.field364 << 3) && var3 <= (this.field357 << 6) + (this.field360 << 3) + 7:false;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "1516873803"
   )
   public boolean vmethod683(int var1, int var2) {
      return var1 >= (this.field361 << 6) + (this.field367 << 3) && var1 <= (this.field361 << 6) + (this.field369 << 3) + 7 && var2 >= (this.field362 << 6) + (this.field368 << 3) && var2 <= (this.field362 << 6) + (this.field370 << 3) + 7;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "-28346373"
   )
   public int[] vmethod684(int var1, int var2, int var3) {
      if(!this.vmethod682(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field361 * 64 - this.field359 * 64 + var2 + (this.field367 * 8 - this.field366 * 8), var3 + (this.field362 * 64 - this.field357 * 64) + (this.field368 * 8 - this.field364 * 8)};
         return var4;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIB)Lhv;",
      garbageValue = "-92"
   )
   public Coordinates vmethod700(int var1, int var2) {
      if(!this.vmethod683(var1, var2)) {
         return null;
      } else {
         int var3 = this.field359 * 64 - this.field361 * 64 + (this.field366 * 8 - this.field367 * 8) + var1;
         int var4 = this.field357 * 64 - this.field362 * 64 + var2 + (this.field364 * 8 - this.field368 * 8);
         return new Coordinates(this.field365, var3, var4);
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lgy;I)V",
      garbageValue = "1352125466"
   )
   public void vmethod686(Buffer var1) {
      this.field365 = var1.readUnsignedByte();
      this.field363 = var1.readUnsignedByte();
      this.field359 = var1.readUnsignedShort();
      this.field366 = var1.readUnsignedByte();
      this.field358 = var1.readUnsignedByte();
      this.field357 = var1.readUnsignedShort();
      this.field364 = var1.readUnsignedByte();
      this.field360 = var1.readUnsignedByte();
      this.field361 = var1.readUnsignedShort();
      this.field367 = var1.readUnsignedByte();
      this.field369 = var1.readUnsignedByte();
      this.field362 = var1.readUnsignedShort();
      this.field368 = var1.readUnsignedByte();
      this.field370 = var1.readUnsignedByte();
      this.method209();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2143527114"
   )
   void method209() {
   }
}
