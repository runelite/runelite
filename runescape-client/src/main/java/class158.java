import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fv")
public class class158 {
   @ObfuscatedName("f")
   public static int[] field2335 = new int[99];
   @ObfuscatedName("as")
   static class171 field2336;
   @ObfuscatedName("q")
   public static final boolean[] field2340 = new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false};
   @ObfuscatedName("bi")
   static class171 field2343;

   @ObfuscatedName("cr")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-43"
   )
   static final void method3191(int var0, int var1) {
      if(class85.method1938(var0)) {
         class47.method982(Widget.widgets[var0], var1);
      }
   }

   static {
      int var0 = 0;

      for(int var1 = 0; var1 < 99; ++var1) {
         int var2 = 1 + var1;
         int var3 = (int)((double)var2 + 300.0D * Math.pow(2.0D, (double)var2 / 7.0D));
         var0 += var3;
         field2335[var1] = var0 / 4;
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lclass125;ILPlayer;IB)V",
      garbageValue = "36"
   )
   static final void method3192(class125 var0, int var1, Player var2, int var3) {
      byte var4 = -1;
      int var5;
      if((var3 & 16) != 0) {
         var5 = var0.method2571();
         byte[] var6 = new byte[var5];
         Buffer var7 = new Buffer(var6);
         var0.method2582(var6, 0, var5);
         class34.field771[var1] = var7;
         var2.method11(var7);
      }

      int var13;
      if((var3 & 2) != 0) {
         var5 = var0.method2691();
         if(var5 == '\uffff') {
            var5 = -1;
         }

         var13 = var0.method2571();
         class141.method2964(var2, var5, var13);
      }

      if((var3 & 64) != 0) {
         var2.interacting = var0.method2691();
         if(var2.interacting == '\uffff') {
            var2.interacting = -1;
         }
      }

      if((var3 & 1) != 0) {
         var2.overhead = var0.method2579();
         if(var2.overhead.charAt(0) == 126) {
            var2.overhead = var2.overhead.substring(1);
            Widget.sendGameMessage(2, var2.name, var2.overhead);
         } else if(class165.localPlayer == var2) {
            Widget.sendGameMessage(2, var2.name, var2.overhead);
         }

         var2.field868 = false;
         var2.field842 = 0;
         var2.field843 = 0;
         var2.field884 = 150;
      }

      int var8;
      int var9;
      int var12;
      if((var3 & 4) != 0) {
         var5 = var0.method2571();
         int var10;
         int var11;
         int var14;
         if(var5 > 0) {
            for(var13 = 0; var13 < var5; ++var13) {
               var8 = -1;
               var9 = -1;
               var10 = -1;
               var14 = var0.method2554();
               if(var14 == 32767) {
                  var14 = var0.method2554();
                  var9 = var0.method2554();
                  var8 = var0.method2554();
                  var10 = var0.method2554();
               } else if(var14 != 32766) {
                  var9 = var0.method2554();
               } else {
                  var14 = -1;
               }

               var11 = var0.method2554();
               var2.method775(var14, var9, var8, var10, Client.gameCycle, var11);
            }
         }

         var13 = var0.method2571();
         if(var13 > 0) {
            for(var14 = 0; var14 < var13; ++var14) {
               var8 = var0.method2554();
               var9 = var0.method2554();
               if(var9 != 32767) {
                  var10 = var0.method2554();
                  var11 = var0.method2571();
                  var12 = var9 > 0?var0.method2571():var11;
                  var2.method785(var8, Client.gameCycle, var9, var10, var11, var12);
               } else {
                  var2.method779(var8);
               }
            }
         }
      }

      if((var3 & 8) != 0) {
         var2.field845 = var0.method2691();
         if(var2.field851 == 0) {
            var2.field876 = var2.field845;
            var2.field845 = -1;
         }
      }

      if((var3 & 128) != 0) {
         var5 = var0.method2691();
         class155 var16 = (class155)class77.method1656(World.method657(), var0.method2571());
         boolean var19 = var0.method2571() == 1;
         var8 = var0.method2571();
         var9 = var0.offset;
         if(null != var2.name && var2.composition != null) {
            boolean var18 = false;
            if(var16.field2305 && class187.method3736(var2.name)) {
               var18 = true;
            }

            if(!var18 && Client.field401 == 0 && !var2.field49) {
               class34.field781.offset = 0;
               var0.method2582(class34.field781.payload, 0, var8);
               class34.field781.offset = 0;
               String var15 = class226.method4060(Actor.method791(class143.method2981(class34.field781)));
               var2.overhead = var15.trim();
               var2.field842 = var5 >> 8;
               var2.field843 = var5 & 255;
               var2.field884 = 150;
               var2.field868 = var19;
               var2.inSequence = class165.localPlayer != var2 && var16.field2305 && Client.field500 != "" && var15.toLowerCase().indexOf(Client.field500) == -1;
               if(var16.field2309) {
                  var12 = var19?91:1;
               } else {
                  var12 = var19?90:2;
               }

               if(var16.field2302 != -1) {
                  Widget.sendGameMessage(var12, class154.method3165(var16.field2302) + var2.name, var15);
               } else {
                  Widget.sendGameMessage(var12, var2.name, var15);
               }
            }
         }

         var0.offset = var8 + var9;
      }

      if((var3 & 256) != 0) {
         var2.graphic = var0.method2691();
         var5 = var0.method2576();
         var2.field866 = var5 >> 16;
         var2.field865 = Client.gameCycle + (var5 & '\uffff');
         var2.field827 = 0;
         var2.field864 = 0;
         if(var2.field865 > Client.gameCycle) {
            var2.field827 = -1;
         }

         if(var2.graphic == '\uffff') {
            var2.graphic = -1;
         }
      }

      if((var3 & 512) != 0) {
         var2.field867 = var0.method2572();
         var2.field869 = var0.method2572();
         var2.field829 = var0.method2572();
         var2.field870 = var0.method2572();
         var2.field871 = var0.method2691() + Client.gameCycle;
         var2.field855 = var0.method2691() + Client.gameCycle;
         var2.field873 = var0.method2691();
         if(var2.field52) {
            var2.field867 += var2.field53;
            var2.field869 += var2.field35;
            var2.field829 += var2.field53;
            var2.field870 += var2.field35;
            var2.field851 = 0;
         } else {
            var2.field867 += var2.pathX[0];
            var2.field869 += var2.pathY[0];
            var2.field829 += var2.pathX[0];
            var2.field870 += var2.pathY[0];
            var2.field851 = 1;
         }

         var2.field863 = 0;
      }

      if((var3 & 1024) != 0) {
         class34.field770[var1] = var0.method2572();
      }

      if((var3 & 4096) != 0) {
         var4 = var0.method2572();
      }

      if((var3 & 2048) != 0) {
         for(var5 = 0; var5 < 3; ++var5) {
            var2.actions[var5] = var0.method2579();
         }
      }

      if(var2.field52) {
         if(var4 == 127) {
            var2.method10(var2.field53, var2.field35);
         } else {
            byte var17;
            if(var4 != -1) {
               var17 = var4;
            } else {
               var17 = class34.field770[var1];
            }

            var2.method14(var2.field53, var2.field35, var17);
         }
      }

   }
}
