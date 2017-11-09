import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("am")
@Implements("WorldMapType2")
public class WorldMapType2 implements WorldMapSectionBase {
   @ObfuscatedName("dl")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   @Export("vorbisIndex")
   static IndexData vorbisIndex;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 367308163
   )
   int field494;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1987323491
   )
   int field493;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1092359709
   )
   int field492;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 938113197
   )
   int field491;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1470198763
   )
   int field495;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 440854055
   )
   int field496;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lap;I)V",
      garbageValue = "-695326084"
   )
   public void vmethod772(WorldMapData var1) {
      if(var1.field430 > this.field495) {
         var1.field430 = this.field495;
      }

      if(var1.field432 < this.field495) {
         var1.field432 = this.field495;
      }

      if(var1.field438 > this.field496) {
         var1.field438 = this.field496;
      }

      if(var1.field439 < this.field496) {
         var1.field439 = this.field496;
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "2104062915"
   )
   public boolean vmethod778(int var1, int var2, int var3) {
      return var1 >= this.field494 && var1 < this.field494 + this.field493?var2 >> 6 == this.field492 && var3 >> 6 == this.field491:false;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "0"
   )
   public boolean vmethod774(int var1, int var2) {
      return var1 >> 6 == this.field495 && var2 >> 6 == this.field496;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "-579666919"
   )
   public int[] vmethod775(int var1, int var2, int var3) {
      if(!this.vmethod778(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field495 * 64 - this.field492 * 64 + var2, var3 + (this.field496 * 64 - this.field491 * 64)};
         return var4;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIB)Lhq;",
      garbageValue = "1"
   )
   public Coordinates vmethod797(int var1, int var2) {
      if(!this.vmethod774(var1, var2)) {
         return null;
      } else {
         int var3 = this.field492 * 64 - this.field495 * 64 + var1;
         int var4 = this.field491 * 64 - this.field496 * 64 + var2;
         return new Coordinates(this.field494, var3, var4);
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lfv;S)V",
      garbageValue = "256"
   )
   public void vmethod777(Buffer var1) {
      this.field494 = var1.readUnsignedByte();
      this.field493 = var1.readUnsignedByte();
      this.field492 = var1.readUnsignedShort();
      this.field491 = var1.readUnsignedShort();
      this.field495 = var1.readUnsignedShort();
      this.field496 = var1.readUnsignedShort();
      this.method562();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1391303379"
   )
   void method562() {
   }
}
