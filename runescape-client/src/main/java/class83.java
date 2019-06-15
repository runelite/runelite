import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cm")
public class class83 {
   @ObfuscatedName("m")
   @Export("__cm_m")
   static final BigInteger __cm_m;
   @ObfuscatedName("f")
   @Export("__cm_f")
   static final BigInteger __cm_f;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 533653621
   )
   @Export("__cm_e")
   public static int __cm_e;

   static {
      __cm_m = new BigInteger("10001", 16);
      __cm_f = new BigInteger("a181e4c9b7c4ae27afa67c87f25364d4edaaca3c4469db685caeb364d37584dadb6c61e33782065de4e6895674c56f0facf0672cab09e95c02c2862a7501ba4f2ac713a3153c137f4c69f0a3c2fc674fa5f43dfa956f2ab98d300c9af3c98fba50a132170a7623fbb29b6fc48710e2f7e1abaf23b3eb3f825cb6fef68e63b934d4c4bf0f3a6a7fdde7716a67944a11df711adc5994597ca1e0603fac548300b8a060b37ebec3a711ce9e112bfa70dd01eadbee6b787daffe299ad501b6ef9937deefe969882c7c20bee7b3a956c9e921a1a7539ac501d86576b1ceea6a07b9f0c7e31fce121008821aa6b752cac49f20c42c2c4e84caf93165af6d2b32211257", 16);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1211070559"
   )
   static int method2027(int var0, int var1) {
      ItemContainer var2 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
      return var2 == null?-1:(var1 >= 0 && var1 < var2.ids.length?var2.ids[var1]:-1);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Z",
      garbageValue = "-1468699107"
   )
   static boolean method2026(String var0) {
      if(var0 == null) {
         return false;
      } else {
         try {
            new URL(var0);
            return true;
         } catch (MalformedURLException var2) {
            return false;
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lir;II)Llq;",
      garbageValue = "1413048059"
   )
   public static IndexedSprite method2028(AbstractIndexCache var0, int var1) {
      return !class179.method3643(var0, var1)?null:ServerPacket.method3663();
   }
}
