import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ac")
@Implements("ChatLineBuffer")
public class ChatLineBuffer {
   @ObfuscatedName("i")
   @Export("lines")
   MessageNode[] lines = new MessageNode[100];
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1278580245
   )
   @Export("length")
   int length;
   @ObfuscatedName("ac")
   @Export("indexConfigs")
   static IndexData indexConfigs;
   @ObfuscatedName("af")
   static IndexData field990;
   @ObfuscatedName("l")
   static int[] field994;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;B)LMessageNode;",
      garbageValue = "118"
   )
   MessageNode method930(int var1, String var2, String var3, String var4) {
      MessageNode var5 = this.lines[99];

      for(int var6 = this.length; var6 > 0; --var6) {
         if(var6 != 100) {
            this.lines[var6] = this.lines[var6 - 1];
         }
      }

      if(var5 == null) {
         var5 = new MessageNode(var1, var2, var4, var3);
      } else {
         var5.unlink();
         var5.method2495();
         var5.method190(var1, var2, var4, var3);
      }

      this.lines[0] = var5;
      if(this.length < 100) {
         ++this.length;
      }

      return var5;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "927943211"
   )
   int method932() {
      return this.length;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)LMessageNode;",
      garbageValue = "1863734625"
   )
   MessageNode method934(int var1) {
      return var1 >= 0 && var1 < this.length?this.lines[var1]:null;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(LCipherBuffer;S)I",
      garbageValue = "4225"
   )
   static int method938(CipherBuffer var0) {
      int var1 = var0.method3111(2);
      int var2;
      if(var1 == 0) {
         var2 = 0;
      } else if(var1 == 1) {
         var2 = var0.method3111(5);
      } else if(var1 == 2) {
         var2 = var0.method3111(8);
      } else {
         var2 = var0.method3111(11);
      }

      return var2;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;II)I",
      garbageValue = "-820159529"
   )
   public static int method939(CharSequence var0, CharSequence var1, int var2) {
      int var3 = var0.length();
      int var4 = var1.length();
      int var5 = 0;
      int var6 = 0;
      byte var7 = 0;
      byte var8 = 0;

      while(var5 - var7 < var3 || var6 - var8 < var4) {
         if(var5 - var7 >= var3) {
            return -1;
         }

         if(var6 - var8 >= var4) {
            return 1;
         }

         char var9;
         if(var7 != 0) {
            var9 = (char)var7;
            boolean var10 = false;
         } else {
            var9 = var0.charAt(var5++);
         }

         char var14;
         if(var8 != 0) {
            var14 = (char)var8;
            boolean var11 = false;
         } else {
            var14 = var1.charAt(var6++);
         }

         byte var16;
         if(var9 == 198) {
            var16 = 69;
         } else if(var9 == 230) {
            var16 = 101;
         } else if(var9 == 223) {
            var16 = 115;
         } else if(var9 == 338) {
            var16 = 69;
         } else if(var9 == 339) {
            var16 = 101;
         } else {
            var16 = 0;
         }

         var7 = var16;
         byte var12;
         if(var14 == 198) {
            var12 = 69;
         } else if(var14 == 230) {
            var12 = 101;
         } else if(var14 == 223) {
            var12 = 115;
         } else if(var14 == 338) {
            var12 = 69;
         } else if(var14 == 339) {
            var12 = 101;
         } else {
            var12 = 0;
         }

         var8 = var12;
         var9 = class183.method3411(var9, var2);
         var14 = class183.method3411(var14, var2);
         if(var14 != var9 && Character.toUpperCase(var9) != Character.toUpperCase(var14)) {
            var9 = Character.toLowerCase(var9);
            var14 = Character.toLowerCase(var14);
            if(var14 != var9) {
               return Player.method227(var9, var2) - Player.method227(var14, var2);
            }
         }
      }

      int var15 = Math.min(var3, var4);

      int var17;
      char var18;
      for(var17 = 0; var17 < var15; ++var17) {
         char var19 = var0.charAt(var17);
         var18 = var1.charAt(var17);
         if(var18 != var19 && Character.toUpperCase(var19) != Character.toUpperCase(var18)) {
            var19 = Character.toLowerCase(var19);
            var18 = Character.toLowerCase(var18);
            if(var18 != var19) {
               return Player.method227(var19, var2) - Player.method227(var18, var2);
            }
         }
      }

      var17 = var3 - var4;
      if(var17 != 0) {
         return var17;
      } else {
         for(int var20 = 0; var20 < var15; ++var20) {
            var18 = var0.charAt(var20);
            char var13 = var1.charAt(var20);
            if(var18 != var13) {
               return Player.method227(var18, var2) - Player.method227(var13, var2);
            }
         }

         return 0;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IZI)Z",
      garbageValue = "-1789374621"
   )
   static boolean method940(CharSequence var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         boolean var3 = false;
         boolean var4 = false;
         int var5 = 0;
         int var6 = var0.length();

         for(int var7 = 0; var7 < var6; ++var7) {
            char var8 = var0.charAt(var7);
            if(var7 == 0) {
               if(var8 == 45) {
                  var3 = true;
                  continue;
               }

               if(var8 == 43) {
                  continue;
               }
            }

            int var9;
            if(var8 >= 48 && var8 <= 57) {
               var9 = var8 - 48;
            } else if(var8 >= 65 && var8 <= 90) {
               var9 = var8 - 55;
            } else {
               if(var8 < 97 || var8 > 122) {
                  return false;
               }

               var9 = var8 - 87;
            }

            if(var9 >= var1) {
               return false;
            }

            if(var3) {
               var9 = -var9;
            }

            int var10 = var9 + var1 * var5;
            if(var10 / var1 != var5) {
               return false;
            }

            var5 = var10;
            var4 = true;
         }

         return var4;
      } else {
         throw new IllegalArgumentException("");
      }
   }
}
