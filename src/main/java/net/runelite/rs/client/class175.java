package net.runelite.rs.client;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fo")
public class class175 {
   @ObfuscatedName("l")
   @Export("settings")
   public static int[] field2904;
   @ObfuscatedName("j")
   static int[] field2905 = new int[32];
   @ObfuscatedName("a")
   @Export("widgetSettings")
   public static int[] field2906;

   static {
      int var0 = 2;

      for(int var1 = 0; var1 < 32; ++var1) {
         field2905[var1] = var0 - 1;
         var0 += var0;
      }

      field2904 = new int[2000];
      field2906 = new int[2000];
   }

   @ObfuscatedName("m")
   public static class151[] method3414() {
      return new class151[]{class151.field2274, class151.field2279, class151.field2270, class151.field2271, class151.field2273};
   }
}
