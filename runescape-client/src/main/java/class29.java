import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ax")
public final class class29 {
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = -166725969
   )
   static int field397;
   @ObfuscatedName("fg")
   static byte[][] field400;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1290607391
   )
   int field395;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1893640913
   )
   int field399;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1524167779
   )
   int field401;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -19787275
   )
   int field398;
   // $FF: synthetic field
   @ObfuscatedSignature(
      signature = "Lan;"
   )
   final class41 this$0;

   @ObfuscatedSignature(
      signature = "(Lan;)V"
   )
   class29(class41 var1) {
      this.this$0 = var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lid;Lid;B)I",
      garbageValue = "2"
   )
   static int method242(IndexDataBase var0, IndexDataBase var1) {
      int var2 = 0;
      if(var0.method4285("title.jpg", "")) {
         ++var2;
      }

      if(var1.method4285("logo", "")) {
         ++var2;
      }

      if(var1.method4285("logo_deadman_mode", "")) {
         ++var2;
      }

      if(var1.method4285("titlebox", "")) {
         ++var2;
      }

      if(var1.method4285("titlebutton", "")) {
         ++var2;
      }

      if(var1.method4285("runes", "")) {
         ++var2;
      }

      if(var1.method4285("title_mute", "")) {
         ++var2;
      }

      if(var1.method4285("options_radio_buttons,0", "")) {
         ++var2;
      }

      if(var1.method4285("options_radio_buttons,2", "")) {
         ++var2;
      }

      if(var1.method4285("options_radio_buttons,4", "")) {
         ++var2;
      }

      if(var1.method4285("options_radio_buttons,6", "")) {
         ++var2;
      }

      var1.method4285("sl_back", "");
      var1.method4285("sl_flags", "");
      var1.method4285("sl_arrows", "");
      var1.method4285("sl_stars", "");
      var1.method4285("sl_button", "");
      return var2;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lfr;Ljava/lang/String;B)I",
      garbageValue = "30"
   )
   public static int method244(Buffer var0, String var1) {
      int var2 = var0.offset;
      byte[] var3 = class239.method4260(var1);
      var0.putShortSmart(var3.length);
      var0.offset += class272.field3721.compress(var3, 0, var3.length, var0.payload, var0.offset);
      return var0.offset - var2;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)Ljava/lang/String;",
      garbageValue = "108"
   )
   public static String method245(CharSequence var0) {
      long var3 = 0L;
      int var5 = var0.length();

      for(int var6 = 0; var6 < var5; ++var6) {
         var3 *= 37L;
         char var7 = var0.charAt(var6);
         if(var7 >= 'A' && var7 <= 'Z') {
            var3 += (long)(var7 + 1 - 65);
         } else if(var7 >= 'a' && var7 <= 'z') {
            var3 += (long)(var7 + 1 - 97);
         } else if(var7 >= '0' && var7 <= '9') {
            var3 += (long)(var7 + 27 - 48);
         }

         if(var3 >= 177917621779460413L) {
            break;
         }
      }

      while(var3 % 37L == 0L && var3 != 0L) {
         var3 /= 37L;
      }

      String var8 = class182.method3529(var3);
      if(var8 == null) {
         var8 = "";
      }

      return var8;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)[Ljn;",
      garbageValue = "-1560291979"
   )
   static class264[] method243() {
      return new class264[]{class264.field3606, class264.field3612, class264.field3607};
   }

   @ObfuscatedName("ji")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Z",
      garbageValue = "295297617"
   )
   @Export("isIgnored")
   static boolean isIgnored(String var0) {
      if(var0 == null) {
         return false;
      } else {
         String var1 = GraphicsObject.method1726(var0, class236.field3239);

         for(int var2 = 0; var2 < Client.ignoreCount; ++var2) {
            Ignore var3 = Client.ignores[var2];
            if(var1.equalsIgnoreCase(GraphicsObject.method1726(var3.name, class236.field3239))) {
               return true;
            }

            if(var1.equalsIgnoreCase(GraphicsObject.method1726(var3.previousName, class236.field3239))) {
               return true;
            }
         }

         return false;
      }
   }
}
