import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ku")
@Implements("ClanMember")
public class ClanMember extends ChatPlayer {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lkj;"
   )
   class303 field3821;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lkj;"
   )
   class303 field3822;

   ClanMember() {
      this.field3821 = class303.field3844;
      this.field3822 = class303.field3844;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "896972229"
   )
   void method5345() {
      this.field3821 = class303.field3844;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "890007061"
   )
   public final boolean method5346() {
      if(this.field3821 == class303.field3844) {
         this.method5352();
      }

      return this.field3821 == class303.field3842;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "547939643"
   )
   void method5352() {
      this.field3821 = ContextMenuRow.friendManager.field1235.isMember(super.name)?class303.field3842:class303.field3843;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1149371675"
   )
   void method5344() {
      this.field3822 = class303.field3844;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1531510919"
   )
   public final boolean method5349() {
      if(this.field3822 == class303.field3844) {
         this.method5350();
      }

      return this.field3822 == class303.field3842;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   void method5350() {
      this.field3822 = ContextMenuRow.friendManager.field1233.isMember(super.name)?class303.field3842:class303.field3843;
   }
}
