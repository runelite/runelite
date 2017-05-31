import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("au")
public final class class50 implements KeyListener, FocusListener {
   @ObfuscatedName("cx")
   static int[] field617;
   @ObfuscatedName("fo")
   static byte[][] field619;
   @ObfuscatedName("cm")
   @ObfuscatedGetter(
      intValue = 331462867
   )
   static int field621;
   @ObfuscatedName("cl")
   public static boolean[] field624;
   @ObfuscatedName("cn")
   @ObfuscatedGetter(
      intValue = 764180193
   )
   public static int field625;
   @ObfuscatedName("co")
   @ObfuscatedGetter(
      intValue = -1432073907
   )
   static int field628;
   @ObfuscatedName("cf")
   public static int[] field629;
   @ObfuscatedName("ce")
   static int[] field630;
   @ObfuscatedName("cw")
   @ObfuscatedGetter(
      intValue = 149948527
   )
   static int field631;
   @ObfuscatedName("i")
   @Export("keyboard")
   static class50 keyboard;
   @ObfuscatedName("ci")
   @ObfuscatedGetter(
      intValue = 1133296537
   )
   static int field634;
   @ObfuscatedName("cu")
   @ObfuscatedGetter(
      intValue = -1193056133
   )
   static int field635;
   @ObfuscatedName("cc")
   @ObfuscatedGetter(
      intValue = 562395699
   )
   @Export("keyboardIdleTicks")
   public static volatile int keyboardIdleTicks;
   @ObfuscatedName("cy")
   static int[] field637;
   @ObfuscatedName("cr")
   static char[] field639;
   @ObfuscatedName("cj")
   @ObfuscatedGetter(
      intValue = 295458039
   )
   public static int field641;
   @ObfuscatedName("ga")
   static ModIcon[] field642;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/CharSequence;IIS)Ljava/lang/String;",
      garbageValue = "28439"
   )
   public static String method748(CharSequence[] var0, int var1, int var2) {
      if(var2 == 0) {
         return "";
      } else if(var2 == 1) {
         CharSequence var3 = var0[var1];
         return var3 == null?"null":var3.toString();
      } else {
         int var9 = var2 + var1;
         int var4 = 0;

         for(int var8 = var1; var8 < var9; ++var8) {
            CharSequence var6 = var0[var8];
            if(var6 == null) {
               var4 += 4;
            } else {
               var4 += var6.length();
            }
         }

         StringBuilder var5 = new StringBuilder(var4);

         for(int var10 = var1; var10 < var9; ++var10) {
            CharSequence var7 = var0[var10];
            if(var7 == null) {
               var5.append("null");
            } else {
               var5.append(var7);
            }
         }

         return var5.toString();
      }
   }

   public final synchronized void keyReleased(KeyEvent var1) {
      if(keyboard != null) {
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field637.length) {
            var2 = field637[var2] & -129;
         } else {
            var2 = -1;
         }

         if(field628 >= 0 && var2 >= 0) {
            field617[field628] = ~var2;
            field628 = field628 + 1 & 127;
            if(field628 == field631) {
               field628 = -1;
            }
         }
      }

      var1.consume();
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(keyboard != null) {
         field628 = -1;
      }

   }

   static {
      keyboard = new class50();
      field624 = new boolean[112];
      field617 = new int[128];
      field631 = 0;
      field628 = 0;
      field639 = new char[128];
      field630 = new int[128];
      field629 = new int[128];
      field641 = 0;
      field621 = 0;
      field634 = 0;
      field635 = 0;
      keyboardIdleTicks = 0;
      field637 = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, 85, 80, 84, -1, 91, -1, -1, -1, 81, 82, 86, -1, -1, -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, 83, 104, 105, 103, 102, 96, 98, 97, 99, -1, -1, -1, -1, -1, -1, -1, 25, 16, 17, 18, 19, 20, 21, 22, 23, 24, -1, -1, -1, -1, -1, -1, -1, 48, 68, 66, 50, 34, 51, 52, 53, 39, 54, 55, 56, 70, 69, 40, 41, 32, 35, 49, 36, 38, 67, 33, 65, 37, 64, -1, -1, -1, -1, -1, 228, 231, 227, 233, 224, 219, 225, 230, 226, 232, 89, 87, -1, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -1, -1, -1, 101, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IB)LFrames;",
      garbageValue = "-102"
   )
   @Export("getFrames")
   static Frames getFrames(int var0) {
      Frames var1 = (Frames)Sequence.field3599.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         IndexDataBase var3 = class215.field2624;
         IndexDataBase var4 = class51.field656;
         boolean var5 = true;
         int[] var6 = var3.method4183(var0);

         for(int var7 = 0; var7 < var6.length; ++var7) {
            byte[] var8 = var3.method4265(var0, var6[var7]);
            if(var8 == null) {
               var5 = false;
            } else {
               int var9 = (var8[0] & 255) << 8 | var8[1] & 255;
               byte[] var10 = var4.method4265(var9, 0);
               if(var10 == null) {
                  var5 = false;
               }
            }
         }

         Frames var2;
         if(!var5) {
            var2 = null;
         } else {
            try {
               var2 = new Frames(var3, var4, var0, false);
            } catch (Exception var12) {
               var2 = null;
            }
         }

         if(var2 != null) {
            Sequence.field3599.put(var2, (long)var0);
         }

         return var2;
      }
   }

   public final void keyTyped(KeyEvent var1) {
      if(keyboard != null) {
         char var2 = var1.getKeyChar();
         if(var2 != 0 && var2 != '\uffff' && XGrandExchangeOffer.method105(var2)) {
            int var3 = field634 + 1 & 127;
            if(var3 != field621) {
               field630[field634] = -1;
               field639[field634] = var2;
               field634 = var3;
            }
         }
      }

      var1.consume();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-377897217"
   )
   public static boolean method763() {
      long var0 = class226.method4147();
      int var2 = (int)(var0 - class238.field3240);
      class238.field3240 = var0;
      if(var2 > 200) {
         var2 = 200;
      }

      class238.field3251 += var2;
      if(class238.field3256 == 0 && class238.field3246 == 0 && class238.field3249 == 0 && class238.field3244 == 0) {
         return true;
      } else if(class238.field3257 == null) {
         return false;
      } else {
         try {
            if(class238.field3251 > 30000) {
               throw new IOException();
            } else {
               class234 var3;
               Buffer var4;
               while(class238.field3246 < 20 && class238.field3244 > 0) {
                  var3 = (class234)class238.field3243.method3606();
                  var4 = new Buffer(4);
                  var4.putByte(1);
                  var4.put24bitInt((int)var3.hash);
                  class238.field3257.queueForWrite(var4.payload, 0, 4);
                  class238.field3245.method3617(var3, var3.hash);
                  --class238.field3244;
                  ++class238.field3246;
               }

               while(class238.field3256 < 20 && class238.field3249 > 0) {
                  var3 = (class234)class238.field3247.method3542();
                  var4 = new Buffer(4);
                  var4.putByte(0);
                  var4.put24bitInt((int)var3.hash);
                  class238.field3257.queueForWrite(var4.payload, 0, 4);
                  var3.method3687();
                  class238.field3250.method3617(var3, var3.hash);
                  --class238.field3249;
                  ++class238.field3256;
               }

               for(int var15 = 0; var15 < 100; ++var15) {
                  int var16 = class238.field3257.available();
                  if(var16 < 0) {
                     throw new IOException();
                  }

                  if(var16 == 0) {
                     break;
                  }

                  class238.field3251 = 0;
                  byte var5 = 0;
                  if(class56.field674 == null) {
                     var5 = 8;
                  } else if(class238.field3248 == 0) {
                     var5 = 1;
                  }

                  int var6;
                  int index;
                  int file;
                  int compressedFileSize;
                  if(var5 > 0) {
                     var6 = var5 - class238.field3252.offset;
                     if(var6 > var16) {
                        var6 = var16;
                     }

                     class238.field3257.read(class238.field3252.payload, class238.field3252.offset, var6);
                     if(class238.field3254 != 0) {
                        for(index = 0; index < var6; ++index) {
                           class238.field3252.payload[class238.field3252.offset + index] ^= class238.field3254;
                        }
                     }

                     class238.field3252.offset += var6;
                     if(class238.field3252.offset < var5) {
                        break;
                     }

                     if(class56.field674 == null) {
                        class238.field3252.offset = 0;
                        index = class238.field3252.readUnsignedByte();
                        file = class238.field3252.readUnsignedShort();
                        int compression = class238.field3252.readUnsignedByte();
                        compressedFileSize = class238.field3252.readInt();
                        long var11 = (long)(file + (index << 16));
                        class234 var13 = (class234)class238.field3245.method3615(var11);
                        class234.field3196 = true;
                        if(var13 == null) {
                           var13 = (class234)class238.field3250.method3615(var11);
                           class234.field3196 = false;
                        }

                        if(var13 == null) {
                           throw new IOException();
                        }

                        int var14 = compression == 0?5:9;
                        class56.field674 = var13;
                        class24.field362 = new Buffer(compressedFileSize + var14 + class56.field674.field3198);
                        class24.field362.putByte(compression);
                        class24.field362.putInt(compressedFileSize);
                        class238.field3248 = 8;
                        class238.field3252.offset = 0;
                     } else if(class238.field3248 == 0) {
                        if(class238.field3252.payload[0] == -1) {
                           class238.field3248 = 1;
                           class238.field3252.offset = 0;
                        } else {
                           class56.field674 = null;
                        }
                     }
                  } else {
                     var6 = class24.field362.payload.length - class56.field674.field3198;
                     index = 512 - class238.field3248;
                     if(index > var6 - class24.field362.offset) {
                        index = var6 - class24.field362.offset;
                     }

                     if(index > var16) {
                        index = var16;
                     }

                     class238.field3257.read(class24.field362.payload, class24.field362.offset, index);
                     if(class238.field3254 != 0) {
                        for(file = 0; file < index; ++file) {
                           class24.field362.payload[class24.field362.offset + file] ^= class238.field3254;
                        }
                     }

                     class24.field362.offset += index;
                     class238.field3248 += index;
                     if(class24.field362.offset == var6) {
                        if(16711935L == class56.field674.hash) {
                           class241.field3274 = class24.field362;

                           for(file = 0; file < 256; ++file) {
                              IndexData var17 = class238.field3253[file];
                              if(var17 != null) {
                                 class241.field3274.offset = file * 8 + 5;
                                 compressedFileSize = class241.field3274.readInt();
                                 int var18 = class241.field3274.readInt();
                                 var17.method4303(compressedFileSize, var18);
                              }
                           }
                        } else {
                           class238.field3242.reset();
                           class238.field3242.update(class24.field362.payload, 0, var6);
                           file = (int)class238.field3242.getValue();
                           if(file != class56.field674.field3202) {
                              try {
                                 class238.field3257.method3048();
                              } catch (Exception var20) {
                                 ;
                              }

                              ++class238.field3258;
                              class238.field3257 = null;
                              class238.field3254 = (byte)((int)(Math.random() * 255.0D + 1.0D));
                              return false;
                           }

                           class238.field3258 = 0;
                           class238.field3241 = 0;
                           class56.field674.field3200.method4293((int)(class56.field674.hash & 65535L), class24.field362.payload, 16711680L == (class56.field674.hash & 16711680L), class234.field3196);
                        }

                        class56.field674.unlink();
                        if(class234.field3196) {
                           --class238.field3246;
                        } else {
                           --class238.field3256;
                        }

                        class238.field3248 = 0;
                        class56.field674 = null;
                        class24.field362 = null;
                     } else {
                        if(class238.field3248 != 512) {
                           break;
                        }

                        class238.field3248 = 0;
                     }
                  }
               }

               return true;
            }
         } catch (IOException var21) {
            try {
               class238.field3257.method3048();
            } catch (Exception var19) {
               ;
            }

            ++class238.field3241;
            class238.field3257 = null;
            return false;
         }
      }
   }

   @ObfuscatedName("hm")
   @ObfuscatedSignature(
      signature = "(LPlayer;IIIB)V",
      garbageValue = "29"
   )
   static final void method766(Player var0, int var1, int var2, int var3) {
      if(XGrandExchangeOffer.localPlayer != var0) {
         if(Client.menuOptionCount < 400) {
            String var4;
            int var7;
            if(var0.field855 == 0) {
               String var5 = var0.actions[0] + var0.name + var0.actions[1];
               var7 = var0.combatLevel;
               int var8 = XGrandExchangeOffer.localPlayer.combatLevel;
               int var9 = var8 - var7;
               String var6;
               if(var9 < -9) {
                  var6 = class82.method1610(16711680);
               } else if(var9 < -6) {
                  var6 = class82.method1610(16723968);
               } else if(var9 < -3) {
                  var6 = class82.method1610(16740352);
               } else if(var9 < 0) {
                  var6 = class82.method1610(16756736);
               } else if(var9 > 9) {
                  var6 = class82.method1610('\uff00');
               } else if(var9 > 6) {
                  var6 = class82.method1610(4259584);
               } else if(var9 > 3) {
                  var6 = class82.method1610(8453888);
               } else if(var9 > 0) {
                  var6 = class82.method1610(12648192);
               } else {
                  var6 = class82.method1610(16776960);
               }

               var4 = var5 + var6 + " " + " (" + "level-" + var0.combatLevel + ")" + var0.actions[2];
            } else {
               var4 = var0.actions[0] + var0.name + var0.actions[1] + " " + " (" + "skill-" + var0.field855 + ")" + var0.actions[2];
            }

            int var10;
            if(Client.field1043 == 1) {
               class176.addMenuEntry("Use", Client.field1142 + " " + "->" + " " + class82.method1610(16777215) + var4, 14, var1, var2, var3);
            } else if(Client.field1045) {
               if((class24.field364 & 8) == 8) {
                  class176.addMenuEntry(Client.field1048, Client.field1049 + " " + "->" + " " + class82.method1610(16777215) + var4, 15, var1, var2, var3);
               }
            } else {
               for(var10 = 7; var10 >= 0; --var10) {
                  if(Client.playerOptions[var10] != null) {
                     short var11 = 0;
                     if(Client.playerOptions[var10].equalsIgnoreCase("Attack")) {
                        if(class91.field1407 == Client.field915) {
                           continue;
                        }

                        if(Client.field915 == class91.field1405 || class91.field1410 == Client.field915 && var0.combatLevel > XGrandExchangeOffer.localPlayer.combatLevel) {
                           var11 = 2000;
                        }

                        if(XGrandExchangeOffer.localPlayer.team != 0 && var0.team != 0) {
                           if(XGrandExchangeOffer.localPlayer.team == var0.team) {
                              var11 = 2000;
                           } else {
                              var11 = 0;
                           }
                        }
                     } else if(Client.playerOptionsPriorities[var10]) {
                        var11 = 2000;
                     }

                     boolean var12 = false;
                     var7 = Client.playerMenuTypes[var10] + var11;
                     class176.addMenuEntry(Client.playerOptions[var10], class82.method1610(16777215) + var4, var7, var1, var2, var3);
                  }
               }
            }

            for(var10 = 0; var10 < Client.menuOptionCount; ++var10) {
               if(Client.menuTypes[var10] == 23) {
                  Client.menuTargets[var10] = class82.method1610(16777215) + var4;
                  break;
               }
            }

         }
      }
   }

   public final void focusGained(FocusEvent var1) {
   }

   public final synchronized void keyPressed(KeyEvent var1) {
      if(keyboard != null) {
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field637.length) {
            var2 = field637[var2];
            if((var2 & 128) != 0) {
               var2 = -1;
            }
         } else {
            var2 = -1;
         }

         if(field628 >= 0 && var2 >= 0) {
            field617[field628] = var2;
            field628 = field628 + 1 & 127;
            if(field631 == field628) {
               field628 = -1;
            }
         }

         int var3;
         if(var2 >= 0) {
            var3 = field634 + 1 & 127;
            if(field621 != var3) {
               field630[field634] = var2;
               field639[field634] = 0;
               field634 = var3;
            }
         }

         var3 = var1.getModifiers();
         if((var3 & 10) != 0 || var2 == 85 || var2 == 10) {
            var1.consume();
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;IIB)LModIcon;",
      garbageValue = "-1"
   )
   static ModIcon method768(IndexDataBase var0, int var1, int var2) {
      return !class228.method4155(var0, var1, var2)?null:class71.method1122();
   }
}
