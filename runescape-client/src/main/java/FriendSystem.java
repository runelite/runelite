import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bh")
@Implements("FriendSystem")
public class FriendSystem {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Llx;"
   )
   @Export("loginType")
   final LoginType loginType;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lkg;"
   )
   @Export("friendsList")
   public final FriendsList friendsList;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lkj;"
   )
   @Export("ignoreList")
   public final IgnoreList ignoreList;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1477282369
   )
   int field357;

   @ObfuscatedSignature(
      signature = "(Llx;)V"
   )
   FriendSystem(LoginType var1) {
      this.field357 = 0;
      this.loginType = var1;
      this.friendsList = new FriendsList(var1);
      this.ignoreList = new IgnoreList(var1);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-114"
   )
   boolean method99() {
      return this.field357 == 2;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2125539725"
   )
   final void method100() {
      this.field357 = 1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgr;II)V",
      garbageValue = "-1440726810"
   )
   final void method101(Buffer var1, int var2) {
      this.friendsList.read(var1, var2);
      this.field357 = 2;
      GrandExchangeOffer.method121();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1408945788"
   )
   final void method102() {
      for (FriendLoginUpdate var1 = (FriendLoginUpdate)this.friendsList.friendLoginUpdates.last(); var1 != null; var1 = (FriendLoginUpdate)this.friendsList.friendLoginUpdates.previous()) {
         if ((long)var1.time < class203.currentTimeMs() / 1000L - 5L) {
            if (var1.world > 0) {
               WorldMapIcon1.method219(5, "", var1.username + " has logged in.");
            }

            if (var1.world == 0) {
               WorldMapIcon1.method219(5, "", var1.username + " has logged out.");
            }

            var1.remove();
         }
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1170844364"
   )
   @Export("clear")
   final void clear() {
      this.field357 = 0;
      this.friendsList.clear();
      this.ignoreList.clear();
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lkp;ZI)Z",
      garbageValue = "2057092629"
   )
   @Export("isFriended")
   final boolean isFriended(Username var1, boolean var2) {
      return var1 != null && (var1.equals(Canvas.localPlayer.username) || this.friendsList.isFriended(var1, var2));
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lkp;I)Z",
      garbageValue = "1482725020"
   )
   @Export("isIgnored")
   final boolean isIgnored(Username var1) {
      return var1 != null && this.ignoreList.contains(var1);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1721017960"
   )
   final void method103(String var1) {
      if (var1 != null) {
         Username var2 = new Username(var1, this.loginType);
         if (var2.hasCleanName()) {
            StringBuilder var3;
            String var4;
            if (this.method104()) {
               var3 = null;
               var4 = "Your friend list is full. Max of 200 for free users, and 400 for members";
               WorldMapIcon1.method219(30, "", var4);
            } else if (Canvas.localPlayer.username.equals(var2)) {
               var3 = null;
               var4 = "You can't add yourself to your own friend list";
               WorldMapIcon1.method219(30, "", var4);
            } else {
               Object var5;
               if (this.isFriended(var2, false)) {
                  var3 = (new StringBuilder()).append(var1);
                  var5 = null;
                  var4 = var3.append(" is already on your friend list").toString();
                  WorldMapIcon1.method219(30, "", var4);
               } else if (this.isIgnored(var2)) {
                  var3 = new StringBuilder();
                  var5 = null;
                  var3 = var3.append("Please remove ").append(var1);
                  var5 = null;
                  var4 = var3.append(" from your ignore list first").toString();
                  WorldMapIcon1.method219(30, "", var4);
               } else {
                  PacketBufferNode var6 = Interpreter.method1915(ClientPacket.field310, Client.packetWriter.isaacCipher);
                  var6.packetBuffer.writeByte(WorldMapRegion.method550(var1));
                  var6.packetBuffer.writeStringCp1252NullTerminated(var1);
                  Client.packetWriter.method241(var6);
               }
            }
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "57"
   )
   final boolean method104() {
      return this.friendsList.isFull() || this.friendsList.size() >= 200 && Client.field209 != 1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "30"
   )
   final void method105(String var1) {
      if (var1 != null) {
         Username var2 = new Username(var1, this.loginType);
         if (var2.hasCleanName()) {
            StringBuilder var3;
            String var4;
            if (this.method106()) {
               var3 = null;
               var4 = "Your ignore list is full. Max of 100 for free users, and 400 for members";
               WorldMapIcon1.method219(30, "", var4);
            } else if (Canvas.localPlayer.username.equals(var2)) {
               var3 = null;
               var4 = "You can't add yourself to your own ignore list";
               WorldMapIcon1.method219(30, "", var4);
            } else if (this.isIgnored(var2)) {
               class22.method294(var1);
            } else {
               PacketBufferNode var5;
               if (this.isFriended(var2, false)) {
                  var3 = new StringBuilder();
                  var5 = null;
                  var3 = var3.append("Please remove ").append(var1);
                  var5 = null;
                  var4 = var3.append(" from your friend list first").toString();
                  WorldMapIcon1.method219(30, "", var4);
               } else {
                  var5 = Interpreter.method1915(ClientPacket.field312, Client.packetWriter.isaacCipher);
                  var5.packetBuffer.writeByte(WorldMapRegion.method550(var1));
                  var5.packetBuffer.writeStringCp1252NullTerminated(var1);
                  Client.packetWriter.method241(var5);
               }
            }
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "120"
   )
   final boolean method106() {
      return this.ignoreList.isFull() || this.ignoreList.size() >= 100 && Client.field209 != 1;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-2122207917"
   )
   @Export("removeFriend")
   final void removeFriend(String var1) {
      if (var1 != null) {
         Username var2 = new Username(var1, this.loginType);
         if (var2.hasCleanName()) {
            if (this.friendsList.removeByUsername(var2)) {
               WorldMapManager.method668();
               PacketBufferNode var3 = Interpreter.method1915(ClientPacket.field276, Client.packetWriter.isaacCipher);
               var3.packetBuffer.writeByte(WorldMapRegion.method550(var1));
               var3.packetBuffer.writeStringCp1252NullTerminated(var1);
               Client.packetWriter.method241(var3);
            }

            GrandExchangeOffer.method121();
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1673636127"
   )
   @Export("removeIgnore")
   final void removeIgnore(String var1) {
      if (var1 != null) {
         Username var2 = new Username(var1, this.loginType);
         if (var2.hasCleanName()) {
            if (this.ignoreList.removeByUsername(var2)) {
               WorldMapManager.method668();
               PacketBufferNode var3 = Interpreter.method1915(ClientPacket.field250, Client.packetWriter.isaacCipher);
               var3.packetBuffer.writeByte(WorldMapRegion.method550(var1));
               var3.packetBuffer.writeStringCp1252NullTerminated(var1);
               Client.packetWriter.method241(var3);
            }

            class229.method4512();
         }
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lkp;S)Z",
      garbageValue = "-543"
   )
   @Export("isFriendAndHasWorld")
   final boolean isFriendAndHasWorld(Username var1) {
      Friend var2 = (Friend)this.friendsList.getByUsername(var1);
      return var2 != null && var2.hasWorld();
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(ILcg;ZI)I",
      garbageValue = "866157286"
   )
   static int method1867(int var0, Script var1, boolean var2) {
      Widget var3;
      if (var0 >= 2000) {
         var0 -= 1000;
         var3 = Huffman.getWidget(Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize]);
      } else {
         var3 = var2 ? WorldMapIcon1.field1030 : class12.field1111;
      }

      if (var0 == 1927) {
         if (Interpreter.field425 >= 10) {
            throw new RuntimeException();
         } else if (var3.field975 == null) {
            return 0;
         } else {
            ScriptEvent var4 = new ScriptEvent();
            var4.widget = var3;
            var4.args0 = var3.field975;
            var4.field772 = Interpreter.field425 + 1;
            Client.scriptEvents.addFirst(var4);
            return 1;
         }
      } else {
         return 2;
      }
   }

   @ObfuscatedName("kb")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "0"
   )
   @Export("jmodCheck")
   public static boolean jmodCheck() {
      return Client.rights >= 2;
   }
}
