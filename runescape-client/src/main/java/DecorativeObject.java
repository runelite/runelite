import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eg")
@Implements("DecorativeObject")
public final class DecorativeObject {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 150031225
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -2041529573
   )
   @Export("y")
   int y;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1149072573
   )
   @Export("x")
   int x;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -793043469
   )
   @Export("renderFlag")
   int renderFlag;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1672912555
   )
   @Export("rotation")
   int rotation;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 986105179
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1103225915
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Les;"
   )
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Les;"
   )
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 406457547
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1402112071
   )
   @Export("renderInfoBitPacked")
   int renderInfoBitPacked;

   DecorativeObject() {
      this.hash = 0;
      this.renderInfoBitPacked = 0;
   }

   @ObfuscatedName("kc")
   @ObfuscatedSignature(
      signature = "(Lhx;I)Ljava/lang/String;",
      garbageValue = "1650268932"
   )
   static String method3017(Widget var0) {
      int var2 = ClanMember.getWidgetConfig(var0);
      int var1 = var2 >> 11 & 63;
      return var1 == 0?null:(var0.selectedAction != null && var0.selectedAction.trim().length() != 0?var0.selectedAction:null);
   }
}
