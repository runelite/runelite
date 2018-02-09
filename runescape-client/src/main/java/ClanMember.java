import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jn")
@Implements("ClanMember")
public class ClanMember extends Nameable {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -567079295
   )
   @Export("world")
   public int world;
   @ObfuscatedName("g")
   @Export("rank")
   public byte rank;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Ljy;"
   )
   class278 field3695;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Ljy;"
   )
   class278 field3697;

   ClanMember() {
      this.field3695 = class278.field3716;
      this.field3697 = class278.field3716;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "8388607"
   )
   void method5117() {
      this.field3695 = class278.field3716;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-872565154"
   )
   public final boolean method5119() {
      if(this.field3695 == class278.field3716) {
         this.method5114();
      }

      return this.field3695 == class278.field3718;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-408145727"
   )
   void method5114() {
      this.field3695 = class35.friendManager.field1211.isMember(super.name)?class278.field3718:class278.field3717;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2095618386"
   )
   void method5115() {
      this.field3697 = class278.field3716;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-79"
   )
   public final boolean method5113() {
      if(this.field3697 == class278.field3716) {
         this.method5116();
      }

      return this.field3697 == class278.field3718;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-258417254"
   )
   void method5116() {
      this.field3697 = class35.friendManager.field1212.isMember(super.name)?class278.field3718:class278.field3717;
   }
}
