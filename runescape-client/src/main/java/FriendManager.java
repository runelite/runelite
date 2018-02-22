import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cq")
@Implements("FriendManager")
public class FriendManager {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -626567149
   )
   public static int field1197;
   @ObfuscatedName("fs")
   @Export("xteaKeys")
   static int[][] xteaKeys;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lld;"
   )
   final JagexLoginType field1192;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lkr;"
   )
   public final class290 field1194;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Ljq;"
   )
   public final class284 field1193;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -867936183
   )
   int field1195;

   @ObfuscatedSignature(
      signature = "(Lld;)V"
   )
   FriendManager(JagexLoginType var1) {
      this.field1195 = 0;
      this.field1192 = var1;
      this.field1194 = new class290(var1);
      this.field1193 = new class284(var1);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "103"
   )
   boolean method1695() {
      return this.field1195 == 2;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1319505522"
   )
   final void method1696() {
      this.field1195 = 1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lgn;IB)V",
      garbageValue = "1"
   )
   final void method1702(Buffer var1, int var2) {
      this.field1194.method5347(var1, var2);
      this.field1195 = 2;
      ItemLayer.method2600();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "915528523"
   )
   final void method1699() {
      for(class294 var1 = (class294)this.field1194.field3732.method4083(); var1 != null; var1 = (class294)this.field1194.field3732.method4084()) {
         if((long)var1.field3748 < class188.currentTimeMs() / 1000L - 5L) {
            if(var1.field3749 > 0) {
               class149.sendGameMessage(5, "", var1.field3747 + " has logged in.");
            }

            if(var1.field3749 == 0) {
               class149.sendGameMessage(5, "", var1.field3747 + " has logged out.");
            }

            var1.method4092();
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-4663913"
   )
   final void method1710() {
      this.field1195 = 0;
      this.field1194.method5230();
      this.field1193.method5230();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lkp;ZI)Z",
      garbageValue = "-853321628"
   )
   @Export("isFriended")
   final boolean isFriended(Name var1, boolean var2) {
      return var1 == null?false:(var1.equals(OwnWorldComparator.localPlayer.name)?true:this.field1194.method5346(var1, var2));
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lkp;B)Z",
      garbageValue = "-1"
   )
   final boolean method1701(Name var1) {
      return var1 == null?false:this.field1193.isMember(var1);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1803105027"
   )
   final void method1730(String var1) {
      if(var1 != null) {
         Name var2 = new Name(var1, this.field1192);
         if(var2.method5359()) {
            if(this.method1703()) {
               DState.method3529();
            } else {
               StringBuilder var10000;
               String var4;
               if(OwnWorldComparator.localPlayer.name.equals(var2)) {
                  var10000 = null;
                  var4 = "You can\'t add yourself to your own friend list";
                  class149.sendGameMessage(30, "", var4);
               } else if(this.isFriended(var2, false)) {
                  World.method1682(var1);
               } else if(this.method1701(var2)) {
                  var10000 = new StringBuilder();
                  Object var10001 = null;
                  var10000 = var10000.append("Please remove ").append(var1);
                  var10001 = null;
                  var4 = var10000.append(" from your ignore list first").toString();
                  class149.sendGameMessage(30, "", var4);
               } else {
                  PacketNode var3 = class61.method1076(ClientPacket.field2351, Client.field863.field1434);
                  var3.packetBuffer.putByte(class43.getLength(var1));
                  var3.packetBuffer.putString(var1);
                  Client.field863.method2039(var3);
               }
            }
         }
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "1"
   )
   final boolean method1703() {
      return this.field1194.method5232() || this.field1194.getCount() >= 200 && Client.field1028 != 1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-502469347"
   )
   final void method1698(String var1) {
      if(var1 != null) {
         Name var2 = new Name(var1, this.field1192);
         if(var2.method5359()) {
            if(this.method1705()) {
               VertexNormal.method2801();
            } else {
               StringBuilder var10000;
               String var4;
               if(OwnWorldComparator.localPlayer.name.equals(var2)) {
                  var10000 = null;
                  var4 = "You can\'t add yourself to your own ignore list";
                  class149.sendGameMessage(30, "", var4);
               } else if(this.method1701(var2)) {
                  var10000 = (new StringBuilder()).append(var1);
                  Object var10001 = null;
                  var4 = var10000.append(" is already on your ignore list").toString();
                  class149.sendGameMessage(30, "", var4);
               } else if(this.isFriended(var2, false)) {
                  class243.method4504(var1);
               } else {
                  PacketNode var3 = class61.method1076(ClientPacket.field2374, Client.field863.field1434);
                  var3.packetBuffer.putByte(class43.getLength(var1));
                  var3.packetBuffer.putString(var1);
                  Client.field863.method2039(var3);
               }
            }
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1536366021"
   )
   final boolean method1705() {
      return this.field1193.method5232() || this.field1193.getCount() >= 100 && Client.field1028 != 1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "-128"
   )
   final void method1706(String var1) {
      if(var1 != null) {
         Name var2 = new Name(var1, this.field1192);
         if(var2.method5359()) {
            if(this.field1194.method5264(var2)) {
               class3.method3();
               PacketNode var3 = class61.method1076(ClientPacket.field2419, Client.field863.field1434);
               var3.packetBuffer.putByte(class43.getLength(var1));
               var3.packetBuffer.putString(var1);
               Client.field863.method2039(var3);
            }

            ItemLayer.method2600();
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-75626074"
   )
   final void method1722(String var1) {
      if(var1 != null) {
         Name var2 = new Name(var1, this.field1192);
         if(var2.method5359()) {
            if(this.field1193.method5264(var2)) {
               class3.method3();
               PacketNode var3 = class61.method1076(ClientPacket.field2418, Client.field863.field1434);
               var3.packetBuffer.putByte(class43.getLength(var1));
               var3.packetBuffer.putString(var1);
               Client.field863.method2039(var3);
            }

            class84.method1854();
            if(class2.clanMemberManager != null) {
               class2.clanMemberManager.method5399();
            }

         }
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Z",
      garbageValue = "2062651771"
   )
   public static boolean method1748(CharSequence var0) {
      return ItemComposition.method5009(var0, 10, true);
   }
}
