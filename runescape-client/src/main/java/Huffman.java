import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fz")
@Implements("Huffman")
public class Huffman {
   @ObfuscatedName("p")
   @Export("masks")
   int[] masks;
   @ObfuscatedName("i")
   @Export("bits")
   byte[] bits;
   @ObfuscatedName("w")
   @Export("keys")
   int[] keys;

   public Huffman(byte[] var1) {
      int var2 = var1.length;
      this.masks = new int[var2];
      this.bits = var1;
      int[] var3 = new int[33];
      this.keys = new int[8];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         byte var6 = var1[var5];
         if(var6 != 0) {
            int var7 = 1 << 32 - var6;
            int var8 = var3[var6];
            this.masks[var5] = var8;
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
                  if(var8 != var11) {
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
                  if(this.keys[var10] == 0) {
                     this.keys[var10] = var4;
                  }

                  var10 = this.keys[var10];
               } else {
                  ++var10;
               }

               if(var10 >= this.keys.length) {
                  int[] var13 = new int[this.keys.length * 2];

                  for(int var14 = 0; var14 < this.keys.length; ++var14) {
                     var13[var14] = this.keys[var14];
                  }

                  this.keys = var13;
               }

               var12 >>>= 1;
            }

            this.keys[var10] = ~var5;
            if(var10 >= var4) {
               var4 = var10 + 1;
            }
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "([BII[BIS)I",
      garbageValue = "-7797"
   )
   @Export("compress")
   public int compress(byte[] var1, int var2, int var3, byte[] var4, int var5) {
      int var6 = 0;
      int var7 = var5 << 3;

      for(var3 += var2; var2 < var3; ++var2) {
         int var8 = var1[var2] & 255;
         int var9 = this.masks[var8];
         byte var10 = this.bits[var8];
         if(var10 == 0) {
            throw new RuntimeException("");
         }

         int var11 = var7 >> 3;
         int var12 = var7 & 7;
         var6 &= -var12 >> 31;
         int var13 = (var12 + var10 - 1 >> 3) + var11;
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

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([BI[BIII)I",
      garbageValue = "-260477927"
   )
   @Export("decompress")
   public int decompress(byte[] var1, int var2, byte[] var3, int var4, int var5) {
      if(var5 == 0) {
         return 0;
      } else {
         int var6 = 0;
         var5 += var4;
         int var7 = var2;

         while(true) {
            byte var8 = var1[var7];
            if(var8 < 0) {
               var6 = this.keys[var6];
            } else {
               ++var6;
            }

            int var9;
            if((var9 = this.keys[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 64) != 0) {
               var6 = this.keys[var6];
            } else {
               ++var6;
            }

            if((var9 = this.keys[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 32) != 0) {
               var6 = this.keys[var6];
            } else {
               ++var6;
            }

            if((var9 = this.keys[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 16) != 0) {
               var6 = this.keys[var6];
            } else {
               ++var6;
            }

            if((var9 = this.keys[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 8) != 0) {
               var6 = this.keys[var6];
            } else {
               ++var6;
            }

            if((var9 = this.keys[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 4) != 0) {
               var6 = this.keys[var6];
            } else {
               ++var6;
            }

            if((var9 = this.keys[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 2) != 0) {
               var6 = this.keys[var6];
            } else {
               ++var6;
            }

            if((var9 = this.keys[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 1) != 0) {
               var6 = this.keys[var6];
            } else {
               ++var6;
            }

            if((var9 = this.keys[var6]) < 0) {
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

   @ObfuscatedName("it")
   @ObfuscatedSignature(
      signature = "(Lcl;III)V",
      garbageValue = "2014038768"
   )
   static final void method3338(ContextMenuRow var0, int var1, int var2) {
      Player.menuAction(var0.param0, var0.param1, var0.type, var0.identifier, var0.option, var0.option, var1, var2);
   }

   @ObfuscatedName("ih")
   @ObfuscatedSignature(
      signature = "(Ljp;IIII)V",
      garbageValue = "-2138959746"
   )
   static final void method3335(NPCComposition var0, int var1, int var2, int var3) {
      if(Client.menuOptionCount < 400) {
         if(var0.configs != null) {
            var0 = var0.transform();
         }

         if(var0 != null) {
            if(var0.field3630) {
               if(!var0.field3640 || Client.field890 == var1) {
                  String var4 = var0.name;
                  if(var0.combatLevel != 0) {
                     var4 = var4 + ScriptEvent.method1083(var0.combatLevel, class36.localPlayer.combatLevel) + " " + " (" + "level-" + var0.combatLevel + ")";
                  }

                  if(var0.field3640 && Client.field953) {
                     class3.addMenuEntry("Examine", class1.getColTags(16776960) + var4, 1003, var1, var2, var3);
                  }

                  if(Client.itemSelectionState == 1) {
                     class3.addMenuEntry("Use", Client.lastSelectedItemName + " " + "->" + " " + class1.getColTags(16776960) + var4, 7, var1, var2, var3);
                  } else if(Client.spellSelected) {
                     if((GameCanvas.field603 & 2) == 2) {
                        class3.addMenuEntry(Client.field1001, Client.field966 + " " + "->" + " " + class1.getColTags(16776960) + var4, 8, var1, var2, var3);
                     }
                  } else {
                     int var5 = var0.field3640 && Client.field953?2000:0;
                     String[] var6 = var0.actions;
                     if(Client.numberMenuOptions) {
                        var6 = GrandExchangeOffer.prependIndices(var6);
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

                              class3.addMenuEntry(var6[var7], class1.getColTags(16776960) + var4, var8, var1, var2, var3);
                           }
                        }
                     }

                     if(var6 != null) {
                        for(var7 = 4; var7 >= 0; --var7) {
                           if(var6[var7] != null && var6[var7].equalsIgnoreCase("Attack")) {
                              short var9 = 0;
                              if(AttackOption.AttackOption_hidden != Client.npcAttackOption) {
                                 if(AttackOption.AttackOption_alwaysRightClick == Client.npcAttackOption || Client.npcAttackOption == AttackOption.AttackOption_dependsOnCombatLevels && var0.combatLevel > class36.localPlayer.combatLevel) {
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

                                 class3.addMenuEntry(var6[var7], class1.getColTags(16776960) + var4, var8, var1, var2, var3);
                              }
                           }
                        }
                     }

                     if(!var0.field3640 || !Client.field953) {
                        class3.addMenuEntry("Examine", class1.getColTags(16776960) + var4, 1003, var1, var2, var3);
                     }
                  }

               }
            }
         }
      }
   }
}
