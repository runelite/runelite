import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("b")
final class class18 implements Comparator {
   @ObfuscatedName("or")
   @ObfuscatedGetter(
      intValue = -2073049581
   )
   static int field311;
   @ObfuscatedName("ew")
   @ObfuscatedGetter(
      longValue = -631187971797647441L
   )
   static long field310;
   @ObfuscatedName("jx")
   @ObfuscatedGetter(
      intValue = 907859597
   )
   @Export("selectedItemIndex")
   static int selectedItemIndex;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lq;Lq;I)I",
      garbageValue = "-980781848"
   )
   int method135(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      return var1.method79().compareTo(var2.method79());
   }

   public int compare(Object var1, Object var2) {
      return this.method135((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lkh;B)V",
      garbageValue = "-33"
   )
   static final void method143(IndexedSprite var0) {
      short var1 = 256;

      int var2;
      for(var2 = 0; var2 < class43.field547.length; ++var2) {
         class43.field547[var2] = 0;
      }

      int var3;
      for(var2 = 0; var2 < 5000; ++var2) {
         var3 = (int)(Math.random() * 128.0D * (double)var1);
         class43.field547[var3] = (int)(Math.random() * 256.0D);
      }

      int var4;
      int var5;
      for(var2 = 0; var2 < 20; ++var2) {
         for(var3 = 1; var3 < var1 - 1; ++var3) {
            for(var4 = 1; var4 < 127; ++var4) {
               var5 = var4 + (var3 << 7);
               OwnWorldComparator.field834[var5] = (class43.field547[var5 + 128] + class43.field547[var5 - 128] + class43.field547[var5 + 1] + class43.field547[var5 - 1]) / 4;
            }
         }

         int[] var8 = class43.field547;
         class43.field547 = OwnWorldComparator.field834;
         OwnWorldComparator.field834 = var8;
      }

      if(var0 != null) {
         var2 = 0;

         for(var3 = 0; var3 < var0.height; ++var3) {
            for(var4 = 0; var4 < var0.originalWidth; ++var4) {
               if(var0.pixels[var2++] != 0) {
                  var5 = var4 + var0.offsetX + 16;
                  int var6 = var3 + var0.offsetY + 16;
                  int var7 = var5 + (var6 << 7);
                  class43.field547[var7] = 0;
               }
            }
         }
      }

   }
}
