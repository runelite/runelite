import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hk")
@Implements("FileOnDisk")
public final class class226 {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      longValue = 2631444657544578999L
   )
   @Export("length")
   long field3206;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      longValue = 1960349642373544815L
   )
   @Export("position")
   long field3207;
   @ObfuscatedName("af")
   static class145 field3208;
   @ObfuscatedName("j")
   @Export("file")
   RandomAccessFile field3209;

   @ObfuscatedName("j")
   final void method4060(long var1) throws IOException {
      this.field3209.seek(var1);
      this.field3207 = var1;
   }

   @ObfuscatedName("l")
   public final void method4061(byte[] var1, int var2, int var3) throws IOException {
      if((long)var3 + this.field3207 > this.field3206) {
         this.field3209.seek(1L + this.field3206);
         this.field3209.write(1);
         throw new EOFException();
      } else {
         this.field3209.write(var1, var2, var3);
         this.field3207 += (long)var3;
      }
   }

   public class226(File var1, String var2, long var3) throws IOException {
      if(-1L == var3) {
         var3 = Long.MAX_VALUE;
      }

      if(var1.length() >= var3) {
         var1.delete();
      }

      this.field3209 = new RandomAccessFile(var1, var2);
      this.field3206 = var3;
      this.field3207 = 0L;
      int var5 = this.field3209.read();
      if(var5 != -1 && !var2.equals("r")) {
         this.field3209.seek(0L);
         this.field3209.write(var5);
      }

      this.field3209.seek(0L);
   }

   @ObfuscatedName("i")
   public final long method4067() throws IOException {
      return this.field3209.length();
   }

   @ObfuscatedName("f")
   public final int method4068(byte[] var1, int var2, int var3) throws IOException {
      int var4 = this.field3209.read(var1, var2, var3);
      if(var4 > 0) {
         this.field3207 += (long)var4;
      }

      return var4;
   }

   @ObfuscatedName("a")
   public final void method4069() throws IOException {
      if(this.field3209 != null) {
         this.field3209.close();
         this.field3209 = null;
      }

   }

   protected void finalize() throws Throwable {
      if(null != this.field3209) {
         System.out.println("");
         this.method4069();
      }

   }
}
