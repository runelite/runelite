import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ik")
public class class234 extends TaskDataNode {
   @ObfuscatedName("j")
   @Export("scriptLocalStrings")
   static String[] scriptLocalStrings;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lht;"
   )
   class230 field2759;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lhl;"
   )
   Deque field2757;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lcs;"
   )
   class100 field2760;

   @ObfuscatedSignature(
      signature = "(Lht;)V"
   )
   class234(class230 var1) {
      this.field2757 = new Deque();
      this.field2760 = new class100();
      this.field2759 = var1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lhu;[IIIIB)V",
      garbageValue = "2"
   )
   void method4341(class231 var1, int[] var2, int var3, int var4, int var5) {
      if((this.field2759.field2698[var1.field2725] & 4) != 0 && var1.field2728 < 0) {
         int var6 = this.field2759.field2703[var1.field2725] / class317.sampleRate;

         while(true) {
            int var7 = (var6 + 1048575 - var1.field2734) / var6;
            if(var7 > var4) {
               var1.field2734 += var6 * var4;
               break;
            }

            var1.field2732.vmethod4339(var2, var3, var7);
            var3 += var7;
            var4 -= var7;
            var1.field2734 += var7 * var6 - 1048576;
            int var8 = class317.sampleRate / 100;
            int var9 = 262144 / var6;
            if(var9 < var8) {
               var8 = var9;
            }

            class115 var10 = var1.field2732;
            if(this.field2759.field2701[var1.field2725] == 0) {
               var1.field2732 = class115.method2446(var1.field2716, var10.method2296(), var10.method2307(), var10.method2436());
            } else {
               var1.field2732 = class115.method2446(var1.field2716, var10.method2296(), 0, var10.method2436());
               this.field2759.method4219(var1, var1.field2715.field2752[var1.field2719] < 0);
               var1.field2732.method2312(var8, var10.method2307());
            }

            if(var1.field2715.field2752[var1.field2719] < 0) {
               var1.field2732.method2303(-1);
            }

            var10.method2314(var8);
            var10.vmethod4339(var2, var3, var5 - var3);
            if(var10.method2318()) {
               this.field2760.method2085(var10);
            }
         }
      }

      var1.field2732.vmethod4339(var2, var3, var4);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lhu;II)V",
      garbageValue = "-1825285835"
   )
   void method4342(class231 var1, int var2) {
      if((this.field2759.field2698[var1.field2725] & 4) != 0 && var1.field2728 < 0) {
         int var3 = this.field2759.field2703[var1.field2725] / class317.sampleRate;
         int var4 = (var3 + 1048575 - var1.field2734) / var3;
         var1.field2734 = var3 * var2 + var1.field2734 & 1048575;
         if(var4 <= var2) {
            if(this.field2759.field2701[var1.field2725] == 0) {
               var1.field2732 = class115.method2446(var1.field2716, var1.field2732.method2296(), var1.field2732.method2307(), var1.field2732.method2436());
            } else {
               var1.field2732 = class115.method2446(var1.field2716, var1.field2732.method2296(), 0, var1.field2732.method2436());
               this.field2759.method4219(var1, var1.field2715.field2752[var1.field2719] < 0);
            }

            if(var1.field2715.field2752[var1.field2719] < 0) {
               var1.field2732.method2303(-1);
            }

            var2 = var1.field2734 / var3;
         }
      }

      var1.field2732.vmethod4340(var2);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "()Ldd;"
   )
   protected TaskDataNode vmethod4336() {
      class231 var1 = (class231)this.field2757.getFront();
      return (TaskDataNode)(var1 == null?null:(var1.field2732 != null?var1.field2732:this.vmethod4337()));
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "()Ldd;"
   )
   protected TaskDataNode vmethod4337() {
      class231 var1;
      do {
         var1 = (class231)this.field2757.getNext();
         if(var1 == null) {
            return null;
         }
      } while(var1.field2732 == null);

      return var1.field2732;
   }

   @ObfuscatedName("p")
   protected int vmethod4338() {
      return 0;
   }

   @ObfuscatedName("w")
   protected void vmethod4339(int[] var1, int var2, int var3) {
      this.field2760.vmethod4339(var1, var2, var3);

      for(class231 var6 = (class231)this.field2757.getFront(); var6 != null; var6 = (class231)this.field2757.getNext()) {
         if(!this.field2759.method4177(var6)) {
            int var4 = var2;
            int var5 = var3;

            do {
               if(var5 <= var6.field2714) {
                  this.method4341(var6, var1, var4, var5, var5 + var4);
                  var6.field2714 -= var5;
                  break;
               }

               this.method4341(var6, var1, var4, var6.field2714, var5 + var4);
               var4 += var6.field2714;
               var5 -= var6.field2714;
            } while(!this.field2759.method4199(var6, var1, var4, var5));
         }
      }

   }

   @ObfuscatedName("d")
   protected void vmethod4340(int var1) {
      this.field2760.vmethod4340(var1);

      for(class231 var3 = (class231)this.field2757.getFront(); var3 != null; var3 = (class231)this.field2757.getNext()) {
         if(!this.field2759.method4177(var3)) {
            int var2 = var1;

            do {
               if(var2 <= var3.field2714) {
                  this.method4342(var3, var2);
                  var3.field2714 -= var2;
                  break;
               }

               this.method4342(var3, var3.field2714);
               var2 -= var3.field2714;
            } while(!this.field2759.method4199(var3, (int[])null, 0, var2));
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(JLjava/lang/String;B)I",
      garbageValue = "-54"
   )
   static final int method4359(long var0, String var2) {
      Random var3 = new Random();
      Buffer var4 = new Buffer(128);
      Buffer var5 = new Buffer(128);
      int[] var6 = new int[]{var3.nextInt(), var3.nextInt(), (int)(var0 >> 32), (int)var0};
      var4.putByte(10);

      int var7;
      for(var7 = 0; var7 < 4; ++var7) {
         var4.putInt(var3.nextInt());
      }

      var4.putInt(var6[0]);
      var4.putInt(var6[1]);
      var4.putLong(var0);
      var4.putLong(0L);

      for(var7 = 0; var7 < 4; ++var7) {
         var4.putInt(var3.nextInt());
      }

      var4.encryptRsa(class85.field1302, class85.field1305);
      var5.putByte(10);

      for(var7 = 0; var7 < 3; ++var7) {
         var5.putInt(var3.nextInt());
      }

      var5.putLong(var3.nextLong());
      var5.method3507(var3.nextLong());
      Buffer.method3727(var5);
      var5.putLong(var3.nextLong());
      var5.encryptRsa(class85.field1302, class85.field1305);
      var7 = Projectile.getLength(var2);
      if(var7 % 8 != 0) {
         var7 += 8 - var7 % 8;
      }

      Buffer var8 = new Buffer(var7);
      var8.putString(var2);
      var8.offset = var7;
      var8.encryptXtea2(var6);
      Buffer var9 = new Buffer(var8.offset + var5.offset + var4.offset + 5);
      var9.putByte(2);
      var9.putByte(var4.offset);
      var9.putBytes(var4.payload, 0, var4.offset);
      var9.putByte(var5.offset);
      var9.putBytes(var5.payload, 0, var5.offset);
      var9.putShort(var8.offset);
      var9.putBytes(var8.payload, 0, var8.offset);
      byte[] var11 = var9.payload;
      int var13 = var11.length;
      StringBuilder var14 = new StringBuilder();

      int var17;
      for(int var15 = 0; var15 < var13 + 0; var15 += 3) {
         int var16 = var11[var15] & 255;
         var14.append(class317.field3924[var16 >>> 2]);
         if(var15 < var13 - 1) {
            var17 = var11[var15 + 1] & 255;
            var14.append(class317.field3924[(var16 & 3) << 4 | var17 >>> 4]);
            if(var15 < var13 - 2) {
               int var18 = var11[var15 + 2] & 255;
               var14.append(class317.field3924[(var17 & 15) << 2 | var18 >>> 6]).append(class317.field3924[var18 & 63]);
            } else {
               var14.append(class317.field3924[(var17 & 15) << 2]).append("=");
            }
         } else {
            var14.append(class317.field3924[(var16 & 3) << 4]).append("==");
         }
      }

      String var12 = var14.toString();
      var12 = var12;

      try {
         URL var19 = new URL(ClientPacket.method3421("services", false) + "m=accountappeal/login.ws");
         URLConnection var26 = var19.openConnection();
         var26.setDoInput(true);
         var26.setDoOutput(true);
         var26.setConnectTimeout(5000);
         OutputStreamWriter var20 = new OutputStreamWriter(var26.getOutputStream());
         var20.write("data2=" + ClanMember.method5258(var12) + "&dest=" + ClanMember.method5258("passwordchoice.ws"));
         var20.flush();
         InputStream var21 = var26.getInputStream();
         var9 = new Buffer(new byte[1000]);

         do {
            var17 = var21.read(var9.payload, var9.offset, 1000 - var9.offset);
            if(var17 == -1) {
               var20.close();
               var21.close();
               String var22 = new String(var9.payload);
               if(var22.startsWith("OFFLINE")) {
                  return 4;
               } else if(var22.startsWith("WRONG")) {
                  return 7;
               } else if(var22.startsWith("RELOAD")) {
                  return 3;
               } else if(var22.startsWith("Not permitted for social network accounts.")) {
                  return 6;
               } else {
                  var9.decryptXtea(var6);

                  while(var9.offset > 0 && var9.payload[var9.offset - 1] == 0) {
                     --var9.offset;
                  }

                  var22 = new String(var9.payload, 0, var9.offset);
                  if(!ScriptVarType.method22(var22)) {
                     return 5;
                  } else {
                     if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
                        try {
                           Desktop.getDesktop().browse(new URI(var22));
                           return 2;
                        } catch (Exception var24) {
                           ;
                        }
                     }

                     if(class57.field646.startsWith("win")) {
                        ItemLayer.method2580(var22, 0);
                     } else if(class57.field646.startsWith("mac")) {
                        WorldMapType2.method553(var22, 1, "openjs");
                     } else {
                        ItemLayer.method2580(var22, 2);
                     }

                     return 2;
                  }
               }
            }

            var9.offset += var17;
         } while(var9.offset < 1000);

         return 5;
      } catch (Throwable var25) {
         var25.printStackTrace();
         return 5;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIIIIILez;Lfk;I)V",
      garbageValue = "882834286"
   )
   @Export("addObject")
   static final void addObject(int var0, int var1, int var2, int var3, int var4, int var5, Region var6, CollisionData var7) {
      if(!Client.lowMemory || (class62.tileSettings[0][var1][var2] & 2) != 0 || (class62.tileSettings[var0][var1][var2] & 16) == 0) {
         if(var0 < class62.field722) {
            class62.field722 = var0;
         }

         ObjectComposition var8 = FileRequest.getObjectDefinition(var3);
         int var9;
         int var10;
         if(var4 != 1 && var4 != 3) {
            var9 = var8.width;
            var10 = var8.length;
         } else {
            var9 = var8.length;
            var10 = var8.width;
         }

         int var11;
         int var12;
         if(var9 + var1 <= 104) {
            var11 = (var9 >> 1) + var1;
            var12 = (var9 + 1 >> 1) + var1;
         } else {
            var11 = var1;
            var12 = var1 + 1;
         }

         int var13;
         int var14;
         if(var10 + var2 <= 104) {
            var13 = (var10 >> 1) + var2;
            var14 = var2 + (var10 + 1 >> 1);
         } else {
            var13 = var2;
            var14 = var2 + 1;
         }

         int[][] var15 = class62.tileHeights[var0];
         int var16 = var15[var12][var14] + var15[var11][var13] + var15[var12][var13] + var15[var11][var14] >> 2;
         int var17 = (var1 << 7) + (var9 << 6);
         int var18 = (var2 << 7) + (var10 << 6);
         int var19 = (var3 << 14) + (var2 << 7) + var1 + 1073741824;
         if(var8.int1 == 0) {
            var19 -= Integer.MIN_VALUE;
         }

         int var20 = var5 + (var4 << 6);
         if(var8.supportItems == 1) {
            var20 += 256;
         }

         if(var8.method5011()) {
            WorldMapRectangle.method269(var0, var1, var2, var8, var4);
         }

         Object var21;
         if(var5 == 22) {
            if(!Client.lowMemory || var8.int1 != 0 || var8.clipType == 1 || var8.obstructsGround) {
               if(var8.animationId == -1 && var8.impostorIds == null) {
                  var21 = var8.getModel(22, var4, var15, var17, var16, var18);
               } else {
                  var21 = new DynamicObject(var3, 22, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               var6.groundObjectSpawned(var0, var1, var2, var16, (Renderable)var21, var19, var20);
               if(var8.clipType == 1 && var7 != null) {
                  var7.method3399(var1, var2);
               }

            }
         } else {
            int var22;
            if(var5 != 10 && var5 != 11) {
               if(var5 >= 12) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var21 = var8.getModel(var5, var4, var15, var17, var16, var18);
                  } else {
                     var21 = new DynamicObject(var3, var5, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method2896(var0, var1, var2, var16, 1, 1, (Renderable)var21, 0, var19, var20);
                  if(var5 >= 12 && var5 <= 17 && var5 != 13 && var0 > 0) {
                     class62.field721[var0][var1][var2] |= 2340;
                  }

                  if(var8.clipType != 0 && var7 != null) {
                     var7.addObject(var1, var2, var9, var10, var8.blocksProjectile);
                  }

               } else if(var5 == 0) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var21 = var8.getModel(0, var4, var15, var17, var16, var18);
                  } else {
                     var21 = new DynamicObject(var3, 0, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.addBoundary(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, class62.field727[var4], 0, var19, var20);
                  if(var4 == 0) {
                     if(var8.clipped) {
                        class62.field725[var0][var1][var2] = 50;
                        class62.field725[var0][var1][var2 + 1] = 50;
                     }

                     if(var8.modelClipped) {
                        class62.field721[var0][var1][var2] |= 585;
                     }
                  } else if(var4 == 1) {
                     if(var8.clipped) {
                        class62.field725[var0][var1][var2 + 1] = 50;
                        class62.field725[var0][var1 + 1][var2 + 1] = 50;
                     }

                     if(var8.modelClipped) {
                        class62.field721[var0][var1][var2 + 1] |= 1170;
                     }
                  } else if(var4 == 2) {
                     if(var8.clipped) {
                        class62.field725[var0][var1 + 1][var2] = 50;
                        class62.field725[var0][var1 + 1][var2 + 1] = 50;
                     }

                     if(var8.modelClipped) {
                        class62.field721[var0][var1 + 1][var2] |= 585;
                     }
                  } else if(var4 == 3) {
                     if(var8.clipped) {
                        class62.field725[var0][var1][var2] = 50;
                        class62.field725[var0][var1 + 1][var2] = 50;
                     }

                     if(var8.modelClipped) {
                        class62.field721[var0][var1][var2] |= 1170;
                     }
                  }

                  if(var8.clipType != 0 && var7 != null) {
                     var7.method3385(var1, var2, var5, var4, var8.blocksProjectile);
                  }

                  if(var8.decorDisplacement != 16) {
                     var6.method2892(var0, var1, var2, var8.decorDisplacement);
                  }

               } else if(var5 == 1) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var21 = var8.getModel(1, var4, var15, var17, var16, var18);
                  } else {
                     var21 = new DynamicObject(var3, 1, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.addBoundary(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, class62.field731[var4], 0, var19, var20);
                  if(var8.clipped) {
                     if(var4 == 0) {
                        class62.field725[var0][var1][var2 + 1] = 50;
                     } else if(var4 == 1) {
                        class62.field725[var0][var1 + 1][var2 + 1] = 50;
                     } else if(var4 == 2) {
                        class62.field725[var0][var1 + 1][var2] = 50;
                     } else if(var4 == 3) {
                        class62.field725[var0][var1][var2] = 50;
                     }
                  }

                  if(var8.clipType != 0 && var7 != null) {
                     var7.method3385(var1, var2, var5, var4, var8.blocksProjectile);
                  }

               } else {
                  int var26;
                  Object var28;
                  if(var5 == 2) {
                     var26 = var4 + 1 & 3;
                     Object var27;
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var27 = var8.getModel(2, var4 + 4, var15, var17, var16, var18);
                        var28 = var8.getModel(2, var26, var15, var17, var16, var18);
                     } else {
                        var27 = new DynamicObject(var3, 2, var4 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                        var28 = new DynamicObject(var3, 2, var26, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.addBoundary(var0, var1, var2, var16, (Renderable)var27, (Renderable)var28, class62.field727[var4], class62.field727[var26], var19, var20);
                     if(var8.modelClipped) {
                        if(var4 == 0) {
                           class62.field721[var0][var1][var2] |= 585;
                           class62.field721[var0][var1][var2 + 1] |= 1170;
                        } else if(var4 == 1) {
                           class62.field721[var0][var1][1 + var2] |= 1170;
                           class62.field721[var0][var1 + 1][var2] |= 585;
                        } else if(var4 == 2) {
                           class62.field721[var0][var1 + 1][var2] |= 585;
                           class62.field721[var0][var1][var2] |= 1170;
                        } else if(var4 == 3) {
                           class62.field721[var0][var1][var2] |= 1170;
                           class62.field721[var0][var1][var2] |= 585;
                        }
                     }

                     if(var8.clipType != 0 && var7 != null) {
                        var7.method3385(var1, var2, var5, var4, var8.blocksProjectile);
                     }

                     if(var8.decorDisplacement != 16) {
                        var6.method2892(var0, var1, var2, var8.decorDisplacement);
                     }

                  } else if(var5 == 3) {
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var21 = var8.getModel(3, var4, var15, var17, var16, var18);
                     } else {
                        var21 = new DynamicObject(var3, 3, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.addBoundary(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, class62.field731[var4], 0, var19, var20);
                     if(var8.clipped) {
                        if(var4 == 0) {
                           class62.field725[var0][var1][var2 + 1] = 50;
                        } else if(var4 == 1) {
                           class62.field725[var0][var1 + 1][var2 + 1] = 50;
                        } else if(var4 == 2) {
                           class62.field725[var0][var1 + 1][var2] = 50;
                        } else if(var4 == 3) {
                           class62.field725[var0][var1][var2] = 50;
                        }
                     }

                     if(var8.clipType != 0 && var7 != null) {
                        var7.method3385(var1, var2, var5, var4, var8.blocksProjectile);
                     }

                  } else if(var5 == 9) {
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var21 = var8.getModel(var5, var4, var15, var17, var16, var18);
                     } else {
                        var21 = new DynamicObject(var3, var5, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.method2896(var0, var1, var2, var16, 1, 1, (Renderable)var21, 0, var19, var20);
                     if(var8.clipType != 0 && var7 != null) {
                        var7.addObject(var1, var2, var9, var10, var8.blocksProjectile);
                     }

                     if(var8.decorDisplacement != 16) {
                        var6.method2892(var0, var1, var2, var8.decorDisplacement);
                     }

                  } else if(var5 == 4) {
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var21 = var8.getModel(4, var4, var15, var17, var16, var18);
                     } else {
                        var21 = new DynamicObject(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, class62.field727[var4], 0, 0, 0, var19, var20);
                  } else if(var5 == 5) {
                     var26 = 16;
                     var22 = var6.getWallObjectHash(var0, var1, var2);
                     if(var22 != 0) {
                        var26 = FileRequest.getObjectDefinition(var22 >> 14 & 32767).decorDisplacement;
                     }

                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var28 = var8.getModel(4, var4, var15, var17, var16, var18);
                     } else {
                        var28 = new DynamicObject(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var28, (Renderable)null, class62.field727[var4], 0, var26 * class62.field730[var4], var26 * class62.field726[var4], var19, var20);
                  } else if(var5 == 6) {
                     var26 = 8;
                     var22 = var6.getWallObjectHash(var0, var1, var2);
                     if(var22 != 0) {
                        var26 = FileRequest.getObjectDefinition(var22 >> 14 & 32767).decorDisplacement / 2;
                     }

                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var28 = var8.getModel(4, var4 + 4, var15, var17, var16, var18);
                     } else {
                        var28 = new DynamicObject(var3, 4, var4 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var28, (Renderable)null, 256, var4, var26 * class62.field723[var4], var26 * class62.field732[var4], var19, var20);
                  } else if(var5 == 7) {
                     var22 = var4 + 2 & 3;
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var21 = var8.getModel(4, var22 + 4, var15, var17, var16, var18);
                     } else {
                        var21 = new DynamicObject(var3, 4, var22 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, 256, var22, 0, 0, var19, var20);
                  } else if(var5 == 8) {
                     var26 = 8;
                     var22 = var6.getWallObjectHash(var0, var1, var2);
                     if(var22 != 0) {
                        var26 = FileRequest.getObjectDefinition(var22 >> 14 & 32767).decorDisplacement / 2;
                     }

                     int var25 = var4 + 2 & 3;
                     Object var29;
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var28 = var8.getModel(4, var4 + 4, var15, var17, var16, var18);
                        var29 = var8.getModel(4, var25 + 4, var15, var17, var16, var18);
                     } else {
                        var28 = new DynamicObject(var3, 4, var4 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                        var29 = new DynamicObject(var3, 4, var25 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var28, (Renderable)var29, 256, var4, var26 * class62.field723[var4], var26 * class62.field732[var4], var19, var20);
                  }
               }
            } else {
               if(var8.animationId == -1 && var8.impostorIds == null) {
                  var21 = var8.getModel(10, var4, var15, var17, var16, var18);
               } else {
                  var21 = new DynamicObject(var3, 10, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               if(var21 != null && var6.method2896(var0, var1, var2, var16, var9, var10, (Renderable)var21, var5 == 11?256:0, var19, var20) && var8.clipped) {
                  var22 = 15;
                  if(var21 instanceof Model) {
                     var22 = ((Model)var21).method2689() / 4;
                     if(var22 > 30) {
                        var22 = 30;
                     }
                  }

                  for(int var23 = 0; var23 <= var9; ++var23) {
                     for(int var24 = 0; var24 <= var10; ++var24) {
                        if(var22 > class62.field725[var0][var23 + var1][var24 + var2]) {
                           class62.field725[var0][var23 + var1][var24 + var2] = (byte)var22;
                        }
                     }
                  }
               }

               if(var8.clipType != 0 && var7 != null) {
                  var7.addObject(var1, var2, var9, var10, var8.blocksProjectile);
               }

            }
         }
      }
   }
}
