import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jk")
@Implements("ClanMemberManager")
public class ClanMemberManager extends NameableContainer {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lld;"
   )
   final JagexLoginType field3709;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Ljh;"
   )
   final class277 field3710;
   @ObfuscatedName("m")
   public String field3713;
   @ObfuscatedName("h")
   public String field3708;
   @ObfuscatedName("o")
   public byte field3711;
   @ObfuscatedName("x")
   public byte field3714;

   @ObfuscatedSignature(
      signature = "(Lld;Ljh;)V"
   )
   public ClanMemberManager(JagexLoginType var1, class277 var2) {
      super(100);
      this.field3713 = null;
      this.field3708 = null;
      this.field3709 = var1;
      this.field3710 = var2;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)Lju;",
      garbageValue = "-98"
   )
   Nameable vmethod5160() {
      return new ClanMember();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)[Lju;",
      garbageValue = "-1319508722"
   )
   Nameable[] vmethod5161(int var1) {
      return new ClanMember[var1];
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1430253261"
   )
   final void method5162(String var1) {
      this.field3713 = BoundingBox.method65(var1);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "1"
   )
   final void method5163(String var1) {
      this.field3708 = BoundingBox.method65(var1);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lgj;S)V",
      garbageValue = "14572"
   )
   public final void method5164(Buffer var1) {
      this.method5163(var1.readString());
      long var2 = var1.readLong();
      this.method5162(class46.method687(var2));
      this.field3711 = var1.readByte();
      int var4 = var1.readUnsignedByte();
      if(var4 != 255) {
         this.method5067();

         for(int var5 = 0; var5 < var4; ++var5) {
            ClanMember var6 = (ClanMember)this.method5034(new Name(var1.readString(), this.field3709));
            var6.world = var1.readUnsignedShort();
            var6.rank = var1.readByte();
            var1.readString();
            this.method5168(var6);
         }

      }
   }

   @ObfuscatedName("cx")
   @ObfuscatedSignature(
      signature = "(Lgj;I)V",
      garbageValue = "-382151944"
   )
   public final void method5165(Buffer var1) {
      Name var2 = new Name(var1.readString(), this.field3709);
      int var3 = var1.readUnsignedShort();
      byte var4 = var1.readByte();
      boolean var5 = false;
      if(var4 == -128) {
         var5 = true;
      }

      ClanMember var6;
      if(var5) {
         if(this.getCount() == 0) {
            return;
         }

         var6 = (ClanMember)this.method5040(var2);
         if(var6 != null && var3 == var6.world) {
            this.method5043(var6);
         }
      } else {
         var1.readString();
         var6 = (ClanMember)this.method5039(var2);
         if(var6 == null) {
            if(this.getCount() > super.field3685) {
               return;
            }

            var6 = (ClanMember)this.method5034(var2);
         }

         var6.world = var3;
         var6.rank = var4;
         this.method5168(var6);
      }

   }

   @ObfuscatedName("cv")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1302275940"
   )
   public final void method5166() {
      for(int var1 = 0; var1 < this.getCount(); ++var1) {
         ((ClanMember)this.get(var1)).method4993();
      }

   }

   @ObfuscatedName("cc")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1915495201"
   )
   public final void method5167() {
      for(int var1 = 0; var1 < this.getCount(); ++var1) {
         ((ClanMember)this.get(var1)).method4976();
      }

   }

   @ObfuscatedName("cg")
   @ObfuscatedSignature(
      signature = "(Ljy;B)V",
      garbageValue = "104"
   )
   final void method5168(ClanMember var1) {
      if(var1.method5001().equals(this.field3710.vmethod5106())) {
         this.field3714 = var1.rank;
      }

   }
}
