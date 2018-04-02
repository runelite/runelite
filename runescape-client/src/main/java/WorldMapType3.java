import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ac")
@Implements("WorldMapType3")
public class WorldMapType3 implements WorldMapSectionBase {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 406266375
   )
   int field370;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -2081703867
   )
   int field362;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -891159025
   )
   int field361;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 621368477
   )
   int field364;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -146624447
   )
   int field365;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1736379333
   )
   int field366;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1659737517
   )
   int field367;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 2066081031
   )
   int field371;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 538391943
   )
   int field369;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1510639037
   )
   int field376;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1188760245
   )
   int field374;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1971241401
   )
   int field368;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -435943719
   )
   int field373;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 286046131
   )
   int field372;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Las;I)V",
      garbageValue = "269119455"
   )
   public void vmethod751(WorldMapData var1) {
      if(var1.minX > this.field365) {
         var1.minX = this.field365;
      }

      if(var1.field431 < this.field365) {
         var1.field431 = this.field365;
      }

      if(var1.minY > this.field366) {
         var1.minY = this.field366;
      }

      if(var1.field436 < this.field366) {
         var1.field436 = this.field366;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "520265099"
   )
   public boolean containsCoord(int var1, int var2, int var3) {
      return var1 >= this.field370 && var1 < this.field362 + this.field370?var2 >= (this.field361 << 6) + (this.field367 << 3) && var2 <= (this.field361 << 6) + (this.field369 << 3) + 7 && var3 >= (this.field364 << 6) + (this.field371 << 3) && var3 <= (this.field364 << 6) + (this.field376 << 3) + 7:false;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIS)Z",
      garbageValue = "9376"
   )
   public boolean vmethod758(int var1, int var2) {
      return var1 >= (this.field365 << 6) + (this.field374 << 3) && var1 <= (this.field365 << 6) + (this.field373 << 3) + 7 && var2 >= (this.field366 << 6) + (this.field368 << 3) && var2 <= (this.field366 << 6) + (this.field372 << 3) + 7;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "174791792"
   )
   public int[] vmethod754(int var1, int var2, int var3) {
      if(!this.containsCoord(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field365 * 64 - this.field361 * 64 + var2 + (this.field374 * 8 - this.field367 * 8), var3 + (this.field366 * 64 - this.field364 * 64) + (this.field368 * 8 - this.field371 * 8)};
         return var4;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIB)Lim;",
      garbageValue = "-64"
   )
   public Coordinates vmethod777(int var1, int var2) {
      if(!this.vmethod758(var1, var2)) {
         return null;
      } else {
         int var3 = this.field361 * 64 - this.field365 * 64 + (this.field367 * 8 - this.field374 * 8) + var1;
         int var4 = this.field364 * 64 - this.field366 * 64 + var2 + (this.field371 * 8 - this.field368 * 8);
         return new Coordinates(this.field370, var3, var4);
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lgp;I)V",
      garbageValue = "-314407075"
   )
   public void vmethod756(Buffer var1) {
      this.field370 = var1.readUnsignedByte();
      this.field362 = var1.readUnsignedByte();
      this.field361 = var1.readUnsignedShort();
      this.field367 = var1.readUnsignedByte();
      this.field369 = var1.readUnsignedByte();
      this.field364 = var1.readUnsignedShort();
      this.field371 = var1.readUnsignedByte();
      this.field376 = var1.readUnsignedByte();
      this.field365 = var1.readUnsignedShort();
      this.field374 = var1.readUnsignedByte();
      this.field373 = var1.readUnsignedByte();
      this.field366 = var1.readUnsignedShort();
      this.field368 = var1.readUnsignedByte();
      this.field372 = var1.readUnsignedByte();
      this.method209();
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "78"
   )
   void method209() {
   }
}
