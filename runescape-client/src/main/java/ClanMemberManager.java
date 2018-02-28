import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kg")
@Implements("ClanMemberManager")
public class ClanMemberManager extends NameableContainer {
   @ObfuscatedName("ea")
   @ObfuscatedSignature(
      signature = "Lkt;"
   )
   @Export("font_p12full")
   static Font font_p12full;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lld;"
   )
   final JagexLoginType field3741;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lkb;"
   )
   final class288 field3740;
   @ObfuscatedName("c")
   public String field3745;
   @ObfuscatedName("u")
   public String field3742;
   @ObfuscatedName("r")
   public byte field3739;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1465634901
   )
   public int field3744;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 2014947155
   )
   int field3743;

   @ObfuscatedSignature(
      signature = "(Lld;Lkb;)V"
   )
   public ClanMemberManager(JagexLoginType var1, class288 var2) {
      super(100);
      this.field3745 = null;
      this.field3742 = null;
      this.field3743 = 1;
      this.field3741 = var1;
      this.field3740 = var2;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)Ljw;",
      garbageValue = "-258832734"
   )
   Nameable vmethod5393() {
      return new ClanMember();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IB)[Ljw;",
      garbageValue = "-1"
   )
   Nameable[] vmethod5396(int var1) {
      return new ClanMember[var1];
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1582324497"
   )
   final void method5417(String var1) {
      String var3 = MapIconReference.method728(GameObject.method3072(var1));
      if(var3 == null) {
         var3 = "";
      }

      this.field3745 = var3;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-427567209"
   )
   final void method5406(String var1) {
      String var3 = MapIconReference.method728(GameObject.method3072(var1));
      if(var3 == null) {
         var3 = "";
      }

      this.field3742 = var3;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lgn;I)V",
      garbageValue = "247650279"
   )
   public final void method5397(Buffer var1) {
      this.method5406(var1.readString());
      long var2 = var1.readLong();
      long var5 = var2;
      String var4;
      int var7;
      if(var2 > 0L && var2 < 6582952005840035281L) {
         if(0L == var2 % 37L) {
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
               var15.append(class302.field3794[(int)(var11 - var5 * 37L)]);
            }

            var4 = var15.reverse().toString();
         }
      } else {
         var4 = null;
      }

      this.method5417(var4);
      this.field3739 = var1.readByte();
      var7 = var1.readUnsignedByte();
      if(var7 != 255) {
         this.method5230();

         for(int var8 = 0; var8 < var7; ++var8) {
            ClanMember var9 = (ClanMember)this.method5269(new Name(var1.readString(), this.field3741));
            int var10 = var1.readUnsignedShort();
            var9.method5332(var10, ++this.field3743 - 1);
            var9.rank = var1.readByte();
            var1.readString();
            this.method5400(var9);
         }

      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lgn;I)V",
      garbageValue = "-796074079"
   )
   public final void method5424(Buffer var1) {
      Name var2 = new Name(var1.readString(), this.field3741);
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

         var6 = (ClanMember)this.method5235(var2);
         if(var6 != null && var6.method5336() == var3) {
            this.method5238(var6);
         }
      } else {
         var1.readString();
         var6 = (ClanMember)this.method5307(var2);
         if(var6 == null) {
            if(this.getCount() > super.field3709) {
               return;
            }

            var6 = (ClanMember)this.method5269(var2);
         }

         var6.method5332(var3, ++this.field3743 - 1);
         var6.rank = var4;
         this.method5400(var6);
      }

   }

   @ObfuscatedName("ck")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1180374089"
   )
   public final void method5407() {
      for(int var1 = 0; var1 < this.getCount(); ++var1) {
         ((ClanMember)this.get(var1)).method5162();
      }

   }

   @ObfuscatedName("ci")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1452453104"
   )
   public final void method5399() {
      for(int var1 = 0; var1 < this.getCount(); ++var1) {
         ((ClanMember)this.get(var1)).method5165();
      }

   }

   @ObfuscatedName("ch")
   @ObfuscatedSignature(
      signature = "(Ljc;I)V",
      garbageValue = "-2135770863"
   )
   final void method5400(ClanMember var1) {
      if(var1.method5183().equals(this.field3740.vmethod5341())) {
         this.field3744 = var1.rank;
      }

   }
}
