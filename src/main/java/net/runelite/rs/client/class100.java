package net.runelite.rs.client;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ck")
@Implements("Tile")
public final class class100 extends class207 {
   @ObfuscatedName("y")
   boolean field1746;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1664312453
   )
   @Export("x")
   int field1747;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1840178631
   )
   int field1748;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1924018345
   )
   int field1749;
   @ObfuscatedName("f")
   class88 field1750;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1393601341
   )
   @Export("y")
   int field1751;
   @ObfuscatedName("o")
   class86 field1752;
   @ObfuscatedName("k")
   @Export("itemLayer")
   class98 field1753;
   @ObfuscatedName("n")
   class92 field1754;
   @ObfuscatedName("c")
   class100 field1755;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -150596387
   )
   int field1756;
   @ObfuscatedName("b")
   @Export("objects")
   class97[] field1757 = new class97[5];
   @ObfuscatedName("q")
   int[] field1758 = new int[5];
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1995811917
   )
   int field1759 = 0;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -178836619
   )
   @Export("plane")
   int field1760;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 537873731
   )
   int field1761;
   @ObfuscatedName("d")
   boolean field1762;
   @ObfuscatedName("m")
   class96 field1763;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1724844915
   )
   int field1764;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1731583823
   )
   int field1765;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 278655649
   )
   int field1766;
   @ObfuscatedName("h")
   class93 field1767;
   @ObfuscatedName("s")
   boolean field1768;

   @ObfuscatedName("cc")
   static final String[] method2242(String[] var0) {
      String[] var1 = new String[5];

      for(int var2 = 0; var2 < 5; ++var2) {
         var1[var2] = var2 + ": ";
         if(var0 != null && var0[var2] != null) {
            var1[var2] = var1[var2] + var0[var2];
         }
      }

      return var1;
   }

   @ObfuscatedName("l")
   public static void method2243(int var0, int var1) {
      class47 var2 = class39.method796(var0);
      int var3 = var2.field1067;
      int var4 = var2.field1068;
      int var5 = var2.field1069;
      int var6 = class175.field2905[var5 - var4];
      if(var1 < 0 || var1 > var6) {
         var1 = 0;
      }

      var6 <<= var4;
      class175.field2906[var3] = class175.field2906[var3] & ~var6 | var1 << var4 & var6;
   }

   class100(int var1, int var2, int var3) {
      this.field1749 = this.field1760 = var1;
      this.field1747 = var2;
      this.field1751 = var3;
   }

   @ObfuscatedName("ch")
   static final String method2244(int var0) {
      String var1 = Integer.toString(var0);

      for(int var2 = var1.length() - 3; var2 > 0; var2 -= 3) {
         var1 = var1.substring(0, var2) + "," + var1.substring(var2);
      }

      return var1.length() > 9?" " + class24.method592('ﾀ') + var1.substring(0, var1.length() - 8) + "M" + " " + " (" + var1 + ")" + "</col>":(var1.length() > 6?" " + class24.method592(16777215) + var1.substring(0, var1.length() - 4) + "K" + " " + " (" + var1 + ")" + "</col>":" " + class24.method592(16776960) + var1 + "</col>");
   }
}
