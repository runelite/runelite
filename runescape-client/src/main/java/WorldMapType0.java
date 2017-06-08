import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ay")
@Implements("WorldMapType0")
public class WorldMapType0 implements WorldMapSectionBase {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1059016459
   )
   int field602;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1695828949
   )
   int field603;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -670514747
   )
   int field604;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 46004423
   )
   int field606;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -667394109
   )
   int field607;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1890446405
   )
   int field608;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -355160483
   )
   int field609;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -657031219
   )
   int field610;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -233679889
   )
   int field611;
   @ObfuscatedName("pd")
   static class102 field613;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1518447379
   )
   int field615;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LWorldMapData;B)V",
      garbageValue = "101"
   )
   public void vmethod692(WorldMapData var1) {
      if(var1.field460 > this.field606) {
         var1.field460 = this.field606;
      }

      if(var1.field468 < this.field606) {
         var1.field468 = this.field606;
      }

      if(var1.field465 > this.field607) {
         var1.field465 = this.field607;
      }

      if(var1.field466 < this.field607) {
         var1.field466 = this.field607;
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIB)Z",
      garbageValue = "-126"
   )
   public boolean vmethod693(int var1, int var2, int var3) {
      return var1 >= this.field615 && var1 < this.field615 + this.field603?var2 >= (this.field608 << 3) + (this.field604 << 6) && var2 <= (this.field604 << 6) + (this.field608 << 3) + 7 && var3 >= (this.field610 << 6) + (this.field609 << 3) && var3 <= (this.field610 << 6) + (this.field609 << 3) + 7:false;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1247170971"
   )
   void method694() {
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIIB)[I",
      garbageValue = "-1"
   )
   public int[] vmethod695(int var1, int var2, int var3) {
      if(!this.vmethod693(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field602 * 8 - this.field608 * 8 + var2 + (this.field606 * 64 - this.field604 * 64), this.field611 * 8 - this.field609 * 8 + this.field607 * 64 - this.field610 * 64 + var3};
         return var4;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(III)LCoordinates;",
      garbageValue = "1721490041"
   )
   public Coordinates vmethod696(int var1, int var2) {
      if(!this.vmethod713(var1, var2)) {
         return null;
      } else {
         int var3 = var1 + (this.field604 * 64 - this.field606 * 64) + (this.field608 * 8 - this.field602 * 8);
         int var4 = this.field609 * 8 - this.field611 * 8 + var2 + (this.field610 * 64 - this.field607 * 64);
         return new Coordinates(this.field615, var3, var4);
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-2062162233"
   )
   public void vmethod697(Buffer var1) {
      this.field615 = var1.readUnsignedByte();
      this.field603 = var1.readUnsignedByte();
      this.field604 = var1.readUnsignedShort();
      this.field608 = var1.readUnsignedByte();
      this.field610 = var1.readUnsignedShort();
      this.field609 = var1.readUnsignedByte();
      this.field606 = var1.readUnsignedShort();
      this.field602 = var1.readUnsignedByte();
      this.field607 = var1.readUnsignedShort();
      this.field611 = var1.readUnsignedByte();
      this.method694();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)Ljava/lang/String;",
      garbageValue = "29"
   )
   public static String method698(CharSequence var0) {
      int var2 = var0.length();
      char[] var3 = new char[var2];

      for(int var4 = 0; var4 < var2; ++var4) {
         var3[var4] = 42;
      }

      String var1 = new String(var3);
      return var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-203277119"
   )
   public boolean vmethod713(int var1, int var2) {
      return var1 >= (this.field606 << 6) + (this.field602 << 3) && var1 <= (this.field602 << 3) + (this.field606 << 6) + 7 && var2 >= (this.field611 << 3) + (this.field607 << 6) && var2 <= (this.field607 << 6) + (this.field611 << 3) + 7;
   }
}
