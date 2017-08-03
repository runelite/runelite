import java.applet.Applet;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("et")
public class class152 extends RuntimeException {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1658108959
   )
   @Export("revision")
   public static int revision;
   @ObfuscatedName("d")
   public static Applet field2193;
   @ObfuscatedName("q")
   public static String field2189;
   @ObfuscatedName("w")
   @Export("cacheLocations")
   static String[] cacheLocations;
   @ObfuscatedName("y")
   String field2192;
   @ObfuscatedName("e")
   Throwable field2190;

   @ObfuscatedName("io")
   @ObfuscatedSignature(
      signature = "(Lhn;IIZI)V",
      garbageValue = "-1424713904"
   )
   static void method2947(Widget var0, int var1, int var2, boolean var3) {
      int var4 = var0.width;
      int var5 = var0.height;
      if(var0.field2737 == 0) {
         var0.width = var0.originalWidth;
      } else if(var0.field2737 == 1) {
         var0.width = var1 - var0.originalWidth;
      } else if(var0.field2737 == 2) {
         var0.width = var0.originalWidth * var1 >> 14;
      }

      if(var0.buttonType == 0) {
         var0.height = var0.field2641;
      } else if(var0.buttonType == 1) {
         var0.height = var2 - var0.field2641;
      } else if(var0.buttonType == 2) {
         var0.height = var2 * var0.field2641 >> 14;
      }

      if(var0.field2737 == 4) {
         var0.width = var0.field2646 * var0.height / var0.field2647;
      }

      if(var0.buttonType == 4) {
         var0.height = var0.width * var0.field2647 / var0.field2646;
      }

      if(Client.field1120 && var0.type == 0) {
         if(var0.height < 5 && var0.width < 5) {
            var0.height = 5;
            var0.width = 5;
         } else {
            if(var0.height <= 0) {
               var0.height = 5;
            }

            if(var0.width <= 0) {
               var0.width = 5;
            }
         }
      }

      if(var0.contentType == 1337) {
         Client.field1055 = var0;
      }

      if(var3 && var0.field2741 != null && (var4 != var0.width || var5 != var0.height)) {
         ScriptEvent var6 = new ScriptEvent();
         var6.widget = var0;
         var6.field818 = var0.field2741;
         Client.field1082.addFront(var6);
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "76"
   )
   static final boolean method2950() {
      return class134.field1973;
   }

   @ObfuscatedName("hr")
   @ObfuscatedSignature(
      signature = "(Lbe;B)V",
      garbageValue = "-6"
   )
   static final void method2949(PendingSpawn var0) {
      int var1 = 0;
      int var2 = -1;
      int var3 = 0;
      int var4 = 0;
      if(var0.type == 0) {
         var1 = class51.region.method2726(var0.level, var0.x, var0.y);
      }

      if(var0.type == 1) {
         var1 = class51.region.method2727(var0.level, var0.x, var0.y);
      }

      if(var0.type == 2) {
         var1 = class51.region.method2760(var0.level, var0.x, var0.y);
      }

      if(var0.type == 3) {
         var1 = class51.region.method2699(var0.level, var0.x, var0.y);
      }

      if(var1 != 0) {
         int var5 = class51.region.method2712(var0.level, var0.x, var0.y, var1);
         var2 = var1 >> 14 & 32767;
         var3 = var5 & 31;
         var4 = var5 >> 6 & 3;
      }

      var0.field1177 = var2;
      var0.field1166 = var3;
      var0.field1168 = var4;
   }
}
