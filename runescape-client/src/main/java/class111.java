import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dh")
public class class111 {
   @ObfuscatedName("fv")
   @ObfuscatedSignature(
      signature = "[Lki;"
   )
   @Export("headIconsHint")
   static SpritePixels[] headIconsHint;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   @Export("sfx_index")
   IndexDataBase sfx_index;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   @Export("vorbis_index")
   IndexDataBase vorbis_index;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   HashTable field1581;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   HashTable field1582;

   @ObfuscatedSignature(
      signature = "(Lir;Lir;)V"
   )
   public class111(IndexDataBase var1, IndexDataBase var2) {
      this.field1581 = new HashTable(256);
      this.field1582 = new HashTable(256);
      this.sfx_index = var1;
      this.vorbis_index = var2;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II[II)Ldz;",
      garbageValue = "1481203449"
   )
   RawAudioNode method2334(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & 65535 | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4;
      RawAudioNode var7 = (RawAudioNode)this.field1582.get(var5);
      if(var7 != null) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         SoundEffect var8 = SoundEffect.getTrack(this.sfx_index, var1, var2);
         if(var8 == null) {
            return null;
         } else {
            var7 = var8.method2181();
            this.field1582.put(var7, var5);
            if(var3 != null) {
               var3[0] -= var7.audioBuffer.length;
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II[II)Ldz;",
      garbageValue = "-1718728892"
   )
   RawAudioNode method2335(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & 65535 | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4 ^ 4294967296L;
      RawAudioNode var7 = (RawAudioNode)this.field1582.get(var5);
      if(var7 != null) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         class105 var8 = (class105)this.field1581.get(var5);
         if(var8 == null) {
            var8 = class105.getInstrument(this.vorbis_index, var1, var2);
            if(var8 == null) {
               return null;
            }

            this.field1581.put(var8, var5);
         }

         var7 = var8.method2204(var3);
         if(var7 == null) {
            return null;
         } else {
            var8.unlink();
            this.field1582.put(var7, var5);
            return var7;
         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I[II)Ldz;",
      garbageValue = "1473729449"
   )
   public RawAudioNode method2336(int var1, int[] var2) {
      if(this.sfx_index.size() == 1) {
         return this.method2334(0, var1, var2);
      } else if(this.sfx_index.fileCount(var1) == 1) {
         return this.method2334(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I[II)Ldz;",
      garbageValue = "-839062302"
   )
   public RawAudioNode method2346(int var1, int[] var2) {
      if(this.vorbis_index.size() == 1) {
         return this.method2335(0, var1, var2);
      } else if(this.vorbis_index.fileCount(var1) == 1) {
         return this.method2335(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIIIIII)I",
      garbageValue = "597996011"
   )
   public static int method2349(int var0, int var1, int var2, int var3, int var4, int var5) {
      if((var5 & 1) == 1) {
         int var6 = var3;
         var3 = var4;
         var4 = var6;
      }

      var2 &= 3;
      return var2 == 0?var0:(var2 == 1?var1:(var2 == 2?7 - var0 - (var3 - 1):7 - var1 - (var4 - 1)));
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1797542172"
   )
   public static void method2337(int var0) {
      if(class214.field2617 != 0) {
         IndexFile.field2192 = var0;
      } else {
         class25.field356.method4133(var0);
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1270031455"
   )
   public static void method2350(int var0) {
      MouseInput.mouseIdleTicks = var0;
   }

   @ObfuscatedName("gf")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "-104"
   )
   @Export("worldToScreen")
   static final void worldToScreen(int var0, int var1, int var2) {
      if(var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
         int var3 = MessageNode.getTileHeight(var0, var1, class60.plane) - var2;
         var0 -= class89.cameraX;
         var3 -= class216.cameraZ;
         var1 -= class3.cameraY;
         int var4 = Graphics3D.SINE[ScriptEvent.cameraPitch];
         int var5 = Graphics3D.COSINE[ScriptEvent.cameraPitch];
         int var6 = Graphics3D.SINE[class80.cameraYaw];
         int var7 = Graphics3D.COSINE[class80.cameraYaw];
         int var8 = var6 * var1 + var0 * var7 >> 16;
         var1 = var7 * var1 - var0 * var6 >> 16;
         var0 = var8;
         var8 = var5 * var3 - var4 * var1 >> 16;
         var1 = var5 * var1 + var3 * var4 >> 16;
         if(var1 >= 50) {
            Client.screenX = var0 * Client.scale / var1 + Client.viewportWidth / 2;
            Client.screenY = var8 * Client.scale / var1 + Client.viewportHeight / 2;
         } else {
            Client.screenX = -1;
            Client.screenY = -1;
         }

      } else {
         Client.screenX = -1;
         Client.screenY = -1;
      }
   }
}
