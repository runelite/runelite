import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jk")
@Implements("ClanMate")
public class ClanMate extends Buddy {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lkd;"
   )
   @Export("isFriend0")
   TriBool isFriend0;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lkd;"
   )
   @Export("isIgnored0")
   TriBool isIgnored0;

   ClanMate() {
      this.isFriend0 = TriBool.TriBool_unknown;
      this.isIgnored0 = TriBool.TriBool_unknown;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-865412624"
   )
   @Export("clearIsFriend")
   void clearIsFriend() {
      this.isFriend0 = TriBool.TriBool_unknown;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1324921155"
   )
   @Export("isFriend")
   public final boolean isFriend() {
      if(this.isFriend0 == TriBool.TriBool_unknown) {
         this.fillIsFriend();
      }

      return this.isFriend0 == TriBool.TriBool_true;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1189907091"
   )
   @Export("fillIsFriend")
   void fillIsFriend() {
      this.isFriend0 = WorldMapArea.friendSystem.friendsList.contains(super.username0)?TriBool.TriBool_true:TriBool.TriBool_false;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1852236089"
   )
   @Export("clearIsIgnored")
   void clearIsIgnored() {
      this.isIgnored0 = TriBool.TriBool_unknown;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1463106780"
   )
   @Export("isIgnored")
   public final boolean isIgnored() {
      if(this.isIgnored0 == TriBool.TriBool_unknown) {
         this.fillIsIgnored();
      }

      return this.isIgnored0 == TriBool.TriBool_true;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-598925338"
   )
   @Export("fillIsIgnored")
   void fillIsIgnored() {
      this.isIgnored0 = WorldMapArea.friendSystem.ignoreList.contains(super.username0)?TriBool.TriBool_true:TriBool.TriBool_false;
   }
}
