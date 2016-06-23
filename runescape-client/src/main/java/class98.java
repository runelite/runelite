import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cy")
@Implements("GameObject")
public final class class98 {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -31726923
   )
   @Export("relativeY")
   int field1660;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 254917313
   )
   @Export("height")
   int field1661;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1301833403
   )
   @Export("y")
   int field1663;
   @ObfuscatedName("l")
   @Export("renderable")
   public class85 field1664;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 713931617
   )
   @Export("orientation")
   int field1665;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 805770711
   )
   @Export("relativeX")
   int field1666;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 303187707
   )
   @Export("offsetX")
   int field1667;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1689788817
   )
   @Export("plane")
   int field1668;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -815899025
   )
   @Export("offsetY")
   int field1669;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1028039575
   )
   int field1670;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1317721889
   )
   @Export("x")
   int field1671;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 677833877
   )
   @Export("hash")
   public int field1672 = 0;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -2117256779
   )
   @Export("flags")
   int field1673 = 0;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1276226507
   )
   public static int field1674;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1381286635
   )
   int field1675;

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "48053792"
   )
   static final void method2263(int var0, int var1, int var2) {
      if(var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
         int var3 = class74.method1659(var0, var1, class14.field212) - var2;
         var0 -= class216.field3160;
         var3 -= class1.field27;
         var1 -= class26.field665;
         int var4 = class91.field1597[class134.field2082];
         int var5 = class91.field1577[class134.field2082];
         int var6 = class91.field1597[class42.field1018];
         int var7 = class91.field1577[class42.field1018];
         int var8 = var7 * var0 + var6 * var1 >> 16;
         var1 = var7 * var1 - var6 * var0 >> 16;
         var0 = var8;
         var8 = var5 * var3 - var4 * var1 >> 16;
         var1 = var5 * var1 + var4 * var3 >> 16;
         if(var1 >= 50) {
            client.field395 = client.field548 * var0 / var1 + client.field432 / 2;
            client.field396 = client.field548 * var8 / var1 + client.field553 / 2;
         } else {
            client.field395 = -1;
            client.field396 = -1;
         }

      } else {
         client.field395 = -1;
         client.field396 = -1;
      }
   }

   @ObfuscatedName("f")
   public static final void method2264(long var0) {
      if(var0 > 0L) {
         if(var0 % 10L == 0L) {
            long var2 = var0 - 1L;

            try {
               Thread.sleep(var2);
            } catch (InterruptedException var8) {
               ;
            }

            try {
               Thread.sleep(1L);
            } catch (InterruptedException var7) {
               ;
            }
         } else {
            try {
               Thread.sleep(var0);
            } catch (InterruptedException var6) {
               ;
            }
         }

      }
   }

   @ObfuscatedName("cd")
   @ObfuscatedSignature(
      signature = "(Lclass173;IIB)V",
      garbageValue = "118"
   )
   static void method2265(class173 var0, int var1, int var2) {
      if(var0.field2759 == 0) {
         var0.field2873 = var0.field2763;
      } else if(var0.field2759 == 1) {
         var0.field2873 = var0.field2763 + (var1 - var0.field2769) / 2;
      } else if(var0.field2759 == 2) {
         var0.field2873 = var1 - var0.field2769 - var0.field2763;
      } else if(var0.field2759 == 3) {
         var0.field2873 = var0.field2763 * var1 >> 14;
      } else if(var0.field2759 == 4) {
         var0.field2873 = (var1 - var0.field2769) / 2 + (var0.field2763 * var1 >> 14);
      } else {
         var0.field2873 = var1 - var0.field2769 - (var0.field2763 * var1 >> 14);
      }

      if(var0.field2858 == 0) {
         var0.field2807 = var0.field2753;
      } else if(var0.field2858 == 1) {
         var0.field2807 = var0.field2753 + (var2 - var0.field2888) / 2;
      } else if(var0.field2858 == 2) {
         var0.field2807 = var2 - var0.field2888 - var0.field2753;
      } else if(var0.field2858 == 3) {
         var0.field2807 = var2 * var0.field2753 >> 14;
      } else if(var0.field2858 == 4) {
         var0.field2807 = (var2 - var0.field2888) / 2 + (var0.field2753 * var2 >> 14);
      } else {
         var0.field2807 = var2 - var0.field2888 - (var2 * var0.field2753 >> 14);
      }

      if(client.field534 && var0.field2798 == 0) {
         if(var0.field2873 < 0) {
            var0.field2873 = 0;
         } else if(var0.field2873 + var0.field2769 > var1) {
            var0.field2873 = var1 - var0.field2769;
         }

         if(var0.field2807 < 0) {
            var0.field2807 = 0;
         } else if(var0.field2807 + var0.field2888 > var2) {
            var0.field2807 = var2 - var0.field2888;
         }
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass167;Lclass167;I)V",
      garbageValue = "1739804904"
   )
   public static void method2266(class167 var0, class167 var1) {
      class44.field1051 = var0;
      class44.field1043 = var1;
      class217.field3162 = class44.field1051.method3321(3);
   }

   @ObfuscatedName("dd")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   static final void method2267() {
      client.field333.method2773(12);

      for(class3 var0 = (class3)client.field448.method3825(); null != var0; var0 = (class3)client.field448.method3823()) {
         if(var0.field62 == 0 || var0.field62 == 3) {
            class23.method628(var0, true);
         }
      }

      if(null != client.field312) {
         class39.method818(client.field312);
         client.field312 = null;
      }

   }
}
