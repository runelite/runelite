import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kd")
@Implements("ClanMember")
public class ClanMember extends ChatPlayer {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lkf;"
   )
   class303 field3829;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lkf;"
   )
   class303 field3828;

   ClanMember() {
      this.field3829 = class303.field3856;
      this.field3828 = class303.field3856;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-572466040"
   )
   void method5302() {
      this.field3829 = class303.field3856;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "2114756487"
   )
   public final boolean method5300() {
      if(this.field3829 == class303.field3856) {
         this.method5304();
      }

      return this.field3829 == class303.field3858;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1903870402"
   )
   void method5304() {
      this.field3829 = CacheFile.friendManager.friendContainer.isMember(super.name)?class303.field3858:class303.field3855;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   void method5320() {
      this.field3828 = class303.field3856;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "106"
   )
   public final boolean method5314() {
      if(this.field3828 == class303.field3856) {
         this.method5312();
      }

      return this.field3828 == class303.field3858;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "2"
   )
   void method5312() {
      this.field3828 = CacheFile.friendManager.ignoreContainer.isMember(super.name)?class303.field3858:class303.field3855;
   }
}
