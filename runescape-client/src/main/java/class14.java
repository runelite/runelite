import java.io.File;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("k")
public class class14 {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1371086371
   )
   public final int field291;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      longValue = -3702403370106776443L
   )
   public final long field284;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lh;"
   )
   public final GrandExchangeOffer field285;
   @ObfuscatedName("j")
   String field286;
   @ObfuscatedName("v")
   String field289;

   @ObfuscatedSignature(
      signature = "(Lfv;BI)V"
   )
   class14(Buffer var1, byte var2, int var3) {
      this.field286 = var1.readString();
      this.field289 = var1.readString();
      this.field291 = var1.readUnsignedShort();
      this.field284 = var1.readLong();
      int var4 = var1.readInt();
      int var5 = var1.readInt();
      this.field285 = new GrandExchangeOffer();
      this.field285.method118(2);
      this.field285.method119(var2);
      this.field285.price = var4;
      this.field285.totalQuantity = var5;
      this.field285.quantitySold = 0;
      this.field285.spent = 0;
      this.field285.itemId = var3;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "2119113262"
   )
   public String method96() {
      return this.field286;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-1941401881"
   )
   public String method87() {
      return this.field289;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;Ljava/io/File;B)V",
      garbageValue = "-56"
   )
   static void method86(File var0, File var1) {
      try {
         FileOnDisk var2 = new FileOnDisk(WidgetNode.field781, "rw", 10000L);
         Buffer var3 = new Buffer(500);
         var3.putByte(3);
         var3.putByte(var1 != null?1:0);
         var3.putCESU8(var0.getPath());
         if(var1 != null) {
            var3.putCESU8("");
         }

         var2.write(var3.payload, 0, var3.offset);
         var2.close();
      } catch (IOException var4) {
         var4.printStackTrace();
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)Lca;",
      garbageValue = "-347625929"
   )
   static Preferences method85() {
      FileOnDisk var0 = null;
      Preferences var1 = new Preferences();

      try {
         var0 = CollisionData.getPreferencesFile("", class41.field528.field3261, false);
         byte[] var2 = new byte[(int)var0.length()];

         int var4;
         for(int var3 = 0; var3 < var2.length; var3 += var4) {
            var4 = var0.read(var2, var3, var2.length - var3);
            if(var4 == -1) {
               throw new IOException();
            }
         }

         var1 = new Preferences(new Buffer(var2));
      } catch (Exception var6) {
         ;
      }

      try {
         if(var0 != null) {
            var0.close();
         }
      } catch (Exception var5) {
         ;
      }

      return var1;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lcd;Lcd;IZI)I",
      garbageValue = "-521097773"
   )
   static int method92(World var0, World var1, int var2, boolean var3) {
      if(var2 == 1) {
         int var4 = var0.playerCount;
         int var5 = var1.playerCount;
         if(!var3) {
            if(var4 == -1) {
               var4 = 2001;
            }

            if(var5 == -1) {
               var5 = 2001;
            }
         }

         return var4 - var5;
      } else {
         return var2 == 2?var0.location - var1.location:(var2 == 3?(var0.activity.equals("-")?(var1.activity.equals("-")?0:(var3?-1:1)):(var1.activity.equals("-")?(var3?1:-1):var0.activity.compareTo(var1.activity))):(var2 == 4?(var0.method1638()?(var1.method1638()?0:1):(var1.method1638()?-1:0)):(var2 == 5?(var0.method1636()?(var1.method1636()?0:1):(var1.method1636()?-1:0)):(var2 == 6?(var0.method1637()?(var1.method1637()?0:1):(var1.method1637()?-1:0)):(var2 == 7?(var0.method1640()?(var1.method1640()?0:1):(var1.method1640()?-1:0)):var0.id - var1.id)))));
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(ILcw;ZI)I",
      garbageValue = "755371930"
   )
   static int method93(int var0, Script var1, boolean var2) {
      int var3;
      if(var0 == 6600) {
         var3 = Ignore.plane;
         int var13 = (class48.localPlayer.x >> 7) + ItemLayer.baseX;
         int var5 = (class48.localPlayer.y >> 7) + ItemLayer.baseY;
         BaseVarType.method13().method5496(var3, var13, var5, true);
         return 1;
      } else {
         WorldMapData var15;
         if(var0 == 6601) {
            var3 = class82.intStack[--class56.intStackSize];
            String var20 = "";
            var15 = BaseVarType.method13().method5438(var3);
            if(var15 != null) {
               var20 = var15.method310();
            }

            class82.scriptStringStack[++class24.scriptStringStackSize - 1] = var20;
            return 1;
         } else if(var0 == 6602) {
            var3 = class82.intStack[--class56.intStackSize];
            BaseVarType.method13().method5423(var3);
            return 1;
         } else if(var0 == 6603) {
            class82.intStack[++class56.intStackSize - 1] = BaseVarType.method13().method5447();
            return 1;
         } else if(var0 == 6604) {
            var3 = class82.intStack[--class56.intStackSize];
            BaseVarType.method13().method5432(var3);
            return 1;
         } else if(var0 == 6605) {
            class82.intStack[++class56.intStackSize - 1] = BaseVarType.method13().method5437()?1:0;
            return 1;
         } else {
            Coordinates var19;
            if(var0 == 6606) {
               var19 = new Coordinates(class82.intStack[--class56.intStackSize]);
               BaseVarType.method13().method5526(var19.worldX, var19.worldY);
               return 1;
            } else if(var0 == 6607) {
               var19 = new Coordinates(class82.intStack[--class56.intStackSize]);
               BaseVarType.method13().method5440(var19.worldX, var19.worldY);
               return 1;
            } else if(var0 == 6608) {
               var19 = new Coordinates(class82.intStack[--class56.intStackSize]);
               BaseVarType.method13().method5441(var19.plane, var19.worldX, var19.worldY);
               return 1;
            } else if(var0 == 6609) {
               var19 = new Coordinates(class82.intStack[--class56.intStackSize]);
               BaseVarType.method13().method5442(var19.plane, var19.worldX, var19.worldY);
               return 1;
            } else if(var0 == 6610) {
               class82.intStack[++class56.intStackSize - 1] = BaseVarType.method13().method5503();
               class82.intStack[++class56.intStackSize - 1] = BaseVarType.method13().method5444();
               return 1;
            } else {
               WorldMapData var17;
               if(var0 == 6611) {
                  var3 = class82.intStack[--class56.intStackSize];
                  var17 = BaseVarType.method13().method5438(var3);
                  if(var17 == null) {
                     class82.intStack[++class56.intStackSize - 1] = 0;
                  } else {
                     class82.intStack[++class56.intStackSize - 1] = var17.method311().method4093();
                  }

                  return 1;
               } else if(var0 == 6612) {
                  var3 = class82.intStack[--class56.intStackSize];
                  var17 = BaseVarType.method13().method5438(var3);
                  if(var17 == null) {
                     class82.intStack[++class56.intStackSize - 1] = 0;
                     class82.intStack[++class56.intStackSize - 1] = 0;
                  } else {
                     class82.intStack[++class56.intStackSize - 1] = (var17.method324() - var17.method323() + 1) * 64;
                     class82.intStack[++class56.intStackSize - 1] = (var17.method326() - var17.method325() + 1) * 64;
                  }

                  return 1;
               } else if(var0 == 6613) {
                  var3 = class82.intStack[--class56.intStackSize];
                  var17 = BaseVarType.method13().method5438(var3);
                  if(var17 == null) {
                     class82.intStack[++class56.intStackSize - 1] = 0;
                     class82.intStack[++class56.intStackSize - 1] = 0;
                     class82.intStack[++class56.intStackSize - 1] = 0;
                     class82.intStack[++class56.intStackSize - 1] = 0;
                  } else {
                     class82.intStack[++class56.intStackSize - 1] = var17.method323() * 64;
                     class82.intStack[++class56.intStackSize - 1] = var17.method325() * 64;
                     class82.intStack[++class56.intStackSize - 1] = var17.method324() * 64 + 64 - 1;
                     class82.intStack[++class56.intStackSize - 1] = var17.method326() * 64 + 64 - 1;
                  }

                  return 1;
               } else if(var0 == 6614) {
                  var3 = class82.intStack[--class56.intStackSize];
                  var17 = BaseVarType.method13().method5438(var3);
                  if(var17 == null) {
                     class82.intStack[++class56.intStackSize - 1] = -1;
                  } else {
                     class82.intStack[++class56.intStackSize - 1] = var17.method322();
                  }

                  return 1;
               } else if(var0 == 6615) {
                  var19 = BaseVarType.method13().method5558();
                  if(var19 == null) {
                     class82.intStack[++class56.intStackSize - 1] = -1;
                     class82.intStack[++class56.intStackSize - 1] = -1;
                  } else {
                     class82.intStack[++class56.intStackSize - 1] = var19.worldX;
                     class82.intStack[++class56.intStackSize - 1] = var19.worldY;
                  }

                  return 1;
               } else if(var0 == 6616) {
                  class82.intStack[++class56.intStackSize - 1] = BaseVarType.method13().method5424();
                  return 1;
               } else if(var0 == 6617) {
                  var19 = new Coordinates(class82.intStack[--class56.intStackSize]);
                  var17 = BaseVarType.method13().method5425();
                  if(var17 == null) {
                     class82.intStack[++class56.intStackSize - 1] = -1;
                     class82.intStack[++class56.intStackSize - 1] = -1;
                     return 1;
                  } else {
                     int[] var18 = var17.method314(var19.plane, var19.worldX, var19.worldY);
                     if(var18 == null) {
                        class82.intStack[++class56.intStackSize - 1] = -1;
                        class82.intStack[++class56.intStackSize - 1] = -1;
                     } else {
                        class82.intStack[++class56.intStackSize - 1] = var18[0];
                        class82.intStack[++class56.intStackSize - 1] = var18[1];
                     }

                     return 1;
                  }
               } else {
                  Coordinates var11;
                  if(var0 == 6618) {
                     var19 = new Coordinates(class82.intStack[--class56.intStackSize]);
                     var17 = BaseVarType.method13().method5425();
                     if(var17 == null) {
                        class82.intStack[++class56.intStackSize - 1] = -1;
                        class82.intStack[++class56.intStackSize - 1] = -1;
                        return 1;
                     } else {
                        var11 = var17.method327(var19.worldX, var19.worldY);
                        if(var11 == null) {
                           class82.intStack[++class56.intStackSize - 1] = -1;
                        } else {
                           class82.intStack[++class56.intStackSize - 1] = var11.method4093();
                        }

                        return 1;
                     }
                  } else {
                     Coordinates var16;
                     if(var0 == 6619) {
                        class56.intStackSize -= 2;
                        var3 = class82.intStack[class56.intStackSize];
                        var16 = new Coordinates(class82.intStack[class56.intStackSize + 1]);
                        class280.method5096(var3, var16, false);
                        return 1;
                     } else if(var0 == 6620) {
                        class56.intStackSize -= 2;
                        var3 = class82.intStack[class56.intStackSize];
                        var16 = new Coordinates(class82.intStack[class56.intStackSize + 1]);
                        var15 = BaseVarType.method13().method5438(var3);
                        int var6 = class48.localPlayer.field852;
                        int var7 = (class48.localPlayer.x >> 7) + ItemLayer.baseX;
                        int var8 = (class48.localPlayer.y >> 7) + ItemLayer.baseY;
                        Coordinates var9 = new Coordinates(var6, var7, var8);
                        BaseVarType.method13().method5428(var15, var9, var16, true);
                        return 1;
                     } else if(var0 == 6621) {
                        class56.intStackSize -= 2;
                        var3 = class82.intStack[class56.intStackSize];
                        var16 = new Coordinates(class82.intStack[class56.intStackSize + 1]);
                        var15 = BaseVarType.method13().method5438(var3);
                        if(var15 == null) {
                           class82.intStack[++class56.intStackSize - 1] = 0;
                           return 1;
                        } else {
                           class82.intStack[++class56.intStackSize - 1] = var15.method344(var16.plane, var16.worldX, var16.worldY)?1:0;
                           return 1;
                        }
                     } else if(var0 == 6622) {
                        class82.intStack[++class56.intStackSize - 1] = BaseVarType.method13().method5446();
                        class82.intStack[++class56.intStackSize - 1] = BaseVarType.method13().method5449();
                        return 1;
                     } else if(var0 == 6623) {
                        var19 = new Coordinates(class82.intStack[--class56.intStackSize]);
                        var17 = BaseVarType.method13().method5421(var19.plane, var19.worldX, var19.worldY);
                        if(var17 == null) {
                           class82.intStack[++class56.intStackSize - 1] = -1;
                        } else {
                           class82.intStack[++class56.intStackSize - 1] = var17.method392();
                        }

                        return 1;
                     } else if(var0 == 6624) {
                        BaseVarType.method13().method5549(class82.intStack[--class56.intStackSize]);
                        return 1;
                     } else if(var0 == 6625) {
                        BaseVarType.method13().method5592();
                        return 1;
                     } else if(var0 == 6626) {
                        BaseVarType.method13().method5450(class82.intStack[--class56.intStackSize]);
                        return 1;
                     } else if(var0 == 6627) {
                        BaseVarType.method13().method5555();
                        return 1;
                     } else {
                        boolean var14;
                        if(var0 == 6628) {
                           var14 = class82.intStack[--class56.intStackSize] == 1;
                           BaseVarType.method13().method5452(var14);
                           return 1;
                        } else if(var0 == 6629) {
                           var3 = class82.intStack[--class56.intStackSize];
                           BaseVarType.method13().method5453(var3);
                           return 1;
                        } else if(var0 == 6630) {
                           var3 = class82.intStack[--class56.intStackSize];
                           BaseVarType.method13().method5471(var3);
                           return 1;
                        } else if(var0 == 6631) {
                           BaseVarType.method13().method5455();
                           return 1;
                        } else if(var0 == 6632) {
                           var14 = class82.intStack[--class56.intStackSize] == 1;
                           BaseVarType.method13().method5533(var14);
                           return 1;
                        } else {
                           boolean var4;
                           if(var0 == 6633) {
                              class56.intStackSize -= 2;
                              var3 = class82.intStack[class56.intStackSize];
                              var4 = class82.intStack[class56.intStackSize + 1] == 1;
                              BaseVarType.method13().method5504(var3, var4);
                              return 1;
                           } else if(var0 == 6634) {
                              class56.intStackSize -= 2;
                              var3 = class82.intStack[class56.intStackSize];
                              var4 = class82.intStack[class56.intStackSize + 1] == 1;
                              BaseVarType.method13().method5458(var3, var4);
                              return 1;
                           } else if(var0 == 6635) {
                              class82.intStack[++class56.intStackSize - 1] = BaseVarType.method13().method5459()?1:0;
                              return 1;
                           } else if(var0 == 6636) {
                              var3 = class82.intStack[--class56.intStackSize];
                              class82.intStack[++class56.intStackSize - 1] = BaseVarType.method13().method5460(var3)?1:0;
                              return 1;
                           } else if(var0 == 6637) {
                              var3 = class82.intStack[--class56.intStackSize];
                              class82.intStack[++class56.intStackSize - 1] = BaseVarType.method13().method5461(var3)?1:0;
                              return 1;
                           } else if(var0 == 6638) {
                              class56.intStackSize -= 2;
                              var3 = class82.intStack[class56.intStackSize];
                              var16 = new Coordinates(class82.intStack[class56.intStackSize + 1]);
                              var11 = BaseVarType.method13().method5517(var3, var16);
                              if(var11 == null) {
                                 class82.intStack[++class56.intStackSize - 1] = -1;
                              } else {
                                 class82.intStack[++class56.intStackSize - 1] = var11.method4093();
                              }

                              return 1;
                           } else {
                              class39 var12;
                              if(var0 == 6639) {
                                 var12 = BaseVarType.method13().method5465();
                                 if(var12 == null) {
                                    class82.intStack[++class56.intStackSize - 1] = -1;
                                    class82.intStack[++class56.intStackSize - 1] = -1;
                                 } else {
                                    class82.intStack[++class56.intStackSize - 1] = var12.field508;
                                    class82.intStack[++class56.intStackSize - 1] = var12.field499.method4093();
                                 }

                                 return 1;
                              } else if(var0 == 6640) {
                                 var12 = BaseVarType.method13().method5466();
                                 if(var12 == null) {
                                    class82.intStack[++class56.intStackSize - 1] = -1;
                                    class82.intStack[++class56.intStackSize - 1] = -1;
                                 } else {
                                    class82.intStack[++class56.intStackSize - 1] = var12.field508;
                                    class82.intStack[++class56.intStackSize - 1] = var12.field499.method4093();
                                 }

                                 return 1;
                              } else {
                                 Area var10;
                                 if(var0 == 6693) {
                                    var3 = class82.intStack[--class56.intStackSize];
                                    var10 = Area.field3358[var3];
                                    if(var10.name == null) {
                                       class82.scriptStringStack[++class24.scriptStringStackSize - 1] = "";
                                    } else {
                                       class82.scriptStringStack[++class24.scriptStringStackSize - 1] = var10.name;
                                    }

                                    return 1;
                                 } else if(var0 == 6694) {
                                    var3 = class82.intStack[--class56.intStackSize];
                                    var10 = Area.field3358[var3];
                                    class82.intStack[++class56.intStackSize - 1] = var10.field3354;
                                    return 1;
                                 } else if(var0 == 6695) {
                                    var3 = class82.intStack[--class56.intStackSize];
                                    var10 = Area.field3358[var3];
                                    if(var10 == null) {
                                       class82.intStack[++class56.intStackSize - 1] = -1;
                                    } else {
                                       class82.intStack[++class56.intStackSize - 1] = var10.field3369;
                                    }

                                    return 1;
                                 } else if(var0 == 6696) {
                                    var3 = class82.intStack[--class56.intStackSize];
                                    var10 = Area.field3358[var3];
                                    if(var10 == null) {
                                       class82.intStack[++class56.intStackSize - 1] = -1;
                                    } else {
                                       class82.intStack[++class56.intStackSize - 1] = var10.spriteId;
                                    }

                                    return 1;
                                 } else if(var0 == 6697) {
                                    class82.intStack[++class56.intStackSize - 1] = class48.field587.field578;
                                    return 1;
                                 } else if(var0 == 6698) {
                                    class82.intStack[++class56.intStackSize - 1] = class48.field587.field582.method4093();
                                    return 1;
                                 } else if(var0 == 6699) {
                                    class82.intStack[++class56.intStackSize - 1] = class48.field587.field579.method4093();
                                    return 1;
                                 } else {
                                    return 2;
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

   @ObfuscatedName("go")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "2067779422"
   )
   static final void method94(int var0, int var1, int var2, int var3, int var4, int var5) {
      int var6 = 2048 - var3 & 2047;
      int var7 = 2048 - var4 & 2047;
      int var8 = 0;
      int var9 = 0;
      int var10 = var5;
      int var11;
      int var12;
      int var13;
      if(var6 != 0) {
         var11 = Graphics3D.SINE[var6];
         var12 = Graphics3D.COSINE[var6];
         var13 = var9 * var12 - var11 * var5 >> 16;
         var10 = var11 * var9 + var5 * var12 >> 16;
         var9 = var13;
      }

      if(var7 != 0) {
         var11 = Graphics3D.SINE[var7];
         var12 = Graphics3D.COSINE[var7];
         var13 = var11 * var10 + var8 * var12 >> 16;
         var10 = var10 * var12 - var8 * var11 >> 16;
         var8 = var13;
      }

      class29.cameraX = var0 - var8;
      class70.cameraZ = var1 - var9;
      Player.cameraY = var2 - var10;
      class28.cameraPitch = var3;
      class228.cameraYaw = var4;
   }
}
