import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jw")
@Implements("ClanMember")
public class ClanMember extends ChatPlayer {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lke;"
   )
   class289 field3628;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lke;"
   )
   class289 field3626;

   ClanMember() {
      this.field3628 = class289.field3652;
      this.field3626 = class289.field3652;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-19"
   )
   void method5275() {
      this.field3628 = class289.field3652;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2033986770"
   )
   public final boolean method5277() {
      if(this.field3628 == class289.field3652) {
         this.method5278();
      }

      return this.field3628 == class289.field3651;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-557789086"
   )
   void method5278() {
      this.field3628 = CacheFile.friendManager.friendContainer.isMember(super.name)?class289.field3651:class289.field3650;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-185368231"
   )
   void method5279() {
      this.field3626 = class289.field3652;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-11"
   )
   public final boolean method5280() {
      if(this.field3626 == class289.field3652) {
         this.method5281();
      }

      return this.field3626 == class289.field3651;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1991874456"
   )
   void method5281() {
      this.field3626 = CacheFile.friendManager.ignoreContainer.isMember(super.name)?class289.field3651:class289.field3650;
   }
}
