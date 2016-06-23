import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hz")
@Implements("FileOnDisk")
public final class class227 {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      longValue = 4284189128816177877L
   )
   @Export("position")
   long field3216;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      longValue = 2780304371522943709L
   )
   @Export("length")
   long field3217;
   @ObfuscatedName("f")
   @Export("file")
   RandomAccessFile field3218;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "929609060"
   )
   public final int method4146(byte[] var1, int var2, int var3) throws IOException {
      int var4 = this.field3218.read(var1, var2, var3);
      if(var4 > 0) {
         this.field3216 += (long)var4;
      }

      return var4;
   }

   @ObfuscatedName("f")
   final void method4147(long var1) throws IOException {
      this.field3218.seek(var1);
      this.field3216 = var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-1"
   )
   public final void method4149() throws IOException {
      if(this.field3218 != null) {
         this.field3218.close();
         this.field3218 = null;
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "789911199"
   )
   public final long method4150() throws IOException {
      return this.field3218.length();
   }

   protected void finalize() throws Throwable {
      if(this.field3218 != null) {
         System.out.println("");
         this.method4149();
      }

   }

   public class227(File var1, String var2, long var3) throws IOException {
      if(var3 == -1L) {
         var3 = Long.MAX_VALUE;
      }

      if(var1.length() >= var3) {
         var1.delete();
      }

      this.field3218 = new RandomAccessFile(var1, var2);
      this.field3217 = var3;
      this.field3216 = 0L;
      int var5 = this.field3218.read();
      if(var5 != -1 && !var2.equals("r")) {
         this.field3218.seek(0L);
         this.field3218.write(var5);
      }

      this.field3218.seek(0L);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "656219749"
   )
   public final void method4158(byte[] var1, int var2, int var3) throws IOException {
      if((long)var3 + this.field3216 > this.field3217) {
         this.field3218.seek(1L + this.field3217);
         this.field3218.write(1);
         throw new EOFException();
      } else {
         this.field3218.write(var1, var2, var3);
         this.field3216 += (long)var3;
      }
   }
}
