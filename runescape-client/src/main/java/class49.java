import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aj")
public class class49 implements WorldMapSectionBase {
   @ObfuscatedName("bf")
   static String field613;
   @ObfuscatedName("el")
   @ObfuscatedGetter(
      longValue = 5025637420389424525L
   )
   static long field603;
   @ObfuscatedName("gu")
   @ObfuscatedGetter(
      intValue = -1687046997
   )
   @Export("cameraZ")
   static int cameraZ;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 449427065
   )
   int field614;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1887725859
   )
   int field604;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1410425519
   )
   int field605;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1480398269
   )
   int field608;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -141903181
   )
   int field607;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1548944481
   )
   int field612;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 2049877231
   )
   int field609;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -696672361
   )
   int field610;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1299219461
   )
   int field611;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1384014649
   )
   int field606;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lal;B)V",
      garbageValue = "-33"
   )
   public void vmethod716(WorldMapData var1) {
      if(var1.field459 > this.field607) {
         var1.field459 = this.field607;
      }

      if(var1.field460 < this.field607) {
         var1.field460 = this.field607;
      }

      if(var1.field453 > this.field612) {
         var1.field453 = this.field612;
      }

      if(var1.field462 < this.field612) {
         var1.field462 = this.field612;
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "-1122721489"
   )
   public boolean vmethod712(int var1, int var2, int var3) {
      return var1 >= this.field614 && var1 < this.field604 + this.field614?var2 >= (this.field605 << 6) + (this.field609 << 3) && var2 <= (this.field605 << 6) + (this.field609 << 3) + 7 && var3 >= (this.field608 << 6) + (this.field610 << 3) && var3 <= (this.field608 << 6) + (this.field610 << 3) + 7:false;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "-78"
   )
   public boolean vmethod715(int var1, int var2) {
      return var1 >= (this.field607 << 6) + (this.field611 << 3) && var1 <= (this.field607 << 6) + (this.field611 << 3) + 7 && var2 >= (this.field612 << 6) + (this.field606 << 3) && var2 <= (this.field612 << 6) + (this.field606 << 3) + 7;
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
         int[] var4 = new int[]{this.field607 * 64 - this.field605 * 64 + var2 + (this.field611 * 8 - this.field609 * 8), var3 + (this.field612 * 64 - this.field608 * 64) + (this.field606 * 8 - this.field610 * 8)};
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
         int var3 = this.field605 * 64 - this.field607 * 64 + (this.field609 * 8 - this.field611 * 8) + var1;
         int var4 = this.field608 * 64 - this.field612 * 64 + var2 + (this.field610 * 8 - this.field606 * 8);
         return new Coordinates(this.field614, var3, var4);
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lgy;I)V",
      garbageValue = "241325114"
   )
   public void vmethod718(Buffer var1) {
      this.field614 = var1.readUnsignedByte();
      this.field604 = var1.readUnsignedByte();
      this.field605 = var1.readUnsignedShort();
      this.field609 = var1.readUnsignedByte();
      this.field608 = var1.readUnsignedShort();
      this.field610 = var1.readUnsignedByte();
      this.field607 = var1.readUnsignedShort();
      this.field611 = var1.readUnsignedByte();
      this.field612 = var1.readUnsignedShort();
      this.field606 = var1.readUnsignedByte();
      this.method719();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1000284215"
   )
   void method719() {
   }
}
