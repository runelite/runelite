import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cj")
@Implements("FriendManager")
public class FriendManager {
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lly;"
   )
   final JagexLoginType field1239;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lky;"
   )
   public final FriendContainer field1237;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lkm;"
   )
   public final IgnoreContainer field1238;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -554047583
   )
   int field1234;

   @ObfuscatedSignature(
      signature = "(Lly;)V"
   )
   FriendManager(JagexLoginType var1) {
      this.field1234 = 0;
      this.field1239 = var1;
      this.field1237 = new FriendContainer(var1);
      this.field1238 = new IgnoreContainer(var1);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "7279"
   )
   boolean method1841() {
      return this.field1234 == 2;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-463995463"
   )
   final void method1827() {
      this.field1234 = 1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lgg;IB)V",
      garbageValue = "46"
   )
   final void method1784(Buffer var1, int var2) {
      this.field1237.method5473(var1, var2);
      this.field1234 = 2;

      for(int var3 = 0; var3 < class93.playerIndexesCount; ++var3) {
         Player var4 = Client.cachedPlayers[class93.playerIndices[var3]];
         var4.method1229();
      }

      Iterator var5 = class95.messages.iterator();

      while(var5.hasNext()) {
         MessageNode var6 = (MessageNode)var5.next();
         var6.method1173();
      }

      if(LoginPacket.clanMemberManager != null) {
         LoginPacket.clanMemberManager.method5516();
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "991129964"
   )
   final void method1785() {
      for(class308 var1 = (class308)this.field1237.field3864.method4154(); var1 != null; var1 = (class308)this.field1237.field3864.method4152()) {
         if((long)var1.field3877 < class289.method5267() / 1000L - 5L) {
            if(var1.field3879 > 0) {
               ChatPlayer.sendGameMessage(5, "", var1.field3878 + " has logged in.");
            }

            if(var1.field3879 == 0) {
               ChatPlayer.sendGameMessage(5, "", var1.field3878 + " has logged out.");
            }

            var1.method4165();
         }
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "8"
   )
   final void method1802() {
      this.field1234 = 0;
      this.field1237.method5363();
      this.field1238.method5363();
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lkb;ZI)Z",
      garbageValue = "-818063600"
   )
   @Export("isFriended")
   final boolean isFriended(Name var1, boolean var2) {
      return var1 == null?false:(var1.equals(class265.localPlayer.name)?true:this.field1237.method5472(var1, var2));
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lkb;I)Z",
      garbageValue = "-1402225156"
   )
   @Export("isIgnored")
   final boolean isIgnored(Name var1) {
      return var1 == null?false:this.field1238.isMember(var1);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "528971158"
   )
   @Export("addToFriendsList")
   final void addToFriendsList(String var1) {
      if(var1 != null) {
         Name var2 = new Name(var1, this.field1239);
         if(var2.isCleanNameValid()) {
            StringBuilder var10000;
            String var3;
            if(this.isFriendsListFull()) {
               var10000 = null;
               var3 = "Your friend list is full. Max of 200 for free users, and 400 for members";
               ChatPlayer.sendGameMessage(30, "", var3);
            } else if(class265.localPlayer.name.equals(var2)) {
               var10000 = null;
               var3 = "You can\'t add yourself to your own friend list";
               ChatPlayer.sendGameMessage(30, "", var3);
            } else if(this.isFriended(var2, false)) {
               var10000 = (new StringBuilder()).append(var1);
               Object var10001 = null;
               var3 = var10000.append(" is already on your friend list").toString();
               ChatPlayer.sendGameMessage(30, "", var3);
            } else if(this.isIgnored(var2)) {
               class197.method3821(var1);
            } else {
               GameEngine.method1050(var1);
            }
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-31"
   )
   @Export("isFriendsListFull")
   final boolean isFriendsListFull() {
      return this.field1237.method5365() || this.field1237.getCount() >= 200 && Client.field969 != 1;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-436797864"
   )
   @Export("addToIgnoreList")
   final void addToIgnoreList(String var1) {
      if(var1 != null) {
         Name var2 = new Name(var1, this.field1239);
         if(var2.isCleanNameValid()) {
            StringBuilder var10000;
            String var4;
            if(this.method1791()) {
               var10000 = null;
               var4 = "Your ignore list is full. Max of 100 for free users, and 400 for members";
               ChatPlayer.sendGameMessage(30, "", var4);
            } else if(class265.localPlayer.name.equals(var2)) {
               var10000 = null;
               var4 = "You can\'t add yourself to your own ignore list";
               ChatPlayer.sendGameMessage(30, "", var4);
            } else if(this.isIgnored(var2)) {
               var10000 = (new StringBuilder()).append(var1);
               Object var10001 = null;
               var4 = var10000.append(" is already on your ignore list").toString();
               ChatPlayer.sendGameMessage(30, "", var4);
            } else if(this.isFriended(var2, false)) {
               class278.method5004(var1);
            } else {
               PacketNode var3 = AbstractSoundSystem.method2350(ClientPacket.field2374, Client.field911.field1460);
               var3.packetBuffer.putByte(class95.getLength(var1));
               var3.packetBuffer.putString(var1);
               Client.field911.method2135(var3);
            }
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "103"
   )
   final boolean method1791() {
      return this.field1238.method5365() || this.field1238.getCount() >= 100 && Client.field969 != 1;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-123437788"
   )
   final void method1792(String var1) {
      if(var1 != null) {
         Name var2 = new Name(var1, this.field1239);
         if(var2.isCleanNameValid()) {
            if(this.field1237.method5369(var2)) {
               Client.field1045 = Client.cycleCntr;
               PacketNode var3 = AbstractSoundSystem.method2350(ClientPacket.field2371, Client.field911.field1460);
               var3.packetBuffer.putByte(class95.getLength(var1));
               var3.packetBuffer.putString(var1);
               Client.field911.method2135(var3);
            }

            for(int var5 = 0; var5 < class93.playerIndexesCount; ++var5) {
               Player var4 = Client.cachedPlayers[class93.playerIndices[var5]];
               var4.method1229();
            }

            Iterator var6 = class95.messages.iterator();

            while(var6.hasNext()) {
               MessageNode var7 = (MessageNode)var6.next();
               var7.method1173();
            }

            if(LoginPacket.clanMemberManager != null) {
               LoginPacket.clanMemberManager.method5516();
            }

         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1327270684"
   )
   final void method1806(String var1) {
      if(var1 != null) {
         Name var2 = new Name(var1, this.field1239);
         if(var2.isCleanNameValid()) {
            if(this.field1238.method5369(var2)) {
               Client.field1045 = Client.cycleCntr;
               PacketNode var3 = AbstractSoundSystem.method2350(ClientPacket.field2365, Client.field911.field1460);
               var3.packetBuffer.putByte(class95.getLength(var1));
               var3.packetBuffer.putString(var1);
               Client.field911.method2135(var3);
            }

            KeyFocusListener.method823();
            if(LoginPacket.clanMemberManager != null) {
               LoginPacket.clanMemberManager.method5519();
            }

         }
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lkb;B)Z",
      garbageValue = "55"
   )
   final boolean method1794(Name var1) {
      Friend var2 = (Friend)this.field1237.method5367(var1);
      return var2 != null && var2.method5458();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "0"
   )
   static final void method1842(int var0, int var1, int var2) {
      int var3;
      for(var3 = 0; var3 < 8; ++var3) {
         for(int var4 = 0; var4 < 8; ++var4) {
            class62.tileHeights[var0][var3 + var1][var4 + var2] = 0;
         }
      }

      if(var1 > 0) {
         for(var3 = 1; var3 < 8; ++var3) {
            class62.tileHeights[var0][var1][var3 + var2] = class62.tileHeights[var0][var1 - 1][var3 + var2];
         }
      }

      if(var2 > 0) {
         for(var3 = 1; var3 < 8; ++var3) {
            class62.tileHeights[var0][var3 + var1][var2] = class62.tileHeights[var0][var3 + var1][var2 - 1];
         }
      }

      if(var1 > 0 && class62.tileHeights[var0][var1 - 1][var2] != 0) {
         class62.tileHeights[var0][var1][var2] = class62.tileHeights[var0][var1 - 1][var2];
      } else if(var2 > 0 && class62.tileHeights[var0][var1][var2 - 1] != 0) {
         class62.tileHeights[var0][var1][var2] = class62.tileHeights[var0][var1][var2 - 1];
      } else if(var1 > 0 && var2 > 0 && class62.tileHeights[var0][var1 - 1][var2 - 1] != 0) {
         class62.tileHeights[var0][var1][var2] = class62.tileHeights[var0][var1 - 1][var2 - 1];
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(ILcr;ZI)I",
      garbageValue = "-97919538"
   )
   static int method1843(int var0, Script var1, boolean var2) {
      int var3;
      int var4;
      if(var0 == 3200) {
         class171.intStackSize -= 3;
         var3 = class81.intStack[class171.intStackSize];
         var4 = class81.intStack[class171.intStackSize + 1];
         int var5 = class81.intStack[class171.intStackSize + 2];
         if(Client.field1086 != 0 && var4 != 0 && Client.queuedSoundEffectCount < 50) {
            Client.queuedSoundEffectIDs[Client.queuedSoundEffectCount] = var3;
            Client.unknownSoundValues1[Client.queuedSoundEffectCount] = var4;
            Client.unknownSoundValues2[Client.queuedSoundEffectCount] = var5;
            Client.audioEffects[Client.queuedSoundEffectCount] = null;
            Client.soundLocations[Client.queuedSoundEffectCount] = 0;
            ++Client.queuedSoundEffectCount;
         }

         return 1;
      } else if(var0 == 3201) {
         MapIconReference.method759(class81.intStack[--class171.intStackSize]);
         return 1;
      } else if(var0 == 3202) {
         class171.intStackSize -= 2;
         var3 = class81.intStack[class171.intStackSize];
         var4 = class81.intStack[class171.intStackSize + 1];
         if(Client.field1083 != 0 && var3 != -1) {
            MilliTimer.method3279(class190.indexTrack2, var3, 0, Client.field1083, false);
            Client.field1085 = true;
         }

         return 1;
      } else {
         return 2;
      }
   }
}
