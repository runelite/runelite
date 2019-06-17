import java.io.File;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fs")
public class class168 {
   @ObfuscatedName("o")
   @Export("__fs_o")
   public static File __fs_o;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -2051451755
   )
   @Export("idxCount")
   public static int idxCount;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Ldy;"
   )
   @Export("randomDat")
   public static BufferedFile randomDat;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Ldy;"
   )
   @Export("dat2File")
   public static BufferedFile dat2File;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Ldy;"
   )
   @Export("idx255File")
   public static BufferedFile idx255File;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 1181569415
   )
   @Export("__fs_au")
   static int __fs_au;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1352667137"
   )
   public static boolean method3461(int var0) {
      return (var0 >> 29 & 1) != 0;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(CIB)Ljava/lang/String;",
      garbageValue = "66"
   )
   public static String method3450(char var0, int var1) {
      char[] var2 = new char[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var2[var3] = var0;
      }

      return new String(var2);
   }

   static {
      randomDat = null;
      dat2File = null;
      idx255File = null;
   }
}
