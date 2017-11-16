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

@ObfuscatedName("dx")
@Implements("FileOnDisk")
public final class FileOnDisk {
   @ObfuscatedName("q")
   static int[] field1680;
   @ObfuscatedName("b")
   @Export("file")
   RandomAccessFile file;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      longValue = -1184907146676286979L
   )
   @Export("length")
   long length;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      longValue = -6836063925767674501L
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

   @ObfuscatedName("b")
   @Export("seek")
   final void seek(long var1) throws IOException {
      this.file.seek(var1);
      this.position = var1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-1008556169"
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

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "12806"
   )
   @Export("close")
   public final void close() throws IOException {
      this.method2368(false);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-464146891"
   )
   public final void method2368(boolean var1) throws IOException {
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

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "1360678634"
   )
   @Export("length")
   public final long length() throws IOException {
      return this.file.length();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "2024864999"
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

   @ObfuscatedName("gj")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "1914558909"
   )
   static final void method2387(int var0, int var1, int var2, int var3, boolean var4) {
      if(var2 < 1) {
         var2 = 1;
      }

      if(var3 < 1) {
         var3 = 1;
      }

      int var5 = var3 - 334;
      if(var5 < 0) {
         var5 = 0;
      } else if(var5 > 100) {
         var5 = 100;
      }

      int var6 = (Client.field1101 - Client.field1100) * var5 / 100 + Client.field1100;
      int var7 = var3 * var6 * 512 / (var2 * 334);
      int var8;
      int var9;
      short var15;
      if(var7 < Client.field1106) {
         var15 = Client.field1106;
         var6 = var15 * var2 * 334 / (var3 * 512);
         if(var6 > Client.field1105) {
            var6 = Client.field1105;
            var8 = var3 * var6 * 512 / (var15 * 334);
            var9 = (var2 - var8) / 2;
            if(var4) {
               Rasterizer2D.noClip();
               Rasterizer2D.method4981(var0, var1, var9, var3, -16777216);
               Rasterizer2D.method4981(var0 + var2 - var9, var1, var9, var3, -16777216);
            }

            var0 += var9;
            var2 -= var9 * 2;
         }
      } else if(var7 > Client.field1107) {
         var15 = Client.field1107;
         var6 = var15 * var2 * 334 / (var3 * 512);
         if(var6 < Client.field1104) {
            var6 = Client.field1104;
            var8 = var15 * var2 * 334 / (var6 * 512);
            var9 = (var3 - var8) / 2;
            if(var4) {
               Rasterizer2D.noClip();
               Rasterizer2D.method4981(var0, var1, var2, var9, -16777216);
               Rasterizer2D.method4981(var0, var3 + var1 - var9, var2, var9, -16777216);
            }

            var1 += var9;
            var3 -= var9 * 2;
         }
      }

      var8 = (Client.field1103 - Client.field1102) * var5 / 100 + Client.field1102;
      Client.scale = var3 * var6 * var8 / 85504 << 1;
      if(var2 != Client.viewportHeight || var3 != Client.viewportWidth) {
         int[] var14 = new int[9];

         for(int var10 = 0; var10 < 9; ++var10) {
            int var11 = var10 * 32 + 15 + 128;
            int var12 = var11 * 3 + 600;
            int var13 = Graphics3D.SINE[var11];
            var14[var10] = var13 * var12 >> 16;
         }

         Region.method2723(var14, 500, 800, var2, var3);
      }

      Client.field1099 = var0;
      Client.field1109 = var1;
      Client.viewportHeight = var2;
      Client.viewportWidth = var3;
   }
}
