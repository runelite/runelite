import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("u")
public class class12 extends Renderable {
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1215597781
   )
   int field171;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -2028467475
   )
   int field173;
   @ObfuscatedName("m")
   Sequence field174;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1030718893
   )
   int field175;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1825039599
   )
   int field176;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 227542421
   )
   int field177;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -740547187
   )
   int field178;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1112541107
   )
   int field179;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -942909961
   )
   int field180;
   @ObfuscatedName("cx")
   static class149 field181;

   @ObfuscatedName("z")
   static final void method157(long var0) {
      try {
         Thread.sleep(var0);
      } catch (InterruptedException var3) {
         ;
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)LModel;",
      garbageValue = "-26"
   )
   protected final Model getModel() {
      if(this.field174 != null) {
         int var1 = Client.gameCycle - this.field180;
         if(var1 > 100 && this.field174.field973 > 0) {
            var1 = 100;
         }

         label60: {
            do {
               do {
                  if(var1 <= this.field174.field981[this.field178]) {
                     break label60;
                  }

                  var1 -= this.field174.field981[this.field178];
                  ++this.field178;
               } while(this.field178 < this.field174.field969.length);

               this.field178 -= this.field174.field973;
            } while(this.field178 >= 0 && this.field178 < this.field174.field969.length);

            this.field174 = null;
         }

         this.field180 = Client.gameCycle - var1;
      }

      ObjectComposition var12 = class40.getObjectDefinition(this.field179);
      if(var12.impostorIds != null) {
         var12 = var12.getImpostor();
      }

      if(var12 == null) {
         return null;
      } else {
         int var2;
         int var3;
         if(this.field173 != 1 && this.field173 != 3) {
            var2 = var12.field923;
            var3 = var12.field924;
         } else {
            var2 = var12.field924;
            var3 = var12.field923;
         }

         int var4 = (var2 >> 1) + this.field175;
         int var5 = this.field175 + (var2 + 1 >> 1);
         int var6 = this.field176 + (var3 >> 1);
         int var7 = (var3 + 1 >> 1) + this.field176;
         int[][] var8 = class5.tileHeights[this.field177];
         int var9 = var8[var4][var7] + var8[var4][var6] + var8[var5][var6] + var8[var5][var7] >> 2;
         int var10 = (this.field175 << 7) + (var2 << 6);
         int var11 = (var3 << 6) + (this.field176 << 7);
         return var12.method815(this.field171, this.field173, var8, var10, var9, var11, this.field174, this.field178);
      }
   }

   class12(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, Renderable var9) {
      this.field179 = var1;
      this.field171 = var2;
      this.field173 = var3;
      this.field177 = var4;
      this.field175 = var5;
      this.field176 = var6;
      if(var7 != -1) {
         this.field174 = class4.getAnimation(var7);
         this.field178 = 0;
         this.field180 = Client.gameCycle - 1;
         if(this.field174.replyMode == 0 && var9 != null && var9 instanceof class12) {
            class12 var10 = (class12)var9;
            if(var10.field174 == this.field174) {
               this.field178 = var10.field178;
               this.field180 = var10.field180;
               return;
            }
         }

         if(var8 && this.field174.field973 != -1) {
            this.field178 = (int)(Math.random() * (double)this.field174.field969.length);
            this.field180 -= (int)(Math.random() * (double)this.field174.field981[this.field178]);
         }
      }

   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;S)V",
      garbageValue = "-15528"
   )
   static void method159(int var0, String var1) {
      int var2 = class34.field743;
      int[] var3 = class34.field739;
      boolean var4 = false;

      for(int var5 = 0; var5 < var2; ++var5) {
         Player var6 = Client.cachedPlayers[var3[var5]];
         if(null != var6 && var6 != TextureProvider.localPlayer && var6.name != null && var6.name.equalsIgnoreCase(var1)) {
            if(var0 == 1) {
               Client.field300.method2748(139);
               Client.field300.method2513(var3[var5]);
               Client.field300.method2467(0);
            } else if(var0 == 4) {
               Client.field300.method2748(247);
               Client.field300.method2466(0);
               Client.field300.method2655(var3[var5]);
            } else if(var0 == 6) {
               Client.field300.method2748(249);
               Client.field300.method2513(var3[var5]);
               Client.field300.method2466(0);
            } else if(var0 == 7) {
               Client.field300.method2748(240);
               Client.field300.method2655(var3[var5]);
               Client.field300.method2467(0);
            }

            var4 = true;
            break;
         }
      }

      if(!var4) {
         Player.sendGameMessage(4, "", "Unable to find " + var1);
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(LWidget;III)V",
      garbageValue = "948918985"
   )
   static final void method160(Widget var0, int var1, int var2) {
      if(Client.field326 == 0 || Client.field326 == 3) {
         if(class143.field2198 == 1 || !class18.field245 && class143.field2198 == 4) {
            class178 var3 = var0.method3407(true);
            if(null == var3) {
               return;
            }

            int var4 = class143.field2188 - var1;
            int var5 = class143.field2196 - var2;
            if(var3.method3447(var4, var5)) {
               var4 -= var3.field2943 / 2;
               var5 -= var3.field2944 / 2;
               int var6 = Client.mapScale + Client.mapAngle & 2047;
               int var7 = class94.field1631[var6];
               int var8 = class94.field1621[var6];
               var7 = (256 + Client.mapScaleDelta) * var7 >> 8;
               var8 = var8 * (256 + Client.mapScaleDelta) >> 8;
               int var9 = var4 * var8 + var5 * var7 >> 11;
               int var10 = var8 * var5 - var4 * var7 >> 11;
               int var11 = var9 + TextureProvider.localPlayer.x >> 7;
               int var12 = TextureProvider.localPlayer.y - var10 >> 7;
               Client.field300.method2748(242);
               Client.field300.method2467(18);
               Client.field300.method2513(class8.baseY + var12);
               Client.field300.method2514(var11 + class23.baseX);
               Client.field300.method2505(class140.field2157[82]?(class140.field2157[81]?2:1):0);
               Client.field300.method2467(var4);
               Client.field300.method2467(var5);
               Client.field300.method2468(Client.mapAngle);
               Client.field300.method2467(57);
               Client.field300.method2467(Client.mapScale);
               Client.field300.method2467(Client.mapScaleDelta);
               Client.field300.method2467(89);
               Client.field300.method2468(TextureProvider.localPlayer.x);
               Client.field300.method2468(TextureProvider.localPlayer.y);
               Client.field300.method2467(63);
               Client.flagX = var11;
               Client.flagY = var12;
            }
         }

      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIIIIII)I",
      garbageValue = "2043679319"
   )
   public static int method161(int var0, int var1, int var2, int var3, int var4, int var5) {
      if((var5 & 1) == 1) {
         int var6 = var3;
         var3 = var4;
         var4 = var6;
      }

      var2 &= 3;
      return var2 == 0?var1:(var2 == 1?7 - var0 - (var3 - 1):(var2 == 2?7 - var1 - (var4 - 1):var0));
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-84"
   )
   static final void method162() {
      if(null != Client.field527) {
         Client.field527.method1184();
      }

      if(null != class22.field576) {
         class22.field576.method1184();
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SIIB)V",
      garbageValue = "94"
   )
   public static void method163(String[] var0, short[] var1, int var2, int var3) {
      if(var2 < var3) {
         int var4 = (var3 + var2) / 2;
         int var5 = var2;
         String var6 = var0[var4];
         var0[var4] = var0[var3];
         var0[var3] = var6;
         short var7 = var1[var4];
         var1[var4] = var1[var3];
         var1[var3] = var7;

         for(int var8 = var2; var8 < var3; ++var8) {
            if(null == var6 || var0[var8] != null && var0[var8].compareTo(var6) < (var8 & 1)) {
               String var9 = var0[var8];
               var0[var8] = var0[var5];
               var0[var5] = var9;
               short var10 = var1[var8];
               var1[var8] = var1[var5];
               var1[var5++] = var10;
            }
         }

         var0[var3] = var0[var5];
         var0[var5] = var6;
         var1[var3] = var1[var5];
         var1[var5] = var7;
         method163(var0, var1, var2, var5 - 1);
         method163(var0, var1, 1 + var5, var3);
      }

   }
}
