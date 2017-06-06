import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ay")
@Implements("WorldMapType0")
public class WorldMapType0 implements WorldMapSectionBase {
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 136416771
   )
   int field616;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -2137894509
   )
   int field617;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1169093367
   )
   int field618;
   @ObfuscatedName("mz")
   static class156 field619;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1090327043
   )
   int field620;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 311363237
   )
   int field621;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1500492047
   )
   int field622;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 2011101297
   )
   int field623;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -723848785
   )
   int field624;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -867854105
   )
   int field625;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 795458263
   )
   int field627;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LWorldMapData;B)V",
      garbageValue = "-1"
   )
   public void vmethod695(WorldMapData var1) {
      if(var1.field458 > this.field620) {
         var1.field458 = this.field620;
      }

      if(var1.field465 < this.field620) {
         var1.field465 = this.field620;
      }

      if(var1.field456 > this.field627) {
         var1.field456 = this.field627;
      }

      if(var1.field461 < this.field627) {
         var1.field461 = this.field627;
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "952872297"
   )
   public boolean vmethod696(int var1, int var2, int var3) {
      return var1 >= this.field617 && var1 < this.field617 + this.field621?var2 >= (this.field618 << 6) + (this.field622 << 3) && var2 <= (this.field622 << 3) + (this.field618 << 6) + 7 && var3 >= (this.field623 << 3) + (this.field616 << 6) && var3 <= (this.field623 << 3) + (this.field616 << 6) + 7:false;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "-578749739"
   )
   public int[] vmethod698(int var1, int var2, int var3) {
      if(!this.vmethod696(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{var2 + (this.field620 * 64 - this.field618 * 64) + (this.field624 * 8 - this.field622 * 8), this.field625 * 8 - this.field623 * 8 + this.field627 * 64 - this.field616 * 64 + var3};
         return var4;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(III)LCoordinates;",
      garbageValue = "730410078"
   )
   public Coordinates vmethod699(int var1, int var2) {
      if(!this.vmethod707(var1, var2)) {
         return null;
      } else {
         int var3 = this.field618 * 64 - this.field620 * 64 + var1 + (this.field622 * 8 - this.field624 * 8);
         int var4 = this.field616 * 64 - this.field627 * 64 + var2 + (this.field623 * 8 - this.field625 * 8);
         return new Coordinates(this.field617, var3, var4);
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "-56"
   )
   public void vmethod700(Buffer var1) {
      this.field617 = var1.readUnsignedByte();
      this.field621 = var1.readUnsignedByte();
      this.field618 = var1.readUnsignedShort();
      this.field622 = var1.readUnsignedByte();
      this.field616 = var1.readUnsignedShort();
      this.field623 = var1.readUnsignedByte();
      this.field620 = var1.readUnsignedShort();
      this.field624 = var1.readUnsignedByte();
      this.field627 = var1.readUnsignedShort();
      this.field625 = var1.readUnsignedByte();
      this.method701();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2112543104"
   )
   void method701() {
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-106764697"
   )
   public boolean vmethod707(int var1, int var2) {
      return var1 >= (this.field624 << 3) + (this.field620 << 6) && var1 <= (this.field624 << 3) + (this.field620 << 6) + 7 && var2 >= (this.field627 << 6) + (this.field625 << 3) && var2 <= (this.field625 << 3) + (this.field627 << 6) + 7;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "0"
   )
   public static void method722(int var0) {
      class59.mouseIdleTicks = var0;
   }
}
