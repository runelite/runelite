import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ji")
@Implements("ClanMemberManager")
public class ClanMemberManager extends NameableContainer {
   @ObfuscatedName("ea")
   @ObfuscatedGetter(
      intValue = -1481587515
   )
   @Export("baseX")
   static int baseX;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lld;"
   )
   final JagexLoginType field3729;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Ljz;"
   )
   final class277 field3730;
   @ObfuscatedName("z")
   public String field3731;
   @ObfuscatedName("k")
   public String field3732;
   @ObfuscatedName("c")
   public byte field3737;
   @ObfuscatedName("o")
   public byte field3733;

   @ObfuscatedSignature(
      signature = "(Lld;Ljz;)V"
   )
   public ClanMemberManager(JagexLoginType var1, class277 var2) {
      super(100);
      this.field3731 = null;
      this.field3732 = null;
      this.field3729 = var1;
      this.field3730 = var2;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)Ljq;",
      garbageValue = "-1161467535"
   )
   Nameable vmethod5308() {
      return new ClanMember();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)[Ljq;",
      garbageValue = "-1191416525"
   )
   Nameable[] vmethod5331(int var1) {
      return new ClanMember[var1];
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "3"
   )
   final void method5305(String var1) {
      this.field3731 = class288.method5457(var1);
   }

   @ObfuscatedName("cx")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "469186545"
   )
   final void method5334(String var1) {
      this.field3732 = class288.method5457(var1);
   }

   @ObfuscatedName("ck")
   @ObfuscatedSignature(
      signature = "(Lgy;B)V",
      garbageValue = "58"
   )
   public final void method5307(Buffer var1) {
      this.method5334(var1.readString());
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

            StringBuilder var10 = new StringBuilder(var7);

            while(0L != var5) {
               long var11 = var5;
               var5 /= 37L;
               var10.append(class291.field3791[(int)(var11 - 37L * var5)]);
            }

            var4 = var10.reverse().toString();
         }
      } else {
         var4 = null;
      }

      this.method5305(var4);
      this.field3737 = var1.readByte();
      var7 = var1.readUnsignedByte();
      if(var7 != 255) {
         this.method5245();

         for(int var8 = 0; var8 < var7; ++var8) {
            ClanMember var9 = (ClanMember)this.method5177(new Name(var1.readString(), this.field3729));
            var9.world = var1.readUnsignedShort();
            var9.rank = var1.readByte();
            var1.readString();
            this.method5311(var9);
         }

      }
   }

   @ObfuscatedName("cb")
   @ObfuscatedSignature(
      signature = "(Lgy;I)V",
      garbageValue = "-1658303149"
   )
   public final void method5306(Buffer var1) {
      Name var2 = new Name(var1.readString(), this.field3729);
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

         var6 = (ClanMember)this.method5173(var2);
         if(var6 != null && var3 == var6.world) {
            this.method5176(var6);
         }
      } else {
         var1.readString();
         var6 = (ClanMember)this.method5171(var2);
         if(var6 == null) {
            if(this.getCount() > super.field3707) {
               return;
            }

            var6 = (ClanMember)this.method5177(var2);
         }

         var6.world = var3;
         var6.rank = var4;
         this.method5311(var6);
      }

   }

   @ObfuscatedName("cm")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2018736750"
   )
   public final void method5309() {
      for(int var1 = 0; var1 < this.getCount(); ++var1) {
         ((ClanMember)this.get(var1)).method5117();
      }

   }

   @ObfuscatedName("cu")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "6"
   )
   public final void method5303() {
      for(int var1 = 0; var1 < this.getCount(); ++var1) {
         ((ClanMember)this.get(var1)).method5115();
      }

   }

   @ObfuscatedName("cf")
   @ObfuscatedSignature(
      signature = "(Ljn;B)V",
      garbageValue = "99"
   )
   final void method5311(ClanMember var1) {
      if(var1.method5136().equals(this.field3730.vmethod5253())) {
         this.field3733 = var1.rank;
      }

   }
}
