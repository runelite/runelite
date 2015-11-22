package net.runelite.rs.client;

import java.applet.Applet;
import java.awt.Image;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ci")
public final class class103 {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -537800803
   )
   int field1753;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 664383329
   )
   int field1754;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 336849963
   )
   int field1755;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1716526951
   )
   int field1756;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1236130491
   )
   int field1757;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -2099594265
   )
   int field1758;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1955440971
   )
   int field1759;
   @ObfuscatedName("qo")
   protected static Image field1760;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1796006321
   )
   int field1761;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -65501289
   )
   int field1762;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1567592825
   )
   int field1763;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1575499695
   )
   int field1764;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -821294535
   )
   int field1765;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -210686373
   )
   int field1766;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 721737567
   )
   int field1767;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1377189027
   )
   int field1768;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 298954873
   )
   int field1769;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 2076207045
   )
   int field1770;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 102202303
   )
   int field1772;
   @ObfuscatedName("nn")
   static class74 field1774;

   @ObfuscatedName("p")
   static final int method2323(int var0, int var1) {
      int var2 = class47.method1022(var0 - 1, var1 - 1) + class47.method1022(var0 + 1, var1 - 1) + class47.method1022(var0 - 1, var1 + 1) + class47.method1022(1 + var0, 1 + var1);
      int var3 = class47.method1022(var0 - 1, var1) + class47.method1022(1 + var0, var1) + class47.method1022(var0, var1 - 1) + class47.method1022(var0, 1 + var1);
      int var4 = class47.method1022(var0, var1);
      return var3 / 8 + var2 / 16 + var4 / 4;
   }

   @ObfuscatedName("j")
   public static void method2324(class166 var0, class166 var1, class166 var2, class166 var3) {
      class172.field2726 = var0;
      class172.field2727 = var1;
      class52.field1150 = var2;
      class112.field1945 = var3;
      class172.field2857 = new class172[class172.field2726.method3361()][];
      class172.field2725 = new boolean[class172.field2726.method3361()];
   }

   @ObfuscatedName("j")
   public static void method2325(Applet var0, String var1) {
      class137.field2116 = var0;
      class137.field2117 = var1;
   }

   @ObfuscatedName("bp")
   static final void method2326(class30 var0, int var1, int var2) {
      class136.method2961(var0.field688, var0.field680, var0.field681, var0.field686, var0.field683, var1, var2);
   }

   @ObfuscatedName("f")
   static char method2327(char var0) {
      return 181 != var0 && 402 != var0?Character.toTitleCase(var0):var0;
   }

   @ObfuscatedName("l")
   static void method2328() {
      Object var0 = class169.field2690;
      synchronized(class169.field2690) {
         if(class169.field2693 == 0) {
            class25.field630.method2919(new class169(), 5);
         }

         class169.field2693 = 600;
      }
   }
}
