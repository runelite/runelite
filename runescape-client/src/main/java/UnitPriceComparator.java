import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("j")
@Implements("UnitPriceComparator")
final class UnitPriceComparator implements Comparator {
   @ObfuscatedName("pg")
   @ObfuscatedGetter(
      intValue = 1454003091
   )
   static int field315;
   @ObfuscatedName("cl")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   @Export("indexSprites")
   static IndexData indexSprites;
   @ObfuscatedName("eu")
   @ObfuscatedSignature(
      signature = "Lkh;"
   )
   @Export("fontPlain11")
   static Font fontPlain11;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lp;Lp;B)I",
      garbageValue = "-125"
   )
   int method131(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      return var1.grandExchangeOffer.price < var2.grandExchangeOffer.price?-1:(var2.grandExchangeOffer.price == var1.grandExchangeOffer.price?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method131((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)Liz;",
      garbageValue = "2049074094"
   )
   @Export("getWidget")
   public static Widget getWidget(int var0) {
      int var1 = var0 >> 16;
      int var2 = var0 & 65535;
      if(GZipDecompressor.widgets[var1] == null || GZipDecompressor.widgets[var1][var2] == null) {
         boolean var3 = class85.loadWidget(var1);
         if(!var3) {
            return null;
         }
      }

      return GZipDecompressor.widgets[var1][var2];
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/String;",
      garbageValue = "448580672"
   )
   public static String method138(String var0) {
      int var1 = var0.length();
      char[] var2 = new char[var1];
      byte var3 = 2;

      for(int var4 = 0; var4 < var1; ++var4) {
         char var5 = var0.charAt(var4);
         if(var3 == 0) {
            var5 = Character.toLowerCase(var5);
         } else if(var3 == 2 || Character.isUpperCase(var5)) {
            var5 = Varbit.method4988(var5);
         }

         if(Character.isLetter(var5)) {
            var3 = 0;
         } else if(var5 != '.' && var5 != '?' && var5 != '!') {
            if(Character.isSpaceChar(var5)) {
               if(var3 != 2) {
                  var3 = 1;
               }
            } else {
               var3 = 1;
            }
         } else {
            var3 = 2;
         }

         var2[var4] = var5;
      }

      return new String(var2);
   }

   @ObfuscatedName("jh")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1355239425"
   )
   static final void method142(int var0) {
      if(class85.loadWidget(var0)) {
         FileRequest.method4639(GZipDecompressor.widgets[var0], -1);
      }
   }
}
