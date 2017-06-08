import java.io.File;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("l")
public class class21 {
   @ObfuscatedName("f")
   static File field347;
   @ObfuscatedName("dq")
   @Export("indexWorldMap")
   static IndexData indexWorldMap;
   @ObfuscatedName("m")
   @Export("overlayPaths")
   static byte[][][] overlayPaths;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1998973497"
   )
   static void method169() {
      Object var0 = class236.field3236;
      synchronized(class236.field3236) {
         if(class236.field3235 == 0) {
            class223.field2848 = new Thread(new class236());
            class223.field2848.setDaemon(true);
            class223.field2848.start();
            class223.field2848.setPriority(5);
         }

         class236.field3235 = 600;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LPacketBuffer;II)V",
      garbageValue = "-1517391782"
   )
   static void method173(PacketBuffer var0, int var1) {
      boolean var2 = var0.method3400(1) == 1;
      if(var2) {
         class96.field1508[++class96.field1507 - 1] = var1;
      }

      int var3 = var0.method3400(2);
      Player var4 = Client.cachedPlayers[var1];
      if(var3 == 0) {
         if(var2) {
            var4.field893 = false;
         } else if(var1 == Client.localInteractingIndex) {
            throw new RuntimeException();
         } else {
            class96.field1504[var1] = (var4.pathX[0] + class61.baseX >> 13 << 14) + (var4.field891 << 28) + (var4.pathY[0] + class23.baseY >> 13);
            if(var4.field1254 != -1) {
               class96.field1505[var1] = var4.field1254;
            } else {
               class96.field1505[var1] = var4.field1252;
            }

            class96.field1495[var1] = var4.interacting;
            Client.cachedPlayers[var1] = null;
            if(var0.method3400(1) != 0) {
               class87.method1684(var0, var1);
            }

         }
      } else {
         int var5;
         int var6;
         int var7;
         if(var3 == 1) {
            var5 = var0.method3400(3);
            var6 = var4.pathX[0];
            var7 = var4.pathY[0];
            if(var5 == 0) {
               --var6;
               --var7;
            } else if(var5 == 1) {
               --var7;
            } else if(var5 == 2) {
               ++var6;
               --var7;
            } else if(var5 == 3) {
               --var6;
            } else if(var5 == 4) {
               ++var6;
            } else if(var5 == 5) {
               --var6;
               ++var7;
            } else if(var5 == 6) {
               ++var7;
            } else if(var5 == 7) {
               ++var6;
               ++var7;
            }

            if(var1 != Client.localInteractingIndex || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
               if(var2) {
                  var4.field893 = true;
                  var4.field894 = var6;
                  var4.field875 = var7;
               } else {
                  var4.field893 = false;
                  var4.method1096(var6, var7, class96.field1498[var1]);
               }
            } else {
               var4.method1123(var6, var7);
               var4.field893 = false;
            }

         } else if(var3 == 2) {
            var5 = var0.method3400(4);
            var6 = var4.pathX[0];
            var7 = var4.pathY[0];
            if(var5 == 0) {
               var6 -= 2;
               var7 -= 2;
            } else if(var5 == 1) {
               --var6;
               var7 -= 2;
            } else if(var5 == 2) {
               var7 -= 2;
            } else if(var5 == 3) {
               ++var6;
               var7 -= 2;
            } else if(var5 == 4) {
               var6 += 2;
               var7 -= 2;
            } else if(var5 == 5) {
               var6 -= 2;
               --var7;
            } else if(var5 == 6) {
               var6 += 2;
               --var7;
            } else if(var5 == 7) {
               var6 -= 2;
            } else if(var5 == 8) {
               var6 += 2;
            } else if(var5 == 9) {
               var6 -= 2;
               ++var7;
            } else if(var5 == 10) {
               var6 += 2;
               ++var7;
            } else if(var5 == 11) {
               var6 -= 2;
               var7 += 2;
            } else if(var5 == 12) {
               --var6;
               var7 += 2;
            } else if(var5 == 13) {
               var7 += 2;
            } else if(var5 == 14) {
               ++var6;
               var7 += 2;
            } else if(var5 == 15) {
               var6 += 2;
               var7 += 2;
            }

            if(var1 == Client.localInteractingIndex && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
               var4.method1123(var6, var7);
               var4.field893 = false;
            } else if(var2) {
               var4.field893 = true;
               var4.field894 = var6;
               var4.field875 = var7;
            } else {
               var4.field893 = false;
               var4.method1096(var6, var7, class96.field1498[var1]);
            }

         } else {
            var5 = var0.method3400(1);
            int var8;
            int var9;
            int var10;
            int var11;
            if(var5 == 0) {
               var6 = var0.method3400(12);
               var7 = var6 >> 10;
               var8 = var6 >> 5 & 31;
               if(var8 > 15) {
                  var8 -= 32;
               }

               var9 = var6 & 31;
               if(var9 > 15) {
                  var9 -= 32;
               }

               var10 = var4.pathX[0] + var8;
               var11 = var9 + var4.pathY[0];
               if(Client.localInteractingIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
                  if(var2) {
                     var4.field893 = true;
                     var4.field894 = var10;
                     var4.field875 = var11;
                  } else {
                     var4.field893 = false;
                     var4.method1096(var10, var11, class96.field1498[var1]);
                  }
               } else {
                  var4.method1123(var10, var11);
                  var4.field893 = false;
               }

               var4.field891 = (byte)(var4.field891 + var7 & 3);
               if(Client.localInteractingIndex == var1) {
                  class92.plane = var4.field891;
               }

            } else {
               var6 = var0.method3400(30);
               var7 = var6 >> 28;
               var8 = var6 >> 14 & 16383;
               var9 = var6 & 16383;
               var10 = (var4.pathX[0] + class61.baseX + var8 & 16383) - class61.baseX;
               var11 = (var9 + class23.baseY + var4.pathY[0] & 16383) - class23.baseY;
               if(var1 == Client.localInteractingIndex && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
                  var4.method1123(var10, var11);
                  var4.field893 = false;
               } else if(var2) {
                  var4.field893 = true;
                  var4.field894 = var10;
                  var4.field875 = var11;
               } else {
                  var4.field893 = false;
                  var4.method1096(var10, var11, class96.field1498[var1]);
               }

               var4.field891 = (byte)(var4.field891 + var7 & 3);
               if(var1 == Client.localInteractingIndex) {
                  class92.plane = var4.field891;
               }

            }
         }
      }
   }

   @ObfuscatedName("hd")
   @ObfuscatedSignature(
      signature = "([LWidget;LWidget;ZI)V",
      garbageValue = "140188787"
   )
   static void method174(Widget[] var0, Widget var1, boolean var2) {
      int var3 = var1.scrollWidth != 0?var1.scrollWidth:var1.width;
      int var4 = var1.scrollHeight != 0?var1.scrollHeight:var1.height;
      class47.method690(var0, var1.id, var3, var4, var2);
      if(var1.children != null) {
         class47.method690(var1.children, var1.id, var3, var4, var2);
      }

      WidgetNode var5 = (WidgetNode)Client.componentTable.method3545((long)var1.id);
      if(var5 != null) {
         class1.method0(var5.id, var3, var4, var2);
      }

      if(var1.contentType == 1337) {
         ;
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([BI)LScript;",
      garbageValue = "-1065089463"
   )
   static Script method175(byte[] var0) {
      Script var1 = new Script();
      Buffer var2 = new Buffer(var0);
      var2.offset = var2.payload.length - 2;
      int var3 = var2.readUnsignedShort();
      int var4 = var2.payload.length - 2 - var3 - 12;
      var2.offset = var4;
      int var5 = var2.readInt();
      var1.localIntCount = var2.readUnsignedShort();
      var1.localStringCount = var2.readUnsignedShort();
      var1.intStackCount = var2.readUnsignedShort();
      var1.stringStackCount = var2.readUnsignedShort();
      int var6 = var2.readUnsignedByte();
      int var7;
      int var8;
      if(var6 > 0) {
         var1.switches = var1.method1837(var6);

         for(var7 = 0; var7 < var6; ++var7) {
            var8 = var2.readUnsignedShort();
            class186 var9 = new class186(class13.method88(var8));
            var1.switches[var7] = var9;

            while(var8-- > 0) {
               int var10 = var2.readInt();
               int var11 = var2.readInt();
               var9.method3494(new class198(var11), (long)var10);
            }
         }
      }

      var2.offset = 0;
      var2.method3279();
      var1.instructions = new int[var5];
      var1.intOperands = new int[var5];
      var1.stringOperands = new String[var5];

      for(var7 = 0; var2.offset < var4; var1.instructions[var7++] = var8) {
         var8 = var2.readUnsignedShort();
         if(var8 == 3) {
            var1.stringOperands[var7] = var2.readString();
         } else if(var8 < 100 && var8 != 21 && var8 != 38 && var8 != 39) {
            var1.intOperands[var7] = var2.readInt();
         } else {
            var1.intOperands[var7] = var2.readUnsignedByte();
         }
      }

      return var1;
   }
}
