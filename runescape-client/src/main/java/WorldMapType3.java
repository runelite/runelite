import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("av")
@Implements("WorldMapType3")
public class WorldMapType3 implements WorldMapSectionBase {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1113615715
   )
   int field358;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 874744723
   )
   int field350;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -579921563
   )
   int field351;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -111817337
   )
   int field353;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -647993333
   )
   int field360;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1932352615
   )
   int field354;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 348870649
   )
   int field359;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1161563447
   )
   int field356;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1636192459
   )
   int field357;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -107532479
   )
   int field362;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1011186279
   )
   int field352;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 997313577
   )
   int field349;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1988774243
   )
   int field361;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 514802271
   )
   int field355;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lai;B)V",
      garbageValue = "59"
   )
   public void vmethod736(WorldMapData var1) {
      if(var1.field419 > this.field360) {
         var1.field419 = this.field360;
      }

      if(var1.field420 < this.field360) {
         var1.field420 = this.field360;
      }

      if(var1.field413 > this.field354) {
         var1.field413 = this.field354;
      }

      if(var1.field422 < this.field354) {
         var1.field422 = this.field354;
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "2052357031"
   )
   public boolean vmethod737(int var1, int var2, int var3) {
      return var1 >= this.field358 && var1 < this.field350 + this.field358?var2 >= (this.field351 << 6) + (this.field359 << 3) && var2 <= (this.field351 << 6) + (this.field357 << 3) + 7 && var3 >= (this.field353 << 6) + (this.field356 << 3) && var3 <= (this.field353 << 6) + (this.field362 << 3) + 7:false;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "1"
   )
   public boolean vmethod745(int var1, int var2) {
      return var1 >= (this.field360 << 6) + (this.field352 << 3) && var1 <= (this.field360 << 6) + (this.field361 << 3) + 7 && var2 >= (this.field354 << 6) + (this.field349 << 3) && var2 <= (this.field354 << 6) + (this.field355 << 3) + 7;
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
         int[] var4 = new int[]{this.field360 * 64 - this.field351 * 64 + var2 + (this.field352 * 8 - this.field359 * 8), var3 + (this.field354 * 64 - this.field353 * 64) + (this.field349 * 8 - this.field356 * 8)};
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
         int var3 = this.field351 * 64 - this.field360 * 64 + (this.field359 * 8 - this.field352 * 8) + var1;
         int var4 = this.field353 * 64 - this.field354 * 64 + var2 + (this.field356 * 8 - this.field349 * 8);
         return new Coordinates(this.field358, var3, var4);
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lgn;I)V",
      garbageValue = "1338328003"
   )
   public void vmethod741(Buffer var1) {
      this.field358 = var1.readUnsignedByte();
      this.field350 = var1.readUnsignedByte();
      this.field351 = var1.readUnsignedShort();
      this.field359 = var1.readUnsignedByte();
      this.field357 = var1.readUnsignedByte();
      this.field353 = var1.readUnsignedShort();
      this.field356 = var1.readUnsignedByte();
      this.field362 = var1.readUnsignedByte();
      this.field360 = var1.readUnsignedShort();
      this.field352 = var1.readUnsignedByte();
      this.field361 = var1.readUnsignedByte();
      this.field354 = var1.readUnsignedShort();
      this.field349 = var1.readUnsignedByte();
      this.field355 = var1.readUnsignedByte();
      this.method221();
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "90"
   )
   void method221() {
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)[Lln;",
      garbageValue = "-2091186694"
   )
   public static class320[] method227() {
      return new class320[]{class320.field3891, class320.field3888, class320.field3887, class320.field3886, class320.field3889};
   }
}
