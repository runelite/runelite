import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fh")
public class class177 implements class165 {
   @ObfuscatedName("w")
   static final class177 field2670 = new class177(4, 3, false, false, true);
   @ObfuscatedName("d")
   static final class177 field2671 = new class177(1, 0, true, true, true);
   @ObfuscatedName("m")
   static final class177 field2672 = new class177(2, 1, true, true, false);
   @ObfuscatedName("z")
   public final boolean field2673;
   @ObfuscatedName("g")
   public final boolean field2674;
   @ObfuscatedName("r")
   static final class177 field2675 = new class177(5, 10, false, false, true);
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1596607977
   )
   final int field2676;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 2025792427
   )
   public final int field2677;
   @ObfuscatedName("h")
   static final class177 field2678 = new class177(3, 2, false, false, true);
   @ObfuscatedName("n")
   static final class177 field2679 = new class177(0, -1, true, false, true);

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1689281815"
   )
   public int vmethod4132() {
      return this.field2676;
   }

   @ObfuscatedSignature(
      signature = "(IIZZZ)V",
      garbageValue = "1"
   )
   class177(int var1, int var2, boolean var3, boolean var4, boolean var5) {
      this.field2676 = var1;
      this.field2677 = var2;
      this.field2674 = var4;
      this.field2673 = var5;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)Lclass188;",
      garbageValue = "252694279"
   )
   public static class188 method3311(int var0) {
      class188 var1 = (class188)class188.field2783.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class188.field2782.method3329(19, var0);
         var1 = new class188();
         if(null != var2) {
            var1.method3487(new Buffer(var2));
         }

         class188.field2783.put(var1, (long)var0);
         return var1;
      }
   }
}
