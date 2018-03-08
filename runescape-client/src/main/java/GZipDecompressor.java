import java.util.zip.Inflater;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gs")
@Implements("GZipDecompressor")
public class GZipDecompressor {
   @ObfuscatedName("t")
   @Export("inflator")
   Inflater inflator;

   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1000000"
   )
   GZipDecompressor(int var1, int var2, int var3) {
   }

   public GZipDecompressor() {
      this(-1, 1000000, 1000000);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lgb;[BI)V",
      garbageValue = "539584997"
   )
   @Export("decompress")
   public void decompress(Buffer var1, byte[] var2) {
      if(var1.payload[var1.offset] == 31 && var1.payload[var1.offset + 1] == -117) {
         if(this.inflator == null) {
            this.inflator = new Inflater(true);
         }

         try {
            this.inflator.setInput(var1.payload, var1.offset + 10, var1.payload.length - (var1.offset + 8 + 10));
            this.inflator.inflate(var2);
         } catch (Exception var4) {
            this.inflator.reset();
            throw new RuntimeException("");
         }

         this.inflator.reset();
      } else {
         throw new RuntimeException("");
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IS)Lig;",
      garbageValue = "5552"
   )
   @Export("getWidget")
   public static Widget getWidget(int var0) {
      int var1 = var0 >> 16;
      int var2 = var0 & 65535;
      if(Widget.widgets[var1] == null || Widget.widgets[var1][var2] == null) {
         boolean var3 = Script.loadWidget(var1);
         if(!var3) {
            return null;
         }
      }

      return Widget.widgets[var1][var2];
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Liw;I)Z",
      garbageValue = "-1386742273"
   )
   public static boolean method3472(class245 var0) {
      return class245.field2965 == var0 || class245.field2964 == var0 || class245.field2957 == var0 || class245.field2958 == var0 || class245.field2955 == var0 || class245.field2960 == var0 || class245.field2956 == var0 || class245.field2962 == var0;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(ILcj;ZI)I",
      garbageValue = "1551700936"
   )
   static int method3475(int var0, Script var1, boolean var2) {
      int var4 = -1;
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var4 = class81.intStack[--class5.intStackSize];
         var3 = getWidget(var4);
      } else {
         var3 = var2?class233.field2755:class81.field1260;
      }

      if(var0 == 1100) {
         class5.intStackSize -= 2;
         var3.scrollX = class81.intStack[class5.intStackSize];
         if(var3.scrollX > var3.scrollWidth - var3.width) {
            var3.scrollX = var3.scrollWidth - var3.width;
         }

         if(var3.scrollX < 0) {
            var3.scrollX = 0;
         }

         var3.scrollY = class81.intStack[class5.intStackSize + 1];
         if(var3.scrollY > var3.scrollHeight - var3.height) {
            var3.scrollY = var3.scrollHeight - var3.height;
         }

         if(var3.scrollY < 0) {
            var3.scrollY = 0;
         }

         GameEngine.method1053(var3);
         return 1;
      } else if(var0 == 1101) {
         var3.textColor = class81.intStack[--class5.intStackSize];
         GameEngine.method1053(var3);
         return 1;
      } else if(var0 == 1102) {
         var3.filled = class81.intStack[--class5.intStackSize] == 1;
         GameEngine.method1053(var3);
         return 1;
      } else if(var0 == 1103) {
         var3.opacity = class81.intStack[--class5.intStackSize];
         GameEngine.method1053(var3);
         return 1;
      } else if(var0 == 1104) {
         var3.lineWidth = class81.intStack[--class5.intStackSize];
         GameEngine.method1053(var3);
         return 1;
      } else if(var0 == 1105) {
         var3.spriteId = class81.intStack[--class5.intStackSize];
         GameEngine.method1053(var3);
         return 1;
      } else if(var0 == 1106) {
         var3.textureId = class81.intStack[--class5.intStackSize];
         GameEngine.method1053(var3);
         return 1;
      } else if(var0 == 1107) {
         var3.spriteTiling = class81.intStack[--class5.intStackSize] == 1;
         GameEngine.method1053(var3);
         return 1;
      } else if(var0 == 1108) {
         var3.modelType = 1;
         var3.modelId = class81.intStack[--class5.intStackSize];
         GameEngine.method1053(var3);
         return 1;
      } else if(var0 == 1109) {
         class5.intStackSize -= 6;
         var3.field2866 = class81.intStack[class5.intStackSize];
         var3.field2867 = class81.intStack[class5.intStackSize + 1];
         var3.rotationX = class81.intStack[class5.intStackSize + 2];
         var3.rotationZ = class81.intStack[class5.intStackSize + 3];
         var3.rotationY = class81.intStack[class5.intStackSize + 4];
         var3.modelZoom = class81.intStack[class5.intStackSize + 5];
         GameEngine.method1053(var3);
         return 1;
      } else {
         int var9;
         if(var0 == 1110) {
            var9 = class81.intStack[--class5.intStackSize];
            if(var9 != var3.field2838) {
               var3.field2838 = var9;
               var3.field2939 = 0;
               var3.field2940 = 0;
               GameEngine.method1053(var3);
            }

            return 1;
         } else if(var0 == 1111) {
            var3.field2874 = class81.intStack[--class5.intStackSize] == 1;
            GameEngine.method1053(var3);
            return 1;
         } else if(var0 == 1112) {
            String var8 = class81.scriptStringStack[--class316.scriptStringStackSize];
            if(!var8.equals(var3.text)) {
               var3.text = var8;
               GameEngine.method1053(var3);
            }

            return 1;
         } else if(var0 == 1113) {
            var3.fontId = class81.intStack[--class5.intStackSize];
            GameEngine.method1053(var3);
            return 1;
         } else if(var0 == 1114) {
            class5.intStackSize -= 3;
            var3.field2827 = class81.intStack[class5.intStackSize];
            var3.field2881 = class81.intStack[class5.intStackSize + 1];
            var3.field2813 = class81.intStack[class5.intStackSize + 2];
            GameEngine.method1053(var3);
            return 1;
         } else if(var0 == 1115) {
            var3.textShadowed = class81.intStack[--class5.intStackSize] == 1;
            GameEngine.method1053(var3);
            return 1;
         } else if(var0 == 1116) {
            var3.borderThickness = class81.intStack[--class5.intStackSize];
            GameEngine.method1053(var3);
            return 1;
         } else if(var0 == 1117) {
            var3.sprite2 = class81.intStack[--class5.intStackSize];
            GameEngine.method1053(var3);
            return 1;
         } else if(var0 == 1118) {
            var3.flippedVertically = class81.intStack[--class5.intStackSize] == 1;
            GameEngine.method1053(var3);
            return 1;
         } else if(var0 == 1119) {
            var3.flippedHorizontally = class81.intStack[--class5.intStackSize] == 1;
            GameEngine.method1053(var3);
            return 1;
         } else if(var0 == 1120) {
            class5.intStackSize -= 2;
            var3.scrollWidth = class81.intStack[class5.intStackSize];
            var3.scrollHeight = class81.intStack[class5.intStackSize + 1];
            GameEngine.method1053(var3);
            if(var4 != -1 && var3.type == 0) {
               GameEngine.method1051(Widget.widgets[var4 >> 16], var3, false);
            }

            return 1;
         } else if(var0 == 1121) {
            class270.method4793(var3.id, var3.index);
            Client.field1012 = var3;
            GameEngine.method1053(var3);
            return 1;
         } else if(var0 == 1122) {
            var3.field2880 = class81.intStack[--class5.intStackSize];
            GameEngine.method1053(var3);
            return 1;
         } else if(var0 == 1123) {
            var3.field2879 = class81.intStack[--class5.intStackSize];
            GameEngine.method1053(var3);
            return 1;
         } else if(var0 == 1124) {
            var3.field2952 = class81.intStack[--class5.intStackSize];
            GameEngine.method1053(var3);
            return 1;
         } else if(var0 == 1125) {
            var9 = class81.intStack[--class5.intStackSize];
            class329[] var6 = new class329[]{class329.field3968, class329.field3970, class329.field3971, class329.field3969, class329.field3973};
            class329 var7 = (class329)WorldMapRectangle.forOrdinal(var6, var9);
            if(var7 != null) {
               var3.field2808 = var7;
               GameEngine.method1053(var3);
            }

            return 1;
         } else if(var0 == 1126) {
            boolean var5 = class81.intStack[--class5.intStackSize] == 1;
            var3.field2851 = var5;
            return 1;
         } else {
            return 2;
         }
      }
   }

   @ObfuscatedName("fv")
   @ObfuscatedSignature(
      signature = "(Lbi;IIS)V",
      garbageValue = "2000"
   )
   static void method3473(Player var0, int var1, int var2) {
      if(var0.animation == var1 && var1 != -1) {
         int var3 = class158.getAnimation(var1).replyMode;
         if(var3 == 1) {
            var0.actionFrame = 0;
            var0.field1140 = 0;
            var0.actionAnimationDisable = var2;
            var0.field1186 = 0;
         }

         if(var3 == 2) {
            var0.field1186 = 0;
         }
      } else if(var1 == -1 || var0.animation == -1 || class158.getAnimation(var1).forcedPriority >= class158.getAnimation(var0.animation).forcedPriority) {
         var0.animation = var1;
         var0.actionFrame = 0;
         var0.field1140 = 0;
         var0.actionAnimationDisable = var2;
         var0.field1186 = 0;
         var0.field1196 = var0.queueSize;
      }

   }

   @ObfuscatedName("hq")
   @ObfuscatedSignature(
      signature = "(Lbl;I)V",
      garbageValue = "1698842944"
   )
   static final void method3474(PendingSpawn var0) {
      int var1 = 0;
      int var2 = -1;
      int var3 = 0;
      int var4 = 0;
      if(var0.type == 0) {
         var1 = class38.region.method2987(var0.level, var0.x, var0.y);
      }

      if(var0.type == 1) {
         var1 = class38.region.method2940(var0.level, var0.x, var0.y);
      }

      if(var0.type == 2) {
         var1 = class38.region.method2885(var0.level, var0.x, var0.y);
      }

      if(var0.type == 3) {
         var1 = class38.region.method3005(var0.level, var0.x, var0.y);
      }

      if(var1 != 0) {
         int var5 = class38.region.getObjectFlags(var0.level, var0.x, var0.y, var1);
         var2 = var1 >> 14 & 32767;
         var3 = var5 & 31;
         var4 = var5 >> 6 & 3;
      }

      var0.field1125 = var2;
      var0.field1121 = var3;
      var0.field1126 = var4;
   }

   @ObfuscatedName("hr")
   @ObfuscatedSignature(
      signature = "(III)Lfv;",
      garbageValue = "-1402907610"
   )
   static class178 method3476(int var0, int var1) {
      Client.field1117.field2254 = var0;
      Client.field1117.field2255 = var1;
      Client.field1117.field2257 = 1;
      Client.field1117.field2256 = 1;
      return Client.field1117;
   }
}
