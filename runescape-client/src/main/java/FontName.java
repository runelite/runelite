import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kq")
@Implements("FontName")
public class FontName {
   @ObfuscatedName("pd")
   @ObfuscatedSignature(
      signature = "Lca;"
   )
   static class100 field3884;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lkq;"
   )
   @Export("FontName_plain11")
   public static final FontName FontName_plain11;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lkq;"
   )
   @Export("FontName_plain12")
   public static final FontName FontName_plain12;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lkq;"
   )
   @Export("FontName_bold12")
   public static final FontName FontName_bold12;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lkq;"
   )
   public static final FontName field3878;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lkq;"
   )
   public static final FontName field3877;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lkq;"
   )
   public static final FontName field3880;
   @ObfuscatedName("dj")
   @ObfuscatedSignature(
      signature = "Lju;"
   )
   @Export("vorbisIndex")
   static IndexData vorbisIndex;
   @ObfuscatedName("e")
   final String field3881;
   @ObfuscatedName("x")
   String field3882;

   static {
      FontName_plain11 = new FontName("PLAIN11", "p11_full");
      FontName_plain12 = new FontName("PLAIN12", "p12_full");
      FontName_bold12 = new FontName("BOLD12", "b12_full");
      field3878 = new FontName("VERDANA11", "verdana_11pt_regular");
      field3877 = new FontName("VERDANA13", "verdana_13pt_regular");
      field3880 = new FontName("VERDANA15", "verdana_15pt_regular");
   }

   FontName(String var1, String var2) {
      this.field3881 = var1;
      this.field3882 = var2;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)[Lkq;",
      garbageValue = "-799510143"
   )
   public static FontName[] method5477() {
      return new FontName[]{field3878, FontName_plain12, FontName_plain11, field3880, field3877, FontName_bold12};
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1498899398"
   )
   public static boolean method5475() {
      try {
         if(class229.field2674 == 2) {
            if(class178.field2258 == null) {
               class178.field2258 = Track1.getMusicFile(class229.field2672, class171.field2199, class229.field2676);
               if(class178.field2258 == null) {
                  return false;
               }
            }

            if(class270.field3481 == null) {
               class270.field3481 = new class110(class229.field2675, class243.field2953);
            }

            if(class229.field2673.method4286(class178.field2258, WorldComparator.field258, class270.field3481, 22050)) {
               class229.field2673.method4169();
               class229.field2673.method4220(class229.field2677);
               class229.field2673.method4171(class178.field2258, class85.field1294);
               class229.field2674 = 0;
               class178.field2258 = null;
               class270.field3481 = null;
               class229.field2672 = null;
               return true;
            }
         }
      } catch (Exception var1) {
         var1.printStackTrace();
         class229.field2673.method4172();
         class229.field2674 = 0;
         class178.field2258 = null;
         class270.field3481 = null;
         class229.field2672 = null;
      }

      return false;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)[Lla;",
      garbageValue = "-670039635"
   )
   static SpritePixels[] method5478() {
      SpritePixels[] var0 = new SpritePixels[class332.field3997];

      for(int var1 = 0; var1 < class332.field3997; ++var1) {
         SpritePixels var2 = var0[var1] = new SpritePixels();
         var2.maxWidth = class332.field3995;
         var2.maxHeight = class332.field3996;
         var2.offsetX = class90.field1360[var1];
         var2.offsetY = class153.offsetsY[var1];
         var2.width = class332.field3998[var1];
         var2.height = GrandExchangeOffer.field294[var1];
         int var3 = var2.height * var2.width;
         byte[] var4 = ClassInfo.spritePixels[var1];
         var2.pixels = new int[var3];

         for(int var5 = 0; var5 < var3; ++var5) {
            var2.pixels[var5] = class332.field3994[var4[var5] & 255];
         }
      }

      class316.method5605();
      return var0;
   }

   @ObfuscatedName("ix")
   @ObfuscatedSignature(
      signature = "(IIIIIIIII)V",
      garbageValue = "-1131311737"
   )
   static final void method5473(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(Script.loadWidget(var0)) {
         class2.field14 = null;
         FileRequest.gameDraw(Widget.widgets[var0], -1, var1, var2, var3, var4, var5, var6, var7);
         if(class2.field14 != null) {
            FileRequest.gameDraw(class2.field14, -1412584499, var1, var2, var3, var4, ItemContainer.field746, WorldComparator.field262, var7);
            class2.field14 = null;
         }

      } else {
         if(var7 != -1) {
            Client.field1051[var7] = true;
         } else {
            for(int var8 = 0; var8 < 100; ++var8) {
               Client.field1051[var8] = true;
            }
         }

      }
   }
}
