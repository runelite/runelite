import java.util.zip.CRC32;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("il")
public class class238 {
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      longValue = -2465052314938923387L
   )
   static long field3240;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 421955813
   )
   public static int field3241;
   @ObfuscatedName("e")
   static CRC32 field3242;
   @ObfuscatedName("q")
   static XHashTable field3243;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -621179
   )
   public static int field3244;
   @ObfuscatedName("v")
   static XHashTable field3245;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1437024471
   )
   public static int field3246;
   @ObfuscatedName("p")
   static Node2LinkedList field3247;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1503266593
   )
   static int field3248;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1106253743
   )
   public static int field3249;
   @ObfuscatedName("k")
   static XHashTable field3250;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1632323133
   )
   static int field3251;
   @ObfuscatedName("o")
   static Buffer field3252;
   @ObfuscatedName("n")
   static IndexData[] field3253;
   @ObfuscatedName("y")
   static byte field3254;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 128508459
   )
   public static int field3256;
   @ObfuscatedName("i")
   static RSSocket field3257;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 935391049
   )
   public static int field3258;
   @ObfuscatedName("l")
   static XHashTable field3259;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "([LWorld;II[I[II)V",
      garbageValue = "1521693967"
   )
   static void method4327(World[] var0, int var1, int var2, int[] var3, int[] var4) {
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
                     var11 = var0[var6].method1549()?1:0;
                     var12 = var8.method1549()?1:0;
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
                     var11 = var0[var5].method1549()?1:0;
                     var12 = var8.method1549()?1:0;
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

         method4327(var0, var1, var6, var3, var4);
         method4327(var0, var6 + 1, var2, var3, var4);
      }

   }

   static {
      field3251 = 0;
      field3243 = new XHashTable(4096);
      field3244 = 0;
      field3245 = new XHashTable(32);
      field3246 = 0;
      field3247 = new Node2LinkedList();
      field3259 = new XHashTable(4096);
      field3249 = 0;
      field3250 = new XHashTable(4096);
      field3256 = 0;
      field3252 = new Buffer(8);
      field3248 = 0;
      field3242 = new CRC32();
      field3253 = new IndexData[256];
      field3254 = 0;
      field3258 = 0;
      field3241 = 0;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)LFloorUnderlayDefinition;",
      garbageValue = "2146502676"
   )
   public static FloorUnderlayDefinition method4335(int var0) {
      FloorUnderlayDefinition var1 = (FloorUnderlayDefinition)FloorUnderlayDefinition.field3336.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = FloorUnderlayDefinition.field3334.getConfigData(1, var0);
         var1 = new FloorUnderlayDefinition();
         if(var2 != null) {
            var1.method4422(new Buffer(var2), var0);
         }

         var1.method4423();
         FloorUnderlayDefinition.field3336.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;Ljava/lang/String;Ljava/lang/String;I)LModIcon;",
      garbageValue = "1499282604"
   )
   public static ModIcon method4337(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.method4189(var1);
      int var4 = var0.method4190(var3, var2);
      return class50.method768(var0, var3, var4);
   }
}
