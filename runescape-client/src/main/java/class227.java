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
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      longValue = -3770885249736981955L
   )
   @Export("position")
   long field3215;
   @ObfuscatedName("s")
   @Export("file")
   RandomAccessFile field3216;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      longValue = -5588021346236803831L
   )
   @Export("length")
   long field3217;

   @ObfuscatedName("s")
   final void method4105(long var1) throws IOException {
      this.field3216.seek(var1);
      this.field3215 = var1;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-1471611736"
   )
   public final void method4106(byte[] var1, int var2, int var3) throws IOException {
      if((long)var3 + this.field3215 > this.field3217) {
         this.field3216.seek(this.field3217 + 1L);
         this.field3216.write(1);
         throw new EOFException();
      } else {
         this.field3216.write(var1, var2, var3);
         this.field3215 += (long)var3;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)J",
      garbageValue = "-59"
   )
   public final long method4108() throws IOException {
      return this.field3216.length();
   }

   protected void finalize() throws Throwable {
      if(null != this.field3216) {
         System.out.println("");
         this.method4121();
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "-1347490765"
   )
   public final int method4119(byte[] var1, int var2, int var3) throws IOException {
      int var4 = this.field3216.read(var1, var2, var3);
      if(var4 > 0) {
         this.field3215 += (long)var4;
      }

      return var4;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1531773865"
   )
   public final void method4121() throws IOException {
      if(null != this.field3216) {
         this.field3216.close();
         this.field3216 = null;
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

      this.field3216 = new RandomAccessFile(var1, var2);
      this.field3217 = var3;
      this.field3215 = 0L;
      int var5 = this.field3216.read();
      if(-1 != var5 && !var2.equals("r")) {
         this.field3216.seek(0L);
         this.field3216.write(var5);
      }

      this.field3216.seek(0L);
   }
}
