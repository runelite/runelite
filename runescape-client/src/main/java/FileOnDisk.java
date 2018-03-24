import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.SyncFailedException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("de")
@Implements("FileOnDisk")
public final class FileOnDisk {
   @ObfuscatedName("t")
   @Export("file")
   RandomAccessFile file;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      longValue = -5911749899801209833L
   )
   @Export("length")
   long length;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      longValue = 331807842309922009L
   )
   @Export("position")
   long position;

   public FileOnDisk(File var1, String var2, long var3) throws IOException {
      if(var3 == -1L) {
         var3 = Long.MAX_VALUE;
      }

      if(var1.length() >= var3) {
         var1.delete();
      }

      this.file = new RandomAccessFile(var1, var2);
      this.length = var3;
      this.position = 0L;
      int var5 = this.file.read();
      if(var5 != -1 && !var2.equals("r")) {
         this.file.seek(0L);
         this.file.write(var5);
      }

      this.file.seek(0L);
   }

   @ObfuscatedName("t")
   @Export("seek")
   final void seek(long var1) throws IOException {
      this.file.seek(var1);
      this.position = var1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "467686700"
   )
   @Export("write")
   public final void write(byte[] var1, int var2, int var3) throws IOException {
      if(this.position + (long)var3 > this.length) {
         this.file.seek(1L + this.length);
         this.file.write(1);
         throw new EOFException();
      } else {
         this.file.write(var1, var2, var3);
         this.position += (long)var3;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1535529545"
   )
   @Export("close")
   public final void close() throws IOException {
      this.closeSync(false);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(ZS)V",
      garbageValue = "147"
   )
   @Export("closeSync")
   public final void closeSync(boolean var1) throws IOException {
      if(this.file != null) {
         if(var1) {
            try {
               this.file.getFD().sync();
            } catch (SyncFailedException var3) {
               ;
            }
         }

         this.file.close();
         this.file = null;
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)J",
      garbageValue = "27"
   )
   @Export("length")
   public final long length() throws IOException {
      return this.file.length();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "([BIIB)I",
      garbageValue = "2"
   )
   @Export("read")
   public final int read(byte[] var1, int var2, int var3) throws IOException {
      int var4 = this.file.read(var1, var2, var3);
      if(var4 > 0) {
         this.position += (long)var4;
      }

      return var4;
   }

   protected void finalize() throws Throwable {
      if(this.file != null) {
         System.out.println("");
         this.close();
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1610804582"
   )
   static final void method2556() {
      MapIconReference.method757("You can\'t add yourself to your own friend list");
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(ILcj;ZI)I",
      garbageValue = "-213873683"
   )
   static int method2563(int var0, Script var1, boolean var2) {
      if(var0 == 3300) {
         class81.intStack[++class5.intStackSize - 1] = Client.gameCycle;
         return 1;
      } else {
         int var3;
         int var4;
         if(var0 == 3301) {
            class5.intStackSize -= 2;
            var3 = class81.intStack[class5.intStackSize];
            var4 = class81.intStack[class5.intStackSize + 1];
            class81.intStack[++class5.intStackSize - 1] = BoundingBox3DDrawMode.method63(var3, var4);
            return 1;
         } else if(var0 == 3302) {
            class5.intStackSize -= 2;
            var3 = class81.intStack[class5.intStackSize];
            var4 = class81.intStack[class5.intStackSize + 1];
            class81.intStack[++class5.intStackSize - 1] = SoundTaskDataProvider.method831(var3, var4);
            return 1;
         } else if(var0 == 3303) {
            class5.intStackSize -= 2;
            var3 = class81.intStack[class5.intStackSize];
            var4 = class81.intStack[class5.intStackSize + 1];
            class81.intStack[++class5.intStackSize - 1] = BoundingBox3DDrawMode.method60(var3, var4);
            return 1;
         } else {
            int var5;
            if(var0 == 3304) {
               var3 = class81.intStack[--class5.intStackSize];
               int[] var9 = class81.intStack;
               var5 = ++class5.intStackSize - 1;
               InvType var7 = (InvType)InvType.inventoryCache.get((long)var3);
               InvType var6;
               if(var7 != null) {
                  var6 = var7;
               } else {
                  byte[] var13 = InvType.field3443.getConfigData(5, var3);
                  var7 = new InvType();
                  if(var13 != null) {
                     var7.decode(new Buffer(var13));
                  }

                  InvType.inventoryCache.put(var7, (long)var3);
                  var6 = var7;
               }

               var9[var5] = var6.size;
               return 1;
            } else if(var0 == 3305) {
               var3 = class81.intStack[--class5.intStackSize];
               class81.intStack[++class5.intStackSize - 1] = Client.boostedSkillLevels[var3];
               return 1;
            } else if(var0 == 3306) {
               var3 = class81.intStack[--class5.intStackSize];
               class81.intStack[++class5.intStackSize - 1] = Client.realSkillLevels[var3];
               return 1;
            } else if(var0 == 3307) {
               var3 = class81.intStack[--class5.intStackSize];
               class81.intStack[++class5.intStackSize - 1] = Client.skillExperiences[var3];
               return 1;
            } else if(var0 == 3308) {
               var3 = Ignore.plane;
               var4 = (WorldMapData.localPlayer.x >> 7) + class38.baseX;
               var5 = (WorldMapData.localPlayer.y >> 7) + PlayerComposition.baseY;
               class81.intStack[++class5.intStackSize - 1] = (var4 << 14) + var5 + (var3 << 28);
               return 1;
            } else if(var0 == 3309) {
               var3 = class81.intStack[--class5.intStackSize];
               class81.intStack[++class5.intStackSize - 1] = var3 >> 14 & 16383;
               return 1;
            } else if(var0 == 3310) {
               var3 = class81.intStack[--class5.intStackSize];
               class81.intStack[++class5.intStackSize - 1] = var3 >> 28;
               return 1;
            } else if(var0 == 3311) {
               var3 = class81.intStack[--class5.intStackSize];
               class81.intStack[++class5.intStackSize - 1] = var3 & 16383;
               return 1;
            } else if(var0 == 3312) {
               class81.intStack[++class5.intStackSize - 1] = Client.isMembers?1:0;
               return 1;
            } else if(var0 == 3313) {
               class5.intStackSize -= 2;
               var3 = class81.intStack[class5.intStackSize] + 32768;
               var4 = class81.intStack[class5.intStackSize + 1];
               class81.intStack[++class5.intStackSize - 1] = BoundingBox3DDrawMode.method63(var3, var4);
               return 1;
            } else {
               int var11;
               if(var0 != 3314) {
                  if(var0 == 3315) {
                     class5.intStackSize -= 2;
                     var3 = class81.intStack[class5.intStackSize] + 32768;
                     var4 = class81.intStack[class5.intStackSize + 1];
                     class81.intStack[++class5.intStackSize - 1] = BoundingBox3DDrawMode.method60(var3, var4);
                     return 1;
                  } else if(var0 == 3316) {
                     if(Client.rights >= 2) {
                        class81.intStack[++class5.intStackSize - 1] = Client.rights;
                     } else {
                        class81.intStack[++class5.intStackSize - 1] = 0;
                     }

                     return 1;
                  } else if(var0 == 3317) {
                     class81.intStack[++class5.intStackSize - 1] = Client.field865;
                     return 1;
                  } else if(var0 == 3318) {
                     class81.intStack[++class5.intStackSize - 1] = Client.world;
                     return 1;
                  } else if(var0 == 3321) {
                     class81.intStack[++class5.intStackSize - 1] = Client.energy;
                     return 1;
                  } else if(var0 == 3322) {
                     class81.intStack[++class5.intStackSize - 1] = Client.weight;
                     return 1;
                  } else if(var0 == 3323) {
                     if(Client.field1017) {
                        class81.intStack[++class5.intStackSize - 1] = 1;
                     } else {
                        class81.intStack[++class5.intStackSize - 1] = 0;
                     }

                     return 1;
                  } else if(var0 == 3324) {
                     class81.intStack[++class5.intStackSize - 1] = Client.flags;
                     return 1;
                  } else if(var0 == 3325) {
                     class5.intStackSize -= 4;
                     var3 = class81.intStack[class5.intStackSize];
                     var4 = class81.intStack[class5.intStackSize + 1];
                     var5 = class81.intStack[class5.intStackSize + 2];
                     var11 = class81.intStack[class5.intStackSize + 3];
                     var3 += var4 << 14;
                     var3 += var5 << 28;
                     var3 += var11;
                     class81.intStack[++class5.intStackSize - 1] = var3;
                     return 1;
                  } else {
                     return 2;
                  }
               } else {
                  class5.intStackSize -= 2;
                  var3 = class81.intStack[class5.intStackSize] + 32768;
                  var4 = class81.intStack[class5.intStackSize + 1];
                  int[] var10 = class81.intStack;
                  var11 = ++class5.intStackSize - 1;
                  ItemContainer var8 = (ItemContainer)ItemContainer.itemContainers.get((long)var3);
                  int var12;
                  if(var8 == null) {
                     var12 = 0;
                  } else if(var4 >= 0 && var4 < var8.stackSizes.length) {
                     var12 = var8.stackSizes[var4];
                  } else {
                     var12 = 0;
                  }

                  var10[var11] = var12;
                  return 1;
               }
            }
         }
      }
   }

   @ObfuscatedName("kw")
   @ObfuscatedSignature(
      signature = "(IIIZB)V",
      garbageValue = "21"
   )
   public static void method2542(int var0, int var1, int var2, boolean var3) {
      PacketNode var4 = class33.method382(ClientPacket.field2415, Client.field1072.field1456);
      var4.packetBuffer.method3570(var1);
      var4.packetBuffer.method3619(var2);
      var4.packetBuffer.putShort(var0);
      var4.packetBuffer.method3582(var3?Client.field930:0);
      Client.field1072.method2073(var4);
   }
}
