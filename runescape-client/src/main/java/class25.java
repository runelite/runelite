import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("o")
public final class class25 extends Node {
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 174413919
   )
   int field572;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -516852573
   )
   int field573;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 809982293
   )
   int field574;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1474157331
   )
   int field575;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 564899401
   )
   int field576;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 123038717
   )
   int field578 = -1;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -427300843
   )
   int field579;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 450984957
   )
   int field580;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -115264633
   )
   int field581;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -478521019
   )
   int field582 = 0;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 972424285
   )
   int field583;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 761952131
   )
   int field586;

   @ObfuscatedName("cn")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "97"
   )
   static boolean method554(int var0) {
      return var0 == 57 || var0 == 58 || var0 == 1007 || var0 == 25 || var0 == 30;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)Lclass194;",
      garbageValue = "1404717621"
   )
   public static class194 method555(int var0) {
      class194 var1 = (class194)class194.field2850.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class150.field2048.method3211(14, var0);
         var1 = new class194();
         if(var2 != null) {
            var1.method3484(new Buffer(var2));
         }

         class194.field2850.put(var1, (long)var0);
         return var1;
      }
   }
}
