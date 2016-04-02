import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hy")
@Implements("FileOnDisk")
public final class class227 {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      longValue = -3154654606416121427L
   )
   @Export("length")
   long field3215;
   @ObfuscatedName("e")
   @Export("file")
   RandomAccessFile field3216;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      longValue = 3565565978409192531L
   )
   @Export("position")
   long field3217;

   @ObfuscatedName("w")
   public final void method4113(byte[] var1, int var2, int var3) throws IOException {
      if(this.field3217 + (long)var3 > this.field3215) {
         this.field3216.seek(1L + this.field3215);
         this.field3216.write(1);
         throw new EOFException();
      } else {
         this.field3216.write(var1, var2, var3);
         this.field3217 += (long)var3;
      }
   }

   @ObfuscatedName("f")
   public final void method4114() throws IOException {
      if(this.field3216 != null) {
         this.field3216.close();
         this.field3216 = null;
      }

   }

   @ObfuscatedName("s")
   public final long method4115() throws IOException {
      return this.field3216.length();
   }

   protected void finalize() throws Throwable {
      if(null != this.field3216) {
         System.out.println("");
         this.method4114();
      }

   }

   public class227(File var1, String var2, long var3) throws IOException {
      if(var3 == -1L) {
         var3 = Long.MAX_VALUE;
      }

      if(var1.length() >= var3) {
         var1.delete();
      }

      this.field3216 = new RandomAccessFile(var1, var2);
      this.field3215 = var3;
      this.field3217 = 0L;
      int var5 = this.field3216.read();
      if(var5 != -1 && !var2.equals("r")) {
         this.field3216.seek(0L);
         this.field3216.write(var5);
      }

      this.field3216.seek(0L);
   }

   @ObfuscatedName("p")
   public final int method4121(byte[] var1, int var2, int var3) throws IOException {
      int var4 = this.field3216.read(var1, var2, var3);
      if(var4 > 0) {
         this.field3217 += (long)var4;
      }

      return var4;
   }

   @ObfuscatedName("e")
   final void method4129(long var1) throws IOException {
      this.field3216.seek(var1);
      this.field3217 = var1;
   }
}
