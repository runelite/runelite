import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jq")
@Implements("StructDefinition")
public class StructDefinition extends DualNode {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   @Export("__jq_m")
   public static AbstractIndexCache __jq_m;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Ler;"
   )
   @Export("__jq_f")
   public static EvictingDualNodeHashTable __jq_f;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Llh;"
   )
   @Export("params")
   IterableNodeHashTable params;

   static {
      __jq_f = new EvictingDualNodeHashTable(64);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-16"
   )
   @Export("init")
   void init() {
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgr;I)V",
      garbageValue = "853330780"
   )
   @Export("read")
   void read(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.readNext(var1, var2);
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lgr;II)V",
      garbageValue = "-2035893488"
   )
   @Export("readNext")
   void readNext(Buffer var1, int var2) {
      if(var2 == 249) {
         this.params = AbstractIndexCache.readStringIntParameters(var1, this.params);
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-30"
   )
   @Export("getIntParam")
   public int getIntParam(int var1, int var2) {
      IterableNodeHashTable var4 = this.params;
      int var3;
      if(var4 == null) {
         var3 = var2;
      } else {
         IntegerNode var5 = (IntegerNode)var4.get((long)var1);
         if(var5 == null) {
            var3 = var2;
         } else {
            var3 = var5.integer;
         }
      }

      return var3;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-343626362"
   )
   @Export("getStringParam")
   public String getStringParam(int var1, String var2) {
      return Frames.method3238(this.params, var1, var2);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(ILcg;ZI)I",
      garbageValue = "2127224103"
   )
   static int method4952(int var0, Script var1, boolean var2) {
      int var4 = -1;
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var4 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
         var3 = Huffman.getWidget(var4);
      } else {
         var3 = var2?WorldMapIcon1.__t_i:class12.__n_n;
      }

      if(var0 == 1100) {
         class179.Interpreter_intStackSize -= 2;
         var3.scrollX = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize];
         if(var3.scrollX > var3.scrollWidth - var3.width) {
            var3.scrollX = var3.scrollWidth - var3.width;
         }

         if(var3.scrollX < 0) {
            var3.scrollX = 0;
         }

         var3.scrollY = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1];
         if(var3.scrollY > var3.scrollHeight - var3.height) {
            var3.scrollY = var3.scrollHeight - var3.height;
         }

         if(var3.scrollY < 0) {
            var3.scrollY = 0;
         }

         class22.method295(var3);
         return 1;
      } else if(var0 == 1101) {
         var3.color = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
         class22.method295(var3);
         return 1;
      } else if(var0 == 1102) {
         var3.fill = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize] == 1;
         class22.method295(var3);
         return 1;
      } else if(var0 == 1103) {
         var3.transparency = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
         class22.method295(var3);
         return 1;
      } else if(var0 == 1104) {
         var3.lineWid = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
         class22.method295(var3);
         return 1;
      } else if(var0 == 1105) {
         var3.spriteId2 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
         class22.method295(var3);
         return 1;
      } else if(var0 == 1106) {
         var3.spriteAngle = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
         class22.method295(var3);
         return 1;
      } else if(var0 == 1107) {
         var3.spriteTiling = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize] == 1;
         class22.method295(var3);
         return 1;
      } else if(var0 == 1108) {
         var3.modelType = 1;
         var3.modelId = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
         class22.method295(var3);
         return 1;
      } else if(var0 == 1109) {
         class179.Interpreter_intStackSize -= 6;
         var3.modelOffsetX = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize];
         var3.modelOffsetY = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1];
         var3.modelAngleX = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 2];
         var3.modelAngleY = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 3];
         var3.modelAngleZ = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 4];
         var3.modelZoom = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 5];
         class22.method295(var3);
         return 1;
      } else {
         int var8;
         if(var0 == 1110) {
            var8 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
            if(var8 != var3.sequenceId) {
               var3.sequenceId = var8;
               var3.modelFrame = 0;
               var3.modelFrameCycle = 0;
               class22.method295(var3);
            }

            return 1;
         } else if(var0 == 1111) {
            var3.modelOrthog = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize] == 1;
            class22.method295(var3);
            return 1;
         } else if(var0 == 1112) {
            String var7 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
            if(!var7.equals(var3.text)) {
               var3.text = var7;
               class22.method295(var3);
            }

            return 1;
         } else if(var0 == 1113) {
            var3.fontId = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
            class22.method295(var3);
            return 1;
         } else if(var0 == 1114) {
            class179.Interpreter_intStackSize -= 3;
            var3.textXAlignment = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize];
            var3.textYAlignment = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1];
            var3.textLineHeight = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 2];
            class22.method295(var3);
            return 1;
         } else if(var0 == 1115) {
            var3.textShadowed = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize] == 1;
            class22.method295(var3);
            return 1;
         } else if(var0 == 1116) {
            var3.outline = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
            class22.method295(var3);
            return 1;
         } else if(var0 == 1117) {
            var3.spriteShadow = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
            class22.method295(var3);
            return 1;
         } else if(var0 == 1118) {
            var3.spriteFlipV = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize] == 1;
            class22.method295(var3);
            return 1;
         } else if(var0 == 1119) {
            var3.spriteFlipH = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize] == 1;
            class22.method295(var3);
            return 1;
         } else if(var0 == 1120) {
            class179.Interpreter_intStackSize -= 2;
            var3.scrollWidth = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize];
            var3.scrollHeight = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1];
            class22.method295(var3);
            if(var4 != -1 && var3.type == 0) {
               class39.revalidateWidgetScroll(Widget.widgets[var4 >> 16], var3, false);
            }

            return 1;
         } else if(var0 == 1121) {
            TilePaint.method3060(var3.id, var3.childIndex);
            Client.__client_mo = var3;
            class22.method295(var3);
            return 1;
         } else if(var0 == 1122) {
            var3.spriteId = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
            class22.method295(var3);
            return 1;
         } else if(var0 == 1123) {
            var3.color2 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
            class22.method295(var3);
            return 1;
         } else if(var0 == 1124) {
            var3.__af = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
            class22.method295(var3);
            return 1;
         } else if(var0 == 1125) {
            var8 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
            RectangleMode var6 = (RectangleMode)ScriptFrame.findEnumerated(class311.method5822(), var8);
            if(var6 != null) {
               var3.rectangleMode = var6;
               class22.method295(var3);
            }

            return 1;
         } else {
            boolean var5;
            if(var0 == 1126) {
               var5 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize] == 1;
               var3.__ba = var5;
               return 1;
            } else if(var0 == 1127) {
               var5 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize] == 1;
               var3.__bv = var5;
               return 1;
            } else {
               return 2;
            }
         }
      }
   }
}
