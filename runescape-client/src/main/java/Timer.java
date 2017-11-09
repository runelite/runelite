import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ff")
@Implements("Timer")
public abstract class Timer {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-3"
   )
   public abstract void vmethod3096();

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-553632509"
   )
   public abstract int vmethod3095(int var1, int var2);

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lik;Lik;B)I",
      garbageValue = "24"
   )
   static int method3091(IndexDataBase var0, IndexDataBase var1) {
      int var2 = 0;
      if(var0.method4295("title.jpg", "")) {
         ++var2;
      }

      if(var1.method4295("logo", "")) {
         ++var2;
      }

      if(var1.method4295("logo_deadman_mode", "")) {
         ++var2;
      }

      if(var1.method4295("titlebox", "")) {
         ++var2;
      }

      if(var1.method4295("titlebutton", "")) {
         ++var2;
      }

      if(var1.method4295("runes", "")) {
         ++var2;
      }

      if(var1.method4295("title_mute", "")) {
         ++var2;
      }

      if(var1.method4295("options_radio_buttons,0", "")) {
         ++var2;
      }

      if(var1.method4295("options_radio_buttons,2", "")) {
         ++var2;
      }

      if(var1.method4295("options_radio_buttons,4", "")) {
         ++var2;
      }

      if(var1.method4295("options_radio_buttons,6", "")) {
         ++var2;
      }

      var1.method4295("sl_back", "");
      var1.method4295("sl_flags", "");
      var1.method4295("sl_arrows", "");
      var1.method4295("sl_stars", "");
      var1.method4295("sl_button", "");
      return var2;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IS)Z",
      garbageValue = "160"
   )
   public static boolean method3089(int var0) {
      return (var0 >> 31 & 1) != 0;
   }

   @ObfuscatedName("id")
   @ObfuscatedSignature(
      signature = "([Lhk;IIIZB)V",
      garbageValue = "14"
   )
   static void method3093(Widget[] var0, int var1, int var2, int var3, boolean var4) {
      for(int var5 = 0; var5 < var0.length; ++var5) {
         Widget var6 = var0[var5];
         if(var6 != null && var6.parentId == var1) {
            MilliTimer.method3042(var6, var2, var3, var4);
            class15.method106(var6, var2, var3);
            if(var6.scrollX > var6.scrollWidth - var6.width) {
               var6.scrollX = var6.scrollWidth - var6.width;
            }

            if(var6.scrollX < 0) {
               var6.scrollX = 0;
            }

            if(var6.scrollY > var6.scrollHeight - var6.height) {
               var6.scrollY = var6.scrollHeight - var6.height;
            }

            if(var6.scrollY < 0) {
               var6.scrollY = 0;
            }

            if(var6.type == 0) {
               class22.method179(var0, var6, var4);
            }
         }
      }

   }

   @ObfuscatedName("jm")
   @ObfuscatedSignature(
      signature = "(Lhk;I)Ljava/lang/String;",
      garbageValue = "123597197"
   )
   static String method3094(Widget var0) {
      return GraphicsObject.method1747(Preferences.getWidgetConfig(var0)) == 0?null:(var0.selectedAction != null && var0.selectedAction.trim().length() != 0?var0.selectedAction:null);
   }
}
