import java.awt.FontMetrics;
import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dq")
@Implements("CacheFile")
public class CacheFile {
   @ObfuscatedName("ab")
   static FontMetrics field1676;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Ldp;"
   )
   @Export("accessFile")
   FileOnDisk accessFile;
   @ObfuscatedName("i")
   @Export("readPayload")
   byte[] readPayload;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      longValue = -4287699158974578759L
   )
   long field1675;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1636442303
   )
   int field1681;
   @ObfuscatedName("k")
   @Export("writePayload")
   byte[] writePayload;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      longValue = -4599449879649805595L
   )
   long field1678;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1544591387
   )
   int field1679;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      longValue = -3303374386081442213L
   )
   @Export("position")
   long position;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      longValue = 6829708687430738371L
   )
   @Export("length")
   long length;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      longValue = 321188635543818891L
   )
   @Export("capacity")
   long capacity;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      longValue = -1918782668834414291L
   )
   long field1683;

   @ObfuscatedSignature(
      signature = "(Ldp;II)V"
   )
   public CacheFile(FileOnDisk var1, int var2, int var3) throws IOException {
      this.field1675 = -1L;
      this.field1678 = -1L;
      this.field1679 = 0;
      this.accessFile = var1;
      this.capacity = this.length = var1.length();
      this.readPayload = new byte[var2];
      this.writePayload = new byte[var3];
      this.position = 0L;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1889334218"
   )
   @Export("close")
   public void close() throws IOException {
      this.flush();
      this.accessFile.close();
   }

   @ObfuscatedName("i")
   @Export("seek")
   public void seek(long var1) throws IOException {
      if(var1 < 0L) {
         throw new IOException("");
      } else {
         this.position = var1;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "-214794823"
   )
   @Export("length")
   public long length() {
      return this.capacity;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "93647544"
   )
   @Export("read")
   public void read(byte[] var1) throws IOException {
      this.read(var1, 0, var1.length);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "1506376877"
   )
   @Export("read")
   public void read(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(var3 + var2 > var1.length) {
            throw new ArrayIndexOutOfBoundsException(var3 + var2 - var1.length);
         }

         if(-1L != this.field1678 && this.position >= this.field1678 && (long)var3 + this.position <= this.field1678 + (long)this.field1679) {
            System.arraycopy(this.writePayload, (int)(this.position - this.field1678), var1, var2, var3);
            this.position += (long)var3;
            return;
         }

         long var4 = this.position;
         int var7 = var3;
         int var8;
         if(this.position >= this.field1675 && this.position < (long)this.field1681 + this.field1675) {
            var8 = (int)((long)this.field1681 - (this.position - this.field1675));
            if(var8 > var3) {
               var8 = var3;
            }

            System.arraycopy(this.readPayload, (int)(this.position - this.field1675), var1, var2, var8);
            this.position += (long)var8;
            var2 += var8;
            var3 -= var8;
         }

         if(var3 > this.readPayload.length) {
            this.accessFile.seek(this.position);

            for(this.field1683 = this.position; var3 > 0; var3 -= var8) {
               var8 = this.accessFile.read(var1, var2, var3);
               if(var8 == -1) {
                  break;
               }

               this.field1683 += (long)var8;
               this.position += (long)var8;
               var2 += var8;
            }
         } else if(var3 > 0) {
            this.load();
            var8 = var3;
            if(var3 > this.field1681) {
               var8 = this.field1681;
            }

            System.arraycopy(this.readPayload, 0, var1, var2, var8);
            var2 += var8;
            var3 -= var8;
            this.position += (long)var8;
         }

         if(-1L != this.field1678) {
            if(this.field1678 > this.position && var3 > 0) {
               var8 = var2 + (int)(this.field1678 - this.position);
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
            if(this.field1678 >= var4 && this.field1678 < var4 + (long)var7) {
               var13 = this.field1678;
            } else if(var4 >= this.field1678 && var4 < this.field1678 + (long)this.field1679) {
               var13 = var4;
            }

            if(this.field1678 + (long)this.field1679 > var4 && (long)this.field1679 + this.field1678 <= var4 + (long)var7) {
               var10 = (long)this.field1679 + this.field1678;
            } else if((long)var7 + var4 > this.field1678 && (long)var7 + var4 <= (long)this.field1679 + this.field1678) {
               var10 = (long)var7 + var4;
            }

            if(var13 > -1L && var10 > var13) {
               int var12 = (int)(var10 - var13);
               System.arraycopy(this.writePayload, (int)(var13 - this.field1678), var1, (int)(var13 - var4) + var2, var12);
               if(var10 > this.position) {
                  var3 = (int)((long)var3 - (var10 - this.position));
                  this.position = var10;
               }
            }
         }
      } catch (IOException var16) {
         this.field1683 = -1L;
         throw var16;
      }

      if(var3 > 0) {
         throw new EOFException();
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1038370147"
   )
   @Export("load")
   void load() throws IOException {
      this.field1681 = 0;
      if(this.field1683 != this.position) {
         this.accessFile.seek(this.position);
         this.field1683 = this.position;
      }

      int var1;
      for(this.field1675 = this.position; this.field1681 < this.readPayload.length; this.field1681 += var1) {
         var1 = this.accessFile.read(this.readPayload, this.field1681, this.readPayload.length - this.field1681);
         if(var1 == -1) {
            break;
         }

         this.field1683 += (long)var1;
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "([BIIS)V",
      garbageValue = "22937"
   )
   @Export("write")
   public void write(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(this.position + (long)var3 > this.capacity) {
            this.capacity = (long)var3 + this.position;
         }

         if(this.field1678 != -1L && (this.position < this.field1678 || this.position > this.field1678 + (long)this.field1679)) {
            this.flush();
         }

         if(-1L != this.field1678 && (long)var3 + this.position > this.field1678 + (long)this.writePayload.length) {
            int var4 = (int)((long)this.writePayload.length - (this.position - this.field1678));
            System.arraycopy(var1, var2, this.writePayload, (int)(this.position - this.field1678), var4);
            this.position += (long)var4;
            var2 += var4;
            var3 -= var4;
            this.field1679 = this.writePayload.length;
            this.flush();
         }

         if(var3 <= this.writePayload.length) {
            if(var3 > 0) {
               if(this.field1678 == -1L) {
                  this.field1678 = this.position;
               }

               System.arraycopy(var1, var2, this.writePayload, (int)(this.position - this.field1678), var3);
               this.position += (long)var3;
               if(this.position - this.field1678 > (long)this.field1679) {
                  this.field1679 = (int)(this.position - this.field1678);
               }

            }
         } else {
            if(this.position != this.field1683) {
               this.accessFile.seek(this.position);
               this.field1683 = this.position;
            }

            this.accessFile.write(var1, var2, var3);
            this.field1683 += (long)var3;
            if(this.field1683 > this.length) {
               this.length = this.field1683;
            }

            long var9 = -1L;
            long var6 = -1L;
            if(this.position >= this.field1675 && this.position < (long)this.field1681 + this.field1675) {
               var9 = this.position;
            } else if(this.field1675 >= this.position && this.field1675 < this.position + (long)var3) {
               var9 = this.field1675;
            }

            if(this.position + (long)var3 > this.field1675 && this.position + (long)var3 <= (long)this.field1681 + this.field1675) {
               var6 = (long)var3 + this.position;
            } else if((long)this.field1681 + this.field1675 > this.position && this.field1675 + (long)this.field1681 <= (long)var3 + this.position) {
               var6 = (long)this.field1681 + this.field1675;
            }

            if(var9 > -1L && var6 > var9) {
               int var8 = (int)(var6 - var9);
               System.arraycopy(var1, (int)((long)var2 + var9 - this.position), this.readPayload, (int)(var9 - this.field1675), var8);
            }

            this.position += (long)var3;
         }
      } catch (IOException var12) {
         this.field1683 = -1L;
         throw var12;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-692910301"
   )
   @Export("flush")
   void flush() throws IOException {
      if(-1L != this.field1678) {
         if(this.field1678 != this.field1683) {
            this.accessFile.seek(this.field1678);
            this.field1683 = this.field1678;
         }

         this.accessFile.write(this.writePayload, 0, this.field1679);
         this.field1683 += 1544591387L * (long)(this.field1679 * -1627028973);
         if(this.field1683 > this.length) {
            this.length = this.field1683;
         }

         long var1 = -1L;
         long var3 = -1L;
         if(this.field1678 >= this.field1675 && this.field1678 < (long)this.field1681 + this.field1675) {
            var1 = this.field1678;
         } else if(this.field1675 >= this.field1678 && this.field1675 < this.field1678 + (long)this.field1679) {
            var1 = this.field1675;
         }

         if((long)this.field1679 + this.field1678 > this.field1675 && (long)this.field1679 + this.field1678 <= this.field1675 + (long)this.field1681) {
            var3 = this.field1678 + (long)this.field1679;
         } else if(this.field1675 + (long)this.field1681 > this.field1678 && (long)this.field1681 + this.field1675 <= (long)this.field1679 + this.field1678) {
            var3 = (long)this.field1681 + this.field1675;
         }

         if(var1 > -1L && var3 > var1) {
            int var5 = (int)(var3 - var1);
            System.arraycopy(this.writePayload, (int)(var1 - this.field1678), this.readPayload, (int)(var1 - this.field1675), var5);
         }

         this.field1678 = -1L;
         this.field1679 = 0;
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(ILjm;IIIZB)V",
      garbageValue = "-94"
   )
   public static void method2509(int var0, IndexDataBase var1, int var2, int var3, int var4, boolean var5) {
      class229.field2680 = 1;
      class61.field714 = var1;
      class229.field2682 = var2;
      class152.field2129 = var3;
      Varcs.field1431 = var4;
      class313.field3910 = var5;
      BoundingBox3D.field249 = var0;
   }
}
