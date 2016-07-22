import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.net.URI;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ft")
public class class157 implements class115 {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1527658889
   )
   final int field2337;
   @ObfuscatedName("w")
   static final class157 field2338 = new class157("stellardawn", "Stellar Dawn", 1);
   @ObfuscatedName("e")
   static final class157 field2339 = new class157("game3", "Game 3", 2);
   @ObfuscatedName("o")
   static final class157 field2340 = new class157("game4", "Game 4", 3);
   @ObfuscatedName("g")
   static final class157 field2341 = new class157("game5", "Game 5", 4);
   @ObfuscatedName("l")
   public static final class157 field2342 = new class157("oldscape", "RuneScape 2007", 5);
   @ObfuscatedName("j")
   public final String field2343;
   @ObfuscatedName("be")
   static class171 field2345;
   @ObfuscatedName("m")
   static final class157 field2347 = new class157("runescape", "RuneScape", 0);

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1587180348"
   )
   public int vmethod3218() {
      return this.field2337;
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "0"
   )
   class157(String var1, String var2, int var3) {
      this.field2343 = var1;
      this.field2337 = var3;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZLjava/lang/String;ZI)V",
      garbageValue = "-1901195153"
   )
   public static void method3211(String var0, boolean var1, String var2, boolean var3) {
      if(var1) {
         if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
            try {
               Desktop.getDesktop().browse(new URI(var0));
               return;
            } catch (Exception var5) {
               ;
            }
         }

         if(class141.field2194.startsWith("win")) {
            class87.method1985(var0, 0, "openjs");
            return;
         }

         if(class141.field2194.startsWith("mac")) {
            class87.method1985(var0, 1, var2);
            return;
         }

         class87.method1985(var0, 2, "openjs");
      } else {
         class87.method1985(var0, 3, "openjs");
      }

   }
}
