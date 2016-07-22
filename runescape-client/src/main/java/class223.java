import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hv")
@Implements("XGrandExchangeOffer")
public class class223 {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -860208269
   )
   @Export("price")
   public int field3217;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -184296489
   )
   @Export("itemId")
   public int field3218;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1414638283
   )
   @Export("spent")
   public int field3219;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1395938489
   )
   @Export("totalQuantity")
   public int field3220;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -317558701
   )
   @Export("quantitySold")
   public int field3221;
   @ObfuscatedName("m")
   @Export("progress")
   byte field3222;

   @ObfuscatedSignature(
      signature = "(Lclass122;Z)V",
      garbageValue = "0"
   )
   public class223(class122 var1, boolean var2) {
      this.field3222 = var1.method2573();
      this.field3218 = var1.method2706();
      this.field3217 = var1.method2577();
      this.field3220 = var1.method2577();
      this.field3221 = var1.method2577();
      this.field3219 = var1.method2577();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2127764105"
   )
   public int method4065() {
      return this.field3222 & 7;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "16"
   )
   public int method4067() {
      return (this.field3222 & 8) == 8?1:0;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1495580847"
   )
   void method4068(int var1) {
      this.field3222 &= -8;
      this.field3222 = (byte)(this.field3222 | var1 & 7);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1612121039"
   )
   void method4069(int var1) {
      this.field3222 &= -9;
      if(var1 == 1) {
         this.field3222 = (byte)(this.field3222 | 8);
      }

   }

   public class223() {
   }

   @ObfuscatedName("cj")
   @ObfuscatedSignature(
      signature = "(Lclass176;III)V",
      garbageValue = "-299787002"
   )
   static final void method4080(class176 var0, int var1, int var2) {
      if(null == client.field540 && !client.field517) {
         if(var0 != null && class11.method128(var0) != null) {
            client.field540 = var0;
            client.field352 = class11.method128(var0);
            client.field445 = var1;
            client.field446 = var2;
            class77.field1444 = 0;
            client.field454 = false;
            if(client.field412 > 0) {
               int var3 = client.field412 - 1;
               class221.field3214 = new class32();
               class221.field3214.field725 = client.field294[var3];
               class221.field3214.field720 = client.field414[var3];
               class221.field3214.field722 = client.field415[var3];
               class221.field3214.field724 = client.field322[var3];
               class221.field3214.field723 = client.field417[var3];
            }

         }
      }
   }
}
