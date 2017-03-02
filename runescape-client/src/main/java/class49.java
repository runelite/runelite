import java.awt.FontMetrics;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("az")
public class class49 extends Renderable {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 162513913
   )
   int field941;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 26238793
   )
   int field942;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -859347059
   )
   int field943;
   @ObfuscatedName("bf")
   protected static FontMetrics field944;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -346921699
   )
   int field945;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1076249795
   )
   int field946;
   @ObfuscatedName("n")
   Sequence field947;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 875694547
   )
   int field948;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1282566601
   )
   int field949;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1800843081
   )
   int field951;
   @ObfuscatedName("z")
   public static class144 field952;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "65536"
   )
   static int method964(int var0, Script var1, boolean var2) {
      int var4 = -1;
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var4 = class32.field729[--class101.field1648];
         var3 = class140.method2681(var4);
      } else {
         var3 = var2?class32.field719:class185.field2760;
      }

      if(var0 == 1100) {
         class101.field1648 -= 2;
         var3.scrollX = class32.field729[class101.field1648];
         if(var3.scrollX > var3.scrollWidth - var3.width) {
            var3.scrollX = var3.scrollWidth - var3.width;
         }

         if(var3.scrollX < 0) {
            var3.scrollX = 0;
         }

         var3.scrollY = class32.field729[1 + class101.field1648];
         if(var3.scrollY > var3.scrollHeight - var3.height) {
            var3.scrollY = var3.scrollHeight - var3.height;
         }

         if(var3.scrollY < 0) {
            var3.scrollY = 0;
         }

         Frames.method1960(var3);
         return 1;
      } else if(var0 == 1101) {
         var3.textColor = class32.field729[--class101.field1648];
         Frames.method1960(var3);
         return 1;
      } else if(var0 == 1102) {
         var3.field2225 = class32.field729[--class101.field1648] == 1;
         Frames.method1960(var3);
         return 1;
      } else if(var0 == 1103) {
         var3.opacity = class32.field729[--class101.field1648];
         Frames.method1960(var3);
         return 1;
      } else if(var0 == 1104) {
         var3.field2229 = class32.field729[--class101.field1648];
         Frames.method1960(var3);
         return 1;
      } else if(var0 == 1105) {
         var3.textureId = class32.field729[--class101.field1648];
         Frames.method1960(var3);
         return 1;
      } else if(var0 == 1106) {
         var3.field2233 = class32.field729[--class101.field1648];
         Frames.method1960(var3);
         return 1;
      } else if(var0 == 1107) {
         var3.field2278 = class32.field729[--class101.field1648] == 1;
         Frames.method1960(var3);
         return 1;
      } else if(var0 == 1108) {
         var3.modelType = 1;
         var3.modelId = class32.field729[--class101.field1648];
         Frames.method1960(var3);
         return 1;
      } else if(var0 == 1109) {
         class101.field1648 -= 6;
         var3.field2245 = class32.field729[class101.field1648];
         var3.field2246 = class32.field729[class101.field1648 + 1];
         var3.rotationX = class32.field729[class101.field1648 + 2];
         var3.rotationZ = class32.field729[class101.field1648 + 3];
         var3.rotationY = class32.field729[4 + class101.field1648];
         var3.field2238 = class32.field729[class101.field1648 + 5];
         Frames.method1960(var3);
         return 1;
      } else {
         int var7;
         if(var0 == 1110) {
            var7 = class32.field729[--class101.field1648];
            if(var7 != var3.field2243) {
               var3.field2243 = var7;
               var3.field2318 = 0;
               var3.field2303 = 0;
               Frames.method1960(var3);
            }

            return 1;
         } else if(var0 == 1111) {
            var3.field2287 = class32.field729[--class101.field1648] == 1;
            Frames.method1960(var3);
            return 1;
         } else if(var0 == 1112) {
            String var5 = class32.scriptStringStack[--World.scriptStringStackSize];
            if(!var5.equals(var3.text)) {
               var3.text = var5;
               Frames.method1960(var3);
            }

            return 1;
         } else if(var0 == 1113) {
            var3.fontId = class32.field729[--class101.field1648];
            Frames.method1960(var3);
            return 1;
         } else if(var0 == 1114) {
            class101.field1648 -= 3;
            var3.field2236 = class32.field729[class101.field1648];
            var3.field2260 = class32.field729[1 + class101.field1648];
            var3.field2283 = class32.field729[class101.field1648 + 2];
            Frames.method1960(var3);
            return 1;
         } else if(var0 == 1115) {
            var3.field2261 = class32.field729[--class101.field1648] == 1;
            Frames.method1960(var3);
            return 1;
         } else if(var0 == 1116) {
            var3.borderThickness = class32.field729[--class101.field1648];
            Frames.method1960(var3);
            return 1;
         } else if(var0 == 1117) {
            var3.sprite2 = class32.field729[--class101.field1648];
            Frames.method1960(var3);
            return 1;
         } else if(var0 == 1118) {
            var3.flippedVertically = class32.field729[--class101.field1648] == 1;
            Frames.method1960(var3);
            return 1;
         } else if(var0 == 1119) {
            var3.flippedHorizontally = class32.field729[--class101.field1648] == 1;
            Frames.method1960(var3);
            return 1;
         } else if(var0 == 1120) {
            class101.field1648 -= 2;
            var3.scrollWidth = class32.field729[class101.field1648];
            var3.scrollHeight = class32.field729[class101.field1648 + 1];
            Frames.method1960(var3);
            if(var4 != -1 && var3.type == 0) {
               CombatInfo1.method646(Widget.widgets[var4 >> 16], var3, false);
            }

            return 1;
         } else if(var0 == 1121) {
            var7 = var3.id;
            int var6 = var3.index;
            Client.field327.method3124(192);
            Client.field327.method2844(var7);
            Client.field327.method2890(var6);
            Client.field546 = var3;
            Frames.method1960(var3);
            return 1;
         } else if(var0 == 1122) {
            var3.field2232 = class32.field729[--class101.field1648];
            Frames.method1960(var3);
            return 1;
         } else if(var0 == 1123) {
            var3.field2222 = class32.field729[--class101.field1648];
            Frames.method1960(var3);
            return 1;
         } else if(var0 == 1124) {
            var3.field2228 = class32.field729[--class101.field1648];
            Frames.method1960(var3);
            return 1;
         } else if(var0 == 1125) {
            var7 = class32.field729[--class101.field1648];
            class221 var8 = (class221)class37.method801(TextureProvider.method1514(), var7);
            if(null != var8) {
               var3.field2329 = var8;
               Frames.method1960(var3);
            }

            return 1;
         } else {
            return 2;
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)LModel;",
      garbageValue = "-8"
   )
   protected final Model getModel() {
      if(this.field947 != null) {
         int var1 = Client.gameCycle - this.field949;
         if(var1 > 100 && this.field947.frameStep > 0) {
            var1 = 100;
         }

         label69: {
            do {
               do {
                  if(var1 <= this.field947.frameLenghts[this.field948]) {
                     break label69;
                  }

                  var1 -= this.field947.frameLenghts[this.field948];
                  ++this.field948;
               } while(this.field948 < this.field947.frameIDs.length);

               this.field948 -= this.field947.frameStep;
            } while(this.field948 >= 0 && this.field948 < this.field947.frameIDs.length);

            this.field947 = null;
         }

         this.field949 = Client.gameCycle - var1;
      }

      ObjectComposition var12 = class196.getObjectDefinition(this.field943);
      if(var12.impostorIds != null) {
         var12 = var12.getImpostor();
      }

      if(null == var12) {
         return null;
      } else {
         int var2;
         int var3;
         if(this.field942 != 1 && this.field942 != 3) {
            var2 = var12.sizeX;
            var3 = var12.sizeY;
         } else {
            var2 = var12.sizeY;
            var3 = var12.sizeX;
         }

         int var4 = (var2 >> 1) + this.field945;
         int var5 = (1 + var2 >> 1) + this.field945;
         int var6 = (var3 >> 1) + this.field951;
         int var7 = this.field951 + (1 + var3 >> 1);
         int[][] var8 = class10.tileHeights[this.field946];
         int var9 = var8[var5][var7] + var8[var4][var7] + var8[var4][var6] + var8[var5][var6] >> 2;
         int var10 = (this.field945 << 7) + (var2 << 6);
         int var11 = (this.field951 << 7) + (var3 << 6);
         return var12.method3687(this.field941, this.field942, var8, var10, var9, var11, this.field947, this.field948);
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "48"
   )
   public static void method968() {
      if(null != class185.field2741) {
         class185.field2741.method2109();
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "774812664"
   )
   public static boolean method969(int var0) {
      return (var0 >> 20 & 1) != 0;
   }

   @ObfuscatedName("sd")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "339378286"
   )
   protected static final void method970() {
      class36.field770.vmethod2102();

      int var0;
      for(var0 = 0; var0 < 32; ++var0) {
         GameEngine.field1769[var0] = 0L;
      }

      for(var0 = 0; var0 < 32; ++var0) {
         GameEngine.field1778[var0] = 0L;
      }

      class40.field806 = 0;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)LCombatInfo2;",
      garbageValue = "140706526"
   )
   public static CombatInfo2 method971(int var0) {
      CombatInfo2 var1 = (CombatInfo2)CombatInfo2.field2832.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = CombatInfo2.field2848.getConfigData(33, var0);
         var1 = new CombatInfo2();
         if(null != var2) {
            var1.method3598(new Buffer(var2));
         }

         CombatInfo2.field2832.put(var1, (long)var0);
         return var1;
      }
   }

   class49(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, Renderable var9) {
      this.field943 = var1;
      this.field941 = var2;
      this.field942 = var3;
      this.field946 = var4;
      this.field945 = var5;
      this.field951 = var6;
      if(var7 != -1) {
         this.field947 = XClanMember.getAnimation(var7);
         this.field948 = 0;
         this.field949 = Client.gameCycle - 1;
         if(this.field947.replyMode == 0 && null != var9 && var9 instanceof class49) {
            class49 var10 = (class49)var9;
            if(var10.field947 == this.field947) {
               this.field948 = var10.field948;
               this.field949 = var10.field949;
               return;
            }
         }

         if(var8 && this.field947.frameStep != -1) {
            this.field948 = (int)(Math.random() * (double)this.field947.frameIDs.length);
            this.field949 -= (int)(Math.random() * (double)this.field947.frameLenghts[this.field948]);
         }
      }

   }
}
