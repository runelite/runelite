import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("e")
public final class class25 extends Node {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1799524175
   )
   int field570;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1702802305
   )
   int field571;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -2084798917
   )
   int field572;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 135956229
   )
   int field573;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1319060999
   )
   int field575;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 288316779
   )
   int field576;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 535130495
   )
   int field577 = -1;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1872041301
   )
   int field578;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 2026795993
   )
   int field579;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -72704535
   )
   int field580 = 0;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 645823303
   )
   int field581;
   @ObfuscatedName("bq")
   static class184 field583;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 376906497
   )
   int field584;
   @ObfuscatedName("be")
   static class184 field587;

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lclass68;I)V",
      garbageValue = "-1500641267"
   )
   static final void method558(class68 var0) {
      var0.field1146 = false;
      if(var0.field1143 != null) {
         var0.field1143.field1177 = 0;
      }

      for(class68 var1 = var0.vmethod2625(); null != var1; var1 = var0.vmethod2626()) {
         method558(var1);
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "2066333589"
   )
   @Export("loadWorlds")
   static boolean loadWorlds() {
      try {
         if(null == World.worldServersDownload) {
            World.worldServersDownload = new class26(Tile.field1346, new URL(class167.field2195));
         } else {
            byte[] var0 = World.worldServersDownload.method567();
            if(var0 != null) {
               Buffer var1 = new Buffer(var0);
               World.field679 = var1.readUnsignedShort();
               World.worldList = new World[World.field679];

               World var3;
               for(int var2 = 0; var2 < World.field679; var3.index = var2++) {
                  var3 = World.worldList[var2] = new World();
                  var3.id = var1.readUnsignedShort();
                  var3.mask = var1.method2731();
                  var3.address = var1.method2780();
                  var3.activity = var1.method2780();
                  var3.location = var1.readUnsignedByte();
                  var3.playerCount = var1.method2729();
               }

               class7.method87(World.worldList, 0, World.worldList.length - 1, World.field696, World.field675);
               World.worldServersDownload = null;
               return true;
            }
         }
      } catch (Exception var4) {
         var4.printStackTrace();
         World.worldServersDownload = null;
      }

      return false;
   }
}
