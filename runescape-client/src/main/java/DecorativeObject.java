import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ea")
@Implements("DecorativeObject")
public final class DecorativeObject {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1023584981
   )
   @Export("renderInfoBitPacked")
   int renderInfoBitPacked;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -483691505
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("j")
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 834795431
   )
   @Export("renderFlag")
   int renderFlag;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -302104167
   )
   @Export("rotation")
   int rotation;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 831492273
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1221729509
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("y")
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 691217971
   )
   @Export("y")
   int y;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -859681275
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1641522523
   )
   @Export("x")
   int x;
   @ObfuscatedName("cs")
   static IndexData field2194;

   DecorativeObject() {
      this.hash = 0;
      this.renderInfoBitPacked = 0;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;LIndexDataBase;I)I",
      garbageValue = "-1133055215"
   )
   static int method2889(IndexDataBase var0, IndexDataBase var1) {
      int var2 = 0;
      if(var0.method4134("title.jpg", "")) {
         ++var2;
      }

      if(var1.method4134("logo", "")) {
         ++var2;
      }

      if(var1.method4134("logo_deadman_mode", "")) {
         ++var2;
      }

      if(var1.method4134("titlebox", "")) {
         ++var2;
      }

      if(var1.method4134("titlebutton", "")) {
         ++var2;
      }

      if(var1.method4134("runes", "")) {
         ++var2;
      }

      if(var1.method4134("title_mute", "")) {
         ++var2;
      }

      if(var1.method4134("options_radio_buttons,0", "")) {
         ++var2;
      }

      if(var1.method4134("options_radio_buttons,2", "")) {
         ++var2;
      }

      var1.method4134("sl_back", "");
      var1.method4134("sl_flags", "");
      var1.method4134("sl_arrows", "");
      var1.method4134("sl_stars", "");
      var1.method4134("sl_button", "");
      return var2;
   }
}
