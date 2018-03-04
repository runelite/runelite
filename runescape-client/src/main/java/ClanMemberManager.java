import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kd")
@Implements("ClanMemberManager")
public class ClanMemberManager extends NameableContainer {
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Llt;"
   )
   final JagexLoginType field3859;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lkf;"
   )
   final class302 field3857;
   @ObfuscatedName("x")
   public String field3858;
   @ObfuscatedName("m")
   public String field3856;
   @ObfuscatedName("h")
   public byte field3860;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1729019
   )
   public int field3861;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1738706673
   )
   int field3862;

   @ObfuscatedSignature(
      signature = "(Llt;Lkf;)V"
   )
   public ClanMemberManager(JagexLoginType var1, class302 var2) {
      super(100);
      this.field3858 = null;
      this.field3856 = null;
      this.field3862 = 1;
      this.field3859 = var1;
      this.field3857 = var2;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Lkm;",
      garbageValue = "-2116343302"
   )
   Nameable vmethod5562() {
      return new ClanMember();
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)[Lkm;",
      garbageValue = "164976155"
   )
   Nameable[] vmethod5575(int var1) {
      return new ClanMember[var1];
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "0"
   )
   final void method5563(String var1) {
      String var3 = class62.method1058(WorldMapType3.method193(var1));
      if(var3 == null) {
         var3 = "";
      }

      this.field3858 = var3;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "-125"
   )
   final void method5564(String var1) {
      String var3 = class62.method1058(WorldMapType3.method193(var1));
      if(var3 == null) {
         var3 = "";
      }

      this.field3856 = var3;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lgy;I)V",
      garbageValue = "630564576"
   )
   public final void method5581(Buffer var1) {
      this.method5564(var1.readString());
      long var2 = var1.readLong();
      long var5 = var2;
      String var4;
      int var7;
      if(var2 > 0L && var2 < 6582952005840035281L) {
         if(var2 % 37L == 0L) {
            var4 = null;
         } else {
            var7 = 0;

            for(long var13 = var2; var13 != 0L; var13 /= 37L) {
               ++var7;
            }

            StringBuilder var15 = new StringBuilder(var7);

            while(0L != var5) {
               long var11 = var5;
               var5 /= 37L;
               var15.append(class316.field3914[(int)(var11 - var5 * 37L)]);
            }

            var4 = var15.reverse().toString();
         }
      } else {
         var4 = null;
      }

      this.method5563(var4);
      this.field3860 = var1.readByte();
      var7 = var1.readUnsignedByte();
      if(var7 != 255) {
         this.method5409();

         for(int var8 = 0; var8 < var7; ++var8) {
            ClanMember var9 = (ClanMember)this.method5451(new Name(var1.readString(), this.field3859));
            int var10 = var1.readUnsignedShort();
            var9.method5508(var10, ++this.field3862 - 1);
            var9.rank = var1.readByte();
            var1.readString();
            this.method5569(var9);
         }

      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lgy;I)V",
      garbageValue = "-1165092424"
   )
   public final void method5566(Buffer var1) {
      Name var2 = new Name(var1.readString(), this.field3859);
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

         var6 = (ClanMember)this.method5414(var2);
         if(var6 != null && var6.method5502() == var3) {
            this.method5417(var6);
         }
      } else {
         var1.readString();
         var6 = (ClanMember)this.method5452(var2);
         if(var6 == null) {
            if(this.getCount() > super.field3834) {
               return;
            }

            var6 = (ClanMember)this.method5451(var2);
         }

         var6.method5508(var3, ++this.field3862 - 1);
         var6.rank = var4;
         this.method5569(var6);
      }

   }

   @ObfuscatedName("cp")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "27"
   )
   public final void method5565() {
      for(int var1 = 0; var1 < this.getCount(); ++var1) {
         ((ClanMember)this.get(var1)).method5345();
      }

   }

   @ObfuscatedName("ch")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-420063761"
   )
   public final void method5568() {
      for(int var1 = 0; var1 < this.getCount(); ++var1) {
         ((ClanMember)this.get(var1)).method5344();
      }

   }

   @ObfuscatedName("cr")
   @ObfuscatedSignature(
      signature = "(Lku;I)V",
      garbageValue = "-838008776"
   )
   final void method5569(ClanMember var1) {
      if(var1.method5385().equals(this.field3857.vmethod5510())) {
         this.field3861 = var1.rank;
      }

   }
}
