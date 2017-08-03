import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dp")
public class class114 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lim;"
   )
   @Export("sfx_index")
   IndexDataBase sfx_index;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lim;"
   )
   @Export("vorbis_index")
   IndexDataBase vorbis_index;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lgx;"
   )
   XHashTable field1657;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lgx;"
   )
   XHashTable field1656;

   @ObfuscatedSignature(
      signature = "(Lim;Lim;)V"
   )
   public class114(IndexDataBase var1, IndexDataBase var2) {
      this.field1656 = new XHashTable(256);
      this.field1657 = new XHashTable(256);
      this.sfx_index = var1;
      this.vorbis_index = var2;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II[II)Ldv;",
      garbageValue = "307613171"
   )
   class109 method2152(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4;
      class109 var7 = (class109)this.field1657.get(var5);
      if(var7 != null) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         SoundEffect var8 = SoundEffect.getTrack(this.sfx_index, var1, var2);
         if(var8 == null) {
            return null;
         } else {
            var7 = var8.method2001();
            this.field1657.put(var7, var5);
            if(var3 != null) {
               var3[0] -= var7.field1598.length;
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II[II)Ldv;",
      garbageValue = "974550489"
   )
   class109 method2159(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4 ^ 4294967296L;
      class109 var7 = (class109)this.field1657.get(var5);
      if(var7 != null) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         class108 var8 = (class108)this.field1656.get(var5);
         if(var8 == null) {
            var8 = class108.method2027(this.vorbis_index, var1, var2);
            if(var8 == null) {
               return null;
            }

            this.field1656.put(var8, var5);
         }

         var7 = var8.method2026(var3);
         if(var7 == null) {
            return null;
         } else {
            var8.unlink();
            this.field1657.put(var7, var5);
            return var7;
         }
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I[II)Ldv;",
      garbageValue = "685992884"
   )
   public class109 method2151(int var1, int[] var2) {
      if(this.vorbis_index.size() == 1) {
         return this.method2159(0, var1, var2);
      } else if(this.vorbis_index.fileCount(var1) == 1) {
         return this.method2159(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I[IB)Ldv;",
      garbageValue = "1"
   )
   public class109 method2153(int var1, int[] var2) {
      if(this.sfx_index.size() == 1) {
         return this.method2152(0, var1, var2);
      } else if(this.sfx_index.fileCount(var1) == 1) {
         return this.method2152(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(ILcd;ZI)I",
      garbageValue = "173255998"
   )
   static int method2167(int var0, Script var1, boolean var2) {
      int var3;
      int var4;
      if(var0 == 4000) {
         class83.intStackSize -= 2;
         var3 = class83.intStack[class83.intStackSize];
         var4 = class83.intStack[class83.intStackSize + 1];
         class83.intStack[++class83.intStackSize - 1] = var3 + var4;
         return 1;
      } else if(var0 == 4001) {
         class83.intStackSize -= 2;
         var3 = class83.intStack[class83.intStackSize];
         var4 = class83.intStack[class83.intStackSize + 1];
         class83.intStack[++class83.intStackSize - 1] = var3 - var4;
         return 1;
      } else if(var0 == 4002) {
         class83.intStackSize -= 2;
         var3 = class83.intStack[class83.intStackSize];
         var4 = class83.intStack[class83.intStackSize + 1];
         class83.intStack[++class83.intStackSize - 1] = var3 * var4;
         return 1;
      } else if(var0 == 4003) {
         class83.intStackSize -= 2;
         var3 = class83.intStack[class83.intStackSize];
         var4 = class83.intStack[class83.intStackSize + 1];
         class83.intStack[++class83.intStackSize - 1] = var3 / var4;
         return 1;
      } else if(var0 == 4004) {
         var3 = class83.intStack[--class83.intStackSize];
         class83.intStack[++class83.intStackSize - 1] = (int)(Math.random() * (double)var3);
         return 1;
      } else if(var0 == 4005) {
         var3 = class83.intStack[--class83.intStackSize];
         class83.intStack[++class83.intStackSize - 1] = (int)(Math.random() * (double)(var3 + 1));
         return 1;
      } else if(var0 == 4006) {
         class83.intStackSize -= 5;
         var3 = class83.intStack[class83.intStackSize];
         var4 = class83.intStack[class83.intStackSize + 1];
         int var5 = class83.intStack[class83.intStackSize + 2];
         int var6 = class83.intStack[class83.intStackSize + 3];
         int var7 = class83.intStack[class83.intStackSize + 4];
         class83.intStack[++class83.intStackSize - 1] = var3 + (var7 - var5) * (var4 - var3) / (var6 - var5);
         return 1;
      } else if(var0 == 4007) {
         class83.intStackSize -= 2;
         var3 = class83.intStack[class83.intStackSize];
         var4 = class83.intStack[class83.intStackSize + 1];
         class83.intStack[++class83.intStackSize - 1] = var3 + var3 * var4 / 100;
         return 1;
      } else if(var0 == 4008) {
         class83.intStackSize -= 2;
         var3 = class83.intStack[class83.intStackSize];
         var4 = class83.intStack[class83.intStackSize + 1];
         class83.intStack[++class83.intStackSize - 1] = var3 | 1 << var4;
         return 1;
      } else if(var0 == 4009) {
         class83.intStackSize -= 2;
         var3 = class83.intStack[class83.intStackSize];
         var4 = class83.intStack[class83.intStackSize + 1];
         class83.intStack[++class83.intStackSize - 1] = var3 & -1 - (1 << var4);
         return 1;
      } else if(var0 == 4010) {
         class83.intStackSize -= 2;
         var3 = class83.intStack[class83.intStackSize];
         var4 = class83.intStack[class83.intStackSize + 1];
         class83.intStack[++class83.intStackSize - 1] = (var3 & 1 << var4) != 0?1:0;
         return 1;
      } else if(var0 == 4011) {
         class83.intStackSize -= 2;
         var3 = class83.intStack[class83.intStackSize];
         var4 = class83.intStack[class83.intStackSize + 1];
         class83.intStack[++class83.intStackSize - 1] = var3 % var4;
         return 1;
      } else if(var0 == 4012) {
         class83.intStackSize -= 2;
         var3 = class83.intStack[class83.intStackSize];
         var4 = class83.intStack[class83.intStackSize + 1];
         if(var3 == 0) {
            class83.intStack[++class83.intStackSize - 1] = 0;
         } else {
            class83.intStack[++class83.intStackSize - 1] = (int)Math.pow((double)var3, (double)var4);
         }

         return 1;
      } else if(var0 == 4013) {
         class83.intStackSize -= 2;
         var3 = class83.intStack[class83.intStackSize];
         var4 = class83.intStack[class83.intStackSize + 1];
         if(var3 == 0) {
            class83.intStack[++class83.intStackSize - 1] = 0;
         } else if(var4 == 0) {
            class83.intStack[++class83.intStackSize - 1] = Integer.MAX_VALUE;
         } else {
            class83.intStack[++class83.intStackSize - 1] = (int)Math.pow((double)var3, 1.0D / (double)var4);
         }

         return 1;
      } else if(var0 == 4014) {
         class83.intStackSize -= 2;
         var3 = class83.intStack[class83.intStackSize];
         var4 = class83.intStack[class83.intStackSize + 1];
         class83.intStack[++class83.intStackSize - 1] = var3 & var4;
         return 1;
      } else if(var0 == 4015) {
         class83.intStackSize -= 2;
         var3 = class83.intStack[class83.intStackSize];
         var4 = class83.intStack[class83.intStackSize + 1];
         class83.intStack[++class83.intStackSize - 1] = var3 | var4;
         return 1;
      } else if(var0 == 4018) {
         class83.intStackSize -= 3;
         long var9 = (long)class83.intStack[class83.intStackSize];
         long var11 = (long)class83.intStack[class83.intStackSize + 1];
         long var13 = (long)class83.intStack[class83.intStackSize + 2];
         class83.intStack[++class83.intStackSize - 1] = (int)(var9 * var13 / var11);
         return 1;
      } else {
         return 2;
      }
   }
}
