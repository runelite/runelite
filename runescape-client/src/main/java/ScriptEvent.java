import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

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
   @Export("__d")
   int __d;
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
   public void setArgs(Object[] var1) {
      this.args0 = var1;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-110"
   )
   @Export("setType")
   public void setType(int var1) {
      this.type0 = var1;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(ILcg;ZB)I",
      garbageValue = "0"
   )
   static int method1185(int var0, Script var1, boolean var2) {
      Widget var3 = var2?WorldMapIcon1.__t_i:class12.__n_n;
      if(var0 == 1600) {
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3.scrollX;
         return 1;
      } else if(var0 == 1601) {
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3.scrollY;
         return 1;
      } else if(var0 == 1602) {
         Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3.text;
         return 1;
      } else if(var0 == 1603) {
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3.scrollWidth;
         return 1;
      } else if(var0 == 1604) {
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3.scrollHeight;
         return 1;
      } else if(var0 == 1605) {
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3.modelZoom;
         return 1;
      } else if(var0 == 1606) {
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3.modelAngleX;
         return 1;
      } else if(var0 == 1607) {
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3.modelAngleZ;
         return 1;
      } else if(var0 == 1608) {
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3.modelAngleY;
         return 1;
      } else if(var0 == 1609) {
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3.transparency;
         return 1;
      } else if(var0 == 1610) {
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3.__af;
         return 1;
      } else if(var0 == 1611) {
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3.color;
         return 1;
      } else if(var0 == 1612) {
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3.color2;
         return 1;
      } else if(var0 == 1613) {
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3.rectangleMode.ordinal();
         return 1;
      } else if(var0 == 1614) {
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3.__bv?1:0;
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
      if(var0 == 3300) {
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = Client.cycle;
         return 1;
      } else {
         int var3;
         int var4;
         if(var0 == 3301) {
            class179.Interpreter_intStackSize -= 2;
            var3 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize];
            var4 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1];
            Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = class83.method2027(var3, var4);
            return 1;
         } else if(var0 == 3302) {
            class179.Interpreter_intStackSize -= 2;
            var3 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize];
            var4 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1];
            Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = WorldMapLabel.method442(var3, var4);
            return 1;
         } else if(var0 == 3303) {
            class179.Interpreter_intStackSize -= 2;
            var3 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize];
            var4 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1];
            Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = class1.method18(var3, var4);
            return 1;
         } else if(var0 == 3304) {
            var3 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
            Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = class231.method4523(var3).size;
            return 1;
         } else if(var0 == 3305) {
            var3 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
            Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = Client.currentLevels[var3];
            return 1;
         } else if(var0 == 3306) {
            var3 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
            Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = Client.levels[var3];
            return 1;
         } else if(var0 == 3307) {
            var3 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
            Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = Client.experience[var3];
            return 1;
         } else {
            int var5;
            if(var0 == 3308) {
               var3 = SoundSystem.plane;
               var4 = (Canvas.localPlayer.x >> 7) + class50.baseX;
               var5 = (Canvas.localPlayer.y >> 7) + GraphicsObject.baseY;
               Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = (var4 << 14) + var5 + (var3 << 28);
               return 1;
            } else if(var0 == 3309) {
               var3 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
               Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3 >> 14 & 16383;
               return 1;
            } else if(var0 == 3310) {
               var3 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
               Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3 >> 28;
               return 1;
            } else if(var0 == 3311) {
               var3 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
               Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3 & 16383;
               return 1;
            } else if(var0 == 3312) {
               Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = Client.isMembersWorld?1:0;
               return 1;
            } else if(var0 == 3313) {
               class179.Interpreter_intStackSize -= 2;
               var3 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize] + 32768;
               var4 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1];
               Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = class83.method2027(var3, var4);
               return 1;
            } else if(var0 == 3314) {
               class179.Interpreter_intStackSize -= 2;
               var3 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize] + 32768;
               var4 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1];
               Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = WorldMapLabel.method442(var3, var4);
               return 1;
            } else if(var0 == 3315) {
               class179.Interpreter_intStackSize -= 2;
               var3 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize] + 32768;
               var4 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1];
               Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = class1.method18(var3, var4);
               return 1;
            } else if(var0 == 3316) {
               if(Client.rights >= 2) {
                  Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = Client.rights;
               } else {
                  Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = 0;
               }

               return 1;
            } else if(var0 == 3317) {
               Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = Client.rebootTimer;
               return 1;
            } else if(var0 == 3318) {
               Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = Client.worldId;
               return 1;
            } else if(var0 == 3321) {
               Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = Client.runEnergy;
               return 1;
            } else if(var0 == 3322) {
               Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = Client.weight;
               return 1;
            } else if(var0 == 3323) {
               if(Client.__client_mn) {
                  Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = 1;
               } else {
                  Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = 0;
               }

               return 1;
            } else if(var0 == 3324) {
               Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = Client.worldProperties;
               return 1;
            } else if(var0 == 3325) {
               class179.Interpreter_intStackSize -= 4;
               var3 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize];
               var4 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1];
               var5 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 2];
               int var6 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 3];
               var3 += var4 << 14;
               var3 += var5 << 28;
               var3 += var6;
               Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3;
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

      for(int var3 = 0; var3 < var2.length; ++var3) {
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
      if(var2 < 0) {
         var2 = 0;
      } else if(var2 > 100) {
         var2 = 100;
      }

      int var3 = (Client.__client_rb - Client.__client_re) * var2 / 100 + Client.__client_re;
      return var0 * var3 / 256;
   }

   @ObfuscatedName("hf")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "35"
   )
   static final void method1179() {
      for(class68 var0 = (class68)Client.__client_kh.last(); var0 != null; var0 = (class68)Client.__client_kh.previous()) {
         if(var0.field910 == -1) {
            var0.field909 = 0;
            class13.method165(var0);
         } else {
            var0.remove();
         }
      }

   }
}
