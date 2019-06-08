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
      __cm_f = new BigInteger("83ff79a3e258b99ead1a70e1049883e78e513c4cdec538d8da9483879a9f81689c0c7d146d7b82b52d05cf26132b1cda5930eeef894e4ccf3d41eebc3aabe54598c4ca48eb5a31d736bfeea17875a35558b9e3fcd4aebe2a9cc970312a477771b36e173dc2ece6001ab895c553e2770de40073ea278026f36961c94428d8d7db", 16);
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
