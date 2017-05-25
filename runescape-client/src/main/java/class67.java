import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bo")
public class class67 extends class196 {
   @ObfuscatedName("u")
   short field806;
   @ObfuscatedName("h")
   String field807;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1643756747
   )
   int field808;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;LIndexDataBase;B)I",
      garbageValue = "7"
   )
   static int method1101(IndexDataBase var0, IndexDataBase var1) {
      int var2 = 0;
      if(var0.method4193("title.jpg", "")) {
         ++var2;
      }

      if(var1.method4193("logo", "")) {
         ++var2;
      }

      if(var1.method4193("logo_deadman_mode", "")) {
         ++var2;
      }

      if(var1.method4193("titlebox", "")) {
         ++var2;
      }

      if(var1.method4193("titlebutton", "")) {
         ++var2;
      }

      if(var1.method4193("runes", "")) {
         ++var2;
      }

      if(var1.method4193("title_mute", "")) {
         ++var2;
      }

      if(var1.method4193("options_radio_buttons,0", "")) {
         ++var2;
      }

      if(var1.method4193("options_radio_buttons,2", "")) {
         ++var2;
      }

      var1.method4193("sl_back", "");
      var1.method4193("sl_flags", "");
      var1.method4193("sl_arrows", "");
      var1.method4193("sl_stars", "");
      var1.method4193("sl_button", "");
      return var2;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)LMessageNode;",
      garbageValue = "-2140101065"
   )
   static MessageNode method1102(int var0, int var1) {
      ChatLineBuffer var2 = (ChatLineBuffer)class98.chatLineMap.get(Integer.valueOf(var0));
      return var2.method1897(var1);
   }

   class67(String var1, int var2) {
      this.field808 = (int)(class226.method4147() / 1000L);
      this.field807 = var1;
      this.field806 = (short)var2;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-710179667"
   )
   static final int method1103() {
      return class134.field1988;
   }
}
