import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.util.Date;
import javax.imageio.ImageIO;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fz")
@Implements("IndexFile")
public final class IndexFile {
   @ObfuscatedName("a")
   static byte[] field2279;
   @ObfuscatedName("j")
   @Export("dataFile")
   CacheFile dataFile;
   @ObfuscatedName("n")
   @Export("indexFile")
   CacheFile indexFile;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 575470557
   )
   @Export("maxSize")
   int maxSize;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -579107289
   )
   @Export("index")
   int index;

   static {
      field2279 = new byte[520];
   }

   public IndexFile(int var1, CacheFile var2, CacheFile var3, int var4) {
      this.dataFile = null;
      this.indexFile = null;
      this.maxSize = '\ufde8';
      this.index = var1;
      this.dataFile = var2;
      this.indexFile = var3;
      this.maxSize = var4;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I[BIZI)Z",
      garbageValue = "-406759493"
   )
   boolean method3008(int var1, byte[] var2, int var3, boolean var4) {
      CacheFile var5 = this.dataFile;
      synchronized(this.dataFile) {
         try {
            int var6;
            boolean var10000;
            if(var4) {
               if(this.indexFile.method2331() < (long)(var1 * 6 + 6)) {
                  var10000 = false;
                  return var10000;
               }

               this.indexFile.seek((long)(var1 * 6));
               this.indexFile.method2338(field2279, 0, 6);
               var6 = ((field2279[3] & 255) << 16) + ((field2279[4] & 255) << 8) + (field2279[5] & 255);
               if(var6 <= 0 || (long)var6 > this.dataFile.method2331() / 520L) {
                  var10000 = false;
                  return var10000;
               }
            } else {
               var6 = (int)((this.dataFile.method2331() + 519L) / 520L);
               if(var6 == 0) {
                  var6 = 1;
               }
            }

            field2279[0] = (byte)(var3 >> 16);
            field2279[1] = (byte)(var3 >> 8);
            field2279[2] = (byte)var3;
            field2279[3] = (byte)(var6 >> 16);
            field2279[4] = (byte)(var6 >> 8);
            field2279[5] = (byte)var6;
            this.indexFile.seek((long)(var1 * 6));
            this.indexFile.write(field2279, 0, 6);
            int var7 = 0;
            int var8 = 0;

            while(true) {
               if(var7 < var3) {
                  label132: {
                     int var9 = 0;
                     int var10;
                     if(var4) {
                        label152: {
                           this.dataFile.seek((long)(var6 * 520));

                           try {
                              this.dataFile.method2338(field2279, 0, 8);
                           } catch (EOFException var16) {
                              break label132;
                           }

                           var10 = ((field2279[0] & 255) << 8) + (field2279[1] & 255);
                           int var11 = (field2279[3] & 255) + ((field2279[2] & 255) << 8);
                           var9 = (field2279[6] & 255) + ((field2279[5] & 255) << 8) + ((field2279[4] & 255) << 16);
                           int var12 = field2279[7] & 255;
                           if(var10 == var1 && var8 == var11 && var12 == this.index) {
                              if(var9 >= 0 && (long)var9 <= this.dataFile.method2331() / 520L) {
                                 break label152;
                              }

                              var10000 = false;
                              return var10000;
                           }

                           var10000 = false;
                           return var10000;
                        }
                     }

                     if(var9 == 0) {
                        var4 = false;
                        var9 = (int)((this.dataFile.method2331() + 519L) / 520L);
                        if(var9 == 0) {
                           ++var9;
                        }

                        if(var6 == var9) {
                           ++var9;
                        }
                     }

                     if(var3 - var7 <= 512) {
                        var9 = 0;
                     }

                     field2279[0] = (byte)(var1 >> 8);
                     field2279[1] = (byte)var1;
                     field2279[2] = (byte)(var8 >> 8);
                     field2279[3] = (byte)var8;
                     field2279[4] = (byte)(var9 >> 16);
                     field2279[5] = (byte)(var9 >> 8);
                     field2279[6] = (byte)var9;
                     field2279[7] = (byte)this.index;
                     this.dataFile.seek((long)(var6 * 520));
                     this.dataFile.write(field2279, 0, 8);
                     var10 = var3 - var7;
                     if(var10 > 512) {
                        var10 = 512;
                     }

                     this.dataFile.write(var2, var7, var10);
                     var7 += var10;
                     var6 = var9;
                     ++var8;
                     continue;
                  }
               }

               var10000 = true;
               return var10000;
            }
         } catch (IOException var17) {
            return false;
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I[BIB)Z",
      garbageValue = "97"
   )
   public boolean method3017(int var1, byte[] var2, int var3) {
      CacheFile var4 = this.dataFile;
      synchronized(this.dataFile) {
         if(var3 >= 0 && var3 <= this.maxSize) {
            boolean var5 = this.method3008(var1, var2, var3, true);
            if(!var5) {
               var5 = this.method3008(var1, var2, var3, false);
            }

            return var5;
         } else {
            throw new IllegalArgumentException();
         }
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "-2115033407"
   )
   public byte[] method3011(int var1) {
      CacheFile var2 = this.dataFile;
      synchronized(this.dataFile) {
         Object var10000;
         try {
            if(this.indexFile.method2331() >= (long)(var1 * 6 + 6)) {
               this.indexFile.seek((long)(var1 * 6));
               this.indexFile.method2338(field2279, 0, 6);
               int var3 = ((field2279[0] & 255) << 16) + ((field2279[1] & 255) << 8) + (field2279[2] & 255);
               int var4 = ((field2279[4] & 255) << 8) + ((field2279[3] & 255) << 16) + (field2279[5] & 255);
               if(var3 >= 0 && var3 <= this.maxSize) {
                  if(var4 > 0 && (long)var4 <= this.dataFile.method2331() / 520L) {
                     byte[] var5 = new byte[var3];
                     int var6 = 0;
                     int var7 = 0;

                     while(var6 < var3) {
                        if(var4 == 0) {
                           var10000 = null;
                           return (byte[])var10000;
                        }

                        this.dataFile.seek((long)(var4 * 520));
                        int var8 = var3 - var6;
                        if(var8 > 512) {
                           var8 = 512;
                        }

                        this.dataFile.method2338(field2279, 0, var8 + 8);
                        int var9 = ((field2279[0] & 255) << 8) + (field2279[1] & 255);
                        int var10 = (field2279[3] & 255) + ((field2279[2] & 255) << 8);
                        int var11 = (field2279[6] & 255) + ((field2279[5] & 255) << 8) + ((field2279[4] & 255) << 16);
                        int var12 = field2279[7] & 255;
                        if(var9 == var1 && var10 == var7 && var12 == this.index) {
                           if(var11 >= 0 && (long)var11 <= this.dataFile.method2331() / 520L) {
                              for(int var13 = 0; var13 < var8; ++var13) {
                                 var5[var6++] = field2279[var13 + 8];
                              }

                              var4 = var11;
                              ++var7;
                              continue;
                           }

                           var10000 = null;
                           return (byte[])var10000;
                        }

                        var10000 = null;
                        return (byte[])var10000;
                     }

                     byte[] var18 = var5;
                     return var18;
                  }

                  var10000 = null;
                  return (byte[])var10000;
               }

               var10000 = null;
               return (byte[])var10000;
            }

            var10000 = null;
         } catch (IOException var16) {
            return null;
         }

         return (byte[])var10000;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lclass186;ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "1061388201"
   )
   static String method3005(class186 var0, int var1, String var2) {
      if(var0 == null) {
         return var2;
      } else {
         class185 var3 = (class185)var0.method3482((long)var1);
         return var3 == null?var2:(String)var3.field2442;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LScriptEvent;IB)V",
      garbageValue = "-63"
   )
   static void method3018(ScriptEvent var0, int var1) {
      Object[] var2 = var0.field839;
      class219 var5 = var0.field834;
      boolean var4 = var5 == class219.field2798 || var5 == class219.field2802 || var5 == class219.field2793 || var5 == class219.field2794 || var5 == class219.field2795 || var5 == class219.field2796 || var5 == class219.field2797 || var5 == class219.field2805;
      Script var3;
      Script var7;
      int var9;
      int var10;
      int var11;
      int var12;
      int var25;
      if(var4) {
         class83.field1330 = (class47)var2[0];
         Area var6 = class54.field662[class83.field1330.field590];
         class219 var8 = var0.field834;
         var9 = var6.field3290;
         var10 = var6.field3307;
         var11 = (var9 << 8) + var8.field2801;
         Script var13 = GameEngine.method1003(var11, var8);
         if(var13 != null) {
            var7 = var13;
         } else {
            var12 = Script.method1835(var10, var8);
            var13 = GameEngine.method1003(var12, var8);
            if(var13 != null) {
               var7 = var13;
            } else {
               var7 = null;
            }
         }

         var3 = var7;
      } else {
         var25 = ((Integer)var2[0]).intValue();
         Script var47 = (Script)Script.field1530.get((long)var25);
         if(var47 != null) {
            var7 = var47;
         } else {
            byte[] var43 = class265.indexScripts.getConfigData(var25, 0);
            if(var43 == null) {
               var7 = null;
            } else {
               var47 = NPC.method1676(var43);
               Script.field1530.put(var47, (long)var25);
               var7 = var47;
            }
         }

         var3 = var7;
      }

      if(var3 != null) {
         WorldMapType2.intStackSize = 0;
         BaseVarType.scriptStringStackSize = 0;
         var25 = -1;
         int[] var50 = var3.instructions;
         int[] var48 = var3.intOperands;
         byte var49 = -1;
         class83.scriptStackCount = 0;

         try {
            class83.scriptLocalInts = new int[var3.localIntCount];
            var10 = 0;
            class83.scriptLocalStrings = new String[var3.localStringCount];
            var11 = 0;

            int var26;
            String var51;
            for(var12 = 1; var12 < var2.length; ++var12) {
               if(var2[var12] instanceof Integer) {
                  var26 = ((Integer)var2[var12]).intValue();
                  if(var26 == -2147483647) {
                     var26 = var0.field831;
                  }

                  if(var26 == -2147483646) {
                     var26 = var0.field828;
                  }

                  if(var26 == -2147483645) {
                     var26 = var0.widget != null?var0.widget.id:-1;
                  }

                  if(var26 == -2147483644) {
                     var26 = var0.field832;
                  }

                  if(var26 == -2147483643) {
                     var26 = var0.widget != null?var0.widget.index:-1;
                  }

                  if(var26 == -2147483642) {
                     var26 = var0.field833 != null?var0.field833.id:-1;
                  }

                  if(var26 == -2147483641) {
                     var26 = var0.field833 != null?var0.field833.index:-1;
                  }

                  if(var26 == -2147483640) {
                     var26 = var0.field838;
                  }

                  if(var26 == -2147483639) {
                     var26 = var0.field836;
                  }

                  class83.scriptLocalInts[var10++] = var26;
               } else if(var2[var12] instanceof String) {
                  var51 = (String)var2[var12];
                  if(var51.equals("event_opbase")) {
                     var51 = var0.field837;
                  }

                  class83.scriptLocalStrings[var11++] = var51;
               }
            }

            var12 = 0;
            class83.field1334 = var0.field835;

            while(true) {
               while(true) {
                  while(true) {
                     while(true) {
                        while(true) {
                           while(true) {
                              while(true) {
                                 while(true) {
                                    while(true) {
                                       while(true) {
                                          while(true) {
                                             while(true) {
                                                while(true) {
                                                   while(true) {
                                                      while(true) {
                                                         while(true) {
                                                            while(true) {
                                                               while(true) {
                                                                  while(true) {
                                                                     while(true) {
                                                                        while(true) {
                                                                           while(true) {
                                                                              while(true) {
                                                                                 while(true) {
                                                                                    while(true) {
                                                                                       label2232:
                                                                                       while(true) {
                                                                                          ++var12;
                                                                                          if(var12 > var1) {
                                                                                             throw new RuntimeException();
                                                                                          }

                                                                                          ++var25;
                                                                                          var9 = var50[var25];
                                                                                          int var14;
                                                                                          int var18;
                                                                                          int var20;
                                                                                          int var29;
                                                                                          int var30;
                                                                                          int[] var87;
                                                                                          if(var9 < 100) {
                                                                                             if(var9 != 0) {
                                                                                                if(var9 != 1) {
                                                                                                   if(var9 != 2) {
                                                                                                      if(var9 != 3) {
                                                                                                         if(var9 != 6) {
                                                                                                            if(var9 != 7) {
                                                                                                               if(var9 != 8) {
                                                                                                                  if(var9 != 9) {
                                                                                                                     if(var9 != 10) {
                                                                                                                        if(var9 != 21) {
                                                                                                                           if(var9 != 25) {
                                                                                                                              if(var9 != 27) {
                                                                                                                                 if(var9 != 31) {
                                                                                                                                    if(var9 != 32) {
                                                                                                                                       if(var9 != 33) {
                                                                                                                                          if(var9 != 34) {
                                                                                                                                             if(var9 != 35) {
                                                                                                                                                if(var9 != 36) {
                                                                                                                                                   if(var9 != 37) {
                                                                                                                                                      if(var9 != 38) {
                                                                                                                                                         if(var9 != 39) {
                                                                                                                                                            if(var9 != 40) {
                                                                                                                                                               if(var9 != 42) {
                                                                                                                                                                  if(var9 != 43) {
                                                                                                                                                                     if(var9 == 44) {
                                                                                                                                                                        var26 = var48[var25] >> 16;
                                                                                                                                                                        var14 = var48[var25] & '\uffff';
                                                                                                                                                                        int var101 = class83.intStack[--WorldMapType2.intStackSize];
                                                                                                                                                                        if(var101 >= 0 && var101 <= 5000) {
                                                                                                                                                                           class83.field1331[var26] = var101;
                                                                                                                                                                           byte var90 = -1;
                                                                                                                                                                           if(var14 == 105) {
                                                                                                                                                                              var90 = 0;
                                                                                                                                                                           }

                                                                                                                                                                           var29 = 0;

                                                                                                                                                                           while(true) {
                                                                                                                                                                              if(var29 >= var101) {
                                                                                                                                                                                 continue label2232;
                                                                                                                                                                              }

                                                                                                                                                                              class83.SHAPE_VERTICIES[var26][var29] = var90;
                                                                                                                                                                              ++var29;
                                                                                                                                                                           }
                                                                                                                                                                        }

                                                                                                                                                                        throw new RuntimeException();
                                                                                                                                                                     } else if(var9 == 45) {
                                                                                                                                                                        var26 = var48[var25];
                                                                                                                                                                        var14 = class83.intStack[--WorldMapType2.intStackSize];
                                                                                                                                                                        if(var14 < 0 || var14 >= class83.field1331[var26]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        class83.intStack[++WorldMapType2.intStackSize - 1] = class83.SHAPE_VERTICIES[var26][var14];
                                                                                                                                                                     } else if(var9 == 46) {
                                                                                                                                                                        var26 = var48[var25];
                                                                                                                                                                        WorldMapType2.intStackSize -= 2;
                                                                                                                                                                        var14 = class83.intStack[WorldMapType2.intStackSize];
                                                                                                                                                                        if(var14 < 0 || var14 >= class83.field1331[var26]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        class83.SHAPE_VERTICIES[var26][var14] = class83.intStack[WorldMapType2.intStackSize + 1];
                                                                                                                                                                     } else if(var9 == 47) {
                                                                                                                                                                        var51 = class46.chatMessages.getVarcString(var48[var25]);
                                                                                                                                                                        if(var51 == null) {
                                                                                                                                                                           var51 = "null";
                                                                                                                                                                        }

                                                                                                                                                                        class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = var51;
                                                                                                                                                                     } else if(var9 == 48) {
                                                                                                                                                                        class46.chatMessages.putVarcString(var48[var25], class83.scriptStringStack[--BaseVarType.scriptStringStackSize]);
                                                                                                                                                                     } else {
                                                                                                                                                                        if(var9 != 60) {
                                                                                                                                                                           throw new IllegalStateException();
                                                                                                                                                                        }

                                                                                                                                                                        class186 var53 = var3.switches[var48[var25]];
                                                                                                                                                                        WidgetConfig var79 = (WidgetConfig)var53.method3482((long)class83.intStack[--WorldMapType2.intStackSize]);
                                                                                                                                                                        if(var79 != null) {
                                                                                                                                                                           var25 += var79.config;
                                                                                                                                                                        }
                                                                                                                                                                     }
                                                                                                                                                                  } else {
                                                                                                                                                                     class46.chatMessages.putVarc(var48[var25], class83.intStack[--WorldMapType2.intStackSize]);
                                                                                                                                                                  }
                                                                                                                                                               } else {
                                                                                                                                                                  class83.intStack[++WorldMapType2.intStackSize - 1] = class46.chatMessages.getVarc(var48[var25]);
                                                                                                                                                               }
                                                                                                                                                            } else {
                                                                                                                                                               var26 = var48[var25];
                                                                                                                                                               Script var75 = (Script)Script.field1530.get((long)var26);
                                                                                                                                                               Script var76;
                                                                                                                                                               if(var75 != null) {
                                                                                                                                                                  var76 = var75;
                                                                                                                                                               } else {
                                                                                                                                                                  byte[] var100 = class265.indexScripts.getConfigData(var26, 0);
                                                                                                                                                                  if(var100 == null) {
                                                                                                                                                                     var76 = null;
                                                                                                                                                                  } else {
                                                                                                                                                                     var75 = NPC.method1676(var100);
                                                                                                                                                                     Script.field1530.put(var75, (long)var26);
                                                                                                                                                                     var76 = var75;
                                                                                                                                                                  }
                                                                                                                                                               }

                                                                                                                                                               var75 = var76;
                                                                                                                                                               var87 = new int[var76.localIntCount];
                                                                                                                                                               String[] var74 = new String[var76.localStringCount];

                                                                                                                                                               for(var18 = 0; var18 < var75.intStackCount; ++var18) {
                                                                                                                                                                  var87[var18] = class83.intStack[var18 + (WorldMapType2.intStackSize - var75.intStackCount)];
                                                                                                                                                               }

                                                                                                                                                               for(var18 = 0; var18 < var75.stringStackCount; ++var18) {
                                                                                                                                                                  var74[var18] = class83.scriptStringStack[var18 + (BaseVarType.scriptStringStackSize - var75.stringStackCount)];
                                                                                                                                                               }

                                                                                                                                                               WorldMapType2.intStackSize -= var75.intStackCount;
                                                                                                                                                               BaseVarType.scriptStringStackSize -= var75.stringStackCount;
                                                                                                                                                               ScriptState var91 = new ScriptState();
                                                                                                                                                               var91.invokedFromScript = var3;
                                                                                                                                                               var91.invokedFromPc = var25;
                                                                                                                                                               var91.savedLocalInts = class83.scriptLocalInts;
                                                                                                                                                               var91.savedLocalStrings = class83.scriptLocalStrings;
                                                                                                                                                               class83.scriptStack[++class83.scriptStackCount - 1] = var91;
                                                                                                                                                               var3 = var75;
                                                                                                                                                               var50 = var75.instructions;
                                                                                                                                                               var48 = var75.intOperands;
                                                                                                                                                               var25 = -1;
                                                                                                                                                               class83.scriptLocalInts = var87;
                                                                                                                                                               class83.scriptLocalStrings = var74;
                                                                                                                                                            }
                                                                                                                                                         } else {
                                                                                                                                                            --BaseVarType.scriptStringStackSize;
                                                                                                                                                         }
                                                                                                                                                      } else {
                                                                                                                                                         --WorldMapType2.intStackSize;
                                                                                                                                                      }
                                                                                                                                                   } else {
                                                                                                                                                      var26 = var48[var25];
                                                                                                                                                      BaseVarType.scriptStringStackSize -= var26;
                                                                                                                                                      String var31 = AbstractByteBuffer.method3369(class83.scriptStringStack, BaseVarType.scriptStringStackSize, var26);
                                                                                                                                                      class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = var31;
                                                                                                                                                   }
                                                                                                                                                } else {
                                                                                                                                                   class83.scriptLocalStrings[var48[var25]] = class83.scriptStringStack[--BaseVarType.scriptStringStackSize];
                                                                                                                                                }
                                                                                                                                             } else {
                                                                                                                                                class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = class83.scriptLocalStrings[var48[var25]];
                                                                                                                                             }
                                                                                                                                          } else {
                                                                                                                                             class83.scriptLocalInts[var48[var25]] = class83.intStack[--WorldMapType2.intStackSize];
                                                                                                                                          }
                                                                                                                                       } else {
                                                                                                                                          class83.intStack[++WorldMapType2.intStackSize - 1] = class83.scriptLocalInts[var48[var25]];
                                                                                                                                       }
                                                                                                                                    } else {
                                                                                                                                       WorldMapType2.intStackSize -= 2;
                                                                                                                                       if(class83.intStack[WorldMapType2.intStackSize] >= class83.intStack[WorldMapType2.intStackSize + 1]) {
                                                                                                                                          var25 += var48[var25];
                                                                                                                                       }
                                                                                                                                    }
                                                                                                                                 } else {
                                                                                                                                    WorldMapType2.intStackSize -= 2;
                                                                                                                                    if(class83.intStack[WorldMapType2.intStackSize] <= class83.intStack[WorldMapType2.intStackSize + 1]) {
                                                                                                                                       var25 += var48[var25];
                                                                                                                                    }
                                                                                                                                 }
                                                                                                                              } else {
                                                                                                                                 var26 = var48[var25];
                                                                                                                                 var14 = class83.intStack[--WorldMapType2.intStackSize];
                                                                                                                                 Varbit var99 = (Varbit)Varbit.varbits.get((long)var26);
                                                                                                                                 Varbit var28;
                                                                                                                                 if(var99 != null) {
                                                                                                                                    var28 = var99;
                                                                                                                                 } else {
                                                                                                                                    byte[] var72 = Varbit.varbit_ref.getConfigData(14, var26);
                                                                                                                                    var99 = new Varbit();
                                                                                                                                    if(var72 != null) {
                                                                                                                                       var99.decode(new Buffer(var72));
                                                                                                                                    }

                                                                                                                                    Varbit.varbits.put(var99, (long)var26);
                                                                                                                                    var28 = var99;
                                                                                                                                 }

                                                                                                                                 var29 = var28.configId;
                                                                                                                                 var18 = var28.leastSignificantBit;
                                                                                                                                 var30 = var28.mostSignificantBit;
                                                                                                                                 var20 = class211.field2609[var30 - var18];
                                                                                                                                 if(var14 < 0 || var14 > var20) {
                                                                                                                                    var14 = 0;
                                                                                                                                 }

                                                                                                                                 var20 <<= var18;
                                                                                                                                 class211.widgetSettings[var29] = class211.widgetSettings[var29] & ~var20 | var14 << var18 & var20;
                                                                                                                              }
                                                                                                                           } else {
                                                                                                                              var26 = var48[var25];
                                                                                                                              class83.intStack[++WorldMapType2.intStackSize - 1] = class1.method3(var26);
                                                                                                                           }
                                                                                                                        } else {
                                                                                                                           if(class83.scriptStackCount == 0) {
                                                                                                                              return;
                                                                                                                           }

                                                                                                                           ScriptState var52 = class83.scriptStack[--class83.scriptStackCount];
                                                                                                                           var3 = var52.invokedFromScript;
                                                                                                                           var50 = var3.instructions;
                                                                                                                           var48 = var3.intOperands;
                                                                                                                           var25 = var52.invokedFromPc;
                                                                                                                           class83.scriptLocalInts = var52.savedLocalInts;
                                                                                                                           class83.scriptLocalStrings = var52.savedLocalStrings;
                                                                                                                        }
                                                                                                                     } else {
                                                                                                                        WorldMapType2.intStackSize -= 2;
                                                                                                                        if(class83.intStack[WorldMapType2.intStackSize] > class83.intStack[WorldMapType2.intStackSize + 1]) {
                                                                                                                           var25 += var48[var25];
                                                                                                                        }
                                                                                                                     }
                                                                                                                  } else {
                                                                                                                     WorldMapType2.intStackSize -= 2;
                                                                                                                     if(class83.intStack[WorldMapType2.intStackSize] < class83.intStack[WorldMapType2.intStackSize + 1]) {
                                                                                                                        var25 += var48[var25];
                                                                                                                     }
                                                                                                                  }
                                                                                                               } else {
                                                                                                                  WorldMapType2.intStackSize -= 2;
                                                                                                                  if(class83.intStack[WorldMapType2.intStackSize] == class83.intStack[WorldMapType2.intStackSize + 1]) {
                                                                                                                     var25 += var48[var25];
                                                                                                                  }
                                                                                                               }
                                                                                                            } else {
                                                                                                               WorldMapType2.intStackSize -= 2;
                                                                                                               if(class83.intStack[WorldMapType2.intStackSize] != class83.intStack[WorldMapType2.intStackSize + 1]) {
                                                                                                                  var25 += var48[var25];
                                                                                                               }
                                                                                                            }
                                                                                                         } else {
                                                                                                            var25 += var48[var25];
                                                                                                         }
                                                                                                      } else {
                                                                                                         class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = var3.stringOperands[var25];
                                                                                                      }
                                                                                                   } else {
                                                                                                      var26 = var48[var25];
                                                                                                      class211.widgetSettings[var26] = class83.intStack[--WorldMapType2.intStackSize];
                                                                                                      class3.method8(var26);
                                                                                                   }
                                                                                                } else {
                                                                                                   var26 = var48[var25];
                                                                                                   class83.intStack[++WorldMapType2.intStackSize - 1] = class211.widgetSettings[var26];
                                                                                                }
                                                                                             } else {
                                                                                                class83.intStack[++WorldMapType2.intStackSize - 1] = var48[var25];
                                                                                             }
                                                                                          } else {
                                                                                             boolean var78;
                                                                                             if(var3.intOperands[var25] == 1) {
                                                                                                var78 = true;
                                                                                             } else {
                                                                                                var78 = false;
                                                                                             }

                                                                                             if(var9 < 1000) {
                                                                                                var14 = class47.method718(var9, var3, var78);
                                                                                             } else if(var9 < 1100) {
                                                                                                var14 = Varcs.method1795(var9, var3, var78);
                                                                                             } else if(var9 < 1200) {
                                                                                                var14 = class174.method3352(var9, var3, var78);
                                                                                             } else if(var9 < 1300) {
                                                                                                var14 = class19.method148(var9, var3, var78);
                                                                                             } else if(var9 < 1400) {
                                                                                                var14 = ScriptVarType.method18(var9, var3, var78);
                                                                                             } else if(var9 < 1500) {
                                                                                                var14 = Huffman.method3065(var9, var3, var78);
                                                                                             } else {
                                                                                                byte var15;
                                                                                                Widget var19;
                                                                                                if(var9 < 1600) {
                                                                                                   var19 = var78?class83.field1336:class1.field9;
                                                                                                   if(var9 == 1500) {
                                                                                                      class83.intStack[++WorldMapType2.intStackSize - 1] = var19.relativeX;
                                                                                                      var15 = 1;
                                                                                                   } else if(var9 == 1501) {
                                                                                                      class83.intStack[++WorldMapType2.intStackSize - 1] = var19.relativeY;
                                                                                                      var15 = 1;
                                                                                                   } else if(var9 == 1502) {
                                                                                                      class83.intStack[++WorldMapType2.intStackSize - 1] = var19.width;
                                                                                                      var15 = 1;
                                                                                                   } else if(var9 == 1503) {
                                                                                                      class83.intStack[++WorldMapType2.intStackSize - 1] = var19.height;
                                                                                                      var15 = 1;
                                                                                                   } else if(var9 == 1504) {
                                                                                                      class83.intStack[++WorldMapType2.intStackSize - 1] = var19.isHidden?1:0;
                                                                                                      var15 = 1;
                                                                                                   } else if(var9 == 1505) {
                                                                                                      class83.intStack[++WorldMapType2.intStackSize - 1] = var19.parentId;
                                                                                                      var15 = 1;
                                                                                                   } else {
                                                                                                      var15 = 2;
                                                                                                   }

                                                                                                   var14 = var15;
                                                                                                } else if(var9 < 1700) {
                                                                                                   var14 = class222.method4057(var9, var3, var78);
                                                                                                } else if(var9 < 1800) {
                                                                                                   var19 = var78?class83.field1336:class1.field9;
                                                                                                   if(var9 == 1700) {
                                                                                                      class83.intStack[++WorldMapType2.intStackSize - 1] = var19.itemId;
                                                                                                      var15 = 1;
                                                                                                   } else if(var9 == 1701) {
                                                                                                      if(var19.itemId != -1) {
                                                                                                         class83.intStack[++WorldMapType2.intStackSize - 1] = var19.itemQuantity;
                                                                                                      } else {
                                                                                                         class83.intStack[++WorldMapType2.intStackSize - 1] = 0;
                                                                                                      }

                                                                                                      var15 = 1;
                                                                                                   } else if(var9 == 1702) {
                                                                                                      class83.intStack[++WorldMapType2.intStackSize - 1] = var19.index;
                                                                                                      var15 = 1;
                                                                                                   } else {
                                                                                                      var15 = 2;
                                                                                                   }

                                                                                                   var14 = var15;
                                                                                                } else {
                                                                                                   int[] var17;
                                                                                                   if(var9 < 1900) {
                                                                                                      Widget var27 = var78?class83.field1336:class1.field9;
                                                                                                      if(var9 == 1800) {
                                                                                                         var17 = class83.intStack;
                                                                                                         var18 = ++WorldMapType2.intStackSize - 1;
                                                                                                         var20 = class46.getWidgetConfig(var27);
                                                                                                         var30 = var20 >> 11 & 63;
                                                                                                         var17[var18] = var30;
                                                                                                         var15 = 1;
                                                                                                      } else if(var9 != 1801) {
                                                                                                         if(var9 == 1802) {
                                                                                                            if(var27.name == null) {
                                                                                                               class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = "";
                                                                                                            } else {
                                                                                                               class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = var27.name;
                                                                                                            }

                                                                                                            var15 = 1;
                                                                                                         } else {
                                                                                                            var15 = 2;
                                                                                                         }
                                                                                                      } else {
                                                                                                         var29 = class83.intStack[--WorldMapType2.intStackSize];
                                                                                                         --var29;
                                                                                                         if(var27.actions != null && var29 < var27.actions.length && var27.actions[var29] != null) {
                                                                                                            class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = var27.actions[var29];
                                                                                                         } else {
                                                                                                            class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = "";
                                                                                                         }

                                                                                                         var15 = 1;
                                                                                                      }

                                                                                                      var14 = var15;
                                                                                                   } else if(var9 < 2000) {
                                                                                                      var14 = class19.method149(var9, var3, var78);
                                                                                                   } else if(var9 < 2100) {
                                                                                                      var14 = Varcs.method1795(var9, var3, var78);
                                                                                                   } else if(var9 < 2200) {
                                                                                                      var14 = class174.method3352(var9, var3, var78);
                                                                                                   } else if(var9 < 2300) {
                                                                                                      var14 = class19.method148(var9, var3, var78);
                                                                                                   } else if(var9 < 2400) {
                                                                                                      var14 = ScriptVarType.method18(var9, var3, var78);
                                                                                                   } else if(var9 < 2500) {
                                                                                                      var14 = Huffman.method3065(var9, var3, var78);
                                                                                                   } else if(var9 < 2600) {
                                                                                                      var14 = XClanMember.method1141(var9, var3, var78);
                                                                                                   } else if(var9 < 2700) {
                                                                                                      var14 = CombatInfo1.method1513(var9, var3, var78);
                                                                                                   } else if(var9 < 2800) {
                                                                                                      var14 = class33.method350(var9, var3, var78);
                                                                                                   } else if(var9 < 2900) {
                                                                                                      var14 = class36.method488(var9, var3, var78);
                                                                                                   } else if(var9 < 3000) {
                                                                                                      var14 = class19.method149(var9, var3, var78);
                                                                                                   } else if(var9 < 3200) {
                                                                                                      var14 = Projectile.method1734(var9, var3, var78);
                                                                                                   } else if(var9 < 3300) {
                                                                                                      var14 = ScriptVarType.method16(var9, var3, var78);
                                                                                                   } else if(var9 < 3400) {
                                                                                                      var14 = class227.method4065(var9, var3, var78);
                                                                                                   } else {
                                                                                                      int var16;
                                                                                                      int var35;
                                                                                                      if(var9 < 3500) {
                                                                                                         if(var9 == 3400) {
                                                                                                            WorldMapType2.intStackSize -= 2;
                                                                                                            var16 = class83.intStack[WorldMapType2.intStackSize];
                                                                                                            var29 = class83.intStack[WorldMapType2.intStackSize + 1];
                                                                                                            Enum var32 = class9.method45(var16);
                                                                                                            if(var32.valType != 115) {
                                                                                                               ;
                                                                                                            }

                                                                                                            for(var30 = 0; var30 < var32.size; ++var30) {
                                                                                                               if(var29 == var32.keys[var30]) {
                                                                                                                  class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = var32.stringVals[var30];
                                                                                                                  var32 = null;
                                                                                                                  break;
                                                                                                               }
                                                                                                            }

                                                                                                            if(var32 != null) {
                                                                                                               class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = var32.defaultString;
                                                                                                            }

                                                                                                            var15 = 1;
                                                                                                         } else if(var9 != 3408) {
                                                                                                            var15 = 2;
                                                                                                         } else {
                                                                                                            WorldMapType2.intStackSize -= 4;
                                                                                                            var16 = class83.intStack[WorldMapType2.intStackSize];
                                                                                                            var29 = class83.intStack[WorldMapType2.intStackSize + 1];
                                                                                                            var18 = class83.intStack[WorldMapType2.intStackSize + 2];
                                                                                                            var30 = class83.intStack[WorldMapType2.intStackSize + 3];
                                                                                                            Enum var36 = class9.method45(var18);
                                                                                                            if(var16 == var36.keyType && var29 == var36.valType) {
                                                                                                               for(var35 = 0; var35 < var36.size; ++var35) {
                                                                                                                  if(var30 == var36.keys[var35]) {
                                                                                                                     if(var29 == 115) {
                                                                                                                        class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = var36.stringVals[var35];
                                                                                                                     } else {
                                                                                                                        class83.intStack[++WorldMapType2.intStackSize - 1] = var36.intVals[var35];
                                                                                                                     }

                                                                                                                     var36 = null;
                                                                                                                     break;
                                                                                                                  }
                                                                                                               }

                                                                                                               if(var36 != null) {
                                                                                                                  if(var29 == 115) {
                                                                                                                     class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = var36.defaultString;
                                                                                                                  } else {
                                                                                                                     class83.intStack[++WorldMapType2.intStackSize - 1] = var36.defaultInt;
                                                                                                                  }
                                                                                                               }

                                                                                                               var15 = 1;
                                                                                                            } else {
                                                                                                               if(var29 == 115) {
                                                                                                                  class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = "null";
                                                                                                               } else {
                                                                                                                  class83.intStack[++WorldMapType2.intStackSize - 1] = 0;
                                                                                                               }

                                                                                                               var15 = 1;
                                                                                                            }
                                                                                                         }

                                                                                                         var14 = var15;
                                                                                                      } else {
                                                                                                         String var55;
                                                                                                         String var73;
                                                                                                         if(var9 < 3700) {
                                                                                                            if(var9 == 3600) {
                                                                                                               if(Client.field1056 == 0) {
                                                                                                                  class83.intStack[++WorldMapType2.intStackSize - 1] = -2;
                                                                                                               } else if(Client.field1056 == 1) {
                                                                                                                  class83.intStack[++WorldMapType2.intStackSize - 1] = -1;
                                                                                                               } else {
                                                                                                                  class83.intStack[++WorldMapType2.intStackSize - 1] = Client.friendCount;
                                                                                                               }

                                                                                                               var15 = 1;
                                                                                                            } else if(var9 == 3601) {
                                                                                                               var16 = class83.intStack[--WorldMapType2.intStackSize];
                                                                                                               if(Client.field1056 == 2 && var16 < Client.friendCount) {
                                                                                                                  class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = Client.friends[var16].name;
                                                                                                                  class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = Client.friends[var16].previousName;
                                                                                                               } else {
                                                                                                                  class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = "";
                                                                                                                  class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = "";
                                                                                                               }

                                                                                                               var15 = 1;
                                                                                                            } else if(var9 == 3602) {
                                                                                                               var16 = class83.intStack[--WorldMapType2.intStackSize];
                                                                                                               if(Client.field1056 == 2 && var16 < Client.friendCount) {
                                                                                                                  class83.intStack[++WorldMapType2.intStackSize - 1] = Client.friends[var16].world;
                                                                                                               } else {
                                                                                                                  class83.intStack[++WorldMapType2.intStackSize - 1] = 0;
                                                                                                               }

                                                                                                               var15 = 1;
                                                                                                            } else if(var9 == 3603) {
                                                                                                               var16 = class83.intStack[--WorldMapType2.intStackSize];
                                                                                                               if(Client.field1056 == 2 && var16 < Client.friendCount) {
                                                                                                                  class83.intStack[++WorldMapType2.intStackSize - 1] = Client.friends[var16].rank;
                                                                                                               } else {
                                                                                                                  class83.intStack[++WorldMapType2.intStackSize - 1] = 0;
                                                                                                               }

                                                                                                               var15 = 1;
                                                                                                            } else if(var9 == 3604) {
                                                                                                               var73 = class83.scriptStringStack[--BaseVarType.scriptStringStackSize];
                                                                                                               var29 = class83.intStack[--WorldMapType2.intStackSize];
                                                                                                               GroundObject.method2478(var73, var29);
                                                                                                               var15 = 1;
                                                                                                            } else {
                                                                                                               String var21;
                                                                                                               Ignore var57;
                                                                                                               Friend var58;
                                                                                                               String var93;
                                                                                                               if(var9 == 3605) {
                                                                                                                  var73 = class83.scriptStringStack[--BaseVarType.scriptStringStackSize];
                                                                                                                  if(var73 != null) {
                                                                                                                     if((Client.friendCount < 200 || Client.field1028 == 1) && Client.friendCount < 400) {
                                                                                                                        var55 = class202.method3682(var73, class164.field2317);
                                                                                                                        if(var55 != null) {
                                                                                                                           var18 = 0;

                                                                                                                           label2044:
                                                                                                                           while(true) {
                                                                                                                              if(var18 >= Client.friendCount) {
                                                                                                                                 for(var18 = 0; var18 < Client.ignoreCount; ++var18) {
                                                                                                                                    var57 = Client.ignores[var18];
                                                                                                                                    var93 = class202.method3682(var57.name, class164.field2317);
                                                                                                                                    if(var93 != null && var93.equals(var55)) {
                                                                                                                                       WidgetNode.sendGameMessage(30, "", "Please remove " + var73 + " from your ignore list first");
                                                                                                                                       break label2044;
                                                                                                                                    }

                                                                                                                                    if(var57.previousName != null) {
                                                                                                                                       var21 = class202.method3682(var57.previousName, class164.field2317);
                                                                                                                                       if(var21 != null && var21.equals(var55)) {
                                                                                                                                          WidgetNode.sendGameMessage(30, "", "Please remove " + var73 + " from your ignore list first");
                                                                                                                                          break label2044;
                                                                                                                                       }
                                                                                                                                    }
                                                                                                                                 }

                                                                                                                                 if(class202.method3682(Script.localPlayer.name, class164.field2317).equals(var55)) {
                                                                                                                                    WidgetNode.sendGameMessage(30, "", "You can\'t add yourself to your own friend list");
                                                                                                                                 } else {
                                                                                                                                    Client.secretPacketBuffer1.putOpcode(6);
                                                                                                                                    Client.secretPacketBuffer1.putByte(DecorativeObject.getLength(var73));
                                                                                                                                    Client.secretPacketBuffer1.putString(var73);
                                                                                                                                 }
                                                                                                                                 break;
                                                                                                                              }

                                                                                                                              var58 = Client.friends[var18];
                                                                                                                              var93 = class202.method3682(var58.name, class164.field2317);
                                                                                                                              if(var93 != null && var93.equals(var55)) {
                                                                                                                                 WidgetNode.sendGameMessage(30, "", var73 + " is already on your friend list");
                                                                                                                                 break;
                                                                                                                              }

                                                                                                                              if(var58.previousName != null) {
                                                                                                                                 var21 = class202.method3682(var58.previousName, class164.field2317);
                                                                                                                                 if(var21 != null && var21.equals(var55)) {
                                                                                                                                    WidgetNode.sendGameMessage(30, "", var73 + " is already on your friend list");
                                                                                                                                    break;
                                                                                                                                 }
                                                                                                                              }

                                                                                                                              ++var18;
                                                                                                                           }
                                                                                                                        }
                                                                                                                     } else {
                                                                                                                        WidgetNode.sendGameMessage(30, "", "Your friend list is full. Max of 200 for free users, and 400 for members");
                                                                                                                     }
                                                                                                                  }

                                                                                                                  var15 = 1;
                                                                                                               } else if(var9 == 3606) {
                                                                                                                  var73 = class83.scriptStringStack[--BaseVarType.scriptStringStackSize];
                                                                                                                  class45.method656(var73);
                                                                                                                  var15 = 1;
                                                                                                               } else if(var9 == 3607) {
                                                                                                                  var73 = class83.scriptStringStack[--BaseVarType.scriptStringStackSize];
                                                                                                                  if(var73 != null) {
                                                                                                                     if((Client.ignoreCount < 100 || Client.field1028 == 1) && Client.ignoreCount < 400) {
                                                                                                                        var55 = class202.method3682(var73, class164.field2317);
                                                                                                                        if(var55 != null) {
                                                                                                                           var18 = 0;

                                                                                                                           label2078:
                                                                                                                           while(true) {
                                                                                                                              if(var18 >= Client.ignoreCount) {
                                                                                                                                 for(var18 = 0; var18 < Client.friendCount; ++var18) {
                                                                                                                                    var58 = Client.friends[var18];
                                                                                                                                    var93 = class202.method3682(var58.name, class164.field2317);
                                                                                                                                    if(var93 != null && var93.equals(var55)) {
                                                                                                                                       WidgetNode.sendGameMessage(31, "", "Please remove " + var73 + " from your friend list first");
                                                                                                                                       break label2078;
                                                                                                                                    }

                                                                                                                                    if(var58.previousName != null) {
                                                                                                                                       var21 = class202.method3682(var58.previousName, class164.field2317);
                                                                                                                                       if(var21 != null && var21.equals(var55)) {
                                                                                                                                          WidgetNode.sendGameMessage(31, "", "Please remove " + var73 + " from your friend list first");
                                                                                                                                          break label2078;
                                                                                                                                       }
                                                                                                                                    }
                                                                                                                                 }

                                                                                                                                 if(class202.method3682(Script.localPlayer.name, class164.field2317).equals(var55)) {
                                                                                                                                    WidgetNode.sendGameMessage(31, "", "You can\'t add yourself to your own ignore list");
                                                                                                                                 } else {
                                                                                                                                    Client.secretPacketBuffer1.putOpcode(195);
                                                                                                                                    Client.secretPacketBuffer1.putByte(DecorativeObject.getLength(var73));
                                                                                                                                    Client.secretPacketBuffer1.putString(var73);
                                                                                                                                 }
                                                                                                                                 break;
                                                                                                                              }

                                                                                                                              var57 = Client.ignores[var18];
                                                                                                                              var93 = class202.method3682(var57.name, class164.field2317);
                                                                                                                              if(var93 != null && var93.equals(var55)) {
                                                                                                                                 WidgetNode.sendGameMessage(31, "", var73 + " is already on your ignore list");
                                                                                                                                 break;
                                                                                                                              }

                                                                                                                              if(var57.previousName != null) {
                                                                                                                                 var21 = class202.method3682(var57.previousName, class164.field2317);
                                                                                                                                 if(var21 != null && var21.equals(var55)) {
                                                                                                                                    WidgetNode.sendGameMessage(31, "", var73 + " is already on your ignore list");
                                                                                                                                    break;
                                                                                                                                 }
                                                                                                                              }

                                                                                                                              ++var18;
                                                                                                                           }
                                                                                                                        }
                                                                                                                     } else {
                                                                                                                        WidgetNode.sendGameMessage(31, "", "Your ignore list is full. Max of 100 for free users, and 400 for members");
                                                                                                                     }
                                                                                                                  }

                                                                                                                  var15 = 1;
                                                                                                               } else if(var9 == 3608) {
                                                                                                                  var73 = class83.scriptStringStack[--BaseVarType.scriptStringStackSize];
                                                                                                                  Script.method1831(var73);
                                                                                                                  var15 = 1;
                                                                                                               } else if(var9 == 3609) {
                                                                                                                  var73 = class83.scriptStringStack[--BaseVarType.scriptStringStackSize];
                                                                                                                  Permission[] var54 = new Permission[]{Permission.field3176, Permission.field3175, Permission.field3174, Permission.field3180, Permission.field3177, Permission.field3179};
                                                                                                                  Permission[] var80 = var54;

                                                                                                                  for(var30 = 0; var30 < var80.length; ++var30) {
                                                                                                                     Permission var92 = var80[var30];
                                                                                                                     if(var92.field3178 != -1 && var73.startsWith(CombatInfo1.method1517(var92.field3178))) {
                                                                                                                        var73 = var73.substring(6 + Integer.toString(var92.field3178).length());
                                                                                                                        break;
                                                                                                                     }
                                                                                                                  }

                                                                                                                  class83.intStack[++WorldMapType2.intStackSize - 1] = WorldMapType3.isFriended(var73, false)?1:0;
                                                                                                                  var15 = 1;
                                                                                                               } else if(var9 == 3611) {
                                                                                                                  if(Client.clanChatOwner != null) {
                                                                                                                     class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = VarPlayerType.method4239(Client.clanChatOwner);
                                                                                                                  } else {
                                                                                                                     class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = "";
                                                                                                                  }

                                                                                                                  var15 = 1;
                                                                                                               } else if(var9 == 3612) {
                                                                                                                  if(Client.clanChatOwner != null) {
                                                                                                                     class83.intStack[++WorldMapType2.intStackSize - 1] = Signlink.clanChatCount;
                                                                                                                  } else {
                                                                                                                     class83.intStack[++WorldMapType2.intStackSize - 1] = 0;
                                                                                                                  }

                                                                                                                  var15 = 1;
                                                                                                               } else if(var9 == 3613) {
                                                                                                                  var16 = class83.intStack[--WorldMapType2.intStackSize];
                                                                                                                  if(Client.clanChatOwner != null && var16 < Signlink.clanChatCount) {
                                                                                                                     class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = class44.clanMembers[var16].username;
                                                                                                                  } else {
                                                                                                                     class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = "";
                                                                                                                  }

                                                                                                                  var15 = 1;
                                                                                                               } else if(var9 == 3614) {
                                                                                                                  var16 = class83.intStack[--WorldMapType2.intStackSize];
                                                                                                                  if(Client.clanChatOwner != null && var16 < Signlink.clanChatCount) {
                                                                                                                     class83.intStack[++WorldMapType2.intStackSize - 1] = class44.clanMembers[var16].world;
                                                                                                                  } else {
                                                                                                                     class83.intStack[++WorldMapType2.intStackSize - 1] = 0;
                                                                                                                  }

                                                                                                                  var15 = 1;
                                                                                                               } else if(var9 == 3615) {
                                                                                                                  var16 = class83.intStack[--WorldMapType2.intStackSize];
                                                                                                                  if(Client.clanChatOwner != null && var16 < Signlink.clanChatCount) {
                                                                                                                     class83.intStack[++WorldMapType2.intStackSize - 1] = class44.clanMembers[var16].rank;
                                                                                                                  } else {
                                                                                                                     class83.intStack[++WorldMapType2.intStackSize - 1] = 0;
                                                                                                                  }

                                                                                                                  var15 = 1;
                                                                                                               } else if(var9 == 3616) {
                                                                                                                  class83.intStack[++WorldMapType2.intStackSize - 1] = FaceNormal.field2133;
                                                                                                                  var15 = 1;
                                                                                                               } else if(var9 == 3617) {
                                                                                                                  var73 = class83.scriptStringStack[--BaseVarType.scriptStringStackSize];
                                                                                                                  if(class44.clanMembers != null) {
                                                                                                                     Client.secretPacketBuffer1.putOpcode(182);
                                                                                                                     Client.secretPacketBuffer1.putByte(DecorativeObject.getLength(var73));
                                                                                                                     Client.secretPacketBuffer1.putString(var73);
                                                                                                                  }

                                                                                                                  var15 = 1;
                                                                                                               } else if(var9 == 3618) {
                                                                                                                  class83.intStack[++WorldMapType2.intStackSize - 1] = class27.clanChatRank;
                                                                                                                  var15 = 1;
                                                                                                               } else if(var9 == 3619) {
                                                                                                                  var73 = class83.scriptStringStack[--BaseVarType.scriptStringStackSize];
                                                                                                                  BaseVarType.method10(var73);
                                                                                                                  var15 = 1;
                                                                                                               } else if(var9 == 3620) {
                                                                                                                  CombatInfo1.method1515();
                                                                                                                  var15 = 1;
                                                                                                               } else if(var9 == 3621) {
                                                                                                                  if(Client.field1056 == 0) {
                                                                                                                     class83.intStack[++WorldMapType2.intStackSize - 1] = -1;
                                                                                                                  } else {
                                                                                                                     class83.intStack[++WorldMapType2.intStackSize - 1] = Client.ignoreCount;
                                                                                                                  }

                                                                                                                  var15 = 1;
                                                                                                               } else if(var9 == 3622) {
                                                                                                                  var16 = class83.intStack[--WorldMapType2.intStackSize];
                                                                                                                  if(Client.field1056 != 0 && var16 < Client.ignoreCount) {
                                                                                                                     class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = Client.ignores[var16].name;
                                                                                                                     class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = Client.ignores[var16].previousName;
                                                                                                                  } else {
                                                                                                                     class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = "";
                                                                                                                     class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = "";
                                                                                                                  }

                                                                                                                  var15 = 1;
                                                                                                               } else if(var9 == 3623) {
                                                                                                                  var73 = class83.scriptStringStack[--BaseVarType.scriptStringStackSize];
                                                                                                                  if(var73.startsWith(CombatInfo1.method1517(0)) || var73.startsWith(CombatInfo1.method1517(1))) {
                                                                                                                     var73 = var73.substring(7);
                                                                                                                  }

                                                                                                                  class83.intStack[++WorldMapType2.intStackSize - 1] = MilliTimer.isIgnored(var73)?1:0;
                                                                                                                  var15 = 1;
                                                                                                               } else if(var9 != 3624) {
                                                                                                                  if(var9 == 3625) {
                                                                                                                     if(Client.clanChatName != null) {
                                                                                                                        class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = VarPlayerType.method4239(Client.clanChatName);
                                                                                                                     } else {
                                                                                                                        class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = "";
                                                                                                                     }

                                                                                                                     var15 = 1;
                                                                                                                  } else {
                                                                                                                     var15 = 2;
                                                                                                                  }
                                                                                                               } else {
                                                                                                                  var16 = class83.intStack[--WorldMapType2.intStackSize];
                                                                                                                  if(class44.clanMembers != null && var16 < Signlink.clanChatCount && class44.clanMembers[var16].username.equalsIgnoreCase(Script.localPlayer.name)) {
                                                                                                                     class83.intStack[++WorldMapType2.intStackSize - 1] = 1;
                                                                                                                  } else {
                                                                                                                     class83.intStack[++WorldMapType2.intStackSize - 1] = 0;
                                                                                                                  }

                                                                                                                  var15 = 1;
                                                                                                               }
                                                                                                            }

                                                                                                            var14 = var15;
                                                                                                         } else if(var9 < 4000) {
                                                                                                            var14 = class25.method174(var9, var3, var78);
                                                                                                         } else if(var9 < 4100) {
                                                                                                            if(var9 == 4000) {
                                                                                                               WorldMapType2.intStackSize -= 2;
                                                                                                               var16 = class83.intStack[WorldMapType2.intStackSize];
                                                                                                               var29 = class83.intStack[WorldMapType2.intStackSize + 1];
                                                                                                               class83.intStack[++WorldMapType2.intStackSize - 1] = var29 + var16;
                                                                                                               var15 = 1;
                                                                                                            } else if(var9 == 4001) {
                                                                                                               WorldMapType2.intStackSize -= 2;
                                                                                                               var16 = class83.intStack[WorldMapType2.intStackSize];
                                                                                                               var29 = class83.intStack[WorldMapType2.intStackSize + 1];
                                                                                                               class83.intStack[++WorldMapType2.intStackSize - 1] = var16 - var29;
                                                                                                               var15 = 1;
                                                                                                            } else if(var9 == 4002) {
                                                                                                               WorldMapType2.intStackSize -= 2;
                                                                                                               var16 = class83.intStack[WorldMapType2.intStackSize];
                                                                                                               var29 = class83.intStack[WorldMapType2.intStackSize + 1];
                                                                                                               class83.intStack[++WorldMapType2.intStackSize - 1] = var29 * var16;
                                                                                                               var15 = 1;
                                                                                                            } else if(var9 == 4003) {
                                                                                                               WorldMapType2.intStackSize -= 2;
                                                                                                               var16 = class83.intStack[WorldMapType2.intStackSize];
                                                                                                               var29 = class83.intStack[WorldMapType2.intStackSize + 1];
                                                                                                               class83.intStack[++WorldMapType2.intStackSize - 1] = var16 / var29;
                                                                                                               var15 = 1;
                                                                                                            } else if(var9 == 4004) {
                                                                                                               var16 = class83.intStack[--WorldMapType2.intStackSize];
                                                                                                               class83.intStack[++WorldMapType2.intStackSize - 1] = (int)(Math.random() * (double)var16);
                                                                                                               var15 = 1;
                                                                                                            } else if(var9 == 4005) {
                                                                                                               var16 = class83.intStack[--WorldMapType2.intStackSize];
                                                                                                               class83.intStack[++WorldMapType2.intStackSize - 1] = (int)(Math.random() * (double)(var16 + 1));
                                                                                                               var15 = 1;
                                                                                                            } else if(var9 == 4006) {
                                                                                                               WorldMapType2.intStackSize -= 5;
                                                                                                               var16 = class83.intStack[WorldMapType2.intStackSize];
                                                                                                               var29 = class83.intStack[WorldMapType2.intStackSize + 1];
                                                                                                               var18 = class83.intStack[WorldMapType2.intStackSize + 2];
                                                                                                               var30 = class83.intStack[WorldMapType2.intStackSize + 3];
                                                                                                               var20 = class83.intStack[WorldMapType2.intStackSize + 4];
                                                                                                               class83.intStack[++WorldMapType2.intStackSize - 1] = var16 + (var20 - var18) * (var29 - var16) / (var30 - var18);
                                                                                                               var15 = 1;
                                                                                                            } else if(var9 == 4007) {
                                                                                                               WorldMapType2.intStackSize -= 2;
                                                                                                               var16 = class83.intStack[WorldMapType2.intStackSize];
                                                                                                               var29 = class83.intStack[WorldMapType2.intStackSize + 1];
                                                                                                               class83.intStack[++WorldMapType2.intStackSize - 1] = var16 + var16 * var29 / 100;
                                                                                                               var15 = 1;
                                                                                                            } else if(var9 == 4008) {
                                                                                                               WorldMapType2.intStackSize -= 2;
                                                                                                               var16 = class83.intStack[WorldMapType2.intStackSize];
                                                                                                               var29 = class83.intStack[WorldMapType2.intStackSize + 1];
                                                                                                               class83.intStack[++WorldMapType2.intStackSize - 1] = var16 | 1 << var29;
                                                                                                               var15 = 1;
                                                                                                            } else if(var9 == 4009) {
                                                                                                               WorldMapType2.intStackSize -= 2;
                                                                                                               var16 = class83.intStack[WorldMapType2.intStackSize];
                                                                                                               var29 = class83.intStack[WorldMapType2.intStackSize + 1];
                                                                                                               class83.intStack[++WorldMapType2.intStackSize - 1] = var16 & -1 - (1 << var29);
                                                                                                               var15 = 1;
                                                                                                            } else if(var9 == 4010) {
                                                                                                               WorldMapType2.intStackSize -= 2;
                                                                                                               var16 = class83.intStack[WorldMapType2.intStackSize];
                                                                                                               var29 = class83.intStack[WorldMapType2.intStackSize + 1];
                                                                                                               class83.intStack[++WorldMapType2.intStackSize - 1] = (var16 & 1 << var29) != 0?1:0;
                                                                                                               var15 = 1;
                                                                                                            } else if(var9 == 4011) {
                                                                                                               WorldMapType2.intStackSize -= 2;
                                                                                                               var16 = class83.intStack[WorldMapType2.intStackSize];
                                                                                                               var29 = class83.intStack[WorldMapType2.intStackSize + 1];
                                                                                                               class83.intStack[++WorldMapType2.intStackSize - 1] = var16 % var29;
                                                                                                               var15 = 1;
                                                                                                            } else if(var9 == 4012) {
                                                                                                               WorldMapType2.intStackSize -= 2;
                                                                                                               var16 = class83.intStack[WorldMapType2.intStackSize];
                                                                                                               var29 = class83.intStack[WorldMapType2.intStackSize + 1];
                                                                                                               if(var16 == 0) {
                                                                                                                  class83.intStack[++WorldMapType2.intStackSize - 1] = 0;
                                                                                                               } else {
                                                                                                                  class83.intStack[++WorldMapType2.intStackSize - 1] = (int)Math.pow((double)var16, (double)var29);
                                                                                                               }

                                                                                                               var15 = 1;
                                                                                                            } else if(var9 == 4013) {
                                                                                                               WorldMapType2.intStackSize -= 2;
                                                                                                               var16 = class83.intStack[WorldMapType2.intStackSize];
                                                                                                               var29 = class83.intStack[WorldMapType2.intStackSize + 1];
                                                                                                               if(var16 == 0) {
                                                                                                                  class83.intStack[++WorldMapType2.intStackSize - 1] = 0;
                                                                                                               } else if(var29 == 0) {
                                                                                                                  class83.intStack[++WorldMapType2.intStackSize - 1] = Integer.MAX_VALUE;
                                                                                                               } else {
                                                                                                                  class83.intStack[++WorldMapType2.intStackSize - 1] = (int)Math.pow((double)var16, 1.0D / (double)var29);
                                                                                                               }

                                                                                                               var15 = 1;
                                                                                                            } else if(var9 == 4014) {
                                                                                                               WorldMapType2.intStackSize -= 2;
                                                                                                               var16 = class83.intStack[WorldMapType2.intStackSize];
                                                                                                               var29 = class83.intStack[WorldMapType2.intStackSize + 1];
                                                                                                               class83.intStack[++WorldMapType2.intStackSize - 1] = var16 & var29;
                                                                                                               var15 = 1;
                                                                                                            } else if(var9 == 4015) {
                                                                                                               WorldMapType2.intStackSize -= 2;
                                                                                                               var16 = class83.intStack[WorldMapType2.intStackSize];
                                                                                                               var29 = class83.intStack[WorldMapType2.intStackSize + 1];
                                                                                                               class83.intStack[++WorldMapType2.intStackSize - 1] = var16 | var29;
                                                                                                               var15 = 1;
                                                                                                            } else if(var9 == 4018) {
                                                                                                               WorldMapType2.intStackSize -= 3;
                                                                                                               long var37 = (long)class83.intStack[WorldMapType2.intStackSize];
                                                                                                               long var39 = (long)class83.intStack[WorldMapType2.intStackSize + 1];
                                                                                                               long var41 = (long)class83.intStack[WorldMapType2.intStackSize + 2];
                                                                                                               class83.intStack[++WorldMapType2.intStackSize - 1] = (int)(var41 * var37 / var39);
                                                                                                               var15 = 1;
                                                                                                            } else {
                                                                                                               var15 = 2;
                                                                                                            }

                                                                                                            var14 = var15;
                                                                                                         } else if(var9 < 4200) {
                                                                                                            if(var9 == 4100) {
                                                                                                               var73 = class83.scriptStringStack[--BaseVarType.scriptStringStackSize];
                                                                                                               var29 = class83.intStack[--WorldMapType2.intStackSize];
                                                                                                               class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = var73 + var29;
                                                                                                               var15 = 1;
                                                                                                            } else if(var9 == 4101) {
                                                                                                               BaseVarType.scriptStringStackSize -= 2;
                                                                                                               var73 = class83.scriptStringStack[BaseVarType.scriptStringStackSize];
                                                                                                               var55 = class83.scriptStringStack[BaseVarType.scriptStringStackSize + 1];
                                                                                                               class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = var73 + var55;
                                                                                                               var15 = 1;
                                                                                                            } else if(var9 == 4102) {
                                                                                                               var73 = class83.scriptStringStack[--BaseVarType.scriptStringStackSize];
                                                                                                               var29 = class83.intStack[--WorldMapType2.intStackSize];
                                                                                                               class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = var73 + GameEngine.method1005(var29, true);
                                                                                                               var15 = 1;
                                                                                                            } else if(var9 == 4103) {
                                                                                                               var73 = class83.scriptStringStack[--BaseVarType.scriptStringStackSize];
                                                                                                               class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = var73.toLowerCase();
                                                                                                               var15 = 1;
                                                                                                            } else if(var9 == 4104) {
                                                                                                               var16 = class83.intStack[--WorldMapType2.intStackSize];
                                                                                                               long var33 = ((long)var16 + 11745L) * 86400000L;
                                                                                                               class83.field1337.setTime(new Date(var33));
                                                                                                               var30 = class83.field1337.get(5);
                                                                                                               var20 = class83.field1337.get(2);
                                                                                                               var35 = class83.field1337.get(1);
                                                                                                               class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = var30 + "-" + class83.field1326[var20] + "-" + var35;
                                                                                                               var15 = 1;
                                                                                                            } else if(var9 == 4105) {
                                                                                                               BaseVarType.scriptStringStackSize -= 2;
                                                                                                               var73 = class83.scriptStringStack[BaseVarType.scriptStringStackSize];
                                                                                                               var55 = class83.scriptStringStack[BaseVarType.scriptStringStackSize + 1];
                                                                                                               if(Script.localPlayer.composition != null && Script.localPlayer.composition.isFemale) {
                                                                                                                  class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = var55;
                                                                                                               } else {
                                                                                                                  class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = var73;
                                                                                                               }

                                                                                                               var15 = 1;
                                                                                                            } else if(var9 == 4106) {
                                                                                                               var16 = class83.intStack[--WorldMapType2.intStackSize];
                                                                                                               class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = Integer.toString(var16);
                                                                                                               var15 = 1;
                                                                                                            } else if(var9 == 4107) {
                                                                                                               BaseVarType.scriptStringStackSize -= 2;
                                                                                                               var87 = class83.intStack;
                                                                                                               var29 = ++WorldMapType2.intStackSize - 1;
                                                                                                               var30 = Projectile.method1742(class83.scriptStringStack[BaseVarType.scriptStringStackSize], class83.scriptStringStack[BaseVarType.scriptStringStackSize + 1], Client.languageId);
                                                                                                               byte var70;
                                                                                                               if(var30 > 0) {
                                                                                                                  var70 = 1;
                                                                                                               } else if(var30 < 0) {
                                                                                                                  var70 = -1;
                                                                                                               } else {
                                                                                                                  var70 = 0;
                                                                                                               }

                                                                                                               var87[var29] = var70;
                                                                                                               var15 = 1;
                                                                                                            } else {
                                                                                                               byte[] var61;
                                                                                                               Font var94;
                                                                                                               if(var9 == 4108) {
                                                                                                                  var73 = class83.scriptStringStack[--BaseVarType.scriptStringStackSize];
                                                                                                                  WorldMapType2.intStackSize -= 2;
                                                                                                                  var29 = class83.intStack[WorldMapType2.intStackSize];
                                                                                                                  var18 = class83.intStack[WorldMapType2.intStackSize + 1];
                                                                                                                  var61 = Player.field881.getConfigData(var18, 0);
                                                                                                                  var94 = new Font(var61);
                                                                                                                  class83.intStack[++WorldMapType2.intStackSize - 1] = var94.method4675(var73, var29);
                                                                                                                  var15 = 1;
                                                                                                               } else if(var9 == 4109) {
                                                                                                                  var73 = class83.scriptStringStack[--BaseVarType.scriptStringStackSize];
                                                                                                                  WorldMapType2.intStackSize -= 2;
                                                                                                                  var29 = class83.intStack[WorldMapType2.intStackSize];
                                                                                                                  var18 = class83.intStack[WorldMapType2.intStackSize + 1];
                                                                                                                  var61 = Player.field881.getConfigData(var18, 0);
                                                                                                                  var94 = new Font(var61);
                                                                                                                  class83.intStack[++WorldMapType2.intStackSize - 1] = var94.method4674(var73, var29);
                                                                                                                  var15 = 1;
                                                                                                               } else if(var9 == 4110) {
                                                                                                                  BaseVarType.scriptStringStackSize -= 2;
                                                                                                                  var73 = class83.scriptStringStack[BaseVarType.scriptStringStackSize];
                                                                                                                  var55 = class83.scriptStringStack[BaseVarType.scriptStringStackSize + 1];
                                                                                                                  if(class83.intStack[--WorldMapType2.intStackSize] == 1) {
                                                                                                                     class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = var73;
                                                                                                                  } else {
                                                                                                                     class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = var55;
                                                                                                                  }

                                                                                                                  var15 = 1;
                                                                                                               } else if(var9 == 4111) {
                                                                                                                  var73 = class83.scriptStringStack[--BaseVarType.scriptStringStackSize];
                                                                                                                  class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = FontTypeFace.appendTags(var73);
                                                                                                                  var15 = 1;
                                                                                                               } else if(var9 == 4112) {
                                                                                                                  var73 = class83.scriptStringStack[--BaseVarType.scriptStringStackSize];
                                                                                                                  var29 = class83.intStack[--WorldMapType2.intStackSize];
                                                                                                                  class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = var73 + (char)var29;
                                                                                                                  var15 = 1;
                                                                                                               } else if(var9 == 4113) {
                                                                                                                  var16 = class83.intStack[--WorldMapType2.intStackSize];
                                                                                                                  class83.intStack[++WorldMapType2.intStackSize - 1] = Permission.method4073((char)var16)?1:0;
                                                                                                                  var15 = 1;
                                                                                                               } else {
                                                                                                                  char var59;
                                                                                                                  boolean var81;
                                                                                                                  if(var9 == 4114) {
                                                                                                                     var16 = class83.intStack[--WorldMapType2.intStackSize];
                                                                                                                     var17 = class83.intStack;
                                                                                                                     var18 = ++WorldMapType2.intStackSize - 1;
                                                                                                                     var59 = (char)var16;
                                                                                                                     var81 = var59 >= 48 && var59 <= 57 || var59 >= 65 && var59 <= 90 || var59 >= 97 && var59 <= 122;
                                                                                                                     var17[var18] = var81?1:0;
                                                                                                                     var15 = 1;
                                                                                                                  } else if(var9 == 4115) {
                                                                                                                     var16 = class83.intStack[--WorldMapType2.intStackSize];
                                                                                                                     var17 = class83.intStack;
                                                                                                                     var18 = ++WorldMapType2.intStackSize - 1;
                                                                                                                     var59 = (char)var16;
                                                                                                                     var81 = var59 >= 65 && var59 <= 90 || var59 >= 97 && var59 <= 122;
                                                                                                                     var17[var18] = var81?1:0;
                                                                                                                     var15 = 1;
                                                                                                                  } else if(var9 == 4116) {
                                                                                                                     var16 = class83.intStack[--WorldMapType2.intStackSize];
                                                                                                                     class83.intStack[++WorldMapType2.intStackSize - 1] = Huffman.method3068((char)var16)?1:0;
                                                                                                                     var15 = 1;
                                                                                                                  } else if(var9 == 4117) {
                                                                                                                     var73 = class83.scriptStringStack[--BaseVarType.scriptStringStackSize];
                                                                                                                     if(var73 != null) {
                                                                                                                        class83.intStack[++WorldMapType2.intStackSize - 1] = var73.length();
                                                                                                                     } else {
                                                                                                                        class83.intStack[++WorldMapType2.intStackSize - 1] = 0;
                                                                                                                     }

                                                                                                                     var15 = 1;
                                                                                                                  } else if(var9 == 4118) {
                                                                                                                     var73 = class83.scriptStringStack[--BaseVarType.scriptStringStackSize];
                                                                                                                     WorldMapType2.intStackSize -= 2;
                                                                                                                     var29 = class83.intStack[WorldMapType2.intStackSize];
                                                                                                                     var18 = class83.intStack[WorldMapType2.intStackSize + 1];
                                                                                                                     class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = var73.substring(var29, var18);
                                                                                                                     var15 = 1;
                                                                                                                  } else if(var9 != 4119) {
                                                                                                                     if(var9 == 4120) {
                                                                                                                        var73 = class83.scriptStringStack[--BaseVarType.scriptStringStackSize];
                                                                                                                        var29 = class83.intStack[--WorldMapType2.intStackSize];
                                                                                                                        class83.intStack[++WorldMapType2.intStackSize - 1] = var73.indexOf(var29);
                                                                                                                        var15 = 1;
                                                                                                                     } else if(var9 == 4121) {
                                                                                                                        BaseVarType.scriptStringStackSize -= 2;
                                                                                                                        var73 = class83.scriptStringStack[BaseVarType.scriptStringStackSize];
                                                                                                                        var55 = class83.scriptStringStack[BaseVarType.scriptStringStackSize + 1];
                                                                                                                        var18 = class83.intStack[--WorldMapType2.intStackSize];
                                                                                                                        class83.intStack[++WorldMapType2.intStackSize - 1] = var73.indexOf(var55, var18);
                                                                                                                        var15 = 1;
                                                                                                                     } else {
                                                                                                                        var15 = 2;
                                                                                                                     }
                                                                                                                  } else {
                                                                                                                     var73 = class83.scriptStringStack[--BaseVarType.scriptStringStackSize];
                                                                                                                     StringBuilder var56 = new StringBuilder(var73.length());
                                                                                                                     boolean var63 = false;

                                                                                                                     for(var30 = 0; var30 < var73.length(); ++var30) {
                                                                                                                        var59 = var73.charAt(var30);
                                                                                                                        if(var59 == 60) {
                                                                                                                           var63 = true;
                                                                                                                        } else if(var59 == 62) {
                                                                                                                           var63 = false;
                                                                                                                        } else if(!var63) {
                                                                                                                           var56.append(var59);
                                                                                                                        }
                                                                                                                     }

                                                                                                                     class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = var56.toString();
                                                                                                                     var15 = 1;
                                                                                                                  }
                                                                                                               }
                                                                                                            }

                                                                                                            var14 = var15;
                                                                                                         } else if(var9 < 4300) {
                                                                                                            var14 = class56.method827(var9, var3, var78);
                                                                                                         } else if(var9 < 5100) {
                                                                                                            if(var9 == 5000) {
                                                                                                               class83.intStack[++WorldMapType2.intStackSize - 1] = Client.field1060;
                                                                                                               var15 = 1;
                                                                                                            } else if(var9 == 5001) {
                                                                                                               WorldMapType2.intStackSize -= 3;
                                                                                                               Client.field1060 = class83.intStack[WorldMapType2.intStackSize];
                                                                                                               var29 = class83.intStack[WorldMapType2.intStackSize + 1];
                                                                                                               class276[] var84 = new class276[]{class276.field3732, class276.field3730, class276.field3734};
                                                                                                               class276[] var64 = var84;
                                                                                                               var20 = 0;

                                                                                                               class276 var96;
                                                                                                               while(true) {
                                                                                                                  if(var20 >= var64.length) {
                                                                                                                     var96 = null;
                                                                                                                     break;
                                                                                                                  }

                                                                                                                  class276 var68 = var64[var20];
                                                                                                                  if(var29 == var68.field3731) {
                                                                                                                     var96 = var68;
                                                                                                                     break;
                                                                                                                  }

                                                                                                                  ++var20;
                                                                                                               }

                                                                                                               MouseInput.field732 = var96;
                                                                                                               if(MouseInput.field732 == null) {
                                                                                                                  MouseInput.field732 = class276.field3734;
                                                                                                               }

                                                                                                               Client.field1123 = class83.intStack[WorldMapType2.intStackSize + 2];
                                                                                                               Client.secretPacketBuffer1.putOpcode(153);
                                                                                                               Client.secretPacketBuffer1.putByte(Client.field1060);
                                                                                                               Client.secretPacketBuffer1.putByte(MouseInput.field732.field3731);
                                                                                                               Client.secretPacketBuffer1.putByte(Client.field1123);
                                                                                                               var15 = 1;
                                                                                                            } else if(var9 == 5002) {
                                                                                                               var73 = class83.scriptStringStack[--BaseVarType.scriptStringStackSize];
                                                                                                               WorldMapType2.intStackSize -= 2;
                                                                                                               var29 = class83.intStack[WorldMapType2.intStackSize];
                                                                                                               var18 = class83.intStack[WorldMapType2.intStackSize + 1];
                                                                                                               Client.secretPacketBuffer1.putOpcode(166);
                                                                                                               Client.secretPacketBuffer1.putByte(DecorativeObject.getLength(var73) + 2);
                                                                                                               Client.secretPacketBuffer1.putString(var73);
                                                                                                               Client.secretPacketBuffer1.putByte(var29 - 1);
                                                                                                               Client.secretPacketBuffer1.putByte(var18);
                                                                                                               var15 = 1;
                                                                                                            } else if(var9 == 5003) {
                                                                                                               WorldMapType2.intStackSize -= 2;
                                                                                                               var16 = class83.intStack[WorldMapType2.intStackSize];
                                                                                                               var29 = class83.intStack[WorldMapType2.intStackSize + 1];
                                                                                                               MessageNode var83 = class67.method1087(var16, var29);
                                                                                                               if(var83 != null) {
                                                                                                                  class83.intStack[++WorldMapType2.intStackSize - 1] = var83.id;
                                                                                                                  class83.intStack[++WorldMapType2.intStackSize - 1] = var83.tick;
                                                                                                                  class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = var83.name != null?var83.name:"";
                                                                                                                  class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = var83.sender != null?var83.sender:"";
                                                                                                                  class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = var83.value != null?var83.value:"";
                                                                                                               } else {
                                                                                                                  class83.intStack[++WorldMapType2.intStackSize - 1] = -1;
                                                                                                                  class83.intStack[++WorldMapType2.intStackSize - 1] = 0;
                                                                                                                  class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = "";
                                                                                                                  class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = "";
                                                                                                                  class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = "";
                                                                                                               }

                                                                                                               var15 = 1;
                                                                                                            } else if(var9 == 5004) {
                                                                                                               var16 = class83.intStack[--WorldMapType2.intStackSize];
                                                                                                               MessageNode var60 = AbstractSoundSystem.method2025(var16);
                                                                                                               if(var60 != null) {
                                                                                                                  class83.intStack[++WorldMapType2.intStackSize - 1] = var60.type;
                                                                                                                  class83.intStack[++WorldMapType2.intStackSize - 1] = var60.tick;
                                                                                                                  class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = var60.name != null?var60.name:"";
                                                                                                                  class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = var60.sender != null?var60.sender:"";
                                                                                                                  class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = var60.value != null?var60.value:"";
                                                                                                               } else {
                                                                                                                  class83.intStack[++WorldMapType2.intStackSize - 1] = -1;
                                                                                                                  class83.intStack[++WorldMapType2.intStackSize - 1] = 0;
                                                                                                                  class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = "";
                                                                                                                  class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = "";
                                                                                                                  class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = "";
                                                                                                               }

                                                                                                               var15 = 1;
                                                                                                            } else if(var9 == 5005) {
                                                                                                               if(MouseInput.field732 == null) {
                                                                                                                  class83.intStack[++WorldMapType2.intStackSize - 1] = -1;
                                                                                                               } else {
                                                                                                                  class83.intStack[++WorldMapType2.intStackSize - 1] = MouseInput.field732.field3731;
                                                                                                               }

                                                                                                               var15 = 1;
                                                                                                            } else if(var9 == 5008) {
                                                                                                               var73 = class83.scriptStringStack[--BaseVarType.scriptStringStackSize];
                                                                                                               var29 = class83.intStack[--WorldMapType2.intStackSize];
                                                                                                               String var82 = var73.toLowerCase();
                                                                                                               byte var85 = 0;
                                                                                                               if(var82.startsWith("yellow:")) {
                                                                                                                  var85 = 0;
                                                                                                                  var73 = var73.substring("yellow:".length());
                                                                                                               } else if(var82.startsWith("red:")) {
                                                                                                                  var85 = 1;
                                                                                                                  var73 = var73.substring("red:".length());
                                                                                                               } else if(var82.startsWith("green:")) {
                                                                                                                  var85 = 2;
                                                                                                                  var73 = var73.substring("green:".length());
                                                                                                               } else if(var82.startsWith("cyan:")) {
                                                                                                                  var85 = 3;
                                                                                                                  var73 = var73.substring("cyan:".length());
                                                                                                               } else if(var82.startsWith("purple:")) {
                                                                                                                  var85 = 4;
                                                                                                                  var73 = var73.substring("purple:".length());
                                                                                                               } else if(var82.startsWith("white:")) {
                                                                                                                  var85 = 5;
                                                                                                                  var73 = var73.substring("white:".length());
                                                                                                               } else if(var82.startsWith("flash1:")) {
                                                                                                                  var85 = 6;
                                                                                                                  var73 = var73.substring("flash1:".length());
                                                                                                               } else if(var82.startsWith("flash2:")) {
                                                                                                                  var85 = 7;
                                                                                                                  var73 = var73.substring("flash2:".length());
                                                                                                               } else if(var82.startsWith("flash3:")) {
                                                                                                                  var85 = 8;
                                                                                                                  var73 = var73.substring("flash3:".length());
                                                                                                               } else if(var82.startsWith("glow1:")) {
                                                                                                                  var85 = 9;
                                                                                                                  var73 = var73.substring("glow1:".length());
                                                                                                               } else if(var82.startsWith("glow2:")) {
                                                                                                                  var85 = 10;
                                                                                                                  var73 = var73.substring("glow2:".length());
                                                                                                               } else if(var82.startsWith("glow3:")) {
                                                                                                                  var85 = 11;
                                                                                                                  var73 = var73.substring("glow3:".length());
                                                                                                               } else if(Client.languageId != 0) {
                                                                                                                  if(var82.startsWith("yellow:")) {
                                                                                                                     var85 = 0;
                                                                                                                     var73 = var73.substring("yellow:".length());
                                                                                                                  } else if(var82.startsWith("red:")) {
                                                                                                                     var85 = 1;
                                                                                                                     var73 = var73.substring("red:".length());
                                                                                                                  } else if(var82.startsWith("green:")) {
                                                                                                                     var85 = 2;
                                                                                                                     var73 = var73.substring("green:".length());
                                                                                                                  } else if(var82.startsWith("cyan:")) {
                                                                                                                     var85 = 3;
                                                                                                                     var73 = var73.substring("cyan:".length());
                                                                                                                  } else if(var82.startsWith("purple:")) {
                                                                                                                     var85 = 4;
                                                                                                                     var73 = var73.substring("purple:".length());
                                                                                                                  } else if(var82.startsWith("white:")) {
                                                                                                                     var85 = 5;
                                                                                                                     var73 = var73.substring("white:".length());
                                                                                                                  } else if(var82.startsWith("flash1:")) {
                                                                                                                     var85 = 6;
                                                                                                                     var73 = var73.substring("flash1:".length());
                                                                                                                  } else if(var82.startsWith("flash2:")) {
                                                                                                                     var85 = 7;
                                                                                                                     var73 = var73.substring("flash2:".length());
                                                                                                                  } else if(var82.startsWith("flash3:")) {
                                                                                                                     var85 = 8;
                                                                                                                     var73 = var73.substring("flash3:".length());
                                                                                                                  } else if(var82.startsWith("glow1:")) {
                                                                                                                     var85 = 9;
                                                                                                                     var73 = var73.substring("glow1:".length());
                                                                                                                  } else if(var82.startsWith("glow2:")) {
                                                                                                                     var85 = 10;
                                                                                                                     var73 = var73.substring("glow2:".length());
                                                                                                                  } else if(var82.startsWith("glow3:")) {
                                                                                                                     var85 = 11;
                                                                                                                     var73 = var73.substring("glow3:".length());
                                                                                                                  }
                                                                                                               }

                                                                                                               var82 = var73.toLowerCase();
                                                                                                               byte var66 = 0;
                                                                                                               if(var82.startsWith("wave:")) {
                                                                                                                  var66 = 1;
                                                                                                                  var73 = var73.substring("wave:".length());
                                                                                                               } else if(var82.startsWith("wave2:")) {
                                                                                                                  var66 = 2;
                                                                                                                  var73 = var73.substring("wave2:".length());
                                                                                                               } else if(var82.startsWith("shake:")) {
                                                                                                                  var66 = 3;
                                                                                                                  var73 = var73.substring("shake:".length());
                                                                                                               } else if(var82.startsWith("scroll:")) {
                                                                                                                  var66 = 4;
                                                                                                                  var73 = var73.substring("scroll:".length());
                                                                                                               } else if(var82.startsWith("slide:")) {
                                                                                                                  var66 = 5;
                                                                                                                  var73 = var73.substring("slide:".length());
                                                                                                               } else if(Client.languageId != 0) {
                                                                                                                  if(var82.startsWith("wave:")) {
                                                                                                                     var66 = 1;
                                                                                                                     var73 = var73.substring("wave:".length());
                                                                                                                  } else if(var82.startsWith("wave2:")) {
                                                                                                                     var66 = 2;
                                                                                                                     var73 = var73.substring("wave2:".length());
                                                                                                                  } else if(var82.startsWith("shake:")) {
                                                                                                                     var66 = 3;
                                                                                                                     var73 = var73.substring("shake:".length());
                                                                                                                  } else if(var82.startsWith("scroll:")) {
                                                                                                                     var66 = 4;
                                                                                                                     var73 = var73.substring("scroll:".length());
                                                                                                                  } else if(var82.startsWith("slide:")) {
                                                                                                                     var66 = 5;
                                                                                                                     var73 = var73.substring("slide:".length());
                                                                                                                  }
                                                                                                               }

                                                                                                               Client.secretPacketBuffer1.putOpcode(174);
                                                                                                               Client.secretPacketBuffer1.putByte(0);
                                                                                                               var35 = Client.secretPacketBuffer1.offset;
                                                                                                               Client.secretPacketBuffer1.putByte(var29);
                                                                                                               Client.secretPacketBuffer1.putByte(var85);
                                                                                                               Client.secretPacketBuffer1.putByte(var66);
                                                                                                               PacketBuffer var22 = Client.secretPacketBuffer1;
                                                                                                               int var23 = var22.offset;
                                                                                                               byte[] var24 = class45.method668(var73);
                                                                                                               var22.putShortSmart(var24.length);
                                                                                                               var22.offset += class265.field3657.compress(var24, 0, var24.length, var22.payload, var22.offset);
                                                                                                               Client.secretPacketBuffer1.putLength(Client.secretPacketBuffer1.offset - var35);
                                                                                                               var15 = 1;
                                                                                                            } else if(var9 == 5009) {
                                                                                                               BaseVarType.scriptStringStackSize -= 2;
                                                                                                               var73 = class83.scriptStringStack[BaseVarType.scriptStringStackSize];
                                                                                                               var55 = class83.scriptStringStack[BaseVarType.scriptStringStackSize + 1];
                                                                                                               Client.secretPacketBuffer1.putOpcode(246);
                                                                                                               Client.secretPacketBuffer1.putShort(0);
                                                                                                               var18 = Client.secretPacketBuffer1.offset;
                                                                                                               Client.secretPacketBuffer1.putString(var73);
                                                                                                               PacketBuffer var62 = Client.secretPacketBuffer1;
                                                                                                               var20 = var62.offset;
                                                                                                               byte[] var65 = class45.method668(var55);
                                                                                                               var62.putShortSmart(var65.length);
                                                                                                               var62.offset += class265.field3657.compress(var65, 0, var65.length, var62.payload, var62.offset);
                                                                                                               Client.secretPacketBuffer1.putShortLength(Client.secretPacketBuffer1.offset - var18);
                                                                                                               var15 = 1;
                                                                                                            } else if(var9 != 5015) {
                                                                                                               if(var9 == 5016) {
                                                                                                                  class83.intStack[++WorldMapType2.intStackSize - 1] = Client.field1123;
                                                                                                                  var15 = 1;
                                                                                                               } else if(var9 == 5017) {
                                                                                                                  var16 = class83.intStack[--WorldMapType2.intStackSize];
                                                                                                                  class83.intStack[++WorldMapType2.intStackSize - 1] = class217.method4042(var16);
                                                                                                                  var15 = 1;
                                                                                                               } else if(var9 == 5018) {
                                                                                                                  var16 = class83.intStack[--WorldMapType2.intStackSize];
                                                                                                                  class83.intStack[++WorldMapType2.intStackSize - 1] = class40.method550(var16);
                                                                                                                  var15 = 1;
                                                                                                               } else if(var9 == 5019) {
                                                                                                                  var16 = class83.intStack[--WorldMapType2.intStackSize];
                                                                                                                  class83.intStack[++WorldMapType2.intStackSize - 1] = FrameMap.method2663(var16);
                                                                                                                  var15 = 1;
                                                                                                               } else if(var9 == 5020) {
                                                                                                                  var73 = class83.scriptStringStack[--BaseVarType.scriptStringStackSize];
                                                                                                                  if(var73.equalsIgnoreCase("toggleroof")) {
                                                                                                                     class23.preferences.hideRoofs = !class23.preferences.hideRoofs;
                                                                                                                     PendingSpawn.method1475();
                                                                                                                     if(class23.preferences.hideRoofs) {
                                                                                                                        WidgetNode.sendGameMessage(99, "", "Roofs are now all hidden");
                                                                                                                     } else {
                                                                                                                        WidgetNode.sendGameMessage(99, "", "Roofs will only be removed selectively");
                                                                                                                     }
                                                                                                                  }

                                                                                                                  if(var73.equalsIgnoreCase("displayfps")) {
                                                                                                                     Client.displayFps = !Client.displayFps;
                                                                                                                  }

                                                                                                                  if(var73.equalsIgnoreCase("clickbox")) {
                                                                                                                     Model.field1978 = !Model.field1978;
                                                                                                                     WidgetNode.sendGameMessage(99, "", "Clickbox Mode: " + (Model.field1978?"AABB":"Legacy"));
                                                                                                                  }

                                                                                                                  if(Client.rights >= 2) {
                                                                                                                     if(var73.equalsIgnoreCase("aabb")) {
                                                                                                                        if(!class7.field232) {
                                                                                                                           class7.field232 = true;
                                                                                                                           class7.field229 = class11.field270;
                                                                                                                           WidgetNode.sendGameMessage(99, "", "AABB boxes: All");
                                                                                                                        } else if(class7.field229 == class11.field270) {
                                                                                                                           class7.field232 = true;
                                                                                                                           class7.field229 = class11.field273;
                                                                                                                           WidgetNode.sendGameMessage(99, "", "AABB boxes: Mouse Over");
                                                                                                                        } else {
                                                                                                                           class7.field232 = false;
                                                                                                                           WidgetNode.sendGameMessage(99, "", "AABB boxes: Off");
                                                                                                                        }
                                                                                                                     }

                                                                                                                     if(var73.equalsIgnoreCase("legacyboxes")) {
                                                                                                                        class7.field227 = !class7.field227;
                                                                                                                        WidgetNode.sendGameMessage(99, "", "Show legacy boxes: " + class7.field227);
                                                                                                                     }

                                                                                                                     if(var73.equalsIgnoreCase("geotests")) {
                                                                                                                        class7.field228 = !class7.field228;
                                                                                                                        WidgetNode.sendGameMessage(99, "", "Show geometry tests: " + class7.field228);
                                                                                                                     }

                                                                                                                     if(var73.equalsIgnoreCase("fpson")) {
                                                                                                                        Client.displayFps = true;
                                                                                                                     }

                                                                                                                     if(var73.equalsIgnoreCase("fpsoff")) {
                                                                                                                        Client.displayFps = false;
                                                                                                                     }

                                                                                                                     if(var73.equalsIgnoreCase("gc")) {
                                                                                                                        System.gc();
                                                                                                                     }

                                                                                                                     if(var73.equalsIgnoreCase("clientdrop")) {
                                                                                                                        if(Client.field958 > 0) {
                                                                                                                           class207.method3867();
                                                                                                                        } else {
                                                                                                                           WorldMapType2.setGameState(40);
                                                                                                                           class261.field3623 = Occluder.rssocket;
                                                                                                                           Occluder.rssocket = null;
                                                                                                                        }
                                                                                                                     }

                                                                                                                     if(var73.equalsIgnoreCase("errortest") && Client.socketType == 2) {
                                                                                                                        throw new RuntimeException();
                                                                                                                     }
                                                                                                                  }

                                                                                                                  Client.secretPacketBuffer1.putOpcode(255);
                                                                                                                  Client.secretPacketBuffer1.putByte(var73.length() + 1);
                                                                                                                  Client.secretPacketBuffer1.putString(var73);
                                                                                                                  var15 = 1;
                                                                                                               } else if(var9 == 5021) {
                                                                                                                  Client.field1124 = class83.scriptStringStack[--BaseVarType.scriptStringStackSize].toLowerCase().trim();
                                                                                                                  var15 = 1;
                                                                                                               } else if(var9 == 5022) {
                                                                                                                  class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = Client.field1124;
                                                                                                                  var15 = 1;
                                                                                                               } else {
                                                                                                                  var15 = 2;
                                                                                                               }
                                                                                                            } else {
                                                                                                               if(Script.localPlayer != null && Script.localPlayer.name != null) {
                                                                                                                  var73 = Script.localPlayer.name;
                                                                                                               } else {
                                                                                                                  var73 = "";
                                                                                                               }

                                                                                                               class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = var73;
                                                                                                               var15 = 1;
                                                                                                            }

                                                                                                            var14 = var15;
                                                                                                         } else if(var9 < 5400) {
                                                                                                            var14 = class47.method715(var9, var3, var78);
                                                                                                         } else if(var9 < 5600) {
                                                                                                            var14 = class12.method69(var9, var3, var78);
                                                                                                         } else if(var9 < 5700) {
                                                                                                            if(var9 == 5630) {
                                                                                                               Client.field958 = 250;
                                                                                                               var15 = 1;
                                                                                                            } else {
                                                                                                               var15 = 2;
                                                                                                            }

                                                                                                            var14 = var15;
                                                                                                         } else if(var9 < 6300) {
                                                                                                            var14 = SceneTilePaint.method2662(var9, var3, var78);
                                                                                                         } else if(var9 < 6600) {
                                                                                                            var14 = MessageNode.method1107(var9, var3, var78);
                                                                                                         } else if(var9 < 6700) {
                                                                                                            if(var9 == 6600) {
                                                                                                               var16 = class45.plane;
                                                                                                               var29 = (Script.localPlayer.x >> 7) + class163.baseX;
                                                                                                               var18 = (Script.localPlayer.y >> 7) + class10.baseY;
                                                                                                               class39.method548().method5115(var16, var29, var18, true);
                                                                                                               var15 = 1;
                                                                                                            } else {
                                                                                                               WorldMapData var86;
                                                                                                               if(var9 == 6601) {
                                                                                                                  var16 = class83.intStack[--WorldMapType2.intStackSize];
                                                                                                                  var55 = "";
                                                                                                                  var86 = class39.method548().method5107(var16);
                                                                                                                  if(var86 != null) {
                                                                                                                     var55 = var86.method301();
                                                                                                                  }

                                                                                                                  class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = var55;
                                                                                                                  var15 = 1;
                                                                                                               } else if(var9 == 6602) {
                                                                                                                  var16 = class83.intStack[--WorldMapType2.intStackSize];
                                                                                                                  class39.method548().method5116(var16);
                                                                                                                  var15 = 1;
                                                                                                               } else if(var9 == 6603) {
                                                                                                                  class83.intStack[++WorldMapType2.intStackSize - 1] = class39.method548().method5128();
                                                                                                                  var15 = 1;
                                                                                                               } else if(var9 == 6604) {
                                                                                                                  var16 = class83.intStack[--WorldMapType2.intStackSize];
                                                                                                                  class39.method548().method5125(var16);
                                                                                                                  var15 = 1;
                                                                                                               } else if(var9 == 6605) {
                                                                                                                  class83.intStack[++WorldMapType2.intStackSize - 1] = class39.method548().method5155()?1:0;
                                                                                                                  var15 = 1;
                                                                                                               } else {
                                                                                                                  Coordinates var97;
                                                                                                                  if(var9 == 6606) {
                                                                                                                     var97 = new Coordinates(class83.intStack[--WorldMapType2.intStackSize]);
                                                                                                                     class39.method548().method5182(var97.worldX, var97.worldY);
                                                                                                                     var15 = 1;
                                                                                                                  } else if(var9 == 6607) {
                                                                                                                     var97 = new Coordinates(class83.intStack[--WorldMapType2.intStackSize]);
                                                                                                                     class39.method548().method5224(var97.worldX, var97.worldY);
                                                                                                                     var15 = 1;
                                                                                                                  } else if(var9 == 6608) {
                                                                                                                     var97 = new Coordinates(class83.intStack[--WorldMapType2.intStackSize]);
                                                                                                                     class39.method548().method5134(var97.plane, var97.worldX, var97.worldY);
                                                                                                                     var15 = 1;
                                                                                                                  } else if(var9 == 6609) {
                                                                                                                     var97 = new Coordinates(class83.intStack[--WorldMapType2.intStackSize]);
                                                                                                                     class39.method548().method5135(var97.plane, var97.worldX, var97.worldY);
                                                                                                                     var15 = 1;
                                                                                                                  } else if(var9 == 6610) {
                                                                                                                     class83.intStack[++WorldMapType2.intStackSize - 1] = class39.method548().method5136();
                                                                                                                     class83.intStack[++WorldMapType2.intStackSize - 1] = class39.method548().method5137();
                                                                                                                     var15 = 1;
                                                                                                                  } else {
                                                                                                                     WorldMapData var67;
                                                                                                                     if(var9 == 6611) {
                                                                                                                        var16 = class83.intStack[--WorldMapType2.intStackSize];
                                                                                                                        var67 = class39.method548().method5107(var16);
                                                                                                                        if(var67 == null) {
                                                                                                                           class83.intStack[++WorldMapType2.intStackSize - 1] = 0;
                                                                                                                        } else {
                                                                                                                           class83.intStack[++WorldMapType2.intStackSize - 1] = var67.method298().method3915();
                                                                                                                        }

                                                                                                                        var15 = 1;
                                                                                                                     } else if(var9 == 6612) {
                                                                                                                        var16 = class83.intStack[--WorldMapType2.intStackSize];
                                                                                                                        var67 = class39.method548().method5107(var16);
                                                                                                                        if(var67 == null) {
                                                                                                                           class83.intStack[++WorldMapType2.intStackSize - 1] = 0;
                                                                                                                           class83.intStack[++WorldMapType2.intStackSize - 1] = 0;
                                                                                                                        } else {
                                                                                                                           class83.intStack[++WorldMapType2.intStackSize - 1] = (var67.method277() - var67.method291() + 1) * 64;
                                                                                                                           class83.intStack[++WorldMapType2.intStackSize - 1] = (var67.method279() - var67.method292() + 1) * 64;
                                                                                                                        }

                                                                                                                        var15 = 1;
                                                                                                                     } else if(var9 == 6613) {
                                                                                                                        var16 = class83.intStack[--WorldMapType2.intStackSize];
                                                                                                                        var67 = class39.method548().method5107(var16);
                                                                                                                        if(var67 == null) {
                                                                                                                           class83.intStack[++WorldMapType2.intStackSize - 1] = 0;
                                                                                                                           class83.intStack[++WorldMapType2.intStackSize - 1] = 0;
                                                                                                                           class83.intStack[++WorldMapType2.intStackSize - 1] = 0;
                                                                                                                           class83.intStack[++WorldMapType2.intStackSize - 1] = 0;
                                                                                                                        } else {
                                                                                                                           class83.intStack[++WorldMapType2.intStackSize - 1] = var67.method291() * 64;
                                                                                                                           class83.intStack[++WorldMapType2.intStackSize - 1] = var67.method292() * 64;
                                                                                                                           class83.intStack[++WorldMapType2.intStackSize - 1] = var67.method277() * 64 + 64 - 1;
                                                                                                                           class83.intStack[++WorldMapType2.intStackSize - 1] = var67.method279() * 64 + 64 - 1;
                                                                                                                        }

                                                                                                                        var15 = 1;
                                                                                                                     } else if(var9 == 6614) {
                                                                                                                        var16 = class83.intStack[--WorldMapType2.intStackSize];
                                                                                                                        var67 = class39.method548().method5107(var16);
                                                                                                                        if(var67 == null) {
                                                                                                                           class83.intStack[++WorldMapType2.intStackSize - 1] = -1;
                                                                                                                        } else {
                                                                                                                           class83.intStack[++WorldMapType2.intStackSize - 1] = var67.method282();
                                                                                                                        }

                                                                                                                        var15 = 1;
                                                                                                                     } else if(var9 == 6615) {
                                                                                                                        var97 = class39.method548().method5138();
                                                                                                                        if(var97 == null) {
                                                                                                                           class83.intStack[++WorldMapType2.intStackSize - 1] = -1;
                                                                                                                           class83.intStack[++WorldMapType2.intStackSize - 1] = -1;
                                                                                                                        } else {
                                                                                                                           class83.intStack[++WorldMapType2.intStackSize - 1] = var97.worldX;
                                                                                                                           class83.intStack[++WorldMapType2.intStackSize - 1] = var97.worldY;
                                                                                                                        }

                                                                                                                        var15 = 1;
                                                                                                                     } else if(var9 == 6616) {
                                                                                                                        class83.intStack[++WorldMapType2.intStackSize - 1] = class39.method548().method5117();
                                                                                                                        var15 = 1;
                                                                                                                     } else if(var9 == 6617) {
                                                                                                                        var97 = new Coordinates(class83.intStack[--WorldMapType2.intStackSize]);
                                                                                                                        var67 = class39.method548().method5250();
                                                                                                                        if(var67 == null) {
                                                                                                                           class83.intStack[++WorldMapType2.intStackSize - 1] = -1;
                                                                                                                           class83.intStack[++WorldMapType2.intStackSize - 1] = -1;
                                                                                                                           var15 = 1;
                                                                                                                        } else {
                                                                                                                           int[] var88 = var67.method331(var97.plane, var97.worldX, var97.worldY);
                                                                                                                           if(var88 == null) {
                                                                                                                              class83.intStack[++WorldMapType2.intStackSize - 1] = -1;
                                                                                                                              class83.intStack[++WorldMapType2.intStackSize - 1] = -1;
                                                                                                                           } else {
                                                                                                                              class83.intStack[++WorldMapType2.intStackSize - 1] = var88[0];
                                                                                                                              class83.intStack[++WorldMapType2.intStackSize - 1] = var88[1];
                                                                                                                           }

                                                                                                                           var15 = 1;
                                                                                                                        }
                                                                                                                     } else {
                                                                                                                        Coordinates var89;
                                                                                                                        if(var9 == 6618) {
                                                                                                                           var97 = new Coordinates(class83.intStack[--WorldMapType2.intStackSize]);
                                                                                                                           var67 = class39.method548().method5250();
                                                                                                                           if(var67 == null) {
                                                                                                                              class83.intStack[++WorldMapType2.intStackSize - 1] = -1;
                                                                                                                              class83.intStack[++WorldMapType2.intStackSize - 1] = -1;
                                                                                                                              var15 = 1;
                                                                                                                           } else {
                                                                                                                              var89 = var67.method283(var97.worldX, var97.worldY);
                                                                                                                              if(var89 == null) {
                                                                                                                                 class83.intStack[++WorldMapType2.intStackSize - 1] = -1;
                                                                                                                              } else {
                                                                                                                                 class83.intStack[++WorldMapType2.intStackSize - 1] = var89.method3915();
                                                                                                                              }

                                                                                                                              var15 = 1;
                                                                                                                           }
                                                                                                                        } else {
                                                                                                                           Coordinates var69;
                                                                                                                           if(var9 == 6619) {
                                                                                                                              WorldMapType2.intStackSize -= 2;
                                                                                                                              var16 = class83.intStack[WorldMapType2.intStackSize];
                                                                                                                              var69 = new Coordinates(class83.intStack[WorldMapType2.intStackSize + 1]);
                                                                                                                              class21.method151(var16, var69, false);
                                                                                                                              var15 = 1;
                                                                                                                           } else if(var9 == 6620) {
                                                                                                                              WorldMapType2.intStackSize -= 2;
                                                                                                                              var16 = class83.intStack[WorldMapType2.intStackSize];
                                                                                                                              var69 = new Coordinates(class83.intStack[WorldMapType2.intStackSize + 1]);
                                                                                                                              class21.method151(var16, var69, true);
                                                                                                                              var15 = 1;
                                                                                                                           } else if(var9 == 6621) {
                                                                                                                              WorldMapType2.intStackSize -= 2;
                                                                                                                              var16 = class83.intStack[WorldMapType2.intStackSize];
                                                                                                                              var69 = new Coordinates(class83.intStack[WorldMapType2.intStackSize + 1]);
                                                                                                                              var86 = class39.method548().method5107(var16);
                                                                                                                              if(var86 == null) {
                                                                                                                                 class83.intStack[++WorldMapType2.intStackSize - 1] = 0;
                                                                                                                                 var15 = 1;
                                                                                                                              } else {
                                                                                                                                 class83.intStack[++WorldMapType2.intStackSize - 1] = var86.method280(var69.plane, var69.worldX, var69.worldY)?1:0;
                                                                                                                                 var15 = 1;
                                                                                                                              }
                                                                                                                           } else if(var9 == 6622) {
                                                                                                                              class83.intStack[++WorldMapType2.intStackSize - 1] = class39.method548().method5181();
                                                                                                                              class83.intStack[++WorldMapType2.intStackSize - 1] = class39.method548().method5140();
                                                                                                                              var15 = 1;
                                                                                                                           } else if(var9 == 6623) {
                                                                                                                              var97 = new Coordinates(class83.intStack[--WorldMapType2.intStackSize]);
                                                                                                                              var67 = class39.method548().method5114(var97.plane, var97.worldX, var97.worldY);
                                                                                                                              if(var67 == null) {
                                                                                                                                 class83.intStack[++WorldMapType2.intStackSize - 1] = -1;
                                                                                                                              } else {
                                                                                                                                 class83.intStack[++WorldMapType2.intStackSize - 1] = var67.method296();
                                                                                                                              }

                                                                                                                              var15 = 1;
                                                                                                                           } else if(var9 == 6624) {
                                                                                                                              class39.method548().method5141(class83.intStack[--WorldMapType2.intStackSize]);
                                                                                                                              var15 = 1;
                                                                                                                           } else if(var9 == 6625) {
                                                                                                                              class39.method548().method5177();
                                                                                                                              var15 = 1;
                                                                                                                           } else if(var9 == 6626) {
                                                                                                                              class39.method548().method5106(class83.intStack[--WorldMapType2.intStackSize]);
                                                                                                                              var15 = 1;
                                                                                                                           } else if(var9 == 6627) {
                                                                                                                              class39.method548().method5243();
                                                                                                                              var15 = 1;
                                                                                                                           } else {
                                                                                                                              boolean var77;
                                                                                                                              if(var9 == 6628) {
                                                                                                                                 var77 = class83.intStack[--WorldMapType2.intStackSize] == 1;
                                                                                                                                 class39.method548().method5145(var77);
                                                                                                                                 var15 = 1;
                                                                                                                              } else if(var9 == 6629) {
                                                                                                                                 var16 = class83.intStack[--WorldMapType2.intStackSize];
                                                                                                                                 class39.method548().method5206(var16);
                                                                                                                                 var15 = 1;
                                                                                                                              } else if(var9 == 6630) {
                                                                                                                                 var16 = class83.intStack[--WorldMapType2.intStackSize];
                                                                                                                                 class39.method548().method5256(var16);
                                                                                                                                 var15 = 1;
                                                                                                                              } else if(var9 == 6631) {
                                                                                                                                 class39.method548().method5148();
                                                                                                                                 var15 = 1;
                                                                                                                              } else if(var9 == 6632) {
                                                                                                                                 var77 = class83.intStack[--WorldMapType2.intStackSize] == 1;
                                                                                                                                 class39.method548().method5143(var77);
                                                                                                                                 var15 = 1;
                                                                                                                              } else {
                                                                                                                                 boolean var95;
                                                                                                                                 if(var9 == 6633) {
                                                                                                                                    WorldMapType2.intStackSize -= 2;
                                                                                                                                    var16 = class83.intStack[WorldMapType2.intStackSize];
                                                                                                                                    var95 = class83.intStack[WorldMapType2.intStackSize + 1] == 1;
                                                                                                                                    class39.method548().method5149(var16, var95);
                                                                                                                                    var15 = 1;
                                                                                                                                 } else if(var9 == 6634) {
                                                                                                                                    WorldMapType2.intStackSize -= 2;
                                                                                                                                    var16 = class83.intStack[WorldMapType2.intStackSize];
                                                                                                                                    var95 = class83.intStack[1 + WorldMapType2.intStackSize] == 1;
                                                                                                                                    class39.method548().method5150(var16, var95);
                                                                                                                                    var15 = 1;
                                                                                                                                 } else if(var9 == 6635) {
                                                                                                                                    class83.intStack[++WorldMapType2.intStackSize - 1] = class39.method548().method5151()?1:0;
                                                                                                                                    var15 = 1;
                                                                                                                                 } else if(var9 == 6636) {
                                                                                                                                    var16 = class83.intStack[--WorldMapType2.intStackSize];
                                                                                                                                    class83.intStack[++WorldMapType2.intStackSize - 1] = class39.method548().method5208(var16)?1:0;
                                                                                                                                    var15 = 1;
                                                                                                                                 } else if(var9 == 6637) {
                                                                                                                                    var16 = class83.intStack[--WorldMapType2.intStackSize];
                                                                                                                                    class83.intStack[++WorldMapType2.intStackSize - 1] = class39.method548().method5153(var16)?1:0;
                                                                                                                                    var15 = 1;
                                                                                                                                 } else if(var9 == 6638) {
                                                                                                                                    WorldMapType2.intStackSize -= 2;
                                                                                                                                    var16 = class83.intStack[WorldMapType2.intStackSize];
                                                                                                                                    var69 = new Coordinates(class83.intStack[WorldMapType2.intStackSize + 1]);
                                                                                                                                    var89 = class39.method548().method5156(var16, var69);
                                                                                                                                    if(var89 == null) {
                                                                                                                                       class83.intStack[++WorldMapType2.intStackSize - 1] = -1;
                                                                                                                                    } else {
                                                                                                                                       class83.intStack[++WorldMapType2.intStackSize - 1] = var89.method3915();
                                                                                                                                    }

                                                                                                                                    var15 = 1;
                                                                                                                                 } else {
                                                                                                                                    class39 var98;
                                                                                                                                    if(var9 == 6639) {
                                                                                                                                       var98 = class39.method548().method5201();
                                                                                                                                       if(var98 == null) {
                                                                                                                                          class83.intStack[++WorldMapType2.intStackSize - 1] = -1;
                                                                                                                                          class83.intStack[++WorldMapType2.intStackSize - 1] = -1;
                                                                                                                                       } else {
                                                                                                                                          class83.intStack[++WorldMapType2.intStackSize - 1] = var98.field523;
                                                                                                                                          class83.intStack[++WorldMapType2.intStackSize - 1] = var98.field516.method3915();
                                                                                                                                       }

                                                                                                                                       var15 = 1;
                                                                                                                                    } else if(var9 == 6640) {
                                                                                                                                       var98 = class39.method548().method5270();
                                                                                                                                       if(var98 == null) {
                                                                                                                                          class83.intStack[++WorldMapType2.intStackSize - 1] = -1;
                                                                                                                                          class83.intStack[++WorldMapType2.intStackSize - 1] = -1;
                                                                                                                                       } else {
                                                                                                                                          class83.intStack[++WorldMapType2.intStackSize - 1] = var98.field523;
                                                                                                                                          class83.intStack[++WorldMapType2.intStackSize - 1] = var98.field516.method3915();
                                                                                                                                       }

                                                                                                                                       var15 = 1;
                                                                                                                                    } else {
                                                                                                                                       Area var71;
                                                                                                                                       if(var9 == 6693) {
                                                                                                                                          var16 = class83.intStack[--WorldMapType2.intStackSize];
                                                                                                                                          var71 = class54.field662[var16];
                                                                                                                                          if(var71.name == null) {
                                                                                                                                             class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = "";
                                                                                                                                          } else {
                                                                                                                                             class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = var71.name;
                                                                                                                                          }

                                                                                                                                          var15 = 1;
                                                                                                                                       } else if(var9 == 6694) {
                                                                                                                                          var16 = class83.intStack[--WorldMapType2.intStackSize];
                                                                                                                                          var71 = class54.field662[var16];
                                                                                                                                          class83.intStack[++WorldMapType2.intStackSize - 1] = var71.field3300;
                                                                                                                                          var15 = 1;
                                                                                                                                       } else if(var9 == 6695) {
                                                                                                                                          var16 = class83.intStack[--WorldMapType2.intStackSize];
                                                                                                                                          var71 = class54.field662[var16];
                                                                                                                                          if(var71 == null) {
                                                                                                                                             class83.intStack[++WorldMapType2.intStackSize - 1] = -1;
                                                                                                                                          } else {
                                                                                                                                             class83.intStack[++WorldMapType2.intStackSize - 1] = var71.field3307;
                                                                                                                                          }

                                                                                                                                          var15 = 1;
                                                                                                                                       } else if(var9 == 6696) {
                                                                                                                                          var16 = class83.intStack[--WorldMapType2.intStackSize];
                                                                                                                                          var71 = class54.field662[var16];
                                                                                                                                          if(var71 == null) {
                                                                                                                                             class83.intStack[++WorldMapType2.intStackSize - 1] = -1;
                                                                                                                                          } else {
                                                                                                                                             class83.intStack[++WorldMapType2.intStackSize - 1] = var71.spriteId;
                                                                                                                                          }

                                                                                                                                          var15 = 1;
                                                                                                                                       } else if(var9 == 6697) {
                                                                                                                                          class83.intStack[++WorldMapType2.intStackSize - 1] = class83.field1330.field590;
                                                                                                                                          var15 = 1;
                                                                                                                                       } else if(var9 == 6698) {
                                                                                                                                          class83.intStack[++WorldMapType2.intStackSize - 1] = class83.field1330.field589.method3915();
                                                                                                                                          var15 = 1;
                                                                                                                                       } else if(var9 == 6699) {
                                                                                                                                          class83.intStack[++WorldMapType2.intStackSize - 1] = class83.field1330.field593.method3915();
                                                                                                                                          var15 = 1;
                                                                                                                                       } else {
                                                                                                                                          var15 = 2;
                                                                                                                                       }
                                                                                                                                    }
                                                                                                                                 }
                                                                                                                              }
                                                                                                                           }
                                                                                                                        }
                                                                                                                     }
                                                                                                                  }
                                                                                                               }
                                                                                                            }

                                                                                                            var14 = var15;
                                                                                                         } else {
                                                                                                            var14 = 2;
                                                                                                         }
                                                                                                      }
                                                                                                   }
                                                                                                }
                                                                                             }

                                                                                             switch(var14) {
                                                                                             case 0:
                                                                                                return;
                                                                                             case 1:
                                                                                             default:
                                                                                                break;
                                                                                             case 2:
                                                                                                throw new IllegalStateException();
                                                                                             }
                                                                                          }
                                                                                       }
                                                                                    }
                                                                                 }
                                                                              }
                                                                           }
                                                                        }
                                                                     }
                                                                  }
                                                               }
                                                            }
                                                         }
                                                      }
                                                   }
                                                }
                                             }
                                          }
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         } catch (Exception var46) {
            StringBuilder var45 = new StringBuilder(30);
            var45.append("").append(var3.hash).append(" ");

            for(var12 = class83.scriptStackCount - 1; var12 >= 0; --var12) {
               var45.append("").append(class83.scriptStack[var12].invokedFromScript.hash).append(" ");
            }

            var45.append("").append(var49);
            class54.method800(var45.toString(), var46);
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;LIndexDataBase;ZIB)V",
      garbageValue = "79"
   )
   static void method3007(IndexDataBase var0, IndexDataBase var1, boolean var2, int var3) {
      if(class92.field1426) {
         if(var3 == 4) {
            class92.loginIndex = 4;
         }

      } else {
         class92.loginIndex = var3;
         Rasterizer2D.reset();
         byte[] var4 = var0.method4116("title.jpg", "");
         BufferedImage var6 = null;

         SpritePixels var5;
         label156: {
            try {
               var6 = ImageIO.read(new ByteArrayInputStream(var4));
               int var7 = var6.getWidth();
               int var8 = var6.getHeight();
               int[] var9 = new int[var8 * var7];
               PixelGrabber var10 = new PixelGrabber(var6, 0, 0, var7, var8, var9, 0, var7);
               var10.grabPixels();
               var5 = new SpritePixels(var9, var7, var8);
               break label156;
            } catch (IOException var13) {
               ;
            } catch (InterruptedException var14) {
               ;
            }

            var5 = new SpritePixels(0, 0);
         }

         XItemContainer.field781 = var5;
         class8.field245 = XItemContainer.field781.method4972();
         if((Client.flags & 536870912) != 0) {
            class157.logoSprite = ISAACCipher.getSprite(var1, "logo_deadman_mode", "");
         } else {
            class157.logoSprite = ISAACCipher.getSprite(var1, "logo", "");
         }

         class92.field1419 = ISAACCipher.getSprite(var1, "titlebox", "");
         class208.field2595 = ISAACCipher.getSprite(var1, "titlebutton", "");
         Frames.field2137 = class266.method4774(var1, "runes", "");
         XClanMember.titlemuteSprite = class266.method4774(var1, "title_mute", "");
         ISAACCipher.field2431 = ISAACCipher.getSprite(var1, "options_radio_buttons,0", "");
         class228.field3151 = ISAACCipher.getSprite(var1, "options_radio_buttons,2", "");
         class92.field1424 = new int[256];

         int var11;
         for(var11 = 0; var11 < 64; ++var11) {
            class92.field1424[var11] = var11 * 262144;
         }

         for(var11 = 0; var11 < 64; ++var11) {
            class92.field1424[var11 + 64] = var11 * 1024 + 16711680;
         }

         for(var11 = 0; var11 < 64; ++var11) {
            class92.field1424[var11 + 128] = var11 * 4 + 16776960;
         }

         for(var11 = 0; var11 < 64; ++var11) {
            class92.field1424[var11 + 192] = 16777215;
         }

         class73.field864 = new int[256];

         for(var11 = 0; var11 < 64; ++var11) {
            class73.field864[var11] = var11 * 1024;
         }

         for(var11 = 0; var11 < 64; ++var11) {
            class73.field864[var11 + 64] = var11 * 4 + '\uff00';
         }

         for(var11 = 0; var11 < 64; ++var11) {
            class73.field864[var11 + 128] = var11 * 262144 + '\uffff';
         }

         for(var11 = 0; var11 < 64; ++var11) {
            class73.field864[var11 + 192] = 16777215;
         }

         World.field1287 = new int[256];

         for(var11 = 0; var11 < 64; ++var11) {
            World.field1287[var11] = var11 * 4;
         }

         for(var11 = 0; var11 < 64; ++var11) {
            World.field1287[var11 + 64] = var11 * 262144 + 255;
         }

         for(var11 = 0; var11 < 64; ++var11) {
            World.field1287[var11 + 128] = var11 * 1024 + 16711935;
         }

         for(var11 = 0; var11 < 64; ++var11) {
            World.field1287[var11 + 192] = 16777215;
         }

         class92.field1445 = new int[256];
         Spotanim.field3339 = new int['耀'];
         class18.field323 = new int['耀'];
         class66.method1084((ModIcon)null);
         class168.field2340 = new int['耀'];
         class17.field312 = new int['耀'];
         if(var2) {
            class92.username = "";
            class92.password = "";
         }

         class3.authCodeForLogin = 0;
         WallObject.authCode = "";
         class92.field1446 = true;
         class92.worldSelectShown = false;
         if(!class23.preferences.muted) {
            class214.method3963(2, class182.indexTrack1, "scape main", "", 255, false);
         } else {
            class203.field2501 = 1;
            class203.field2502 = null;
            class203.field2503 = -1;
            MilliTimer.field2204 = -1;
            class203.field2504 = 0;
            class203.field2505 = false;
            class73.field861 = 2;
         }

         Actor.sendConInfo(false);
         class92.field1426 = true;
         class92.field1436 = (class77.canvasWidth - 765) / 2;
         class92.loginWindowX = class92.field1436 + 202;
         XItemContainer.field781.method4981(class92.field1436, 0);
         class8.field245.method4981(class92.field1436 + 382, 0);
         class157.logoSprite.method4952(class92.field1436 + 382 - class157.logoSprite.originalWidth / 2, 18);
      }
   }

   @ObfuscatedName("hk")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIIIZI)V",
      garbageValue = "-2125982877"
   )
   static final void method3019(String var0, String var1, int var2, int var3, int var4, int var5, boolean var6) {
      if(!Client.isMenuOpen) {
         if(Client.menuOptionCount < 500) {
            Client.menuOptions[Client.menuOptionCount] = var0;
            Client.menuTargets[Client.menuOptionCount] = var1;
            Client.menuTypes[Client.menuOptionCount] = var2;
            Client.menuIdentifiers[Client.menuOptionCount] = var3;
            Client.menuActionParams0[Client.menuOptionCount] = var4;
            Client.menuActionParams1[Client.menuOptionCount] = var5;
            if(var6) {
               Client.field940 = Client.menuOptionCount;
            }

            ++Client.menuOptionCount;
         }

      }
   }
}
