import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cw")
@Implements("FriendManager")
public class FriendManager {
   @ObfuscatedName("fs")
   @ObfuscatedSignature(
      signature = "[Lkh;"
   )
   @Export("modIconSprites")
   static IndexedSprite[] modIconSprites;
   @ObfuscatedName("ja")
   @ObfuscatedSignature(
      signature = "Lhs;"
   )
   static Widget field1216;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lld;"
   )
   final JagexLoginType field1219;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Ljd;"
   )
   public final class279 field1211;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Ljr;"
   )
   public final class274 field1212;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -738736207
   )
   int field1213;

   @ObfuscatedSignature(
      signature = "(Lld;)V"
   )
   FriendManager(JagexLoginType var1) {
      this.field1213 = 0;
      this.field1219 = var1;
      this.field1211 = new class279(var1);
      this.field1212 = new class274(var1);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "21"
   )
   boolean method1738() {
      return this.field1213 == 2;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2124399386"
   )
   final void method1684() {
      this.field1213 = 1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lgy;II)V",
      garbageValue = "-1272541274"
   )
   final void method1723(Buffer var1, int var2) {
      this.field1211.method5258(var1, var2);
      this.field1213 = 2;

      for(int var3 = 0; var3 < class92.playerIndexesCount; ++var3) {
         Player var4 = Client.cachedPlayers[class92.playerIndices[var3]];
         var4.method1124();
      }

      Iterator var5 = class94.messages.iterator();

      while(var5.hasNext()) {
         MessageNode var6 = (MessageNode)var5.next();
         var6.method1081();
      }

      if(class22.clanMemberManager != null) {
         class22.clanMemberManager.method5309();
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   final void method1686() {
      for(class283 var1 = (class283)this.field1211.field3719.method4069(); var1 != null; var1 = (class283)this.field1211.field3719.method4066()) {
         if((long)var1.field3745 < SceneTilePaint.currentTimeMs() / 1000L - 5L) {
            if(var1.field3744 > 0) {
               SoundTaskDataProvider.sendGameMessage(5, "", var1.field3746 + " has logged in.");
            }

            if(var1.field3744 == 0) {
               SoundTaskDataProvider.sendGameMessage(5, "", var1.field3746 + " has logged out.");
            }

            var1.method4076();
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "685816571"
   )
   final void method1742() {
      this.field1213 = 0;
      this.field1211.method5245();
      this.field1212.method5245();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lja;ZI)Z",
      garbageValue = "626634568"
   )
   @Export("isFriended")
   final boolean isFriended(Name var1, boolean var2) {
      return var1 == null?false:(var1.equals(GroundObject.localPlayer.name)?true:this.field1211.method5262(var1, var2));
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lja;B)Z",
      garbageValue = "-55"
   )
   final boolean method1689(Name var1) {
      return var1 == null?false:this.field1212.isMember(var1);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "26189272"
   )
   final void method1690(String var1) {
      if(var1 != null) {
         Name var2 = new Name(var1, this.field1219);
         if(var2.method5276()) {
            if(this.method1691()) {
               class70.method1118();
            } else if(GroundObject.localPlayer.name.equals(var2)) {
               NameableContainer.method5186();
            } else if(this.isFriended(var2, false)) {
               BoundingBox3D.method49(var1 + " is already on your friend list");
            } else if(this.method1689(var2)) {
               BoundingBox3D.method49("Please remove " + var1 + " from your ignore list first");
            } else {
               PacketNode var3 = Script.method2025(ClientPacket.field2369, Client.field937.field1454);
               var3.packetBuffer.putByte(FrameMap.getLength(var1));
               var3.packetBuffer.putString(var1);
               Client.field937.method2044(var3);
            }
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1966492928"
   )
   final boolean method1691() {
      return this.field1211.method5170() || this.field1211.getCount() >= 200 && Client.field946 != 1;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1669194440"
   )
   final void method1749(String var1) {
      if(var1 != null) {
         Name var2 = new Name(var1, this.field1219);
         if(var2.method5276()) {
            if(this.method1693()) {
               MessageNode.method1109();
            } else if(GroundObject.localPlayer.name.equals(var2)) {
               class84.method1865();
            } else if(this.method1689(var2)) {
               BoundingBox3D.method49(var1 + " is already on your ignore list");
            } else if(this.isFriended(var2, false)) {
               BoundingBox3D.method49("Please remove " + var1 + " from your friend list first");
            } else {
               Preferences.method1667(var1);
            }
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "31"
   )
   final boolean method1693() {
      return this.field1212.method5170() || this.field1212.getCount() >= 100 && Client.field946 != 1;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1339059143"
   )
   final void method1712(String var1) {
      if(var1 != null) {
         Name var2 = new Name(var1, this.field1219);
         if(var2.method5276()) {
            if(this.field1211.method5175(var2)) {
               class289.method5459();
               PacketNode var3 = Script.method2025(ClientPacket.field2328, Client.field937.field1454);
               var3.packetBuffer.putByte(FrameMap.getLength(var1));
               var3.packetBuffer.putString(var1);
               Client.field937.method2044(var3);
            }

            for(int var5 = 0; var5 < class92.playerIndexesCount; ++var5) {
               Player var4 = Client.cachedPlayers[class92.playerIndices[var5]];
               var4.method1124();
            }

            Iterator var6 = class94.messages.iterator();

            while(var6.hasNext()) {
               MessageNode var7 = (MessageNode)var6.next();
               var7.method1081();
            }

            if(class22.clanMemberManager != null) {
               class22.clanMemberManager.method5309();
            }

         }
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "-20"
   )
   final void method1695(String var1) {
      if(var1 != null) {
         Name var2 = new Name(var1, this.field1219);
         if(var2.method5276()) {
            if(this.field1212.method5175(var2)) {
               class289.method5459();
               PacketNode var3 = Script.method2025(ClientPacket.field2389, Client.field937.field1454);
               var3.packetBuffer.putByte(FrameMap.getLength(var1));
               var3.packetBuffer.putString(var1);
               Client.field937.method2044(var3);
            }

            DState.method3487();
            if(class22.clanMemberManager != null) {
               class22.clanMemberManager.method5303();
            }

         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lgt;IB)Z",
      garbageValue = "-116"
   )
   @Export("decodeRegionHash")
   static boolean decodeRegionHash(PacketBuffer var0, int var1) {
      int var2 = var0.getBits(2);
      int var3;
      int var4;
      int var7;
      int var8;
      int var9;
      int var10;
      if(var2 == 0) {
         if(var0.getBits(1) != 0) {
            decodeRegionHash(var0, var1);
         }

         var3 = var0.getBits(13);
         var4 = var0.getBits(13);
         boolean var12 = var0.getBits(1) == 1;
         if(var12) {
            class92.field1400[++class92.field1399 - 1] = var1;
         }

         if(Client.cachedPlayers[var1] != null) {
            throw new RuntimeException();
         } else {
            Player var6 = Client.cachedPlayers[var1] = new Player();
            var6.field822 = var1;
            if(class92.field1398[var1] != null) {
               var6.decodeApperance(class92.field1398[var1]);
            }

            var6.orientation = class92.Players_orientations[var1];
            var6.interacting = class92.Players_targetIndices[var1];
            var7 = class92.Players_regions[var1];
            var8 = var7 >> 28;
            var9 = var7 >> 14 & 255;
            var10 = var7 & 255;
            var6.pathTraversed[0] = class92.field1390[var1];
            var6.field827 = (byte)var8;
            var6.method1125((var9 << 13) + var3 - ClanMemberManager.baseX, (var10 << 13) + var4 - WorldMapData.baseY);
            var6.field831 = false;
            return true;
         }
      } else if(var2 == 1) {
         var3 = var0.getBits(2);
         var4 = class92.Players_regions[var1];
         class92.Players_regions[var1] = (((var4 >> 28) + var3 & 3) << 28) + (var4 & 268435455);
         return false;
      } else {
         int var5;
         int var11;
         if(var2 == 2) {
            var3 = var0.getBits(5);
            var4 = var3 >> 3;
            var5 = var3 & 7;
            var11 = class92.Players_regions[var1];
            var7 = (var11 >> 28) + var4 & 3;
            var8 = var11 >> 14 & 255;
            var9 = var11 & 255;
            if(var5 == 0) {
               --var8;
               --var9;
            }

            if(var5 == 1) {
               --var9;
            }

            if(var5 == 2) {
               ++var8;
               --var9;
            }

            if(var5 == 3) {
               --var8;
            }

            if(var5 == 4) {
               ++var8;
            }

            if(var5 == 5) {
               --var8;
               ++var9;
            }

            if(var5 == 6) {
               ++var9;
            }

            if(var5 == 7) {
               ++var8;
               ++var9;
            }

            class92.Players_regions[var1] = (var8 << 14) + var9 + (var7 << 28);
            return false;
         } else {
            var3 = var0.getBits(18);
            var4 = var3 >> 16;
            var5 = var3 >> 8 & 255;
            var11 = var3 & 255;
            var7 = class92.Players_regions[var1];
            var8 = (var7 >> 28) + var4 & 3;
            var9 = var5 + (var7 >> 14) & 255;
            var10 = var11 + var7 & 255;
            class92.Players_regions[var1] = (var9 << 14) + var10 + (var8 << 28);
            return false;
         }
      }
   }
}
