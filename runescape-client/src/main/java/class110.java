import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("di")
public class class110 {
   @ObfuscatedName("a")
   @Export("osNameLC")
   public static String osNameLC;
   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "Lbt;"
   )
   static class70 field1653;
   @ObfuscatedName("cb")
   static boolean field1650;
   @ObfuscatedName("pb")
   @ObfuscatedGetter(
      intValue = -1419635649
   )
   static int field1656;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   @Export("vorbis_index")
   IndexDataBase vorbis_index;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   @Export("sfx_index")
   IndexDataBase sfx_index;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lgn;"
   )
   HashTable field1658;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lgn;"
   )
   HashTable field1652;

   @ObfuscatedSignature(
      signature = "(Lit;Lit;)V"
   )
   public class110(IndexDataBase var1, IndexDataBase var2) {
      this.field1652 = new HashTable(256);
      this.field1658 = new HashTable(256);
      this.sfx_index = var1;
      this.vorbis_index = var2;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II[II)Ldo;",
      garbageValue = "2103328028"
   )
   class105 method2157(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & 65535 | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4;
      class105 var7 = (class105)this.field1658.get(var5);
      if(var7 != null) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         SoundEffect var8 = SoundEffect.getTrack(this.sfx_index, var1, var2);
         if(var8 == null) {
            return null;
         } else {
            var7 = var8.method2011();
            this.field1658.put(var7, var5);
            if(var3 != null) {
               var3[0] -= var7.field1596.length;
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II[IB)Ldo;",
      garbageValue = "-21"
   )
   class105 method2158(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & 65535 | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4 ^ 4294967296L;
      class105 var7 = (class105)this.field1658.get(var5);
      if(var7 != null) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         class104 var8 = (class104)this.field1652.get(var5);
         if(var8 == null) {
            var8 = class104.method2027(this.vorbis_index, var1, var2);
            if(var8 == null) {
               return null;
            }

            this.field1652.put(var8, var5);
         }

         var7 = var8.method2037(var3);
         if(var7 == null) {
            return null;
         } else {
            var8.unlink();
            this.field1658.put(var7, var5);
            return var7;
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I[II)Ldo;",
      garbageValue = "1531071422"
   )
   public class105 method2160(int var1, int[] var2) {
      if(this.vorbis_index.size() == 1) {
         return this.method2158(0, var1, var2);
      } else if(this.vorbis_index.fileCount(var1) == 1) {
         return this.method2158(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I[II)Ldo;",
      garbageValue = "-1865161267"
   )
   public class105 method2165(int var1, int[] var2) {
      if(this.sfx_index.size() == 1) {
         return this.method2157(0, var1, var2);
      } else if(this.sfx_index.fileCount(var1) == 1) {
         return this.method2157(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "([Lcg;II[I[IB)V",
      garbageValue = "46"
   )
   static void method2174(World[] var0, int var1, int var2, int[] var3, int[] var4) {
      if(var1 < var2) {
         int var5 = var1 - 1;
         int var6 = var2 + 1;
         int var7 = (var2 + var1) / 2;
         World var8 = var0[var7];
         var0[var7] = var0[var1];
         var0[var1] = var8;

         while(var5 < var6) {
            boolean var9 = true;

            int var10;
            int var11;
            int var12;
            do {
               --var6;

               for(var10 = 0; var10 < 4; ++var10) {
                  if(var3[var10] == 2) {
                     var11 = var0[var6].index;
                     var12 = var8.index;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var6].playerCount;
                     var12 = var8.playerCount;
                     if(var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var10] == 3) {
                     var11 = var0[var6].method1638()?1:0;
                     var12 = var8.method1638()?1:0;
                  } else {
                     var11 = var0[var6].id;
                     var12 = var8.id;
                  }

                  if(var11 != var12) {
                     if((var4[var10] != 1 || var11 <= var12) && (var4[var10] != 0 || var11 >= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(var10 == 3) {
                     var9 = false;
                  }
               }
            } while(var9);

            var9 = true;

            do {
               ++var5;

               for(var10 = 0; var10 < 4; ++var10) {
                  if(var3[var10] == 2) {
                     var11 = var0[var5].index;
                     var12 = var8.index;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var5].playerCount;
                     var12 = var8.playerCount;
                     if(var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var10] == 3) {
                     var11 = var0[var5].method1638()?1:0;
                     var12 = var8.method1638()?1:0;
                  } else {
                     var11 = var0[var5].id;
                     var12 = var8.id;
                  }

                  if(var12 != var11) {
                     if((var4[var10] != 1 || var11 >= var12) && (var4[var10] != 0 || var11 <= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(var10 == 3) {
                     var9 = false;
                  }
               }
            } while(var9);

            if(var5 < var6) {
               World var13 = var0[var5];
               var0[var5] = var0[var6];
               var0[var6] = var13;
            }
         }

         method2174(var0, var1, var6, var3, var4);
         method2174(var0, var6 + 1, var2, var3, var4);
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "16"
   )
   public static boolean method2171(int var0, int var1) {
      return (var0 >> var1 + 1 & 1) != 0;
   }
}
