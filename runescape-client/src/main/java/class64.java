import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bt")
public class class64 {
   @ObfuscatedName("c")
   static int[] field774;
   @ObfuscatedName("cv")
   static IndexData field785;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1994464905
   )
   protected static int field786;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;LIndexDataBase;LIndexDataBase;S)V",
      garbageValue = "-21404"
   )
   public static void method1093(IndexDataBase var0, IndexDataBase var1, IndexDataBase var2) {
      class254.field3409 = var0;
      class254.field3404 = var1;
      Frames.field2126 = var2;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LModIcon;I)V",
      garbageValue = "255371152"
   )
   static final void method1094(ModIcon var0) {
      short var1 = 256;

      int var2;
      for(var2 = 0; var2 < WorldMapType1.field437.length; ++var2) {
         WorldMapType1.field437[var2] = 0;
      }

      int var8;
      for(var2 = 0; var2 < 5000; ++var2) {
         var8 = (int)(Math.random() * 128.0D * (double)var1);
         WorldMapType1.field437[var8] = (int)(Math.random() * 256.0D);
      }

      int var4;
      int var5;
      for(var2 = 0; var2 < 20; ++var2) {
         for(var8 = 1; var8 < var1 - 1; ++var8) {
            for(var4 = 1; var4 < 127; ++var4) {
               var5 = (var8 << 7) + var4;
               Preferences.field1289[var5] = (WorldMapType1.field437[var5 + 128] + WorldMapType1.field437[var5 - 128] + WorldMapType1.field437[var5 - 1] + WorldMapType1.field437[var5 + 1]) / 4;
            }
         }

         int[] var3 = WorldMapType1.field437;
         WorldMapType1.field437 = Preferences.field1289;
         Preferences.field1289 = var3;
      }

      if(var0 != null) {
         var2 = 0;

         for(var8 = 0; var8 < var0.height; ++var8) {
            for(var4 = 0; var4 < var0.originalWidth; ++var4) {
               if(var0.pixels[var2++] != 0) {
                  var5 = var4 + 16 + var0.offsetX;
                  int var6 = var0.offsetY + var8 + 16;
                  int var7 = var5 + (var6 << 7);
                  WorldMapType1.field437[var7] = 0;
               }
            }
         }
      }

   }
}
