import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ky")
@Implements("ClanMemberManager")
public class ClanMemberManager extends NameableContainer {
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Llh;"
   )
   final JagexLoginType field3866;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lkn;"
   )
   final class302 field3867;
   @ObfuscatedName("x")
   public String field3870;
   @ObfuscatedName("y")
   public String field3869;
   @ObfuscatedName("a")
   public byte field3865;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -2058371485
   )
   public int field3871;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1041941277
   )
   int field3872;

   @ObfuscatedSignature(
      signature = "(Llh;Lkn;)V"
   )
   public ClanMemberManager(JagexLoginType var1, class302 var2) {
      super(100);
      this.field3870 = null;
      this.field3869 = null;
      this.field3872 = 1;
      this.field3866 = var1;
      this.field3867 = var2;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)Lku;",
      garbageValue = "52"
   )
   Nameable vmethod5454() {
      return new ClanMember();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)[Lku;",
      garbageValue = "1474922336"
   )
   Nameable[] vmethod5462(int var1) {
      return new ClanMember[var1];
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "2019694273"
   )
   final void method5481(String var1) {
      this.field3870 = class290.method5208(var1);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-166998516"
   )
   final void method5457(String var1) {
      this.field3869 = class290.method5208(var1);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lgc;I)V",
      garbageValue = "-521243063"
   )
   public final void method5469(Buffer var1) {
      this.method5457(var1.readString());
      long var2 = var1.readLong();
      long var5 = var2;
      String var4;
      int var7;
      if(var2 > 0L && var2 < 6582952005840035281L) {
         if(var2 % 37L == 0L) {
            var4 = null;
         } else {
            var7 = 0;

            for(long var13 = var2; 0L != var13; var13 /= 37L) {
               ++var7;
            }

            StringBuilder var15 = new StringBuilder(var7);

            while(var5 != 0L) {
               long var11 = var5;
               var5 /= 37L;
               var15.append(class316.field3924[(int)(var11 - var5 * 37L)]);
            }

            var4 = var15.reverse().toString();
         }
      } else {
         var4 = null;
      }

      this.method5481(var4);
      this.field3865 = var1.readByte();
      var7 = var1.readUnsignedByte();
      if(var7 != 255) {
         this.method5302();

         for(int var8 = 0; var8 < var7; ++var8) {
            ClanMember var9 = (ClanMember)this.method5312(new Name(var1.readString(), this.field3866));
            int var10 = var1.readUnsignedShort();
            var9.method5389(var10, ++this.field3872 - 1);
            var9.rank = var1.readByte();
            var1.readString();
            this.method5470(var9);
         }

      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lgc;I)V",
      garbageValue = "488922628"
   )
   public final void method5459(Buffer var1) {
      Name var2 = new Name(var1.readString(), this.field3866);
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

         var6 = (ClanMember)this.method5327(var2);
         if(var6 != null && var6.method5390() == var3) {
            this.method5311(var6);
         }
      } else {
         var1.readString();
         var6 = (ClanMember)this.method5327(var2);
         if(var6 == null) {
            if(this.getCount() > super.field3838) {
               return;
            }

            var6 = (ClanMember)this.method5312(var2);
         }

         var6.method5389(var3, ++this.field3872 - 1);
         var6.rank = var4;
         this.method5470(var6);
      }

   }

   @ObfuscatedName("cm")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1227336595"
   )
   public final void method5460() {
      for(int var1 = 0; var1 < this.getCount(); ++var1) {
         ((ClanMember)this.get(var1)).method5247();
      }

   }

   @ObfuscatedName("cw")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1475497438"
   )
   public final void method5461() {
      for(int var1 = 0; var1 < this.getCount(); ++var1) {
         ((ClanMember)this.get(var1)).method5258();
      }

   }

   @ObfuscatedName("ci")
   @ObfuscatedSignature(
      signature = "(Lkg;I)V",
      garbageValue = "1605565571"
   )
   final void method5470(ClanMember var1) {
      if(var1.method5271().equals(this.field3867.vmethod5404())) {
         this.field3871 = var1.rank;
      }

   }
}
