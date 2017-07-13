import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("du")
public class class112 {
   @ObfuscatedName("p")
   @Export("worldServersDownload")
   static class77 worldServersDownload;
   @ObfuscatedName("j")
   @Export("vorbis_index")
   IndexDataBase vorbis_index;
   @ObfuscatedName("a")
   @Export("sfx_index")
   IndexDataBase sfx_index;
   @ObfuscatedName("r")
   XHashTable field1657;
   @ObfuscatedName("n")
   XHashTable field1658;

   public class112(IndexDataBase var1, IndexDataBase var2) {
      this.field1658 = new XHashTable(256);
      this.field1657 = new XHashTable(256);
      this.sfx_index = var1;
      this.vorbis_index = var2;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II[II)Lclass107;",
      garbageValue = "972050229"
   )
   class107 method2060(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4 ^ 4294967296L;
      class107 var7 = (class107)this.field1657.get(var5);
      if(var7 != null) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         class106 var8 = (class106)this.field1658.get(var5);
         if(var8 == null) {
            var8 = class106.method1924(this.vorbis_index, var1, var2);
            if(var8 == null) {
               return null;
            }

            this.field1658.put(var8, var5);
         }

         var7 = var8.method1926(var3);
         if(var7 == null) {
            return null;
         } else {
            var8.unlink();
            this.field1657.put(var7, var5);
            return var7;
         }
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II[II)Lclass107;",
      garbageValue = "2100864803"
   )
   class107 method2061(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4;
      class107 var7 = (class107)this.field1657.get(var5);
      if(var7 != null) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         SoundEffect var8 = SoundEffect.getTrack(this.sfx_index, var1, var2);
         if(var8 == null) {
            return null;
         } else {
            var7 = var8.method1906();
            this.field1657.put(var7, var5);
            if(var3 != null) {
               var3[0] -= var7.field1607.length;
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I[II)Lclass107;",
      garbageValue = "671573384"
   )
   public class107 method2063(int var1, int[] var2) {
      if(this.sfx_index.size() == 1) {
         return this.method2061(0, var1, var2);
      } else if(this.sfx_index.fileCount(var1) == 1) {
         return this.method2061(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I[II)Lclass107;",
      garbageValue = "2016154789"
   )
   public class107 method2064(int var1, int[] var2) {
      if(this.vorbis_index.size() == 1) {
         return this.method2060(0, var1, var2);
      } else if(this.vorbis_index.fileCount(var1) == 1) {
         return this.method2060(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IB)LSequence;",
      garbageValue = "-93"
   )
   @Export("getAnimation")
   public static Sequence getAnimation(int var0) {
      Sequence var1 = (Sequence)Sequence.sequences.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Sequence.seq_ref.getConfigData(12, var0);
         var1 = new Sequence();
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         var1.post();
         Sequence.sequences.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "([BILjava/lang/CharSequence;I)I",
      garbageValue = "2141379391"
   )
   public static int method2070(byte[] var0, int var1, CharSequence var2) {
      int var3 = var2.length();
      int var4 = var1;

      for(int var5 = 0; var5 < var3; ++var5) {
         char var6 = var2.charAt(var5);
         if(var6 <= 127) {
            var0[var4++] = (byte)var6;
         } else if(var6 <= 2047) {
            var0[var4++] = (byte)(192 | var6 >> 6);
            var0[var4++] = (byte)(128 | var6 & 63);
         } else {
            var0[var4++] = (byte)(224 | var6 >> 12);
            var0[var4++] = (byte)(128 | var6 >> 6 & 63);
            var0[var4++] = (byte)(128 | var6 & 63);
         }
      }

      return var4 - var1;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1010432495"
   )
   public static final boolean method2078() {
      KeyFocusListener var0 = KeyFocusListener.keyboard;
      synchronized(KeyFocusListener.keyboard) {
         if(KeyFocusListener.field637 == KeyFocusListener.field635) {
            return false;
         } else {
            KeyFocusListener.field627 = KeyFocusListener.field628[KeyFocusListener.field635];
            class203.field2510 = KeyFocusListener.field631[KeyFocusListener.field635];
            KeyFocusListener.field635 = KeyFocusListener.field635 + 1 & 127;
            return true;
         }
      }
   }

   @ObfuscatedName("gd")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-998959860"
   )
   static final void method2073(boolean var0) {
      for(int var1 = 0; var1 < Client.field944; ++var1) {
         NPC var2 = Client.cachedNPCs[Client.npcIndices[var1]];
         int var3 = (Client.npcIndices[var1] << 14) + 536870912;
         if(var2 != null && var2.hasConfig() && var2.composition.isVisible == var0 && var2.composition.method4578()) {
            int var4 = var2.x >> 7;
            int var5 = var2.y >> 7;
            if(var4 >= 0 && var4 < 104 && var5 >= 0 && var5 < 104) {
               if(var2.field1218 == 1 && (var2.x & 127) == 64 && (var2.y & 127) == 64) {
                  if(Client.field1009[var4][var5] == Client.field1010) {
                     continue;
                  }

                  Client.field1009[var4][var5] = Client.field1010;
               }

               if(!var2.composition.field3584) {
                  var3 -= Integer.MIN_VALUE;
               }

               class29.region.method2677(class45.plane, var2.x, var2.y, Actor.getTileHeight(var2.field1218 * 64 - 64 + var2.x, var2.field1218 * 64 - 64 + var2.y, class45.plane), var2.field1218 * 64 - 64 + 60, var2, var2.angle, var3, var2.field1217);
            }
         }
      }

   }
}
