import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Opcodes;

@ObfuscatedName("dv")
@Implements("CacheFile")
public class CacheFile {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Ldw;"
   )
   FileOnDisk field1748;
   @ObfuscatedName("s")
   @Export("readPayload")
   byte[] readPayload;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      longValue = -7352221243347966451L
   )
   long field1742;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1559568197
   )
   int field1741;
   @ObfuscatedName("g")
   @Export("writePayload")
   byte[] writePayload;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      longValue = -32305076833850759L
   )
   long field1743;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1682531713
   )
   int field1744;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      longValue = -4399020207622913365L
   )
   @Export("position")
   long position;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      longValue = -3136279656533144179L
   )
   @Export("length")
   long length;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      longValue = 8825921594396767351L
   )
   long field1747;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      longValue = -5155806361874845769L
   )
   long field1750;

   @ObfuscatedSignature(
      signature = "(Ldw;II)V"
   )
   public CacheFile(FileOnDisk var1, int var2, int var3) throws IOException {
      this.field1742 = -1L;
      this.field1743 = -1L;
      this.field1744 = 0;
      this.field1748 = var1;
      this.field1747 = this.length = var1.length();
      this.readPayload = new byte[var2];
      this.writePayload = new byte[var3];
      this.position = 0L;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2139912808"
   )
   public void method2398() throws IOException {
      this.method2383();
      this.field1748.close();
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

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "-1363047717"
   )
   public long method2392() {
      return this.field1747;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "([BB)V",
      garbageValue = "-33"
   )
   @Export("read")
   public void read(byte[] var1) throws IOException {
      this.method2380(var1, 0, var1.length);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "1631729351"
   )
   public void method2380(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(var3 + var2 > var1.length) {
            throw new ArrayIndexOutOfBoundsException(var3 + var2 - var1.length);
         }

         if(-1L != this.field1743 && this.position >= this.field1743 && (long)var3 + this.position <= (long)this.field1744 + this.field1743) {
            System.arraycopy(this.writePayload, (int)(this.position - this.field1743), var1, var2, var3);
            this.position += (long)var3;
            return;
         }

         long var4 = this.position;
         int var7 = var3;
         int var8;
         if(this.position >= this.field1742 && this.position < (long)this.field1741 + this.field1742) {
            var8 = (int)((long)this.field1741 - (this.position - this.field1742));
            if(var8 > var3) {
               var8 = var3;
            }

            System.arraycopy(this.readPayload, (int)(this.position - this.field1742), var1, var2, var8);
            this.position += (long)var8;
            var2 += var8;
            var3 -= var8;
         }

         if(var3 > this.readPayload.length) {
            this.field1748.seek(this.position);

            for(this.field1750 = this.position; var3 > 0; var3 -= var8) {
               var8 = this.field1748.read(var1, var2, var3);
               if(var8 == -1) {
                  break;
               }

               this.field1750 += (long)var8;
               this.position += (long)var8;
               var2 += var8;
            }
         } else if(var3 > 0) {
            this.method2381();
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
            if(this.field1743 >= var4 && this.field1743 < (long)var7 + var4) {
               var13 = this.field1743;
            } else if(var4 >= this.field1743 && var4 < this.field1743 + (long)this.field1744) {
               var13 = var4;
            }

            if(this.field1743 + (long)this.field1744 > var4 && (long)this.field1744 + this.field1743 <= (long)var7 + var4) {
               var10 = (long)this.field1744 + this.field1743;
            } else if((long)var7 + var4 > this.field1743 && var4 + (long)var7 <= this.field1743 + (long)this.field1744) {
               var10 = (long)var7 + var4;
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
         this.field1750 = -1L;
         throw var16;
      }

      if(var3 > 0) {
         throw new EOFException();
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "55"
   )
   void method2381() throws IOException {
      this.field1741 = 0;
      if(this.position != this.field1750) {
         this.field1748.seek(this.position);
         this.field1750 = this.position;
      }

      int var1;
      for(this.field1742 = this.position; this.field1741 < this.readPayload.length; this.field1741 += var1) {
         var1 = this.field1748.read(this.readPayload, this.field1741, this.readPayload.length - this.field1741);
         if(var1 == -1) {
            break;
         }

         this.field1750 += (long)var1;
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-151462005"
   )
   @Export("write")
   public void write(byte[] var1, int var2, int var3) throws IOException {
      try {
         if((long)var3 + this.position > this.field1747) {
            this.field1747 = (long)var3 + this.position;
         }

         if(this.field1743 != -1L && (this.position < this.field1743 || this.position > (long)this.field1744 + this.field1743)) {
            this.method2383();
         }

         if(this.field1743 != -1L && this.position + (long)var3 > (long)this.writePayload.length + this.field1743) {
            int var4 = (int)((long)this.writePayload.length - (this.position - this.field1743));
            System.arraycopy(var1, var2, this.writePayload, (int)(this.position - this.field1743), var4);
            this.position += (long)var4;
            var2 += var4;
            var3 -= var4;
            this.field1744 = this.writePayload.length;
            this.method2383();
         }

         if(var3 <= this.writePayload.length) {
            if(var3 > 0) {
               if(-1L == this.field1743) {
                  this.field1743 = this.position;
               }

               System.arraycopy(var1, var2, this.writePayload, (int)(this.position - this.field1743), var3);
               this.position += (long)var3;
               if(this.position - this.field1743 > (long)this.field1744) {
                  this.field1744 = (int)(this.position - this.field1743);
               }

            }
         } else {
            if(this.field1750 != this.position) {
               this.field1748.seek(this.position);
               this.field1750 = this.position;
            }

            this.field1748.write(var1, var2, var3);
            this.field1750 += (long)var3;
            if(this.field1750 > this.length) {
               this.length = this.field1750;
            }

            long var9 = -1L;
            long var6 = -1L;
            if(this.position >= this.field1742 && this.position < this.field1742 + (long)this.field1741) {
               var9 = this.position;
            } else if(this.field1742 >= this.position && this.field1742 < (long)var3 + this.position) {
               var9 = this.field1742;
            }

            if((long)var3 + this.position > this.field1742 && (long)var3 + this.position <= (long)this.field1741 + this.field1742) {
               var6 = this.position + (long)var3;
            } else if((long)this.field1741 + this.field1742 > this.position && (long)this.field1741 + this.field1742 <= (long)var3 + this.position) {
               var6 = this.field1742 + (long)this.field1741;
            }

            if(var9 > -1L && var6 > var9) {
               int var8 = (int)(var6 - var9);
               System.arraycopy(var1, (int)(var9 + (long)var2 - this.position), this.readPayload, (int)(var9 - this.field1742), var8);
            }

            this.position += (long)var3;
         }
      } catch (IOException var12) {
         this.field1750 = -1L;
         throw var12;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "14"
   )
   void method2383() throws IOException {
      if(this.field1743 != -1L) {
         if(this.field1743 != this.field1750) {
            this.field1748.seek(this.field1743);
            this.field1750 = this.field1743;
         }

         this.field1748.write(this.writePayload, 0, this.field1744);
         this.field1750 += (long)(this.field1744 * -1217714817) * -1682531713L;
         if(this.field1750 > this.length) {
            this.length = this.field1750;
         }

         long var1 = -1L;
         long var3 = -1L;
         if(this.field1743 >= this.field1742 && this.field1743 < this.field1742 + (long)this.field1741) {
            var1 = this.field1743;
         } else if(this.field1742 >= this.field1743 && this.field1742 < (long)this.field1744 + this.field1743) {
            var1 = this.field1742;
         }

         if((long)this.field1744 + this.field1743 > this.field1742 && (long)this.field1744 + this.field1743 <= this.field1742 + (long)this.field1741) {
            var3 = this.field1743 + (long)this.field1744;
         } else if((long)this.field1741 + this.field1742 > this.field1743 && this.field1742 + (long)this.field1741 <= this.field1743 + (long)this.field1744) {
            var3 = this.field1742 + (long)this.field1741;
         }

         if(var1 > -1L && var3 > var1) {
            int var5 = (int)(var3 - var1);
            System.arraycopy(this.writePayload, (int)(var1 - this.field1743), this.readPayload, (int)(var1 - this.field1742), var5);
         }

         this.field1743 = -1L;
         this.field1744 = 0;
      }

   }

   @ObfuscatedName("fi")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "209713116"
   )
   static final void method2399(String var0) {
      if(var0.equalsIgnoreCase("toggleroof")) {
         class70.preferences.hideRoofs = !class70.preferences.hideRoofs;
         WorldMapType3.method215();
         if(class70.preferences.hideRoofs) {
            class174.sendGameMessage(99, "", "Roofs are now all hidden");
         } else {
            class174.sendGameMessage(99, "", "Roofs will only be removed selectively");
         }
      }

      if(var0.equalsIgnoreCase("displayfps")) {
         Client.displayFps = !Client.displayFps;
      }

      if(Client.rights >= 2) {
         if(var0.equalsIgnoreCase("aabb")) {
            if(!class7.field245) {
               class7.field245 = true;
               class7.field240 = class11.field275;
            } else if(class11.field275 == class7.field240) {
               class7.field245 = true;
               class7.field240 = class11.field276;
            } else {
               class7.field245 = false;
            }
         }

         if(var0.equalsIgnoreCase("fpson")) {
            Client.displayFps = true;
         }

         if(var0.equalsIgnoreCase("fpsoff")) {
            Client.displayFps = false;
         }

         if(var0.equalsIgnoreCase("gc")) {
            System.gc();
         }

         if(var0.equalsIgnoreCase("clientdrop")) {
            class60.method1028();
         }

         if(var0.equalsIgnoreCase("errortest") && Client.socketType == 2) {
            throw new RuntimeException();
         }
      }

      Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_COMMAND);
      Client.secretPacketBuffer1.putByte(var0.length() + 1);
      Client.secretPacketBuffer1.putString(var0);
   }
}
