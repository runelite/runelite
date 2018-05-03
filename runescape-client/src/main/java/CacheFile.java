import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dm")
@Implements("CacheFile")
public class CacheFile {
   @ObfuscatedName("qf")
   @ObfuscatedSignature(
      signature = "Lcj;"
   )
   @Export("friendManager")
   public static FriendManager friendManager;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Ldb;"
   )
   @Export("accessFile")
   FileOnDisk accessFile;
   @ObfuscatedName("e")
   @Export("readPayload")
   byte[] readPayload;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      longValue = 8112277646389941977L
   )
   long field1658;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 2117671119
   )
   int field1659;
   @ObfuscatedName("n")
   @Export("writePayload")
   byte[] writePayload;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      longValue = 5604150678817006087L
   )
   long field1667;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1432820083
   )
   int field1662;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      longValue = 222308318850593107L
   )
   @Export("position")
   long position;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      longValue = 8097039660485562115L
   )
   @Export("length")
   long length;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      longValue = 9114034760577712113L
   )
   @Export("capacity")
   long capacity;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      longValue = 6786274596280194585L
   )
   long field1666;

   @ObfuscatedSignature(
      signature = "(Ldb;II)V"
   )
   public CacheFile(FileOnDisk var1, int var2, int var3) throws IOException {
      this.field1658 = -1L;
      this.field1667 = -1L;
      this.field1662 = 0;
      this.accessFile = var1;
      this.capacity = this.length = var1.length();
      this.readPayload = new byte[var2];
      this.writePayload = new byte[var3];
      this.position = 0L;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2119250912"
   )
   @Export("close")
   public void close() throws IOException {
      this.flush();
      this.accessFile.close();
   }

   @ObfuscatedName("e")
   @Export("seek")
   public void seek(long var1) throws IOException {
      if(var1 < 0L) {
         throw new IOException("");
      } else {
         this.position = var1;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)J",
      garbageValue = "-24"
   )
   @Export("length")
   public long length() {
      return this.capacity;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-42858199"
   )
   @Export("read")
   public void read(byte[] var1) throws IOException {
      this.read(var1, 0, var1.length);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "-87"
   )
   @Export("read")
   public void read(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(var3 + var2 > var1.length) {
            throw new ArrayIndexOutOfBoundsException(var3 + var2 - var1.length);
         }

         if(-1L != this.field1667 && this.position >= this.field1667 && this.position + (long)var3 <= this.field1667 + (long)this.field1662) {
            System.arraycopy(this.writePayload, (int)(this.position - this.field1667), var1, var2, var3);
            this.position += (long)var3;
            return;
         }

         long var4 = this.position;
         int var7 = var3;
         int var8;
         if(this.position >= this.field1658 && this.position < (long)this.field1659 + this.field1658) {
            var8 = (int)((long)this.field1659 - (this.position - this.field1658));
            if(var8 > var3) {
               var8 = var3;
            }

            System.arraycopy(this.readPayload, (int)(this.position - this.field1658), var1, var2, var8);
            this.position += (long)var8;
            var2 += var8;
            var3 -= var8;
         }

         if(var3 > this.readPayload.length) {
            this.accessFile.seek(this.position);

            for(this.field1666 = this.position; var3 > 0; var3 -= var8) {
               var8 = this.accessFile.read(var1, var2, var3);
               if(var8 == -1) {
                  break;
               }

               this.field1666 += (long)var8;
               this.position += (long)var8;
               var2 += var8;
            }
         } else if(var3 > 0) {
            this.load();
            var8 = var3;
            if(var3 > this.field1659) {
               var8 = this.field1659;
            }

            System.arraycopy(this.readPayload, 0, var1, var2, var8);
            var2 += var8;
            var3 -= var8;
            this.position += (long)var8;
         }

         if(this.field1667 != -1L) {
            if(this.field1667 > this.position && var3 > 0) {
               var8 = var2 + (int)(this.field1667 - this.position);
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
            if(this.field1667 >= var4 && this.field1667 < (long)var7 + var4) {
               var13 = this.field1667;
            } else if(var4 >= this.field1667 && var4 < this.field1667 + (long)this.field1662) {
               var13 = var4;
            }

            if(this.field1667 + (long)this.field1662 > var4 && this.field1667 + (long)this.field1662 <= var4 + (long)var7) {
               var10 = (long)this.field1662 + this.field1667;
            } else if((long)var7 + var4 > this.field1667 && (long)var7 + var4 <= (long)this.field1662 + this.field1667) {
               var10 = (long)var7 + var4;
            }

            if(var13 > -1L && var10 > var13) {
               int var12 = (int)(var10 - var13);
               System.arraycopy(this.writePayload, (int)(var13 - this.field1667), var1, (int)(var13 - var4) + var2, var12);
               if(var10 > this.position) {
                  var3 = (int)((long)var3 - (var10 - this.position));
                  this.position = var10;
               }
            }
         }
      } catch (IOException var16) {
         this.field1666 = -1L;
         throw var16;
      }

      if(var3 > 0) {
         throw new EOFException();
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-221046813"
   )
   @Export("load")
   void load() throws IOException {
      this.field1659 = 0;
      if(this.field1666 != this.position) {
         this.accessFile.seek(this.position);
         this.field1666 = this.position;
      }

      int var1;
      for(this.field1658 = this.position; this.field1659 < this.readPayload.length; this.field1659 += var1) {
         var1 = this.accessFile.read(this.readPayload, this.field1659, this.readPayload.length - this.field1659);
         if(var1 == -1) {
            break;
         }

         this.field1666 += (long)var1;
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-1687154524"
   )
   @Export("write")
   public void write(byte[] var1, int var2, int var3) throws IOException {
      try {
         if((long)var3 + this.position > this.capacity) {
            this.capacity = (long)var3 + this.position;
         }

         if(this.field1667 != -1L && (this.position < this.field1667 || this.position > (long)this.field1662 + this.field1667)) {
            this.flush();
         }

         if(this.field1667 != -1L && (long)var3 + this.position > (long)this.writePayload.length + this.field1667) {
            int var4 = (int)((long)this.writePayload.length - (this.position - this.field1667));
            System.arraycopy(var1, var2, this.writePayload, (int)(this.position - this.field1667), var4);
            this.position += (long)var4;
            var2 += var4;
            var3 -= var4;
            this.field1662 = this.writePayload.length;
            this.flush();
         }

         if(var3 <= this.writePayload.length) {
            if(var3 > 0) {
               if(-1L == this.field1667) {
                  this.field1667 = this.position;
               }

               System.arraycopy(var1, var2, this.writePayload, (int)(this.position - this.field1667), var3);
               this.position += (long)var3;
               if(this.position - this.field1667 > (long)this.field1662) {
                  this.field1662 = (int)(this.position - this.field1667);
               }

            }
         } else {
            if(this.field1666 != this.position) {
               this.accessFile.seek(this.position);
               this.field1666 = this.position;
            }

            this.accessFile.write(var1, var2, var3);
            this.field1666 += (long)var3;
            if(this.field1666 > this.length) {
               this.length = this.field1666;
            }

            long var9 = -1L;
            long var6 = -1L;
            if(this.position >= this.field1658 && this.position < this.field1658 + (long)this.field1659) {
               var9 = this.position;
            } else if(this.field1658 >= this.position && this.field1658 < this.position + (long)var3) {
               var9 = this.field1658;
            }

            if(this.position + (long)var3 > this.field1658 && (long)var3 + this.position <= (long)this.field1659 + this.field1658) {
               var6 = this.position + (long)var3;
            } else if((long)this.field1659 + this.field1658 > this.position && this.field1658 + (long)this.field1659 <= (long)var3 + this.position) {
               var6 = (long)this.field1659 + this.field1658;
            }

            if(var9 > -1L && var6 > var9) {
               int var8 = (int)(var6 - var9);
               System.arraycopy(var1, (int)(var9 + (long)var2 - this.position), this.readPayload, (int)(var9 - this.field1658), var8);
            }

            this.position += (long)var3;
         }
      } catch (IOException var12) {
         this.field1666 = -1L;
         throw var12;
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1870626532"
   )
   @Export("flush")
   void flush() throws IOException {
      if(-1L != this.field1667) {
         if(this.field1666 != this.field1667) {
            this.accessFile.seek(this.field1667);
            this.field1666 = this.field1667;
         }

         this.accessFile.write(this.writePayload, 0, this.field1662);
         this.field1666 += (long)(this.field1662 * -1471695941) * 1432820083L;
         if(this.field1666 > this.length) {
            this.length = this.field1666;
         }

         long var1 = -1L;
         long var3 = -1L;
         if(this.field1667 >= this.field1658 && this.field1667 < this.field1658 + (long)this.field1659) {
            var1 = this.field1667;
         } else if(this.field1658 >= this.field1667 && this.field1658 < (long)this.field1662 + this.field1667) {
            var1 = this.field1658;
         }

         if(this.field1667 + (long)this.field1662 > this.field1658 && (long)this.field1662 + this.field1667 <= (long)this.field1659 + this.field1658) {
            var3 = this.field1667 + (long)this.field1662;
         } else if(this.field1658 + (long)this.field1659 > this.field1667 && (long)this.field1659 + this.field1658 <= (long)this.field1662 + this.field1667) {
            var3 = (long)this.field1659 + this.field1658;
         }

         if(var1 > -1L && var3 > var1) {
            int var5 = (int)(var3 - var1);
            System.arraycopy(this.writePayload, (int)(var1 - this.field1667), this.readPayload, (int)(var1 - this.field1658), var5);
         }

         this.field1667 = -1L;
         this.field1662 = 0;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIIIIII)I",
      garbageValue = "-2126135055"
   )
   public static int method2633(int var0, int var1, int var2, int var3, int var4, int var5) {
      if((var5 & 1) == 1) {
         int var6 = var3;
         var3 = var4;
         var4 = var6;
      }

      var2 &= 3;
      return var2 == 0?var1:(var2 == 1?7 - var0 - (var3 - 1):(var2 == 2?7 - var1 - (var4 - 1):var0));
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1912010791"
   )
   @Export("nextPowerOfTwo")
   public static int nextPowerOfTwo(int var0) {
      --var0;
      var0 |= var0 >>> 1;
      var0 |= var0 >>> 2;
      var0 |= var0 >>> 4;
      var0 |= var0 >>> 8;
      var0 |= var0 >>> 16;
      return var0 + 1;
   }

   @ObfuscatedName("kt")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1434957708"
   )
   static final void method2632(String var0) {
      if(!var0.equals("")) {
         PacketNode var1 = AbstractSoundSystem.method2350(ClientPacket.field2440, Client.field911.field1460);
         var1.packetBuffer.putByte(class95.getLength(var0));
         var1.packetBuffer.putString(var0);
         Client.field911.method2135(var1);
      }
   }
}
