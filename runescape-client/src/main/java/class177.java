import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fd")
public class class177 implements class158 {
   @ObfuscatedName("v")
   public static final class177 field2668 = new class177(5, 10, false, false, true);
   @ObfuscatedName("m")
   public static final class177 field2669 = new class177(1, 0, true, true, true);
   @ObfuscatedName("cb")
   @ObfuscatedGetter(
      intValue = -740217913
   )
   public static int field2670;
   @ObfuscatedName("b")
   public static final class177 field2671 = new class177(2, 1, true, true, false);
   @ObfuscatedName("h")
   public static final class177 field2672 = new class177(4, 3, false, false, true);
   @ObfuscatedName("g")
   public static final class177 field2673 = new class177(3, 2, false, false, true);
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 458310047
   )
   final int field2674;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 791626915
   )
   public final int field2675;
   @ObfuscatedName("o")
   public static final class177 field2676 = new class177(0, -1, true, false, true);
   @ObfuscatedName("k")
   public final boolean field2677;
   @ObfuscatedName("mo")
   @ObfuscatedGetter(
      intValue = -489554013
   )
   static int field2678;
   @ObfuscatedName("pw")
   @ObfuscatedGetter(
      intValue = 554145589
   )
   static int field2679;
   @ObfuscatedName("u")
   public final boolean field2680;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "656494876"
   )
   public static boolean method3184(int var0) {
      return (var0 >> 20 & 1) != 0;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "255"
   )
   public int vmethod3989() {
      return this.field2674;
   }

   @ObfuscatedSignature(
      signature = "(IIZZZ)V",
      garbageValue = "1"
   )
   class177(int var1, int var2, boolean var3, boolean var4, boolean var5) {
      this.field2674 = var1;
      this.field2675 = var2;
      this.field2680 = var4;
      this.field2677 = var5;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IB)Lclass187;",
      garbageValue = "0"
   )
   public static class187 method3187(int var0) {
      class187 var1 = (class187)class187.field2780.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class187.field2781.method3203(16, var0);
         var1 = new class187();
         if(null != var2) {
            var1.method3347(new Buffer(var2));
         }

         class187.field2780.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "([BZI)Ljava/lang/Object;",
      garbageValue = "461393858"
   )
   public static Object method3189(byte[] var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else {
         if(var0.length > 136 && !class156.field2130) {
            try {
               class151 var2 = new class151();
               var2.vmethod2938(var0);
               return var2;
            } catch (Throwable var3) {
               class156.field2130 = true;
            }
         }

         return var0;
      }
   }
}
