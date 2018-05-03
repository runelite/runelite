import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ki")
@Implements("ClanMemberManager")
public class ClanMemberManager extends NameableContainer {
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lly;"
   )
   final JagexLoginType field3870;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lkx;"
   )
   final class302 field3869;
   @ObfuscatedName("h")
   public String field3872;
   @ObfuscatedName("i")
   public String field3873;
   @ObfuscatedName("o")
   public byte field3874;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1598588801
   )
   public int field3871;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1812803835
   )
   int field3876;

   @ObfuscatedSignature(
      signature = "(Lly;Lkx;)V"
   )
   public ClanMemberManager(JagexLoginType var1, class302 var2) {
      super(100);
      this.field3872 = null;
      this.field3873 = null;
      this.field3876 = 1;
      this.field3870 = var1;
      this.field3869 = var2;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Lkg;",
      garbageValue = "1778408778"
   )
   Nameable vmethod5513() {
      return new ClanMember();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IB)[Lkg;",
      garbageValue = "0"
   )
   Nameable[] vmethod5514(int var1) {
      return new ClanMember[var1];
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1198023022"
   )
   final void method5515(String var1) {
      this.field3872 = OwnWorldComparator.method1264(var1);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;S)V",
      garbageValue = "-16466"
   )
   final void method5517(String var1) {
      this.field3873 = OwnWorldComparator.method1264(var1);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lgg;B)V",
      garbageValue = "-30"
   )
   public final void method5524(Buffer var1) {
      this.method5517(var1.readString());
      long var2 = var1.readLong();
      this.method5515(ScriptState.method1132(var2));
      this.field3874 = var1.readByte();
      int var4 = var1.readUnsignedByte();
      if(var4 != 255) {
         this.method5363();

         for(int var5 = 0; var5 < var4; ++var5) {
            ClanMember var6 = (ClanMember)this.method5371(new Name(var1.readString(), this.field3870));
            int var7 = var1.readUnsignedShort();
            var6.method5454(var7, ++this.field3876 - 1);
            var6.rank = var1.readByte();
            var1.readString();
            this.method5531(var6);
         }

      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lgg;I)V",
      garbageValue = "-637112722"
   )
   public final void method5539(Buffer var1) {
      Name var2 = new Name(var1.readString(), this.field3870);
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

         var6 = (ClanMember)this.method5368(var2);
         if(var6 != null && var6.method5456() == var3) {
            this.method5415(var6);
         }
      } else {
         var1.readString();
         var6 = (ClanMember)this.method5368(var2);
         if(var6 == null) {
            if(this.getCount() > super.field3849) {
               return;
            }

            var6 = (ClanMember)this.method5371(var2);
         }

         var6.method5454(var3, ++this.field3876 - 1);
         var6.rank = var4;
         this.method5531(var6);
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "759225492"
   )
   public final void method5516() {
      for(int var1 = 0; var1 < this.getCount(); ++var1) {
         ((ClanMember)this.get(var1)).method5302();
      }

   }

   @ObfuscatedName("cm")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "85"
   )
   public final void method5519() {
      for(int var1 = 0; var1 < this.getCount(); ++var1) {
         ((ClanMember)this.get(var1)).method5320();
      }

   }

   @ObfuscatedName("cg")
   @ObfuscatedSignature(
      signature = "(Lkd;B)V",
      garbageValue = "-70"
   )
   final void method5531(ClanMember var1) {
      if(var1.method5322().equals(this.field3869.vmethod5463())) {
         this.field3871 = var1.rank;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IZI)Z",
      garbageValue = "410775066"
   )
   public static boolean method5518(CharSequence var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         boolean var3 = false;
         boolean var4 = false;
         int var5 = 0;
         int var6 = var0.length();

         for(int var7 = 0; var7 < var6; ++var7) {
            char var8 = var0.charAt(var7);
            if(var7 == 0) {
               if(var8 == '-') {
                  var3 = true;
                  continue;
               }

               if(var8 == '+') {
                  continue;
               }
            }

            int var10;
            if(var8 >= '0' && var8 <= '9') {
               var10 = var8 - '0';
            } else if(var8 >= 'A' && var8 <= 'Z') {
               var10 = var8 - '7';
            } else {
               if(var8 < 'a' || var8 > 'z') {
                  return false;
               }

               var10 = var8 - 'W';
            }

            if(var10 >= var1) {
               return false;
            }

            if(var3) {
               var10 = -var10;
            }

            int var9 = var5 * var1 + var10;
            if(var9 / var1 != var5) {
               return false;
            }

            var5 = var9;
            var4 = true;
         }

         return var4;
      } else {
         throw new IllegalArgumentException("");
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)[Llh;",
      garbageValue = "-126"
   )
   static IndexedSprite[] method5525() {
      IndexedSprite[] var0 = new IndexedSprite[class332.indexedSpriteCount];

      for(int var1 = 0; var1 < class332.indexedSpriteCount; ++var1) {
         IndexedSprite var2 = var0[var1] = new IndexedSprite();
         var2.originalWidth = class332.indexedSpriteWidth;
         var2.originalHeight = class332.indexedSpriteHeight;
         var2.offsetX = class332.indexedSpriteOffsetXs[var1];
         var2.offsetY = WorldComparator.indexedSpriteOffsetYs[var1];
         var2.width = class332.indexSpriteWidths[var1];
         var2.height = GrandExchangeEvents.indexedSpriteHeights[var1];
         var2.palette = class332.indexedSpritePalette;
         var2.pixels = ChatPlayer.spritePixels[var1];
      }

      class332.indexedSpriteOffsetXs = null;
      WorldComparator.indexedSpriteOffsetYs = null;
      class332.indexSpriteWidths = null;
      GrandExchangeEvents.indexedSpriteHeights = null;
      class332.indexedSpritePalette = null;
      ChatPlayer.spritePixels = null;
      return var0;
   }

   @ObfuscatedName("ko")
   @ObfuscatedSignature(
      signature = "(IIIILlv;Lin;I)V",
      garbageValue = "1984280687"
   )
   @Export("drawDot")
   static final void drawDot(int var0, int var1, int var2, int var3, SpritePixels var4, class236 var5) {
      if(var4 != null) {
         int var6 = Client.mapAngle & 2047;
         int var7 = var3 * var3 + var2 * var2;
         if(var7 <= 6400) {
            int var8 = Graphics3D.SINE[var6];
            int var9 = Graphics3D.COSINE[var6];
            int var10 = var9 * var2 + var3 * var8 >> 16;
            int var11 = var3 * var9 - var8 * var2 >> 16;
            if(var7 > 2500) {
               var4.method5931(var10 + var5.field2780 / 2 - var4.maxWidth / 2, var5.field2782 / 2 - var11 - var4.maxHeight / 2, var0, var1, var5.field2780, var5.field2782, var5.field2779, var5.field2781);
            } else {
               var4.drawAt(var0 + var10 + var5.field2780 / 2 - var4.maxWidth / 2, var5.field2782 / 2 + var1 - var11 - var4.maxHeight / 2);
            }

         }
      }
   }
}
