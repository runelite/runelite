import java.awt.FontMetrics;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dc")
public class class121 {
   @ObfuscatedName("d")
   int[] field1872;
   @ObfuscatedName("n")
   int[] field1874;
   @ObfuscatedName("bf")
   protected static FontMetrics field1878;
   @ObfuscatedName("c")
   byte[] field1879;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "([BIIIIIII[LCollisionData;I)V",
      garbageValue = "-1906641804"
   )
   static final void method2303(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, CollisionData[] var8) {
      int var10;
      for(int var9 = 0; var9 < 8; ++var9) {
         for(var10 = 0; var10 < 8; ++var10) {
            if(var9 + var2 > 0 && var2 + var9 < 103 && var3 + var10 > 0 && var10 + var3 < 103) {
               var8[var1].flags[var9 + var2][var3 + var10] &= -16777217;
            }
         }
      }

      Buffer var21 = new Buffer(var0);

      for(var10 = 0; var10 < 4; ++var10) {
         for(int var11 = 0; var11 < 64; ++var11) {
            for(int var12 = 0; var12 < 64; ++var12) {
               if(var4 == var10 && var11 >= var5 && var11 < var5 + 8 && var12 >= var6 && var12 < var6 + 8) {
                  int var15 = var2 + class18.method202(var11 & 7, var12 & 7, var7);
                  int var18 = var11 & 7;
                  int var19 = var12 & 7;
                  int var20 = var7 & 3;
                  int var17;
                  if(var20 == 0) {
                     var17 = var19;
                  } else if(var20 == 1) {
                     var17 = 7 - var18;
                  } else if(var20 == 2) {
                     var17 = 7 - var19;
                  } else {
                     var17 = var18;
                  }

                  ScriptState.method152(var21, var1, var15, var17 + var3, 0, 0, var7);
               } else {
                  ScriptState.method152(var21, 0, -1, -1, 0, 0, 0);
               }
            }
         }
      }

   }

   public class121(byte[] var1) {
      int var2 = var1.length;
      this.field1872 = new int[var2];
      this.field1879 = var1;
      int[] var3 = new int[33];
      this.field1874 = new int[8];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         byte var6 = var1[var5];
         if(var6 != 0) {
            int var7 = 1 << 32 - var6;
            int var8 = var3[var6];
            this.field1872[var5] = var8;
            int var9;
            int var10;
            int var11;
            int var12;
            if((var8 & var7) != 0) {
               var9 = var3[var6 - 1];
            } else {
               var9 = var8 | var7;

               for(var10 = var6 - 1; var10 >= 1; --var10) {
                  var11 = var3[var10];
                  if(var11 != var8) {
                     break;
                  }

                  var12 = 1 << 32 - var10;
                  if((var11 & var12) != 0) {
                     var3[var10] = var3[var10 - 1];
                     break;
                  }

                  var3[var10] = var11 | var12;
               }
            }

            var3[var6] = var9;

            for(var10 = var6 + 1; var10 <= 32; ++var10) {
               if(var8 == var3[var10]) {
                  var3[var10] = var9;
               }
            }

            var10 = 0;

            for(var11 = 0; var11 < var6; ++var11) {
               var12 = Integer.MIN_VALUE >>> var11;
               if((var8 & var12) != 0) {
                  if(this.field1874[var10] == 0) {
                     this.field1874[var10] = var4;
                  }

                  var10 = this.field1874[var10];
               } else {
                  ++var10;
               }

               if(var10 >= this.field1874.length) {
                  int[] var13 = new int[this.field1874.length * 2];

                  for(int var14 = 0; var14 < this.field1874.length; ++var14) {
                     var13[var14] = this.field1874[var14];
                  }

                  this.field1874 = var13;
               }

               var12 >>>= 1;
            }

            this.field1874[var10] = ~var5;
            if(var10 >= var4) {
               var4 = var10 + 1;
            }
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IZIZI)V",
      garbageValue = "-162227084"
   )
   static void method2304(int var0, boolean var1, int var2, boolean var3) {
      if(World.worldList != null) {
         class10.method148(0, World.worldList.length - 1, var0, var1, var2, var3);
      }

   }

   @ObfuscatedName("cg")
   @ObfuscatedSignature(
      signature = "(LNPCComposition;IIIB)V",
      garbageValue = "2"
   )
   static final void method2309(NPCComposition var0, int var1, int var2, int var3) {
      if(Client.menuOptionCount < 400) {
         if(var0.configs != null) {
            var0 = var0.method3804();
         }

         if(var0 != null) {
            if(var0.field3061) {
               if(!var0.field3068 || Client.field310 == var1) {
                  String var4 = var0.name;
                  if(var0.combatLevel != 0) {
                     var4 = var4 + class31.method652(var0.combatLevel, class22.localPlayer.combatLevel) + " " + " (" + "level-" + var0.combatLevel + ")";
                  }

                  if(var0.field3068 && Client.field430) {
                     class59.addMenuEntry("Examine", class213.method4037(16776960) + var4, 1003, var1, var2, var3);
                  }

                  if(Client.field351 == 1) {
                     class59.addMenuEntry("Use", Client.field439 + " " + "->" + " " + class213.method4037(16776960) + var4, 7, var1, var2, var3);
                  } else if(Client.field440) {
                     if((class159.field2071 & 2) == 2) {
                        class59.addMenuEntry(Client.field438, Client.field392 + " " + "->" + " " + class213.method4037(16776960) + var4, 8, var1, var2, var3);
                     }
                  } else {
                     int var5 = var0.field3068 && Client.field430?2000:0;
                     String[] var6 = var0.actions;
                     if(Client.field456) {
                        var6 = CollisionData.method2275(var6);
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

                              class59.addMenuEntry(var6[var7], class213.method4037(16776960) + var4, var8, var1, var2, var3);
                           }
                        }
                     }

                     if(var6 != null) {
                        for(var7 = 4; var7 >= 0; --var7) {
                           if(var6[var7] != null && var6[var7].equalsIgnoreCase("Attack")) {
                              short var9 = 0;
                              if(Client.field307 != class40.field807) {
                                 if(Client.field307 == class40.field805 || Client.field307 == class40.field809 && var0.combatLevel > class22.localPlayer.combatLevel) {
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

                                 class59.addMenuEntry(var6[var7], class213.method4037(16776960) + var4, var8, var1, var2, var3);
                              }
                           }
                        }
                     }

                     if(!var0.field3068 || !Client.field430) {
                        class59.addMenuEntry("Examine", class213.method4037(16776960) + var4, 1003, var1, var2, var3);
                     }
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "([BI[BIII)I",
      garbageValue = "-1786390920"
   )
   public int method2310(byte[] var1, int var2, byte[] var3, int var4, int var5) {
      if(var5 == 0) {
         return 0;
      } else {
         int var6 = 0;
         var5 += var4;
         int var7 = var2;

         while(true) {
            byte var8 = var1[var7];
            if(var8 < 0) {
               var6 = this.field1874[var6];
            } else {
               ++var6;
            }

            int var9;
            if((var9 = this.field1874[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 64) != 0) {
               var6 = this.field1874[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1874[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 32) != 0) {
               var6 = this.field1874[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1874[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 16) != 0) {
               var6 = this.field1874[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1874[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 8) != 0) {
               var6 = this.field1874[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1874[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 4) != 0) {
               var6 = this.field1874[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1874[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 2) != 0) {
               var6 = this.field1874[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1874[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 1) != 0) {
               var6 = this.field1874[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1874[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            ++var7;
         }

         return var7 + 1 - var2;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([BII[BIB)I",
      garbageValue = "88"
   )
   public int method2311(byte[] var1, int var2, int var3, byte[] var4, int var5) {
      int var6 = 0;
      int var7 = var5 << 3;

      for(var3 += var2; var2 < var3; ++var2) {
         int var8 = var1[var2] & 255;
         int var9 = this.field1872[var8];
         byte var10 = this.field1879[var8];
         if(var10 == 0) {
            throw new RuntimeException("");
         }

         int var11 = var7 >> 3;
         int var12 = var7 & 7;
         var6 &= -var12 >> 31;
         int var13 = (var10 + var12 - 1 >> 3) + var11;
         var12 += 24;
         var4[var11] = (byte)(var6 |= var9 >>> var12);
         if(var11 < var13) {
            ++var11;
            var12 -= 8;
            var4[var11] = (byte)(var6 = var9 >>> var12);
            if(var11 < var13) {
               ++var11;
               var12 -= 8;
               var4[var11] = (byte)(var6 = var9 >>> var12);
               if(var11 < var13) {
                  ++var11;
                  var12 -= 8;
                  var4[var11] = (byte)(var6 = var9 >>> var12);
                  if(var11 < var13) {
                     ++var11;
                     var12 -= 8;
                     var4[var11] = (byte)(var6 = var9 << -var12);
                  }
               }
            }
         }

         var7 += var10;
      }

      return (var7 + 7 >> 3) - var5;
   }
}
