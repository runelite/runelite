import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jl")
@Implements("FontName")
public class FontName {
   @ObfuscatedName("pz")
   @ObfuscatedGetter(
      intValue = 1371443495
   )
   static int field3698;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Ljl;"
   )
   @Export("FontName_plain11")
   public static final FontName FontName_plain11;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Ljl;"
   )
   @Export("FontName_plain12")
   public static final FontName FontName_plain12;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Ljl;"
   )
   @Export("FontName_bold12")
   public static final FontName FontName_bold12;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Ljl;"
   )
   public static final FontName field3688;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Ljl;"
   )
   public static final FontName field3697;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Ljl;"
   )
   public static final FontName field3692;
   @ObfuscatedName("dh")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   @Export("indexCache15")
   static IndexData indexCache15;
   @ObfuscatedName("t")
   final String field3694;
   @ObfuscatedName("f")
   String field3695;

   static {
      FontName_plain11 = new FontName("PLAIN11", "p11_full");
      FontName_plain12 = new FontName("PLAIN12", "p12_full");
      FontName_bold12 = new FontName("BOLD12", "b12_full");
      field3688 = new FontName("VERDANA11", "verdana_11pt_regular");
      field3697 = new FontName("VERDANA13", "verdana_13pt_regular");
      field3692 = new FontName("VERDANA15", "verdana_15pt_regular");
   }

   FontName(String var1, String var2) {
      this.field3694 = var1;
      this.field3695 = var2;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)[Ljl;",
      garbageValue = "8"
   )
   public static FontName[] method4869() {
      return new FontName[]{FontName_bold12, FontName_plain12, field3697, field3688, FontName_plain11, field3692};
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(JLjava/lang/String;B)I",
      garbageValue = "0"
   )
   static final int method4872(long var0, String var2) {
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

      var4.encryptRsa(class86.field1275, class86.field1274);
      var5.putByte(10);

      for(var7 = 0; var7 < 3; ++var7) {
         var5.putInt(var3.nextInt());
      }

      var5.putLong(var3.nextLong());
      var5.method3249(var3.nextLong());
      if(Client.field1034 != null) {
         var5.putBytes(Client.field1034, 0, Client.field1034.length);
      } else {
         byte[] var8 = new byte[24];

         try {
            class157.randomDat.seek(0L);
            class157.randomDat.read(var8);

            int var9;
            for(var9 = 0; var9 < 24 && var8[var9] == 0; ++var9) {
               ;
            }

            if(var9 >= 24) {
               throw new IOException();
            }
         } catch (Exception var27) {
            for(int var10 = 0; var10 < 24; ++var10) {
               var8[var10] = -1;
            }
         }

         var5.putBytes(var8, 0, var8.length);
      }

      var5.putLong(var3.nextLong());
      var5.encryptRsa(class86.field1275, class86.field1274);
      var7 = Ignore.getLength(var2);
      if(var7 % 8 != 0) {
         var7 += 8 - var7 % 8;
      }

      Buffer var28 = new Buffer(var7);
      var28.putString(var2);
      var28.offset = var7;
      var28.encryptXtea2(var6);
      Buffer var20 = new Buffer(var28.offset + var5.offset + var4.offset + 5);
      var20.putByte(2);
      var20.putByte(var4.offset);
      var20.putBytes(var4.payload, 0, var4.offset);
      var20.putByte(var5.offset);
      var20.putBytes(var5.payload, 0, var5.offset);
      var20.putShort(var28.offset);
      var20.putBytes(var28.payload, 0, var28.offset);
      byte[] var11 = var20.payload;
      String var22 = BoundingBox3D.method51(var11, 0, var11.length);
      String var12 = var22;

      try {
         URL var13 = new URL(SceneComposition.method167("services", false) + "m=accountappeal/login.ws");
         URLConnection var14 = var13.openConnection();
         var14.setDoInput(true);
         var14.setDoOutput(true);
         var14.setConnectTimeout(5000);
         OutputStreamWriter var15 = new OutputStreamWriter(var14.getOutputStream());
         var15.write("data2=" + GrandExchangeEvent.method84(var12) + "&dest=" + GrandExchangeEvent.method84("passwordchoice.ws"));
         var15.flush();
         InputStream var16 = var14.getInputStream();
         var20 = new Buffer(new byte[1000]);

         do {
            int var17 = var16.read(var20.payload, var20.offset, 1000 - var20.offset);
            if(var17 == -1) {
               var15.close();
               var16.close();
               String var23 = new String(var20.payload);
               if(var23.startsWith("OFFLINE")) {
                  return 4;
               } else if(var23.startsWith("WRONG")) {
                  return 7;
               } else if(var23.startsWith("RELOAD")) {
                  return 3;
               } else if(var23.startsWith("Not permitted for social network accounts.")) {
                  return 6;
               } else {
                  var20.decryptXtea(var6);

                  while(var20.offset > 0 && var20.payload[var20.offset - 1] == 0) {
                     --var20.offset;
                  }

                  var23 = new String(var20.payload, 0, var20.offset);
                  boolean var18;
                  if(var23 == null) {
                     var18 = false;
                  } else {
                     label130: {
                        try {
                           new URL(var23);
                        } catch (MalformedURLException var25) {
                           var18 = false;
                           break label130;
                        }

                        var18 = true;
                     }
                  }

                  if(!var18) {
                     return 5;
                  } else {
                     if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
                        try {
                           Desktop.getDesktop().browse(new URI(var23));
                           return 2;
                        } catch (Exception var24) {
                           ;
                        }
                     }

                     if(class56.field621.startsWith("win")) {
                        class54.method766(var23, 0);
                     } else if(class56.field621.startsWith("mac")) {
                        class35.method492(var23, 1, "openjs");
                     } else {
                        class54.method766(var23, 2);
                     }

                     return 2;
                  }
               }
            }

            var20.offset += var17;
         } while(var20.offset < 1000);

         return 5;
      } catch (Throwable var26) {
         var26.printStackTrace();
         return 5;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "([Lcp;II[I[IB)V",
      garbageValue = "11"
   )
   static void method4874(World[] var0, int var1, int var2, int[] var3, int[] var4) {
      if(var1 < var2) {
         int var5 = var1 - 1;
         int var6 = var2 + 1;
         int var7 = (var2 + var1) / 2;
         World var8 = var0[var7];
         var0[var7] = var0[var1];
         var0[var1] = var8;

         while(var5 < var6) {
            boolean var9 = true;

            int var10;
            int var11;
            int var12;
            do {
               --var6;

               for(var10 = 0; var10 < 4; ++var10) {
                  if(var3[var10] == 2) {
                     var11 = var0[var6].index;
                     var12 = var8.index;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var6].playerCount;
                     var12 = var8.playerCount;
                     if(var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var10] == 3) {
                     var11 = var0[var6].method1518()?1:0;
                     var12 = var8.method1518()?1:0;
                  } else {
                     var11 = var0[var6].id;
                     var12 = var8.id;
                  }

                  if(var11 != var12) {
                     if((var4[var10] != 1 || var11 <= var12) && (var4[var10] != 0 || var11 >= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(var10 == 3) {
                     var9 = false;
                  }
               }
            } while(var9);

            var9 = true;

            do {
               ++var5;

               for(var10 = 0; var10 < 4; ++var10) {
                  if(var3[var10] == 2) {
                     var11 = var0[var5].index;
                     var12 = var8.index;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var5].playerCount;
                     var12 = var8.playerCount;
                     if(var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var10] == 3) {
                     var11 = var0[var5].method1518()?1:0;
                     var12 = var8.method1518()?1:0;
                  } else {
                     var11 = var0[var5].id;
                     var12 = var8.id;
                  }

                  if(var12 != var11) {
                     if((var4[var10] != 1 || var11 >= var12) && (var4[var10] != 0 || var11 <= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(var10 == 3) {
                     var9 = false;
                  }
               }
            } while(var9);

            if(var5 < var6) {
               World var13 = var0[var5];
               var0[var5] = var0[var6];
               var0[var6] = var13;
            }
         }

         method4874(var0, var1, var6, var3, var4);
         method4874(var0, var6 + 1, var2, var3, var4);
      }

   }

   @ObfuscatedName("gw")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "-1427753178"
   )
   static final void method4871(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(var2 >= 1 && var3 >= 1 && var2 <= 102 && var3 <= 102) {
         if(Client.lowMemory && var0 != BoundingBox2D.plane) {
            return;
         }

         int var7 = 0;
         boolean var8 = true;
         boolean var9 = false;
         boolean var10 = false;
         if(var1 == 0) {
            var7 = class48.region.method2716(var0, var2, var3);
         }

         if(var1 == 1) {
            var7 = class48.region.method2717(var0, var2, var3);
         }

         if(var1 == 2) {
            var7 = class48.region.method2718(var0, var2, var3);
         }

         if(var1 == 3) {
            var7 = class48.region.method2840(var0, var2, var3);
         }

         int var11;
         if(var7 != 0) {
            var11 = class48.region.getObjectFlags(var0, var2, var3, var7);
            int var34 = var7 >> 14 & 32767;
            int var35 = var11 & 31;
            int var36 = var11 >> 6 & 3;
            ObjectComposition var12;
            if(var1 == 0) {
               class48.region.removeBoundaryObject(var0, var2, var3);
               var12 = CacheFile.getObjectDefinition(var34);
               if(var12.interactType != 0) {
                  Client.collisionMaps[var0].removeWall(var2, var3, var35, var36, var12.boolean1);
               }
            }

            if(var1 == 1) {
               class48.region.removeWallDecoration(var0, var2, var3);
            }

            if(var1 == 2) {
               class48.region.method2709(var0, var2, var3);
               var12 = CacheFile.getObjectDefinition(var34);
               if(var2 + var12.sizeX > 103 || var3 + var12.sizeX > 103 || var2 + var12.sizeY > 103 || var3 + var12.sizeY > 103) {
                  return;
               }

               if(var12.interactType != 0) {
                  Client.collisionMaps[var0].removeObject(var2, var3, var12.sizeX, var12.sizeY, var36, var12.boolean1);
               }
            }

            if(var1 == 3) {
               class48.region.removeFloorDecoration(var0, var2, var3);
               var12 = CacheFile.getObjectDefinition(var34);
               if(var12.interactType == 1) {
                  Client.collisionMaps[var0].method3138(var2, var3);
               }
            }
         }

         if(var4 >= 0) {
            var11 = var0;
            if(var0 < 3 && (class61.tileSettings[1][var2][var3] & 2) == 2) {
               var11 = var0 + 1;
            }

            Region var37 = class48.region;
            CollisionData var13 = Client.collisionMaps[var0];
            ObjectComposition var14 = CacheFile.getObjectDefinition(var4);
            int var15;
            int var16;
            if(var5 != 1 && var5 != 3) {
               var15 = var14.sizeX;
               var16 = var14.sizeY;
            } else {
               var15 = var14.sizeY;
               var16 = var14.sizeX;
            }

            int var17;
            int var18;
            if(var15 + var2 <= 104) {
               var17 = (var15 >> 1) + var2;
               var18 = var2 + (var15 + 1 >> 1);
            } else {
               var17 = var2;
               var18 = var2 + 1;
            }

            int var19;
            int var20;
            if(var3 + var16 <= 104) {
               var19 = var3 + (var16 >> 1);
               var20 = var3 + (var16 + 1 >> 1);
            } else {
               var19 = var3;
               var20 = var3 + 1;
            }

            int[][] var21 = class61.tileHeights[var11];
            int var22 = var21[var18][var20] + var21[var17][var20] + var21[var18][var19] + var21[var17][var19] >> 2;
            int var23 = (var2 << 7) + (var15 << 6);
            int var24 = (var3 << 7) + (var16 << 6);
            int var25 = (var3 << 7) + var2 + (var4 << 14) + 1073741824;
            if(var14.int1 == 0) {
               var25 -= Integer.MIN_VALUE;
            }

            int var26 = (var5 << 6) + var6;
            if(var14.int3 == 1) {
               var26 += 256;
            }

            Object var27;
            if(var6 == 22) {
               if(var14.animationId == -1 && var14.impostorIds == null) {
                  var27 = var14.method4665(22, var5, var21, var23, var22, var24);
               } else {
                  var27 = new DynamicObject(var4, 22, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
               }

               var37.groundObjectSpawned(var0, var2, var3, var22, (Renderable)var27, var25, var26);
               if(var14.interactType == 1) {
                  var13.method3150(var2, var3);
               }
            } else if(var6 != 10 && var6 != 11) {
               if(var6 >= 12) {
                  if(var14.animationId == -1 && var14.impostorIds == null) {
                     var27 = var14.method4665(var6, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new DynamicObject(var4, var6, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                  }

                  var37.method2700(var0, var2, var3, var22, 1, 1, (Renderable)var27, 0, var25, var26);
                  if(var14.interactType != 0) {
                     var13.addObject(var2, var3, var15, var16, var14.boolean1);
                  }
               } else if(var6 == 0) {
                  if(var14.animationId == -1 && var14.impostorIds == null) {
                     var27 = var14.method4665(0, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new DynamicObject(var4, 0, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                  }

                  var37.addBoundary(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class61.field701[var5], 0, var25, var26);
                  if(var14.interactType != 0) {
                     var13.method3130(var2, var3, var6, var5, var14.boolean1);
                  }
               } else if(var6 == 1) {
                  if(var14.animationId == -1 && var14.impostorIds == null) {
                     var27 = var14.method4665(1, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new DynamicObject(var4, 1, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                  }

                  var37.addBoundary(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class61.field703[var5], 0, var25, var26);
                  if(var14.interactType != 0) {
                     var13.method3130(var2, var3, var6, var5, var14.boolean1);
                  }
               } else {
                  Object var29;
                  int var32;
                  if(var6 == 2) {
                     var32 = var5 + 1 & 3;
                     Object var28;
                     if(var14.animationId == -1 && var14.impostorIds == null) {
                        var28 = var14.method4665(2, var5 + 4, var21, var23, var22, var24);
                        var29 = var14.method4665(2, var32, var21, var23, var22, var24);
                     } else {
                        var28 = new DynamicObject(var4, 2, var5 + 4, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        var29 = new DynamicObject(var4, 2, var32, var11, var2, var3, var14.animationId, true, (Renderable)null);
                     }

                     var37.addBoundary(var0, var2, var3, var22, (Renderable)var28, (Renderable)var29, class61.field701[var5], class61.field701[var32], var25, var26);
                     if(var14.interactType != 0) {
                        var13.method3130(var2, var3, var6, var5, var14.boolean1);
                     }
                  } else if(var6 == 3) {
                     if(var14.animationId == -1 && var14.impostorIds == null) {
                        var27 = var14.method4665(3, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new DynamicObject(var4, 3, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                     }

                     var37.addBoundary(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class61.field703[var5], 0, var25, var26);
                     if(var14.interactType != 0) {
                        var13.method3130(var2, var3, var6, var5, var14.boolean1);
                     }
                  } else if(var6 == 9) {
                     if(var14.animationId == -1 && var14.impostorIds == null) {
                        var27 = var14.method4665(var6, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new DynamicObject(var4, var6, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                     }

                     var37.method2700(var0, var2, var3, var22, 1, 1, (Renderable)var27, 0, var25, var26);
                     if(var14.interactType != 0) {
                        var13.addObject(var2, var3, var15, var16, var14.boolean1);
                     }
                  } else if(var6 == 4) {
                     if(var14.animationId == -1 && var14.impostorIds == null) {
                        var27 = var14.method4665(4, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new DynamicObject(var4, 4, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                     }

                     var37.addBoundaryDecoration(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class61.field701[var5], 0, 0, 0, var25, var26);
                  } else {
                     int var33;
                     if(var6 == 5) {
                        var32 = 16;
                        var33 = var37.method2716(var0, var2, var3);
                        if(var33 != 0) {
                           var32 = CacheFile.getObjectDefinition(var33 >> 14 & 32767).int2;
                        }

                        if(var14.animationId == -1 && var14.impostorIds == null) {
                           var29 = var14.method4665(4, var5, var21, var23, var22, var24);
                        } else {
                           var29 = new DynamicObject(var4, 4, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        }

                        var37.addBoundaryDecoration(var0, var2, var3, var22, (Renderable)var29, (Renderable)null, class61.field701[var5], 0, var32 * class61.field704[var5], var32 * class61.field702[var5], var25, var26);
                     } else if(var6 == 6) {
                        var32 = 8;
                        var33 = var37.method2716(var0, var2, var3);
                        if(var33 != 0) {
                           var32 = CacheFile.getObjectDefinition(var33 >> 14 & 32767).int2 / 2;
                        }

                        if(var14.animationId == -1 && var14.impostorIds == null) {
                           var29 = var14.method4665(4, var5 + 4, var21, var23, var22, var24);
                        } else {
                           var29 = new DynamicObject(var4, 4, var5 + 4, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        }

                        var37.addBoundaryDecoration(var0, var2, var3, var22, (Renderable)var29, (Renderable)null, 256, var5, var32 * class61.field705[var5], var32 * class61.field706[var5], var25, var26);
                     } else if(var6 == 7) {
                        var33 = var5 + 2 & 3;
                        if(var14.animationId == -1 && var14.impostorIds == null) {
                           var27 = var14.method4665(4, var33 + 4, var21, var23, var22, var24);
                        } else {
                           var27 = new DynamicObject(var4, 4, var33 + 4, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        }

                        var37.addBoundaryDecoration(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, 256, var33, 0, 0, var25, var26);
                     } else if(var6 == 8) {
                        var32 = 8;
                        var33 = var37.method2716(var0, var2, var3);
                        if(var33 != 0) {
                           var32 = CacheFile.getObjectDefinition(var33 >> 14 & 32767).int2 / 2;
                        }

                        int var31 = var5 + 2 & 3;
                        Object var30;
                        if(var14.animationId == -1 && var14.impostorIds == null) {
                           var29 = var14.method4665(4, var5 + 4, var21, var23, var22, var24);
                           var30 = var14.method4665(4, var31 + 4, var21, var23, var22, var24);
                        } else {
                           var29 = new DynamicObject(var4, 4, var5 + 4, var11, var2, var3, var14.animationId, true, (Renderable)null);
                           var30 = new DynamicObject(var4, 4, var31 + 4, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        }

                        var37.addBoundaryDecoration(var0, var2, var3, var22, (Renderable)var29, (Renderable)var30, 256, var5, var32 * class61.field705[var5], var32 * class61.field706[var5], var25, var26);
                     }
                  }
               }
            } else {
               if(var14.animationId == -1 && var14.impostorIds == null) {
                  var27 = var14.method4665(10, var5, var21, var23, var22, var24);
               } else {
                  var27 = new DynamicObject(var4, 10, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
               }

               if(var27 != null) {
                  var37.method2700(var0, var2, var3, var22, var15, var16, (Renderable)var27, var6 == 11?256:0, var25, var26);
               }

               if(var14.interactType != 0) {
                  var13.addObject(var2, var3, var15, var16, var14.boolean1);
               }
            }
         }
      }

   }

   @ObfuscatedName("jr")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1262465520"
   )
   public static void method4873(int var0, int var1, int var2) {
      PacketNode var3 = FileSystem.bufferForSize(ClientPacket.field2369, Client.signlink.field1449);
      var3.packetBuffer.putShort(var0);
      var3.packetBuffer.method3286(var2);
      var3.packetBuffer.writeIntLE16(var1);
      Client.signlink.method1862(var3);
   }
}
