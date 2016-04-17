import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hs")
@Implements("FileOnDisk")
public final class class227 {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      longValue = 1090618522452410011L
   )
   @Export("position")
   long field3215;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      longValue = 1838144256712138007L
   )
   @Export("length")
   long field3216;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -664668203
   )
   public static int field3217;
   @ObfuscatedName("a")
   @Export("file")
   RandomAccessFile field3219;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "111848289"
   )
   public final void method4201(byte[] var1, int var2, int var3) throws IOException {
      if(this.field3215 + (long)var3 > this.field3216) {
         this.field3219.seek(1L + this.field3216);
         this.field3219.write(1);
         throw new EOFException();
      } else {
         this.field3219.write(var1, var2, var3);
         this.field3215 += (long)var3;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "91"
   )
   public final void method4202() throws IOException {
      if(null != this.field3219) {
         this.field3219.close();
         this.field3219 = null;
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)J",
      garbageValue = "46"
   )
   public final long method4203() throws IOException {
      return this.field3219.length();
   }

   @ObfuscatedSignature(
      signature = "(Ljava/io/File;Ljava/lang/String;J)V",
      garbageValue = "10000"
   )
   public class227(File var1, String var2, long var3) throws IOException {
      if(-1L == var3) {
         var3 = Long.MAX_VALUE;
      }

      if(var1.length() >= var3) {
         var1.delete();
      }

      this.field3219 = new RandomAccessFile(var1, var2);
      this.field3216 = var3;
      this.field3215 = 0L;
      int var5 = this.field3219.read();
      if(-1 != var5 && !var2.equals("r")) {
         this.field3219.seek(0L);
         this.field3219.write(var5);
      }

      this.field3219.seek(0L);
   }

   protected void finalize() throws Throwable {
      if(null != this.field3219) {
         System.out.println("");
         this.method4202();
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "-575462148"
   )
   public final int method4205(byte[] var1, int var2, int var3) throws IOException {
      int var4 = this.field3219.read(var1, var2, var3);
      if(var4 > 0) {
         this.field3215 += (long)var4;
      }

      return var4;
   }

   @ObfuscatedName("a")
   final void method4219(long var1) throws IOException {
      this.field3219.seek(var1);
      this.field3215 = var1;
   }
}
