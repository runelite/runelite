import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("by")
@Implements("ScriptEvent")
public class ScriptEvent extends Node {
   @ObfuscatedName("fv")
   @ObfuscatedSignature(
      signature = "Lkk;"
   )
   @Export("fontPlain11")
   static Font fontPlain11;
   @ObfuscatedName("hb")
   @ObfuscatedGetter(
      intValue = -1218466245
   )
   @Export("oculusOrbFocalPointY")
   static int oculusOrbFocalPointY;
   @ObfuscatedName("m")
   @Export("args0")
   Object[] args0;
   @ObfuscatedName("f")
   @Export("boolean1")
   boolean boolean1;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   @Export("widget")
   Widget widget;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 488198377
   )
   @Export("mouseX")
   int mouseX;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 95719815
   )
   @Export("mouseY")
   int mouseY;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1089993721
   )
   @Export("opIndex")
   int opIndex;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   @Export("dragTarget")
   Widget dragTarget;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1330602393
   )
   @Export("keyTyped")
   int keyTyped;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 327085889
   )
   @Export("keyPressed")
   int keyPressed;
   @ObfuscatedName("x")
   @Export("targetName")
   String targetName;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -2138736593
   )
   int field772;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -161292529
   )
   @Export("type0")
   int type0;

   public ScriptEvent() {
      this.type0 = 76;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/Object;I)V",
      garbageValue = "723852511"
   )
   @Export("setArgs")
   public void setArgs(Object[] args) {
      this.args0 = args;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-110"
   )
   @Export("setType")
   public void setType(int type) {
      this.type0 = type;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(ILcg;ZB)I",
      garbageValue = "0"
   )
   static int method1185(int var0, Script var1, boolean var2) {
      Widget var3 = var2 ? WorldMapIcon1.field1030 : GrandExchangeOfferAgeComparator.field1111;
      if (var0 == ScriptOpcodes.CC_GETSCROLLX) {
         Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var3.scrollX;
         return 1;
      } else if (var0 == ScriptOpcodes.CC_GETSCROLLY) {
         Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var3.scrollY;
         return 1;
      } else if (var0 == ScriptOpcodes.CC_GETTEXT) {
         Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3.text;
         return 1;
      } else if (var0 == ScriptOpcodes.CC_GETSCROLLWIDTH) {
         Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var3.scrollWidth;
         return 1;
      } else if (var0 == ScriptOpcodes.CC_GETSCROLLHEIGHT) {
         Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var3.scrollHeight;
         return 1;
      } else if (var0 == ScriptOpcodes.CC_GETMODELZOOM) {
         Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var3.modelZoom;
         return 1;
      } else if (var0 == ScriptOpcodes.CC_GETMODELANGLE_X) {
         Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var3.modelAngleX;
         return 1;
      } else if (var0 == ScriptOpcodes.CC_GETMODELANGLE_Z) {
         Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var3.modelAngleZ;
         return 1;
      } else if (var0 == ScriptOpcodes.CC_GETMODELANGLE_Y) {
         Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var3.modelAngleY;
         return 1;
      } else if (var0 == ScriptOpcodes.CC_GETTRANS) {
         Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var3.transparency;
         return 1;
      } else if (var0 == 1610) {
         Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var3.field960;
         return 1;
      } else if (var0 == ScriptOpcodes.CC_GETCOLOUR) {
         Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var3.color;
         return 1;
      } else if (var0 == ScriptOpcodes.CC_GETFILLCOLOUR) {
         Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var3.color2;
         return 1;
      } else if (var0 == 1613) {
         Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var3.rectangleMode.rsOrdinal();
         return 1;
      } else if (var0 == 1614) {
         Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var3.modelTransparency ? 1 : 0;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(ILcg;ZI)I",
      garbageValue = "1256509027"
   )
   static int method1187(int var0, Script var1, boolean var2) {
      if (var0 == ScriptOpcodes.CLIENTCLOCK) {
         Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = Client.cycle;
         return 1;
      } else {
         int var3;
         int var4;
         if (var0 == ScriptOpcodes.INV_GETOBJ) {
            RouteStrategy.Interpreter_intStackSize -= 2;
            var3 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize];
            var4 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize + 1];
            Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = class83.method2027(var3, var4);
            return 1;
         } else if (var0 == ScriptOpcodes.INV_GETNUM) {
            RouteStrategy.Interpreter_intStackSize -= 2;
            var3 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize];
            var4 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize + 1];
            Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = WorldMapLabel.method442(var3, var4);
            return 1;
         } else if (var0 == ScriptOpcodes.INV_TOTAL) {
            RouteStrategy.Interpreter_intStackSize -= 2;
            var3 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize];
            var4 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize + 1];
            Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = class1.method18(var3, var4);
            return 1;
         } else if (var0 == ScriptOpcodes.INV_SIZE) {
            var3 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize];
            Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = WorldMapDecorationType.method4523(var3).size;
            return 1;
         } else if (var0 == ScriptOpcodes.STAT) {
            var3 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize];
            Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = Client.currentLevels[var3];
            return 1;
         } else if (var0 == ScriptOpcodes.STAT_BASE) {
            var3 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize];
            Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = Client.levels[var3];
            return 1;
         } else if (var0 == ScriptOpcodes.STAT_XP) {
            var3 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize];
            Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = Client.experience[var3];
            return 1;
         } else {
            int var5;
            if (var0 == ScriptOpcodes.COORD) {
               var3 = SoundSystem.plane;
               var4 = (Canvas.localPlayer.x >> 7) + class50.baseX;
               var5 = (Canvas.localPlayer.y >> 7) + GraphicsObject.baseY;
               Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = (var4 << 14) + var5 + (var3 << 28);
               return 1;
            } else if (var0 == ScriptOpcodes.COORDX) {
               var3 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize];
               Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var3 >> 14 & 16383;
               return 1;
            } else if (var0 == ScriptOpcodes.COORDZ) {
               var3 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize];
               Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var3 >> 28;
               return 1;
            } else if (var0 == ScriptOpcodes.COORDY) {
               var3 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize];
               Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var3 & 16383;
               return 1;
            } else if (var0 == ScriptOpcodes.MAP_MEMBERS) {
               Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = Client.isMembersWorld ? 1 : 0;
               return 1;
            } else if (var0 == ScriptOpcodes.INVOTHER_GETOBJ) {
               RouteStrategy.Interpreter_intStackSize -= 2;
               var3 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize] + 32768;
               var4 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize + 1];
               Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = class83.method2027(var3, var4);
               return 1;
            } else if (var0 == ScriptOpcodes.INVOTHER_GETNUM) {
               RouteStrategy.Interpreter_intStackSize -= 2;
               var3 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize] + 32768;
               var4 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize + 1];
               Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = WorldMapLabel.method442(var3, var4);
               return 1;
            } else if (var0 == ScriptOpcodes.INVOTHER_TOTAL) {
               RouteStrategy.Interpreter_intStackSize -= 2;
               var3 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize] + 32768;
               var4 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize + 1];
               Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = class1.method18(var3, var4);
               return 1;
            } else if (var0 == ScriptOpcodes.STAFFMODLEVEL) {
               if (Client.staffModLevel >= 2) {
                  Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = Client.staffModLevel;
               } else {
                  Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = 0;
               }

               return 1;
            } else if (var0 == ScriptOpcodes.REBOOTTIMER) {
               Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = Client.rebootTimer;
               return 1;
            } else if (var0 == ScriptOpcodes.MAP_WORLD) {
               Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = Client.worldId;
               return 1;
            } else if (var0 == ScriptOpcodes.RUNENERGY_VISIBLE) {
               Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = Client.runEnergy;
               return 1;
            } else if (var0 == ScriptOpcodes.RUNWEIGHT_VISIBLE) {
               Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = Client.weight;
               return 1;
            } else if (var0 == ScriptOpcodes.PLAYERMOD) {
               if (Client.playerMod) {
                  Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = 1;
               } else {
                  Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = 0;
               }

               return 1;
            } else if (var0 == ScriptOpcodes.WORLDFLAGS) {
               Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = Client.worldProperties;
               return 1;
            } else if (var0 == ScriptOpcodes.MOVECOORD) {
               RouteStrategy.Interpreter_intStackSize -= 4;
               var3 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize];
               var4 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize + 1];
               var5 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize + 2];
               int var6 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize + 3];
               var3 += var4 << 14;
               var3 += var5 << 28;
               var3 += var6;
               Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var3;
               return 1;
            } else {
               return 2;
            }
         }
      }
   }

   @ObfuscatedName("ep")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-52"
   )
   static void method1183(int var0, int var1) {
      int[] var2 = new int[9];

      for (int var3 = 0; var3 < var2.length; ++var3) {
         int var4 = var3 * 32 + 15 + 128;
         int var5 = var4 * 3 + 600;
         int var6 = Rasterizer3D.Rasterizer3D_sine[var4];
         int var7 = method1176(var5, var1);
         var2[var3] = var7 * var6 >> 16;
      }

      Scene.Scene_buildVisiblityMap(var2, 500, 800, var0 * 334 / var1, 334);
   }

   @ObfuscatedName("gj")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-914543563"
   )
   static int method1176(int var0, int var1) {
      int var2 = var1 - 334;
      if (var2 < 0) {
         var2 = 0;
      } else if (var2 > 100) {
         var2 = 100;
      }

      int var3 = (Client.field149 - Client.field150) * var2 / 100 + Client.field150;
      return var0 * var3 / 256;
   }

   @ObfuscatedName("hf")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "35"
   )
   static final void method1179() {
      for (PendingSpawn var0 = (PendingSpawn)Client.pendingSpawns.last(); var0 != null; var0 = (PendingSpawn)Client.pendingSpawns.previous()) {
         if (var0.hitpoints == -1) {
            var0.delay = 0;
            class13.method165(var0);
         } else {
            var0.remove();
         }
      }

   }
}
