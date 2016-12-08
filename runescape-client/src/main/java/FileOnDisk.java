import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bn")
@Implements("FileOnDisk")
public final class FileOnDisk {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      longValue = 4199302794556595219L
   )
   @Export("position")
   long position;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      longValue = 5190847102451418709L
   )
   @Export("length")
   long length;
   @ObfuscatedName("o")
   @Export("file")
   RandomAccessFile file;
   @ObfuscatedName("nm")
   @ObfuscatedGetter(
      intValue = -1459804033
   )
   static int field1197;
   @ObfuscatedName("l")
   public static int[] field1199;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-1708279247"
   )
   public final void method1387(byte[] var1, int var2, int var3) throws IOException {
      if(this.position + (long)var3 > this.length) {
         this.file.seek(1L + this.length);
         this.file.write(1);
         throw new EOFException();
      } else {
         this.file.write(var1, var2, var3);
         this.position += (long)var3;
      }
   }

   @ObfuscatedName("o")
   final void method1388(long var1) throws IOException {
      this.file.seek(var1);
      this.position = var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "329788446"
   )
   public final long method1389() throws IOException {
      return this.file.length();
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "([Lclass158;II)Lclass158;",
      garbageValue = "1793000019"
   )
   public static class158 method1390(class158[] var0, int var1) {
      class158[] var2 = var0;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         class158 var4 = var2[var3];
         if(var1 == var4.vmethod3989()) {
            return var4;
         }
      }

      return null;
   }

   protected void finalize() throws Throwable {
      if(this.file != null) {
         System.out.println("");
         this.method1400();
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "([BIIB)I",
      garbageValue = "82"
   )
   public final int method1391(byte[] var1, int var2, int var3) throws IOException {
      int var4 = this.file.read(var1, var2, var3);
      if(var4 > 0) {
         this.position += (long)var4;
      }

      return var4;
   }

   public FileOnDisk(File var1, String var2, long var3) throws IOException {
      if(var3 == -1L) {
         var3 = Long.MAX_VALUE;
      }

      if(var1.length() >= var3) {
         var1.delete();
      }

      this.file = new RandomAccessFile(var1, var2);
      this.length = var3;
      this.position = 0L;
      int var5 = this.file.read();
      if(var5 != -1 && !var2.equals("r")) {
         this.file.seek(0L);
         this.file.write(var5);
      }

      this.file.seek(0L);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2125142392"
   )
   public final void method1400() throws IOException {
      if(this.file != null) {
         this.file.close();
         this.file = null;
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "416674217"
   )
   public static int method1403(CharSequence var0) {
      return class142.method2619(var0, 10, true);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LSequence;IIIB)V",
      garbageValue = "40"
   )
   static void method1404(Sequence var0, int var1, int var2, int var3) {
      if(Client.field526 < 50 && Client.field525 != 0) {
         if(var0.field3053 != null && var1 < var0.field3053.length) {
            int var4 = var0.field3053[var1];
            if(var4 != 0) {
               int var5 = var4 >> 8;
               int var6 = var4 >> 4 & 7;
               int var7 = var4 & 15;
               Client.field527[Client.field526] = var5;
               Client.field351[Client.field526] = var6;
               Client.field529[Client.field526] = 0;
               Client.field531[Client.field526] = null;
               int var8 = (var2 - 64) / 128;
               int var9 = (var3 - 64) / 128;
               Client.field349[Client.field526] = var7 + (var8 << 16) + (var9 << 8);
               ++Client.field526;
            }
         }
      }
   }
}
