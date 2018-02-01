import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("as")
public class class48 implements WorldMapSectionBase {
   @ObfuscatedName("fq")
   @ObfuscatedSignature(
      signature = "Lee;"
   )
   @Export("region")
   static Region region;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -264720365
   )
   int field565;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -352549737
   )
   int field557;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 57485869
   )
   int field559;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -139920287
   )
   int field560;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1679854071
   )
   int field558;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1385481349
   )
   int field564;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1056894753
   )
   int field563;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 900304343
   )
   int field561;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 702532185
   )
   int field562;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 827276089
   )
   int field566;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lae;I)V",
      garbageValue = "-1518418003"
   )
   public void vmethod701(WorldMapData var1) {
      if(var1.field426 > this.field558) {
         var1.field426 = this.field558;
      }

      if(var1.field433 < this.field558) {
         var1.field433 = this.field558;
      }

      if(var1.field428 > this.field564) {
         var1.field428 = this.field564;
      }

      if(var1.field422 < this.field564) {
         var1.field422 = this.field564;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "-2038931748"
   )
   public boolean vmethod702(int var1, int var2, int var3) {
      return var1 >= this.field565 && var1 < this.field565 + this.field557?var2 >= (this.field559 << 6) + (this.field563 << 3) && var2 <= (this.field559 << 6) + (this.field563 << 3) + 7 && var3 >= (this.field560 << 6) + (this.field561 << 3) && var3 <= (this.field560 << 6) + (this.field561 << 3) + 7:false;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "1297520065"
   )
   public boolean vmethod703(int var1, int var2) {
      return var1 >= (this.field558 << 6) + (this.field562 << 3) && var1 <= (this.field558 << 6) + (this.field562 << 3) + 7 && var2 >= (this.field564 << 6) + (this.field566 << 3) && var2 <= (this.field564 << 6) + (this.field566 << 3) + 7;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "-336358408"
   )
   public int[] vmethod711(int var1, int var2, int var3) {
      if(!this.vmethod702(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field558 * 64 - this.field559 * 64 + var2 + (this.field562 * 8 - this.field563 * 8), var3 + (this.field564 * 64 - this.field560 * 64) + (this.field566 * 8 - this.field561 * 8)};
         return var4;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)Lhn;",
      garbageValue = "1673050917"
   )
   public Coordinates vmethod700(int var1, int var2) {
      if(!this.vmethod703(var1, var2)) {
         return null;
      } else {
         int var3 = this.field559 * 64 - this.field558 * 64 + (this.field563 * 8 - this.field562 * 8) + var1;
         int var4 = this.field560 * 64 - this.field564 * 64 + var2 + (this.field561 * 8 - this.field566 * 8);
         return new Coordinates(this.field565, var3, var4);
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lgj;B)V",
      garbageValue = "7"
   )
   public void vmethod706(Buffer var1) {
      this.field565 = var1.readUnsignedByte();
      this.field557 = var1.readUnsignedByte();
      this.field559 = var1.readUnsignedShort();
      this.field563 = var1.readUnsignedByte();
      this.field560 = var1.readUnsignedShort();
      this.field561 = var1.readUnsignedByte();
      this.field558 = var1.readUnsignedShort();
      this.field562 = var1.readUnsignedByte();
      this.field564 = var1.readUnsignedShort();
      this.field566 = var1.readUnsignedByte();
      this.method721();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1487302059"
   )
   void method721() {
   }
}
