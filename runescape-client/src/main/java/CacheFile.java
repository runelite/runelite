import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dz")
@Implements("CacheFile")
public class CacheFile {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Ldx;"
   )
   FileOnDisk field1665;
   @ObfuscatedName("s")
   @Export("readPayload")
   byte[] readPayload;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      longValue = 6432642305875811773L
   )
   long field1674;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1766864863
   )
   int field1666;
   @ObfuscatedName("x")
   @Export("writePayload")
   byte[] writePayload;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      longValue = 5694883018105517145L
   )
   long field1668;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1085565251
   )
   int field1669;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      longValue = 4543102841769589987L
   )
   @Export("position")
   long position;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      longValue = -3013336979514221425L
   )
   @Export("length")
   long length;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      longValue = -989189216127524449L
   )
   long field1672;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      longValue = 8482804052606973633L
   )
   long field1673;

   @ObfuscatedSignature(
      signature = "(Ldx;II)V"
   )
   public CacheFile(FileOnDisk var1, int var2, int var3) throws IOException {
      this.field1674 = -1L;
      this.field1668 = -1L;
      this.field1669 = 0;
      this.field1665 = var1;
      this.field1672 = this.length = var1.length();
      this.readPayload = new byte[var2];
      this.writePayload = new byte[var3];
      this.position = 0L;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1815053136"
   )
   public void method2355() throws IOException {
      this.method2338();
      this.field1665.close();
   }

   @ObfuscatedName("s")
   @Export("seek")
   public void seek(long var1) throws IOException {
      if(var1 < 0L) {
         throw new IOException("");
      } else {
         this.position = var1;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "1458591198"
   )
   public long method2334() {
      return this.field1672;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "1654243"
   )
   @Export("read")
   public void read(byte[] var1) throws IOException {
      this.method2335(var1, 0, var1.length);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "1292939651"
   )
   public void method2335(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(var3 + var2 > var1.length) {
            throw new ArrayIndexOutOfBoundsException(var3 + var2 - var1.length);
         }

         if(-1L != this.field1668 && this.position >= this.field1668 && this.position + (long)var3 <= (long)this.field1669 + this.field1668) {
            System.arraycopy(this.writePayload, (int)(this.position - this.field1668), var1, var2, var3);
            this.position += (long)var3;
            return;
         }

         long var4 = this.position;
         int var7 = var3;
         int var8;
         if(this.position >= this.field1674 && this.position < (long)this.field1666 + this.field1674) {
            var8 = (int)((long)this.field1666 - (this.position - this.field1674));
            if(var8 > var3) {
               var8 = var3;
            }

            System.arraycopy(this.readPayload, (int)(this.position - this.field1674), var1, var2, var8);
            this.position += (long)var8;
            var2 += var8;
            var3 -= var8;
         }

         if(var3 > this.readPayload.length) {
            this.field1665.seek(this.position);

            for(this.field1673 = this.position; var3 > 0; var3 -= var8) {
               var8 = this.field1665.read(var1, var2, var3);
               if(var8 == -1) {
                  break;
               }

               this.field1673 += (long)var8;
               this.position += (long)var8;
               var2 += var8;
            }
         } else if(var3 > 0) {
            this.method2336();
            var8 = var3;
            if(var3 > this.field1666) {
               var8 = this.field1666;
            }

            System.arraycopy(this.readPayload, 0, var1, var2, var8);
            var2 += var8;
            var3 -= var8;
            this.position += (long)var8;
         }

         if(-1L != this.field1668) {
            if(this.field1668 > this.position && var3 > 0) {
               var8 = var2 + (int)(this.field1668 - this.position);
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
            if(this.field1668 >= var4 && this.field1668 < var4 + (long)var7) {
               var13 = this.field1668;
            } else if(var4 >= this.field1668 && var4 < this.field1668 + (long)this.field1669) {
               var13 = var4;
            }

            if((long)this.field1669 + this.field1668 > var4 && (long)this.field1669 + this.field1668 <= (long)var7 + var4) {
               var10 = this.field1668 + (long)this.field1669;
            } else if((long)var7 + var4 > this.field1668 && var4 + (long)var7 <= this.field1668 + (long)this.field1669) {
               var10 = var4 + (long)var7;
            }

            if(var13 > -1L && var10 > var13) {
               int var12 = (int)(var10 - var13);
               System.arraycopy(this.writePayload, (int)(var13 - this.field1668), var1, (int)(var13 - var4) + var2, var12);
               if(var10 > this.position) {
                  var3 = (int)((long)var3 - (var10 - this.position));
                  this.position = var10;
               }
            }
         }
      } catch (IOException var16) {
         this.field1673 = -1L;
         throw var16;
      }

      if(var3 > 0) {
         throw new EOFException();
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1541291861"
   )
   void method2336() throws IOException {
      this.field1666 = 0;
      if(this.field1673 != this.position) {
         this.field1665.seek(this.position);
         this.field1673 = this.position;
      }

      int var1;
      for(this.field1674 = this.position; this.field1666 < this.readPayload.length; this.field1666 += var1) {
         var1 = this.field1665.read(this.readPayload, this.field1666, this.readPayload.length - this.field1666);
         if(var1 == -1) {
            break;
         }

         this.field1673 += (long)var1;
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "-18"
   )
   @Export("write")
   public void write(byte[] var1, int var2, int var3) throws IOException {
      try {
         if((long)var3 + this.position > this.field1672) {
            this.field1672 = this.position + (long)var3;
         }

         if(this.field1668 != -1L && (this.position < this.field1668 || this.position > this.field1668 + (long)this.field1669)) {
            this.method2338();
         }

         if(this.field1668 != -1L && (long)var3 + this.position > this.field1668 + (long)this.writePayload.length) {
            int var4 = (int)((long)this.writePayload.length - (this.position - this.field1668));
            System.arraycopy(var1, var2, this.writePayload, (int)(this.position - this.field1668), var4);
            this.position += (long)var4;
            var2 += var4;
            var3 -= var4;
            this.field1669 = this.writePayload.length;
            this.method2338();
         }

         if(var3 <= this.writePayload.length) {
            if(var3 > 0) {
               if(-1L == this.field1668) {
                  this.field1668 = this.position;
               }

               System.arraycopy(var1, var2, this.writePayload, (int)(this.position - this.field1668), var3);
               this.position += (long)var3;
               if(this.position - this.field1668 > (long)this.field1669) {
                  this.field1669 = (int)(this.position - this.field1668);
               }

            }
         } else {
            if(this.field1673 != this.position) {
               this.field1665.seek(this.position);
               this.field1673 = this.position;
            }

            this.field1665.write(var1, var2, var3);
            this.field1673 += (long)var3;
            if(this.field1673 > this.length) {
               this.length = this.field1673;
            }

            long var9 = -1L;
            long var6 = -1L;
            if(this.position >= this.field1674 && this.position < this.field1674 + (long)this.field1666) {
               var9 = this.position;
            } else if(this.field1674 >= this.position && this.field1674 < this.position + (long)var3) {
               var9 = this.field1674;
            }

            if(this.position + (long)var3 > this.field1674 && (long)var3 + this.position <= this.field1674 + (long)this.field1666) {
               var6 = (long)var3 + this.position;
            } else if(this.field1674 + (long)this.field1666 > this.position && this.field1674 + (long)this.field1666 <= this.position + (long)var3) {
               var6 = (long)this.field1666 + this.field1674;
            }

            if(var9 > -1L && var6 > var9) {
               int var8 = (int)(var6 - var9);
               System.arraycopy(var1, (int)((long)var2 + var9 - this.position), this.readPayload, (int)(var9 - this.field1674), var8);
            }

            this.position += (long)var3;
         }
      } catch (IOException var12) {
         this.field1673 = -1L;
         throw var12;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-578214629"
   )
   void method2338() throws IOException {
      if(-1L != this.field1668) {
         if(this.field1668 != this.field1673) {
            this.field1665.seek(this.field1668);
            this.field1673 = this.field1668;
         }

         this.field1665.write(this.writePayload, 0, this.field1669);
         this.field1673 += -1085565251L * (long)(this.field1669 * 1225561237);
         if(this.field1673 > this.length) {
            this.length = this.field1673;
         }

         long var1 = -1L;
         long var3 = -1L;
         if(this.field1668 >= this.field1674 && this.field1668 < this.field1674 + (long)this.field1666) {
            var1 = this.field1668;
         } else if(this.field1674 >= this.field1668 && this.field1674 < (long)this.field1669 + this.field1668) {
            var1 = this.field1674;
         }

         if(this.field1668 + (long)this.field1669 > this.field1674 && this.field1668 + (long)this.field1669 <= (long)this.field1666 + this.field1674) {
            var3 = (long)this.field1669 + this.field1668;
         } else if(this.field1674 + (long)this.field1666 > this.field1668 && (long)this.field1666 + this.field1674 <= (long)this.field1669 + this.field1668) {
            var3 = this.field1674 + (long)this.field1666;
         }

         if(var1 > -1L && var3 > var1) {
            int var5 = (int)(var3 - var1);
            System.arraycopy(this.writePayload, (int)(var1 - this.field1668), this.readPayload, (int)(var1 - this.field1674), var5);
         }

         this.field1668 = -1L;
         this.field1669 = 0;
      }

   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "([BB)[B",
      garbageValue = "100"
   )
   @Export("decodeContainer")
   static final byte[] decodeContainer(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      int var2 = var1.readUnsignedByte();
      int var3 = var1.readInt();
      if(var3 < 0 || IndexDataBase.field3285 != 0 && var3 > IndexDataBase.field3285) {
         throw new RuntimeException();
      } else if(var2 == 0) {
         byte[] var4 = new byte[var3];
         var1.readBytes(var4, 0, var3);
         return var4;
      } else {
         int var6 = var1.readInt();
         if(var6 >= 0 && (IndexDataBase.field3285 == 0 || var6 <= IndexDataBase.field3285)) {
            byte[] var5 = new byte[var6];
            if(var2 == 1) {
               class174.method3132(var5, var6, var0, var3, 9);
            } else {
               IndexDataBase.gzip.decompress(var1, var5);
            }

            return var5;
         } else {
            throw new RuntimeException();
         }
      }
   }

   @ObfuscatedName("ia")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "0"
   )
   static void method2363(int var0) {
      class31.topContextMenuRow = new ContextMenuRow();
      class31.topContextMenuRow.param0 = Client.menuActionParams0[var0];
      class31.topContextMenuRow.param1 = Client.menuActionParams1[var0];
      class31.topContextMenuRow.type = Client.menuTypes[var0];
      class31.topContextMenuRow.identifier = Client.menuIdentifiers[var0];
      class31.topContextMenuRow.option = Client.menuOptions[var0];
   }
}
