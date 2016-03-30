import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hy")
@Implements("FileOnDisk")
public final class class227 {
   @ObfuscatedName("w")
   @Export("file")
   RandomAccessFile field3217;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      longValue = -8323264026935496179L
   )
   @Export("position")
   long field3218;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      longValue = -4738116293779681655L
   )
   @Export("length")
   long field3219;
   @ObfuscatedName("eb")
   static class78[] field3220;

   @ObfuscatedName("t")
   public final void method4130() throws IOException {
      if(this.field3217 != null) {
         this.field3217.close();
         this.field3217 = null;
      }

   }

   @ObfuscatedName("e")
   public final int method4131(byte[] var1, int var2, int var3) throws IOException {
      int var4 = this.field3217.read(var1, var2, var3);
      if(var4 > 0) {
         this.field3218 += (long)var4;
      }

      return var4;
   }

   @ObfuscatedName("p")
   public final long method4132() throws IOException {
      return this.field3217.length();
   }

   public class227(File var1, String var2, long var3) throws IOException {
      if(var3 == -1L) {
         var3 = Long.MAX_VALUE;
      }

      if(var1.length() >= var3) {
         var1.delete();
      }

      this.field3217 = new RandomAccessFile(var1, var2);
      this.field3219 = var3;
      this.field3218 = 0L;
      int var5 = this.field3217.read();
      if(-1 != var5 && !var2.equals("r")) {
         this.field3217.seek(0L);
         this.field3217.write(var5);
      }

      this.field3217.seek(0L);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-388526757"
   )
   public final void method4143(byte[] var1, int var2, int var3) throws IOException {
      if((long)var3 + this.field3218 > this.field3219) {
         this.field3217.seek(this.field3219 + 1L);
         this.field3217.write(1);
         throw new EOFException();
      } else {
         this.field3217.write(var1, var2, var3);
         this.field3218 += (long)var3;
      }
   }

   protected void finalize() throws Throwable {
      if(null != this.field3217) {
         System.out.println("");
         this.method4130();
      }

   }

   @ObfuscatedName("w")
   final void method4147(long var1) throws IOException {
      this.field3217.seek(var1);
      this.field3218 = var1;
   }
}
