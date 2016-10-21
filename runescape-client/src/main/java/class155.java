import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("er")
public class class155 implements class115 {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 374656843
   )
   final int field2305;
   @ObfuscatedName("v")
   static final class155 field2308 = new class155(4, 3, false, false, true);
   @ObfuscatedName("n")
   static final class155 field2309 = new class155(2, 1, true, true, false);
   @ObfuscatedName("t")
   static final class155 field2310 = new class155(3, 2, false, false, true);
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1651370251
   )
   public final int field2311;
   @ObfuscatedName("k")
   public final boolean field2312;
   @ObfuscatedName("c")
   public final boolean field2313;
   @ObfuscatedName("e")
   static final class155 field2314 = new class155(1, 0, true, true, true);
   @ObfuscatedName("f")
   static final class155 field2315 = new class155(0, -1, true, false, true);

   @ObfuscatedSignature(
      signature = "(IIZZZ)V",
      garbageValue = "1"
   )
   class155(int var1, int var2, boolean var3, boolean var4, boolean var5) {
      this.field2305 = var1;
      this.field2311 = var2;
      this.field2312 = var4;
      this.field2313 = var5;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "50702266"
   )
   public int vmethod3196() {
      return this.field2305;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;Ljava/lang/String;I)I",
      garbageValue = "-551930405"
   )
   public static int method3179(Buffer var0, String var1) {
      int var2 = var0.offset;
      byte[] var3 = class137.method2889(var1);
      var0.method2712(var3.length);
      var0.offset += class225.field3231.method2462(var3, 0, var3.length, var0.payload, var0.offset);
      return var0.offset - var2;
   }
}
