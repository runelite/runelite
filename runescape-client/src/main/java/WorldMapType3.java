import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ad")
@Implements("WorldMapType3")
public class WorldMapType3 implements WorldMapSectionBase {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -920058365
   )
   int field369;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 973612321
   )
   int field370;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -619882877
   )
   int field371;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -555071493
   )
   int field372;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -347360899
   )
   int field374;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1347775897
   )
   int field375;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1892202219
   )
   int field376;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -303425729
   )
   int field377;
   @ObfuscatedName("ew")
   static class262 field378;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1792442263
   )
   int field379;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 256344041
   )
   int field380;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1979178705
   )
   int field381;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -190716409
   )
   int field382;
   @ObfuscatedName("ch")
   @Export("indexTextures")
   static IndexData indexTextures;
   @ObfuscatedName("eq")
   @ObfuscatedGetter(
      intValue = -731621631
   )
   @Export("baseY")
   static int baseY;
   @ObfuscatedName("jg")
   @ObfuscatedGetter(
      intValue = -691878979
   )
   @Export("menuY")
   static int menuY;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1484554361
   )
   int field388;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -242778101
   )
   int field390;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LWorldMapData;B)V",
      garbageValue = "-1"
   )
   public void vmethod695(WorldMapData var1) {
      if(var1.field458 > this.field369) {
         var1.field458 = this.field369;
      }

      if(var1.field465 < this.field369) {
         var1.field465 = this.field369;
      }

      if(var1.field456 > this.field374) {
         var1.field456 = this.field374;
      }

      if(var1.field461 < this.field374) {
         var1.field461 = this.field374;
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "952872297"
   )
   public boolean vmethod696(int var1, int var2, int var3) {
      return var1 >= this.field388 && var1 < this.field388 + this.field370?var2 >= (this.field372 << 6) + (this.field375 << 3) && var2 <= (this.field377 << 3) + (this.field372 << 6) + 7 && var3 >= (this.field390 << 6) + (this.field376 << 3) && var3 <= (this.field381 << 3) + (this.field390 << 6) + 7:false;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-106764697"
   )
   public boolean vmethod707(int var1, int var2) {
      return var1 >= (this.field369 << 6) + (this.field379 << 3) && var1 <= (this.field371 << 3) + (this.field369 << 6) + 7 && var2 >= (this.field374 << 6) + (this.field380 << 3) && var2 <= (this.field374 << 6) + (this.field382 << 3) + 7;
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
         int[] var4 = new int[]{this.field379 * 8 - this.field375 * 8 + var2 + (this.field369 * 64 - this.field372 * 64), this.field380 * 8 - this.field376 * 8 + this.field374 * 64 - this.field390 * 64 + var3};
         return var4;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1945367435"
   )
   void method178() {
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "-56"
   )
   public void vmethod700(Buffer var1) {
      this.field388 = var1.readUnsignedByte();
      this.field370 = var1.readUnsignedByte();
      this.field372 = var1.readUnsignedShort();
      this.field375 = var1.readUnsignedByte();
      this.field377 = var1.readUnsignedByte();
      this.field390 = var1.readUnsignedShort();
      this.field376 = var1.readUnsignedByte();
      this.field381 = var1.readUnsignedByte();
      this.field369 = var1.readUnsignedShort();
      this.field379 = var1.readUnsignedByte();
      this.field371 = var1.readUnsignedByte();
      this.field374 = var1.readUnsignedShort();
      this.field380 = var1.readUnsignedByte();
      this.field382 = var1.readUnsignedByte();
      this.method178();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "41"
   )
   @Export("loadWorlds")
   static boolean loadWorlds() {
      try {
         if(class36.worldServersDownload == null) {
            class36.worldServersDownload = new class77(GameEngine.field721, new URL(class66.field824));
         } else {
            byte[] var0 = class36.worldServersDownload.method1507();
            if(var0 != null) {
               Buffer var1 = new Buffer(var0);
               World.field1326 = var1.readUnsignedShort();
               World.worldList = new World[World.field1326];

               World var3;
               for(int var2 = 0; var2 < World.field1326; var3.index = var2++) {
                  var3 = World.worldList[var2] = new World();
                  var3.id = var1.readUnsignedShort();
                  var3.mask = var1.readInt();
                  var3.address = var1.readString();
                  var3.activity = var1.readString();
                  var3.location = var1.readUnsignedByte();
                  var3.playerCount = var1.readShort();
               }

               class166.method3079(World.worldList, 0, World.worldList.length - 1, World.field1328, World.field1318);
               class36.worldServersDownload = null;
               return true;
            }
         }
      } catch (Exception var4) {
         var4.printStackTrace();
         class36.worldServersDownload = null;
      }

      return false;
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
         int var3 = var1 + (this.field372 * 64 - this.field369 * 64) + (this.field375 * 8 - this.field379 * 8);
         int var4 = var2 + (this.field390 * 64 - this.field374 * 64) + (this.field376 * 8 - this.field380 * 8);
         return new Coordinates(this.field388, var3, var4);
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)LWidget;",
      garbageValue = "65280"
   )
   public static Widget method199(int var0) {
      int var1 = var0 >> 16;
      int var2 = var0 & '\uffff';
      if(CombatInfo1.widgets[var1] == null || CombatInfo1.widgets[var1][var2] == null) {
         boolean var3 = RSSocket.method2986(var1);
         if(!var3) {
            return null;
         }
      }

      return CombatInfo1.widgets[var1][var2];
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "0"
   )
   static void method200(int var0, int var1) {
      int[] var2 = new int[4];
      int[] var3 = new int[4];
      var2[0] = var0;
      var3[0] = var1;
      int var4 = 1;

      for(int var5 = 0; var5 < 4; ++var5) {
         if(World.field1328[var5] != var0) {
            var2[var4] = World.field1328[var5];
            var3[var4] = World.field1318[var5];
            ++var4;
         }
      }

      World.field1328 = var2;
      World.field1318 = var3;
      class166.method3079(World.worldList, 0, World.worldList.length - 1, World.field1328, World.field1318);
   }
}
