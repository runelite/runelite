import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dn")
public class class111 {
   @ObfuscatedName("hl")
   @ObfuscatedSignature(
      signature = "Lhk;"
   )
   static Widget field1586;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   @Export("sfx_index")
   IndexDataBase sfx_index;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   @Export("vorbis_index")
   IndexDataBase vorbis_index;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lgx;"
   )
   HashTable field1588;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lgx;"
   )
   HashTable field1585;

   @ObfuscatedSignature(
      signature = "(Lik;Lik;)V"
   )
   public class111(IndexDataBase var1, IndexDataBase var2) {
      this.field1588 = new HashTable(256);
      this.field1585 = new HashTable(256);
      this.sfx_index = var1;
      this.vorbis_index = var2;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II[II)Lde;",
      garbageValue = "-312599664"
   )
   class106 method2171(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & 65535 | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4;
      class106 var7 = (class106)this.field1585.get(var5);
      if(var7 != null) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         SoundEffect var8 = SoundEffect.getTrack(this.sfx_index, var1, var2);
         if(var8 == null) {
            return null;
         } else {
            var7 = var8.method2038();
            this.field1585.put(var7, var5);
            if(var3 != null) {
               var3[0] -= var7.field1527.length;
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II[IB)Lde;",
      garbageValue = "-18"
   )
   class106 method2172(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & 65535 | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4 ^ 4294967296L;
      class106 var7 = (class106)this.field1585.get(var5);
      if(var7 != null) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         class105 var8 = (class105)this.field1588.get(var5);
         if(var8 == null) {
            var8 = class105.method2057(this.vorbis_index, var1, var2);
            if(var8 == null) {
               return null;
            }

            this.field1588.put(var8, var5);
         }

         var7 = var8.method2058(var3);
         if(var7 == null) {
            return null;
         } else {
            var8.unlink();
            this.field1585.put(var7, var5);
            return var7;
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I[II)Lde;",
      garbageValue = "-637208931"
   )
   public class106 method2173(int var1, int[] var2) {
      if(this.sfx_index.size() == 1) {
         return this.method2171(0, var1, var2);
      } else if(this.sfx_index.fileCount(var1) == 1) {
         return this.method2171(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I[IB)Lde;",
      garbageValue = "-105"
   )
   public class106 method2174(int var1, int[] var2) {
      if(this.vorbis_index.size() == 1) {
         return this.method2172(0, var1, var2);
      } else if(this.vorbis_index.fileCount(var1) == 1) {
         return this.method2172(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lbi;I)V",
      garbageValue = "-1501553455"
   )
   public static void method2177(ScriptEvent var0) {
      class64.method1147(var0, 200000);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)[Lig;",
      garbageValue = "1089779989"
   )
   public static class239[] method2182() {
      return new class239[]{class239.field3260, class239.field3258, class239.field3257, class239.field3256, class239.field3255, class239.field3263};
   }

   @ObfuscatedName("hn")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Lhk;I)Ljava/lang/String;",
      garbageValue = "-2139407332"
   )
   static String method2189(String var0, Widget var1) {
      if(var0.indexOf("%") != -1) {
         int var2;
         for(var2 = 1; var2 <= 5; ++var2) {
            while(true) {
               int var3 = var0.indexOf("%" + var2);
               if(var3 == -1) {
                  break;
               }

               var0 = var0.substring(0, var3) + class96.method1906(class12.method73(var1, var2 - 1)) + var0.substring(var3 + 2);
            }
         }

         while(true) {
            var2 = var0.indexOf("%dns");
            if(var2 == -1) {
               break;
            }

            String var4 = "";
            if(FileSystem.field3271 != null) {
               var4 = SceneTilePaint.method2776(FileSystem.field3271.field2144);
               if(FileSystem.field3271.value != null) {
                  var4 = (String)FileSystem.field3271.value;
               }
            }

            var0 = var0.substring(0, var2) + var4 + var0.substring(var2 + 4);
         }
      }

      return var0;
   }
}
