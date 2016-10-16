import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("p")
public class class4 {
   @ObfuscatedName("s")
   static final BigInteger field61 = new BigInteger("10001", 16);
   @ObfuscatedName("ne")
   @ObfuscatedGetter(
      intValue = -855146123
   )
   static int field63;
   @ObfuscatedName("z")
   static final BigInteger field64 = new BigInteger("ba4ebfc4353e01d4efccc812b1bcf0ff11078e20b22c52f1fed55a8260c9eba16d46f73df7316a3df04d727a4d5f0d44f548296d666f2970fcc84cb4c9cc689fed264fba39cbf5c7f72c68f562105a392423b8349b1bae66a6fa5c70b2176678e32e731cf8e11671f2cf68fa77e7a7337fec0a94e96857da2530c6336c34e231", 16);

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)LSequence;",
      garbageValue = "2072743194"
   )
   @Export("getAnimation")
   public static Sequence getAnimation(int var0) {
      Sequence var1 = (Sequence)Sequence.field972.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Sequence.field965.method3272(12, var0);
         var1 = new Sequence();
         if(null != var2) {
            var1.method878(new Buffer(var2));
         }

         var1.method880();
         Sequence.field972.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "628191392"
   )
   public static final boolean method44() {
      class140 var0 = class140.keyboard;
      synchronized(class140.keyboard) {
         if(class140.field2167 == class140.field2165) {
            return false;
         } else {
            class162.field2650 = class140.field2162[class140.field2165];
            class130.field2084 = class140.field2161[class140.field2165];
            class140.field2165 = class140.field2165 + 1 & 127;
            return true;
         }
      }
   }
}
