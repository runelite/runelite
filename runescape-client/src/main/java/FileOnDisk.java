import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bx")
@Implements("FileOnDisk")
public final class FileOnDisk {
   @ObfuscatedName("f")
   @Export("file")
   RandomAccessFile file;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      longValue = 4699944321656828799L
   )
   @Export("position")
   long position;
   @ObfuscatedName("bu")
   @Export("indexSprites")
   static IndexData indexSprites;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      longValue = 1387621246430742515L
   )
   @Export("length")
   long length;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;B)I",
      garbageValue = "-27"
   )
   static int method1445(class182 var0, class182 var1) {
      int var2 = 0;
      if(var0.method3354("title.jpg", "")) {
         ++var2;
      }

      if(var1.method3354("logo", "")) {
         ++var2;
      }

      if(var1.method3354("logo_deadman_mode", "")) {
         ++var2;
      }

      if(var1.method3354("titlebox", "")) {
         ++var2;
      }

      if(var1.method3354("titlebutton", "")) {
         ++var2;
      }

      if(var1.method3354("runes", "")) {
         ++var2;
      }

      if(var1.method3354("title_mute", "")) {
         ++var2;
      }

      if(var1.method3365("options_radio_buttons,0")) {
         ++var2;
      }

      if(var1.method3365("options_radio_buttons,2")) {
         ++var2;
      }

      var1.method3354("sl_back", "");
      var1.method3354("sl_flags", "");
      var1.method3354("sl_arrows", "");
      var1.method3354("sl_stars", "");
      var1.method3354("sl_button", "");
      return var2;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "1570124504"
   )
   public final void method1447(byte[] var1, int var2, int var3) throws IOException {
      if(this.position + (long)var3 > this.length) {
         this.file.seek(1L + this.length);
         this.file.write(1);
         throw new EOFException();
      } else {
         this.file.write(var1, var2, var3);
         this.position += (long)var3;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "65"
   )
   public final void method1448() throws IOException {
      if(null != this.file) {
         this.file.close();
         this.file = null;
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "-604054846"
   )
   public final long method1449() throws IOException {
      return this.file.length();
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "1788312400"
   )
   public final int method1450(byte[] var1, int var2, int var3) throws IOException {
      int var4 = this.file.read(var1, var2, var3);
      if(var4 > 0) {
         this.position += (long)var4;
      }

      return var4;
   }

   @ObfuscatedName("f")
   final void method1453(long var1) throws IOException {
      this.file.seek(var1);
      this.position = var1;
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

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(ZZI)I",
      garbageValue = "-1004742915"
   )
   public static int method1455(boolean var0, boolean var1) {
      byte var2 = 0;
      int var3 = var2 + class185.field2766 + class185.field2774;
      return var3;
   }

   protected void finalize() throws Throwable {
      if(this.file != null) {
         System.out.println("");
         this.method1448();
      }

   }
}
