import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dd")
@Implements("CacheFile")
public class CacheFile {
   @ObfuscatedName("qr")
   @ObfuscatedSignature(
      signature = "Lbm;"
   )
   @Export("friendManager")
   public static FriendManager friendManager;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Ldw;"
   )
   @Export("accessFile")
   FileOnDisk accessFile;
   @ObfuscatedName("m")
   @Export("readPayload")
   byte[] readPayload;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      longValue = 79894814711093239L
   )
   long field1443;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1152552109
   )
   int field1450;
   @ObfuscatedName("f")
   @Export("writePayload")
   byte[] writePayload;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      longValue = -5782506921457900227L
   )
   long field1445;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1131433535
   )
   int field1447;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      longValue = -7476910008420183513L
   )
   @Export("position")
   long position;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      longValue = 5226289285948649811L
   )
   @Export("length")
   long length;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      longValue = 8930523000186473743L
   )
   @Export("capacity")
   long capacity;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      longValue = 1367430875267670415L
   )
   long field1444;

   @ObfuscatedSignature(
      signature = "(Ldw;II)V"
   )
   public CacheFile(FileOnDisk var1, int var2, int var3) throws IOException {
      this.field1443 = -1L;
      this.field1445 = -1L;
      this.field1447 = 0;
      this.accessFile = var1;
      this.capacity = this.length = var1.length();
      this.readPayload = new byte[var2];
      this.writePayload = new byte[var3];
      this.position = 0L;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-776871131"
   )
   @Export("close")
   public void close() throws IOException {
      this.flush();
      this.accessFile.close();
   }

   @ObfuscatedName("m")
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
      garbageValue = "-1366209319"
   )
   @Export("length")
   public long length() {
      return this.capacity;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([BB)V",
      garbageValue = "-88"
   )
   @Export("read")
   public void read(byte[] var1) throws IOException {
      this.read(var1, 0, var1.length);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([BIIS)V",
      garbageValue = "255"
   )
   @Export("read")
   public void read(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(var3 + var2 > var1.length) {
            throw new ArrayIndexOutOfBoundsException(var3 + var2 - var1.length);
         }

         if(this.field1445 != -1L && this.position >= this.field1445 && this.position + (long)var3 <= (long)this.field1447 + this.field1445) {
            System.arraycopy(this.writePayload, (int)(this.position - this.field1445), var1, var2, var3);
            this.position += (long)var3;
            return;
         }

         long var4 = this.position;
         int var7 = var3;
         int var8;
         if(this.position >= this.field1443 && this.position < (long)this.field1450 + this.field1443) {
            var8 = (int)((long)this.field1450 - (this.position - this.field1443));
            if(var8 > var3) {
               var8 = var3;
            }

            System.arraycopy(this.readPayload, (int)(this.position - this.field1443), var1, var2, var8);
            this.position += (long)var8;
            var2 += var8;
            var3 -= var8;
         }

         if(var3 > this.readPayload.length) {
            this.accessFile.seek(this.position);

            for(this.field1444 = this.position; var3 > 0; var3 -= var8) {
               var8 = this.accessFile.read(var1, var2, var3);
               if(var8 == -1) {
                  break;
               }

               this.field1444 += (long)var8;
               this.position += (long)var8;
               var2 += var8;
            }
         } else if(var3 > 0) {
            this.load();
            var8 = var3;
            if(var3 > this.field1450) {
               var8 = this.field1450;
            }

            System.arraycopy(this.readPayload, 0, var1, var2, var8);
            var2 += var8;
            var3 -= var8;
            this.position += (long)var8;
         }

         if(-1L != this.field1445) {
            if(this.field1445 > this.position && var3 > 0) {
               var8 = var2 + (int)(this.field1445 - this.position);
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
            if(this.field1445 >= var4 && this.field1445 < (long)var7 + var4) {
               var13 = this.field1445;
            } else if(var4 >= this.field1445 && var4 < this.field1445 + (long)this.field1447) {
               var13 = var4;
            }

            if((long)this.field1447 + this.field1445 > var4 && (long)this.field1447 + this.field1445 <= (long)var7 + var4) {
               var10 = (long)this.field1447 + this.field1445;
            } else if((long)var7 + var4 > this.field1445 && var4 + (long)var7 <= this.field1445 + (long)this.field1447) {
               var10 = var4 + (long)var7;
            }

            if(var13 > -1L && var10 > var13) {
               int var12 = (int)(var10 - var13);
               System.arraycopy(this.writePayload, (int)(var13 - this.field1445), var1, (int)(var13 - var4) + var2, var12);
               if(var10 > this.position) {
                  var3 = (int)((long)var3 - (var10 - this.position));
                  this.position = var10;
               }
            }
         }
      } catch (IOException var16) {
         this.field1444 = -1L;
         throw var16;
      }

      if(var3 > 0) {
         throw new EOFException();
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "6"
   )
   @Export("load")
   void load() throws IOException {
      this.field1450 = 0;
      if(this.position != this.field1444) {
         this.accessFile.seek(this.position);
         this.field1444 = this.position;
      }

      int var1;
      for(this.field1443 = this.position; this.field1450 < this.readPayload.length; this.field1450 += var1) {
         var1 = this.accessFile.read(this.readPayload, this.field1450, this.readPayload.length - this.field1450);
         if(var1 == -1) {
            break;
         }

         this.field1444 += (long)var1;
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "8"
   )
   @Export("write")
   public void write(byte[] var1, int var2, int var3) throws IOException {
      try {
         if((long)var3 + this.position > this.capacity) {
            this.capacity = (long)var3 + this.position;
         }

         if(this.field1445 != -1L && (this.position < this.field1445 || this.position > this.field1445 + (long)this.field1447)) {
            this.flush();
         }

         if(this.field1445 != -1L && (long)var3 + this.position > (long)this.writePayload.length + this.field1445) {
            int var4 = (int)((long)this.writePayload.length - (this.position - this.field1445));
            System.arraycopy(var1, var2, this.writePayload, (int)(this.position - this.field1445), var4);
            this.position += (long)var4;
            var2 += var4;
            var3 -= var4;
            this.field1447 = this.writePayload.length;
            this.flush();
         }

         if(var3 <= this.writePayload.length) {
            if(var3 > 0) {
               if(-1L == this.field1445) {
                  this.field1445 = this.position;
               }

               System.arraycopy(var1, var2, this.writePayload, (int)(this.position - this.field1445), var3);
               this.position += (long)var3;
               if(this.position - this.field1445 > (long)this.field1447) {
                  this.field1447 = (int)(this.position - this.field1445);
               }

            }
         } else {
            if(this.position != this.field1444) {
               this.accessFile.seek(this.position);
               this.field1444 = this.position;
            }

            this.accessFile.write(var1, var2, var3);
            this.field1444 += (long)var3;
            if(this.field1444 > this.length) {
               this.length = this.field1444;
            }

            long var9 = -1L;
            long var6 = -1L;
            if(this.position >= this.field1443 && this.position < (long)this.field1450 + this.field1443) {
               var9 = this.position;
            } else if(this.field1443 >= this.position && this.field1443 < (long)var3 + this.position) {
               var9 = this.field1443;
            }

            if((long)var3 + this.position > this.field1443 && this.position + (long)var3 <= this.field1443 + (long)this.field1450) {
               var6 = (long)var3 + this.position;
            } else if(this.field1443 + (long)this.field1450 > this.position && (long)this.field1450 + this.field1443 <= (long)var3 + this.position) {
               var6 = this.field1443 + (long)this.field1450;
            }

            if(var9 > -1L && var6 > var9) {
               int var8 = (int)(var6 - var9);
               System.arraycopy(var1, (int)(var9 + (long)var2 - this.position), this.readPayload, (int)(var9 - this.field1443), var8);
            }

            this.position += (long)var3;
         }
      } catch (IOException var12) {
         this.field1444 = -1L;
         throw var12;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1749709188"
   )
   @Export("flush")
   void flush() throws IOException {
      if(this.field1445 != -1L) {
         if(this.field1444 != this.field1445) {
            this.accessFile.seek(this.field1445);
            this.field1444 = this.field1445;
         }

         this.accessFile.write(this.writePayload, 0, this.field1447);
         this.field1444 += (long)(this.field1447 * 1912644031) * 1131433535L;
         if(this.field1444 > this.length) {
            this.length = this.field1444;
         }

         long var1 = -1L;
         long var3 = -1L;
         if(this.field1445 >= this.field1443 && this.field1445 < this.field1443 + (long)this.field1450) {
            var1 = this.field1445;
         } else if(this.field1443 >= this.field1445 && this.field1443 < this.field1445 + (long)this.field1447) {
            var1 = this.field1443;
         }

         if(this.field1445 + (long)this.field1447 > this.field1443 && this.field1445 + (long)this.field1447 <= (long)this.field1450 + this.field1443) {
            var3 = this.field1445 + (long)this.field1447;
         } else if((long)this.field1450 + this.field1443 > this.field1445 && (long)this.field1450 + this.field1443 <= this.field1445 + (long)this.field1447) {
            var3 = (long)this.field1450 + this.field1443;
         }

         if(var1 > -1L && var3 > var1) {
            int var5 = (int)(var3 - var1);
            System.arraycopy(this.writePayload, (int)(var1 - this.field1445), this.readPayload, (int)(var1 - this.field1443), var5);
         }

         this.field1445 = -1L;
         this.field1447 = 0;
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lgy;Lgx;I)Lgx;",
      garbageValue = "-1971083675"
   )
   @Export("readStringIntParameters")
   static final IterableHashTable readStringIntParameters(Buffer var0, IterableHashTable var1) {
      int var2 = var0.readUnsignedByte();
      int var3;
      if(var1 == null) {
         var3 = class81.nextPowerOfTwo(var2);
         var1 = new IterableHashTable(var3);
      }

      for(var3 = 0; var3 < var2; ++var3) {
         boolean var4 = var0.readUnsignedByte() == 1;
         int var5 = var0.read24BitInt();
         Object var6;
         if(var4) {
            var6 = new ObjectNode(var0.readString());
         } else {
            var6 = new IntegerNode(var0.readInt());
         }

         var1.put((Node)var6, (long)var5);
      }

      return var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-1854065562"
   )
   public static int method2553(int var0, int var1, int var2) {
      var2 &= 3;
      return var2 == 0?var0:(var2 == 1?var1:(var2 == 2?7 - var0:7 - var1));
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)J",
      garbageValue = "591361198"
   )
   public static long method2522(int var0) {
      return class120.field1688[var0];
   }

   @ObfuscatedName("fu")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "378951678"
   )
   static void method2549() {
      Client.field739.method2020();
      Client.field739.packetBuffer.offset = 0;
      Client.field739.serverPacket = null;
      Client.field739.field1251 = null;
      Client.field739.field1245 = null;
      Client.field739.field1253 = null;
      Client.field739.packetLength = 0;
      Client.field739.field1249 = 0;
      Client.field643 = 0;
      Client.menuOptionCount = 0;
      Client.isMenuOpen = false;
      Client.field822 = 0;
      Client.destinationX = 0;

      int var0;
      for(var0 = 0; var0 < 2048; ++var0) {
         Client.cachedPlayers[var0] = null;
      }

      MilliTimer.localPlayer = null;

      for(var0 = 0; var0 < Client.cachedNPCs.length; ++var0) {
         NPC var1 = Client.cachedNPCs[var0];
         if(var1 != null) {
            var1.interacting = -1;
            var1.field910 = false;
         }
      }

      ItemContainer.itemContainers = new HashTable(32);
      Resampler.setGameState(30);

      for(var0 = 0; var0 < 100; ++var0) {
         Client.field795[var0] = true;
      }

      PacketNode var3 = DecorativeObject.method3115(ClientPacket.field2206, Client.field739.field1250);
      PacketBuffer var4 = var3.packetBuffer;
      int var2 = Client.isResized?2:1;
      var4.putByte(var2);
      var3.packetBuffer.putShort(class9.canvasWidth);
      var3.packetBuffer.putShort(class37.canvasHeight);
      Client.field739.method2019(var3);
   }

   @ObfuscatedName("kd")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)Ljava/lang/String;",
      garbageValue = "-1872122983"
   )
   static String method2551(String var0, boolean var1) {
      String var2 = var1?"https://":"http://";
      if(Client.socketType == 1) {
         var0 = var0 + "-wtrc";
      } else if(Client.socketType == 2) {
         var0 = var0 + "-wtqa";
      } else if(Client.socketType == 3) {
         var0 = var0 + "-wtwip";
      } else if(Client.socketType == 5) {
         var0 = var0 + "-wti";
      } else if(Client.socketType == 4) {
         var0 = "local";
      }

      String var3 = "";
      if(SoundTaskDataProvider.sessionToken != null) {
         var3 = "/p=" + SoundTaskDataProvider.sessionToken;
      }

      String var4 = "runescape.com";
      return var2 + var0 + "." + var4 + "/l=" + Client.languageId + "/a=" + class25.field231 + var3 + "/";
   }
}
