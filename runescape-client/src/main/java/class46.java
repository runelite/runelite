import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("ak")
public class class46 {
   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "[Lkh;"
   )
   @Export("slArrowSprites")
   static IndexedSprite[] slArrowSprites;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 2104724871
   )
   int field553;
   @ObfuscatedName("i")
   byte[][][] field549;

   class46(int var1) {
      this.field553 = var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIS)V",
      garbageValue = "-17678"
   )
   void method658(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      if(var7 != 0 && this.field553 != 0 && this.field549 != null) {
         var8 = this.method659(var8, var7);
         var7 = this.method660(var7);
         Rasterizer2D.method5396(var1, var2, var5, var6, var3, var4, this.field549[var7 - 1][var8], this.field553);
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1290826276"
   )
   int method659(int var1, int var2) {
      if(var2 == 9) {
         var1 = var1 + 1 & 3;
      }

      if(var2 == 10) {
         var1 = var1 + 3 & 3;
      }

      if(var2 == 11) {
         var1 = var1 + 3 & 3;
      }

      return var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-11"
   )
   int method660(int var1) {
      return var1 != 9 && var1 != 10?(var1 == 11?8:var1):1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "412622470"
   )
   void method661() {
      if(this.field549 == null) {
         this.field549 = new byte[8][4][];
         this.method657();
         this.method665();
         this.method689();
         this.method696();
         this.method666();
         this.method667();
         this.method664();
         this.method669();
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "735696811"
   )
   void method657() {
      byte[] var1 = new byte[this.field553 * this.field553];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field553; ++var3) {
         for(var4 = 0; var4 < this.field553; ++var4) {
            if(var4 <= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field549[0][0] = var1;
      var1 = new byte[this.field553 * this.field553];
      var2 = 0;

      for(var3 = this.field553 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field553; ++var4) {
            if(var4 <= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field549[0][1] = var1;
      var1 = new byte[this.field553 * this.field553];
      var2 = 0;

      for(var3 = 0; var3 < this.field553; ++var3) {
         for(var4 = 0; var4 < this.field553; ++var4) {
            if(var4 >= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field549[0][2] = var1;
      var1 = new byte[this.field553 * this.field553];
      var2 = 0;

      for(var3 = this.field553 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field553; ++var4) {
            if(var4 >= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field549[0][3] = var1;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-77145442"
   )
   void method665() {
      byte[] var1 = new byte[this.field553 * this.field553];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field553 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field553; ++var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field549[1][0] = var1;
      var1 = new byte[this.field553 * this.field553];
      var2 = 0;

      for(var3 = 0; var3 < this.field553; ++var3) {
         for(var4 = 0; var4 < this.field553; ++var4) {
            if(var2 >= 0 && var2 < var1.length) {
               if(var4 >= var3 << 1) {
                  var1[var2] = -1;
               }

               ++var2;
            } else {
               ++var2;
            }
         }
      }

      this.field549[1][1] = var1;
      var1 = new byte[this.field553 * this.field553];
      var2 = 0;

      for(var3 = 0; var3 < this.field553; ++var3) {
         for(var4 = this.field553 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field549[1][2] = var1;
      var1 = new byte[this.field553 * this.field553];
      var2 = 0;

      for(var3 = this.field553 - 1; var3 >= 0; --var3) {
         for(var4 = this.field553 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field549[1][3] = var1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "2047"
   )
   void method689() {
      byte[] var1 = new byte[this.field553 * this.field553];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field553 - 1; var3 >= 0; --var3) {
         for(var4 = this.field553 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field549[2][0] = var1;
      var1 = new byte[this.field553 * this.field553];
      var2 = 0;

      for(var3 = this.field553 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field553; ++var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field549[2][1] = var1;
      var1 = new byte[this.field553 * this.field553];
      var2 = 0;

      for(var3 = 0; var3 < this.field553; ++var3) {
         for(var4 = 0; var4 < this.field553; ++var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field549[2][2] = var1;
      var1 = new byte[this.field553 * this.field553];
      var2 = 0;

      for(var3 = 0; var3 < this.field553; ++var3) {
         for(var4 = this.field553 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field549[2][3] = var1;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "68"
   )
   void method696() {
      byte[] var1 = new byte[this.field553 * this.field553];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field553 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field553; ++var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field549[3][0] = var1;
      var1 = new byte[this.field553 * this.field553];
      var2 = 0;

      for(var3 = 0; var3 < this.field553; ++var3) {
         for(var4 = 0; var4 < this.field553; ++var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field549[3][1] = var1;
      var1 = new byte[this.field553 * this.field553];
      var2 = 0;

      for(var3 = 0; var3 < this.field553; ++var3) {
         for(var4 = this.field553 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field549[3][2] = var1;
      var1 = new byte[this.field553 * this.field553];
      var2 = 0;

      for(var3 = this.field553 - 1; var3 >= 0; --var3) {
         for(var4 = this.field553 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field549[3][3] = var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-831213355"
   )
   void method666() {
      byte[] var1 = new byte[this.field553 * this.field553];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field553 - 1; var3 >= 0; --var3) {
         for(var4 = this.field553 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field549[4][0] = var1;
      var1 = new byte[this.field553 * this.field553];
      var2 = 0;

      for(var3 = this.field553 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field553; ++var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field549[4][1] = var1;
      var1 = new byte[this.field553 * this.field553];
      var2 = 0;

      for(var3 = 0; var3 < this.field553; ++var3) {
         for(var4 = 0; var4 < this.field553; ++var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field549[4][2] = var1;
      var1 = new byte[this.field553 * this.field553];
      var2 = 0;

      for(var3 = 0; var3 < this.field553; ++var3) {
         for(var4 = this.field553 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field549[4][3] = var1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1547902127"
   )
   void method667() {
      byte[] var1 = new byte[this.field553 * this.field553];
      boolean var2 = false;
      var1 = new byte[this.field553 * this.field553];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field553; ++var3) {
         for(var4 = 0; var4 < this.field553; ++var4) {
            if(var4 <= this.field553 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field549[5][0] = var1;
      var1 = new byte[this.field553 * this.field553];
      var5 = 0;

      for(var3 = 0; var3 < this.field553; ++var3) {
         for(var4 = 0; var4 < this.field553; ++var4) {
            if(var3 <= this.field553 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field549[5][1] = var1;
      var1 = new byte[this.field553 * this.field553];
      var5 = 0;

      for(var3 = 0; var3 < this.field553; ++var3) {
         for(var4 = 0; var4 < this.field553; ++var4) {
            if(var4 >= this.field553 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field549[5][2] = var1;
      var1 = new byte[this.field553 * this.field553];
      var5 = 0;

      for(var3 = 0; var3 < this.field553; ++var3) {
         for(var4 = 0; var4 < this.field553; ++var4) {
            if(var3 >= this.field553 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field549[5][3] = var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1292716633"
   )
   void method664() {
      byte[] var1 = new byte[this.field553 * this.field553];
      boolean var2 = false;
      var1 = new byte[this.field553 * this.field553];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field553; ++var3) {
         for(var4 = 0; var4 < this.field553; ++var4) {
            if(var4 <= var3 - this.field553 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field549[6][0] = var1;
      var1 = new byte[this.field553 * this.field553];
      var5 = 0;

      for(var3 = this.field553 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field553; ++var4) {
            if(var4 <= var3 - this.field553 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field549[6][1] = var1;
      var1 = new byte[this.field553 * this.field553];
      var5 = 0;

      for(var3 = this.field553 - 1; var3 >= 0; --var3) {
         for(var4 = this.field553 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 - this.field553 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field549[6][2] = var1;
      var1 = new byte[this.field553 * this.field553];
      var5 = 0;

      for(var3 = 0; var3 < this.field553; ++var3) {
         for(var4 = this.field553 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 - this.field553 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field549[6][3] = var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "500"
   )
   void method669() {
      byte[] var1 = new byte[this.field553 * this.field553];
      boolean var2 = false;
      var1 = new byte[this.field553 * this.field553];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field553; ++var3) {
         for(var4 = 0; var4 < this.field553; ++var4) {
            if(var4 >= var3 - this.field553 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field549[7][0] = var1;
      var1 = new byte[this.field553 * this.field553];
      var5 = 0;

      for(var3 = this.field553 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field553; ++var4) {
            if(var4 >= var3 - this.field553 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field549[7][1] = var1;
      var1 = new byte[this.field553 * this.field553];
      var5 = 0;

      for(var3 = this.field553 - 1; var3 >= 0; --var3) {
         for(var4 = this.field553 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 - this.field553 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field549[7][2] = var1;
      var1 = new byte[this.field553 * this.field553];
      var5 = 0;

      for(var3 = 0; var3 < this.field553; ++var3) {
         for(var4 = this.field553 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 - this.field553 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field549[7][3] = var1;
   }

   @ObfuscatedName("p")
   public static String method687(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(0L == var0 % 37L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; 0L != var3; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5 = new StringBuilder(var2);

            while(0L != var0) {
               long var6 = var0;
               var0 /= 37L;
               var5.append(class291.field3768[(int)(var6 - var0 * 37L)]);
            }

            return var5.reverse().toString();
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-105899056"
   )
   static final int method694() {
      return class131.Viewport_mouseX;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Ljava/lang/Class;",
      garbageValue = "50"
   )
   @Export("loadClassFromDescriptor")
   public static Class loadClassFromDescriptor(String var0) throws ClassNotFoundException {
      return var0.equals("B")?Byte.TYPE:(var0.equals("I")?Integer.TYPE:(var0.equals("S")?Short.TYPE:(var0.equals("J")?Long.TYPE:(var0.equals("Z")?Boolean.TYPE:(var0.equals("F")?Float.TYPE:(var0.equals("D")?Double.TYPE:(var0.equals("C")?Character.TYPE:(var0.equals("void")?Void.TYPE:Reflection.findClass(var0)))))))));
   }

   @ObfuscatedName("gq")
   @ObfuscatedSignature(
      signature = "(Lbx;I)V",
      garbageValue = "1293404911"
   )
   static final void method695(Actor var0) {
      if(var0.field1150 != 0) {
         if(var0.interacting != -1) {
            Object var1 = null;
            if(var0.interacting < 32768) {
               var1 = Client.cachedNPCs[var0.interacting];
            } else if(var0.interacting >= 32768) {
               var1 = Client.cachedPlayers[var0.interacting - 32768];
            }

            if(var1 != null) {
               int var2 = var0.x - ((Actor)var1).x;
               int var3 = var0.y - ((Actor)var1).y;
               if(var2 != 0 || var3 != 0) {
                  var0.orientation = (int)(Math.atan2((double)var2, (double)var3) * 325.949D) & 2047;
               }
            } else if(var0.field1124) {
               var0.interacting = -1;
               var0.field1124 = false;
            }
         }

         if(var0.field1125 != -1 && (var0.queueSize == 0 || var0.field1136 > 0)) {
            var0.orientation = var0.field1125;
            var0.field1125 = -1;
         }

         int var4 = var0.orientation - var0.angle & 2047;
         if(var4 == 0 && var0.field1124) {
            var0.interacting = -1;
            var0.field1124 = false;
         }

         if(var4 != 0) {
            ++var0.field1139;
            boolean var6;
            if(var4 > 1024) {
               var0.angle -= var0.field1150;
               var6 = true;
               if(var4 < var0.field1150 || var4 > 2048 - var0.field1150) {
                  var0.angle = var0.orientation;
                  var6 = false;
               }

               if(var0.idlePoseAnimation == var0.poseAnimation && (var0.field1139 > 25 || var6)) {
                  if(var0.field1106 != -1) {
                     var0.poseAnimation = var0.field1106;
                  } else {
                     var0.poseAnimation = var0.field1105;
                  }
               }
            } else {
               var0.angle += var0.field1150;
               var6 = true;
               if(var4 < var0.field1150 || var4 > 2048 - var0.field1150) {
                  var0.angle = var0.orientation;
                  var6 = false;
               }

               if(var0.idlePoseAnimation == var0.poseAnimation && (var0.field1139 > 25 || var6)) {
                  if(var0.field1149 != -1) {
                     var0.poseAnimation = var0.field1149;
                  } else {
                     var0.poseAnimation = var0.field1105;
                  }
               }
            }

            var0.angle &= 2047;
         } else {
            var0.field1139 = 0;
         }

      }
   }
}
