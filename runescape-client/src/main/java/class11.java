import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("w")
public class class11 {
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 186574373
   )
   static int field162 = 0;
   @ObfuscatedName("s")
   @Export("chatLineMap")
   static final Map chatLineMap = new HashMap();
   @ObfuscatedName("k")
   static int[][] field164;
   @ObfuscatedName("t")
   static final class203 field165 = new class203();
   @ObfuscatedName("mx")
   static SpritePixels field166;
   @ObfuscatedName("z")
   static final class201 field168 = new class201(1024);

   @ObfuscatedName("cw")
   @ObfuscatedSignature(
      signature = "(IIIZI)V",
      garbageValue = "1745202819"
   )
   static final void method135(int var0, int var1, int var2, boolean var3) {
      if(class174.method3393(var0)) {
         ChatMessages.method221(Widget.widgets[var0], -1, var1, var2, var3);
      }
   }

   @ObfuscatedName("dz")
   @ObfuscatedSignature(
      signature = "(LWidget;I)I",
      garbageValue = "-1784894771"
   )
   static int method138(Widget var0) {
      class204 var1 = (class204)Client.widgetFlags.method3775((long)var0.index + ((long)var0.id << 32));
      return null != var1?var1.field3151:var0.field2854;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;Ljava/lang/String;Ljava/lang/String;I)Lclass227;",
      garbageValue = "1445240558"
   )
   public static class227 method146(class170 var0, class170 var1, String var2, String var3) {
      int var4 = var0.method3265(var2);
      int var5 = var0.method3266(var4, var3);
      class227 var6;
      if(!class35.method729(var0, var4, var5)) {
         var6 = null;
      } else {
         var6 = class190.method3732(var1.method3272(var4, var5));
      }

      return var6;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZZI)V",
      garbageValue = "1816547527"
   )
   public static void method152(String var0, boolean var1, boolean var2) {
      if(var1) {
         if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
            try {
               Desktop.getDesktop().browse(new URI(var0));
               return;
            } catch (Exception var4) {
               ;
            }
         }

         if(class141.field2176.startsWith("win")) {
            class0.method3(var0, 0, "openjs");
         } else if(class141.field2176.startsWith("mac")) {
            class0.method3(var0, 1, "openjs");
         } else {
            class0.method3(var0, 2, "openjs");
         }
      } else {
         class0.method3(var0, 3, "openjs");
      }

   }
}
