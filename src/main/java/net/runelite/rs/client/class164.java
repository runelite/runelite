import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.io.IOException;
import java.net.URI;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fk")
public class class164 {
   @ObfuscatedName("j")
   static final char[] field2668 = new char[]{'€', '\u0000', '‚', 'ƒ', '„', '…', '†', '‡', 'ˆ', '‰', 'Š', '‹', 'Œ', '\u0000', 'Ž', '\u0000', '\u0000', '‘', '’', '“', '”', '•', '–', '—', '˜', '™', 'š', '›', 'œ', '\u0000', 'ž', 'Ÿ'};
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1111609909
   )
   static int field2669;
   @ObfuscatedName("iv")
   @ObfuscatedGetter(
      intValue = 1714525251
   )
   static int field2672;

   @ObfuscatedName("l")
   public static void method3191(String var0, boolean var1) {
      if(var1) {
         if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
            try {
               Desktop.getDesktop().browse(new URI(var0));
               return;
            } catch (Exception var3) {
               ;
            }
         }

         if(class137.field2147.startsWith("win")) {
            class0.method2(var0, 0, "openjs");
         } else if(class137.field2147.startsWith("mac")) {
            class0.method2(var0, 1, "openjs");
         } else {
            class77.method1673(var0, 2);
         }
      } else {
         class0.method2(var0, 3, "openjs");
      }

   }

   @ObfuscatedName("l")
   public static void method3192(boolean var0) {
      if(null != class216.field3155) {
         try {
            class118 var1 = new class118(4);
            var1.method2438(var0?2:3);
            var1.method2457(0);
            class216.field3155.method2932(var1.field1995, 0, 4);
         } catch (IOException var4) {
            try {
               class216.field3155.method2948();
            } catch (Exception var3) {
               ;
            }

            ++class170.field2739;
            class216.field3155 = null;
         }

      }
   }
}
