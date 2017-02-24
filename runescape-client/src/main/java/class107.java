import java.io.File;
import java.util.Hashtable;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dx")
public class class107 {
   @ObfuscatedName("q")
   static boolean field1731 = false;
   @ObfuscatedName("d")
   static File field1732;
   @ObfuscatedName("h")
   static Hashtable field1733 = new Hashtable(16);
   @ObfuscatedName("hh")
   @ObfuscatedGetter(
      intValue = 740660459
   )
   @Export("menuWidth")
   static int menuWidth;
   @ObfuscatedName("bu")
   static class184 field1738;

   class107() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-122"
   )
   static final void method2099() {
      int var0 = Client.field481 + class36.localPlayer.x;
      int var1 = class36.localPlayer.y + Client.field371;
      if(class85.field1473 - var0 < -500 || class85.field1473 - var0 > 500 || class180.field2698 - var1 < -500 || class180.field2698 - var1 > 500) {
         class85.field1473 = var0;
         class180.field2698 = var1;
      }

      if(var0 != class85.field1473) {
         class85.field1473 += (var0 - class85.field1473) / 16;
      }

      if(var1 != class180.field2698) {
         class180.field2698 += (var1 - class180.field2698) / 16;
      }

      int var2;
      int var3;
      if(class115.field1794 == 4 && class15.field173) {
         var2 = class115.field1799 - Client.field393;
         Client.field391 = var2 * 2;
         Client.field393 = var2 != -1 && var2 != 1?(Client.field393 + class115.field1799) / 2:class115.field1799;
         var3 = Client.field392 - class115.field1792;
         Client.field390 = var3 * 2;
         Client.field392 = var3 != -1 && var3 != 1?(class115.field1792 + Client.field392) / 2:class115.field1792;
      } else {
         if(class105.field1713[96]) {
            Client.field390 += (-24 - Client.field390) / 2;
         } else if(class105.field1713[97]) {
            Client.field390 += (24 - Client.field390) / 2;
         } else {
            Client.field390 /= 2;
         }

         if(class105.field1713[98]) {
            Client.field391 += (12 - Client.field391) / 2;
         } else if(class105.field1713[99]) {
            Client.field391 += (-12 - Client.field391) / 2;
         } else {
            Client.field391 /= 2;
         }

         Client.field393 = class115.field1799;
         Client.field392 = class115.field1792;
      }

      Client.mapAngle = Client.field390 / 2 + Client.mapAngle & 2047;
      Client.field541 += Client.field391 / 2;
      if(Client.field541 < 128) {
         Client.field541 = 128;
      }

      if(Client.field541 > 383) {
         Client.field541 = 383;
      }

      var2 = class85.field1473 >> 7;
      var3 = class180.field2698 >> 7;
      int var4 = class2.method19(class85.field1473, class180.field2698, WallObject.plane);
      int var5 = 0;
      int var6;
      if(var2 > 3 && var3 > 3 && var2 < 100 && var3 < 100) {
         for(var6 = var2 - 4; var6 <= 4 + var2; ++var6) {
            for(int var7 = var3 - 4; var7 <= 4 + var3; ++var7) {
               int var8 = WallObject.plane;
               if(var8 < 3 && (class10.tileSettings[1][var6][var7] & 2) == 2) {
                  ++var8;
               }

               int var9 = var4 - class10.tileHeights[var8][var6][var7];
               if(var9 > var5) {
                  var5 = var9;
               }
            }
         }
      }

      var6 = var5 * 192;
      if(var6 > 98048) {
         var6 = 98048;
      }

      if(var6 < '耀') {
         var6 = '耀';
      }

      if(var6 > Client.field397) {
         Client.field397 += (var6 - Client.field397) / 24;
      } else if(var6 < Client.field397) {
         Client.field397 += (var6 - Client.field397) / 80;
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "100"
   )
   public static void method2100() {
      Spotanim.field2803.reset();
      Spotanim.field2798.reset();
   }
}
