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

@ObfuscatedName("di")
@Implements("FileOnDisk")
public final class FileOnDisk {
   @ObfuscatedName("d")
   @Export("file")
   RandomAccessFile file;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      longValue = 1347991565056993615L
   )
   @Export("length")
   long length;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      longValue = -9142159151113047375L
   )
   @Export("position")
   long position;

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

   @ObfuscatedName("d")
   @Export("seek")
   final void seek(long var1) throws IOException {
      this.file.seek(var1);
      this.position = var1;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-1036215976"
   )
   @Export("write")
   public final void write(byte[] var1, int var2, int var3) throws IOException {
      if(this.position + (long)var3 > this.length) {
         this.file.seek(this.length + 1L);
         this.file.write(1);
         throw new EOFException();
      } else {
         this.file.write(var1, var2, var3);
         this.position += (long)var3;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2073960154"
   )
   @Export("close")
   public final void close() throws IOException {
      this.closeSync(false);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1383131630"
   )
   @Export("closeSync")
   public final void closeSync(boolean var1) throws IOException {
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

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "-1689086150"
   )
   @Export("length")
   public final long length() throws IOException {
      return this.file.length();
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "-556741703"
   )
   @Export("read")
   public final int read(byte[] var1, int var2, int var3) throws IOException {
      int var4 = this.file.read(var1, var2, var3);
      if(var4 > 0) {
         this.position += (long)var4;
      }

      return var4;
   }

   protected void finalize() throws Throwable {
      if(this.file != null) {
         System.out.println("");
         this.close();
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljk;B)V",
      garbageValue = "-1"
   )
   public static void method2621(IndexDataBase var0) {
      FloorUnderlayDefinition.underlay_ref = var0;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;II)I",
      garbageValue = "1841227524"
   )
   public static int method2603(CharSequence var0, CharSequence var1, int var2) {
      int var3 = var0.length();
      int var4 = var1.length();
      int var5 = 0;
      int var6 = 0;
      char var7 = 0;
      char var8 = 0;

      while(var5 - var7 < var3 || var6 - var8 < var4) {
         if(var5 - var7 >= var3) {
            return -1;
         }

         if(var6 - var8 >= var4) {
            return 1;
         }

         char var9;
         if(var7 != 0) {
            var9 = var7;
            boolean var14 = false;
         } else {
            var9 = var0.charAt(var5++);
         }

         char var10;
         if(var8 != 0) {
            var10 = var8;
            boolean var15 = false;
         } else {
            var10 = var1.charAt(var6++);
         }

         var7 = class37.method504(var9);
         var8 = class37.method504(var10);
         var9 = class167.method3311(var9, var2);
         var10 = class167.method3311(var10, var2);
         if(var9 != var10 && Character.toUpperCase(var9) != Character.toUpperCase(var10)) {
            var9 = Character.toLowerCase(var9);
            var10 = Character.toLowerCase(var10);
            if(var10 != var9) {
               return NetWriter.method2100(var9, var2) - NetWriter.method2100(var10, var2);
            }
         }
      }

      int var16 = Math.min(var3, var4);

      char var12;
      int var17;
      for(var17 = 0; var17 < var16; ++var17) {
         char var11 = var0.charAt(var17);
         var12 = var1.charAt(var17);
         if(var12 != var11 && Character.toUpperCase(var11) != Character.toUpperCase(var12)) {
            var11 = Character.toLowerCase(var11);
            var12 = Character.toLowerCase(var12);
            if(var11 != var12) {
               return NetWriter.method2100(var11, var2) - NetWriter.method2100(var12, var2);
            }
         }
      }

      var17 = var3 - var4;
      if(var17 != 0) {
         return var17;
      } else {
         for(int var18 = 0; var18 < var16; ++var18) {
            var12 = var0.charAt(var18);
            char var13 = var1.charAt(var18);
            if(var12 != var13) {
               return NetWriter.method2100(var12, var2) - NetWriter.method2100(var13, var2);
            }
         }

         return 0;
      }
   }
}
