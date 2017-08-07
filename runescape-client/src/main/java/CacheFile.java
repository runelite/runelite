import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("do")
@Implements("CacheFile")
public class CacheFile {
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      longValue = -4635411454823055233L
   )
   long field1748;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      longValue = -6505330231784609993L
   )
   long field1739;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1347707981
   )
   int field1747;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      longValue = 8838793997080844093L
   )
   long field1744;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      longValue = -7057215160944708307L
   )
   @Export("position")
   long position;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      longValue = -1968876849771652885L
   )
   long field1741;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Ldk;"
   )
   FileOnDisk field1742;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1754087187
   )
   int field1745;
   @ObfuscatedName("w")
   @Export("writePayload")
   byte[] writePayload;
   @ObfuscatedName("n")
   @Export("readPayload")
   byte[] readPayload;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      longValue = 426398395559840729L
   )
   @Export("length")
   long length;

   @ObfuscatedSignature(
      signature = "(Ldk;II)V"
   )
   public CacheFile(FileOnDisk var1, int var2, int var3) throws IOException {
      this.field1741 = -1L;
      this.field1744 = -1L;
      this.field1745 = 0;
      this.field1742 = var1;
      this.field1748 = this.length = var1.length();
      this.readPayload = new byte[var2];
      this.writePayload = new byte[var3];
      this.position = 0L;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "-11"
   )
   public void method2350(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(var3 + var2 > var1.length) {
            throw new ArrayIndexOutOfBoundsException(var3 + var2 - var1.length);
         }

         if(this.field1744 != -1L && this.position >= this.field1744 && (long)var3 + this.position <= (long)this.field1745 + this.field1744) {
            System.arraycopy(this.writePayload, (int)(this.position - this.field1744), var1, var2, var3);
            this.position += (long)var3;
            return;
         }

         long var4 = this.position;
         int var7 = var3;
         int var8;
         if(this.position >= this.field1741 && this.position < this.field1741 + (long)this.field1747) {
            var8 = (int)((long)this.field1747 - (this.position - this.field1741));
            if(var8 > var3) {
               var8 = var3;
            }

            System.arraycopy(this.readPayload, (int)(this.position - this.field1741), var1, var2, var8);
            this.position += (long)var8;
            var2 += var8;
            var3 -= var8;
         }

         if(var3 > this.readPayload.length) {
            this.field1742.seek(this.position);

            for(this.field1739 = this.position; var3 > 0; var3 -= var8) {
               var8 = this.field1742.read(var1, var2, var3);
               if(var8 == -1) {
                  break;
               }

               this.field1739 += (long)var8;
               this.position += (long)var8;
               var2 += var8;
            }
         } else if(var3 > 0) {
            this.method2365();
            var8 = var3;
            if(var3 > this.field1747) {
               var8 = this.field1747;
            }

            System.arraycopy(this.readPayload, 0, var1, var2, var8);
            var2 += var8;
            var3 -= var8;
            this.position += (long)var8;
         }

         if(this.field1744 != -1L) {
            if(this.field1744 > this.position && var3 > 0) {
               var8 = var2 + (int)(this.field1744 - this.position);
               if(var8 > var3 + var2) {
                  var8 = var3 + var2;
               }

               while(var2 < var8) {
                  var1[var2++] = 0;
                  --var3;
                  ++this.position;
               }
            }

            long var13 = -1L;
            long var10 = -1L;
            if(this.field1744 >= var4 && this.field1744 < (long)var7 + var4) {
               var13 = this.field1744;
            } else if(var4 >= this.field1744 && var4 < (long)this.field1745 + this.field1744) {
               var13 = var4;
            }

            if(this.field1744 + (long)this.field1745 > var4 && this.field1744 + (long)this.field1745 <= (long)var7 + var4) {
               var10 = this.field1744 + (long)this.field1745;
            } else if(var4 + (long)var7 > this.field1744 && var4 + (long)var7 <= (long)this.field1745 + this.field1744) {
               var10 = var4 + (long)var7;
            }

            if(var13 > -1L && var10 > var13) {
               int var12 = (int)(var10 - var13);
               System.arraycopy(this.writePayload, (int)(var13 - this.field1744), var1, (int)(var13 - var4) + var2, var12);
               if(var10 > this.position) {
                  var3 = (int)((long)var3 - (var10 - this.position));
                  this.position = var10;
               }
            }
         }
      } catch (IOException var16) {
         this.field1739 = -1L;
         throw var16;
      }

      if(var3 > 0) {
         throw new EOFException();
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1903070643"
   )
   void method2347() throws IOException {
      if(-1L != this.field1744) {
         if(this.field1744 != this.field1739) {
            this.field1742.seek(this.field1744);
            this.field1739 = this.field1744;
         }

         this.field1742.write(this.writePayload, 0, this.field1745);
         this.field1739 += -1754087187L * (long)(this.field1745 * 667786469);
         if(this.field1739 > this.length) {
            this.length = this.field1739;
         }

         long var1 = -1L;
         long var3 = -1L;
         if(this.field1744 >= this.field1741 && this.field1744 < this.field1741 + (long)this.field1747) {
            var1 = this.field1744;
         } else if(this.field1741 >= this.field1744 && this.field1741 < this.field1744 + (long)this.field1745) {
            var1 = this.field1741;
         }

         if(this.field1744 + (long)this.field1745 > this.field1741 && (long)this.field1745 + this.field1744 <= (long)this.field1747 + this.field1741) {
            var3 = this.field1744 + (long)this.field1745;
         } else if(this.field1741 + (long)this.field1747 > this.field1744 && this.field1741 + (long)this.field1747 <= (long)this.field1745 + this.field1744) {
            var3 = this.field1741 + (long)this.field1747;
         }

         if(var1 > -1L && var3 > var1) {
            int var5 = (int)(var3 - var1);
            System.arraycopy(this.writePayload, (int)(var1 - this.field1744), this.readPayload, (int)(var1 - this.field1741), var5);
         }

         this.field1744 = -1L;
         this.field1745 = 0;
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "1040972711"
   )
   public long method2346() {
      return this.field1748;
   }

   @ObfuscatedName("n")
   @Export("seek")
   public void seek(long var1) throws IOException {
      if(var1 < 0L) {
         throw new IOException("");
      } else {
         this.position = var1;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "43"
   )
   @Export("write")
   public void write(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(this.position + (long)var3 > this.field1748) {
            this.field1748 = (long)var3 + this.position;
         }

         if(this.field1744 != -1L && (this.position < this.field1744 || this.position > this.field1744 + (long)this.field1745)) {
            this.method2347();
         }

         if(-1L != this.field1744 && (long)var3 + this.position > this.field1744 + (long)this.writePayload.length) {
            int var4 = (int)((long)this.writePayload.length - (this.position - this.field1744));
            System.arraycopy(var1, var2, this.writePayload, (int)(this.position - this.field1744), var4);
            this.position += (long)var4;
            var2 += var4;
            var3 -= var4;
            this.field1745 = this.writePayload.length;
            this.method2347();
         }

         if(var3 <= this.writePayload.length) {
            if(var3 > 0) {
               if(this.field1744 == -1L) {
                  this.field1744 = this.position;
               }

               System.arraycopy(var1, var2, this.writePayload, (int)(this.position - this.field1744), var3);
               this.position += (long)var3;
               if(this.position - this.field1744 > (long)this.field1745) {
                  this.field1745 = (int)(this.position - this.field1744);
               }

            }
         } else {
            if(this.field1739 != this.position) {
               this.field1742.seek(this.position);
               this.field1739 = this.position;
            }

            this.field1742.write(var1, var2, var3);
            this.field1739 += (long)var3;
            if(this.field1739 > this.length) {
               this.length = this.field1739;
            }

            long var9 = -1L;
            long var6 = -1L;
            if(this.position >= this.field1741 && this.position < this.field1741 + (long)this.field1747) {
               var9 = this.position;
            } else if(this.field1741 >= this.position && this.field1741 < this.position + (long)var3) {
               var9 = this.field1741;
            }

            if((long)var3 + this.position > this.field1741 && this.position + (long)var3 <= (long)this.field1747 + this.field1741) {
               var6 = (long)var3 + this.position;
            } else if((long)this.field1747 + this.field1741 > this.position && (long)this.field1747 + this.field1741 <= (long)var3 + this.position) {
               var6 = this.field1741 + (long)this.field1747;
            }

            if(var9 > -1L && var6 > var9) {
               int var8 = (int)(var6 - var9);
               System.arraycopy(var1, (int)(var9 + (long)var2 - this.position), this.readPayload, (int)(var9 - this.field1741), var8);
            }

            this.position += (long)var3;
         }
      } catch (IOException var12) {
         this.field1739 = -1L;
         throw var12;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1458921133"
   )
   void method2365() throws IOException {
      this.field1747 = 0;
      if(this.position != this.field1739) {
         this.field1742.seek(this.position);
         this.field1739 = this.position;
      }

      int var1;
      for(this.field1741 = this.position; this.field1747 < this.readPayload.length; this.field1747 += var1) {
         var1 = this.field1742.read(this.readPayload, this.field1747, this.readPayload.length - this.field1747);
         if(var1 == -1) {
            break;
         }

         this.field1739 += (long)var1;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1738171154"
   )
   public void method2357() throws IOException {
      this.method2347();
      this.field1742.close();
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "([BB)V",
      garbageValue = "3"
   )
   @Export("read")
   public void read(byte[] var1) throws IOException {
      this.method2350(var1, 0, var1.length);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;II)I",
      garbageValue = "-810269843"
   )
   public static int method2371(CharSequence var0, CharSequence var1, int var2) {
      int var3 = var0.length();
      int var4 = var1.length();
      int var5 = 0;
      int var6 = 0;
      char var7 = 0;
      byte var8 = 0;

      while(var5 - var7 < var3 || var6 - var8 < var4) {
         if(var5 - var7 >= var3) {
            return -1;
         }

         if(var6 - var8 >= var4) {
            return 1;
         }

         char var9;
         if(var7 != 0) {
            var9 = var7;
            boolean var14 = false;
         } else {
            var9 = var0.charAt(var5++);
         }

         char var10;
         if(var8 != 0) {
            var10 = (char)var8;
            boolean var15 = false;
         } else {
            var10 = var1.charAt(var6++);
         }

         var7 = class150.method2942(var9);
         byte var11;
         if(var10 == 198) {
            var11 = 69;
         } else if(var10 == 230) {
            var11 = 101;
         } else if(var10 == 223) {
            var11 = 115;
         } else if(var10 == 338) {
            var11 = 69;
         } else if(var10 == 339) {
            var11 = 101;
         } else {
            var11 = 0;
         }

         var8 = var11;
         var9 = class39.method539(var9, var2);
         var10 = class39.method539(var10, var2);
         if(var10 != var9 && Character.toUpperCase(var9) != Character.toUpperCase(var10)) {
            var9 = Character.toLowerCase(var9);
            var10 = Character.toLowerCase(var10);
            if(var9 != var10) {
               return Projectile.method1783(var9, var2) - Projectile.method1783(var10, var2);
            }
         }
      }

      int var16 = Math.min(var3, var4);

      char var12;
      int var17;
      for(var17 = 0; var17 < var16; ++var17) {
         char var18 = var0.charAt(var17);
         var12 = var1.charAt(var17);
         if(var12 != var18 && Character.toUpperCase(var18) != Character.toUpperCase(var12)) {
            var18 = Character.toLowerCase(var18);
            var12 = Character.toLowerCase(var12);
            if(var18 != var12) {
               return Projectile.method1783(var18, var2) - Projectile.method1783(var12, var2);
            }
         }
      }

      var17 = var3 - var4;
      if(var17 != 0) {
         return var17;
      } else {
         for(int var19 = 0; var19 < var16; ++var19) {
            var12 = var0.charAt(var19);
            char var13 = var1.charAt(var19);
            if(var12 != var13) {
               return Projectile.method1783(var12, var2) - Projectile.method1783(var13, var2);
            }
         }

         return 0;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lcq;Lcq;IZIZS)I",
      garbageValue = "202"
   )
   static int method2372(World var0, World var1, int var2, boolean var3, int var4, boolean var5) {
      int var6 = PendingSpawn.method1522(var0, var1, var2, var3);
      if(var6 != 0) {
         return var3?-var6:var6;
      } else if(var4 == -1) {
         return 0;
      } else {
         int var7 = PendingSpawn.method1522(var0, var1, var4, var5);
         return var5?-var7:var7;
      }
   }
}
