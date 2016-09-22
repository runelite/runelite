import java.awt.Component;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fu")
public abstract class class170 {
   @ObfuscatedName("t")
   int[] field2731;
   @ObfuscatedName("d")
   int[] field2732;
   @ObfuscatedName("r")
   class195 field2733;
   @ObfuscatedName("u")
   static class119 field2734 = new class119();
   @ObfuscatedName("z")
   int[] field2735;
   @ObfuscatedName("v")
   int[] field2736;
   @ObfuscatedName("k")
   Object[] field2737;
   @ObfuscatedName("i")
   int[][] field2738;
   @ObfuscatedName("g")
   int[][] field2739;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -647618573
   )
   int field2740;
   @ObfuscatedName("n")
   int[] field2741;
   @ObfuscatedName("x")
   Object[][] field2742;
   @ObfuscatedName("m")
   class195[] field2743;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 355539575
   )
   public int field2744;
   @ObfuscatedName("q")
   boolean field2745;
   @ObfuscatedName("w")
   boolean field2746;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 2125914403
   )
   static int field2747 = 0;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-1571548207"
   )
   void method3307(byte[] var1) {
      int var3 = var1.length;
      int var2 = class109.method2403(var1, 0, var3);
      this.field2744 = var2;
      Buffer var4 = new Buffer(Buffer.method2594(var1));
      int var5 = var4.method2528();
      if(var5 >= 5 && var5 <= 7) {
         if(var5 >= 6) {
            var4.method2533();
         }

         int var6 = var4.method2528();
         if(var5 >= 7) {
            this.field2740 = var4.method2542();
         } else {
            this.field2740 = var4.method2717();
         }

         int var7 = 0;
         int var8 = -1;
         this.field2732 = new int[this.field2740];
         int var9;
         if(var5 >= 7) {
            for(var9 = 0; var9 < this.field2740; ++var9) {
               this.field2732[var9] = var7 += var4.method2542();
               if(this.field2732[var9] > var8) {
                  var8 = this.field2732[var9];
               }
            }
         } else {
            for(var9 = 0; var9 < this.field2740; ++var9) {
               this.field2732[var9] = var7 += var4.method2717();
               if(this.field2732[var9] > var8) {
                  var8 = this.field2732[var9];
               }
            }
         }

         this.field2735 = new int[1 + var8];
         this.field2731 = new int[1 + var8];
         this.field2741 = new int[var8 + 1];
         this.field2738 = new int[1 + var8][];
         this.field2737 = new Object[1 + var8];
         this.field2742 = new Object[1 + var8][];
         if(var6 != 0) {
            this.field2736 = new int[var8 + 1];

            for(var9 = 0; var9 < this.field2740; ++var9) {
               this.field2736[this.field2732[var9]] = var4.method2533();
            }

            this.field2733 = new class195(this.field2736);
         }

         for(var9 = 0; var9 < this.field2740; ++var9) {
            this.field2735[this.field2732[var9]] = var4.method2533();
         }

         for(var9 = 0; var9 < this.field2740; ++var9) {
            this.field2731[this.field2732[var9]] = var4.method2533();
         }

         for(var9 = 0; var9 < this.field2740; ++var9) {
            this.field2741[this.field2732[var9]] = var4.method2717();
         }

         int var10;
         int var11;
         int var12;
         int var13;
         int var14;
         if(var5 >= 7) {
            for(var9 = 0; var9 < this.field2740; ++var9) {
               var10 = this.field2732[var9];
               var11 = this.field2741[var10];
               var7 = 0;
               var12 = -1;
               this.field2738[var10] = new int[var11];

               for(var13 = 0; var13 < var11; ++var13) {
                  var14 = this.field2738[var10][var13] = var7 += var4.method2542();
                  if(var14 > var12) {
                     var12 = var14;
                  }
               }

               this.field2742[var10] = new Object[1 + var12];
            }
         } else {
            for(var9 = 0; var9 < this.field2740; ++var9) {
               var10 = this.field2732[var9];
               var11 = this.field2741[var10];
               var7 = 0;
               var12 = -1;
               this.field2738[var10] = new int[var11];

               for(var13 = 0; var13 < var11; ++var13) {
                  var14 = this.field2738[var10][var13] = var7 += var4.method2717();
                  if(var14 > var12) {
                     var12 = var14;
                  }
               }

               this.field2742[var10] = new Object[var12 + 1];
            }
         }

         if(var6 != 0) {
            this.field2739 = new int[var8 + 1][];
            this.field2743 = new class195[1 + var8];

            for(var9 = 0; var9 < this.field2740; ++var9) {
               var10 = this.field2732[var9];
               var11 = this.field2741[var10];
               this.field2739[var10] = new int[this.field2742[var10].length];

               for(var12 = 0; var12 < var11; ++var12) {
                  this.field2739[var10][this.field2738[var10][var12]] = var4.method2533();
               }

               this.field2743[var10] = new class195(this.field2739[var10]);
            }
         }

      } else {
         throw new RuntimeException("");
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1418501113"
   )
   void vmethod3384(int var1) {
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(III)[B",
      garbageValue = "1102315706"
   )
   public byte[] method3309(int var1, int var2) {
      return this.method3310(var1, var2, (int[])null);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II[II)[B",
      garbageValue = "-1453696171"
   )
   public byte[] method3310(int var1, int var2, int[] var3) {
      if(var1 >= 0 && var1 < this.field2742.length && this.field2742[var1] != null && var2 >= 0 && var2 < this.field2742[var1].length) {
         if(this.field2742[var1][var2] == null) {
            boolean var4 = this.method3316(var1, var3);
            if(!var4) {
               this.vmethod3406(var1);
               var4 = this.method3316(var1, var3);
               if(!var4) {
                  return null;
               }
            }
         }

         byte[] var5 = class50.method1039(this.field2742[var1][var2], false);
         if(this.field2746) {
            this.field2742[var1][var2] = null;
         }

         return var5;
      } else {
         return null;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;S)I",
      garbageValue = "-23864"
   )
   public int method3313(int var1, String var2) {
      var2 = var2.toLowerCase();
      return this.field2743[var1].method3778(class129.method2856(var2));
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)[B",
      garbageValue = "-275535269"
   )
   public byte[] method3315(int var1, int var2) {
      if(var1 >= 0 && var1 < this.field2742.length && this.field2742[var1] != null && var2 >= 0 && var2 < this.field2742[var1].length) {
         if(this.field2742[var1][var2] == null) {
            boolean var3 = this.method3316(var1, (int[])null);
            if(!var3) {
               this.vmethod3406(var1);
               var3 = this.method3316(var1, (int[])null);
               if(!var3) {
                  return null;
               }
            }
         }

         byte[] var4 = class50.method1039(this.field2742[var1][var2], false);
         return var4;
      } else {
         return null;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I[II)Z",
      garbageValue = "1098108741"
   )
   boolean method3316(int var1, int[] var2) {
      if(null == this.field2737[var1]) {
         return false;
      } else {
         int var3 = this.field2741[var1];
         int[] var4 = this.field2738[var1];
         Object[] var5 = this.field2742[var1];
         boolean var6 = true;

         for(int var7 = 0; var7 < var3; ++var7) {
            if(null == var5[var4[var7]]) {
               var6 = false;
               break;
            }
         }

         if(var6) {
            return true;
         } else {
            byte[] var18;
            if(var2 == null || var2[0] == 0 && var2[1] == 0 && var2[2] == 0 && var2[3] == 0) {
               var18 = class50.method1039(this.field2737[var1], false);
            } else {
               var18 = class50.method1039(this.field2737[var1], true);
               Buffer var8 = new Buffer(var18);
               var8.method2548(var2, 5, var8.payload.length);
            }

            byte[] var20 = Buffer.method2594(var18);
            if(this.field2745) {
               this.field2737[var1] = null;
            }

            if(var3 > 1) {
               int var9 = var20.length;
               --var9;
               int var10 = var20[var9] & 255;
               var9 -= var10 * var3 * 4;
               Buffer var11 = new Buffer(var20);
               int[] var12 = new int[var3];
               var11.offset = var9;

               int var14;
               int var15;
               for(int var13 = 0; var13 < var10; ++var13) {
                  var14 = 0;

                  for(var15 = 0; var15 < var3; ++var15) {
                     var14 += var11.method2533();
                     var12[var15] += var14;
                  }
               }

               byte[][] var19 = new byte[var3][];

               for(var14 = 0; var14 < var3; ++var14) {
                  var19[var14] = new byte[var12[var14]];
                  var12[var14] = 0;
               }

               var11.offset = var9;
               var14 = 0;

               for(var15 = 0; var15 < var10; ++var15) {
                  int var16 = 0;

                  for(int var17 = 0; var17 < var3; ++var17) {
                     var16 += var11.method2533();
                     System.arraycopy(var20, var14, var19[var17], var12[var17], var16);
                     var12[var17] += var16;
                     var14 += var16;
                  }
               }

               for(var15 = 0; var15 < var3; ++var15) {
                  if(!this.field2746) {
                     var5[var4[var15]] = class126.method2807(var19[var15], false);
                  } else {
                     var5[var4[var15]] = var19[var15];
                  }
               }
            } else if(!this.field2746) {
               var5[var4[0]] = class126.method2807(var20, false);
            } else {
               var5[var4[0]] = var20;
            }

            return true;
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-800410959"
   )
   void vmethod3406(int var1) {
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "598675832"
   )
   public int method3319(int var1) {
      return this.field2742[var1].length;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "46"
   )
   public int method3320() {
      return this.field2742.length;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1004807893"
   )
   public void method3321(int var1) {
      for(int var2 = 0; var2 < this.field2742[var1].length; ++var2) {
         this.field2742[var1][var2] = null;
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "110309836"
   )
   public void method3322() {
      for(int var1 = 0; var1 < this.field2742.length; ++var1) {
         if(this.field2742[var1] != null) {
            for(int var2 = 0; var2 < this.field2742[var1].length; ++var2) {
               this.field2742[var1][var2] = null;
            }
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "1133871137"
   )
   public byte[] method3323(int var1) {
      if(this.field2742.length == 1) {
         return this.method3309(0, var1);
      } else if(this.field2742[var1].length == 1) {
         return this.method3309(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)I",
      garbageValue = "-99"
   )
   public int method3324(String var1) {
      var1 = var1.toLowerCase();
      return this.field2733.method3778(class129.method2856(var1));
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;B)[B",
      garbageValue = "63"
   )
   public byte[] method3326(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field2733.method3778(class129.method2856(var1));
      int var4 = this.field2743[var3].method3778(class129.method2856(var2));
      return this.method3309(var3, var4);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;B)Z",
      garbageValue = "5"
   )
   public boolean method3327(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.field2733.method3778(class129.method2856(var1));
      int var4 = this.field2743[var3].method3778(class129.method2856(var2));
      return this.method3351(var3, var4);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1672365584"
   )
   public void method3329(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.field2733.method3778(class129.method2856(var1));
      if(var2 >= 0) {
         this.vmethod3384(var2);
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IB)[I",
      garbageValue = "29"
   )
   public int[] method3330(int var1) {
      return this.field2738[var1];
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;Lclass170;Lclass170;ZII)V",
      garbageValue = "-1181425994"
   )
   static void method3331(Component var0, class170 var1, class170 var2, boolean var3, int var4) {
      if(class33.field740) {
         if(var4 == 4) {
            class33.loginIndex = 4;
         }

      } else {
         class33.loginIndex = var4;
         class82.method1851();
         byte[] var5 = var1.method3326("title.jpg", "");
         class130.field2124 = new SpritePixels(var5, var0);
         class137.field2153 = class130.field2124.method1765();
         if((Client.flags & 536870912) != 0) {
            class33.field739 = class118.method2468(var2, "logo_deadman_mode", "");
         } else {
            class33.field739 = class118.method2468(var2, "logo", "");
         }

         class33.field737 = class118.method2468(var2, "titlebox", "");
         class154.field2317 = class118.method2468(var2, "titlebutton", "");
         class33.field753 = class119.method2474(var2, "runes", "");
         class172.field2765 = class119.method2474(var2, "title_mute", "");
         class33.field741 = class118.method2468(var2, "options_radio_buttons,0", "");
         class93.field1651 = class118.method2468(var2, "options_radio_buttons,2", "");
         class33.field743 = new int[256];

         int var6;
         for(var6 = 0; var6 < 64; ++var6) {
            class33.field743[var6] = var6 * 262144;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class33.field743[64 + var6] = var6 * 1024 + 16711680;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class33.field743[var6 + 128] = 16776960 + var6 * 4;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class33.field743[var6 + 192] = 16777215;
         }

         ChatMessages.field273 = new int[256];

         for(var6 = 0; var6 < 64; ++var6) {
            ChatMessages.field273[var6] = var6 * 1024;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            ChatMessages.field273[var6 + 64] = 4 * var6 + '\uff00';
         }

         for(var6 = 0; var6 < 64; ++var6) {
            ChatMessages.field273[128 + var6] = '\uffff' + var6 * 262144;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            ChatMessages.field273[var6 + 192] = 16777215;
         }

         class1.field25 = new int[256];

         for(var6 = 0; var6 < 64; ++var6) {
            class1.field25[var6] = 4 * var6;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class1.field25[64 + var6] = 255 + var6 * 262144;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class1.field25[128 + var6] = 16711935 + var6 * 1024;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class1.field25[192 + var6] = 16777215;
         }

         class137.field2145 = new int[256];
         class1.field20 = new int['耀'];
         class129.field2119 = new int['耀'];
         Player.method13((ModIcon)null);
         class9.field149 = new int['耀'];
         class138.field2159 = new int['耀'];
         if(var3) {
            class33.username = "";
            class33.field758 = "";
         }

         class10.field156 = 0;
         SecondaryBufferProvider.authCode = "";
         class33.field747 = true;
         class33.worldSelectShown = false;
         if(!class116.field2039.field133) {
            class171 var9 = class8.field140;
            int var7 = var9.method3324("scape main");
            int var8 = var9.method3313(var7, "");
            class186.field3016 = 1;
            class186.field3017 = var9;
            class186.field3019 = var7;
            class186.field3022 = var8;
            class177.field2951 = 255;
            class186.field3020 = false;
            class21.field585 = 2;
         } else {
            class186.field3016 = 1;
            class186.field3017 = null;
            class186.field3019 = -1;
            class186.field3022 = -1;
            class177.field2951 = 0;
            class186.field3020 = false;
            class21.field585 = 2;
         }

         class163.method3216(false);
         class33.field740 = true;
         class33.field736 = (class159.field2374 - Client.field346) / 2;
         class33.loginWindowX = 202 + class33.field736;
         class130.field2124.method1807(class33.field736, 0);
         class137.field2153.method1807(class33.field736 + 382, 0);
         class33.field739.method1900(class33.field736 + 382 - class33.field739.originalWidth / 2, 18);
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "1961783119"
   )
   public byte[] method3349(int var1) {
      if(this.field2742.length == 1) {
         return this.method3315(0, var1);
      } else if(this.field2742[var1].length == 1) {
         return this.method3315(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIS)Z",
      garbageValue = "6400"
   )
   public boolean method3351(int var1, int var2) {
      if(var1 >= 0 && var1 < this.field2742.length && this.field2742[var1] != null && var2 >= 0 && var2 < this.field2742[var1].length) {
         if(this.field2742[var1][var2] != null) {
            return true;
         } else if(null != this.field2737[var1]) {
            return true;
         } else {
            this.vmethod3406(var1);
            return null != this.field2737[var1];
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "18459"
   )
   public boolean method3353() {
      boolean var1 = true;

      for(int var2 = 0; var2 < this.field2732.length; ++var2) {
         int var3 = this.field2732[var2];
         if(this.field2737[var3] == null) {
            this.vmethod3406(var3);
            if(null == this.field2737[var3]) {
               var1 = false;
            }
         }
      }

      return var1;
   }

   class170(boolean var1, boolean var2) {
      this.field2745 = var1;
      this.field2746 = var2;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1129545556"
   )
   public boolean method3362(int var1) {
      if(this.field2737[var1] != null) {
         return true;
      } else {
         this.vmethod3406(var1);
         return null != this.field2737[var1];
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Z",
      garbageValue = "887231156"
   )
   public boolean method3365(String var1) {
      int var2 = this.method3324("");
      return var2 != -1?this.method3327("", var1):this.method3327(var1, "");
   }
}
