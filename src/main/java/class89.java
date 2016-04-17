import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cj")
public final class class89 {
   @ObfuscatedName("k")
   boolean field1551 = true;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -760111357
   )
   int field1552;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -2098130761
   )
   int field1553;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -17823197
   )
   int field1554;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -609838631
   )
   int field1555;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -649871239
   )
   int field1556;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -941593415
   )
   int field1557;
   @ObfuscatedName("i")
   public static class228[] field1558;

   @ObfuscatedSignature(
      signature = "(IIIIIIZ)V",
      garbageValue = "0"
   )
   class89(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
      this.field1556 = var1;
      this.field1552 = var2;
      this.field1553 = var3;
      this.field1554 = var4;
      this.field1555 = var5;
      this.field1557 = var6;
      this.field1551 = var7;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "2021149767"
   )
   static final boolean method2162(int var0, int var1) {
      class40 var2 = class133.method2969(var0);
      if(var1 == 11) {
         var1 = 10;
      }

      if(var1 >= 5 && var1 <= 8) {
         var1 = 4;
      }

      return var2.method893(var1);
   }

   @ObfuscatedName("df")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;B)[Ljava/lang/String;",
      garbageValue = "63"
   )
   static final String[] method2163(String[] var0) {
      String[] var1 = new String[5];

      for(int var2 = 0; var2 < 5; ++var2) {
         var1[var2] = var2 + ": ";
         if(var0 != null && null != var0[var2]) {
            var1[var2] = var1[var2] + var0[var2];
         }
      }

      return var1;
   }
}
