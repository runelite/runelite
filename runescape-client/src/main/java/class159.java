import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fs")
public class class159 implements class158 {
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lie;"
   )
   @Export("NpcDefinition_modelIndexCache")
   static IndexDataBase NpcDefinition_modelIndexCache;
   @ObfuscatedName("gb")
   @ObfuscatedGetter(
      intValue = 1554226597
   )
   @Export("cameraZ")
   static int cameraZ;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)Lej;",
      garbageValue = "-11984480"
   )
   @Export("getFrames")
   static Frames getFrames(int var0) {
      Frames var1 = (Frames)Sequence.skeletons.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         IndexDataBase var3 = Sequence.skel_ref;
         IndexDataBase var4 = Sequence.skin_ref;
         boolean var5 = true;
         int[] var6 = var3.getChilds(var0);

         for(int var7 = 0; var7 < var6.length; ++var7) {
            byte[] var8 = var3.getChild(var0, var6[var7]);
            if(var8 == null) {
               var5 = false;
            } else {
               int var9 = (var8[0] & 255) << 8 | var8[1] & 255;
               byte[] var10 = var4.getChild(var9, 0);
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
            Sequence.skeletons.put(var2, (long)var0);
         }

         return var2;
      }
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(ILca;ZI)I",
      garbageValue = "-703473064"
   )
   static int method3171(int var0, Script var1, boolean var2) {
      String var3;
      int var4;
      if(var0 == 4100) {
         var3 = class80.scriptStringStack[--class43.scriptStringStackSize];
         var4 = class80.intStack[--class80.intStackSize];
         class80.scriptStringStack[++class43.scriptStringStackSize - 1] = var3 + var4;
         return 1;
      } else {
         String var38;
         if(var0 == 4101) {
            class43.scriptStringStackSize -= 2;
            var3 = class80.scriptStringStack[class43.scriptStringStackSize];
            var38 = class80.scriptStringStack[class43.scriptStringStackSize + 1];
            class80.scriptStringStack[++class43.scriptStringStackSize - 1] = var3 + var38;
            return 1;
         } else if(var0 == 4102) {
            var3 = class80.scriptStringStack[--class43.scriptStringStackSize];
            var4 = class80.intStack[--class80.intStackSize];
            class80.scriptStringStack[++class43.scriptStringStackSize - 1] = var3 + AbstractByteBuffer.method3809(var4, true);
            return 1;
         } else if(var0 == 4103) {
            var3 = class80.scriptStringStack[--class43.scriptStringStackSize];
            class80.scriptStringStack[++class43.scriptStringStackSize - 1] = var3.toLowerCase();
            return 1;
         } else {
            int var22;
            int var30;
            if(var0 == 4104) {
               var22 = class80.intStack[--class80.intStackSize];
               long var23 = (11745L + (long)var22) * 86400000L;
               class80.field1229.setTime(new Date(var23));
               var30 = class80.field1229.get(5);
               int var31 = class80.field1229.get(2);
               int var8 = class80.field1229.get(1);
               class80.scriptStringStack[++class43.scriptStringStackSize - 1] = var30 + "-" + class80.field1223[var31] + "-" + var8;
               return 1;
            } else if(var0 == 4105) {
               class43.scriptStringStackSize -= 2;
               var3 = class80.scriptStringStack[class43.scriptStringStackSize];
               var38 = class80.scriptStringStack[class43.scriptStringStackSize + 1];
               if(OwnWorldComparator.localPlayer.composition != null && OwnWorldComparator.localPlayer.composition.isFemale) {
                  class80.scriptStringStack[++class43.scriptStringStackSize - 1] = var38;
               } else {
                  class80.scriptStringStack[++class43.scriptStringStackSize - 1] = var3;
               }

               return 1;
            } else if(var0 == 4106) {
               var22 = class80.intStack[--class80.intStackSize];
               class80.scriptStringStack[++class43.scriptStringStackSize - 1] = Integer.toString(var22);
               return 1;
            } else if(var0 == 4107) {
               class43.scriptStringStackSize -= 2;
               int[] var29 = class80.intStack;
               var4 = ++class80.intStackSize - 1;
               String var40 = class80.scriptStringStack[class43.scriptStringStackSize];
               String var26 = class80.scriptStringStack[class43.scriptStringStackSize + 1];
               int var9 = Client.languageId;
               int var10 = var40.length();
               int var11 = var26.length();
               int var12 = 0;
               int var13 = 0;
               char var14 = 0;
               char var15 = 0;

               label257:
               while(true) {
                  if(var12 - var14 >= var10 && var13 - var15 >= var11) {
                     int var35 = Math.min(var10, var11);

                     char var19;
                     int var36;
                     for(var36 = 0; var36 < var35; ++var36) {
                        char var18 = var40.charAt(var36);
                        var19 = var26.charAt(var36);
                        if(var18 != var19 && Character.toUpperCase(var18) != Character.toUpperCase(var19)) {
                           var18 = Character.toLowerCase(var18);
                           var19 = Character.toLowerCase(var19);
                           if(var19 != var18) {
                              var30 = class168.method3281(var18, var9) - class168.method3281(var19, var9);
                              break label257;
                           }
                        }
                     }

                     var36 = var10 - var11;
                     if(var36 != 0) {
                        var30 = var36;
                     } else {
                        for(int var37 = 0; var37 < var35; ++var37) {
                           var19 = var40.charAt(var37);
                           char var20 = var26.charAt(var37);
                           if(var19 != var20) {
                              var30 = class168.method3281(var19, var9) - class168.method3281(var20, var9);
                              break label257;
                           }
                        }

                        var30 = 0;
                     }
                     break;
                  }

                  if(var12 - var14 >= var10) {
                     var30 = -1;
                     break;
                  }

                  if(var13 - var15 >= var11) {
                     var30 = 1;
                     break;
                  }

                  char var16;
                  if(var14 != 0) {
                     var16 = var14;
                     boolean var33 = false;
                  } else {
                     var16 = var40.charAt(var12++);
                  }

                  char var17;
                  if(var15 != 0) {
                     var17 = var15;
                     boolean var34 = false;
                  } else {
                     var17 = var26.charAt(var13++);
                  }

                  var14 = class34.method509(var16);
                  var15 = class34.method509(var17);
                  var16 = BoundingBox3DDrawMode.method50(var16, var9);
                  var17 = BoundingBox3DDrawMode.method50(var17, var9);
                  if(var17 != var16 && Character.toUpperCase(var16) != Character.toUpperCase(var17)) {
                     var16 = Character.toLowerCase(var16);
                     var17 = Character.toLowerCase(var17);
                     if(var16 != var17) {
                        var30 = class168.method3281(var16, var9) - class168.method3281(var17, var9);
                        break;
                     }
                  }
               }

               byte var32;
               if(var30 > 0) {
                  var32 = 1;
               } else if(var30 < 0) {
                  var32 = -1;
               } else {
                  var32 = 0;
               }

               var29[var4] = var32;
               return 1;
            } else {
               int var5;
               Font var25;
               byte[] var27;
               if(var0 == 4108) {
                  var3 = class80.scriptStringStack[--class43.scriptStringStackSize];
                  class80.intStackSize -= 2;
                  var4 = class80.intStack[class80.intStackSize];
                  var5 = class80.intStack[class80.intStackSize + 1];
                  var27 = class2.indexCache13.getConfigData(var5, 0);
                  var25 = new Font(var27);
                  class80.intStack[++class80.intStackSize - 1] = var25.method5449(var3, var4);
                  return 1;
               } else if(var0 == 4109) {
                  var3 = class80.scriptStringStack[--class43.scriptStringStackSize];
                  class80.intStackSize -= 2;
                  var4 = class80.intStack[class80.intStackSize];
                  var5 = class80.intStack[class80.intStackSize + 1];
                  var27 = class2.indexCache13.getConfigData(var5, 0);
                  var25 = new Font(var27);
                  class80.intStack[++class80.intStackSize - 1] = var25.method5510(var3, var4);
                  return 1;
               } else if(var0 == 4110) {
                  class43.scriptStringStackSize -= 2;
                  var3 = class80.scriptStringStack[class43.scriptStringStackSize];
                  var38 = class80.scriptStringStack[class43.scriptStringStackSize + 1];
                  if(class80.intStack[--class80.intStackSize] == 1) {
                     class80.scriptStringStack[++class43.scriptStringStackSize - 1] = var3;
                  } else {
                     class80.scriptStringStack[++class43.scriptStringStackSize - 1] = var38;
                  }

                  return 1;
               } else if(var0 == 4111) {
                  var3 = class80.scriptStringStack[--class43.scriptStringStackSize];
                  class80.scriptStringStack[++class43.scriptStringStackSize - 1] = FontTypeFace.appendTags(var3);
                  return 1;
               } else if(var0 == 4112) {
                  var3 = class80.scriptStringStack[--class43.scriptStringStackSize];
                  var4 = class80.intStack[--class80.intStackSize];
                  class80.scriptStringStack[++class43.scriptStringStackSize - 1] = var3 + (char)var4;
                  return 1;
               } else if(var0 == 4113) {
                  var22 = class80.intStack[--class80.intStackSize];
                  class80.intStack[++class80.intStackSize - 1] = class264.method4775((char)var22)?1:0;
                  return 1;
               } else if(var0 == 4114) {
                  var22 = class80.intStack[--class80.intStackSize];
                  class80.intStack[++class80.intStackSize - 1] = class269.method4849((char)var22)?1:0;
                  return 1;
               } else {
                  char var7;
                  if(var0 != 4115) {
                     if(var0 == 4116) {
                        var22 = class80.intStack[--class80.intStackSize];
                        class80.intStack[++class80.intStackSize - 1] = WidgetNode.method1125((char)var22)?1:0;
                        return 1;
                     } else if(var0 == 4117) {
                        var3 = class80.scriptStringStack[--class43.scriptStringStackSize];
                        if(var3 != null) {
                           class80.intStack[++class80.intStackSize - 1] = var3.length();
                        } else {
                           class80.intStack[++class80.intStackSize - 1] = 0;
                        }

                        return 1;
                     } else if(var0 == 4118) {
                        var3 = class80.scriptStringStack[--class43.scriptStringStackSize];
                        class80.intStackSize -= 2;
                        var4 = class80.intStack[class80.intStackSize];
                        var5 = class80.intStack[class80.intStackSize + 1];
                        class80.scriptStringStack[++class43.scriptStringStackSize - 1] = var3.substring(var4, var5);
                        return 1;
                     } else if(var0 == 4119) {
                        var3 = class80.scriptStringStack[--class43.scriptStringStackSize];
                        StringBuilder var39 = new StringBuilder(var3.length());
                        boolean var28 = false;

                        for(var30 = 0; var30 < var3.length(); ++var30) {
                           var7 = var3.charAt(var30);
                           if(var7 == '<') {
                              var28 = true;
                           } else if(var7 == '>') {
                              var28 = false;
                           } else if(!var28) {
                              var39.append(var7);
                           }
                        }

                        class80.scriptStringStack[++class43.scriptStringStackSize - 1] = var39.toString();
                        return 1;
                     } else if(var0 == 4120) {
                        var3 = class80.scriptStringStack[--class43.scriptStringStackSize];
                        var4 = class80.intStack[--class80.intStackSize];
                        class80.intStack[++class80.intStackSize - 1] = var3.indexOf(var4);
                        return 1;
                     } else if(var0 == 4121) {
                        class43.scriptStringStackSize -= 2;
                        var3 = class80.scriptStringStack[class43.scriptStringStackSize];
                        var38 = class80.scriptStringStack[class43.scriptStringStackSize + 1];
                        var5 = class80.intStack[--class80.intStackSize];
                        class80.intStack[++class80.intStackSize - 1] = var3.indexOf(var38, var5);
                        return 1;
                     } else {
                        return 2;
                     }
                  } else {
                     var22 = class80.intStack[--class80.intStackSize];
                     int[] var21 = class80.intStack;
                     var5 = ++class80.intStackSize - 1;
                     var7 = (char)var22;
                     boolean var6 = var7 >= 'A' && var7 <= 'Z' || var7 >= 'a' && var7 <= 'z';
                     var21[var5] = var6?1:0;
                     return 1;
                  }
               }
            }
         }
      }
   }
}
