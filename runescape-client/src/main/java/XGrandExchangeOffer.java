import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("w")
@Implements("XGrandExchangeOffer")
public class XGrandExchangeOffer {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1250729179
   )
   @Export("quantitySold")
   public int quantitySold;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1168423671
   )
   @Export("itemId")
   public int itemId;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1464174603
   )
   @Export("totalQuantity")
   public int totalQuantity;
   @ObfuscatedName("k")
   @Export("progress")
   byte progress;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 581956319
   )
   @Export("spent")
   public int spent;
   @ObfuscatedName("ae")
   static class110 field44;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -812897861
   )
   @Export("price")
   public int price;

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1469779072"
   )
   static final void method48() {
      for(class33 var0 = (class33)Client.field411.method2403(); null != var0; var0 = (class33)Client.field411.method2398()) {
         if(var0.field748 == class48.plane && !var0.field744) {
            if(Client.gameCycle >= var0.field736) {
               var0.method717(Client.field354);
               if(var0.field744) {
                  var0.unlink();
               } else {
                  class65.region.method1718(var0.field748, var0.field738, var0.field739, var0.field746, 60, var0, 0, -1, false);
               }
            }
         } else {
            var0.unlink();
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "1"
   )
   public int method51() {
      return (this.progress & 8) == 8?1:0;
   }

   public XGrandExchangeOffer() {
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-88741603"
   )
   void method53(int var1) {
      this.progress &= -9;
      if(var1 == 1) {
         this.progress = (byte)(this.progress | 8);
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-996358829"
   )
   public int method62() {
      return this.progress & 7;
   }

   @ObfuscatedSignature(
      signature = "(LBuffer;Z)V",
      garbageValue = "0"
   )
   public XGrandExchangeOffer(Buffer var1, boolean var2) {
      this.progress = var1.readByte();
      this.itemId = var1.readUnsignedShort();
      this.price = var1.method3062();
      this.totalQuantity = var1.method3062();
      this.quantitySold = var1.method3062();
      this.spent = var1.method3062();
   }

   @ObfuscatedName("dc")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "122"
   )
   static void method70(int var0) {
      Friend.field158 = new class38();
      Friend.field158.field796 = Client.menuActionParams0[var0];
      Friend.field158.field791 = Client.menuActionParams1[var0];
      Friend.field158.field792 = Client.menuTypes[var0];
      Friend.field158.field793 = Client.menuIdentifiers[var0];
      Friend.field158.field790 = Client.menuOptions[var0];
   }

   @ObfuscatedName("ck")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "358010673"
   )
   static void method71() {
      if(Client.field432) {
         Widget var0 = ItemLayer.method1468(class39.field800, Client.field433);
         if(var0 != null && var0.field2141 != null) {
            class18 var1 = new class18();
            var1.field190 = var0;
            var1.field198 = var0.field2141;
            class9.method118(var1);
         }

         Client.field432 = false;
         class2.method28(var0);
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1971199779"
   )
   void method72(int var1) {
      this.progress &= -8;
      this.progress = (byte)(this.progress | var1 & 7);
   }
}
