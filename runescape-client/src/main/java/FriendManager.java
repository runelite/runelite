import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cm")
@Implements("FriendManager")
public class FriendManager {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Llu;"
   )
   final JagexLoginType field1231;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lke;"
   )
   public final class304 field1229;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lkj;"
   )
   public final class298 field1233;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 645764735
   )
   int field1228;

   @ObfuscatedSignature(
      signature = "(Llu;)V"
   )
   FriendManager(JagexLoginType var1) {
      this.field1228 = 0;
      this.field1231 = var1;
      this.field1229 = new class304(var1);
      this.field1233 = new class298(var1);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "425727715"
   )
   boolean method1721() {
      return this.field1228 == 2;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1180889999"
   )
   final void method1752() {
      this.field1228 = 1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lgb;IB)V",
      garbageValue = "67"
   )
   final void method1723(Buffer var1, int var2) {
      this.field1229.method5412(var1, var2);
      this.field1228 = 2;
      MouseRecorder.method1163();
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "66"
   )
   final void method1751() {
      for(class308 var1 = (class308)this.field1229.field3852.method4084(); var1 != null; var1 = (class308)this.field1229.field3852.method4085()) {
         if((long)var1.field3874 < WorldMapRegion.method465() / 1000L - 5L) {
            if(var1.field3873 > 0) {
               TotalQuantityComparator.sendGameMessage(5, "", var1.field3872 + " has logged in.");
            }

            if(var1.field3873 == 0) {
               TotalQuantityComparator.sendGameMessage(5, "", var1.field3872 + " has logged out.");
            }

            var1.method4093();
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-89"
   )
   final void method1725() {
      this.field1228 = 0;
      this.field1229.method5297();
      this.field1233.method5297();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lkb;ZI)Z",
      garbageValue = "-2140289655"
   )
   @Export("isFriended")
   final boolean isFriended(Name var1, boolean var2) {
      return var1 == null?false:(var1.equals(WorldMapData.localPlayer.name)?true:this.field1229.method5416(var1, var2));
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lkb;B)Z",
      garbageValue = "105"
   )
   final boolean method1727(Name var1) {
      return var1 == null?false:this.field1233.isMember(var1);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "14"
   )
   final void method1782(String var1) {
      if(var1 != null) {
         Name var2 = new Name(var1, this.field1231);
         if(var2.method5418()) {
            if(this.method1729()) {
               class45.method687();
            } else if(WorldMapData.localPlayer.name.equals(var2)) {
               FileOnDisk.method2556();
            } else if(this.isFriended(var2, false)) {
               MapIconReference.method757(var1 + " is already on your friend list");
            } else if(this.method1727(var2)) {
               class2.method4(var1);
            } else {
               PacketNode var3 = class33.method382(ClientPacket.field2372, Client.field1072.field1456);
               var3.packetBuffer.putByte(UnitPriceComparator.getLength(var1));
               var3.packetBuffer.putString(var1);
               Client.field1072.method2073(var3);
            }
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1387249777"
   )
   final boolean method1729() {
      return this.field1229.method5375() || this.field1229.getCount() >= 200 && Client.field966 != 1;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1131938338"
   )
   final void method1769(String var1) {
      if(var1 != null) {
         Name var2 = new Name(var1, this.field1231);
         if(var2.method5418()) {
            if(this.method1731()) {
               BoundingBox2D.method40();
            } else if(WorldMapData.localPlayer.name.equals(var2)) {
               MapIconReference.method757("You can\'t add yourself to your own ignore list");
            } else if(this.method1727(var2)) {
               Area.method4767(var1);
            } else if(this.isFriended(var2, false)) {
               class229.method4163(var1);
            } else {
               PacketNode var3 = class33.method382(ClientPacket.field2351, Client.field1072.field1456);
               var3.packetBuffer.putByte(UnitPriceComparator.getLength(var1));
               var3.packetBuffer.putString(var1);
               Client.field1072.method2073(var3);
            }
         }
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "744082181"
   )
   final boolean method1731() {
      return this.field1233.method5375() || this.field1233.getCount() >= 100 && Client.field966 != 1;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1047960487"
   )
   final void method1732(String var1) {
      if(var1 != null) {
         Name var2 = new Name(var1, this.field1231);
         if(var2.method5418()) {
            if(this.field1229.method5304(var2)) {
               MapIconReference.method760();
               PacketNode var3 = class33.method382(ClientPacket.field2439, Client.field1072.field1456);
               var3.packetBuffer.putByte(UnitPriceComparator.getLength(var1));
               var3.packetBuffer.putString(var1);
               Client.field1072.method2073(var3);
            }

            MouseRecorder.method1163();
         }
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "-14"
   )
   final void method1733(String var1) {
      if(var1 != null) {
         Name var2 = new Name(var1, this.field1231);
         if(var2.method5418()) {
            if(this.field1233.method5304(var2)) {
               MapIconReference.method760();
               PacketNode var3 = class33.method382(ClientPacket.field2412, Client.field1072.field1456);
               var3.packetBuffer.putByte(UnitPriceComparator.getLength(var1));
               var3.packetBuffer.putString(var1);
               Client.field1072.method2073(var3);
            }

            Size.method194();
            if(KeyFocusListener.clanMemberManager != null) {
               KeyFocusListener.clanMemberManager.method5469();
            }

         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lkb;S)Z",
      garbageValue = "14717"
   )
   final boolean method1734(Name var1) {
      Friend var2 = (Friend)this.field1229.method5301(var1);
      return var2 != null && var2.method5390();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "704442605"
   )
   static synchronized void method1724(byte[] var0) {
      if(var0.length == 100 && class195.field2557 < 1000) {
         class195.field2555[++class195.field2557 - 1] = var0;
      } else if(var0.length == 5000 && class195.field2560 < 250) {
         class195.field2552[++class195.field2560 - 1] = var0;
      } else if(var0.length == 30000 && class195.field2554 < 50) {
         class195.field2553[++class195.field2554 - 1] = var0;
      } else {
         if(class195.field2559 != null) {
            for(int var1 = 0; var1 < CombatInfo1.field1202.length; ++var1) {
               if(var0.length == CombatInfo1.field1202[var1] && class195.field2558[var1] < class195.field2559[var1].length) {
                  class195.field2559[var1][class195.field2558[var1]++] = var0;
                  return;
               }
            }
         }

      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "7"
   )
   static final int method1792(int var0, int var1) {
      if(var0 == -1) {
         return 12345678;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 65408) + var1;
      }
   }
}
