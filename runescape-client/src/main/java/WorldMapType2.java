import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("am")
@Implements("WorldMapType2")
public class WorldMapType2 implements WorldMapSectionBase {
   @ObfuscatedName("am")
   protected static String field515;
   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "Lbc;"
   )
   @Export("mouseRecorder")
   static MouseRecorder mouseRecorder;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1542413767
   )
   int field519;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 2135707951
   )
   int field513;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 545675865
   )
   int field516;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1013683485
   )
   int field521;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 456398323
   )
   int field514;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -705865251
   )
   int field517;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lah;I)V",
      garbageValue = "634115433"
   )
   public void vmethod767(WorldMapData var1) {
      if(var1.minX > this.field514) {
         var1.minX = this.field514;
      }

      if(var1.field455 < this.field514) {
         var1.field455 = this.field514;
      }

      if(var1.minY > this.field517) {
         var1.minY = this.field517;
      }

      if(var1.field457 < this.field517) {
         var1.field457 = this.field517;
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIIB)Z",
      garbageValue = "29"
   )
   public boolean containsCoord(int var1, int var2, int var3) {
      return var1 >= this.field519 && var1 < this.field513 + this.field519?var2 >> 6 == this.field516 && var3 >> 6 == this.field521:false;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "230864345"
   )
   public boolean vmethod768(int var1, int var2) {
      return var1 >> 6 == this.field514 && var2 >> 6 == this.field517;
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
         int[] var4 = new int[]{this.field514 * 64 - this.field516 * 64 + var2, var3 + (this.field517 * 64 - this.field521 * 64)};
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
         int var3 = this.field516 * 64 - this.field514 * 64 + var1;
         int var4 = this.field521 * 64 - this.field517 * 64 + var2;
         return new Coordinates(this.field519, var3, var4);
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lgc;I)V",
      garbageValue = "-2042290425"
   )
   public void vmethod754(Buffer var1) {
      this.field519 = var1.readUnsignedByte();
      this.field513 = var1.readUnsignedByte();
      this.field516 = var1.readUnsignedShort();
      this.field521 = var1.readUnsignedShort();
      this.field514 = var1.readUnsignedShort();
      this.field517 = var1.readUnsignedShort();
      this.method559();
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "45"
   )
   void method559() {
   }

   @ObfuscatedName("hd")
   @ObfuscatedSignature(
      signature = "(IIB)Lfr;",
      garbageValue = "1"
   )
   static class178 method578(int var0, int var1) {
      Client.field901.field2296 = var0;
      Client.field901.field2293 = var1;
      Client.field901.field2294 = 1;
      Client.field901.field2295 = 1;
      return Client.field901;
   }
}
