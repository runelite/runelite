import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bz")
@Implements("FileOnDisk")
public final class FileOnDisk {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      longValue = -6511922456311017321L
   )
   @Export("length")
   long length;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      longValue = -8757647802192122013L
   )
   @Export("position")
   long position;
   @ObfuscatedName("ac")
   static class102 field1200;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = 382851071
   )
   static int field1201;
   @ObfuscatedName("cd")
   @ObfuscatedGetter(
      intValue = 1136300065
   )
   public static int field1202;
   @ObfuscatedName("dg")
   @ObfuscatedGetter(
      intValue = -1703121737
   )
   static int field1203;
   @ObfuscatedName("x")
   @Export("file")
   RandomAccessFile file;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "656345339"
   )
   public final int method1476(byte[] var1, int var2, int var3) throws IOException {
      int var4 = this.file.read(var1, var2, var3);
      if(var4 > 0) {
         this.position += (long)var4;
      }

      return var4;
   }

   @ObfuscatedName("x")
   final void method1477(long var1) throws IOException {
      this.file.seek(var1);
      this.position = var1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   public final void method1479() throws IOException {
      if(this.file != null) {
         this.file.close();
         this.file = null;
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)J",
      garbageValue = "51"
   )
   public final long method1480() throws IOException {
      return this.file.length();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-691810477"
   )
   public final void method1481(byte[] var1, int var2, int var3) throws IOException {
      if(this.position + (long)var3 > this.length) {
         this.file.seek(1L + this.length);
         this.file.write(1);
         throw new EOFException();
      } else {
         this.file.write(var1, var2, var3);
         this.position += (long)var3;
      }
   }

   protected void finalize() throws Throwable {
      if(null != this.file) {
         System.out.println("");
         this.method1479();
      }

   }

   public FileOnDisk(File var1, String var2, long var3) throws IOException {
      if(-1L == var3) {
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

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(CI)C",
      garbageValue = "61635301"
   )
   static char method1492(char var0) {
      return var0 != 181 && var0 != 402?Character.toTitleCase(var0):var0;
   }
}
