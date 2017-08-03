import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cv")
@Implements("CacheFile")
public class CacheFile {
   @ObfuscatedName("ev")
   @ObfuscatedSignature(
      signature = "Lfz;"
   )
   @Export("rssocket")
   static RSSocket rssocket;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -8744819
   )
   static int field1538;
   @ObfuscatedName("pl")
   @ObfuscatedSignature(
      signature = "Lde;"
   )
   static class118 field1539;
   @ObfuscatedName("gr")
   @ObfuscatedGetter(
      intValue = -163110869
   )
   static int field1535;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      longValue = 3909998125424328117L
   )
   long field1536;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 4781897
   )
   int field1530;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      longValue = -598238945829884671L
   )
   long field1537;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      longValue = -1681726549191683357L
   )
   long field1529;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      longValue = -3918514422360999859L
   )
   @Export("position")
   long position;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      longValue = -3756181014180701753L
   )
   long field1527;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lcn;"
   )
   FileOnDisk field1543;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1518735289
   )
   int field1533;
   @ObfuscatedName("e")
   @Export("writePayload")
   byte[] writePayload;
   @ObfuscatedName("q")
   @Export("readPayload")
   byte[] readPayload;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      longValue = -404941187914630407L
   )
   @Export("length")
   long length;

   @ObfuscatedSignature(
      signature = "(Lcn;II)V"
   )
   public CacheFile(FileOnDisk var1, int var2, int var3) throws IOException {
      this.field1527 = -1L;
      this.field1529 = -1L;
      this.field1533 = 0;
      this.field1543 = var1;
      this.field1536 = this.length = var1.length();
      this.readPayload = new byte[var2];
      this.writePayload = new byte[var3];
      this.position = 0L;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "9"
   )
   public void method1889(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(var3 + var2 > var1.length) {
            throw new ArrayIndexOutOfBoundsException(var3 + var2 - var1.length);
         }

         if(-1L != this.field1529 && this.position >= this.field1529 && this.position + (long)var3 <= (long)this.field1533 + this.field1529) {
            System.arraycopy(this.writePayload, (int)(this.position - this.field1529), var1, var2, var3);
            this.position += (long)var3;
            return;
         }

         long var4 = this.position;
         int var7 = var3;
         int var8;
         if(this.position >= this.field1527 && this.position < this.field1527 + (long)this.field1530) {
            var8 = (int)((long)this.field1530 - (this.position - this.field1527));
            if(var8 > var3) {
               var8 = var3;
            }

            System.arraycopy(this.readPayload, (int)(this.position - this.field1527), var1, var2, var8);
            this.position += (long)var8;
            var2 += var8;
            var3 -= var8;
         }

         if(var3 > this.readPayload.length) {
            this.field1543.seek(this.position);

            for(this.field1537 = this.position; var3 > 0; var3 -= var8) {
               var8 = this.field1543.read(var1, var2, var3);
               if(var8 == -1) {
                  break;
               }

               this.field1537 += (long)var8;
               this.position += (long)var8;
               var2 += var8;
            }
         } else if(var3 > 0) {
            this.method1890();
            var8 = var3;
            if(var3 > this.field1530) {
               var8 = this.field1530;
            }

            System.arraycopy(this.readPayload, 0, var1, var2, var8);
            var2 += var8;
            var3 -= var8;
            this.position += (long)var8;
         }

         if(this.field1529 != -1L) {
            if(this.field1529 > this.position && var3 > 0) {
               var8 = var2 + (int)(this.field1529 - this.position);
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
            if(this.field1529 >= var4 && this.field1529 < var4 + (long)var7) {
               var13 = this.field1529;
            } else if(var4 >= this.field1529 && var4 < (long)this.field1533 + this.field1529) {
               var13 = var4;
            }

            if((long)this.field1533 + this.field1529 > var4 && (long)this.field1533 + this.field1529 <= var4 + (long)var7) {
               var10 = (long)this.field1533 + this.field1529;
            } else if(var4 + (long)var7 > this.field1529 && (long)var7 + var4 <= (long)this.field1533 + this.field1529) {
               var10 = var4 + (long)var7;
            }

            if(var13 > -1L && var10 > var13) {
               int var12 = (int)(var10 - var13);
               System.arraycopy(this.writePayload, (int)(var13 - this.field1529), var1, (int)(var13 - var4) + var2, var12);
               if(var10 > this.position) {
                  var3 = (int)((long)var3 - (var10 - this.position));
                  this.position = var10;
               }
            }
         }
      } catch (IOException var16) {
         this.field1537 = -1L;
         throw var16;
      }

      if(var3 > 0) {
         throw new EOFException();
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "848933248"
   )
   void method1912() throws IOException {
      if(-1L != this.field1529) {
         if(this.field1537 != this.field1529) {
            this.field1543.seek(this.field1529);
            this.field1537 = this.field1529;
         }

         this.field1543.write(this.writePayload, 0, this.field1533);
         this.field1537 += -1518735289L * (long)(this.field1533 * -236799625);
         if(this.field1537 > this.length) {
            this.length = this.field1537;
         }

         long var1 = -1L;
         long var3 = -1L;
         if(this.field1529 >= this.field1527 && this.field1529 < (long)this.field1530 + this.field1527) {
            var1 = this.field1529;
         } else if(this.field1527 >= this.field1529 && this.field1527 < (long)this.field1533 + this.field1529) {
            var1 = this.field1527;
         }

         if(this.field1529 + (long)this.field1533 > this.field1527 && (long)this.field1533 + this.field1529 <= this.field1527 + (long)this.field1530) {
            var3 = (long)this.field1533 + this.field1529;
         } else if((long)this.field1530 + this.field1527 > this.field1529 && (long)this.field1530 + this.field1527 <= (long)this.field1533 + this.field1529) {
            var3 = this.field1527 + (long)this.field1530;
         }

         if(var1 > -1L && var3 > var1) {
            int var5 = (int)(var3 - var1);
            System.arraycopy(this.writePayload, (int)(var1 - this.field1529), this.readPayload, (int)(var1 - this.field1527), var5);
         }

         this.field1529 = -1L;
         this.field1533 = 0;
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "-376022723"
   )
   public long method1887() {
      return this.field1536;
   }

   @ObfuscatedName("q")
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
      garbageValue = "2"
   )
   @Export("write")
   public void write(byte[] var1, int var2, int var3) throws IOException {
      try {
         if((long)var3 + this.position > this.field1536) {
            this.field1536 = (long)var3 + this.position;
         }

         if(-1L != this.field1529 && (this.position < this.field1529 || this.position > (long)this.field1533 + this.field1529)) {
            this.method1912();
         }

         if(-1L != this.field1529 && (long)var3 + this.position > (long)this.writePayload.length + this.field1529) {
            int var4 = (int)((long)this.writePayload.length - (this.position - this.field1529));
            System.arraycopy(var1, var2, this.writePayload, (int)(this.position - this.field1529), var4);
            this.position += (long)var4;
            var2 += var4;
            var3 -= var4;
            this.field1533 = this.writePayload.length;
            this.method1912();
         }

         if(var3 <= this.writePayload.length) {
            if(var3 > 0) {
               if(this.field1529 == -1L) {
                  this.field1529 = this.position;
               }

               System.arraycopy(var1, var2, this.writePayload, (int)(this.position - this.field1529), var3);
               this.position += (long)var3;
               if(this.position - this.field1529 > (long)this.field1533) {
                  this.field1533 = (int)(this.position - this.field1529);
               }

            }
         } else {
            if(this.field1537 != this.position) {
               this.field1543.seek(this.position);
               this.field1537 = this.position;
            }

            this.field1543.write(var1, var2, var3);
            this.field1537 += (long)var3;
            if(this.field1537 > this.length) {
               this.length = this.field1537;
            }

            long var9 = -1L;
            long var6 = -1L;
            if(this.position >= this.field1527 && this.position < this.field1527 + (long)this.field1530) {
               var9 = this.position;
            } else if(this.field1527 >= this.position && this.field1527 < (long)var3 + this.position) {
               var9 = this.field1527;
            }

            if((long)var3 + this.position > this.field1527 && this.position + (long)var3 <= (long)this.field1530 + this.field1527) {
               var6 = this.position + (long)var3;
            } else if(this.field1527 + (long)this.field1530 > this.position && (long)this.field1530 + this.field1527 <= (long)var3 + this.position) {
               var6 = this.field1527 + (long)this.field1530;
            }

            if(var9 > -1L && var6 > var9) {
               int var8 = (int)(var6 - var9);
               System.arraycopy(var1, (int)((long)var2 + var9 - this.position), this.readPayload, (int)(var9 - this.field1527), var8);
            }

            this.position += (long)var3;
         }
      } catch (IOException var12) {
         this.field1537 = -1L;
         throw var12;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-294900614"
   )
   void method1890() throws IOException {
      this.field1530 = 0;
      if(this.field1537 != this.position) {
         this.field1543.seek(this.position);
         this.field1537 = this.position;
      }

      int var1;
      for(this.field1527 = this.position; this.field1530 < this.readPayload.length; this.field1530 += var1) {
         var1 = this.field1543.read(this.readPayload, this.field1530, this.readPayload.length - this.field1530);
         if(var1 == -1) {
            break;
         }

         this.field1537 += (long)var1;
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "105"
   )
   public void method1893() throws IOException {
      this.method1912();
      this.field1543.close();
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "1755016874"
   )
   @Export("read")
   public void read(byte[] var1) throws IOException {
      this.method1889(var1, 0, var1.length);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-2134368225"
   )
   @Export("getColTags")
   static String getColTags(int var0) {
      return "<col=" + Integer.toHexString(var0) + ">";
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1633749583"
   )
   static void method1884(int var0) {
      XItemContainer var1 = (XItemContainer)XItemContainer.itemContainers.get((long)var0);
      if(var1 != null) {
         for(int var2 = 0; var2 < var1.itemIds.length; ++var2) {
            var1.itemIds[var2] = -1;
            var1.stackSizes[var2] = 0;
         }

      }
   }
}
