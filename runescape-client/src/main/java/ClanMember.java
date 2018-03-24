import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ki")
@Implements("ClanMember")
public class ClanMember extends ChatPlayer {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lkx;"
   )
   class303 field3822;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lkx;"
   )
   class303 field3823;

   ClanMember() {
      this.field3822 = class303.field3850;
      this.field3823 = class303.field3850;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2118717872"
   )
   void method5227() {
      this.field3822 = class303.field3850;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1963475027"
   )
   public final boolean method5229() {
      if(this.field3822 == class303.field3850) {
         this.method5230();
      }

      return this.field3822 == class303.field3846;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1860606292"
   )
   void method5230() {
      this.field3822 = WallObject.friendManager.field1229.isMember(super.name)?class303.field3846:class303.field3847;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "10"
   )
   void method5231() {
      this.field3823 = class303.field3850;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2084775830"
   )
   public final boolean method5244() {
      if(this.field3823 == class303.field3850) {
         this.method5232();
      }

      return this.field3823 == class303.field3846;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "264907422"
   )
   void method5232() {
      this.field3823 = WallObject.friendManager.field1233.isMember(super.name)?class303.field3846:class303.field3847;
   }

   @ObfuscatedName("jv")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZB)Ljava/lang/String;",
      garbageValue = "3"
   )
   static String method5226(String var0, boolean var1) {
      String var2 = var1?"https://":"http://";
      if(Client.socketType == 1) {
         var0 = var0 + "-wtrc";
      } else if(Client.socketType == 2) {
         var0 = var0 + "-wtqa";
      } else if(Client.socketType == 3) {
         var0 = var0 + "-wtwip";
      } else if(Client.socketType == 5) {
         var0 = var0 + "-wti";
      } else if(Client.socketType == 4) {
         var0 = "local";
      }

      String var3 = "";
      if(Projectile.sessionToken != null) {
         var3 = "/p=" + Projectile.sessionToken;
      }

      String var4 = "runescape.com";
      return var2 + var0 + "." + var4 + "/l=" + Client.languageId + "/a=" + Enum.field3558 + var3 + "/";
   }
}
