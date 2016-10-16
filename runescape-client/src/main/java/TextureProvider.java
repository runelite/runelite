import java.awt.Component;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cn")
@Implements("TextureProvider")
public class TextureProvider implements class95 {
   @ObfuscatedName("m")
   class170 field1656;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 201398693
   )
   int field1657;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 546833109
   )
   int field1658 = 0;
   @ObfuscatedName("p")
   double field1659 = 1.0D;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 415236367
   )
   int field1660 = 128;
   @ObfuscatedName("z")
   Deque field1661 = new Deque();
   @ObfuscatedName("hd")
   @Export("localPlayer")
   static Player localPlayer;
   @ObfuscatedName("s")
   class86[] field1665;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "-1428429575"
   )
   @Export("load")
   public int[] load(int var1) {
      class86 var2 = this.field1665[var1];
      if(var2 != null) {
         if(var2.field1481 != null) {
            this.field1661.method3811(var2);
            var2.field1493 = true;
            return var2.field1481;
         }

         boolean var3 = var2.method1897(this.field1659, this.field1660, this.field1656);
         if(var3) {
            if(this.field1658 == 0) {
               class86 var4 = (class86)this.field1661.method3807();
               var4.method1901();
            } else {
               --this.field1658;
            }

            this.field1661.method3811(var2);
            var2.field1493 = true;
            return var2.field1481;
         }
      }

      return null;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1992274994"
   )
   public void method2155(int var1) {
      for(int var2 = 0; var2 < this.field1665.length; ++var2) {
         class86 var3 = this.field1665[var2];
         if(null != var3 && var3.field1492 != 0 && var3.field1493) {
            var3.method1899(var1);
            var3.field1493 = false;
         }
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1648836859"
   )
   public boolean vmethod2156(int var1) {
      return this.field1660 == 64;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "15"
   )
   public void method2157() {
      for(int var1 = 0; var1 < this.field1665.length; ++var1) {
         if(this.field1665[var1] != null) {
            this.field1665[var1].method1901();
         }
      }

      this.field1661 = new Deque();
      this.field1658 = this.field1657;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-324567181"
   )
   public int vmethod2160(int var1) {
      return null != this.field1665[var1]?this.field1665[var1].field1485:0;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1218593576"
   )
   public boolean vmethod2161(int var1) {
      return this.field1665[var1].field1490;
   }

   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;IDI)V",
      garbageValue = "64"
   )
   public TextureProvider(class170 var1, class170 var2, int var3, double var4, int var6) {
      this.field1656 = var2;
      this.field1657 = var3;
      this.field1658 = this.field1657;
      this.field1659 = var4;
      this.field1660 = var6;
      int[] var7 = var1.method3282(0);
      int var8 = var7.length;
      this.field1665 = new class86[var1.method3260(0)];

      for(int var9 = 0; var9 < var8; ++var9) {
         Buffer var10 = new Buffer(var1.method3272(0, var7[var9]));
         this.field1665[var7[var9]] = new class86(var10);
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "([BIIS)Ljava/lang/String;",
      garbageValue = "17084"
   )
   public static String method2163(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         int var6 = var0[var1 + var5] & 255;
         if(var6 != 0) {
            if(var6 >= 128 && var6 < 160) {
               char var7 = class168.field2709[var6 - 128];
               if(var7 == 0) {
                  var7 = 63;
               }

               var6 = var7;
            }

            var3[var4++] = (char)var6;
         }
      }

      return new String(var3, 0, var4);
   }

   @ObfuscatedName("dk")
   @ObfuscatedSignature(
      signature = "(IIIILSpritePixels;Lclass178;I)V",
      garbageValue = "-1205202355"
   )
   static final void method2172(int var0, int var1, int var2, int var3, SpritePixels var4, class178 var5) {
      if(null != var4) {
         int var6 = Client.mapScale + Client.mapAngle & 2047;
         int var7 = var3 * var3 + var2 * var2;
         if(var7 <= 6400) {
            int var8 = class94.field1631[var6];
            int var9 = class94.field1621[var6];
            var8 = 256 * var8 / (Client.mapScaleDelta + 256);
            var9 = var9 * 256 / (Client.mapScaleDelta + 256);
            int var10 = var3 * var8 + var9 * var2 >> 16;
            int var11 = var9 * var3 - var2 * var8 >> 16;
            if(var7 > 2500) {
               var4.method1722(var5.field2943 / 2 + var10 - var4.field1439 / 2, var5.field2944 / 2 - var11 - var4.field1445 / 2, var0, var1, var5.field2943, var5.field2944, var5.field2948, var5.field2945);
            } else {
               var4.method1712(var10 + var5.field2943 / 2 + var0 - var4.field1439 / 2, var1 + var5.field2944 / 2 - var11 - var4.field1445 / 2);
            }

         }
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "34"
   )
   public static void method2173(Component var0) {
      var0.removeKeyListener(class140.keyboard);
      var0.removeFocusListener(class140.keyboard);
      class140.field2150 = -1;
   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "-2137834695"
   )
   static final void method2174(int var0, int var1, int var2, int var3, int var4) {
      int var5 = class114.region.method2004(var0, var1, var2);
      int var6;
      int var7;
      int var8;
      int var9;
      int var11;
      int var18;
      if(var5 != 0) {
         var6 = class114.region.method1945(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var3;
         if(var5 > 0) {
            var9 = var4;
         }

         int[] var10 = class11.field166.image;
         var11 = 4 * var1 + 24624 + 2048 * (103 - var2);
         var18 = var5 >> 14 & 32767;
         ObjectComposition var19 = class40.getObjectDefinition(var18);
         if(var19.field937 != -1) {
            ModIcon var14 = class16.field222[var19.field937];
            if(null != var14) {
               int var15 = (var19.field923 * 4 - var14.originalWidth) / 2;
               int var16 = (var19.field924 * 4 - var14.height) / 2;
               var14.method1871(48 + 4 * var1 + var15, (104 - var2 - var19.field924) * 4 + 48 + var16);
            }
         } else {
            if(var8 == 0 || var8 == 2) {
               if(var7 == 0) {
                  var10[var11] = var9;
                  var10[var11 + 512] = var9;
                  var10[1024 + var11] = var9;
                  var10[var11 + 1536] = var9;
               } else if(var7 == 1) {
                  var10[var11] = var9;
                  var10[1 + var11] = var9;
                  var10[2 + var11] = var9;
                  var10[var11 + 3] = var9;
               } else if(var7 == 2) {
                  var10[3 + var11] = var9;
                  var10[3 + var11 + 512] = var9;
                  var10[3 + var11 + 1024] = var9;
                  var10[var11 + 3 + 1536] = var9;
               } else if(var7 == 3) {
                  var10[var11 + 1536] = var9;
                  var10[1536 + var11 + 1] = var9;
                  var10[2 + 1536 + var11] = var9;
                  var10[1536 + var11 + 3] = var9;
               }
            }

            if(var8 == 3) {
               if(var7 == 0) {
                  var10[var11] = var9;
               } else if(var7 == 1) {
                  var10[var11 + 3] = var9;
               } else if(var7 == 2) {
                  var10[3 + var11 + 1536] = var9;
               } else if(var7 == 3) {
                  var10[1536 + var11] = var9;
               }
            }

            if(var8 == 2) {
               if(var7 == 3) {
                  var10[var11] = var9;
                  var10[var11 + 512] = var9;
                  var10[var11 + 1024] = var9;
                  var10[var11 + 1536] = var9;
               } else if(var7 == 0) {
                  var10[var11] = var9;
                  var10[var11 + 1] = var9;
                  var10[var11 + 2] = var9;
                  var10[var11 + 3] = var9;
               } else if(var7 == 1) {
                  var10[3 + var11] = var9;
                  var10[512 + var11 + 3] = var9;
                  var10[1024 + 3 + var11] = var9;
                  var10[3 + var11 + 1536] = var9;
               } else if(var7 == 2) {
                  var10[1536 + var11] = var9;
                  var10[1 + var11 + 1536] = var9;
                  var10[2 + var11 + 1536] = var9;
                  var10[1536 + var11 + 3] = var9;
               }
            }
         }
      }

      var5 = class114.region.method1943(var0, var1, var2);
      if(var5 != 0) {
         var6 = class114.region.method1945(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var5 >> 14 & 32767;
         ObjectComposition var23 = class40.getObjectDefinition(var9);
         int var13;
         if(var23.field937 != -1) {
            ModIcon var17 = class16.field222[var23.field937];
            if(null != var17) {
               var18 = (var23.field923 * 4 - var17.originalWidth) / 2;
               var13 = (var23.field924 * 4 - var17.height) / 2;
               var17.method1871(48 + 4 * var1 + var18, var13 + 48 + (104 - var2 - var23.field924) * 4);
            }
         } else if(var8 == 9) {
            var11 = 15658734;
            if(var5 > 0) {
               var11 = 15597568;
            }

            int[] var12 = class11.field166.image;
            var13 = 2048 * (103 - var2) + 24624 + var1 * 4;
            if(var7 != 0 && var7 != 2) {
               var12[var13] = var11;
               var12[512 + var13 + 1] = var11;
               var12[1024 + var13 + 2] = var11;
               var12[var13 + 1536 + 3] = var11;
            } else {
               var12[var13 + 1536] = var11;
               var12[1 + var13 + 1024] = var11;
               var12[2 + var13 + 512] = var11;
               var12[var13 + 3] = var11;
            }
         }
      }

      var5 = class114.region.method1944(var0, var1, var2);
      if(var5 != 0) {
         var6 = var5 >> 14 & 32767;
         ObjectComposition var20 = class40.getObjectDefinition(var6);
         if(var20.field937 != -1) {
            ModIcon var21 = class16.field222[var20.field937];
            if(var21 != null) {
               var9 = (var20.field923 * 4 - var21.originalWidth) / 2;
               int var22 = (var20.field924 * 4 - var21.height) / 2;
               var21.method1871(var9 + 4 * var1 + 48, var22 + 48 + 4 * (104 - var2 - var20.field924));
            }
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(D)V",
      garbageValue = "0.9"
   )
   public void method2175(double var1) {
      this.field1659 = var1;
      this.method2157();
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(ILclass137;Lclass171;B)V",
      garbageValue = "-5"
   )
   static void method2176(int var0, class137 var1, class171 var2) {
      byte[] var3 = null;
      Deque var4 = class173.field2760;
      synchronized(class173.field2760) {
         for(class172 var5 = (class172)class173.field2760.method3808(); var5 != null; var5 = (class172)class173.field2760.method3810()) {
            if((long)var0 == var5.hash && var5.field2750 == var1 && var5.field2758 == 0) {
               var3 = var5.field2757;
               break;
            }
         }
      }

      if(var3 != null) {
         var2.method3337(var1, var0, var3, true);
      } else {
         byte[] var8 = var1.method2868(var0);
         var2.method3337(var1, var0, var8, true);
      }
   }
}
