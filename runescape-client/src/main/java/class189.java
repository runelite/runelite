import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gm")
public class class189 extends CacheableNode {
   @ObfuscatedName("x")
   static class182 field2780;
   @ObfuscatedName("c")
   public boolean field2782 = false;
   @ObfuscatedName("j")
   static NodeCache field2783 = new NodeCache(64);

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;I)I",
      garbageValue = "799780140"
   )
   static int method3464(class182 var0, class182 var1) {
      int var2 = 0;
      if(var0.method3324("title.jpg", "")) {
         ++var2;
      }

      if(var1.method3324("logo", "")) {
         ++var2;
      }

      if(var1.method3324("logo_deadman_mode", "")) {
         ++var2;
      }

      if(var1.method3324("titlebox", "")) {
         ++var2;
      }

      if(var1.method3324("titlebutton", "")) {
         ++var2;
      }

      if(var1.method3324("runes", "")) {
         ++var2;
      }

      if(var1.method3324("title_mute", "")) {
         ++var2;
      }

      if(var1.method3325("options_radio_buttons,0")) {
         ++var2;
      }

      if(var1.method3325("options_radio_buttons,2")) {
         ++var2;
      }

      var1.method3324("sl_back", "");
      var1.method3324("sl_flags", "");
      var1.method3324("sl_arrows", "");
      var1.method3324("sl_stars", "");
      var1.method3324("sl_button", "");
      return var2;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1365993814"
   )
   void method3465(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3466(var1, var2);
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "1248291710"
   )
   void method3466(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field2782 = true;
      }

   }
}
