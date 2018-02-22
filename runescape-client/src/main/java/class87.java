import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cc")
public class class87 {
   @ObfuscatedName("ou")
   @ObfuscatedSignature(
      signature = "Ldw;"
   )
   @Export("soundSystem1")
   static AbstractSoundSystem soundSystem1;
   @ObfuscatedName("b")
   static final BigInteger field1292;
   @ObfuscatedName("q")
   static final BigInteger field1287;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -394488333
   )
   static int field1290;

   static {
      field1292 = new BigInteger("10001", 16);
      field1287 = new BigInteger("9fe9af6f57c7bf592f2b1ac3512411a1634f3ff600ea6efb0f06de71cf950f42349223018acbb2bffefc03216bcd8a057c49bb71b36cc8c4040240d8c599733ccb74c709f8e8cc34fe1d0e141a8eea79d2bdce3c2eb6f044949b70e6b5685beb92f8495310afe0ef10f56c4f0bfd6fd70c6555f693c049a186dcb4b1c01fc1c7", 16);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(ILca;ZI)I",
      garbageValue = "557027061"
   )
   static int method1863(int var0, Script var1, boolean var2) {
      int var4 = -1;
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var4 = class80.intStack[--class80.intStackSize];
         var3 = NetWriter.getWidget(var4);
      } else {
         var3 = var2?class223.field2643:class80.field1228;
      }

      if(var0 == 1100) {
         class80.intStackSize -= 2;
         var3.scrollX = class80.intStack[class80.intStackSize];
         if(var3.scrollX > var3.scrollWidth - var3.width) {
            var3.scrollX = var3.scrollWidth - var3.width;
         }

         if(var3.scrollX < 0) {
            var3.scrollX = 0;
         }

         var3.scrollY = class80.intStack[class80.intStackSize + 1];
         if(var3.scrollY > var3.scrollHeight - var3.height) {
            var3.scrollY = var3.scrollHeight - var3.height;
         }

         if(var3.scrollY < 0) {
            var3.scrollY = 0;
         }

         ScriptEvent.method1132(var3);
         return 1;
      } else if(var0 == 1101) {
         var3.textColor = class80.intStack[--class80.intStackSize];
         ScriptEvent.method1132(var3);
         return 1;
      } else if(var0 == 1102) {
         var3.filled = class80.intStack[--class80.intStackSize] == 1;
         ScriptEvent.method1132(var3);
         return 1;
      } else if(var0 == 1103) {
         var3.opacity = class80.intStack[--class80.intStackSize];
         ScriptEvent.method1132(var3);
         return 1;
      } else if(var0 == 1104) {
         var3.lineWidth = class80.intStack[--class80.intStackSize];
         ScriptEvent.method1132(var3);
         return 1;
      } else if(var0 == 1105) {
         var3.spriteId = class80.intStack[--class80.intStackSize];
         ScriptEvent.method1132(var3);
         return 1;
      } else if(var0 == 1106) {
         var3.textureId = class80.intStack[--class80.intStackSize];
         ScriptEvent.method1132(var3);
         return 1;
      } else if(var0 == 1107) {
         var3.spriteTiling = class80.intStack[--class80.intStackSize] == 1;
         ScriptEvent.method1132(var3);
         return 1;
      } else if(var0 == 1108) {
         var3.modelType = 1;
         var3.modelId = class80.intStack[--class80.intStackSize];
         ScriptEvent.method1132(var3);
         return 1;
      } else if(var0 == 1109) {
         class80.intStackSize -= 6;
         var3.field2835 = class80.intStack[class80.intStackSize];
         var3.field2795 = class80.intStack[class80.intStackSize + 1];
         var3.rotationX = class80.intStack[class80.intStackSize + 2];
         var3.rotationZ = class80.intStack[class80.intStackSize + 3];
         var3.rotationY = class80.intStack[class80.intStackSize + 4];
         var3.modelZoom = class80.intStack[class80.intStackSize + 5];
         ScriptEvent.method1132(var3);
         return 1;
      } else {
         int var10;
         if(var0 == 1110) {
            var10 = class80.intStack[--class80.intStackSize];
            if(var10 != var3.field2824) {
               var3.field2824 = var10;
               var3.field2899 = 0;
               var3.field2800 = 0;
               ScriptEvent.method1132(var3);
            }

            return 1;
         } else if(var0 == 1111) {
            var3.field2834 = class80.intStack[--class80.intStackSize] == 1;
            ScriptEvent.method1132(var3);
            return 1;
         } else if(var0 == 1112) {
            String var8 = class80.scriptStringStack[--class43.scriptStringStackSize];
            if(!var8.equals(var3.text)) {
               var3.text = var8;
               ScriptEvent.method1132(var3);
            }

            return 1;
         } else if(var0 == 1113) {
            var3.fontId = class80.intStack[--class80.intStackSize];
            ScriptEvent.method1132(var3);
            return 1;
         } else if(var0 == 1114) {
            class80.intStackSize -= 3;
            var3.field2779 = class80.intStack[class80.intStackSize];
            var3.field2847 = class80.intStack[class80.intStackSize + 1];
            var3.field2839 = class80.intStack[class80.intStackSize + 2];
            ScriptEvent.method1132(var3);
            return 1;
         } else if(var0 == 1115) {
            var3.textShadowed = class80.intStack[--class80.intStackSize] == 1;
            ScriptEvent.method1132(var3);
            return 1;
         } else if(var0 == 1116) {
            var3.borderThickness = class80.intStack[--class80.intStackSize];
            ScriptEvent.method1132(var3);
            return 1;
         } else if(var0 == 1117) {
            var3.sprite2 = class80.intStack[--class80.intStackSize];
            ScriptEvent.method1132(var3);
            return 1;
         } else if(var0 == 1118) {
            var3.flippedVertically = class80.intStack[--class80.intStackSize] == 1;
            ScriptEvent.method1132(var3);
            return 1;
         } else if(var0 == 1119) {
            var3.flippedHorizontally = class80.intStack[--class80.intStackSize] == 1;
            ScriptEvent.method1132(var3);
            return 1;
         } else if(var0 == 1120) {
            class80.intStackSize -= 2;
            var3.scrollWidth = class80.intStack[class80.intStackSize];
            var3.scrollHeight = class80.intStack[class80.intStackSize + 1];
            ScriptEvent.method1132(var3);
            if(var4 != -1 && var3.type == 0) {
               GrandExchangeOffer.method119(Widget.widgets[var4 >> 16], var3, false);
            }

            return 1;
         } else if(var0 == 1121) {
            var10 = var3.id;
            int var6 = var3.index;
            PacketNode var7 = class61.method1076(ClientPacket.field2412, Client.field863.field1434);
            var7.packetBuffer.putShort(var6);
            var7.packetBuffer.method3779(var10);
            Client.field863.method2039(var7);
            Client.field930 = var3;
            ScriptEvent.method1132(var3);
            return 1;
         } else if(var0 == 1122) {
            var3.field2883 = class80.intStack[--class80.intStackSize];
            ScriptEvent.method1132(var3);
            return 1;
         } else if(var0 == 1123) {
            var3.field2803 = class80.intStack[--class80.intStackSize];
            ScriptEvent.method1132(var3);
            return 1;
         } else if(var0 == 1124) {
            var3.field2772 = class80.intStack[--class80.intStackSize];
            ScriptEvent.method1132(var3);
            return 1;
         } else if(var0 == 1125) {
            var10 = class80.intStack[--class80.intStackSize];
            class320 var9 = (class320)Tile.forOrdinal(WorldMapType3.method227(), var10);
            if(var9 != null) {
               var3.field2807 = var9;
               ScriptEvent.method1132(var3);
            }

            return 1;
         } else if(var0 == 1126) {
            boolean var5 = class80.intStack[--class80.intStackSize] == 1;
            var3.field2889 = var5;
            return 1;
         } else {
            return 2;
         }
      }
   }

   @ObfuscatedName("jr")
   @ObfuscatedSignature(
      signature = "([Lim;II)V",
      garbageValue = "-105728973"
   )
   static final void method1862(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null && var3.parentId == var1 && (!var3.hasScript || !class197.method3823(var3))) {
            if(var3.type == 0) {
               if(!var3.hasScript && class197.method3823(var3) && var3 != Varcs.field1389) {
                  continue;
               }

               method1862(var0, var3.id);
               if(var3.children != null) {
                  method1862(var3.children, var3.id);
               }

               WidgetNode var4 = (WidgetNode)Client.componentTable.get((long)var3.id);
               if(var4 != null) {
                  Renderable.method3050(var4.id);
               }
            }

            if(var3.type == 6) {
               int var5;
               if(var3.field2824 != -1 || var3.field2765 != -1) {
                  boolean var7 = Renderable.method3049(var3);
                  if(var7) {
                     var5 = var3.field2765;
                  } else {
                     var5 = var3.field2824;
                  }

                  if(var5 != -1) {
                     Sequence var6 = Occluder.getAnimation(var5);

                     for(var3.field2800 += Client.field878; var3.field2800 > var6.frameLenghts[var3.field2899]; ScriptEvent.method1132(var3)) {
                        var3.field2800 -= var6.frameLenghts[var3.field2899];
                        ++var3.field2899;
                        if(var3.field2899 >= var6.frameIDs.length) {
                           var3.field2899 -= var6.frameStep;
                           if(var3.field2899 < 0 || var3.field2899 >= var6.frameIDs.length) {
                              var3.field2899 = 0;
                           }
                        }
                     }
                  }
               }

               if(var3.field2833 != 0 && !var3.hasScript) {
                  int var8 = var3.field2833 >> 16;
                  var5 = var3.field2833 << 16 >> 16;
                  var8 *= Client.field878;
                  var5 *= Client.field878;
                  var3.rotationX = var8 + var3.rotationX & 2047;
                  var3.rotationZ = var5 + var3.rotationZ & 2047;
                  ScriptEvent.method1132(var3);
               }
            }
         }
      }

   }
}
