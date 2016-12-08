import java.io.IOException;
import java.math.BigInteger;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("af")
public class class39 {
   @ObfuscatedName("o")
   static final BigInteger field813 = new BigInteger("10001", 16);
   @ObfuscatedName("m")
   static final BigInteger field814 = new BigInteger("ebfa4d647ae869b5b46c2c32e3f4c58fc231bc87e42216ca972d403d9be7c6e215a2a7374f47846b8dbbc6cbbe41f31d520efd7c6985bc818c5b5852dc50a1980f9219030318c959c146e48ebfe5fd915a050e285bd34fec8e18d2229c72bef4de1520e2b9e01c99a460211d57d8931171c6b69ef6ebc8eb95539aea0ecd3ac9", 16);

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)Lclass30;",
      garbageValue = "68643308"
   )
   static class30 method728() {
      FileOnDisk var0 = null;
      class30 var1 = new class30();

      try {
         var0 = class33.method676("", class145.field2024.field2700, false);
         byte[] var2 = new byte[(int)var0.method1389()];

         int var4;
         for(int var3 = 0; var3 < var2.length; var3 += var4) {
            var4 = var0.method1391(var2, var3, var2.length - var3);
            if(var4 == -1) {
               throw new IOException();
            }
         }

         var1 = new class30(new Buffer(var2));
      } catch (Exception var6) {
         ;
      }

      try {
         if(var0 != null) {
            var0.method1400();
         }
      } catch (Exception var5) {
         ;
      }

      return var1;
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   static final void method729() {
      for(int var0 = 0; var0 < Client.field492; ++var0) {
         int var1 = Client.field327[var0];
         NPC var2 = Client.cachedNPCs[var1];
         if(null != var2) {
            class97.method1885(var2, var2.composition.field2999);
         }
      }

   }
}
