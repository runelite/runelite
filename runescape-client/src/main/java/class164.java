import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fg")
public abstract class class164 {
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Ldt;"
   )
   @Export("task")
   static SoundTask task;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -2098469635
   )
   public int field2294;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1294006913
   )
   public int field2293;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1020670377
   )
   public int field2292;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -2137467273
   )
   public int field2295;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIILfo;I)Z",
      garbageValue = "379386019"
   )
   public abstract boolean vmethod3095(int var1, int var2, int var3, CollisionData var4);

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)Lhb;",
      garbageValue = "-385208509"
   )
   public static BuildType method3093(int var0) {
      BuildType[] var1 = Occluder.method2933();

      for(int var2 = 0; var2 < var1.length; ++var2) {
         BuildType var3 = var1[var2];
         if(var0 == var3.ordinal) {
            return var3;
         }
      }

      return null;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([Lcq;II[I[II)V",
      garbageValue = "37214633"
   )
   static void method3096(World[] var0, int var1, int var2, int[] var3, int[] var4) {
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
                     var11 = var0[var6].method1550()?1:0;
                     var12 = var8.method1550()?1:0;
                  } else {
                     var11 = var0[var6].id;
                     var12 = var8.id;
                  }

                  if(var12 != var11) {
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
                     var11 = var0[var5].method1550()?1:0;
                     var12 = var8.method1550()?1:0;
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

         method3096(var0, var1, var6, var3, var4);
         method3096(var0, var6 + 1, var2, var3, var4);
      }

   }
}
