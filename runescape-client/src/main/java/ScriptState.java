import java.applet.Applet;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bo")
@Implements("ScriptState")
public class ScriptState {
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lkr;"
   )
   static SpritePixels field791;
   @ObfuscatedName("ai")
   static int[] field792;
   @ObfuscatedName("gw")
   @ObfuscatedGetter(
      intValue = 503524493
   )
   @Export("cameraZ")
   static int cameraZ;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1095625493
   )
   @Export("invokedFromPc")
   int invokedFromPc;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lcv;"
   )
   @Export("invokedFromScript")
   Script invokedFromScript;
   @ObfuscatedName("e")
   @Export("savedLocalInts")
   int[] savedLocalInts;
   @ObfuscatedName("p")
   @Export("savedLocalStrings")
   String[] savedLocalStrings;

   ScriptState() {
      this.invokedFromPc = -1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/applet/Applet;Ljava/lang/String;I)V",
      garbageValue = "2131467544"
   )
   public static void method1124(Applet var0, String var1) {
      class56.field694 = var0;
      class56.field695 = var1;
   }

   @ObfuscatedName("ik")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "1955376972"
   )
   static final void method1123(int var0, int var1, int var2, int var3, int var4, int var5) {
      int var6 = var2 - var0;
      int var7 = var3 - var1;
      int var8 = var6 >= 0?var6:-var6;
      int var9 = var7 >= 0?var7:-var7;
      int var10 = var8;
      if(var8 < var9) {
         var10 = var9;
      }

      if(var10 != 0) {
         int var11 = (var6 << 16) / var10;
         int var12 = (var7 << 16) / var10;
         if(var12 <= var11) {
            var11 = -var11;
         } else {
            var12 = -var12;
         }

         int var13 = var5 * var12 >> 17;
         int var14 = 1 + var5 * var12 >> 17;
         int var15 = var5 * var11 >> 17;
         int var16 = 1 + var5 * var11 >> 17;
         var0 -= Rasterizer2D.draw_region_x;
         var1 -= Rasterizer2D.drawingAreaTop;
         int var17 = var0 + var13;
         int var18 = var0 - var14;
         int var19 = var0 + var6 - var14;
         int var20 = var0 + var13 + var6;
         int var21 = var15 + var1;
         int var22 = var1 - var16;
         int var23 = var7 + var1 - var16;
         int var24 = var15 + var7 + var1;
         Graphics3D.setRasterClippingEnabled(var17, var18, var19);
         Graphics3D.rasterFlat(var21, var22, var23, var17, var18, var19, var4);
         Graphics3D.setRasterClippingEnabled(var17, var19, var20);
         Graphics3D.rasterFlat(var21, var23, var24, var17, var19, var20, var4);
      }
   }
}
