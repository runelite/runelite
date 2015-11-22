package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gy")
public class class184 {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 459197531
   )
   int field2974;
   @ObfuscatedName("m")
   byte[] field2975;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1455492665
   )
   int field2976;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -761852825
   )
   int field2977;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -378418119
   )
   int field2978;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 804155943
   )
   int field2979;
   @ObfuscatedName("j")
   byte[] field2981;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -15503455
   )
   int field2982;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -192465839
   )
   int field2984;

   @ObfuscatedName("z")
   static final int method3769(int var0, int var1, int var2, int var3) {
      int var4 = 65536 - class90.field1573[var2 * 1024 / var3] >> 1;
      return (var1 * var4 >> 16) + (var0 * (65536 - var4) >> 16);
   }
}
