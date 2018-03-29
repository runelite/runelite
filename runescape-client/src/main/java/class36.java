import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("am")
public class class36 {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lam;"
   )
   static final class36 field477;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lam;"
   )
   static final class36 field475;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Laj;"
   )
   @Export("scriptMapIconReference")
   static MapIconReference scriptMapIconReference;
   @ObfuscatedName("y")
   static int[] field480;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1877163075
   )
   final int field474;

   static {
      field477 = new class36(0);
      field475 = new class36(1);
   }

   class36(int var1) {
      this.field474 = var1;
   }

   @ObfuscatedName("ix")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "151765542"
   )
   static final int method520() {
      return Client.menuOptionCount - 1;
   }
}
