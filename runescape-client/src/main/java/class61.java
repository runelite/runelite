import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bh")
public final class class61 {
   @ObfuscatedName("a")
   @Export("tileHeights")
   static int[][][] tileHeights;
   @ObfuscatedName("j")
   @Export("tileSettings")
   static byte[][][] tileSettings;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1562199555
   )
   static int field747;
   @ObfuscatedName("jq")
   @ObfuscatedGetter(
      intValue = -286808623
   )
   @Export("menuX")
   static int menuX;
   @ObfuscatedName("f")
   static final int[] field749;
   @ObfuscatedName("h")
   static final int[] field756;
   @ObfuscatedName("z")
   static final int[] field748;
   @ObfuscatedName("i")
   static final int[] field752;
   @ObfuscatedName("d")
   static final int[] field757;
   @ObfuscatedName("b")
   static final int[] field758;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -416485739
   )
   static int field745;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1858562407
   )
   static int field760;
   @ObfuscatedName("v")
   @Export("overlayIds")
   static byte[][][] overlayIds;
   @ObfuscatedName("l")
   @Export("overlayRotations")
   static byte[][][] overlayRotations;
   @ObfuscatedName("s")
   static byte[][][] field750;
   @ObfuscatedName("p")
   @Export("blendedHue")
   static int[] blendedHue;
   @ObfuscatedName("g")
   static int[] field763;

   static {
      tileHeights = new int[4][105][105];
      tileSettings = new byte[4][104][104];
      field747 = 99;
      field749 = new int[]{1, 2, 4, 8};
      field756 = new int[]{16, 32, 64, 128};
      field748 = new int[]{1, 0, -1, 0};
      field752 = new int[]{0, -1, 0, 1};
      field757 = new int[]{1, -1, -1, 1};
      field758 = new int[]{-1, -1, 1, 1};
      field745 = (int)(Math.random() * 17.0D) - 8;
      field760 = (int)(Math.random() * 33.0D) - 16;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)Lhy;",
      garbageValue = "-890117828"
   )
   public static Widget method1038(int var0) {
      int var1 = var0 >> 16;
      int var2 = var0 & '\uffff';
      if(Widget.widgets[var1] == null || Widget.widgets[var1][var2] == null) {
         boolean var3 = class33.loadWidget(var1);
         if(!var3) {
            return null;
         }
      }

      return Widget.widgets[var1][var2];
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(Ldf;B)V",
      garbageValue = "119"
   )
   static final void method1077(class119 var0) {
      var0.field1707 = false;
      if(var0.field1706 != null) {
         var0.field1706.field1738 = 0;
      }

      for(class119 var1 = var0.vmethod3883(); var1 != null; var1 = var0.vmethod3882()) {
         method1077(var1);
      }

   }
}
