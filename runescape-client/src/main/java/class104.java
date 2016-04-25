import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dn")
public final class class104 {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1567125995
   )
   int field1759;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 531011831
   )
   int field1760;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 800527365
   )
   int field1762;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 2019404819
   )
   int field1763;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1945281173
   )
   int field1764;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 804072145
   )
   int field1765;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1075701819
   )
   int field1766;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -932153549
   )
   int field1767;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1417477979
   )
   int field1768;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -358159937
   )
   int field1769;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -18118717
   )
   int field1770;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1173901887
   )
   int field1771;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 517796729
   )
   int field1772;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -202513023
   )
   int field1773;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1454951305
   )
   int field1774;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 543078635
   )
   int field1775;
   @ObfuscatedName("bq")
   static class168 field1776;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -95184137
   )
   int field1780;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1643830381
   )
   int field1781;

   @ObfuscatedName("h")
   public static String method2281(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(0L == var0 % 37L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; 0L != var3; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5;
            char var8;
            for(var5 = new StringBuilder(var2); var0 != 0L; var5.append(var8)) {
               long var6 = var0;
               var0 /= 37L;
               var8 = class162.field2642[(int)(var6 - 37L * var0)];
               if(var8 == 95) {
                  int var9 = var5.length() - 1;
                  var5.setCharAt(var9, Character.toUpperCase(var5.charAt(var9)));
                  var8 = 160;
               }
            }

            var5.reverse();
            var5.setCharAt(0, Character.toUpperCase(var5.charAt(0)));
            return var5.toString();
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([Lclass112;II)Lclass112;",
      garbageValue = "-773603593"
   )
   public static class112 method2282(class112[] var0, int var1) {
      class112[] var2 = var0;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         class112 var4 = var2[var3];
         if(var1 == var4.vmethod3136()) {
            return var4;
         }
      }

      return null;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "119"
   )
   static int method2283(int var0, int var1) {
      class15 var2 = (class15)class15.field210.method3742((long)var0);
      return null == var2?0:(var1 >= 0 && var1 < var2.field212.length?var2.field212[var1]:0);
   }
}
