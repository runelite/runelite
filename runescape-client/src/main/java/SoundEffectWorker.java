import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("de")
@Implements("SoundEffectWorker")
public class SoundEffectWorker {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   @Export("sfx_index")
   IndexDataBase sfx_index;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   @Export("vorbis_index")
   IndexDataBase vorbis_index;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   HashTable field1559;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   HashTable field1558;

   @ObfuscatedSignature(
      signature = "(Lib;Lib;)V"
   )
   public SoundEffectWorker(IndexDataBase var1, IndexDataBase var2) {
      this.field1559 = new HashTable(256);
      this.field1558 = new HashTable(256);
      this.sfx_index = var1;
      this.vorbis_index = var2;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II[IB)Ldx;",
      garbageValue = "58"
   )
   MusicTrack2 method2072(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & 65535 | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4;
      MusicTrack2 var7 = (MusicTrack2)this.field1558.get(var5);
      if(var7 != null) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         SoundEffect var8 = SoundEffect.getTrack(this.sfx_index, var1, var2);
         if(var8 == null) {
            return null;
         } else {
            var7 = var8.method1942();
            this.field1558.put(var7, var5);
            if(var3 != null) {
               var3[0] -= var7.field1509.length;
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II[IB)Ldx;",
      garbageValue = "119"
   )
   MusicTrack2 method2073(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & 65535 | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4 ^ 4294967296L;
      MusicTrack2 var7 = (MusicTrack2)this.field1558.get(var5);
      if(var7 != null) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         SoundStudio var8 = (SoundStudio)this.field1559.get(var5);
         if(var8 == null) {
            var8 = SoundStudio.method1951(this.vorbis_index, var1, var2);
            if(var8 == null) {
               return null;
            }

            this.field1559.put(var8, var5);
         }

         var7 = var8.method1952(var3);
         if(var7 == null) {
            return null;
         } else {
            var8.unlink();
            this.field1558.put(var7, var5);
            return var7;
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I[II)Ldx;",
      garbageValue = "-1120993990"
   )
   public MusicTrack2 method2074(int var1, int[] var2) {
      if(this.sfx_index.size() == 1) {
         return this.method2072(0, var1, var2);
      } else if(this.sfx_index.fileCount(var1) == 1) {
         return this.method2072(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I[II)Ldx;",
      garbageValue = "-144670660"
   )
   public MusicTrack2 method2077(int var1, int[] var2) {
      if(this.vorbis_index.size() == 1) {
         return this.method2073(0, var1, var2);
      } else if(this.vorbis_index.fileCount(var1) == 1) {
         return this.method2073(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IB)[B",
      garbageValue = "29"
   )
   static synchronized byte[] method2088(int var0) {
      return class185.method3505(var0, false);
   }

   @ObfuscatedName("go")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-680699859"
   )
   static final void method2084(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Client.widgetCount; ++var4) {
         if(Client.widgetPositionX[var4] + Client.widgetBoundsWidth[var4] > var0 && Client.widgetPositionX[var4] < var0 + var2 && Client.widgetBoundsHeight[var4] + Client.widgetPositionY[var4] > var1 && Client.widgetPositionY[var4] < var3 + var1) {
            Client.field1019[var4] = true;
         }
      }

   }
}
