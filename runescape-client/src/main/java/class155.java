import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.io.File;
import java.net.URI;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ee")
public class class155 {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Ldv;"
   )
   static CacheFile field2240;
   @ObfuscatedName("et")
   @ObfuscatedSignature(
      signature = "Ljh;"
   )
   static Font field2238;
   @ObfuscatedName("g")
   public static File field2237;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Ldv;"
   )
   public static CacheFile field2239;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Ldv;"
   )
   public static CacheFile field2241;

   static {
      field2240 = null;
      field2239 = null;
      field2241 = null;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZZI)V",
      garbageValue = "-2088264904"
   )
   public static void method2999(String var0, boolean var1, boolean var2) {
      if(var1) {
         if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
            try {
               Desktop.getDesktop().browse(new URI(var0));
               return;
            } catch (Exception var4) {
               ;
            }
         }

         if(class56.field692.startsWith("win")) {
            class254.method4577(var0, 0);
         } else if(class56.field692.startsWith("mac")) {
            Parameters.method4989(var0, 1, "openjs");
         } else {
            class254.method4577(var0, 2);
         }
      } else {
         class254.method4577(var0, 3);
      }

   }

   @ObfuscatedName("hc")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "16711935"
   )
   static void method3015(int var0, int var1, int var2, int var3) {
      Widget var4 = class215.method4064(var0, var1);
      if(var4 != null && var4.field2755 != null) {
         ScriptEvent var5 = new ScriptEvent();
         var5.widget = var4;
         var5.field849 = var4.field2755;
         class56.method817(var5);
      }

      Client.field1169 = var3;
      Client.spellSelected = true;
      class56.field696 = var0;
      Client.field1070 = var1;
      class90.field1421 = var2;
      class45.method647(var4);
   }
}
