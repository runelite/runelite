import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bm")
@Implements("ScriptEvent")
public class ScriptEvent extends Node {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lhn;"
   )
   class220 field863;
   @ObfuscatedName("j")
   Object[] field856;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lhi;"
   )
   @Export("widget")
   Widget widget;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1411916729
   )
   int field857;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 747456331
   )
   int field858;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lhi;"
   )
   Widget field860;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1573275857
   )
   int field864;
   @ObfuscatedName("b")
   String field854;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1693541631
   )
   int field859;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1156687709
   )
   int field861;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 291139189
   )
   int field862;
   @ObfuscatedName("h")
   boolean field865;

   public ScriptEvent() {
      this.field863 = class220.field2797;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/Object;B)V",
      garbageValue = "68"
   )
   public void method1161(Object[] var1) {
      this.field856 = var1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lhn;S)V",
      garbageValue = "-27859"
   )
   public void method1162(class220 var1) {
      this.field863 = var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([BIII)Ljava/lang/String;",
      garbageValue = "899422762"
   )
   @Export("getString")
   public static String getString(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         int var6 = var0[var5 + var1] & 255;
         if(var6 != 0) {
            if(var6 >= 128 && var6 < 160) {
               char var7 = class267.field3650[var6 - 128];
               if(var7 == 0) {
                  var7 = 63;
               }

               var6 = var7;
            }

            var3[var4++] = (char)var6;
         }
      }

      return new String(var3, 0, var4);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "([Lch;II[I[II)V",
      garbageValue = "-1852514334"
   )
   static void method1163(World[] var0, int var1, int var2, int[] var3, int[] var4) {
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
                     var11 = var0[var6].method1579()?1:0;
                     var12 = var8.method1579()?1:0;
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
                     var11 = var0[var5].method1579()?1:0;
                     var12 = var8.method1579()?1:0;
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

         method1163(var0, var1, var6, var3, var4);
         method1163(var0, var6 + 1, var2, var3, var4);
      }

   }
}
