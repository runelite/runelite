import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("et")
public class class155 implements class115 {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1516117639
   )
   public final int field2304;
   @ObfuscatedName("z")
   public static final class155 field2305 = new class155(1, 0, true, true, true);
   @ObfuscatedName("t")
   public static final class155 field2306 = new class155(2, 1, true, true, false);
   @ObfuscatedName("y")
   public static final class155 field2307 = new class155(3, 2, false, false, true);
   @ObfuscatedName("p")
   public static final class155 field2308 = new class155(4, 3, false, false, true);
   @ObfuscatedName("s")
   public static final class155 field2309 = new class155(0, -1, true, false, true);
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 344159641
   )
   final int field2310;
   @ObfuscatedName("js")
   @ObfuscatedGetter(
      intValue = -624874933
   )
   static int field2311;
   @ObfuscatedName("k")
   public final boolean field2312;
   @ObfuscatedName("f")
   public final boolean field2314;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "([BB)[B",
      garbageValue = "61"
   )
   static final byte[] method3145(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      int var2 = var1.method2481();
      int var3 = var1.method2526();
      if(var3 >= 0 && (class170.field2723 == 0 || var3 <= class170.field2723)) {
         if(var2 == 0) {
            byte[] var6 = new byte[var3];
            var1.method2492(var6, 0, var3);
            return var6;
         } else {
            int var4 = var1.method2526();
            if(var4 < 0 || class170.field2723 != 0 && var4 > class170.field2723) {
               throw new RuntimeException();
            } else {
               byte[] var5 = new byte[var4];
               if(var2 == 1) {
                  class120.method2440(var5, var4, var0, var3, 9);
               } else {
                  class170.field2730.method2424(var1, var5);
               }

               return var5;
            }
         }
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "8"
   )
   public int vmethod3162() {
      return this.field2310;
   }

   @ObfuscatedSignature(
      signature = "(IIZZZ)V",
      garbageValue = "1"
   )
   class155(int var1, int var2, boolean var3, boolean var4, boolean var5) {
      this.field2310 = var1;
      this.field2304 = var2;
      this.field2314 = var4;
      this.field2312 = var5;
   }
}
