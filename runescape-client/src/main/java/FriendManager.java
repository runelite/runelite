import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ct")
@Implements("FriendManager")
public class FriendManager {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1068851971
   )
   static int field1251;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Llo;"
   )
   final JagexLoginType field1247;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lkz;"
   )
   public final class304 field1250;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lkq;"
   )
   public final class298 field1249;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1638783467
   )
   int field1246;

   @ObfuscatedSignature(
      signature = "(Llo;)V"
   )
   FriendManager(JagexLoginType var1) {
      this.field1246 = 0;
      this.field1247 = var1;
      this.field1250 = new class304(var1);
      this.field1249 = new class298(var1);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "718001579"
   )
   boolean method1657() {
      return this.field1246 == 2;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "78"
   )
   final void method1658() {
      this.field1246 = 1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lgp;II)V",
      garbageValue = "1464575764"
   )
   final void method1659(Buffer var1, int var2) {
      this.field1250.method5420(var1, var2);
      this.field1246 = 2;

      for(int var3 = 0; var3 < class93.playerIndexesCount; ++var3) {
         Player var4 = Client.cachedPlayers[class93.playerIndices[var3]];
         var4.method1166();
      }

      GameCanvas.method824();
      if(class33.clanMemberManager != null) {
         class33.clanMemberManager.method5468();
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "801935468"
   )
   final void method1660() {
      for(class308 var1 = (class308)this.field1250.field3847.method4061(); var1 != null; var1 = (class308)this.field1250.field3847.method4062()) {
         if((long)var1.field3868 < ScriptVarType.method28() / 1000L - 5L) {
            if(var1.field3866 > 0) {
               class189.sendGameMessage(5, "", var1.field3865 + " has logged in.");
            }

            if(var1.field3866 == 0) {
               class189.sendGameMessage(5, "", var1.field3865 + " has logged out.");
            }

            var1.method4069();
         }
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "11"
   )
   final void method1661() {
      this.field1246 = 0;
      this.field1250.method5351();
      this.field1249.method5351();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lko;ZI)Z",
      garbageValue = "498146722"
   )
   @Export("isFriended")
   final boolean isFriended(Name var1, boolean var2) {
      return var1 == null?false:(var1.equals(WorldComparator.localPlayer.name)?true:this.field1250.method5415(var1, var2));
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lko;B)Z",
      garbageValue = "-8"
   )
   final boolean method1695(Name var1) {
      return var1 == null?false:this.field1249.isMember(var1);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "2047936356"
   )
   final void method1664(String var1) {
      if(var1 != null) {
         Name var2 = new Name(var1, this.field1247);
         if(var2.method5450()) {
            if(this.method1665()) {
               class47.method743("Your friend list is full. Max of 200 for free users, and 400 for members");
            } else if(WorldComparator.localPlayer.name.equals(var2)) {
               class240.method4441();
            } else if(this.isFriended(var2, false)) {
               class47.method743(var1 + " is already on your friend list");
            } else if(this.method1695(var2)) {
               class47.method743("Please remove " + var1 + " from your ignore list first");
            } else {
               Client.method1579(var1);
            }
         }
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2055406942"
   )
   final boolean method1665() {
      return this.field1250.method5315() || this.field1250.getCount() >= 200 && Client.field973 != 1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "0"
   )
   final void method1666(String var1) {
      if(var1 != null) {
         Name var2 = new Name(var1, this.field1247);
         if(var2.method5450()) {
            if(this.method1667()) {
               class47.method743("Your ignore list is full. Max of 100 for free users, and 400 for members");
            } else if(WorldComparator.localPlayer.name.equals(var2)) {
               IndexData.method4694();
            } else if(this.method1695(var2)) {
               class49.method778(var1);
            } else if(this.isFriended(var2, false)) {
               GrandExchangeEvent.method87(var1);
            } else {
               PacketNode var3 = FaceNormal.method3078(ClientPacket.field2439, Client.field902.field1475);
               var3.packetBuffer.putByte(Projectile.getLength(var1));
               var3.packetBuffer.putString(var1);
               Client.field902.method2036(var3);
            }
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "109725225"
   )
   final boolean method1667() {
      return this.field1249.method5315() || this.field1249.getCount() >= 100 && Client.field973 != 1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1293478071"
   )
   final void method1668(String var1) {
      if(var1 != null) {
         Name var2 = new Name(var1, this.field1247);
         if(var2.method5450()) {
            if(this.field1250.method5345(var2)) {
               class132.method2786();
               PacketNode var3 = FaceNormal.method3078(ClientPacket.field2379, Client.field902.field1475);
               var3.packetBuffer.putByte(Projectile.getLength(var1));
               var3.packetBuffer.putString(var1);
               Client.field902.method2036(var3);
            }

            class190.method3487();
         }
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "640825907"
   )
   final void method1690(String var1) {
      if(var1 != null) {
         Name var2 = new Name(var1, this.field1247);
         if(var2.method5450()) {
            if(this.field1249.method5345(var2)) {
               class132.method2786();
               PacketNode var3 = FaceNormal.method3078(ClientPacket.field2399, Client.field902.field1475);
               var3.packetBuffer.putByte(Projectile.getLength(var1));
               var3.packetBuffer.putString(var1);
               Client.field902.method2036(var3);
            }

            Iterator var5 = class95.messages.iterator();

            while(var5.hasNext()) {
               MessageNode var4 = (MessageNode)var5.next();
               var4.method1107();
            }

            if(class33.clanMemberManager != null) {
               class33.clanMemberManager.method5469();
            }

         }
      }
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(Lko;I)Z",
      garbageValue = "-307992040"
   )
   final boolean method1670(Name var1) {
      Friend var2 = (Friend)this.field1250.method5317(var1);
      return var2 != null && var2.method5397();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "0"
   )
   public static int method1686(int var0) {
      return var0 > 0?1:(var0 < 0?-1:0);
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-472965224"
   )
   @Export("runWidgetOnLoadListener")
   static void runWidgetOnLoadListener(int var0) {
      if(var0 != -1) {
         if(Name.loadWidget(var0)) {
            Widget[] var1 = class189.widgets[var0];

            for(int var2 = 0; var2 < var1.length; ++var2) {
               Widget var3 = var1[var2];
               if(var3.onLoadListener != null) {
                  ScriptEvent var4 = new ScriptEvent();
                  var4.widget = var3;
                  var4.objs = var3.onLoadListener;
                  class23.runScript(var4, 5000000);
               }
            }

         }
      }
   }

   @ObfuscatedName("fk")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1672555473"
   )
   static final void method1722() {
      Client.field902.close();
      class18.method155();
      class308.region.reset();

      for(int var0 = 0; var0 < 4; ++var0) {
         Client.collisionMaps[var0].reset();
      }

      System.gc();
      IndexStoreActionHandler.method4660(2);
      Client.field1089 = -1;
      Client.field1090 = false;
      class231.method4261();
      MapIconReference.setGameState(10);
   }
}
