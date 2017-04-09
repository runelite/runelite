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
      byte[] var40 = new byte[var9];
      int var12;
      int var13;
      if(var9 > 1) {
         var40[1] = 1;
         int var14 = 1;
         var12 = 2;

         for(var13 = 2; var13 < var9; ++var13) {
            int var15 = var2.readUnsignedByte();
            if(var15 == 0) {
               var14 = var12++;
            } else {
               if(var15 <= var14) {
                  --var15;
               }

               var14 = var15;
            }

            var40[var13] = (byte)var14;
         }
      } else {
         var12 = var9;
      }

      class137[] var41 = new class137[var12];

      class137 var42;
      for(var13 = 0; var13 < var41.length; ++var13) {
         var42 = var41[var13] = new class137();
         int var16 = var2.readUnsignedByte();
         if(var16 > 0) {
            var42.field1924 = new byte[var16 * 2];
         }

         var16 = var2.readUnsignedByte();
         if(var16 > 0) {
            var42.field1925 = new byte[var16 * 2 + 2];
            var42.field1925[1] = 64;
         }
      }

      var13 = var2.readUnsignedByte();
      byte[] var43 = var13 > 0?new byte[var13 * 2]:null;
      var13 = var2.readUnsignedByte();
      byte[] var17 = var13 > 0?new byte[var13 * 2]:null;

      int var18;
      for(var18 = 0; var2.payload[var2.offset + var18] != 0; ++var18) {
         ;
      }

      byte[] var19 = new byte[var18];

      int var20;
      for(var20 = 0; var20 < var18; ++var20) {
         var19[var20] = var2.readByte();
      }

      ++var2.offset;
      ++var18;
      var20 = 0;

      int var21;
      for(var21 = 0; var21 < 128; ++var21) {
         var20 += var2.readUnsignedByte();
         this.field2013[var21] = (short)var20;
      }

      var20 = 0;

      for(var21 = 0; var21 < 128; ++var21) {
         var20 += var2.readUnsignedByte();
         this.field2013[var21] = (short)(this.field2013[var21] + (var20 << 8));
      }

      var21 = 0;
      int var22 = 0;
      int var23 = 0;

      int var24;
      for(var24 = 0; var24 < 128; ++var24) {
         if(var21 == 0) {
            if(var22 < var19.length) {
               var21 = var19[var22++];
            } else {
               var21 = -1;
            }

            var23 = var2.readVarInt();
         }

         this.field2013[var24] = (short)(this.field2013[var24] + ((var23 - 1 & 2) << 14));
         this.field2018[var24] = var23;
         --var21;
      }

      var21 = 0;
      var22 = 0;
      var24 = 0;

      int var25;
      for(var25 = 0; var25 < 128; ++var25) {
         if(this.field2018[var25] != 0) {
            if(var21 == 0) {
               if(var22 < var4.length) {
                  var21 = var4[var22++];
               } else {
                  var21 = -1;
               }

               var24 = var2.payload[var5++] - 1;
            }

            this.field2012[var25] = (byte)var24;
            --var21;
         }
      }

      var21 = 0;
      var22 = 0;
      var25 = 0;

      for(int var26 = 0; var26 < 128; ++var26) {
         if(this.field2018[var26] != 0) {
            if(var21 == 0) {
               if(var22 < var7.length) {
                  var21 = var7[var22++];
               } else {
                  var21 = -1;
               }

               var25 = var2.payload[var8++] + 16 << 2;
            }

            this.field2015[var26] = (byte)var25;
            --var21;
         }
      }

      var21 = 0;
      var22 = 0;
      class137 var44 = null;

      int var27;
      for(var27 = 0; var27 < 128; ++var27) {
         if(this.field2018[var27] != 0) {
            if(var21 == 0) {
               var44 = var41[var40[var22]];
               if(var22 < var10.length) {
                  var21 = var10[var22++];
               } else {
                  var21 = -1;
               }
            }

            this.field2017[var27] = var44;
            --var21;
         }
      }

      var21 = 0;
      var22 = 0;
      var27 = 0;

      int var28;
      for(var28 = 0; var28 < 128; ++var28) {
         if(var21 == 0) {
            if(var22 < var19.length) {
               var21 = var19[var22++];
            } else {
               var21 = -1;
            }

            if(this.field2018[var28] > 0) {
               var27 = var2.readUnsignedByte() + 1;
            }
         }

         this.field2014[var28] = (byte)var27;
         --var21;
      }

      this.field2016 = var2.readUnsignedByte() + 1;

      class137 var29;
      int var30;
      for(var28 = 0; var28 < var12; ++var28) {
         var29 = var41[var28];
         if(var29.field1924 != null) {
            for(var30 = 1; var30 < var29.field1924.length; var30 += 2) {
               var29.field1924[var30] = var2.readByte();
            }
         }

         if(var29.field1925 != null) {
            for(var30 = 3; var30 < var29.field1925.length - 2; var30 += 2) {
               var29.field1925[var30] = var2.readByte();
            }
         }
      }

      if(var43 != null) {
         for(var28 = 1; var28 < var43.length; var28 += 2) {
            var43[var28] = var2.readByte();
         }
      }

      if(var17 != null) {
         for(var28 = 1; var28 < var17.length; var28 += 2) {
            var17[var28] = var2.readByte();
         }
      }

      for(var28 = 0; var28 < var12; ++var28) {
         var29 = var41[var28];
         if(var29.field1925 != null) {
            var20 = 0;

            for(var30 = 2; var30 < var29.field1925.length; var30 += 2) {
               var20 = var20 + 1 + var2.readUnsignedByte();
               var29.field1925[var30] = (byte)var20;
            }
         }
      }

      for(var28 = 0; var28 < var12; ++var28) {
         var29 = var41[var28];
         if(var29.field1924 != null) {
            var20 = 0;

            for(var30 = 2; var30 < var29.field1924.length; var30 += 2) {
               var20 = var20 + 1 + var2.readUnsignedByte();
               var29.field1924[var30] = (byte)var20;
            }
         }
      }

      byte var31;
      int var32;
      int var33;
      int var34;
      int var35;
      byte var36;
      if(var43 != null) {
         var20 = var2.readUnsignedByte();
         var43[0] = (byte)var20;

         for(var28 = 2; var28 < var43.length; var28 += 2) {
            var20 = var20 + 1 + var2.readUnsignedByte();
            var43[var28] = (byte)var20;
         }

         var36 = var43[0];
         byte var37 = var43[1];

         for(var30 = 0; var30 < var36; ++var30) {
            this.field2014[var30] = (byte)(this.field2014[var30] * var37 + 32 >> 6);
         }

         for(var30 = 2; var30 < var43.length; var30 += 2) {
            var31 = var43[var30];
            byte var38 = var43[var30 + 1];
            var32 = (var31 - var36) / 2 + var37 * (var31 - var36);

            for(var33 = var36; var33 < var31; ++var33) {
               var34 = RSCanvas.method2123(var32, var31 - var36);
               this.field2014[var33] = (byte)(this.field2014[var33] * var34 + 32 >> 6);
               var32 += var38 - var37;
            }

            var36 = var31;
            var37 = var38;
         }

         for(var35 = var36; var35 < 128; ++var35) {
            this.field2014[var35] = (byte)(this.field2014[var35] * var37 + 32 >> 6);
         }

         var42 = null;
      }

      if(var17 != null) {
         var20 = var2.readUnsignedByte();
         var17[0] = (byte)var20;

         for(var28 = 2; var28 < var17.length; var28 += 2) {
            var20 = var20 + 1 + var2.readUnsignedByte();
            var17[var28] = (byte)var20;
         }

         var36 = var17[0];
         int var45 = var17[1] << 1;

         for(var30 = 0; var30 < var36; ++var30) {
            var35 = var45 + (this.field2015[var30] & 255);
            if(var35 < 0) {
               var35 = 0;
            }

            if(var35 > 128) {
               var35 = 128;
            }

            this.field2015[var30] = (byte)var35;
         }

         int var46;
         for(var30 = 2; var30 < var17.length; var30 += 2) {
            var31 = var17[var30];
            var46 = var17[var30 + 1] << 1;
            var32 = var45 * (var31 - var36) + (var31 - var36) / 2;

            for(var33 = var36; var33 < var31; ++var33) {
               var34 = RSCanvas.method2123(var32, var31 - var36);
               int var39 = var34 + (this.field2015[var33] & 255);
               if(var39 < 0) {
                  var39 = 0;
               }

               if(var39 > 128) {
                  var39 = 128;
               }

               this.field2015[var33] = (byte)var39;
               var32 += var46 - var45;
            }

            var36 = var31;
            var45 = var46;
         }

         for(var35 = var36; var35 < 128; ++var35) {
            var46 = (this.field2015[var35] & 255) + var45;
            if(var46 < 0) {
               var46 = 0;
            }

            if(var46 > 128) {
               var46 = 128;
            }

            this.field2015[var35] = (byte)var46;
         }

         Object var47 = null;
      }

      for(var28 = 0; var28 < var12; ++var28) {
         var41[var28].field1926 = var2.readUnsignedByte();
      }

      for(var28 = 0; var28 < var12; ++var28) {
         var29 = var41[var28];
         if(var29.field1924 != null) {
            var29.field1930 = var2.readUnsignedByte();
         }

         if(var29.field1925 != null) {
            var29.field1928 = var2.readUnsignedByte();
         }

         if(var29.field1926 > 0) {
            var29.field1929 = var2.readUnsignedByte();
         }
      }

      for(var28 = 0; var28 < var12; ++var28) {
         var41[var28].field1931 = var2.readUnsignedByte();
      }

      for(var28 = 0; var28 < var12; ++var28) {
         var29 = var41[var28];
         if(var29.field1931 > 0) {
            var29.field1934 = var2.readUnsignedByte();
         }
      }

      for(var28 = 0; var28 < var12; ++var28) {
         var29 = var41[var28];
         if(var29.field1934 > 0) {
            var29.field1932 = var2.readUnsignedByte();
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
         if(var2 == null || var2[var7] != 0) {
            int var8 = this.field2018[var7];
            if(var8 != 0) {
               if(var5 != var8) {
                  var5 = var8--;
                  if((var8 & 1) == 0) {
                     var6 = var1.method1173(var8 >> 2, var3);
                  } else {
                     var6 = var1.method1178(var8 >> 2, var3);
                  }

                  if(var6 == null) {
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
         if(var0.configs != null) {
            var0 = var0.method3741();
         }

         if(var0 != null && var0.field3020 && (!var0.field3007 || Client.field471 == var1)) {
            String var4 = var0.name;
            if(var0.combatLevel != 0) {
               var4 = var4 + RSCanvas.method2130(var0.combatLevel, Projectile.localPlayer.combatLevel) + "  (level-" + var0.combatLevel + ")";
            }

            if(var0.field3007 && Client.field448) {
               class119.addMenuEntry("Examine", XItemContainer.method153(16776960) + var4, 1003, var1, var2, var3);
            }

            if(Client.field455 == 1) {
               class119.addMenuEntry("Use", Client.field457 + " -> " + XItemContainer.method153(16776960) + var4, 7, var1, var2, var3);
            } else if(Client.field458) {
               if((ItemComposition.field3004 & 2) == 2) {
                  class119.addMenuEntry(Client.field326, Client.field527 + " -> " + XItemContainer.method153(16776960) + var4, 8, var1, var2, var3);
               }
            } else {
               int var5 = var0.field3007 && Client.field448?2000:0;
               String[] var6 = var0.actions;
               if(Client.field474) {
                  var6 = class31.method659(var6);
               }

               int var7;
               int var8;
               if(var6 != null) {
                  for(var7 = 4; var7 >= 0; --var7) {
                     if(var6[var7] != null && !var6[var7].equalsIgnoreCase("Attack")) {
                        var8 = 0;
                        if(var7 == 0) {
                           var8 = var5 + 9;
                        }

                        if(var7 == 1) {
                           var8 = var5 + 10;
                        }

                        if(var7 == 2) {
                           var8 = var5 + 11;
                        }

                        if(var7 == 3) {
                           var8 = var5 + 12;
                        }

                        if(var7 == 4) {
                           var8 = var5 + 13;
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
                              var8 = var9 + 9;
                           }

                           if(var7 == 1) {
                              var8 = var9 + 10;
                           }

                           if(var7 == 2) {
                              var8 = var9 + 11;
                           }

                           if(var7 == 3) {
                              var8 = var9 + 12;
                           }

                           if(var7 == 4) {
                              var8 = var9 + 13;
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
      Rasterizer2D.method4007(var0 + 1, var1 + 1, var2 - 2, 16, 0);
      Rasterizer2D.method4013(var0 + 1, var1 + 18, var2 - 2, var3 - 19, 0);
      class63.field1119.method3930("Choose Option", var0 + 3, var1 + 14, var4, -1);
      int var5 = class115.field1817;
      int var6 = class115.field1818;

      for(int var7 = 0; var7 < Client.menuOptionCount; ++var7) {
         int var8 = (Client.menuOptionCount - 1 - var7) * 15 + var1 + 31;
         int var9 = 16777215;
         if(var5 > var0 && var5 < var2 + var0 && var6 > var8 - 13 && var6 < var8 + 3) {
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
      class0.field4 = Client.field580 == 0?443:var0.id + '썐';
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
            int var12;
            if(var10 == 2 && CombatInfo1.region.method1766(Sequence.plane, var8, var9, var7) >= 0) {
               ObjectComposition var13 = class140.getObjectDefinition(var11);
               if(var13.impostorIds != null) {
                  var13 = var13.getImpostor();
               }

               if(var13 == null) {
                  continue;
               }

               if(Client.field455 == 1) {
                  class119.addMenuEntry("Use", Client.field457 + " -> " + XItemContainer.method153('\uffff') + var13.name, 1, var7, var8, var9);
               } else if(Client.field458) {
                  if((ItemComposition.field3004 & 4) == 4) {
                     class119.addMenuEntry(Client.field326, Client.field527 + " -> " + XItemContainer.method153('\uffff') + var13.name, 2, var7, var8, var9);
                  }
               } else {
                  String[] var14 = var13.actions;
                  if(Client.field474) {
                     var14 = class31.method659(var14);
                  }

                  if(var14 != null) {
                     for(var12 = 4; var12 >= 0; --var12) {
                        if(var14[var12] != null) {
                           short var15 = 0;
                           if(var12 == 0) {
                              var15 = 3;
                           }

                           if(var12 == 1) {
                              var15 = 4;
                           }

                           if(var12 == 2) {
                              var15 = 5;
                           }

                           if(var12 == 3) {
                              var15 = 6;
                           }

                           if(var12 == 4) {
                              var15 = 1001;
                           }

                           class119.addMenuEntry(var14[var12], XItemContainer.method153('\uffff') + var13.name, var15, var7, var8, var9);
                        }
                     }
                  }

                  class119.addMenuEntry("Examine", XItemContainer.method153('\uffff') + var13.name, 1002, var13.field2904 << 14, var8, var9);
               }
            }

            int[] var16;
            int var24;
            NPC var25;
            Player var27;
            if(var10 == 1) {
               NPC var17 = Client.cachedNPCs[var11];
               if(var17 == null) {
                  continue;
               }

               if(var17.composition.field3011 == 1 && (var17.x & 127) == 64 && (var17.y & 127) == 64) {
                  for(var12 = 0; var12 < Client.field402; ++var12) {
                     var25 = Client.cachedNPCs[Client.field342[var12]];
                     if(var25 != null && var17 != var25 && var25.composition.field3011 == 1 && var17.x == var25.x && var25.y == var17.y) {
                        method2748(var25.composition, Client.field342[var12], var8, var9);
                     }
                  }

                  var12 = class45.field923;
                  var16 = class45.field918;

                  for(var24 = 0; var24 < var12; ++var24) {
                     var27 = Client.cachedPlayers[var16[var24]];
                     if(var27 != null && var27.x == var17.x && var17.y == var27.y) {
                        class3.method24(var27, var16[var24], var8, var9);
                     }
                  }
               }

               method2748(var17.composition, var11, var8, var9);
            }

            if(var10 == 0) {
               Player var26 = Client.cachedPlayers[var11];
               if(var26 == null) {
                  continue;
               }

               if((var26.x & 127) == 64 && (var26.y & 127) == 64) {
                  for(var12 = 0; var12 < Client.field402; ++var12) {
                     var25 = Client.cachedNPCs[Client.field342[var12]];
                     if(var25 != null && var25.composition.field3011 == 1 && var26.x == var25.x && var25.y == var26.y) {
                        method2748(var25.composition, Client.field342[var12], var8, var9);
                     }
                  }

                  var12 = class45.field923;
                  var16 = class45.field918;

                  for(var24 = 0; var24 < var12; ++var24) {
                     var27 = Client.cachedPlayers[var16[var24]];
                     if(var27 != null && var27 != var26 && var26.x == var27.x && var26.y == var27.y) {
                        class3.method24(var27, var16[var24], var8, var9);
                     }
                  }
               }

               if(Client.field340 != var11) {
                  class3.method24(var26, var11, var8, var9);
               } else {
                  var4 = var7;
               }
            }

            if(var10 == 3) {
               Deque var28 = Client.groundItemDeque[Sequence.plane][var8][var9];
               if(var28 != null) {
                  for(Item var18 = (Item)var28.method2469(); var18 != null; var18 = (Item)var28.method2467()) {
                     ItemComposition var19 = class196.getItemDefinition(var18.id);
                     if(Client.field455 == 1) {
                        class119.addMenuEntry("Use", Client.field457 + " -> " + XItemContainer.method153(16748608) + var19.name, 16, var18.id, var8, var9);
                     } else if(Client.field458) {
                        if((ItemComposition.field3004 & 1) == 1) {
                           class119.addMenuEntry(Client.field326, Client.field527 + " -> " + XItemContainer.method153(16748608) + var19.name, 17, var18.id, var8, var9);
                        }
                     } else {
                        String[] var20 = var19.groundActions;
                        if(Client.field474) {
                           var20 = class31.method659(var20);
                        }

                        for(int var21 = 4; var21 >= 0; --var21) {
                           if(var20 != null && var20[var21] != null) {
                              byte var22 = 0;
                              if(var21 == 0) {
                                 var22 = 18;
                              }

                              if(var21 == 1) {
                                 var22 = 19;
                              }

                              if(var21 == 2) {
                                 var22 = 20;
                              }

                              if(var21 == 3) {
                                 var22 = 21;
                              }

                              if(var21 == 4) {
                                 var22 = 22;
                              }

                              class119.addMenuEntry(var20[var21], XItemContainer.method153(16748608) + var19.name, var22, var18.id, var8, var9);
                           } else if(var21 == 2) {
                              class119.addMenuEntry("Take", XItemContainer.method153(16748608) + var19.name, 20, var18.id, var8, var9);
                           }
                        }

                        class119.addMenuEntry("Examine", XItemContainer.method153(16748608) + var19.name, 1004, var18.id, var8, var9);
                     }
                  }
               }
            }
         }
      }

      if(var4 != -1) {
         var6 = var4 & 127;
         var7 = var4 >> 7 & 127;
         Player var23 = Client.cachedPlayers[Client.field340];
         class3.method24(var23, Client.field340, var6, var7);
      }

   }
}
