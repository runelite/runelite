import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hv")
public class class221 implements class178 {
   @ObfuscatedName("e")
   public static final class221 field2819;
   @ObfuscatedName("n")
   static final class221 field2820;
   @ObfuscatedName("r")
   static final class221 field2821;
   @ObfuscatedName("x")
   public static final class221 field2822;
   @ObfuscatedName("w")
   public static final class221 field2823;
   @ObfuscatedName("v")
   static final class221 field2824;
   @ObfuscatedName("p")
   public static final class221 field2825;
   @ObfuscatedName("i")
   static final class221 field2826;
   @ObfuscatedName("f")
   static final class221 field2827;
   @ObfuscatedName("c")
   static final class221 field2828;
   @ObfuscatedName("o")
   static final class221 field2829;
   @ObfuscatedName("q")
   static final class221 field2830;
   @ObfuscatedName("s")
   static final class221 field2831;
   @ObfuscatedName("a")
   static final class221 field2832;
   @ObfuscatedName("g")
   static final class221 field2833;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1492535623
   )
   public final int field2834;
   @ObfuscatedName("m")
   static final class221 field2835;
   @ObfuscatedName("k")
   static final class221 field2836;
   @ObfuscatedName("z")
   static final class221 field2837;
   @ObfuscatedName("l")
   static final class221 field2838;
   @ObfuscatedName("h")
   public static final class221 field2839;
   @ObfuscatedName("d")
   public static final class221 field2840;
   @ObfuscatedName("t")
   public static final class221 field2841;
   @ObfuscatedName("j")
   static final class221 field2842;
   @ObfuscatedName("ci")
   static boolean field2845;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "665522131"
   )
   public int vmethod4906() {
      return this.field2834;
   }

   static {
      field2825 = new class221(0, 0);
      field2835 = new class221(1, 0);
      field2819 = new class221(2, 0);
      field2841 = new class221(3, 0);
      field2823 = new class221(9, 2);
      field2837 = new class221(4, 1);
      field2842 = new class221(5, 1);
      field2826 = new class221(6, 1);
      field2827 = new class221(7, 1);
      field2828 = new class221(8, 1);
      field2829 = new class221(12, 2);
      field2830 = new class221(13, 2);
      field2820 = new class221(14, 2);
      field2832 = new class221(15, 2);
      field2833 = new class221(16, 2);
      field2824 = new class221(17, 2);
      field2831 = new class221(18, 2);
      field2836 = new class221(19, 2);
      field2821 = new class221(20, 2);
      field2838 = new class221(21, 2);
      field2839 = new class221(10, 2);
      field2840 = new class221(11, 2);
      field2822 = new class221(22, 3);
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class221(int var1, int var2) {
      this.field2834 = var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IB)Lclass243;",
      garbageValue = "-88"
   )
   public static class243 method3958(int var0) {
      class243 var1 = (class243)class243.field3322.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class243.field3321.getConfigData(19, var0);
         var1 = new class243();
         if(var2 != null) {
            var1.method4200(new Buffer(var2));
         }

         class243.field3322.put(var1, (long)var0);
         return var1;
      }
   }
}
