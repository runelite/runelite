import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("j")
public class class8 {
   @ObfuscatedName("rc")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   public static class251 field53;
   @ObfuscatedName("at")
   static int[] field51;
   @ObfuscatedName("ce")
   @Export("middleMouseMovesCamera")
   static boolean middleMouseMovesCamera;
   @ObfuscatedName("fh")
   static byte[][] field58;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)[Lfr;",
      garbageValue = "-2014391752"
   )
   public static class171[] method90() {
      return new class171[]{class171.field2274, class171.field2267, class171.field2269, class171.field2270, class171.field2271, class171.field2276, class171.field2273, class171.field2268, class171.field2275, class171.field2272};
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IB)Ljq;",
      garbageValue = "43"
   )
   public static class267 method92(int var0) {
      class267 var1 = (class267)class267.field3367.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class267.field3386.getConfigData(32, var0);
         var1 = new class267();
         if(var2 != null) {
            var1.method5010(new Buffer(var2));
         }

         class267.field3367.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-44"
   )
   static int method91(int var0, int var1) {
      long var2 = (long)((var0 << 16) + var1);
      return class320.currentRequest != null && var2 == class320.currentRequest.hash?class232.NetCache_responseArchiveBuffer.offset * 99 / (class232.NetCache_responseArchiveBuffer.payload.length - class320.currentRequest.padding) + 1:0;
   }

   @ObfuscatedName("l")
   public static int method93(long var0) {
      return (int)(var0 >>> 17 & 4294967295L);
   }
}
