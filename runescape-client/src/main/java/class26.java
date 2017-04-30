import java.io.DataInputStream;
import java.io.IOException;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("am")
public class class26 {
   @ObfuscatedName("c")
   class102 field587;
   @ObfuscatedName("pl")
   static short[] field589;
   @ObfuscatedName("q")
   byte[] field590;
   @ObfuscatedName("p")
   byte[] field591;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 216528663
   )
   int field592;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      longValue = 5130762723647753533L
   )
   long field593;
   @ObfuscatedName("n")
   DataInputStream field594;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -2045278477
   )
   int field597;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -2133045069
   )
   int field598;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "([LWorld;II[I[IS)V",
      garbageValue = "180"
   )
   static void method574(World[] var0, int var1, int var2, int[] var3, int[] var4) {
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
                     var11 = var0[var6].method603()?1:0;
                     var12 = var8.method603()?1:0;
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
                     var11 = var0[var5].method603()?1:0;
                     var12 = var8.method603()?1:0;
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

         method574(var0, var1, var6, var3, var4);
         method574(var0, var6 + 1, var2, var3, var4);
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "-65196489"
   )
   byte[] method575() throws IOException {
      if(class72.method1421() > this.field593) {
         throw new IOException();
      } else {
         if(this.field597 == 0) {
            if(this.field587.field1653 == 2) {
               throw new IOException();
            }

            if(this.field587.field1653 == 1) {
               this.field594 = (DataInputStream)this.field587.field1657;
               this.field597 = 1;
            }
         }

         if(this.field597 == 1) {
            this.field598 += this.field594.read(this.field590, this.field598, this.field590.length - this.field598);
            if(this.field598 == 4) {
               int var1 = (new Buffer(this.field590)).readInt();
               this.field591 = new byte[var1];
               this.field597 = 2;
            }
         }

         if(this.field597 == 2) {
            this.field592 += this.field594.read(this.field591, this.field592, this.field591.length - this.field592);
            if(this.field591.length == this.field592) {
               return this.field591;
            }
         }

         return null;
      }
   }

   class26(class103 var1, URL var2) {
      this.field590 = new byte[4];
      this.field587 = var1.method1991(var2);
      this.field597 = 0;
      this.field593 = class72.method1421() + 30000L;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)LObjectComposition;",
      garbageValue = "-1199799866"
   )
   @Export("getObjectDefinition")
   public static ObjectComposition getObjectDefinition(int var0) {
      ObjectComposition var1 = (ObjectComposition)ObjectComposition.field2926.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = ObjectComposition.field2967.getConfigData(6, var0);
         var1 = new ObjectComposition();
         var1.field2941 = var0;
         if(var2 != null) {
            var1.method3693(new Buffer(var2));
         }

         var1.method3692();
         if(var1.isSolid) {
            var1.field2936 = 0;
            var1.field2942 = false;
         }

         ObjectComposition.field2926.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "-792098417"
   )
   static final boolean method579(char var0) {
      return var0 == 160 || var0 == 32 || var0 == 95 || var0 == 45;
   }
}
