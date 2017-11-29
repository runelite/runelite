import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aq")
@Implements("WorldMapType1")
public class WorldMapType1 implements WorldMapSectionBase {
   @ObfuscatedName("jl")
   @ObfuscatedGetter(
      intValue = 2072173321
   )
   @Export("menuWidth")
   static int menuWidth;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1499806155
   )
   int field406;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1769068483
   )
   int field417;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 818915323
   )
   int field405;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -198232177
   )
   int field407;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1585816541
   )
   int field411;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -92871859
   )
   int field409;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -412419717
   )
   int field410;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -780792805
   )
   int field416;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1680679775
   )
   int field412;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1702042153
   )
   int field413;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lal;I)V",
      garbageValue = "1038625343"
   )
   public void vmethod724(WorldMapData var1) {
      if(var1.field427 > this.field410) {
         var1.field427 = this.field410;
      }

      if(var1.field431 < this.field412) {
         var1.field431 = this.field412;
      }

      if(var1.field428 > this.field416) {
         var1.field428 = this.field416;
      }

      if(var1.field436 < this.field413) {
         var1.field436 = this.field413;
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "952023960"
   )
   public boolean vmethod728(int var1, int var2, int var3) {
      return var1 >= this.field406 && var1 < this.field406 + this.field417?var2 >> 6 >= this.field405 && var2 >> 6 <= this.field411 && var3 >> 6 >= this.field407 && var3 >> 6 <= this.field409:false;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "-27"
   )
   public boolean vmethod716(int var1, int var2) {
      return var1 >> 6 >= this.field410 && var1 >> 6 <= this.field412 && var2 >> 6 >= this.field416 && var2 >> 6 <= this.field413;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "-495685061"
   )
   public int[] vmethod717(int var1, int var2, int var3) {
      if(!this.vmethod728(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field410 * 64 - this.field405 * 64 + var2, var3 + (this.field416 * 64 - this.field407 * 64)};
         return var4;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIB)Lhp;",
      garbageValue = "1"
   )
   public Coordinates vmethod741(int var1, int var2) {
      if(!this.vmethod716(var1, var2)) {
         return null;
      } else {
         int var3 = this.field405 * 64 - this.field410 * 64 + var1;
         int var4 = this.field407 * 64 - this.field416 * 64 + var2;
         return new Coordinates(this.field406, var3, var4);
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lfr;I)V",
      garbageValue = "-1975557779"
   )
   public void vmethod719(Buffer var1) {
      this.field406 = var1.readUnsignedByte();
      this.field417 = var1.readUnsignedByte();
      this.field405 = var1.readUnsignedShort();
      this.field407 = var1.readUnsignedShort();
      this.field411 = var1.readUnsignedShort();
      this.field409 = var1.readUnsignedShort();
      this.field410 = var1.readUnsignedShort();
      this.field416 = var1.readUnsignedShort();
      this.field412 = var1.readUnsignedShort();
      this.field413 = var1.readUnsignedShort();
      this.method252();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "123"
   )
   void method252() {
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)[Lkl;",
      garbageValue = "-2129841392"
   )
   static IndexedSprite[] method271() {
      IndexedSprite[] var0 = new IndexedSprite[class295.field3849];

      for(int var1 = 0; var1 < class295.field3849; ++var1) {
         IndexedSprite var2 = var0[var1] = new IndexedSprite();
         var2.width = class295.field3846;
         var2.originalHeight = class295.field3847;
         var2.offsetX = class295.field3848[var1];
         var2.offsetY = class295.offsetsY[var1];
         var2.originalWidth = class295.field3845[var1];
         var2.height = class285.field3788[var1];
         var2.palette = class115.field1599;
         var2.pixels = TotalQuantityComparator.spritePixels[var1];
      }

      class295.field3848 = null;
      class295.offsetsY = null;
      class295.field3845 = null;
      class285.field3788 = null;
      class115.field1599 = null;
      TotalQuantityComparator.spritePixels = null;
      return var0;
   }

   @ObfuscatedName("ju")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "5"
   )
   static final void method246(int var0) {
      if(ISAACCipher.loadWidget(var0)) {
         Widget[] var1 = class11.widgets[var0];

         for(int var2 = 0; var2 < var1.length; ++var2) {
            Widget var3 = var1[var2];
            if(var3 != null) {
               var3.field2846 = 0;
               var3.field2783 = 0;
            }
         }

      }
   }

   @ObfuscatedName("jm")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "127"
   )
   static final void method268() {
      PacketNode var0 = class218.method4105(ClientPacket.field2313, Client.field916.field1470);
      Client.field916.method1925(var0);

      for(WidgetNode var1 = (WidgetNode)Client.componentTable.first(); var1 != null; var1 = (WidgetNode)Client.componentTable.next()) {
         if(var1.owner == 0 || var1.owner == 3) {
            class39.method552(var1, true);
         }
      }

      if(Client.field1018 != null) {
         class40.method556(Client.field1018);
         Client.field1018 = null;
      }

   }
}
