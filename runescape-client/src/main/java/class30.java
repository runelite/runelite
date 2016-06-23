import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aj")
public class class30 {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -148430261
   )
   int field703;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 700151743
   )
   int field704;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 859618559
   )
   int field705;
   @ObfuscatedName("l")
   String field707;
   @ObfuscatedName("qy")
   @ObfuscatedGetter(
      intValue = 599022613
   )
   public static int field708;
   @ObfuscatedName("rb")
   protected static boolean field709;
   @ObfuscatedName("ex")
   static class78[] field711;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1178748921
   )
   int field712;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)Lclass45;",
      garbageValue = "1619460073"
   )
   public static class45 method708(int var0) {
      class45 var1 = (class45)class45.field1056.method3797((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class213.field3144.method3286(19, var0);
         var1 = new class45();
         if(null != var2) {
            var1.method997(new class119(var2));
         }

         class45.field1056.method3788(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IS)I",
      garbageValue = "128"
   )
   public static int method709(int var0) {
      return var0 > 0?1:(var0 < 0?-1:0);
   }
}
