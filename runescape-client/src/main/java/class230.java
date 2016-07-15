import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hq")
@Implements("FileOnDisk")
public final class class230 {
   @ObfuscatedName("e")
   @Export("file")
   RandomAccessFile field3260;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      longValue = 3044660203494447397L
   )
   @Export("position")
   long field3261;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      longValue = 511393137545522581L
   )
   @Export("length")
   long field3262;
   @ObfuscatedName("bt")
   static class171 field3263;

   @ObfuscatedName("e")
   final void method4211(long var1) throws IOException {
      this.field3260.seek(var1);
      this.field3261 = var1;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "11"
   )
   public final void method4212(byte[] var1, int var2, int var3) throws IOException {
      if(this.field3261 + (long)var3 > this.field3262) {
         this.field3260.seek(1L + this.field3262);
         this.field3260.write(1);
         throw new EOFException();
      } else {
         this.field3260.write(var1, var2, var3);
         this.field3261 += (long)var3;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "996541975"
   )
   public final void method4213() throws IOException {
      if(this.field3260 != null) {
         this.field3260.close();
         this.field3260 = null;
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)J",
      garbageValue = "14"
   )
   public final long method4214() throws IOException {
      return this.field3260.length();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "1032477614"
   )
   public final int method4215(byte[] var1, int var2, int var3) throws IOException {
      int var4 = this.field3260.read(var1, var2, var3);
      if(var4 > 0) {
         this.field3261 += (long)var4;
      }

      return var4;
   }

   protected void finalize() throws Throwable {
      if(null != this.field3260) {
         System.out.println("");
         this.method4213();
      }

   }

   public class230(File var1, String var2, long var3) throws IOException {
      if(-1L == var3) {
         var3 = Long.MAX_VALUE;
      }

      if(var1.length() >= var3) {
         var1.delete();
      }

      this.field3260 = new RandomAccessFile(var1, var2);
      this.field3262 = var3;
      this.field3261 = 0L;
      int var5 = this.field3260.read();
      if(var5 != -1 && !var2.equals("r")) {
         this.field3260.seek(0L);
         this.field3260.write(var5);
      }

      this.field3260.seek(0L);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass170;II)Lclass184;",
      garbageValue = "-1928369055"
   )
   static class184 method4229(class170 var0, int var1) {
      byte[] var2 = var0.method3415(var1);
      return null == var2?null:new class184(var2);
   }
}
