import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hp")
@Implements("XGrandExchangeOffer")
public class class220 {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1559204437
   )
   @Export("price")
   public int field3172;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1301485881
   )
   @Export("itemId")
   public int field3173;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1644899351
   )
   @Export("quantitySold")
   public int field3174;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1908037387
   )
   @Export("totalQuantity")
   public int field3175;
   @ObfuscatedName("b")
   @Export("progress")
   byte field3176;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1706290675
   )
   @Export("spent")
   public int field3177;

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1422362194"
   )
   static final void method3995(int var0, int var1, int var2, int var3) {
      if(client.field400 == 1) {
         class110.field1918[client.field304 / 100].method1767(client.field397 - 8, client.field398 - 8);
      }

      if(client.field400 == 2) {
         class110.field1918[client.field304 / 100 + 4].method1767(client.field397 - 8, client.field398 - 8);
      }

      client.field409 = 0;
      int var4 = class4.field62 + (class153.field2262.field813 >> 7);
      int var5 = class85.field1434 + (class153.field2262.field791 >> 7);
      if(var4 >= 3053 && var4 <= 3156 && var5 >= 3056 && var5 <= 3136) {
         client.field409 = 1;
      }

      if(var4 >= 3072 && var4 <= 3118 && var5 >= 9492 && var5 <= 9535) {
         client.field409 = 1;
      }

      if(client.field409 == 1 && var4 >= 3139 && var4 <= 3199 && var5 >= 3008 && var5 <= 3062) {
         client.field409 = 0;
      }

   }

   @ObfuscatedSignature(
      signature = "(Lclass119;Z)V",
      garbageValue = "0"
   )
   public class220(class119 var1, boolean var2) {
      this.field3176 = var1.method2515();
      this.field3173 = var1.method2516();
      this.field3172 = var1.method2519();
      this.field3175 = var1.method2519();
      this.field3174 = var1.method2519();
      this.field3177 = var1.method2519();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "687102488"
   )
   public int method3998() {
      return (this.field3176 & 8) == 8?1:0;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "2"
   )
   void method3999(int var1) {
      this.field3176 &= -8;
      this.field3176 = (byte)(this.field3176 | var1 & 7);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1692617126"
   )
   void method4000(int var1) {
      this.field3176 &= -9;
      if(var1 == 1) {
         this.field3176 = (byte)(this.field3176 | 8);
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-109875471"
   )
   public int method4006() {
      return this.field3176 & 7;
   }

   public class220() {
   }
}
