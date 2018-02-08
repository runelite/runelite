import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ay")
public class class48 implements WorldMapSectionBase {
   @ObfuscatedName("cq")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   @Export("indexModels")
   static IndexData indexModels;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1878302115
   )
   int field589;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -659162137
   )
   int field582;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 49711685
   )
   int field577;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -989320859
   )
   int field580;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1828375015
   )
   int field581;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -2057556143
   )
   int field583;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 637934943
   )
   int field578;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1846265591
   )
   int field584;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 992068381
   )
   int field585;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1170852001
   )
   int field586;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Las;I)V",
      garbageValue = "-1901809840"
   )
   public void vmethod681(WorldMapData var1) {
      if(var1.field432 > this.field581) {
         var1.field432 = this.field581;
      }

      if(var1.field433 < this.field581) {
         var1.field433 = this.field581;
      }

      if(var1.field426 > this.field583) {
         var1.field426 = this.field583;
      }

      if(var1.field435 < this.field583) {
         var1.field435 = this.field583;
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIIB)Z",
      garbageValue = "-76"
   )
   public boolean vmethod682(int var1, int var2, int var3) {
      return var1 >= this.field589 && var1 < this.field582 + this.field589?var2 >= (this.field577 << 6) + (this.field578 << 3) && var2 <= (this.field577 << 6) + (this.field578 << 3) + 7 && var3 >= (this.field580 << 6) + (this.field584 << 3) && var3 <= (this.field580 << 6) + (this.field584 << 3) + 7:false;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "1516873803"
   )
   public boolean vmethod683(int var1, int var2) {
      return var1 >= (this.field581 << 6) + (this.field585 << 3) && var1 <= (this.field581 << 6) + (this.field585 << 3) + 7 && var2 >= (this.field583 << 6) + (this.field586 << 3) && var2 <= (this.field583 << 6) + (this.field586 << 3) + 7;
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
         int[] var4 = new int[]{this.field581 * 64 - this.field577 * 64 + var2 + (this.field585 * 8 - this.field578 * 8), var3 + (this.field583 * 64 - this.field580 * 64) + (this.field586 * 8 - this.field584 * 8)};
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
         int var3 = this.field577 * 64 - this.field581 * 64 + (this.field578 * 8 - this.field585 * 8) + var1;
         int var4 = this.field580 * 64 - this.field583 * 64 + var2 + (this.field584 * 8 - this.field586 * 8);
         return new Coordinates(this.field589, var3, var4);
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lgy;I)V",
      garbageValue = "1352125466"
   )
   public void vmethod686(Buffer var1) {
      this.field589 = var1.readUnsignedByte();
      this.field582 = var1.readUnsignedByte();
      this.field577 = var1.readUnsignedShort();
      this.field578 = var1.readUnsignedByte();
      this.field580 = var1.readUnsignedShort();
      this.field584 = var1.readUnsignedByte();
      this.field581 = var1.readUnsignedShort();
      this.field585 = var1.readUnsignedByte();
      this.field583 = var1.readUnsignedShort();
      this.field586 = var1.readUnsignedByte();
      this.method687();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1468855137"
   )
   void method687() {
   }
}
