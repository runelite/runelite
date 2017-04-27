import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("fn")
public class class173 {
   @ObfuscatedName("q")
   @Export("underlayIds")
   static byte[][][] underlayIds;

   class173() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("ef")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-389500429"
   )
   static void method3256(String var0) {
      Client.field287 = var0;

      try {
         String var1 = Client.field279.getParameter(class218.field3192.field3193);
         String var2 = Client.field279.getParameter(class218.field3180.field3193);
         String var3 = var1 + "settings=" + var0 + "; version=1; path=/; domain=" + var2;
         if(var0.length() == 0) {
            var3 = var3 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
         } else {
            var3 = var3 + "; Expires=" + IndexFile.method2247(class72.method1421() + 94608000000L) + "; Max-Age=" + 94608000L;
         }

         Client var4 = Client.field279;
         String var5 = "document.cookie=\"" + var3 + "\"";
         JSObject.getWindow(var4).eval(var5);
      } catch (Throwable var6) {
         ;
      }

   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(IIIIZB)V",
      garbageValue = "1"
   )
   static final void method3257(int var0, int var1, int var2, int var3, boolean var4) {
      if(var2 < 1) {
         var2 = 1;
      }

      if(var3 < 1) {
         var3 = 1;
      }

      int var5 = var3 - 334;
      if(var5 < 0) {
         var5 = 0;
      } else if(var5 > 100) {
         var5 = 100;
      }

      int var6 = var5 * (Client.field541 - Client.field500) / 100 + Client.field500;
      int var7 = var3 * var6 * 512 / (var2 * 334);
      int var8;
      int var9;
      short var15;
      if(var7 < Client.field320) {
         var15 = Client.field320;
         var6 = var15 * var2 * 334 / (var3 * 512);
         if(var6 > Client.field459) {
            var6 = Client.field459;
            var8 = var3 * var6 * 512 / (var15 * 334);
            var9 = (var2 - var8) / 2;
            if(var4) {
               Rasterizer2D.method4082();
               Rasterizer2D.method4089(var0, var1, var9, var3, -16777216);
               Rasterizer2D.method4089(var2 + var0 - var9, var1, var9, var3, -16777216);
            }

            var0 += var9;
            var2 -= var9 * 2;
         }
      } else if(var7 > Client.field547) {
         var15 = Client.field547;
         var6 = var2 * var15 * 334 / (var3 * 512);
         if(var6 < Client.field509) {
            var6 = Client.field509;
            var8 = var2 * var15 * 334 / (var6 * 512);
            var9 = (var3 - var8) / 2;
            if(var4) {
               Rasterizer2D.method4082();
               Rasterizer2D.method4089(var0, var1, var2, var9, -16777216);
               Rasterizer2D.method4089(var0, var3 + var1 - var9, var2, var9, -16777216);
            }

            var1 += var9;
            var3 -= var9 * 2;
         }
      }

      var8 = var5 * (Client.field318 - Client.field542) / 100 + Client.field542;
      Client.scale = var6 * var3 * var8 / 85504 << 1;
      if(var2 != Client.camera2 || var3 != Client.camera3) {
         int[] var14 = new int[9];

         for(int var10 = 0; var10 < 9; ++var10) {
            int var11 = var10 * 32 + 128 + 15;
            int var12 = var11 * 3 + 600;
            int var13 = class84.field1433[var11];
            var14[var10] = var12 * var13 >> 16;
         }

         Region.method1756(var14, 500, 800, var2, var3);
      }

      Client.field548 = var0;
      Client.field549 = var1;
      Client.camera2 = var2;
      Client.camera3 = var3;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;Ljava/lang/String;Ljava/lang/String;I)LModIcon;",
      garbageValue = "-509456605"
   )
   public static ModIcon method3258(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.method3296(var1);
      int var4 = var0.method3310(var3, var2);
      ModIcon var5;
      if(!class199.method3620(var0, var3, var4)) {
         var5 = null;
      } else {
         ModIcon var7 = new ModIcon();
         var7.width = class229.field3255;
         var7.originalHeight = class229.field3251;
         var7.offsetX = class199.field2877[0];
         var7.offsetY = class229.field3252[0];
         var7.originalWidth = class229.field3254[0];
         var7.height = class36.field772[0];
         var7.palette = class229.field3249;
         var7.pixels = class229.field3253[0];
         class199.field2877 = null;
         class229.field3252 = null;
         class229.field3254 = null;
         class36.field772 = null;
         class229.field3249 = null;
         class229.field3253 = null;
         var5 = var7;
      }

      return var5;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/Throwable;B)V",
      garbageValue = "-105"
   )
   public static void method3259(String var0, Throwable var1) {
      var1.printStackTrace();
   }
}
