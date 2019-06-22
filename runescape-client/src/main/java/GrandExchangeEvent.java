import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("l")
@Implements("GrandExchangeEvent")
public class GrandExchangeEvent {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -633089807
   )
   @Export("world")
   public final int world;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      longValue = -6503890758391257651L
   )
   @Export("__f")
   public final long __f;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lx;"
   )
   @Export("grandExchangeOffer")
   public final GrandExchangeOffer grandExchangeOffer;
   @ObfuscatedName("w")
   @Export("string1")
   String string1;
   @ObfuscatedName("o")
   @Export("string2")
   String string2;

   @ObfuscatedSignature(
      signature = "(Lgr;BI)V"
   )
   GrandExchangeEvent(Buffer var1, byte var2, int var3) {
      this.string1 = var1.readStringCp1252NullTerminated();
      this.string2 = var1.readStringCp1252NullTerminated();
      this.world = var1.__ag_302();
      this.__f = var1.readLong();
      int var4 = var1.readInt();
      int var5 = var1.readInt();
      this.grandExchangeOffer = new GrandExchangeOffer();
      this.grandExchangeOffer.__o_9(2);
      this.grandExchangeOffer.__u_10(var2);
      this.grandExchangeOffer.unitPrice = var4;
      this.grandExchangeOffer.totalQuantity = var5;
      this.grandExchangeOffer.currentQuantity = 0;
      this.grandExchangeOffer.currentPrice = 0;
      this.grandExchangeOffer.id = var3;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "1672323214"
   )
   @Export("__m_3")
   public String __m_3() {
      return this.string1;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-271438207"
   )
   @Export("__f_4")
   public String __f_4() {
      return this.string2;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lby;II)V",
      garbageValue = "-1003049523"
   )
   @Export("runScript0")
   static void runScript0(ScriptEvent var0, int var1) {
      Object[] var2 = var0.args0;
      Script var3;
      int var17;
      if(class12.method162(var0.type0)) {
         class15.worldMapEvent = (WorldMapEvent)var2[0];
         WorldMapElement var4 = ViewportMouse.getWorldMapElement(class15.worldMapEvent.mapElement);
         var3 = FaceNormal.method3236(var0.type0, var4.__o, var4.category);
      } else {
         var17 = ((Integer)var2[0]).intValue();
         var3 = SoundSystem.method2451(var17);
      }

      if(var3 != null) {
         class179.Interpreter_intStackSize = 0;
         Interpreter.Interpreter_stringStackSize = 0;
         var17 = -1;
         int[] var5 = var3.opcodes;
         int[] var6 = var3.intOperands;
         byte var7 = -1;
         Interpreter.Interpreter_frameDepth = 0;
         Interpreter.__bv_s = false;

         try {
            int var10;
            try {
               Username.Interpreter_intLocals = new int[var3.localIntCount];
               int var8 = 0;
               Interpreter.Interpreter_stringLocals = new String[var3.localStringCount];
               int var9 = 0;

               int var11;
               String var18;
               for(var10 = 1; var10 < var2.length; ++var10) {
                  if(var2[var10] instanceof Integer) {
                     var11 = ((Integer)var2[var10]).intValue();
                     if(var11 == -2147483647) {
                        var11 = var0.mouseX;
                     }

                     if(var11 == -2147483646) {
                        var11 = var0.mouseY;
                     }

                     if(var11 == -2147483645) {
                        var11 = var0.widget != null?var0.widget.id:-1;
                     }

                     if(var11 == -2147483644) {
                        var11 = var0.opIndex;
                     }

                     if(var11 == -2147483643) {
                        var11 = var0.widget != null?var0.widget.childIndex:-1;
                     }

                     if(var11 == -2147483642) {
                        var11 = var0.dragTarget != null?var0.dragTarget.id:-1;
                     }

                     if(var11 == -2147483641) {
                        var11 = var0.dragTarget != null?var0.dragTarget.childIndex:-1;
                     }

                     if(var11 == -2147483640) {
                        var11 = var0.keyTyped;
                     }

                     if(var11 == -2147483639) {
                        var11 = var0.keyPressed;
                     }

                     Username.Interpreter_intLocals[var8++] = var11;
                  } else if(var2[var10] instanceof String) {
                     var18 = (String)var2[var10];
                     if(var18.equals("event_opbase")) {
                        var18 = var0.targetName;
                     }

                     Interpreter.Interpreter_stringLocals[var9++] = var18;
                  }
               }

               var10 = 0;
               Interpreter.__bv_y = var0.__d;

               while(true) {
                  ++var10;
                  if(var10 > var1) {
                     throw new RuntimeException();
                  }

                  ++var17;
                  int var29 = var5[var17];
                  int var20;
                  if(var29 >= 100) {
                     boolean var32;
                     if(var3.intOperands[var17] == 1) {
                        var32 = true;
                     } else {
                        var32 = false;
                     }

                     var20 = class196.method3736(var29, var3, var32);
                     switch(var20) {
                     case 0:
                        return;
                     case 1:
                     default:
                        break;
                     case 2:
                        throw new IllegalStateException();
                     }
                  } else if(var29 == 0) {
                     Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var6[var17];
                  } else if(var29 == 1) {
                     var11 = var6[var17];
                     Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = Varps.Varps_main[var11];
                  } else if(var29 == 2) {
                     var11 = var6[var17];
                     Varps.Varps_main[var11] = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
                     IndexCache.method4703(var11);
                  } else if(var29 == 3) {
                     Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3.stringOperands[var17];
                  } else if(var29 == 6) {
                     var17 += var6[var17];
                  } else if(var29 == 7) {
                     class179.Interpreter_intStackSize -= 2;
                     if(Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize] != Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1]) {
                        var17 += var6[var17];
                     }
                  } else if(var29 == 8) {
                     class179.Interpreter_intStackSize -= 2;
                     if(Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize] == Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1]) {
                        var17 += var6[var17];
                     }
                  } else if(var29 == 9) {
                     class179.Interpreter_intStackSize -= 2;
                     if(Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize] < Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1]) {
                        var17 += var6[var17];
                     }
                  } else if(var29 == 10) {
                     class179.Interpreter_intStackSize -= 2;
                     if(Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize] > Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1]) {
                        var17 += var6[var17];
                     }
                  } else if(var29 == 21) {
                     if(Interpreter.Interpreter_frameDepth == 0) {
                        return;
                     }

                     ScriptFrame var34 = Interpreter.Interpreter_frames[--Interpreter.Interpreter_frameDepth];
                     var3 = var34.script;
                     var5 = var3.opcodes;
                     var6 = var3.intOperands;
                     var17 = var34.pc;
                     Username.Interpreter_intLocals = var34.intLocals;
                     Interpreter.Interpreter_stringLocals = var34.stringLocals;
                  } else if(var29 == 25) {
                     var11 = var6[var17];
                     Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = WorldMapSection2.getVarbit(var11);
                  } else if(var29 == 27) {
                     var11 = var6[var17];
                     class68.method1695(var11, Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize]);
                  } else if(var29 == 31) {
                     class179.Interpreter_intStackSize -= 2;
                     if(Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize] <= Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1]) {
                        var17 += var6[var17];
                     }
                  } else if(var29 == 32) {
                     class179.Interpreter_intStackSize -= 2;
                     if(Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize] >= Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1]) {
                        var17 += var6[var17];
                     }
                  } else if(var29 == 33) {
                     Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = Username.Interpreter_intLocals[var6[var17]];
                  } else if(var29 == 34) {
                     Username.Interpreter_intLocals[var6[var17]] = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
                  } else if(var29 == 35) {
                     Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = Interpreter.Interpreter_stringLocals[var6[var17]];
                  } else if(var29 == 36) {
                     Interpreter.Interpreter_stringLocals[var6[var17]] = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
                  } else if(var29 == 37) {
                     var11 = var6[var17];
                     Interpreter.Interpreter_stringStackSize -= var11;
                     String var31 = class277.method5356(Interpreter.Interpreter_stringStack, Interpreter.Interpreter_stringStackSize, var11);
                     Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var31;
                  } else if(var29 == 38) {
                     --class179.Interpreter_intStackSize;
                  } else if(var29 == 39) {
                     --Interpreter.Interpreter_stringStackSize;
                  } else {
                     int var15;
                     if(var29 != 40) {
                        if(var29 == 42) {
                           Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = class196.varcs.getInt(var6[var17]);
                        } else if(var29 == 43) {
                           class196.varcs.setInt(var6[var17], Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize]);
                        } else if(var29 == 44) {
                           var11 = var6[var17] >> 16;
                           var20 = var6[var17] & 65535;
                           int var21 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
                           if(var21 < 0 || var21 > 5000) {
                              throw new RuntimeException();
                           }

                           Interpreter.Interpreter_arrayLengths[var11] = var21;
                           byte var22 = -1;
                           if(var20 == 105) {
                              var22 = 0;
                           }

                           for(var15 = 0; var15 < var21; ++var15) {
                              Interpreter.Interpreter_arrays[var11][var15] = var22;
                           }
                        } else if(var29 == 45) {
                           var11 = var6[var17];
                           var20 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
                           if(var20 < 0 || var20 >= Interpreter.Interpreter_arrayLengths[var11]) {
                              throw new RuntimeException();
                           }

                           Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = Interpreter.Interpreter_arrays[var11][var20];
                        } else if(var29 == 46) {
                           var11 = var6[var17];
                           class179.Interpreter_intStackSize -= 2;
                           var20 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize];
                           if(var20 < 0 || var20 >= Interpreter.Interpreter_arrayLengths[var11]) {
                              throw new RuntimeException();
                           }

                           Interpreter.Interpreter_arrays[var11][var20] = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1];
                        } else if(var29 == 47) {
                           var18 = class196.varcs.getStringOld(var6[var17]);
                           if(var18 == null) {
                              var18 = "null";
                           }

                           Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var18;
                        } else if(var29 == 48) {
                           class196.varcs.setStringOld(var6[var17], Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize]);
                        } else if(var29 == 49) {
                           var18 = class196.varcs.getString(var6[var17]);
                           Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var18;
                        } else if(var29 == 50) {
                           class196.varcs.setString(var6[var17], Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize]);
                        } else {
                           if(var29 != 60) {
                              throw new IllegalStateException();
                           }

                           IterableNodeHashTable var33 = var3.switches[var6[var17]];
                           IntegerNode var30 = (IntegerNode)var33.get((long)Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize]);
                           if(var30 != null) {
                              var17 += var30.integer;
                           }
                        }
                     } else {
                        var11 = var6[var17];
                        Script var12 = SoundSystem.method2451(var11);
                        int[] var13 = new int[var12.localIntCount];
                        String[] var14 = new String[var12.localStringCount];

                        for(var15 = 0; var15 < var12.intArgumentCount; ++var15) {
                           var13[var15] = Interpreter.Interpreter_intStack[var15 + (class179.Interpreter_intStackSize - var12.intArgumentCount)];
                        }

                        for(var15 = 0; var15 < var12.stringArgumentCount; ++var15) {
                           var14[var15] = Interpreter.Interpreter_stringStack[var15 + (Interpreter.Interpreter_stringStackSize - var12.stringArgumentCount)];
                        }

                        class179.Interpreter_intStackSize -= var12.intArgumentCount;
                        Interpreter.Interpreter_stringStackSize -= var12.stringArgumentCount;
                        ScriptFrame var19 = new ScriptFrame();
                        var19.script = var3;
                        var19.pc = var17;
                        var19.intLocals = Username.Interpreter_intLocals;
                        var19.stringLocals = Interpreter.Interpreter_stringLocals;
                        Interpreter.Interpreter_frames[++Interpreter.Interpreter_frameDepth - 1] = var19;
                        var3 = var12;
                        var5 = var12.opcodes;
                        var6 = var12.intOperands;
                        var17 = -1;
                        Username.Interpreter_intLocals = var13;
                        Interpreter.Interpreter_stringLocals = var14;
                     }
                  }
               }
            } catch (Exception var27) {
               StringBuilder var24 = new StringBuilder(30);
               var24.append("").append(var3.key).append(" ");

               for(var10 = Interpreter.Interpreter_frameDepth - 1; var10 >= 0; --var10) {
                  var24.append("").append(Interpreter.Interpreter_frames[var10].script.key).append(" ");
               }

               var24.append("").append(var7);
               NpcDefinition.sendStackTrace(var24.toString(), var27);
            }
         } finally {
            if(Interpreter.__bv_s) {
               Interpreter.__bv_t = true;
               WorldMapLabelSize.method198();
               Interpreter.__bv_t = false;
               Interpreter.__bv_s = false;
            }

         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IS)I",
      garbageValue = "1404"
   )
   public static int method80(int var0) {
      long var2 = ViewportMouse.ViewportMouse_entityTags[var0];
      int var1 = (int)(var2 >>> 14 & 3L);
      return var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1385318222"
   )
   public static int method87(int var0, int var1) {
      int var2;
      for(var2 = 0; var1 > 0; --var1) {
         var2 = var2 << 1 | var0 & 1;
         var0 >>>= 1;
      }

      return var2;
   }

   @ObfuscatedName("iq")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "1819478902"
   )
   static final String method88(int var0) {
      String var1 = Integer.toString(var0);

      for(int var2 = var1.length() - 3; var2 > 0; var2 -= 3) {
         var1 = var1.substring(0, var2) + "," + var1.substring(var2);
      }

      return var1.length() > 9?" " + BufferedFile.colorStartTag(65408) + var1.substring(0, var1.length() - 8) + "M" + " " + " (" + var1 + ")" + "</col>":(var1.length() > 6?" " + BufferedFile.colorStartTag(16777215) + var1.substring(0, var1.length() - 4) + "K" + " " + " (" + var1 + ")" + "</col>":" " + BufferedFile.colorStartTag(16776960) + var1 + "</col>");
   }
}
