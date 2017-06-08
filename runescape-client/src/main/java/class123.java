import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dl")
public class class123 {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      longValue = 4188268873331026077L
   )
   long field1758;
   @ObfuscatedName("p")
   byte[] field1759;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      longValue = 8956573440989339039L
   )
   long field1760;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 814836833
   )
   int field1761;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 497443247
   )
   int field1762;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      longValue = 3011855362201195141L
   )
   long field1763;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      longValue = 7827619845451512843L
   )
   long field1764;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      longValue = -3918869206490706787L
   )
   long field1765;
   @ObfuscatedName("n")
   FileOnDisk field1766;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      longValue = -7975144767392784901L
   )
   long field1767;
   @ObfuscatedName("f")
   byte[] field1769;

   @ObfuscatedName("p")
   public void method2337(long var1) throws IOException {
      if(var1 < 0L) {
         throw new IOException("");
      } else {
         this.field1765 = var1;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "-1939248210"
   )
   public long method2338() {
      return this.field1764;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "367332456"
   )
   public void method2340(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(var3 + var2 > var1.length) {
            throw new ArrayIndexOutOfBoundsException(var3 + var2 - var1.length);
         }

         if(-1L != this.field1763 && this.field1765 >= this.field1763 && this.field1765 + (long)var3 <= this.field1763 + (long)this.field1762) {
            System.arraycopy(this.field1769, (int)(this.field1765 - this.field1763), var1, var2, var3);
            this.field1765 += (long)var3;
            return;
         }

         long var4 = this.field1765;
         int var7 = var3;
         int var8;
         if(this.field1765 >= this.field1760 && this.field1765 < this.field1760 + (long)this.field1761) {
            var8 = (int)((long)this.field1761 - (this.field1765 - this.field1760));
            if(var8 > var3) {
               var8 = var3;
            }

            System.arraycopy(this.field1759, (int)(this.field1765 - this.field1760), var1, var2, var8);
            this.field1765 += (long)var8;
            var2 += var8;
            var3 -= var8;
         }

         if(var3 > this.field1759.length) {
            this.field1766.method2365(this.field1765);

            for(this.field1767 = this.field1765; var3 > 0; var3 -= var8) {
               var8 = this.field1766.method2369(var1, var2, var3);
               if(var8 == -1) {
                  break;
               }

               this.field1767 += (long)var8;
               this.field1765 += (long)var8;
               var2 += var8;
            }
         } else if(var3 > 0) {
            this.method2350();
            var8 = var3;
            if(var3 > this.field1761) {
               var8 = this.field1761;
            }

            System.arraycopy(this.field1759, 0, var1, var2, var8);
            var2 += var8;
            var3 -= var8;
            this.field1765 += (long)var8;
         }

         if(-1L != this.field1763) {
            if(this.field1763 > this.field1765 && var3 > 0) {
               var8 = var2 + (int)(this.field1763 - this.field1765);
               if(var8 > var3 + var2) {
                  var8 = var3 + var2;
               }

               while(var2 < var8) {
                  var1[var2++] = 0;
                  --var3;
                  ++this.field1765;
               }
            }

            long var13 = -1L;
            long var10 = -1L;
            if(this.field1763 >= var4 && this.field1763 < var4 + (long)var7) {
               var13 = this.field1763;
            } else if(var4 >= this.field1763 && var4 < this.field1763 + (long)this.field1762) {
               var13 = var4;
            }

            if((long)this.field1762 + this.field1763 > var4 && this.field1763 + (long)this.field1762 <= (long)var7 + var4) {
               var10 = (long)this.field1762 + this.field1763;
            } else if((long)var7 + var4 > this.field1763 && (long)var7 + var4 <= (long)this.field1762 + this.field1763) {
               var10 = (long)var7 + var4;
            }

            if(var13 > -1L && var10 > var13) {
               int var12 = (int)(var10 - var13);
               System.arraycopy(this.field1769, (int)(var13 - this.field1763), var1, var2 + (int)(var13 - var4), var12);
               if(var10 > this.field1765) {
                  var3 = (int)((long)var3 - (var10 - this.field1765));
                  this.field1765 = var10;
               }
            }
         }
      } catch (IOException var16) {
         this.field1767 = -1L;
         throw var16;
      }

      if(var3 > 0) {
         throw new EOFException();
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "497714297"
   )
   public void method2341(byte[] var1, int var2, int var3) throws IOException {
      try {
         if((long)var3 + this.field1765 > this.field1764) {
            this.field1764 = this.field1765 + (long)var3;
         }

         if(-1L != this.field1763 && (this.field1765 < this.field1763 || this.field1765 > this.field1763 + (long)this.field1762)) {
            this.method2343();
         }

         if(this.field1763 != -1L && (long)var3 + this.field1765 > this.field1763 + (long)this.field1769.length) {
            int var4 = (int)((long)this.field1769.length - (this.field1765 - this.field1763));
            System.arraycopy(var1, var2, this.field1769, (int)(this.field1765 - this.field1763), var4);
            this.field1765 += (long)var4;
            var2 += var4;
            var3 -= var4;
            this.field1762 = this.field1769.length;
            this.method2343();
         }

         if(var3 <= this.field1769.length) {
            if(var3 > 0) {
               if(this.field1763 == -1L) {
                  this.field1763 = this.field1765;
               }

               System.arraycopy(var1, var2, this.field1769, (int)(this.field1765 - this.field1763), var3);
               this.field1765 += (long)var3;
               if(this.field1765 - this.field1763 > (long)this.field1762) {
                  this.field1762 = (int)(this.field1765 - this.field1763);
               }

            }
         } else {
            if(this.field1765 != this.field1767) {
               this.field1766.method2365(this.field1765);
               this.field1767 = this.field1765;
            }

            this.field1766.method2366(var1, var2, var3);
            this.field1767 += (long)var3;
            if(this.field1767 > this.field1758) {
               this.field1758 = this.field1767;
            }

            long var9 = -1L;
            long var6 = -1L;
            if(this.field1765 >= this.field1760 && this.field1765 < this.field1760 + (long)this.field1761) {
               var9 = this.field1765;
            } else if(this.field1760 >= this.field1765 && this.field1760 < this.field1765 + (long)var3) {
               var9 = this.field1760;
            }

            if((long)var3 + this.field1765 > this.field1760 && (long)var3 + this.field1765 <= (long)this.field1761 + this.field1760) {
               var6 = (long)var3 + this.field1765;
            } else if(this.field1760 + (long)this.field1761 > this.field1765 && (long)this.field1761 + this.field1760 <= (long)var3 + this.field1765) {
               var6 = this.field1760 + (long)this.field1761;
            }

            if(var9 > -1L && var6 > var9) {
               int var8 = (int)(var6 - var9);
               System.arraycopy(var1, (int)(var9 + (long)var2 - this.field1765), this.field1759, (int)(var9 - this.field1760), var8);
            }

            this.field1765 += (long)var3;
         }
      } catch (IOException var12) {
         this.field1767 = -1L;
         throw var12;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1606309662"
   )
   void method2343() throws IOException {
      if(-1L != this.field1763) {
         if(this.field1767 != this.field1763) {
            this.field1766.method2365(this.field1763);
            this.field1767 = this.field1763;
         }

         this.field1766.method2366(this.field1769, 0, this.field1762);
         this.field1767 += 497443247L * (long)(this.field1762 * 776181071);
         if(this.field1767 > this.field1758) {
            this.field1758 = this.field1767;
         }

         long var1 = -1L;
         long var3 = -1L;
         if(this.field1763 >= this.field1760 && this.field1763 < this.field1760 + (long)this.field1761) {
            var1 = this.field1763;
         } else if(this.field1760 >= this.field1763 && this.field1760 < this.field1763 + (long)this.field1762) {
            var1 = this.field1760;
         }

         if((long)this.field1762 + this.field1763 > this.field1760 && this.field1763 + (long)this.field1762 <= this.field1760 + (long)this.field1761) {
            var3 = (long)this.field1762 + this.field1763;
         } else if((long)this.field1761 + this.field1760 > this.field1763 && this.field1760 + (long)this.field1761 <= this.field1763 + (long)this.field1762) {
            var3 = (long)this.field1761 + this.field1760;
         }

         if(var1 > -1L && var3 > var1) {
            int var5 = (int)(var3 - var1);
            System.arraycopy(this.field1769, (int)(var1 - this.field1763), this.field1759, (int)(var1 - this.field1760), var5);
         }

         this.field1763 = -1L;
         this.field1762 = 0;
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "1734613841"
   )
   public void method2347(byte[] var1) throws IOException {
      this.method2340(var1, 0, var1.length);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1109234296"
   )
   void method2350() throws IOException {
      this.field1761 = 0;
      if(this.field1765 != this.field1767) {
         this.field1766.method2365(this.field1765);
         this.field1767 = this.field1765;
      }

      int var1;
      for(this.field1760 = this.field1765; this.field1761 < this.field1759.length; this.field1761 += var1) {
         var1 = this.field1766.method2369(this.field1759, this.field1761, this.field1759.length - this.field1761);
         if(var1 == -1) {
            break;
         }

         this.field1767 += (long)var1;
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "939529827"
   )
   public void method2351() throws IOException {
      this.method2343();
      this.field1766.method2368();
   }

   @ObfuscatedSignature(
      signature = "(LFileOnDisk;II)V",
      garbageValue = "0"
   )
   public class123(FileOnDisk var1, int var2, int var3) throws IOException {
      this.field1760 = -1L;
      this.field1763 = -1L;
      this.field1762 = 0;
      this.field1766 = var1;
      this.field1764 = this.field1758 = var1.method2370();
      this.field1759 = new byte[var2];
      this.field1769 = new byte[var3];
      this.field1765 = 0L;
   }

   @ObfuscatedName("gk")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1827174108"
   )
   @Export("xteaChanged")
   static final void xteaChanged(boolean var0) {
      Client.isDynamicRegion = var0;
      int var1;
      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      if(!Client.isDynamicRegion) {
         var1 = Client.secretPacketBuffer2.method3196();
         int var2 = Client.secretPacketBuffer2.readUnsignedShort();
         var3 = Client.secretPacketBuffer2.readUnsignedShort();
         class60.xteaKeys = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               class60.xteaKeys[var4][var5] = Client.secretPacketBuffer2.readInt();
            }
         }

         class18.mapRegions = new int[var3];
         class45.field582 = new int[var3];
         class28.field421 = new int[var3];
         WorldMapType2.field521 = new byte[var3][];
         class9.field248 = new byte[var3][];
         boolean var15 = false;
         if((var2 / 8 == 48 || var2 / 8 == 49) && var1 / 8 == 48) {
            var15 = true;
         }

         if(var2 / 8 == 48 && var1 / 8 == 148) {
            var15 = true;
         }

         var3 = 0;

         for(var5 = (var2 - 6) / 8; var5 <= (var2 + 6) / 8; ++var5) {
            for(var6 = (var1 - 6) / 8; var6 <= (var1 + 6) / 8; ++var6) {
               var7 = var6 + (var5 << 8);
               if(!var15 || var6 != 49 && var6 != 149 && var6 != 147 && var5 != 50 && (var5 != 49 || var6 != 47)) {
                  class18.mapRegions[var3] = var7;
                  class45.field582[var3] = class77.indexMaps.method4141("m" + var5 + "_" + var6);
                  class28.field421[var3] = class77.indexMaps.method4141("l" + var5 + "_" + var6);
                  ++var3;
               }
            }
         }

         class59.method969(var2, var1, true);
      } else {
         var1 = Client.secretPacketBuffer2.method3194();
         boolean var14 = Client.secretPacketBuffer2.method3188() == 1;
         var3 = Client.secretPacketBuffer2.method3195();
         var4 = Client.secretPacketBuffer2.readUnsignedShort();
         Client.secretPacketBuffer2.method3399();

         int var8;
         for(var5 = 0; var5 < 4; ++var5) {
            for(var6 = 0; var6 < 13; ++var6) {
               for(var7 = 0; var7 < 13; ++var7) {
                  var8 = Client.secretPacketBuffer2.method3400(1);
                  if(var8 == 1) {
                     Client.field976[var5][var6][var7] = Client.secretPacketBuffer2.method3400(26);
                  } else {
                     Client.field976[var5][var6][var7] = -1;
                  }
               }
            }
         }

         Client.secretPacketBuffer2.method3401();
         class60.xteaKeys = new int[var4][4];

         for(var5 = 0; var5 < var4; ++var5) {
            for(var6 = 0; var6 < 4; ++var6) {
               class60.xteaKeys[var5][var6] = Client.secretPacketBuffer2.readInt();
            }
         }

         class18.mapRegions = new int[var4];
         class45.field582 = new int[var4];
         class28.field421 = new int[var4];
         WorldMapType2.field521 = new byte[var4][];
         class9.field248 = new byte[var4][];
         var4 = 0;

         for(var5 = 0; var5 < 4; ++var5) {
            for(var6 = 0; var6 < 13; ++var6) {
               for(var7 = 0; var7 < 13; ++var7) {
                  var8 = Client.field976[var5][var6][var7];
                  if(var8 != -1) {
                     int var9 = var8 >> 14 & 1023;
                     int var10 = var8 >> 3 & 2047;
                     int var11 = (var9 / 8 << 8) + var10 / 8;

                     int var12;
                     for(var12 = 0; var12 < var4; ++var12) {
                        if(var11 == class18.mapRegions[var12]) {
                           var11 = -1;
                           break;
                        }
                     }

                     if(var11 != -1) {
                        class18.mapRegions[var4] = var11;
                        var12 = var11 >> 8 & 255;
                        int var13 = var11 & 255;
                        class45.field582[var4] = class77.indexMaps.method4141("m" + var12 + "_" + var13);
                        class28.field421[var4] = class77.indexMaps.method4141("l" + var12 + "_" + var13);
                        ++var4;
                     }
                  }
               }
            }
         }

         class59.method969(var3, var1, !var14);
      }

   }
}
