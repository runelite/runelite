import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ha")
@Implements("FileOnDisk")
public final class class227 {
   @ObfuscatedName("t")
   @Export("file")
   RandomAccessFile field3215;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      longValue = 2299547363658823539L
   )
   @Export("length")
   long field3216;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      longValue = 3313211108895290373L
   )
   @Export("position")
   long field3217;
   @ObfuscatedName("z")
   public static class167 field3218;

   @ObfuscatedName("t")
   final void method4072(long var1) throws IOException {
      this.field3215.seek(var1);
      this.field3217 = var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "1720933563"
   )
   public final void method4073(byte[] var1, int var2, int var3) throws IOException {
      if((long)var3 + this.field3217 > this.field3216) {
         this.field3215.seek(this.field3216 + 1L);
         this.field3215.write(1);
         throw new EOFException();
      } else {
         this.field3215.write(var1, var2, var3);
         this.field3217 += (long)var3;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-490941411"
   )
   public final void method4074() throws IOException {
      if(this.field3215 != null) {
         this.field3215.close();
         this.field3215 = null;
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

      this.field3215 = new RandomAccessFile(var1, var2);
      this.field3216 = var3;
      this.field3217 = 0L;
      int var5 = this.field3215.read();
      if(var5 != -1 && !var2.equals("r")) {
         this.field3215.seek(0L);
         this.field3215.write(var5);
      }

      this.field3215.seek(0L);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "1390129103"
   )
   public final long method4075() throws IOException {
      return this.field3215.length();
   }

   protected void finalize() throws Throwable {
      if(null != this.field3215) {
         System.out.println("");
         this.method4074();
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "([BIIB)I",
      garbageValue = "-4"
   )
   public final int method4086(byte[] var1, int var2, int var3) throws IOException {
      int var4 = this.field3215.read(var1, var2, var3);
      if(var4 > 0) {
         this.field3217 += (long)var4;
      }

      return var4;
   }
}
