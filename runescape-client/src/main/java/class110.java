import java.io.File;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dc")
public class class110 {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Ljr;"
   )
   @Export("sfx_index")
   IndexDataBase sfx_index;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Ljr;"
   )
   @Export("vorbis_index")
   IndexDataBase vorbis_index;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lhu;"
   )
   HashTable field1574;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lhu;"
   )
   HashTable field1573;

   @ObfuscatedSignature(
      signature = "(Ljr;Ljr;)V"
   )
   public class110(IndexDataBase var1, IndexDataBase var2) {
      this.field1574 = new HashTable(256);
      this.field1573 = new HashTable(256);
      this.sfx_index = var1;
      this.vorbis_index = var2;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II[II)Ldt;",
      garbageValue = "1844170907"
   )
   RawAudioNode method2363(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & 65535 | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4;
      RawAudioNode var7 = (RawAudioNode)this.field1573.get(var5);
      if(var7 != null) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         SoundEffect var8 = SoundEffect.getTrack(this.sfx_index, var1, var2);
         if(var8 == null) {
            return null;
         } else {
            var7 = var8.method2231();
            this.field1573.put(var7, var5);
            if(var3 != null) {
               var3[0] -= var7.audioBuffer.length;
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II[IS)Ldt;",
      garbageValue = "-503"
   )
   RawAudioNode method2364(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & 65535 | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4 ^ 4294967296L;
      RawAudioNode var7 = (RawAudioNode)this.field1573.get(var5);
      if(var7 != null) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         class104 var8 = (class104)this.field1574.get(var5);
         if(var8 == null) {
            var8 = class104.getInstrument(this.vorbis_index, var1, var2);
            if(var8 == null) {
               return null;
            }

            this.field1574.put(var8, var5);
         }

         var7 = var8.method2250(var3);
         if(var7 == null) {
            return null;
         } else {
            var8.unlink();
            this.field1573.put(var7, var5);
            return var7;
         }
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I[IB)Ldt;",
      garbageValue = "3"
   )
   public RawAudioNode method2365(int var1, int[] var2) {
      if(this.sfx_index.size() == 1) {
         return this.method2363(0, var1, var2);
      } else if(this.sfx_index.fileCount(var1) == 1) {
         return this.method2363(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I[II)Ldt;",
      garbageValue = "-1223718748"
   )
   public RawAudioNode method2366(int var1, int[] var2) {
      if(this.vorbis_index.size() == 1) {
         return this.method2364(0, var1, var2);
      } else if(this.vorbis_index.fileCount(var1) == 1) {
         return this.method2364(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;I)V",
      garbageValue = "271886784"
   )
   public static void method2375(File var0) {
      class170.field2210 = var0;
      if(!class170.field2210.exists()) {
         throw new RuntimeException("");
      } else {
         class170.field2209 = true;
      }
   }
}
