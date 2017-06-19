import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hv")
public enum class221 implements RSEnum {
   @ObfuscatedName("p")
   field2825(0, 0),
   @ObfuscatedName("m")
   field2835(1, 0),
   @ObfuscatedName("e")
   field2819(2, 0),
   @ObfuscatedName("t")
   field2841(3, 0),
   @ObfuscatedName("w")
   field2823(9, 2),
   @ObfuscatedName("z")
   field2837(4, 1),
   @ObfuscatedName("j")
   field2842(5, 1),
   @ObfuscatedName("i")
   field2826(6, 1),
   @ObfuscatedName("f")
   field2827(7, 1),
   @ObfuscatedName("c")
   field2828(8, 1),
   @ObfuscatedName("o")
   field2829(12, 2),
   @ObfuscatedName("q")
   field2830(13, 2),
   @ObfuscatedName("n")
   field2820(14, 2),
   @ObfuscatedName("a")
   field2832(15, 2),
   @ObfuscatedName("g")
   field2833(16, 2),
   @ObfuscatedName("v")
   field2824(17, 2),
   @ObfuscatedName("s")
   field2831(18, 2),
   @ObfuscatedName("k")
   field2836(19, 2),
   @ObfuscatedName("r")
   field2821(20, 2),
   @ObfuscatedName("l")
   field2838(21, 2),
   @ObfuscatedName("h")
   field2839(10, 2),
   @ObfuscatedName("d")
   field2840(11, 2),
   @ObfuscatedName("x")
   field2822(22, 3);

   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1492535623
   )
   public final int field2834;
   @ObfuscatedName("ci")
   static boolean field2845;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "665522131"
   )
   public int rsOrdinal() {
      return this.field2834;
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   private class221(int var3, int var4) {
      this.field2834 = var3;
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
