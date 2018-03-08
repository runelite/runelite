import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kl")
@Implements("ClanMemberManager")
public class ClanMemberManager extends NameableContainer {
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Llu;"
   )
   final JagexLoginType field3867;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lkz;"
   )
   final class302 field3866;
   @ObfuscatedName("g")
   public String field3871;
   @ObfuscatedName("n")
   public String field3868;
   @ObfuscatedName("o")
   public byte field3865;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 425289397
   )
   public int field3870;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 150359499
   )
   int field3864;

   @ObfuscatedSignature(
      signature = "(Llu;Lkz;)V"
   )
   public ClanMemberManager(JagexLoginType var1, class302 var2) {
      super(100);
      this.field3871 = null;
      this.field3868 = null;
      this.field3864 = 1;
      this.field3867 = var1;
      this.field3866 = var2;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)Lkv;",
      garbageValue = "-21"
   )
   Nameable vmethod5446() {
      return new ClanMember();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)[Lkv;",
      garbageValue = "-827789091"
   )
   Nameable[] vmethod5470(int var1) {
      return new ClanMember[var1];
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;S)V",
      garbageValue = "-7151"
   )
   final void method5449(String var1) {
      String var3 = class25.method200(GrandExchangeEvent.method91(var1));
      if(var3 == null) {
         var3 = "";
      }

      this.field3871 = var3;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1268121375"
   )
   final void method5450(String var1) {
      String var3 = class25.method200(GrandExchangeEvent.method91(var1));
      if(var3 == null) {
         var3 = "";
      }

      this.field3868 = var3;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lgb;B)V",
      garbageValue = "93"
   )
   public final void method5451(Buffer var1) {
      this.method5450(var1.readString());
      long var2 = var1.readLong();
      this.method5449(class3.method6(var2));
      this.field3865 = var1.readByte();
      int var4 = var1.readUnsignedByte();
      if(var4 != 255) {
         this.method5297();

         for(int var5 = 0; var5 < var4; ++var5) {
            ClanMember var6 = (ClanMember)this.method5336(new Name(var1.readString(), this.field3867));
            int var7 = var1.readUnsignedShort();
            var6.method5399(var7, ++this.field3864 - 1);
            var6.rank = var1.readByte();
            var1.readString();
            this.method5456(var6);
         }

      }
   }

   @ObfuscatedName("ce")
   @ObfuscatedSignature(
      signature = "(Lgb;I)V",
      garbageValue = "-1429290728"
   )
   public final void method5452(Buffer var1) {
      Name var2 = new Name(var1.readString(), this.field3867);
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

         var6 = (ClanMember)this.method5302(var2);
         if(var6 != null && var6.method5401() == var3) {
            this.method5305(var6);
         }
      } else {
         var1.readString();
         var6 = (ClanMember)this.method5301(var2);
         if(var6 == null) {
            if(this.getCount() > super.field3837) {
               return;
            }

            var6 = (ClanMember)this.method5336(var2);
         }

         var6.method5399(var3, ++this.field3864 - 1);
         var6.rank = var4;
         this.method5456(var6);
      }

   }

   @ObfuscatedName("cx")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "741600893"
   )
   public final void method5453() {
      for(int var1 = 0; var1 < this.getCount(); ++var1) {
         ((ClanMember)this.get(var1)).method5227();
      }

   }

   @ObfuscatedName("cy")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "14"
   )
   public final void method5469() {
      for(int var1 = 0; var1 < this.getCount(); ++var1) {
         ((ClanMember)this.get(var1)).method5231();
      }

   }

   @ObfuscatedName("cg")
   @ObfuscatedSignature(
      signature = "(Lki;I)V",
      garbageValue = "1861184411"
   )
   final void method5456(ClanMember var1) {
      if(var1.method5246().equals(this.field3866.vmethod5402())) {
         this.field3870 = var1.rank;
      }

   }
}
