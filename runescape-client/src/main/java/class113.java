import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dp")
public class class113 {
   @ObfuscatedName("fj")
   @ObfuscatedSignature(
      signature = "[Lkn;"
   )
   @Export("hitmarks")
   static SpritePixels[] hitmarks;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   @Export("sfx_index")
   IndexDataBase sfx_index;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   @Export("vorbis_index")
   IndexDataBase vorbis_index;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lgk;"
   )
   XHashTable field1651;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lgk;"
   )
   XHashTable field1655;

   @ObfuscatedSignature(
      signature = "(Lit;Lit;)V"
   )
   public class113(IndexDataBase var1, IndexDataBase var2) {
      this.field1655 = new XHashTable(256);
      this.field1651 = new XHashTable(256);
      this.sfx_index = var1;
      this.vorbis_index = var2;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II[IB)Ldb;",
      garbageValue = "28"
   )
   class108 method2107(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4;
      class108 var7 = (class108)this.field1651.get(var5);
      if(var7 != null) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         SoundEffect var8 = SoundEffect.getTrack(this.sfx_index, var1, var2);
         if(var8 == null) {
            return null;
         } else {
            var7 = var8.method1964();
            this.field1651.put(var7, var5);
            if(var3 != null) {
               var3[0] -= var7.field1600.length;
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II[IB)Ldb;",
      garbageValue = "-128"
   )
   class108 method2108(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4 ^ 4294967296L;
      class108 var7 = (class108)this.field1651.get(var5);
      if(var7 != null) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         class107 var8 = (class107)this.field1655.get(var5);
         if(var8 == null) {
            var8 = class107.method1982(this.vorbis_index, var1, var2);
            if(var8 == null) {
               return null;
            }

            this.field1655.put(var8, var5);
         }

         var7 = var8.method2004(var3);
         if(var7 == null) {
            return null;
         } else {
            var8.unlink();
            this.field1651.put(var7, var5);
            return var7;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I[II)Ldb;",
      garbageValue = "1953679620"
   )
   public class108 method2109(int var1, int[] var2) {
      if(this.sfx_index.size() == 1) {
         return this.method2107(0, var1, var2);
      } else if(this.sfx_index.fileCount(var1) == 1) {
         return this.method2107(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I[IB)Ldb;",
      garbageValue = "115"
   )
   public class108 method2112(int var1, int[] var2) {
      if(this.vorbis_index.size() == 1) {
         return this.method2108(0, var1, var2);
      } else if(this.vorbis_index.fileCount(var1) == 1) {
         return this.method2108(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("gz")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-122808591"
   )
   static final void method2110(int var0, int var1, int var2) {
      if(var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
         int var3 = Friend.getTileHeight(var0, var1, class29.plane) - var2;
         var0 -= class273.cameraX;
         var3 -= PendingSpawn.cameraZ;
         var1 -= GZipDecompressor.cameraY;
         int var4 = Graphics3D.SINE[class250.cameraPitch];
         int var5 = Graphics3D.COSINE[class250.cameraPitch];
         int var6 = Graphics3D.SINE[Player.cameraYaw];
         int var7 = Graphics3D.COSINE[Player.cameraYaw];
         int var8 = var6 * var1 + var0 * var7 >> 16;
         var1 = var7 * var1 - var0 * var6 >> 16;
         var0 = var8;
         var8 = var3 * var5 - var4 * var1 >> 16;
         var1 = var5 * var1 + var3 * var4 >> 16;
         if(var1 >= 50) {
            Client.screenY = var0 * Client.scale / var1 + Client.viewportHeight / 2;
            Client.screenX = Client.viewportWidth / 2 + var8 * Client.scale / var1;
         } else {
            Client.screenY = -1;
            Client.screenX = -1;
         }

      } else {
         Client.screenY = -1;
         Client.screenX = -1;
      }
   }
}
