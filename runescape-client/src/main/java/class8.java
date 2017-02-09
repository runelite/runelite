import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("n")
public class class8 {
   @ObfuscatedName("bz")
   static ModIcon field70;
   @ObfuscatedName("kx")
   static class112 field76;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)I",
      garbageValue = "0"
   )
   public static int method113(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + class38.method765(var0.charAt(var3));
      }

      return var2;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "2132187207"
   )
   @Export("loadWorlds")
   static boolean loadWorlds() {
      try {
         if(World.worldServersDownload == null) {
            World.worldServersDownload = new class26(class63.field1093, new URL(class20.field214));
         } else {
            byte[] var0 = World.worldServersDownload.method616();
            if(var0 != null) {
               Buffer var1 = new Buffer(var0);
               World.field677 = var1.readUnsignedShort();
               WidgetNode.worldList = new World[World.field677];

               World var3;
               for(int var2 = 0; var2 < World.field677; var3.index = var2++) {
                  var3 = WidgetNode.worldList[var2] = new World();
                  var3.id = var1.readUnsignedShort();
                  var3.mask = var1.method3062();
                  var3.address = var1.method2934();
                  var3.activity = var1.method2934();
                  var3.location = var1.readUnsignedByte();
                  var3.playerCount = var1.readShort();
               }

               class103.method1962(WidgetNode.worldList, 0, WidgetNode.worldList.length - 1, World.field669, World.field674);
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

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIIII)I",
      garbageValue = "1453179168"
   )
   static final int method115(int var0, int var1, int var2, int var3) {
      int var4 = 65536 - class84.field1452[1024 * var2 / var3] >> 1;
      return (var1 * var4 >> 16) + ((65536 - var4) * var0 >> 16);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(CI)C",
      garbageValue = "-1487963387"
   )
   public static char method116(char var0) {
      return (char)(var0 == 198?'E':(var0 == 230?'e':(var0 == 223?'s':(var0 == 338?'E':(var0 == 339?'e':'\u0000')))));
   }

   class8() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("cj")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "-40"
   )
   static final void method117(boolean var0) {
      int var1 = Client.widgetRoot;
      int var2 = XItemContainer.field123;
      int var3 = class143.field1999;
      if(class15.method193(var1)) {
         TextureProvider.method1460(Widget.widgets[var1], -1, var2, var3, var0);
      }

   }
}
