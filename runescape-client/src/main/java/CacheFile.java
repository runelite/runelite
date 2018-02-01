import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("db")
@Implements("CacheFile")
public class CacheFile {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Ldc;"
   )
   @Export("accessFile")
   FileOnDisk accessFile;
   @ObfuscatedName("i")
   @Export("readPayload")
   byte[] readPayload;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      longValue = 2214670790348307093L
   )
   long field1635;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1820179037
   )
   int field1634;
   @ObfuscatedName("j")
   @Export("writePayload")
   byte[] writePayload;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      longValue = 3836296197454268951L
   )
   long field1636;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 2137687103
   )
   int field1643;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      longValue = -2084999741179690597L
   )
   @Export("position")
   long position;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      longValue = -5641132720872942403L
   )
   @Export("length")
   long length;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      longValue = 4621610958166376653L
   )
   @Export("capacity")
   long capacity;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      longValue = 6153074236574281001L
   )
   long field1641;

   @ObfuscatedSignature(
      signature = "(Ldc;II)V"
   )
   public CacheFile(FileOnDisk var1, int var2, int var3) throws IOException {
      this.field1635 = -1L;
      this.field1636 = -1L;
      this.field1643 = 0;
      this.accessFile = var1;
      this.capacity = this.length = var1.length();
      this.readPayload = new byte[var2];
      this.writePayload = new byte[var3];
      this.position = 0L;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "7"
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

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "-787276746"
   )
   @Export("length")
   public long length() {
      return this.capacity;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "367565953"
   )
   @Export("read")
   public void read(byte[] var1) throws IOException {
      this.read(var1, 0, var1.length);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "105"
   )
   @Export("read")
   public void read(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(var3 + var2 > var1.length) {
            throw new ArrayIndexOutOfBoundsException(var3 + var2 - var1.length);
         }

         if(-1L != this.field1636 && this.position >= this.field1636 && (long)var3 + this.position <= this.field1636 + (long)this.field1643) {
            System.arraycopy(this.writePayload, (int)(this.position - this.field1636), var1, var2, var3);
            this.position += (long)var3;
            return;
         }

         long var4 = this.position;
         int var7 = var3;
         int var8;
         if(this.position >= this.field1635 && this.position < (long)this.field1634 + this.field1635) {
            var8 = (int)((long)this.field1634 - (this.position - this.field1635));
            if(var8 > var3) {
               var8 = var3;
            }

            System.arraycopy(this.readPayload, (int)(this.position - this.field1635), var1, var2, var8);
            this.position += (long)var8;
            var2 += var8;
            var3 -= var8;
         }

         if(var3 > this.readPayload.length) {
            this.accessFile.seek(this.position);

            for(this.field1641 = this.position; var3 > 0; var3 -= var8) {
               var8 = this.accessFile.read(var1, var2, var3);
               if(var8 == -1) {
                  break;
               }

               this.field1641 += (long)var8;
               this.position += (long)var8;
               var2 += var8;
            }
         } else if(var3 > 0) {
            this.load();
            var8 = var3;
            if(var3 > this.field1634) {
               var8 = this.field1634;
            }

            System.arraycopy(this.readPayload, 0, var1, var2, var8);
            var2 += var8;
            var3 -= var8;
            this.position += (long)var8;
         }

         if(this.field1636 != -1L) {
            if(this.field1636 > this.position && var3 > 0) {
               var8 = var2 + (int)(this.field1636 - this.position);
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
            if(this.field1636 >= var4 && this.field1636 < (long)var7 + var4) {
               var13 = this.field1636;
            } else if(var4 >= this.field1636 && var4 < (long)this.field1643 + this.field1636) {
               var13 = var4;
            }

            if(this.field1636 + (long)this.field1643 > var4 && (long)this.field1643 + this.field1636 <= (long)var7 + var4) {
               var10 = (long)this.field1643 + this.field1636;
            } else if((long)var7 + var4 > this.field1636 && var4 + (long)var7 <= (long)this.field1643 + this.field1636) {
               var10 = var4 + (long)var7;
            }

            if(var13 > -1L && var10 > var13) {
               int var12 = (int)(var10 - var13);
               System.arraycopy(this.writePayload, (int)(var13 - this.field1636), var1, (int)(var13 - var4) + var2, var12);
               if(var10 > this.position) {
                  var3 = (int)((long)var3 - (var10 - this.position));
                  this.position = var10;
               }
            }
         }
      } catch (IOException var16) {
         this.field1641 = -1L;
         throw var16;
      }

      if(var3 > 0) {
         throw new EOFException();
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1779603098"
   )
   @Export("load")
   void load() throws IOException {
      this.field1634 = 0;
      if(this.position != this.field1641) {
         this.accessFile.seek(this.position);
         this.field1641 = this.position;
      }

      int var1;
      for(this.field1635 = this.position; this.field1634 < this.readPayload.length; this.field1634 += var1) {
         var1 = this.accessFile.read(this.readPayload, this.field1634, this.readPayload.length - this.field1634);
         if(var1 == -1) {
            break;
         }

         this.field1641 += (long)var1;
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "0"
   )
   @Export("write")
   public void write(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(this.position + (long)var3 > this.capacity) {
            this.capacity = (long)var3 + this.position;
         }

         if(this.field1636 != -1L && (this.position < this.field1636 || this.position > (long)this.field1643 + this.field1636)) {
            this.flush();
         }

         if(-1L != this.field1636 && this.position + (long)var3 > (long)this.writePayload.length + this.field1636) {
            int var4 = (int)((long)this.writePayload.length - (this.position - this.field1636));
            System.arraycopy(var1, var2, this.writePayload, (int)(this.position - this.field1636), var4);
            this.position += (long)var4;
            var2 += var4;
            var3 -= var4;
            this.field1643 = this.writePayload.length;
            this.flush();
         }

         if(var3 <= this.writePayload.length) {
            if(var3 > 0) {
               if(-1L == this.field1636) {
                  this.field1636 = this.position;
               }

               System.arraycopy(var1, var2, this.writePayload, (int)(this.position - this.field1636), var3);
               this.position += (long)var3;
               if(this.position - this.field1636 > (long)this.field1643) {
                  this.field1643 = (int)(this.position - this.field1636);
               }

            }
         } else {
            if(this.position != this.field1641) {
               this.accessFile.seek(this.position);
               this.field1641 = this.position;
            }

            this.accessFile.write(var1, var2, var3);
            this.field1641 += (long)var3;
            if(this.field1641 > this.length) {
               this.length = this.field1641;
            }

            long var9 = -1L;
            long var6 = -1L;
            if(this.position >= this.field1635 && this.position < this.field1635 + (long)this.field1634) {
               var9 = this.position;
            } else if(this.field1635 >= this.position && this.field1635 < this.position + (long)var3) {
               var9 = this.field1635;
            }

            if(this.position + (long)var3 > this.field1635 && this.position + (long)var3 <= (long)this.field1634 + this.field1635) {
               var6 = (long)var3 + this.position;
            } else if((long)this.field1634 + this.field1635 > this.position && (long)this.field1634 + this.field1635 <= (long)var3 + this.position) {
               var6 = this.field1635 + (long)this.field1634;
            }

            if(var9 > -1L && var6 > var9) {
               int var8 = (int)(var6 - var9);
               System.arraycopy(var1, (int)(var9 + (long)var2 - this.position), this.readPayload, (int)(var9 - this.field1635), var8);
            }

            this.position += (long)var3;
         }
      } catch (IOException var12) {
         this.field1641 = -1L;
         throw var12;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-110"
   )
   @Export("flush")
   void flush() throws IOException {
      if(-1L != this.field1636) {
         if(this.field1636 != this.field1641) {
            this.accessFile.seek(this.field1636);
            this.field1641 = this.field1636;
         }

         this.accessFile.write(this.writePayload, 0, this.field1643);
         this.field1641 += (long)(this.field1643 * 1904176063) * 2137687103L;
         if(this.field1641 > this.length) {
            this.length = this.field1641;
         }

         long var1 = -1L;
         long var3 = -1L;
         if(this.field1636 >= this.field1635 && this.field1636 < (long)this.field1634 + this.field1635) {
            var1 = this.field1636;
         } else if(this.field1635 >= this.field1636 && this.field1635 < (long)this.field1643 + this.field1636) {
            var1 = this.field1635;
         }

         if((long)this.field1643 + this.field1636 > this.field1635 && (long)this.field1643 + this.field1636 <= (long)this.field1634 + this.field1635) {
            var3 = (long)this.field1643 + this.field1636;
         } else if(this.field1635 + (long)this.field1634 > this.field1636 && (long)this.field1634 + this.field1635 <= this.field1636 + (long)this.field1643) {
            var3 = (long)this.field1634 + this.field1635;
         }

         if(var1 > -1L && var3 > var1) {
            int var5 = (int)(var3 - var1);
            System.arraycopy(this.writePayload, (int)(var1 - this.field1636), this.readPayload, (int)(var1 - this.field1635), var5);
         }

         this.field1636 = -1L;
         this.field1643 = 0;
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)Ljm;",
      garbageValue = "-1355177529"
   )
   @Export("getAnimation")
   public static Sequence getAnimation(int var0) {
      Sequence var1 = (Sequence)Sequence.sequences.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Sequence.seq_ref.getConfigData(12, var0);
         var1 = new Sequence();
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         var1.post();
         Sequence.sequences.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lik;Lik;Lik;Lhq;I)Z",
      garbageValue = "-2109959667"
   )
   public static boolean method2476(IndexDataBase var0, IndexDataBase var1, IndexDataBase var2, class215 var3) {
      class214.field2598 = var0;
      class214.field2593 = var1;
      class214.field2592 = var2;
      class214.field2595 = var3;
      return true;
   }
}
