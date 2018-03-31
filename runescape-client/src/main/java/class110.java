import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dl")
public class class110 {
   @ObfuscatedName("py")
   @ObfuscatedGetter(
      intValue = -1053248559
   )
   static int field1590;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Ljm;"
   )
   @Export("sfx_index")
   IndexDataBase sfx_index;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Ljm;"
   )
   @Export("vorbis_index")
   IndexDataBase vorbis_index;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lhy;"
   )
   HashTable field1587;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lhy;"
   )
   HashTable field1588;

   @ObfuscatedSignature(
      signature = "(Ljm;Ljm;)V"
   )
   public class110(IndexDataBase var1, IndexDataBase var2) {
      this.field1587 = new HashTable(256);
      this.field1588 = new HashTable(256);
      this.sfx_index = var1;
      this.vorbis_index = var2;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II[II)Lda;",
      garbageValue = "-2086664220"
   )
   RawAudioNode method2261(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & 65535 | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4;
      RawAudioNode var7 = (RawAudioNode)this.field1588.get(var5);
      if(var7 != null) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         SoundEffect var8 = SoundEffect.getTrack(this.sfx_index, var1, var2);
         if(var8 == null) {
            return null;
         } else {
            var7 = var8.method2115();
            this.field1588.put(var7, var5);
            if(var3 != null) {
               var3[0] -= var7.audioBuffer.length;
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II[II)Lda;",
      garbageValue = "-452702840"
   )
   RawAudioNode method2263(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & 65535 | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4 ^ 4294967296L;
      RawAudioNode var7 = (RawAudioNode)this.field1588.get(var5);
      if(var7 != null) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         class104 var8 = (class104)this.field1587.get(var5);
         if(var8 == null) {
            var8 = class104.getInstrument(this.vorbis_index, var1, var2);
            if(var8 == null) {
               return null;
            }

            this.field1587.put(var8, var5);
         }

         var7 = var8.method2152(var3);
         if(var7 == null) {
            return null;
         } else {
            var8.unlink();
            this.field1588.put(var7, var5);
            return var7;
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I[II)Lda;",
      garbageValue = "-290857524"
   )
   public RawAudioNode method2264(int var1, int[] var2) {
      if(this.sfx_index.size() == 1) {
         return this.method2261(0, var1, var2);
      } else if(this.sfx_index.fileCount(var1) == 1) {
         return this.method2261(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I[II)Lda;",
      garbageValue = "1479750415"
   )
   public RawAudioNode method2268(int var1, int[] var2) {
      if(this.vorbis_index.size() == 1) {
         return this.method2263(0, var1, var2);
      } else if(this.vorbis_index.fileCount(var1) == 1) {
         return this.method2263(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "541533633"
   )
   public static boolean method2262(int var0) {
      return var0 >= WorldMapDecorationType.field2982.rsOrdinal && var0 <= WorldMapDecorationType.field2976.rsOrdinal || var0 == WorldMapDecorationType.field2977.rsOrdinal;
   }
}
