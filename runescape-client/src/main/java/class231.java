import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hn")
public class class231 extends Node {
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1798284945
   )
   int field2734;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lhx;"
   )
   class233 field2722;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Ldp;"
   )
   RawAudioNode field2729;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lhq;"
   )
   class228 field2724;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 336612017
   )
   int field2725;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -421665255
   )
   int field2726;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1177219731
   )
   int field2727;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1070398357
   )
   int field2728;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 2081770757
   )
   int field2733;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1644041127
   )
   int field2730;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 342580387
   )
   int field2721;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 130889509
   )
   int field2732;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 373027721
   )
   int field2731;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -506289271
   )
   int field2735;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 2065634891
   )
   int field2740;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1052678629
   )
   int field2736;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1451029365
   )
   int field2737;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1997208629
   )
   int field2738;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lda;"
   )
   class115 field2739;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -2140173415
   )
   int field2723;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1771557571
   )
   int field2741;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "117"
   )
   void method4262() {
      this.field2722 = null;
      this.field2729 = null;
      this.field2724 = null;
      this.field2739 = null;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)J",
      garbageValue = "-30"
   )
   static long encodeBase37(CharSequence string) {
      long encoded = 0L;
      int var3 = string.length();

      for(int index = 0; index < var3; ++index) {
         encoded *= 37L;
         char character = string.charAt(index);
         if(character >= 'A' && character <= 'Z') {
            encoded += (long)(character + 1 - 65);
         } else if(character >= 'a' && character <= 'z') {
            encoded += (long)(character + 1 - 97);
         } else if(character >= '0' && character <= '9') {
            encoded += (long)(character + 27 - 48);
         }

         if(encoded >= 177917621779460413L) {
            break;
         }
      }

      while(0L == encoded % 37L && encoded != 0L) {
         encoded /= 37L;
      }

      return encoded;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-937162823"
   )
   static final void method4265(String var0) {
      StringBuilder var10000 = (new StringBuilder()).append(var0);
      Object var10001 = null;
      String var1 = var10000.append(" is already on your ignore list").toString();
      class57.sendGameMessage(30, "", var1);
   }
}
