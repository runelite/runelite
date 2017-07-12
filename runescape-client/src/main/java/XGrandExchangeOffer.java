import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("b")
@Implements("XGrandExchangeOffer")
public class XGrandExchangeOffer {
   @ObfuscatedName("eq")
   static class262 field313;
   @ObfuscatedName("ct")
   @Export("indexTrack2")
   static IndexData indexTrack2;
   @ObfuscatedName("i")
   @Export("progress")
   byte progress;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -708171489
   )
   @Export("totalQuantity")
   public int totalQuantity;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -53549477
   )
   @Export("price")
   public int price;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1110847931
   )
   @Export("itemId")
   public int itemId;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -261525069
   )
   @Export("quantitySold")
   public int quantitySold;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1083057083
   )
   @Export("spent")
   public int spent;

   public XGrandExchangeOffer() {
   }

   @ObfuscatedSignature(
      signature = "(LBuffer;Z)V",
      garbageValue = "0"
   )
   public XGrandExchangeOffer(Buffer var1, boolean var2) {
      this.progress = var1.readByte();
      this.itemId = var1.readUnsignedShort();
      this.price = var1.readInt();
      this.totalQuantity = var1.readInt();
      this.quantitySold = var1.readInt();
      this.spent = var1.readInt();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-1"
   )
   void method89(int var1) {
      this.progress &= -8;
      this.progress = (byte)(this.progress | var1 & 7);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-62"
   )
   void method92(int var1) {
      this.progress &= -9;
      if(var1 == 1) {
         this.progress = (byte)(this.progress | 8);
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-28"
   )
   public int method91() {
      return (this.progress & 8) == 8?1:0;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1834311547"
   )
   public int method87() {
      return this.progress & 7;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1588417071"
   )
   public static void method113() {
      class286.field3799 = null;
      class286.offsetsY = null;
      class7.field239 = null;
      class226.field3146 = null;
      class278.field3745 = null;
      class210.spritePixels = null;
   }

   @ObfuscatedName("ja")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1800077005"
   )
   static final void method111(String var0) {
      if(class11.clanMembers != null) {
         Client.secretPacketBuffer1.putOpcode(34);
         Client.secretPacketBuffer1.putByte(class261.getLength(var0));
         Client.secretPacketBuffer1.putString(var0);
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIIZIZS)V",
      garbageValue = "-11612"
   )
   static void method112(int var0, int var1, int var2, boolean var3, int var4, boolean var5) {
      if(var0 < var1) {
         int var6 = (var0 + var1) / 2;
         int var7 = var0;
         World var8 = World.worldList[var6];
         World.worldList[var6] = World.worldList[var1];
         World.worldList[var1] = var8;

         for(int var9 = var0; var9 < var1; ++var9) {
            if(Spotanim.method4356(World.worldList[var9], var8, var2, var3, var4, var5) <= 0) {
               World var10 = World.worldList[var9];
               World.worldList[var9] = World.worldList[var7];
               World.worldList[var7++] = var10;
            }
         }

         World.worldList[var1] = World.worldList[var7];
         World.worldList[var7] = var8;
         method112(var0, var7 - 1, var2, var3, var4, var5);
         method112(var7 + 1, var1, var2, var3, var4, var5);
      }

   }
}
