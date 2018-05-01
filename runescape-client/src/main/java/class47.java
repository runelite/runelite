import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("an")
public class class47 {
   @ObfuscatedName("dm")
   @ObfuscatedGetter(
      intValue = 1945808119
   )
   @Export("myWorldPort")
   static int myWorldPort;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 677650737
   )
   int field580;
   @ObfuscatedName("e")
   byte[][][] field579;

   class47(int var1) {
      this.field580 = var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIIIIIIII)V",
      garbageValue = "1589909117"
   )
   void method729(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      if(var7 != 0 && this.field580 != 0 && this.field579 != null) {
         var8 = this.method713(var8, var7);
         var7 = this.method719(var7);
         Rasterizer2D.method5809(var1, var2, var5, var6, var3, var4, this.field579[var7 - 1][var8], this.field580);
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1133568658"
   )
   int method713(int var1, int var2) {
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

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-31"
   )
   int method719(int var1) {
      return var1 != 9 && var1 != 10?(var1 == 11?8:var1):1;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1034049653"
   )
   void method718() {
      if(this.field579 == null) {
         this.field579 = new byte[8][4][];
         this.method730();
         this.method720();
         this.method741();
         this.method712();
         this.method745();
         this.method721();
         this.method722();
         this.method723();
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "625399072"
   )
   void method730() {
      byte[] var1 = new byte[this.field580 * this.field580];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field580; ++var3) {
         for(var4 = 0; var4 < this.field580; ++var4) {
            if(var4 <= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field579[0][0] = var1;
      var1 = new byte[this.field580 * this.field580];
      var2 = 0;

      for(var3 = this.field580 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field580; ++var4) {
            if(var4 <= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field579[0][1] = var1;
      var1 = new byte[this.field580 * this.field580];
      var2 = 0;

      for(var3 = 0; var3 < this.field580; ++var3) {
         for(var4 = 0; var4 < this.field580; ++var4) {
            if(var4 >= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field579[0][2] = var1;
      var1 = new byte[this.field580 * this.field580];
      var2 = 0;

      for(var3 = this.field580 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field580; ++var4) {
            if(var4 >= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field579[0][3] = var1;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1172511221"
   )
   void method720() {
      byte[] var1 = new byte[this.field580 * this.field580];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field580 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field580; ++var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field579[1][0] = var1;
      var1 = new byte[this.field580 * this.field580];
      var2 = 0;

      for(var3 = 0; var3 < this.field580; ++var3) {
         for(var4 = 0; var4 < this.field580; ++var4) {
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

      this.field579[1][1] = var1;
      var1 = new byte[this.field580 * this.field580];
      var2 = 0;

      for(var3 = 0; var3 < this.field580; ++var3) {
         for(var4 = this.field580 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field579[1][2] = var1;
      var1 = new byte[this.field580 * this.field580];
      var2 = 0;

      for(var3 = this.field580 - 1; var3 >= 0; --var3) {
         for(var4 = this.field580 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field579[1][3] = var1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1748940294"
   )
   void method741() {
      byte[] var1 = new byte[this.field580 * this.field580];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field580 - 1; var3 >= 0; --var3) {
         for(var4 = this.field580 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field579[2][0] = var1;
      var1 = new byte[this.field580 * this.field580];
      var2 = 0;

      for(var3 = this.field580 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field580; ++var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field579[2][1] = var1;
      var1 = new byte[this.field580 * this.field580];
      var2 = 0;

      for(var3 = 0; var3 < this.field580; ++var3) {
         for(var4 = 0; var4 < this.field580; ++var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field579[2][2] = var1;
      var1 = new byte[this.field580 * this.field580];
      var2 = 0;

      for(var3 = 0; var3 < this.field580; ++var3) {
         for(var4 = this.field580 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field579[2][3] = var1;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1233526304"
   )
   void method712() {
      byte[] var1 = new byte[this.field580 * this.field580];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field580 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field580; ++var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field579[3][0] = var1;
      var1 = new byte[this.field580 * this.field580];
      var2 = 0;

      for(var3 = 0; var3 < this.field580; ++var3) {
         for(var4 = 0; var4 < this.field580; ++var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field579[3][1] = var1;
      var1 = new byte[this.field580 * this.field580];
      var2 = 0;

      for(var3 = 0; var3 < this.field580; ++var3) {
         for(var4 = this.field580 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field579[3][2] = var1;
      var1 = new byte[this.field580 * this.field580];
      var2 = 0;

      for(var3 = this.field580 - 1; var3 >= 0; --var3) {
         for(var4 = this.field580 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field579[3][3] = var1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "620268573"
   )
   void method745() {
      byte[] var1 = new byte[this.field580 * this.field580];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field580 - 1; var3 >= 0; --var3) {
         for(var4 = this.field580 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field579[4][0] = var1;
      var1 = new byte[this.field580 * this.field580];
      var2 = 0;

      for(var3 = this.field580 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field580; ++var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field579[4][1] = var1;
      var1 = new byte[this.field580 * this.field580];
      var2 = 0;

      for(var3 = 0; var3 < this.field580; ++var3) {
         for(var4 = 0; var4 < this.field580; ++var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field579[4][2] = var1;
      var1 = new byte[this.field580 * this.field580];
      var2 = 0;

      for(var3 = 0; var3 < this.field580; ++var3) {
         for(var4 = this.field580 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field579[4][3] = var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1167196914"
   )
   void method721() {
      byte[] var1 = new byte[this.field580 * this.field580];
      boolean var2 = false;
      var1 = new byte[this.field580 * this.field580];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field580; ++var3) {
         for(var4 = 0; var4 < this.field580; ++var4) {
            if(var4 <= this.field580 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field579[5][0] = var1;
      var1 = new byte[this.field580 * this.field580];
      var5 = 0;

      for(var3 = 0; var3 < this.field580; ++var3) {
         for(var4 = 0; var4 < this.field580; ++var4) {
            if(var3 <= this.field580 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field579[5][1] = var1;
      var1 = new byte[this.field580 * this.field580];
      var5 = 0;

      for(var3 = 0; var3 < this.field580; ++var3) {
         for(var4 = 0; var4 < this.field580; ++var4) {
            if(var4 >= this.field580 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field579[5][2] = var1;
      var1 = new byte[this.field580 * this.field580];
      var5 = 0;

      for(var3 = 0; var3 < this.field580; ++var3) {
         for(var4 = 0; var4 < this.field580; ++var4) {
            if(var3 >= this.field580 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field579[5][3] = var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1345626030"
   )
   void method722() {
      byte[] var1 = new byte[this.field580 * this.field580];
      boolean var2 = false;
      var1 = new byte[this.field580 * this.field580];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field580; ++var3) {
         for(var4 = 0; var4 < this.field580; ++var4) {
            if(var4 <= var3 - this.field580 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field579[6][0] = var1;
      var1 = new byte[this.field580 * this.field580];
      var5 = 0;

      for(var3 = this.field580 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field580; ++var4) {
            if(var4 <= var3 - this.field580 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field579[6][1] = var1;
      var1 = new byte[this.field580 * this.field580];
      var5 = 0;

      for(var3 = this.field580 - 1; var3 >= 0; --var3) {
         for(var4 = this.field580 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 - this.field580 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field579[6][2] = var1;
      var1 = new byte[this.field580 * this.field580];
      var5 = 0;

      for(var3 = 0; var3 < this.field580; ++var3) {
         for(var4 = this.field580 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 - this.field580 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field579[6][3] = var1;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1725324357"
   )
   void method723() {
      byte[] var1 = new byte[this.field580 * this.field580];
      boolean var2 = false;
      var1 = new byte[this.field580 * this.field580];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field580; ++var3) {
         for(var4 = 0; var4 < this.field580; ++var4) {
            if(var4 >= var3 - this.field580 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field579[7][0] = var1;
      var1 = new byte[this.field580 * this.field580];
      var5 = 0;

      for(var3 = this.field580 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field580; ++var4) {
            if(var4 >= var3 - this.field580 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field579[7][1] = var1;
      var1 = new byte[this.field580 * this.field580];
      var5 = 0;

      for(var3 = this.field580 - 1; var3 >= 0; --var3) {
         for(var4 = this.field580 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 - this.field580 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field579[7][2] = var1;
      var1 = new byte[this.field580 * this.field580];
      var5 = 0;

      for(var3 = 0; var3 < this.field580; ++var3) {
         for(var4 = this.field580 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 - this.field580 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field579[7][3] = var1;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1101558322"
   )
   public static int method755() {
      return KeyFocusListener.keyboardIdleTicks;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-23"
   )
   @Export("adjustHSLListness0")
   static final int adjustHSLListness0(int var0, int var1) {
      if(var0 == -2) {
         return 12345678;
      } else if(var0 == -1) {
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 65408) + var1;
      }
   }

   @ObfuscatedName("ho")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "779890004"
   )
   static final void method757() {
      Overlay.flush(false);
      Client.field904 = 0;
      boolean var0 = true;

      int var1;
      for(var1 = 0; var1 < class88.field1323.length; ++var1) {
         if(class23.landMapFileIds[var1] != -1 && class88.field1323[var1] == null) {
            class88.field1323[var1] = SoundTaskDataProvider.indexMaps.getConfigData(class23.landMapFileIds[var1], 0);
            if(class88.field1323[var1] == null) {
               var0 = false;
               ++Client.field904;
            }
         }

         if(CombatInfo1.landRegionFileIds[var1] != -1 && BoundingBox3DDrawMode.field270[var1] == null) {
            BoundingBox3DDrawMode.field270[var1] = SoundTaskDataProvider.indexMaps.getConfigDataKeys(CombatInfo1.landRegionFileIds[var1], 0, MapIcon.xteaKeys[var1]);
            if(BoundingBox3DDrawMode.field270[var1] == null) {
               var0 = false;
               ++Client.field904;
            }
         }
      }

      if(!var0) {
         Client.field1002 = 1;
      } else {
         Client.field910 = 0;
         var0 = true;

         int var3;
         int var4;
         int var9;
         int var10;
         int var11;
         int var13;
         int var14;
         int var15;
         int var16;
         int var17;
         int var18;
         for(var1 = 0; var1 < class88.field1323.length; ++var1) {
            byte[] var2 = BoundingBox3DDrawMode.field270[var1];
            if(var2 != null) {
               var3 = (class20.mapRegions[var1] >> 8) * 64 - ClientPacket.baseX;
               var4 = (class20.mapRegions[var1] & 255) * 64 - MapIconReference.baseY;
               if(Client.isDynamicRegion) {
                  var3 = 10;
                  var4 = 10;
               }

               boolean var7 = true;
               Buffer var8 = new Buffer(var2);
               var9 = -1;

               label1416:
               while(true) {
                  var10 = var8.getUSmart();
                  if(var10 == 0) {
                     var0 &= var7;
                     break;
                  }

                  var9 += var10;
                  var11 = 0;
                  boolean var12 = false;

                  while(true) {
                     while(!var12) {
                        var13 = var8.getUSmart();
                        if(var13 == 0) {
                           continue label1416;
                        }

                        var11 += var13 - 1;
                        var14 = var11 & 63;
                        var15 = var11 >> 6 & 63;
                        var16 = var8.readUnsignedByte() >> 2;
                        var17 = var15 + var3;
                        var18 = var4 + var14;
                        if(var17 > 0 && var18 > 0 && var17 < 103 && var18 < 103) {
                           ObjectComposition var19 = class80.getObjectDefinition(var9);
                           if(var16 != 22 || !Client.lowMemory || var19.int1 != 0 || var19.clipType == 1 || var19.obstructsGround) {
                              if(!var19.method5085()) {
                                 ++Client.field910;
                                 var7 = false;
                              }

                              var12 = true;
                           }
                        }
                     }

                     var13 = var8.getUSmart();
                     if(var13 == 0) {
                        break;
                     }

                     var8.readUnsignedByte();
                  }
               }
            }
         }

         if(!var0) {
            Client.field1002 = 2;
         } else {
            if(Client.field1002 != 0) {
               class5.method16("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
            }

            class36.method545();
            GameSocket.region.reset();

            for(var1 = 0; var1 < 4; ++var1) {
               Client.collisionMaps[var1].reset();
            }

            int var44;
            for(var1 = 0; var1 < 4; ++var1) {
               for(var44 = 0; var44 < 104; ++var44) {
                  for(var3 = 0; var3 < 104; ++var3) {
                     class62.tileSettings[var1][var44][var3] = 0;
                  }
               }
            }

            class36.method545();
            class57.method883();
            var1 = class88.field1323.length;
            NetWriter.method2150();
            Overlay.flush(true);
            int var5;
            int var6;
            int var61;
            int var63;
            if(!Client.isDynamicRegion) {
               byte[] var45;
               for(var44 = 0; var44 < var1; ++var44) {
                  var3 = (class20.mapRegions[var44] >> 8) * 64 - ClientPacket.baseX;
                  var4 = (class20.mapRegions[var44] & 255) * 64 - MapIconReference.baseY;
                  var45 = class88.field1323[var44];
                  if(var45 != null) {
                     class36.method545();
                     var6 = class169.field2206 * 8 - 48;
                     var61 = class36.field493 * 8 - 48;
                     CollisionData[] var62 = Client.collisionMaps;

                     for(var9 = 0; var9 < 4; ++var9) {
                        for(var10 = 0; var10 < 64; ++var10) {
                           for(var11 = 0; var11 < 64; ++var11) {
                              if(var10 + var3 > 0 && var10 + var3 < 103 && var4 + var11 > 0 && var4 + var11 < 103) {
                                 var62[var9].flags[var3 + var10][var11 + var4] &= -16777217;
                              }
                           }
                        }
                     }

                     Buffer var46 = new Buffer(var45);

                     for(var10 = 0; var10 < 4; ++var10) {
                        for(var11 = 0; var11 < 64; ++var11) {
                           for(var63 = 0; var63 < 64; ++var63) {
                              class88.loadTerrain(var46, var10, var11 + var3, var63 + var4, var6, var61, 0);
                           }
                        }
                     }
                  }
               }

               for(var44 = 0; var44 < var1; ++var44) {
                  var3 = (class20.mapRegions[var44] >> 8) * 64 - ClientPacket.baseX;
                  var4 = (class20.mapRegions[var44] & 255) * 64 - MapIconReference.baseY;
                  var45 = class88.field1323[var44];
                  if(var45 == null && class36.field493 < 800) {
                     class36.method545();
                     GameEngine.method916(var3, var4, 64, 64);
                  }
               }

               Overlay.flush(true);

               for(var44 = 0; var44 < var1; ++var44) {
                  byte[] var51 = BoundingBox3DDrawMode.field270[var44];
                  if(var51 != null) {
                     var4 = (class20.mapRegions[var44] >> 8) * 64 - ClientPacket.baseX;
                     var5 = (class20.mapRegions[var44] & 255) * 64 - MapIconReference.baseY;
                     class36.method545();
                     class169.method3364(var51, var4, var5, GameSocket.region, Client.collisionMaps);
                  }
               }
            }

            int var20;
            int var21;
            int var22;
            int var23;
            int var24;
            int var25;
            int var26;
            int var27;
            int var28;
            int var29;
            int var32;
            int var33;
            int var34;
            int var35;
            int var36;
            int var38;
            int var39;
            int var40;
            int var47;
            int var50;
            if(Client.isDynamicRegion) {
               CollisionData[] var49;
               Buffer var64;
               for(var44 = 0; var44 < 4; ++var44) {
                  class36.method545();

                  for(var3 = 0; var3 < 13; ++var3) {
                     for(var4 = 0; var4 < 13; ++var4) {
                        boolean var60 = false;
                        var6 = Client.instanceTemplateChunks[var44][var3][var4];
                        if(var6 != -1) {
                           var61 = var6 >> 24 & 3;
                           var47 = var6 >> 1 & 3;
                           var9 = var6 >> 14 & 1023;
                           var10 = var6 >> 3 & 2047;
                           var11 = (var9 / 8 << 8) + var10 / 8;

                           for(var63 = 0; var63 < class20.mapRegions.length; ++var63) {
                              if(class20.mapRegions[var63] == var11 && class88.field1323[var63] != null) {
                                 byte[] var48 = class88.field1323[var63];
                                 var14 = var3 * 8;
                                 var15 = var4 * 8;
                                 var16 = (var9 & 7) * 8;
                                 var17 = (var10 & 7) * 8;
                                 var49 = Client.collisionMaps;

                                 for(var50 = 0; var50 < 8; ++var50) {
                                    for(var20 = 0; var20 < 8; ++var20) {
                                       if(var14 + var50 > 0 && var50 + var14 < 103 && var20 + var15 > 0 && var15 + var20 < 103) {
                                          var49[var44].flags[var14 + var50][var20 + var15] &= -16777217;
                                       }
                                    }
                                 }

                                 var64 = new Buffer(var48);

                                 for(var20 = 0; var20 < 4; ++var20) {
                                    for(var21 = 0; var21 < 64; ++var21) {
                                       for(var22 = 0; var22 < 64; ++var22) {
                                          if(var20 == var61 && var21 >= var16 && var21 < var16 + 8 && var22 >= var17 && var22 < var17 + 8) {
                                             var27 = var21 & 7;
                                             var28 = var22 & 7;
                                             var29 = var47 & 3;
                                             if(var29 == 0) {
                                                var26 = var27;
                                             } else if(var29 == 1) {
                                                var26 = var28;
                                             } else if(var29 == 2) {
                                                var26 = 7 - var27;
                                             } else {
                                                var26 = 7 - var28;
                                             }

                                             class88.loadTerrain(var64, var44, var14 + var26, var15 + GraphicsObject.method1919(var21 & 7, var22 & 7, var47), 0, 0, var47);
                                          } else {
                                             class88.loadTerrain(var64, 0, -1, -1, 0, 0, 0);
                                          }
                                       }
                                    }
                                 }

                                 var60 = true;
                                 break;
                              }
                           }
                        }

                        if(!var60) {
                           FriendManager.method1842(var44, var3 * 8, var4 * 8);
                        }
                     }
                  }
               }

               for(var44 = 0; var44 < 13; ++var44) {
                  for(var3 = 0; var3 < 13; ++var3) {
                     var4 = Client.instanceTemplateChunks[0][var44][var3];
                     if(var4 == -1) {
                        GameEngine.method916(var44 * 8, var3 * 8, 8, 8);
                     }
                  }
               }

               Overlay.flush(true);

               for(var44 = 0; var44 < 4; ++var44) {
                  class36.method545();

                  for(var3 = 0; var3 < 13; ++var3) {
                     label1221:
                     for(var4 = 0; var4 < 13; ++var4) {
                        var5 = Client.instanceTemplateChunks[var44][var3][var4];
                        if(var5 != -1) {
                           var6 = var5 >> 24 & 3;
                           var61 = var5 >> 1 & 3;
                           var47 = var5 >> 14 & 1023;
                           var9 = var5 >> 3 & 2047;
                           var10 = (var47 / 8 << 8) + var9 / 8;

                           for(var11 = 0; var11 < class20.mapRegions.length; ++var11) {
                              if(class20.mapRegions[var11] == var10 && BoundingBox3DDrawMode.field270[var11] != null) {
                                 byte[] var54 = BoundingBox3DDrawMode.field270[var11];
                                 var13 = var3 * 8;
                                 var14 = var4 * 8;
                                 var15 = (var47 & 7) * 8;
                                 var16 = (var9 & 7) * 8;
                                 Region var53 = GameSocket.region;
                                 var49 = Client.collisionMaps;
                                 var64 = new Buffer(var54);
                                 var20 = -1;

                                 while(true) {
                                    var21 = var64.getUSmart();
                                    if(var21 == 0) {
                                       continue label1221;
                                    }

                                    var20 += var21;
                                    var22 = 0;

                                    while(true) {
                                       var23 = var64.getUSmart();
                                       if(var23 == 0) {
                                          break;
                                       }

                                       var22 += var23 - 1;
                                       var24 = var22 & 63;
                                       var25 = var22 >> 6 & 63;
                                       var26 = var22 >> 12;
                                       var27 = var64.readUnsignedByte();
                                       var28 = var27 >> 2;
                                       var29 = var27 & 3;
                                       if(var26 == var6 && var25 >= var15 && var25 < var15 + 8 && var24 >= var16 && var24 < var16 + 8) {
                                          ObjectComposition var56 = class80.getObjectDefinition(var20);
                                          var33 = var25 & 7;
                                          var34 = var24 & 7;
                                          var36 = var56.width;
                                          int var57 = var56.length;
                                          if((var29 & 1) == 1) {
                                             var38 = var36;
                                             var36 = var57;
                                             var57 = var38;
                                          }

                                          var35 = var61 & 3;
                                          if(var35 == 0) {
                                             var32 = var33;
                                          } else if(var35 == 1) {
                                             var32 = var34;
                                          } else if(var35 == 2) {
                                             var32 = 7 - var33 - (var36 - 1);
                                          } else {
                                             var32 = 7 - var34 - (var57 - 1);
                                          }

                                          var38 = var13 + var32;
                                          var39 = var14 + CacheFile.method2633(var25 & 7, var24 & 7, var61, var56.width, var56.length, var29);
                                          if(var38 > 0 && var39 > 0 && var38 < 103 && var39 < 103) {
                                             var40 = var44;
                                             if((class62.tileSettings[1][var38][var39] & 2) == 2) {
                                                var40 = var44 - 1;
                                             }

                                             CollisionData var58 = null;
                                             if(var40 >= 0) {
                                                var58 = var49[var40];
                                             }

                                             WorldMapType3.addObject(var44, var38, var39, var20, var29 + var61 & 3, var28, var53, var58);
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

            Overlay.flush(true);
            class36.method545();
            Region var59 = GameSocket.region;
            CollisionData[] var71 = Client.collisionMaps;

            for(var4 = 0; var4 < 4; ++var4) {
               for(var5 = 0; var5 < 104; ++var5) {
                  for(var6 = 0; var6 < 104; ++var6) {
                     if((class62.tileSettings[var4][var5][var6] & 1) == 1) {
                        var61 = var4;
                        if((class62.tileSettings[1][var5][var6] & 2) == 2) {
                           var61 = var4 - 1;
                        }

                        if(var61 >= 0) {
                           var71[var61].method3477(var5, var6);
                        }
                     }
                  }
               }
            }

            class62.field733 += (int)(Math.random() * 5.0D) - 2;
            if(class62.field733 < -8) {
               class62.field733 = -8;
            }

            if(class62.field733 > 8) {
               class62.field733 = 8;
            }

            class62.field734 += (int)(Math.random() * 5.0D) - 2;
            if(class62.field734 < -16) {
               class62.field734 = -16;
            }

            if(class62.field734 > 16) {
               class62.field734 = 16;
            }

            for(var4 = 0; var4 < 4; ++var4) {
               byte[][] var68 = WorldMapType2.field519[var4];
               var11 = (int)Math.sqrt(5100.0D);
               var63 = var11 * 768 >> 8;

               for(var13 = 1; var13 < 103; ++var13) {
                  for(var14 = 1; var14 < 103; ++var14) {
                     var15 = class62.tileHeights[var4][var14 + 1][var13] - class62.tileHeights[var4][var14 - 1][var13];
                     var16 = class62.tileHeights[var4][var14][var13 + 1] - class62.tileHeights[var4][var14][var13 - 1];
                     var17 = (int)Math.sqrt((double)(var15 * var15 + var16 * var16 + 65536));
                     var18 = (var15 << 8) / var17;
                     var50 = 65536 / var17;
                     var20 = (var16 << 8) / var17;
                     var21 = (var20 * -50 + var18 * -50 + var50 * -10) / var63 + 96;
                     var22 = (var68[var14 - 1][var13] >> 2) + (var68[var14][var13 - 1] >> 2) + (var68[var14 + 1][var13] >> 3) + (var68[var14][var13 + 1] >> 3) + (var68[var14][var13] >> 1);
                     class297.field3834[var14][var13] = var21 - var22;
                  }
               }

               for(var13 = 0; var13 < 104; ++var13) {
                  class62.floorHues[var13] = 0;
                  ItemContainer.floorSaturations[var13] = 0;
                  GZipDecompressor.field2501[var13] = 0;
                  WorldComparator.floorMultiplier[var13] = 0;
                  MapIconReference.field588[var13] = 0;
               }

               for(var13 = -5; var13 < 109; ++var13) {
                  for(var14 = 0; var14 < 104; ++var14) {
                     var15 = var13 + 5;
                     if(var15 >= 0 && var15 < 104) {
                        var16 = class62.tileUnderlayIds[var4][var15][var14] & 255;
                        if(var16 > 0) {
                           FloorUnderlayDefinition var72 = Frames.getUnderlayDefinition(var16 - 1);
                           class62.floorHues[var14] += var72.hue;
                           ItemContainer.floorSaturations[var14] += var72.saturation;
                           GZipDecompressor.field2501[var14] += var72.lightness;
                           WorldComparator.floorMultiplier[var14] += var72.hueMultiplier;
                           ++MapIconReference.field588[var14];
                        }
                     }

                     var16 = var13 - 5;
                     if(var16 >= 0 && var16 < 104) {
                        var17 = class62.tileUnderlayIds[var4][var16][var14] & 255;
                        if(var17 > 0) {
                           FloorUnderlayDefinition var70 = Frames.getUnderlayDefinition(var17 - 1);
                           class62.floorHues[var14] -= var70.hue;
                           ItemContainer.floorSaturations[var14] -= var70.saturation;
                           GZipDecompressor.field2501[var14] -= var70.lightness;
                           WorldComparator.floorMultiplier[var14] -= var70.hueMultiplier;
                           --MapIconReference.field588[var14];
                        }
                     }
                  }

                  if(var13 >= 1 && var13 < 103) {
                     var14 = 0;
                     var15 = 0;
                     var16 = 0;
                     var17 = 0;
                     var18 = 0;

                     for(var50 = -5; var50 < 109; ++var50) {
                        var20 = var50 + 5;
                        if(var20 >= 0 && var20 < 104) {
                           var14 += class62.floorHues[var20];
                           var15 += ItemContainer.floorSaturations[var20];
                           var16 += GZipDecompressor.field2501[var20];
                           var17 += WorldComparator.floorMultiplier[var20];
                           var18 += MapIconReference.field588[var20];
                        }

                        var21 = var50 - 5;
                        if(var21 >= 0 && var21 < 104) {
                           var14 -= class62.floorHues[var21];
                           var15 -= ItemContainer.floorSaturations[var21];
                           var16 -= GZipDecompressor.field2501[var21];
                           var17 -= WorldComparator.floorMultiplier[var21];
                           var18 -= MapIconReference.field588[var21];
                        }

                        if(var50 >= 1 && var50 < 103 && (!Client.lowMemory || (class62.tileSettings[0][var13][var50] & 2) != 0 || (class62.tileSettings[var4][var13][var50] & 16) == 0)) {
                           if(var4 < class62.field722) {
                              class62.field722 = var4;
                           }

                           var22 = class62.tileUnderlayIds[var4][var13][var50] & 255;
                           var23 = class21.tileOverlayIds[var4][var13][var50] & 255;
                           if(var22 > 0 || var23 > 0) {
                              var24 = class62.tileHeights[var4][var13][var50];
                              var25 = class62.tileHeights[var4][var13 + 1][var50];
                              var26 = class62.tileHeights[var4][var13 + 1][var50 + 1];
                              var27 = class62.tileHeights[var4][var13][var50 + 1];
                              var28 = class297.field3834[var13][var50];
                              var29 = class297.field3834[var13 + 1][var50];
                              int var30 = class297.field3834[var13 + 1][var50 + 1];
                              int var31 = class297.field3834[var13][var50 + 1];
                              var32 = -1;
                              var33 = -1;
                              if(var22 > 0) {
                                 var34 = var14 * 256 / var17;
                                 var35 = var15 / var18;
                                 var36 = var16 / var18;
                                 var32 = Fonts.method5548(var34, var35, var36);
                                 var34 = var34 + class62.field733 & 255;
                                 var36 += class62.field734;
                                 if(var36 < 0) {
                                    var36 = 0;
                                 } else if(var36 > 255) {
                                    var36 = 255;
                                 }

                                 var33 = Fonts.method5548(var34, var35, var36);
                              }

                              if(var4 > 0) {
                                 boolean var66 = true;
                                 if(var22 == 0 && class62.tileOverlayPath[var4][var13][var50] != 0) {
                                    var66 = false;
                                 }

                                 if(var23 > 0 && !class229.getOverlayDefinition(var23 - 1).isHidden) {
                                    var66 = false;
                                 }

                                 if(var66 && var24 == var25 && var24 == var26 && var24 == var27) {
                                    BoundingBox3DDrawMode.field271[var4][var13][var50] |= 2340;
                                 }
                              }

                              var34 = 0;
                              if(var33 != -1) {
                                 var34 = Graphics3D.colorPalette[DynamicObject.method2115(var33, 96)];
                              }

                              if(var23 == 0) {
                                 var59.addTile(var4, var13, var50, 0, 0, -1, var24, var25, var26, var27, DynamicObject.method2115(var32, var28), DynamicObject.method2115(var32, var29), DynamicObject.method2115(var32, var30), DynamicObject.method2115(var32, var31), 0, 0, 0, 0, var34, 0);
                              } else {
                                 var35 = class62.tileOverlayPath[var4][var13][var50] + 1;
                                 byte var67 = class62.overlayRotations[var4][var13][var50];
                                 Overlay var37 = class229.getOverlayDefinition(var23 - 1);
                                 var38 = var37.texture;
                                 int var41;
                                 int var42;
                                 if(var38 >= 0) {
                                    var40 = Graphics3D.textureLoader.getAverageTextureRGB(var38);
                                    var39 = -1;
                                 } else if(var37.color == 16711935) {
                                    var39 = -2;
                                    var38 = -1;
                                    var40 = -2;
                                 } else {
                                    var39 = Fonts.method5548(var37.hue, var37.saturation, var37.lightness);
                                    var41 = var37.hue + class62.field733 & 255;
                                    var42 = var37.lightness + class62.field734;
                                    if(var42 < 0) {
                                       var42 = 0;
                                    } else if(var42 > 255) {
                                       var42 = 255;
                                    }

                                    var40 = Fonts.method5548(var41, var37.saturation, var42);
                                 }

                                 var41 = 0;
                                 if(var40 != -2) {
                                    var41 = Graphics3D.colorPalette[adjustHSLListness0(var40, 96)];
                                 }

                                 if(var37.otherRgbColor != -1) {
                                    var42 = var37.otherHue + class62.field733 & 255;
                                    int var43 = var37.otherLightness + class62.field734;
                                    if(var43 < 0) {
                                       var43 = 0;
                                    } else if(var43 > 255) {
                                       var43 = 255;
                                    }

                                    var40 = Fonts.method5548(var42, var37.otherSaturation, var43);
                                    var41 = Graphics3D.colorPalette[adjustHSLListness0(var40, 96)];
                                 }

                                 var59.addTile(var4, var13, var50, var35, var67, var38, var24, var25, var26, var27, DynamicObject.method2115(var32, var28), DynamicObject.method2115(var32, var29), DynamicObject.method2115(var32, var30), DynamicObject.method2115(var32, var31), adjustHSLListness0(var39, var28), adjustHSLListness0(var39, var29), adjustHSLListness0(var39, var30), adjustHSLListness0(var39, var31), var34, var41);
                              }
                           }
                        }
                     }
                  }
               }

               for(var13 = 1; var13 < 103; ++var13) {
                  for(var14 = 1; var14 < 103; ++var14) {
                     if((class62.tileSettings[var4][var14][var13] & 8) != 0) {
                        var50 = 0;
                     } else if(var4 > 0 && (class62.tileSettings[1][var14][var13] & 2) != 0) {
                        var50 = var4 - 1;
                     } else {
                        var50 = var4;
                     }

                     var59.setPhysicalLevel(var4, var14, var13, var50);
                  }
               }

               class62.tileUnderlayIds[var4] = null;
               class21.tileOverlayIds[var4] = null;
               class62.tileOverlayPath[var4] = null;
               class62.overlayRotations[var4] = null;
               WorldMapType2.field519[var4] = null;
            }

            var59.applyLighting(-50, -10, -50);

            for(var4 = 0; var4 < 104; ++var4) {
               for(var5 = 0; var5 < 104; ++var5) {
                  if((class62.tileSettings[1][var4][var5] & 2) == 2) {
                     var59.setBridge(var4, var5);
                  }
               }
            }

            var4 = 1;
            var5 = 2;
            var6 = 4;

            for(var61 = 0; var61 < 4; ++var61) {
               if(var61 > 0) {
                  var4 <<= 3;
                  var5 <<= 3;
                  var6 <<= 3;
               }

               for(var47 = 0; var47 <= var61; ++var47) {
                  for(var9 = 0; var9 <= 104; ++var9) {
                     for(var10 = 0; var10 <= 104; ++var10) {
                        short var65;
                        if((BoundingBox3DDrawMode.field271[var47][var10][var9] & var4) != 0) {
                           var11 = var9;
                           var63 = var9;
                           var13 = var47;

                           for(var14 = var47; var11 > 0 && (BoundingBox3DDrawMode.field271[var47][var10][var11 - 1] & var4) != 0; --var11) {
                              ;
                           }

                           while(var63 < 104 && (BoundingBox3DDrawMode.field271[var47][var10][var63 + 1] & var4) != 0) {
                              ++var63;
                           }

                           label949:
                           while(var13 > 0) {
                              for(var15 = var11; var15 <= var63; ++var15) {
                                 if((BoundingBox3DDrawMode.field271[var13 - 1][var10][var15] & var4) == 0) {
                                    break label949;
                                 }
                              }

                              --var13;
                           }

                           label938:
                           while(var14 < var61) {
                              for(var15 = var11; var15 <= var63; ++var15) {
                                 if((BoundingBox3DDrawMode.field271[var14 + 1][var10][var15] & var4) == 0) {
                                    break label938;
                                 }
                              }

                              ++var14;
                           }

                           var15 = (var63 - var11 + 1) * (var14 + 1 - var13);
                           if(var15 >= 8) {
                              var65 = 240;
                              var17 = class62.tileHeights[var14][var10][var11] - var65;
                              var18 = class62.tileHeights[var13][var10][var11];
                              Region.addOcclude(var61, 1, var10 * 128, var10 * 128, var11 * 128, var63 * 128 + 128, var17, var18);

                              for(var50 = var13; var50 <= var14; ++var50) {
                                 for(var20 = var11; var20 <= var63; ++var20) {
                                    BoundingBox3DDrawMode.field271[var50][var10][var20] &= ~var4;
                                 }
                              }
                           }
                        }

                        if((BoundingBox3DDrawMode.field271[var47][var10][var9] & var5) != 0) {
                           var11 = var10;
                           var63 = var10;
                           var13 = var47;

                           for(var14 = var47; var11 > 0 && (BoundingBox3DDrawMode.field271[var47][var11 - 1][var9] & var5) != 0; --var11) {
                              ;
                           }

                           while(var63 < 104 && (BoundingBox3DDrawMode.field271[var47][var63 + 1][var9] & var5) != 0) {
                              ++var63;
                           }

                           label1002:
                           while(var13 > 0) {
                              for(var15 = var11; var15 <= var63; ++var15) {
                                 if((BoundingBox3DDrawMode.field271[var13 - 1][var15][var9] & var5) == 0) {
                                    break label1002;
                                 }
                              }

                              --var13;
                           }

                           label991:
                           while(var14 < var61) {
                              for(var15 = var11; var15 <= var63; ++var15) {
                                 if((BoundingBox3DDrawMode.field271[var14 + 1][var15][var9] & var5) == 0) {
                                    break label991;
                                 }
                              }

                              ++var14;
                           }

                           var15 = (var14 + 1 - var13) * (var63 - var11 + 1);
                           if(var15 >= 8) {
                              var65 = 240;
                              var17 = class62.tileHeights[var14][var11][var9] - var65;
                              var18 = class62.tileHeights[var13][var11][var9];
                              Region.addOcclude(var61, 2, var11 * 128, var63 * 128 + 128, var9 * 128, var9 * 128, var17, var18);

                              for(var50 = var13; var50 <= var14; ++var50) {
                                 for(var20 = var11; var20 <= var63; ++var20) {
                                    BoundingBox3DDrawMode.field271[var50][var20][var9] &= ~var5;
                                 }
                              }
                           }
                        }

                        if((BoundingBox3DDrawMode.field271[var47][var10][var9] & var6) != 0) {
                           var11 = var10;
                           var63 = var10;
                           var13 = var9;

                           for(var14 = var9; var13 > 0 && (BoundingBox3DDrawMode.field271[var47][var10][var13 - 1] & var6) != 0; --var13) {
                              ;
                           }

                           while(var14 < 104 && (BoundingBox3DDrawMode.field271[var47][var10][var14 + 1] & var6) != 0) {
                              ++var14;
                           }

                           label1055:
                           while(var11 > 0) {
                              for(var15 = var13; var15 <= var14; ++var15) {
                                 if((BoundingBox3DDrawMode.field271[var47][var11 - 1][var15] & var6) == 0) {
                                    break label1055;
                                 }
                              }

                              --var11;
                           }

                           label1044:
                           while(var63 < 104) {
                              for(var15 = var13; var15 <= var14; ++var15) {
                                 if((BoundingBox3DDrawMode.field271[var47][var63 + 1][var15] & var6) == 0) {
                                    break label1044;
                                 }
                              }

                              ++var63;
                           }

                           if((var63 - var11 + 1) * (var14 - var13 + 1) >= 4) {
                              var15 = class62.tileHeights[var47][var11][var13];
                              Region.addOcclude(var61, 4, var11 * 128, var63 * 128 + 128, var13 * 128, var14 * 128 + 128, var15, var15);

                              for(var16 = var11; var16 <= var63; ++var16) {
                                 for(var17 = var13; var17 <= var14; ++var17) {
                                    BoundingBox3DDrawMode.field271[var47][var16][var17] &= ~var6;
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }

            Overlay.flush(true);
            var4 = class62.field722;
            if(var4 > ScriptVarType.plane) {
               var4 = ScriptVarType.plane;
            }

            if(var4 < ScriptVarType.plane - 1) {
               var4 = ScriptVarType.plane - 1;
            }

            if(Client.lowMemory) {
               GameSocket.region.setup(class62.field722);
            } else {
               GameSocket.region.setup(0);
            }

            for(var5 = 0; var5 < 104; ++var5) {
               for(var6 = 0; var6 < 104; ++var6) {
                  class177.groundItemSpawned(var5, var6);
               }
            }

            class36.method545();
            class318.method5710();
            ObjectComposition.field3594.reset();
            PacketNode var69;
            if(InvType.clientInstance.method934()) {
               var69 = AbstractSoundSystem.method2350(ClientPacket.field2397, Client.field911.field1460);
               var69.packetBuffer.putInt(1057001181);
               Client.field911.method2135(var69);
            }

            if(!Client.isDynamicRegion) {
               var5 = (class169.field2206 - 6) / 8;
               var6 = (class169.field2206 + 6) / 8;
               var61 = (class36.field493 - 6) / 8;
               var47 = (class36.field493 + 6) / 8;

               for(var9 = var5 - 1; var9 <= var6 + 1; ++var9) {
                  for(var10 = var61 - 1; var10 <= var47 + 1; ++var10) {
                     if(var9 < var5 || var9 > var6 || var10 < var61 || var10 > var47) {
                        SoundTaskDataProvider.indexMaps.method4667("m" + var9 + "_" + var10);
                        SoundTaskDataProvider.indexMaps.method4667("l" + var9 + "_" + var10);
                     }
                  }
               }
            }

            class55.setGameState(30);
            class36.method545();
            class62.tileUnderlayIds = null;
            class21.tileOverlayIds = null;
            class62.tileOverlayPath = null;
            class62.overlayRotations = null;
            BoundingBox3DDrawMode.field271 = null;
            WorldMapType2.field519 = null;
            class297.field3834 = null;
            class62.floorHues = null;
            ItemContainer.floorSaturations = null;
            GZipDecompressor.field2501 = null;
            WorldComparator.floorMultiplier = null;
            MapIconReference.field588 = null;
            var69 = AbstractSoundSystem.method2350(ClientPacket.field2452, Client.field911.field1460);
            Client.field911.method2135(var69);
            class155.method3236();
         }
      }
   }
}
