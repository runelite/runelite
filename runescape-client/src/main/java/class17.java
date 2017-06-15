import java.lang.management.GarbageCollectorMXBean;
import java.net.URL;
import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("k")
final class class17 implements Comparator {
   @ObfuscatedName("rc")
   static GarbageCollectorMXBean field321;
   @ObfuscatedName("cg")
   @Export("indexTextures")
   static IndexData indexTextures;
   @ObfuscatedName("fs")
   @Export("region")
   static Region region;

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method137((class14)var1, (class14)var2);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "1"
   )
   static int method131(int var0, int var1) {
      Overlay var2 = class252.method4319(var0);
      if(var2 == null) {
         return var1;
      } else if(var2.field3595 >= 0) {
         return var2.field3595 | -16777216;
      } else {
         int var3;
         if(var2.texture >= 0) {
            var3 = class27.method227(class136.field2028.vmethod2771(var2.texture), 96);
            return class136.colorPalette[var3] | -16777216;
         } else if(var2.color == 16711935) {
            return var1;
         } else {
            var3 = class22.method184(var2.hue, var2.saturation, var2.lightness);
            int var4 = class27.method227(var3, 96);
            return class136.colorPalette[var4] | -16777216;
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass14;Lclass14;B)I",
      garbageValue = "-19"
   )
   int method137(class14 var1, class14 var2) {
      return var1.field292.price < var2.field292.price?-1:(var1.field292.price == var2.field292.price?0:1);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-51"
   )
   @Export("loadWorlds")
   static boolean loadWorlds() {
      try {
         if(World.worldServersDownload == null) {
            World.worldServersDownload = new class77(GameEngine.field691, new URL(class151.field2219));
         } else {
            byte[] var0 = World.worldServersDownload.method1436();
            if(var0 != null) {
               Buffer var1 = new Buffer(var0);
               World.field1281 = var1.readUnsignedShort();
               World.worldList = new World[World.field1281];

               World var3;
               for(int var2 = 0; var2 < World.field1281; var3.index = var2++) {
                  var3 = World.worldList[var2] = new World();
                  var3.id = var1.readUnsignedShort();
                  var3.mask = var1.readInt();
                  var3.address = var1.readString();
                  var3.activity = var1.readString();
                  var3.location = var1.readUnsignedByte();
                  var3.playerCount = var1.readShort();
               }

               Player.method1092(World.worldList, 0, World.worldList.length - 1, World.field1284, World.field1283);
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

   @ObfuscatedName("fw")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1625752485"
   )
   static final void method139(int var0, int var1) {
      if(Client.field920 == 2) {
         class152.method2815((Client.hintArrowX - class19.baseX << 7) + Client.field926, (Client.hintArrowY - class21.baseY << 7) + Client.field1039, Client.hintArrowType * 2);
         if(Client.field1011 > -1 && Client.gameCycle % 20 < 10) {
            class18.field332[0].method4950(Client.field1011 + var0 - 12, Client.field1049 + var1 - 28);
         }

      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(ILclass219;I)I",
      garbageValue = "-196602240"
   )
   public static int method140(int var0, class219 var1) {
      return var1.field2804 + (var0 << 8);
   }
}
