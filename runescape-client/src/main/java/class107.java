import java.io.File;
import java.util.Hashtable;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("de")
public class class107 {
   @ObfuscatedName("i")
   static boolean field1711 = false;
   @ObfuscatedName("g")
   @Export("worldList")
   static World[] worldList;
   @ObfuscatedName("f")
   static Hashtable field1714 = new Hashtable(16);
   @ObfuscatedName("e")
   static File field1717;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1981113178"
   )
   static void method2005(int var0, int var1) {
      long var2 = (long)((var0 << 16) + var1);
      class181 var4 = (class181)class185.field2757.method2311(var2);
      if(var4 != null) {
         class185.field2751.method2259(var4);
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(LModIcon;B)V",
      garbageValue = "0"
   )
   static final void method2007(ModIcon var0) {
      short var1 = 256;

      int var2;
      for(var2 = 0; var2 < XGrandExchangeOffer.field44.length; ++var2) {
         XGrandExchangeOffer.field44[var2] = 0;
      }

      int var3;
      for(var2 = 0; var2 < 5000; ++var2) {
         var3 = (int)(Math.random() * 128.0D * (double)var1);
         XGrandExchangeOffer.field44[var3] = (int)(Math.random() * 256.0D);
      }

      int var4;
      int var5;
      for(var2 = 0; var2 < 20; ++var2) {
         for(var3 = 1; var3 < var1 - 1; ++var3) {
            for(var4 = 1; var4 < 127; ++var4) {
               var5 = var4 + (var3 << 7);
               class230.field3255[var5] = (XGrandExchangeOffer.field44[var5 - 1] + XGrandExchangeOffer.field44[1 + var5] + XGrandExchangeOffer.field44[var5 - 128] + XGrandExchangeOffer.field44[var5 + 128]) / 4;
            }
         }

         int[] var8 = XGrandExchangeOffer.field44;
         XGrandExchangeOffer.field44 = class230.field3255;
         class230.field3255 = var8;
      }

      if(var0 != null) {
         var2 = 0;

         for(var3 = 0; var3 < var0.height; ++var3) {
            for(var4 = 0; var4 < var0.originalWidth; ++var4) {
               if(var0.pixels[var2++] != 0) {
                  var5 = 16 + var4 + var0.offsetX;
                  int var6 = var0.offsetY + 16 + var3;
                  int var7 = (var6 << 7) + var5;
                  XGrandExchangeOffer.field44[var7] = 0;
               }
            }
         }
      }

   }
}
