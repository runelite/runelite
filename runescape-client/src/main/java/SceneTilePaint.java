import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ex")
@Implements("SceneTilePaint")
public final class SceneTilePaint {
   @ObfuscatedName("t")
   @Export("colorsToReplace")
   public static short[][] colorsToReplace;
   @ObfuscatedName("f")
   @Export("flatShade")
   boolean flatShade;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1160916813
   )
   @Export("swColor")
   int swColor;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -577039723
   )
   @Export("rgb")
   int rgb;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1514021983
   )
   @Export("seColor")
   int seColor;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1636973739
   )
   @Export("neColor")
   int neColor;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -2039752957
   )
   @Export("nwColor")
   int nwColor;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1976815923
   )
   @Export("texture")
   int texture;

   SceneTilePaint(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
      this.flatShade = true;
      this.swColor = var1;
      this.seColor = var2;
      this.neColor = var3;
      this.nwColor = var4;
      this.texture = var5;
      this.rgb = var6;
      this.flatShade = var7;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lim;Lim;ZI)V",
      garbageValue = "-942970909"
   )
   public static void method2696(IndexDataBase var0, IndexDataBase var1, boolean var2) {
      ObjectComposition.objects_ref = var0;
      ObjectComposition.field3446 = var1;
      ObjectComposition.field3439 = var2;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lfw;IB)Ljava/lang/String;",
      garbageValue = "-1"
   )
   public static String method2695(Buffer var0, int var1) {
      try {
         int var2 = var0.getUSmart();
         if(var2 > var1) {
            var2 = var1;
         }

         byte[] var3 = new byte[var2];
         var0.offset += class265.field3639.decompress(var0.payload, var0.offset, var3, 0, var2);
         String var4 = class211.getString(var3, 0, var2);
         return var4;
      } catch (Exception var6) {
         return "Cabbage";
      }
   }
}
