import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jm")
@Implements("HorizontalAlignment")
public enum HorizontalAlignment implements Enumerated {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Ljm;"
   )
   field3700(2, 0),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Ljm;"
   )
   field3701(0, 1),
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Ljm;"
   )
   field3702(1, 2);

   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1484889033
   )
   @Export("value")
   public final int value;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1606827001
   )
   final int field3704;

   HorizontalAlignment(int var3, int var4) {
      this.value = var3;
      this.field3704 = var4;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "64"
   )
   public int rsOrdinal() {
      return this.field3704;
   }
}
