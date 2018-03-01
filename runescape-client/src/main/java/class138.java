import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ef")
public class class138 {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Llv;B)V",
      garbageValue = "-31"
   )
   static final void method3120(IndexedSprite var0) {
      short var1 = 256;

      int var2;
      for(var2 = 0; var2 < TotalQuantityComparator.field299.length; ++var2) {
         TotalQuantityComparator.field299[var2] = 0;
      }

      int var3;
      for(var2 = 0; var2 < 5000; ++var2) {
         var3 = (int)(Math.random() * 128.0D * (double)var1);
         TotalQuantityComparator.field299[var3] = (int)(Math.random() * 256.0D);
      }

      int var4;
      int var5;
      for(var2 = 0; var2 < 20; ++var2) {
         for(var3 = 1; var3 < var1 - 1; ++var3) {
            for(var4 = 1; var4 < 127; ++var4) {
               var5 = var4 + (var3 << 7);
               class177.field2277[var5] = (TotalQuantityComparator.field299[var5 + 128] + TotalQuantityComparator.field299[var5 - 128] + TotalQuantityComparator.field299[var5 + 1] + TotalQuantityComparator.field299[var5 - 1]) / 4;
            }
         }

         int[] var8 = TotalQuantityComparator.field299;
         TotalQuantityComparator.field299 = class177.field2277;
         class177.field2277 = var8;
      }

      if(var0 != null) {
         var2 = 0;

         for(var3 = 0; var3 < var0.height; ++var3) {
            for(var4 = 0; var4 < var0.originalWidth; ++var4) {
               if(var0.pixels[var2++] != 0) {
                  var5 = var4 + var0.offsetX + 16;
                  int var6 = var3 + var0.offsetY + 16;
                  int var7 = var5 + (var6 << 7);
                  TotalQuantityComparator.field299[var7] = 0;
               }
            }
         }
      }

   }

   @ObfuscatedName("ga")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1495111114"
   )
   static final void method3119(int var0, int var1, int var2, int var3) {
      if(Client.field978) {
         if(Client.cursorState == 1) {
            class278.crossSprites[Client.field953 / 100].drawAt(Client.lastLeftClickX - 8, Client.lastLeftClickY - 8);
         }

         if(Client.cursorState == 2) {
            class278.crossSprites[Client.field953 / 100 + 4].drawAt(Client.lastLeftClickX - 8, Client.lastLeftClickY - 8);
         }
      }

      class29.method252();
   }
}
