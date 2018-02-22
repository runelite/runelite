import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("do")
public class class109 {
   @ObfuscatedName("cs")
   @ObfuscatedSignature(
      signature = "Lia;"
   )
   @Export("configsIndex")
   static IndexData configsIndex;
   @ObfuscatedName("hs")
   @ObfuscatedSignature(
      signature = "Lim;"
   )
   static Widget field1552;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lie;"
   )
   @Export("sfx_index")
   IndexDataBase sfx_index;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lie;"
   )
   @Export("vorbis_index")
   IndexDataBase vorbis_index;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lhk;"
   )
   HashTable field1546;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lhk;"
   )
   HashTable field1549;

   @ObfuscatedSignature(
      signature = "(Lie;Lie;)V"
   )
   public class109(IndexDataBase var1, IndexDataBase var2) {
      this.field1546 = new HashTable(256);
      this.field1549 = new HashTable(256);
      this.sfx_index = var1;
      this.vorbis_index = var2;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II[IB)Ldb;",
      garbageValue = "-3"
   )
   RawAudioNode method2275(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & 65535 | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4;
      RawAudioNode var7 = (RawAudioNode)this.field1549.get(var5);
      if(var7 != null) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         SoundEffect var8 = SoundEffect.getTrack(this.sfx_index, var1, var2);
         if(var8 == null) {
            return null;
         } else {
            var7 = var8.method2124();
            this.field1549.put(var7, var5);
            if(var3 != null) {
               var3[0] -= var7.audioBuffer.length;
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II[II)Ldb;",
      garbageValue = "-806142676"
   )
   RawAudioNode method2280(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & 65535 | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4 ^ 4294967296L;
      RawAudioNode var7 = (RawAudioNode)this.field1549.get(var5);
      if(var7 != null) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         class103 var8 = (class103)this.field1546.get(var5);
         if(var8 == null) {
            var8 = class103.getInstrument(this.vorbis_index, var1, var2);
            if(var8 == null) {
               return null;
            }

            this.field1546.put(var8, var5);
         }

         var7 = var8.method2147(var3);
         if(var7 == null) {
            return null;
         } else {
            var8.unlink();
            this.field1549.put(var7, var5);
            return var7;
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I[II)Ldb;",
      garbageValue = "461302655"
   )
   public RawAudioNode method2277(int var1, int[] var2) {
      if(this.sfx_index.size() == 1) {
         return this.method2275(0, var1, var2);
      } else if(this.sfx_index.fileCount(var1) == 1) {
         return this.method2275(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I[II)Ldb;",
      garbageValue = "-557698097"
   )
   public RawAudioNode method2278(int var1, int[] var2) {
      if(this.vorbis_index.size() == 1) {
         return this.method2280(0, var1, var2);
      } else if(this.vorbis_index.fileCount(var1) == 1) {
         return this.method2280(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lie;II)Llv;",
      garbageValue = "-67656368"
   )
   public static IndexedSprite method2274(IndexDataBase var0, int var1) {
      return !Occluder.method3068(var0, var1)?null:NameableContainer.method5288();
   }
}
