import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("h")
public class class22 extends class28 {
   @ObfuscatedName("ds")
   @Export("host")
   static String host;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lfp;Lfp;B)V",
      garbageValue = "23"
   )
   void method188(Buffer var1, Buffer var2) {
      int var3 = var2.readUnsignedByte();
      if(var3 != class36.field521.field513) {
         throw new IllegalStateException("");
      } else {
         super.field422 = var2.readUnsignedByte();
         super.field419 = var2.readUnsignedByte();
         super.field415 = var2.readUnsignedShort();
         super.field416 = var2.readUnsignedShort();
         super.field414 = var2.readUnsignedShort();
         super.field417 = var2.readUnsignedShort();
         super.field419 = Math.min(super.field419, 4);
         super.field420 = new short[1][64][64];
         super.field418 = new short[super.field419][64][64];
         super.field421 = new byte[super.field419][64][64];
         super.field423 = new byte[super.field419][64][64];
         super.field424 = new class31[super.field419][64][64][];
         var3 = var1.readUnsignedByte();
         if(var3 != class35.field510.field512) {
            throw new IllegalStateException("");
         } else {
            int var4 = var1.readUnsignedByte();
            int var5 = var1.readUnsignedByte();
            if(var4 == super.field414 && var5 == super.field417) {
               for(int var6 = 0; var6 < 64; ++var6) {
                  for(int var7 = 0; var7 < 64; ++var7) {
                     this.method269(var6, var7, var1);
                  }
               }

            } else {
               throw new IllegalStateException("");
            }
         }
      }
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof class22)) {
         return false;
      } else {
         class22 var2 = (class22)var1;
         return var2.field414 == super.field414 && var2.field417 == super.field417;
      }
   }

   public int hashCode() {
      return super.field414 | super.field417 << 8;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-2052249613"
   )
   public static boolean method195(int var0) {
      return var0 >= class222.field2839.field2842 && var0 <= class222.field2840.field2842;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([BIII)Ljava/lang/String;",
      garbageValue = "-1201919137"
   )
   public static String method194(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;
      int var5 = var1;

      int var8;
      for(int var6 = var2 + var1; var5 < var6; var3[var4++] = (char)var8) {
         int var7 = var0[var5++] & 255;
         if(var7 < 128) {
            if(var7 == 0) {
               var8 = '�';
            } else {
               var8 = var7;
            }
         } else if(var7 < 192) {
            var8 = '�';
         } else if(var7 < 224) {
            if(var5 < var6 && (var0[var5] & 192) == 128) {
               var8 = (var7 & 31) << 6 | var0[var5++] & 63;
               if(var8 < 128) {
                  var8 = '�';
               }
            } else {
               var8 = '�';
            }
         } else if(var7 < 240) {
            if(var5 + 1 < var6 && (var0[var5] & 192) == 128 && 128 == (var0[var5 + 1] & 192)) {
               var8 = (var7 & 15) << 12 | (var0[var5++] & 63) << 6 | var0[var5++] & 63;
               if(var8 < 2048) {
                  var8 = '�';
               }
            } else {
               var8 = '�';
            }
         } else if(var7 < 248) {
            if(var5 + 2 < var6 && (var0[var5] & 192) == 128 && (var0[var5 + 1] & 192) == 128 && (var0[var5 + 2] & 192) == 128) {
               var8 = (var7 & 7) << 18 | (var0[var5++] & 63) << 12 | (var0[var5++] & 63) << 6 | var0[var5++] & 63;
               if(var8 >= 65536 && var8 <= 1114111) {
                  var8 = '�';
               } else {
                  var8 = '�';
               }
            } else {
               var8 = '�';
            }
         } else {
            var8 = '�';
         }
      }

      return new String(var3, 0, var4);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([BI)Lkd;",
      garbageValue = "-2106620676"
   )
   public static final SpritePixels method186(byte[] var0) {
      BufferedImage var1 = null;

      try {
         var1 = ImageIO.read(new ByteArrayInputStream(var0));
         int var2 = var1.getWidth();
         int var3 = var1.getHeight();
         int[] var4 = new int[var2 * var3];
         PixelGrabber var5 = new PixelGrabber(var1, 0, 0, var2, var3, var4, 0, var2);
         var5.grabPixels();
         return new SpritePixels(var4, var2, var3);
      } catch (IOException var7) {
         ;
      } catch (InterruptedException var8) {
         ;
      }

      return new SpritePixels(0, 0);
   }
}
