import java.awt.Canvas;
import java.awt.Color;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.URL;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ap")
public class class26 {
   @ObfuscatedName("pw")
   static class1 field576;
   @ObfuscatedName("y")
   class102 field577;
   @ObfuscatedName("o")
   DataInputStream field578;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1559205593
   )
   int field580;
   @ObfuscatedName("j")
   byte[] field581;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      longValue = 7323020000486406013L
   )
   long field583;
   @ObfuscatedName("r")
   byte[] field584 = new byte[4];
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -974255853
   )
   int field586;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -213488689
   )
   int field587;

   class26(class103 var1, URL var2) {
      this.field577 = var1.method1947(var2);
      this.field587 = 0;
      this.field583 = class22.method224() + 30000L;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "1392697159"
   )
   byte[] method616() throws IOException {
      if(class22.method224() > this.field583) {
         throw new IOException();
      } else {
         if(this.field587 == 0) {
            if(this.field577.field1667 == 2) {
               throw new IOException();
            }

            if(this.field577.field1667 == 1) {
               this.field578 = (DataInputStream)this.field577.field1675;
               this.field587 = 1;
            }
         }

         int var1;
         if(this.field587 == 1) {
            var1 = this.field578.available();
            if(var1 > 0) {
               if(var1 + this.field580 > 4) {
                  var1 = 4 - this.field580;
               }

               this.field580 += this.field578.read(this.field584, this.field580, var1);
               if(this.field580 == 4) {
                  int var2 = (new Buffer(this.field584)).method3062();
                  this.field581 = new byte[var2];
                  this.field587 = 2;
               }
            }
         }

         if(this.field587 == 2) {
            var1 = this.field578.available();
            if(var1 > 0) {
               if(var1 + this.field586 > this.field581.length) {
                  var1 = this.field581.length - this.field586;
               }

               this.field586 += this.field578.read(this.field581, this.field586, var1);
               if(this.field586 == this.field581.length) {
                  return this.field581;
               }
            }
         }

         return null;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass166;I)V",
      garbageValue = "763464670"
   )
   static final void method621(class166 var0) {
      var0.method3175();
      int var1 = Client.localInteractingIndex;
      Player var2 = VertexNormal.localPlayer = Client.cachedPlayers[var1] = new Player();
      var2.field256 = var1;
      int var3 = var0.method3176(30);
      byte var4 = (byte)(var3 >> 28);
      int var5 = var3 >> 14 & 16383;
      int var6 = var3 & 16383;
      var2.pathX[0] = var5 - class114.baseX;
      var2.x = (var2.pathX[0] << 7) + (var2.method236() << 6);
      var2.pathY[0] = var6 - CombatInfo1.baseY;
      var2.y = (var2.pathY[0] << 7) + (var2.method236() << 6);
      class48.plane = var2.field263 = var4;
      if(null != class45.field900[var1]) {
         var2.method235(class45.field900[var1]);
      }

      class45.field901 = 0;
      class45.field902[++class45.field901 - 1] = var1;
      class45.field898[var1] = 0;
      class45.field903 = 0;

      for(int var7 = 1; var7 < 2048; ++var7) {
         if(var7 != var1) {
            int var8 = var0.method3176(18);
            int var9 = var8 >> 16;
            int var10 = var8 >> 8 & 597;
            int var11 = var8 & 597;
            class45.field911[var7] = (var9 << 28) + (var10 << 14) + var11;
            class45.field906[var7] = 0;
            class45.field907[var7] = -1;
            class45.field905[++class45.field903 - 1] = var7;
            class45.field898[var7] = 0;
         }
      }

      var0.method3177();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass182;Ljava/lang/String;Ljava/lang/String;I)[LSpritePixels;",
      garbageValue = "716271319"
   )
   public static SpritePixels[] method622(class182 var0, String var1, String var2) {
      int var3 = var0.method3284(var1);
      int var4 = var0.method3285(var3, var2);
      return class182.method3333(var0, var3, var4);
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-481596035"
   )
   static void method623() {
      Canvas var0 = class32.canvas;
      var0.removeKeyListener(class105.keyboard);
      var0.removeFocusListener(class105.keyboard);
      class105.field1719 = -1;
      class189.method3452(class32.canvas);
      if(class8.field76 != null) {
         class8.field76.vmethod2088(class32.canvas);
      }

      Client.field277.method2094();
      class32.canvas.setBackground(Color.black);
      Canvas var1 = class32.canvas;
      var1.setFocusTraversalKeysEnabled(false);
      var1.addKeyListener(class105.keyboard);
      var1.addFocusListener(class105.keyboard);
      FrameMap.method1704(class32.canvas);
      if(class8.field76 != null) {
         class8.field76.vmethod2079(class32.canvas);
      }

      if(Client.widgetRoot != -1) {
         class8.method117(false);
      }

      GameEngine.field1778 = true;
   }
}
