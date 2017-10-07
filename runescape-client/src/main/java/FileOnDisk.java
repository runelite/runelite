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

@ObfuscatedName("dw")
@Implements("FileOnDisk")
public final class FileOnDisk {
   @ObfuscatedName("p")
   @Export("scriptLocalStrings")
   static String[] scriptLocalStrings;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      longValue = 3899941133317147237L
   )
   @Export("position")
   long position;
   @ObfuscatedName("d")
   @Export("file")
   RandomAccessFile file;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      longValue = -5694526308621846409L
   )
   @Export("length")
   long length;

   public FileOnDisk(File var1, String var2, long var3) throws IOException {
      if(-1L == var3) {
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

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-2036573380"
   )
   public final void method2445(boolean var1) throws IOException {
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

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "-827659861"
   )
   @Export("length")
   public final long length() throws IOException {
      return this.file.length();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1070520457"
   )
   @Export("close")
   public final void close() throws IOException {
      this.method2445(false);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "594849700"
   )
   @Export("read")
   public final int read(byte[] var1, int var2, int var3) throws IOException {
      int var4 = this.file.read(var1, var2, var3);
      if(var4 > 0) {
         this.position += (long)var4;
      }

      return var4;
   }

   @ObfuscatedName("d")
   @Export("seek")
   final void seek(long var1) throws IOException {
      this.file.seek(var1);
      this.position = var1;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "1062847520"
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

   protected void finalize() throws Throwable {
      if(this.file != null) {
         System.out.println("");
         this.close();
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Leb;IIII)Z",
      garbageValue = "-2127562289"
   )
   static final boolean method2457(Model var0, int var1, int var2, int var3) {
      if(!class54.method813()) {
         return false;
      } else {
         int var4;
         int var5;
         int var6;
         int var7;
         int var10;
         int var11;
         int var12;
         int var15;
         int var16;
         if(!class132.field1983) {
            var4 = Region.pitchSin;
            var5 = Region.pitchCos;
            var6 = Region.yawSin;
            var7 = Region.yawCos;
            byte var8 = 50;
            short var9 = 3500;
            var10 = (class132.field1985 - Graphics3D.centerX) * var8 / Graphics3D.field2009;
            var11 = (class132.field1984 - Graphics3D.centerY) * var8 / Graphics3D.field2009;
            var12 = (class132.field1985 - Graphics3D.centerX) * var9 / Graphics3D.field2009;
            int var13 = (class132.field1984 - Graphics3D.centerY) * var9 / Graphics3D.field2009;
            int var14 = Graphics3D.method2701(var11, var8, var5, var4);
            var15 = Graphics3D.method2702(var11, var8, var5, var4);
            var11 = var14;
            var14 = Graphics3D.method2701(var13, var9, var5, var4);
            var16 = Graphics3D.method2702(var13, var9, var5, var4);
            var13 = var14;
            var14 = Graphics3D.method2707(var10, var15, var7, var6);
            var15 = Graphics3D.method2700(var10, var15, var7, var6);
            var10 = var14;
            var14 = Graphics3D.method2707(var12, var16, var7, var6);
            var16 = Graphics3D.method2700(var12, var16, var7, var6);
            class132.field1986 = (var14 + var10) / 2;
            class96.field1517 = (var13 + var11) / 2;
            class270.field3685 = (var16 + var15) / 2;
            class132.field1987 = (var14 - var10) / 2;
            BuildType.field3190 = (var13 - var11) / 2;
            class132.field1988 = (var16 - var15) / 2;
            class31.field459 = Math.abs(class132.field1987);
            MessageNode.field873 = Math.abs(BuildType.field3190);
            class48.field638 = Math.abs(class132.field1988);
         }

         var4 = var0.field1944 + var1;
         var5 = var2 + var0.field1963;
         var6 = var3 + var0.field1946;
         var7 = var0.field1947;
         var15 = var0.field1948;
         var16 = var0.field1924;
         var10 = class132.field1986 - var4;
         var11 = class96.field1517 - var5;
         var12 = class270.field3685 - var6;
         return Math.abs(var10) > var7 + class31.field459?false:(Math.abs(var11) > var15 + MessageNode.field873?false:(Math.abs(var12) > var16 + class48.field638?false:(Math.abs(var12 * BuildType.field3190 - var11 * class132.field1988) > var16 * MessageNode.field873 + var15 * class48.field638?false:(Math.abs(var10 * class132.field1988 - var12 * class132.field1987) > var16 * class31.field459 + var7 * class48.field638?false:Math.abs(var11 * class132.field1987 - var10 * BuildType.field3190) <= var15 * class31.field459 + var7 * MessageNode.field873))));
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(ILcv;ZB)I",
      garbageValue = "79"
   )
   static int method2449(int var0, Script var1, boolean var2) {
      int var3;
      int var4;
      if(var0 == 4000) {
         class81.intStackSize -= 2;
         var3 = class81.intStack[class81.intStackSize];
         var4 = class81.intStack[class81.intStackSize + 1];
         class81.intStack[++class81.intStackSize - 1] = var3 + var4;
         return 1;
      } else if(var0 == 4001) {
         class81.intStackSize -= 2;
         var3 = class81.intStack[class81.intStackSize];
         var4 = class81.intStack[class81.intStackSize + 1];
         class81.intStack[++class81.intStackSize - 1] = var3 - var4;
         return 1;
      } else if(var0 == 4002) {
         class81.intStackSize -= 2;
         var3 = class81.intStack[class81.intStackSize];
         var4 = class81.intStack[class81.intStackSize + 1];
         class81.intStack[++class81.intStackSize - 1] = var4 * var3;
         return 1;
      } else if(var0 == 4003) {
         class81.intStackSize -= 2;
         var3 = class81.intStack[class81.intStackSize];
         var4 = class81.intStack[class81.intStackSize + 1];
         class81.intStack[++class81.intStackSize - 1] = var3 / var4;
         return 1;
      } else if(var0 == 4004) {
         var3 = class81.intStack[--class81.intStackSize];
         class81.intStack[++class81.intStackSize - 1] = (int)(Math.random() * (double)var3);
         return 1;
      } else if(var0 == 4005) {
         var3 = class81.intStack[--class81.intStackSize];
         class81.intStack[++class81.intStackSize - 1] = (int)(Math.random() * (double)(var3 + 1));
         return 1;
      } else if(var0 == 4006) {
         class81.intStackSize -= 5;
         var3 = class81.intStack[class81.intStackSize];
         var4 = class81.intStack[class81.intStackSize + 1];
         int var5 = class81.intStack[class81.intStackSize + 2];
         int var6 = class81.intStack[class81.intStackSize + 3];
         int var7 = class81.intStack[class81.intStackSize + 4];
         class81.intStack[++class81.intStackSize - 1] = var3 + (var4 - var3) * (var7 - var5) / (var6 - var5);
         return 1;
      } else if(var0 == 4007) {
         class81.intStackSize -= 2;
         var3 = class81.intStack[class81.intStackSize];
         var4 = class81.intStack[class81.intStackSize + 1];
         class81.intStack[++class81.intStackSize - 1] = var3 + var4 * var3 / 100;
         return 1;
      } else if(var0 == 4008) {
         class81.intStackSize -= 2;
         var3 = class81.intStack[class81.intStackSize];
         var4 = class81.intStack[class81.intStackSize + 1];
         class81.intStack[++class81.intStackSize - 1] = var3 | 1 << var4;
         return 1;
      } else if(var0 == 4009) {
         class81.intStackSize -= 2;
         var3 = class81.intStack[class81.intStackSize];
         var4 = class81.intStack[class81.intStackSize + 1];
         class81.intStack[++class81.intStackSize - 1] = var3 & -1 - (1 << var4);
         return 1;
      } else if(var0 == 4010) {
         class81.intStackSize -= 2;
         var3 = class81.intStack[class81.intStackSize];
         var4 = class81.intStack[class81.intStackSize + 1];
         class81.intStack[++class81.intStackSize - 1] = (var3 & 1 << var4) != 0?1:0;
         return 1;
      } else if(var0 == 4011) {
         class81.intStackSize -= 2;
         var3 = class81.intStack[class81.intStackSize];
         var4 = class81.intStack[class81.intStackSize + 1];
         class81.intStack[++class81.intStackSize - 1] = var3 % var4;
         return 1;
      } else if(var0 == 4012) {
         class81.intStackSize -= 2;
         var3 = class81.intStack[class81.intStackSize];
         var4 = class81.intStack[class81.intStackSize + 1];
         if(var3 == 0) {
            class81.intStack[++class81.intStackSize - 1] = 0;
         } else {
            class81.intStack[++class81.intStackSize - 1] = (int)Math.pow((double)var3, (double)var4);
         }

         return 1;
      } else if(var0 == 4013) {
         class81.intStackSize -= 2;
         var3 = class81.intStack[class81.intStackSize];
         var4 = class81.intStack[class81.intStackSize + 1];
         if(var3 == 0) {
            class81.intStack[++class81.intStackSize - 1] = 0;
            return 1;
         } else {
            switch(var4) {
            case 0:
               class81.intStack[++class81.intStackSize - 1] = Integer.MAX_VALUE;
               break;
            case 1:
               class81.intStack[++class81.intStackSize - 1] = var3;
               break;
            case 2:
               class81.intStack[++class81.intStackSize - 1] = (int)Math.sqrt((double)var3);
               break;
            case 3:
               class81.intStack[++class81.intStackSize - 1] = (int)Math.cbrt((double)var3);
               break;
            case 4:
               class81.intStack[++class81.intStackSize - 1] = (int)Math.sqrt(Math.sqrt((double)var3));
               break;
            default:
               class81.intStack[++class81.intStackSize - 1] = (int)Math.pow((double)var3, 1.0D / (double)var4);
            }

            return 1;
         }
      } else if(var0 == 4014) {
         class81.intStackSize -= 2;
         var3 = class81.intStack[class81.intStackSize];
         var4 = class81.intStack[class81.intStackSize + 1];
         class81.intStack[++class81.intStackSize - 1] = var3 & var4;
         return 1;
      } else if(var0 == 4015) {
         class81.intStackSize -= 2;
         var3 = class81.intStack[class81.intStackSize];
         var4 = class81.intStack[class81.intStackSize + 1];
         class81.intStack[++class81.intStackSize - 1] = var3 | var4;
         return 1;
      } else if(var0 == 4018) {
         class81.intStackSize -= 3;
         long var9 = (long)class81.intStack[class81.intStackSize];
         long var11 = (long)class81.intStack[class81.intStackSize + 1];
         long var13 = (long)class81.intStack[class81.intStackSize + 2];
         class81.intStack[++class81.intStackSize - 1] = (int)(var13 * var9 / var11);
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "([BIILem;[Lfq;I)V",
      garbageValue = "-747063927"
   )
   static final void method2466(byte[] var0, int var1, int var2, Region var3, CollisionData[] var4) {
      Buffer var5 = new Buffer(var0);
      int var6 = -1;

      while(true) {
         int var7 = var5.getUSmart();
         if(var7 == 0) {
            return;
         }

         var6 += var7;
         int var8 = 0;

         while(true) {
            int var9 = var5.getUSmart();
            if(var9 == 0) {
               break;
            }

            var8 += var9 - 1;
            int var10 = var8 & 63;
            int var11 = var8 >> 6 & 63;
            int var12 = var8 >> 12;
            int var13 = var5.readUnsignedByte();
            int var14 = var13 >> 2;
            int var15 = var13 & 3;
            int var16 = var11 + var1;
            int var17 = var10 + var2;
            if(var16 > 0 && var17 > 0 && var16 < 103 && var17 < 103) {
               int var18 = var12;
               if((class61.tileSettings[1][var16][var17] & 2) == 2) {
                  var18 = var12 - 1;
               }

               CollisionData var19 = null;
               if(var18 >= 0) {
                  var19 = var4[var18];
               }

               World.addObject(var12, var16, var17, var6, var15, var14, var3, var19);
            }
         }
      }
   }
}
