import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("df")
public class class118 {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -399330521
   )
   static int field1839;
   @ObfuscatedName("f")
   static int[][] field1840 = new int[128][128];
   @ObfuscatedName("k")
   static int[][] field1841 = new int[128][128];
   @ObfuscatedName("ne")
   @ObfuscatedGetter(
      intValue = 1808539961
   )
   static int field1842;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1113015609
   )
   static int field1843;
   @ObfuscatedName("ci")
   static class102 field1844;
   @ObfuscatedName("w")
   static int[] field1845 = new int[4096];
   @ObfuscatedName("q")
   static int[] field1848 = new int[4096];
   @ObfuscatedName("qq")
   @ObfuscatedGetter(
      intValue = -1175393685
   )
   protected static int field1849;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Lclass228;B)Ljava/lang/String;",
      garbageValue = "-65"
   )
   public static String method2244(CharSequence var0, class228 var1) {
      if(var0 == null) {
         return null;
      } else {
         int var2 = 0;

         int var3;
         boolean var4;
         char var5;
         for(var3 = var0.length(); var2 < var3; ++var2) {
            var5 = var0.charAt(var2);
            var4 = var5 == 160 || var5 == 32 || var5 == 95 || var5 == 45;
            if(!var4) {
               break;
            }
         }

         while(var3 > var2) {
            var5 = var0.charAt(var3 - 1);
            var4 = var5 == 160 || var5 == 32 || var5 == 95 || var5 == 45;
            if(!var4) {
               break;
            }

            --var3;
         }

         int var14 = var3 - var2;
         if(var14 >= 1 && var14 <= Actor.method585(var1)) {
            StringBuilder var13 = new StringBuilder(var14);

            for(int var6 = var2; var6 < var3; ++var6) {
               char var7 = var0.charAt(var6);
               boolean var8;
               if(Character.isISOControl(var7)) {
                  var8 = false;
               } else {
                  boolean var9 = var7 >= 48 && var7 <= 57 || var7 >= 65 && var7 <= 90 || var7 >= 97 && var7 <= 122;
                  if(var9) {
                     var8 = true;
                  } else {
                     char[] var10 = class204.field3077;
                     int var11 = 0;

                     label128:
                     while(true) {
                        char var12;
                        if(var11 >= var10.length) {
                           var10 = class204.field3078;

                           for(var11 = 0; var11 < var10.length; ++var11) {
                              var12 = var10[var11];
                              if(var7 == var12) {
                                 var8 = true;
                                 break label128;
                              }
                           }

                           var8 = false;
                           break;
                        }

                        var12 = var10[var11];
                        if(var7 == var12) {
                           var8 = true;
                           break;
                        }

                        ++var11;
                     }
                  }
               }

               if(var8) {
                  char var15 = Widget.method3127(var7);
                  if(var15 != 0) {
                     var13.append(var15);
                  }
               }
            }

            if(var13.length() == 0) {
               return null;
            } else {
               return var13.toString();
            }
         } else {
            return null;
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)I",
      garbageValue = "0"
   )
   public static int method2246(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if(var4 <= 127) {
            ++var2;
         } else if(var4 <= 2047) {
            var2 += 2;
         } else {
            var2 += 3;
         }
      }

      return var2;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass159;II)Z",
      garbageValue = "40080473"
   )
   static boolean method2250(class159 var0, int var1) {
      int var2 = var0.method2978(2);
      int var3;
      int var4;
      int var7;
      int var8;
      int var9;
      int var10;
      if(var2 == 0) {
         if(var0.method2978(1) != 0) {
            method2250(var0, var1);
         }

         var3 = var0.method2978(6);
         var4 = var0.method2978(6);
         boolean var12 = var0.method2978(1) == 1;
         if(var12) {
            class45.field917[++class45.field924 - 1] = var1;
         }

         if(Client.cachedPlayers[var1] != null) {
            throw new RuntimeException();
         } else {
            Player var6 = Client.cachedPlayers[var1] = new Player();
            var6.field262 = var1;
            if(class45.field907[var1] != null) {
               var6.method208(class45.field907[var1]);
            }

            var6.field649 = class45.field915[var1];
            var6.interacting = class45.field904[var1];
            var7 = class45.field912[var1];
            var8 = var7 >> 28;
            var9 = var7 >> 14 & 255;
            var10 = var7 & 255;
            var6.field655[0] = class45.field913[var1];
            var6.field261 = (byte)var8;
            var6.method235((var9 << 6) + var3 - class15.baseX, (var10 << 6) + var4 - class20.baseY);
            var6.field263 = false;
            return true;
         }
      } else if(var2 == 1) {
         var3 = var0.method2978(2);
         var4 = class45.field912[var1];
         class45.field912[var1] = (var4 & 268435455) + (((var4 >> 28) + var3 & 3) << 28);
         return false;
      } else {
         int var5;
         int var11;
         if(var2 == 2) {
            var3 = var0.method2978(5);
            var4 = var3 >> 3;
            var5 = var3 & 7;
            var11 = class45.field912[var1];
            var7 = var4 + (var11 >> 28) & 3;
            var8 = var11 >> 14 & 255;
            var9 = var11 & 255;
            if(var5 == 0) {
               --var8;
               --var9;
            }

            if(var5 == 1) {
               --var9;
            }

            if(var5 == 2) {
               ++var8;
               --var9;
            }

            if(var5 == 3) {
               --var8;
            }

            if(var5 == 4) {
               ++var8;
            }

            if(var5 == 5) {
               --var8;
               ++var9;
            }

            if(var5 == 6) {
               ++var9;
            }

            if(var5 == 7) {
               ++var8;
               ++var9;
            }

            class45.field912[var1] = (var8 << 14) + (var7 << 28) + var9;
            return false;
         } else {
            var3 = var0.method2978(18);
            var4 = var3 >> 16;
            var5 = var3 >> 8 & 255;
            var11 = var3 & 255;
            var7 = class45.field912[var1];
            var8 = var4 + (var7 >> 28) & 3;
            var9 = (var7 >> 14) + var5 & 255;
            var10 = var7 + var11 & 255;
            class45.field912[var1] = var10 + (var9 << 14) + (var8 << 28);
            return false;
         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-83108686"
   )
   public static void method2251() {
      NPCComposition.field3000.reset();
      NPCComposition.npcModelCache.reset();
   }
}
