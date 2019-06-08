import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("x")
@Implements("GrandExchangeOffer")
public class GrandExchangeOffer {
   @ObfuscatedName("rg")
   @ObfuscatedGetter(
      intValue = -1286287981
   )
   @Export("__x_rg")
   static int __x_rg;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -812708185
   )
   @Export("musicTrackFileId")
   public static int musicTrackFileId;
   @ObfuscatedName("m")
   @Export("state")
   byte state;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1136727241
   )
   @Export("id")
   public int id;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1627453165
   )
   @Export("unitPrice")
   public int unitPrice;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 562564821
   )
   @Export("totalQuantity")
   public int totalQuantity;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1413132419
   )
   @Export("currentQuantity")
   public int currentQuantity;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 396420073
   )
   @Export("currentPrice")
   public int currentPrice;

   public GrandExchangeOffer() {
   }

   @ObfuscatedSignature(
      signature = "(Lgr;Z)V",
      garbageValue = "0"
   )
   public GrandExchangeOffer(Buffer var1, boolean var2) {
      this.state = var1.readByte();
      this.id = var1.__ag_302();
      this.unitPrice = var1.readInt();
      this.totalQuantity = var1.readInt();
      this.currentQuantity = var1.readInt();
      this.currentPrice = var1.readInt();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1084140748"
   )
   @Export("status")
   public int status() {
      return this.state & 7;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1007396683"
   )
   @Export("type")
   public int type() {
      return (this.state & 8) == 8?1:0;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1339285061"
   )
   @Export("__o_9")
   void __o_9(int var1) {
      this.state &= -8;
      this.state = (byte)(this.state | var1 & 7);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "743094900"
   )
   @Export("__u_10")
   void __u_10(int var1) {
      this.state &= -9;
      if(var1 == 1) {
         this.state = (byte)(this.state | 8);
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lhx;I)I",
      garbageValue = "-756558077"
   )
   static int method105(PacketBuffer var0) {
      int var1 = var0.readBits(2);
      int var2;
      if(var1 == 0) {
         var2 = 0;
      } else if(var1 == 1) {
         var2 = var0.readBits(5);
      } else if(var1 == 2) {
         var2 = var0.readBits(8);
      } else {
         var2 = var0.readBits(11);
      }

      return var2;
   }

   @ObfuscatedName("ez")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "50"
   )
   static int method101() {
      if(Client.indexCacheLoaders != null && Client.indexCacheLoaderIndex < Client.indexCacheLoaders.size()) {
         int var0 = 0;

         for(int var1 = 0; var1 <= Client.indexCacheLoaderIndex; ++var1) {
            var0 += ((IndexCacheLoader)Client.indexCacheLoaders.get(var1)).__w;
         }

         return var0 * 10000 / Client.__client_sx;
      } else {
         return 10000;
      }
   }

   @ObfuscatedName("kf")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-304562381"
   )
   static final void method121() {
      for(int var0 = 0; var0 < Players.Players_count; ++var0) {
         Player var1 = Client.players[Players.Players_indices[var0]];
         var1.clearIsFriend();
      }

      Iterator var2 = Messages.Messages_hashTable.iterator();

      while(var2.hasNext()) {
         Message var3 = (Message)var2.next();
         var3.clearIsFromFriend();
      }

      if(PacketWriter.clanChat != null) {
         PacketWriter.clanChat.clearFriends();
      }

   }
}
