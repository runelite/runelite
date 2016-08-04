import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ho")
final class class221 implements Comparator {
   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass217;Lclass217;I)I",
      garbageValue = "1706348395"
   )
   int method4126(class217 var1, class217 var2) {
      return var1.field3209 < var2.field3209?-1:(var1.field3209 == var2.field3209?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method4126((class217)var1, (class217)var2);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;I)I",
      garbageValue = "-892072893"
   )
   static int method4133(class170 var0, class170 var1) {
      int var2 = 0;
      if(var0.method3413("title.jpg", "")) {
         ++var2;
      }

      if(var1.method3413("logo", "")) {
         ++var2;
      }

      if(var1.method3413("logo_deadman_mode", "")) {
         ++var2;
      }

      if(var1.method3413("titlebox", "")) {
         ++var2;
      }

      if(var1.method3413("titlebutton", "")) {
         ++var2;
      }

      if(var1.method3413("runes", "")) {
         ++var2;
      }

      if(var1.method3413("title_mute", "")) {
         ++var2;
      }

      if(var1.method3414("options_radio_buttons,0")) {
         ++var2;
      }

      if(var1.method3414("options_radio_buttons,2")) {
         ++var2;
      }

      var1.method3413("sl_back", "");
      var1.method3413("sl_flags", "");
      var1.method3413("sl_arrows", "");
      var1.method3413("sl_stars", "");
      var1.method3413("sl_button", "");
      return var2;
   }
}
