import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eh")
public class class142 extends Node {
   @ObfuscatedName("l")
   byte[] field2012 = new byte[128];
   @ObfuscatedName("u")
   short[] field2013 = new short[128];
   @ObfuscatedName("h")
   byte[] field2014 = new byte[128];
   @ObfuscatedName("r")
   byte[] field2015 = new byte[128];
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1097009983
   )
   int field2016;
   @ObfuscatedName("o")
   class137[] field2017 = new class137[128];
   @ObfuscatedName("n")
   int[] field2018 = new int[128];
   @ObfuscatedName("i")
   class55[] field2019 = new class55[128];

   class142(byte[] var1) {
      Buffer var2 = new Buffer(var1);

      int var3;
      for(var3 = 0; var2.payload[var3 + var2.offset] != 0; ++var3) {
         ;
      }

      byte[] var4 = new byte[var3];

      int var5;
      for(var5 = 0; var5 < var3; ++var5) {
         var4[var5] = var2.readByte();
      }

      ++var2.offset;
      ++var3;
      var5 = var2.offset;
      var2.offset += var3;

      int var6;
      for(var6 = 0; var2.payload[var6 + var2.offset] != 0; ++var6) {
         ;
      }

      byte[] var7 = new byte[var6];

      int var8;
      for(var8 = 0; var8 < var6; ++var8) {
         var7[var8] = var2.readByte();
      }

      ++var2.offset;
      ++var6;
      var8 = var2.offset;
      var2.offset += var6;

      int var9;
      for(var9 = 0; var2.payload[var9 + var2.offset] != 0; ++var9) {
         ;
      }

      byte[] var10 = new byte[var9];

      for(int var11 = 0; var11 < var9; ++var11) {
         var10[var11] = var2.readByte();
      }

      ++var2.offset;
      ++var9;
      byte[] var39 = new byte[var9];
      int var12;
      int var14;
      if(var9 > 1) {
         var39[1] = 1;
         int var37 = 1;
         var12 = 2;

         for(var14 = 2; var14 < var9; ++var14) {
            int var38 = var2.readUnsignedByte();
            if(var38 == 0) {
               var37 = var12++;
            } else {
               if(var38 <= var37) {
                  --var38;
               }

               var37 = var38;
            }

            var39[var14] = (byte)var37;
         }
      } else {
         var12 = var9;
      }

      class137[] var13 = new class137[var12];

      class137 var15;
      for(var14 = 0; var14 < var13.length; ++var14) {
         var15 = var13[var14] = new class137();
         int var40 = var2.readUnsignedByte();
         if(var40 > 0) {
            var15.field1924 = new byte[2 * var40];
         }

         var40 = var2.readUnsignedByte();
         if(var40 > 0) {
            var15.field1925 = new byte[2 * var40 + 2];
            var15.field1925[1] = 64;
         }
      }

      var14 = var2.readUnsignedByte();
      byte[] var42 = var14 > 0?new byte[2 * var14]:null;
      var14 = var2.readUnsignedByte();
      byte[] var16 = var14 > 0?new byte[var14 * 2]:null;

      int var17;
      for(var17 = 0; var2.payload[var2.offset + var17] != 0; ++var17) {
         ;
      }

      byte[] var18 = new byte[var17];

      int var19;
      for(var19 = 0; var19 < var17; ++var19) {
         var18[var19] = var2.readByte();
      }

      ++var2.offset;
      ++var17;
      var19 = 0;

      int var20;
      for(var20 = 0; var20 < 128; ++var20) {
         var19 += var2.readUnsignedByte();
         this.field2013[var20] = (short)var19;
      }

      var19 = 0;

      for(var20 = 0; var20 < 128; ++var20) {
         var19 += var2.readUnsignedByte();
         this.field2013[var20] = (short)(this.field2013[var20] + (var19 << 8));
      }

      var20 = 0;
      int var21 = 0;
      int var22 = 0;

      int var23;
      for(var23 = 0; var23 < 128; ++var23) {
         if(var20 == 0) {
            if(var21 < var18.length) {
               var20 = var18[var21++];
            } else {
               var20 = -1;
            }

            var22 = var2.method2883();
         }

         this.field2013[var23] = (short)(this.field2013[var23] + ((var22 - 1 & 2) << 14));
         this.field2018[var23] = var22;
         --var20;
      }

      var20 = 0;
      var21 = 0;
      var23 = 0;

      int var24;
      for(var24 = 0; var24 < 128; ++var24) {
         if(this.field2018[var24] != 0) {
            if(var20 == 0) {
               if(var21 < var4.length) {
                  var20 = var4[var21++];
               } else {
                  var20 = -1;
               }

               var23 = var2.payload[var5++] - 1;
            }

            this.field2012[var24] = (byte)var23;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      var24 = 0;

      for(int var25 = 0; var25 < 128; ++var25) {
         if(this.field2018[var25] != 0) {
            if(var20 == 0) {
               if(var21 < var7.length) {
                  var20 = var7[var21++];
               } else {
                  var20 = -1;
               }

               var24 = var2.payload[var8++] + 16 << 2;
            }

            this.field2015[var25] = (byte)var24;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      class137 var41 = null;

      int var26;
      for(var26 = 0; var26 < 128; ++var26) {
         if(this.field2018[var26] != 0) {
            if(var20 == 0) {
               var41 = var13[var39[var21]];
               if(var21 < var10.length) {
                  var20 = var10[var21++];
               } else {
                  var20 = -1;
               }
            }

            this.field2017[var26] = var41;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      var26 = 0;

      int var27;
      for(var27 = 0; var27 < 128; ++var27) {
         if(var20 == 0) {
            if(var21 < var18.length) {
               var20 = var18[var21++];
            } else {
               var20 = -1;
            }

            if(this.field2018[var27] > 0) {
               var26 = var2.readUnsignedByte() + 1;
            }
         }

         this.field2014[var27] = (byte)var26;
         --var20;
      }

      this.field2016 = var2.readUnsignedByte() + 1;

      class137 var28;
      int var29;
      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(var28.field1924 != null) {
            for(var29 = 1; var29 < var28.field1924.length; var29 += 2) {
               var28.field1924[var29] = var2.readByte();
            }
         }

         if(var28.field1925 != null) {
            for(var29 = 3; var29 < var28.field1925.length - 2; var29 += 2) {
               var28.field1925[var29] = var2.readByte();
            }
         }
      }

      if(var42 != null) {
         for(var27 = 1; var27 < var42.length; var27 += 2) {
            var42[var27] = var2.readByte();
         }
      }

      if(null != var16) {
         for(var27 = 1; var27 < var16.length; var27 += 2) {
            var16[var27] = var2.readByte();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(var28.field1925 != null) {
            var19 = 0;

            for(var29 = 2; var29 < var28.field1925.length; var29 += 2) {
               var19 = var19 + 1 + var2.readUnsignedByte();
               var28.field1925[var29] = (byte)var19;
            }
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(var28.field1924 != null) {
            var19 = 0;

            for(var29 = 2; var29 < var28.field1924.length; var29 += 2) {
               var19 = var19 + 1 + var2.readUnsignedByte();
               var28.field1924[var29] = (byte)var19;
            }
         }
      }

      byte var30;
      int var32;
      int var33;
      int var34;
      int var44;
      byte var46;
      if(null != var42) {
         var19 = var2.readUnsignedByte();
         var42[0] = (byte)var19;

         for(var27 = 2; var27 < var42.length; var27 += 2) {
            var19 = var19 + 1 + var2.readUnsignedByte();
            var42[var27] = (byte)var19;
         }

         var46 = var42[0];
         byte var36 = var42[1];

         for(var29 = 0; var29 < var46; ++var29) {
            this.field2014[var29] = (byte)(this.field2014[var29] * var36 + 32 >> 6);
         }

         for(var29 = 2; var29 < var42.length; var29 += 2) {
            var30 = var42[var29];
            byte var31 = var42[var29 + 1];
            var32 = (var30 - var46) / 2 + var36 * (var30 - var46);

            for(var33 = var46; var33 < var30; ++var33) {
               var34 = RSCanvas.method2123(var32, var30 - var46);
               this.field2014[var33] = (byte)(32 + this.field2014[var33] * var34 >> 6);
               var32 += var31 - var36;
            }

            var46 = var30;
            var36 = var31;
         }

         for(var44 = var46; var44 < 128; ++var44) {
            this.field2014[var44] = (byte)(this.field2014[var44] * var36 + 32 >> 6);
         }

         var15 = null;
      }

      if(var16 != null) {
         var19 = var2.readUnsignedByte();
         var16[0] = (byte)var19;

         for(var27 = 2; var27 < var16.length; var27 += 2) {
            var19 = 1 + var19 + var2.readUnsignedByte();
            var16[var27] = (byte)var19;
         }

         var46 = var16[0];
         int var47 = var16[1] << 1;

         for(var29 = 0; var29 < var46; ++var29) {
            var44 = var47 + (this.field2015[var29] & 255);
            if(var44 < 0) {
               var44 = 0;
            }

            if(var44 > 128) {
               var44 = 128;
            }

            this.field2015[var29] = (byte)var44;
         }

         int var45;
         for(var29 = 2; var29 < var16.length; var29 += 2) {
            var30 = var16[var29];
            var45 = var16[1 + var29] << 1;
            var32 = var47 * (var30 - var46) + (var30 - var46) / 2;

            for(var33 = var46; var33 < var30; ++var33) {
               var34 = RSCanvas.method2123(var32, var30 - var46);
               int var35 = var34 + (this.field2015[var33] & 255);
               if(var35 < 0) {
                  var35 = 0;
               }

               if(var35 > 128) {
                  var35 = 128;
               }

               this.field2015[var33] = (byte)var35;
               var32 += var45 - var47;
            }

            var46 = var30;
            var47 = var45;
         }

         for(var44 = var46; var44 < 128; ++var44) {
            var45 = (this.field2015[var44] & 255) + var47;
            if(var45 < 0) {
               var45 = 0;
            }

            if(var45 > 128) {
               var45 = 128;
            }

            this.field2015[var44] = (byte)var45;
         }

         Object var43 = null;
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var13[var27].field1926 = var2.readUnsignedByte();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(var28.field1924 != null) {
            var28.field1930 = var2.readUnsignedByte();
         }

         if(var28.field1925 != null) {
            var28.field1928 = var2.readUnsignedByte();
         }

         if(var28.field1926 > 0) {
            var28.field1929 = var2.readUnsignedByte();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var13[var27].field1931 = var2.readUnsignedByte();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(var28.field1931 > 0) {
            var28.field1934 = var2.readUnsignedByte();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(var28.field1934 > 0) {
            var28.field1932 = var2.readUnsignedByte();
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-720466805"
   )
   void method2737() {
      this.field2018 = null;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass60;[B[II)Z",
      garbageValue = "1821001489"
   )
   boolean method2741(class60 var1, byte[] var2, int[] var3) {
      boolean var4 = true;
      int var5 = 0;
      class55 var6 = null;

      for(int var7 = 0; var7 < 128; ++var7) {
         if(null == var2 || var2[var7] != 0) {
            int var8 = this.field2018[var7];
            if(var8 != 0) {
               if(var5 != var8) {
                  var5 = var8--;
                  if((var8 & 1) == 0) {
                     var6 = var1.method1173(var8 >> 2, var3);
                  } else {
                     var6 = var1.method1178(var8 >> 2, var3);
                  }

                  if(null == var6) {
                     var4 = false;
                  }
               }

               if(var6 != null) {
                  this.field2019[var7] = var6;
                  this.field2018[var7] = 0;
               }
            }
         }
      }

      return var4;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2138476188"
   )
   public static int method2747() {
      return ++class115.mouseIdleTicks - 1;
   }

   @ObfuscatedName("cg")
   @ObfuscatedSignature(
      signature = "(LNPCComposition;IIII)V",
      garbageValue = "634576205"
   )
   static final void method2748(NPCComposition var0, int var1, int var2, int var3) {
      if(Client.menuOptionCount < 400) {
         if(null != var0.configs) {
            var0 = var0.method3741();
         }

         if(var0 != null) {
            if(var0.field3020) {
               if(!var0.field3007 || Client.field471 == var1) {
                  String var4 = var0.name;
                  if(var0.combatLevel != 0) {
                     var4 = var4 + RSCanvas.method2130(var0.combatLevel, Projectile.localPlayer.combatLevel) + " " + " (" + "level-" + var0.combatLevel + ")";
                  }

                  if(var0.field3007 && Client.field448) {
                     class119.addMenuEntry("Examine", XItemContainer.method153(16776960) + var4, 1003, var1, var2, var3);
                  }

                  if(Client.field455 == 1) {
                     class119.addMenuEntry("Use", Client.field457 + " " + "->" + " " + XItemContainer.method153(16776960) + var4, 7, var1, var2, var3);
                  } else if(Client.field458) {
                     if((ItemComposition.field3004 & 2) == 2) {
                        class119.addMenuEntry(Client.field326, Client.field527 + " " + "->" + " " + XItemContainer.method153(16776960) + var4, 8, var1, var2, var3);
                     }
                  } else {
                     int var5 = var0.field3007 && Client.field448?2000:0;
                     String[] var6 = var0.actions;
                     if(Client.field474) {
                        var6 = class31.method659(var6);
                     }

                     int var7;
                     int var8;
                     if(null != var6) {
                        for(var7 = 4; var7 >= 0; --var7) {
                           if(null != var6[var7] && !var6[var7].equalsIgnoreCase("Attack")) {
                              var8 = 0;
                              if(var7 == 0) {
                                 var8 = var5 + 9;
                              }

                              if(var7 == 1) {
                                 var8 = 10 + var5;
                              }

                              if(var7 == 2) {
                                 var8 = 11 + var5;
                              }

                              if(var7 == 3) {
                                 var8 = 12 + var5;
                              }

                              if(var7 == 4) {
                                 var8 = 13 + var5;
                              }

                              class119.addMenuEntry(var6[var7], XItemContainer.method153(16776960) + var4, var8, var1, var2, var3);
                           }
                        }
                     }

                     if(var6 != null) {
                        for(var7 = 4; var7 >= 0; --var7) {
                           if(var6[var7] != null && var6[var7].equalsIgnoreCase("Attack")) {
                              short var9 = 0;
                              if(Client.field392 != class40.field827) {
                                 if(Client.field392 == class40.field830 || class40.field829 == Client.field392 && var0.combatLevel > Projectile.localPlayer.combatLevel) {
                                    var9 = 2000;
                                 }

                                 var8 = 0;
                                 if(var7 == 0) {
                                    var8 = 9 + var9;
                                 }

                                 if(var7 == 1) {
                                    var8 = 10 + var9;
                                 }

                                 if(var7 == 2) {
                                    var8 = var9 + 11;
                                 }

                                 if(var7 == 3) {
                                    var8 = 12 + var9;
                                 }

                                 if(var7 == 4) {
                                    var8 = 13 + var9;
                                 }

                                 class119.addMenuEntry(var6[var7], XItemContainer.method153(16776960) + var4, var8, var1, var2, var3);
                              }
                           }
                        }
                     }

                     if(!var0.field3007 || !Client.field448) {
                        class119.addMenuEntry("Examine", XItemContainer.method153(16776960) + var4, 1003, var1, var2, var3);
                     }
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1503831326"
   )
   static final void method2749() {
      int var0 = World.menuX;
      int var1 = class104.menuY;
      int var2 = Widget.menuWidth;
      int var3 = class97.menuHeight;
      int var4 = 6116423;
      Rasterizer2D.method4007(var0, var1, var2, var3, var4);
      Rasterizer2D.method4007(1 + var0, var1 + 1, var2 - 2, 16, 0);
      Rasterizer2D.method4013(var0 + 1, var1 + 18, var2 - 2, var3 - 19, 0);
      class63.field1119.method3930("Choose Option", var0 + 3, var1 + 14, var4, -1);
      int var5 = class115.field1817;
      int var6 = class115.field1818;

      for(int var7 = 0; var7 < Client.menuOptionCount; ++var7) {
         int var8 = (Client.menuOptionCount - 1 - var7) * 15 + var1 + 31;
         int var9 = 16777215;
         if(var5 > var0 && var5 < var2 + var0 && var6 > var8 - 13 && var6 < 3 + var8) {
            var9 = 16776960;
         }

         Font var10 = class63.field1119;
         String var11;
         if(var7 < 0) {
            var11 = "";
         } else if(Client.menuTargets[var7].length() > 0) {
            var11 = Client.menuOptions[var7] + " " + Client.menuTargets[var7];
         } else {
            var11 = Client.menuOptions[var7];
         }

         var10.method3930(var11, var0 + 3, var8, var9, 0);
      }

      class10.method105(World.menuX, class104.menuY, Widget.menuWidth, class97.menuHeight);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(LWorld;I)V",
      garbageValue = "92894469"
   )
   static void method2750(World var0) {
      if(var0.method632() != Client.isMembers) {
         Client.isMembers = var0.method632();
         FloorUnderlayDefinition.method3547(var0.method632());
      }

      XGrandExchangeOffer.host = var0.address;
      Client.world = var0.id;
      Client.flags = var0.mask;
      class99.field1671 = Client.field580 == 0?'ꩊ':var0.id + '鱀';
      class0.field4 = Client.field580 == 0?443:'썐' + var0.id;
      Client.field431 = class99.field1671;
   }

   @ObfuscatedName("ce")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-1"
   )
   static final void method2751(int var0, int var1, int var2, int var3) {
      if(Client.field455 == 0 && !Client.field458) {
         class119.addMenuEntry("Walk here", "", 23, 0, var0 - var2, var1 - var3);
      }

      int var4 = -1;
      int var5 = -1;

      int var6;
      int var7;
      for(var6 = 0; var6 < Model.field1421; ++var6) {
         var7 = Model.field1435[var6];
         int var8 = var7 & 127;
         int var9 = var7 >> 7 & 127;
         int var10 = var7 >> 29 & 3;
         int var11 = var7 >> 14 & 32767;
         if(var7 != var5) {
            var5 = var7;
            if(var10 == 2 && CombatInfo1.region.method1766(Sequence.plane, var8, var9, var7) >= 0) {
               ObjectComposition var12 = class140.getObjectDefinition(var11);
               if(null != var12.impostorIds) {
                  var12 = var12.getImpostor();
               }

               if(null == var12) {
                  continue;
               }

               if(Client.field455 == 1) {
                  class119.addMenuEntry("Use", Client.field457 + " " + "->" + " " + XItemContainer.method153('\uffff') + var12.name, 1, var7, var8, var9);
               } else if(Client.field458) {
                  if((ItemComposition.field3004 & 4) == 4) {
                     class119.addMenuEntry(Client.field326, Client.field527 + " " + "->" + " " + XItemContainer.method153('\uffff') + var12.name, 2, var7, var8, var9);
                  }
               } else {
                  String[] var13 = var12.actions;
                  if(Client.field474) {
                     var13 = class31.method659(var13);
                  }

                  if(null != var13) {
                     for(int var18 = 4; var18 >= 0; --var18) {
                        if(var13[var18] != null) {
                           short var15 = 0;
                           if(var18 == 0) {
                              var15 = 3;
                           }

                           if(var18 == 1) {
                              var15 = 4;
                           }

                           if(var18 == 2) {
                              var15 = 5;
                           }

                           if(var18 == 3) {
                              var15 = 6;
                           }

                           if(var18 == 4) {
                              var15 = 1001;
                           }

                           class119.addMenuEntry(var13[var18], XItemContainer.method153('\uffff') + var12.name, var15, var7, var8, var9);
                        }
                     }
                  }

                  class119.addMenuEntry("Examine", XItemContainer.method153('\uffff') + var12.name, 1002, var12.field2904 << 14, var8, var9);
               }
            }

            NPC var14;
            Player var16;
            int var22;
            int[] var27;
            int var29;
            if(var10 == 1) {
               NPC var23 = Client.cachedNPCs[var11];
               if(null == var23) {
                  continue;
               }

               if(var23.composition.field3011 == 1 && (var23.x & 127) == 64 && (var23.y & 127) == 64) {
                  for(var22 = 0; var22 < Client.field402; ++var22) {
                     var14 = Client.cachedNPCs[Client.field342[var22]];
                     if(var14 != null && var23 != var14 && var14.composition.field3011 == 1 && var23.x == var14.x && var14.y == var23.y) {
                        method2748(var14.composition, Client.field342[var22], var8, var9);
                     }
                  }

                  var22 = class45.field923;
                  var27 = class45.field918;

                  for(var29 = 0; var29 < var22; ++var29) {
                     var16 = Client.cachedPlayers[var27[var29]];
                     if(null != var16 && var16.x == var23.x && var23.y == var16.y) {
                        class3.method24(var16, var27[var29], var8, var9);
                     }
                  }
               }

               method2748(var23.composition, var11, var8, var9);
            }

            if(var10 == 0) {
               Player var24 = Client.cachedPlayers[var11];
               if(var24 == null) {
                  continue;
               }

               if((var24.x & 127) == 64 && (var24.y & 127) == 64) {
                  for(var22 = 0; var22 < Client.field402; ++var22) {
                     var14 = Client.cachedNPCs[Client.field342[var22]];
                     if(null != var14 && var14.composition.field3011 == 1 && var24.x == var14.x && var14.y == var24.y) {
                        method2748(var14.composition, Client.field342[var22], var8, var9);
                     }
                  }

                  var22 = class45.field923;
                  var27 = class45.field918;

                  for(var29 = 0; var29 < var22; ++var29) {
                     var16 = Client.cachedPlayers[var27[var29]];
                     if(null != var16 && var16 != var24 && var24.x == var16.x && var24.y == var16.y) {
                        class3.method24(var16, var27[var29], var8, var9);
                     }
                  }
               }

               if(Client.field340 != var11) {
                  class3.method24(var24, var11, var8, var9);
               } else {
                  var4 = var7;
               }
            }

            if(var10 == 3) {
               Deque var25 = Client.groundItemDeque[Sequence.plane][var8][var9];
               if(var25 != null) {
                  for(Item var26 = (Item)var25.method2469(); null != var26; var26 = (Item)var25.method2467()) {
                     ItemComposition var28 = class196.getItemDefinition(var26.id);
                     if(Client.field455 == 1) {
                        class119.addMenuEntry("Use", Client.field457 + " " + "->" + " " + XItemContainer.method153(16748608) + var28.name, 16, var26.id, var8, var9);
                     } else if(Client.field458) {
                        if((ItemComposition.field3004 & 1) == 1) {
                           class119.addMenuEntry(Client.field326, Client.field527 + " " + "->" + " " + XItemContainer.method153(16748608) + var28.name, 17, var26.id, var8, var9);
                        }
                     } else {
                        String[] var21 = var28.groundActions;
                        if(Client.field474) {
                           var21 = class31.method659(var21);
                        }

                        for(int var20 = 4; var20 >= 0; --var20) {
                           if(var21 != null && null != var21[var20]) {
                              byte var17 = 0;
                              if(var20 == 0) {
                                 var17 = 18;
                              }

                              if(var20 == 1) {
                                 var17 = 19;
                              }

                              if(var20 == 2) {
                                 var17 = 20;
                              }

                              if(var20 == 3) {
                                 var17 = 21;
                              }

                              if(var20 == 4) {
                                 var17 = 22;
                              }

                              class119.addMenuEntry(var21[var20], XItemContainer.method153(16748608) + var28.name, var17, var26.id, var8, var9);
                           } else if(var20 == 2) {
                              class119.addMenuEntry("Take", XItemContainer.method153(16748608) + var28.name, 20, var26.id, var8, var9);
                           }
                        }

                        class119.addMenuEntry("Examine", XItemContainer.method153(16748608) + var28.name, 1004, var26.id, var8, var9);
                     }
                  }
               }
            }
         }
      }

      if(var4 != -1) {
         var6 = var4 & 127;
         var7 = var4 >> 7 & 127;
         Player var19 = Client.cachedPlayers[Client.field340];
         class3.method24(var19, Client.field340, var6, var7);
      }

   }
}
