import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Opcodes;

@ObfuscatedName("da")
@Implements("CacheFile")
public class CacheFile {
   @ObfuscatedName("ou")
   @ObfuscatedSignature(
      signature = "Ldz;"
   )
   @Export("soundSystem0")
   static AbstractSoundSystem soundSystem0;
   @ObfuscatedName("x")
   @Export("osName")
   public static String osName;
   @ObfuscatedName("t")
   public static boolean field1774;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      longValue = 6553041751931198795L
   )
   long field1766;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      longValue = -1077047013766378967L
   )
   long field1761;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1994233995
   )
   int field1762;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      longValue = -8944172173191303177L
   )
   long field1771;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      longValue = -8222798535544309675L
   )
   @Export("position")
   long position;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      longValue = 8003552140438805997L
   )
   long field1763;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Ldc;"
   )
   FileOnDisk field1770;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1348329431
   )
   int field1767;
   @ObfuscatedName("o")
   @Export("writePayload")
   byte[] writePayload;
   @ObfuscatedName("j")
   @Export("readPayload")
   byte[] readPayload;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      longValue = -2652964784623792997L
   )
   @Export("length")
   long length;

   @ObfuscatedSignature(
      signature = "(Ldc;II)V"
   )
   public CacheFile(FileOnDisk var1, int var2, int var3) throws IOException {
      this.field1763 = -1L;
      this.field1771 = -1L;
      this.field1767 = 0;
      this.field1770 = var1;
      this.field1766 = this.length = var1.length();
      this.readPayload = new byte[var2];
      this.writePayload = new byte[var3];
      this.position = 0L;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-1812083276"
   )
   public void method2349(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(var3 + var2 > var1.length) {
            throw new ArrayIndexOutOfBoundsException(var3 + var2 - var1.length);
         }

         if(this.field1771 != -1L && this.position >= this.field1771 && this.position + (long)var3 <= this.field1771 + (long)this.field1767) {
            System.arraycopy(this.writePayload, (int)(this.position - this.field1771), var1, var2, var3);
            this.position += (long)var3;
            return;
         }

         long var4 = this.position;
         int var7 = var3;
         int var8;
         if(this.position >= this.field1763 && this.position < this.field1763 + (long)this.field1762) {
            var8 = (int)((long)this.field1762 - (this.position - this.field1763));
            if(var8 > var3) {
               var8 = var3;
            }

            System.arraycopy(this.readPayload, (int)(this.position - this.field1763), var1, var2, var8);
            this.position += (long)var8;
            var2 += var8;
            var3 -= var8;
         }

         if(var3 > this.readPayload.length) {
            this.field1770.seek(this.position);

            for(this.field1761 = this.position; var3 > 0; var3 -= var8) {
               var8 = this.field1770.read(var1, var2, var3);
               if(var8 == -1) {
                  break;
               }

               this.field1761 += (long)var8;
               this.position += (long)var8;
               var2 += var8;
            }
         } else if(var3 > 0) {
            this.method2338();
            var8 = var3;
            if(var3 > this.field1762) {
               var8 = this.field1762;
            }

            System.arraycopy(this.readPayload, 0, var1, var2, var8);
            var2 += var8;
            var3 -= var8;
            this.position += (long)var8;
         }

         if(-1L != this.field1771) {
            if(this.field1771 > this.position && var3 > 0) {
               var8 = var2 + (int)(this.field1771 - this.position);
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
            if(this.field1771 >= var4 && this.field1771 < (long)var7 + var4) {
               var13 = this.field1771;
            } else if(var4 >= this.field1771 && var4 < (long)this.field1767 + this.field1771) {
               var13 = var4;
            }

            if(this.field1771 + (long)this.field1767 > var4 && this.field1771 + (long)this.field1767 <= (long)var7 + var4) {
               var10 = (long)this.field1767 + this.field1771;
            } else if(var4 + (long)var7 > this.field1771 && var4 + (long)var7 <= (long)this.field1767 + this.field1771) {
               var10 = (long)var7 + var4;
            }

            if(var13 > -1L && var10 > var13) {
               int var12 = (int)(var10 - var13);
               System.arraycopy(this.writePayload, (int)(var13 - this.field1771), var1, (int)(var13 - var4) + var2, var12);
               if(var10 > this.position) {
                  var3 = (int)((long)var3 - (var10 - this.position));
                  this.position = var10;
               }
            }
         }
      } catch (IOException var16) {
         this.field1761 = -1L;
         throw var16;
      }

      if(var3 > 0) {
         throw new EOFException();
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2130188397"
   )
   void method2340() throws IOException {
      if(this.field1771 != -1L) {
         if(this.field1761 != this.field1771) {
            this.field1770.seek(this.field1771);
            this.field1761 = this.field1771;
         }

         this.field1770.write(this.writePayload, 0, this.field1767);
         this.field1761 += 1348329431L * (long)(this.field1767 * -465533977);
         if(this.field1761 > this.length) {
            this.length = this.field1761;
         }

         long var1 = -1L;
         long var3 = -1L;
         if(this.field1771 >= this.field1763 && this.field1771 < (long)this.field1762 + this.field1763) {
            var1 = this.field1771;
         } else if(this.field1763 >= this.field1771 && this.field1763 < (long)this.field1767 + this.field1771) {
            var1 = this.field1763;
         }

         if(this.field1771 + (long)this.field1767 > this.field1763 && this.field1771 + (long)this.field1767 <= this.field1763 + (long)this.field1762) {
            var3 = (long)this.field1767 + this.field1771;
         } else if((long)this.field1762 + this.field1763 > this.field1771 && this.field1763 + (long)this.field1762 <= (long)this.field1767 + this.field1771) {
            var3 = this.field1763 + (long)this.field1762;
         }

         if(var1 > -1L && var3 > var1) {
            int var5 = (int)(var3 - var1);
            System.arraycopy(this.writePayload, (int)(var1 - this.field1771), this.readPayload, (int)(var1 - this.field1763), var5);
         }

         this.field1771 = -1L;
         this.field1767 = 0;
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)J",
      garbageValue = "-108"
   )
   public long method2346() {
      return this.field1766;
   }

   @ObfuscatedName("j")
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
      signature = "([BIII)V",
      garbageValue = "755321672"
   )
   @Export("write")
   public void write(byte[] var1, int var2, int var3) throws IOException {
      try {
         if((long)var3 + this.position > this.field1766) {
            this.field1766 = (long)var3 + this.position;
         }

         if(this.field1771 != -1L && (this.position < this.field1771 || this.position > (long)this.field1767 + this.field1771)) {
            this.method2340();
         }

         if(this.field1771 != -1L && this.position + (long)var3 > (long)this.writePayload.length + this.field1771) {
            int var4 = (int)((long)this.writePayload.length - (this.position - this.field1771));
            System.arraycopy(var1, var2, this.writePayload, (int)(this.position - this.field1771), var4);
            this.position += (long)var4;
            var2 += var4;
            var3 -= var4;
            this.field1767 = this.writePayload.length;
            this.method2340();
         }

         if(var3 <= this.writePayload.length) {
            if(var3 > 0) {
               if(this.field1771 == -1L) {
                  this.field1771 = this.position;
               }

               System.arraycopy(var1, var2, this.writePayload, (int)(this.position - this.field1771), var3);
               this.position += (long)var3;
               if(this.position - this.field1771 > (long)this.field1767) {
                  this.field1767 = (int)(this.position - this.field1771);
               }

            }
         } else {
            if(this.field1761 != this.position) {
               this.field1770.seek(this.position);
               this.field1761 = this.position;
            }

            this.field1770.write(var1, var2, var3);
            this.field1761 += (long)var3;
            if(this.field1761 > this.length) {
               this.length = this.field1761;
            }

            long var9 = -1L;
            long var6 = -1L;
            if(this.position >= this.field1763 && this.position < this.field1763 + (long)this.field1762) {
               var9 = this.position;
            } else if(this.field1763 >= this.position && this.field1763 < this.position + (long)var3) {
               var9 = this.field1763;
            }

            if((long)var3 + this.position > this.field1763 && this.position + (long)var3 <= this.field1763 + (long)this.field1762) {
               var6 = this.position + (long)var3;
            } else if(this.field1763 + (long)this.field1762 > this.position && (long)this.field1762 + this.field1763 <= this.position + (long)var3) {
               var6 = this.field1763 + (long)this.field1762;
            }

            if(var9 > -1L && var6 > var9) {
               int var8 = (int)(var6 - var9);
               System.arraycopy(var1, (int)(var9 + (long)var2 - this.position), this.readPayload, (int)(var9 - this.field1763), var8);
            }

            this.position += (long)var3;
         }
      } catch (IOException var12) {
         this.field1761 = -1L;
         throw var12;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-43874890"
   )
   void method2338() throws IOException {
      this.field1762 = 0;
      if(this.position != this.field1761) {
         this.field1770.seek(this.position);
         this.field1761 = this.position;
      }

      int var1;
      for(this.field1763 = this.position; this.field1762 < this.readPayload.length; this.field1762 += var1) {
         var1 = this.field1770.read(this.readPayload, this.field1762, this.readPayload.length - this.field1762);
         if(var1 == -1) {
            break;
         }

         this.field1761 += (long)var1;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-437179321"
   )
   public void method2334() throws IOException {
      this.method2340();
      this.field1770.close();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "([BB)V",
      garbageValue = "56"
   )
   @Export("read")
   public void read(byte[] var1) throws IOException {
      this.method2349(var1, 0, var1.length);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-400312701"
   )
   public static int method2361(int var0, int var1) {
      int var2;
      for(var2 = 0; var1 > 0; --var1) {
         var2 = var2 << 1 | var0 & 1;
         var0 >>>= 1;
      }

      return var2;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lii;IIIZS)V",
      garbageValue = "2055"
   )
   public static void method2339(IndexDataBase var0, int var1, int var2, int var3, boolean var4) {
      class204.field2507 = 1;
      class204.field2508 = var0;
      class204.field2509 = var1;
      ItemContainer.field787 = var2;
      class204.field2510 = var3;
      Varcs.field1528 = var4;
      class115.field1694 = 10000;
   }

   @ObfuscatedName("ho")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)V",
      garbageValue = "2012158097"
   )
   static void method2363(int var0, String var1) {
      int var2 = class95.field1507;
      int[] var3 = class95.field1511;
      boolean var4 = false;

      for(int var5 = 0; var5 < var2; ++var5) {
         Player var6 = Client.cachedPlayers[var3[var5]];
         if(var6 != null && var6 != Player.localPlayer && var6.name != null && var6.name.equalsIgnoreCase(var1)) {
            if(var0 == 1) {
               Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_73);
               if(Client.RUNELITE_PACKET) {
                  Client.secretPacketBuffer1.runeliteWriteInt(0);
                  Client.secretPacketBuffer1.runeliteWriteInt(var3[var5]);
               } else {
                  Client.secretPacketBuffer1.putByte(0);
                  Client.secretPacketBuffer1.method3273(var3[var5]);
               }
            } else if(var0 == 4) {
               Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_TRADE_PLAYER);
               if(Client.RUNELITE_PACKET) {
                  Client.secretPacketBuffer1.runeliteWriteInt(0);
                  Client.secretPacketBuffer1.runeliteWriteInt(var3[var5]);
               } else {
                  Client.secretPacketBuffer1.putLEInt(0);
                  Client.secretPacketBuffer1.putShortLE(var3[var5]);
               }
            } else if(var0 == 6) {
               Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_115);
               if(Client.RUNELITE_PACKET) {
                  Client.secretPacketBuffer1.runeliteWriteInt(0);
                  Client.secretPacketBuffer1.runeliteWriteInt(var3[var5]);
               } else {
                  Client.secretPacketBuffer1.putLEInt(0);
                  Client.secretPacketBuffer1.putShortLE(var3[var5]);
               }
            } else if(var0 == 7) {
               Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_65);
               if(Client.RUNELITE_PACKET) {
                  Client.secretPacketBuffer1.runeliteWriteInt(0);
                  Client.secretPacketBuffer1.runeliteWriteInt(var3[var5]);
               } else {
                  Client.secretPacketBuffer1.putLEInt(0);
                  Client.secretPacketBuffer1.method3273(var3[var5]);
               }
            }

            var4 = true;
            break;
         }
      }

      if(!var4) {
         Client.sendGameMessage(4, "", "Unable to find " + var1);
      }

   }

   @ObfuscatedName("fg")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "21"
   )
   static final void method2362() {
      int var0 = class271.field3678 * 128 + 64;
      int var1 = 64 + class87.field1393 * 128;
      int var2 = class227.getTileHeight(var0, var1, class27.plane) - GroundObject.field1881;
      if(class82.cameraX < var0) {
         class82.cameraX = (var0 - class82.cameraX) * class9.field250 / 1000 + class82.cameraX + class86.field1392;
         if(class82.cameraX > var0) {
            class82.cameraX = var0;
         }
      }

      if(class82.cameraX > var0) {
         class82.cameraX -= class9.field250 * (class82.cameraX - var0) / 1000 + class86.field1392;
         if(class82.cameraX < var0) {
            class82.cameraX = var0;
         }
      }

      if(Ignore.cameraZ < var2) {
         Ignore.cameraZ = (var2 - Ignore.cameraZ) * class9.field250 / 1000 + Ignore.cameraZ + class86.field1392;
         if(Ignore.cameraZ > var2) {
            Ignore.cameraZ = var2;
         }
      }

      if(Ignore.cameraZ > var2) {
         Ignore.cameraZ -= class9.field250 * (Ignore.cameraZ - var2) / 1000 + class86.field1392;
         if(Ignore.cameraZ < var2) {
            Ignore.cameraZ = var2;
         }
      }

      if(class158.cameraY < var1) {
         class158.cameraY = (var1 - class158.cameraY) * class9.field250 / 1000 + class158.cameraY + class86.field1392;
         if(class158.cameraY > var1) {
            class158.cameraY = var1;
         }
      }

      if(class158.cameraY > var1) {
         class158.cameraY -= class9.field250 * (class158.cameraY - var1) / 1000 + class86.field1392;
         if(class158.cameraY < var1) {
            class158.cameraY = var1;
         }
      }

      var0 = 64 + class89.field1421 * 128;
      var1 = ItemContainer.field790 * 128 + 64;
      var2 = class227.getTileHeight(var0, var1, class27.plane) - class169.field2340;
      int var3 = var0 - class82.cameraX;
      int var4 = var2 - Ignore.cameraZ;
      int var5 = var1 - class158.cameraY;
      int var6 = (int)Math.sqrt((double)(var3 * var3 + var5 * var5));
      int var7 = (int)(Math.atan2((double)var4, (double)var6) * 325.949D) & 2047;
      int var8 = (int)(Math.atan2((double)var3, (double)var5) * -325.949D) & 2047;
      if(var7 < 128) {
         var7 = 128;
      }

      if(var7 > 383) {
         var7 = 383;
      }

      if(Friend.cameraPitch < var7) {
         Friend.cameraPitch = (var7 - Friend.cameraPitch) * MilliTimer.field2218 / 1000 + Friend.cameraPitch + class64.field812;
         if(Friend.cameraPitch > var7) {
            Friend.cameraPitch = var7;
         }
      }

      if(Friend.cameraPitch > var7) {
         Friend.cameraPitch -= MilliTimer.field2218 * (Friend.cameraPitch - var7) / 1000 + class64.field812;
         if(Friend.cameraPitch < var7) {
            Friend.cameraPitch = var7;
         }
      }

      int var9 = var8 - Ignore.cameraYaw;
      if(var9 > 1024) {
         var9 -= 2048;
      }

      if(var9 < -1024) {
         var9 += 2048;
      }

      if(var9 > 0) {
         Ignore.cameraYaw += var9 * MilliTimer.field2218 / 1000 + class64.field812;
         Ignore.cameraYaw &= 2047;
      }

      if(var9 < 0) {
         Ignore.cameraYaw -= class64.field812 + -var9 * MilliTimer.field2218 / 1000;
         Ignore.cameraYaw &= 2047;
      }

      int var10 = var8 - Ignore.cameraYaw;
      if(var10 > 1024) {
         var10 -= 2048;
      }

      if(var10 < -1024) {
         var10 += 2048;
      }

      if(var10 < 0 && var9 > 0 || var10 > 0 && var9 < 0) {
         Ignore.cameraYaw = var8;
      }

   }
}
