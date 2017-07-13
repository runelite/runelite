import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dk")
@Implements("FileOnDisk")
public final class FileOnDisk {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1250186955
   )
   static int field1754;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      longValue = 7844680910599758713L
   )
   @Export("position")
   long position;
   @ObfuscatedName("a")
   @Export("file")
   RandomAccessFile file;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      longValue = -7388041668595790779L
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
      signature = "(I)J",
      garbageValue = "720127786"
   )
   @Export("length")
   public final long length() throws IOException {
      return this.file.length();
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-676366823"
   )
   @Export("close")
   public final void close() throws IOException {
      if(this.file != null) {
         this.file.close();
         this.file = null;
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "([BIIB)I",
      garbageValue = "-31"
   )
   @Export("read")
   public final int read(byte[] var1, int var2, int var3) throws IOException {
      int var4 = this.file.read(var1, var2, var3);
      if(var4 > 0) {
         this.position += (long)var4;
      }

      return var4;
   }

   @ObfuscatedName("a")
   @Export("seek")
   final void seek(long var1) throws IOException {
      this.file.seek(var1);
      this.position = var1;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-1006610038"
   )
   @Export("write")
   public final void write(byte[] var1, int var2, int var3) throws IOException {
      if((long)var3 + this.position > this.length) {
         this.file.seek(this.length + 1L);
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

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(LIndexData;IIIBZI)V",
      garbageValue = "-108821052"
   )
   static void method2368(IndexData var0, int var1, int var2, int var3, byte var4, boolean var5) {
      long var6 = (long)((var1 << 16) + var2);
      FileRequest var8 = (FileRequest)class238.field3255.get(var6);
      if(var8 == null) {
         var8 = (FileRequest)class238.field3269.get(var6);
         if(var8 == null) {
            var8 = (FileRequest)class238.field3260.get(var6);
            if(var8 != null) {
               if(var5) {
                  var8.unlinkDual();
                  class238.field3255.put(var8, var6);
                  --class238.field3256;
                  ++class238.field3272;
               }

            } else {
               if(!var5) {
                  var8 = (FileRequest)class238.field3262.get(var6);
                  if(var8 != null) {
                     return;
                  }
               }

               var8 = new FileRequest();
               var8.index = var0;
               var8.crc = var3;
               var8.padding = var4;
               if(var5) {
                  class238.field3255.put(var8, var6);
                  ++class238.field3272;
               } else {
                  class238.field3259.push(var8);
                  class238.field3260.put(var8, var6);
                  ++class238.field3256;
               }

            }
         }
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;Ljava/lang/String;Ljava/lang/String;IZI)V",
      garbageValue = "1709750485"
   )
   public static void method2367(IndexDataBase var0, String var1, String var2, int var3, boolean var4) {
      int var5 = var0.getFile(var1);
      int var6 = var0.getChild(var5, var2);
      Friend.method1083(var0, var5, var6, var3, var4);
   }
}
