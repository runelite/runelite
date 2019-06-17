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

   static {
      __cm_m = new BigInteger("10001", 16);
      __cm_f = new BigInteger("db7adc8af6f44b1359c5d1701d6bddc3eb47ce3ff2c690521ec8a9ea27525bf69263cea25648540cb572db8c703eeab85e740d1b44342555ab5733e9884f979fb42929d0a21b79d4a180fe83e48e1abaf08ec41e9dc2c0d8b087dc1a9637df68a64b82dddfdfbc6ae31a3c077434c892c7e8425a0184eed3971fa77b0ec895399d7b683042ee981990d9dd2ce3c436be9b2ec93587fb25d1f17cbb771e0f0bf88b27c47af0fd5417f4d1977e3f5483f787a71f59820d1b29a9af9460c6ad8a713ee2a1bf4021e51ce9776aa4eddae3616a808174493b572218c957c15b06df5aef889dbfd5de3a1326ea2d47dbf68b5bd06201b36d6ca5dedb69a8be84c254bb", 16);
   }
}
