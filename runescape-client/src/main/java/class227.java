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
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      longValue = 1681701827320478825L
   )
   @Export("position")
   long field3213;
   @ObfuscatedName("b")
   @Export("file")
   RandomAccessFile field3214;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      longValue = 3325446795323353145L
   )
   @Export("length")
   long field3216;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "-38829410"
   )
   public final long method4113() throws IOException {
      return this.field3214.length();
   }

   @ObfuscatedName("b")
   final void method4114(long var1) throws IOException {
      this.field3214.seek(var1);
      this.field3213 = var1;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-710440513"
   )
   public final void method4116() throws IOException {
      if(null != this.field3214) {
         this.field3214.close();
         this.field3214 = null;
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([BIIB)I",
      garbageValue = "52"
   )
   public final int method4118(byte[] var1, int var2, int var3) throws IOException {
      int var4 = this.field3214.read(var1, var2, var3);
      if(var4 > 0) {
         this.field3213 += (long)var4;
      }

      return var4;
   }

   protected void finalize() throws Throwable {
      if(this.field3214 != null) {
         System.out.println("");
         this.method4116();
      }

   }

   @ObfuscatedSignature(
      signature = "(Ljava/io/File;Ljava/lang/String;J)V",
      garbageValue = "10000"
   )
   public class227(File var1, String var2, long var3) throws IOException {
      if(var3 == -1L) {
         var3 = Long.MAX_VALUE;
      }

      if(var1.length() >= var3) {
         var1.delete();
      }

      this.field3214 = new RandomAccessFile(var1, var2);
      this.field3216 = var3;
      this.field3213 = 0L;
      int var5 = this.field3214.read();
      if(var5 != -1 && !var2.equals("r")) {
         this.field3214.seek(0L);
         this.field3214.write(var5);
      }

      this.field3214.seek(0L);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "1984178371"
   )
   public final void method4127(byte[] var1, int var2, int var3) throws IOException {
      if((long)var3 + this.field3213 > this.field3216) {
         this.field3214.seek(this.field3216 + 1L);
         this.field3214.write(1);
         throw new EOFException();
      } else {
         this.field3214.write(var1, var2, var3);
         this.field3213 += (long)var3;
      }
   }
}
