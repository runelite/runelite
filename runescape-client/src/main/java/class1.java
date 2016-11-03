import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("q")
public class class1 {
   @ObfuscatedName("bk")
   static class171 field13;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1677303329"
   )
   public static int method4(int var0, int var1) {
      int var2 = var0 >>> 31;
      return (var2 + var0) / var1 - var2;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Lclass136;",
      garbageValue = "-1940223253"
   )
   static class136 method6() {
      try {
         return new class150();
      } catch (Throwable var1) {
         return new class144();
      }
   }
}
