import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dx")
@Implements("FileOnDisk")
public final class FileOnDisk {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 702214533
   )
   static int field1730;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      longValue = -8838535059392606211L
   )
   @Export("position")
   long position;
   @ObfuscatedName("c")
   @Export("file")
   RandomAccessFile file;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      longValue = 3002344540474477281L
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

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)J",
      garbageValue = "1"
   )
   @Export("length")
   public final long length() throws IOException {
      return this.file.length();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1107471226"
   )
   @Export("close")
   public final void close() throws IOException {
      if(this.file != null) {
         this.file.close();
         this.file = null;
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "210606768"
   )
   @Export("read")
   public final int read(byte[] var1, int var2, int var3) throws IOException {
      int var4 = this.file.read(var1, var2, var3);
      if(var4 > 0) {
         this.position += (long)var4;
      }

      return var4;
   }

   @ObfuscatedName("c")
   @Export("seek")
   final void seek(long var1) throws IOException {
      this.file.seek(var1);
      this.position = var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "829435026"
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

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "([BB)[B",
      garbageValue = "102"
   )
   @Export("decodeContainer")
   static final byte[] decodeContainer(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      int var2 = var1.readUnsignedByte();
      int var3 = var1.readInt();
      if(var3 < 0 || IndexDataBase.field3198 != 0 && var3 > IndexDataBase.field3198) {
         throw new RuntimeException();
      } else if(var2 == 0) {
         byte[] var4 = new byte[var3];
         var1.readBytes(var4, 0, var3);
         return var4;
      } else {
         int var6 = var1.readInt();
         if(var6 < 0 || IndexDataBase.field3198 != 0 && var6 > IndexDataBase.field3198) {
            throw new RuntimeException();
         } else {
            byte[] var5 = new byte[var6];
            if(var2 == 1) {
               class167.method3027(var5, var6, var0, var3, 9);
            } else {
               IndexDataBase.gzip.decompress(var1, var5);
            }

            return var5;
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "1403112964"
   )
   @Export("addChatMessage")
   @Hook("addChatMessage")
   static void addChatMessage(int var0, String var1, String var2, String var3) {
      ChatLineBuffer var4 = (ChatLineBuffer)class98.chatLineMap.get(Integer.valueOf(var0));
      if(var4 == null) {
         var4 = new ChatLineBuffer();
         class98.chatLineMap.put(Integer.valueOf(var0), var4);
      }

      MessageNode var5 = var4.addMessage(var0, var1, var2, var3);
      class98.field1495.put(var5, (long)var5.id);
      class98.field1493.method3616(var5);
      Client.chatCycle = Client.cycleCntr;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIIIIZI)Ljj;",
      garbageValue = "524257191"
   )
   @Export("createSprite")
   public static final SpritePixels createSprite(int var0, int var1, int var2, int var3, int var4, boolean var5) {
      if(var1 == -1) {
         var4 = 0;
      } else if(var4 == 2 && var1 != 1) {
         var4 = 1;
      }

      long var6 = ((long)var4 << 40) + ((long)var2 << 38) + ((long)var1 << 16) + (long)var0 + ((long)var3 << 42);
      SpritePixels var8;
      if(!var5) {
         var8 = (SpritePixels)ItemComposition.itemSpriteCache.get(var6);
         if(var8 != null) {
            return var8;
         }
      }

      ItemComposition var9 = class10.getItemDefinition(var0);
      if(var1 > 1 && var9.countObj != null) {
         int var10 = -1;

         for(int var11 = 0; var11 < 10; ++var11) {
            if(var1 >= var9.countCo[var11] && var9.countCo[var11] != 0) {
               var10 = var9.countObj[var11];
            }
         }

         if(var10 != -1) {
            var9 = class10.getItemDefinition(var10);
         }
      }

      Model var21 = var9.getModel(1);
      if(var21 == null) {
         return null;
      } else {
         SpritePixels var22 = null;
         if(var9.notedTemplate != -1) {
            var22 = createSprite(var9.note, 10, 1, 0, 0, true);
            if(var22 == null) {
               return null;
            }
         } else if(var9.notedId != -1) {
            var22 = createSprite(var9.unnotedId, var1, var2, var3, 0, false);
            if(var22 == null) {
               return null;
            }
         } else if(var9.field3492 != -1) {
            var22 = createSprite(var9.field3516, var1, 0, 0, 0, false);
            if(var22 == null) {
               return null;
            }
         }

         int[] var12 = Rasterizer2D.graphicsPixels;
         int var13 = Rasterizer2D.graphicsPixelsWidth;
         int var14 = Rasterizer2D.graphicsPixelsHeight;
         int[] var15 = new int[4];
         Rasterizer2D.copyDrawRegion(var15);
         var8 = new SpritePixels(36, 32);
         Rasterizer2D.setRasterBuffer(var8.image, 36, 32);
         Rasterizer2D.reset();
         Graphics3D.method2524();
         Graphics3D.method2602(16, 16);
         Graphics3D.rasterGouraudLowRes = false;
         if(var9.field3492 != -1) {
            var22.method4958(0, 0);
         }

         int var16 = var9.zoom2d;
         if(var5) {
            var16 = (int)(1.5D * (double)var16);
         } else if(var2 == 2) {
            var16 = (int)((double)var16 * 1.04D);
         }

         int var17 = var16 * Graphics3D.SINE[var9.xan2d] >> 16;
         int var18 = var16 * Graphics3D.COSINE[var9.xan2d] >> 16;
         var21.method2433();
         var21.method2476(0, var9.yan2d, var9.zan2d, var9.xan2d, var9.offsetX2d, var17 + var21.modelHeight / 2 + var9.offsetY2d, var18 + var9.offsetY2d);
         if(var9.notedId != -1) {
            var22.method4958(0, 0);
         }

         if(var2 >= 1) {
            var8.method5011(1);
         }

         if(var2 >= 2) {
            var8.method5011(16777215);
         }

         if(var3 != 0) {
            var8.method4955(var3);
         }

         Rasterizer2D.setRasterBuffer(var8.image, 36, 32);
         if(var9.notedTemplate != -1) {
            var22.method4958(0, 0);
         }

         if(var4 == 1 || var4 == 2 && var9.isStackable == 1) {
            Font var19 = WorldMapType2.field523;
            String var20;
            if(var1 < 100000) {
               var20 = "<col=ffff00>" + var1 + "</col>";
            } else if(var1 < 10000000) {
               var20 = "<col=ffffff>" + var1 / 1000 + "K" + "</col>";
            } else {
               var20 = "<col=00ff80>" + var1 / 1000000 + "M" + "</col>";
            }

            var19.method4640(var20, 0, 9, 16776960, 1);
         }

         if(!var5) {
            ItemComposition.itemSpriteCache.put(var8, var6);
         }

         Rasterizer2D.setRasterBuffer(var12, var13, var14);
         Rasterizer2D.setDrawRegion(var15);
         Graphics3D.method2524();
         Graphics3D.rasterGouraudLowRes = true;
         return var8;
      }
   }
}
