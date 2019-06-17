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
      int var4;
      if(class12.method162(var0.type0)) {
         class15.worldMapEvent = (WorldMapEvent)var2[0];
         WorldMapElement var5 = ViewportMouse.getWorldMapElement(class15.worldMapEvent.mapElement);
         var3 = FaceNormal.method3236(var0.type0, var5.__o, var5.category);
      } else {
         var4 = ((Integer)var2[0]).intValue();
         var3 = SoundSystem.method2451(var4);
      }

      if(var3 != null) {
         class179.Interpreter_intStackSize = 0;
         Interpreter.Interpreter_stringStackSize = 0;
         var4 = -1;
         int[] var25 = var3.opcodes;
         int[] var6 = var3.intOperands;
         byte var7 = -1;
         Interpreter.Interpreter_frameDepth = 0;
         Interpreter.__bv_s = false;

         try {
            int var8;
            try {
               Username.Interpreter_intLocals = new int[var3.localIntCount];
               int var9 = 0;
               Interpreter.Interpreter_stringLocals = new String[var3.localStringCount];
               int var26 = 0;

               int var11;
               String var12;
               for(var8 = 1; var8 < var2.length; ++var8) {
                  if(var2[var8] instanceof Integer) {
                     var11 = ((Integer)var2[var8]).intValue();
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

                     Username.Interpreter_intLocals[var9++] = var11;
                  } else if(var2[var8] instanceof String) {
                     var12 = (String)var2[var8];
                     if(var12.equals("event_opbase")) {
                        var12 = var0.targetName;
                     }

                     Interpreter.Interpreter_stringLocals[var26++] = var12;
                  }
               }

               var8 = 0;
               Interpreter.__bv_y = var0.__d;

               while(true) {
                  ++var8;
                  if(var8 > var1) {
                     throw new RuntimeException();
                  }

                  ++var4;
                  int var13 = var25[var4];
                  int var14;
                  if(var13 >= 100) {
                     boolean var32;
                     if(var3.intOperands[var4] == 1) {
                        var32 = true;
                     } else {
                        var32 = false;
                     }

                     var14 = class196.method3736(var13, var3, var32);
                     switch(var14) {
                     case 0:
                        return;
                     case 1:
                     default:
                        break;
                     case 2:
                        throw new IllegalStateException();
                     }
                  } else if(var13 == 0) {
                     Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var6[var4];
                  } else if(var13 == 1) {
                     var11 = var6[var4];
                     Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = Varps.Varps_main[var11];
                  } else if(var13 == 2) {
                     var11 = var6[var4];
                     Varps.Varps_main[var11] = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
                     IndexCache.method4703(var11);
                  } else if(var13 == 3) {
                     Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3.stringOperands[var4];
                  } else if(var13 == 6) {
                     var4 += var6[var4];
                  } else if(var13 == 7) {
                     class179.Interpreter_intStackSize -= 2;
                     if(Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize] != Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1]) {
                        var4 += var6[var4];
                     }
                  } else if(var13 == 8) {
                     class179.Interpreter_intStackSize -= 2;
                     if(Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize] == Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1]) {
                        var4 += var6[var4];
                     }
                  } else if(var13 == 9) {
                     class179.Interpreter_intStackSize -= 2;
                     if(Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize] < Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1]) {
                        var4 += var6[var4];
                     }
                  } else if(var13 == 10) {
                     class179.Interpreter_intStackSize -= 2;
                     if(Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize] > Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1]) {
                        var4 += var6[var4];
                     }
                  } else if(var13 == 21) {
                     if(Interpreter.Interpreter_frameDepth == 0) {
                        return;
                     }

                     ScriptFrame var30 = Interpreter.Interpreter_frames[--Interpreter.Interpreter_frameDepth];
                     var3 = var30.script;
                     var25 = var3.opcodes;
                     var6 = var3.intOperands;
                     var4 = var30.pc;
                     Username.Interpreter_intLocals = var30.intLocals;
                     Interpreter.Interpreter_stringLocals = var30.stringLocals;
                  } else if(var13 == 25) {
                     var11 = var6[var4];
                     Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = WorldMapSection2.getVarbit(var11);
                  } else if(var13 == 27) {
                     var11 = var6[var4];
                     class68.method1695(var11, Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize]);
                  } else if(var13 == 31) {
                     class179.Interpreter_intStackSize -= 2;
                     if(Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize] <= Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1]) {
                        var4 += var6[var4];
                     }
                  } else if(var13 == 32) {
                     class179.Interpreter_intStackSize -= 2;
                     if(Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize] >= Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1]) {
                        var4 += var6[var4];
                     }
                  } else if(var13 == 33) {
                     Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = Username.Interpreter_intLocals[var6[var4]];
                  } else if(var13 == 34) {
                     Username.Interpreter_intLocals[var6[var4]] = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
                  } else if(var13 == 35) {
                     Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = Interpreter.Interpreter_stringLocals[var6[var4]];
                  } else if(var13 == 36) {
                     Interpreter.Interpreter_stringLocals[var6[var4]] = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
                  } else if(var13 == 37) {
                     var11 = var6[var4];
                     Interpreter.Interpreter_stringStackSize -= var11;
                     String var29 = class277.method5356(Interpreter.Interpreter_stringStack, Interpreter.Interpreter_stringStackSize, var11);
                     Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var29;
                  } else if(var13 == 38) {
                     --class179.Interpreter_intStackSize;
                  } else if(var13 == 39) {
                     --Interpreter.Interpreter_stringStackSize;
                  } else {
                     int var15;
                     if(var13 != 40) {
                        if(var13 == 42) {
                           Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = class196.varcs.getInt(var6[var4]);
                        } else if(var13 == 43) {
                           class196.varcs.setInt(var6[var4], Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize]);
                        } else if(var13 == 44) {
                           var11 = var6[var4] >> 16;
                           var14 = var6[var4] & 65535;
                           int var28 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
                           if(var28 < 0 || var28 > 5000) {
                              throw new RuntimeException();
                           }

                           Interpreter.Interpreter_arrayLengths[var11] = var28;
                           byte var33 = -1;
                           if(var14 == 105) {
                              var33 = 0;
                           }

                           for(var15 = 0; var15 < var28; ++var15) {
                              Interpreter.Interpreter_arrays[var11][var15] = var33;
                           }
                        } else if(var13 == 45) {
                           var11 = var6[var4];
                           var14 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
                           if(var14 < 0 || var14 >= Interpreter.Interpreter_arrayLengths[var11]) {
                              throw new RuntimeException();
                           }

                           Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = Interpreter.Interpreter_arrays[var11][var14];
                        } else if(var13 == 46) {
                           var11 = var6[var4];
                           class179.Interpreter_intStackSize -= 2;
                           var14 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize];
                           if(var14 < 0 || var14 >= Interpreter.Interpreter_arrayLengths[var11]) {
                              throw new RuntimeException();
                           }

                           Interpreter.Interpreter_arrays[var11][var14] = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1];
                        } else if(var13 == 47) {
                           var12 = class196.varcs.getStringOld(var6[var4]);
                           if(var12 == null) {
                              var12 = "null";
                           }

                           Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var12;
                        } else if(var13 == 48) {
                           class196.varcs.setStringOld(var6[var4], Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize]);
                        } else if(var13 == 49) {
                           var12 = class196.varcs.getString(var6[var4]);
                           Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var12;
                        } else if(var13 == 50) {
                           class196.varcs.setString(var6[var4], Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize]);
                        } else {
                           if(var13 != 60) {
                              throw new IllegalStateException();
                           }

                           IterableNodeHashTable var27 = var3.switches[var6[var4]];
                           IntegerNode var31 = (IntegerNode)var27.get((long)Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize]);
                           if(var31 != null) {
                              var4 += var31.integer;
                           }
                        }
                     } else {
                        var11 = var6[var4];
                        Script var16 = SoundSystem.method2451(var11);
                        int[] var17 = new int[var16.localIntCount];
                        String[] var18 = new String[var16.localStringCount];

                        for(var15 = 0; var15 < var16.intArgumentCount; ++var15) {
                           var17[var15] = Interpreter.Interpreter_intStack[var15 + (class179.Interpreter_intStackSize - var16.intArgumentCount)];
                        }

                        for(var15 = 0; var15 < var16.stringArgumentCount; ++var15) {
                           var18[var15] = Interpreter.Interpreter_stringStack[var15 + (Interpreter.Interpreter_stringStackSize - var16.stringArgumentCount)];
                        }

                        class179.Interpreter_intStackSize -= var16.intArgumentCount;
                        Interpreter.Interpreter_stringStackSize -= var16.stringArgumentCount;
                        ScriptFrame var19 = new ScriptFrame();
                        var19.script = var3;
                        var19.pc = var4;
                        var19.intLocals = Username.Interpreter_intLocals;
                        var19.stringLocals = Interpreter.Interpreter_stringLocals;
                        Interpreter.Interpreter_frames[++Interpreter.Interpreter_frameDepth - 1] = var19;
                        var3 = var16;
                        var25 = var16.opcodes;
                        var6 = var16.intOperands;
                        var4 = -1;
                        Username.Interpreter_intLocals = var17;
                        Interpreter.Interpreter_stringLocals = var18;
                     }
                  }
               }
            } catch (Exception var23) {
               StringBuilder var10 = new StringBuilder(30);
               var10.append("").append(var3.key).append(" ");

               for(var8 = Interpreter.Interpreter_frameDepth - 1; var8 >= 0; --var8) {
                  var10.append("").append(Interpreter.Interpreter_frames[var8].script.key).append(" ");
               }

               var10.append("").append(var7);
               NPCDefinition.sendStackTrace(var10.toString(), var23);
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
      long var1 = ViewportMouse.ViewportMouse_entityTags[var0];
      int var3 = (int)(var1 >>> 14 & 3L);
      return var3;
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

      return var1.length() > 9?" " + BufferedFile.colorStartTag(65408) + var1.substring(0, var1.length() - 8) + "M  (" + var1 + ")</col>":(var1.length() > 6?" " + BufferedFile.colorStartTag(16777215) + var1.substring(0, var1.length() - 4) + "K  (" + var1 + ")</col>":" " + BufferedFile.colorStartTag(16776960) + var1 + "</col>");
   }
}
