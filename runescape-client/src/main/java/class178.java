import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fg")
public class class178 {
   @ObfuscatedName("i")
   public static final class178 field2671 = new class178("RC", 1);
   @ObfuscatedName("l")
   public static final class178 field2674 = new class178("BUILDLIVE", 3);
   @ObfuscatedName("k")
   public final String field2675;
   @ObfuscatedName("b")
   public static final class178 field2676 = new class178("LIVE", 0);
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1514967003
   )
   public final int field2678;
   @ObfuscatedName("t")
   public static final class178 field2680 = new class178("WIP", 2);

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "0"
   )
   class178(String var1, int var2) {
      this.field2675 = var1;
      this.field2678 = var2;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-379060204"
   )
   static final int method3336(int var0, int var1, int var2) {
      int var3 = var0 / var2;
      int var4 = var0 & var2 - 1;
      int var5 = var1 / var2;
      int var6 = var1 & var2 - 1;
      int var7 = GroundObject.method1601(var3, var5);
      int var8 = GroundObject.method1601(var3 + 1, var5);
      int var9 = GroundObject.method1601(var3, var5 + 1);
      int var10 = GroundObject.method1601(var3 + 1, 1 + var5);
      int var11 = class22.method219(var7, var8, var4, var2);
      int var12 = class22.method219(var9, var10, var4, var2);
      return class22.method219(var11, var12, var6, var2);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-1"
   )
   public static int method3337(int var0) {
      var0 = (var0 & 1431655765) + (var0 >>> 1 & 1431655765);
      var0 = (var0 >>> 2 & 858993459) + (var0 & 858993459);
      var0 = var0 + (var0 >>> 4) & 252645135;
      var0 += var0 >>> 8;
      var0 += var0 >>> 16;
      return var0 & 255;
   }
}
