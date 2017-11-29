import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("av")
public class class48 implements WorldMapSectionBase {
   @ObfuscatedName("dn")
   @ObfuscatedGetter(
      intValue = 493026841
   )
   @Export("port1")
   static int port1;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1378429875
   )
   int field587;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1335265991
   )
   int field579;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 2141045815
   )
   int field580;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1322439677
   )
   int field581;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1300029485
   )
   int field578;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -2081069435
   )
   int field583;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1715908697
   )
   int field590;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 140595331
   )
   int field582;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1128621275
   )
   int field586;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1945652615
   )
   int field585;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lal;I)V",
      garbageValue = "1038625343"
   )
   public void vmethod724(WorldMapData var1) {
      if(var1.field427 > this.field578) {
         var1.field427 = this.field578;
      }

      if(var1.field431 < this.field578) {
         var1.field431 = this.field578;
      }

      if(var1.field428 > this.field583) {
         var1.field428 = this.field583;
      }

      if(var1.field436 < this.field583) {
         var1.field436 = this.field583;
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "952023960"
   )
   public boolean vmethod728(int var1, int var2, int var3) {
      return var1 >= this.field587 && var1 < this.field579 + this.field587?var2 >= (this.field580 << 6) + (this.field590 << 3) && var2 <= (this.field580 << 6) + (this.field590 << 3) + 7 && var3 >= (this.field581 << 6) + (this.field582 << 3) && var3 <= (this.field581 << 6) + (this.field582 << 3) + 7:false;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "-27"
   )
   public boolean vmethod716(int var1, int var2) {
      return var1 >= (this.field578 << 6) + (this.field586 << 3) && var1 <= (this.field578 << 6) + (this.field586 << 3) + 7 && var2 >= (this.field583 << 6) + (this.field585 << 3) && var2 <= (this.field583 << 6) + (this.field585 << 3) + 7;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "-495685061"
   )
   public int[] vmethod717(int var1, int var2, int var3) {
      if(!this.vmethod728(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field578 * 64 - this.field580 * 64 + var2 + (this.field586 * 8 - this.field590 * 8), var3 + (this.field583 * 64 - this.field581 * 64) + (this.field585 * 8 - this.field582 * 8)};
         return var4;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIB)Lhp;",
      garbageValue = "1"
   )
   public Coordinates vmethod741(int var1, int var2) {
      if(!this.vmethod716(var1, var2)) {
         return null;
      } else {
         int var3 = this.field580 * 64 - this.field578 * 64 + (this.field590 * 8 - this.field586 * 8) + var1;
         int var4 = this.field581 * 64 - this.field583 * 64 + var2 + (this.field582 * 8 - this.field585 * 8);
         return new Coordinates(this.field587, var3, var4);
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lfr;I)V",
      garbageValue = "-1975557779"
   )
   public void vmethod719(Buffer var1) {
      this.field587 = var1.readUnsignedByte();
      this.field579 = var1.readUnsignedByte();
      this.field580 = var1.readUnsignedShort();
      this.field590 = var1.readUnsignedByte();
      this.field581 = var1.readUnsignedShort();
      this.field582 = var1.readUnsignedByte();
      this.field578 = var1.readUnsignedShort();
      this.field586 = var1.readUnsignedByte();
      this.field583 = var1.readUnsignedShort();
      this.field585 = var1.readUnsignedByte();
      this.method720();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1780401569"
   )
   void method720() {
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;ZI)[B",
      garbageValue = "-1744244645"
   )
   @Export("toByteArray")
   public static byte[] toByteArray(Object var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else if(var0 instanceof byte[]) {
         byte[] var6 = (byte[])((byte[])var0);
         if(var1) {
            int var4 = var6.length;
            byte[] var5 = new byte[var4];
            System.arraycopy(var6, 0, var5, 0, var4);
            return var5;
         } else {
            return var6;
         }
      } else if(var0 instanceof AbstractByteBuffer) {
         AbstractByteBuffer var2 = (AbstractByteBuffer)var0;
         return var2.get();
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(ILce;ZI)I",
      garbageValue = "1755481777"
   )
   static int method740(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class87.getWidget(class82.intStack[--GrandExchangeEvents.intStackSize]);
      } else {
         var3 = var2?class54.field636:class82.field1265;
      }

      int var4;
      if(var0 == 1300) {
         var4 = class82.intStack[--GrandExchangeEvents.intStackSize] - 1;
         if(var4 >= 0 && var4 <= 9) {
            var3.setAction(var4, class82.scriptStringStack[--class82.scriptStringStackSize]);
            return 1;
         } else {
            --class82.scriptStringStackSize;
            return 1;
         }
      } else if(var0 == 1301) {
         GrandExchangeEvents.intStackSize -= 2;
         var4 = class82.intStack[GrandExchangeEvents.intStackSize];
         int var5 = class82.intStack[GrandExchangeEvents.intStackSize + 1];
         var3.dragParent = MilliTimer.getWidgetChild(var4, var5);
         return 1;
      } else if(var0 == 1302) {
         var3.field2802 = class82.intStack[--GrandExchangeEvents.intStackSize] == 1;
         return 1;
      } else if(var0 == 1303) {
         var3.field2800 = class82.intStack[--GrandExchangeEvents.intStackSize];
         return 1;
      } else if(var0 == 1304) {
         var3.field2801 = class82.intStack[--GrandExchangeEvents.intStackSize];
         return 1;
      } else if(var0 == 1305) {
         var3.name = class82.scriptStringStack[--class82.scriptStringStackSize];
         return 1;
      } else if(var0 == 1306) {
         var3.selectedAction = class82.scriptStringStack[--class82.scriptStringStackSize];
         return 1;
      } else if(var0 == 1307) {
         var3.actions = null;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("hf")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "-10441"
   )
   static final void method739(int var0) {
      int[] var1 = class1.field12.pixels;
      int var2 = var1.length;

      int var3;
      for(var3 = 0; var3 < var2; ++var3) {
         var1[var3] = 0;
      }

      int var4;
      int var5;
      for(var3 = 1; var3 < 103; ++var3) {
         var4 = (103 - var3) * 2048 + 24628;

         for(var5 = 1; var5 < 103; ++var5) {
            if((class61.tileSettings[var0][var5][var3] & 24) == 0) {
               GrandExchangeEvent.region.method2927(var1, var4, 512, var0, var5, var3);
            }

            if(var0 < 3 && (class61.tileSettings[var0 + 1][var5][var3] & 8) != 0) {
               GrandExchangeEvent.region.method2927(var1, var4, 512, var0 + 1, var5, var3);
            }

            var4 += 4;
         }
      }

      var3 = (238 + (int)(Math.random() * 20.0D) - 10 << 16) + (238 + (int)(Math.random() * 20.0D) - 10 << 8) + (238 + (int)(Math.random() * 20.0D) - 10);
      var4 = 238 + (int)(Math.random() * 20.0D) - 10 << 16;
      class1.field12.method5285();

      int var6;
      for(var5 = 1; var5 < 103; ++var5) {
         for(var6 = 1; var6 < 103; ++var6) {
            if((class61.tileSettings[var0][var6][var5] & 24) == 0) {
               class91.method1814(var0, var6, var5, var3, var4);
            }

            if(var0 < 3 && (class61.tileSettings[var0 + 1][var6][var5] & 8) != 0) {
               class91.method1814(var0 + 1, var6, var5, var3, var4);
            }
         }
      }

      Client.field1024 = 0;

      for(var5 = 0; var5 < 104; ++var5) {
         for(var6 = 0; var6 < 104; ++var6) {
            int var7 = GrandExchangeEvent.region.method2826(class233.plane, var5, var6);
            if(var7 != 0) {
               var7 = var7 >> 14 & 32767;
               int var8 = class3.getObjectDefinition(var7).mapIconId;
               if(var8 >= 0) {
                  Client.mapIcons[Client.field1024] = Area.mapAreaType[var8].getMapIcon(false);
                  Client.field994[Client.field1024] = var5;
                  Client.field1084[Client.field1024] = var6;
                  ++Client.field1024;
               }
            }
         }
      }

      class86.rasterProvider.setRaster();
   }
}
