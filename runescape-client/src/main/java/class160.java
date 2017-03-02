import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fy")
public final class class160 {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 663420431
   )
   int field2125;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1403544061
   )
   int field2127;
   @ObfuscatedName("h")
   int[] field2128 = new int[256];
   @ObfuscatedName("n")
   int[] field2129 = new int[256];
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 2130936759
   )
   int field2131;
   @ObfuscatedName("ky")
   @ObfuscatedGetter(
      intValue = 50965027
   )
   static int field2133;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -847785859
   )
   int field2134;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-77186985"
   )
   public static int method3144(int var0) {
      return var0 >> 17 & 7;
   }

   class160(int[] var1) {
      for(int var2 = 0; var2 < var1.length; ++var2) {
         this.field2128[var2] = var1[var2];
      }

      this.method3146();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2064221556"
   )
   final void method3146() {
      int var9 = -1640531527;
      int var8 = -1640531527;
      int var7 = -1640531527;
      int var6 = -1640531527;
      int var5 = -1640531527;
      int var4 = -1640531527;
      int var3 = -1640531527;
      int var2 = -1640531527;

      int var1;
      for(var1 = 0; var1 < 4; ++var1) {
         var2 ^= var3 << 11;
         var5 += var2;
         var3 += var4;
         var3 ^= var4 >>> 2;
         var6 += var3;
         var4 += var5;
         var4 ^= var5 << 8;
         var7 += var4;
         var5 += var6;
         var5 ^= var6 >>> 16;
         var8 += var5;
         var6 += var7;
         var6 ^= var7 << 10;
         var9 += var6;
         var7 += var8;
         var7 ^= var8 >>> 4;
         var2 += var7;
         var8 += var9;
         var8 ^= var9 << 8;
         var3 += var8;
         var9 += var2;
         var9 ^= var2 >>> 9;
         var4 += var9;
         var2 += var3;
      }

      for(var1 = 0; var1 < 256; var1 += 8) {
         var2 += this.field2128[var1];
         var3 += this.field2128[1 + var1];
         var4 += this.field2128[2 + var1];
         var5 += this.field2128[3 + var1];
         var6 += this.field2128[var1 + 4];
         var7 += this.field2128[var1 + 5];
         var8 += this.field2128[6 + var1];
         var9 += this.field2128[7 + var1];
         var2 ^= var3 << 11;
         var5 += var2;
         var3 += var4;
         var3 ^= var4 >>> 2;
         var6 += var3;
         var4 += var5;
         var4 ^= var5 << 8;
         var7 += var4;
         var5 += var6;
         var5 ^= var6 >>> 16;
         var8 += var5;
         var6 += var7;
         var6 ^= var7 << 10;
         var9 += var6;
         var7 += var8;
         var7 ^= var8 >>> 4;
         var2 += var7;
         var8 += var9;
         var8 ^= var9 << 8;
         var3 += var8;
         var9 += var2;
         var9 ^= var2 >>> 9;
         var4 += var9;
         var2 += var3;
         this.field2129[var1] = var2;
         this.field2129[1 + var1] = var3;
         this.field2129[2 + var1] = var4;
         this.field2129[var1 + 3] = var5;
         this.field2129[var1 + 4] = var6;
         this.field2129[var1 + 5] = var7;
         this.field2129[6 + var1] = var8;
         this.field2129[7 + var1] = var9;
      }

      for(var1 = 0; var1 < 256; var1 += 8) {
         var2 += this.field2129[var1];
         var3 += this.field2129[var1 + 1];
         var4 += this.field2129[var1 + 2];
         var5 += this.field2129[var1 + 3];
         var6 += this.field2129[4 + var1];
         var7 += this.field2129[5 + var1];
         var8 += this.field2129[var1 + 6];
         var9 += this.field2129[7 + var1];
         var2 ^= var3 << 11;
         var5 += var2;
         var3 += var4;
         var3 ^= var4 >>> 2;
         var6 += var3;
         var4 += var5;
         var4 ^= var5 << 8;
         var7 += var4;
         var5 += var6;
         var5 ^= var6 >>> 16;
         var8 += var5;
         var6 += var7;
         var6 ^= var7 << 10;
         var9 += var6;
         var7 += var8;
         var7 ^= var8 >>> 4;
         var2 += var7;
         var8 += var9;
         var8 ^= var9 << 8;
         var3 += var8;
         var9 += var2;
         var9 ^= var2 >>> 9;
         var4 += var9;
         var2 += var3;
         this.field2129[var1] = var2;
         this.field2129[var1 + 1] = var3;
         this.field2129[2 + var1] = var4;
         this.field2129[var1 + 3] = var5;
         this.field2129[4 + var1] = var6;
         this.field2129[5 + var1] = var7;
         this.field2129[6 + var1] = var8;
         this.field2129[var1 + 7] = var9;
      }

      this.method3147();
      this.field2127 = 256;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1651477186"
   )
   final void method3147() {
      this.field2134 += ++this.field2131;

      for(int var1 = 0; var1 < 256; ++var1) {
         int var2 = this.field2129[var1];
         if((var1 & 2) == 0) {
            if((var1 & 1) == 0) {
               this.field2125 ^= this.field2125 << 13;
            } else {
               this.field2125 ^= this.field2125 >>> 6;
            }
         } else if((var1 & 1) == 0) {
            this.field2125 ^= this.field2125 << 2;
         } else {
            this.field2125 ^= this.field2125 >>> 16;
         }

         this.field2125 += this.field2129[var1 + 128 & 255];
         int var3;
         this.field2129[var1] = var3 = this.field2134 + this.field2125 + this.field2129[(var2 & 1020) >> 2];
         this.field2128[var1] = this.field2134 = var2 + this.field2129[(var3 >> 8 & 1020) >> 2];
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IB)LSpotanim;",
      garbageValue = "-93"
   )
   public static Spotanim method3154(int var0) {
      Spotanim var1 = (Spotanim)Spotanim.field2809.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Spotanim.field2794.getConfigData(13, var0);
         var1 = new Spotanim();
         var1.field2798 = var0;
         if(var2 != null) {
            var1.method3537(new Buffer(var2));
         }

         Spotanim.field2809.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-122"
   )
   final int method3157() {
      if(--this.field2127 + 1 == 0) {
         this.method3147();
         this.field2127 = 255;
      }

      return this.field2128[this.field2127];
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass159;IB)V",
      garbageValue = "0"
   )
   static final void method3159(class159 var0, int var1) {
      int var2 = var0.offset;
      class45.field906 = 0;
      int var3 = 0;
      var0.method3141();

      int var4;
      int var6;
      int var17;
      for(var4 = 0; var4 < class45.field907; ++var4) {
         var17 = class45.field900[var4];
         if((class45.field898[var17] & 1) == 0) {
            if(var3 > 0) {
               --var3;
               class45.field898[var17] = (byte)(class45.field898[var17] | 2);
            } else {
               var6 = var0.method3119(1);
               if(var6 == 0) {
                  var3 = XGrandExchangeOffer.method68(var0);
                  class45.field898[var17] = (byte)(class45.field898[var17] | 2);
               } else {
                  class6.method96(var0, var17);
               }
            }
         }
      }

      var0.method3125();
      if(var3 != 0) {
         throw new RuntimeException();
      } else {
         var0.method3141();

         for(var4 = 0; var4 < class45.field907; ++var4) {
            var17 = class45.field900[var4];
            if((class45.field898[var17] & 1) != 0) {
               if(var3 > 0) {
                  --var3;
                  class45.field898[var17] = (byte)(class45.field898[var17] | 2);
               } else {
                  var6 = var0.method3119(1);
                  if(var6 == 0) {
                     var3 = XGrandExchangeOffer.method68(var0);
                     class45.field898[var17] = (byte)(class45.field898[var17] | 2);
                  } else {
                     class6.method96(var0, var17);
                  }
               }
            }
         }

         var0.method3125();
         if(var3 != 0) {
            throw new RuntimeException();
         } else {
            var0.method3141();

            for(var4 = 0; var4 < class45.field901; ++var4) {
               var17 = class45.field902[var4];
               if((class45.field898[var17] & 1) != 0) {
                  if(var3 > 0) {
                     --var3;
                     class45.field898[var17] = (byte)(class45.field898[var17] | 2);
                  } else {
                     var6 = var0.method3119(1);
                     if(var6 == 0) {
                        var3 = XGrandExchangeOffer.method68(var0);
                        class45.field898[var17] = (byte)(class45.field898[var17] | 2);
                     } else if(CombatInfo2.method3616(var0, var17)) {
                        class45.field898[var17] = (byte)(class45.field898[var17] | 2);
                     }
                  }
               }
            }

            var0.method3125();
            if(var3 != 0) {
               throw new RuntimeException();
            } else {
               var0.method3141();

               for(var4 = 0; var4 < class45.field901; ++var4) {
                  var17 = class45.field902[var4];
                  if((class45.field898[var17] & 1) == 0) {
                     if(var3 > 0) {
                        --var3;
                        class45.field898[var17] = (byte)(class45.field898[var17] | 2);
                     } else {
                        var6 = var0.method3119(1);
                        if(var6 == 0) {
                           var3 = XGrandExchangeOffer.method68(var0);
                           class45.field898[var17] = (byte)(class45.field898[var17] | 2);
                        } else if(CombatInfo2.method3616(var0, var17)) {
                           class45.field898[var17] = (byte)(class45.field898[var17] | 2);
                        }
                     }
                  }
               }

               var0.method3125();
               if(var3 != 0) {
                  throw new RuntimeException();
               } else {
                  class45.field907 = 0;
                  class45.field901 = 0;

                  Player var5;
                  for(var4 = 1; var4 < 2048; ++var4) {
                     class45.field898[var4] = (byte)(class45.field898[var4] >> 1);
                     var5 = Client.cachedPlayers[var4];
                     if(null != var5) {
                        class45.field900[++class45.field907 - 1] = var4;
                     } else {
                        class45.field902[++class45.field901 - 1] = var4;
                     }
                  }

                  for(var3 = 0; var3 < class45.field906; ++var3) {
                     var4 = class45.field894[var3];
                     var5 = Client.cachedPlayers[var4];
                     var6 = var0.readUnsignedByte();
                     if((var6 & 32) != 0) {
                        var6 += var0.readUnsignedByte() << 8;
                     }

                     byte var7 = -1;
                     int var8;
                     if((var6 & 16) != 0) {
                        var8 = var0.readUnsignedByte();
                        byte[] var18 = new byte[var8];
                        Buffer var10 = new Buffer(var18);
                        var0.method2867(var18, 0, var8);
                        class45.field899[var4] = var10;
                        var5.method227(var10);
                     }

                     int var9;
                     if((var6 & 1) != 0) {
                        var8 = var0.readUnsignedShort();
                        if(var8 == '\uffff') {
                           var8 = -1;
                        }

                        var9 = var0.readUnsignedByte();
                        ChatLineBuffer.method987(var5, var8, var9);
                     }

                     if((var6 & 8) != 0) {
                        var5.interacting = var0.readUnsignedShort();
                        if(var5.interacting == '\uffff') {
                           var5.interacting = -1;
                        }
                     }

                     if((var6 & 64) != 0) {
                        var5.overhead = var0.readString();
                        if(var5.overhead.charAt(0) == 126) {
                           var5.overhead = var5.overhead.substring(1);
                           class140.sendGameMessage(2, var5.name, var5.overhead);
                        } else if(class9.localPlayer == var5) {
                           class140.sendGameMessage(2, var5.name, var5.overhead);
                        }

                        var5.field615 = false;
                        var5.field648 = 0;
                        var5.field619 = 0;
                        var5.field606 = 150;
                     }

                     int var12;
                     int var13;
                     if((var6 & 2) != 0) {
                        var8 = var0.readUnsignedByte();
                        int var11;
                        int var14;
                        int var19;
                        if(var8 > 0) {
                           for(var9 = 0; var9 < var8; ++var9) {
                              var11 = -1;
                              var12 = -1;
                              var13 = -1;
                              var19 = var0.method2991();
                              if(var19 == 32767) {
                                 var19 = var0.method2991();
                                 var12 = var0.method2991();
                                 var11 = var0.method2991();
                                 var13 = var0.method2991();
                              } else if(var19 != 32766) {
                                 var12 = var0.method2991();
                              } else {
                                 var19 = -1;
                              }

                              var14 = var0.method2991();
                              var5.method641(var19, var12, var11, var13, Client.gameCycle, var14);
                           }
                        }

                        var9 = var0.readUnsignedByte();
                        if(var9 > 0) {
                           for(var19 = 0; var19 < var9; ++var19) {
                              var11 = var0.method2991();
                              var12 = var0.method2991();
                              if(var12 != 32767) {
                                 var13 = var0.method2991();
                                 var14 = var0.readUnsignedByte();
                                 int var15 = var12 > 0?var0.readUnsignedByte():var14;
                                 var5.method626(var11, Client.gameCycle, var12, var13, var14, var15);
                              } else {
                                 var5.method627(var11);
                              }
                           }
                        }
                     }

                     if((var6 & 128) != 0) {
                        var5.field610 = var0.readUnsignedShort();
                        if(var5.field655 == 0) {
                           var5.field652 = var5.field610;
                           var5.field610 = -1;
                        }
                     }

                     if((var6 & 4) != 0) {
                        var8 = var0.readUnsignedShort();
                        class177[] var25 = new class177[]{class177.field2658, class177.field2661, class177.field2668, class177.field2657, class177.field2663, class177.field2664};
                        class177 var21 = (class177)class37.method801(var25, var0.readUnsignedByte());
                        boolean var23 = var0.readUnsignedByte() == 1;
                        var12 = var0.readUnsignedByte();
                        var13 = var0.offset;
                        if(var5.name != null && var5.composition != null) {
                           boolean var24 = false;
                           if(var21.field2670 && class5.method82(var5.name)) {
                              var24 = true;
                           }

                           if(!var24 && Client.field336 == 0 && !var5.field259) {
                              class45.field908.offset = 0;
                              var0.method2867(class45.field908.payload, 0, var12);
                              class45.field908.offset = 0;
                              String var20 = FontTypeFace.method3973(class156.method3091(class182.method3425(class45.field908)));
                              var5.overhead = var20.trim();
                              var5.field648 = var8 >> 8;
                              var5.field619 = var8 & 255;
                              var5.field606 = 150;
                              var5.field615 = var23;
                              var5.inSequence = var5 != class9.localPlayer && var21.field2670 && Client.field502 != "" && var20.toLowerCase().indexOf(Client.field502) == -1;
                              int var16;
                              if(var21.field2659) {
                                 var16 = var23?91:1;
                              } else {
                                 var16 = var23?90:2;
                              }

                              if(var21.field2660 != -1) {
                                 class140.sendGameMessage(var16, class25.method614(var21.field2660) + var5.name, var20);
                              } else {
                                 class140.sendGameMessage(var16, var5.name, var20);
                              }
                           }
                        }

                        var0.offset = var12 + var13;
                     }

                     if((var6 & 2048) != 0) {
                        var5.graphic = var0.readUnsignedShort();
                        var8 = var0.readInt();
                        var5.field642 = var8 >> 16;
                        var5.field641 = Client.gameCycle + (var8 & '\uffff');
                        var5.field639 = 0;
                        var5.field628 = 0;
                        if(var5.field641 > Client.gameCycle) {
                           var5.field639 = -1;
                        }

                        if(var5.graphic == '\uffff') {
                           var5.graphic = -1;
                        }
                     }

                     if((var6 & 4096) != 0) {
                        var5.field643 = var0.readByte();
                        var5.field645 = var0.readByte();
                        var5.field644 = var0.readByte();
                        var5.field646 = var0.readByte();
                        var5.field647 = var0.readUnsignedShort() + Client.gameCycle;
                        var5.field633 = var0.readUnsignedShort() + Client.gameCycle;
                        var5.field649 = var0.readUnsignedShort();
                        if(var5.field242) {
                           var5.field643 += var5.field244;
                           var5.field645 += var5.field264;
                           var5.field644 += var5.field244;
                           var5.field646 += var5.field264;
                           var5.field655 = 0;
                        } else {
                           var5.field643 += var5.pathX[0];
                           var5.field645 += var5.pathY[0];
                           var5.field644 += var5.pathX[0];
                           var5.field646 += var5.pathY[0];
                           var5.field655 = 1;
                        }

                        var5.field660 = 0;
                     }

                     if((var6 & 1024) != 0) {
                        class45.field897[var4] = var0.readByte();
                     }

                     if((var6 & 256) != 0) {
                        var7 = var0.readByte();
                     }

                     if((var6 & 512) != 0) {
                        for(var8 = 0; var8 < 3; ++var8) {
                           var5.actions[var8] = var0.readString();
                        }
                     }

                     if(var5.field242) {
                        if(var7 == 127) {
                           var5.method230(var5.field244, var5.field264);
                        } else {
                           byte var22;
                           if(var7 != -1) {
                              var22 = var7;
                           } else {
                              var22 = class45.field897[var4];
                           }

                           var5.method253(var5.field244, var5.field264, var22);
                        }
                     }
                  }

                  if(var0.offset - var2 != var1) {
                     throw new RuntimeException(var0.offset - var2 + " " + var1);
                  }
               }
            }
         }
      }
   }
}
