import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dc")
public class class110 {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 708364975
   )
   static int field1591;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Ljk;"
   )
   @Export("sfx_index")
   IndexDataBase sfx_index;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Ljk;"
   )
   @Export("vorbis_index")
   IndexDataBase vorbis_index;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lhe;"
   )
   HashTable field1592;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lhe;"
   )
   HashTable field1590;

   @ObfuscatedSignature(
      signature = "(Ljk;Ljk;)V"
   )
   public class110(IndexDataBase var1, IndexDataBase var2) {
      this.field1592 = new HashTable(256);
      this.field1590 = new HashTable(256);
      this.sfx_index = var1;
      this.vorbis_index = var2;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II[II)Ldd;",
      garbageValue = "-1079748908"
   )
   RawAudioNode method2321(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & 65535 | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4;
      RawAudioNode var7 = (RawAudioNode)this.field1590.get(var5);
      if(var7 != null) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         SoundEffect var8 = SoundEffect.getTrack(this.sfx_index, var1, var2);
         if(var8 == null) {
            return null;
         } else {
            var7 = var8.method2168();
            this.field1590.put(var7, var5);
            if(var3 != null) {
               var3[0] -= var7.audioBuffer.length;
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II[II)Ldd;",
      garbageValue = "2032840627"
   )
   RawAudioNode method2323(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & 65535 | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4 ^ 4294967296L;
      RawAudioNode var7 = (RawAudioNode)this.field1590.get(var5);
      if(var7 != null) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         class104 var8 = (class104)this.field1592.get(var5);
         if(var8 == null) {
            var8 = class104.getInstrument(this.vorbis_index, var1, var2);
            if(var8 == null) {
               return null;
            }

            this.field1592.put(var8, var5);
         }

         var7 = var8.method2191(var3);
         if(var7 == null) {
            return null;
         } else {
            var8.unlink();
            this.field1590.put(var7, var5);
            return var7;
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I[II)Ldd;",
      garbageValue = "-128447668"
   )
   public RawAudioNode method2329(int var1, int[] var2) {
      if(this.sfx_index.size() == 1) {
         return this.method2321(0, var1, var2);
      } else if(this.sfx_index.fileCount(var1) == 1) {
         return this.method2321(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I[II)Ldd;",
      garbageValue = "-1026147198"
   )
   public RawAudioNode method2327(int var1, int[] var2) {
      if(this.vorbis_index.size() == 1) {
         return this.method2323(0, var1, var2);
      } else if(this.vorbis_index.fileCount(var1) == 1) {
         return this.method2323(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }
}
