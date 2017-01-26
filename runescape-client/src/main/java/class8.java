import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("o")
public class class8 {
   @ObfuscatedName("bj")
   static class184 field74;
   @ObfuscatedName("qj")
   @ObfuscatedGetter(
      intValue = 1985779085
   )
   protected static int field75;
   @ObfuscatedName("c")
   static Widget field76;
   @ObfuscatedName("d")
   public static class182 field77;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-283927102"
   )
   public static int method114(int var0) {
      Varbit var2 = (Varbit)Varbit.field2845.get((long)var0);
      Varbit var1;
      if(null != var2) {
         var1 = var2;
      } else {
         byte[] var3 = class44.field892.getConfigData(14, var0);
         var2 = new Varbit();
         if(null != var3) {
            var2.method3528(new Buffer(var3));
         }

         Varbit.field2845.put(var2, (long)var0);
         var1 = var2;
      }

      int var7 = var1.leastSignificantBit;
      int var4 = var1.configId;
      int var5 = var1.mostSignificantBit;
      int var6 = class165.field2162[var5 - var4];
      return class165.widgetSettings[var7] >> var4 & var6;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(LModIcon;I)V",
      garbageValue = "68755294"
   )
   static final void method115(ModIcon var0) {
      short var1 = 256;

      int var2;
      for(var2 = 0; var2 < CollisionData.field1841.length; ++var2) {
         CollisionData.field1841[var2] = 0;
      }

      int var3;
      for(var2 = 0; var2 < 5000; ++var2) {
         var3 = (int)(Math.random() * 128.0D * (double)var1);
         CollisionData.field1841[var3] = (int)(Math.random() * 256.0D);
      }

      int var4;
      int var5;
      for(var2 = 0; var2 < 20; ++var2) {
         for(var3 = 1; var3 < var1 - 1; ++var3) {
            for(var4 = 1; var4 < 127; ++var4) {
               var5 = var4 + (var3 << 7);
               FileOnDisk.field1191[var5] = (CollisionData.field1841[var5 + 1] + CollisionData.field1841[var5 - 1] + CollisionData.field1841[var5 - 128] + CollisionData.field1841[128 + var5]) / 4;
            }
         }

         int[] var8 = CollisionData.field1841;
         CollisionData.field1841 = FileOnDisk.field1191;
         FileOnDisk.field1191 = var8;
      }

      if(var0 != null) {
         var2 = 0;

         for(var3 = 0; var3 < var0.height; ++var3) {
            for(var4 = 0; var4 < var0.originalWidth; ++var4) {
               if(var0.pixels[var2++] != 0) {
                  var5 = var0.offsetX + 16 + var4;
                  int var6 = var3 + 16 + var0.offsetY;
                  int var7 = (var6 << 7) + var5;
                  CollisionData.field1841[var7] = 0;
               }
            }
         }
      }

   }

   class8() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lclass182;Ljava/lang/String;Ljava/lang/String;I)[LModIcon;",
      garbageValue = "1561932551"
   )
   public static ModIcon[] method116(class182 var0, String var1, String var2) {
      int var3 = var0.method3276(var1);
      int var4 = var0.method3287(var3, var2);
      return Overlay.method3745(var0, var3, var4);
   }
}
