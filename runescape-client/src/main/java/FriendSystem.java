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
   @Export("__g")
   int __g;

   @ObfuscatedSignature(
      signature = "(Llx;)V"
   )
   FriendSystem(LoginType var1) {
      this.__g = 0;
      this.loginType = var1;
      this.friendsList = new FriendsList(var1);
      this.ignoreList = new IgnoreList(var1);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-114"
   )
   @Export("__m_151")
   boolean __m_151() {
      return this.__g == 2;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2125539725"
   )
   @Export("__f_152")
   final void __f_152() {
      this.__g = 1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgr;II)V",
      garbageValue = "-1440726810"
   )
   @Export("__q_153")
   final void __q_153(Buffer var1, int var2) {
      this.friendsList.read(var1, var2);
      this.__g = 2;
      GrandExchangeOffer.method121();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1408945788"
   )
   @Export("__w_154")
   final void __w_154() {
      for(FriendLoginUpdate var1 = (FriendLoginUpdate)this.friendsList.friendLoginUpdates.__f_438(); var1 != null; var1 = (FriendLoginUpdate)this.friendsList.friendLoginUpdates.__q_439()) {
         if((long)var1.time < class203.currentTimeMs() / 1000L - 5L) {
            if(var1.world > 0) {
               WorldMapIcon1.method219(5, "", var1.username + " has logged in.");
            }

            if(var1.world == 0) {
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
      this.__g = 0;
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
      return var1 != null && (var1.__equals_466(Canvas.localPlayer.username) || this.friendsList.isFriended(var1, var2));
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
   @Export("__l_157")
   final void __l_157(String var1) {
      if(var1 != null) {
         Username var2 = new Username(var1, this.loginType);
         if(var2.hasCleanName()) {
            StringBuilder var10000;
            String var4;
            if(this.__e_158()) {
               var10000 = null;
               var4 = "Your friend list is full. Max of 200 for free users, and 400 for members";
               WorldMapIcon1.method219(30, "", var4);
            } else if(Canvas.localPlayer.username.__equals_466(var2)) {
               var10000 = null;
               var4 = "You can\'t add yourself to your own friend list";
               WorldMapIcon1.method219(30, "", var4);
            } else {
               Object var10001;
               if(this.isFriended(var2, false)) {
                  var10000 = (new StringBuilder()).append(var1);
                  var10001 = null;
                  var4 = var10000.append(" is already on your friend list").toString();
                  WorldMapIcon1.method219(30, "", var4);
               } else if(this.isIgnored(var2)) {
                  var10000 = new StringBuilder();
                  var10001 = null;
                  var10000 = var10000.append("Please remove ").append(var1);
                  var10001 = null;
                  var4 = var10000.append(" from your ignore list first").toString();
                  WorldMapIcon1.method219(30, "", var4);
               } else {
                  PacketBufferNode var3 = Interpreter.method1915(ClientPacket.__gs_cn, Client.packetWriter.isaacCipher);
                  var3.packetBuffer.writeByte(WorldMapRegion.method550(var1));
                  var3.packetBuffer.writeStringCp1252NullTerminated(var1);
                  Client.packetWriter.__q_167(var3);
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
   @Export("__e_158")
   final boolean __e_158() {
      return this.friendsList.isFull() || this.friendsList.size() >= 200 && Client.__client_jo != 1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "30"
   )
   @Export("__x_159")
   final void __x_159(String var1) {
      if(var1 != null) {
         Username var2 = new Username(var1, this.loginType);
         if(var2.hasCleanName()) {
            StringBuilder var10000;
            String var4;
            if(this.__a_160()) {
               var10000 = null;
               var4 = "Your ignore list is full. Max of 100 for free users, and 400 for members";
               WorldMapIcon1.method219(30, "", var4);
            } else if(Canvas.localPlayer.username.__equals_466(var2)) {
               var10000 = null;
               var4 = "You can\'t add yourself to your own ignore list";
               WorldMapIcon1.method219(30, "", var4);
            } else if(this.isIgnored(var2)) {
               class22.method294(var1);
            } else if(this.isFriended(var2, false)) {
               var10000 = new StringBuilder();
               Object var10001 = null;
               var10000 = var10000.append("Please remove ").append(var1);
               var10001 = null;
               var4 = var10000.append(" from your friend list first").toString();
               WorldMapIcon1.method219(30, "", var4);
            } else {
               PacketBufferNode var3 = Interpreter.method1915(ClientPacket.__gs_ch, Client.packetWriter.isaacCipher);
               var3.packetBuffer.writeByte(WorldMapRegion.method550(var1));
               var3.packetBuffer.writeStringCp1252NullTerminated(var1);
               Client.packetWriter.__q_167(var3);
            }
         }
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "120"
   )
   @Export("__a_160")
   final boolean __a_160() {
      return this.ignoreList.isFull() || this.ignoreList.size() >= 100 && Client.__client_jo != 1;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-2122207917"
   )
   @Export("removeFriend")
   final void removeFriend(String var1) {
      if(var1 != null) {
         Username var2 = new Username(var1, this.loginType);
         if(var2.hasCleanName()) {
            if(this.friendsList.removeByUsername(var2)) {
               WorldMapManager.method668();
               PacketBufferNode var3 = Interpreter.method1915(ClientPacket.__gs_bs, Client.packetWriter.isaacCipher);
               var3.packetBuffer.writeByte(WorldMapRegion.method550(var1));
               var3.packetBuffer.writeStringCp1252NullTerminated(var1);
               Client.packetWriter.__q_167(var3);
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
      if(var1 != null) {
         Username var2 = new Username(var1, this.loginType);
         if(var2.hasCleanName()) {
            if(this.ignoreList.removeByUsername(var2)) {
               WorldMapManager.method668();
               PacketBufferNode var3 = Interpreter.method1915(ClientPacket.__gs_aj, Client.packetWriter.isaacCipher);
               var3.packetBuffer.writeByte(WorldMapRegion.method550(var1));
               var3.packetBuffer.writeStringCp1252NullTerminated(var1);
               Client.packetWriter.__q_167(var3);
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
   @Export("__t_161")
   final boolean __t_161(Username var1) {
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
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = Huffman.getWidget(Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize]);
      } else {
         var3 = var2?WorldMapIcon1.__t_i:class12.__n_n;
      }

      if(var0 == 1927) {
         if(Interpreter.__bv_y >= 10) {
            throw new RuntimeException();
         } else if(var3.__ee == null) {
            return 0;
         } else {
            ScriptEvent var4 = new ScriptEvent();
            var4.widget = var3;
            var4.args0 = var3.__ee;
            var4.__d = Interpreter.__bv_y + 1;
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
