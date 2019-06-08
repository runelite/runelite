import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("id")
@Implements("Strings")
public class Strings {
   @ObfuscatedName("bq")
   @Export("__id_bq")
   public static String __id_bq;
   @ObfuscatedName("cp")
   @Export("__id_cp")
   public static String __id_cp;
   @ObfuscatedName("jr")
   @Export("__id_jr")
   public static String __id_jr;
   @ObfuscatedName("jv")
   @Export("__id_jv")
   public static String __id_jv;
   @ObfuscatedName("ju")
   @Export("__id_ju")
   public static String __id_ju;

   static {
      __id_bq = "Please visit the support page for assistance.";
      __id_cp = "Please visit the support page for assistance.";
      __id_jr = "";
      __id_jv = "Page has opened in a new window.";
      __id_ju = "(Please check your popup blocker.)";
   }

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
      if(var3 < 0 || AbstractIndexCache.__ir_s != 0 && var3 > AbstractIndexCache.__ir_s) {
         throw new RuntimeException();
      } else if(var2 == 0) {
         byte[] var4 = new byte[var3];
         var1.__al_305(var4, 0, var3);
         return var4;
      } else {
         int var6 = var1.readInt();
         if(var6 < 0 || AbstractIndexCache.__ir_s != 0 && var6 > AbstractIndexCache.__ir_s) {
            throw new RuntimeException();
         } else {
            byte[] var5 = new byte[var6];
            if(var2 == 1) {
               Bzip2Decompressor.Bzip2Decompressor_decompress(var5, var6, var0, var3, 9);
            } else {
               AbstractIndexCache.gzipDecompressor.decompress(var1, var5);
            }

            return var5;
         }
      }
   }
}
