import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hu")
public class class217 {
   @ObfuscatedName("i")
   String field3202;
   @ObfuscatedName("j")
   public final XGrandExchangeOffer field3203;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 830942631
   )
   public final int field3204;
   @ObfuscatedName("z")
   String field3205;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      longValue = -3660468620050067843L
   )
   public final long field3206;

   class217(Buffer var1, byte var2, int var3) {
      this.field3205 = var1.method2774();
      this.field3202 = var1.method2774();
      this.field3204 = var1.method2551();
      this.field3206 = var1.method2562();
      int var4 = var1.method2561();
      int var5 = var1.method2561();
      this.field3203 = new XGrandExchangeOffer();
      this.field3203.method4015(2);
      this.field3203.method4010(var2);
      this.field3203.price = var4;
      this.field3203.totalQuantity = var5;
      this.field3203.quantitySold = 0;
      this.field3203.spent = 0;
      this.field3203.itemId = var3;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "0"
   )
   public String method3967() {
      return this.field3202;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(S)Ljava/lang/String;",
      garbageValue = "9317"
   )
   public String method3969() {
      return this.field3205;
   }
}
