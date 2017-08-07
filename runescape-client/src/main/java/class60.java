import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("by")
public final class class60 {
   @ObfuscatedName("fm")
   @ObfuscatedSignature(
      signature = "Lkn;"
   )
   @Export("mapedge")
   static SpritePixels mapedge;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lid;II)V",
      garbageValue = "1469426157"
   )
   static void method1027(IndexData var0, int var1) {
      if(class19.field323 != null) {
         class19.field323.offset = var1 * 8 + 5;
         int var2 = class19.field323.readInt();
         int var3 = class19.field323.readInt();
         var0.setInformation(var2, var3);
      } else {
         class258.method4651((IndexData)null, 255, 255, 0, (byte)0, true);
         class239.field3250[var1] = var0;
      }
   }

   @ObfuscatedName("hk")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "0"
   )
   static final void method1024(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Client.field1105; ++var4) {
         if(Client.widgetPositionX[var4] + Client.widgetBoundsWidth[var4] > var0 && Client.widgetPositionX[var4] < var0 + var2 && Client.widgetBoundsHeight[var4] + Client.widgetPositionY[var4] > var1 && Client.widgetPositionY[var4] < var3 + var1) {
            Client.field1159[var4] = true;
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lcq;I)V",
      garbageValue = "1959901924"
   )
   static void method1019(World var0) {
      if(var0.method1550() != Client.isMembers) {
         Client.isMembers = var0.method1550();
         BaseVarType.method9(var0.method1550());
      }

      class64.host = var0.address;
      Client.world = var0.id;
      Client.flags = var0.mask;
      class225.field2823 = Client.socketType == 0?'ꩊ':var0.id + '鱀';
      class69.field832 = Client.socketType == 0?443:var0.id + '썐';
      class29.myWorldPort = class225.field2823;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-1"
   )
   @Export("getSmoothNoise2D")
   static final int getSmoothNoise2D(int var0, int var1) {
      int var2 = class34.method491(var0 - 1, var1 - 1) + class34.method491(var0 + 1, var1 - 1) + class34.method491(var0 - 1, var1 + 1) + class34.method491(var0 + 1, var1 + 1);
      int var3 = class34.method491(var0 - 1, var1) + class34.method491(var0 + 1, var1) + class34.method491(var0, var1 - 1) + class34.method491(var0, var1 + 1);
      int var4 = class34.method491(var0, var1);
      return var2 / 16 + var3 / 8 + var4 / 4;
   }
}
