import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("co")
public class class85 implements class115 {
   @ObfuscatedName("a")
   public static final class85 field1504 = new class85(0, 0);
   @ObfuscatedName("d")
   public static final class85 field1505 = new class85(1, 1);
   @ObfuscatedName("bd")
   static class171 field1506;
   @ObfuscatedName("r")
   public static final class85 field1507 = new class85(3, 3);
   @ObfuscatedName("z")
   public static final class85 field1508 = new class85(4, 4);
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1826720363
   )
   final int field1510;
   @ObfuscatedName("v")
   public static final class85 field1514 = new class85(2, 2);
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1883035951
   )
   public final int field1515;
   @ObfuscatedName("hd")
   @ObfuscatedGetter(
      intValue = 1970825013
   )
   @Export("menuWidth")
   static int menuWidth;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1565114944"
   )
   public int vmethod3214() {
      return this.field1510;
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class85(int var1, int var2) {
      this.field1515 = var1;
      this.field1510 = var2;
   }

   @ObfuscatedName("cy")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "16711935"
   )
   static void method1925(int var0) {
      WidgetNode.field65 = new class32();
      WidgetNode.field65.field734 = Client.menuActionParams0[var0];
      WidgetNode.field65.field725 = Client.menuActionParams1[var0];
      WidgetNode.field65.field726 = Client.menuTypes[var0];
      WidgetNode.field65.field727 = Client.menuIdentifiers[var0];
      WidgetNode.field65.field728 = Client.menuOptions[var0];
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "1"
   )
   static final void method1926(int var0, int var1, int var2) {
      if(var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
         int var3 = class116.method2462(var0, var1, Item.plane) - var2;
         var0 -= class165.cameraX;
         var3 -= class125.cameraZ;
         var1 -= class9.cameraY;
         int var4 = class94.field1670[class18.cameraPitch];
         int var5 = class94.field1676[class18.cameraPitch];
         int var6 = class94.field1670[class33.cameraYaw];
         int var7 = class94.field1676[class33.cameraYaw];
         int var8 = var1 * var6 + var0 * var7 >> 16;
         var1 = var1 * var7 - var6 * var0 >> 16;
         var0 = var8;
         var8 = var5 * var3 - var1 * var4 >> 16;
         var1 = var3 * var4 + var1 * var5 >> 16;
         if(var1 >= 50) {
            Client.field388 = Client.camera2 / 2 + Client.scale * var0 / var1;
            Client.field389 = Client.camera3 / 2 + var8 * Client.scale / var1;
         } else {
            Client.field388 = -1;
            Client.field389 = -1;
         }

      } else {
         Client.field388 = -1;
         Client.field389 = -1;
      }
   }
}
