import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ae")
@Implements("WorldMapType3")
public class WorldMapType3 implements WorldMapSectionBase {
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 789894099
   )
   int field380;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 705850241
   )
   int field381;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1134349089
   )
   int field382;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -282676405
   )
   int field383;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -515070571
   )
   int field384;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1788989105
   )
   int field385;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1728842503
   )
   int field386;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1517538951
   )
   int field387;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1344977837
   )
   int field388;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 954653887
   )
   int field389;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -117156781
   )
   int field391;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -285381199
   )
   int field392;
   @ObfuscatedName("az")
   static ModIcon[] field394;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -848170231
   )
   int field395;
   @ObfuscatedName("gk")
   static SpritePixels[] field396;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1560298341
   )
   int field397;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIIB)[I",
      garbageValue = "-1"
   )
   public int[] vmethod695(int var1, int var2, int var3) {
      if(!this.vmethod693(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{var2 + (this.field384 * 64 - this.field382 * 64) + (this.field387 * 8 - this.field386 * 8), this.field388 * 8 - this.field380 * 8 + this.field385 * 64 - this.field383 * 64 + var3};
         return var4;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-203277119"
   )
   public boolean vmethod713(int var1, int var2) {
      return var1 >= (this.field387 << 3) + (this.field384 << 6) && var1 <= (this.field392 << 3) + (this.field384 << 6) + 7 && var2 >= (this.field385 << 6) + (this.field388 << 3) && var2 <= (this.field385 << 6) + (this.field391 << 3) + 7;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-2062162233"
   )
   public void vmethod697(Buffer var1) {
      this.field395 = var1.readUnsignedByte();
      this.field381 = var1.readUnsignedByte();
      this.field382 = var1.readUnsignedShort();
      this.field386 = var1.readUnsignedByte();
      this.field397 = var1.readUnsignedByte();
      this.field383 = var1.readUnsignedShort();
      this.field380 = var1.readUnsignedByte();
      this.field389 = var1.readUnsignedByte();
      this.field384 = var1.readUnsignedShort();
      this.field387 = var1.readUnsignedByte();
      this.field392 = var1.readUnsignedByte();
      this.field385 = var1.readUnsignedShort();
      this.field388 = var1.readUnsignedByte();
      this.field391 = var1.readUnsignedByte();
      this.method214();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1320212753"
   )
   void method214() {
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIB)Z",
      garbageValue = "-126"
   )
   public boolean vmethod693(int var1, int var2, int var3) {
      return var1 >= this.field395 && var1 < this.field395 + this.field381?var2 >= (this.field386 << 3) + (this.field382 << 6) && var2 <= (this.field397 << 3) + (this.field382 << 6) + 7 && var3 >= (this.field383 << 6) + (this.field380 << 3) && var3 <= (this.field389 << 3) + (this.field383 << 6) + 7:false;
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
         int var3 = this.field386 * 8 - this.field387 * 8 + this.field382 * 64 - this.field384 * 64 + var1;
         int var4 = var2 + (this.field383 * 64 - this.field385 * 64) + (this.field380 * 8 - this.field388 * 8);
         return new Coordinates(this.field395, var3, var4);
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LWorldMapData;B)V",
      garbageValue = "101"
   )
   public void vmethod692(WorldMapData var1) {
      if(var1.field460 > this.field384) {
         var1.field460 = this.field384;
      }

      if(var1.field468 < this.field384) {
         var1.field468 = this.field384;
      }

      if(var1.field465 > this.field385) {
         var1.field465 = this.field385;
      }

      if(var1.field466 < this.field385) {
         var1.field466 = this.field385;
      }

   }

   @ObfuscatedName("ir")
   @ObfuscatedSignature(
      signature = "(LWidget;I)LWidget;",
      garbageValue = "-1677006397"
   )
   static Widget method230(Widget var0) {
      Widget var1 = class168.method3120(var0);
      if(var1 == null) {
         var1 = var0.dragParent;
      }

      return var1;
   }

   @ObfuscatedName("im")
   @ObfuscatedSignature(
      signature = "(LWidgetNode;ZI)V",
      garbageValue = "-352524902"
   )
   static final void method231(WidgetNode var0, boolean var1) {
      int var2 = var0.id;
      int var3 = (int)var0.hash;
      var0.unlink();
      if(var1) {
         ISAACCipher.method3423(var2);
      }

      for(class198 var4 = (class198)Client.widgetFlags.method3548(); var4 != null; var4 = (class198)Client.widgetFlags.method3556()) {
         if((long)var2 == (var4.hash >> 48 & 65535L)) {
            var4.unlink();
         }
      }

      Widget var6 = class177.method3390(var3);
      if(var6 != null) {
         CombatInfo1.method1515(var6);
      }

      Actor.method1512();
      if(Client.widgetRoot != -1) {
         int var5 = Client.widgetRoot;
         if(class73.method1095(var5)) {
            class261.method4764(Widget.widgets[var5], 1);
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-96"
   )
   static void method232() {
      FileOnDisk var0 = null;

      try {
         var0 = class163.getPreferencesFile("", Client.field916.field3197, true);
         Buffer var1 = class66.field801.method1573();
         var0.method2366(var1.payload, 0, var1.offset);
      } catch (Exception var3) {
         ;
      }

      try {
         if(var0 != null) {
            var0.method2368();
         }
      } catch (Exception var2) {
         ;
      }

   }
}
