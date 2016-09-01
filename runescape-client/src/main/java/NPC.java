import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("au")
@Implements("NPC")
public final class NPC extends Actor {
   @ObfuscatedName("x")
   @Export("composition")
   NPCComposition composition;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IBI)V",
      garbageValue = "509721193"
   )
   final void method716(int var1, byte var2) {
      int var3 = super.pathX[0];
      int var4 = super.pathY[0];
      if(var1 == 0) {
         --var3;
         ++var4;
      }

      if(var1 == 1) {
         ++var4;
      }

      if(var1 == 2) {
         ++var3;
         ++var4;
      }

      if(var1 == 3) {
         --var3;
      }

      if(var1 == 4) {
         ++var3;
      }

      if(var1 == 5) {
         --var3;
         --var4;
      }

      if(var1 == 6) {
         --var4;
      }

      if(var1 == 7) {
         ++var3;
         --var4;
      }

      if(super.animation != -1 && class113.getAnimation(super.animation).field1009 == 1) {
         super.animation = -1;
      }

      if(super.field871 < 9) {
         ++super.field871;
      }

      for(int var5 = super.field871; var5 > 0; --var5) {
         super.pathX[var5] = super.pathX[var5 - 1];
         super.pathY[var5] = super.pathY[var5 - 1];
         super.field830[var5] = super.field830[var5 - 1];
      }

      super.pathX[0] = var3;
      super.pathY[0] = var4;
      super.field830[0] = var2;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "-1904052091"
   )
   protected final Model getModel() {
      if(this.composition == null) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?class113.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation == -1 || super.idlePoseAnimation == super.poseAnimation && var1 != null?null:class113.getAnimation(super.poseAnimation);
         Model var3 = this.composition.method777(var1, super.actionFrame, var2, super.poseFrame);
         if(null == var3) {
            return null;
         } else {
            var3.method2391();
            super.field867 = var3.modelHeight;
            if(super.graphic != -1 && super.field855 != -1) {
               Model var4 = Renderable.method1946(super.graphic).method906(super.field855);
               if(null != var4) {
                  var4.method2429(0, -super.field858, 0);
                  Model[] var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(this.composition.field902 == 1) {
               var3.field1866 = true;
            }

            return var3;
         }
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1014507711"
   )
   final boolean vmethod750() {
      return null != this.composition;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;II[BII)I",
      garbageValue = "-1602002780"
   )
   public static int method720(CharSequence var0, int var1, int var2, byte[] var3, int var4) {
      int var5 = var2 - var1;

      for(int var6 = 0; var6 < var5; ++var6) {
         char var7 = var0.charAt(var1 + var6);
         if((var7 <= 0 || var7 >= 128) && (var7 < 160 || var7 > 255)) {
            if(var7 == 8364) {
               var3[var4 + var6] = -128;
            } else if(var7 == 8218) {
               var3[var6 + var4] = -126;
            } else if(var7 == 402) {
               var3[var4 + var6] = -125;
            } else if(var7 == 8222) {
               var3[var4 + var6] = -124;
            } else if(var7 == 8230) {
               var3[var4 + var6] = -123;
            } else if(var7 == 8224) {
               var3[var6 + var4] = -122;
            } else if(var7 == 8225) {
               var3[var6 + var4] = -121;
            } else if(var7 == 710) {
               var3[var6 + var4] = -120;
            } else if(var7 == 8240) {
               var3[var4 + var6] = -119;
            } else if(var7 == 352) {
               var3[var6 + var4] = -118;
            } else if(var7 == 8249) {
               var3[var6 + var4] = -117;
            } else if(var7 == 338) {
               var3[var4 + var6] = -116;
            } else if(var7 == 381) {
               var3[var6 + var4] = -114;
            } else if(var7 == 8216) {
               var3[var6 + var4] = -111;
            } else if(var7 == 8217) {
               var3[var4 + var6] = -110;
            } else if(var7 == 8220) {
               var3[var6 + var4] = -109;
            } else if(var7 == 8221) {
               var3[var6 + var4] = -108;
            } else if(var7 == 8226) {
               var3[var6 + var4] = -107;
            } else if(var7 == 8211) {
               var3[var4 + var6] = -106;
            } else if(var7 == 8212) {
               var3[var4 + var6] = -105;
            } else if(var7 == 732) {
               var3[var6 + var4] = -104;
            } else if(var7 == 8482) {
               var3[var4 + var6] = -103;
            } else if(var7 == 353) {
               var3[var6 + var4] = -102;
            } else if(var7 == 8250) {
               var3[var4 + var6] = -101;
            } else if(var7 == 339) {
               var3[var4 + var6] = -100;
            } else if(var7 == 382) {
               var3[var4 + var6] = -98;
            } else if(var7 == 376) {
               var3[var4 + var6] = -97;
            } else {
               var3[var6 + var4] = 63;
            }
         } else {
            var3[var4 + var6] = (byte)var7;
         }
      }

      return var5;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIZS)V",
      garbageValue = "18850"
   )
   final void method729(int var1, int var2, boolean var3) {
      if(super.animation != -1 && class113.getAnimation(super.animation).field1009 == 1) {
         super.animation = -1;
      }

      if(!var3) {
         int var4 = var1 - super.pathX[0];
         int var5 = var2 - super.pathY[0];
         if(var4 >= -8 && var4 <= 8 && var5 >= -8 && var5 <= 8) {
            if(super.field871 < 9) {
               ++super.field871;
            }

            for(int var6 = super.field871; var6 > 0; --var6) {
               super.pathX[var6] = super.pathX[var6 - 1];
               super.pathY[var6] = super.pathY[var6 - 1];
               super.field830[var6] = super.field830[var6 - 1];
            }

            super.pathX[0] = var1;
            super.pathY[0] = var2;
            super.field830[0] = 1;
            return;
         }
      }

      super.field871 = 0;
      super.field822 = 0;
      super.field875 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.x = super.field821 * 64 + super.pathX[0] * 128;
      super.y = super.field821 * 64 + 128 * super.pathY[0];
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "([BIIB)Z",
      garbageValue = "-107"
   )
   static final boolean method730(byte[] var0, int var1, int var2) {
      boolean var3 = true;
      Buffer var4 = new Buffer(var0);
      int var5 = -1;

      label82:
      while(true) {
         int var6 = var4.method2569();
         if(var6 == 0) {
            return var3;
         }

         var5 += var6;
         int var7 = 0;
         boolean var8 = false;

         while(true) {
            int var9;
            while(!var8) {
               var9 = var4.method2569();
               if(var9 == 0) {
                  continue label82;
               }

               var7 += var9 - 1;
               int var10 = var7 & 63;
               int var11 = var7 >> 6 & 63;
               int var12 = var4.method2556() >> 2;
               int var13 = var11 + var1;
               int var14 = var10 + var2;
               if(var13 > 0 && var14 > 0 && var13 < 103 && var14 < 103) {
                  ObjectComposition var15 = class1.getObjectDefinition(var5);
                  if(var12 != 22 || !Client.field314 || var15.field966 != 0 || var15.field940 == 1 || var15.field961) {
                     if(!var15.method802()) {
                        ++Client.field337;
                        var3 = false;
                     }

                     var8 = true;
                  }
               }
            }

            var9 = var4.method2569();
            if(var9 == 0) {
               break;
            }

            var4.method2556();
         }
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(ILclass170;Ljava/lang/String;Ljava/lang/String;IZI)V",
      garbageValue = "1585657180"
   )
   public static void method731(int var0, class170 var1, String var2, String var3, int var4, boolean var5) {
      int var6 = var1.method3359(var2);
      int var7 = var1.method3305(var6, var3);
      class24.method578(var0, var1, var6, var7, var4, var5);
   }
}
