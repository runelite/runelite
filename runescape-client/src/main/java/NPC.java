import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cl")
@Implements("NPC")
public final class NPC extends Actor {
   @ObfuscatedName("i")
   @Export("composition")
   NPCComposition composition;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IBI)V",
      garbageValue = "-512325069"
   )
   final void method1711(int var1, byte var2) {
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

      if(super.animation != -1 && class165.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      if(super.field1252 < 9) {
         ++super.field1252;
      }

      for(int var5 = super.field1252; var5 > 0; --var5) {
         super.pathX[var5] = super.pathX[var5 - 1];
         super.pathY[var5] = super.pathY[var5 - 1];
         super.field1255[var5] = super.field1255[var5 - 1];
      }

      super.pathX[0] = var3;
      super.pathY[0] = var4;
      super.field1255[0] = var2;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIZI)V",
      garbageValue = "-1411607682"
   )
   final void method1712(int var1, int var2, boolean var3) {
      if(super.animation != -1 && class165.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      if(!var3) {
         int var4 = var1 - super.pathX[0];
         int var5 = var2 - super.pathY[0];
         if(var4 >= -8 && var4 <= 8 && var5 >= -8 && var5 <= 8) {
            if(super.field1252 < 9) {
               ++super.field1252;
            }

            for(int var6 = super.field1252; var6 > 0; --var6) {
               super.pathX[var6] = super.pathX[var6 - 1];
               super.pathY[var6] = super.pathY[var6 - 1];
               super.field1255[var6] = super.field1255[var6 - 1];
            }

            super.pathX[0] = var1;
            super.pathY[0] = var2;
            super.field1255[0] = 1;
            return;
         }
      }

      super.field1252 = 0;
      super.field1236 = 0;
      super.field1257 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.x = super.pathX[0] * 128 + super.field1202 * 64;
      super.y = super.pathY[0] * 128 + super.field1202 * 64;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "-1208682604"
   )
   protected final Model getModel() {
      if(this.composition == null) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?class165.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation != -1 && (super.idlePoseAnimation != super.poseAnimation || var1 == null)?class165.getAnimation(super.poseAnimation):null;
         Model var3 = this.composition.method4703(var1, super.actionFrame, var2, super.poseFrame);
         if(var3 == null) {
            return null;
         } else {
            var3.method2575();
            super.field1248 = var3.modelHeight;
            if(super.graphic != -1 && super.field1228 != -1) {
               Model var4 = class203.method3752(super.graphic).method4407(super.field1228);
               if(var4 != null) {
                  var4.method2565(0, -super.field1239, 0);
                  Model[] var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(this.composition.field3548 == 1) {
               var3.field1908 = true;
            }

            return var3;
         }
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-740818925"
   )
   final boolean vmethod1721() {
      return this.composition != null;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1012159919"
   )
   static void method1726() {
      class96.field1489 = 0;

      for(int var0 = 0; var0 < 2048; ++var0) {
         class96.field1486[var0] = null;
         class96.field1485[var0] = 1;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(JLjava/lang/String;I)I",
      garbageValue = "-1614937987"
   )
   static final int method1729(long var0, String var2) {
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

      var4.method3353(class87.field1358, class87.field1367);
      var5.putByte(10);

      for(var7 = 0; var7 < 3; ++var7) {
         var5.putInt(var3.nextInt());
      }

      var5.putLong(var3.nextLong());
      var5.method3219(var3.nextLong());
      if(Client.field967 != null) {
         var5.putBytes(Client.field967, 0, Client.field967.length);
      } else {
         byte[] var19 = class134.method2618();
         var5.putBytes(var19, 0, var19.length);
      }

      var5.putLong(var3.nextLong());
      var5.method3353(class87.field1358, class87.field1367);
      var7 = class46.method711(var2);
      if(var7 % 8 != 0) {
         var7 += 8 - var7 % 8;
      }

      Buffer var8 = new Buffer(var7);
      var8.method3191(var2);
      var8.offset = var7;
      var8.encryptXtea2(var6);
      Buffer var9 = new Buffer(var4.offset + 5 + var5.offset + var8.offset);
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
         var14.append(class269.field3679[var16 >>> 2]);
         if(var15 < var13 - 1) {
            var17 = var11[var15 + 1] & 255;
            var14.append(class269.field3679[(var16 & 3) << 4 | var17 >>> 4]);
            if(var15 < var13 - 2) {
               int var18 = var11[var15 + 2] & 255;
               var14.append(class269.field3679[(var17 & 15) << 2 | var18 >>> 6]).append(class269.field3679[var18 & 63]);
            } else {
               var14.append(class269.field3679[(var17 & 15) << 2]).append("=");
            }
         } else {
            var14.append(class269.field3679[(var16 & 3) << 4]).append("==");
         }
      }

      String var12 = var14.toString();
      var12 = var12;

      try {
         URL var20 = new URL(WorldMapType3.method179("services", false) + "m=accountappeal/login.ws");
         URLConnection var25 = var20.openConnection();
         var25.setDoInput(true);
         var25.setDoOutput(true);
         var25.setConnectTimeout(5000);
         OutputStreamWriter var21 = new OutputStreamWriter(var25.getOutputStream());
         var21.write("data2=" + ISAACCipher.method3485(var12) + "&dest=" + ISAACCipher.method3485("passwordchoice.ws"));
         var21.flush();
         InputStream var22 = var25.getInputStream();
         var9 = new Buffer(new byte[1000]);

         do {
            var17 = var22.read(var9.payload, var9.offset, 1000 - var9.offset);
            if(var17 == -1) {
               var21.close();
               var22.close();
               String var23 = new String(var9.payload);
               if(var23.startsWith("OFFLINE")) {
                  return 4;
               } else if(var23.startsWith("WRONG")) {
                  return 7;
               } else if(var23.startsWith("RELOAD")) {
                  return 3;
               } else if(var23.startsWith("Not permitted for social network accounts.")) {
                  return 6;
               } else {
                  var9.decryptXtea(var6);

                  while(var9.offset > 0 && var9.payload[var9.offset - 1] == 0) {
                     --var9.offset;
                  }

                  var23 = new String(var9.payload, 0, var9.offset);
                  if(class236.method4287(var23)) {
                     class11.method47(var23, true, false);
                     return 2;
                  } else {
                     return 5;
                  }
               }
            }

            var9.offset += var17;
         } while(var9.offset < 1000);

         return 5;
      } catch (Throwable var24) {
         var24.printStackTrace();
         return 5;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "4"
   )
   public static int method1730(int var0) {
      return var0 >> 17 & 7;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "1506863492"
   )
   static int method1732(int var0, Script var1, boolean var2) {
      String var3;
      int var4;
      if(var0 == 4100) {
         var3 = class83.scriptStringStack[--ChatMessages.scriptStringStackSize];
         var4 = class83.intStack[--class83.intStackSize];
         class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = var3 + var4;
         return 1;
      } else {
         String var37;
         if(var0 == 4101) {
            ChatMessages.scriptStringStackSize -= 2;
            var3 = class83.scriptStringStack[ChatMessages.scriptStringStackSize];
            var37 = class83.scriptStringStack[ChatMessages.scriptStringStackSize + 1];
            class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = var3 + var37;
            return 1;
         } else {
            int var40;
            if(var0 == 4102) {
               var3 = class83.scriptStringStack[--ChatMessages.scriptStringStackSize];
               var4 = class83.intStack[--class83.intStackSize];
               String[] var5 = class83.scriptStringStack;
               var40 = ++ChatMessages.scriptStringStackSize - 1;
               String var8;
               if(var4 < 0) {
                  var8 = Integer.toString(var4);
               } else {
                  var8 = class37.method511(var4, 10, true);
               }

               var5[var40] = var3 + var8;
               return 1;
            } else if(var0 == 4103) {
               var3 = class83.scriptStringStack[--ChatMessages.scriptStringStackSize];
               class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = var3.toLowerCase();
               return 1;
            } else {
               int var23;
               int var26;
               if(var0 == 4104) {
                  var23 = class83.intStack[--class83.intStackSize];
                  long var24 = 86400000L * ((long)var23 + 11745L);
                  class83.field1320.setTime(new Date(var24));
                  var40 = class83.field1320.get(5);
                  int var39 = class83.field1320.get(2);
                  var26 = class83.field1320.get(1);
                  class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = var40 + "-" + class83.field1310[var39] + "-" + var26;
                  return 1;
               } else if(var0 == 4105) {
                  ChatMessages.scriptStringStackSize -= 2;
                  var3 = class83.scriptStringStack[ChatMessages.scriptStringStackSize];
                  var37 = class83.scriptStringStack[ChatMessages.scriptStringStackSize + 1];
                  if(XGrandExchangeOffer.localPlayer.composition != null && XGrandExchangeOffer.localPlayer.composition.isFemale) {
                     class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = var37;
                  } else {
                     class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = var3;
                  }

                  return 1;
               } else if(var0 == 4106) {
                  var23 = class83.intStack[--class83.intStackSize];
                  class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = Integer.toString(var23);
                  return 1;
               } else {
                  int var27;
                  if(var0 == 4107) {
                     ChatMessages.scriptStringStackSize -= 2;
                     int[] var28 = class83.intStack;
                     var4 = ++class83.intStackSize - 1;
                     String var29 = class83.scriptStringStack[ChatMessages.scriptStringStackSize];
                     String var30 = class83.scriptStringStack[ChatMessages.scriptStringStackSize + 1];
                     var26 = Client.field896;
                     int var9 = var29.length();
                     int var10 = var30.length();
                     int var11 = 0;
                     int var12 = 0;
                     byte var13 = 0;
                     char var14 = 0;

                     label374:
                     while(true) {
                        if(var11 - var13 >= var9 && var12 - var14 >= var10) {
                           int var33 = Math.min(var9, var10);

                           char var18;
                           int var34;
                           for(var34 = 0; var34 < var33; ++var34) {
                              char var35 = var29.charAt(var34);
                              var18 = var30.charAt(var34);
                              if(var18 != var35 && Character.toUpperCase(var35) != Character.toUpperCase(var18)) {
                                 var35 = Character.toLowerCase(var35);
                                 var18 = Character.toLowerCase(var18);
                                 if(var35 != var18) {
                                    var27 = class45.method660(var35, var26) - class45.method660(var18, var26);
                                    break label374;
                                 }
                              }
                           }

                           var34 = var9 - var10;
                           if(var34 != 0) {
                              var27 = var34;
                           } else {
                              for(int var36 = 0; var36 < var33; ++var36) {
                                 var18 = var29.charAt(var36);
                                 char var19 = var30.charAt(var36);
                                 if(var19 != var18) {
                                    var27 = class45.method660(var18, var26) - class45.method660(var19, var26);
                                    break label374;
                                 }
                              }

                              var27 = 0;
                           }
                           break;
                        }

                        if(var11 - var13 >= var9) {
                           var27 = -1;
                           break;
                        }

                        if(var12 - var14 >= var10) {
                           var27 = 1;
                           break;
                        }

                        char var15;
                        if(var13 != 0) {
                           var15 = (char)var13;
                           boolean var31 = false;
                        } else {
                           var15 = var29.charAt(var11++);
                        }

                        char var16;
                        if(var14 != 0) {
                           var16 = var14;
                           boolean var32 = false;
                        } else {
                           var16 = var30.charAt(var12++);
                        }

                        byte var17;
                        if(var15 == 198) {
                           var17 = 69;
                        } else if(var15 == 230) {
                           var17 = 101;
                        } else if(var15 == 223) {
                           var17 = 115;
                        } else if(var15 == 338) {
                           var17 = 69;
                        } else if(var15 == 339) {
                           var17 = 101;
                        } else {
                           var17 = 0;
                        }

                        var13 = var17;
                        var14 = class154.method2984(var16);
                        var15 = class83.method1686(var15, var26);
                        var16 = class83.method1686(var16, var26);
                        if(var16 != var15 && Character.toUpperCase(var15) != Character.toUpperCase(var16)) {
                           var15 = Character.toLowerCase(var15);
                           var16 = Character.toLowerCase(var16);
                           if(var15 != var16) {
                              var27 = class45.method660(var15, var26) - class45.method660(var16, var26);
                              break;
                           }
                        }
                     }

                     var28[var4] = class82.method1615(var27);
                     return 1;
                  } else {
                     byte[] var6;
                     Font var7;
                     if(var0 == 4108) {
                        var3 = class83.scriptStringStack[--ChatMessages.scriptStringStackSize];
                        class83.intStackSize -= 2;
                        var4 = class83.intStack[class83.intStackSize];
                        var27 = class83.intStack[class83.intStackSize + 1];
                        var6 = class91.field1411.getConfigData(var27, 0);
                        var7 = new Font(var6);
                        class83.intStack[++class83.intStackSize - 1] = var7.method4841(var3, var4);
                        return 1;
                     } else if(var0 == 4109) {
                        var3 = class83.scriptStringStack[--ChatMessages.scriptStringStackSize];
                        class83.intStackSize -= 2;
                        var4 = class83.intStack[class83.intStackSize];
                        var27 = class83.intStack[class83.intStackSize + 1];
                        var6 = class91.field1411.getConfigData(var27, 0);
                        var7 = new Font(var6);
                        class83.intStack[++class83.intStackSize - 1] = var7.method4811(var3, var4);
                        return 1;
                     } else if(var0 == 4110) {
                        ChatMessages.scriptStringStackSize -= 2;
                        var3 = class83.scriptStringStack[ChatMessages.scriptStringStackSize];
                        var37 = class83.scriptStringStack[ChatMessages.scriptStringStackSize + 1];
                        if(class83.intStack[--class83.intStackSize] == 1) {
                           class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = var3;
                        } else {
                           class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = var37;
                        }

                        return 1;
                     } else if(var0 == 4111) {
                        var3 = class83.scriptStringStack[--ChatMessages.scriptStringStackSize];
                        class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = FontTypeFace.method4813(var3);
                        return 1;
                     } else if(var0 == 4112) {
                        var3 = class83.scriptStringStack[--ChatMessages.scriptStringStackSize];
                        var4 = class83.intStack[--class83.intStackSize];
                        class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = var3 + (char)var4;
                        return 1;
                     } else {
                        char var21;
                        if(var0 != 4113) {
                           if(var0 == 4114) {
                              var23 = class83.intStack[--class83.intStackSize];
                              class83.intStack[++class83.intStackSize - 1] = class47.method713((char)var23)?1:0;
                              return 1;
                           } else if(var0 == 4115) {
                              var23 = class83.intStack[--class83.intStackSize];
                              class83.intStack[++class83.intStackSize - 1] = ChatLineBuffer.method1905((char)var23)?1:0;
                              return 1;
                           } else if(var0 == 4116) {
                              var23 = class83.intStack[--class83.intStackSize];
                              class83.intStack[++class83.intStackSize - 1] = class233.method4170((char)var23)?1:0;
                              return 1;
                           } else if(var0 == 4117) {
                              var3 = class83.scriptStringStack[--ChatMessages.scriptStringStackSize];
                              if(var3 != null) {
                                 class83.intStack[++class83.intStackSize - 1] = var3.length();
                              } else {
                                 class83.intStack[++class83.intStackSize - 1] = 0;
                              }

                              return 1;
                           } else if(var0 == 4118) {
                              var3 = class83.scriptStringStack[--ChatMessages.scriptStringStackSize];
                              class83.intStackSize -= 2;
                              var4 = class83.intStack[class83.intStackSize];
                              var27 = class83.intStack[class83.intStackSize + 1];
                              class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = var3.substring(var4, var27);
                              return 1;
                           } else if(var0 == 4119) {
                              var3 = class83.scriptStringStack[--ChatMessages.scriptStringStackSize];
                              StringBuilder var38 = new StringBuilder(var3.length());
                              boolean var41 = false;

                              for(var40 = 0; var40 < var3.length(); ++var40) {
                                 var21 = var3.charAt(var40);
                                 if(var21 == 60) {
                                    var41 = true;
                                 } else if(var21 == 62) {
                                    var41 = false;
                                 } else if(!var41) {
                                    var38.append(var21);
                                 }
                              }

                              class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = var38.toString();
                              return 1;
                           } else if(var0 == 4120) {
                              var3 = class83.scriptStringStack[--ChatMessages.scriptStringStackSize];
                              var4 = class83.intStack[--class83.intStackSize];
                              class83.intStack[++class83.intStackSize - 1] = var3.indexOf(var4);
                              return 1;
                           } else if(var0 == 4121) {
                              ChatMessages.scriptStringStackSize -= 2;
                              var3 = class83.scriptStringStack[ChatMessages.scriptStringStackSize];
                              var37 = class83.scriptStringStack[ChatMessages.scriptStringStackSize + 1];
                              var27 = class83.intStack[--class83.intStackSize];
                              class83.intStack[++class83.intStackSize - 1] = var3.indexOf(var37, var27);
                              return 1;
                           } else {
                              return 2;
                           }
                        } else {
                           var23 = class83.intStack[--class83.intStackSize];
                           int[] var20 = class83.intStack;
                           var27 = ++class83.intStackSize - 1;
                           var21 = (char)var23;
                           boolean var22;
                           if(var21 >= 32 && var21 <= 126) {
                              var22 = true;
                           } else if(var21 >= 160 && var21 <= 255) {
                              var22 = true;
                           } else if(var21 != 8364 && var21 != 338 && var21 != 8212 && var21 != 339 && var21 != 376) {
                              var22 = false;
                           } else {
                              var22 = true;
                           }

                           var20[var27] = var22?1:0;
                           return 1;
                        }
                     }
                  }
               }
            }
         }
      }
   }
}
