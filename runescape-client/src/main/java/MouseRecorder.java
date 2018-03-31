import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bn")
@Implements("MouseRecorder")
public class MouseRecorder implements Runnable {
   @ObfuscatedName("fr")
   @ObfuscatedSignature(
      signature = "Lla;"
   )
   @Export("compass")
   static SpritePixels compass;
   @ObfuscatedName("c")
   @Export("isRunning")
   boolean isRunning;
   @ObfuscatedName("i")
   @Export("lock")
   Object lock;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1392647411
   )
   @Export("index")
   int index;
   @ObfuscatedName("j")
   @Export("xs")
   int[] xs;
   @ObfuscatedName("k")
   @Export("ys")
   int[] ys;

   MouseRecorder() {
      this.isRunning = true;
      this.lock = new Object();
      this.index = 0;
      this.xs = new int[500];
      this.ys = new int[500];
   }

   public void run() {
      for(; this.isRunning; class163.method3223(50L)) {
         Object var1 = this.lock;
         synchronized(this.lock) {
            if(this.index < 500) {
               this.xs[this.index] = MouseInput.mouseLastX;
               this.ys[this.index] = MouseInput.mouseLastY;
               ++this.index;
            }
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(ILcx;ZI)I",
      garbageValue = "-634935039"
   )
   static int method1105(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class3.getWidget(class81.intStack[--SceneTilePaint.intStackSize]);
      } else {
         var3 = var2?class336.field4073:class61.field713;
      }

      int var4;
      if(var0 == 1300) {
         var4 = class81.intStack[--SceneTilePaint.intStackSize] - 1;
         if(var4 >= 0 && var4 <= 9) {
            var3.setAction(var4, class81.scriptStringStack[--World.scriptStringStackSize]);
            return 1;
         } else {
            --World.scriptStringStackSize;
            return 1;
         }
      } else if(var0 == 1301) {
         SceneTilePaint.intStackSize -= 2;
         var4 = class81.intStack[SceneTilePaint.intStackSize];
         int var5 = class81.intStack[SceneTilePaint.intStackSize + 1];
         var3.dragParent = ClientPacket.getWidgetChild(var4, var5);
         return 1;
      } else if(var0 == 1302) {
         var3.dragRenderBehavior = class81.intStack[--SceneTilePaint.intStackSize] == 1;
         return 1;
      } else if(var0 == 1303) {
         var3.dragDeadZone = class81.intStack[--SceneTilePaint.intStackSize];
         return 1;
      } else if(var0 == 1304) {
         var3.dragDeadTime = class81.intStack[--SceneTilePaint.intStackSize];
         return 1;
      } else if(var0 == 1305) {
         var3.opBase = class81.scriptStringStack[--World.scriptStringStackSize];
         return 1;
      } else if(var0 == 1306) {
         var3.targetVerb = class81.scriptStringStack[--World.scriptStringStackSize];
         return 1;
      } else if(var0 == 1307) {
         var3.actions = null;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("hv")
   @ObfuscatedSignature(
      signature = "(ZLgf;S)V",
      garbageValue = "11447"
   )
   @Export("xteaChanged")
   static final void xteaChanged(boolean var0, PacketBuffer var1) {
      Client.isDynamicRegion = var0;
      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      if(!Client.isDynamicRegion) {
         int var2 = var1.method3513();
         var3 = var1.readUnsignedShort();
         var4 = var1.readUnsignedShort();
         Size.xteaKeys = new int[var4][4];

         for(var5 = 0; var5 < var4; ++var5) {
            for(var6 = 0; var6 < 4; ++var6) {
               Size.xteaKeys[var5][var6] = var1.readInt();
            }
         }

         Size.mapRegions = new int[var4];
         FontName.landMapFileIds = new int[var4];
         class185.landRegionFileIds = new int[var4];
         FrameMap.field1970 = new byte[var4][];
         class245.field2960 = new byte[var4][];
         boolean var16 = false;
         if((var3 / 8 == 48 || var3 / 8 == 49) && var2 / 8 == 48) {
            var16 = true;
         }

         if(var3 / 8 == 48 && var2 / 8 == 148) {
            var16 = true;
         }

         var4 = 0;

         for(var6 = (var3 - 6) / 8; var6 <= (var3 + 6) / 8; ++var6) {
            for(var7 = (var2 - 6) / 8; var7 <= (var2 + 6) / 8; ++var7) {
               var8 = var7 + (var6 << 8);
               if(!var16 || var7 != 49 && var7 != 149 && var7 != 147 && var6 != 50 && (var6 != 49 || var7 != 47)) {
                  Size.mapRegions[var4] = var8;
                  FontName.landMapFileIds[var4] = class1.indexMaps.getFile("m" + var6 + "_" + var7);
                  class185.landRegionFileIds[var4] = class1.indexMaps.getFile("l" + var6 + "_" + var7);
                  ++var4;
               }
            }
         }

         ScriptVarType.method20(var3, var2, true);
      } else {
         boolean var15 = var1.method3673() == 1;
         var3 = var1.method3716();
         var4 = var1.readUnsignedShortOb1();
         var5 = var1.readUnsignedShort();
         var1.bitAccess();

         int var9;
         for(var6 = 0; var6 < 4; ++var6) {
            for(var7 = 0; var7 < 13; ++var7) {
               for(var8 = 0; var8 < 13; ++var8) {
                  var9 = var1.getBits(1);
                  if(var9 == 1) {
                     Client.instanceTemplateChunks[var6][var7][var8] = var1.getBits(26);
                  } else {
                     Client.instanceTemplateChunks[var6][var7][var8] = -1;
                  }
               }
            }
         }

         var1.byteAccess();
         Size.xteaKeys = new int[var5][4];

         for(var6 = 0; var6 < var5; ++var6) {
            for(var7 = 0; var7 < 4; ++var7) {
               Size.xteaKeys[var6][var7] = var1.readInt();
            }
         }

         Size.mapRegions = new int[var5];
         FontName.landMapFileIds = new int[var5];
         class185.landRegionFileIds = new int[var5];
         FrameMap.field1970 = new byte[var5][];
         class245.field2960 = new byte[var5][];
         var5 = 0;

         for(var6 = 0; var6 < 4; ++var6) {
            for(var7 = 0; var7 < 13; ++var7) {
               for(var8 = 0; var8 < 13; ++var8) {
                  var9 = Client.instanceTemplateChunks[var6][var7][var8];
                  if(var9 != -1) {
                     int var10 = var9 >> 14 & 1023;
                     int var11 = var9 >> 3 & 2047;
                     int var12 = (var10 / 8 << 8) + var11 / 8;

                     int var13;
                     for(var13 = 0; var13 < var5; ++var13) {
                        if(Size.mapRegions[var13] == var12) {
                           var12 = -1;
                           break;
                        }
                     }

                     if(var12 != -1) {
                        Size.mapRegions[var5] = var12;
                        var13 = var12 >> 8 & 255;
                        int var14 = var12 & 255;
                        FontName.landMapFileIds[var5] = class1.indexMaps.getFile("m" + var13 + "_" + var14);
                        class185.landRegionFileIds[var5] = class1.indexMaps.getFile("l" + var13 + "_" + var14);
                        ++var5;
                     }
                  }
               }
            }
         }

         ScriptVarType.method20(var4, var3, !var15);
      }

   }
}
