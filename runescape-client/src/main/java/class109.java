import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("de")
public class class109 {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   @Export("sfx_index")
   IndexDataBase sfx_index;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   @Export("vorbis_index")
   IndexDataBase vorbis_index;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   HashTable field1552;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   HashTable field1551;

   @ObfuscatedSignature(
      signature = "(Lik;Lik;)V"
   )
   public class109(IndexDataBase var1, IndexDataBase var2) {
      this.field1552 = new HashTable(256);
      this.field1551 = new HashTable(256);
      this.sfx_index = var1;
      this.vorbis_index = var2;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II[II)Ldp;",
      garbageValue = "1993161755"
   )
   RawAudioNode method2245(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & 65535 | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4;
      RawAudioNode var7 = (RawAudioNode)this.field1551.get(var5);
      if(var7 != null) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         SoundEffect var8 = SoundEffect.getTrack(this.sfx_index, var1, var2);
         if(var8 == null) {
            return null;
         } else {
            var7 = var8.method2109();
            this.field1551.put(var7, var5);
            if(var3 != null) {
               var3[0] -= var7.audioBuffer.length;
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II[II)Ldp;",
      garbageValue = "-1513574709"
   )
   RawAudioNode method2248(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & 65535 | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4 ^ 4294967296L;
      RawAudioNode var7 = (RawAudioNode)this.field1551.get(var5);
      if(var7 != null) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         class103 var8 = (class103)this.field1552.get(var5);
         if(var8 == null) {
            var8 = class103.getInstrument(this.vorbis_index, var1, var2);
            if(var8 == null) {
               return null;
            }

            this.field1552.put(var8, var5);
         }

         var7 = var8.method2113(var3);
         if(var7 == null) {
            return null;
         } else {
            var8.unlink();
            this.field1551.put(var7, var5);
            return var7;
         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I[II)Ldp;",
      garbageValue = "-2145444568"
   )
   public RawAudioNode method2246(int var1, int[] var2) {
      if(this.sfx_index.size() == 1) {
         return this.method2245(0, var1, var2);
      } else if(this.sfx_index.fileCount(var1) == 1) {
         return this.method2245(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I[II)Ldp;",
      garbageValue = "-1431375950"
   )
   public RawAudioNode method2247(int var1, int[] var2) {
      if(this.vorbis_index.size() == 1) {
         return this.method2248(0, var1, var2);
      } else if(this.vorbis_index.fileCount(var1) == 1) {
         return this.method2248(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)[Lkx;",
      garbageValue = "1828456575"
   )
   static class301[] method2244() {
      return new class301[]{class301.field3831, class301.field3832, class301.field3830};
   }
}
