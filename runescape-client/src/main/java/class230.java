import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hl")
@Implements("FileOnDisk")
public final class class230 {
   @ObfuscatedName("l")
   @Export("file")
   RandomAccessFile field3257;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      longValue = -4009065674402867081L
   )
   @Export("position")
   long field3258;
   @ObfuscatedName("e")
   static String[] field3259;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      longValue = -7996947393543454741L
   )
   @Export("length")
   long field3260;

   @ObfuscatedName("l")
   final void method4271(long var1) throws IOException {
      this.field3257.seek(var1);
      this.field3258 = var1;
   }

   public class230(File var1, String var2, long var3) throws IOException {
      if(var3 == -1L) {
         var3 = Long.MAX_VALUE;
      }

      if(var1.length() >= var3) {
         var1.delete();
      }

      this.field3257 = new RandomAccessFile(var1, var2);
      this.field3260 = var3;
      this.field3258 = 0L;
      int var5 = this.field3257.read();
      if(var5 != -1 && !var2.equals("r")) {
         this.field3257.seek(0L);
         this.field3257.write(var5);
      }

      this.field3257.seek(0L);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "-857236254"
   )
   public final long method4273() throws IOException {
      return this.field3257.length();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "([BIIS)I",
      garbageValue = "-16810"
   )
   public final int method4274(byte[] var1, int var2, int var3) throws IOException {
      int var4 = this.field3257.read(var1, var2, var3);
      if(var4 > 0) {
         this.field3258 += (long)var4;
      }

      return var4;
   }

   protected void finalize() throws Throwable {
      if(this.field3257 != null) {
         System.out.println("");
         this.method4283();
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "1677494714"
   )
   public final void method4275(byte[] var1, int var2, int var3) throws IOException {
      if((long)var3 + this.field3258 > this.field3260) {
         this.field3257.seek(this.field3260 + 1L);
         this.field3257.write(1);
         throw new EOFException();
      } else {
         this.field3257.write(var1, var2, var3);
         this.field3258 += (long)var3;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1852866503"
   )
   public final void method4283() throws IOException {
      if(this.field3257 != null) {
         this.field3257.close();
         this.field3257 = null;
      }

   }
}
