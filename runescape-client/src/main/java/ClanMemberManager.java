import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ki")
@Implements("ClanMemberManager")
public class ClanMemberManager extends NameableContainer {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Llo;"
   )
   final JagexLoginType field3861;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lkc;"
   )
   final class302 field3858;
   @ObfuscatedName("r")
   public String field3857;
   @ObfuscatedName("d")
   public String field3856;
   @ObfuscatedName("a")
   public byte field3860;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1870307021
   )
   public int field3862;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1307901435
   )
   int field3863;

   @ObfuscatedSignature(
      signature = "(Llo;Lkc;)V"
   )
   public ClanMemberManager(JagexLoginType var1, class302 var2) {
      super(100);
      this.field3857 = null;
      this.field3856 = null;
      this.field3863 = 1;
      this.field3861 = var1;
      this.field3858 = var2;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Lku;",
      garbageValue = "437342171"
   )
   Nameable vmethod5462() {
      return new ClanMember();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)[Lku;",
      garbageValue = "-1281183690"
   )
   Nameable[] vmethod5463(int var1) {
      return new ClanMember[var1];
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-490804797"
   )
   final void method5464(String var1) {
      this.field3857 = class149.method3123(var1);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-467536568"
   )
   final void method5465(String var1) {
      this.field3856 = class149.method3123(var1);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lgp;S)V",
      garbageValue = "334"
   )
   public final void method5492(Buffer var1) {
      this.method5465(var1.readString());
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

            while(0L != var5) {
               long var11 = var5;
               var5 /= 37L;
               var15.append(class316.field3922[(int)(var11 - var5 * 37L)]);
            }

            var4 = var15.reverse().toString();
         }
      } else {
         var4 = null;
      }

      this.method5464(var4);
      this.field3860 = var1.readByte();
      var7 = var1.readUnsignedByte();
      if(var7 != 255) {
         this.method5351();

         for(int var8 = 0; var8 < var7; ++var8) {
            ClanMember var9 = (ClanMember)this.method5322(new Name(var1.readString(), this.field3861));
            int var10 = var1.readUnsignedShort();
            var9.method5395(var10, ++this.field3863 - 1);
            var9.rank = var1.readByte();
            var1.readString();
            this.method5466(var9);
         }

      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lgp;I)V",
      garbageValue = "-605643198"
   )
   public final void method5490(Buffer var1) {
      Name var2 = new Name(var1.readString(), this.field3861);
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

         var6 = (ClanMember)this.method5319(var2);
         if(var6 != null && var6.method5400() == var3) {
            this.method5321(var6);
         }
      } else {
         var1.readString();
         var6 = (ClanMember)this.method5319(var2);
         if(var6 == null) {
            if(this.getCount() > super.field3833) {
               return;
            }

            var6 = (ClanMember)this.method5322(var2);
         }

         var6.method5395(var3, ++this.field3863 - 1);
         var6.rank = var4;
         this.method5466(var6);
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1582483967"
   )
   public final void method5468() {
      for(int var1 = 0; var1 < this.getCount(); ++var1) {
         ((ClanMember)this.get(var1)).method5236();
      }

   }

   @ObfuscatedName("cc")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "995253645"
   )
   public final void method5469() {
      for(int var1 = 0; var1 < this.getCount(); ++var1) {
         ((ClanMember)this.get(var1)).method5239();
      }

   }

   @ObfuscatedName("cg")
   @ObfuscatedSignature(
      signature = "(Lkg;I)V",
      garbageValue = "1201553057"
   )
   final void method5466(ClanMember var1) {
      if(var1.method5260().equals(this.field3858.vmethod5410())) {
         this.field3862 = var1.rank;
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Llo;I)I",
      garbageValue = "-983963280"
   )
   public static final int method5491(JagexLoginType var0) {
      if(var0 == null) {
         return 12;
      } else {
         switch(var0.field4070) {
         case 7:
            return 20;
         default:
            return 12;
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-119"
   )
   static void method5483() {
      if(class90.field1345) {
         class90.field1339 = null;
         class203.field2605 = null;
         class90.runeSprites = null;
         class317.field3926 = null;
         class61.field715 = null;
         class90.logoSprite = null;
         class38.titlemuteSprite = null;
         TextureProvider.field1691 = null;
         class151.field2127 = null;
         class25.field356 = null;
         class90.slFlagSprites = null;
         AbstractSoundSystem.slArrowSprites = null;
         class157.slStarSprites = null;
         Sequence.field3764 = null;
         class38.field489 = null;
         class7.field231 = null;
         class36.field480 = null;
         Item.field1408 = null;
         BaseVarType.field30 = null;
         class5.field34 = null;
         class90.field1362 = null;
         RunException.field2181 = null;
         IndexStoreActionHandler.method4660(2);
         class189.sendConInfo(true);
         class90.field1345 = false;
      }
   }
}
