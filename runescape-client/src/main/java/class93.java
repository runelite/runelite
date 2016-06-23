import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cb")
@Implements("GroundObject")
public final class class93 {
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1145864475
   )
   @Export("x")
   int field1600;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 80431229
   )
   @Export("y")
   int field1601;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1657107943
   )
   int field1602;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -952495603
   )
   @Export("hash")
   public int field1603;
   @ObfuscatedName("b")
   @Export("renderable")
   public class85 field1605;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -2018659675
   )
   @Export("floor")
   int field1606;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1264608347"
   )
   static boolean method2226(int var0, int var1) {
      return var0 != 4 || var1 < 8;
   }
}
