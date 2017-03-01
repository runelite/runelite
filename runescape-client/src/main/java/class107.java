import java.io.File;
import java.util.Hashtable;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dj")
public class class107 {
   @ObfuscatedName("n")
   public static File field1733;
   @ObfuscatedName("x")
   public static boolean field1734 = false;
   @ObfuscatedName("g")
   static Hashtable field1736 = new Hashtable(16);

   class107() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "-641598420"
   )
   static final void method2125(int var0, int var1, int var2, int var3, int var4) {
      int var5 = Friend.region.method1815(var0, var1, var2);
      int var6;
      int var7;
      int var8;
      int var9;
      int var11;
      int var17;
      if(var5 != 0) {
         var6 = Friend.region.method1924(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var3;
         if(var5 > 0) {
            var9 = var4;
         }

         int[] var10 = class26.field595.image;
         var11 = 2048 * (103 - var2) + 24624 + 4 * var1;
         var17 = var5 >> 14 & 32767;
         ObjectComposition var19 = ChatMessages.getObjectDefinition(var17);
         if(var19.mapSceneId != -1) {
            ModIcon var14 = class143.field2002[var19.mapSceneId];
            if(var14 != null) {
               int var15 = (var19.sizeX * 4 - var14.originalWidth) / 2;
               int var16 = (var19.sizeY * 4 - var14.height) / 2;
               var14.method4115(var15 + var1 * 4 + 48, 48 + (104 - var2 - var19.sizeY) * 4 + var16);
            }
         } else {
            if(var8 == 0 || var8 == 2) {
               if(var7 == 0) {
                  var10[var11] = var9;
                  var10[var11 + 512] = var9;
                  var10[var11 + 1024] = var9;
                  var10[1536 + var11] = var9;
               } else if(var7 == 1) {
                  var10[var11] = var9;
                  var10[1 + var11] = var9;
                  var10[var11 + 2] = var9;
                  var10[var11 + 3] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 3] = var9;
                  var10[512 + 3 + var11] = var9;
                  var10[3 + var11 + 1024] = var9;
                  var10[var11 + 3 + 1536] = var9;
               } else if(var7 == 3) {
                  var10[var11 + 1536] = var9;
                  var10[1 + 1536 + var11] = var9;
                  var10[2 + var11 + 1536] = var9;
                  var10[3 + 1536 + var11] = var9;
               }
            }

            if(var8 == 3) {
               if(var7 == 0) {
                  var10[var11] = var9;
               } else if(var7 == 1) {
                  var10[var11 + 3] = var9;
               } else if(var7 == 2) {
                  var10[1536 + var11 + 3] = var9;
               } else if(var7 == 3) {
                  var10[var11 + 1536] = var9;
               }
            }

            if(var8 == 2) {
               if(var7 == 3) {
                  var10[var11] = var9;
                  var10[var11 + 512] = var9;
                  var10[1024 + var11] = var9;
                  var10[1536 + var11] = var9;
               } else if(var7 == 0) {
                  var10[var11] = var9;
                  var10[1 + var11] = var9;
                  var10[var11 + 2] = var9;
                  var10[3 + var11] = var9;
               } else if(var7 == 1) {
                  var10[3 + var11] = var9;
                  var10[3 + var11 + 512] = var9;
                  var10[1024 + 3 + var11] = var9;
                  var10[1536 + 3 + var11] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 1536] = var9;
                  var10[var11 + 1536 + 1] = var9;
                  var10[var11 + 1536 + 2] = var9;
                  var10[var11 + 1536 + 3] = var9;
               }
            }
         }
      }

      var5 = Friend.region.method1925(var0, var1, var2);
      if(var5 != 0) {
         var6 = Friend.region.method1924(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var5 >> 14 & 32767;
         ObjectComposition var23 = ChatMessages.getObjectDefinition(var9);
         int var13;
         if(var23.mapSceneId != -1) {
            ModIcon var18 = class143.field2002[var23.mapSceneId];
            if(var18 != null) {
               var17 = (var23.sizeX * 4 - var18.originalWidth) / 2;
               var13 = (var23.sizeY * 4 - var18.height) / 2;
               var18.method4115(4 * var1 + 48 + var17, 48 + (104 - var2 - var23.sizeY) * 4 + var13);
            }
         } else if(var8 == 9) {
            var11 = 15658734;
            if(var5 > 0) {
               var11 = 15597568;
            }

            int[] var12 = class26.field595.image;
            var13 = 4 * var1 + 24624 + (103 - var2) * 2048;
            if(var7 != 0 && var7 != 2) {
               var12[var13] = var11;
               var12[var13 + 512 + 1] = var11;
               var12[2 + var13 + 1024] = var11;
               var12[3 + 1536 + var13] = var11;
            } else {
               var12[1536 + var13] = var11;
               var12[1 + var13 + 1024] = var11;
               var12[2 + 512 + var13] = var11;
               var12[var13 + 3] = var11;
            }
         }
      }

      var5 = Friend.region.method1831(var0, var1, var2);
      if(var5 != 0) {
         var6 = var5 >> 14 & 32767;
         ObjectComposition var20 = ChatMessages.getObjectDefinition(var6);
         if(var20.mapSceneId != -1) {
            ModIcon var21 = class143.field2002[var20.mapSceneId];
            if(var21 != null) {
               var9 = (var20.sizeX * 4 - var21.originalWidth) / 2;
               int var22 = (var20.sizeY * 4 - var21.height) / 2;
               var21.method4115(4 * var1 + 48 + var9, var22 + 48 + (104 - var2 - var20.sizeY) * 4);
            }
         }
      }

   }

   @ObfuscatedName("ck")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "40561144"
   )
   static void method2127(int var0, int var1) {
      Client.field332.method3144(2);
      Client.field332.method2940(var1);
      Client.field332.method2930(var0);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(CB)C",
      garbageValue = "-78"
   )
   static char method2128(char var0) {
      switch(var0) {
      case ' ':
      case '-':
      case '_':
      case ' ':
         return '_';
      case '#':
      case '[':
      case ']':
         return var0;
      case 'À':
      case 'Á':
      case 'Â':
      case 'Ã':
      case 'Ä':
      case 'à':
      case 'á':
      case 'â':
      case 'ã':
      case 'ä':
         return 'a';
      case 'Ç':
      case 'ç':
         return 'c';
      case 'È':
      case 'É':
      case 'Ê':
      case 'Ë':
      case 'è':
      case 'é':
      case 'ê':
      case 'ë':
         return 'e';
      case 'Í':
      case 'Î':
      case 'Ï':
      case 'í':
      case 'î':
      case 'ï':
         return 'i';
      case 'Ñ':
      case 'ñ':
         return 'n';
      case 'Ò':
      case 'Ó':
      case 'Ô':
      case 'Õ':
      case 'Ö':
      case 'ò':
      case 'ó':
      case 'ô':
      case 'õ':
      case 'ö':
         return 'o';
      case 'Ù':
      case 'Ú':
      case 'Û':
      case 'Ü':
      case 'ù':
      case 'ú':
      case 'û':
      case 'ü':
         return 'u';
      case 'ß':
         return 'b';
      case 'ÿ':
      case 'Ÿ':
         return 'y';
      default:
         return Character.toLowerCase(var0);
      }
   }
}
