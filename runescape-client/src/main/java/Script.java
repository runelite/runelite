import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ct")
@Implements("Script")
public class Script extends CacheableNode {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lgo;"
   )
   static NodeCache field1522;
   @ObfuscatedName("s")
   @Export("instructions")
   int[] instructions;
   @ObfuscatedName("q")
   @Export("intOperands")
   int[] intOperands;
   @ObfuscatedName("o")
   @Export("stringOperands")
   String[] stringOperands;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 924257005
   )
   @Export("localIntCount")
   int localIntCount;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 663833861
   )
   @Export("localStringCount")
   int localStringCount;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1231872303
   )
   @Export("intStackCount")
   int intStackCount;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1090992437
   )
   @Export("stringStackCount")
   int stringStackCount;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "[Lgk;"
   )
   @Export("switches")
   IterableHashTable[] switches;

   static {
      field1522 = new NodeCache(128);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)[Lgk;",
      garbageValue = "-2008049021"
   )
   IterableHashTable[] method1882(int var1) {
      return new IterableHashTable[var1];
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "([Lco;II[I[II)V",
      garbageValue = "2043682542"
   )
   static void method1897(World[] var0, int var1, int var2, int[] var3, int[] var4) {
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
                     var11 = var0[var6].method1546()?1:0;
                     var12 = var8.method1546()?1:0;
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
                     var11 = var0[var5].method1546()?1:0;
                     var12 = var8.method1546()?1:0;
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

         method1897(var0, var1, var6, var3, var4);
         method1897(var0, var6 + 1, var2, var3, var4);
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lfg;I)I",
      garbageValue = "897121551"
   )
   static int method1896(PacketBuffer var0) {
      int var1 = var0.getBits(2);
      int var2;
      if(var1 == 0) {
         var2 = 0;
      } else if(var1 == 1) {
         var2 = var0.getBits(5);
      } else if(var1 == 2) {
         var2 = var0.getBits(8);
      } else {
         var2 = var0.getBits(11);
      }

      return var2;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-492487402"
   )
   static int method1898(int var0) {
      MessageNode var1 = (MessageNode)class96.field1516.get((long)var0);
      return var1 == null?-1:(var1.previous == class96.field1517.field2483?-1:((MessageNode)var1.previous).id);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lcs;B)V",
      garbageValue = "4"
   )
   public static final void method1895(class101 var0) {
      AbstractSoundSystem.field1618 = var0;
   }
}
