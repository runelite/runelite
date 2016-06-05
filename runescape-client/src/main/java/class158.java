import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.awt.datatransfer.Clipboard;
import java.net.URI;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fj")
public class class158 {
   @ObfuscatedName("pn")
   static Clipboard field2623;

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(Lclass37;B)V",
      garbageValue = "-31"
   )
   static final void method3141(class37 var0) {
      if(var0.field863 != 0) {
         if(var0.field828 != -1) {
            Object var1 = null;
            if(var0.field828 < '耀') {
               var1 = client.field320[var0.field828];
            } else if(var0.field828 >= '耀') {
               var1 = client.field405[var0.field828 - '耀'];
            }

            if(null != var1) {
               int var2 = var0.field809 - ((class37)var1).field809;
               int var3 = var0.field804 - ((class37)var1).field804;
               if(var2 != 0 || var3 != 0) {
                  var0.field831 = (int)(Math.atan2((double)var2, (double)var3) * 325.949D) & 2047;
               }
            } else if(var0.field829) {
               var0.field828 = -1;
               var0.field829 = false;
            }
         }

         if(var0.field830 != -1 && (var0.field856 == 0 || var0.field860 > 0)) {
            var0.field831 = var0.field830;
            var0.field830 = -1;
         }

         int var4 = var0.field831 - var0.field805 & 2047;
         if(var4 == 0 && var0.field829) {
            var0.field828 = -1;
            var0.field829 = false;
         }

         if(var4 != 0) {
            ++var0.field854;
            boolean var6;
            if(var4 > 1024) {
               var0.field805 -= var0.field863;
               var6 = true;
               if(var4 < var0.field863 || var4 > 2048 - var0.field863) {
                  var0.field805 = var0.field831;
                  var6 = false;
               }

               if(var0.field827 == var0.field808 && (var0.field854 > 25 || var6)) {
                  if(var0.field837 != -1) {
                     var0.field827 = var0.field837;
                  } else {
                     var0.field827 = var0.field811;
                  }
               }
            } else {
               var0.field805 += var0.field863;
               var6 = true;
               if(var4 < var0.field863 || var4 > 2048 - var0.field863) {
                  var0.field805 = var0.field831;
                  var6 = false;
               }

               if(var0.field808 == var0.field827 && (var0.field854 > 25 || var6)) {
                  if(var0.field810 != -1) {
                     var0.field827 = var0.field810;
                  } else {
                     var0.field827 = var0.field811;
                  }
               }
            }

            var0.field805 &= 2047;
         } else {
            var0.field854 = 0;
         }

      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZLjava/lang/String;ZB)V",
      garbageValue = "-90"
   )
   static void method3142(String var0, boolean var1, String var2, boolean var3) {
      if(var1) {
         if(!var3 && Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
            try {
               Desktop.getDesktop().browse(new URI(var0));
               return;
            } catch (Exception var5) {
               ;
            }
         }

         if(class138.field2155.startsWith("win") && !var3) {
            class104.method2249(var0, 0);
            return;
         }

         if(class138.field2155.startsWith("mac")) {
            class185.method3673(var0, 1, var2);
            return;
         }

         class104.method2249(var0, 2);
      } else {
         class104.method2249(var0, 3);
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lclass167;Lclass167;I)V",
      garbageValue = "-855597224"
   )
   public static void method3143(class167 var0, class167 var1) {
      class39.field905 = var0;
      class39.field878 = var1;
   }
}
