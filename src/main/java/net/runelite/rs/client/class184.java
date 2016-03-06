import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gk")
public class class184 {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1098260541
   )
   int field2987;
   @ObfuscatedName("l")
   byte[] field2988;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1689120419
   )
   int field2989;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1153110835
   )
   int field2990;
   @ObfuscatedName("j")
   byte[] field2991;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1630533071
   )
   int field2992;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 181020951
   )
   int field2994;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1236439953
   )
   int field2995;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -559863621
   )
   int field2997;

   @ObfuscatedName("n")
   static final int method3675(int var0, int var1, int var2) {
      int var3 = var0 / var2;
      int var4 = var0 & var2 - 1;
      int var5 = var1 / var2;
      int var6 = var1 & var2 - 1;
      int var7 = class50.method1015(var3, var5);
      int var8 = class50.method1015(1 + var3, var5);
      int var9 = class50.method1015(var3, 1 + var5);
      int var10 = class50.method1015(1 + var3, var5 + 1);
      int var12 = 65536 - class90.field1590[var4 * 1024 / var2] >> 1;
      int var11 = (var7 * (65536 - var12) >> 16) + (var12 * var8 >> 16);
      int var14 = 65536 - class90.field1590[1024 * var4 / var2] >> 1;
      int var13 = (var9 * (65536 - var14) >> 16) + (var14 * var10 >> 16);
      int var16 = 65536 - class90.field1590[1024 * var6 / var2] >> 1;
      int var15 = ((65536 - var16) * var11 >> 16) + (var13 * var16 >> 16);
      return var15;
   }
}
