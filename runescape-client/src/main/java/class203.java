import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gf")
public class class203 {
   @ObfuscatedName("nz")
   @ObfuscatedGetter(
      intValue = 874029335
   )
   static int field3072;
   @ObfuscatedName("i")
   public static final char[] field3073 = new char[]{'€', '\u0000', '‚', 'ƒ', '„', '…', '†', '‡', 'ˆ', '‰', 'Š', '‹', 'Œ', '\u0000', 'Ž', '\u0000', '\u0000', '‘', '’', '“', '”', '•', '–', '—', '˜', '™', 'š', '›', 'œ', '\u0000', 'ž', 'Ÿ'};

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1031998170"
   )
   static void method3734() {
      for(class31 var0 = (class31)class31.field706.method2359(); null != var0; var0 = (class31)class31.field706.method2361()) {
         if(null != var0.field709) {
            class0.field3.method911(var0.field709);
            var0.field709 = null;
         }

         if(null != var0.field714) {
            class0.field3.method911(var0.field714);
            var0.field714 = null;
         }
      }

      class31.field706.method2353();
   }
}
