import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hl")
@Implements("FileOnDisk")
public final class FileOnDisk {
   @ObfuscatedName("l")
   @Export("file")
   RandomAccessFile file;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      longValue = -4009065674402867081L
   )
   @Export("position")
   long position;
   @ObfuscatedName("e")
   static String[] field3259;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      longValue = -7996947393543454741L
   )
   @Export("length")
   long length;

   @ObfuscatedName("l")
   final void method4271(long var1) throws IOException {
      this.file.seek(var1);
      this.position = var1;
   }

   public FileOnDisk(File var1, String var2, long var3) throws IOException {
      if(var3 == -1L) {
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

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "-857236254"
   )
   public final long method4273() throws IOException {
      return this.file.length();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "([BIIS)I",
      garbageValue = "-16810"
   )
   public final int method4274(byte[] var1, int var2, int var3) throws IOException {
      int var4 = this.file.read(var1, var2, var3);
      if(var4 > 0) {
         this.position += (long)var4;
      }

      return var4;
   }

   protected void finalize() throws Throwable {
      if(this.file != null) {
         System.out.println("");
         this.method4283();
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "1677494714"
   )
   public final void method4275(byte[] var1, int var2, int var3) throws IOException {
      if((long)var3 + this.position > this.length) {
         this.file.seek(this.length + 1L);
         this.file.write(1);
         throw new EOFException();
      } else {
         this.file.write(var1, var2, var3);
         this.position += (long)var3;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1852866503"
   )
   public final void method4283() throws IOException {
      if(this.file != null) {
         this.file.close();
         this.file = null;
      }

   }
}
