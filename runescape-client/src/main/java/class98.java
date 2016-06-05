import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ce")
@Implements("GameObject")
public final class class98 {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -741167035
   )
   @Export("offsetY")
   int field1670;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1965283355
   )
   @Export("height")
   int field1671;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1764557735
   )
   @Export("x")
   int field1672;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -929976675
   )
   @Export("y")
   int field1673;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 2078477207
   )
   int field1674;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 822481077
   )
   @Export("orientation")
   int field1675;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -233991379
   )
   @Export("relativeX")
   int field1676;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1981069411
   )
   @Export("offsetX")
   int field1677;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -446964189
   )
   @Export("hash")
   public int field1678 = 0;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 2146710195
   )
   @Export("plane")
   int field1680;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1541485691
   )
   @Export("relativeY")
   int field1681;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -2032228429
   )
   int field1682;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 991734535
   )
   @Export("flags")
   int field1683 = 0;
   @ObfuscatedName("de")
   static int[] field1684;
   @ObfuscatedName("z")
   @Export("renderable")
   public class85 field1685;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "25"
   )
   public static void method2152() {
      try {
         class149.field2264.method4095();

         for(int var0 = 0; var0 < class149.field2265; ++var0) {
            class134.field2093[var0].method4095();
         }

         class149.field2268.method4095();
         class149.field2269.method4095();
      } catch (Exception var2) {
         ;
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "14500"
   )
   public static void method2153(int var0) {
      class140.field2174 = var0;
   }
}
