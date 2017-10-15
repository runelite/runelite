import java.awt.Component;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aw")
public class class45 extends class28 {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -607005123
   )
   int field604;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 478487487
   )
   int field607;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1037110155
   )
   int field603;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1315342335
   )
   int field606;

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1062396151"
   )
   int method647() {
      return this.field603;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "1791482049"
   )
   boolean method643(int var1, int var2) {
      return var1 < this.field603 * 8?false:(var2 < this.field606 * 8?false:(var1 >= 8 + this.field603 * 8?false:var2 < 8 + this.field606 * 8));
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1855841522"
   )
   int method648() {
      return this.field606;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lfg;Lfg;B)V",
      garbageValue = "43"
   )
   void method641(Buffer var1, Buffer var2) {
      int var3 = var2.readUnsignedByte();
      if(var3 != class36.field524.field523) {
         throw new IllegalStateException("");
      } else {
         super.field425 = var2.readUnsignedByte();
         super.field419 = var2.readUnsignedByte();
         super.field418 = var2.readUnsignedShort();
         super.field426 = var2.readUnsignedShort();
         this.field607 = var2.readUnsignedByte();
         this.field604 = var2.readUnsignedByte();
         super.field416 = var2.readUnsignedShort();
         super.field417 = var2.readUnsignedShort();
         this.field603 = var2.readUnsignedByte();
         this.field606 = var2.readUnsignedByte();
         super.field419 = Math.min(super.field419, 4);
         super.field420 = new short[1][64][64];
         super.field421 = new short[super.field419][64][64];
         super.field422 = new byte[super.field419][64][64];
         super.field423 = new byte[super.field419][64][64];
         super.field424 = new class31[super.field419][64][64][];
         var3 = var1.readUnsignedByte();
         if(var3 != class35.field512.field513) {
            throw new IllegalStateException("");
         } else {
            int var4 = var1.readUnsignedByte();
            int var5 = var1.readUnsignedByte();
            int var6 = var1.readUnsignedByte();
            int var7 = var1.readUnsignedByte();
            if(var4 == super.field416 && var5 == super.field417 && var6 == this.field603 && var7 == this.field606) {
               for(int var8 = 0; var8 < 8; ++var8) {
                  for(int var9 = 0; var9 < 8; ++var9) {
                     this.method228(var8 + this.field603 * 8, var9 + this.field606 * 8, var1);
                  }
               }

            } else {
               throw new IllegalStateException("");
            }
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1206693689"
   )
   int method657() {
      return this.field607;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-846552591"
   )
   int method644() {
      return this.field604;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof class45)) {
         return false;
      } else {
         class45 var2 = (class45)var1;
         return var2.field416 == super.field416 && var2.field417 == super.field417?this.field603 == var2.field603 && this.field606 == var2.field606:false;
      }
   }

   public int hashCode() {
      return super.field416 | super.field417 << 8 | this.field603 << 16 | this.field606 << 24;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "2139458086"
   )
   static void method652(Component var0) {
      var0.addMouseListener(MouseInput.mouse);
      var0.addMouseMotionListener(MouseInput.mouse);
      var0.addFocusListener(MouseInput.mouse);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lit;Ljava/lang/String;Ljava/lang/String;I)[Lkr;",
      garbageValue = "-1635160581"
   )
   public static SpritePixels[] method666(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      SpritePixels[] var5;
      if(!class249.method4517(var0, var3, var4)) {
         var5 = null;
      } else {
         var5 = GraphicsObject.method1735();
      }

      return var5;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIILfy;Lfq;Z[I[II)I",
      garbageValue = "1598769719"
   )
   public static int method667(int var0, int var1, int var2, class163 var3, CollisionData var4, boolean var5, int[] var6, int[] var7) {
      int var9;
      for(int var8 = 0; var8 < 128; ++var8) {
         for(var9 = 0; var9 < 128; ++var9) {
            class162.field2309[var8][var9] = 0;
            class162.field2307[var8][var9] = 99999999;
         }
      }

      int var10;
      int var11;
      byte var12;
      byte var13;
      int var14;
      int var15;
      byte var16;
      int var17;
      int[][] var18;
      int var19;
      int var20;
      int var21;
      int var22;
      boolean var28;
      boolean var29;
      int var30;
      int var31;
      int var33;
      if(var2 == 1) {
         var10 = var0;
         var11 = var1;
         var12 = 64;
         var13 = 64;
         var14 = var0 - var12;
         var15 = var1 - var13;
         class162.field2309[var12][var13] = 99;
         class162.field2307[var12][var13] = 0;
         var16 = 0;
         var17 = 0;
         class162.field2313[var16] = var0;
         var33 = var16 + 1;
         class162.field2314[var16] = var1;
         var18 = var4.flags;

         while(true) {
            if(var33 == var17) {
               class162.field2311 = var10;
               class162.field2312 = var11;
               var29 = false;
               break;
            }

            var10 = class162.field2313[var17];
            var11 = class162.field2314[var17];
            var17 = var17 + 1 & 4095;
            var30 = var10 - var14;
            var31 = var11 - var15;
            var19 = var10 - var4.x;
            var20 = var11 - var4.y;
            if(var3.vmethod3147(1, var10, var11, var4)) {
               class162.field2311 = var10;
               class162.field2312 = var11;
               var29 = true;
               break;
            }

            var21 = class162.field2307[var30][var31] + 1;
            if(var30 > 0 && class162.field2309[var30 - 1][var31] == 0 && (var18[var19 - 1][var20] & 19136776) == 0) {
               class162.field2313[var33] = var10 - 1;
               class162.field2314[var33] = var11;
               var33 = var33 + 1 & 4095;
               class162.field2309[var30 - 1][var31] = 2;
               class162.field2307[var30 - 1][var31] = var21;
            }

            if(var30 < 127 && class162.field2309[var30 + 1][var31] == 0 && (var18[var19 + 1][var20] & 19136896) == 0) {
               class162.field2313[var33] = var10 + 1;
               class162.field2314[var33] = var11;
               var33 = var33 + 1 & 4095;
               class162.field2309[var30 + 1][var31] = 8;
               class162.field2307[var30 + 1][var31] = var21;
            }

            if(var31 > 0 && class162.field2309[var30][var31 - 1] == 0 && (var18[var19][var20 - 1] & 19136770) == 0) {
               class162.field2313[var33] = var10;
               class162.field2314[var33] = var11 - 1;
               var33 = var33 + 1 & 4095;
               class162.field2309[var30][var31 - 1] = 1;
               class162.field2307[var30][var31 - 1] = var21;
            }

            if(var31 < 127 && class162.field2309[var30][var31 + 1] == 0 && (var18[var19][var20 + 1] & 19136800) == 0) {
               class162.field2313[var33] = var10;
               class162.field2314[var33] = var11 + 1;
               var33 = var33 + 1 & 4095;
               class162.field2309[var30][var31 + 1] = 4;
               class162.field2307[var30][var31 + 1] = var21;
            }

            if(var30 > 0 && var31 > 0 && class162.field2309[var30 - 1][var31 - 1] == 0 && (var18[var19 - 1][var20 - 1] & 19136782) == 0 && (var18[var19 - 1][var20] & 19136776) == 0 && (var18[var19][var20 - 1] & 19136770) == 0) {
               class162.field2313[var33] = var10 - 1;
               class162.field2314[var33] = var11 - 1;
               var33 = var33 + 1 & 4095;
               class162.field2309[var30 - 1][var31 - 1] = 3;
               class162.field2307[var30 - 1][var31 - 1] = var21;
            }

            if(var30 < 127 && var31 > 0 && 0 == class162.field2309[var30 + 1][var31 - 1] && (var18[var19 + 1][var20 - 1] & 19136899) == 0 && 0 == (var18[var19 + 1][var20] & 19136896) && (var18[var19][var20 - 1] & 19136770) == 0) {
               class162.field2313[var33] = var10 + 1;
               class162.field2314[var33] = var11 - 1;
               var33 = var33 + 1 & 4095;
               class162.field2309[var30 + 1][var31 - 1] = 9;
               class162.field2307[var30 + 1][var31 - 1] = var21;
            }

            if(var30 > 0 && var31 < 127 && class162.field2309[var30 - 1][var31 + 1] == 0 && 0 == (var18[var19 - 1][var20 + 1] & 19136824) && (var18[var19 - 1][var20] & 19136776) == 0 && (var18[var19][var20 + 1] & 19136800) == 0) {
               class162.field2313[var33] = var10 - 1;
               class162.field2314[var33] = var11 + 1;
               var33 = var33 + 1 & 4095;
               class162.field2309[var30 - 1][var31 + 1] = 6;
               class162.field2307[var30 - 1][var31 + 1] = var21;
            }

            if(var30 < 127 && var31 < 127 && 0 == class162.field2309[var30 + 1][var31 + 1] && (var18[var19 + 1][var20 + 1] & 19136992) == 0 && (var18[var19 + 1][var20] & 19136896) == 0 && (var18[var19][var20 + 1] & 19136800) == 0) {
               class162.field2313[var33] = var10 + 1;
               class162.field2314[var33] = var11 + 1;
               var33 = var33 + 1 & 4095;
               class162.field2309[var30 + 1][var31 + 1] = 12;
               class162.field2307[var30 + 1][var31 + 1] = var21;
            }
         }

         var28 = var29;
      } else if(var2 == 2) {
         var10 = var0;
         var11 = var1;
         var12 = 64;
         var13 = 64;
         var14 = var0 - var12;
         var15 = var1 - var13;
         class162.field2309[var12][var13] = 99;
         class162.field2307[var12][var13] = 0;
         var16 = 0;
         var17 = 0;
         class162.field2313[var16] = var0;
         var33 = var16 + 1;
         class162.field2314[var16] = var1;
         var18 = var4.flags;

         while(true) {
            if(var33 == var17) {
               class162.field2311 = var10;
               class162.field2312 = var11;
               var29 = false;
               break;
            }

            var10 = class162.field2313[var17];
            var11 = class162.field2314[var17];
            var17 = var17 + 1 & 4095;
            var30 = var10 - var14;
            var31 = var11 - var15;
            var19 = var10 - var4.x;
            var20 = var11 - var4.y;
            if(var3.vmethod3147(2, var10, var11, var4)) {
               class162.field2311 = var10;
               class162.field2312 = var11;
               var29 = true;
               break;
            }

            var21 = class162.field2307[var30][var31] + 1;
            if(var30 > 0 && class162.field2309[var30 - 1][var31] == 0 && (var18[var19 - 1][var20] & 19136782) == 0 && 0 == (var18[var19 - 1][var20 + 1] & 19136824)) {
               class162.field2313[var33] = var10 - 1;
               class162.field2314[var33] = var11;
               var33 = var33 + 1 & 4095;
               class162.field2309[var30 - 1][var31] = 2;
               class162.field2307[var30 - 1][var31] = var21;
            }

            if(var30 < 126 && class162.field2309[var30 + 1][var31] == 0 && (var18[var19 + 2][var20] & 19136899) == 0 && (var18[var19 + 2][var20 + 1] & 19136992) == 0) {
               class162.field2313[var33] = var10 + 1;
               class162.field2314[var33] = var11;
               var33 = var33 + 1 & 4095;
               class162.field2309[var30 + 1][var31] = 8;
               class162.field2307[var30 + 1][var31] = var21;
            }

            if(var31 > 0 && class162.field2309[var30][var31 - 1] == 0 && (var18[var19][var20 - 1] & 19136782) == 0 && (var18[var19 + 1][var20 - 1] & 19136899) == 0) {
               class162.field2313[var33] = var10;
               class162.field2314[var33] = var11 - 1;
               var33 = var33 + 1 & 4095;
               class162.field2309[var30][var31 - 1] = 1;
               class162.field2307[var30][var31 - 1] = var21;
            }

            if(var31 < 126 && class162.field2309[var30][var31 + 1] == 0 && (var18[var19][var20 + 2] & 19136824) == 0 && (var18[var19 + 1][var20 + 2] & 19136992) == 0) {
               class162.field2313[var33] = var10;
               class162.field2314[var33] = var11 + 1;
               var33 = var33 + 1 & 4095;
               class162.field2309[var30][var31 + 1] = 4;
               class162.field2307[var30][var31 + 1] = var21;
            }

            if(var30 > 0 && var31 > 0 && class162.field2309[var30 - 1][var31 - 1] == 0 && (var18[var19 - 1][var20] & 19136830) == 0 && (var18[var19 - 1][var20 - 1] & 19136782) == 0 && (var18[var19][var20 - 1] & 19136911) == 0) {
               class162.field2313[var33] = var10 - 1;
               class162.field2314[var33] = var11 - 1;
               var33 = var33 + 1 & 4095;
               class162.field2309[var30 - 1][var31 - 1] = 3;
               class162.field2307[var30 - 1][var31 - 1] = var21;
            }

            if(var30 < 126 && var31 > 0 && class162.field2309[var30 + 1][var31 - 1] == 0 && (var18[var19 + 1][var20 - 1] & 19136911) == 0 && 0 == (var18[var19 + 2][var20 - 1] & 19136899) && 0 == (var18[var19 + 2][var20] & 19136995)) {
               class162.field2313[var33] = var10 + 1;
               class162.field2314[var33] = var11 - 1;
               var33 = var33 + 1 & 4095;
               class162.field2309[var30 + 1][var31 - 1] = 9;
               class162.field2307[var30 + 1][var31 - 1] = var21;
            }

            if(var30 > 0 && var31 < 126 && class162.field2309[var30 - 1][var31 + 1] == 0 && 0 == (var18[var19 - 1][var20 + 1] & 19136830) && (var18[var19 - 1][var20 + 2] & 19136824) == 0 && (var18[var19][var20 + 2] & 19137016) == 0) {
               class162.field2313[var33] = var10 - 1;
               class162.field2314[var33] = var11 + 1;
               var33 = var33 + 1 & 4095;
               class162.field2309[var30 - 1][var31 + 1] = 6;
               class162.field2307[var30 - 1][var31 + 1] = var21;
            }

            if(var30 < 126 && var31 < 126 && 0 == class162.field2309[var30 + 1][var31 + 1] && (var18[var19 + 1][var20 + 2] & 19137016) == 0 && (var18[var19 + 2][var20 + 2] & 19136992) == 0 && (var18[var19 + 2][var20 + 1] & 19136995) == 0) {
               class162.field2313[var33] = var10 + 1;
               class162.field2314[var33] = var11 + 1;
               var33 = var33 + 1 & 4095;
               class162.field2309[var30 + 1][var31 + 1] = 12;
               class162.field2307[var30 + 1][var31 + 1] = var21;
            }
         }

         var28 = var29;
      } else {
         var10 = var0;
         var11 = var1;
         var12 = 64;
         var13 = 64;
         var14 = var0 - var12;
         var15 = var1 - var13;
         class162.field2309[var12][var13] = 99;
         class162.field2307[var12][var13] = 0;
         var16 = 0;
         var17 = 0;
         class162.field2313[var16] = var0;
         var33 = var16 + 1;
         class162.field2314[var16] = var1;
         var18 = var4.flags;

         label840:
         while(true) {
            label838:
            while(true) {
               do {
                  do {
                     do {
                        label815:
                        do {
                           if(var17 == var33) {
                              class162.field2311 = var10;
                              class162.field2312 = var11;
                              var29 = false;
                              break label840;
                           }

                           var10 = class162.field2313[var17];
                           var11 = class162.field2314[var17];
                           var17 = var17 + 1 & 4095;
                           var30 = var10 - var14;
                           var31 = var11 - var15;
                           var19 = var10 - var4.x;
                           var20 = var11 - var4.y;
                           if(var3.vmethod3147(var2, var10, var11, var4)) {
                              class162.field2311 = var10;
                              class162.field2312 = var11;
                              var29 = true;
                              break label840;
                           }

                           var21 = class162.field2307[var30][var31] + 1;
                           if(var30 > 0 && class162.field2309[var30 - 1][var31] == 0 && (var18[var19 - 1][var20] & 19136782) == 0 && (var18[var19 - 1][var20 + var2 - 1] & 19136824) == 0) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2 - 1) {
                                    class162.field2313[var33] = var10 - 1;
                                    class162.field2314[var33] = var11;
                                    var33 = var33 + 1 & 4095;
                                    class162.field2309[var30 - 1][var31] = 2;
                                    class162.field2307[var30 - 1][var31] = var21;
                                    break;
                                 }

                                 if((var18[var19 - 1][var20 + var22] & 19136830) != 0) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var30 < 128 - var2 && 0 == class162.field2309[var30 + 1][var31] && (var18[var19 + var2][var20] & 19136899) == 0 && (var18[var19 + var2][var20 + var2 - 1] & 19136992) == 0) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2 - 1) {
                                    class162.field2313[var33] = var10 + 1;
                                    class162.field2314[var33] = var11;
                                    var33 = var33 + 1 & 4095;
                                    class162.field2309[var30 + 1][var31] = 8;
                                    class162.field2307[var30 + 1][var31] = var21;
                                    break;
                                 }

                                 if((var18[var19 + var2][var20 + var22] & 19136995) != 0) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var31 > 0 && class162.field2309[var30][var31 - 1] == 0 && (var18[var19][var20 - 1] & 19136782) == 0 && (var18[var19 + var2 - 1][var20 - 1] & 19136899) == 0) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2 - 1) {
                                    class162.field2313[var33] = var10;
                                    class162.field2314[var33] = var11 - 1;
                                    var33 = var33 + 1 & 4095;
                                    class162.field2309[var30][var31 - 1] = 1;
                                    class162.field2307[var30][var31 - 1] = var21;
                                    break;
                                 }

                                 if((var18[var22 + var19][var20 - 1] & 19136911) != 0) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var31 < 128 - var2 && class162.field2309[var30][var31 + 1] == 0 && (var18[var19][var20 + var2] & 19136824) == 0 && 0 == (var18[var19 + var2 - 1][var20 + var2] & 19136992)) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2 - 1) {
                                    class162.field2313[var33] = var10;
                                    class162.field2314[var33] = var11 + 1;
                                    var33 = var33 + 1 & 4095;
                                    class162.field2309[var30][var31 + 1] = 4;
                                    class162.field2307[var30][var31 + 1] = var21;
                                    break;
                                 }

                                 if(0 != (var18[var19 + var22][var20 + var2] & 19137016)) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var30 > 0 && var31 > 0 && class162.field2309[var30 - 1][var31 - 1] == 0 && (var18[var19 - 1][var20 - 1] & 19136782) == 0) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2) {
                                    class162.field2313[var33] = var10 - 1;
                                    class162.field2314[var33] = var11 - 1;
                                    var33 = var33 + 1 & 4095;
                                    class162.field2309[var30 - 1][var31 - 1] = 3;
                                    class162.field2307[var30 - 1][var31 - 1] = var21;
                                    break;
                                 }

                                 if(0 != (var18[var19 - 1][var22 + (var20 - 1)] & 19136830) || (var18[var22 + (var19 - 1)][var20 - 1] & 19136911) != 0) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var30 < 128 - var2 && var31 > 0 && class162.field2309[var30 + 1][var31 - 1] == 0 && 0 == (var18[var19 + var2][var20 - 1] & 19136899)) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2) {
                                    class162.field2313[var33] = var10 + 1;
                                    class162.field2314[var33] = var11 - 1;
                                    var33 = var33 + 1 & 4095;
                                    class162.field2309[var30 + 1][var31 - 1] = 9;
                                    class162.field2307[var30 + 1][var31 - 1] = var21;
                                    break;
                                 }

                                 if(0 != (var18[var19 + var2][var22 + (var20 - 1)] & 19136995) || (var18[var19 + var22][var20 - 1] & 19136911) != 0) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var30 > 0 && var31 < 128 - var2 && 0 == class162.field2309[var30 - 1][var31 + 1] && (var18[var19 - 1][var20 + var2] & 19136824) == 0) {
                              for(var22 = 1; var22 < var2; ++var22) {
                                 if((var18[var19 - 1][var22 + var20] & 19136830) != 0 || (var18[var22 + (var19 - 1)][var20 + var2] & 19137016) != 0) {
                                    continue label815;
                                 }
                              }

                              class162.field2313[var33] = var10 - 1;
                              class162.field2314[var33] = var11 + 1;
                              var33 = var33 + 1 & 4095;
                              class162.field2309[var30 - 1][var31 + 1] = 6;
                              class162.field2307[var30 - 1][var31 + 1] = var21;
                           }
                        } while(var30 >= 128 - var2);
                     } while(var31 >= 128 - var2);
                  } while(class162.field2309[var30 + 1][var31 + 1] != 0);
               } while(0 != (var18[var19 + var2][var20 + var2] & 19136992));

               for(var22 = 1; var22 < var2; ++var22) {
                  if((var18[var19 + var22][var20 + var2] & 19137016) != 0 || (var18[var19 + var2][var22 + var20] & 19136995) != 0) {
                     continue label838;
                  }
               }

               class162.field2313[var33] = var10 + 1;
               class162.field2314[var33] = var11 + 1;
               var33 = var33 + 1 & 4095;
               class162.field2309[var30 + 1][var31 + 1] = 12;
               class162.field2307[var30 + 1][var31 + 1] = var21;
            }
         }

         var28 = var29;
      }

      var9 = var0 - 64;
      var10 = var1 - 64;
      var11 = class162.field2311;
      var30 = class162.field2312;
      if(!var28) {
         var31 = Integer.MAX_VALUE;
         var14 = Integer.MAX_VALUE;
         byte var32 = 10;
         var33 = var3.field2317;
         var17 = var3.field2318;
         int var27 = var3.field2319;
         var19 = var3.field2320;

         for(var20 = var33 - var32; var20 <= var32 + var33; ++var20) {
            for(var21 = var17 - var32; var21 <= var32 + var17; ++var21) {
               var22 = var20 - var9;
               int var23 = var21 - var10;
               if(var22 >= 0 && var23 >= 0 && var22 < 128 && var23 < 128 && class162.field2307[var22][var23] < 100) {
                  int var24 = 0;
                  if(var20 < var33) {
                     var24 = var33 - var20;
                  } else if(var20 > var33 + var27 - 1) {
                     var24 = var20 - (var27 + var33 - 1);
                  }

                  int var25 = 0;
                  if(var21 < var17) {
                     var25 = var17 - var21;
                  } else if(var21 > var17 + var19 - 1) {
                     var25 = var21 - (var19 + var17 - 1);
                  }

                  int var26 = var25 * var25 + var24 * var24;
                  if(var26 < var31 || var31 == var26 && class162.field2307[var22][var23] < var14) {
                     var31 = var26;
                     var14 = class162.field2307[var22][var23];
                     var11 = var20;
                     var30 = var21;
                  }
               }
            }
         }

         if(var31 == Integer.MAX_VALUE) {
            return -1;
         }
      }

      if(var0 == var11 && var30 == var1) {
         return 0;
      } else {
         var13 = 0;
         class162.field2313[var13] = var11;
         var31 = var13 + 1;
         class162.field2314[var13] = var30;

         for(var14 = var15 = class162.field2309[var11 - var9][var30 - var10]; var0 != var11 || var30 != var1; var14 = class162.field2309[var11 - var9][var30 - var10]) {
            if(var15 != var14) {
               var15 = var14;
               class162.field2313[var31] = var11;
               class162.field2314[var31++] = var30;
            }

            if((var14 & 2) != 0) {
               ++var11;
            } else if((var14 & 8) != 0) {
               --var11;
            }

            if((var14 & 1) != 0) {
               ++var30;
            } else if((var14 & 4) != 0) {
               --var30;
            }
         }

         var33 = 0;

         while(var31-- > 0) {
            var6[var33] = class162.field2313[var31];
            var7[var33++] = class162.field2314[var31];
            if(var33 >= var6.length) {
               break;
            }
         }

         return var33;
      }
   }
}
