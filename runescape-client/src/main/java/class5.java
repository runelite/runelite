import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("g")
final class class5 implements class0 {
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lia;Lia;I)I",
      garbageValue = "932659841"
   )
   static int method14(IndexDataBase var0, IndexDataBase var1) {
      int var2 = 0;
      if(var0.method4133("title.jpg", "")) {
         ++var2;
      }

      if(var1.method4133("logo", "")) {
         ++var2;
      }

      if(var1.method4133("logo_deadman_mode", "")) {
         ++var2;
      }

      if(var1.method4133("titlebox", "")) {
         ++var2;
      }

      if(var1.method4133("titlebutton", "")) {
         ++var2;
      }

      if(var1.method4133("runes", "")) {
         ++var2;
      }

      if(var1.method4133("title_mute", "")) {
         ++var2;
      }

      if(var1.method4133("options_radio_buttons,0", "")) {
         ++var2;
      }

      if(var1.method4133("options_radio_buttons,2", "")) {
         ++var2;
      }

      var1.method4133("sl_back", "");
      var1.method4133("sl_flags", "");
      var1.method4133("sl_arrows", "");
      var1.method4133("sl_stars", "");
      var1.method4133("sl_button", "");
      return var2;
   }
}
