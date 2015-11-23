package net.runelite.rs.client;

import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fu")
public class class175 {
   @ObfuscatedName("f")
   @Export("widgetSettings")
   public static int[] field2884;
   @ObfuscatedName("j")
   static int[] field2885 = new int[32];
   @ObfuscatedName("m")
   @Export("settings")
   public static int[] field2887;

   static {
      int var0 = 2;

      for(int var1 = 0; var1 < 32; ++var1) {
         field2885[var1] = var0 - 1;
         var0 += var0;
      }

      field2887 = new int[2000];
      field2884 = new int[2000];
   }
}
