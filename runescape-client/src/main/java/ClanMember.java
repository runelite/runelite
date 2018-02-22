import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jc")
@Implements("ClanMember")
public class ClanMember extends ChatPlayer
{
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lkd;"
   )
   class289 field3699;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lkd;"
   )
   class289 field3698;

   ClanMember() {
      this.field3699 = class289.field3723;
      this.field3698 = class289.field3723;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "16577949"
   )
   void method5162() {
      this.field3699 = class289.field3723;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-31"
   )
   public final boolean method5167() {
      if(this.field3699 == class289.field3723) {
         this.method5164();
      }

      return this.field3699 == class289.field3722;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "111"
   )
   void method5164() {
      this.field3699 = ContextMenuRow.friendManager.field1194.isMember(super.name)?class289.field3722:class289.field3726;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1910755418"
   )
   void method5165() {
      this.field3698 = class289.field3723;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1761870379"
   )
   public final boolean method5166() {
      if(this.field3698 == class289.field3723) {
         this.method5169();
      }

      return this.field3698 == class289.field3722;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1080984782"
   )
   void method5169() {
      this.field3698 = ContextMenuRow.friendManager.field1193.isMember(super.name)?class289.field3722:class289.field3726;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lgn;J)V"
   )
   static void method5163(Buffer var0, long var1) {
      var1 /= 10L;
      if(var1 < 0L) {
         var1 = 0L;
      } else if(var1 > 65535L) {
         var1 = 65535L;
      }

      var0.putShort((int)var1);
   }
}
