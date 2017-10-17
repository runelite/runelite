import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ak")
public class class51 implements class101 {
   @ObfuscatedName("es")
   @ObfuscatedSignature(
      signature = "Leh;"
   )
   static Task field671;
   @ObfuscatedName("dk")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   @Export("indexScripts")
   static IndexData indexScripts;
   @ObfuscatedName("qj")
   @ObfuscatedGetter(
      longValue = 1613509206782837681L
   )
   static long field675;
   @ObfuscatedName("pn")
   @ObfuscatedGetter(
      intValue = -1756131635
   )
   static int field672;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Ldk;",
      garbageValue = "265930202"
   )
   public AbstractSoundSystem vmethod1993() {
      return new SourceDataSoundSystem();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1078404089"
   )
   static void method789(int var0, int var1) {
      long var2 = (long)((var0 << 16) + var1);
      FileRequest var4 = (FileRequest)class238.field3259.get(var2);
      if(var4 != null) {
         class238.field3258.setHead(var4);
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lit;Lit;ZII)V",
      garbageValue = "-2004690505"
   )
   static void method792(IndexDataBase var0, IndexDataBase var1, boolean var2, int var3) {
      if(class90.field1409) {
         if(var3 == 4) {
            class90.loginIndex = 4;
         }

      } else {
         class90.loginIndex = var3;
         Rasterizer2D.reset();
         byte[] var4 = var0.method4305("title.jpg", "");
         class208.field2603 = Widget.method4157(var4);
         ScriptState.field791 = class208.field2603.method5222();
         if((Client.flags & 536870912) != 0) {
            class90.logoSprite = class70.getSprite(var1, "logo_deadman_mode", "");
         } else {
            class90.logoSprite = class70.getSprite(var1, "logo", "");
         }

         class90.field1411 = class70.getSprite(var1, "titlebox", "");
         class90.field1412 = class70.getSprite(var1, "titlebutton", "");
         class266.field3666 = Ignore.method1147(var1, "runes", "");
         class90.titlemuteSprite = Ignore.method1147(var1, "title_mute", "");
         TextureProvider.field1758 = class70.getSprite(var1, "options_radio_buttons,0", "");
         class29.field431 = class70.getSprite(var1, "options_radio_buttons,4", "");
         class90.field1415 = class70.getSprite(var1, "options_radio_buttons,2", "");
         class37.field527 = class70.getSprite(var1, "options_radio_buttons,6", "");
         CacheFile.field1750 = TextureProvider.field1758.originalWidth;
         Spotanim.field3336 = TextureProvider.field1758.height;
         WidgetNode.field837 = new int[256];

         int var5;
         for(var5 = 0; var5 < 64; ++var5) {
            WidgetNode.field837[var5] = var5 * 262144;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            WidgetNode.field837[var5 + 64] = var5 * 1024 + 16711680;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            WidgetNode.field837[var5 + 128] = var5 * 4 + 16776960;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            WidgetNode.field837[var5 + 192] = 16777215;
         }

         class5.field41 = new int[256];

         for(var5 = 0; var5 < 64; ++var5) {
            class5.field41[var5] = var5 * 1024;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            class5.field41[var5 + 64] = var5 * 4 + '\uff00';
         }

         for(var5 = 0; var5 < 64; ++var5) {
            class5.field41[var5 + 128] = var5 * 262144 + '\uffff';
         }

         for(var5 = 0; var5 < 64; ++var5) {
            class5.field41[var5 + 192] = 16777215;
         }

         class1.field10 = new int[256];

         for(var5 = 0; var5 < 64; ++var5) {
            class1.field10[var5] = var5 * 4;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            class1.field10[var5 + 64] = var5 * 262144 + 255;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            class1.field10[var5 + 128] = var5 * 1024 + 16711935;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            class1.field10[var5 + 192] = 16777215;
         }

         class41.field577 = new int[256];
         ScriptState.field792 = new int['耀'];
         Varbit.field3383 = new int['耀'];
         class227.method4199((IndexedSprite)null);
         ClanMember.field917 = new int['耀'];
         class224.field2854 = new int['耀'];
         if(var2) {
            class90.username = "";
            class90.password = "";
         }

         FrameMap.field2042 = 0;
         class90.field1437 = "";
         class90.field1438 = true;
         class90.worldSelectShown = false;
         if(!class23.preferences.muted) {
            class29.method235(2, class268.indexTrack1, "scape main", "", 255, false);
         } else {
            class138.method2927(2);
         }

         IndexDataBase.sendConInfo(false);
         class90.field1409 = true;
         class90.field1419 = (class60.canvasWidth - 765) / 2;
         class90.loginWindowX = class90.field1419 + 202;
         WorldMapType2.field539 = class90.loginWindowX + 180;
         class208.field2603.method5173(class90.field1419, 0);
         ScriptState.field791.method5173(class90.field1419 + 382, 0);
         class90.logoSprite.method5147(class90.field1419 + 382 - class90.logoSprite.originalWidth / 2, 18);
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(ILcv;ZI)I",
      garbageValue = "840307407"
   )
   static int method788(int var0, Script var1, boolean var2) {
      String var3;
      int var4;
      if(var0 == 4100) {
         var3 = class81.scriptStringStack[--class81.scriptStringStackSize];
         var4 = class81.intStack[--class81.intStackSize];
         class81.scriptStringStack[++class81.scriptStringStackSize - 1] = var3 + var4;
         return 1;
      } else {
         String var27;
         if(var0 == 4101) {
            class81.scriptStringStackSize -= 2;
            var3 = class81.scriptStringStack[class81.scriptStringStackSize];
            var27 = class81.scriptStringStack[class81.scriptStringStackSize + 1];
            class81.scriptStringStack[++class81.scriptStringStackSize - 1] = var3 + var27;
            return 1;
         } else {
            int var26;
            if(var0 == 4102) {
               var3 = class81.scriptStringStack[--class81.scriptStringStackSize];
               var4 = class81.intStack[--class81.intStackSize];
               String[] var5 = class81.scriptStringStack;
               var26 = ++class81.scriptStringStackSize - 1;
               String var8;
               if(var4 < 0) {
                  var8 = Integer.toString(var4);
               } else {
                  int var10 = var4;
                  String var9;
                  if(var4 < 0) {
                     var9 = Integer.toString(var4, 10);
                  } else {
                     int var11 = 2;

                     for(int var12 = var4 / 10; var12 != 0; ++var11) {
                        var12 /= 10;
                     }

                     char[] var13 = new char[var11];
                     var13[0] = 43;

                     for(int var14 = var11 - 1; var14 > 0; --var14) {
                        int var15 = var10;
                        var10 /= 10;
                        int var16 = var15 - var10 * 10;
                        if(var16 >= 10) {
                           var13[var14] = (char)(var16 + 87);
                        } else {
                           var13[var14] = (char)(var16 + 48);
                        }
                     }

                     var9 = new String(var13);
                  }

                  var8 = var9;
               }

               var5[var26] = var3 + var8;
               return 1;
            } else if(var0 == 4103) {
               var3 = class81.scriptStringStack[--class81.scriptStringStackSize];
               class81.scriptStringStack[++class81.scriptStringStackSize - 1] = var3.toLowerCase();
               return 1;
            } else {
               int var18;
               if(var0 == 4104) {
                  var18 = class81.intStack[--class81.intStackSize];
                  long var19 = ((long)var18 + 11745L) * 86400000L;
                  class81.field1329.setTime(new Date(var19));
                  var26 = class81.field1329.get(5);
                  int var29 = class81.field1329.get(2);
                  int var22 = class81.field1329.get(1);
                  class81.scriptStringStack[++class81.scriptStringStackSize - 1] = var26 + "-" + class81.field1343[var29] + "-" + var22;
                  return 1;
               } else if(var0 == 4105) {
                  class81.scriptStringStackSize -= 2;
                  var3 = class81.scriptStringStack[class81.scriptStringStackSize];
                  var27 = class81.scriptStringStack[class81.scriptStringStackSize + 1];
                  if(AbstractByteBuffer.localPlayer.composition != null && AbstractByteBuffer.localPlayer.composition.isFemale) {
                     class81.scriptStringStack[++class81.scriptStringStackSize - 1] = var27;
                  } else {
                     class81.scriptStringStack[++class81.scriptStringStackSize - 1] = var3;
                  }

                  return 1;
               } else if(var0 == 4106) {
                  var18 = class81.intStack[--class81.intStackSize];
                  class81.scriptStringStack[++class81.scriptStringStackSize - 1] = Integer.toString(var18);
                  return 1;
               } else if(var0 == 4107) {
                  class81.scriptStringStackSize -= 2;
                  int[] var25 = class81.intStack;
                  var4 = ++class81.intStackSize - 1;
                  var26 = class214.method4103(class81.scriptStringStack[class81.scriptStringStackSize], class81.scriptStringStack[class81.scriptStringStackSize + 1], Client.languageId);
                  byte var31;
                  if(var26 > 0) {
                     var31 = 1;
                  } else if(var26 < 0) {
                     var31 = -1;
                  } else {
                     var31 = 0;
                  }

                  var25[var4] = var31;
                  return 1;
               } else {
                  Font var7;
                  int var23;
                  byte[] var24;
                  if(var0 == 4108) {
                     var3 = class81.scriptStringStack[--class81.scriptStringStackSize];
                     class81.intStackSize -= 2;
                     var4 = class81.intStack[class81.intStackSize];
                     var23 = class81.intStack[class81.intStackSize + 1];
                     var24 = class31.field458.getConfigData(var23, 0);
                     var7 = new Font(var24);
                     class81.intStack[++class81.intStackSize - 1] = var7.method4838(var3, var4);
                     return 1;
                  } else if(var0 == 4109) {
                     var3 = class81.scriptStringStack[--class81.scriptStringStackSize];
                     class81.intStackSize -= 2;
                     var4 = class81.intStack[class81.intStackSize];
                     var23 = class81.intStack[class81.intStackSize + 1];
                     var24 = class31.field458.getConfigData(var23, 0);
                     var7 = new Font(var24);
                     class81.intStack[++class81.intStackSize - 1] = var7.method4878(var3, var4);
                     return 1;
                  } else if(var0 == 4110) {
                     class81.scriptStringStackSize -= 2;
                     var3 = class81.scriptStringStack[class81.scriptStringStackSize];
                     var27 = class81.scriptStringStack[class81.scriptStringStackSize + 1];
                     if(class81.intStack[--class81.intStackSize] == 1) {
                        class81.scriptStringStack[++class81.scriptStringStackSize - 1] = var3;
                     } else {
                        class81.scriptStringStack[++class81.scriptStringStackSize - 1] = var27;
                     }

                     return 1;
                  } else if(var0 == 4111) {
                     var3 = class81.scriptStringStack[--class81.scriptStringStackSize];
                     class81.scriptStringStack[++class81.scriptStringStackSize - 1] = FontTypeFace.appendTags(var3);
                     return 1;
                  } else if(var0 == 4112) {
                     var3 = class81.scriptStringStack[--class81.scriptStringStackSize];
                     var4 = class81.intStack[--class81.intStackSize];
                     class81.scriptStringStack[++class81.scriptStringStackSize - 1] = var3 + (char)var4;
                     return 1;
                  } else if(var0 == 4113) {
                     var18 = class81.intStack[--class81.intStackSize];
                     class81.intStack[++class81.intStackSize - 1] = Sequence.method4813((char)var18)?1:0;
                     return 1;
                  } else if(var0 == 4114) {
                     var18 = class81.intStack[--class81.intStackSize];
                     class81.intStack[++class81.intStackSize - 1] = Overlay.method4773((char)var18)?1:0;
                     return 1;
                  } else {
                     boolean var6;
                     int[] var17;
                     char var21;
                     if(var0 == 4115) {
                        var18 = class81.intStack[--class81.intStackSize];
                        var17 = class81.intStack;
                        var23 = ++class81.intStackSize - 1;
                        var21 = (char)var18;
                        var6 = var21 >= 65 && var21 <= 90 || var21 >= 97 && var21 <= 122;
                        var17[var23] = var6?1:0;
                        return 1;
                     } else if(var0 != 4116) {
                        if(var0 == 4117) {
                           var3 = class81.scriptStringStack[--class81.scriptStringStackSize];
                           if(var3 != null) {
                              class81.intStack[++class81.intStackSize - 1] = var3.length();
                           } else {
                              class81.intStack[++class81.intStackSize - 1] = 0;
                           }

                           return 1;
                        } else if(var0 == 4118) {
                           var3 = class81.scriptStringStack[--class81.scriptStringStackSize];
                           class81.intStackSize -= 2;
                           var4 = class81.intStack[class81.intStackSize];
                           var23 = class81.intStack[class81.intStackSize + 1];
                           class81.scriptStringStack[++class81.scriptStringStackSize - 1] = var3.substring(var4, var23);
                           return 1;
                        } else if(var0 == 4119) {
                           var3 = class81.scriptStringStack[--class81.scriptStringStackSize];
                           StringBuilder var28 = new StringBuilder(var3.length());
                           boolean var30 = false;

                           for(var26 = 0; var26 < var3.length(); ++var26) {
                              var21 = var3.charAt(var26);
                              if(var21 == 60) {
                                 var30 = true;
                              } else if(var21 == 62) {
                                 var30 = false;
                              } else if(!var30) {
                                 var28.append(var21);
                              }
                           }

                           class81.scriptStringStack[++class81.scriptStringStackSize - 1] = var28.toString();
                           return 1;
                        } else if(var0 == 4120) {
                           var3 = class81.scriptStringStack[--class81.scriptStringStackSize];
                           var4 = class81.intStack[--class81.intStackSize];
                           class81.intStack[++class81.intStackSize - 1] = var3.indexOf(var4);
                           return 1;
                        } else if(var0 == 4121) {
                           class81.scriptStringStackSize -= 2;
                           var3 = class81.scriptStringStack[class81.scriptStringStackSize];
                           var27 = class81.scriptStringStack[class81.scriptStringStackSize + 1];
                           var23 = class81.intStack[--class81.intStackSize];
                           class81.intStack[++class81.intStackSize - 1] = var3.indexOf(var27, var23);
                           return 1;
                        } else {
                           return 2;
                        }
                     } else {
                        var18 = class81.intStack[--class81.intStackSize];
                        var17 = class81.intStack;
                        var23 = ++class81.intStackSize - 1;
                        var21 = (char)var18;
                        var6 = var21 >= 48 && var21 <= 57;
                        var17[var23] = var6?1:0;
                        return 1;
                     }
                  }
               }
            }
         }
      }
   }
}
