package net.runelite.rs.client;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hm")
public final class class226 {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      longValue = -5491611329971135641L
   )
   long field3197;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      longValue = -1222268832551527705L
   )
   long field3198;
   @ObfuscatedName("j")
   RandomAccessFile field3199;

   @ObfuscatedName("j")
   final void method4173(long var1) throws IOException {
      this.field3199.seek(var1);
      this.field3198 = var1;
   }

   @ObfuscatedName("l")
   public final long method4176() throws IOException {
      return this.field3199.length();
   }

   @ObfuscatedName("u")
   public final int method4177(byte[] var1, int var2, int var3) throws IOException {
      int var4 = this.field3199.read(var1, var2, var3);
      if(var4 > 0) {
         this.field3198 += (long)var4;
      }

      return var4;
   }

   protected void finalize() throws Throwable {
      if(null != this.field3199) {
         System.out.println("");
         this.method4183();
      }

   }

   @ObfuscatedName("f")
   public final void method4183() throws IOException {
      if(this.field3199 != null) {
         this.field3199.close();
         this.field3199 = null;
      }

   }

   public class226(File var1, String var2, long var3) throws IOException {
      if(var3 == -1L) {
         var3 = Long.MAX_VALUE;
      }

      if(var1.length() >= var3) {
         var1.delete();
      }

      this.field3199 = new RandomAccessFile(var1, var2);
      this.field3197 = var3;
      this.field3198 = 0L;
      int var5 = this.field3199.read();
      if(var5 != -1 && !var2.equals("r")) {
         this.field3199.seek(0L);
         this.field3199.write(var5);
      }

      this.field3199.seek(0L);
   }

   @ObfuscatedName("m")
   public final void method4185(byte[] var1, int var2, int var3) throws IOException {
      if((long)var3 + this.field3198 > this.field3197) {
         this.field3199.seek(this.field3197 + 1L);
         this.field3199.write(1);
         throw new EOFException();
      } else {
         this.field3199.write(var1, var2, var3);
         this.field3198 += (long)var3;
      }
   }
}
