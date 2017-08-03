import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cn")
@Implements("FileOnDisk")
public final class FileOnDisk {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lim;"
   )
   public static IndexDataBase field1544;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      longValue = 6029850626035004263L
   )
   @Export("position")
   long position;
   @ObfuscatedName("d")
   @Export("file")
   RandomAccessFile file;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      longValue = 1327944110921867863L
   )
   @Export("length")
   long length;

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

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "-1294255984"
   )
   @Export("length")
   public final long length() throws IOException {
      return this.file.length();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-80"
   )
   @Export("close")
   public final void close() throws IOException {
      if(this.file != null) {
         this.file.close();
         this.file = null;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "948351038"
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

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "([BIIS)V",
      garbageValue = "6618"
   )
   @Export("write")
   public final void write(byte[] var1, int var2, int var3) throws IOException {
      if(this.position + (long)var3 > this.length) {
         this.file.seek(this.length + 1L);
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

   @ObfuscatedName("gi")
   @ObfuscatedSignature(
      signature = "(Lcj;I)V",
      garbageValue = "1555091999"
   )
   static final void method1934(Actor var0) {
      var0.poseAnimation = var0.idlePoseAnimation;
      if(var0.queueSize == 0) {
         var0.field1247 = 0;
      } else {
         if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
            Sequence var1 = class40.getAnimation(var0.animation);
            if(var0.field1248 > 0 && var1.precedenceAnimating == 0) {
               ++var0.field1247;
               return;
            }

            if(var0.field1248 <= 0 && var1.priority == 0) {
               ++var0.field1247;
               return;
            }
         }

         int var10 = var0.x;
         int var2 = var0.y;
         int var3 = var0.field1216 * 64 + var0.pathX[var0.queueSize - 1] * 128;
         int var4 = var0.pathY[var0.queueSize - 1] * 128 + var0.field1216 * 64;
         if(var10 < var3) {
            if(var2 < var4) {
               var0.orientation = 1280;
            } else if(var2 > var4) {
               var0.orientation = 1792;
            } else {
               var0.orientation = 1536;
            }
         } else if(var10 > var3) {
            if(var2 < var4) {
               var0.orientation = 768;
            } else if(var2 > var4) {
               var0.orientation = 256;
            } else {
               var0.orientation = 512;
            }
         } else if(var2 < var4) {
            var0.orientation = 1024;
         } else if(var2 > var4) {
            var0.orientation = 0;
         }

         byte var5 = var0.field1246[var0.queueSize - 1];
         if(var3 - var10 <= 256 && var3 - var10 >= -256 && var4 - var2 <= 256 && var4 - var2 >= -256) {
            int var6 = var0.orientation - var0.angle & 2047;
            if(var6 > 1024) {
               var6 -= 2048;
            }

            int var7 = var0.field1205;
            if(var6 >= -256 && var6 <= 256) {
               var7 = var0.field1197;
            } else if(var6 >= 256 && var6 < 768) {
               var7 = var0.field1200;
            } else if(var6 >= -768 && var6 <= -256) {
               var7 = var0.field1249;
            }

            if(var7 == -1) {
               var7 = var0.field1197;
            }

            var0.poseAnimation = var7;
            int var8 = 4;
            boolean var9 = true;
            if(var0 instanceof NPC) {
               var9 = ((NPC)var0).composition.isClickable;
            }

            if(var9) {
               if(var0.angle != var0.orientation && var0.interacting == -1 && var0.field1242 != 0) {
                  var8 = 2;
               }

               if(var0.queueSize > 2) {
                  var8 = 6;
               }

               if(var0.queueSize > 3) {
                  var8 = 8;
               }

               if(var0.field1247 > 0 && var0.queueSize > 1) {
                  var8 = 8;
                  --var0.field1247;
               }
            } else {
               if(var0.queueSize > 1) {
                  var8 = 6;
               }

               if(var0.queueSize > 2) {
                  var8 = 8;
               }

               if(var0.field1247 > 0 && var0.queueSize > 1) {
                  var8 = 8;
                  --var0.field1247;
               }
            }

            if(var5 == 2) {
               var8 <<= 1;
            }

            if(var8 >= 8 && var0.field1197 == var0.poseAnimation && var0.field1217 != -1) {
               var0.poseAnimation = var0.field1217;
            }

            if(var3 != var10 || var2 != var4) {
               if(var10 < var3) {
                  var0.x += var8;
                  if(var0.x > var3) {
                     var0.x = var3;
                  }
               } else if(var10 > var3) {
                  var0.x -= var8;
                  if(var0.x < var3) {
                     var0.x = var3;
                  }
               }

               if(var2 < var4) {
                  var0.y += var8;
                  if(var0.y > var4) {
                     var0.y = var4;
                  }
               } else if(var2 > var4) {
                  var0.y -= var8;
                  if(var0.y < var4) {
                     var0.y = var4;
                  }
               }
            }

            if(var3 == var0.x && var4 == var0.y) {
               --var0.queueSize;
               if(var0.field1248 > 0) {
                  --var0.field1248;
               }
            }

         } else {
            var0.x = var3;
            var0.y = var4;
            --var0.queueSize;
            if(var0.field1248 > 0) {
               --var0.field1248;
            }

         }
      }
   }

   @ObfuscatedName("jj")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;I)[Ljava/lang/String;",
      garbageValue = "1415040013"
   )
   static final String[] method1920(String[] var0) {
      String[] var1 = new String[5];

      for(int var2 = 0; var2 < 5; ++var2) {
         var1[var2] = var2 + ": ";
         if(var0 != null && var0[var2] != null) {
            var1[var2] = var1[var2] + var0[var2];
         }
      }

      return var1;
   }
}
