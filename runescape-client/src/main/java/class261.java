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
   @Export("clientInstance")
   static Client clientInstance;
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

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "([BIII)Z",
      garbageValue = "1747601896"
   )
   static final boolean method4733(byte[] var0, int var1, int var2) {
      boolean var3 = true;
      Buffer var4 = new Buffer(var0);
      int var5 = -1;

      label71:
      while(true) {
         int var6 = var4.getUSmart();
         if(var6 == 0) {
            return var3;
         }

         var5 += var6;
         int var7 = 0;
         boolean var8 = false;

         while(true) {
            int var12;
            ObjectComposition var15;
            do {
               int var13;
               int var14;
               do {
                  do {
                     do {
                        do {
                           int var9;
                           while(var8) {
                              var9 = var4.getUSmart();
                              if(var9 == 0) {
                                 continue label71;
                              }

                              var4.readUnsignedByte();
                           }

                           var9 = var4.getUSmart();
                           if(var9 == 0) {
                              continue label71;
                           }

                           var7 += var9 - 1;
                           int var10 = var7 & 63;
                           int var11 = var7 >> 6 & 63;
                           var12 = var4.readUnsignedByte() >> 2;
                           var13 = var11 + var1;
                           var14 = var10 + var2;
                        } while(var13 <= 0);
                     } while(var14 <= 0);
                  } while(var13 >= 103);
               } while(var14 >= 103);

               var15 = class251.getObjectDefinition(var5);
            } while(var12 == 22 && Client.lowMemory && var15.field3488 == 0 && var15.interactType != 1 && !var15.field3474);

            if(!var15.method4516()) {
               ++Client.field983;
               var3 = false;
            }

            var8 = true;
         }
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "614079530"
   )
   @Export("getLength")
   public static int getLength(String var0) {
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
         var3 = class83.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
         var4 = class83.intStack[--class46.intStackSize];
         class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var3 + var4;
         return 1;
      } else {
         String var5;
         if(var0 == 4101) {
            KeyFocusListener.scriptStringStackSize -= 2;
            var3 = class83.scriptStringStack[KeyFocusListener.scriptStringStackSize];
            var5 = class83.scriptStringStack[KeyFocusListener.scriptStringStackSize + 1];
            class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var3 + var5;
            return 1;
         } else if(var0 == 4102) {
            var3 = class83.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
            var4 = class83.intStack[--class46.intStackSize];
            class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var3 + KitDefinition.method4390(var4, true);
            return 1;
         } else if(var0 == 4103) {
            var3 = class83.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
            class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var3.toLowerCase();
            return 1;
         } else {
            int var6;
            int var7;
            int var8;
            if(var0 == 4104) {
               var7 = class83.intStack[--class46.intStackSize];
               long var28 = 86400000L * (11745L + (long)var7);
               class83.field1365.setTime(new Date(var28));
               var8 = class83.field1365.get(5);
               int var26 = class83.field1365.get(2);
               var6 = class83.field1365.get(1);
               class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var8 + "-" + class83.field1359[var26] + "-" + var6;
               return 1;
            } else if(var0 == 4105) {
               KeyFocusListener.scriptStringStackSize -= 2;
               var3 = class83.scriptStringStack[KeyFocusListener.scriptStringStackSize];
               var5 = class83.scriptStringStack[KeyFocusListener.scriptStringStackSize + 1];
               if(XItemContainer.localPlayer.composition != null && XItemContainer.localPlayer.composition.isFemale) {
                  class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var5;
               } else {
                  class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var3;
               }

               return 1;
            } else if(var0 == 4106) {
               var7 = class83.intStack[--class46.intStackSize];
               class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = Integer.toString(var7);
               return 1;
            } else {
               int var9;
               if(var0 == 4107) {
                  KeyFocusListener.scriptStringStackSize -= 2;
                  int[] var24 = class83.intStack;
                  var4 = ++class46.intStackSize - 1;
                  String var25 = class83.scriptStringStack[KeyFocusListener.scriptStringStackSize];
                  String var27 = class83.scriptStringStack[KeyFocusListener.scriptStringStackSize + 1];
                  var6 = Client.languageId;
                  int var30 = var25.length();
                  int var31 = var27.length();
                  int var15 = 0;
                  int var16 = 0;
                  byte var17 = 0;
                  byte var18 = 0;

                  label237:
                  while(true) {
                     if(var15 - var17 >= var30 && var16 - var18 >= var31) {
                        int var33 = Math.min(var30, var31);

                        int var35;
                        char var36;
                        for(var35 = 0; var35 < var33; ++var35) {
                           char var37 = var25.charAt(var35);
                           var36 = var27.charAt(var35);
                           if(var36 != var37 && Character.toUpperCase(var37) != Character.toUpperCase(var36)) {
                              var37 = Character.toLowerCase(var37);
                              var36 = Character.toLowerCase(var36);
                              if(var36 != var37) {
                                 var9 = WorldMapType3.method169(var37, var6) - WorldMapType3.method169(var36, var6);
                                 break label237;
                              }
                           }
                        }

                        var35 = var30 - var31;
                        if(var35 != 0) {
                           var9 = var35;
                        } else {
                           for(int var38 = 0; var38 < var33; ++var38) {
                              var36 = var25.charAt(var38);
                              char var23 = var27.charAt(var38);
                              if(var36 != var23) {
                                 var9 = WorldMapType3.method169(var36, var6) - WorldMapType3.method169(var23, var6);
                                 break label237;
                              }
                           }

                           var9 = 0;
                        }
                        break;
                     }

                     if(var15 - var17 >= var30) {
                        var9 = -1;
                        break;
                     }

                     if(var16 - var18 >= var31) {
                        var9 = 1;
                        break;
                     }

                     char var19;
                     if(var17 != 0) {
                        var19 = (char)var17;
                        boolean var20 = false;
                     } else {
                        var19 = var25.charAt(var15++);
                     }

                     char var32;
                     if(var18 != 0) {
                        var32 = (char)var18;
                        boolean var21 = false;
                     } else {
                        var32 = var27.charAt(var16++);
                     }

                     byte var34;
                     if(var19 == 198) {
                        var34 = 69;
                     } else if(var19 == 230) {
                        var34 = 101;
                     } else if(var19 == 223) {
                        var34 = 115;
                     } else if(var19 == 338) {
                        var34 = 69;
                     } else if(var19 == 339) {
                        var34 = 101;
                     } else {
                        var34 = 0;
                     }

                     var17 = var34;
                     byte var22;
                     if(var32 == 198) {
                        var22 = 69;
                     } else if(var32 == 230) {
                        var22 = 101;
                     } else if(var32 == 223) {
                        var22 = 115;
                     } else if(var32 == 338) {
                        var22 = 69;
                     } else if(var32 == 339) {
                        var22 = 101;
                     } else {
                        var22 = 0;
                     }

                     var18 = var22;
                     var19 = Timer.method2970(var19, var6);
                     var32 = Timer.method2970(var32, var6);
                     if(var19 != var32 && Character.toUpperCase(var19) != Character.toUpperCase(var32)) {
                        var19 = Character.toLowerCase(var19);
                        var32 = Character.toLowerCase(var32);
                        if(var19 != var32) {
                           var9 = WorldMapType3.method169(var19, var6) - WorldMapType3.method169(var32, var6);
                           break;
                        }
                     }
                  }

                  var24[var4] = FrameMap.method2663(var9);
                  return 1;
               } else {
                  byte[] var10;
                  Font var11;
                  if(var0 == 4108) {
                     var3 = class83.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                     class46.intStackSize -= 2;
                     var4 = class83.intStack[class46.intStackSize];
                     var9 = class83.intStack[class46.intStackSize + 1];
                     var10 = RSCanvas.field693.getConfigData(var9, 0);
                     var11 = new Font(var10);
                     class83.intStack[++class46.intStackSize - 1] = var11.method4752(var3, var4);
                     return 1;
                  } else if(var0 == 4109) {
                     var3 = class83.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                     class46.intStackSize -= 2;
                     var4 = class83.intStack[class46.intStackSize];
                     var9 = class83.intStack[class46.intStackSize + 1];
                     var10 = RSCanvas.field693.getConfigData(var9, 0);
                     var11 = new Font(var10);
                     class83.intStack[++class46.intStackSize - 1] = var11.method4751(var3, var4);
                     return 1;
                  } else if(var0 == 4110) {
                     KeyFocusListener.scriptStringStackSize -= 2;
                     var3 = class83.scriptStringStack[KeyFocusListener.scriptStringStackSize];
                     var5 = class83.scriptStringStack[KeyFocusListener.scriptStringStackSize + 1];
                     if(class83.intStack[--class46.intStackSize] == 1) {
                        class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var3;
                     } else {
                        class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var5;
                     }

                     return 1;
                  } else if(var0 == 4111) {
                     var3 = class83.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                     class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = FontTypeFace.appendTags(var3);
                     return 1;
                  } else if(var0 == 4112) {
                     var3 = class83.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                     var4 = class83.intStack[--class46.intStackSize];
                     class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var3 + (char)var4;
                     return 1;
                  } else if(var0 == 4113) {
                     var7 = class83.intStack[--class46.intStackSize];
                     class83.intStack[++class46.intStackSize - 1] = class163.method3052((char)var7)?1:0;
                     return 1;
                  } else {
                     char var12;
                     boolean var14;
                     if(var0 != 4114) {
                        if(var0 == 4115) {
                           var7 = class83.intStack[--class46.intStackSize];
                           class83.intStack[++class46.intStackSize - 1] = MouseInput.method1042((char)var7)?1:0;
                           return 1;
                        } else if(var0 == 4116) {
                           var7 = class83.intStack[--class46.intStackSize];
                           class83.intStack[++class46.intStackSize - 1] = class22.method159((char)var7)?1:0;
                           return 1;
                        } else if(var0 == 4117) {
                           var3 = class83.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                           if(var3 != null) {
                              class83.intStack[++class46.intStackSize - 1] = var3.length();
                           } else {
                              class83.intStack[++class46.intStackSize - 1] = 0;
                           }

                           return 1;
                        } else if(var0 == 4118) {
                           var3 = class83.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                           class46.intStackSize -= 2;
                           var4 = class83.intStack[class46.intStackSize];
                           var9 = class83.intStack[class46.intStackSize + 1];
                           class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var3.substring(var4, var9);
                           return 1;
                        } else if(var0 == 4119) {
                           var3 = class83.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                           StringBuilder var29 = new StringBuilder(var3.length());
                           var14 = false;

                           for(var8 = 0; var8 < var3.length(); ++var8) {
                              var12 = var3.charAt(var8);
                              if(var12 == 60) {
                                 var14 = true;
                              } else if(var12 == 62) {
                                 var14 = false;
                              } else if(!var14) {
                                 var29.append(var12);
                              }
                           }

                           class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var29.toString();
                           return 1;
                        } else if(var0 == 4120) {
                           var3 = class83.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                           var4 = class83.intStack[--class46.intStackSize];
                           class83.intStack[++class46.intStackSize - 1] = var3.indexOf(var4);
                           return 1;
                        } else if(var0 == 4121) {
                           KeyFocusListener.scriptStringStackSize -= 2;
                           var3 = class83.scriptStringStack[KeyFocusListener.scriptStringStackSize];
                           var5 = class83.scriptStringStack[KeyFocusListener.scriptStringStackSize + 1];
                           var9 = class83.intStack[--class46.intStackSize];
                           class83.intStack[++class46.intStackSize - 1] = var3.indexOf(var5, var9);
                           return 1;
                        } else {
                           return 2;
                        }
                     } else {
                        var7 = class83.intStack[--class46.intStackSize];
                        int[] var13 = class83.intStack;
                        var9 = ++class46.intStackSize - 1;
                        var12 = (char)var7;
                        var14 = var12 >= 48 && var12 <= 57 || var12 >= 65 && var12 <= 90 || var12 >= 97 && var12 <= 122;
                        var13[var9] = var14?1:0;
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
      int var3 = -1;
      Widget var4;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class83.intStack[--class46.intStackSize];
         var4 = PacketBuffer.method3403(var3);
      } else {
         var4 = var2?class83.field1364:class60.field766;
      }

      if(var0 == 1100) {
         class46.intStackSize -= 2;
         var4.scrollX = class83.intStack[class46.intStackSize];
         if(var4.scrollX > var4.scrollWidth - var4.width) {
            var4.scrollX = var4.scrollWidth - var4.width;
         }

         if(var4.scrollX < 0) {
            var4.scrollX = 0;
         }

         var4.scrollY = class83.intStack[class46.intStackSize + 1];
         if(var4.scrollY > var4.scrollHeight - var4.height) {
            var4.scrollY = var4.scrollHeight - var4.height;
         }

         if(var4.scrollY < 0) {
            var4.scrollY = 0;
         }

         class88.method1714(var4);
         return 1;
      } else if(var0 == 1101) {
         var4.textColor = class83.intStack[--class46.intStackSize];
         class88.method1714(var4);
         return 1;
      } else if(var0 == 1102) {
         var4.field2647 = class83.intStack[--class46.intStackSize] == 1;
         class88.method1714(var4);
         return 1;
      } else if(var0 == 1103) {
         var4.opacity = class83.intStack[--class46.intStackSize];
         class88.method1714(var4);
         return 1;
      } else if(var0 == 1104) {
         var4.field2687 = class83.intStack[--class46.intStackSize];
         class88.method1714(var4);
         return 1;
      } else if(var0 == 1105) {
         var4.spriteId = class83.intStack[--class46.intStackSize];
         class88.method1714(var4);
         return 1;
      } else if(var0 == 1106) {
         var4.textureId = class83.intStack[--class46.intStackSize];
         class88.method1714(var4);
         return 1;
      } else if(var0 == 1107) {
         var4.field2692 = class83.intStack[--class46.intStackSize] == 1;
         class88.method1714(var4);
         return 1;
      } else if(var0 == 1108) {
         var4.modelType = 1;
         var4.modelId = class83.intStack[--class46.intStackSize];
         class88.method1714(var4);
         return 1;
      } else if(var0 == 1109) {
         class46.intStackSize -= 6;
         var4.field2703 = class83.intStack[class46.intStackSize];
         var4.field2704 = class83.intStack[class46.intStackSize + 1];
         var4.rotationX = class83.intStack[class46.intStackSize + 2];
         var4.rotationZ = class83.intStack[class46.intStackSize + 3];
         var4.rotationY = class83.intStack[class46.intStackSize + 4];
         var4.modelZoom = class83.intStack[class46.intStackSize + 5];
         class88.method1714(var4);
         return 1;
      } else {
         int var5;
         if(var0 == 1110) {
            var5 = class83.intStack[--class46.intStackSize];
            if(var5 != var4.field2717) {
               var4.field2717 = var5;
               var4.field2788 = 0;
               var4.field2777 = 0;
               class88.method1714(var4);
            }

            return 1;
         } else if(var0 == 1111) {
            var4.field2711 = class83.intStack[--class46.intStackSize] == 1;
            class88.method1714(var4);
            return 1;
         } else if(var0 == 1112) {
            String var9 = class83.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
            if(!var9.equals(var4.text)) {
               var4.text = var9;
               class88.method1714(var4);
            }

            return 1;
         } else if(var0 == 1113) {
            var4.fontId = class83.intStack[--class46.intStackSize];
            class88.method1714(var4);
            return 1;
         } else if(var0 == 1114) {
            class46.intStackSize -= 3;
            var4.field2652 = class83.intStack[class46.intStackSize];
            var4.field2726 = class83.intStack[class46.intStackSize + 1];
            var4.field2716 = class83.intStack[class46.intStackSize + 2];
            class88.method1714(var4);
            return 1;
         } else if(var0 == 1115) {
            var4.textShadowed = class83.intStack[--class46.intStackSize] == 1;
            class88.method1714(var4);
            return 1;
         } else if(var0 == 1116) {
            var4.borderThickness = class83.intStack[--class46.intStackSize];
            class88.method1714(var4);
            return 1;
         } else if(var0 == 1117) {
            var4.sprite2 = class83.intStack[--class46.intStackSize];
            class88.method1714(var4);
            return 1;
         } else if(var0 == 1118) {
            var4.flippedVertically = class83.intStack[--class46.intStackSize] == 1;
            class88.method1714(var4);
            return 1;
         } else if(var0 == 1119) {
            var4.flippedHorizontally = class83.intStack[--class46.intStackSize] == 1;
            class88.method1714(var4);
            return 1;
         } else if(var0 == 1120) {
            class46.intStackSize -= 2;
            var4.scrollWidth = class83.intStack[class46.intStackSize];
            var4.scrollHeight = class83.intStack[class46.intStackSize + 1];
            class88.method1714(var4);
            if(var3 != -1 && var4.type == 0) {
               WorldMapType2.method546(class46.widgets[var3 >> 16], var4, false);
            }

            return 1;
         } else if(var0 == 1121) {
            MouseInput.method1017(var4.id, var4.index);
            Client.field1091 = var4;
            class88.method1714(var4);
            return 1;
         } else if(var0 == 1122) {
            var4.field2690 = class83.intStack[--class46.intStackSize];
            class88.method1714(var4);
            return 1;
         } else if(var0 == 1123) {
            var4.field2680 = class83.intStack[--class46.intStackSize];
            class88.method1714(var4);
            return 1;
         } else if(var0 == 1124) {
            var4.field2686 = class83.intStack[--class46.intStackSize];
            class88.method1714(var4);
            return 1;
         } else if(var0 == 1125) {
            var5 = class83.intStack[--class46.intStackSize];
            class283[] var8 = new class283[]{class283.field3768, class283.field3770, class283.field3771, class283.field3772, class283.field3769};
            class283 var7 = (class283)class134.forOrdinal(var8, var5);
            if(var7 != null) {
               var4.field2757 = var7;
               class88.method1714(var4);
            }

            return 1;
         } else if(var0 == 1126) {
            boolean var6 = class83.intStack[--class46.intStackSize] == 1;
            var4.field2688 = var6;
            return 1;
         } else {
            return 2;
         }
      }
   }

   static {
      field3634 = new class261("PLAIN11", "p11_full");
      field3633 = new class261("PLAIN12", "p12_full");
      field3624 = new class261("BOLD12", "b12_full");
      field3635 = new class261("VERDANA11", "verdana_11pt_regular");
      field3628 = new class261("VERDANA13", "verdana_13pt_regular");
      field3629 = new class261("VERDANA15", "verdana_15pt_regular");
   }
}
