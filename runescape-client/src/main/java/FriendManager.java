import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cf")
@Implements("FriendManager")
public class FriendManager {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Llh;"
   )
   final JagexLoginType field1252;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lkq;"
   )
   public final class304 field1256;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lkx;"
   )
   public final class298 field1254;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1754571737
   )
   int field1253;

   @ObfuscatedSignature(
      signature = "(Llh;)V"
   )
   FriendManager(JagexLoginType var1) {
      this.field1253 = 0;
      this.field1252 = var1;
      this.field1256 = new class304(var1);
      this.field1254 = new class298(var1);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "76"
   )
   boolean method1732() {
      return this.field1253 == 2;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "103"
   )
   final void method1733() {
      this.field1253 = 1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lgc;IB)V",
      garbageValue = "63"
   )
   final void method1734(Buffer var1, int var2) {
      this.field1256.method5411(var1, var2);
      this.field1253 = 2;

      for(int var3 = 0; var3 < class93.playerIndexesCount; ++var3) {
         Player var4 = Client.cachedPlayers[class93.playerIndices[var3]];
         var4.method1188();
      }

      Iterator var5 = class95.messages.iterator();

      while(var5.hasNext()) {
         MessageNode var6 = (MessageNode)var5.next();
         var6.method1148();
      }

      if(GameEngine.clanMemberManager != null) {
         GameEngine.clanMemberManager.method5460();
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-144546608"
   )
   final void method1735() {
      for(class308 var1 = (class308)this.field1256.field3856.method4061(); var1 != null; var1 = (class308)this.field1256.field3856.method4060()) {
         if((long)var1.field3876 < class64.method1118() / 1000L - 5L) {
            if(var1.field3875 > 0) {
               class57.sendGameMessage(5, "", var1.field3877 + " has logged in.");
            }

            if(var1.field3875 == 0) {
               class57.sendGameMessage(5, "", var1.field3877 + " has logged out.");
            }

            var1.method4067();
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "14326"
   )
   final void method1756() {
      this.field1253 = 0;
      this.field1256.method5302();
      this.field1254.method5302();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lkz;ZB)Z",
      garbageValue = "20"
   )
   @Export("isFriended")
   final boolean isFriended(Name var1, boolean var2) {
      return var1 == null?false: (var1.equals(SoundTaskDataProvider.localPlayer.name)?true: this.field1256.method5414(var1, var2));
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lkz;B)Z",
      garbageValue = "-42"
   )
   @Export("isIgnored")
   final boolean isIgnored(Name var1) {
      return var1 == null?false: this.field1254.isMember(var1);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "-55"
   )
   @Export("addToFriendsList")
   final void addToFriendsList(String var1) {
      if(var1 != null) {
         Name var2 = new Name(var1, this.field1252);
         if(var2.isCleanNameValid()) {
            StringBuilder var10000;
            String var3;
            if(this.isFriendsListFull()) {
               var10000 = null;
               var3 = "Your friend list is full. Max of 200 for free users, and 400 for members";
               class57.sendGameMessage(30, "", var3);
            } else if(SoundTaskDataProvider.localPlayer.name.equals(var2)) {
               var10000 = null;
               var3 = "You can\'t add yourself to your own friend list";
               class57.sendGameMessage(30, "", var3);
            } else {
               Object var10001;
               if(this.isFriended(var2, false)) {
                  var10000 = (new StringBuilder()).append(var1);
                  var10001 = null;
                  var3 = var10000.append(" is already on your friend list").toString();
                  class57.sendGameMessage(30, "", var3);
               } else if(this.isIgnored(var2)) {
                  var10000 = new StringBuilder();
                  var10001 = null;
                  var10000 = var10000.append("Please remove ").append(var1);
                  var10001 = null;
                  var3 = var10000.append(" from your ignore list first").toString();
                  class57.sendGameMessage(30, "", var3);
               } else {
                  class45.method672(var1);
               }
            }
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1921717557"
   )
   @Export("isFriendsListFull")
   final boolean isFriendsListFull() {
      return this.field1256.method5305() || this.field1256.getCount() >= 200 && Client.field987 != 1;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "-16"
   )
   @Export("addToIgnoreList")
   final void addToIgnoreList(String var1) {
      if(var1 != null) {
         Name var2 = new Name(var1, this.field1252);
         if(var2.isCleanNameValid()) {
            if(this.method1741()) {
               Size.method199();
            } else {
               StringBuilder var10000;
               String var3;
               if(SoundTaskDataProvider.localPlayer.name.equals(var2)) {
                  var10000 = null;
                  var3 = "You can\'t add yourself to your own ignore list";
                  class57.sendGameMessage(30, "", var3);
               } else if(this.isIgnored(var2)) {
                  class231.method4265(var1);
               } else if(this.isFriended(var2, false)) {
                  var10000 = new StringBuilder();
                  Object var10001 = null;
                  var10000 = var10000.append("Please remove ").append(var1);
                  var10001 = null;
                  var3 = var10000.append(" from your friend list first").toString();
                  class57.sendGameMessage(30, "", var3);
               } else {
                  class249.method4501(var1);
               }
            }
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "65"
   )
   final boolean method1741() {
      return this.field1254.method5305() || this.field1254.getCount() >= 100 && Client.field987 != 1;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1044707329"
   )
   final void method1742(String var1) {
      if(var1 != null) {
         Name var2 = new Name(var1, this.field1252);
         if(var2.isCleanNameValid()) {
            if(this.field1256.method5344(var2)) {
               OwnWorldComparator.method1248();
               PacketNode var3 = WorldMapRectangle.method280(ClientPacket.field2475, Client.field957.field1484);
               var3.packetBuffer.putByte(WorldMapRegion.getLength(var1));
               var3.packetBuffer.putString(var1);
               Client.field957.method2052(var3);
            }

            for(int var5 = 0; var5 < class93.playerIndexesCount; ++var5) {
               Player var4 = Client.cachedPlayers[class93.playerIndices[var5]];
               var4.method1188();
            }

            Iterator var6 = class95.messages.iterator();

            while(var6.hasNext()) {
               MessageNode var7 = (MessageNode)var6.next();
               var7.method1148();
            }

            if(GameEngine.clanMemberManager != null) {
               GameEngine.clanMemberManager.method5460();
            }

         }
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-659389112"
   )
   final void method1743(String var1) {
      if(var1 != null) {
         Name var2 = new Name(var1, this.field1252);
         if(var2.isCleanNameValid()) {
            if(this.field1254.method5344(var2)) {
               OwnWorldComparator.method1248();
               PacketNode var3 = WorldMapRectangle.method280(ClientPacket.field2470, Client.field957.field1484);
               var3.packetBuffer.putByte(WorldMapRegion.getLength(var1));
               var3.packetBuffer.putString(var1);
               Client.field957.method2052(var3);
            }

            class197.method3746();
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lkz;B)Z",
      garbageValue = "-76"
   )
   final boolean method1776(Name var1) {
      Friend var2 = (Friend)this.field1256.method5307(var1);
      return var2 != null && var2.method5391();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lgs;B)I",
      garbageValue = "-73"
   )
   static int method1789(PacketBuffer var0) {
      int var1 = var0.getBits(2);
      int var2;
      if(var1 == 0) {
         var2 = 0;
      } else if(var1 == 1) {
         var2 = var0.getBits(5);
      } else if(var1 == 2) {
         var2 = var0.getBits(8);
      } else {
         var2 = var0.getBits(11);
      }

      return var2;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "445566401"
   )
   public static int method1792(int var0) {
      return var0 >> 17 & 7;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljf;Ljava/lang/String;Ljava/lang/String;I)Lll;",
      garbageValue = "391049745"
   )
   @Export("getSprite")
   public static IndexedSprite getSprite(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      IndexedSprite var5;
      if(!RunException.method3215(var0, var3, var4)) {
         var5 = null;
      } else {
         var5 = class155.method3159();
      }

      return var5;
   }
}
