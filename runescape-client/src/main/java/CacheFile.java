import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Opcodes;

@ObfuscatedName("dz")
@Implements("CacheFile")
public class CacheFile {
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -666357589
   )
   static int field1750;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      longValue = 6071230024670713881L
   )
   long field1747;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      longValue = 4637845237527882731L
   )
   long field1748;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1226316099
   )
   int field1741;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      longValue = 8326644413648038521L
   )
   long field1743;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      longValue = 4873450675100369759L
   )
   @Export("position")
   long position;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      longValue = 775709737557103169L
   )
   long field1740;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Ldw;"
   )
   FileOnDisk field1749;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1548235935
   )
   int field1738;
   @ObfuscatedName("q")
   @Export("writePayload")
   byte[] writePayload;
   @ObfuscatedName("k")
   @Export("readPayload")
   byte[] readPayload;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      longValue = 5863275630171102245L
   )
   @Export("length")
   long length;

   @ObfuscatedSignature(
      signature = "(Ldw;II)V"
   )
   public CacheFile(FileOnDisk var1, int var2, int var3) throws IOException {
      this.field1740 = -1L;
      this.field1743 = -1L;
      this.field1738 = 0;
      this.field1749 = var1;
      this.field1747 = this.length = var1.length();
      this.readPayload = new byte[var2];
      this.writePayload = new byte[var3];
      this.position = 0L;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-902249243"
   )
   public void method2426(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(var3 + var2 > var1.length) {
            throw new ArrayIndexOutOfBoundsException(var3 + var2 - var1.length);
         }

         if(-1L != this.field1743 && this.position >= this.field1743 && this.position + (long)var3 <= this.field1743 + (long)this.field1738) {
            System.arraycopy(this.writePayload, (int)(this.position - this.field1743), var1, var2, var3);
            this.position += (long)var3;
            return;
         }

         long var4 = this.position;
         int var7 = var3;
         int var8;
         if(this.position >= this.field1740 && this.position < (long)this.field1741 + this.field1740) {
            var8 = (int)((long)this.field1741 - (this.position - this.field1740));
            if(var8 > var3) {
               var8 = var3;
            }

            System.arraycopy(this.readPayload, (int)(this.position - this.field1740), var1, var2, var8);
            this.position += (long)var8;
            var2 += var8;
            var3 -= var8;
         }

         if(var3 > this.readPayload.length) {
            this.field1749.seek(this.position);

            for(this.field1748 = this.position; var3 > 0; var3 -= var8) {
               var8 = this.field1749.read(var1, var2, var3);
               if(var8 == -1) {
                  break;
               }

               this.field1748 += (long)var8;
               this.position += (long)var8;
               var2 += var8;
            }
         } else if(var3 > 0) {
            this.method2440();
            var8 = var3;
            if(var3 > this.field1741) {
               var8 = this.field1741;
            }

            System.arraycopy(this.readPayload, 0, var1, var2, var8);
            var2 += var8;
            var3 -= var8;
            this.position += (long)var8;
         }

         if(-1L != this.field1743) {
            if(this.field1743 > this.position && var3 > 0) {
               var8 = var2 + (int)(this.field1743 - this.position);
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
            if(this.field1743 >= var4 && this.field1743 < var4 + (long)var7) {
               var13 = this.field1743;
            } else if(var4 >= this.field1743 && var4 < this.field1743 + (long)this.field1738) {
               var13 = var4;
            }

            if((long)this.field1738 + this.field1743 > var4 && (long)this.field1738 + this.field1743 <= (long)var7 + var4) {
               var10 = (long)this.field1738 + this.field1743;
            } else if(var4 + (long)var7 > this.field1743 && (long)var7 + var4 <= this.field1743 + (long)this.field1738) {
               var10 = var4 + (long)var7;
            }

            if(var13 > -1L && var10 > var13) {
               int var12 = (int)(var10 - var13);
               System.arraycopy(this.writePayload, (int)(var13 - this.field1743), var1, (int)(var13 - var4) + var2, var12);
               if(var10 > this.position) {
                  var3 = (int)((long)var3 - (var10 - this.position));
                  this.position = var10;
               }
            }
         }
      } catch (IOException var16) {
         this.field1748 = -1L;
         throw var16;
      }

      if(var3 > 0) {
         throw new EOFException();
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1879670294"
   )
   void method2417() throws IOException {
      if(this.field1743 != -1L) {
         if(this.field1748 != this.field1743) {
            this.field1749.seek(this.field1743);
            this.field1748 = this.field1743;
         }

         this.field1749.write(this.writePayload, 0, this.field1738);
         this.field1748 += (long)(this.field1738 * -89659553) * 1548235935L;
         if(this.field1748 > this.length) {
            this.length = this.field1748;
         }

         long var1 = -1L;
         long var3 = -1L;
         if(this.field1743 >= this.field1740 && this.field1743 < (long)this.field1741 + this.field1740) {
            var1 = this.field1743;
         } else if(this.field1740 >= this.field1743 && this.field1740 < this.field1743 + (long)this.field1738) {
            var1 = this.field1740;
         }

         if(this.field1743 + (long)this.field1738 > this.field1740 && (long)this.field1738 + this.field1743 <= (long)this.field1741 + this.field1740) {
            var3 = (long)this.field1738 + this.field1743;
         } else if((long)this.field1741 + this.field1740 > this.field1743 && this.field1740 + (long)this.field1741 <= this.field1743 + (long)this.field1738) {
            var3 = (long)this.field1741 + this.field1740;
         }

         if(var1 > -1L && var3 > var1) {
            int var5 = (int)(var3 - var1);
            System.arraycopy(this.writePayload, (int)(var1 - this.field1743), this.readPayload, (int)(var1 - this.field1740), var5);
         }

         this.field1743 = -1L;
         this.field1738 = 0;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "-1535240099"
   )
   public long method2412() {
      return this.field1747;
   }

   @ObfuscatedName("k")
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
      signature = "([BIII)V",
      garbageValue = "996204330"
   )
   @Export("write")
   public void write(byte[] var1, int var2, int var3) throws IOException {
      try {
         if((long)var3 + this.position > this.field1747) {
            this.field1747 = this.position + (long)var3;
         }

         if(-1L != this.field1743 && (this.position < this.field1743 || this.position > this.field1743 + (long)this.field1738)) {
            this.method2417();
         }

         if(-1L != this.field1743 && this.position + (long)var3 > this.field1743 + (long)this.writePayload.length) {
            int var4 = (int)((long)this.writePayload.length - (this.position - this.field1743));
            System.arraycopy(var1, var2, this.writePayload, (int)(this.position - this.field1743), var4);
            this.position += (long)var4;
            var2 += var4;
            var3 -= var4;
            this.field1738 = this.writePayload.length;
            this.method2417();
         }

         if(var3 <= this.writePayload.length) {
            if(var3 > 0) {
               if(this.field1743 == -1L) {
                  this.field1743 = this.position;
               }

               System.arraycopy(var1, var2, this.writePayload, (int)(this.position - this.field1743), var3);
               this.position += (long)var3;
               if(this.position - this.field1743 > (long)this.field1738) {
                  this.field1738 = (int)(this.position - this.field1743);
               }

            }
         } else {
            if(this.position != this.field1748) {
               this.field1749.seek(this.position);
               this.field1748 = this.position;
            }

            this.field1749.write(var1, var2, var3);
            this.field1748 += (long)var3;
            if(this.field1748 > this.length) {
               this.length = this.field1748;
            }

            long var9 = -1L;
            long var6 = -1L;
            if(this.position >= this.field1740 && this.position < this.field1740 + (long)this.field1741) {
               var9 = this.position;
            } else if(this.field1740 >= this.position && this.field1740 < (long)var3 + this.position) {
               var9 = this.field1740;
            }

            if((long)var3 + this.position > this.field1740 && this.position + (long)var3 <= (long)this.field1741 + this.field1740) {
               var6 = this.position + (long)var3;
            } else if(this.field1740 + (long)this.field1741 > this.position && (long)this.field1741 + this.field1740 <= (long)var3 + this.position) {
               var6 = this.field1740 + (long)this.field1741;
            }

            if(var9 > -1L && var6 > var9) {
               int var8 = (int)(var6 - var9);
               System.arraycopy(var1, (int)(var9 + (long)var2 - this.position), this.readPayload, (int)(var9 - this.field1740), var8);
            }

            this.position += (long)var3;
         }
      } catch (IOException var12) {
         this.field1748 = -1L;
         throw var12;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-25"
   )
   void method2440() throws IOException {
      this.field1741 = 0;
      if(this.field1748 != this.position) {
         this.field1749.seek(this.position);
         this.field1748 = this.position;
      }

      int var1;
      for(this.field1740 = this.position; this.field1741 < this.readPayload.length; this.field1741 += var1) {
         var1 = this.field1749.read(this.readPayload, this.field1741, this.readPayload.length - this.field1741);
         if(var1 == -1) {
            break;
         }

         this.field1748 += (long)var1;
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1073338359"
   )
   public void method2410() throws IOException {
      this.method2417();
      this.field1749.close();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "1081817106"
   )
   @Export("read")
   public void read(byte[] var1) throws IOException {
      this.method2426(var1, 0, var1.length);
   }

   @ObfuscatedName("hv")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "-49"
   )
   @Export("getTileHeight")
   static final int getTileHeight(int var0, int var1, int var2) {
      int var3 = var0 >> 7;
      int var4 = var1 >> 7;
      if(var3 >= 0 && var4 >= 0 && var3 <= 103 && var4 <= 103) {
         int var5 = var2;
         if(var2 < 3 && (class61.tileSettings[1][var3][var4] & 2) == 2) {
            var5 = var2 + 1;
         }

         int var6 = var0 & 127;
         int var7 = var1 & 127;
         int var8 = (128 - var6) * class61.tileHeights[var5][var3][var4] + class61.tileHeights[var5][var3 + 1][var4] * var6 >> 7;
         int var9 = var6 * class61.tileHeights[var5][var3 + 1][var4 + 1] + class61.tileHeights[var5][var3][var4 + 1] * (128 - var6) >> 7;
         return var8 * (128 - var7) + var7 * var9 >> 7;
      } else {
         return 0;
      }
   }

   @ObfuscatedName("ku")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)V",
      garbageValue = "1177455322"
   )
   static final void method2428(String var0, int var1) {
      Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_139);
      Client.secretPacketBuffer1.putByte(class162.getLength(var0) + 1);
      Client.secretPacketBuffer1.method3261(var1);
      Client.secretPacketBuffer1.putString(var0);
   }
}
