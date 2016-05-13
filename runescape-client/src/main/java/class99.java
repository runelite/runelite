import java.awt.Font;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cy")
@Implements("ItemLayer")
public final class class99 {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1676492001
   )
   @Export("hash")
   int field1684;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -449280817
   )
   @Export("x")
   int field1685;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 310708495
   )
   @Export("y")
   int field1686;
   @ObfuscatedName("x")
   @Export("bottom")
   class85 field1687;
   @ObfuscatedName("d")
   @Export("middle")
   class85 field1688;
   @ObfuscatedName("jr")
   static class173[] field1689;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -242931499
   )
   @Export("flags")
   int field1690;
   @ObfuscatedName("el")
   static class78 field1691;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1369365309
   )
   @Export("height")
   int field1693;
   @ObfuscatedName("u")
   @Export("top")
   class85 field1694;
   @ObfuscatedName("qk")
   protected static Font field1695;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IB)Lclass39;",
      garbageValue = "19"
   )
   @Export("getNpcDefinition")
   public static class39 method2179(int var0) {
      class39 var1 = (class39)class39.field888.method3743((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class39.field884.method3239(9, var0);
         var1 = new class39();
         var1.field886 = var0;
         if(null != var2) {
            var1.method746(new class119(var2));
         }

         var1.method745();
         class39.field888.method3745(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("cf")
   @ObfuscatedSignature(
      signature = "(Lclass173;IIZI)V",
      garbageValue = "-1959408718"
   )
   static void method2180(class173 var0, int var1, int var2, boolean var3) {
      int var4 = var0.field2886;
      int var5 = var0.field2781;
      if(var0.field2772 == 0) {
         var0.field2886 = var0.field2776;
      } else if(1 == var0.field2772) {
         var0.field2886 = var1 - var0.field2776;
      } else if(2 == var0.field2772) {
         var0.field2886 = var0.field2776 * var1 >> 14;
      }

      if(var0.field2889 == 0) {
         var0.field2781 = var0.field2777;
      } else if(1 == var0.field2889) {
         var0.field2781 = var2 - var0.field2777;
      } else if(var0.field2889 == 2) {
         var0.field2781 = var0.field2777 * var2 >> 14;
      }

      if(4 == var0.field2772) {
         var0.field2886 = var0.field2781 * var0.field2765 / var0.field2783;
      }

      if(4 == var0.field2889) {
         var0.field2781 = var0.field2886 * var0.field2783 / var0.field2765;
      }

      if(client.field535 && var0.field2767 == 0) {
         if(var0.field2781 < 5 && var0.field2886 < 5) {
            var0.field2781 = 5;
            var0.field2886 = 5;
         } else {
            if(var0.field2781 <= 0) {
               var0.field2781 = 5;
            }

            if(var0.field2886 <= 0) {
               var0.field2886 = 5;
            }
         }
      }

      if(1337 == var0.field2887) {
         client.field449 = var0;
      }

      if(var3 && null != var0.field2874 && (var0.field2886 != var4 || var0.field2781 != var5)) {
         class0 var6 = new class0();
         var6.field8 = var0;
         var6.field12 = var0.field2874;
         client.field283.method3807(var6);
      }

   }
}
