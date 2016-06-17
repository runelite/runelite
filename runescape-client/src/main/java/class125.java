import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dp")
public abstract class class125 {
   @ObfuscatedName("g")
   static boolean field2026 = false;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)[B",
      garbageValue = "77"
   )
   abstract byte[] vmethod2826();

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-391690139"
   )
   abstract void vmethod2827(byte[] var1);

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;ZI)Z",
      garbageValue = "0"
   )
   static boolean method2830(File var0, boolean var1) {
      try {
         RandomAccessFile var2 = new RandomAccessFile(var0, "rw");
         int var3 = var2.read();
         var2.seek(0L);
         var2.write(var3);
         var2.seek(0L);
         var2.close();
         return true;
      } catch (Exception var4) {
         return false;
      }
   }
}
