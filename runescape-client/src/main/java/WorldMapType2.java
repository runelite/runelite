import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("am")
@Implements("WorldMapType2")
public class WorldMapType2 implements WorldMapSectionBase {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lfh;"
   )
   @Export("timer")
   protected static Timer timer;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -1433398193
   )
   static int field499;
   @ObfuscatedName("db")
   @ObfuscatedGetter(
      intValue = 1178031753
   )
   @Export("port1")
   static int port1;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1168879599
   )
   int field497;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1283791051
   )
   int field496;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1659648265
   )
   int field492;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 295181523
   )
   int field493;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 682977077
   )
   int field494;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 576707389
   )
   int field495;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Las;I)V",
      garbageValue = "-1901809840"
   )
   public void vmethod681(WorldMapData var1) {
      if(var1.field432 > this.field494) {
         var1.field432 = this.field494;
      }

      if(var1.field433 < this.field494) {
         var1.field433 = this.field494;
      }

      if(var1.field426 > this.field495) {
         var1.field426 = this.field495;
      }

      if(var1.field435 < this.field495) {
         var1.field435 = this.field495;
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIIB)Z",
      garbageValue = "-76"
   )
   public boolean vmethod682(int var1, int var2, int var3) {
      return var1 >= this.field497 && var1 < this.field496 + this.field497?var2 >> 6 == this.field492 && var3 >> 6 == this.field493:false;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "1516873803"
   )
   public boolean vmethod683(int var1, int var2) {
      return var1 >> 6 == this.field494 && var2 >> 6 == this.field495;
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
         int[] var4 = new int[]{this.field494 * 64 - this.field492 * 64 + var2, var3 + (this.field495 * 64 - this.field493 * 64)};
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
         int var3 = this.field492 * 64 - this.field494 * 64 + var1;
         int var4 = this.field493 * 64 - this.field495 * 64 + var2;
         return new Coordinates(this.field497, var3, var4);
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lgy;I)V",
      garbageValue = "1352125466"
   )
   public void vmethod686(Buffer var1) {
      this.field497 = var1.readUnsignedByte();
      this.field496 = var1.readUnsignedByte();
      this.field492 = var1.readUnsignedShort();
      this.field493 = var1.readUnsignedShort();
      this.field494 = var1.readUnsignedShort();
      this.field495 = var1.readUnsignedShort();
      this.method500();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "117"
   )
   void method500() {
   }

   @ObfuscatedName("fu")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "698728883"
   )
   static final void method516() {
      Client.field937.close();
      ObjectComposition.method4931();
      TotalQuantityComparator.region.reset();

      for(int var0 = 0; var0 < 4; ++var0) {
         Client.collisionMaps[var0].reset();
      }

      System.gc();
      UnitPriceComparator.method132(2);
      Client.field902 = -1;
      Client.field1059 = false;

      for(class79 var1 = (class79)class79.field1233.getFront(); var1 != null; var1 = (class79)class79.field1233.getNext()) {
         if(var1.field1231 != null) {
            class33.field450.method2117(var1.field1231);
            var1.field1231 = null;
         }

         if(var1.field1220 != null) {
            class33.field450.method2117(var1.field1220);
            var1.field1220 = null;
         }
      }

      class79.field1233.clear();
      class87.setGameState(10);
   }

   @ObfuscatedName("ja")
   @ObfuscatedSignature(
      signature = "(IIIILki;Lhg;I)V",
      garbageValue = "274977333"
   )
   @Export("drawDot")
   static final void drawDot(int var0, int var1, int var2, int var3, SpritePixels var4, class221 var5) {
      if(var4 != null) {
         int var6 = Client.mapAngle & 2047;
         int var7 = var3 * var3 + var2 * var2;
         if(var7 <= 6400) {
            int var8 = Graphics3D.SINE[var6];
            int var9 = Graphics3D.COSINE[var6];
            int var10 = var9 * var2 + var3 * var8 >> 16;
            int var11 = var3 * var9 - var8 * var2 >> 16;
            if(var7 > 2500) {
               var4.method5701(var10 + var5.field2708 / 2 - var4.maxWidth / 2, var5.field2703 / 2 - var11 - var4.maxHeight / 2, var0, var1, var5.field2708, var5.field2703, var5.field2704, var5.field2702);
            } else {
               var4.drawAt(var0 + var10 + var5.field2708 / 2 - var4.maxWidth / 2, var5.field2703 / 2 + var1 - var11 - var4.maxHeight / 2);
            }

         }
      }
   }
}
