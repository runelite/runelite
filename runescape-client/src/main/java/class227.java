import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hz")
@Implements("FileOnDisk")
public final class class227 {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      longValue = -5622887488644793999L
   )
   @Export("length")
   long field3217;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      longValue = 8373317572098110985L
   )
   @Export("position")
   long field3218;
   @ObfuscatedName("j")
   @Export("file")
   RandomAccessFile field3219;
   @ObfuscatedName("c")
   static int[] field3220;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-13"
   )
   public final void method4088() throws IOException {
      if(null != this.field3219) {
         this.field3219.close();
         this.field3219 = null;
      }

   }

   @ObfuscatedName("j")
   final void method4089(long var1) throws IOException {
      this.field3219.seek(var1);
      this.field3218 = var1;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "-582335713"
   )
   public final long method4092() throws IOException {
      return this.field3219.length();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "883847445"
   )
   public final int method4093(byte[] var1, int var2, int var3) throws IOException {
      int var4 = this.field3219.read(var1, var2, var3);
      if(var4 > 0) {
         this.field3218 += (long)var4;
      }

      return var4;
   }

   protected void finalize() throws Throwable {
      if(null != this.field3219) {
         System.out.println("");
         this.method4088();
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-1372539220"
   )
   public final void method4097(byte[] var1, int var2, int var3) throws IOException {
      if(this.field3218 + (long)var3 > this.field3217) {
         this.field3219.seek(1L + this.field3217);
         this.field3219.write(1);
         throw new EOFException();
      } else {
         this.field3219.write(var1, var2, var3);
         this.field3218 += (long)var3;
      }
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
      this.field3217 = var3;
      this.field3218 = 0L;
      int var5 = this.field3219.read();
      if(var5 != -1 && !var2.equals("r")) {
         this.field3219.seek(0L);
         this.field3219.write(var5);
      }

      this.field3219.seek(0L);
   }
}
