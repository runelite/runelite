import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gh")
@Implements("Overlay")
public class Overlay extends CacheableNode {
   @ObfuscatedName("i")
   static NodeCache field3042 = new NodeCache(64);
   @ObfuscatedName("r")
   @Export("isHidden")
   public boolean isHidden = true;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1702683879
   )
   public int field3044 = -1;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1841010593
   )
   @Export("texture")
   public int texture = -1;
   @ObfuscatedName("f")
   public static IndexDataBase field3047;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1691153859
   )
   @Export("hue")
   public int hue;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -929857147
   )
   @Export("saturation")
   public int saturation;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1281335121
   )
   @Export("color")
   public int color = 0;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -2520271
   )
   public int field3051;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -177991853
   )
   public int field3052;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1806577607
   )
   public int field3053;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1010647321
   )
   @Export("lightness")
   public int lightness;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "1087496335"
   )
   void method3761(Buffer var1, int var2) {
      while(true) {
         int var3 = var1.readUnsignedByte();
         if(var3 == 0) {
            return;
         }

         this.method3764(var1, var3, var2);
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(LBuffer;III)V",
      garbageValue = "371335550"
   )
   void method3764(Buffer var1, int var2, int var3) {
      if(var2 == 1) {
         this.color = var1.read24BitInt();
      } else if(var2 == 2) {
         this.texture = var1.readUnsignedByte();
      } else if(var2 == 5) {
         this.isHidden = false;
      } else if(var2 == 7) {
         this.field3044 = var1.read24BitInt();
      } else if(var2 == 8) {
         ;
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-459218596"
   )
   void method3765(int var1) {
      double var2 = (double)(var1 >> 16 & 255) / 256.0D;
      double var4 = (double)(var1 >> 8 & 255) / 256.0D;
      double var6 = (double)(var1 & 255) / 256.0D;
      double var8 = var2;
      if(var4 < var2) {
         var8 = var4;
      }

      if(var6 < var8) {
         var8 = var6;
      }

      double var10 = var2;
      if(var4 > var2) {
         var10 = var4;
      }

      if(var6 > var10) {
         var10 = var6;
      }

      double var12 = 0.0D;
      double var14 = 0.0D;
      double var16 = (var10 + var8) / 2.0D;
      if(var8 != var10) {
         if(var16 < 0.5D) {
            var14 = (var10 - var8) / (var10 + var8);
         }

         if(var16 >= 0.5D) {
            var14 = (var10 - var8) / (2.0D - var10 - var8);
         }

         if(var2 == var10) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if(var4 == var10) {
            var12 = (var6 - var2) / (var10 - var8) + 2.0D;
         } else if(var10 == var6) {
            var12 = 4.0D + (var2 - var4) / (var10 - var8);
         }
      }

      var12 /= 6.0D;
      this.hue = (int)(256.0D * var12);
      this.saturation = (int)(256.0D * var14);
      this.lightness = (int)(256.0D * var16);
      if(this.saturation < 0) {
         this.saturation = 0;
      } else if(this.saturation > 255) {
         this.saturation = 255;
      }

      if(this.lightness < 0) {
         this.lightness = 0;
      } else if(this.lightness > 255) {
         this.lightness = 255;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1894049827"
   )
   void method3770() {
      if(this.field3044 != -1) {
         this.method3765(this.field3044);
         this.field3051 = this.hue;
         this.field3052 = this.saturation;
         this.field3053 = this.lightness;
      }

      this.method3765(this.color);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-580079244"
   )
   static final int method3784(int var0, int var1) {
      int var2 = class217.method3987('넵' + var0, 91923 + var1, 4) - 128 + (class217.method3987(var0 + 10294, var1 + '鎽', 2) - 128 >> 1) + (class217.method3987(var0, var1, 1) - 128 >> 2);
      var2 = 35 + (int)((double)var2 * 0.3D);
      if(var2 < 10) {
         var2 = 10;
      } else if(var2 > 60) {
         var2 = 60;
      }

      return var2;
   }
}
