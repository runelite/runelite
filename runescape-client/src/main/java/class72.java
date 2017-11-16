import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("bu")
public class class72 extends class164 {
   @ObfuscatedName("hx")
   @ObfuscatedSignature(
      signature = "Lhx;"
   )
   static Widget field812;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIILfy;I)Z",
      garbageValue = "1851420855"
   )
   protected boolean vmethod3088(int var1, int var2, int var3, CollisionData var4) {
      return var2 == super.field2210 && var3 == super.field2209;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "334477629"
   )
   public static int method1061(int var0, int var1, int var2) {
      var2 &= 3;
      return var2 == 0?var0:(var2 == 1?var1:(var2 == 2?7 - var0:7 - var1));
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "([Lcg;II[I[II)V",
      garbageValue = "807094593"
   )
   static void method1060(World[] var0, int var1, int var2, int[] var3, int[] var4) {
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
                     var11 = var0[var6].method1516()?1:0;
                     var12 = var8.method1516()?1:0;
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
                     var11 = var0[var5].method1516()?1:0;
                     var12 = var8.method1516()?1:0;
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

         method1060(var0, var1, var6, var3, var4);
         method1060(var0, var6 + 1, var2, var3, var4);
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lij;Ljava/lang/String;Ljava/lang/String;I)Lks;",
      garbageValue = "1644041863"
   )
   @Export("getSprite")
   public static IndexedSprite getSprite(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      return class60.method971(var0, var3, var4);
   }

   @ObfuscatedName("iy")
   @ObfuscatedSignature(
      signature = "(Lhx;III)V",
      garbageValue = "1087412745"
   )
   static void method1055(Widget var0, int var1, int var2) {
      if(var0.field2718 == 0) {
         var0.relativeX = var0.originalX;
      } else if(var0.field2718 == 1) {
         var0.relativeX = var0.originalX + (var1 - var0.width) / 2;
      } else if(var0.field2718 == 2) {
         var0.relativeX = var1 - var0.width - var0.originalX;
      } else if(var0.field2718 == 3) {
         var0.relativeX = var0.originalX * var1 >> 14;
      } else if(var0.field2718 == 4) {
         var0.relativeX = (var1 - var0.width) / 2 + (var0.originalX * var1 >> 14);
      } else {
         var0.relativeX = var1 - var0.width - (var0.originalX * var1 >> 14);
      }

      if(var0.field2721 == 0) {
         var0.relativeY = var0.originalY;
      } else if(var0.field2721 == 1) {
         var0.relativeY = (var2 - var0.height) / 2 + var0.originalY;
      } else if(var0.field2721 == 2) {
         var0.relativeY = var2 - var0.height - var0.originalY;
      } else if(var0.field2721 == 3) {
         var0.relativeY = var2 * var0.originalY >> 14;
      } else if(var0.field2721 == 4) {
         var0.relativeY = (var2 * var0.originalY >> 14) + (var2 - var0.height) / 2;
      } else {
         var0.relativeY = var2 - var0.height - (var2 * var0.originalY >> 14);
      }

      if(Client.field1017 && var0.type == 0) {
         if(var0.relativeX < 0) {
            var0.relativeX = 0;
         } else if(var0.relativeX + var0.width > var1) {
            var0.relativeX = var1 - var0.width;
         }

         if(var0.relativeY < 0) {
            var0.relativeY = 0;
         } else if(var0.height + var0.relativeY > var2) {
            var0.relativeY = var2 - var0.height;
         }
      }

   }

   @ObfuscatedName("ja")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-607587965"
   )
   static void method1054(String var0) {
      SoundTask.sessionToken = var0;

      try {
         String var1 = class289.clientInstance.getParameter(Parameters.field3765.key);
         String var2 = class289.clientInstance.getParameter(Parameters.field3766.key);
         String var3 = var1 + "settings=" + var0 + "; version=1; path=/; domain=" + var2;
         String var5;
         if(var0.length() == 0) {
            var3 = var3 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
         } else {
            String var4 = var3 + "; Expires=";
            long var6 = ChatLineBuffer.currentTimeMs() + 94608000000L;
            class189.field2530.setTime(new Date(var6));
            int var8 = class189.field2530.get(7);
            int var9 = class189.field2530.get(5);
            int var10 = class189.field2530.get(2);
            int var11 = class189.field2530.get(1);
            int var12 = class189.field2530.get(11);
            int var13 = class189.field2530.get(12);
            int var14 = class189.field2530.get(13);
            var5 = class189.field2526[var8 - 1] + ", " + var9 / 10 + var9 % 10 + "-" + class189.field2528[0][var10] + "-" + var11 + " " + var12 / 10 + var12 % 10 + ":" + var13 / 10 + var13 % 10 + ":" + var14 / 10 + var14 % 10 + " GMT";
            var3 = var4 + var5 + "; Max-Age=" + 94608000L;
         }

         Client var16 = class289.clientInstance;
         var5 = "document.cookie=\"" + var3 + "\"";
         JSObject.getWindow(var16).eval(var5);
      } catch (Throwable var15) {
         ;
      }

   }
}
