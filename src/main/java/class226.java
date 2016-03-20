import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hn")
@Implements("FileOnDisk")
public final class class226 {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      longValue = 7324685209562159801L
   )
   @Export("length")
   long field3205;
   @ObfuscatedName("a")
   @Export("file")
   RandomAccessFile field3206;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      longValue = -3551003884435086917L
   )
   @Export("position")
   long field3207;

   @ObfuscatedName("a")
   final void method4153(long var1) throws IOException {
      this.field3206.seek(var1);
      this.field3207 = var1;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-1504111019"
   )
   public final void method4154(byte[] var1, int var2, int var3) throws IOException {
      if((long)var3 + this.field3207 > this.field3205) {
         this.field3206.seek(1L + this.field3205);
         this.field3206.write(1);
         throw new EOFException();
      } else {
         this.field3206.write(var1, var2, var3);
         this.field3207 += (long)var3;
      }
   }

   @ObfuscatedName("s")
   public final long method4156() throws IOException {
      return this.field3206.length();
   }

   @ObfuscatedName("y")
   public final int method4157(byte[] var1, int var2, int var3) throws IOException {
      int var4 = this.field3206.read(var1, var2, var3);
      if(var4 > 0) {
         this.field3207 += (long)var4;
      }

      return var4;
   }

   protected void finalize() throws Throwable {
      if(this.field3206 != null) {
         System.out.println("");
         this.method4168();
      }

   }

   public class226(File var1, String var2, long var3) throws IOException {
      if(-1L == var3) {
         var3 = Long.MAX_VALUE;
      }

      if(var1.length() >= var3) {
         var1.delete();
      }

      this.field3206 = new RandomAccessFile(var1, var2);
      this.field3205 = var3;
      this.field3207 = 0L;
      int var5 = this.field3206.read();
      if(var5 != -1 && !var2.equals("r")) {
         this.field3206.seek(0L);
         this.field3206.write(var5);
      }

      this.field3206.seek(0L);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1212662683"
   )
   public final void method4168() throws IOException {
      if(null != this.field3206) {
         this.field3206.close();
         this.field3206 = null;
      }

   }
}
