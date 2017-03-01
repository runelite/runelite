import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("k")
@Implements("ScriptState")
public class ScriptState {
   @ObfuscatedName("y")
   static ModIcon[] field95;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1266706205
   )
   int field96 = -1;
   @ObfuscatedName("v")
   String[] field98;
   @ObfuscatedName("g")
   int[] field102;
   @ObfuscatedName("x")
   Script field105;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)LWorld;",
      garbageValue = "-50"
   )
   static World method159() {
      return World.field676 < World.field675?CombatInfoListHolder.worldList[++World.field676 - 1]:null;
   }

   @ObfuscatedName("ch")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;LWidget;I)Ljava/lang/String;",
      garbageValue = "-291213518"
   )
   static String method160(String var0, Widget var1) {
      if(var0.indexOf("%") != -1) {
         int var2;
         for(var2 = 1; var2 <= 5; ++var2) {
            while(true) {
               int var6 = var0.indexOf("%" + var2);
               if(var6 == -1) {
                  break;
               }

               var0 = var0.substring(0, var6) + class112.method2184(class187.method3509(var1, var2 - 1)) + var0.substring(2 + var6);
            }
         }

         while(true) {
            var2 = var0.indexOf("%dns");
            if(var2 == -1) {
               break;
            }

            String var3 = "";
            if(null != class85.field1466) {
               int var5 = class85.field1466.field1671;
               String var4 = (var5 >> 24 & 255) + "." + (var5 >> 16 & 255) + "." + (var5 >> 8 & 255) + "." + (var5 & 255);
               var3 = var4;
               if(null != class85.field1466.field1674) {
                  var3 = (String)class85.field1466.field1674;
               }
            }

            var0 = var0.substring(0, var2) + var3 + var0.substring(var2 + 4);
         }
      }

      return var0;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "-1188173306"
   )
   static int method161(int var0, Script var1, boolean var2) {
      int var4 = -1;
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var4 = class32.field726[--class32.field735];
         var3 = ChatLineBuffer.method993(var4);
      } else {
         var3 = var2?class32.field731:class108.field1738;
      }

      if(var0 == 1100) {
         class32.field735 -= 2;
         var3.scrollX = class32.field726[class32.field735];
         if(var3.scrollX > var3.scrollWidth - var3.width) {
            var3.scrollX = var3.scrollWidth - var3.width;
         }

         if(var3.scrollX < 0) {
            var3.scrollX = 0;
         }

         var3.scrollY = class32.field726[class32.field735 + 1];
         if(var3.scrollY > var3.scrollHeight - var3.height) {
            var3.scrollY = var3.scrollHeight - var3.height;
         }

         if(var3.scrollY < 0) {
            var3.scrollY = 0;
         }

         ChatLineBuffer.method996(var3);
         return 1;
      } else if(var0 == 1101) {
         var3.textColor = class32.field726[--class32.field735];
         ChatLineBuffer.method996(var3);
         return 1;
      } else if(var0 == 1102) {
         var3.field2261 = class32.field726[--class32.field735] == 1;
         ChatLineBuffer.method996(var3);
         return 1;
      } else if(var0 == 1103) {
         var3.opacity = class32.field726[--class32.field735];
         ChatLineBuffer.method996(var3);
         return 1;
      } else if(var0 == 1104) {
         var3.field2239 = class32.field726[--class32.field735];
         ChatLineBuffer.method996(var3);
         return 1;
      } else if(var0 == 1105) {
         var3.textureId = class32.field726[--class32.field735];
         ChatLineBuffer.method996(var3);
         return 1;
      } else if(var0 == 1106) {
         var3.field2291 = class32.field726[--class32.field735];
         ChatLineBuffer.method996(var3);
         return 1;
      } else if(var0 == 1107) {
         var3.field2244 = class32.field726[--class32.field735] == 1;
         ChatLineBuffer.method996(var3);
         return 1;
      } else if(var0 == 1108) {
         var3.modelType = 1;
         var3.modelId = class32.field726[--class32.field735];
         ChatLineBuffer.method996(var3);
         return 1;
      } else if(var0 == 1109) {
         class32.field735 -= 6;
         var3.field2255 = class32.field726[class32.field735];
         var3.field2256 = class32.field726[1 + class32.field735];
         var3.rotationX = class32.field726[2 + class32.field735];
         var3.rotationZ = class32.field726[3 + class32.field735];
         var3.rotationY = class32.field726[4 + class32.field735];
         var3.field2260 = class32.field726[class32.field735 + 5];
         ChatLineBuffer.method996(var3);
         return 1;
      } else {
         int var5;
         if(var0 == 1110) {
            var5 = class32.field726[--class32.field735];
            if(var3.field2233 != var5) {
               var3.field2233 = var5;
               var3.field2328 = 0;
               var3.field2329 = 0;
               ChatLineBuffer.method996(var3);
            }

            return 1;
         } else if(var0 == 1111) {
            var3.field2263 = class32.field726[--class32.field735] == 1;
            ChatLineBuffer.method996(var3);
            return 1;
         } else if(var0 == 1112) {
            String var7 = class32.scriptStringStack[--class30.scriptStringStackSize];
            if(!var7.equals(var3.text)) {
               var3.text = var7;
               ChatLineBuffer.method996(var3);
            }

            return 1;
         } else if(var0 == 1113) {
            var3.fontId = class32.field726[--class32.field735];
            ChatLineBuffer.method996(var3);
            return 1;
         } else if(var0 == 1114) {
            class32.field735 -= 3;
            var3.field2269 = class32.field726[class32.field735];
            var3.field2270 = class32.field726[class32.field735 + 1];
            var3.field2268 = class32.field726[2 + class32.field735];
            ChatLineBuffer.method996(var3);
            return 1;
         } else if(var0 == 1115) {
            var3.field2271 = class32.field726[--class32.field735] == 1;
            ChatLineBuffer.method996(var3);
            return 1;
         } else if(var0 == 1116) {
            var3.borderThickness = class32.field726[--class32.field735];
            ChatLineBuffer.method996(var3);
            return 1;
         } else if(var0 == 1117) {
            var3.sprite2 = class32.field726[--class32.field735];
            ChatLineBuffer.method996(var3);
            return 1;
         } else if(var0 == 1118) {
            var3.flippedVertically = class32.field726[--class32.field735] == 1;
            ChatLineBuffer.method996(var3);
            return 1;
         } else if(var0 == 1119) {
            var3.flippedHorizontally = class32.field726[--class32.field735] == 1;
            ChatLineBuffer.method996(var3);
            return 1;
         } else if(var0 == 1120) {
            class32.field735 -= 2;
            var3.scrollWidth = class32.field726[class32.field735];
            var3.scrollHeight = class32.field726[class32.field735 + 1];
            ChatLineBuffer.method996(var3);
            if(var4 != -1 && var3.type == 0) {
               Script.method973(class231.widgets[var4 >> 16], var3, false);
            }

            return 1;
         } else if(var0 == 1121) {
            class107.method2127(var3.id, var3.index);
            Client.field543 = var3;
            ChatLineBuffer.method996(var3);
            return 1;
         } else if(var0 == 1122) {
            var3.field2231 = class32.field726[--class32.field735];
            ChatLineBuffer.method996(var3);
            return 1;
         } else if(var0 == 1123) {
            var3.field2232 = class32.field726[--class32.field735];
            ChatLineBuffer.method996(var3);
            return 1;
         } else if(var0 == 1124) {
            var3.field2196 = class32.field726[--class32.field735];
            ChatLineBuffer.method996(var3);
            return 1;
         } else if(var0 == 1125) {
            var5 = class32.field726[--class32.field735];
            class221 var6 = (class221)Ignore.method207(class211.method3997(), var5);
            if(null != var6) {
               var3.field2236 = var6;
               ChatLineBuffer.method996(var3);
            }

            return 1;
         } else {
            return 2;
         }
      }
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(LActor;II)V",
      garbageValue = "-589448106"
   )
   static final void method163(Actor var0, int var1) {
      class39.method823(var0.x, var0.y, var1);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-86"
   )
   static final void method164(int var0, int var1, int var2, int var3) {
      for(int var4 = var1; var4 <= var3 + var1; ++var4) {
         for(int var5 = var0; var5 <= var0 + var2; ++var5) {
            if(var5 >= 0 && var5 < 104 && var4 >= 0 && var4 < 104) {
               class10.field83[0][var5][var4] = 127;
               if(var0 == var5 && var5 > 0) {
                  class10.tileHeights[0][var5][var4] = class10.tileHeights[0][var5 - 1][var4];
               }

               if(var0 + var2 == var5 && var5 < 103) {
                  class10.tileHeights[0][var5][var4] = class10.tileHeights[0][1 + var5][var4];
               }

               if(var1 == var4 && var4 > 0) {
                  class10.tileHeights[0][var5][var4] = class10.tileHeights[0][var5][var4 - 1];
               }

               if(var1 + var3 == var4 && var4 < 103) {
                  class10.tileHeights[0][var5][var4] = class10.tileHeights[0][var5][1 + var4];
               }
            }
         }
      }

   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "-194853623"
   )
   static final byte[] method165(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      int var2 = var1.readUnsignedByte();
      int var3 = var1.readInt();
      if(var3 >= 0 && (class182.field2724 == 0 || var3 <= class182.field2724)) {
         if(var2 == 0) {
            byte[] var6 = new byte[var3];
            var1.method2897(var6, 0, var3);
            return var6;
         } else {
            int var4 = var1.readInt();
            if(var4 >= 0 && (class182.field2724 == 0 || var4 <= class182.field2724)) {
               byte[] var5 = new byte[var4];
               if(var2 == 1) {
                  class147.method2817(var5, var4, var0, var3, 9);
               } else {
                  class182.field2720.method2812(var1, var5);
               }

               return var5;
            } else {
               throw new RuntimeException();
            }
         }
      } else {
         throw new RuntimeException();
      }
   }
}
