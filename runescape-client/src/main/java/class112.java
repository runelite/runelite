import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dt")
public class class112 {
   @ObfuscatedName("eu")
   @ObfuscatedSignature(
      signature = "Ljt;"
   )
   @Export("font_p12full")
   static Font font_p12full;
   @ObfuscatedName("cs")
   @ObfuscatedSignature(
      signature = "Lix;"
   )
   @Export("indexSoundEffects")
   static IndexData indexSoundEffects;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   @Export("vorbis_index")
   IndexDataBase vorbis_index;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   @Export("sfx_index")
   IndexDataBase sfx_index;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lgi;"
   )
   XHashTable field1632;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lgi;"
   )
   XHashTable field1628;

   @ObfuscatedSignature(
      signature = "(Lip;Lip;)V"
   )
   public class112(IndexDataBase var1, IndexDataBase var2) {
      this.field1628 = new XHashTable(256);
      this.field1632 = new XHashTable(256);
      this.sfx_index = var1;
      this.vorbis_index = var2;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II[IB)Ldm;",
      garbageValue = "-1"
   )
   class107 method2016(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4;
      class107 var7 = (class107)this.field1632.get(var5);
      if(var7 != null) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         SoundEffect var8 = SoundEffect.getTrack(this.sfx_index, var1, var2);
         if(var8 == null) {
            return null;
         } else {
            var7 = var8.method1867();
            this.field1632.put(var7, var5);
            if(var3 != null) {
               var3[0] -= var7.field1576.length;
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II[II)Ldm;",
      garbageValue = "-1800534463"
   )
   class107 method2030(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4 ^ 4294967296L;
      class107 var7 = (class107)this.field1632.get(var5);
      if(var7 != null) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         class106 var8 = (class106)this.field1628.get(var5);
         if(var8 == null) {
            var8 = class106.method1885(this.vorbis_index, var1, var2);
            if(var8 == null) {
               return null;
            }

            this.field1628.put(var8, var5);
         }

         var7 = var8.method1902(var3);
         if(var7 == null) {
            return null;
         } else {
            var8.unlink();
            this.field1632.put(var7, var5);
            return var7;
         }
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I[IB)Ldm;",
      garbageValue = "-56"
   )
   public class107 method2020(int var1, int[] var2) {
      if(this.vorbis_index.size() == 1) {
         return this.method2030(0, var1, var2);
      } else if(this.vorbis_index.fileCount(var1) == 1) {
         return this.method2030(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I[II)Ldm;",
      garbageValue = "-966373565"
   )
   public class107 method2021(int var1, int[] var2) {
      if(this.sfx_index.size() == 1) {
         return this.method2016(0, var1, var2);
      } else if(this.sfx_index.fileCount(var1) == 1) {
         return this.method2016(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lgk;III)I",
      garbageValue = "1670776060"
   )
   static int method2023(class186 var0, int var1, int var2) {
      if(var0 == null) {
         return var2;
      } else {
         WidgetConfig var3 = (WidgetConfig)var0.method3439((long)var1);
         return var3 == null?var2:var3.config;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-90370072"
   )
   public static void method2031(int var0) {
      class203.field2471 = 1;
      class222.field2815 = null;
      class203.field2468 = -1;
      class203.field2473 = -1;
      WorldMapType2.field513 = 0;
      class203.field2474 = false;
      ChatLineBuffer.field1524 = var0;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Leo;IIII)Z",
      garbageValue = "-2050880809"
   )
   public static final boolean method2029(Model var0, int var1, int var2, int var3) {
      if(!class261.method4610()) {
         return false;
      } else {
         int var4;
         int var5;
         int var6;
         int var7;
         int var10;
         int var11;
         int var12;
         int var15;
         int var16;
         if(!class134.field1951) {
            var4 = Region.pitchSin;
            var5 = Region.pitchCos;
            var6 = Region.yawSin;
            var7 = Region.yawCos;
            byte var8 = 50;
            short var9 = 3500;
            var10 = (class134.field1953 - Graphics3D.centerX) * var8 / Graphics3D.field1983;
            var11 = (class134.field1948 - Graphics3D.centerY) * var8 / Graphics3D.field1983;
            var12 = (class134.field1953 - Graphics3D.centerX) * var9 / Graphics3D.field1983;
            int var13 = (class134.field1948 - Graphics3D.centerY) * var9 / Graphics3D.field1983;
            int var14 = Graphics3D.method2608(var11, var8, var5, var4);
            var15 = Graphics3D.method2581(var11, var8, var5, var4);
            var11 = var14;
            var14 = Graphics3D.method2608(var13, var9, var5, var4);
            var16 = Graphics3D.method2581(var13, var9, var5, var4);
            var13 = var14;
            var14 = Graphics3D.method2543(var10, var15, var7, var6);
            var15 = Graphics3D.method2607(var10, var15, var7, var6);
            var10 = var14;
            var14 = Graphics3D.method2543(var12, var16, var7, var6);
            var16 = Graphics3D.method2607(var12, var16, var7, var6);
            class35.field487 = (var10 + var14) / 2;
            class134.field1952 = (var13 + var11) / 2;
            BuildType.field3153 = (var16 + var15) / 2;
            class37.field505 = (var14 - var10) / 2;
            RSCanvas.field660 = (var13 - var11) / 2;
            class2.field12 = (var16 - var15) / 2;
            class134.field1950 = Math.abs(class37.field505);
            FileOnDisk.field1730 = Math.abs(RSCanvas.field660);
            class140.field2080 = Math.abs(class2.field12);
         }

         var4 = var0.field1896 + var1;
         var5 = var2 + var0.field1911;
         var6 = var3 + var0.field1912;
         var7 = var0.field1913;
         var15 = var0.field1917;
         var16 = var0.field1901;
         var10 = class35.field487 - var4;
         var11 = class134.field1952 - var5;
         var12 = BuildType.field3153 - var6;
         return Math.abs(var10) > var7 + class134.field1950?false:(Math.abs(var11) > var15 + FileOnDisk.field1730?false:(Math.abs(var12) > var16 + class140.field2080?false:(Math.abs(var12 * RSCanvas.field660 - var11 * class2.field12) > var16 * FileOnDisk.field1730 + var15 * class140.field2080?false:(Math.abs(var10 * class2.field12 - var12 * class37.field505) > var16 * class134.field1950 + var7 * class140.field2080?false:Math.abs(var11 * class37.field505 - var10 * RSCanvas.field660) <= var15 * class134.field1950 + var7 * FileOnDisk.field1730))));
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)[Ljx;",
      garbageValue = "1539977190"
   )
   static ModIcon[] method2032() {
      ModIcon[] var0 = new ModIcon[class286.field3785];

      for(int var1 = 0; var1 < class286.field3785; ++var1) {
         ModIcon var2 = var0[var1] = new ModIcon();
         var2.width = class286.field3780;
         var2.originalHeight = class286.field3781;
         var2.offsetX = class286.field3782[var1];
         var2.offsetY = class286.offsetsY[var1];
         var2.originalWidth = class286.field3779[var1];
         var2.height = class286.field3787[var1];
         var2.palette = class286.field3786;
         var2.pixels = class286.spritePixels[var1];
      }

      class286.field3782 = null;
      class286.offsetsY = null;
      class286.field3779 = null;
      class286.field3787 = null;
      class286.field3786 = null;
      class286.spritePixels = null;
      return var0;
   }
}
