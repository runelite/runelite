import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ci")
@Implements("GameObject")
public final class class98 {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1110913803
   )
   @Export("y")
   int field1636;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 983551319
   )
   @Export("height")
   int field1637;
   @ObfuscatedName("dl")
   static int[] field1638;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -404024169
   )
   int field1639;
   @ObfuscatedName("z")
   @Export("renderable")
   public class85 field1640;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -784414093
   )
   @Export("plane")
   int field1641;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1920415701
   )
   @Export("relativeX")
   int field1642;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 655089249
   )
   @Export("x")
   int field1643;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1130959767
   )
   @Export("relativeY")
   int field1644;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1641327105
   )
   @Export("offsetY")
   int field1645;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -925889521
   )
   int field1646;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -487545543
   )
   @Export("orientation")
   int field1647;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 441424893
   )
   @Export("hash")
   public int field1648 = 0;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1600363513
   )
   @Export("flags")
   int field1649 = 0;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1193533221
   )
   @Export("offsetX")
   int field1650;

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "454640079"
   )
   static String method2193(int var0) {
      return client.field290[var0].length() > 0?client.field420[var0] + " " + client.field290[var0]:client.field420[var0];
   }

   @ObfuscatedName("cu")
   @ObfuscatedSignature(
      signature = "(Lclass173;IIZI)V",
      garbageValue = "-1756050322"
   )
   static void method2194(class173 var0, int var1, int var2, boolean var3) {
      int var4 = var0.field2840;
      int var5 = var0.field2746;
      if(var0.field2751 == 0) {
         var0.field2840 = var0.field2755;
      } else if(1 == var0.field2751) {
         var0.field2840 = var1 - var0.field2755;
      } else if(var0.field2751 == 2) {
         var0.field2840 = var0.field2755 * var1 >> 14;
      }

      if(var0.field2752 == 0) {
         var0.field2746 = var0.field2756;
      } else if(var0.field2752 == 1) {
         var0.field2746 = var2 - var0.field2756;
      } else if(var0.field2752 == 2) {
         var0.field2746 = var2 * var0.field2756 >> 14;
      }

      if(4 == var0.field2751) {
         var0.field2840 = var0.field2746 * var0.field2846 / var0.field2762;
      }

      if(4 == var0.field2752) {
         var0.field2746 = var0.field2762 * var0.field2840 / var0.field2846;
      }

      if(client.field443 && var0.field2820 == 0) {
         if(var0.field2746 < 5 && var0.field2840 < 5) {
            var0.field2746 = 5;
            var0.field2840 = 5;
         } else {
            if(var0.field2746 <= 0) {
               var0.field2746 = 5;
            }

            if(var0.field2840 <= 0) {
               var0.field2840 = 5;
            }
         }
      }

      if(var0.field2748 == 1337) {
         client.field298 = var0;
      }

      if(var3 && var0.field2858 != null && (var0.field2840 != var4 || var0.field2746 != var5)) {
         class0 var6 = new class0();
         var6.field18 = var0;
         var6.field16 = var0.field2858;
         client.field472.method3779(var6);
      }

   }
}
