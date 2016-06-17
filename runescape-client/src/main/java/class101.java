import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cw")
@Implements("Tile")
public final class class101 extends class208 {
   @ObfuscatedName("y")
   class97 field1712;
   @ObfuscatedName("c")
   @Export("decorativeObject")
   class94 field1713;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1776289263
   )
   @Export("y")
   int field1714;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -2011293631
   )
   int field1715;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1078188803
   )
   int field1716;
   @ObfuscatedName("x")
   class89 field1717;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 318255073
   )
   @Export("plane")
   int field1718;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1002460037
   )
   int field1719;
   @ObfuscatedName("l")
   @Export("groundObject")
   class93 field1720;
   @ObfuscatedName("u")
   @Export("itemLayer")
   class99 field1721;
   @ObfuscatedName("r")
   @Export("wallObject")
   class87 field1722;
   @ObfuscatedName("n")
   @Export("objects")
   class98[] field1723 = new class98[5];
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1318614705
   )
   int field1725 = 0;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1759744717
   )
   int field1726;
   @ObfuscatedName("o")
   boolean field1727;
   @ObfuscatedName("t")
   boolean field1728;
   @ObfuscatedName("h")
   boolean field1729;
   @ObfuscatedName("w")
   int[] field1730 = new int[5];
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1969664301
   )
   int field1731;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 635854795
   )
   int field1732;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1182460605
   )
   int field1733;
   @ObfuscatedName("m")
   class101 field1734;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -806620621
   )
   @Export("x")
   int field1735;
   @ObfuscatedName("qm")
   @ObfuscatedGetter(
      intValue = 677827679
   )
   static int field1739;
   @ObfuscatedName("jp")
   @ObfuscatedGetter(
      intValue = -2006184955
   )
   static int field1740;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Ljava/lang/Class;",
      garbageValue = "0"
   )
   static Class method2287(String var0) throws ClassNotFoundException {
      return var0.equals("B")?Byte.TYPE:(var0.equals("I")?Integer.TYPE:(var0.equals("S")?Short.TYPE:(var0.equals("J")?Long.TYPE:(var0.equals("Z")?Boolean.TYPE:(var0.equals("F")?Float.TYPE:(var0.equals("D")?Double.TYPE:(var0.equals("C")?Character.TYPE:(var0.equals("void")?Void.TYPE:Class.forName(var0)))))))));
   }

   class101(int var1, int var2, int var3) {
      this.field1715 = this.field1718 = var1;
      this.field1735 = var2;
      this.field1714 = var3;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass122;IB)Z",
      garbageValue = "88"
   )
   static boolean method2288(class122 var0, int var1) {
      int var2 = var0.method2784(2);
      int var3;
      int var4;
      int var7;
      int var8;
      int var9;
      int var10;
      if(var2 == 0) {
         if(var0.method2784(1) != 0) {
            method2288(var0, var1);
         }

         var3 = var0.method2784(6);
         var4 = var0.method2784(6);
         boolean var12 = var0.method2784(1) == 1;
         if(var12) {
            class32.field746[++class32.field745 - 1] = var1;
         }

         if(client.field410[var1] != null) {
            throw new RuntimeException();
         } else {
            class2 var6 = client.field410[var1] = new class2();
            var6.field48 = var1;
            if(class32.field737[var1] != null) {
               var6.method13(class32.field737[var1]);
            }

            var6.field840 = class32.field743[var1];
            var6.field815 = class32.field744[var1];
            var7 = class32.field741[var1];
            var8 = var7 >> 28;
            var9 = var7 >> 14 & 255;
            var10 = var7 & 255;
            var6.field846[0] = class32.field736[var1];
            var6.field47 = (byte)var8;
            var6.method17((var9 << 6) + var3 - class4.field62, (var10 << 6) + var4 - class85.field1434);
            var6.field29 = false;
            return true;
         }
      } else if(var2 == 1) {
         var3 = var0.method2784(2);
         var4 = class32.field741[var1];
         class32.field741[var1] = (var4 & 268435455) + ((var3 + (var4 >> 28) & 3) << 28);
         return false;
      } else {
         int var5;
         int var11;
         if(var2 == 2) {
            var3 = var0.method2784(5);
            var4 = var3 >> 3;
            var5 = var3 & 7;
            var11 = class32.field741[var1];
            var7 = var4 + (var11 >> 28) & 3;
            var8 = var11 >> 14 & 255;
            var9 = var11 & 255;
            if(var5 == 0) {
               --var8;
               --var9;
            }

            if(var5 == 1) {
               --var9;
            }

            if(var5 == 2) {
               ++var8;
               --var9;
            }

            if(var5 == 3) {
               --var8;
            }

            if(var5 == 4) {
               ++var8;
            }

            if(var5 == 5) {
               --var8;
               ++var9;
            }

            if(var5 == 6) {
               ++var9;
            }

            if(var5 == 7) {
               ++var8;
               ++var9;
            }

            class32.field741[var1] = (var8 << 14) + (var7 << 28) + var9;
            return false;
         } else {
            var3 = var0.method2784(18);
            var4 = var3 >> 16;
            var5 = var3 >> 8 & 255;
            var11 = var3 & 255;
            var7 = class32.field741[var1];
            var8 = (var7 >> 28) + var4 & 3;
            var9 = var5 + (var7 >> 14) & 255;
            var10 = var7 + var11 & 255;
            class32.field741[var1] = var10 + (var9 << 14) + (var8 << 28);
            return false;
         }
      }
   }
}
