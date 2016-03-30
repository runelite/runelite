import java.awt.Canvas;
import java.awt.Color;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("as")
public class class46 extends class204 {
   @ObfuscatedName("x")
   public static class193 field1060 = new class193(64);
   @ObfuscatedName("w")
   public static class167 field1061;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1391957063
   )
   public int field1062 = -1;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 532464059
   )
   public int field1064 = -1;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 380560127
   )
   public int field1066;
   @ObfuscatedName("e")
   public boolean field1067 = true;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -436877325
   )
   public int field1068;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 785378357
   )
   public int field1069;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1160678931
   )
   public int field1070;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 633503459
   )
   public int field1072;
   @ObfuscatedName("qo")
   @ObfuscatedGetter(
      intValue = 1972051051
   )
   static int field1073;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1124640693
   )
   public int field1075 = 0;
   @ObfuscatedName("ap")
   static class168 field1076;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -830989553
   )
   public int field1077;

   @ObfuscatedName("t")
   public void method995(class119 var1) {
      while(true) {
         int var2 = var1.method2506();
         if(0 == var2) {
            return;
         }

         this.method999(var1, var2);
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1327534247"
   )
   void method996(int var1) {
      double var2 = (double)(var1 >> 16 & 255) / 256.0D;
      double var4 = (double)(var1 >> 8 & 255) / 256.0D;
      double var6 = (double)(var1 & 255) / 256.0D;
      double var8 = var2;
      if(var4 < var2) {
         var8 = var4;
      }

      if(var6 < var8) {
         var8 = var6;
      }

      double var10 = var2;
      if(var4 > var2) {
         var10 = var4;
      }

      if(var6 > var10) {
         var10 = var6;
      }

      double var12 = 0.0D;
      double var14 = 0.0D;
      double var16 = (var8 + var10) / 2.0D;
      if(var8 != var10) {
         if(var16 < 0.5D) {
            var14 = (var10 - var8) / (var8 + var10);
         }

         if(var16 >= 0.5D) {
            var14 = (var10 - var8) / (2.0D - var10 - var8);
         }

         if(var10 == var2) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if(var4 == var10) {
            var12 = (var6 - var2) / (var10 - var8) + 2.0D;
         } else if(var6 == var10) {
            var12 = (var2 - var4) / (var10 - var8) + 4.0D;
         }
      }

      var12 /= 6.0D;
      this.field1066 = (int)(256.0D * var12);
      this.field1072 = (int)(var14 * 256.0D);
      this.field1077 = (int)(256.0D * var16);
      if(this.field1072 < 0) {
         this.field1072 = 0;
      } else if(this.field1072 > 255) {
         this.field1072 = 255;
      }

      if(this.field1077 < 0) {
         this.field1077 = 0;
      } else if(this.field1077 > 255) {
         this.field1077 = 255;
      }

   }

   @ObfuscatedName("av")
   static void method998() {
      Canvas var0 = class87.field1537;
      var0.removeKeyListener(class137.field2131);
      var0.removeFocusListener(class137.field2131);
      class137.field2133 = -1;
      class102.method2283(class87.field1537);
      if(null != class8.field159) {
         class8.field159.vmethod3123(class87.field1537);
      }

      client.field294.method3024();
      class87.field1537.setBackground(Color.black);
      Canvas var1 = class87.field1537;
      var1.setFocusTraversalKeysEnabled(false);
      var1.addKeyListener(class137.field2131);
      var1.addFocusListener(class137.field2131);
      Canvas var2 = class87.field1537;
      var2.addMouseListener(class140.field2163);
      var2.addMouseMotionListener(class140.field2163);
      var2.addFocusListener(class140.field2163);
      if(class8.field159 != null) {
         class8.field159.vmethod3122(class87.field1537);
      }

      if(client.field454 != -1) {
         class14.method168(client.field454, class15.field235, class15.field233, false);
      }

      class144.field2225 = true;
   }

   @ObfuscatedName("p")
   void method999(class119 var1, int var2) {
      if(1 == var2) {
         this.field1075 = var1.method2510();
      } else if(2 == var2) {
         this.field1062 = var1.method2506();
      } else if(var2 == 5) {
         this.field1067 = false;
      } else if(var2 == 7) {
         this.field1064 = var1.method2510();
      } else if(8 == var2) {
         ;
      }

   }

   @ObfuscatedName("x")
   public void method1001() {
      if(this.field1064 != -1) {
         this.method996(this.field1064);
         this.field1068 = this.field1066;
         this.field1069 = this.field1072;
         this.field1070 = this.field1077;
      }

      this.method996(this.field1075);
   }

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "114"
   )
   static final void method1008(boolean var0) {
      client.field418 = 0;
      client.field504 = 0;
      client.field528.method2748();
      int var1 = client.field528.method2777(8);
      int var2;
      if(var1 < client.field332) {
         for(var2 = var1; var2 < client.field332; ++var2) {
            client.field419[++client.field418 - 1] = client.field333[var2];
         }
      }

      if(var1 > client.field332) {
         throw new RuntimeException("");
      } else {
         client.field332 = 0;

         int var5;
         int var6;
         int var7;
         int var8;
         for(var2 = 0; var2 < var1; ++var2) {
            int var3 = client.field333[var2];
            class34 var4 = client.field331[var3];
            var5 = client.field528.method2777(1);
            if(var5 == 0) {
               client.field333[++client.field332 - 1] = var3;
               var4.field866 = client.field305;
            } else {
               var6 = client.field528.method2777(2);
               if(var6 == 0) {
                  client.field333[++client.field332 - 1] = var3;
                  var4.field866 = client.field305;
                  client.field395[++client.field504 - 1] = var3;
               } else if(1 == var6) {
                  client.field333[++client.field332 - 1] = var3;
                  var4.field866 = client.field305;
                  var7 = client.field528.method2777(3);
                  var4.method735(var7, (byte)1);
                  var8 = client.field528.method2777(1);
                  if(var8 == 1) {
                     client.field395[++client.field504 - 1] = var3;
                  }
               } else if(var6 == 2) {
                  client.field333[++client.field332 - 1] = var3;
                  var4.field866 = client.field305;
                  var7 = client.field528.method2777(3);
                  var4.method735(var7, (byte)2);
                  var8 = client.field528.method2777(3);
                  var4.method735(var8, (byte)2);
                  int var9 = client.field528.method2777(1);
                  if(var9 == 1) {
                     client.field395[++client.field504 - 1] = var3;
                  }
               } else if(var6 == 3) {
                  client.field419[++client.field418 - 1] = var3;
               }
            }
         }

         class34 var11;
         int var12;
         while(client.field528.method2754(client.field339) >= 27) {
            var1 = client.field528.method2777(15);
            if(var1 == 32767) {
               break;
            }

            boolean var10 = false;
            if(client.field331[var1] == null) {
               client.field331[var1] = new class34();
               var10 = true;
            }

            var11 = client.field331[var1];
            client.field333[++client.field332 - 1] = var1;
            var11.field866 = client.field305;
            var12 = client.field528.method2777(1);
            if(var0) {
               var5 = client.field528.method2777(8);
               if(var5 > 127) {
                  var5 -= 256;
               }
            } else {
               var5 = client.field528.method2777(5);
               if(var5 > 15) {
                  var5 -= 32;
               }
            }

            var6 = client.field576[client.field528.method2777(3)];
            if(var10) {
               var11.field847 = var11.field820 = var6;
            }

            if(var0) {
               var7 = client.field528.method2777(8);
               if(var7 > 127) {
                  var7 -= 256;
               }
            } else {
               var7 = client.field528.method2777(5);
               if(var7 > 15) {
                  var7 -= 32;
               }
            }

            var11.field781 = class36.method759(client.field528.method2777(14));
            var8 = client.field528.method2777(1);
            if(var8 == 1) {
               client.field395[++client.field504 - 1] = var1;
            }

            var11.field822 = var11.field781.field885;
            var11.field842 = var11.field781.field914;
            if(0 == var11.field842) {
               var11.field820 = 0;
            }

            var11.field826 = var11.field781.field911;
            var11.field827 = var11.field781.field898;
            var11.field828 = var11.field781.field887;
            var11.field829 = var11.field781.field900;
            var11.field823 = var11.field781.field923;
            var11.field824 = var11.field781.field895;
            var11.field825 = var11.field781.field909;
            var11.method732(class167.field2692.field872[0] + var5, var7 + class167.field2692.field873[0], var12 == 1);
         }

         client.field528.method2752();

         for(var1 = 0; var1 < client.field504; ++var1) {
            var2 = client.field395[var1];
            var11 = client.field331[var2];
            var12 = client.field528.method2506();
            if((var12 & 16) != 0) {
               var11.field851 = client.field528.method2600();
               if(var11.field851 == '\uffff') {
                  var11.field851 = -1;
               }
            }

            if((var12 & 32) != 0) {
               var11.field781 = class36.method759(client.field528.method2541());
               var11.field822 = var11.field781.field885;
               var11.field842 = var11.field781.field914;
               var11.field826 = var11.field781.field911;
               var11.field827 = var11.field781.field898;
               var11.field828 = var11.field781.field887;
               var11.field829 = var11.field781.field900;
               var11.field823 = var11.field781.field923;
               var11.field824 = var11.field781.field895;
               var11.field825 = var11.field781.field909;
            }

            if(0 != (var12 & 8)) {
               var11.field831 = client.field528.method2683();
               var11.field834 = 100;
            }

            if((var12 & 128) != 0) {
               var5 = client.field528.method2600();
               var6 = client.field528.method2508();
               var7 = var11.field849 - (var5 - class41.field990 - class41.field990) * 64;
               var8 = var11.field819 - (var6 - class2.field37 - class2.field37) * 64;
               if(var7 != 0 || var8 != 0) {
                  var11.field876 = (int)(Math.atan2((double)var7, (double)var8) * 325.949D) & 2047;
               }
            }

            if(0 != (var12 & 64)) {
               var5 = client.field528.method2533();
               var6 = client.field528.method2597();
               var11.method770(var5, var6, client.field305);
               var11.field840 = client.field305 + 300;
               var11.field841 = client.field528.method2541();
               var11.field848 = client.field528.method2600();
            }

            if(0 != (var12 & 1)) {
               var5 = client.field528.method2506();
               var6 = client.field528.method2506();
               var11.method770(var5, var6, client.field305);
               var11.field840 = client.field305 + 300;
               var11.field841 = client.field528.method2541();
               var11.field848 = client.field528.method2508();
            }

            if(0 != (var12 & 4)) {
               var11.field854 = client.field528.method2508();
               var5 = client.field528.method2511();
               var11.field858 = var5 >> 16;
               var11.field857 = client.field305 + (var5 & '\uffff');
               var11.field869 = 0;
               var11.field856 = 0;
               if(var11.field857 > client.field305) {
                  var11.field869 = -1;
               }

               if(var11.field854 == '\uffff') {
                  var11.field854 = -1;
               }
            }

            if(0 != (var12 & 2)) {
               var5 = client.field528.method2508();
               if(var5 == '\uffff') {
                  var5 = -1;
               }

               var6 = client.field528.method2597();
               if(var11.field821 == var5 && -1 != var5) {
                  var7 = class96.method2187(var5).field1008;
                  if(var7 == 1) {
                     var11.field850 = 0;
                     var11.field861 = 0;
                     var11.field852 = var6;
                     var11.field853 = 0;
                  }

                  if(var7 == 2) {
                     var11.field853 = 0;
                  }
               } else if(-1 == var5 || var11.field821 == -1 || class96.method2187(var5).field1002 >= class96.method2187(var11.field821).field1002) {
                  var11.field821 = var5;
                  var11.field850 = 0;
                  var11.field861 = 0;
                  var11.field852 = var6;
                  var11.field853 = 0;
                  var11.field875 = var11.field818;
               }
            }
         }

         for(var1 = 0; var1 < client.field418; ++var1) {
            var2 = client.field419[var1];
            if(client.field305 != client.field331[var2].field866) {
               client.field331[var2].field781 = null;
               client.field331[var2] = null;
            }
         }

         if(client.field528.field2011 != client.field339) {
            throw new RuntimeException(client.field528.field2011 + "," + client.field339);
         } else {
            for(var1 = 0; var1 < client.field332; ++var1) {
               if(null == client.field331[client.field333[var1]]) {
                  throw new RuntimeException(var1 + "," + client.field332);
               }
            }

         }
      }
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "19719"
   )
   static final void method1010() {
      for(class29 var0 = (class29)client.field478.method3836(); null != var0; var0 = (class29)client.field478.method3841()) {
         if(var0.field692 == class82.field1437 && !var0.field690) {
            if(client.field305 >= var0.field704) {
               var0.method665(client.field370);
               if(var0.field690) {
                  var0.method3935();
               } else {
                  class3.field75.method1919(var0.field692, var0.field689, var0.field700, var0.field693, 60, var0, 0, -1, false);
               }
            }
         } else {
            var0.method3935();
         }
      }

   }
}
