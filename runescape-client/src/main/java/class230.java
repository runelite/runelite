import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hz")
public class class230 extends Node {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 2007400871
   )
   int field3252;
   @ObfuscatedName("j")
   boolean field3253;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -1286002985
   )
   int field3254;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 245950281
   )
   int field3257;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -1239269243
   )
   int field3258;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -2120669559
   )
   int field3259;
   @ObfuscatedName("ab")
   String field3262;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -2104375161
   )
   int field3263;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -218090607
   )
   int field3264;
   @ObfuscatedName("aw")
   boolean field3265;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 1940175955
   )
   int field3267;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 1144889709
   )
   int field3268;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -447982763
   )
   int field3269;
   @ObfuscatedName("an")
   String field3271;
   @ObfuscatedName("ac")
   String field3272;
   @ObfuscatedName("al")
   String field3273;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 873184043
   )
   int field3274;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 1992705055
   )
   int field3275;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 1446807179
   )
   int field3276;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -29334137
   )
   int field3277;
   @ObfuscatedName("at")
   String field3278;
   @ObfuscatedName("az")
   String field3279;
   @ObfuscatedName("as")
   int[] field3280 = new int[3];
   @ObfuscatedName("be")
   @ObfuscatedGetter(
      intValue = 295759033
   )
   int field3281;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1833345910"
   )
   public int method4273() {
      byte var1 = 38;
      String var4 = this.field3262;
      int var3 = var4.length() + 2;
      int var20 = var3 + var1;
      String var7 = this.field3271;
      int var6 = var7.length() + 2;
      var20 += var6;
      String var10 = this.field3272;
      int var9 = var10.length() + 2;
      var20 += var9;
      String var13 = this.field3273;
      int var12 = var13.length() + 2;
      var20 += var12;
      String var16 = this.field3278;
      int var15 = var16.length() + 2;
      var20 += var15;
      String var19 = this.field3279;
      int var18 = var19.length() + 2;
      var20 += var18;
      return var20;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "111"
   )
   public void method4274(Buffer var1) {
      var1.method2799(6);
      var1.method2799(this.field3252);
      var1.method2799(this.field3253?1:0);
      var1.method2799(this.field3259);
      var1.method2799(this.field3258);
      var1.method2799(this.field3254);
      var1.method2799(this.field3263);
      var1.method2799(this.field3264);
      var1.method2799(this.field3265?1:0);
      var1.method2837(this.field3275);
      var1.method2799(this.field3267);
      var1.method2801(this.field3276);
      var1.method2837(this.field3269);
      var1.method2889(this.field3262);
      var1.method2889(this.field3271);
      var1.method2889(this.field3272);
      var1.method2889(this.field3273);
      var1.method2799(this.field3257);
      var1.method2837(this.field3274);
      var1.method2889(this.field3278);
      var1.method2889(this.field3279);
      var1.method2799(this.field3277);
      var1.method2799(this.field3268);

      for(int var2 = 0; var2 < this.field3280.length; ++var2) {
         var1.method2802(this.field3280[var2]);
      }

      var1.method2802(this.field3281);
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1522360640"
   )
   static final int method4276() {
      if(class107.field1733.field685) {
         return WallObject.plane;
      } else {
         int var0 = 3;
         if(class13.cameraPitch < 310) {
            int var1 = GameEngine.cameraX >> 7;
            int var2 = class149.cameraY >> 7;
            int var3 = class16.localPlayer.x >> 7;
            int var4 = class16.localPlayer.y >> 7;
            if(var1 < 0 || var2 < 0 || var1 >= 104 || var2 >= 104) {
               return WallObject.plane;
            }

            if((class10.tileSettings[WallObject.plane][var1][var2] & 4) != 0) {
               var0 = WallObject.plane;
            }

            int var5;
            if(var3 > var1) {
               var5 = var3 - var1;
            } else {
               var5 = var1 - var3;
            }

            int var6;
            if(var4 > var2) {
               var6 = var4 - var2;
            } else {
               var6 = var2 - var4;
            }

            int var7;
            int var8;
            if(var5 > var6) {
               var7 = 65536 * var6 / var5;
               var8 = '耀';

               while(var1 != var3) {
                  if(var1 < var3) {
                     ++var1;
                  } else if(var1 > var3) {
                     --var1;
                  }

                  if((class10.tileSettings[WallObject.plane][var1][var2] & 4) != 0) {
                     var0 = WallObject.plane;
                  }

                  var8 += var7;
                  if(var8 >= 65536) {
                     var8 -= 65536;
                     if(var2 < var4) {
                        ++var2;
                     } else if(var2 > var4) {
                        --var2;
                     }

                     if((class10.tileSettings[WallObject.plane][var1][var2] & 4) != 0) {
                        var0 = WallObject.plane;
                     }
                  }
               }
            } else {
               var7 = var5 * 65536 / var6;
               var8 = '耀';

               while(var2 != var4) {
                  if(var2 < var4) {
                     ++var2;
                  } else if(var2 > var4) {
                     --var2;
                  }

                  if((class10.tileSettings[WallObject.plane][var1][var2] & 4) != 0) {
                     var0 = WallObject.plane;
                  }

                  var8 += var7;
                  if(var8 >= 65536) {
                     var8 -= 65536;
                     if(var1 < var3) {
                        ++var1;
                     } else if(var1 > var3) {
                        --var1;
                     }

                     if((class10.tileSettings[WallObject.plane][var1][var2] & 4) != 0) {
                        var0 = WallObject.plane;
                     }
                  }
               }
            }
         }

         if(class16.localPlayer.x >= 0 && class16.localPlayer.y >= 0 && class16.localPlayer.x < 13312 && class16.localPlayer.y < 13312) {
            if((class10.tileSettings[WallObject.plane][class16.localPlayer.x >> 7][class16.localPlayer.y >> 7] & 4) != 0) {
               var0 = WallObject.plane;
            }

            return var0;
         } else {
            return WallObject.plane;
         }
      }
   }

   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public class230(boolean var1) {
      if(class88.field1534.startsWith("win")) {
         this.field3252 = 1;
      } else if(class88.field1534.startsWith("mac")) {
         this.field3252 = 2;
      } else if(class88.field1534.startsWith("linux")) {
         this.field3252 = 3;
      } else {
         this.field3252 = 4;
      }

      String var2;
      try {
         var2 = System.getProperty("os.arch").toLowerCase();
      } catch (Exception var13) {
         var2 = "";
      }

      String var3;
      try {
         var3 = System.getProperty("os.version").toLowerCase();
      } catch (Exception var12) {
         var3 = "";
      }

      String var4 = "Unknown";
      String var5 = "1.1";

      try {
         var4 = System.getProperty("java.vendor");
         var5 = System.getProperty("java.version");
      } catch (Exception var11) {
         ;
      }

      if(!var2.startsWith("amd64") && !var2.startsWith("x86_64")) {
         this.field3253 = false;
      } else {
         this.field3253 = true;
      }

      if(this.field3252 == 1) {
         if(var3.indexOf("4.0") != -1) {
            this.field3259 = 1;
         } else if(var3.indexOf("4.1") != -1) {
            this.field3259 = 2;
         } else if(var3.indexOf("4.9") != -1) {
            this.field3259 = 3;
         } else if(var3.indexOf("5.0") != -1) {
            this.field3259 = 4;
         } else if(var3.indexOf("5.1") != -1) {
            this.field3259 = 5;
         } else if(var3.indexOf("5.2") != -1) {
            this.field3259 = 8;
         } else if(var3.indexOf("6.0") != -1) {
            this.field3259 = 6;
         } else if(var3.indexOf("6.1") != -1) {
            this.field3259 = 7;
         } else if(var3.indexOf("6.2") != -1) {
            this.field3259 = 9;
         } else if(var3.indexOf("6.3") != -1) {
            this.field3259 = 10;
         }
      } else if(this.field3252 == 2) {
         if(var3.indexOf("10.4") != -1) {
            this.field3259 = 20;
         } else if(var3.indexOf("10.5") != -1) {
            this.field3259 = 21;
         } else if(var3.indexOf("10.6") != -1) {
            this.field3259 = 22;
         } else if(var3.indexOf("10.7") != -1) {
            this.field3259 = 23;
         } else if(var3.indexOf("10.8") != -1) {
            this.field3259 = 24;
         } else if(var3.indexOf("10.9") != -1) {
            this.field3259 = 25;
         } else if(var3.indexOf("10.10") != -1) {
            this.field3259 = 26;
         }
      }

      if(var4.toLowerCase().indexOf("sun") != -1) {
         this.field3258 = 1;
      } else if(var4.toLowerCase().indexOf("microsoft") != -1) {
         this.field3258 = 2;
      } else if(var4.toLowerCase().indexOf("apple") != -1) {
         this.field3258 = 3;
      } else if(var4.toLowerCase().indexOf("oracle") != -1) {
         this.field3258 = 5;
      } else {
         this.field3258 = 4;
      }

      int var9 = 2;
      int var7 = 0;

      char var8;
      try {
         while(var9 < var5.length()) {
            var8 = var5.charAt(var9);
            if(var8 < 48 || var8 > 57) {
               break;
            }

            var7 = var8 - 48 + 10 * var7;
            ++var9;
         }
      } catch (Exception var16) {
         ;
      }

      this.field3254 = var7;
      var9 = var5.indexOf(46, 2) + 1;
      var7 = 0;

      try {
         while(var9 < var5.length()) {
            var8 = var5.charAt(var9);
            if(var8 < 48 || var8 > 57) {
               break;
            }

            var7 = var8 - 48 + 10 * var7;
            ++var9;
         }
      } catch (Exception var15) {
         ;
      }

      this.field3263 = var7;
      var9 = var5.indexOf(95, 4) + 1;
      var7 = 0;

      try {
         while(var9 < var5.length()) {
            var8 = var5.charAt(var9);
            if(var8 < 48 || var8 > 57) {
               break;
            }

            var7 = var8 - 48 + 10 * var7;
            ++var9;
         }
      } catch (Exception var14) {
         ;
      }

      this.field3264 = var7;
      this.field3265 = false;
      this.field3275 = (int)(Runtime.getRuntime().maxMemory() / 1048576L) + 1;
      if(this.field3254 > 3) {
         this.field3267 = Runtime.getRuntime().availableProcessors();
      } else {
         this.field3267 = 0;
      }

      this.field3276 = 0;
      if(this.field3262 == null) {
         this.field3262 = "";
      }

      if(null == this.field3271) {
         this.field3271 = "";
      }

      if(null == this.field3272) {
         this.field3272 = "";
      }

      if(null == this.field3273) {
         this.field3273 = "";
      }

      if(null == this.field3278) {
         this.field3278 = "";
      }

      if(this.field3279 == null) {
         this.field3279 = "";
      }

      this.method4282();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1286001949"
   )
   void method4282() {
      if(this.field3262.length() > 40) {
         this.field3262 = this.field3262.substring(0, 40);
      }

      if(this.field3271.length() > 40) {
         this.field3271 = this.field3271.substring(0, 40);
      }

      if(this.field3272.length() > 10) {
         this.field3272 = this.field3272.substring(0, 10);
      }

      if(this.field3273.length() > 10) {
         this.field3273 = this.field3273.substring(0, 10);
      }

   }
}
