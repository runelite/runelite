import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.SyncFailedException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dc")
@Implements("FileOnDisk")
public final class FileOnDisk {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lii;"
   )
   @Export("item_ref")
   public static IndexDataBase item_ref;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      longValue = -2914574443387994835L
   )
   @Export("position")
   long position;
   @ObfuscatedName("i")
   @Export("file")
   RandomAccessFile file;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      longValue = 380184747870635553L
   )
   @Export("length")
   long length;

   public FileOnDisk(File var1, String var2, long var3) throws IOException {
      if(-1L == var3) {
         var3 = Long.MAX_VALUE;
      }

      if(var1.length() >= var3) {
         var1.delete();
      }

      this.file = new RandomAccessFile(var1, var2);
      this.length = var3;
      this.position = 0L;
      int var5 = this.file.read();
      if(var5 != -1 && !var2.equals("r")) {
         this.file.seek(0L);
         this.file.write(var5);
      }

      this.file.seek(0L);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "882680926"
   )
   public final void method2374(boolean var1) throws IOException {
      if(this.file != null) {
         if(var1) {
            try {
               this.file.getFD().sync();
            } catch (SyncFailedException var3) {
               ;
            }
         }

         this.file.close();
         this.file = null;
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "-2071112601"
   )
   @Export("length")
   public final long length() throws IOException {
      return this.file.length();
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2083020169"
   )
   @Export("close")
   public final void close() throws IOException {
      this.method2374(false);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "-2137110675"
   )
   @Export("read")
   public final int read(byte[] var1, int var2, int var3) throws IOException {
      int var4 = this.file.read(var1, var2, var3);
      if(var4 > 0) {
         this.position += (long)var4;
      }

      return var4;
   }

   @ObfuscatedName("i")
   @Export("seek")
   final void seek(long var1) throws IOException {
      this.file.seek(var1);
      this.position = var1;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "120"
   )
   @Export("write")
   public final void write(byte[] var1, int var2, int var3) throws IOException {
      if(this.position + (long)var3 > this.length) {
         this.file.seek(1L + this.length);
         this.file.write(1);
         throw new EOFException();
      } else {
         this.file.write(var1, var2, var3);
         this.position += (long)var3;
      }
   }

   protected void finalize() throws Throwable {
      if(this.file != null) {
         System.out.println("");
         this.close();
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-688324130"
   )
   static final int method2376() {
      return class133.field2002;
   }
}
