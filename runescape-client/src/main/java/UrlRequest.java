import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("er")
@Implements("UrlRequest")
public class UrlRequest {
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 1332900993
   )
   static int field1881;
   @ObfuscatedName("w")
   @Export("url")
   final URL url;
   @ObfuscatedName("m")
   @Export("isDone0")
   volatile boolean isDone0;
   @ObfuscatedName("q")
   @Export("response0")
   volatile byte[] response0;

   UrlRequest(URL var1) {
      this.url = var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1886294861"
   )
   @Export("isDone")
   public boolean isDone() {
      return this.isDone0;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)[B",
      garbageValue = "-80"
   )
   @Export("getResponse")
   public byte[] getResponse() {
      return this.response0;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "([Lbb;II[I[IB)V",
      garbageValue = "-103"
   )
   static void method3137(World[] var0, int var1, int var2, int[] var3, int[] var4) {
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
                     var11 = var0[var6].method1603()?1:0;
                     var12 = var8.method1603()?1:0;
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
                     var11 = var0[var5].method1603()?1:0;
                     var12 = var8.method1603()?1:0;
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

         method3137(var0, var1, var6, var3, var4);
         method3137(var0, var6 + 1, var2, var3, var4);
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(ILcs;ZI)I",
      garbageValue = "-1322184782"
   )
   static int method3138(int var0, Script var1, boolean var2) {
      int var4 = -1;
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var4 = class69.intStack[--class45.intStackSize];
         var3 = OwnWorldComparator.getWidget(var4);
      } else {
         var3 = var2?class184.field2379:FriendManager.field996;
      }

      if(var0 == 1100) {
         class45.intStackSize -= 2;
         var3.scrollX = class69.intStack[class45.intStackSize];
         if(var3.scrollX > var3.scrollWidth - var3.width) {
            var3.scrollX = var3.scrollWidth - var3.width;
         }

         if(var3.scrollX < 0) {
            var3.scrollX = 0;
         }

         var3.scrollY = class69.intStack[class45.intStackSize + 1];
         if(var3.scrollY > var3.scrollHeight - var3.height) {
            var3.scrollY = var3.scrollHeight - var3.height;
         }

         if(var3.scrollY < 0) {
            var3.scrollY = 0;
         }

         DState.method3548(var3);
         return 1;
      } else if(var0 == 1101) {
         var3.textColor = class69.intStack[--class45.intStackSize];
         DState.method3548(var3);
         return 1;
      } else if(var0 == 1102) {
         var3.filled = class69.intStack[--class45.intStackSize] == 1;
         DState.method3548(var3);
         return 1;
      } else if(var0 == 1103) {
         var3.opacity = class69.intStack[--class45.intStackSize];
         DState.method3548(var3);
         return 1;
      } else if(var0 == 1104) {
         var3.lineWidth = class69.intStack[--class45.intStackSize];
         DState.method3548(var3);
         return 1;
      } else if(var0 == 1105) {
         var3.spriteId = class69.intStack[--class45.intStackSize];
         DState.method3548(var3);
         return 1;
      } else if(var0 == 1106) {
         var3.textureId = class69.intStack[--class45.intStackSize];
         DState.method3548(var3);
         return 1;
      } else if(var0 == 1107) {
         var3.spriteTiling = class69.intStack[--class45.intStackSize] == 1;
         DState.method3548(var3);
         return 1;
      } else if(var0 == 1108) {
         var3.modelType = 1;
         var3.modelId = class69.intStack[--class45.intStackSize];
         DState.method3548(var3);
         return 1;
      } else if(var0 == 1109) {
         class45.intStackSize -= 6;
         var3.offsetX2d = class69.intStack[class45.intStackSize];
         var3.offsetY2d = class69.intStack[class45.intStackSize + 1];
         var3.rotationX = class69.intStack[class45.intStackSize + 2];
         var3.rotationZ = class69.intStack[class45.intStackSize + 3];
         var3.rotationY = class69.intStack[class45.intStackSize + 4];
         var3.modelZoom = class69.intStack[class45.intStackSize + 5];
         DState.method3548(var3);
         return 1;
      } else {
         int var10;
         if(var0 == 1110) {
            var10 = class69.intStack[--class45.intStackSize];
            if(var10 != var3.field2670) {
               var3.field2670 = var10;
               var3.field2746 = 0;
               var3.field2718 = 0;
               DState.method3548(var3);
            }

            return 1;
         } else if(var0 == 1111) {
            var3.field2699 = class69.intStack[--class45.intStackSize] == 1;
            DState.method3548(var3);
            return 1;
         } else if(var0 == 1112) {
            String var8 = class69.scriptStringStack[--class83.scriptStringStackSize];
            if(!var8.equals(var3.text)) {
               var3.text = var8;
               DState.method3548(var3);
            }

            return 1;
         } else if(var0 == 1113) {
            var3.fontId = class69.intStack[--class45.intStackSize];
            DState.method3548(var3);
            return 1;
         } else if(var0 == 1114) {
            class45.intStackSize -= 3;
            var3.field2747 = class69.intStack[class45.intStackSize];
            var3.field2688 = class69.intStack[class45.intStackSize + 1];
            var3.field2686 = class69.intStack[class45.intStackSize + 2];
            DState.method3548(var3);
            return 1;
         } else if(var0 == 1115) {
            var3.textShadowed = class69.intStack[--class45.intStackSize] == 1;
            DState.method3548(var3);
            return 1;
         } else if(var0 == 1116) {
            var3.borderThickness = class69.intStack[--class45.intStackSize];
            DState.method3548(var3);
            return 1;
         } else if(var0 == 1117) {
            var3.sprite2 = class69.intStack[--class45.intStackSize];
            DState.method3548(var3);
            return 1;
         } else if(var0 == 1118) {
            var3.flippedVertically = class69.intStack[--class45.intStackSize] == 1;
            DState.method3548(var3);
            return 1;
         } else if(var0 == 1119) {
            var3.flippedHorizontally = class69.intStack[--class45.intStackSize] == 1;
            DState.method3548(var3);
            return 1;
         } else if(var0 == 1120) {
            class45.intStackSize -= 2;
            var3.scrollWidth = class69.intStack[class45.intStackSize];
            var3.scrollHeight = class69.intStack[class45.intStackSize + 1];
            DState.method3548(var3);
            if(var4 != -1 && var3.type == 0) {
               class45.method818(Widget.widgets[var4 >> 16], var3, false);
            }

            return 1;
         } else if(var0 == 1121) {
            var10 = var3.id;
            int var6 = var3.index;
            PacketNode var11 = DecorativeObject.method3115(ClientPacket.field2225, Client.field739.field1250);
            var11.packetBuffer.method3670(var10);
            var11.packetBuffer.method3605(var6);
            Client.field739.method2019(var11);
            Client.field756 = var3;
            DState.method3548(var3);
            return 1;
         } else if(var0 == 1122) {
            var3.field2616 = class69.intStack[--class45.intStackSize];
            DState.method3548(var3);
            return 1;
         } else if(var0 == 1123) {
            var3.field2640 = class69.intStack[--class45.intStackSize];
            DState.method3548(var3);
            return 1;
         } else if(var0 == 1124) {
            var3.field2649 = class69.intStack[--class45.intStackSize];
            DState.method3548(var3);
            return 1;
         } else if(var0 == 1125) {
            var10 = class69.intStack[--class45.intStackSize];
            class316[] var9 = new class316[]{class316.field3781, class316.field3777, class316.field3780, class316.field3779, class316.field3778};
            class316 var7 = (class316)class7.forOrdinal(var9, var10);
            if(var7 != null) {
               var3.field2700 = var7;
               DState.method3548(var3);
            }

            return 1;
         } else {
            boolean var5;
            if(var0 == 1126) {
               var5 = class69.intStack[--class45.intStackSize] == 1;
               var3.field2657 = var5;
               return 1;
            } else if(var0 == 1127) {
               var5 = class69.intStack[--class45.intStackSize] == 1;
               var3.field2679 = var5;
               return 1;
            } else {
               return 2;
            }
         }
      }
   }
}
