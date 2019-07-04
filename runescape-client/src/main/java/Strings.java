import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("id")
@Implements("Strings")
public class Strings {
   @ObfuscatedName("bq")
   public static String field880;
   @ObfuscatedName("cp")
   public static String field881;
   @ObfuscatedName("jr")
   public static String field882;
   @ObfuscatedName("jv")
   public static String field883;
   @ObfuscatedName("ju")
   public static String field884;

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "274331764"
   )
   @Export("decompressBytes")
   static final byte[] decompressBytes(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      int var2 = var1.readUnsignedByte();
      int var3 = var1.readInt();
      if (var3 >= 0 && (AbstractIndexCache.field1 == 0 || var3 <= AbstractIndexCache.field1)) {
         if (var2 == 0) {
            byte[] var6 = new byte[var3];
            var1.method46(var6, 0, var3);
            return var6;
         } else {
            int var4 = var1.readInt();
            if (var4 < 0 || AbstractIndexCache.field1 != 0 && var4 > AbstractIndexCache.field1) {
               throw new RuntimeException();
            } else {
               byte[] var5 = new byte[var4];
               if (var2 == 1) {
                  Bzip2Decompressor.Bzip2Decompressor_decompress(var5, var4, var0, var3, 9);
               } else {
                  AbstractIndexCache.gzipDecompressor.decompress(var1, var5);
               }

               return var5;
            }
         }
      } else {
         throw new RuntimeException();
      }
   }

   static {
      field880 = "Please visit the support page for assistance.";
      field881 = "Please visit the support page for assistance.";
      field882 = "";
      field883 = "Page has opened in a new window.";
      field884 = "(Please check your popup blocker.)";
   }
}
