import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("az")
public class class40 {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Laz;"
   )
   public static final class40 field535;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Laz;"
   )
   public static final class40 field528;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Laz;"
   )
   public static final class40 field533;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Laz;"
   )
   public static final class40 field529;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Laz;"
   )
   public static final class40 field531;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -829465441
   )
   static int field527;
   @ObfuscatedName("e")
   public final String field532;

   static {
      field535 = new class40("details");
      field528 = new class40("compositemap");
      field529 = new class40("compositetexture");
      field533 = new class40("area");
      field531 = new class40("labels");
   }

   class40(String var1) {
      this.field532 = var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-611074859"
   )
   static final void method552() {
      short var0 = 256;
      int var1;
      if(class92.field1447 > 0) {
         for(var1 = 0; var1 < 256; ++var1) {
            if(class92.field1447 > 768) {
               class92.field1445[var1] = class140.method2854(class92.field1424[var1], class73.field864[var1], 1024 - class92.field1447);
            } else if(class92.field1447 > 256) {
               class92.field1445[var1] = class73.field864[var1];
            } else {
               class92.field1445[var1] = class140.method2854(class73.field864[var1], class92.field1424[var1], 256 - class92.field1447);
            }
         }
      } else if(class92.field1422 > 0) {
         for(var1 = 0; var1 < 256; ++var1) {
            if(class92.field1422 > 768) {
               class92.field1445[var1] = class140.method2854(class92.field1424[var1], World.field1287[var1], 1024 - class92.field1422);
            } else if(class92.field1422 > 256) {
               class92.field1445[var1] = World.field1287[var1];
            } else {
               class92.field1445[var1] = class140.method2854(World.field1287[var1], class92.field1424[var1], 256 - class92.field1422);
            }
         }
      } else {
         for(var1 = 0; var1 < 256; ++var1) {
            class92.field1445[var1] = class92.field1424[var1];
         }
      }

      Rasterizer2D.setDrawRegion(class92.field1436, 9, class92.field1436 + 128, var0 + 7);
      XItemContainer.field781.method4981(class92.field1436, 0);
      Rasterizer2D.noClip();
      var1 = 0;
      int var2 = GZipDecompressor.field2327.width * 9 + class92.field1436;

      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var9;
      int var10;
      for(var3 = 1; var3 < var0 - 1; ++var3) {
         var4 = class92.field1444[var3] * (var0 - var3) / var0;
         var5 = var4 + 22;
         if(var5 < 0) {
            var5 = 0;
         }

         var1 += var5;

         for(var6 = var5; var6 < 128; ++var6) {
            var7 = class168.field2340[var1++];
            if(var7 != 0) {
               var8 = var7;
               var9 = 256 - var7;
               var7 = class92.field1445[var7];
               var10 = GZipDecompressor.field2327.pixels[var2];
               GZipDecompressor.field2327.pixels[var2++] = (var8 * (var7 & '\uff00') + var9 * (var10 & '\uff00') & 16711680) + ((var7 & 16711935) * var8 + var9 * (var10 & 16711935) & -16711936) >> 8;
            } else {
               ++var2;
            }
         }

         var2 += var5 + GZipDecompressor.field2327.width - 128;
      }

      Rasterizer2D.setDrawRegion(class92.field1436 + 765 - 128, 9, class92.field1436 + 765, var0 + 7);
      class8.field245.method4981(class92.field1436 + 382, 0);
      Rasterizer2D.noClip();
      var1 = 0;
      var2 = 24 + GZipDecompressor.field2327.width * 9 + 637 + class92.field1436;

      for(var3 = 1; var3 < var0 - 1; ++var3) {
         var4 = class92.field1444[var3] * (var0 - var3) / var0;
         var5 = 103 - var4;
         var2 += var4;

         for(var6 = 0; var6 < var5; ++var6) {
            var7 = class168.field2340[var1++];
            if(var7 != 0) {
               var8 = var7;
               var9 = 256 - var7;
               var7 = class92.field1445[var7];
               var10 = GZipDecompressor.field2327.pixels[var2];
               GZipDecompressor.field2327.pixels[var2++] = (var8 * (var7 & '\uff00') + var9 * (var10 & '\uff00') & 16711680) + (var8 * (var7 & 16711935) + var9 * (var10 & 16711935) & -16711936) >> 8;
            } else {
               ++var2;
            }
         }

         var1 += 128 - var5;
         var2 += GZipDecompressor.field2327.width - var5 - var4;
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "([BB)Ljava/lang/String;",
      garbageValue = "12"
   )
   public static String method551(byte[] var0) {
      int var2 = var0.length;
      StringBuilder var3 = new StringBuilder();

      for(int var4 = 0; var4 < var2 + 0; var4 += 3) {
         int var5 = var0[var4] & 255;
         var3.append(class269.field3674[var5 >>> 2]);
         if(var4 < var2 - 1) {
            int var6 = var0[var4 + 1] & 255;
            var3.append(class269.field3674[(var5 & 3) << 4 | var6 >>> 4]);
            if(var4 < var2 - 2) {
               int var7 = var0[var4 + 2] & 255;
               var3.append(class269.field3674[(var6 & 15) << 2 | var7 >>> 6]).append(class269.field3674[var7 & 63]);
            } else {
               var3.append(class269.field3674[(var6 & 15) << 2]).append("=");
            }
         } else {
            var3.append(class269.field3674[(var5 & 3) << 4]).append("==");
         }
      }

      String var1 = var3.toString();
      return var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1622096992"
   )
   static int method550(int var0) {
      MessageNode var1 = (MessageNode)class98.field1520.method3482((long)var0);
      return var1 == null?-1:(var1.previous == class98.field1526.field2484?-1:((MessageNode)var1.previous).id);
   }
}
