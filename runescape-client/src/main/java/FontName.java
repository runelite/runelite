import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kd")
@Implements("FontName")
public class FontName {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lkd;"
   )
   @Export("FontName_plain11")
   public static final FontName FontName_plain11;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lkd;"
   )
   @Export("FontName_plain12")
   public static final FontName FontName_plain12;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lkd;"
   )
   @Export("FontName_bold12")
   public static final FontName FontName_bold12;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lkd;"
   )
   public static final FontName field3872;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lkd;"
   )
   public static final FontName field3873;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lkd;"
   )
   public static final FontName field3880;
   @ObfuscatedName("du")
   @ObfuscatedGetter(
      intValue = -787747873
   )
   @Export("port2")
   static int port2;
   @ObfuscatedName("fh")
   @Export("landMapFileIds")
   static int[] landMapFileIds;
   @ObfuscatedName("z")
   final String field3869;
   @ObfuscatedName("p")
   String field3876;

   static {
      FontName_plain11 = new FontName("PLAIN11", "p11_full");
      FontName_plain12 = new FontName("PLAIN12", "p12_full");
      FontName_bold12 = new FontName("BOLD12", "b12_full");
      field3872 = new FontName("VERDANA11", "verdana_11pt_regular");
      field3873 = new FontName("VERDANA13", "verdana_13pt_regular");
      field3880 = new FontName("VERDANA15", "verdana_15pt_regular");
   }

   FontName(String var1, String var2) {
      this.field3869 = var1;
      this.field3876 = var2;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)[Lkd;",
      garbageValue = "0"
   )
   public static FontName[] method5498() {
      return new FontName[]{field3872, FontName_plain11, field3873, FontName_plain12, field3880, FontName_bold12};
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(ZZB)Llq;",
      garbageValue = "56"
   )
   static IndexedSprite method5499(boolean var0, boolean var1) {
      return var0?(var1?class304.field3848:class151.field2127):(var1?class90.field1342:TextureProvider.field1691);
   }

   @ObfuscatedName("gx")
   @ObfuscatedSignature(
      signature = "(Lbx;IIB)V",
      garbageValue = "1"
   )
   static void method5496(Player var0, int var1, int var2) {
      if(var0.animation == var1 && var1 != -1) {
         int var3 = ISAACCipher.getAnimation(var1).replyMode;
         if(var3 == 1) {
            var0.actionFrame = 0;
            var0.actionFrameCycle = 0;
            var0.actionAnimationDisable = var2;
            var0.field1186 = 0;
         }

         if(var3 == 2) {
            var0.field1186 = 0;
         }
      } else if(var1 == -1 || var0.animation == -1 || ISAACCipher.getAnimation(var1).forcedPriority >= ISAACCipher.getAnimation(var0.animation).forcedPriority) {
         var0.animation = var1;
         var0.actionFrame = 0;
         var0.actionFrameCycle = 0;
         var0.actionAnimationDisable = var2;
         var0.field1186 = 0;
         var0.field1194 = var0.queueSize;
      }

   }
}
