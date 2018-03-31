import java.awt.Image;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("y")
@Implements("Size")
public class Size {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Ly;"
   )
   public static final Size field347;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Ly;"
   )
   public static final Size field346;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Ly;"
   )
   public static final Size field344;
   @ObfuscatedName("ah")
   static Image field348;
   @ObfuscatedName("fg")
   @Export("mapRegions")
   static int[] mapRegions;
   @ObfuscatedName("fi")
   @Export("xteaKeys")
   static int[][] xteaKeys;
   @ObfuscatedName("j")
   final String field345;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -397925001
   )
   final int field349;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -516149199
   )
   final int field352;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -154420731
   )
   final int field342;

   static {
      field347 = new Size("SMALL", 0, 0, 4);
      field346 = new Size("MEDIUM", 2, 1, 2);
      field344 = new Size("LARGE", 1, 2, 0);
   }

   Size(String var1, int var2, int var3, int var4) {
      this.field345 = var1;
      this.field349 = var2;
      this.field352 = var3;
      this.field342 = var4;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(FB)Z",
      garbageValue = "70"
   )
   boolean method192(float var1) {
      return var1 >= (float)this.field342;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIII)Lla;",
      garbageValue = "1811050241"
   )
   static SpritePixels method194(int var0, int var1, int var2) {
      class213 var3 = WorldMapRegion.field470;
      long var4 = (long)(var2 << 16 | var0 << 8 | var1);
      return (SpritePixels)var3.method3945(var4);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)Ly;",
      garbageValue = "2038821774"
   )
   static Size method199(int var0) {
      Size[] var1 = new Size[]{field347, field346, field344};
      Size[] var2 = var1;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         Size var4 = var2[var3];
         if(var0 == var4.field352) {
            return var4;
         }
      }

      return null;
   }

   @ObfuscatedName("js")
   @ObfuscatedSignature(
      signature = "(Lib;IIZB)V",
      garbageValue = "14"
   )
   static void method191(Widget var0, int var1, int var2, boolean var3) {
      int var4 = var0.width;
      int var5 = var0.height;
      if(var0.dynamicWidth == 0) {
         var0.width = var0.originalWidth;
      } else if(var0.dynamicWidth == 1) {
         var0.width = var1 - var0.originalWidth;
      } else if(var0.dynamicWidth == 2) {
         var0.width = var0.originalWidth * var1 >> 14;
      }

      if(var0.buttonType == 0) {
         var0.height = var0.originalHeight;
      } else if(var0.buttonType == 1) {
         var0.height = var2 - var0.originalHeight;
      } else if(var0.buttonType == 2) {
         var0.height = var2 * var0.originalHeight >> 14;
      }

      if(var0.dynamicWidth == 4) {
         var0.width = var0.field2901 * var0.height / var0.field2892;
      }

      if(var0.buttonType == 4) {
         var0.height = var0.width * var0.field2892 / var0.field2901;
      }

      if(var0.contentType == 1337) {
         Client.field1026 = var0;
      }

      if(var3 && var0.onResizeListener != null && (var4 != var0.width || var5 != var0.height)) {
         ScriptEvent var6 = new ScriptEvent();
         var6.widget = var0;
         var6.objs = var0.onResizeListener;
         Client.field1054.addFront(var6);
      }

   }
}
