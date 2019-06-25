import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("k")
final class class11 implements Comparator {
   @ObfuscatedName("hl")
   @ObfuscatedGetter(
      intValue = -1945589829
   )
   @Export("cameraZ")
   static int cameraZ;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ll;Ll;B)I",
      garbageValue = "1"
   )
   int method138(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      return var1.__m_3().compareTo(var2.__m_3());
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method138((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lhx;B)V",
      garbageValue = "26"
   )
   @Export("updatePlayer")
   static final void updatePlayer(PacketBuffer var0) {
      var0.importIndex();
      int var1 = Client.localPlayerIndex;
      Player var2 = Canvas.localPlayer = Client.players[var1] = new Player();
      var2.index = var1;
      int var3 = var0.readBits(30);
      byte var4 = (byte)(var3 >> 28);
      int var5 = var3 >> 14 & 16383;
      int var6 = var3 & 16383;
      var2.pathX[0] = var5 - class50.baseX;
      var2.x = (var2.pathX[0] << 7) + (var2.transformedSize() << 6);
      var2.pathY[0] = var6 - GraphicsObject.baseY;
      var2.y = (var2.pathY[0] << 7) + (var2.transformedSize() << 6);
      SoundSystem.plane = var2.plane = var4;
      if(Players.__cq_o[var1] != null) {
         var2.read(Players.__cq_o[var1]);
      }

      Players.Players_count = 0;
      Players.Players_indices[++Players.Players_count - 1] = var1;
      Players.__cq_q[var1] = 0;
      Players.__cq_l = 0;

      for(int var7 = 1; var7 < 2048; ++var7) {
         if(var1 != var7) {
            int var8 = var0.readBits(18);
            int var9 = var8 >> 16;
            int var10 = var8 >> 8 & 597;
            int var11 = var8 & 597;
            Players.Players_regions[var7] = (var10 << 14) + var11 + (var9 << 28);
            Players.Players_orientations[var7] = 0;
            Players.Players_targetIndices[var7] = -1;
            Players.__cq_e[++Players.__cq_l - 1] = var7;
            Players.__cq_q[var7] = 0;
         }
      }

      var0.exportIndex();
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(ILcg;ZI)I",
      garbageValue = "1948861515"
   )
   static int method141(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = Huffman.getWidget(Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize]);
      } else {
         var3 = var2?WorldMapIcon1.__t_i:class12.__n_n;
      }

      String var4 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
      int[] var5 = null;
      if(var4.length() > 0 && var4.charAt(var4.length() - 1) == 'Y') {
         int var6 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
         if(var6 > 0) {
            for(var5 = new int[var6]; var6-- > 0; var5[var6] = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize]) {
               ;
            }
         }

         var4 = var4.substring(0, var4.length() - 1);
      }

      Object[] var8 = new Object[var4.length() + 1];

      int var7;
      for(var7 = var8.length - 1; var7 >= 1; --var7) {
         if(var4.charAt(var7 - 1) == 's') {
            var8[var7] = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
         } else {
            var8[var7] = new Integer(Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize]);
         }
      }

      var7 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
      if(var7 != -1) {
         var8[0] = new Integer(var7);
      } else {
         var8 = null;
      }

      if(var0 == 1400) {
         var3.onClick = var8;
      } else if(var0 == 1401) {
         var3.onHold = var8;
      } else if(var0 == 1402) {
         var3.onRelease = var8;
      } else if(var0 == 1403) {
         var3.onMouseOver = var8;
      } else if(var0 == 1404) {
         var3.onMouseLeave = var8;
      } else if(var0 == 1405) {
         var3.onDrag = var8;
      } else if(var0 == 1406) {
         var3.onTargetLeave = var8;
      } else if(var0 == 1407) {
         var3.onVarTransmit = var8;
         var3.varTransmitTriggers = var5;
      } else if(var0 == 1408) {
         var3.onTimer = var8;
      } else if(var0 == 1409) {
         var3.onOp = var8;
      } else if(var0 == 1410) {
         var3.onDragComplete = var8;
      } else if(var0 == 1411) {
         var3.onClickRepeat = var8;
      } else if(var0 == 1412) {
         var3.onMouseRepeat = var8;
      } else if(var0 == 1414) {
         var3.onInvTransmit = var8;
         var3.invTransmitTriggers = var5;
      } else if(var0 == 1415) {
         var3.onStatTransmit = var8;
         var3.statTransmitTriggers = var5;
      } else if(var0 == 1416) {
         var3.onTargetEnter = var8;
      } else if(var0 == 1417) {
         var3.onScroll = var8;
      } else if(var0 == 1418) {
         var3.__em = var8;
      } else if(var0 == 1419) {
         var3.onKeyListener = var8;
      } else if(var0 == 1420) {
         var3.__ex = var8;
      } else if(var0 == 1421) {
         var3.__ej = var8;
      } else if(var0 == 1422) {
         var3.__el = var8;
      } else if(var0 == 1423) {
         var3.onDialogAbortListener = var8;
      } else if(var0 == 1424) {
         var3.__ei = var8;
      } else if(var0 == 1425) {
         var3.__eq = var8;
      } else if(var0 == 1426) {
         var3.__eh = var8;
      } else {
         if(var0 != 1427) {
            return 2;
         }

         var3.__ee = var8;
      }

      var3.hasListener = true;
      return 1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(ILcg;ZI)I",
      garbageValue = "1020189514"
   )
   static int method146(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 == 2700) {
         var3 = Huffman.getWidget(Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize]);
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3.itemId;
         return 1;
      } else if(var0 == 2701) {
         var3 = Huffman.getWidget(Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize]);
         if(var3.itemId != -1) {
            Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3.itemQuantity;
         } else {
            Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = 0;
         }

         return 1;
      } else if(var0 == 2702) {
         int var5 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
         WidgetGroupParent var4 = (WidgetGroupParent)Client.widgetGroupParents.get((long)var5);
         if(var4 != null) {
            Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = 1;
         } else {
            Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = 0;
         }

         return 1;
      } else if(var0 == 2706) {
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = Client.rootWidgetGroup;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-87"
   )
   protected static final void method145() {
      UserComparator6.clock.mark();

      int var0;
      for(var0 = 0; var0 < 32; ++var0) {
         GameShell.__ba_a[var0] = 0L;
      }

      for(var0 = 0; var0 < 32; ++var0) {
         GameShell.__ba_j[var0] = 0L;
      }

      GameShell.__ba_l = 0;
   }

   @ObfuscatedName("ih")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "-1292134247"
   )
   static final void method148(int var0, int var1, int var2, int var3, int var4) {
      class32.scrollBarSprites[0].__q_496(var0, var1);
      class32.scrollBarSprites[1].__q_496(var0, var3 + var1 - 16);
      Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1 + 16, 16, var3 - 32, Client.__client_hx);
      int var5 = var3 * (var3 - 32) / var4;
      if(var5 < 8) {
         var5 = 8;
      }

      int var6 = (var3 - 32 - var5) * var2 / (var4 - var3);
      Rasterizer2D.Rasterizer2D_fillRectangle(var0, var6 + var1 + 16, 16, var5, Client.__client_hn);
      Rasterizer2D.Rasterizer2D_drawVerticalLine(var0, var6 + var1 + 16, var5, Client.__client_hg);
      Rasterizer2D.Rasterizer2D_drawVerticalLine(var0 + 1, var6 + var1 + 16, var5, Client.__client_hg);
      Rasterizer2D.Rasterizer2D_drawHorizontalLine(var0, var6 + var1 + 16, 16, Client.__client_hg);
      Rasterizer2D.Rasterizer2D_drawHorizontalLine(var0, var6 + var1 + 17, 16, Client.__client_hg);
      Rasterizer2D.Rasterizer2D_drawVerticalLine(var0 + 15, var6 + var1 + 16, var5, Client.__client_hr);
      Rasterizer2D.Rasterizer2D_drawVerticalLine(var0 + 14, var6 + var1 + 17, var5 - 1, Client.__client_hr);
      Rasterizer2D.Rasterizer2D_drawHorizontalLine(var0, var5 + var6 + var1 + 15, 16, Client.__client_hr);
      Rasterizer2D.Rasterizer2D_drawHorizontalLine(var0 + 1, var6 + var5 + var1 + 14, 15, Client.__client_hr);
   }
}
