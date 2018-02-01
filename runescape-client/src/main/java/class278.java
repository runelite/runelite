import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ji")
public class class278 {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   public static final class278 field3690;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   public static final class278 field3691;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   public static final class278 field3692;

   static {
      field3690 = new class278();
      field3691 = new class278();
      field3692 = new class278();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;II[BIB)I",
      garbageValue = "-104"
   )
   @Export("encodeStringCp1252")
   public static int encodeStringCp1252(CharSequence var0, int var1, int var2, byte[] var3, int var4) {
      int var5 = var2 - var1;

      for(int var6 = 0; var6 < var5; ++var6) {
         char var7 = var0.charAt(var6 + var1);
         if(var7 > 0 && var7 < 128 || var7 >= 160 && var7 <= 255) {
            var3[var6 + var4] = (byte)var7;
         } else if(var7 == 8364) {
            var3[var6 + var4] = -128;
         } else if(var7 == 8218) {
            var3[var6 + var4] = -126;
         } else if(var7 == 402) {
            var3[var6 + var4] = -125;
         } else if(var7 == 8222) {
            var3[var6 + var4] = -124;
         } else if(var7 == 8230) {
            var3[var6 + var4] = -123;
         } else if(var7 == 8224) {
            var3[var6 + var4] = -122;
         } else if(var7 == 8225) {
            var3[var6 + var4] = -121;
         } else if(var7 == 710) {
            var3[var6 + var4] = -120;
         } else if(var7 == 8240) {
            var3[var6 + var4] = -119;
         } else if(var7 == 352) {
            var3[var6 + var4] = -118;
         } else if(var7 == 8249) {
            var3[var6 + var4] = -117;
         } else if(var7 == 338) {
            var3[var6 + var4] = -116;
         } else if(var7 == 381) {
            var3[var6 + var4] = -114;
         } else if(var7 == 8216) {
            var3[var6 + var4] = -111;
         } else if(var7 == 8217) {
            var3[var6 + var4] = -110;
         } else if(var7 == 8220) {
            var3[var6 + var4] = -109;
         } else if(var7 == 8221) {
            var3[var6 + var4] = -108;
         } else if(var7 == 8226) {
            var3[var6 + var4] = -107;
         } else if(var7 == 8211) {
            var3[var6 + var4] = -106;
         } else if(var7 == 8212) {
            var3[var6 + var4] = -105;
         } else if(var7 == 732) {
            var3[var6 + var4] = -104;
         } else if(var7 == 8482) {
            var3[var6 + var4] = -103;
         } else if(var7 == 353) {
            var3[var6 + var4] = -102;
         } else if(var7 == 8250) {
            var3[var6 + var4] = -101;
         } else if(var7 == 339) {
            var3[var6 + var4] = -100;
         } else if(var7 == 382) {
            var3[var6 + var4] = -98;
         } else if(var7 == 376) {
            var3[var6 + var4] = -97;
         } else {
            var3[var6 + var4] = 63;
         }
      }

      return var5;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lik;II)Lkh;",
      garbageValue = "-1952261718"
   )
   public static IndexedSprite method5112(IndexDataBase var0, int var1) {
      byte[] var3 = var0.takeRecordFlat(var1);
      boolean var2;
      if(var3 == null) {
         var2 = false;
      } else {
         Coordinates.decodeSprite(var3);
         var2 = true;
      }

      if(!var2) {
         return null;
      } else {
         IndexedSprite var4 = new IndexedSprite();
         var4.width = class310.field3891;
         var4.originalHeight = class310.field3898;
         var4.offsetX = class310.field3892[0];
         var4.offsetY = class310.offsetsY[0];
         var4.originalWidth = class310.field3895[0];
         var4.height = class310.field3896[0];
         var4.palette = class310.field3897;
         var4.pixels = class160.spritePixels[0];
         class47.method698();
         return var4;
      }
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "-1811376387"
   )
   @Export("decodeContainer")
   static final byte[] decodeContainer(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      int var2 = var1.readUnsignedByte();
      int var3 = var1.readInt();
      if(var3 < 0 || IndexDataBase.field3304 != 0 && var3 > IndexDataBase.field3304) {
         throw new RuntimeException();
      } else if(var2 == 0) {
         byte[] var4 = new byte[var3];
         var1.readBytes(var4, 0, var3);
         return var4;
      } else {
         int var6 = var1.readInt();
         if(var6 < 0 || IndexDataBase.field3304 != 0 && var6 > IndexDataBase.field3304) {
            throw new RuntimeException();
         } else {
            byte[] var5 = new byte[var6];
            if(var2 == 1) {
               class178.Bzip2Decompressor_decompress(var5, var6, var0, var3, 9);
            } else {
               IndexDataBase.gzip.decompress(var1, var5);
            }

            return var5;
         }
      }
   }
}
