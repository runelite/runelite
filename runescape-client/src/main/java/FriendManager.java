import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cx")
@Implements("FriendManager")
public class FriendManager {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lld;"
   )
   final JagexLoginType field1194;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Ljs;"
   )
   public final class279 field1191;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Ljq;"
   )
   public final class274 field1196;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 685212631
   )
   int field1195;

   @ObfuscatedSignature(
      signature = "(Lld;)V"
   )
   FriendManager(JagexLoginType var1) {
      this.field1195 = 0;
      this.field1194 = var1;
      this.field1191 = new class279(var1);
      this.field1196 = new class274(var1);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "82"
   )
   boolean method1664() {
      return this.field1195 == 2;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1727014086"
   )
   final void method1665() {
      this.field1195 = 1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lgj;II)V",
      garbageValue = "993231494"
   )
   final void method1694(Buffer var1, int var2) {
      this.field1191.method5117(var1, var2);
      this.field1195 = 2;
      WorldMapType1.method284();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1952853488"
   )
   final void method1671() {
      for(class283 var1 = (class283)this.field1191.field3693.method3895(); var1 != null; var1 = (class283)this.field1191.field3693.method3897()) {
         if((long)var1.field3719 < ScriptVarType.currentTimeMs() / 1000L - 5L) {
            if(var1.field3717 > 0) {
               class240.sendGameMessage(5, "", var1.field3715 + " has logged in.");
            }

            if(var1.field3717 == 0) {
               class240.sendGameMessage(5, "", var1.field3715 + " has logged out.");
            }

            var1.method3909();
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-153255708"
   )
   final void method1668() {
      this.field1195 = 0;
      this.field1191.method5067();
      this.field1196.method5067();
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljr;ZI)Z",
      garbageValue = "-717303535"
   )
   @Export("isFriended")
   final boolean isFriended(Name var1, boolean var2) {
      return var1 == null?false:(var1.equals(class36.localPlayer.name)?true:this.field1191.method5116(var1, var2));
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljr;I)Z",
      garbageValue = "1659869194"
   )
   final boolean method1670(Name var1) {
      return var1 == null?false:this.field1196.isMember(var1);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1395904253"
   )
   final void method1707(String var1) {
      if(var1 != null) {
         Name var2 = new Name(var1, this.field1194);
         if(var2.method5132()) {
            if(this.method1672()) {
               class63.method1054("Your friend list is full. Max of 200 for free users, and 400 for members");
            } else if(class36.localPlayer.name.equals(var2)) {
               Size.method187();
            } else if(this.isFriended(var2, false)) {
               SceneTilePaint.method2808(var1);
            } else if(this.method1670(var2)) {
               class5.method23(var1);
            } else {
               class35.method503(var1);
            }
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1827557930"
   )
   final boolean method1672() {
      return this.field1191.method5037() || this.field1191.getCount() >= 200 && Client.field928 != 1;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1992712707"
   )
   final void method1673(String var1) {
      if(var1 != null) {
         Name var2 = new Name(var1, this.field1194);
         if(var2.method5132()) {
            if(this.method1674()) {
               WorldMapType3.method215();
            } else if(class36.localPlayer.name.equals(var2)) {
               GameEngine.method983();
            } else if(this.method1670(var2)) {
               BuildType.method4352(var1);
            } else if(this.isFriended(var2, false)) {
               ScriptState.method1050(var1);
            } else {
               ObjectComposition.method4823(var1);
            }
         }
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "686206964"
   )
   final boolean method1674() {
      return this.field1196.method5037() || this.field1196.getCount() >= 100 && Client.field928 != 1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-389196825"
   )
   final void method1675(String var1) {
      if(var1 != null) {
         Name var2 = new Name(var1, this.field1194);
         if(var2.method5132()) {
            if(this.field1191.method5056(var2)) {
               Client.field1000 = Client.cycleCntr;
               PacketNode var3 = class35.method501(ClientPacket.field2336, Client.field867.field1439);
               var3.packetBuffer.putByte(ContextMenuRow.getLength(var1));
               var3.packetBuffer.putString(var1);
               Client.field867.method2021(var3);
            }

            WorldMapType1.method284();
         }
      }
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "2092012355"
   )
   final void method1713(String var1) {
      if(var1 != null) {
         Name var2 = new Name(var1, this.field1194);
         if(var2.method5132()) {
            if(this.field1196.method5056(var2)) {
               Client.field1000 = Client.cycleCntr;
               PacketNode var3 = class35.method501(ClientPacket.field2355, Client.field867.field1439);
               var3.packetBuffer.putByte(ContextMenuRow.getLength(var1));
               var3.packetBuffer.putString(var1);
               Client.field867.method2021(var3);
            }

            Iterator var5 = class94.messages.iterator();

            while(var5.hasNext()) {
               MessageNode var4 = (MessageNode)var5.next();
               var4.method1093();
            }

            if(class234.clanMemberManager != null) {
               class234.clanMemberManager.method5167();
            }

         }
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "68"
   )
   static int method1733(int var0) {
      MessageNode var1 = (MessageNode)class94.messages.get((long)var0);
      return var1 == null?-1:(var1.previous == class94.field1401.sentinel?-1:((MessageNode)var1.previous).id);
   }
}
