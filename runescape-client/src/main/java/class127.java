import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dk")
public class class127 {
   @ObfuscatedName("bb")
   static class171 field2086;
   @ObfuscatedName("kn")
   static class134 field2087;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -2144034063
   )
   public static int field2088;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "2083270172"
   )
   static final int method2903(int var0, int var1, int var2) {
      int var3 = var0 / var2;
      int var4 = var0 & var2 - 1;
      int var5 = var1 / var2;
      int var6 = var1 & var2 - 1;
      int var7 = class75.method1668(var3, var5);
      int var8 = class75.method1668(var3 + 1, var5);
      int var9 = class75.method1668(var3, var5 + 1);
      int var10 = class75.method1668(var3 + 1, var5 + 1);
      int var11 = class134.method2963(var7, var8, var4, var2);
      int var12 = class134.method2963(var9, var10, var4, var2);
      return class134.method2963(var11, var12, var6, var2);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass170;IIIZI)V",
      garbageValue = "328967019"
   )
   public static void method2904(class170 var0, int var1, int var2, int var3, boolean var4) {
      class186.field2993 = 1;
      class186.field2998 = var0;
      class119.field2041 = var1;
      class145.field2223 = var2;
      class28.field695 = var3;
      class102.field1760 = var4;
      class186.field2999 = 10000;
   }
}
