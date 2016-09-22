import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eh")
public class class144 extends class136 {
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -632638865
   )
   int field2233 = 0;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 632599029
   )
   int field2234 = 256;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1902029071
   )
   int field2235 = 1;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      longValue = -4734313290727928835L
   )
   long field2236 = class5.method63();
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1287259391
   )
   static int field2237;
   @ObfuscatedName("a")
   long[] field2239 = new long[10];
   @ObfuscatedName("ae")
   static class171 field2240;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 671466173
   )
   int field2242;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2077774028"
   )
   public void vmethod3147() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2239[var1] = 0L;
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1886051607"
   )
   int vmethod3149(int var1, int var2) {
      int var3 = this.field2234;
      int var4 = this.field2235;
      this.field2234 = 300;
      this.field2235 = 1;
      this.field2236 = class5.method63();
      if(0L == this.field2239[this.field2242]) {
         this.field2234 = var3;
         this.field2235 = var4;
      } else if(this.field2236 > this.field2239[this.field2242]) {
         this.field2234 = (int)((long)(2560 * var1) / (this.field2236 - this.field2239[this.field2242]));
      }

      if(this.field2234 < 25) {
         this.field2234 = 25;
      }

      if(this.field2234 > 256) {
         this.field2234 = 256;
         this.field2235 = (int)((long)var1 - (this.field2236 - this.field2239[this.field2242]) / 10L);
      }

      if(this.field2235 > var1) {
         this.field2235 = var1;
      }

      this.field2239[this.field2242] = this.field2236;
      this.field2242 = (1 + this.field2242) % 10;
      int var5;
      if(this.field2235 > 1) {
         for(var5 = 0; var5 < 10; ++var5) {
            if(0L != this.field2239[var5]) {
               this.field2239[var5] += (long)this.field2235;
            }
         }
      }

      if(this.field2235 < var2) {
         this.field2235 = var2;
      }

      Item.method681((long)this.field2235);

      for(var5 = 0; this.field2233 < 256; this.field2233 += this.field2234) {
         ++var5;
      }

      this.field2233 &= 255;
      return var5;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass125;S)V",
      garbageValue = "13360"
   )
   static final void method3013(class125 var0) {
      var0.method2784();
      int var1 = Client.localInteractingIndex;
      Player var2 = WidgetNode.localPlayer = Client.cachedPlayers[var1] = new Player();
      var2.field54 = var1;
      int var3 = var0.method2792(30);
      byte var4 = (byte)(var3 >> 28);
      int var5 = var3 >> 14 & 16383;
      int var6 = var3 & 16383;
      var2.pathX[0] = var5 - class9.baseX;
      var2.x = (var2.pathX[0] << 7) + (var2.method15() << 6);
      var2.pathY[0] = var6 - KitDefinition.baseY;
      var2.y = (var2.pathY[0] << 7) + (var2.method15() << 6);
      Item.plane = var2.field40 = var4;
      if(null != class34.field778[var1]) {
         var2.method14(class34.field778[var1]);
      }

      class34.field779 = 0;
      class34.field780[++class34.field779 - 1] = var1;
      class34.field776[var1] = 0;
      class34.field781 = 0;

      for(int var7 = 1; var7 < 2048; ++var7) {
         if(var7 != var1) {
            int var8 = var0.method2792(18);
            int var9 = var8 >> 16;
            int var10 = var8 >> 8 & 255;
            int var11 = var8 & 255;
            class34.field794[var7] = var11 + (var9 << 28) + (var10 << 14);
            class34.field788[var7] = 0;
            class34.field785[var7] = -1;
            class34.field782[++class34.field781 - 1] = var7;
            class34.field776[var7] = 0;
         }
      }

      var0.method2805();
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1189589366"
   )
   static final void method3015(boolean var0) {
      Client.field406 = 0;
      Client.field321 = 0;
      class5.method88();

      int var1;
      while(Client.field325.method2787(Client.field326) >= 27) {
         var1 = Client.field325.method2792(15);
         if(var1 == 32767) {
            break;
         }

         boolean var2 = false;
         if(null == Client.cachedNPCs[var1]) {
            Client.cachedNPCs[var1] = new NPC();
            var2 = true;
         }

         NPC var3 = Client.cachedNPCs[var1];
         Client.field320[++Client.field319 - 1] = var1;
         var3.field886 = Client.gameCycle;
         int var4 = Client.field325.method2792(1);
         if(var4 == 1) {
            Client.field399[++Client.field321 - 1] = var1;
         }

         int var5;
         if(var0) {
            var5 = Client.field325.method2792(8);
            if(var5 > 127) {
               var5 -= 256;
            }
         } else {
            var5 = Client.field325.method2792(5);
            if(var5 > 15) {
               var5 -= 32;
            }
         }

         int var6;
         if(var0) {
            var6 = Client.field325.method2792(8);
            if(var6 > 127) {
               var6 -= 256;
            }
         } else {
            var6 = Client.field325.method2792(5);
            if(var6 > 15) {
               var6 -= 32;
            }
         }

         int var7 = Client.field508[Client.field325.method2792(3)];
         if(var2) {
            var3.field891 = var3.angle = var7;
         }

         var3.composition = ObjectComposition.getNpcDefinition(Client.field325.method2792(14));
         int var8 = Client.field325.method2792(1);
         var3.field843 = var3.composition.field915;
         var3.field892 = var3.composition.field938;
         if(var3.field892 == 0) {
            var3.angle = 0;
         }

         var3.field847 = var3.composition.field921;
         var3.field887 = var3.composition.field913;
         var3.field863 = var3.composition.field928;
         var3.field850 = var3.composition.field924;
         var3.idlePoseAnimation = var3.composition.field935;
         var3.field849 = var3.composition.field934;
         var3.field890 = var3.composition.field920;
         var3.method762(var5 + WidgetNode.localPlayer.pathX[0], WidgetNode.localPlayer.pathY[0] + var6, var8 == 1);
      }

      Client.field325.method2805();
      class52.method1097();

      for(var1 = 0; var1 < Client.field406; ++var1) {
         int var9 = Client.field407[var1];
         if(Client.gameCycle != Client.cachedNPCs[var9].field886) {
            Client.cachedNPCs[var9].composition = null;
            Client.cachedNPCs[var9] = null;
         }
      }

      if(Client.field326 != Client.field325.offset) {
         throw new RuntimeException(Client.field325.offset + "," + Client.field326);
      } else {
         for(var1 = 0; var1 < Client.field319; ++var1) {
            if(null == Client.cachedNPCs[Client.field320[var1]]) {
               throw new RuntimeException(var1 + "," + Client.field319);
            }
         }

      }
   }

   class144() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2239[var1] = this.field2236;
      }

   }
}
