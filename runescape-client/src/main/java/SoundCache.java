import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dt")
@Implements("SoundCache")
public class SoundCache {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1784515731
   )
   @Export("canvasWidth")
   public static int canvasWidth;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   @Export("soundEffectIndex")
   AbstractArchive soundEffectIndex;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   @Export("musicSampleIndex")
   AbstractArchive musicSampleIndex;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lld;"
   )
   @Export("musicSamples")
   NodeHashTable musicSamples;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lld;"
   )
   @Export("rawSounds")
   NodeHashTable rawSounds;

   @ObfuscatedSignature(
      signature = "(Lir;Lir;)V"
   )
   public SoundCache(AbstractArchive var1, AbstractArchive var2) {
      this.musicSamples = new NodeHashTable(256);
      this.rawSounds = new NodeHashTable(256);
      this.soundEffectIndex = var1;
      this.musicSampleIndex = var2;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II[IS)Lcx;",
      garbageValue = "17979"
   )
   @Export("getSoundEffect0")
   RawSound getSoundEffect0(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & 65535 | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4;
      RawSound var7 = (RawSound)this.rawSounds.get(var5);
      if (var7 != null) {
         return var7;
      } else if (var3 != null && var3[0] <= 0) {
         return null;
      } else {
         SoundEffect var8 = SoundEffect.readSoundEffect(this.soundEffectIndex, var1, var2);
         if (var8 == null) {
            return null;
         } else {
            var7 = var8.toRawSound();
            this.rawSounds.put(var7, var5);
            if (var3 != null) {
               var3[0] -= var7.samples.length;
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II[II)Lcx;",
      garbageValue = "-847417897"
   )
   @Export("getMusicSample0")
   RawSound getMusicSample0(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & 65535 | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4 ^ 4294967296L;
      RawSound var7 = (RawSound)this.rawSounds.get(var5);
      if (var7 != null) {
         return var7;
      } else if (var3 != null && var3[0] <= 0) {
         return null;
      } else {
         MusicSample var8 = (MusicSample)this.musicSamples.get(var5);
         if (var8 == null) {
            var8 = MusicSample.readMusicSample(this.musicSampleIndex, var1, var2);
            if (var8 == null) {
               return null;
            }

            this.musicSamples.put(var8, var5);
         }

         var7 = var8.toRawSound(var3);
         if (var7 == null) {
            return null;
         } else {
            var8.remove();
            this.rawSounds.put(var7, var5);
            return var7;
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I[IB)Lcx;",
      garbageValue = "-28"
   )
   @Export("getSoundEffect")
   public RawSound getSoundEffect(int var1, int[] var2) {
      if (this.soundEffectIndex.getGroupCount() == 1) {
         return this.getSoundEffect0(0, var1, var2);
      } else if (this.soundEffectIndex.getGroupFileCount(var1) == 1) {
         return this.getSoundEffect0(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I[II)Lcx;",
      garbageValue = "-2131728116"
   )
   @Export("getMusicSample")
   public RawSound getMusicSample(int var1, int[] var2) {
      if (this.musicSampleIndex.getGroupCount() == 1) {
         return this.getMusicSample0(0, var1, var2);
      } else if (this.musicSampleIndex.getGroupFileCount(var1) == 1) {
         return this.getMusicSample0(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;II[BII)I",
      garbageValue = "-1706770105"
   )
   @Export("encodeStringCp1252")
   public static int encodeStringCp1252(CharSequence src, int srcStart, int srcEnd, byte[] dst, int dstStart) {
      int var5 = srcEnd - srcStart;

      for (int var6 = 0; var6 < var5; ++var6) {
         char var7 = src.charAt(var6 + srcStart);
         if ((var7 <= 0 || var7 >= 128) && (var7 < 160 || var7 > 255)) {
            if (var7 == 8364) {
               dst[var6 + dstStart] = -128;
            } else if (var7 == 8218) {
               dst[var6 + dstStart] = -126;
            } else if (var7 == 402) {
               dst[var6 + dstStart] = -125;
            } else if (var7 == 8222) {
               dst[var6 + dstStart] = -124;
            } else if (var7 == 8230) {
               dst[var6 + dstStart] = -123;
            } else if (var7 == 8224) {
               dst[var6 + dstStart] = -122;
            } else if (var7 == 8225) {
               dst[var6 + dstStart] = -121;
            } else if (var7 == 710) {
               dst[var6 + dstStart] = -120;
            } else if (var7 == 8240) {
               dst[var6 + dstStart] = -119;
            } else if (var7 == 352) {
               dst[var6 + dstStart] = -118;
            } else if (var7 == 8249) {
               dst[var6 + dstStart] = -117;
            } else if (var7 == 338) {
               dst[var6 + dstStart] = -116;
            } else if (var7 == 381) {
               dst[var6 + dstStart] = -114;
            } else if (var7 == 8216) {
               dst[var6 + dstStart] = -111;
            } else if (var7 == 8217) {
               dst[var6 + dstStart] = -110;
            } else if (var7 == 8220) {
               dst[var6 + dstStart] = -109;
            } else if (var7 == 8221) {
               dst[var6 + dstStart] = -108;
            } else if (var7 == 8226) {
               dst[var6 + dstStart] = -107;
            } else if (var7 == 8211) {
               dst[var6 + dstStart] = -106;
            } else if (var7 == 8212) {
               dst[var6 + dstStart] = -105;
            } else if (var7 == 732) {
               dst[var6 + dstStart] = -104;
            } else if (var7 == 8482) {
               dst[var6 + dstStart] = -103;
            } else if (var7 == 353) {
               dst[var6 + dstStart] = -102;
            } else if (var7 == 8250) {
               dst[var6 + dstStart] = -101;
            } else if (var7 == 339) {
               dst[var6 + dstStart] = -100;
            } else if (var7 == 382) {
               dst[var6 + dstStart] = -98;
            } else if (var7 == 376) {
               dst[var6 + dstStart] = -97;
            } else {
               dst[var6 + dstStart] = 63;
            }
         } else {
            dst[var6 + dstStart] = (byte)var7;
         }
      }

      return var5;
   }
}
