import java.io.File;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cj")
@Implements("ContextMenuRow")
public class ContextMenuRow {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1097709421
   )
   @Export("param0")
   int param0;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 724323879
   )
   @Export("param1")
   int param1;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1664084635
   )
   @Export("type")
   int type;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -314532609
   )
   @Export("identifier")
   int identifier;
   @ObfuscatedName("i")
   @Export("option")
   String option;

   @ObfuscatedName("g")
   static final void method1876(long var0) {
      try {
         Thread.sleep(var0);
      } catch (InterruptedException var3) {
         ;
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([BIIB)Ljava/lang/String;",
      garbageValue = "41"
   )
   @Export("getString")
   public static String getString(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         int var6 = var0[var5 + var1] & 255;
         if(var6 != 0) {
            if(var6 >= 128 && var6 < 160) {
               char var7 = class289.cp1252AsciiExtension[var6 - 128];
               if(var7 == 0) {
                  var7 = '?';
               }

               var6 = var7;
            }

            var3[var4++] = (char)var6;
         }
      }

      return new String(var3, 0, var4);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;Ljava/io/File;I)V",
      garbageValue = "1741062396"
   )
   static void method1875(File var0, File var1) {
      try {
         FileOnDisk var2 = new FileOnDisk(class157.jagexClDat, "rw", 10000L);
         Buffer var3 = new Buffer(500);
         var3.putByte(3);
         var3.putByte(var1 != null?1:0);
         var3.putCESU8(var0.getPath());
         if(var1 != null) {
            var3.putCESU8("");
         }

         var2.write(var3.payload, 0, var3.offset);
         var2.close();
      } catch (IOException var4) {
         var4.printStackTrace();
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(ILcf;ZI)I",
      garbageValue = "-1446255493"
   )
   static int method1874(int var0, Script var1, boolean var2) {
      int var4 = -1;
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var4 = class80.intStack[--class80.intStackSize];
         var3 = class216.getWidget(var4);
      } else {
         var3 = var2?class94.field1418:ItemLayer.field1668;
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

         class33.method341(var3);
         return 1;
      } else if(var0 == 1101) {
         var3.textColor = class80.intStack[--class80.intStackSize];
         class33.method341(var3);
         return 1;
      } else if(var0 == 1102) {
         var3.filled = class80.intStack[--class80.intStackSize] == 1;
         class33.method341(var3);
         return 1;
      } else if(var0 == 1103) {
         var3.opacity = class80.intStack[--class80.intStackSize];
         class33.method341(var3);
         return 1;
      } else if(var0 == 1104) {
         var3.lineWidth = class80.intStack[--class80.intStackSize];
         class33.method341(var3);
         return 1;
      } else if(var0 == 1105) {
         var3.spriteId = class80.intStack[--class80.intStackSize];
         class33.method341(var3);
         return 1;
      } else if(var0 == 1106) {
         var3.textureId = class80.intStack[--class80.intStackSize];
         class33.method341(var3);
         return 1;
      } else if(var0 == 1107) {
         var3.spriteTiling = class80.intStack[--class80.intStackSize] == 1;
         class33.method341(var3);
         return 1;
      } else if(var0 == 1108) {
         var3.modelType = 1;
         var3.modelId = class80.intStack[--class80.intStackSize];
         class33.method341(var3);
         return 1;
      } else if(var0 == 1109) {
         class80.intStackSize -= 6;
         var3.field2777 = class80.intStack[class80.intStackSize];
         var3.field2864 = class80.intStack[class80.intStackSize + 1];
         var3.rotationX = class80.intStack[class80.intStackSize + 2];
         var3.rotationZ = class80.intStack[class80.intStackSize + 3];
         var3.rotationY = class80.intStack[class80.intStackSize + 4];
         var3.modelZoom = class80.intStack[class80.intStackSize + 5];
         class33.method341(var3);
         return 1;
      } else {
         int var10;
         if(var0 == 1110) {
            var10 = class80.intStack[--class80.intStackSize];
            if(var10 != var3.field2801) {
               var3.field2801 = var10;
               var3.field2876 = 0;
               var3.field2889 = 0;
               class33.method341(var3);
            }

            return 1;
         } else if(var0 == 1111) {
            var3.field2778 = class80.intStack[--class80.intStackSize] == 1;
            class33.method341(var3);
            return 1;
         } else if(var0 == 1112) {
            String var8 = class80.scriptStringStack[--class294.scriptStringStackSize];
            if(!var8.equals(var3.text)) {
               var3.text = var8;
               class33.method341(var3);
            }

            return 1;
         } else if(var0 == 1113) {
            var3.fontId = class80.intStack[--class80.intStackSize];
            class33.method341(var3);
            return 1;
         } else if(var0 == 1114) {
            class80.intStackSize -= 3;
            var3.field2817 = class80.intStack[class80.intStackSize];
            var3.field2818 = class80.intStack[class80.intStackSize + 1];
            var3.field2816 = class80.intStack[class80.intStackSize + 2];
            class33.method341(var3);
            return 1;
         } else if(var0 == 1115) {
            var3.textShadowed = class80.intStack[--class80.intStackSize] == 1;
            class33.method341(var3);
            return 1;
         } else if(var0 == 1116) {
            var3.borderThickness = class80.intStack[--class80.intStackSize];
            class33.method341(var3);
            return 1;
         } else if(var0 == 1117) {
            var3.sprite2 = class80.intStack[--class80.intStackSize];
            class33.method341(var3);
            return 1;
         } else if(var0 == 1118) {
            var3.flippedVertically = class80.intStack[--class80.intStackSize] == 1;
            class33.method341(var3);
            return 1;
         } else if(var0 == 1119) {
            var3.flippedHorizontally = class80.intStack[--class80.intStackSize] == 1;
            class33.method341(var3);
            return 1;
         } else if(var0 == 1120) {
            class80.intStackSize -= 2;
            var3.scrollWidth = class80.intStack[class80.intStackSize];
            var3.scrollHeight = class80.intStack[class80.intStackSize + 1];
            class33.method341(var3);
            if(var4 != -1 && var3.type == 0) {
               class5.method14(ScriptState.widgets[var4 >> 16], var3, false);
            }

            return 1;
         } else if(var0 == 1121) {
            var10 = var3.id;
            int var6 = var3.index;
            PacketNode var11 = Script.method2025(ClientPacket.field2398, Client.field937.field1454);
            var11.packetBuffer.writeIntLE(var10);
            var11.packetBuffer.writeShortLE(var6);
            Client.field937.method2044(var11);
            Client.field885 = var3;
            class33.method341(var3);
            return 1;
         } else if(var0 == 1122) {
            var3.field2790 = class80.intStack[--class80.intStackSize];
            class33.method341(var3);
            return 1;
         } else if(var0 == 1123) {
            var3.field2780 = class80.intStack[--class80.intStackSize];
            class33.method341(var3);
            return 1;
         } else if(var0 == 1124) {
            var3.field2786 = class80.intStack[--class80.intStackSize];
            class33.method341(var3);
            return 1;
         } else if(var0 == 1125) {
            var10 = class80.intStack[--class80.intStackSize];
            class307[] var9 = new class307[]{class307.field3884, class307.field3887, class307.field3881, class307.field3883, class307.field3882};
            class307 var7 = (class307)Projectile.forOrdinal(var9, var10);
            if(var7 != null) {
               var3.field2832 = var7;
               class33.method341(var3);
            }

            return 1;
         } else if(var0 == 1126) {
            boolean var5 = class80.intStack[--class80.intStackSize] == 1;
            var3.field2820 = var5;
            return 1;
         } else {
            return 2;
         }
      }
   }

   @ObfuscatedName("ke")
   @ObfuscatedSignature(
      signature = "(Lhs;I)Z",
      garbageValue = "-1595894021"
   )
   static boolean method1877(Widget var0) {
      if(Client.field1098) {
         if(WorldComparator.getWidgetConfig(var0) != 0) {
            return false;
         }

         if(var0.type == 0) {
            return false;
         }
      }

      return var0.isHidden;
   }
}
