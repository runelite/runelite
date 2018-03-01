import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ar")
@Implements("WorldMapType2")
public class WorldMapType2 implements WorldMapSectionBase {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 381441827
   )
   int field527;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 703077797
   )
   int field528;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -901440297
   )
   int field524;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1524862395
   )
   int field522;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -586464603
   )
   int field526;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -2064984113
   )
   int field529;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lal;B)V",
      garbageValue = "-33"
   )
   public void vmethod716(WorldMapData var1) {
      if(var1.field459 > this.field526) {
         var1.field459 = this.field526;
      }

      if(var1.field460 < this.field526) {
         var1.field460 = this.field526;
      }

      if(var1.field453 > this.field529) {
         var1.field453 = this.field529;
      }

      if(var1.field462 < this.field529) {
         var1.field462 = this.field529;
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "-1122721489"
   )
   public boolean vmethod712(int var1, int var2, int var3) {
      return var1 >= this.field527 && var1 < this.field527 + this.field528?var2 >> 6 == this.field524 && var3 >> 6 == this.field522:false;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "-78"
   )
   public boolean vmethod715(int var1, int var2) {
      return var1 >> 6 == this.field526 && var2 >> 6 == this.field529;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "606812260"
   )
   public int[] vmethod714(int var1, int var2, int var3) {
      if(!this.vmethod712(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field526 * 64 - this.field524 * 64 + var2, var3 + (this.field529 * 64 - this.field522 * 64)};
         return var4;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(III)Lic;",
      garbageValue = "-1902472796"
   )
   public Coordinates vmethod717(int var1, int var2) {
      if(!this.vmethod715(var1, var2)) {
         return null;
      } else {
         int var3 = this.field524 * 64 - this.field526 * 64 + var1;
         int var4 = this.field522 * 64 - this.field529 * 64 + var2;
         return new Coordinates(this.field527, var3, var4);
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lgy;I)V",
      garbageValue = "241325114"
   )
   public void vmethod718(Buffer var1) {
      this.field527 = var1.readUnsignedByte();
      this.field528 = var1.readUnsignedByte();
      this.field524 = var1.readUnsignedShort();
      this.field522 = var1.readUnsignedShort();
      this.field526 = var1.readUnsignedShort();
      this.field529 = var1.readUnsignedShort();
      this.method526();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "25"
   )
   void method526() {
   }
}
