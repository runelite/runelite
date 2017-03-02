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
   @ObfuscatedName("nv")
   @ObfuscatedGetter(
      intValue = -1847565025
   )
   static int field1174;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      longValue = -3302281709295698133L
   )
   @Export("position")
   long position;
   @ObfuscatedName("b")
   @Export("file")
   RandomAccessFile file;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      longValue = 6524665069296974635L
   )
   @Export("length")
   long length;

   @ObfuscatedName("b")
   final void method1467(long var1) throws IOException {
      this.file.seek(var1);
      this.position = var1;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "3"
   )
   public final void method1468(byte[] var1, int var2, int var3) throws IOException {
      if(this.position + (long)var3 > this.length) {
         this.file.seek(this.length + 1L);
         this.file.write(1);
         throw new EOFException();
      } else {
         this.file.write(var1, var2, var3);
         this.position += (long)var3;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "578540154"
   )
   public final int method1469(byte[] var1, int var2, int var3) throws IOException {
      int var4 = this.file.read(var1, var2, var3);
      if(var4 > 0) {
         this.position += (long)var4;
      }

      return var4;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "-2138627098"
   )
   public final long method1470() throws IOException {
      return this.file.length();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2114016341"
   )
   public final void method1471() throws IOException {
      if(null != this.file) {
         this.file.close();
         this.file = null;
      }

   }

   protected void finalize() throws Throwable {
      if(this.file != null) {
         System.out.println("");
         this.method1471();
      }

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

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-98"
   )
   public static void method1485(int var0) {
      class115.mouseIdleTicks = var0;
   }

   @ObfuscatedName("dg")
   @ObfuscatedSignature(
      signature = "(LWidget;IIB)V",
      garbageValue = "-64"
   )
   static final void method1487(Widget var0, int var1, int var2) {
      if(null == Client.field458 && !Client.isMenuOpen) {
         if(null != var0 && class47.method955(var0) != null) {
            Client.field458 = var0;
            Client.field459 = class47.method955(var0);
            Client.field460 = var1;
            Client.field461 = var2;
            class138.field1919 = 0;
            Client.field469 = false;
            int var3 = class7.method110();
            if(var3 != -1) {
               class180.field2698 = new class38();
               class180.field2698.field797 = Client.menuActionParams0[var3];
               class180.field2698.field790 = Client.menuActionParams1[var3];
               class180.field2698.field791 = Client.menuTypes[var3];
               class180.field2698.field792 = Client.menuIdentifiers[var3];
               class180.field2698.field793 = Client.menuOptions[var3];
            }

         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "([BI)LFont;",
      garbageValue = "-1039005817"
   )
   public static Font method1488(byte[] var0) {
      if(var0 == null) {
         return null;
      } else {
         Font var1 = new Font(var0, class225.field3229, class155.field2105, class172.field2351, class225.field3230, class225.field3231, class225.field3232);
         class0.method13();
         return var1;
      }
   }
}
