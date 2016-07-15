import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("an")
public class class34 {
   @ObfuscatedName("j")
   static int[] field796 = new int[2048];
   @ObfuscatedName("y")
   public static String field797;
   @ObfuscatedName("r")
   static class122[] field798 = new class122[2048];
   @ObfuscatedName("h")
   static byte[] field799 = new byte[2048];
   @ObfuscatedName("i")
   static int[] field800 = new int[2048];
   @ObfuscatedName("c")
   static byte[] field801 = new byte[2048];
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 637190137
   )
   static int field802 = 0;
   @ObfuscatedName("p")
   static int[] field803 = new int[2048];
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -145111791
   )
   static int field804 = 0;
   @ObfuscatedName("q")
   static int[] field805 = new int[2048];
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1428338557
   )
   static int field806 = 0;
   @ObfuscatedName("b")
   static int[] field807 = new int[2048];
   @ObfuscatedName("w")
   static class122 field808 = new class122(new byte[5000]);
   @ObfuscatedName("no")
   static class59 field809;
   @ObfuscatedName("o")
   static int[] field810 = new int[2048];
   @ObfuscatedName("ew")
   static class81[] field811;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;I)V",
      garbageValue = "-1688561311"
   )
   public static void method734(class170 var0, class170 var1) {
      class45.field1056 = var0;
      class106.field1846 = var1;
   }

   @ObfuscatedName("cc")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-20"
   )
   static void method735() {
      if(client.field448) {
         class176 var0 = class93.method2180(client.field344, client.field450);
         if(null != var0 && null != var0.field2913) {
            class0 var1 = new class0();
            var1.field2 = var0;
            var1.field4 = var0.field2913;
            class143.method3071(var1);
         }

         client.field448 = false;
         class51.method1124(var0);
      }
   }
}
