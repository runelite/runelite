import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("h")
@Implements("GrandExchangeOffer")
public class GrandExchangeOffer {
   @ObfuscatedName("cw")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   @Export("configsIndex")
   static IndexData configsIndex;
   @ObfuscatedName("m")
   @Export("progress")
   byte progress;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -684121785
   )
   @Export("itemId")
   public int itemId;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -778076757
   )
   @Export("price")
   public int price;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1782650877
   )
   @Export("totalQuantity")
   public int totalQuantity;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 667657107
   )
   @Export("quantitySold")
   public int quantitySold;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 3405275
   )
   @Export("spent")
   public int spent;

   public GrandExchangeOffer() {
   }

   @ObfuscatedSignature(
      signature = "(Lfv;Z)V",
      garbageValue = "0"
   )
   public GrandExchangeOffer(Buffer var1, boolean var2) {
      this.progress = var1.readByte();
      this.itemId = var1.readUnsignedShort();
      this.price = var1.readInt();
      this.totalQuantity = var1.readInt();
      this.quantitySold = var1.readInt();
      this.spent = var1.readInt();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1885548174"
   )
   public int method116() {
      return this.progress & 7;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-238543080"
   )
   public int method117() {
      return (this.progress & 8) == 8?1:0;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-771727694"
   )
   void method118(int var1) {
      this.progress &= -8;
      this.progress = (byte)(this.progress | var1 & 7);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1597875363"
   )
   void method119(int var1) {
      this.progress &= -9;
      if(var1 == 1) {
         this.progress = (byte)(this.progress | 8);
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(ILcw;ZI)I",
      garbageValue = "1349582776"
   )
   static int method123(int var0, Script var1, boolean var2) {
      Widget var3 = var2?class285.field3789:Friend.field768;
      if(var0 == 1700) {
         class82.intStack[++class56.intStackSize - 1] = var3.itemId;
         return 1;
      } else if(var0 == 1701) {
         if(var3.itemId != -1) {
            class82.intStack[++class56.intStackSize - 1] = var3.itemQuantity;
         } else {
            class82.intStack[++class56.intStackSize - 1] = 0;
         }

         return 1;
      } else if(var0 == 1702) {
         class82.intStack[++class56.intStackSize - 1] = var3.index;
         return 1;
      } else {
         return 2;
      }
   }
}
