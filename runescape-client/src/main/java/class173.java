import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fa")
public class class173 {
   @ObfuscatedName("pi")
   @ObfuscatedGetter(
      intValue = 591184169
   )
   static int field2429;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lfa;"
   )
   public static final class173 field2427;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lfa;"
   )
   public static final class173 field2428;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lfa;"
   )
   public static final class173 field2422;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lfa;"
   )
   public static final class173 field2423;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lfa;"
   )
   public static final class173 field2424;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lfa;"
   )
   public static final class173 field2425;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lfa;"
   )
   public static final class173 field2426;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lfa;"
   )
   public static final class173 field2421;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lfa;"
   )
   public static final class173 field2420;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lfa;"
   )
   public static final class173 field2430;

   static {
      field2427 = new class173(5);
      field2428 = new class173(3);
      field2422 = new class173(14);
      field2423 = new class173(6);
      field2424 = new class173(5);
      field2425 = new class173(2);
      field2426 = new class173(15);
      field2421 = new class173(4);
      field2420 = new class173(4);
      field2430 = new class173(7);
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "5"
   )
   class173(int var1) {
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1537757103"
   )
   @Export("nextPowerOfTwo")
   public static int nextPowerOfTwo(int var0) {
      --var0;
      var0 |= var0 >>> 1;
      var0 |= var0 >>> 2;
      var0 |= var0 >>> 4;
      var0 |= var0 >>> 8;
      var0 |= var0 >>> 16;
      return var0 + 1;
   }
}
