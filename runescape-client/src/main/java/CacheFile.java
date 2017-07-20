import java.io.EOFException;
import java.io.IOException;
import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ds")
@Implements("CacheFile")
public class CacheFile {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      longValue = -3263912319047505647L
   )
   long field1724;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 564751999
   )
   int field1718;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      longValue = 4849791634038814791L
   )
   long field1720;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      longValue = -5429615958926528065L
   )
   long field1723;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      longValue = -808869899873598611L
   )
   @Export("position")
   long position;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      longValue = -8412094420725159811L
   )
   long field1717;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Ldx;"
   )
   FileOnDisk field1722;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1066762775
   )
   int field1721;
   @ObfuscatedName("g")
   @Export("writePayload")
   byte[] writePayload;
   @ObfuscatedName("o")
   @Export("readPayload")
   byte[] readPayload;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      longValue = -7105862234181573813L
   )
   @Export("length")
   long length;

   @ObfuscatedSignature(
      signature = "(Ldx;II)V"
   )
   public CacheFile(FileOnDisk var1, int var2, int var3) throws IOException {
      this.field1717 = -1L;
      this.field1723 = -1L;
      this.field1721 = 0;
      this.field1722 = var1;
      this.field1724 = this.length = var1.length();
      this.readPayload = new byte[var2];
      this.writePayload = new byte[var3];
      this.position = 0L;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "371718483"
   )
   public void method2258(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(var3 + var2 > var1.length) {
            throw new ArrayIndexOutOfBoundsException(var3 + var2 - var1.length);
         }

         if(-1L != this.field1723 && this.position >= this.field1723 && (long)var3 + this.position <= (long)this.field1721 + this.field1723) {
            System.arraycopy(this.writePayload, (int)(this.position - this.field1723), var1, var2, var3);
            this.position += (long)var3;
            return;
         }

         long var4 = this.position;
         int var7 = var3;
         int var8;
         if(this.position >= this.field1717 && this.position < (long)this.field1718 + this.field1717) {
            var8 = (int)((long)this.field1718 - (this.position - this.field1717));
            if(var8 > var3) {
               var8 = var3;
            }

            System.arraycopy(this.readPayload, (int)(this.position - this.field1717), var1, var2, var8);
            this.position += (long)var8;
            var2 += var8;
            var3 -= var8;
         }

         if(var3 > this.readPayload.length) {
            this.field1722.seek(this.position);

            for(this.field1720 = this.position; var3 > 0; var3 -= var8) {
               var8 = this.field1722.read(var1, var2, var3);
               if(var8 == -1) {
                  break;
               }

               this.field1720 += (long)var8;
               this.position += (long)var8;
               var2 += var8;
            }
         } else if(var3 > 0) {
            this.method2259();
            var8 = var3;
            if(var3 > this.field1718) {
               var8 = this.field1718;
            }

            System.arraycopy(this.readPayload, 0, var1, var2, var8);
            var2 += var8;
            var3 -= var8;
            this.position += (long)var8;
         }

         if(this.field1723 != -1L) {
            if(this.field1723 > this.position && var3 > 0) {
               var8 = var2 + (int)(this.field1723 - this.position);
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
            if(this.field1723 >= var4 && this.field1723 < var4 + (long)var7) {
               var13 = this.field1723;
            } else if(var4 >= this.field1723 && var4 < (long)this.field1721 + this.field1723) {
               var13 = var4;
            }

            if((long)this.field1721 + this.field1723 > var4 && (long)this.field1721 + this.field1723 <= var4 + (long)var7) {
               var10 = this.field1723 + (long)this.field1721;
            } else if((long)var7 + var4 > this.field1723 && (long)var7 + var4 <= this.field1723 + (long)this.field1721) {
               var10 = (long)var7 + var4;
            }

            if(var13 > -1L && var10 > var13) {
               int var12 = (int)(var10 - var13);
               System.arraycopy(this.writePayload, (int)(var13 - this.field1723), var1, (int)(var13 - var4) + var2, var12);
               if(var10 > this.position) {
                  var3 = (int)((long)var3 - (var10 - this.position));
                  this.position = var10;
               }
            }
         }
      } catch (IOException var16) {
         this.field1720 = -1L;
         throw var16;
      }

      if(var3 > 0) {
         throw new EOFException();
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1344056541"
   )
   void method2255() throws IOException {
      if(this.field1723 != -1L) {
         if(this.field1723 != this.field1720) {
            this.field1722.seek(this.field1723);
            this.field1720 = this.field1723;
         }

         this.field1722.write(this.writePayload, 0, this.field1721);
         this.field1720 += 1066762775L * (long)(this.field1721 * 494785959);
         if(this.field1720 > this.length) {
            this.length = this.field1720;
         }

         long var1 = -1L;
         long var3 = -1L;
         if(this.field1723 >= this.field1717 && this.field1723 < this.field1717 + (long)this.field1718) {
            var1 = this.field1723;
         } else if(this.field1717 >= this.field1723 && this.field1717 < this.field1723 + (long)this.field1721) {
            var1 = this.field1717;
         }

         if(this.field1723 + (long)this.field1721 > this.field1717 && this.field1723 + (long)this.field1721 <= (long)this.field1718 + this.field1717) {
            var3 = this.field1723 + (long)this.field1721;
         } else if((long)this.field1718 + this.field1717 > this.field1723 && (long)this.field1718 + this.field1717 <= (long)this.field1721 + this.field1723) {
            var3 = this.field1717 + (long)this.field1718;
         }

         if(var1 > -1L && var3 > var1) {
            int var5 = (int)(var3 - var1);
            System.arraycopy(this.writePayload, (int)(var1 - this.field1723), this.readPayload, (int)(var1 - this.field1717), var5);
         }

         this.field1723 = -1L;
         this.field1721 = 0;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "283543843"
   )
   public long method2257() {
      return this.field1724;
   }

   @ObfuscatedName("o")
   @Export("seek")
   public void seek(long var1) throws IOException {
      if(var1 < 0L) {
         throw new IOException("");
      } else {
         this.position = var1;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "-57"
   )
   @Export("write")
   public void write(byte[] var1, int var2, int var3) throws IOException {
      try {
         if((long)var3 + this.position > this.field1724) {
            this.field1724 = this.position + (long)var3;
         }

         if(this.field1723 != -1L && (this.position < this.field1723 || this.position > this.field1723 + (long)this.field1721)) {
            this.method2255();
         }

         if(-1L != this.field1723 && this.position + (long)var3 > this.field1723 + (long)this.writePayload.length) {
            int var4 = (int)((long)this.writePayload.length - (this.position - this.field1723));
            System.arraycopy(var1, var2, this.writePayload, (int)(this.position - this.field1723), var4);
            this.position += (long)var4;
            var2 += var4;
            var3 -= var4;
            this.field1721 = this.writePayload.length;
            this.method2255();
         }

         if(var3 <= this.writePayload.length) {
            if(var3 > 0) {
               if(this.field1723 == -1L) {
                  this.field1723 = this.position;
               }

               System.arraycopy(var1, var2, this.writePayload, (int)(this.position - this.field1723), var3);
               this.position += (long)var3;
               if(this.position - this.field1723 > (long)this.field1721) {
                  this.field1721 = (int)(this.position - this.field1723);
               }

            }
         } else {
            if(this.field1720 != this.position) {
               this.field1722.seek(this.position);
               this.field1720 = this.position;
            }

            this.field1722.write(var1, var2, var3);
            this.field1720 += (long)var3;
            if(this.field1720 > this.length) {
               this.length = this.field1720;
            }

            long var9 = -1L;
            long var6 = -1L;
            if(this.position >= this.field1717 && this.position < (long)this.field1718 + this.field1717) {
               var9 = this.position;
            } else if(this.field1717 >= this.position && this.field1717 < this.position + (long)var3) {
               var9 = this.field1717;
            }

            if(this.position + (long)var3 > this.field1717 && (long)var3 + this.position <= this.field1717 + (long)this.field1718) {
               var6 = (long)var3 + this.position;
            } else if((long)this.field1718 + this.field1717 > this.position && (long)this.field1718 + this.field1717 <= this.position + (long)var3) {
               var6 = this.field1717 + (long)this.field1718;
            }

            if(var9 > -1L && var6 > var9) {
               int var8 = (int)(var6 - var9);
               System.arraycopy(var1, (int)((long)var2 + var9 - this.position), this.readPayload, (int)(var9 - this.field1717), var8);
            }

            this.position += (long)var3;
         }
      } catch (IOException var12) {
         this.field1720 = -1L;
         throw var12;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "72"
   )
   void method2259() throws IOException {
      this.field1718 = 0;
      if(this.position != this.field1720) {
         this.field1722.seek(this.position);
         this.field1720 = this.position;
      }

      int var1;
      for(this.field1717 = this.position; this.field1718 < this.readPayload.length; this.field1718 += var1) {
         var1 = this.field1722.read(this.readPayload, this.field1718, this.readPayload.length - this.field1718);
         if(var1 == -1) {
            break;
         }

         this.field1720 += (long)var1;
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-68"
   )
   public void method2282() throws IOException {
      this.method2255();
      this.field1722.close();
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-21829469"
   )
   @Export("read")
   public void read(byte[] var1) throws IOException {
      this.method2258(var1, 0, var1.length);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "1714862103"
   )
   static String method2283() {
      String var0 = "";

      MessageNode var2;
      for(Iterator var1 = class98.field1495.iterator(); var1.hasNext(); var0 = var0 + var2.name + ':' + var2.value + '\n') {
         var2 = (MessageNode)var1.next();
      }

      return var0;
   }
}
