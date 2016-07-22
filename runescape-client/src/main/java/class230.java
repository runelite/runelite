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
public final class class230 {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      longValue = 8995419701243428195L
   )
   @Export("length")
   long field3262;
   @ObfuscatedName("m")
   @Export("file")
   RandomAccessFile field3263;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      longValue = 6699628237780247031L
   )
   @Export("position")
   long field3264;

   @ObfuscatedName("m")
   final void method4206(long var1) throws IOException {
      this.field3263.seek(var1);
      this.field3264 = var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "52"
   )
   public final void method4207(byte[] var1, int var2, int var3) throws IOException {
      if((long)var3 + this.field3264 > this.field3262) {
         this.field3263.seek(this.field3262 + 1L);
         this.field3263.write(1);
         throw new EOFException();
      } else {
         this.field3263.write(var1, var2, var3);
         this.field3264 += (long)var3;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "917671438"
   )
   public final int method4210(byte[] var1, int var2, int var3) throws IOException {
      int var4 = this.field3263.read(var1, var2, var3);
      if(var4 > 0) {
         this.field3264 += (long)var4;
      }

      return var4;
   }

   protected void finalize() throws Throwable {
      if(this.field3263 != null) {
         System.out.println("");
         this.method4223();
      }

   }

   public class230(File var1, String var2, long var3) throws IOException {
      if(-1L == var3) {
         var3 = Long.MAX_VALUE;
      }

      if(var1.length() >= var3) {
         var1.delete();
      }

      this.field3263 = new RandomAccessFile(var1, var2);
      this.field3262 = var3;
      this.field3264 = 0L;
      int var5 = this.field3263.read();
      if(var5 != -1 && !var2.equals("r")) {
         this.field3263.seek(0L);
         this.field3263.write(var5);
      }

      this.field3263.seek(0L);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "-324734668"
   )
   public final long method4214() throws IOException {
      return this.field3263.length();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1300892151"
   )
   public final void method4223() throws IOException {
      if(null != this.field3263) {
         this.field3263.close();
         this.field3263 = null;
      }

   }
}
