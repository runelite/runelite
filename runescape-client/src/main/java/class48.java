import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("au")
public class class48 implements WorldMapSectionBase {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1963811895
   )
   int field617;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 926723313
   )
   int field618;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1163966231
   )
   int field619;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1766457177
   )
   int field620;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1227892165
   )
   int field621;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1478937707
   )
   int field622;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -693174793
   )
   int field623;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1758225405
   )
   int field624;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -277835471
   )
   int field625;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1905902237
   )
   int field626;
   @ObfuscatedName("l")
   static int[] field629;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "-2095092414"
   )
   public boolean vmethod678(int var1, int var2, int var3) {
      return var1 >= this.field618 && var1 < this.field622 + this.field618?var2 >= (this.field623 << 6) + (this.field619 << 3) && var2 <= (this.field623 << 6) + (this.field619 << 3) + 7 && var3 >= (this.field617 << 6) + (this.field620 << 3) && var3 <= (this.field617 << 6) + (this.field620 << 3) + 7:false;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "108"
   )
   public boolean vmethod679(int var1, int var2) {
      return var1 >= (this.field621 << 6) + (this.field624 << 3) && var1 <= (this.field621 << 6) + (this.field624 << 3) + 7 && var2 >= (this.field626 << 6) + (this.field625 << 3) && var2 <= (this.field626 << 6) + (this.field625 << 3) + 7;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LWorldMapData;I)V",
      garbageValue = "-466828627"
   )
   public void vmethod680(WorldMapData var1) {
      if(var1.field459 > this.field621) {
         var1.field459 = this.field621;
      }

      if(var1.field465 < this.field621) {
         var1.field465 = this.field621;
      }

      if(var1.field466 > this.field626) {
         var1.field466 = this.field626;
      }

      if(var1.field458 < this.field626) {
         var1.field458 = this.field626;
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2121949816"
   )
   void method681() {
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "630255391"
   )
   public int[] vmethod682(int var1, int var2, int var3) {
      if(!this.vmethod678(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{var2 + (this.field624 * 8 - this.field619 * 8) + (this.field621 * 64 - this.field623 * 64), var3 + (this.field625 * 8 - this.field620 * 8 + this.field626 * 64 - this.field617 * 64)};
         return var4;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1315256502"
   )
   public void vmethod684(Buffer var1) {
      this.field618 = var1.readUnsignedByte();
      this.field622 = var1.readUnsignedByte();
      this.field623 = var1.readUnsignedShort();
      this.field619 = var1.readUnsignedByte();
      this.field617 = var1.readUnsignedShort();
      this.field620 = var1.readUnsignedByte();
      this.field621 = var1.readUnsignedShort();
      this.field624 = var1.readUnsignedByte();
      this.field626 = var1.readUnsignedShort();
      this.field625 = var1.readUnsignedByte();
      this.method681();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)LCoordinates;",
      garbageValue = "-1537373407"
   )
   public Coordinates vmethod685(int var1, int var2) {
      if(!this.vmethod679(var1, var2)) {
         return null;
      } else {
         int var3 = this.field623 * 64 + (this.field619 * 8 - this.field624 * 8) - this.field621 * 64 + var1;
         int var4 = var2 + (this.field620 * 8 - this.field625 * 8) + (this.field617 * 64 - this.field626 * 64);
         return new Coordinates(this.field618, var3, var4);
      }
   }
}
