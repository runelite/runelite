import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hp")
public class class217 {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1636570499
   )
   public final int field3197;
   @ObfuscatedName("f")
   public final XGrandExchangeOffer field3198;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      longValue = -3076635769132597463L
   )
   public final long field3199;
   @ObfuscatedName("c")
   String field3200;
   @ObfuscatedName("v")
   String field3201;
   @ObfuscatedName("t")
   static int[] field3202;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "-61"
   )
   public String method3983() {
      return this.field3201;
   }

   class217(Buffer var1, byte var2, int var3) {
      this.field3200 = var1.method2579();
      this.field3201 = var1.method2579();
      this.field3197 = var1.method2691();
      this.field3199 = var1.method2704();
      int var4 = var1.method2576();
      int var5 = var1.method2576();
      this.field3198 = new XGrandExchangeOffer();
      this.field3198.method4019(2);
      this.field3198.method4020(var2);
      this.field3198.price = var4;
      this.field3198.totalQuantity = var5;
      this.field3198.quantitySold = 0;
      this.field3198.spent = 0;
      this.field3198.itemId = var3;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "2045583647"
   )
   public String method3984() {
      return this.field3200;
   }
}
