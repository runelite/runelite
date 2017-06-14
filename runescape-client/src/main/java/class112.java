import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dk")
public class class112 {
   @ObfuscatedName("j")
   XHashTable field1671;
   @ObfuscatedName("p")
   IndexDataBase field1672;
   @ObfuscatedName("i")
   XHashTable field1673;
   @ObfuscatedName("n")
   IndexDataBase field1678;

   @ObfuscatedName("ho")
   @ObfuscatedSignature(
      signature = "(IIIIS)V",
      garbageValue = "29527"
   )
   static void method2074(int var0, int var1, int var2, int var3) {
      Widget var4 = class29.method254(var0, var1);
      if(var4 != null && var4.field2743 != null) {
         class69 var5 = new class69();
         var5.field824 = var4;
         var5.field833 = var4.field2743;
         class227.method4101(var5);
      }

      Client.field1073 = var3;
      Client.field1071 = true;
      NPC.field1375 = var0;
      Client.field1072 = var1;
      class221.spellTargetFlags = var2;
      CombatInfo1.method1515(var4);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II[IB)Lclass107;",
      garbageValue = "-63"
   )
   class107 method2075(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4;
      class107 var7 = (class107)this.field1671.method3545(var5);
      if(var7 != null) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         SoundEffect var8 = SoundEffect.method1922(this.field1678, var1, var2);
         if(var8 == null) {
            return null;
         } else {
            var7 = var8.method1920();
            this.field1671.method3546(var7, var5);
            if(var3 != null) {
               var3[0] -= var7.field1613.length;
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I[II)Lclass107;",
      garbageValue = "-1795629414"
   )
   public class107 method2077(int var1, int[] var2) {
      if(this.field1678.method4215() == 1) {
         return this.method2075(0, var1, var2);
      } else if(this.field1678.method4174(var1) == 1) {
         return this.method2075(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   public class112(IndexDataBase var1, IndexDataBase var2) {
      this.field1673 = new XHashTable(256);
      this.field1671 = new XHashTable(256);
      this.field1678 = var1;
      this.field1672 = var2;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I[IB)Lclass107;",
      garbageValue = "63"
   )
   public class107 method2081(int var1, int[] var2) {
      if(this.field1672.method4215() == 1) {
         return this.method2085(0, var1, var2);
      } else if(this.field1672.method4174(var1) == 1) {
         return this.method2085(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "([BIIB)I",
      garbageValue = "-37"
   )
   public static int method2082(byte[] var0, int var1, int var2) {
      int var3 = -1;

      for(int var4 = var1; var4 < var2; ++var4) {
         var3 = var3 >>> 8 ^ Buffer.field2397[(var3 ^ var0[var4]) & 255];
      }

      var3 = ~var3;
      return var3;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II[II)Lclass107;",
      garbageValue = "-494450728"
   )
   class107 method2085(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4 ^ 4294967296L;
      class107 var7 = (class107)this.field1671.method3545(var5);
      if(var7 != null) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         class106 var8 = (class106)this.field1673.method3545(var5);
         if(var8 == null) {
            var8 = class106.method1954(this.field1672, var1, var2);
            if(var8 == null) {
               return null;
            }

            this.field1673.method3546(var8, var5);
         }

         var7 = var8.method1942(var3);
         if(var7 == null) {
            return null;
         } else {
            var8.unlink();
            this.field1671.method3546(var7, var5);
            return var7;
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-70"
   )
   static void method2090(int var0, int var1) {
      int[] var2 = new int[4];
      int[] var3 = new int[4];
      var2[0] = var0;
      var3[0] = var1;
      int var4 = 1;

      for(int var5 = 0; var5 < 4; ++var5) {
         if(World.field1294[var5] != var0) {
            var2[var4] = World.field1294[var5];
            var3[var4] = World.field1299[var5];
            ++var4;
         }
      }

      World.field1294 = var2;
      World.field1299 = var3;
      method2093(World.worldList, 0, World.worldList.length - 1, World.field1294, World.field1299);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;III)Z",
      garbageValue = "904021961"
   )
   public static boolean method2092(IndexDataBase var0, int var1, int var2) {
      byte[] var3 = var0.getConfigData(var1, var2);
      if(var3 == null) {
         return false;
      } else {
         Renderable.method2869(var3);
         return true;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([LWorld;II[I[II)V",
      garbageValue = "-257732151"
   )
   static void method2093(World[] var0, int var1, int var2, int[] var3, int[] var4) {
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
                     var11 = var0[var6].method1518()?1:0;
                     var12 = var8.method1518()?1:0;
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
                     var11 = var0[var5].method1518()?1:0;
                     var12 = var8.method1518()?1:0;
                  } else {
                     var11 = var0[var5].id;
                     var12 = var8.id;
                  }

                  if(var11 != var12) {
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

         method2093(var0, var1, var6, var3, var4);
         method2093(var0, var6 + 1, var2, var3, var4);
      }

   }
}
