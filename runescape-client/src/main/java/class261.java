import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jr")
public class class261 {
   @ObfuscatedName("a")
   public static final class261 field3624;
   @ObfuscatedName("cr")
   @Export("indexSoundEffects")
   static IndexData indexSoundEffects;
   @ObfuscatedName("s")
   public static final class261 field3628;
   @ObfuscatedName("r")
   public static final class261 field3629;
   @ObfuscatedName("v")
   final String field3630;
   @ObfuscatedName("y")
   String field3631;
   @ObfuscatedName("ae")
   static Client field3632;
   @ObfuscatedName("w")
   public static final class261 field3633;
   @ObfuscatedName("i")
   public static final class261 field3634;
   @ObfuscatedName("t")
   public static final class261 field3635;

   class261(String var1, String var2) {
      this.field3630 = var1;
      this.field3631 = var2;
   }

   static {
      field3634 = new class261("PLAIN11", "p11_full");
      field3633 = new class261("PLAIN12", "p12_full");
      field3624 = new class261("BOLD12", "b12_full");
      field3635 = new class261("VERDANA11", "verdana_11pt_regular");
      field3628 = new class261("VERDANA13", "verdana_13pt_regular");
      field3629 = new class261("VERDANA15", "verdana_15pt_regular");
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "([BIII)Z",
      garbageValue = "1747601896"
   )
   static final boolean method4733(byte[] var0, int var1, int var2) {
      boolean var3 = true;
      Buffer var4 = new Buffer(var0);
      int var5 = -1;

      label70:
      while(true) {
         int var6 = var4.method3159();
         if(var6 == 0) {
            return var3;
         }

         var5 += var6;
         int var7 = 0;
         boolean var8 = false;

         while(true) {
            int var9;
            while(!var8) {
               var9 = var4.method3159();
               if(var9 == 0) {
                  continue label70;
               }

               var7 += var9 - 1;
               int var10 = var7 & 63;
               int var11 = var7 >> 6 & 63;
               int var12 = var4.readUnsignedByte() >> 2;
               int var13 = var11 + var1;
               int var14 = var10 + var2;
               if(var13 > 0 && var14 > 0 && var13 < 103 && var14 < 103) {
                  ObjectComposition var15 = class251.getObjectDefinition(var5);
                  if(var12 != 22 || !Client.field930 || var15.field3488 != 0 || var15.field3463 == 1 || var15.field3474) {
                     if(!var15.method4516()) {
                        ++Client.field983;
                        var3 = false;
                     }

                     var8 = true;
                  }
               }
            }

            var9 = var4.method3159();
            if(var9 == 0) {
               break;
            }

            var4.readUnsignedByte();
         }
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "614079530"
   )
   public static int method4734(String var0) {
      return var0.length() + 1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "-677567341"
   )
   static int method4735(int var0, Script var1, boolean var2) {
      String var3;
      int var4;
      if(var0 == 4100) {
         var3 = class83.scriptStringStack[--class50.scriptStringStackSize];
         var4 = class83.intStack[--class46.intStackSize];
         class83.scriptStringStack[++class50.scriptStringStackSize - 1] = var3 + var4;
         return 1;
      } else {
         String var37;
         if(var0 == 4101) {
            class50.scriptStringStackSize -= 2;
            var3 = class83.scriptStringStack[class50.scriptStringStackSize];
            var37 = class83.scriptStringStack[class50.scriptStringStackSize + 1];
            class83.scriptStringStack[++class50.scriptStringStackSize - 1] = var3 + var37;
            return 1;
         } else if(var0 == 4102) {
            var3 = class83.scriptStringStack[--class50.scriptStringStackSize];
            var4 = class83.intStack[--class46.intStackSize];
            class83.scriptStringStack[++class50.scriptStringStackSize - 1] = var3 + KitDefinition.method4390(var4, true);
            return 1;
         } else if(var0 == 4103) {
            var3 = class83.scriptStringStack[--class50.scriptStringStackSize];
            class83.scriptStringStack[++class50.scriptStringStackSize - 1] = var3.toLowerCase();
            return 1;
         } else {
            int var8;
            int var21;
            int var28;
            if(var0 == 4104) {
               var21 = class83.intStack[--class46.intStackSize];
               long var22 = 86400000L * (11745L + (long)var21);
               class83.field1365.setTime(new Date(var22));
               var28 = class83.field1365.get(5);
               int var29 = class83.field1365.get(2);
               var8 = class83.field1365.get(1);
               class83.scriptStringStack[++class50.scriptStringStackSize - 1] = var28 + "-" + class83.field1359[var29] + "-" + var8;
               return 1;
            } else if(var0 == 4105) {
               class50.scriptStringStackSize -= 2;
               var3 = class83.scriptStringStack[class50.scriptStringStackSize];
               var37 = class83.scriptStringStack[class50.scriptStringStackSize + 1];
               if(XItemContainer.localPlayer.composition != null && XItemContainer.localPlayer.composition.isFemale) {
                  class83.scriptStringStack[++class50.scriptStringStackSize - 1] = var37;
               } else {
                  class83.scriptStringStack[++class50.scriptStringStackSize - 1] = var3;
               }

               return 1;
            } else if(var0 == 4106) {
               var21 = class83.intStack[--class46.intStackSize];
               class83.scriptStringStack[++class50.scriptStringStackSize - 1] = Integer.toString(var21);
               return 1;
            } else {
               int var5;
               if(var0 == 4107) {
                  class50.scriptStringStackSize -= 2;
                  int[] var27 = class83.intStack;
                  var4 = ++class46.intStackSize - 1;
                  String var39 = class83.scriptStringStack[class50.scriptStringStackSize];
                  String var40 = class83.scriptStringStack[class50.scriptStringStackSize + 1];
                  var8 = Client.field931;
                  int var9 = var39.length();
                  int var10 = var40.length();
                  int var11 = 0;
                  int var12 = 0;
                  byte var13 = 0;
                  byte var14 = 0;

                  label291:
                  while(true) {
                     if(var11 - var13 >= var9 && var12 - var14 >= var10) {
                        int var32 = Math.min(var9, var10);

                        int var33;
                        char var36;
                        for(var33 = 0; var33 < var32; ++var33) {
                           char var34 = var39.charAt(var33);
                           var36 = var40.charAt(var33);
                           if(var36 != var34 && Character.toUpperCase(var34) != Character.toUpperCase(var36)) {
                              var34 = Character.toLowerCase(var34);
                              var36 = Character.toLowerCase(var36);
                              if(var36 != var34) {
                                 var5 = WorldMapType3.method169(var34, var8) - WorldMapType3.method169(var36, var8);
                                 break label291;
                              }
                           }
                        }

                        var33 = var9 - var10;
                        if(var33 != 0) {
                           var5 = var33;
                        } else {
                           for(int var35 = 0; var35 < var32; ++var35) {
                              var36 = var39.charAt(var35);
                              char var19 = var40.charAt(var35);
                              if(var36 != var19) {
                                 var5 = WorldMapType3.method169(var36, var8) - WorldMapType3.method169(var19, var8);
                                 break label291;
                              }
                           }

                           var5 = 0;
                        }
                        break;
                     }

                     if(var11 - var13 >= var9) {
                        var5 = -1;
                        break;
                     }

                     if(var12 - var14 >= var10) {
                        var5 = 1;
                        break;
                     }

                     char var15;
                     if(var13 != 0) {
                        var15 = (char)var13;
                        boolean var30 = false;
                     } else {
                        var15 = var39.charAt(var11++);
                     }

                     char var16;
                     if(var14 != 0) {
                        var16 = (char)var14;
                        boolean var31 = false;
                     } else {
                        var16 = var40.charAt(var12++);
                     }

                     byte var17;
                     if(var15 == 198) {
                        var17 = 69;
                     } else if(var15 == 230) {
                        var17 = 101;
                     } else if(var15 == 223) {
                        var17 = 115;
                     } else if(var15 == 338) {
                        var17 = 69;
                     } else if(var15 == 339) {
                        var17 = 101;
                     } else {
                        var17 = 0;
                     }

                     var13 = var17;
                     byte var18;
                     if(var16 == 198) {
                        var18 = 69;
                     } else if(var16 == 230) {
                        var18 = 101;
                     } else if(var16 == 223) {
                        var18 = 115;
                     } else if(var16 == 338) {
                        var18 = 69;
                     } else if(var16 == 339) {
                        var18 = 101;
                     } else {
                        var18 = 0;
                     }

                     var14 = var18;
                     var15 = class158.method2970(var15, var8);
                     var16 = class158.method2970(var16, var8);
                     if(var15 != var16 && Character.toUpperCase(var15) != Character.toUpperCase(var16)) {
                        var15 = Character.toLowerCase(var15);
                        var16 = Character.toLowerCase(var16);
                        if(var15 != var16) {
                           var5 = WorldMapType3.method169(var15, var8) - WorldMapType3.method169(var16, var8);
                           break;
                        }
                     }
                  }

                  var27[var4] = FrameMap.method2663(var5);
                  return 1;
               } else {
                  byte[] var24;
                  Font var25;
                  if(var0 == 4108) {
                     var3 = class83.scriptStringStack[--class50.scriptStringStackSize];
                     class46.intStackSize -= 2;
                     var4 = class83.intStack[class46.intStackSize];
                     var5 = class83.intStack[class46.intStackSize + 1];
                     var24 = RSCanvas.field693.getConfigData(var5, 0);
                     var25 = new Font(var24);
                     class83.intStack[++class46.intStackSize - 1] = var25.method4752(var3, var4);
                     return 1;
                  } else if(var0 == 4109) {
                     var3 = class83.scriptStringStack[--class50.scriptStringStackSize];
                     class46.intStackSize -= 2;
                     var4 = class83.intStack[class46.intStackSize];
                     var5 = class83.intStack[class46.intStackSize + 1];
                     var24 = RSCanvas.field693.getConfigData(var5, 0);
                     var25 = new Font(var24);
                     class83.intStack[++class46.intStackSize - 1] = var25.method4751(var3, var4);
                     return 1;
                  } else if(var0 == 4110) {
                     class50.scriptStringStackSize -= 2;
                     var3 = class83.scriptStringStack[class50.scriptStringStackSize];
                     var37 = class83.scriptStringStack[class50.scriptStringStackSize + 1];
                     if(class83.intStack[--class46.intStackSize] == 1) {
                        class83.scriptStringStack[++class50.scriptStringStackSize - 1] = var3;
                     } else {
                        class83.scriptStringStack[++class50.scriptStringStackSize - 1] = var37;
                     }

                     return 1;
                  } else if(var0 == 4111) {
                     var3 = class83.scriptStringStack[--class50.scriptStringStackSize];
                     class83.scriptStringStack[++class50.scriptStringStackSize - 1] = FontTypeFace.method4835(var3);
                     return 1;
                  } else if(var0 == 4112) {
                     var3 = class83.scriptStringStack[--class50.scriptStringStackSize];
                     var4 = class83.intStack[--class46.intStackSize];
                     class83.scriptStringStack[++class50.scriptStringStackSize - 1] = var3 + (char)var4;
                     return 1;
                  } else if(var0 == 4113) {
                     var21 = class83.intStack[--class46.intStackSize];
                     class83.intStack[++class46.intStackSize - 1] = class163.method3052((char)var21)?1:0;
                     return 1;
                  } else {
                     char var7;
                     if(var0 != 4114) {
                        if(var0 == 4115) {
                           var21 = class83.intStack[--class46.intStackSize];
                           class83.intStack[++class46.intStackSize - 1] = class59.method1042((char)var21)?1:0;
                           return 1;
                        } else if(var0 == 4116) {
                           var21 = class83.intStack[--class46.intStackSize];
                           class83.intStack[++class46.intStackSize - 1] = class22.method159((char)var21)?1:0;
                           return 1;
                        } else if(var0 == 4117) {
                           var3 = class83.scriptStringStack[--class50.scriptStringStackSize];
                           if(var3 != null) {
                              class83.intStack[++class46.intStackSize - 1] = var3.length();
                           } else {
                              class83.intStack[++class46.intStackSize - 1] = 0;
                           }

                           return 1;
                        } else if(var0 == 4118) {
                           var3 = class83.scriptStringStack[--class50.scriptStringStackSize];
                           class46.intStackSize -= 2;
                           var4 = class83.intStack[class46.intStackSize];
                           var5 = class83.intStack[class46.intStackSize + 1];
                           class83.scriptStringStack[++class50.scriptStringStackSize - 1] = var3.substring(var4, var5);
                           return 1;
                        } else if(var0 == 4119) {
                           var3 = class83.scriptStringStack[--class50.scriptStringStackSize];
                           StringBuilder var38 = new StringBuilder(var3.length());
                           boolean var26 = false;

                           for(var28 = 0; var28 < var3.length(); ++var28) {
                              var7 = var3.charAt(var28);
                              if(var7 == 60) {
                                 var26 = true;
                              } else if(var7 == 62) {
                                 var26 = false;
                              } else if(!var26) {
                                 var38.append(var7);
                              }
                           }

                           class83.scriptStringStack[++class50.scriptStringStackSize - 1] = var38.toString();
                           return 1;
                        } else if(var0 == 4120) {
                           var3 = class83.scriptStringStack[--class50.scriptStringStackSize];
                           var4 = class83.intStack[--class46.intStackSize];
                           class83.intStack[++class46.intStackSize - 1] = var3.indexOf(var4);
                           return 1;
                        } else if(var0 == 4121) {
                           class50.scriptStringStackSize -= 2;
                           var3 = class83.scriptStringStack[class50.scriptStringStackSize];
                           var37 = class83.scriptStringStack[class50.scriptStringStackSize + 1];
                           var5 = class83.intStack[--class46.intStackSize];
                           class83.intStack[++class46.intStackSize - 1] = var3.indexOf(var37, var5);
                           return 1;
                        } else {
                           return 2;
                        }
                     } else {
                        var21 = class83.intStack[--class46.intStackSize];
                        int[] var20 = class83.intStack;
                        var5 = ++class46.intStackSize - 1;
                        var7 = (char)var21;
                        boolean var6 = var7 >= 48 && var7 <= 57 || var7 >= 65 && var7 <= 90 || var7 >= 97 && var7 <= 122;
                        var20[var5] = var6?1:0;
                        return 1;
                     }
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "-30671369"
   )
   static int method4736(int var0, Script var1, boolean var2) {
      int var4 = -1;
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var4 = class83.intStack[--class46.intStackSize];
         var3 = PacketBuffer.method3403(var4);
      } else {
         var3 = var2?class83.field1364:class60.field766;
      }

      if(var0 == 1100) {
         class46.intStackSize -= 2;
         var3.scrollX = class83.intStack[class46.intStackSize];
         if(var3.scrollX > var3.scrollWidth - var3.width) {
            var3.scrollX = var3.scrollWidth - var3.width;
         }

         if(var3.scrollX < 0) {
            var3.scrollX = 0;
         }

         var3.scrollY = class83.intStack[class46.intStackSize + 1];
         if(var3.scrollY > var3.scrollHeight - var3.height) {
            var3.scrollY = var3.scrollHeight - var3.height;
         }

         if(var3.scrollY < 0) {
            var3.scrollY = 0;
         }

         class88.method1714(var3);
         return 1;
      } else if(var0 == 1101) {
         var3.textColor = class83.intStack[--class46.intStackSize];
         class88.method1714(var3);
         return 1;
      } else if(var0 == 1102) {
         var3.field2647 = class83.intStack[--class46.intStackSize] == 1;
         class88.method1714(var3);
         return 1;
      } else if(var0 == 1103) {
         var3.opacity = class83.intStack[--class46.intStackSize];
         class88.method1714(var3);
         return 1;
      } else if(var0 == 1104) {
         var3.field2687 = class83.intStack[--class46.intStackSize];
         class88.method1714(var3);
         return 1;
      } else if(var0 == 1105) {
         var3.spriteId = class83.intStack[--class46.intStackSize];
         class88.method1714(var3);
         return 1;
      } else if(var0 == 1106) {
         var3.field2691 = class83.intStack[--class46.intStackSize];
         class88.method1714(var3);
         return 1;
      } else if(var0 == 1107) {
         var3.field2692 = class83.intStack[--class46.intStackSize] == 1;
         class88.method1714(var3);
         return 1;
      } else if(var0 == 1108) {
         var3.modelType = 1;
         var3.modelId = class83.intStack[--class46.intStackSize];
         class88.method1714(var3);
         return 1;
      } else if(var0 == 1109) {
         class46.intStackSize -= 6;
         var3.field2703 = class83.intStack[class46.intStackSize];
         var3.field2704 = class83.intStack[class46.intStackSize + 1];
         var3.rotationX = class83.intStack[class46.intStackSize + 2];
         var3.rotationZ = class83.intStack[class46.intStackSize + 3];
         var3.rotationY = class83.intStack[class46.intStackSize + 4];
         var3.field2650 = class83.intStack[class46.intStackSize + 5];
         class88.method1714(var3);
         return 1;
      } else {
         int var9;
         if(var0 == 1110) {
            var9 = class83.intStack[--class46.intStackSize];
            if(var9 != var3.field2717) {
               var3.field2717 = var9;
               var3.field2788 = 0;
               var3.field2777 = 0;
               class88.method1714(var3);
            }

            return 1;
         } else if(var0 == 1111) {
            var3.field2711 = class83.intStack[--class46.intStackSize] == 1;
            class88.method1714(var3);
            return 1;
         } else if(var0 == 1112) {
            String var8 = class83.scriptStringStack[--class50.scriptStringStackSize];
            if(!var8.equals(var3.text)) {
               var3.text = var8;
               class88.method1714(var3);
            }

            return 1;
         } else if(var0 == 1113) {
            var3.fontId = class83.intStack[--class46.intStackSize];
            class88.method1714(var3);
            return 1;
         } else if(var0 == 1114) {
            class46.intStackSize -= 3;
            var3.field2652 = class83.intStack[class46.intStackSize];
            var3.field2726 = class83.intStack[class46.intStackSize + 1];
            var3.field2716 = class83.intStack[class46.intStackSize + 2];
            class88.method1714(var3);
            return 1;
         } else if(var0 == 1115) {
            var3.field2719 = class83.intStack[--class46.intStackSize] == 1;
            class88.method1714(var3);
            return 1;
         } else if(var0 == 1116) {
            var3.borderThickness = class83.intStack[--class46.intStackSize];
            class88.method1714(var3);
            return 1;
         } else if(var0 == 1117) {
            var3.sprite2 = class83.intStack[--class46.intStackSize];
            class88.method1714(var3);
            return 1;
         } else if(var0 == 1118) {
            var3.flippedVertically = class83.intStack[--class46.intStackSize] == 1;
            class88.method1714(var3);
            return 1;
         } else if(var0 == 1119) {
            var3.flippedHorizontally = class83.intStack[--class46.intStackSize] == 1;
            class88.method1714(var3);
            return 1;
         } else if(var0 == 1120) {
            class46.intStackSize -= 2;
            var3.scrollWidth = class83.intStack[class46.intStackSize];
            var3.scrollHeight = class83.intStack[class46.intStackSize + 1];
            class88.method1714(var3);
            if(var4 != -1 && var3.type == 0) {
               WorldMapType2.method546(class46.widgets[var4 >> 16], var3, false);
            }

            return 1;
         } else if(var0 == 1121) {
            class59.method1017(var3.id, var3.index);
            Client.field1091 = var3;
            class88.method1714(var3);
            return 1;
         } else if(var0 == 1122) {
            var3.field2690 = class83.intStack[--class46.intStackSize];
            class88.method1714(var3);
            return 1;
         } else if(var0 == 1123) {
            var3.field2680 = class83.intStack[--class46.intStackSize];
            class88.method1714(var3);
            return 1;
         } else if(var0 == 1124) {
            var3.field2686 = class83.intStack[--class46.intStackSize];
            class88.method1714(var3);
            return 1;
         } else if(var0 == 1125) {
            var9 = class83.intStack[--class46.intStackSize];
            class283[] var6 = new class283[]{class283.field3768, class283.field3770, class283.field3771, class283.field3772, class283.field3769};
            class283 var7 = (class283)class134.method2577(var6, var9);
            if(var7 != null) {
               var3.field2757 = var7;
               class88.method1714(var3);
            }

            return 1;
         } else if(var0 == 1126) {
            boolean var5 = class83.intStack[--class46.intStackSize] == 1;
            var3.field2688 = var5;
            return 1;
         } else {
            return 2;
         }
      }
   }
}
