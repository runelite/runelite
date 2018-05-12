import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bm")
@Implements("FriendManager")
public class FriendManager {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lhl;"
   )
   static Widget field996;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lla;"
   )
   @Export("jagexLoginType")
   final JagexLoginType jagexLoginType;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lkn;"
   )
   @Export("friendContainer")
   public final FriendContainer friendContainer;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Ljz;"
   )
   @Export("ignoreContainer")
   public final class284 ignoreContainer;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 364671715
   )
   int field994;

   @ObfuscatedSignature(
      signature = "(Lla;)V"
   )
   FriendManager(JagexLoginType var1) {
      this.field994 = 0;
      this.jagexLoginType = var1;
      this.friendContainer = new FriendContainer(var1);
      this.ignoreContainer = new class284(var1);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "949143045"
   )
   boolean method1663() {
      return this.field994 == 2;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1887534903"
   )
   final void method1664() {
      this.field994 = 1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgy;II)V",
      garbageValue = "-164625233"
   )
   final void method1665(Buffer var1, int var2) {
      this.friendContainer.method5449(var1, var2);
      this.field994 = 2;

      for(int var3 = 0; var3 < class81.playerIndexesCount; ++var3) {
         Player var4 = Client.cachedPlayers[class81.playerIndices[var3]];
         var4.method1158();
      }

      Iterator var5 = class83.messages.iterator();

      while(var5.hasNext()) {
         MessageNode var6 = (MessageNode)var5.next();
         var6.method1095();
      }

      if(WorldComparator.clanMemberManager != null) {
         WorldComparator.clanMemberManager.method5518();
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1443163446"
   )
   final void method1698() {
      for(class294 var1 = (class294)this.friendContainer.field3658.method4147(); var1 != null; var1 = (class294)this.friendContainer.field3658.method4146()) {
         if((long)var1.field3676 < class166.method3456() / 1000L - 5L) {
            if(var1.field3677 > 0) {
               OwnWorldComparator.sendGameMessage(5, "", var1.field3675 + " has logged in.");
            }

            if(var1.field3677 == 0) {
               OwnWorldComparator.sendGameMessage(5, "", var1.field3675 + " has logged out.");
            }

            var1.method4156();
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1922799886"
   )
   final void method1667() {
      this.field994 = 0;
      this.friendContainer.method5340();
      this.ignoreContainer.method5340();
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lkm;ZI)Z",
      garbageValue = "-1852519047"
   )
   @Export("isFriended")
   final boolean isFriended(Name var1, boolean var2) {
      return var1 == null?false:(var1.equals(MilliTimer.localPlayer.name)?true:this.friendContainer.method5457(var1, var2));
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lkm;I)Z",
      garbageValue = "611113321"
   )
   @Export("isIgnored")
   final boolean isIgnored(Name var1) {
      return var1 == null?false:this.ignoreContainer.isMember(var1);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "0"
   )
   @Export("addToFriendsList")
   final void addToFriendsList(String var1) {
      if(var1 != null) {
         Name var2 = new Name(var1, this.jagexLoginType);
         if(var2.isCleanNameValid()) {
            if(this.isFriendsListFull()) {
               CollisionData.method3448("Your friend list is full. Max of 200 for free users, and 400 for members");
            } else if(MilliTimer.localPlayer.name.equals(var2)) {
               Huffman.method3498();
            } else if(this.isFriended(var2, false)) {
               Frames.method3094(var1);
            } else if(this.isIgnored(var2)) {
               class11.method112(var1);
            } else {
               class138.method3158(var1);
            }
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-773051644"
   )
   @Export("isFriendsListFull")
   final boolean isFriendsListFull() {
      return this.friendContainer.method5342() || this.friendContainer.getCount() >= 200 && Client.field710 != 1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "2"
   )
   @Export("addToIgnoreList")
   final void addToIgnoreList(String var1) {
      if(var1 != null) {
         Name var2 = new Name(var1, this.jagexLoginType);
         if(var2.isCleanNameValid()) {
            if(this.method1673()) {
               class37.method720();
            } else if(MilliTimer.localPlayer.name.equals(var2)) {
               CollisionData.method3448("You can\'t add yourself to your own ignore list");
            } else if(this.isIgnored(var2)) {
               class11.method115(var1);
            } else if(this.isFriended(var2, false)) {
               CollisionData.method3448("Please remove " + var1 + " from your friend list first");
            } else {
               class74.method1845(var1);
            }
         }
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "83"
   )
   final boolean method1673() {
      return this.ignoreContainer.method5342() || this.ignoreContainer.getCount() >= 100 && Client.field710 != 1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "-72"
   )
   @Export("removeFriend")
   final void removeFriend(String var1) {
      if(var1 != null) {
         Name var2 = new Name(var1, this.jagexLoginType);
         if(var2.isCleanNameValid()) {
            if(this.friendContainer.method5397(var2)) {
               Client.field742 = Client.cycleCntr;
               PacketNode var3 = DecorativeObject.method3115(ClientPacket.field2250, Client.field739.field1250);
               var3.packetBuffer.putByte(Size.getLength(var1));
               var3.packetBuffer.putString(var1);
               Client.field739.method2019(var3);
            }

            for(int var5 = 0; var5 < class81.playerIndexesCount; ++var5) {
               Player var4 = Client.cachedPlayers[class81.playerIndices[var5]];
               var4.method1158();
            }

            Iterator var6 = class83.messages.iterator();

            while(var6.hasNext()) {
               MessageNode var7 = (MessageNode)var6.next();
               var7.method1095();
            }

            if(WorldComparator.clanMemberManager != null) {
               WorldComparator.clanMemberManager.method5518();
            }

         }
      }
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1697776287"
   )
   final void method1675(String var1) {
      if(var1 != null) {
         Name var2 = new Name(var1, this.jagexLoginType);
         if(var2.isCleanNameValid()) {
            if(this.ignoreContainer.method5397(var2)) {
               Client.field742 = Client.cycleCntr;
               PacketNode var3 = DecorativeObject.method3115(ClientPacket.field2214, Client.field739.field1250);
               var3.packetBuffer.putByte(Size.getLength(var1));
               var3.packetBuffer.putString(var1);
               Client.field739.method2019(var3);
            }

            ClientPacket.method3460();
            if(WorldComparator.clanMemberManager != null) {
               WorldComparator.clanMemberManager.method5498();
            }

         }
      }
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(Lkm;B)Z",
      garbageValue = "22"
   )
   final boolean method1693(Name var1) {
      Friend var2 = (Friend)this.friendContainer.method5344(var1);
      return var2 != null && var2.method5438();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lbr;I)V",
      garbageValue = "-1754453186"
   )
   public static void method1728(ScriptEvent var0) {
      MouseRecorder.runScript(var0, 500000);
   }
}
