import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("a")
@Implements("GrandExchangeOffer")
public class GrandExchangeOffer {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Ljz;"
   )
   public static Font field297;
   @ObfuscatedName("c")
   static int[] field296;
   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "Lkh;"
   )
   @Export("jagexLoginType")
   static JagexLoginType jagexLoginType;
   @ObfuscatedName("io")
   @ObfuscatedSignature(
      signature = "Lbf;"
   )
   @Export("localPlayer")
   static Player localPlayer;
   @ObfuscatedName("n")
   @Export("progress")
   byte progress;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 814876475
   )
   @Export("itemId")
   public int itemId;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1581347403
   )
   @Export("price")
   public int price;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -2044645577
   )
   @Export("totalQuantity")
   public int totalQuantity;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1724518865
   )
   @Export("quantitySold")
   public int quantitySold;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 825894885
   )
   @Export("spent")
   public int spent;

   public GrandExchangeOffer() {
   }

   @ObfuscatedSignature(
      signature = "(Lgv;Z)V",
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

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-1"
   )
   @Export("status")
   public int status() {
      return this.progress & 7;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1813185538"
   )
   @Export("type")
   public int type() {
      return (this.progress & 8) == 8?1:0;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1219711832"
   )
   void method101(int var1) {
      this.progress &= -8;
      this.progress = (byte)(this.progress | var1 & 7);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2051474544"
   )
   void method104(int var1) {
      this.progress &= -9;
      if(var1 == 1) {
         this.progress = (byte)(this.progress | 8);
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lgb;III)I",
      garbageValue = "714913308"
   )
   static int method113(IterableHashTable var0, int var1, int var2) {
      if(var0 == null) {
         return var2;
      } else {
         IntegerNode var3 = (IntegerNode)var0.get((long)var1);
         return var3 == null?var2:var3.value;
      }
   }
}
