package net.runelite.rs.client;

import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.net.URI;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fj")
public class class158 implements class111 {
   @ObfuscatedName("m")
   public static final class158 field2578 = new class158(0, 1);
   @ObfuscatedName("f")
   public static final class158 field2579 = new class158(2, 2);
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 223201631
   )
   public final int field2580;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 750718579
   )
   final int field2581;
   @ObfuscatedName("j")
   public static final class158 field2582 = new class158(1, 0);
   @ObfuscatedName("bn")
   static class167 field2583;
   @ObfuscatedName("s")
   public static boolean field2586;
   @ObfuscatedName("l")
   public static final class158 field2587 = new class158(3, 3);

   class158(int var1, int var2) {
      this.field2580 = var1;
      this.field2581 = var2;
   }

   @ObfuscatedName("m")
   public int vmethod3208() {
      return this.field2581;
   }

   @ObfuscatedName("m")
   public static void method3209(String var0, boolean var1) {
      if(var1) {
         if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
            try {
               Desktop.getDesktop().browse(new URI(var0));
               return;
            } catch (Exception var3) {
               ;
            }
         }

         if(class137.field2117.startsWith("win")) {
            class122.method2816(var0, 0);
         } else if(class137.field2117.startsWith("mac")) {
            class10.method157(var0, 1, "openjs");
         } else {
            class122.method2816(var0, 2);
         }
      } else {
         class122.method2816(var0, 3);
      }

   }
}
